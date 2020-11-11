package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ThreadCardBottomOpSegmentLayout extends ThreadCommentAndPraiseInfoLayout {
    private AgreeView.a eVU;

    public ThreadCardBottomOpSegmentLayout(Context context) {
        super(context);
        this.eVU = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.D(ThreadCardBottomOpSegmentLayout.this.bkh(), z);
            }
        };
    }

    public ThreadCardBottomOpSegmentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eVU = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.D(ThreadCardBottomOpSegmentLayout.this.bkh(), z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View ef(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void ahV() {
        this.eVZ.setVisibilityListener(this.eVU);
        boolean bkh = bkh();
        if (jo(bkh) || jp(bkh)) {
            this.eVZ.jh(bkh);
            jq(bkh());
        }
    }

    private boolean jo(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWe.getLayoutParams();
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

    private boolean jp(boolean z) {
        boolean bsg = this.eVZ.bsg();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVZ.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            if (f != (bsg ? 1.0f : 2.0f) || i != 0) {
                return true;
            }
        } else if (f != 0.0f || i != -2) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bsO() {
        D(bkh(), this.eVZ.bsg());
    }

    private void jq(boolean z) {
        if (z) {
            a(0, -1, 0, 1.0f, true, this.eVZ.bsg());
            return;
        }
        a(-2, -1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds78), 0.0f, false, this.eVZ.bsg());
    }

    private void a(int i, int i2, int i3, float f, boolean z, boolean z2) {
        this.eWe.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWl.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.eWl.setLayoutParams(layoutParams);
        this.eWb.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eWa.getLayoutParams();
        layoutParams2.leftMargin = i3;
        this.eWa.setLayoutParams(layoutParams2);
        this.eWj.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.eWi.getLayoutParams();
        layoutParams3.leftMargin = i3;
        this.eWi.setLayoutParams(layoutParams3);
        this.eWm.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.dcg.getLayoutParams();
        layoutParams4.leftMargin = i3;
        this.dcg.setLayoutParams(layoutParams4);
        D(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVZ.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            float f2 = z2 ? 1.0f : 2.0f;
            if (f != f2 || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = f2;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.eVZ.setLayoutParams(layoutParams);
            }
        } else if (f != 0.0f || i != -2) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.eVZ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkh() {
        return this.agx != null;
    }
}
