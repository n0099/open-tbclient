package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.n0.r.q.a2;
/* loaded from: classes3.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12558e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12559f;

    /* renamed from: g  reason: collision with root package name */
    public Context f12560g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12561h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12562i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.f12561h = false;
        this.f12562i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.f12558e = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.f12559f = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.f12560g = context;
    }

    public void b() {
        SkinManager.setViewTextColor(this.f12558e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f12559f, R.color.CAM_X0109);
    }

    public final void c(a2 a2Var) {
        if (this.f12559f == null || a2Var == null || !this.f12562i) {
            return;
        }
        if (a2Var.b1() >= 0) {
            this.f12559f.setVisibility(0);
            this.f12559f.setText(String.format(this.f12560g.getString(R.string.comment_num_tip), StringHelper.numberUniformFormat(a2Var.b1())));
            return;
        }
        this.f12559f.setVisibility(8);
    }

    public final void d(a2 a2Var) {
        if (this.f12559f == null || a2Var == null || !this.l || !a2Var.t2()) {
            return;
        }
        this.f12559f.setVisibility(0);
        this.f12559f.setText(String.format(this.f12560g.getString(R.string.person_view_item_live_share_num), StringHelper.numberUniformFormat((a2Var.s1() == null || a2Var.s1().share_info == null) ? 0 : a2Var.s1().share_info.share_count)));
    }

    public final void e(a2 a2Var) {
        if (this.f12558e == null || a2Var == null || !this.f12561h) {
            return;
        }
        if (a2Var.J1() >= 0) {
            this.f12558e.setVisibility(0);
            this.f12558e.setText(String.format(this.f12560g.getString(R.string.person_view_num), StringHelper.numberUniformFormat(a2Var.J1())));
            return;
        }
        this.f12558e.setVisibility(8);
    }

    public final void f(a2 a2Var) {
        if (this.f12558e == null || a2Var == null || !this.j || a2Var.s1() == null || !a2Var.t2()) {
            return;
        }
        this.f12558e.setVisibility(0);
        this.f12558e.setText(String.format(this.f12560g.getString(R.string.person_view_item_live_watch_num), StringHelper.numberUniformFormat(a2Var.s1().audience_count)));
    }

    public final void g(a2 a2Var) {
        if (this.f12559f == null || a2Var == null || !this.k || !a2Var.t2()) {
            return;
        }
        this.f12559f.setVisibility(0);
        this.f12559f.setText(String.format(this.f12560g.getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormat(a2Var.M())));
    }

    public void setData(a2 a2Var) {
        if (a2Var == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        f(a2Var);
        e(a2Var);
        c(a2Var);
        g(a2Var);
        d(a2Var);
    }

    public void setIsShowAudienceNum(boolean z) {
        this.j = z;
    }

    public void setIsShowReadNum(boolean z) {
        this.f12561h = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.f12562i = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.l = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.k = z;
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12561h = false;
        this.f12562i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        a(context);
    }
}
