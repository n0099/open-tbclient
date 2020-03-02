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
    private boolean axT;
    private String axU;
    private int aya;
    private int ayb;
    private int ayc;
    private int ayd;
    private View.OnClickListener ayg;
    private boolean ayh;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide axS = null;
    private int axV = a.f.sdk_pic_sign_tip;
    private int axW = 0;
    private int axX = 1;
    private int axY = 1000;
    private int axZ = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int aye = 48;
    private int ayf = 4;
    private boolean mUseDirectOffset = false;
    private Runnable ayi = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.axS == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.ayh || a.this.zA()) {
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
                            textView.setPadding(a.this.aya, a.this.ayb, a.this.ayc, a.this.ayd);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.axV);
                            if (a.this.ayg != null) {
                                textView.setOnClickListener(a.this.ayg);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.ayf;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.aye;
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
                    a.this.axS = guideBuilder.createGuide();
                    a.this.axS.setShouldCheckLocInWindow(false);
                    a.this.axS.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.axS.show(a.this.mPageContext.getPageActivity());
                    a.this.axT = true;
                    a.this.zy();
                    a.this.mHandler.postDelayed(a.this.ayj, a.this.axZ);
                }
            }
        }
    };
    private Runnable ayj = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.axS != null) {
                a.this.axS.dismiss();
            }
        }
    };

    public void cj(int i) {
        this.aye = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.aya = 0;
        this.ayb = 0;
        this.ayc = 0;
        this.ayd = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.aya = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ayb = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ayc = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ayd = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zy() {
        SharedPrefHelper.getInstance().putInt(this.axU, this.axW + 1);
    }

    public void aj(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.axT && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.axU = str2;
            this.axW = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.axW < this.axX) {
                if (z) {
                    zy();
                    this.axT = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ayi, this.axY);
            }
        }
    }

    public void zz() {
        if (this.axS != null) {
            this.axS.dismiss();
            this.axS = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ayi);
            this.mHandler.removeCallbacks(this.ayj);
        }
    }

    public void ck(int i) {
        if (i > 0) {
            this.axV = i;
        }
    }

    public void cl(int i) {
        if (i > 0) {
            this.axZ = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.ayg = onClickListener;
    }

    public boolean zA() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
