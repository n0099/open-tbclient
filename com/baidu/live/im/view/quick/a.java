package com.baidu.live.im.view.quick;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bj;
import com.baidu.live.gift.t;
import com.baidu.live.im.m;
import com.baidu.live.im.view.barrage.ImBarrageItemView;
import com.baidu.live.im.view.barrage.ImBarrageOptionListView;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.u.a;
import com.baidu.live.view.Switch;
/* loaded from: classes3.dex */
public class a extends Dialog {
    private ImBarrageItemView aUg;
    private ImBarrageOptionListView aUi;
    private Switch aUj;
    private InterfaceC0166a aVI;
    private View aVJ;
    private FlexLayout aVK;
    private b aVL;
    private View mContentView;

    /* renamed from: com.baidu.live.im.view.quick.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0166a {
        boolean CC();

        int CH();

        boolean DA();

        void Dz();

        void b(int i, String str, bj bjVar);

        void onDismiss();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_TransparentDialog);
        init();
    }

    public void a(InterfaceC0166a interfaceC0166a) {
        this.aVI = interfaceC0166a;
    }

    public void l(String[] strArr) {
        m(strArr);
        Em();
        zB();
        show();
        if (this.mContentView != null) {
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.aVK != null && (layoutParams = a.this.aVK.getLayoutParams()) != null) {
                        layoutParams.height = a.this.aVK.realHeight;
                        a.this.aVK.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void cs(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.aVK != null && (layoutParams = this.aVK.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.aVK.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.aUg.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (a.this.aVK != null && (layoutParams2 = a.this.aVK.getLayoutParams()) != null) {
                                layoutParams2.height = a.this.aVK.realHeight;
                                a.this.aVK.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.aUj != null && this.aUj.isChecked()) {
                this.aUg.setVisibility(0);
            }
        }
    }

    public void EE() {
        if (this.aUi != null) {
            this.aUi.g(t.yl().yn());
        }
    }

    private void init() {
        EF();
        initView();
        xT();
    }

    private void EF() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(81);
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.mContentView = LayoutInflater.from(getContext()).inflate(a.h.ala_im_quick_input_list, (ViewGroup) null);
        setContentView(this.mContentView);
        this.aUg = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aVJ = findViewById(a.g.layout_barrage);
        this.aUj = (Switch) findViewById(a.g.switch_barrage);
        this.aUi = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aVK = (FlexLayout) findViewById(a.g.flex);
        this.aUj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.quick.a.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bK(z);
            }
        });
        this.aUi.setSelectEnabled(false);
        this.aUi.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.quick.a.4
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean DA() {
                return a.this.aVI != null && a.this.aVI.DA();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bV(int i) {
                a.this.bL(false);
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public int CH() {
                if (a.this.aVI != null) {
                    return a.this.aVI.CH();
                }
                return 0;
            }
        });
        this.aVK.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.aVK.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.aVK.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.im.view.quick.a.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                bj bjVar;
                if (a.this.aVI != null) {
                    if (a.this.aVJ.getVisibility() == 0 && a.this.aUj.isChecked()) {
                        bj selectInfo = a.this.aUi.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.aVI == null || !a.this.aVI.DA())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aCc > a.this.aVI.CH()) {
                            if (selectInfo.aCc == 7) {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            bjVar = selectInfo;
                        }
                    } else {
                        bjVar = null;
                    }
                    a.this.aVI.b(i, a.this.aVL.getItem(i), bjVar);
                }
            }
        });
    }

    private void xT() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.im.view.quick.a.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.aVI != null) {
                    a.this.aVI.Dz();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.im.view.quick.a.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.aUg != null) {
                    a.this.aUg.release();
                }
                if (a.this.aVI != null) {
                    a.this.aVI.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (z && this.aVI != null && !this.aVI.CC()) {
            this.aUj.setChecked(false, false);
        } else if (z) {
            this.aUi.setSwitchStatus(true);
            if (!TextUtils.isEmpty(m.CL().CO())) {
                this.aUi.setSelectId(m.CL().CO());
            } else {
                this.aUi.setSelectPos(0);
            }
            this.aUi.setSelectEnabled(true);
            bL(true);
        } else {
            this.aUi.setSwitchStatus(false);
            this.aUi.setSelectEnabled(false);
            this.aUg.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (z) {
            this.aUg.setPreview();
        }
        this.aUg.setUIInfo(this.aUi.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aUg.setVisibility(4);
        } else if (this.aUj != null && this.aUj.isChecked()) {
            this.aUg.setVisibility(0);
        }
    }

    private void Em() {
        final bj[] e = m.CL().e(this.aVI != null && this.aVI.DA(), this.aVI != null ? this.aVI.CH() : 0);
        if (e == null) {
            if (this.aUj.isChecked()) {
                this.aUj.setChecked(false, false);
            } else {
                bK(false);
            }
            this.aVJ.setVisibility(8);
            return;
        }
        this.aVJ.setVisibility(0);
        this.aUi.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.aUi.setData(e, t.yl().yn(), 1);
                if (m.CL().CN()) {
                    if (a.this.aUj.isChecked()) {
                        a.this.aUi.setSelectId(m.CL().CO());
                        a.this.bL(true);
                        return;
                    }
                    a.this.aUj.setChecked(true, false);
                } else if (a.this.aUj.isChecked()) {
                    a.this.aUj.setChecked(false, false);
                }
            }
        });
    }

    private void m(String[] strArr) {
        if (this.aVL == null) {
            this.aVL = new b(strArr);
            this.aVK.setAdapter(this.aVL);
            return;
        }
        this.aVL.setDatas(strArr);
        this.aVL.notifyDataSetChanged();
    }

    private void zB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends FlexAdapter<String> {
        b(String[] strArr) {
            super(strArr);
        }

        @Override // com.baidu.live.tbadk.widget.flex.FlexAdapter
        public View getView(int i, ViewGroup viewGroup) {
            QuickInputFlexTextView quickInputFlexTextView = new QuickInputFlexTextView(viewGroup.getContext());
            quickInputFlexTextView.setText(getItem(i));
            return quickInputFlexTextView;
        }
    }
}
