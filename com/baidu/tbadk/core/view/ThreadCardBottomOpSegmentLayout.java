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
    private AgreeView.a fcB;

    public ThreadCardBottomOpSegmentLayout(Context context) {
        super(context);
        this.fcB = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void g(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.D(ThreadCardBottomOpSegmentLayout.this.bmt(), z);
            }
        };
    }

    public ThreadCardBottomOpSegmentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fcB = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void g(View view, boolean z) {
                ThreadCardBottomOpSegmentLayout.this.D(ThreadCardBottomOpSegmentLayout.this.bmt(), z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View eK(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void an(View view) {
        super.an(view);
        this.fcF.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void akv() {
        this.fcF.setVisibilityListener(this.fcB);
        boolean bmt = bmt();
        if (jF(bmt) || jG(bmt)) {
            this.fcF.jx(bmt);
            jH(bmt());
        }
    }

    private boolean jF(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fcL.getLayoutParams();
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

    private boolean jG(boolean z) {
        boolean buR = this.fcF.buR();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fcF.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            if (f != (buR ? 1.0f : 2.0f) || i != 0) {
                return true;
            }
        } else if (f != 0.0f || i != -2) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bvE() {
        D(bmt(), this.fcF.buR());
    }

    private void jH(boolean z) {
        if (z) {
            a(0, -1, 0, 1.0f, true, this.fcF.buR());
            return;
        }
        a(-2, -1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds78), 0.0f, false, this.fcF.buR());
    }

    private void a(int i, int i2, int i3, float f, boolean z, boolean z2) {
        this.fcL.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fcS.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.fcS.setLayoutParams(layoutParams);
        this.fcI.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fcH.getLayoutParams();
        layoutParams2.leftMargin = i3;
        this.fcH.setLayoutParams(layoutParams2);
        this.fcQ.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.fcP.getLayoutParams();
        layoutParams3.leftMargin = i3;
        this.fcP.setLayoutParams(layoutParams3);
        this.fcT.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f));
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.dhw.getLayoutParams();
        layoutParams4.leftMargin = i3;
        this.dhw.setLayoutParams(layoutParams4);
        D(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fcF.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            float f2 = z2 ? 1.0f : 2.0f;
            if (f != f2 || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = f2;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.fcF.setLayoutParams(layoutParams);
            }
        } else if (f != 0.0f || i != -2) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.fcF.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmt() {
        return this.ahA != null;
    }
}
