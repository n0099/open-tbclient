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
    private boolean aZg;
    private String aZh;
    private int aZn;
    private int aZo;
    private int aZp;
    private int aZq;
    private View.OnClickListener aZt;
    private boolean aZu;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide aZf = null;
    private int aZi = a.f.sdk_pic_sign_tip;
    private int aZj = 0;
    private int aZk = 1;
    private int aZl = 1000;
    private int aZm = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int aZr = 48;
    private int aZs = 4;
    private boolean mUseDirectOffset = false;
    private Runnable aZv = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.aZf == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.aZu || a.this.Gv()) {
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
                            textView.setPadding(a.this.aZn, a.this.aZo, a.this.aZp, a.this.aZq);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.aZi);
                            if (a.this.aZt != null) {
                                textView.setOnClickListener(a.this.aZt);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.aZs;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.aZr;
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
                    a.this.aZf = guideBuilder.createGuide();
                    a.this.aZf.setShouldCheckLocInWindow(false);
                    a.this.aZf.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.aZf.show(a.this.mPageContext.getPageActivity());
                    a.this.aZg = true;
                    a.this.Gt();
                    a.this.mHandler.postDelayed(a.this.aZw, a.this.aZm);
                }
            }
        }
    };
    private Runnable aZw = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.aZf != null) {
                a.this.aZf.dismiss();
            }
        }
    };

    public void cF(int i) {
        this.aZr = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.aZn = 0;
        this.aZo = 0;
        this.aZp = 0;
        this.aZq = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.aZn = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aZo = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aZp = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aZq = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt() {
        SharedPrefHelper.getInstance().putInt(this.aZh, this.aZj + 1);
    }

    public void aA(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.aZg && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.aZh = str2;
            this.aZj = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.aZj < this.aZk) {
                if (z) {
                    Gt();
                    this.aZg = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.aZv, this.aZl);
            }
        }
    }

    public void Gu() {
        if (this.aZf != null) {
            this.aZf.dismiss();
            this.aZf = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aZv);
            this.mHandler.removeCallbacks(this.aZw);
        }
    }

    public void cG(int i) {
        if (i > 0) {
            this.aZi = i;
        }
    }

    public void cH(int i) {
        if (i > 0) {
            this.aZm = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.aZt = onClickListener;
    }

    public boolean Gv() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
