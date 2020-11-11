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
    private int bzA;
    private int bzB;
    private int bzC;
    private View.OnClickListener bzF;
    private boolean bzG;
    private boolean bzs;
    private String bzt;
    private int bzz;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bzr = null;
    private int bzu = a.e.sdk_pic_sign_tip;
    private int bzv = 0;
    private int bzw = 1;
    private int bzx = 1000;
    private int bzy = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bzD = 48;
    private int bzE = 4;
    private boolean mUseDirectOffset = false;
    private Runnable bzH = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bzr == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.bzG || a.this.SS()) {
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
                            textView.setPadding(a.this.bzz, a.this.bzA, a.this.bzB, a.this.bzC);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.bzu);
                            if (a.this.bzF != null) {
                                textView.setOnClickListener(a.this.bzF);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bzE;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.bzD;
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
                    a.this.bzr = guideBuilder.createGuide();
                    a.this.bzr.setShouldCheckLocInWindow(false);
                    a.this.bzr.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bzr.show(a.this.mPageContext.getPageActivity());
                    a.this.bzs = true;
                    a.this.SQ();
                    a.this.mHandler.postDelayed(a.this.bzI, a.this.bzy);
                }
            }
        }
    };
    private Runnable bzI = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bzr != null) {
                a.this.bzr.dismiss();
            }
        }
    };

    public void ft(int i) {
        this.bzD = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.bzz = 0;
        this.bzA = 0;
        this.bzB = 0;
        this.bzC = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bzz = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bzA = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bzB = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bzC = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SQ() {
        SharedPrefHelper.getInstance().putInt(this.bzt, this.bzv + 1);
    }

    public void aM(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (!this.bzs && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.bzt = str2;
            this.bzv = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bzv < this.bzw) {
                if (z) {
                    SQ();
                    this.bzs = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bzH, this.bzx);
            }
        }
    }

    public void SR() {
        if (this.bzr != null) {
            this.bzr.dismiss();
            this.bzr = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bzH);
            this.mHandler.removeCallbacks(this.bzI);
        }
    }

    public void fu(int i) {
        if (i > 0) {
            this.bzu = i;
        }
    }

    public void fv(int i) {
        if (i > 0) {
            this.bzy = i;
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bzF = onClickListener;
    }

    public boolean SS() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
