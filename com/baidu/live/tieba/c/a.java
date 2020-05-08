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
    private boolean aRS;
    private String aRT;
    private int aRZ;
    private int aSa;
    private int aSb;
    private int aSc;
    private View.OnClickListener aSf;
    private boolean aSg;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide aRR = null;
    private int aRU = a.f.sdk_pic_sign_tip;
    private int aRV = 0;
    private int aRW = 1;
    private int aRX = 1000;
    private int aRY = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int aSd = 48;
    private int aSe = 4;
    private boolean mUseDirectOffset = false;
    private Runnable aSh = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.aRR == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.aSg || a.this.EE()) {
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
                            textView.setPadding(a.this.aRZ, a.this.aSa, a.this.aSb, a.this.aSc);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.aRU);
                            if (a.this.aSf != null) {
                                textView.setOnClickListener(a.this.aSf);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.aSe;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.aSd;
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
                    a.this.aRR = guideBuilder.createGuide();
                    a.this.aRR.setShouldCheckLocInWindow(false);
                    a.this.aRR.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.aRR.show(a.this.mPageContext.getPageActivity());
                    a.this.aRS = true;
                    a.this.EC();
                    a.this.mHandler.postDelayed(a.this.aSi, a.this.aRY);
                }
            }
        }
    };
    private Runnable aSi = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.aRR != null) {
                a.this.aRR.dismiss();
            }
        }
    };

    public void cy(int i) {
        this.aSd = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.aRZ = 0;
        this.aSa = 0;
        this.aSb = 0;
        this.aSc = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.aRZ = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aSa = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aSb = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aSc = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC() {
        SharedPrefHelper.getInstance().putInt(this.aRT, this.aRV + 1);
    }

    public void al(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.aRS && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.aRT = str2;
            this.aRV = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.aRV < this.aRW) {
                if (z) {
                    EC();
                    this.aRS = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.aSh, this.aRX);
            }
        }
    }

    public void ED() {
        if (this.aRR != null) {
            this.aRR.dismiss();
            this.aRR = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aSh);
            this.mHandler.removeCallbacks(this.aSi);
        }
    }

    public void cz(int i) {
        if (i > 0) {
            this.aRU = i;
        }
    }

    public void cA(int i) {
        if (i > 0) {
            this.aRY = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.aSf = onClickListener;
    }

    public boolean EE() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
