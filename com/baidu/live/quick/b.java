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
import com.baidu.live.data.br;
import com.baidu.live.gift.t;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.view.Switch;
/* loaded from: classes7.dex */
public class b extends Dialog {
    private com.baidu.live.im.b.b bcY;
    private c bda;
    private FrameLayout bdb;
    private FrameLayout bdc;
    private Switch bdd;
    private a bhe;
    private View bhf;
    private FlexLayout bhg;
    private C0184b bhh;
    private BdPageContext bhi;
    private View mContentView;

    /* loaded from: classes7.dex */
    public interface a {
        boolean JJ();

        boolean Ji();

        int Jn();

        void Mr();

        void b(int i, String str, br brVar);

        void onDismiss();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.j.sdk_TransparentDialog);
        this.bhi = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bhe = aVar;
    }

    public void a(String[] strArr, boolean z) {
        m(strArr);
        ci(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.bhg != null && (layoutParams = b.this.bhg.getLayoutParams()) != null) {
                        layoutParams.height = b.this.bhg.realHeight;
                        b.this.bhg.setLayoutParams(layoutParams);
                    }
                    b.this.Gg();
                }
            });
        }
    }

    public void dz(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.bhg != null && (layoutParams = this.bhg.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.bhg.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.bdc.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.bhg != null && (layoutParams2 = b.this.bhg.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.bhg.realHeight;
                                b.this.bhg.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.bdd != null && this.bdd.isChecked()) {
                this.bdc.setVisibility(0);
            }
        }
    }

    public void Ms() {
        if (this.bda != null) {
            this.bda.f(t.EQ().ES());
        }
    }

    private void init() {
        Mt();
        initView();
        Ey();
    }

    private void Mt() {
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
        this.bhf = findViewById(a.g.layout_barrage);
        this.bdd = (Switch) findViewById(a.g.switch_barrage);
        this.bhg = (FlexLayout) findViewById(a.g.flex);
        this.bdc = (FrameLayout) findViewById(a.g.barrage_preview);
        this.bdb = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bhi);
        if (runTask != null) {
            this.bda = (c) runTask.getData();
        }
        if (this.bda != null) {
            this.bdb.addView(this.bda.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bhi);
        if (runTask2 != null) {
            this.bcY = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bcY != null) {
            this.bdc.addView(this.bcY.getView());
        }
        this.bdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.bT(z);
            }
        });
        if (this.bda != null) {
            this.bda.setSelectEnabled(false);
            this.bda.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean JJ() {
                    return b.this.bhe != null && b.this.bhe.JJ();
                }

                @Override // com.baidu.live.im.b.e
                public void dY(int i) {
                    b.this.bU(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Jn() {
                    if (b.this.bhe != null) {
                        return b.this.bhe.Jn();
                    }
                    return 0;
                }
            });
        }
        this.bhg.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.bhg.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.bhg.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                br brVar;
                if (b.this.bhe != null) {
                    if (b.this.bhf.getVisibility() == 0 && b.this.bdd.isChecked() && b.this.bda != null) {
                        br selectInfo = b.this.bda.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bhe == null || !b.this.bhe.JJ())) {
                            BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aKR > b.this.bhe.Jn()) {
                            if (selectInfo.aKR == 7) {
                                BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            brVar = selectInfo;
                        }
                    } else {
                        brVar = null;
                    }
                    b.this.bhe.b(i, b.this.bhh.getItem(i), brVar);
                }
            }
        });
    }

    private void Ey() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bhe != null) {
                    b.this.bhe.Mr();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bcY != null) {
                    b.this.bcY.release();
                }
                if (b.this.bhe != null) {
                    b.this.bhe.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(boolean z) {
        if (z && this.bhe != null && !this.bhe.Ji()) {
            this.bdd.setChecked(false, false);
        } else if (this.bda != null) {
            if (z) {
                this.bda.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.JD().JG())) {
                    this.bda.setSelectId(d.JD().JG());
                } else {
                    this.bda.setSelectPos(0);
                }
                this.bda.setSelectEnabled(true);
                bU(true);
                return;
            }
            this.bda.setSwitchStatus(false);
            this.bda.setSelectEnabled(false);
            this.bdc.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(boolean z) {
        if (z && this.bcY != null) {
            this.bcY.setPreview();
        }
        if (this.bcY != null && this.bda != null) {
            this.bcY.setUIInfo(this.bda.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bdc.setVisibility(4);
        } else if (this.bdd != null && this.bdd.isChecked()) {
            this.bdc.setVisibility(0);
        }
    }

    private void ci(boolean z) {
        final br[] e = d.JD().e(this.bhe != null && this.bhe.JJ(), this.bhe != null ? this.bhe.Jn() : 0);
        if (e == null || z) {
            if (this.bdd.isChecked()) {
                this.bdd.setChecked(false, false);
            } else {
                bT(false);
            }
            this.bhf.setVisibility(8);
            return;
        }
        this.bhf.setVisibility(0);
        if (this.bda != null) {
            this.bda.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bda != null) {
                        b.this.bda.setData(e, t.EQ().ES(), 1);
                        if (d.JD().JF()) {
                            if (b.this.bdd.isChecked()) {
                                b.this.bda.setSelectId(d.JD().JG());
                                b.this.bU(true);
                                return;
                            }
                            b.this.bdd.setChecked(true, false);
                        } else if (b.this.bdd.isChecked()) {
                            b.this.bdd.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void m(String[] strArr) {
        if (this.bhh == null) {
            this.bhh = new C0184b(strArr);
            this.bhg.setAdapter(this.bhh);
            return;
        }
        this.bhh.setDatas(strArr);
        this.bhh.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gg() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0184b extends FlexAdapter<String> {
        C0184b(String[] strArr) {
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
