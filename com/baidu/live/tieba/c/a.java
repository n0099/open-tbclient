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
    private boolean beG;
    private String beH;
    private int beN;
    private int beO;
    private int beP;
    private int beQ;
    private View.OnClickListener beT;
    private boolean beU;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide beF = null;
    private int beI = a.f.sdk_pic_sign_tip;
    private int beJ = 0;
    private int beK = 1;
    private int beL = 1000;
    private int beM = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int beR = 48;
    private int beS = 4;
    private boolean mUseDirectOffset = false;
    private Runnable beV = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.beF == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.beU || a.this.HO()) {
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
                            textView.setPadding(a.this.beN, a.this.beO, a.this.beP, a.this.beQ);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.beI);
                            if (a.this.beT != null) {
                                textView.setOnClickListener(a.this.beT);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.beS;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.beR;
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
                    a.this.beF = guideBuilder.createGuide();
                    a.this.beF.setShouldCheckLocInWindow(false);
                    a.this.beF.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.beF.show(a.this.mPageContext.getPageActivity());
                    a.this.beG = true;
                    a.this.HM();
                    a.this.mHandler.postDelayed(a.this.beW, a.this.beM);
                }
            }
        }
    };
    private Runnable beW = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.beF != null) {
                a.this.beF.dismiss();
            }
        }
    };

    public void cR(int i) {
        this.beR = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.beN = 0;
        this.beO = 0;
        this.beP = 0;
        this.beQ = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.beN = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.beO = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.beP = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.beQ = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
        SharedPrefHelper.getInstance().putInt(this.beH, this.beJ + 1);
    }

    public void aC(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.beG && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.beH = str2;
            this.beJ = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.beJ < this.beK) {
                if (z) {
                    HM();
                    this.beG = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.beV, this.beL);
            }
        }
    }

    public void HN() {
        if (this.beF != null) {
            this.beF.dismiss();
            this.beF = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.beV);
            this.mHandler.removeCallbacks(this.beW);
        }
    }

    public void cS(int i) {
        if (i > 0) {
            this.beI = i;
        }
    }

    public void cT(int i) {
        if (i > 0) {
            this.beM = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.beT = onClickListener;
    }

    public boolean HO() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
