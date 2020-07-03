package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ThreadCardBottomOpSegmentWeightLayout extends ThreadCommentAndPraiseInfoLayout {
    private AgreeView.a edm;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.edm = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.hx(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.edm = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.hx(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View dL(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aYu() {
        this.edr.setVisibilityListener(this.edm);
        this.edr.hn(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hx(boolean z) {
        if (aYw()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edr.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.edr.setLayoutParams(layoutParams);
        }
    }

    private boolean aYw() {
        boolean aXM = this.edr.aXM();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edr.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (aXM ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
