package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ThreadCardBottomOpSegmentLayout extends ThreadCommentAndPraiseInfoLayout {
    private AgreeView.a etr;

    public ThreadCardBottomOpSegmentLayout(Context context) {
        super(context);
        this.etr = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void e(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.D(ThreadCardBottomOpSegmentLayout.this.bcl(), z);
            }
        };
    }

    public ThreadCardBottomOpSegmentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etr = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void e(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.D(ThreadCardBottomOpSegmentLayout.this.bcl(), z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View dZ(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aag() {
        this.etw.setVisibilityListener(this.etr);
        boolean bcl = bcl();
        if (iw(bcl) || ix(bcl)) {
            this.etw.ip(bcl);
            iy(bcl());
        }
    }

    private boolean iw(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etB.getLayoutParams();
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

    private boolean ix(boolean z) {
        boolean bki = this.etw.bki();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etw.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            if (f != (bki ? 1.0f : 2.0f) || i != 0) {
                return true;
            }
        } else if (f != 0.0f || i != -2) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bkQ() {
        D(bcl(), this.etw.bki());
    }

    private void iy(boolean z) {
        if (z) {
            a(0, -1, 0, 1.0f, true, this.etw.bki());
            return;
        }
        a(-2, -1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds78), 0.0f, false, this.etw.bki());
    }

    private void a(int i, int i2, int i3, float f, boolean z, boolean z2) {
        this.etB.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etI.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.etI.setLayoutParams(layoutParams);
        this.ety.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.etx.getLayoutParams();
        layoutParams2.leftMargin = i3;
        this.etx.setLayoutParams(layoutParams2);
        this.etG.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.etF.getLayoutParams();
        layoutParams3.leftMargin = i3;
        this.etF.setLayoutParams(layoutParams3);
        this.etJ.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.czG.getLayoutParams();
        layoutParams4.leftMargin = i3;
        this.czG.setLayoutParams(layoutParams4);
        D(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etw.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            float f2 = z2 ? 1.0f : 2.0f;
            if (f != f2 || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = f2;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.etw.setLayoutParams(layoutParams);
            }
        } else if (f != 0.0f || i != -2) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.etw.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bcl() {
        return this.afJ != null;
    }
}
