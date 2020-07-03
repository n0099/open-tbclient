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
/* loaded from: classes3.dex */
public class a {
    private View.OnClickListener beA;
    private boolean beB;
    private boolean bem;
    private String ben;
    private int beu;
    private int bev;
    private int bew;
    private int bex;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bel = null;
    private int beo = a.f.sdk_pic_sign_tip;
    private int bep = 0;
    private int beq = 1;
    private int ber = 1000;
    private int bes = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bey = 48;
    private int bez = 4;
    private boolean mUseDirectOffset = false;
    private Runnable beC = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bel == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.beB || a.this.HI()) {
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
                            textView.setPadding(a.this.beu, a.this.bev, a.this.bew, a.this.bex);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.beo);
                            if (a.this.beA != null) {
                                textView.setOnClickListener(a.this.beA);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bez;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.bey;
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
                    a.this.bel = guideBuilder.createGuide();
                    a.this.bel.setShouldCheckLocInWindow(false);
                    a.this.bel.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bel.show(a.this.mPageContext.getPageActivity());
                    a.this.bem = true;
                    a.this.HG();
                    a.this.mHandler.postDelayed(a.this.beD, a.this.bes);
                }
            }
        }
    };
    private Runnable beD = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bel != null) {
                a.this.bel.dismiss();
            }
        }
    };

    public void cR(int i) {
        this.bey = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.beu = 0;
        this.bev = 0;
        this.bew = 0;
        this.bex = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.beu = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bev = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bew = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bex = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HG() {
        SharedPrefHelper.getInstance().putInt(this.ben, this.bep + 1);
    }

    public void aC(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bem && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.ben = str2;
            this.bep = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bep < this.beq) {
                if (z) {
                    HG();
                    this.bem = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.beC, this.ber);
            }
        }
    }

    public void HH() {
        if (this.bel != null) {
            this.bel.dismiss();
            this.bel = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.beC);
            this.mHandler.removeCallbacks(this.beD);
        }
    }

    public void cS(int i) {
        if (i > 0) {
            this.beo = i;
        }
    }

    public void cT(int i) {
        if (i > 0) {
            this.bes = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.beA = onClickListener;
    }

    public boolean HI() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
