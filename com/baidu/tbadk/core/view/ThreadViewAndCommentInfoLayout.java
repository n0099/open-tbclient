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
import d.a.m0.r.q.a2;
/* loaded from: classes3.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12414e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12415f;

    /* renamed from: g  reason: collision with root package name */
    public Context f12416g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12417h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12418i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.f12417h = false;
        this.f12418i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.f12414e = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.f12415f = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.f12416g = context;
    }

    public void b() {
        SkinManager.setViewTextColor(this.f12414e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f12415f, R.color.CAM_X0109);
    }

    public final void c(a2 a2Var) {
        if (this.f12415f == null || a2Var == null || !this.f12418i) {
            return;
        }
        if (a2Var.a1() >= 0) {
            this.f12415f.setVisibility(0);
            this.f12415f.setText(String.format(this.f12416g.getString(R.string.comment_num_tip), StringHelper.numberUniformFormat(a2Var.a1())));
            return;
        }
        this.f12415f.setVisibility(8);
    }

    public final void d(a2 a2Var) {
        if (this.f12415f == null || a2Var == null || !this.l || !a2Var.s2()) {
            return;
        }
        this.f12415f.setVisibility(0);
        this.f12415f.setText(String.format(this.f12416g.getString(R.string.person_view_item_live_share_num), StringHelper.numberUniformFormat((a2Var.r1() == null || a2Var.r1().share_info == null) ? 0 : a2Var.r1().share_info.share_count)));
    }

    public final void e(a2 a2Var) {
        if (this.f12414e == null || a2Var == null || !this.f12417h) {
            return;
        }
        if (a2Var.I1() >= 0) {
            this.f12414e.setVisibility(0);
            this.f12414e.setText(String.format(this.f12416g.getString(R.string.person_view_num), StringHelper.numberUniformFormat(a2Var.I1())));
            return;
        }
        this.f12414e.setVisibility(8);
    }

    public final void f(a2 a2Var) {
        if (this.f12414e == null || a2Var == null || !this.j || a2Var.r1() == null || !a2Var.s2()) {
            return;
        }
        this.f12414e.setVisibility(0);
        this.f12414e.setText(String.format(this.f12416g.getString(R.string.person_view_item_live_watch_num), StringHelper.numberUniformFormat(a2Var.r1().audience_count)));
    }

    public final void g(a2 a2Var) {
        if (this.f12415f == null || a2Var == null || !this.k || !a2Var.s2()) {
            return;
        }
        this.f12415f.setVisibility(0);
        this.f12415f.setText(String.format(this.f12416g.getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormat(a2Var.M())));
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
        this.f12417h = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.f12418i = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.l = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.k = z;
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12417h = false;
        this.f12418i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        a(context);
    }
}
