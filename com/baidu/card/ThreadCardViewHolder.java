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
import d.a.n0.b.d;
import d.a.n0.r.q.a;
import d.a.n0.r.q.a2;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends a> extends TypeAdapter.ViewHolder {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f4339e;

    /* renamed from: f  reason: collision with root package name */
    public l0<T> f4340f;

    /* renamed from: g  reason: collision with root package name */
    public b0 f4341g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f4342h;

    /* renamed from: i  reason: collision with root package name */
    public u f4343i;
    public k0 j;
    public d0 k;
    public j l;
    public f m;

    public ThreadCardViewHolder(l0<T> l0Var) {
        super(l0Var.j());
        this.f4340f = l0Var;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View a() {
        return this.f4340f.j();
    }

    public l0<T> b() {
        return this.f4340f;
    }

    public final TbPageContext c() {
        return ((TbPageContextSupport) this.f4340f.j().getContext()).getPageContext();
    }

    public final void d(c cVar) {
        if (cVar == null || cVar.b() == null) {
            return;
        }
        this.f4340f.n(cVar);
    }

    public final boolean e(a2 a2Var) {
        return (a2Var == null || a2Var.T() == null || !a2Var.W1 || !d.h() || a2Var.T().hadConcerned() || ThreadCardUtils.isSelf(a2Var)) ? false : true;
    }

    public void f(T t) {
        NEGFeedBackView nEGFeedBackView;
        if (t == null) {
            this.f4340f.j().setVisibility(8);
            return;
        }
        if (t.i() != null) {
            t.i().z1();
        }
        if (t.i() != null && t.i().T() != null) {
            t.i().T().getName_show();
        }
        boolean z = false;
        this.f4340f.j().setVisibility(0);
        b0 b0Var = this.f4341g;
        if (b0Var != null && b0Var.f43788i != null) {
            if (!t.o() && t.c() != null) {
                this.f4341g.m(t);
                this.f4341g.a(t.c());
                this.f4341g.f43788i.setVisibility(0);
                z = true;
            } else {
                b0 b0Var2 = this.f4341g;
                if (b0Var2 != null && (nEGFeedBackView = b0Var2.f43788i) != null) {
                    nEGFeedBackView.setVisibility(8);
                }
            }
        }
        if (this.f4342h != null) {
            if (e(t.i())) {
                d(this.f4342h);
            } else {
                this.f4342h.l(t);
                this.f4342h.a(t.i());
            }
        }
        k0 k0Var = this.j;
        if (k0Var != null) {
            k0Var.n(z);
            this.j.a(t.i());
        }
        u uVar = this.f4343i;
        if (uVar != null) {
            uVar.a(t.i());
        }
        d0 d0Var = this.k;
        if (d0Var != null) {
            d0Var.n(t);
            this.k.a(t.i());
        }
        j jVar = this.l;
        if (jVar != null) {
            jVar.k(t, z);
            this.l.a(t.i());
        }
        if (this.m != null) {
            if (e(t.i())) {
                this.m.a(t.i());
            } else {
                d(this.m);
            }
        }
        this.f4340f.l(t);
    }

    public void h() {
        this.f4340f.n(this.j);
    }

    public void i(int i2, m0 m0Var) {
        u uVar = this.f4343i;
        if (uVar != null) {
            uVar.t(i2, m0Var);
        }
    }

    public void j(d.a.o0.z.b0<T> b0Var) {
        this.f4340f.p(b0Var);
    }

    public void k(BdUniqueId bdUniqueId) {
        this.f4339e = bdUniqueId;
    }

    public f l() {
        if (this.m == null) {
            this.m = new f(c());
        }
        this.f4340f.b(this.m);
        return this.m;
    }

    public void m(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            d(this.l);
            return;
        }
        if (this.l == null) {
            j jVar = new j(c(), d.V());
            this.l = jVar;
            jVar.q(aVar);
        }
        this.l.r(this.f4339e);
        this.f4340f.b(this.l);
    }

    public u n() {
        return o(true);
    }

    public u o(boolean z) {
        if (this.f4343i == null) {
            this.f4343i = new u(this.f4340f.g());
        }
        this.f4343i.s(this.f4339e);
        this.f4343i.q(z);
        this.f4340f.b(this.f4343i);
        return this.f4343i;
    }

    public b0 p(boolean z) {
        if (this.f4341g == null) {
            b0 b0Var = new b0(c(), z);
            this.f4341g = b0Var;
            b0Var.f43788i.setUniqueId(this.f4339e);
        }
        this.f4340f.b(this.f4341g);
        return this.f4341g;
    }

    public void q(boolean z, Align align, NEGFeedBackView.b bVar) {
        if (!z) {
            d(this.f4341g);
            return;
        }
        if (this.f4341g == null) {
            b0 b0Var = new b0(c(), align);
            this.f4341g = b0Var;
            b0Var.f43788i.setUniqueId(this.f4339e);
            this.f4341g.u(bVar);
        }
        this.f4341g.l(align);
        this.f4340f.b(this.f4341g);
    }

    public d0 r(int i2) {
        if (this.k == null) {
            d0 d0Var = new d0(this.f4340f.j().getContext(), i2);
            this.k = d0Var;
            d0Var.q(this.f4339e);
        }
        this.f4340f.b(this.k);
        return this.k;
    }

    public k0 s() {
        if (this.j == null) {
            k0 k0Var = new k0(c());
            this.j = k0Var;
            k0Var.o(this.f4339e);
        }
        this.f4340f.b(this.j);
        return this.j;
    }

    public void t(boolean z, Align align) {
        if (!z) {
            d(this.f4342h);
            return;
        }
        if (this.f4342h == null) {
            this.f4342h = new r0(c(), align);
        }
        this.f4342h.k(align);
        this.f4340f.b(this.f4342h);
    }
}
