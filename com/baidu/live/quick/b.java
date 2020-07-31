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
import com.baidu.live.data.bp;
import com.baidu.live.gift.t;
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
    private com.baidu.live.im.b.b aXI;
    private c aXK;
    private FrameLayout aXL;
    private FrameLayout aXM;
    private Switch aXN;
    private a bbG;
    private View bbH;
    private FlexLayout bbI;
    private C0176b bbJ;
    private BdPageContext bbK;
    private View mContentView;

    /* loaded from: classes4.dex */
    public interface a {
        boolean DF();

        int DK();

        boolean Eg();

        void GF();

        void b(int i, String str, bp bpVar);

        void onDismiss();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.j.sdk_TransparentDialog);
        this.bbK = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bbG = aVar;
    }

    public void a(String[] strArr, boolean z) {
        m(strArr);
        ca(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.bbI != null && (layoutParams = b.this.bbI.getLayoutParams()) != null) {
                        layoutParams.height = b.this.bbI.realHeight;
                        b.this.bbI.setLayoutParams(layoutParams);
                    }
                    b.this.AD();
                }
            });
        }
    }

    public void bN(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.bbI != null && (layoutParams = this.bbI.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.bbI.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.aXM.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.bbI != null && (layoutParams2 = b.this.bbI.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.bbI.realHeight;
                                b.this.bbI.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.aXN != null && this.aXN.isChecked()) {
                this.aXM.setVisibility(0);
            }
        }
    }

    public void GG() {
        if (this.aXK != null) {
            this.aXK.f(t.zn().zp());
        }
    }

    private void init() {
        GH();
        initView();
        yV();
    }

    private void GH() {
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
        this.bbH = findViewById(a.g.layout_barrage);
        this.aXN = (Switch) findViewById(a.g.switch_barrage);
        this.bbI = (FlexLayout) findViewById(a.g.flex);
        this.aXM = (FrameLayout) findViewById(a.g.barrage_preview);
        this.aXL = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bbK);
        if (runTask != null) {
            this.aXK = (c) runTask.getData();
        }
        if (this.aXK != null) {
            this.aXL.addView(this.aXK.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bbK);
        if (runTask2 != null) {
            this.aXI = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.aXI != null) {
            this.aXM.addView(this.aXI.getView());
        }
        this.aXN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.bN(z);
            }
        });
        if (this.aXK != null) {
            this.aXK.setSelectEnabled(false);
            this.aXK.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean Eg() {
                    return b.this.bbG != null && b.this.bbG.Eg();
                }

                @Override // com.baidu.live.im.b.e
                public void cj(int i) {
                    b.this.bO(false);
                }

                @Override // com.baidu.live.im.b.e
                public int DK() {
                    if (b.this.bbG != null) {
                        return b.this.bbG.DK();
                    }
                    return 0;
                }
            });
        }
        this.bbI.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.bbI.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.bbI.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                bp bpVar;
                if (b.this.bbG != null) {
                    if (b.this.bbH.getVisibility() == 0 && b.this.aXN.isChecked() && b.this.aXK != null) {
                        bp selectInfo = b.this.aXK.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bbG == null || !b.this.bbG.Eg())) {
                            BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aFH > b.this.bbG.DK()) {
                            if (selectInfo.aFH == 7) {
                                BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            bpVar = selectInfo;
                        }
                    } else {
                        bpVar = null;
                    }
                    b.this.bbG.b(i, b.this.bbJ.getItem(i), bpVar);
                }
            }
        });
    }

    private void yV() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bbG != null) {
                    b.this.bbG.GF();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.aXI != null) {
                    b.this.aXI.release();
                }
                if (b.this.bbG != null) {
                    b.this.bbG.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (z && this.bbG != null && !this.bbG.DF()) {
            this.aXN.setChecked(false, false);
        } else if (this.aXK != null) {
            if (z) {
                this.aXK.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Ea().Ed())) {
                    this.aXK.setSelectId(d.Ea().Ed());
                } else {
                    this.aXK.setSelectPos(0);
                }
                this.aXK.setSelectEnabled(true);
                bO(true);
                return;
            }
            this.aXK.setSwitchStatus(false);
            this.aXK.setSelectEnabled(false);
            this.aXM.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(boolean z) {
        if (z && this.aXI != null) {
            this.aXI.setPreview();
        }
        if (this.aXI != null && this.aXK != null) {
            this.aXI.setUIInfo(this.aXK.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aXM.setVisibility(4);
        } else if (this.aXN != null && this.aXN.isChecked()) {
            this.aXM.setVisibility(0);
        }
    }

    private void ca(boolean z) {
        final bp[] e = d.Ea().e(this.bbG != null && this.bbG.Eg(), this.bbG != null ? this.bbG.DK() : 0);
        if (e == null || z) {
            if (this.aXN.isChecked()) {
                this.aXN.setChecked(false, false);
            } else {
                bN(false);
            }
            this.bbH.setVisibility(8);
            return;
        }
        this.bbH.setVisibility(0);
        if (this.aXK != null) {
            this.aXK.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.aXK != null) {
                        b.this.aXK.setData(e, t.zn().zp(), 1);
                        if (d.Ea().Ec()) {
                            if (b.this.aXN.isChecked()) {
                                b.this.aXK.setSelectId(d.Ea().Ed());
                                b.this.bO(true);
                                return;
                            }
                            b.this.aXN.setChecked(true, false);
                        } else if (b.this.aXN.isChecked()) {
                            b.this.aXN.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void m(String[] strArr) {
        if (this.bbJ == null) {
            this.bbJ = new C0176b(strArr);
            this.bbI.setAdapter(this.bbJ);
            return;
        }
        this.bbJ.setDatas(strArr);
        this.bbJ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AD() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0176b extends FlexAdapter<String> {
        C0176b(String[] strArr) {
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
