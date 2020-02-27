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
import com.baidu.live.data.bb;
import com.baidu.live.gift.r;
import com.baidu.live.im.k;
import com.baidu.live.im.view.barrage.ImBarrageItemView;
import com.baidu.live.im.view.barrage.ImBarrageOptionListView;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.u.a;
import com.baidu.live.view.Switch;
/* loaded from: classes3.dex */
public class a extends Dialog {
    private ImBarrageItemView auj;
    private ImBarrageOptionListView aul;
    private Switch aum;
    private InterfaceC0089a avF;
    private View avG;
    private FlexLayout avH;
    private b avI;
    private View mContentView;

    /* renamed from: com.baidu.live.im.view.quick.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0089a {
        void a(int i, String str, bb bbVar);

        void onDismiss();

        boolean ws();

        void xm();

        boolean xn();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_TransparentDialog);
        init();
    }

    public void a(InterfaceC0089a interfaceC0089a) {
        this.avF = interfaceC0089a;
    }

    public void m(String[] strArr) {
        n(strArr);
        xT();
        tN();
        show();
        if (this.mContentView != null) {
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.avH != null && (layoutParams = a.this.avH.getLayoutParams()) != null) {
                        layoutParams.height = a.this.avH.realHeight;
                        a.this.avH.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void bW(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.avH != null && (layoutParams = this.avH.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.avH.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.auj.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (a.this.avH != null && (layoutParams2 = a.this.avH.getLayoutParams()) != null) {
                                layoutParams2.height = a.this.avH.realHeight;
                                a.this.avH.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.aum != null && this.aum.isChecked()) {
                this.auj.setVisibility(0);
            }
        }
    }

    public void yj() {
        if (this.aul != null) {
            this.aul.i(r.sx().sz());
        }
    }

    private void init() {
        initWindow();
        initView();
        sf();
    }

    private void initWindow() {
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
        this.auj = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.avG = findViewById(a.g.layout_barrage);
        this.aum = (Switch) findViewById(a.g.switch_barrage);
        this.aul = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.avH = (FlexLayout) findViewById(a.g.flex);
        this.aum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.quick.a.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.aX(z);
            }
        });
        this.aul.setSelectEnabled(false);
        this.aul.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.quick.a.4
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean xn() {
                return a.this.avF != null && a.this.avF.xn();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bP(int i) {
                a.this.aY(false);
            }
        });
        this.avH.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.avH.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.avH.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.im.view.quick.a.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                bb bbVar;
                if (a.this.avF != null) {
                    if (a.this.avG.getVisibility() == 0 && a.this.aum.isChecked()) {
                        bb selectInfo = a.this.aul.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.avF == null || !a.this.avF.xn())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        bbVar = selectInfo;
                    } else {
                        bbVar = null;
                    }
                    a.this.avF.a(i, a.this.avI.getItem(i), bbVar);
                }
            }
        });
    }

    private void sf() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.im.view.quick.a.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.avF != null) {
                    a.this.avF.xm();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.im.view.quick.a.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.auj != null) {
                    a.this.auj.release();
                }
                if (a.this.avF != null) {
                    a.this.avF.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(boolean z) {
        if (z && this.avF != null && !this.avF.ws()) {
            this.aum.setChecked(false, false);
        } else if (z) {
            this.aul.setSwitchStatus(true);
            if (!TextUtils.isEmpty(k.wA().wD())) {
                this.aul.setSelectId(k.wA().wD());
            } else {
                this.aul.setSelectPos(0);
            }
            this.aul.setSelectEnabled(true);
            aY(true);
        } else {
            this.aul.setSwitchStatus(false);
            this.aul.setSelectEnabled(false);
            this.auj.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (z) {
            this.auj.setPreview();
        }
        this.auj.setUIInfo(this.aul.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.auj.setVisibility(4);
        } else if (this.aum != null && this.aum.isChecked()) {
            this.auj.setVisibility(0);
        }
    }

    private void xT() {
        final bb[] aT = k.wA().aT(this.avF != null && this.avF.xn());
        if (aT == null) {
            if (this.aum.isChecked()) {
                this.aum.setChecked(false, false);
            } else {
                aX(false);
            }
            this.avG.setVisibility(8);
            return;
        }
        this.avG.setVisibility(0);
        this.aul.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.aul.setData(aT, r.sx().sz(), 1);
                if (k.wA().wC()) {
                    if (a.this.aum.isChecked()) {
                        a.this.aul.setSelectId(k.wA().wD());
                        a.this.aY(true);
                        return;
                    }
                    a.this.aum.setChecked(true, false);
                } else if (a.this.aum.isChecked()) {
                    a.this.aum.setChecked(false, false);
                }
            }
        });
    }

    private void n(String[] strArr) {
        if (this.avI == null) {
            this.avI = new b(strArr);
            this.avH.setAdapter(this.avI);
            return;
        }
        this.avI.setDatas(strArr);
        this.avI.notifyDataSetChanged();
    }

    private void tN() {
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
