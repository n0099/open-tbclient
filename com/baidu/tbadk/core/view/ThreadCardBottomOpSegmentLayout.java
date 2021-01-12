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
    private AgreeView.a fhz;

    public ThreadCardBottomOpSegmentLayout(Context context) {
        super(context);
        this.fhz = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.D(ThreadCardBottomOpSegmentLayout.this.blb(), z);
            }
        };
    }

    public ThreadCardBottomOpSegmentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhz = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.D(ThreadCardBottomOpSegmentLayout.this.blb(), z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View fe(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void ap(View view) {
        super.ap(view);
        this.fhD.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void ahM() {
        this.fhD.setVisibilityListener(this.fhz);
        boolean blb = blb();
        if (jX(blb) || jY(blb)) {
            this.fhD.jP(blb);
            jZ(blb());
        }
    }

    private boolean jX(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhJ.getLayoutParams();
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

    private boolean jY(boolean z) {
        boolean btt = this.fhD.btt();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhD.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            if (f != (btt ? 1.0f : 2.0f) || i != 0) {
                return true;
            }
        } else if (f != 0.0f || i != -2) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bug() {
        D(blb(), this.fhD.btt());
    }

    private void jZ(boolean z) {
        if (z) {
            a(0, -1, 0, 1.0f, true, this.fhD.btt());
            return;
        }
        a(-2, -1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds78), 0.0f, false, this.fhD.btt());
    }

    private void a(int i, int i2, int i3, float f, boolean z, boolean z2) {
        this.fhJ.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhQ.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.fhQ.setLayoutParams(layoutParams);
        this.fhG.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fhF.getLayoutParams();
        layoutParams2.leftMargin = i3;
        this.fhF.setLayoutParams(layoutParams2);
        this.fhO.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fhN.getLayoutParams();
        layoutParams3.leftMargin = i3;
        this.fhN.setLayoutParams(layoutParams3);
        this.fhR.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.dhB.getLayoutParams();
        layoutParams4.leftMargin = i3;
        this.dhB.setLayoutParams(layoutParams4);
        D(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhD.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            float f2 = z2 ? 1.0f : 2.0f;
            if (f != f2 || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = f2;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.fhD.setLayoutParams(layoutParams);
            }
        } else if (f != 0.0f || i != -2) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.fhD.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blb() {
        return this.ahu != null;
    }
}
