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
import d.a.i.j0;
import d.a.i.k0;
import d.a.i.l0;
import d.a.i.q0;
import d.a.i.u;
import d.a.i0.b.d;
import d.a.i0.r.q.a;
import d.a.i0.r.q.a2;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends a> extends TypeAdapter.ViewHolder {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f4466e;

    /* renamed from: f  reason: collision with root package name */
    public k0<T> f4467f;

    /* renamed from: g  reason: collision with root package name */
    public b0 f4468g;

    /* renamed from: h  reason: collision with root package name */
    public q0 f4469h;

    /* renamed from: i  reason: collision with root package name */
    public u f4470i;
    public j0 j;
    public d0 k;
    public j l;
    public f m;

    public ThreadCardViewHolder(k0<T> k0Var) {
        super(k0Var.j());
        this.f4467f = k0Var;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View a() {
        return this.f4467f.j();
    }

    public k0<T> b() {
        return this.f4467f;
    }

    public final TbPageContext c() {
        return ((TbPageContextSupport) this.f4467f.j().getContext()).getPageContext();
    }

    public final void d(c cVar) {
        if (cVar == null || cVar.b() == null) {
            return;
        }
        this.f4467f.n(cVar);
    }

    public final boolean e(a2 a2Var) {
        return (a2Var == null || a2Var.T() == null || !a2Var.U1 || !d.h() || a2Var.T().hadConcerned() || ThreadCardUtils.isSelf(a2Var)) ? false : true;
    }

    public void f(T t) {
        NEGFeedBackView nEGFeedBackView;
        if (t == null) {
            this.f4467f.j().setVisibility(8);
            return;
        }
        if (t.m() != null) {
            t.m().w1();
        }
        if (t.m() != null && t.m().T() != null) {
            t.m().T().getName_show();
        }
        boolean z = false;
        this.f4467f.j().setVisibility(0);
        b0 b0Var = this.f4468g;
        if (b0Var != null && b0Var.f47696i != null) {
            if (!t.s() && t.h() != null) {
                this.f4468g.m(t);
                this.f4468g.a(t.h());
                this.f4468g.f47696i.setVisibility(0);
                z = true;
            } else {
                b0 b0Var2 = this.f4468g;
                if (b0Var2 != null && (nEGFeedBackView = b0Var2.f47696i) != null) {
                    nEGFeedBackView.setVisibility(8);
                }
            }
        }
        if (this.f4469h != null) {
            if (e(t.m())) {
                d(this.f4469h);
            } else {
                this.f4469h.l(t);
                this.f4469h.a(t.m());
            }
        }
        j0 j0Var = this.j;
        if (j0Var != null) {
            j0Var.n(z);
            this.j.a(t.m());
        }
        u uVar = this.f4470i;
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
        this.f4467f.l(t);
    }

    public void g() {
        this.f4467f.n(this.j);
    }

    public void h(int i2, l0 l0Var) {
        u uVar = this.f4470i;
        if (uVar != null) {
            uVar.t(i2, l0Var);
        }
    }

    public void i(d.a.j0.x.b0<T> b0Var) {
        this.f4467f.p(b0Var);
    }

    public void j(BdUniqueId bdUniqueId) {
        this.f4466e = bdUniqueId;
    }

    public f k() {
        if (this.m == null) {
            this.m = new f(c());
        }
        this.f4467f.b(this.m);
        return this.m;
    }

    public void l(boolean z, FollowUserButton.a aVar) {
        if (!z) {
            d(this.l);
            return;
        }
        if (this.l == null) {
            j jVar = new j(c(), d.T());
            this.l = jVar;
            jVar.q(aVar);
        }
        this.l.r(this.f4466e);
        this.f4467f.b(this.l);
    }

    public u m() {
        return n(true);
    }

    public u n(boolean z) {
        if (this.f4470i == null) {
            this.f4470i = new u(this.f4467f.g());
        }
        this.f4470i.s(this.f4466e);
        this.f4470i.q(z);
        this.f4467f.b(this.f4470i);
        return this.f4470i;
    }

    public b0 o(boolean z) {
        if (this.f4468g == null) {
            b0 b0Var = new b0(c(), z);
            this.f4468g = b0Var;
            b0Var.f47696i.setUniqueId(this.f4466e);
        }
        this.f4467f.b(this.f4468g);
        return this.f4468g;
    }

    public void p(boolean z, Align align, NEGFeedBackView.b bVar) {
        if (!z) {
            d(this.f4468g);
            return;
        }
        if (this.f4468g == null) {
            b0 b0Var = new b0(c(), align);
            this.f4468g = b0Var;
            b0Var.f47696i.setUniqueId(this.f4466e);
            this.f4468g.u(bVar);
        }
        this.f4468g.l(align);
        this.f4467f.b(this.f4468g);
    }

    public d0 q(int i2) {
        if (this.k == null) {
            d0 d0Var = new d0(this.f4467f.j().getContext(), i2);
            this.k = d0Var;
            d0Var.q(this.f4466e);
        }
        this.f4467f.b(this.k);
        return this.k;
    }

    public j0 r() {
        if (this.j == null) {
            j0 j0Var = new j0(c());
            this.j = j0Var;
            j0Var.o(this.f4466e);
        }
        this.f4467f.b(this.j);
        return this.j;
    }

    public void s(boolean z, Align align) {
        if (!z) {
            d(this.f4469h);
            return;
        }
        if (this.f4469h == null) {
            this.f4469h = new q0(c(), align);
        }
        this.f4469h.k(align);
        this.f4467f.b(this.f4469h);
    }
}
