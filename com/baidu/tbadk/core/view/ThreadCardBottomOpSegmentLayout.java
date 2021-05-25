package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class ThreadCardBottomOpSegmentLayout extends ThreadCommentAndPraiseInfoLayout {
    public AgreeView.d k0;

    /* loaded from: classes3.dex */
    public class a implements AgreeView.d {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.d
        public void a(View view, boolean z) {
            ThreadCardBottomOpSegmentLayout.this.R(ThreadCardBottomOpSegmentLayout.this.X(), z);
        }
    }

    public ThreadCardBottomOpSegmentLayout(Context context) {
        super(context);
        this.k0 = new a();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void I() {
        this.f12350h.setVisibilityListener(this.k0);
        boolean X = X();
        if (W(X) || V(X)) {
            this.f12350h.j(X);
            S(X());
        }
    }

    public final void R(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12350h.getLayoutParams();
        int i2 = layoutParams.width;
        float f2 = layoutParams.weight;
        if (!z) {
            if (f2 == 0.0f && i2 == -2) {
                return;
            }
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = l.g(this.F, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.f12350h.setLayoutParams(layoutParams);
            return;
        }
        float f3 = z2 ? 1.0f : 2.0f;
        if (f2 == f3 && i2 == 0) {
            return;
        }
        layoutParams.width = 0;
        layoutParams.weight = f3;
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.f12350h.setLayoutParams(layoutParams);
    }

    public final void S(boolean z) {
        if (z) {
            T(0, -1, 0, 1.0f, true, this.f12350h.q());
            return;
        }
        T(-2, -1, l.g(getContext(), R.dimen.tbds78), 0.0f, false, this.f12350h.q());
    }

    public final void T(int i2, int i3, int i4, float f2, boolean z, boolean z2) {
        this.o.setLayoutParams(new LinearLayout.LayoutParams(i2, i3, f2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.C.setLayoutParams(layoutParams);
        this.l.setLayoutParams(new LinearLayout.LayoutParams(i2, i3, f2));
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams2.leftMargin = i4;
        this.j.setLayoutParams(layoutParams2);
        this.t.setLayoutParams(new LinearLayout.LayoutParams(i2, i3, f2));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams3.leftMargin = i4;
        this.s.setLayoutParams(layoutParams3);
        this.D.setLayoutParams(new LinearLayout.LayoutParams(i2, i3, f2));
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.B.getLayoutParams();
        layoutParams4.leftMargin = i4;
        this.B.setLayoutParams(layoutParams4);
        R(z, z2);
    }

    public final boolean V(boolean z) {
        boolean q = this.f12350h.q();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12350h.getLayoutParams();
        int i2 = layoutParams.width;
        float f2 = layoutParams.weight;
        if (z) {
            return (f2 == (q ? 1.0f : 2.0f) && i2 == 0) ? false : true;
        }
        return (f2 == 0.0f && i2 == -2) ? false : true;
    }

    public final boolean W(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
        float f2 = layoutParams.weight;
        int i2 = layoutParams.width;
        return z ? (f2 == 1.0f && i2 == 0) ? false : true : (f2 == 0.0f && i2 == -2) ? false : true;
    }

    public final boolean X() {
        return this.E != null;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View i(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(View view) {
        super.p(view);
        this.f12350h.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v() {
        R(X(), this.f12350h.q());
    }

    public ThreadCardBottomOpSegmentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k0 = new a();
    }
}
