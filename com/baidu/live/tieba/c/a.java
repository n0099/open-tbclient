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
    private boolean ayi;
    private String ayj;
    private int ayp;
    private int ayq;
    private int ayr;
    private int ays;
    private View.OnClickListener ayv;
    private boolean ayw;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide ayh = null;
    private int ayk = a.f.sdk_pic_sign_tip;
    private int ayl = 0;
    private int aym = 1;
    private int ayn = 1000;
    private int ayo = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int ayt = 48;
    private int ayu = 4;
    private boolean mUseDirectOffset = false;
    private Runnable ayx = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ayh == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.ayw || a.this.zH()) {
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
                            textView.setPadding(a.this.ayp, a.this.ayq, a.this.ayr, a.this.ays);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.ayk);
                            if (a.this.ayv != null) {
                                textView.setOnClickListener(a.this.ayv);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.ayu;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.ayt;
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
                    a.this.ayh = guideBuilder.createGuide();
                    a.this.ayh.setShouldCheckLocInWindow(false);
                    a.this.ayh.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.ayh.show(a.this.mPageContext.getPageActivity());
                    a.this.ayi = true;
                    a.this.zF();
                    a.this.mHandler.postDelayed(a.this.ayy, a.this.ayo);
                }
            }
        }
    };
    private Runnable ayy = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ayh != null) {
                a.this.ayh.dismiss();
            }
        }
    };

    public void cj(int i) {
        this.ayt = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.ayp = 0;
        this.ayq = 0;
        this.ayr = 0;
        this.ays = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.ayp = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ayq = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ayr = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ays = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF() {
        SharedPrefHelper.getInstance().putInt(this.ayj, this.ayl + 1);
    }

    public void ai(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.ayi && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.ayj = str2;
            this.ayl = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.ayl < this.aym) {
                if (z) {
                    zF();
                    this.ayi = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ayx, this.ayn);
            }
        }
    }

    public void zG() {
        if (this.ayh != null) {
            this.ayh.dismiss();
            this.ayh = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ayx);
            this.mHandler.removeCallbacks(this.ayy);
        }
    }

    public void ck(int i) {
        if (i > 0) {
            this.ayk = i;
        }
    }

    public void cl(int i) {
        if (i > 0) {
            this.ayo = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.ayv = onClickListener;
    }

    public boolean zH() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
