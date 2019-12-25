package com.baidu.live.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.lib.guide.Component;
import com.baidu.live.adp.lib.guide.Guide;
import com.baidu.live.adp.lib.guide.GuideBuilder;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes2.dex */
public class a {
    private boolean asQ;
    private String asR;
    private int asX;
    private int asY;
    private int asZ;
    private int ata;
    private View.OnClickListener atd;
    private boolean ate;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide asP = null;
    private int asS = a.f.sdk_pic_sign_tip;
    private int asT = 0;
    private int asU = 1;
    private int asV = 1000;
    private int asW = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int atb = 48;
    private int atc = 4;
    private boolean mUseDirectOffset = false;
    private Runnable atf = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.asP == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.ate || a.this.wQ()) {
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
                            textView.setPadding(a.this.asX, a.this.asY, a.this.asZ, a.this.ata);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.asS);
                            if (a.this.atd != null) {
                                textView.setOnClickListener(a.this.atd);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.atc;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.atb;
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
                    a.this.asP = guideBuilder.createGuide();
                    a.this.asP.setShouldCheckLocInWindow(false);
                    a.this.asP.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.asP.show(a.this.mPageContext.getPageActivity());
                    a.this.asQ = true;
                    a.this.wO();
                    a.this.mHandler.postDelayed(a.this.atg, a.this.asW);
                }
            }
        }
    };
    private Runnable atg = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.asP != null) {
                a.this.asP.dismiss();
            }
        }
    };

    public void bS(int i) {
        this.atb = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.asX = 0;
        this.asY = 0;
        this.asZ = 0;
        this.ata = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.asX = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.asY = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.asZ = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ata = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wO() {
        SharedPrefHelper.getInstance().putInt(this.asR, this.asT + 1);
    }

    public void Z(String str, String str2) {
        c(str, str2, false);
    }

    public void c(String str, String str2, boolean z) {
        if (!this.asQ && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.asR = str2;
            this.asT = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.asT < this.asU) {
                if (z) {
                    wO();
                    this.asQ = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.atf, this.asV);
            }
        }
    }

    public void wP() {
        if (this.asP != null) {
            this.asP.dismiss();
            this.asP = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.atf);
            this.mHandler.removeCallbacks(this.atg);
        }
    }

    public void bT(int i) {
        if (i > 0) {
            this.asS = i;
        }
    }

    public void bU(int i) {
        if (i > 0) {
            this.asW = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.atd = onClickListener;
    }

    public boolean wQ() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
