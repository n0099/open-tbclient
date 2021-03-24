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
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class ThreadCardBottomOpSegmentLayout extends ThreadCommentAndPraiseInfoLayout {
    public AgreeView.d k0;

    /* loaded from: classes3.dex */
    public class a implements AgreeView.d {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.d
        public void a(View view, boolean z) {
            ThreadCardBottomOpSegmentLayout.this.T(ThreadCardBottomOpSegmentLayout.this.Y(), z);
        }
    }

    public ThreadCardBottomOpSegmentLayout(Context context) {
        super(context);
        this.k0 = new a();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void J() {
        this.f13492h.setVisibilityListener(this.k0);
        boolean Y = Y();
        if (X(Y) || W(Y)) {
            this.f13492h.j(Y);
            U(Y());
        }
    }

    public final void T(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13492h.getLayoutParams();
        int i = layoutParams.width;
        float f2 = layoutParams.weight;
        if (!z) {
            if (f2 == 0.0f && i == -2) {
                return;
            }
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = l.g(this.F, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.f13492h.setLayoutParams(layoutParams);
            return;
        }
        float f3 = z2 ? 1.0f : 2.0f;
        if (f2 == f3 && i == 0) {
            return;
        }
        layoutParams.width = 0;
        layoutParams.weight = f3;
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.f13492h.setLayoutParams(layoutParams);
    }

    public final void U(boolean z) {
        if (z) {
            V(0, -1, 0, 1.0f, true, this.f13492h.q());
            return;
        }
        V(-2, -1, l.g(getContext(), R.dimen.tbds78), 0.0f, false, this.f13492h.q());
    }

    public final void V(int i, int i2, int i3, float f2, boolean z, boolean z2) {
        this.o.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.C.setLayoutParams(layoutParams);
        this.l.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f2));
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams2.leftMargin = i3;
        this.j.setLayoutParams(layoutParams2);
        this.t.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f2));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams3.leftMargin = i3;
        this.s.setLayoutParams(layoutParams3);
        this.D.setLayoutParams(new LinearLayout.LayoutParams(i, i2, f2));
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.B.getLayoutParams();
        layoutParams4.leftMargin = i3;
        this.B.setLayoutParams(layoutParams4);
        T(z, z2);
    }

    public final boolean W(boolean z) {
        boolean q = this.f13492h.q();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13492h.getLayoutParams();
        int i = layoutParams.width;
        float f2 = layoutParams.weight;
        if (z) {
            return (f2 == (q ? 1.0f : 2.0f) && i == 0) ? false : true;
        }
        return (f2 == 0.0f && i == -2) ? false : true;
    }

    public final boolean X(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
        float f2 = layoutParams.weight;
        int i = layoutParams.width;
        return z ? (f2 == 1.0f && i == 0) ? false : true : (f2 == 0.0f && i == -2) ? false : true;
    }

    public final boolean Y() {
        return this.E != null;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View i(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(View view) {
        super.p(view);
        this.f13492h.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void w() {
        T(Y(), this.f13492h.q());
    }

    public ThreadCardBottomOpSegmentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k0 = new a();
    }
}
