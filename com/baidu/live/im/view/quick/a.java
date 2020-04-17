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
    private ImBarrageItemView aNT;
    private ImBarrageOptionListView aNV;
    private Switch aNW;
    private InterfaceC0115a aPt;
    private View aPu;
    private FlexLayout aPv;
    private b aPw;
    private View mContentView;

    /* renamed from: com.baidu.live.im.view.quick.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0115a {
        boolean Bh();

        void Cd();

        boolean Ce();

        void b(int i, String str, be beVar);

        void onDismiss();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_TransparentDialog);
        init();
    }

    public void a(InterfaceC0115a interfaceC0115a) {
        this.aPt = interfaceC0115a;
    }

    public void m(String[] strArr) {
        n(strArr);
        CQ();
        ym();
        show();
        if (this.mContentView != null) {
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.aPv != null && (layoutParams = a.this.aPv.getLayoutParams()) != null) {
                        layoutParams.height = a.this.aPv.realHeight;
                        a.this.aPv.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void cl(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.aPv != null && (layoutParams = this.aPv.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.aPv.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.aNT.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (a.this.aPv != null && (layoutParams2 = a.this.aPv.getLayoutParams()) != null) {
                                layoutParams2.height = a.this.aPv.realHeight;
                                a.this.aPv.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.aNW != null && this.aNW.isChecked()) {
                this.aNT.setVisibility(0);
            }
        }
    }

    public void Dh() {
        if (this.aNV != null) {
            this.aNV.f(s.wV().wX());
        }
    }

    private void init() {
        Di();
        initView();
        wD();
    }

    private void Di() {
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
        this.aNT = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aPu = findViewById(a.g.layout_barrage);
        this.aNW = (Switch) findViewById(a.g.switch_barrage);
        this.aNV = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aPv = (FlexLayout) findViewById(a.g.flex);
        this.aNW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.quick.a.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bB(z);
            }
        });
        this.aNV.setSelectEnabled(false);
        this.aNV.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.quick.a.4
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean Ce() {
                return a.this.aPt != null && a.this.aPt.Ce();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bO(int i) {
                a.this.bC(false);
            }
        });
        this.aPv.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.aPv.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.aPv.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.im.view.quick.a.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                be beVar;
                if (a.this.aPt != null) {
                    if (a.this.aPu.getVisibility() == 0 && a.this.aNW.isChecked()) {
                        be selectInfo = a.this.aNV.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.aPt == null || !a.this.aPt.Ce())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        beVar = selectInfo;
                    } else {
                        beVar = null;
                    }
                    a.this.aPt.b(i, a.this.aPw.getItem(i), beVar);
                }
            }
        });
    }

    private void wD() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.im.view.quick.a.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.aPt != null) {
                    a.this.aPt.Cd();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.im.view.quick.a.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.aNT != null) {
                    a.this.aNT.release();
                }
                if (a.this.aPt != null) {
                    a.this.aPt.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        if (z && this.aPt != null && !this.aPt.Bh()) {
            this.aNW.setChecked(false, false);
        } else if (z) {
            this.aNV.setSwitchStatus(true);
            if (!TextUtils.isEmpty(m.Bp().Bs())) {
                this.aNV.setSelectId(m.Bp().Bs());
            } else {
                this.aNV.setSelectPos(0);
            }
            this.aNV.setSelectEnabled(true);
            bC(true);
        } else {
            this.aNV.setSwitchStatus(false);
            this.aNV.setSelectEnabled(false);
            this.aNT.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(boolean z) {
        if (z) {
            this.aNT.setPreview();
        }
        this.aNT.setUIInfo(this.aNV.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aNT.setVisibility(4);
        } else if (this.aNW != null && this.aNW.isChecked()) {
            this.aNT.setVisibility(0);
        }
    }

    private void CQ() {
        final be[] bw = m.Bp().bw(this.aPt != null && this.aPt.Ce());
        if (bw == null) {
            if (this.aNW.isChecked()) {
                this.aNW.setChecked(false, false);
            } else {
                bB(false);
            }
            this.aPu.setVisibility(8);
            return;
        }
        this.aPu.setVisibility(0);
        this.aNV.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.aNV.setData(bw, s.wV().wX(), 1);
                if (m.Bp().Br()) {
                    if (a.this.aNW.isChecked()) {
                        a.this.aNV.setSelectId(m.Bp().Bs());
                        a.this.bC(true);
                        return;
                    }
                    a.this.aNW.setChecked(true, false);
                } else if (a.this.aNW.isChecked()) {
                    a.this.aNW.setChecked(false, false);
                }
            }
        });
    }

    private void n(String[] strArr) {
        if (this.aPw == null) {
            this.aPw = new b(strArr);
            this.aPv.setAdapter(this.aPw);
            return;
        }
        this.aPw.setDatas(strArr);
        this.aPw.notifyDataSetChanged();
    }

    private void ym() {
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
