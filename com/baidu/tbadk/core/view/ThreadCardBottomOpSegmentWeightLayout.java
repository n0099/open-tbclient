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
    public AgreeView.d k0;

    /* loaded from: classes3.dex */
    public class a implements AgreeView.d {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.d
        public void a(View view, boolean z) {
            ThreadCardBottomOpSegmentWeightLayout.this.S(z);
        }
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context) {
        super(context);
        this.k0 = new a();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void J() {
        this.f13493h.setVisibilityListener(this.k0);
        this.f13493h.j(true);
    }

    public final void S(boolean z) {
        if (T()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13493h.getLayoutParams();
            float f2 = z ? 1.0f : 2.0f;
            layoutParams.width = 0;
            layoutParams.weight = f2;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.f13493h.setLayoutParams(layoutParams);
        }
    }

    public final boolean T() {
        boolean q = this.f13493h.q();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13493h.getLayoutParams();
        return (layoutParams.weight == (q ? 1.0f : 2.0f) && layoutParams.width == 0) ? false : true;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View i(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.weight_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(View view) {
        super.p(view);
        this.f13493h.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    public ThreadCardBottomOpSegmentWeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k0 = new a();
    }
}
