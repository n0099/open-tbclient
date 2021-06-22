package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ThreadCardBottomOpSegmentWeightLayout extends ThreadCommentAndPraiseInfoLayout {
    public AgreeView.d p0;

    /* loaded from: classes3.dex */
    public class a implements AgreeView.d {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.d
        public void a(View view, boolean z) {
            ThreadCardBottomOpSegmentWeightLayout.this.Q(z);
        }
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.p0 = new a();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void I() {
        this.f12494h.setVisibilityListener(this.p0);
        this.f12494h.j(true);
    }

    public final void Q(boolean z) {
        if (R()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12494h.getLayoutParams();
            float f2 = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f2;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.f12494h.setLayoutParams(layoutParams);
        }
    }

    public final boolean R() {
        boolean q = this.f12494h.q();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12494h.getLayoutParams();
        return (layoutParams.weight == (q ? 1.0f : 2.0f) && layoutParams.width == 0) ? false : true;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View i(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(View view) {
        super.p(view);
        this.f12494h.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p0 = new a();
    }
}
