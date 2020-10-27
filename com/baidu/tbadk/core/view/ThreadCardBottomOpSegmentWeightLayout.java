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
    private AgreeView.a eQf;

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.eQf = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void e(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.ji(z);
            }
        };
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eQf = new AgreeView.a() { // from class: com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout.1
            @Override // com.baidu.tbadk.core.view.AgreeView.a
            public void e(View view, boolean z) {
                ThreadCardBottomOpSegmentWeightLayout.this.ji(z);
            }
        };
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected View ef(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void afv() {
        this.eQk.setVisibilityListener(this.eQf);
        this.eQk.iY(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji(boolean z) {
        if (bqp()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQk.getLayoutParams();
            float f = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.eQk.setLayoutParams(layoutParams);
        }
    }

    private boolean bqp() {
        boolean bpG = this.eQk.bpG();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQk.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight != (bpG ? 1.0f : 2.0f) || i != 0) {
            return true;
        }
        return false;
    }
}
