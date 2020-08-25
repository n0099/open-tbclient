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
    private int bkA;
    private int bkB;
    private View.OnClickListener bkE;
    private boolean bkF;
    private boolean bkr;
    private String bks;
    private int bky;
    private int bkz;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bkq = null;
    private int bkt = a.f.sdk_pic_sign_tip;
    private int bku = 0;
    private int bkv = 1;
    private int bkw = 1000;
    private int bkx = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bkC = 48;
    private int bkD = 4;
    private boolean mUseDirectOffset = false;
    private Runnable bkG = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bkq == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.bkF || a.this.NH()) {
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
                            textView.setPadding(a.this.bky, a.this.bkz, a.this.bkA, a.this.bkB);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.bkt);
                            if (a.this.bkE != null) {
                                textView.setOnClickListener(a.this.bkE);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bkD;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.bkC;
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
                    a.this.bkq = guideBuilder.createGuide();
                    a.this.bkq.setShouldCheckLocInWindow(false);
                    a.this.bkq.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bkq.show(a.this.mPageContext.getPageActivity());
                    a.this.bkr = true;
                    a.this.NF();
                    a.this.mHandler.postDelayed(a.this.bkH, a.this.bkx);
                }
            }
        }
    };
    private Runnable bkH = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bkq != null) {
                a.this.bkq.dismiss();
            }
        }
    };

    public void eK(int i) {
        this.bkC = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.bky = 0;
        this.bkz = 0;
        this.bkA = 0;
        this.bkB = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bky = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bkz = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bkA = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bkB = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF() {
        SharedPrefHelper.getInstance().putInt(this.bks, this.bku + 1);
    }

    public void aG(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bkr && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.bks = str2;
            this.bku = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bku < this.bkv) {
                if (z) {
                    NF();
                    this.bkr = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bkG, this.bkw);
            }
        }
    }

    public void NG() {
        if (this.bkq != null) {
            this.bkq.dismiss();
            this.bkq = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bkG);
            this.mHandler.removeCallbacks(this.bkH);
        }
    }

    public void eL(int i) {
        if (i > 0) {
            this.bkt = i;
        }
    }

    public void eM(int i) {
        if (i > 0) {
            this.bkx = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.bkE = onClickListener;
    }

    public boolean NH() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
