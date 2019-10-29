package com.baidu.live.tieba.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.lib.guide.Component;
import com.baidu.live.adp.lib.guide.Guide;
import com.baidu.live.adp.lib.guide.GuideBuilder;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes6.dex */
public class a {
    private boolean ale;
    private String alf;
    private int alm;
    private int aln;
    private int alo;
    private int alp;
    private View.OnClickListener als;
    private boolean alt;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide ald = null;
    private int alg = a.f.sdk_pic_sign_tip;
    private int alh = 0;
    private int ali = 1;
    private int alj = 1000;
    private int alk = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int alq = 48;
    private int alr = 4;
    private boolean mUseDirectOffset = false;
    private Runnable alu = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ald == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.alt || a.this.uQ()) {
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
                            textView.setPadding(a.this.alm, a.this.aln, a.this.alo, a.this.alp);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.alg);
                            if (a.this.als != null) {
                                textView.setOnClickListener(a.this.als);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.alr;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.alq;
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
                    a.this.ald = guideBuilder.createGuide();
                    a.this.ald.setShouldCheckLocInWindow(false);
                    a.this.ald.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.ald.show(a.this.mPageContext.getPageActivity());
                    a.this.ale = true;
                    a.this.uO();
                    a.this.mHandler.postDelayed(a.this.alv, a.this.alk);
                }
            }
        }
    };
    private Runnable alv = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ald != null) {
                a.this.ald.dismiss();
            }
        }
    };

    public void bA(int i) {
        this.alq = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.alm = 0;
        this.aln = 0;
        this.alo = 0;
        this.alp = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.alm = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.aln = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.alo = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.alp = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uO() {
        SharedPrefHelper.getInstance().putInt(this.alf, this.alh + 1);
    }

    public void R(String str, String str2) {
        c(str, str2, false);
    }

    public void c(String str, String str2, boolean z) {
        if (!this.ale && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.alf = str2;
            this.alh = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.alh < this.ali) {
                if (z) {
                    uO();
                    this.ale = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.alu, this.alj);
            }
        }
    }

    public void uP() {
        if (this.ald != null) {
            this.ald.dismiss();
            this.ald = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.alu);
            this.mHandler.removeCallbacks(this.alv);
        }
    }

    public void bB(int i) {
        if (i > 0) {
            this.alg = i;
        }
    }

    public void bC(int i) {
        if (i > 0) {
            this.alk = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.als = onClickListener;
    }

    public boolean uQ() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
