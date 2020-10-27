package com.baidu.live.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.lib.guide.Component;
import com.baidu.live.adp.lib.guide.Guide;
import com.baidu.live.adp.lib.guide.GuideBuilder;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes4.dex */
public class a {
    private boolean btf;
    private String btg;
    private int btm;
    private int bto;
    private int btp;
    private int btq;
    private View.OnClickListener btt;
    private boolean btu;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bte = null;
    private int bth = a.f.sdk_pic_sign_tip;
    private int bti = 0;
    private int btj = 1;
    private int btk = 1000;
    private int btl = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int btr = 48;
    private int bts = 4;
    private boolean mUseDirectOffset = false;
    private Runnable btv = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bte == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.btu || a.this.Qi()) {
                    GuideBuilder guideBuilder = new GuideBuilder();
                    guideBuilder.setTargetView(a.this.mTargetView).setAlpha(0).setOverlayTarget(true).setOutsideTouchable(true);
                    guideBuilder.addComponent(new Component() { // from class: com.baidu.live.tieba.c.a.1.1
                        @Override // com.baidu.live.adp.lib.guide.Component
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(a.this.mPageContext.getPageActivity());
                            textView.setText(a.this.mMessage);
                            textView.setGravity(17);
                            SkinManager.setViewTextColor(textView, a.d.sdk_cp_cont_i);
                            textView.setTextSize(0, a.this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize28));
                            textView.setHeight(a.this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds76));
                            textView.setPadding(a.this.btm, a.this.bto, a.this.btp, a.this.btq);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.bth);
                            if (a.this.btt != null) {
                                textView.setOnClickListener(a.this.btt);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bts;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.btr;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getXOffset() {
                            return a.this.mXOffset;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getYOffset() {
                            return a.this.mYOffset;
                        }
                    });
                    a.this.bte = guideBuilder.createGuide();
                    a.this.bte.setShouldCheckLocInWindow(false);
                    a.this.bte.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bte.show(a.this.mPageContext.getPageActivity());
                    a.this.btf = true;
                    a.this.Qg();
                    a.this.mHandler.postDelayed(a.this.btw, a.this.btl);
                }
            }
        }
    };
    private Runnable btw = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bte != null) {
                a.this.bte.dismiss();
            }
        }
    };

    public void fg(int i) {
        this.btr = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.btm = 0;
        this.bto = 0;
        this.btp = 0;
        this.btq = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.btm = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bto = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.btp = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.btq = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qg() {
        SharedPrefHelper.getInstance().putInt(this.btg, this.bti + 1);
    }

    public void aL(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.btf && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.btg = str2;
            this.bti = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bti < this.btj) {
                if (z) {
                    Qg();
                    this.btf = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.btv, this.btk);
            }
        }
    }

    public void Qh() {
        if (this.bte != null) {
            this.bte.dismiss();
            this.bte = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.btv);
            this.mHandler.removeCallbacks(this.btw);
        }
    }

    public void fh(int i) {
        if (i > 0) {
            this.bth = i;
        }
    }

    public void fi(int i) {
        if (i > 0) {
            this.btl = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.btt = onClickListener;
    }

    public boolean Qi() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
