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
    private AgreeView.a eVU;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.eVU = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.jr(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eVU = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.jr(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View ef(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void ahV() {
        this.eVZ.setVisibilityListener(this.eVU);
        this.eVZ.jh(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr(boolean z) {
        if (bsP()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVZ.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.eVZ.setLayoutParams(layoutParams);
        }
    }

    private boolean bsP() {
        boolean bsg = this.eVZ.bsg();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVZ.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (bsg ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
