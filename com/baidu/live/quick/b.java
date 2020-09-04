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
    private com.baidu.live.im.b.b bda;
    private c bdc;
    private FrameLayout bdd;
    private FrameLayout bde;
    private Switch bdf;
    private a bhh;
    private View bhi;
    private FlexLayout bhj;
    private C0184b bhk;
    private BdPageContext bhl;
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
        this.bhl = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bhh = aVar;
    }

    public void a(String[] strArr, boolean z) {
        m(strArr);
        cj(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.bhj != null && (layoutParams = b.this.bhj.getLayoutParams()) != null) {
                        layoutParams.height = b.this.bhj.realHeight;
                        b.this.bhj.setLayoutParams(layoutParams);
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
            if (this.bhj != null && (layoutParams = this.bhj.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.bhj.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.bde.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.bhj != null && (layoutParams2 = b.this.bhj.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.bhj.realHeight;
                                b.this.bhj.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.bdf != null && this.bdf.isChecked()) {
                this.bde.setVisibility(0);
            }
        }
    }

    public void Ms() {
        if (this.bdc != null) {
            this.bdc.f(t.EQ().ES());
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
        this.bhi = findViewById(a.g.layout_barrage);
        this.bdf = (Switch) findViewById(a.g.switch_barrage);
        this.bhj = (FlexLayout) findViewById(a.g.flex);
        this.bde = (FrameLayout) findViewById(a.g.barrage_preview);
        this.bdd = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bhl);
        if (runTask != null) {
            this.bdc = (c) runTask.getData();
        }
        if (this.bdc != null) {
            this.bdd.addView(this.bdc.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bhl);
        if (runTask2 != null) {
            this.bda = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bda != null) {
            this.bde.addView(this.bda.getView());
        }
        this.bdf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.bT(z);
            }
        });
        if (this.bdc != null) {
            this.bdc.setSelectEnabled(false);
            this.bdc.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean JJ() {
                    return b.this.bhh != null && b.this.bhh.JJ();
                }

                @Override // com.baidu.live.im.b.e
                public void dY(int i) {
                    b.this.bU(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Jn() {
                    if (b.this.bhh != null) {
                        return b.this.bhh.Jn();
                    }
                    return 0;
                }
            });
        }
        this.bhj.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.bhj.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.bhj.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                br brVar;
                if (b.this.bhh != null) {
                    if (b.this.bhi.getVisibility() == 0 && b.this.bdf.isChecked() && b.this.bdc != null) {
                        br selectInfo = b.this.bdc.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bhh == null || !b.this.bhh.JJ())) {
                            BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aKT > b.this.bhh.Jn()) {
                            if (selectInfo.aKT == 7) {
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
                    b.this.bhh.b(i, b.this.bhk.getItem(i), brVar);
                }
            }
        });
    }

    private void Ey() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bhh != null) {
                    b.this.bhh.Mr();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bda != null) {
                    b.this.bda.release();
                }
                if (b.this.bhh != null) {
                    b.this.bhh.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(boolean z) {
        if (z && this.bhh != null && !this.bhh.Ji()) {
            this.bdf.setChecked(false, false);
        } else if (this.bdc != null) {
            if (z) {
                this.bdc.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.JD().JG())) {
                    this.bdc.setSelectId(d.JD().JG());
                } else {
                    this.bdc.setSelectPos(0);
                }
                this.bdc.setSelectEnabled(true);
                bU(true);
                return;
            }
            this.bdc.setSwitchStatus(false);
            this.bdc.setSelectEnabled(false);
            this.bde.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(boolean z) {
        if (z && this.bda != null) {
            this.bda.setPreview();
        }
        if (this.bda != null && this.bdc != null) {
            this.bda.setUIInfo(this.bdc.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bde.setVisibility(4);
        } else if (this.bdf != null && this.bdf.isChecked()) {
            this.bde.setVisibility(0);
        }
    }

    private void cj(boolean z) {
        final br[] e = d.JD().e(this.bhh != null && this.bhh.JJ(), this.bhh != null ? this.bhh.Jn() : 0);
        if (e == null || z) {
            if (this.bdf.isChecked()) {
                this.bdf.setChecked(false, false);
            } else {
                bT(false);
            }
            this.bhi.setVisibility(8);
            return;
        }
        this.bhi.setVisibility(0);
        if (this.bdc != null) {
            this.bdc.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bdc != null) {
                        b.this.bdc.setData(e, t.EQ().ES(), 1);
                        if (d.JD().JF()) {
                            if (b.this.bdf.isChecked()) {
                                b.this.bdc.setSelectId(d.JD().JG());
                                b.this.bU(true);
                                return;
                            }
                            b.this.bdf.setChecked(true, false);
                        } else if (b.this.bdf.isChecked()) {
                            b.this.bdf.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void m(String[] strArr) {
        if (this.bhk == null) {
            this.bhk = new C0184b(strArr);
            this.bhj.setAdapter(this.bhk);
            return;
        }
        this.bhk.setDatas(strArr);
        this.bhk.notifyDataSetChanged();
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
