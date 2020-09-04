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
    private AgreeView.a etv;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.etv = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void e(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.iA(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etv = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void e(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.iA(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View dZ(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aag() {
        this.etA.setVisibilityListener(this.etv);
        this.etA.iq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA(boolean z) {
        if (bkR()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etA.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.etA.setLayoutParams(layoutParams);
        }
    }

    private boolean bkR() {
        boolean bki = this.etA.bki();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etA.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (bki ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
