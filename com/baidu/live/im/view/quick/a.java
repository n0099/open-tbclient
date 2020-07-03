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
import com.baidu.live.data.bo;
import com.baidu.live.gift.t;
import com.baidu.live.im.m;
import com.baidu.live.im.view.barrage.ImBarrageItemView;
import com.baidu.live.im.view.barrage.ImBarrageOptionListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.view.Switch;
/* loaded from: classes3.dex */
public class a extends Dialog {
    private ImBarrageItemView aWN;
    private ImBarrageOptionListView aWP;
    private Switch aWQ;
    private InterfaceC0168a aYp;
    private View aYq;
    private FlexLayout aYr;
    private b aYs;
    private View mContentView;

    /* renamed from: com.baidu.live.im.view.quick.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0168a {
        boolean Dd();

        int Di();

        void Eb();

        boolean Ec();

        void b(int i, String str, bo boVar);

        void onDismiss();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_TransparentDialog);
        init();
    }

    public void a(InterfaceC0168a interfaceC0168a) {
        this.aYp = interfaceC0168a;
    }

    public void a(String[] strArr, boolean z) {
        l(strArr);
        bN(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.aYr != null && (layoutParams = a.this.aYr.getLayoutParams()) != null) {
                        layoutParams.height = a.this.aYr.realHeight;
                        a.this.aYr.setLayoutParams(layoutParams);
                    }
                    a.this.Ab();
                }
            });
        }
    }

    public void cA(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.aYr != null && (layoutParams = this.aYr.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.aYr.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.aWN.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (a.this.aYr != null && (layoutParams2 = a.this.aYr.getLayoutParams()) != null) {
                                layoutParams2.height = a.this.aYr.realHeight;
                                a.this.aYr.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.aWQ != null && this.aWQ.isChecked()) {
                this.aWN.setVisibility(0);
            }
        }
    }

    public void Fi() {
        if (this.aWP != null) {
            this.aWP.g(t.yL().yN());
        }
    }

    private void init() {
        Fj();
        initView();
        yt();
    }

    private void Fj() {
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
        this.aWN = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aYq = findViewById(a.g.layout_barrage);
        this.aWQ = (Switch) findViewById(a.g.switch_barrage);
        this.aWP = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aYr = (FlexLayout) findViewById(a.g.flex);
        this.aWQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.quick.a.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bK(z);
            }
        });
        this.aWP.setSelectEnabled(false);
        this.aWP.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.quick.a.4
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean Ec() {
                return a.this.aYp != null && a.this.aYp.Ec();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void cd(int i) {
                a.this.bL(false);
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public int Di() {
                if (a.this.aYp != null) {
                    return a.this.aYp.Di();
                }
                return 0;
            }
        });
        this.aYr.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.aYr.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.aYr.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.im.view.quick.a.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                bo boVar;
                if (a.this.aYp != null) {
                    if (a.this.aYq.getVisibility() == 0 && a.this.aWQ.isChecked()) {
                        bo selectInfo = a.this.aWP.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.aYp == null || !a.this.aYp.Ec())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aEn > a.this.aYp.Di()) {
                            if (selectInfo.aEn == 7) {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            boVar = selectInfo;
                        }
                    } else {
                        boVar = null;
                    }
                    a.this.aYp.b(i, a.this.aYs.getItem(i), boVar);
                }
            }
        });
    }

    private void yt() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.im.view.quick.a.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.aYp != null) {
                    a.this.aYp.Eb();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.im.view.quick.a.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.aWN != null) {
                    a.this.aWN.release();
                }
                if (a.this.aYp != null) {
                    a.this.aYp.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (z && this.aYp != null && !this.aYp.Dd()) {
            this.aWQ.setChecked(false, false);
        } else if (z) {
            this.aWP.setSwitchStatus(true);
            if (!TextUtils.isEmpty(m.Dm().Dp())) {
                this.aWP.setSelectId(m.Dm().Dp());
            } else {
                this.aWP.setSelectPos(0);
            }
            this.aWP.setSelectEnabled(true);
            bL(true);
        } else {
            this.aWP.setSwitchStatus(false);
            this.aWP.setSelectEnabled(false);
            this.aWN.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (z) {
            this.aWN.setPreview();
        }
        this.aWN.setUIInfo(this.aWP.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aWN.setVisibility(4);
        } else if (this.aWQ != null && this.aWQ.isChecked()) {
            this.aWN.setVisibility(0);
        }
    }

    private void bN(boolean z) {
        final bo[] e = m.Dm().e(this.aYp != null && this.aYp.Ec(), this.aYp != null ? this.aYp.Di() : 0);
        if (e == null || z) {
            if (this.aWQ.isChecked()) {
                this.aWQ.setChecked(false, false);
            } else {
                bK(false);
            }
            this.aYq.setVisibility(8);
            return;
        }
        this.aYq.setVisibility(0);
        this.aWP.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.aWP.setData(e, t.yL().yN(), 1);
                if (m.Dm().Do()) {
                    if (a.this.aWQ.isChecked()) {
                        a.this.aWP.setSelectId(m.Dm().Dp());
                        a.this.bL(true);
                        return;
                    }
                    a.this.aWQ.setChecked(true, false);
                } else if (a.this.aWQ.isChecked()) {
                    a.this.aWQ.setChecked(false, false);
                }
            }
        });
    }

    private void l(String[] strArr) {
        if (this.aYs == null) {
            this.aYs = new b(strArr);
            this.aYr.setAdapter(this.aYs);
            return;
        }
        this.aYs.setDatas(strArr);
        this.aYs.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ab() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
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
