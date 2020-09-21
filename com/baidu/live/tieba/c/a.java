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
    private View.OnClickListener bnA;
    private boolean bnB;
    private boolean bnn;
    private String bno;
    private int bnu;
    private int bnv;
    private int bnw;
    private int bnx;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bnm = null;
    private int bnp = a.f.sdk_pic_sign_tip;
    private int bnq = 0;
    private int bnr = 1;
    private int bns = 1000;
    private int bnt = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bny = 48;
    private int bnz = 4;
    private boolean mUseDirectOffset = false;
    private Runnable bnC = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bnm == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.bnB || a.this.Ok()) {
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
                            textView.setPadding(a.this.bnu, a.this.bnv, a.this.bnw, a.this.bnx);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.bnp);
                            if (a.this.bnA != null) {
                                textView.setOnClickListener(a.this.bnA);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bnz;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.bny;
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
                    a.this.bnm = guideBuilder.createGuide();
                    a.this.bnm.setShouldCheckLocInWindow(false);
                    a.this.bnm.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bnm.show(a.this.mPageContext.getPageActivity());
                    a.this.bnn = true;
                    a.this.Oi();
                    a.this.mHandler.postDelayed(a.this.bnD, a.this.bnt);
                }
            }
        }
    };
    private Runnable bnD = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bnm != null) {
                a.this.bnm.dismiss();
            }
        }
    };

    public void eV(int i) {
        this.bny = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.bnu = 0;
        this.bnv = 0;
        this.bnw = 0;
        this.bnx = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bnu = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bnv = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bnw = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bnx = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oi() {
        SharedPrefHelper.getInstance().putInt(this.bno, this.bnq + 1);
    }

    public void aG(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bnn && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.bno = str2;
            this.bnq = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bnq < this.bnr) {
                if (z) {
                    Oi();
                    this.bnn = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bnC, this.bns);
            }
        }
    }

    public void Oj() {
        if (this.bnm != null) {
            this.bnm.dismiss();
            this.bnm = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bnC);
            this.mHandler.removeCallbacks(this.bnD);
        }
    }

    public void eW(int i) {
        if (i > 0) {
            this.bnp = i;
        }
    }

    public void eX(int i) {
        if (i > 0) {
            this.bnt = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.bnA = onClickListener;
    }

    public boolean Ok() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
