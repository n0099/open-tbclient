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
/* loaded from: classes11.dex */
public class a {
    private String bGA;
    private int bGG;
    private int bGH;
    private int bGI;
    private int bGJ;
    private View.OnClickListener bGM;
    private boolean bGN;
    private boolean bGz;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bGy = null;
    private int bGB = a.e.sdk_pic_sign_tip;
    private int bGC = 0;
    private int bGD = 1;
    private int bGE = 1000;
    private int bGF = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bGK = 48;
    private int bGL = 4;
    private boolean mUseDirectOffset = false;
    private Runnable bGO = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bGy == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.bGN || a.this.TA()) {
                    GuideBuilder guideBuilder = new GuideBuilder();
                    guideBuilder.setTargetView(a.this.mTargetView).setAlpha(0).setOverlayTarget(true).setOutsideTouchable(true);
                    guideBuilder.addComponent(new Component() { // from class: com.baidu.live.tieba.c.a.1.1
                        @Override // com.baidu.live.adp.lib.guide.Component
                        public View getView(LayoutInflater layoutInflater) {
                            TextView textView = new TextView(a.this.mPageContext.getPageActivity());
                            textView.setText(a.this.mMessage);
                            textView.setGravity(17);
                            SkinManager.setViewTextColor(textView, a.c.sdk_cp_cont_i);
                            textView.setTextSize(0, a.this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize28));
                            textView.setHeight(a.this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds76));
                            textView.setPadding(a.this.bGG, a.this.bGH, a.this.bGI, a.this.bGJ);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.bGB);
                            if (a.this.bGM != null) {
                                textView.setOnClickListener(a.this.bGM);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bGL;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.bGK;
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
                    a.this.bGy = guideBuilder.createGuide();
                    a.this.bGy.setShouldCheckLocInWindow(false);
                    a.this.bGy.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bGy.show(a.this.mPageContext.getPageActivity());
                    a.this.bGz = true;
                    a.this.Ty();
                    a.this.mHandler.postDelayed(a.this.bGP, a.this.bGF);
                }
            }
        }
    };
    private Runnable bGP = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bGy != null) {
                a.this.bGy.dismiss();
            }
        }
    };

    public void em(int i) {
        this.bGK = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.bGG = 0;
        this.bGH = 0;
        this.bGI = 0;
        this.bGJ = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bGG = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bGH = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bGI = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bGJ = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ty() {
        SharedPrefHelper.getInstance().putInt(this.bGA, this.bGC + 1);
    }

    public void aJ(String str, String str2) {
        i(str, str2, false);
    }

    public void i(String str, String str2, boolean z) {
        if (!this.bGz && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.bGA = str2;
            this.bGC = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bGC < this.bGD) {
                if (z) {
                    Ty();
                    this.bGz = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bGO, this.bGE);
            }
        }
    }

    public void Tz() {
        if (this.bGy != null) {
            this.bGy.dismiss();
            this.bGy = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bGO);
            this.mHandler.removeCallbacks(this.bGP);
        }
    }

    public void en(int i) {
        if (i > 0) {
            this.bGB = i;
        }
    }

    public void eo(int i) {
        if (i > 0) {
            this.bGF = i;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.bGM = onClickListener;
    }

    public boolean TA() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
