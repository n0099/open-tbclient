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
    private com.baidu.live.im.b.b bfP;
    private c bfR;
    private FrameLayout bfS;
    private FrameLayout bfT;
    private Switch bfU;
    private a bkg;
    private View bkh;
    private FlexLayout bki;
    private C0185b bkj;
    private BdPageContext bkk;
    private View mContentView;

    /* loaded from: classes4.dex */
    public interface a {
        boolean JM();

        int JR();

        boolean Kn();

        void MZ();

        void b(int i, String str, bz bzVar);

        void onDismiss();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.j.sdk_TransparentDialog);
        this.bkk = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bkg = aVar;
    }

    public void a(String[] strArr, boolean z) {
        m(strArr);
        ck(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.bki != null && (layoutParams = b.this.bki.getLayoutParams()) != null) {
                        layoutParams.height = b.this.bki.realHeight;
                        b.this.bki.setLayoutParams(layoutParams);
                    }
                    b.this.GG();
                }
            });
        }
    }

    public void dD(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.bki != null && (layoutParams = this.bki.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.bki.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.bfT.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.bki != null && (layoutParams2 = b.this.bki.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.bki.realHeight;
                                b.this.bki.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.bfU != null && this.bfU.isChecked()) {
                this.bfT.setVisibility(0);
            }
        }
    }

    public void Na() {
        if (this.bfR != null) {
            this.bfR.f(u.Fk().Fm());
        }
    }

    private void init() {
        Nb();
        initView();
        EP();
    }

    private void Nb() {
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
        this.bkh = findViewById(a.g.layout_barrage);
        this.bfU = (Switch) findViewById(a.g.switch_barrage);
        this.bki = (FlexLayout) findViewById(a.g.flex);
        this.bfT = (FrameLayout) findViewById(a.g.barrage_preview);
        this.bfS = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bkk);
        if (runTask != null) {
            this.bfR = (c) runTask.getData();
        }
        if (this.bfR != null) {
            this.bfS.addView(this.bfR.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bkk);
        if (runTask2 != null) {
            this.bfP = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bfP != null) {
            this.bfT.addView(this.bfP.getView());
        }
        this.bfU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.bV(z);
            }
        });
        if (this.bfR != null) {
            this.bfR.setSelectEnabled(false);
            this.bfR.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean Kn() {
                    return b.this.bkg != null && b.this.bkg.Kn();
                }

                @Override // com.baidu.live.im.b.e
                public void ec(int i) {
                    b.this.bW(false);
                }

                @Override // com.baidu.live.im.b.e
                public int JR() {
                    if (b.this.bkg != null) {
                        return b.this.bkg.JR();
                    }
                    return 0;
                }
            });
        }
        this.bki.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.bki.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.bki.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                bz bzVar;
                if (b.this.bkg != null) {
                    if (b.this.bkh.getVisibility() == 0 && b.this.bfU.isChecked() && b.this.bfR != null) {
                        bz selectInfo = b.this.bfR.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bkg == null || !b.this.bkg.Kn())) {
                            BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aMA > b.this.bkg.JR()) {
                            if (selectInfo.aMA == 7) {
                                BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            bzVar = selectInfo;
                        }
                    } else {
                        bzVar = null;
                    }
                    b.this.bkg.b(i, b.this.bkj.getItem(i), bzVar);
                }
            }
        });
    }

    private void EP() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bkg != null) {
                    b.this.bkg.MZ();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bfP != null) {
                    b.this.bfP.release();
                }
                if (b.this.bkg != null) {
                    b.this.bkg.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(boolean z) {
        if (z && this.bkg != null && !this.bkg.JM()) {
            this.bfU.setChecked(false, false);
        } else if (this.bfR != null) {
            if (z) {
                this.bfR.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Kh().Kk())) {
                    this.bfR.setSelectId(d.Kh().Kk());
                } else {
                    this.bfR.setSelectPos(0);
                }
                this.bfR.setSelectEnabled(true);
                bW(true);
                return;
            }
            this.bfR.setSwitchStatus(false);
            this.bfR.setSelectEnabled(false);
            this.bfT.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(boolean z) {
        if (z && this.bfP != null) {
            this.bfP.setPreview();
        }
        if (this.bfP != null && this.bfR != null) {
            this.bfP.setUIInfo(this.bfR.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bfT.setVisibility(4);
        } else if (this.bfU != null && this.bfU.isChecked()) {
            this.bfT.setVisibility(0);
        }
    }

    private void ck(boolean z) {
        final bz[] e = d.Kh().e(this.bkg != null && this.bkg.Kn(), this.bkg != null ? this.bkg.JR() : 0);
        if (e == null || z) {
            if (this.bfU.isChecked()) {
                this.bfU.setChecked(false, false);
            } else {
                bV(false);
            }
            this.bkh.setVisibility(8);
            return;
        }
        this.bkh.setVisibility(0);
        if (this.bfR != null) {
            this.bfR.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bfR != null) {
                        b.this.bfR.setData(e, u.Fk().Fm(), 1);
                        if (d.Kh().Kj()) {
                            if (b.this.bfU.isChecked()) {
                                b.this.bfR.setSelectId(d.Kh().Kk());
                                b.this.bW(true);
                                return;
                            }
                            b.this.bfU.setChecked(true, false);
                        } else if (b.this.bfU.isChecked()) {
                            b.this.bfU.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void m(String[] strArr) {
        if (this.bkj == null) {
            this.bkj = new C0185b(strArr);
            this.bki.setAdapter(this.bkj);
            return;
        }
        this.bkj.setDatas(strArr);
        this.bkj.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0185b extends FlexAdapter<String> {
        C0185b(String[] strArr) {
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
