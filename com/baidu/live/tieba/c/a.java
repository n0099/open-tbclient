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
    private boolean bHB;
    private String bHC;
    private int bHI;
    private int bHJ;
    private int bHK;
    private int bHL;
    private View.OnClickListener bHO;
    private boolean bHP;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bHA = null;
    private int bHD = a.e.sdk_pic_sign_tip;
    private int bHE = 0;
    private int bHF = 1;
    private int bHG = 1000;
    private int bHH = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bHM = 48;
    private int bHN = 4;
    private boolean mUseDirectOffset = false;
    private Runnable bHQ = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bHA == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.bHP || a.this.VM()) {
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
                            textView.setPadding(a.this.bHI, a.this.bHJ, a.this.bHK, a.this.bHL);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.bHD);
                            if (a.this.bHO != null) {
                                textView.setOnClickListener(a.this.bHO);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bHN;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.bHM;
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
                    a.this.bHA = guideBuilder.createGuide();
                    a.this.bHA.setShouldCheckLocInWindow(false);
                    a.this.bHA.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bHA.show(a.this.mPageContext.getPageActivity());
                    a.this.bHB = true;
                    a.this.VK();
                    a.this.mHandler.postDelayed(a.this.bHR, a.this.bHH);
                }
            }
        }
    };
    private Runnable bHR = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bHA != null) {
                a.this.bHA.dismiss();
            }
        }
    };

    public void fO(int i) {
        this.bHM = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.bHI = 0;
        this.bHJ = 0;
        this.bHK = 0;
        this.bHL = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bHI = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bHJ = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bHK = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bHL = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VK() {
        SharedPrefHelper.getInstance().putInt(this.bHC, this.bHE + 1);
    }

    public void aK(String str, String str2) {
        i(str, str2, false);
    }

    public void i(String str, String str2, boolean z) {
        if (!this.bHB && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.bHC = str2;
            this.bHE = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bHE < this.bHF) {
                if (z) {
                    VK();
                    this.bHB = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bHQ, this.bHG);
            }
        }
    }

    public void VL() {
        if (this.bHA != null) {
            this.bHA.dismiss();
            this.bHA = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bHQ);
            this.mHandler.removeCallbacks(this.bHR);
        }
    }

    public void fP(int i) {
        if (i > 0) {
            this.bHD = i;
        }
    }

    public void fQ(int i) {
        if (i > 0) {
            this.bHH = i;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.bHO = onClickListener;
    }

    public boolean VM() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
