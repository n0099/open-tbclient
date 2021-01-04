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
public class ThreadCardBottomOpSegmentWeightLayout extends ThreadCommentAndPraiseInfoLayout {
    private AgreeView.a fmk;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.fmk = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.ke(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmk = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.ke(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View fg(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void ap(View view) {
        super.ap(view);
        this.fmo.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void alF() {
        this.fmo.setVisibilityListener(this.fmk);
        this.fmo.jT(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ke(boolean z) {
        if (bya()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmo.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.fmo.setLayoutParams(layoutParams);
        }
    }

    private boolean bya() {
        boolean bxm = this.fmo.bxm();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmo.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (bxm ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
