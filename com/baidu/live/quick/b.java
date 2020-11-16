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
import com.baidu.live.data.cg;
import com.baidu.live.gift.y;
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
    private com.baidu.live.im.b.b bkJ;
    private c bkL;
    private FrameLayout bkM;
    private FrameLayout bkN;
    private Switch bkO;
    private a bpo;
    private View bpp;
    private FlexLayout bpq;
    private C0194b bpr;
    private BdPageContext bps;
    private View mContentView;

    /* loaded from: classes4.dex */
    public interface a {
        boolean LE();

        boolean Ld();

        int Li();

        void Ot();

        void b(int i, String str, cg cgVar);

        void onDismiss();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.bps = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bpo = aVar;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cs(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.bpq != null && (layoutParams = b.this.bpq.getLayoutParams()) != null) {
                        layoutParams.height = b.this.bpq.realHeight;
                        b.this.bpq.setLayoutParams(layoutParams);
                    }
                    b.this.HP();
                }
            });
        }
    }

    public void dE(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.bpq != null && (layoutParams = this.bpq.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.bpq.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.bkN.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.bpq != null && (layoutParams2 = b.this.bpq.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.bpq.realHeight;
                                b.this.bpq.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.bkO != null && this.bkO.isChecked()) {
                this.bkN.setVisibility(0);
            }
        }
    }

    public void Ou() {
        if (this.bkL != null) {
            this.bkL.f(y.Gt().Gv());
        }
    }

    private void init() {
        Ov();
        initView();
        FS();
    }

    private void Ov() {
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
        this.bpp = findViewById(a.f.layout_barrage);
        this.bkO = (Switch) findViewById(a.f.switch_barrage);
        this.bpq = (FlexLayout) findViewById(a.f.flex);
        this.bkN = (FrameLayout) findViewById(a.f.barrage_preview);
        this.bkM = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bps);
        if (runTask != null) {
            this.bkL = (c) runTask.getData();
        }
        if (this.bkL != null) {
            this.bkM.addView(this.bkL.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bps);
        if (runTask2 != null) {
            this.bkJ = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bkJ != null) {
            this.bkN.addView(this.bkJ.getView());
        }
        this.bkO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.cd(z);
            }
        });
        if (this.bkL != null) {
            this.bkL.setSelectEnabled(false);
            this.bkL.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean LE() {
                    return b.this.bpo != null && b.this.bpo.LE();
                }

                @Override // com.baidu.live.im.b.e
                public void ee(int i) {
                    b.this.ce(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Li() {
                    if (b.this.bpo != null) {
                        return b.this.bpo.Li();
                    }
                    return 0;
                }
            });
        }
        this.bpq.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.bpq.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.bpq.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                cg cgVar;
                if (b.this.bpo != null) {
                    if (b.this.bpp.getVisibility() == 0 && b.this.bkO.isChecked() && b.this.bkL != null) {
                        cg selectInfo = b.this.bkL.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bpo == null || !b.this.bpo.LE())) {
                            BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aPG > b.this.bpo.Li()) {
                            if (selectInfo.aPG == 7) {
                                BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            cgVar = selectInfo;
                        }
                    } else {
                        cgVar = null;
                    }
                    b.this.bpo.b(i, b.this.bpr.getItem(i), cgVar);
                }
            }
        });
    }

    private void FS() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bpo != null) {
                    b.this.bpo.Ot();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bkJ != null) {
                    b.this.bkJ.release();
                }
                if (b.this.bpo != null) {
                    b.this.bpo.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(boolean z) {
        if (z && this.bpo != null && !this.bpo.Ld()) {
            this.bkO.setChecked(false, false);
        } else if (this.bkL != null) {
            if (z) {
                this.bkL.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Lx().LB())) {
                    this.bkL.setSelectId(d.Lx().LB());
                } else {
                    this.bkL.setSelectPos(0);
                }
                this.bkL.setSelectEnabled(true);
                ce(true);
                return;
            }
            this.bkL.setSwitchStatus(false);
            this.bkL.setSelectEnabled(false);
            this.bkN.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(boolean z) {
        if (z && this.bkJ != null) {
            this.bkJ.setPreview();
        }
        if (this.bkJ != null && this.bkL != null) {
            this.bkJ.setUIInfo(this.bkL.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bkN.setVisibility(4);
        } else if (this.bkO != null && this.bkO.isChecked()) {
            this.bkN.setVisibility(0);
        }
    }

    private void cs(boolean z) {
        final cg[] e = d.Lx().e(this.bpo != null && this.bpo.LE(), this.bpo != null ? this.bpo.Li() : 0);
        if (e == null || z) {
            if (this.bkO.isChecked()) {
                this.bkO.setChecked(false, false);
            } else {
                cd(false);
            }
            this.bpp.setVisibility(8);
            return;
        }
        this.bpp.setVisibility(0);
        if (this.bkL != null) {
            this.bkL.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bkL != null) {
                        b.this.bkL.setData(e, y.Gt().Gv(), 1);
                        if (d.Lx().LA()) {
                            if (b.this.bkO.isChecked()) {
                                b.this.bkL.setSelectId(d.Lx().LB());
                                b.this.ce(true);
                                return;
                            }
                            b.this.bkO.setChecked(true, false);
                        } else if (b.this.bkO.isChecked()) {
                            b.this.bkO.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.bpr == null) {
            this.bpr = new C0194b(strArr);
            this.bpq.setAdapter(this.bpr);
            return;
        }
        this.bpr.setDatas(strArr);
        this.bpr.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HP() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0194b extends FlexAdapter<String> {
        C0194b(String[] strArr) {
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
