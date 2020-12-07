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
public class ThreadCardBottomOpSegmentWeightLayout extends ThreadCommentAndPraiseInfoLayout {
    private AgreeView.a fcB;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.fcB = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void g(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.jI(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fcB = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void g(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.jI(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View eK(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void an(View view) {
        super.an(view);
        this.fcF.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void akv() {
        this.fcF.setVisibilityListener(this.fcB);
        this.fcF.jx(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jI(boolean z) {
        if (bvF()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fcF.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.fcF.setLayoutParams(layoutParams);
        }
    }

    private boolean bvF() {
        boolean buR = this.fcF.buR();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fcF.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (buR ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
