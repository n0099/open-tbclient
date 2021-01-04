package com.baidu.live.quick;

import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ck;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.view.Switch;
/* loaded from: classes11.dex */
public class b extends Dialog {
    private com.baidu.live.im.b.b brA;
    private c brC;
    private FrameLayout brD;
    private FrameLayout brE;
    private Switch brF;
    private a bzk;
    private View bzl;
    private FlexLayout bzm;
    private C0202b bzn;
    private BdPageContext bzo;
    private View mContentView;

    /* loaded from: classes11.dex */
    public interface a {
        boolean ME();

        int MK();

        boolean ML();

        boolean Nt();

        void b(int i, String str, ck ckVar);

        void onDismiss();

        void onShow();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.bzo = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bzk = aVar;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cJ(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.bzm != null && (layoutParams = b.this.bzm.getLayoutParams()) != null) {
                        layoutParams.height = b.this.bzm.realHeight;
                        b.this.bzm.setLayoutParams(layoutParams);
                    }
                    b.this.Ji();
                }
            });
        }
    }

    public void dU(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.bzm != null && (layoutParams = this.bzm.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.bzm.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.brE.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.bzm != null && (layoutParams2 = b.this.bzm.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.bzm.realHeight;
                                b.this.bzm.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.brF != null && this.brF.isChecked()) {
                this.brE.setVisibility(0);
            }
        }
    }

    public void RQ() {
        if (this.brC != null) {
            this.brC.f(z.HJ().HL());
        }
    }

    private void init() {
        JK();
        initView();
        Hi();
    }

    private void JK() {
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
        this.mContentView = LayoutInflater.from(getContext()).inflate(a.g.ala_im_quick_input_list, (ViewGroup) null);
        setContentView(this.mContentView);
        this.bzl = findViewById(a.f.layout_barrage);
        this.brF = (Switch) findViewById(a.f.switch_barrage);
        this.bzm = (FlexLayout) findViewById(a.f.flex);
        this.brE = (FrameLayout) findViewById(a.f.barrage_preview);
        this.brD = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bzo);
        if (runTask != null) {
            this.brC = (c) runTask.getData();
        }
        if (this.brC != null) {
            this.brD.addView(this.brC.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bzo);
        if (runTask2 != null) {
            this.brA = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.brA != null) {
            this.brE.addView(this.brA.getView());
        }
        this.brF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.cp(z);
            }
        });
        if (this.brC != null) {
            this.brC.setSelectEnabled(false);
            this.brC.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean Nt() {
                    return b.this.bzk != null && b.this.bzk.Nt();
                }

                @Override // com.baidu.live.im.b.e
                public void fb(int i) {
                    b.this.cq(false);
                }

                @Override // com.baidu.live.im.b.e
                public int MK() {
                    if (b.this.bzk != null) {
                        return b.this.bzk.MK();
                    }
                    return 0;
                }
            });
        }
        this.bzm.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.bzm.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.bzm.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                ck ckVar;
                if (b.this.bzk != null) {
                    if (b.this.bzl.getVisibility() == 0 && b.this.brF.isChecked() && b.this.brC != null) {
                        ck selectInfo = b.this.brC.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bzk == null || !b.this.bzk.Nt())) {
                            BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aTG > b.this.bzk.MK()) {
                            if (selectInfo.aTG == 7) {
                                BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            ckVar = selectInfo;
                        }
                    } else {
                        ckVar = null;
                    }
                    b.this.bzk.b(i, b.this.bzn.getItem(i), ckVar);
                }
            }
        });
    }

    private void Hi() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bzk != null) {
                    b.this.bzk.onShow();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.brA != null) {
                    b.this.brA.release();
                }
                if (b.this.bzk != null) {
                    b.this.bzk.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(boolean z) {
        if (z && this.bzk != null && !this.bzk.ME()) {
            this.brF.setChecked(false, false);
        } else if (this.brC != null) {
            if (z) {
                this.brC.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Nk().No())) {
                    this.brC.setSelectId(d.Nk().No());
                } else {
                    this.brC.setSelectPos(0);
                }
                this.brC.setSelectEnabled(true);
                cq(true);
                return;
            }
            this.brC.setSwitchStatus(false);
            this.brC.setSelectEnabled(false);
            this.brE.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(boolean z) {
        if (z && this.brA != null) {
            this.brA.setPreview();
        }
        if (this.brA != null && this.brC != null) {
            this.brA.setUIInfo(this.brC.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.brE.setVisibility(4);
        } else if (this.brF != null && this.brF.isChecked()) {
            this.brE.setVisibility(0);
        }
    }

    private void cJ(boolean z) {
        final ck[] b2 = d.Nk().b(this.bzk != null && this.bzk.Nt(), this.bzk != null ? this.bzk.MK() : 0, this.bzk != null ? this.bzk.ML() : false);
        if (b2 == null || b2.length <= 0 || z) {
            if (this.brF.isChecked()) {
                this.brF.setChecked(false, false);
            } else {
                cp(false);
            }
            this.bzl.setVisibility(8);
            return;
        }
        this.bzl.setVisibility(0);
        if (this.brC != null) {
            this.brC.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.brC != null) {
                        b.this.brC.setData(b2, z.HJ().HL(), 1);
                        if (d.Nk().Nn()) {
                            if (b.this.brF.isChecked()) {
                                b.this.brC.setSelectId(d.Nk().No());
                                b.this.cq(true);
                                return;
                            }
                            b.this.brF.setChecked(true, false);
                        } else if (b.this.brF.isChecked()) {
                            b.this.brF.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.bzn == null) {
            this.bzn = new C0202b(strArr);
            this.bzm.setAdapter(this.bzn);
            return;
        }
        this.bzn.setDatas(strArr);
        this.bzn.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ji() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0202b extends FlexAdapter<String> {
        C0202b(String[] strArr) {
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
