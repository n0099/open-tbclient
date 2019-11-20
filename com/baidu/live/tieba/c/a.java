package com.baidu.live.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.lib.guide.Component;
import com.baidu.live.adp.lib.guide.Guide;
import com.baidu.live.adp.lib.guide.GuideBuilder;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes6.dex */
public class a {
    private boolean akM;
    private String akN;
    private int akT;
    private int akU;
    private int akV;
    private int akW;
    private View.OnClickListener akZ;
    private boolean ala;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide akL = null;
    private int akO = a.f.sdk_pic_sign_tip;
    private int akP = 0;
    private int akQ = 1;
    private int akR = 1000;
    private int akS = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int akX = 48;
    private int akY = 4;
    private boolean mUseDirectOffset = false;
    private Runnable alb = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.akL == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.ala || a.this.uR()) {
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
                            textView.setPadding(a.this.akT, a.this.akU, a.this.akV, a.this.akW);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.akO);
                            if (a.this.akZ != null) {
                                textView.setOnClickListener(a.this.akZ);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.akY;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.akX;
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
                    a.this.akL = guideBuilder.createGuide();
                    a.this.akL.setShouldCheckLocInWindow(false);
                    a.this.akL.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.akL.show(a.this.mPageContext.getPageActivity());
                    a.this.akM = true;
                    a.this.uP();
                    a.this.mHandler.postDelayed(a.this.alc, a.this.akS);
                }
            }
        }
    };
    private Runnable alc = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.akL != null) {
                a.this.akL.dismiss();
            }
        }
    };

    public void bA(int i) {
        this.akX = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.akT = 0;
        this.akU = 0;
        this.akV = 0;
        this.akW = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.akT = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.akU = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.akV = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.akW = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP() {
        SharedPrefHelper.getInstance().putInt(this.akN, this.akP + 1);
    }

    public void R(String str, String str2) {
        c(str, str2, false);
    }

    public void c(String str, String str2, boolean z) {
        if (!this.akM && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.akN = str2;
            this.akP = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.akP < this.akQ) {
                if (z) {
                    uP();
                    this.akM = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.alb, this.akR);
            }
        }
    }

    public void uQ() {
        if (this.akL != null) {
            this.akL.dismiss();
            this.akL = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.alb);
            this.mHandler.removeCallbacks(this.alc);
        }
    }

    public void bB(int i) {
        if (i > 0) {
            this.akO = i;
        }
    }

    public void bC(int i) {
        if (i > 0) {
            this.akS = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.akZ = onClickListener;
    }

    public boolean uR() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
