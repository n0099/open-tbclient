package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.FollowUserButton;
import d.b.h0.b.d;
import d.b.h0.r.q.a;
import d.b.h0.r.q.a2;
import d.b.i.b0;
import d.b.i.c;
import d.b.i.d0;
import d.b.i.f;
import d.b.i.j;
import d.b.i.j0;
import d.b.i.k0;
import d.b.i.l0;
import d.b.i.q0;
import d.b.i.u;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends a> extends TypeAdapter.ViewHolder {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f4352e;

    /* renamed from: f  reason: collision with root package name */
    public k0<T> f4353f;

    /* renamed from: g  reason: collision with root package name */
    public b0 f4354g;

    /* renamed from: h  reason: collision with root package name */
    public q0 f4355h;
    public u i;
    public j0 j;
    public d0 k;
    public j l;
    public f m;

    public ThreadCardViewHolder(k0<T> k0Var) {
        super(k0Var.j());
        this.f4353f = k0Var;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View a() {
        return this.f4353f.j();
    }

    public k0<T> b() {
        return this.f4353f;
    }

    public final TbPageContext c() {
        return ((TbPageContextSupport) this.f4353f.j().getContext()).getPageContext();
    }

    public final void d(c cVar) {
        if (cVar == null || cVar.b() == null) {
            return;
        }
        this.f4353f.n(cVar);
    }

    public final boolean e(a2 a2Var) {
        return (a2Var == null || a2Var.T() == null || !a2Var.U1 || !d.h() || a2Var.T().hadConcerned() || ThreadCardUtils.isSelf(a2Var)) ? false : true;
    }

    public void f(T t) {
        NEGFeedBackView nEGFeedBackView;
        if (t == null) {
            this.f4353f.j().setVisibility(8);
            return;
        }
        if (t.n() != null) {
            t.n().w1();
        }
        if (t.n() != null && t.n().T() != null) {
            t.n().T().getName_show();
        }
        boolean z = false;
        this.f4353f.j().setVisibility(0);
        b0 b0Var = this.f4354g;
        if (b0Var != null && b0Var.i != null) {
            if (!t.s() && t.g() != null) {
                this.f4354g.m(t);
                this.f4354g.a(t.g());
                this.f4354g.i.setVisibility(0);
                z = true;
            } else {
                b0 b0Var2 = this.f4354g;
                if (b0Var2 != null && (nEGFeedBackView = b0Var2.i) != null) {
                    nEGFeedBackView.setVisibility(8);
                }
            }
        }
        if (this.f4355h != null) {
            if (e(t.n())) {
                d(this.f4355h);
            } else {
                this.f4355h.l(t);
                this.f4355h.a(t.n());
            }
        }
        j0 j0Var = this.j;
        if (j0Var != null) {
            j0Var.n(z);
            this.j.a(t.n());
        }
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(t.n());
        }
        d0 d0Var = this.k;
        if (d0Var != null) {
            d0Var.n(t);
            this.k.a(t.n());
        }
        j jVar = this.l;
        if (jVar != null) {
            jVar.k(t, z);
            this.l.a(t.n());
        }
        if (this.m != null) {
            if (e(t.n())) {
                this.m.a(t.n());
            } else {
                d(this.m);
            }
        }
        this.f4353f.l(t);
    }

    public void h() {
        this.f4353f.n(this.j);
    }

    public void i(int i, l0 l0Var) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.t(i, l0Var);
        }
    }

    public void j(d.b.i0.x.b0<T> b0Var) {
        this.f4353f.p(b0Var);
    }

    public void k(BdUniqueId bdUniqueId) {
        this.f4352e = bdUniqueId;
    }

    public f l() {
        if (this.m == null) {
            this.m = new f(c());
        }
        this.f4353f.b(this.m);
        return this.m;
    }

    public void m(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            d(this.l);
            return;
        }
        if (this.l == null) {
            j jVar = new j(c(), d.R());
            this.l = jVar;
            jVar.q(aVar);
        }
        this.l.r(this.f4352e);
        this.f4353f.b(this.l);
    }

    public u n() {
        return o(true);
    }

    public u o(boolean z) {
        if (this.i == null) {
            this.i = new u(this.f4353f.g());
        }
        this.i.s(this.f4352e);
        this.i.q(z);
        this.f4353f.b(this.i);
        return this.i;
    }

    public b0 p(boolean z) {
        if (this.f4354g == null) {
            b0 b0Var = new b0(c(), z);
            this.f4354g = b0Var;
            b0Var.i.setUniqueId(this.f4352e);
        }
        this.f4353f.b(this.f4354g);
        return this.f4354g;
    }

    public void q(boolean z, Align align, NEGFeedBackView.b bVar) {
        if (!z) {
            d(this.f4354g);
            return;
        }
        if (this.f4354g == null) {
            b0 b0Var = new b0(c(), align);
            this.f4354g = b0Var;
            b0Var.i.setUniqueId(this.f4352e);
            this.f4354g.u(bVar);
        }
        this.f4354g.l(align);
        this.f4353f.b(this.f4354g);
    }

    public d0 r(int i) {
        if (this.k == null) {
            d0 d0Var = new d0(this.f4353f.j().getContext(), i);
            this.k = d0Var;
            d0Var.q(this.f4352e);
        }
        this.f4353f.b(this.k);
        return this.k;
    }

    public j0 s() {
        if (this.j == null) {
            j0 j0Var = new j0(c());
            this.j = j0Var;
            j0Var.o(this.f4352e);
        }
        this.f4353f.b(this.j);
        return this.j;
    }

    public void u(boolean z, Align align) {
        if (!z) {
            d(this.f4355h);
            return;
        }
        if (this.f4355h == null) {
            this.f4355h = new q0(c(), align);
        }
        this.f4355h.k(align);
        this.f4353f.b(this.f4355h);
    }
}
