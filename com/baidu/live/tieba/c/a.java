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
    private boolean bra;
    private String brb;
    private int brh;
    private int bri;
    private int brj;
    private int brk;
    private View.OnClickListener brn;
    private boolean bro;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bqZ = null;
    private int brc = a.f.sdk_pic_sign_tip;
    private int brd = 0;
    private int bre = 1;
    private int brf = 1000;
    private int brg = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int brl = 48;
    private int brm = 4;
    private boolean mUseDirectOffset = false;
    private Runnable brp = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bqZ == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.bro || a.this.Pp()) {
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
                            textView.setPadding(a.this.brh, a.this.bri, a.this.brj, a.this.brk);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.brc);
                            if (a.this.brn != null) {
                                textView.setOnClickListener(a.this.brn);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.brm;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.brl;
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
                    a.this.bqZ = guideBuilder.createGuide();
                    a.this.bqZ.setShouldCheckLocInWindow(false);
                    a.this.bqZ.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bqZ.show(a.this.mPageContext.getPageActivity());
                    a.this.bra = true;
                    a.this.Pn();
                    a.this.mHandler.postDelayed(a.this.brq, a.this.brg);
                }
            }
        }
    };
    private Runnable brq = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bqZ != null) {
                a.this.bqZ.dismiss();
            }
        }
    };

    public void fe(int i) {
        this.brl = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.brh = 0;
        this.bri = 0;
        this.brj = 0;
        this.brk = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.brh = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.bri = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.brj = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.brk = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pn() {
        SharedPrefHelper.getInstance().putInt(this.brb, this.brd + 1);
    }

    public void aJ(String str, String str2) {
        f(str, str2, false);
    }

    public void f(String str, String str2, boolean z) {
        if (!this.bra && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.brb = str2;
            this.brd = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.brd < this.bre) {
                if (z) {
                    Pn();
                    this.bra = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.brp, this.brf);
            }
        }
    }

    public void Po() {
        if (this.bqZ != null) {
            this.bqZ.dismiss();
            this.bqZ = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.brp);
            this.mHandler.removeCallbacks(this.brq);
        }
    }

    public void ff(int i) {
        if (i > 0) {
            this.brc = i;
        }
    }

    public void fg(int i) {
        if (i > 0) {
            this.brg = i;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.brn = onClickListener;
    }

    public boolean Pp() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
