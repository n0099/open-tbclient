package com.baidu.live.quick;

import android.app.Dialog;
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
import android.widget.FrameLayout;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ci;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.view.Switch;
/* loaded from: classes4.dex */
public class b extends Dialog {
    private com.baidu.live.im.b.b bpS;
    private c bpU;
    private FrameLayout bpV;
    private FrameLayout bpW;
    private Switch bpX;
    private View buA;
    private FlexLayout buB;
    private C0204b buC;
    private BdPageContext buD;
    private a buz;
    private View mContentView;

    /* loaded from: classes4.dex */
    public interface a {
        boolean NR();

        boolean Nh();

        int Nm();

        void QM();

        void b(int i, String str, ci ciVar);

        void onDismiss();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.buD = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.buz = aVar;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cG(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.buB != null && (layoutParams = b.this.buB.getLayoutParams()) != null) {
                        layoutParams.height = b.this.buB.realHeight;
                        b.this.buB.setLayoutParams(layoutParams);
                    }
                    b.this.JG();
                }
            });
        }
    }

    public void dX(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.buB != null && (layoutParams = this.buB.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.buB.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.bpW.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.buB != null && (layoutParams2 = b.this.buB.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.buB.realHeight;
                                b.this.buB.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.bpX != null && this.bpX.isChecked()) {
                this.bpW.setVisibility(0);
            }
        }
    }

    public void QN() {
        if (this.bpU != null) {
            this.bpU.f(z.Ii().Ik());
        }
    }

    private void init() {
        Ki();
        initView();
        HH();
    }

    private void Ki() {
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
        this.buA = findViewById(a.f.layout_barrage);
        this.bpX = (Switch) findViewById(a.f.switch_barrage);
        this.buB = (FlexLayout) findViewById(a.f.flex);
        this.bpW = (FrameLayout) findViewById(a.f.barrage_preview);
        this.bpV = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.buD);
        if (runTask != null) {
            this.bpU = (c) runTask.getData();
        }
        if (this.bpU != null) {
            this.bpV.addView(this.bpU.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.buD);
        if (runTask2 != null) {
            this.bpS = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bpS != null) {
            this.bpW.addView(this.bpS.getView());
        }
        this.bpX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.cn(z);
            }
        });
        if (this.bpU != null) {
            this.bpU.setSelectEnabled(false);
            this.bpU.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean NR() {
                    return b.this.buz != null && b.this.buz.NR();
                }

                @Override // com.baidu.live.im.b.e
                public void fd(int i) {
                    b.this.co(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Nm() {
                    if (b.this.buz != null) {
                        return b.this.buz.Nm();
                    }
                    return 0;
                }
            });
        }
        this.buB.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.buB.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.buB.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                ci ciVar;
                if (b.this.buz != null) {
                    if (b.this.buA.getVisibility() == 0 && b.this.bpX.isChecked() && b.this.bpU != null) {
                        ci selectInfo = b.this.bpU.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.buz == null || !b.this.buz.NR())) {
                            BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aSI > b.this.buz.Nm()) {
                            if (selectInfo.aSI == 7) {
                                BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            ciVar = selectInfo;
                        }
                    } else {
                        ciVar = null;
                    }
                    b.this.buz.b(i, b.this.buC.getItem(i), ciVar);
                }
            }
        });
    }

    private void HH() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.buz != null) {
                    b.this.buz.QM();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bpS != null) {
                    b.this.bpS.release();
                }
                if (b.this.buz != null) {
                    b.this.buz.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (z && this.buz != null && !this.buz.Nh()) {
            this.bpX.setChecked(false, false);
        } else if (this.bpU != null) {
            if (z) {
                this.bpU.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.NK().NO())) {
                    this.bpU.setSelectId(d.NK().NO());
                } else {
                    this.bpU.setSelectPos(0);
                }
                this.bpU.setSelectEnabled(true);
                co(true);
                return;
            }
            this.bpU.setSwitchStatus(false);
            this.bpU.setSelectEnabled(false);
            this.bpW.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(boolean z) {
        if (z && this.bpS != null) {
            this.bpS.setPreview();
        }
        if (this.bpS != null && this.bpU != null) {
            this.bpS.setUIInfo(this.bpU.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bpW.setVisibility(4);
        } else if (this.bpX != null && this.bpX.isChecked()) {
            this.bpW.setVisibility(0);
        }
    }

    private void cG(boolean z) {
        final ci[] e = d.NK().e(this.buz != null && this.buz.NR(), this.buz != null ? this.buz.Nm() : 0);
        if (e == null || z) {
            if (this.bpX.isChecked()) {
                this.bpX.setChecked(false, false);
            } else {
                cn(false);
            }
            this.buA.setVisibility(8);
            return;
        }
        this.buA.setVisibility(0);
        if (this.bpU != null) {
            this.bpU.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bpU != null) {
                        b.this.bpU.setData(e, z.Ii().Ik(), 1);
                        if (d.NK().NN()) {
                            if (b.this.bpX.isChecked()) {
                                b.this.bpU.setSelectId(d.NK().NO());
                                b.this.co(true);
                                return;
                            }
                            b.this.bpX.setChecked(true, false);
                        } else if (b.this.bpX.isChecked()) {
                            b.this.bpX.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.buC == null) {
            this.buC = new C0204b(strArr);
            this.buB.setAdapter(this.buC);
            return;
        }
        this.buC.setDatas(strArr);
        this.buC.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0204b extends FlexAdapter<String> {
        C0204b(String[] strArr) {
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
