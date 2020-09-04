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
/* loaded from: classes7.dex */
public class a {
    private int bkB;
    private int bkC;
    private int bkD;
    private int bkE;
    private View.OnClickListener bkH;
    private boolean bkI;
    private boolean bku;
    private String bkv;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bkt = null;
    private int bkw = a.f.sdk_pic_sign_tip;
    private int bkx = 0;
    private int bky = 1;
    private int bkz = 1000;
    private int bkA = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bkF = 48;
    private int bkG = 4;
    private boolean mUseDirectOffset = false;
    private Runnable bkJ = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bkt == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.bkI || a.this.NH()) {
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
                            textView.setPadding(a.this.bkB, a.this.bkC, a.this.bkD, a.this.bkE);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.bkw);
                            if (a.this.bkH != null) {
                                textView.setOnClickListener(a.this.bkH);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bkG;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.bkF;
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
                    a.this.bkt = guideBuilder.createGuide();
                    a.this.bkt.setShouldCheckLocInWindow(false);
                    a.this.bkt.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bkt.show(a.this.mPageContext.getPageActivity());
                    a.this.bku = true;
                    a.this.NF();
                    a.this.mHandler.postDelayed(a.this.bkK, a.this.bkA);
                }
            }
        }
    };
    private Runnable bkK = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bkt != null) {
                a.this.bkt.dismiss();
            }
        }
    };

    public void eK(int i) {
        this.bkF = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.bkB = 0;
        this.bkC = 0;
        this.bkD = 0;
        this.bkE = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bkB = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bkC = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bkD = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bkE = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF() {
        SharedPrefHelper.getInstance().putInt(this.bkv, this.bkx + 1);
    }

    public void aG(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bku && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.bkv = str2;
            this.bkx = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bkx < this.bky) {
                if (z) {
                    NF();
                    this.bku = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bkJ, this.bkz);
            }
        }
    }

    public void NG() {
        if (this.bkt != null) {
            this.bkt.dismiss();
            this.bkt = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bkJ);
            this.mHandler.removeCallbacks(this.bkK);
        }
    }

    public void eL(int i) {
        if (i > 0) {
            this.bkw = i;
        }
    }

    public void eM(int i) {
        if (i > 0) {
            this.bkA = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.bkH = onClickListener;
    }

    public boolean NH() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
