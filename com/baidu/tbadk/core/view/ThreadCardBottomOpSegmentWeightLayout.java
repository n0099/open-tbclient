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
    private AgreeView.a fjS;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.fjS = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.kd(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjS = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.kd(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View fd(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void am(View view) {
        super.am(view);
        this.fjW.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aik() {
        this.fjW.setVisibilityListener(this.fjS);
        this.fjW.jS(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (buB()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjW.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.fjW.setLayoutParams(layoutParams);
        }
    }

    private boolean buB() {
        boolean btN = this.fjW.btN();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjW.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (btN ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
