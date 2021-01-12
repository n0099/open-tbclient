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
/* loaded from: classes10.dex */
public class b extends Dialog {
    private com.baidu.live.im.b.b bmO;
    private c bmQ;
    private FrameLayout bmR;
    private FrameLayout bmS;
    private Switch bmT;
    private FlexLayout buA;
    private C0193b buB;
    private BdPageContext buC;
    private a buy;
    private View buz;
    private View mContentView;

    /* loaded from: classes10.dex */
    public interface a {
        boolean IJ();

        int IP();

        boolean IQ();

        boolean Jy();

        void b(int i, String str, ck ckVar);

        void onDismiss();

        void onShow();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.buC = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.buy = aVar;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cF(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.buA != null && (layoutParams = b.this.buA.getLayoutParams()) != null) {
                        layoutParams.height = b.this.buA.realHeight;
                        b.this.buA.setLayoutParams(layoutParams);
                    }
                    b.this.Fn();
                }
            });
        }
    }

    public void co(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.buA != null && (layoutParams = this.buA.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.buA.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.bmS.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.buA != null && (layoutParams2 = b.this.buA.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.buA.realHeight;
                                b.this.buA.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.bmT != null && this.bmT.isChecked()) {
                this.bmS.setVisibility(0);
            }
        }
    }

    public void NV() {
        if (this.bmQ != null) {
            this.bmQ.f(z.DO().DQ());
        }
    }

    private void init() {
        FP();
        initView();
        Dn();
    }

    private void FP() {
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
        this.buz = findViewById(a.f.layout_barrage);
        this.bmT = (Switch) findViewById(a.f.switch_barrage);
        this.buA = (FlexLayout) findViewById(a.f.flex);
        this.bmS = (FrameLayout) findViewById(a.f.barrage_preview);
        this.bmR = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.buC);
        if (runTask != null) {
            this.bmQ = (c) runTask.getData();
        }
        if (this.bmQ != null) {
            this.bmR.addView(this.bmQ.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.buC);
        if (runTask2 != null) {
            this.bmO = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bmO != null) {
            this.bmS.addView(this.bmO.getView());
        }
        this.bmT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.cl(z);
            }
        });
        if (this.bmQ != null) {
            this.bmQ.setSelectEnabled(false);
            this.bmQ.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean Jy() {
                    return b.this.buy != null && b.this.buy.Jy();
                }

                @Override // com.baidu.live.im.b.e
                public void dv(int i) {
                    b.this.cm(false);
                }

                @Override // com.baidu.live.im.b.e
                public int IP() {
                    if (b.this.buy != null) {
                        return b.this.buy.IP();
                    }
                    return 0;
                }
            });
        }
        this.buA.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.buA.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.buA.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                ck ckVar;
                if (b.this.buy != null) {
                    if (b.this.buz.getVisibility() == 0 && b.this.bmT.isChecked() && b.this.bmQ != null) {
                        ck selectInfo = b.this.bmQ.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.buy == null || !b.this.buy.Jy())) {
                            BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aOT > b.this.buy.IP()) {
                            if (selectInfo.aOT == 7) {
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
                    b.this.buy.b(i, b.this.buB.getItem(i), ckVar);
                }
            }
        });
    }

    private void Dn() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.buy != null) {
                    b.this.buy.onShow();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bmO != null) {
                    b.this.bmO.release();
                }
                if (b.this.buy != null) {
                    b.this.buy.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(boolean z) {
        if (z && this.buy != null && !this.buy.IJ()) {
            this.bmT.setChecked(false, false);
        } else if (this.bmQ != null) {
            if (z) {
                this.bmQ.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Jp().Jt())) {
                    this.bmQ.setSelectId(d.Jp().Jt());
                } else {
                    this.bmQ.setSelectPos(0);
                }
                this.bmQ.setSelectEnabled(true);
                cm(true);
                return;
            }
            this.bmQ.setSwitchStatus(false);
            this.bmQ.setSelectEnabled(false);
            this.bmS.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(boolean z) {
        if (z && this.bmO != null) {
            this.bmO.setPreview();
        }
        if (this.bmO != null && this.bmQ != null) {
            this.bmO.setUIInfo(this.bmQ.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bmS.setVisibility(4);
        } else if (this.bmT != null && this.bmT.isChecked()) {
            this.bmS.setVisibility(0);
        }
    }

    private void cF(boolean z) {
        final ck[] b2 = d.Jp().b(this.buy != null && this.buy.Jy(), this.buy != null ? this.buy.IP() : 0, this.buy != null ? this.buy.IQ() : false);
        if (b2 == null || b2.length <= 0 || z) {
            if (this.bmT.isChecked()) {
                this.bmT.setChecked(false, false);
            } else {
                cl(false);
            }
            this.buz.setVisibility(8);
            return;
        }
        this.buz.setVisibility(0);
        if (this.bmQ != null) {
            this.bmQ.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bmQ != null) {
                        b.this.bmQ.setData(b2, z.DO().DQ(), 1);
                        if (d.Jp().Js()) {
                            if (b.this.bmT.isChecked()) {
                                b.this.bmQ.setSelectId(d.Jp().Jt());
                                b.this.cm(true);
                                return;
                            }
                            b.this.bmT.setChecked(true, false);
                        } else if (b.this.bmT.isChecked()) {
                            b.this.bmT.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.buB == null) {
            this.buB = new C0193b(strArr);
            this.buA.setAdapter(this.buB);
            return;
        }
        this.buB.setDatas(strArr);
        this.buB.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fn() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0193b extends FlexAdapter<String> {
        C0193b(String[] strArr) {
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
