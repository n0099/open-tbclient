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
    private boolean bxH;
    private String bxI;
    private int bxO;
    private int bxP;
    private int bxQ;
    private int bxR;
    private View.OnClickListener bxU;
    private boolean bxV;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bxG = null;
    private int bxJ = a.e.sdk_pic_sign_tip;
    private int bxK = 0;
    private int bxL = 1;
    private int bxM = 1000;
    private int bxN = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bxS = 48;
    private int bxT = 4;
    private boolean mUseDirectOffset = false;
    private Runnable bxW = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bxG == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.bxV || a.this.Sj()) {
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
                            textView.setPadding(a.this.bxO, a.this.bxP, a.this.bxQ, a.this.bxR);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.bxJ);
                            if (a.this.bxU != null) {
                                textView.setOnClickListener(a.this.bxU);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bxT;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.bxS;
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
                    a.this.bxG = guideBuilder.createGuide();
                    a.this.bxG.setShouldCheckLocInWindow(false);
                    a.this.bxG.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bxG.show(a.this.mPageContext.getPageActivity());
                    a.this.bxH = true;
                    a.this.Sh();
                    a.this.mHandler.postDelayed(a.this.bxX, a.this.bxN);
                }
            }
        }
    };
    private Runnable bxX = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bxG != null) {
                a.this.bxG.dismiss();
            }
        }
    };

    public void fp(int i) {
        this.bxS = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.bxO = 0;
        this.bxP = 0;
        this.bxQ = 0;
        this.bxR = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bxO = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bxP = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bxQ = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bxR = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        SharedPrefHelper.getInstance().putInt(this.bxI, this.bxK + 1);
    }

    public void aL(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.bxH && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.bxI = str2;
            this.bxK = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bxK < this.bxL) {
                if (z) {
                    Sh();
                    this.bxH = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bxW, this.bxM);
            }
        }
    }

    public void Si() {
        if (this.bxG != null) {
            this.bxG.dismiss();
            this.bxG = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bxW);
            this.mHandler.removeCallbacks(this.bxX);
        }
    }

    public void fq(int i) {
        if (i > 0) {
            this.bxJ = i;
        }
    }

    public void fr(int i) {
        if (i > 0) {
            this.bxN = i;
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bxU = onClickListener;
    }

    public boolean Sj() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
