package com.baidu.live.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.lib.guide.Component;
import com.baidu.live.adp.lib.guide.Guide;
import com.baidu.live.adp.lib.guide.GuideBuilder;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes2.dex */
public class a {
    private boolean atC;
    private String atD;
    private int atJ;
    private int atK;
    private int atL;
    private int atM;
    private View.OnClickListener atP;
    private boolean atQ;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide atB = null;
    private int atE = a.f.sdk_pic_sign_tip;
    private int atF = 0;
    private int atG = 1;
    private int atH = 1000;
    private int atI = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int atN = 48;
    private int atO = 4;
    private boolean mUseDirectOffset = false;
    private Runnable atR = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.atB == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.atQ || a.this.xh()) {
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
                            textView.setPadding(a.this.atJ, a.this.atK, a.this.atL, a.this.atM);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.atE);
                            if (a.this.atP != null) {
                                textView.setOnClickListener(a.this.atP);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.atO;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.atN;
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
                    a.this.atB = guideBuilder.createGuide();
                    a.this.atB.setShouldCheckLocInWindow(false);
                    a.this.atB.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.atB.show(a.this.mPageContext.getPageActivity());
                    a.this.atC = true;
                    a.this.xf();
                    a.this.mHandler.postDelayed(a.this.atS, a.this.atI);
                }
            }
        }
    };
    private Runnable atS = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.atB != null) {
                a.this.atB.dismiss();
            }
        }
    };

    public void bT(int i) {
        this.atN = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.atJ = 0;
        this.atK = 0;
        this.atL = 0;
        this.atM = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.atJ = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.atK = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.atL = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.atM = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xf() {
        SharedPrefHelper.getInstance().putInt(this.atD, this.atF + 1);
    }

    public void Y(String str, String str2) {
        c(str, str2, false);
    }

    public void c(String str, String str2, boolean z) {
        if (!this.atC && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.atD = str2;
            this.atF = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.atF < this.atG) {
                if (z) {
                    xf();
                    this.atC = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.atR, this.atH);
            }
        }
    }

    public void xg() {
        if (this.atB != null) {
            this.atB.dismiss();
            this.atB = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.atR);
            this.mHandler.removeCallbacks(this.atS);
        }
    }

    public void bU(int i) {
        if (i > 0) {
            this.atE = i;
        }
    }

    public void bV(int i) {
        if (i > 0) {
            this.atI = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.atP = onClickListener;
    }

    public boolean xh() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
