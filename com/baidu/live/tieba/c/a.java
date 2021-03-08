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
/* loaded from: classes10.dex */
public class a {
    private boolean bHZ;
    private String bIa;
    private int bIg;
    private int bIh;
    private int bIi;
    private int bIj;
    private View.OnClickListener bIm;
    private boolean bIn;
    private String mMessage;
    private TbPageContext mPageContext;
    private View mTargetView;
    private Handler mHandler = null;
    private Guide bHY = null;
    private int bIb = a.e.sdk_pic_sign_tip;
    private int bIc = 0;
    private int bId = 1;
    private int bIe = 1000;
    private int bIf = 3000;
    private int mXOffset = 5;
    private int mYOffset = 0;
    private int bIk = 48;
    private int bIl = 4;
    private boolean mUseDirectOffset = false;
    private Runnable bIo = new Runnable() { // from class: com.baidu.live.tieba.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bHY == null && !StringUtils.isNull(a.this.mMessage)) {
                if (!a.this.bIn || a.this.TD()) {
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
                            textView.setPadding(a.this.bIg, a.this.bIh, a.this.bIi, a.this.bIj);
                            textView.setSingleLine(true);
                            SkinManager.setBackgroundResource(textView, a.this.bIb);
                            if (a.this.bIm != null) {
                                textView.setOnClickListener(a.this.bIm);
                            }
                            return textView;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getAnchor() {
                            return a.this.bIl;
                        }

                        @Override // com.baidu.live.adp.lib.guide.Component
                        public int getFitPosition() {
                            return a.this.bIk;
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
                    a.this.bHY = guideBuilder.createGuide();
                    a.this.bHY.setShouldCheckLocInWindow(false);
                    a.this.bHY.setUseDirectOffset(a.this.mUseDirectOffset);
                    a.this.bHY.show(a.this.mPageContext.getPageActivity());
                    a.this.bHZ = true;
                    a.this.TB();
                    a.this.mHandler.postDelayed(a.this.bIp, a.this.bIf);
                }
            }
        }
    };
    private Runnable bIp = new Runnable() { // from class: com.baidu.live.tieba.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.bHY != null) {
                a.this.bHY.dismiss();
            }
        }
    };

    public void en(int i) {
        this.bIk = i;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.bIg = 0;
        this.bIh = 0;
        this.bIi = 0;
        this.bIj = 0;
        this.mPageContext = tbPageContext;
        this.mTargetView = view;
        this.bIg = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bIh = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bIi = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.bIj = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TB() {
        SharedPrefHelper.getInstance().putInt(this.bIa, this.bIc + 1);
    }

    public void aJ(String str, String str2) {
        i(str, str2, false);
    }

    public void i(String str, String str2, boolean z) {
        if (!this.bHZ && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && this.mTargetView != null && this.mTargetView.getVisibility() == 0) {
            this.mMessage = str;
            this.bIa = str2;
            this.bIc = SharedPrefHelper.getInstance().getInt(str2, 0);
            if (this.bIc < this.bId) {
                if (z) {
                    TB();
                    this.bHZ = true;
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.bIo, this.bIe);
            }
        }
    }

    public void TC() {
        if (this.bHY != null) {
            this.bHY.dismiss();
            this.bHY = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bIo);
            this.mHandler.removeCallbacks(this.bIp);
        }
    }

    public void eo(int i) {
        if (i > 0) {
            this.bIb = i;
        }
    }

    public void ep(int i) {
        if (i > 0) {
            this.bIf = i;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.bIm = onClickListener;
    }

    public boolean TD() {
        return this.mTargetView != null && this.mTargetView.getVisibility() == 0 && ((double) this.mTargetView.getAlpha()) >= 0.4d;
    }
}
