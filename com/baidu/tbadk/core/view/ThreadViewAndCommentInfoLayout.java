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
import d.b.h0.r.q.a2;
/* loaded from: classes3.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f13546e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13547f;

    /* renamed from: g  reason: collision with root package name */
    public Context f13548g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13549h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.f13549h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.f13546e = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.f13547f = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.f13548g = context;
    }

    public void b() {
        SkinManager.setViewTextColor(this.f13546e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f13547f, R.color.CAM_X0109);
    }

    public final void c(a2 a2Var) {
        if (this.f13547f == null || a2Var == null || !this.i) {
            return;
        }
        if (a2Var.Z0() >= 0) {
            this.f13547f.setVisibility(0);
            this.f13547f.setText(String.format(this.f13548g.getString(R.string.comment_num_tip), StringHelper.numberUniformFormat(a2Var.Z0())));
            return;
        }
        this.f13547f.setVisibility(8);
    }

    public final void d(a2 a2Var) {
        if (this.f13547f == null || a2Var == null || !this.l || !a2Var.p2()) {
            return;
        }
        this.f13547f.setVisibility(0);
        this.f13547f.setText(String.format(this.f13548g.getString(R.string.person_view_item_live_share_num), StringHelper.numberUniformFormat((a2Var.q1() == null || a2Var.q1().share_info == null) ? 0 : a2Var.q1().share_info.share_count)));
    }

    public final void e(a2 a2Var) {
        if (this.f13546e == null || a2Var == null || !this.f13549h) {
            return;
        }
        if (a2Var.G1() >= 0) {
            this.f13546e.setVisibility(0);
            this.f13546e.setText(String.format(this.f13548g.getString(R.string.person_view_num), StringHelper.numberUniformFormat(a2Var.G1())));
            return;
        }
        this.f13546e.setVisibility(8);
    }

    public final void f(a2 a2Var) {
        if (this.f13546e == null || a2Var == null || !this.j || a2Var.q1() == null || !a2Var.p2()) {
            return;
        }
        this.f13546e.setVisibility(0);
        this.f13546e.setText(String.format(this.f13548g.getString(R.string.person_view_item_live_watch_num), StringHelper.numberUniformFormat(a2Var.q1().audience_count)));
    }

    public final void g(a2 a2Var) {
        if (this.f13547f == null || a2Var == null || !this.k || !a2Var.p2()) {
            return;
        }
        this.f13547f.setVisibility(0);
        this.f13547f.setText(String.format(this.f13548g.getString(R.string.person_view_item_live_zan_num), StringHelper.numberUniformFormat(a2Var.M())));
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
        this.f13549h = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.i = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.l = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.k = z;
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13549h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        a(context);
    }
}
