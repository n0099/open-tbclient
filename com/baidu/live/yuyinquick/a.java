package com.baidu.live.yuyinquick;

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
public class a extends Dialog {
    private com.baidu.live.im.b.b brA;
    private c brC;
    private FrameLayout brD;
    private FrameLayout brE;
    private Switch brF;
    private View bzl;
    private FlexLayout bzm;
    private BdPageContext bzo;
    private InterfaceC0250a ceO;
    private b ceP;
    private View mContentView;

    /* renamed from: com.baidu.live.yuyinquick.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0250a {
        boolean ME();

        int MK();

        boolean Nt();

        void b(int i, String str, ck ckVar);

        void onDismiss();

        void onShow();
    }

    public a(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.bzo = bdPageContext;
        init();
    }

    public void a(InterfaceC0250a interfaceC0250a) {
        this.ceO = interfaceC0250a;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.yuyinquick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.bzm != null && (layoutParams = a.this.bzm.getLayoutParams()) != null) {
                        layoutParams.height = a.this.bzm.realHeight;
                        a.this.bzm.setLayoutParams(layoutParams);
                    }
                    a.this.Ji();
                }
            });
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
        this.mContentView = LayoutInflater.from(getContext()).inflate(a.g.ala_yuyin_im_quick_input_list, (ViewGroup) null);
        setContentView(this.mContentView);
        this.bzl = findViewById(a.f.layout_barrage);
        this.brF = (Switch) findViewById(a.f.switch_barrage);
        this.bzm = (FlexLayout) findViewById(a.f.flex);
        this.brE = (FrameLayout) findViewById(a.f.barrage_preview);
        this.brD = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.bzo);
        if (runTask != null) {
            this.brC = (c) runTask.getData();
        }
        if (this.brC != null) {
            this.brD.addView(this.brC.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, com.baidu.live.im.b.b.class, this.bzo);
        if (runTask2 != null) {
            this.brA = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.brA != null) {
            this.brE.addView(this.brA.getView());
            this.brE.setVisibility(8);
        }
        this.brF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinquick.a.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.cp(z);
            }
        });
        if (this.brC != null) {
            this.brC.setSelectEnabled(false);
            this.brC.setCallback(new e() { // from class: com.baidu.live.yuyinquick.a.3
                @Override // com.baidu.live.im.b.e
                public boolean Nt() {
                    return a.this.ceO != null && a.this.ceO.Nt();
                }

                @Override // com.baidu.live.im.b.e
                public void fb(int i) {
                    a.this.cq(false);
                }

                @Override // com.baidu.live.im.b.e
                public int MK() {
                    if (a.this.ceO != null) {
                        return a.this.ceO.MK();
                    }
                    return 0;
                }
            });
        }
        this.bzm.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.bzm.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.bzm.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.yuyinquick.a.4
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                ck ckVar;
                if (a.this.ceO != null) {
                    if (a.this.bzl.getVisibility() == 0 && a.this.brF.isChecked() && a.this.brC != null) {
                        ck selectInfo = a.this.brC.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.ceO == null || !a.this.ceO.Nt())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aTG > a.this.ceO.MK()) {
                            if (selectInfo.aTG == 7) {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            ckVar = selectInfo;
                        }
                    } else {
                        ckVar = null;
                    }
                    a.this.ceO.b(i, a.this.ceP.getItem(i), ckVar);
                }
            }
        });
    }

    private void Hi() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.yuyinquick.a.5
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.ceO != null) {
                    a.this.ceO.onShow();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.yuyinquick.a.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.brA != null) {
                    a.this.brA.release();
                }
                if (a.this.ceO != null) {
                    a.this.ceO.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(boolean z) {
        if (z && this.ceO != null && !this.ceO.ME()) {
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
            this.brE.setVisibility(8);
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
            this.brE.setVisibility(8);
        } else if (this.brF != null && this.brF.isChecked()) {
            this.brE.setVisibility(0);
        }
    }

    private void n(String[] strArr) {
        if (this.ceP == null) {
            this.ceP = new b(strArr);
            this.bzm.setAdapter(this.ceP);
            return;
        }
        this.ceP.setDatas(strArr);
        this.ceP.notifyDataSetChanged();
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
    /* loaded from: classes11.dex */
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
