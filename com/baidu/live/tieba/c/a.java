package com.baidu.live.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.lib.guide.Component;
import com.baidu.live.adp.lib.guide.Guide;
import com.baidu.live.adp.lib.guide.GuideBuilder;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private boolean aRN;
    private String aRO;
    private int aRU;
    private int aRV;
    private int aRW;
    private int aRX;
    private View.OnClickListener aSa;
    private boolean aSb;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide aRM = null;
    private int aRP = a.f.sdk_pic_sign_tip;
    private int aRQ = 0;
    private int aRR = 1;
    private int aRS = 1000;
    private int aRT = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int aRY = 48;
    private int aRZ = 4;
    private boolean mUseDirectOffset = false;
    private Runnable aSc = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.aRM == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.aSb || a.this.EF()) {
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
                            textView.setPadding(a.this.aRU, a.this.aRV, a.this.aRW, a.this.aRX);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.aRP);
                            if (a.this.aSa != null) {
                                textView.setOnClickListener(a.this.aSa);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.aRZ;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.aRY;
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
                    a.this.aRM = guideBuilder.createGuide();
                    a.this.aRM.setShouldCheckLocInWindow(false);
                    a.this.aRM.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.aRM.show(a.this.mPageContext.getPageActivity());
                    a.this.aRN = true;
                    a.this.ED();
                    a.this.mHandler.postDelayed(a.this.aSd, a.this.aRT);
                }
            }
        }
    };
    private Runnable aSd = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.aRM != null) {
                a.this.aRM.dismiss();
            }
        }
    };

    public void cy(int i) {
        this.aRY = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.aRU = 0;
        this.aRV = 0;
        this.aRW = 0;
        this.aRX = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.aRU = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aRV = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aRW = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aRX = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ED() {
        SharedPrefHelper.getInstance().putInt(this.aRO, this.aRQ + 1);
    }

    public void al(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.aRN && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.aRO = str2;
            this.aRQ = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.aRQ < this.aRR) {
                if (z) {
                    ED();
                    this.aRN = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.aSc, this.aRS);
            }
        }
    }

    public void EE() {
        if (this.aRM != null) {
            this.aRM.dismiss();
            this.aRM = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aSc);
            this.mHandler.removeCallbacks(this.aSd);
        }
    }

    public void cz(int i) {
        if (i > 0) {
            this.aRP = i;
        }
    }

    public void cA(int i) {
        if (i > 0) {
            this.aRT = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.aSa = onClickListener;
    }

    public boolean EF() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
