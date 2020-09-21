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
    private AgreeView.a evz;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.evz = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void e(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.ix(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evz = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void e(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.ix(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View dY(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aaP() {
        this.evE.setVisibilityListener(this.evz);
        this.evE.in(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ix(boolean z) {
        if (blM()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evE.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.evE.setLayoutParams(layoutParams);
        }
    }

    private boolean blM() {
        boolean bld = this.evE.bld();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evE.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (bld ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
