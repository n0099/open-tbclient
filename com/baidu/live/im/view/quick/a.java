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
import com.baidu.live.data.be;
import com.baidu.live.gift.s;
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
    private ImBarrageItemView aNZ;
    private ImBarrageOptionListView aOb;
    private Switch aOc;
    private View aPA;
    private FlexLayout aPB;
    private b aPC;
    private InterfaceC0136a aPz;
    private View mContentView;

    /* renamed from: com.baidu.live.im.view.quick.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0136a {
        boolean Bg();

        void Cc();

        boolean Cd();

        void b(int i, String str, be beVar);

        void onDismiss();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_TransparentDialog);
        init();
    }

    public void a(InterfaceC0136a interfaceC0136a) {
        this.aPz = interfaceC0136a;
    }

    public void m(String[] strArr) {
        n(strArr);
        CP();
        yl();
        show();
        if (this.mContentView != null) {
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.aPB != null && (layoutParams = a.this.aPB.getLayoutParams()) != null) {
                        layoutParams.height = a.this.aPB.realHeight;
                        a.this.aPB.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void cl(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.aPB != null && (layoutParams = this.aPB.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.aPB.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.aNZ.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (a.this.aPB != null && (layoutParams2 = a.this.aPB.getLayoutParams()) != null) {
                                layoutParams2.height = a.this.aPB.realHeight;
                                a.this.aPB.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.aOc != null && this.aOc.isChecked()) {
                this.aNZ.setVisibility(0);
            }
        }
    }

    public void Dg() {
        if (this.aOb != null) {
            this.aOb.f(s.wU().wW());
        }
    }

    private void init() {
        Dh();
        initView();
        wC();
    }

    private void Dh() {
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
        this.aNZ = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aPA = findViewById(a.g.layout_barrage);
        this.aOc = (Switch) findViewById(a.g.switch_barrage);
        this.aOb = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aPB = (FlexLayout) findViewById(a.g.flex);
        this.aOc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.quick.a.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bB(z);
            }
        });
        this.aOb.setSelectEnabled(false);
        this.aOb.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.quick.a.4
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean Cd() {
                return a.this.aPz != null && a.this.aPz.Cd();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bO(int i) {
                a.this.bC(false);
            }
        });
        this.aPB.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.aPB.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.aPB.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.im.view.quick.a.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                be beVar;
                if (a.this.aPz != null) {
                    if (a.this.aPA.getVisibility() == 0 && a.this.aOc.isChecked()) {
                        be selectInfo = a.this.aOb.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.aPz == null || !a.this.aPz.Cd())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        beVar = selectInfo;
                    } else {
                        beVar = null;
                    }
                    a.this.aPz.b(i, a.this.aPC.getItem(i), beVar);
                }
            }
        });
    }

    private void wC() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.im.view.quick.a.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.aPz != null) {
                    a.this.aPz.Cc();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.im.view.quick.a.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.aNZ != null) {
                    a.this.aNZ.release();
                }
                if (a.this.aPz != null) {
                    a.this.aPz.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        if (z && this.aPz != null && !this.aPz.Bg()) {
            this.aOc.setChecked(false, false);
        } else if (z) {
            this.aOb.setSwitchStatus(true);
            if (!TextUtils.isEmpty(m.Bo().Br())) {
                this.aOb.setSelectId(m.Bo().Br());
            } else {
                this.aOb.setSelectPos(0);
            }
            this.aOb.setSelectEnabled(true);
            bC(true);
        } else {
            this.aOb.setSwitchStatus(false);
            this.aOb.setSelectEnabled(false);
            this.aNZ.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(boolean z) {
        if (z) {
            this.aNZ.setPreview();
        }
        this.aNZ.setUIInfo(this.aOb.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aNZ.setVisibility(4);
        } else if (this.aOc != null && this.aOc.isChecked()) {
            this.aNZ.setVisibility(0);
        }
    }

    private void CP() {
        final be[] bw = m.Bo().bw(this.aPz != null && this.aPz.Cd());
        if (bw == null) {
            if (this.aOc.isChecked()) {
                this.aOc.setChecked(false, false);
            } else {
                bB(false);
            }
            this.aPA.setVisibility(8);
            return;
        }
        this.aPA.setVisibility(0);
        this.aOb.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.aOb.setData(bw, s.wU().wW(), 1);
                if (m.Bo().Bq()) {
                    if (a.this.aOc.isChecked()) {
                        a.this.aOb.setSelectId(m.Bo().Br());
                        a.this.bC(true);
                        return;
                    }
                    a.this.aOc.setChecked(true, false);
                } else if (a.this.aOc.isChecked()) {
                    a.this.aOc.setChecked(false, false);
                }
            }
        });
    }

    private void n(String[] strArr) {
        if (this.aPC == null) {
            this.aPC = new b(strArr);
            this.aPB.setAdapter(this.aPC);
            return;
        }
        this.aPC.setDatas(strArr);
        this.aPC.notifyDataSetChanged();
    }

    private void yl() {
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
