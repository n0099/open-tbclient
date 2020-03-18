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
    private ImBarrageItemView auu;
    private ImBarrageOptionListView auw;
    private Switch aux;
    private InterfaceC0089a avQ;
    private View avR;
    private FlexLayout avS;
    private b avT;
    private View mContentView;

    /* renamed from: com.baidu.live.im.view.quick.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0089a {
        void a(int i, String str, bb bbVar);

        void onDismiss();

        boolean wx();

        void xr();

        boolean xs();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_TransparentDialog);
        init();
    }

    public void a(InterfaceC0089a interfaceC0089a) {
        this.avQ = interfaceC0089a;
    }

    public void m(String[] strArr) {
        n(strArr);
        xY();
        tS();
        show();
        if (this.mContentView != null) {
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.avS != null && (layoutParams = a.this.avS.getLayoutParams()) != null) {
                        layoutParams.height = a.this.avS.realHeight;
                        a.this.avS.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void bW(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.avS != null && (layoutParams = this.avS.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.avS.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.auu.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (a.this.avS != null && (layoutParams2 = a.this.avS.getLayoutParams()) != null) {
                                layoutParams2.height = a.this.avS.realHeight;
                                a.this.avS.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.aux != null && this.aux.isChecked()) {
                this.auu.setVisibility(0);
            }
        }
    }

    public void yo() {
        if (this.auw != null) {
            this.auw.i(r.sC().sE());
        }
    }

    private void init() {
        initWindow();
        initView();
        sk();
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
        this.auu = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.avR = findViewById(a.g.layout_barrage);
        this.aux = (Switch) findViewById(a.g.switch_barrage);
        this.auw = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.avS = (FlexLayout) findViewById(a.g.flex);
        this.aux.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.quick.a.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.aX(z);
            }
        });
        this.auw.setSelectEnabled(false);
        this.auw.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.quick.a.4
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean xs() {
                return a.this.avQ != null && a.this.avQ.xs();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bP(int i) {
                a.this.aY(false);
            }
        });
        this.avS.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.avS.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.avS.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.im.view.quick.a.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                bb bbVar;
                if (a.this.avQ != null) {
                    if (a.this.avR.getVisibility() == 0 && a.this.aux.isChecked()) {
                        bb selectInfo = a.this.auw.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.avQ == null || !a.this.avQ.xs())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        bbVar = selectInfo;
                    } else {
                        bbVar = null;
                    }
                    a.this.avQ.a(i, a.this.avT.getItem(i), bbVar);
                }
            }
        });
    }

    private void sk() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.im.view.quick.a.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.avQ != null) {
                    a.this.avQ.xr();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.im.view.quick.a.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.auu != null) {
                    a.this.auu.release();
                }
                if (a.this.avQ != null) {
                    a.this.avQ.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(boolean z) {
        if (z && this.avQ != null && !this.avQ.wx()) {
            this.aux.setChecked(false, false);
        } else if (z) {
            this.auw.setSwitchStatus(true);
            if (!TextUtils.isEmpty(k.wF().wI())) {
                this.auw.setSelectId(k.wF().wI());
            } else {
                this.auw.setSelectPos(0);
            }
            this.auw.setSelectEnabled(true);
            aY(true);
        } else {
            this.auw.setSwitchStatus(false);
            this.auw.setSelectEnabled(false);
            this.auu.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (z) {
            this.auu.setPreview();
        }
        this.auu.setUIInfo(this.auw.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.auu.setVisibility(4);
        } else if (this.aux != null && this.aux.isChecked()) {
            this.auu.setVisibility(0);
        }
    }

    private void xY() {
        final bb[] aT = k.wF().aT(this.avQ != null && this.avQ.xs());
        if (aT == null) {
            if (this.aux.isChecked()) {
                this.aux.setChecked(false, false);
            } else {
                aX(false);
            }
            this.avR.setVisibility(8);
            return;
        }
        this.avR.setVisibility(0);
        this.auw.post(new Runnable() { // from class: com.baidu.live.im.view.quick.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.auw.setData(aT, r.sC().sE(), 1);
                if (k.wF().wH()) {
                    if (a.this.aux.isChecked()) {
                        a.this.auw.setSelectId(k.wF().wI());
                        a.this.aY(true);
                        return;
                    }
                    a.this.aux.setChecked(true, false);
                } else if (a.this.aux.isChecked()) {
                    a.this.aux.setChecked(false, false);
                }
            }
        });
    }

    private void n(String[] strArr) {
        if (this.avT == null) {
            this.avT = new b(strArr);
            this.avS.setAdapter(this.avT);
            return;
        }
        this.avT.setDatas(strArr);
        this.avT.notifyDataSetChanged();
    }

    private void tS() {
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
