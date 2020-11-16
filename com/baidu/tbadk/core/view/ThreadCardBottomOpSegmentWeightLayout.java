package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ThreadCardBottomOpSegmentWeightLayout extends ThreadCommentAndPraiseInfoLayout {
    private AgreeView.a eVe;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.eVe = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void g(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.js(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eVe = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void g(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.js(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View ef(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void al(View view) {
        super.al(view);
        this.eVi.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void ahn() {
        this.eVi.setVisibilityListener(this.eVe);
        this.eVi.ji(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(boolean z) {
        if (bsf()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVi.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.eVi.setLayoutParams(layoutParams);
        }
    }

    private boolean bsf() {
        boolean bru = this.eVi.bru();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVi.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (bru ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
