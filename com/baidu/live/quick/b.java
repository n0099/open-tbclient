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
import com.baidu.live.data.bz;
import com.baidu.live.gift.u;
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
    private com.baidu.live.im.b.b bjF;
    private c bjH;
    private FrameLayout bjI;
    private FrameLayout bjJ;
    private Switch bjK;
    private a bnT;
    private View bnU;
    private FlexLayout bnV;
    private C0193b bnW;
    private BdPageContext bnX;
    private View mContentView;

    /* loaded from: classes4.dex */
    public interface a {
        boolean KS();

        int KX();

        boolean Ls();

        void Oe();

        void b(int i, String str, bz bzVar);

        void onDismiss();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.j.sdk_TransparentDialog);
        this.bnX = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bnT = aVar;
    }

    public void a(String[] strArr, boolean z) {
        m(strArr);
        cn(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.bnV != null && (layoutParams = b.this.bnV.getLayoutParams()) != null) {
                        layoutParams.height = b.this.bnV.realHeight;
                        b.this.bnV.setLayoutParams(layoutParams);
                    }
                    b.this.HC();
                }
            });
        }
    }

    public void dI(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.bnV != null && (layoutParams = this.bnV.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.bnV.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.bjJ.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.bnV != null && (layoutParams2 = b.this.bnV.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.bnV.realHeight;
                                b.this.bnV.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.bjK != null && this.bjK.isChecked()) {
                this.bjJ.setVisibility(0);
            }
        }
    }

    public void Of() {
        if (this.bjH != null) {
            this.bjH.f(u.Gg().Gi());
        }
    }

    private void init() {
        Og();
        initView();
        FL();
    }

    private void Og() {
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
        this.bnU = findViewById(a.g.layout_barrage);
        this.bjK = (Switch) findViewById(a.g.switch_barrage);
        this.bnV = (FlexLayout) findViewById(a.g.flex);
        this.bjJ = (FrameLayout) findViewById(a.g.barrage_preview);
        this.bjI = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bnX);
        if (runTask != null) {
            this.bjH = (c) runTask.getData();
        }
        if (this.bjH != null) {
            this.bjI.addView(this.bjH.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bnX);
        if (runTask2 != null) {
            this.bjF = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bjF != null) {
            this.bjJ.addView(this.bjF.getView());
        }
        this.bjK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.bY(z);
            }
        });
        if (this.bjH != null) {
            this.bjH.setSelectEnabled(false);
            this.bjH.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean Ls() {
                    return b.this.bnT != null && b.this.bnT.Ls();
                }

                @Override // com.baidu.live.im.b.e
                public void eh(int i) {
                    b.this.bZ(false);
                }

                @Override // com.baidu.live.im.b.e
                public int KX() {
                    if (b.this.bnT != null) {
                        return b.this.bnT.KX();
                    }
                    return 0;
                }
            });
        }
        this.bnV.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.bnV.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.bnV.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                bz bzVar;
                if (b.this.bnT != null) {
                    if (b.this.bnU.getVisibility() == 0 && b.this.bjK.isChecked() && b.this.bjH != null) {
                        bz selectInfo = b.this.bjH.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bnT == null || !b.this.bnT.Ls())) {
                            BdUtilHelper.showToast(b.this.getContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aPF > b.this.bnT.KX()) {
                            if (selectInfo.aPF == 7) {
                                BdUtilHelper.showToast(b.this.getContext(), a.i.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(b.this.getContext(), a.i.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            bzVar = selectInfo;
                        }
                    } else {
                        bzVar = null;
                    }
                    b.this.bnT.b(i, b.this.bnW.getItem(i), bzVar);
                }
            }
        });
    }

    private void FL() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bnT != null) {
                    b.this.bnT.Oe();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bjF != null) {
                    b.this.bjF.release();
                }
                if (b.this.bnT != null) {
                    b.this.bnT.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(boolean z) {
        if (z && this.bnT != null && !this.bnT.KS()) {
            this.bjK.setChecked(false, false);
        } else if (this.bjH != null) {
            if (z) {
                this.bjH.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Lm().Lp())) {
                    this.bjH.setSelectId(d.Lm().Lp());
                } else {
                    this.bjH.setSelectPos(0);
                }
                this.bjH.setSelectEnabled(true);
                bZ(true);
                return;
            }
            this.bjH.setSwitchStatus(false);
            this.bjH.setSelectEnabled(false);
            this.bjJ.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(boolean z) {
        if (z && this.bjF != null) {
            this.bjF.setPreview();
        }
        if (this.bjF != null && this.bjH != null) {
            this.bjF.setUIInfo(this.bjH.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bjJ.setVisibility(4);
        } else if (this.bjK != null && this.bjK.isChecked()) {
            this.bjJ.setVisibility(0);
        }
    }

    private void cn(boolean z) {
        final bz[] e = d.Lm().e(this.bnT != null && this.bnT.Ls(), this.bnT != null ? this.bnT.KX() : 0);
        if (e == null || z) {
            if (this.bjK.isChecked()) {
                this.bjK.setChecked(false, false);
            } else {
                bY(false);
            }
            this.bnU.setVisibility(8);
            return;
        }
        this.bnU.setVisibility(0);
        if (this.bjH != null) {
            this.bjH.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bjH != null) {
                        b.this.bjH.setData(e, u.Gg().Gi(), 1);
                        if (d.Lm().Lo()) {
                            if (b.this.bjK.isChecked()) {
                                b.this.bjH.setSelectId(d.Lm().Lp());
                                b.this.bZ(true);
                                return;
                            }
                            b.this.bjK.setChecked(true, false);
                        } else if (b.this.bjK.isChecked()) {
                            b.this.bjK.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void m(String[] strArr) {
        if (this.bnW == null) {
            this.bnW = new C0193b(strArr);
            this.bnV.setAdapter(this.bnW);
            return;
        }
        this.bnW.setDatas(strArr);
        this.bnW.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
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
