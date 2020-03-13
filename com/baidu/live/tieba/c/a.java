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
    private boolean axU;
    private String axV;
    private int ayb;
    private int ayc;
    private int ayd;
    private int aye;
    private View.OnClickListener ayh;
    private boolean ayi;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide axT = null;
    private int axW = a.f.sdk_pic_sign_tip;
    private int axX = 0;
    private int axY = 1;
    private int axZ = 1000;
    private int aya = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int ayf = 48;
    private int ayg = 4;
    private boolean mUseDirectOffset = false;
    private Runnable ayj = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.axT == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.ayi || a.this.zA()) {
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
                            textView.setPadding(a.this.ayb, a.this.ayc, a.this.ayd, a.this.aye);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.axW);
                            if (a.this.ayh != null) {
                                textView.setOnClickListener(a.this.ayh);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.ayg;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.ayf;
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
                    a.this.axT = guideBuilder.createGuide();
                    a.this.axT.setShouldCheckLocInWindow(false);
                    a.this.axT.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.axT.show(a.this.mPageContext.getPageActivity());
                    a.this.axU = true;
                    a.this.zy();
                    a.this.mHandler.postDelayed(a.this.ayk, a.this.aya);
                }
            }
        }
    };
    private Runnable ayk = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.axT != null) {
                a.this.axT.dismiss();
            }
        }
    };

    public void cj(int i) {
        this.ayf = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.ayb = 0;
        this.ayc = 0;
        this.ayd = 0;
        this.aye = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.ayb = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ayc = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.ayd = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aye = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zy() {
        SharedPrefHelper.getInstance().putInt(this.axV, this.axX + 1);
    }

    public void aj(String str, String str2) {
        d(str, str2, false);
    }

    public void d(String str, String str2, boolean z) {
        if (!this.axU && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.axV = str2;
            this.axX = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.axX < this.axY) {
                if (z) {
                    zy();
                    this.axU = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.ayj, this.axZ);
            }
        }
    }

    public void zz() {
        if (this.axT != null) {
            this.axT.dismiss();
            this.axT = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ayj);
            this.mHandler.removeCallbacks(this.ayk);
        }
    }

    public void ck(int i) {
        if (i > 0) {
            this.axW = i;
        }
    }

    public void cl(int i) {
        if (i > 0) {
            this.aya = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.ayh = onClickListener;
    }

    public boolean zA() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
