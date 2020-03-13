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
    private ImBarrageItemView auk;
    private ImBarrageOptionListView aum;
    private Switch aun;
    private InterfaceC0089a avG;
    private View avH;
    private FlexLayout avI;
    private b avJ;
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
        this.avG = interfaceC0089a;
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
                    if (a.this.avI != null && (layoutParams = a.this.avI.getLayoutParams()) != null) {
                        layoutParams.height = a.this.avI.realHeight;
                        a.this.avI.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void bW(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.avI != null && (layoutParams = this.avI.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.avI.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.auk.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (a.this.avI != null && (layoutParams2 = a.this.avI.getLayoutParams()) != null) {
                                layoutParams2.height = a.this.avI.realHeight;
                                a.this.avI.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.aun != null && this.aun.isChecked()) {
                this.auk.setVisibility(0);
            }
        }
    }

    public void yj() {
        if (this.aum != null) {
            this.aum.i(r.sx().sz());
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
        this.auk = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.avH = findViewById(a.g.layout_barrage);
        this.aun = (Switch) findViewById(a.g.switch_barrage);
        this.aum = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.avI = (FlexLayout) findViewById(a.g.flex);
        this.aun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.quick.a.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.aX(z);
            }
        });
        this.aum.setSelectEnabled(false);
        this.aum.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.quick.a.4
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean xn() {
                return a.this.avG != null && a.this.avG.xn();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bP(int i) {
                a.this.aY(false);
            }
        });
        this.avI.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.avI.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.avI.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.im.view.quick.a.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                bb bbVar;
                if (a.this.avG != null) {
                    if (a.this.avH.getVisibility() == 0 && a.this.aun.isChecked()) {
                        bb selectInfo = a.this.aum.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.avG == null || !a.this.avG.xn())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        bbVar = selectInfo;
                    } else {
                        bbVar = null;
                    }
                    a.this.avG.a(i, a.this.avJ.getItem(i), bbVar);
                }
            }
        });
    }

    private void sf() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.im.view.quick.a.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.avG != null) {
                    a.this.avG.xm();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.im.view.quick.a.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.auk != null) {
                    a.this.auk.release();
                }
                if (a.this.avG != null) {
                    a.this.avG.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(boolean z) {
        if (z && this.avG != null && !this.avG.ws()) {
            this.aun.setChecked(false, false);
        } else if (z) {
            this.aum.setSwitchStatus(true);
            if (!TextUtils.isEmpty(k.wA().wD())) {
                this.aum.setSelectId(k.wA().wD());
            } else {
                this.aum.setSelectPos(0);
            }
            this.aum.setSelectEnabled(true);
            aY(true);
        } else {
            this.aum.setSwitchStatus(false);
            this.aum.setSelectEnabled(false);
            this.auk.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (z) {
            this.auk.setPreview();
        }
        this.auk.setUIInfo(this.aum.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.auk.setVisibility(4);
        } else if (this.aun != null && this.aun.isChecked()) {
            this.auk.setVisibility(0);
        }
    }

    private void xT() {
        final bb[] aT = k.wA().aT(this.avG != null && this.avG.xn());
        if (aT == null) {
            if (this.aun.isChecked()) {
                this.aun.setChecked(false, false);
            } else {
                aX(false);
            }
            this.avH.setVisibility(8);
            return;
        }
        this.avH.setVisibility(0);
        this.aum.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.aum.setData(aT, r.sx().sz(), 1);
                if (k.wA().wC()) {
                    if (a.this.aun.isChecked()) {
                        a.this.aum.setSelectId(k.wA().wD());
                        a.this.aY(true);
                        return;
                    }
                    a.this.aun.setChecked(true, false);
                } else if (a.this.aun.isChecked()) {
                    a.this.aun.setChecked(false, false);
                }
            }
        });
    }

    private void n(String[] strArr) {
        if (this.avJ == null) {
            this.avJ = new b(strArr);
            this.avI.setAdapter(this.avJ);
            return;
        }
        this.avJ.setDatas(strArr);
        this.avJ.notifyDataSetChanged();
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
