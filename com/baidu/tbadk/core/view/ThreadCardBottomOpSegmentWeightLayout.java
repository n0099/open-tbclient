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
public class ThreadCardBottomOpSegmentWeightLayout extends ThreadCommentAndPraiseInfoLayout {
    private AgreeView.a ejw;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.ejw = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.ic(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ejw = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.ic(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View dQ(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void Tk() {
        this.ejB.setVisibilityListener(this.ejw);
        this.ejB.hS(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic(boolean z) {
        if (bcu()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejB.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.ejB.setLayoutParams(layoutParams);
        }
    }

    private boolean bcu() {
        boolean bbM = this.ejB.bbM();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejB.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (bbM ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
