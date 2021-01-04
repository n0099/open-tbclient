package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadCardBottomOpSegmentLayout extends ThreadCommentAndPraiseInfoLayout {
    private AgreeView.a fmk;

    public ThreadCardBottomOpSegmentLayout(Context context) {
        super(context);
        this.fmk = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.D(ThreadCardBottomOpSegmentLayout.this.boU(), z);
            }
        };
    }

    public ThreadCardBottomOpSegmentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmk = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.D(ThreadCardBottomOpSegmentLayout.this.boU(), z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View fg(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void ap(View view) {
        super.ap(view);
        this.fmo.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void alF() {
        this.fmo.setVisibilityListener(this.fmk);
        boolean boU = boU();
        if (kb(boU) || kc(boU)) {
            this.fmo.jT(boU);
            kd(boU());
        }
    }

    private boolean kb(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmv.getLayoutParams();
        float f = layoutParams.weight;
        int i = layoutParams.width;
        if (z) {
            if (f != 1.0f || i != 0) {
                return true;
            }
        } else if (f != 0.0f || i != -2) {
            return true;
        }
        return false;
    }

    private boolean kc(boolean z) {
        boolean bxm = this.fmo.bxm();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmo.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            if (f != (bxm ? 1.0f : 2.0f) || i != 0) {
                return true;
            }
        } else if (f != 0.0f || i != -2) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bxZ() {
        D(boU(), this.fmo.bxm());
    }

    private void kd(boolean z) {
        if (z) {
            a(0, -1, 0, 1.0f, true, this.fmo.bxm());
            return;
        }
        a(-2, -1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds78), 0.0f, false, this.fmo.bxm());
    }

    private void a(int i, int i2, int i3, float f, boolean z, boolean z2) {
        this.fmv.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmC.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.fmC.setLayoutParams(layoutParams);
        this.fms.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fmr.getLayoutParams();
        layoutParams2.leftMargin = i3;
        this.fmr.setLayoutParams(layoutParams2);
        this.fmA.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fmz.getLayoutParams();
        layoutParams3.leftMargin = i3;
        this.fmz.setLayoutParams(layoutParams3);
        this.fmD.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.dmq.getLayoutParams();
        layoutParams4.leftMargin = i3;
        this.dmq.setLayoutParams(layoutParams4);
        D(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmo.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            float f2 = z2 ? 1.0f : 2.0f;
            if (f != f2 || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = f2;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.fmo.setLayoutParams(layoutParams);
            }
        } else if (f != 0.0f || i != -2) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.fmo.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean boU() {
        return this.aim != null;
    }
}
