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
    private AgreeView.a dVO;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.dVO = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.ho(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVO = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void f(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.ho(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View dK(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aWC() {
        this.dVU.setVisibilityListener(this.dVO);
        this.dVU.he(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ho(boolean z) {
        if (aWE()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dVU.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.dVU.setLayoutParams(layoutParams);
        }
    }

    private boolean aWE() {
        boolean aVS = this.dVU.aVS();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dVU.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (aVS ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
