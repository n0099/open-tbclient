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
    private boolean bCP;
    private String bCQ;
    private int bCW;
    private int bCX;
    private int bCY;
    private int bCZ;
    private View.OnClickListener bDc;
    private boolean bDd;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bCO = null;
    private int bCR = a.e.sdk_pic_sign_tip;
    private int bCS = 0;
    private int bCT = 1;
    private int bCU = 1000;
    private int bCV = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bDa = 48;
    private int bDb = 4;
    private boolean mUseDirectOffset = false;
    private Runnable bDe = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bCO == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.bDd || a.this.UH()) {
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
                            textView.setPadding(a.this.bCW, a.this.bCX, a.this.bCY, a.this.bCZ);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.bCR);
                            if (a.this.bDc != null) {
                                textView.setOnClickListener(a.this.bDc);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bDb;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.bDa;
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
                    a.this.bCO = guideBuilder.createGuide();
                    a.this.bCO.setShouldCheckLocInWindow(false);
                    a.this.bCO.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bCO.show(a.this.mPageContext.getPageActivity());
                    a.this.bCP = true;
                    a.this.UF();
                    a.this.mHandler.postDelayed(a.this.bDf, a.this.bCV);
                }
            }
        }
    };
    private Runnable bDf = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bCO != null) {
                a.this.bCO.dismiss();
            }
        }
    };

    public void fN(int i) {
        this.bDa = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.bCW = 0;
        this.bCX = 0;
        this.bCY = 0;
        this.bCZ = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bCW = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bCX = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bCY = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bCZ = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UF() {
        SharedPrefHelper.getInstance().putInt(this.bCQ, this.bCS + 1);
    }

    public void aP(String str, String str2) {
        h(str, str2, false);
    }

    public void h(String str, String str2, boolean z) {
        if (!this.bCP && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.bCQ = str2;
            this.bCS = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bCS < this.bCT) {
                if (z) {
                    UF();
                    this.bCP = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bDe, this.bCU);
            }
        }
    }

    public void UG() {
        if (this.bCO != null) {
            this.bCO.dismiss();
            this.bCO = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bDe);
            this.mHandler.removeCallbacks(this.bDf);
        }
    }

    public void fO(int i) {
        if (i > 0) {
            this.bCR = i;
        }
    }

    public void fP(int i) {
        if (i > 0) {
            this.bCV = i;
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bDc = onClickListener;
    }

    public boolean UH() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
