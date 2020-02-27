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
    private boolean axS;
    private String axT;
    private int axZ;
    private int aya;
    private int ayb;
    private int ayc;
    private View.OnClickListener ayf;
    private boolean ayg;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide axR = null;
    private int axU = a.f.sdk_pic_sign_tip;
    private int axV = 0;
    private int axW = 1;
    private int axX = 1000;
    private int axY = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int ayd = 48;
    private int aye = 4;
    private boolean mUseDirectOffset = false;
    private Runnable ayh = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.axR == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.ayg || a.this.zy()) {
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
                            textView.setPadding(a.this.axZ, a.this.aya, a.this.ayb, a.this.ayc);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.axU);
                            if (a.this.ayf != null) {
                                textView.setOnClickListener(a.this.ayf);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.aye;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.ayd;
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
                    a.this.axR = guideBuilder.createGuide();
                    a.this.axR.setShouldCheckLocInWindow(false);
                    a.this.axR.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.axR.show(a.this.mPageContext.getPageActivity());
                    a.this.axS = true;
                    a.this.zw();
                    a.this.mHandler.postDelayed(a.this.ayi, a.this.axY);
                }
            }
        }
    };
    private Runnable ayi = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.axR != null) {
                a.this.axR.dismiss();
            }
        }
    };

    public void cj(int i) {
        this.ayd = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.axZ = 0;
        this.aya = 0;
        this.ayb = 0;
        this.ayc = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.axZ = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aya = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ayb = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ayc = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw() {
        SharedPrefHelper.getInstance().putInt(this.axT, this.axV + 1);
    }

    public void aj(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.axS && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.axT = str2;
            this.axV = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.axV < this.axW) {
                if (z) {
                    zw();
                    this.axS = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ayh, this.axX);
            }
        }
    }

    public void zx() {
        if (this.axR != null) {
            this.axR.dismiss();
            this.axR = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ayh);
            this.mHandler.removeCallbacks(this.ayi);
        }
    }

    public void ck(int i) {
        if (i > 0) {
            this.axU = i;
        }
    }

    public void cl(int i) {
        if (i > 0) {
            this.axY = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.ayf = onClickListener;
    }

    public boolean zy() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
