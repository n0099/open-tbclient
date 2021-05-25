package com.baidu.card;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import d.a.i.b0;
import d.a.i.c;
import d.a.i.d0;
import d.a.i.f;
import d.a.i.j;
import d.a.i.k0;
import d.a.i.l0;
import d.a.i.m0;
import d.a.i.r0;
import d.a.i.u;
import d.a.m0.b.d;
import d.a.m0.r.q.a;
import d.a.m0.r.q.a2;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends a> extends TypeAdapter.ViewHolder {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f4320e;

    /* renamed from: f  reason: collision with root package name */
    public l0<T> f4321f;

    /* renamed from: g  reason: collision with root package name */
    public b0 f4322g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f4323h;

    /* renamed from: i  reason: collision with root package name */
    public u f4324i;
    public k0 j;
    public d0 k;
    public j l;
    public f m;

    public ThreadCardViewHolder(l0<T> l0Var) {
        super(l0Var.j());
        this.f4321f = l0Var;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View a() {
        return this.f4321f.j();
    }

    public l0<T> b() {
        return this.f4321f;
    }

    public final TbPageContext c() {
        return ((TbPageContextSupport) this.f4321f.j().getContext()).getPageContext();
    }

    public final void d(c cVar) {
        if (cVar == null || cVar.b() == null) {
            return;
        }
        this.f4321f.n(cVar);
    }

    public final boolean e(a2 a2Var) {
        return (a2Var == null || a2Var.T() == null || !a2Var.V1 || !d.h() || a2Var.T().hadConcerned() || ThreadCardUtils.isSelf(a2Var)) ? false : true;
    }

    public void f(T t) {
        NEGFeedBackView nEGFeedBackView;
        if (t == null) {
            this.f4321f.j().setVisibility(8);
            return;
        }
        if (t.m() != null) {
            t.m().y1();
        }
        if (t.m() != null && t.m().T() != null) {
            t.m().T().getName_show();
        }
        boolean z = false;
        this.f4321f.j().setVisibility(0);
        b0 b0Var = this.f4322g;
        if (b0Var != null && b0Var.f40014i != null) {
            if (!t.s() && t.h() != null) {
                this.f4322g.m(t);
                this.f4322g.a(t.h());
                this.f4322g.f40014i.setVisibility(0);
                z = true;
            } else {
                b0 b0Var2 = this.f4322g;
                if (b0Var2 != null && (nEGFeedBackView = b0Var2.f40014i) != null) {
                    nEGFeedBackView.setVisibility(8);
                }
            }
        }
        if (this.f4323h != null) {
            if (e(t.m())) {
                d(this.f4323h);
            } else {
                this.f4323h.l(t);
                this.f4323h.a(t.m());
            }
        }
        k0 k0Var = this.j;
        if (k0Var != null) {
            k0Var.n(z);
            this.j.a(t.m());
        }
        u uVar = this.f4324i;
        if (uVar != null) {
            uVar.a(t.m());
        }
        d0 d0Var = this.k;
        if (d0Var != null) {
            d0Var.n(t);
            this.k.a(t.m());
        }
        j jVar = this.l;
        if (jVar != null) {
            jVar.k(t, z);
            this.l.a(t.m());
        }
        if (this.m != null) {
            if (e(t.m())) {
                this.m.a(t.m());
            } else {
                d(this.m);
            }
        }
        this.f4321f.l(t);
    }

    public void g() {
        this.f4321f.n(this.j);
    }

    public void h(int i2, m0 m0Var) {
        u uVar = this.f4324i;
        if (uVar != null) {
            uVar.t(i2, m0Var);
        }
    }

    public void i(d.a.n0.z.b0<T> b0Var) {
        this.f4321f.p(b0Var);
    }

    public void j(BdUniqueId bdUniqueId) {
        this.f4320e = bdUniqueId;
    }

    public f k() {
        if (this.m == null) {
            this.m = new f(c());
        }
        this.f4321f.b(this.m);
        return this.m;
    }

    public void l(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            d(this.l);
            return;
        }
        if (this.l == null) {
            j jVar = new j(c(), d.V());
            this.l = jVar;
            jVar.q(aVar);
        }
        this.l.r(this.f4320e);
        this.f4321f.b(this.l);
    }

    public u m() {
        return n(true);
    }

    public u n(boolean z) {
        if (this.f4324i == null) {
            this.f4324i = new u(this.f4321f.g());
        }
        this.f4324i.s(this.f4320e);
        this.f4324i.q(z);
        this.f4321f.b(this.f4324i);
        return this.f4324i;
    }

    public b0 o(boolean z) {
        if (this.f4322g == null) {
            b0 b0Var = new b0(c(), z);
            this.f4322g = b0Var;
            b0Var.f40014i.setUniqueId(this.f4320e);
        }
        this.f4321f.b(this.f4322g);
        return this.f4322g;
    }

    public void p(boolean z, Align align, NEGFeedBackView.b bVar) {
        if (!z) {
            d(this.f4322g);
            return;
        }
        if (this.f4322g == null) {
            b0 b0Var = new b0(c(), align);
            this.f4322g = b0Var;
            b0Var.f40014i.setUniqueId(this.f4320e);
            this.f4322g.u(bVar);
        }
        this.f4322g.l(align);
        this.f4321f.b(this.f4322g);
    }

    public d0 q(int i2) {
        if (this.k == null) {
            d0 d0Var = new d0(this.f4321f.j().getContext(), i2);
            this.k = d0Var;
            d0Var.q(this.f4320e);
        }
        this.f4321f.b(this.k);
        return this.k;
    }

    public k0 r() {
        if (this.j == null) {
            k0 k0Var = new k0(c());
            this.j = k0Var;
            k0Var.o(this.f4320e);
        }
        this.f4321f.b(this.j);
        return this.j;
    }

    public void s(boolean z, Align align) {
        if (!z) {
            d(this.f4323h);
            return;
        }
        if (this.f4323h == null) {
            this.f4323h = new r0(c(), align);
        }
        this.f4323h.k(align);
        this.f4321f.b(this.f4323h);
    }
}
