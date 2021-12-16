package c.a.s0.x2.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m a;

    /* renamed from: b  reason: collision with root package name */
    public b f25587b;

    /* renamed from: c  reason: collision with root package name */
    public i f25588c;

    /* renamed from: d  reason: collision with root package name */
    public a f25589d;

    /* renamed from: e  reason: collision with root package name */
    public c f25590e;

    /* renamed from: f  reason: collision with root package name */
    public h f25591f;

    /* renamed from: g  reason: collision with root package name */
    public e f25592g;

    /* renamed from: h  reason: collision with root package name */
    public k f25593h;

    /* renamed from: i  reason: collision with root package name */
    public d f25594i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.u2.g.d f25595j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.s0.u2.g.a f25596k;
    public p l;
    public c.a.s0.x2.c.q.g m;
    public c.a.s0.x2.c.q.d n;
    public c.a.s0.x2.c.q.i o;
    public c.a.s0.x2.c.q.h p;
    public c.a.s0.x2.c.q.a q;
    public c.a.s0.x2.c.q.c r;
    public c.a.s0.x2.c.q.b s;
    public c.a.s0.x2.c.q.e t;
    public c.a.s0.x2.c.q.f u;
    public List<c.a.d.m.e.a> v;
    public BdTypeRecyclerView w;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new ArrayList();
        a(tbPageContext, bdTypeRecyclerView);
        e(bdUniqueId);
    }

    public final void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, bdTypeRecyclerView) == null) {
            this.w = bdTypeRecyclerView;
            this.a = new m(tbPageContext);
            this.f25587b = new b(tbPageContext);
            this.f25588c = new i(tbPageContext);
            this.f25589d = new a(tbPageContext);
            this.f25590e = new c(tbPageContext);
            this.f25591f = new h(tbPageContext, tbPageContext.getUniqueId());
            this.f25592g = new e(tbPageContext, c.a.s0.x2.e.g.l);
            this.f25593h = new k(tbPageContext);
            this.f25594i = new d(tbPageContext);
            this.f25595j = new c.a.s0.u2.g.d(tbPageContext, c.a.s0.u2.g.f.f24608f);
            this.f25596k = new c.a.s0.u2.g.a(tbPageContext.getPageActivity(), c.a.s0.u2.d.f24589h);
            this.l = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new c.a.s0.x2.c.q.g(tbPageContext, c.a.s0.g0.f0.k.v0);
            this.n = new c.a.s0.x2.c.q.d(tbPageContext, c.a.s0.g0.f0.k.x0);
            this.o = new c.a.s0.x2.c.q.i(tbPageContext, c.a.s0.g0.f0.l.Z);
            this.p = new c.a.s0.x2.c.q.h(tbPageContext, c.a.s0.g0.f0.k.y0);
            this.s = new c.a.s0.x2.c.q.b(tbPageContext, c.a.s0.g0.f0.k.A0);
            this.t = new c.a.s0.x2.c.q.e(tbPageContext, c.a.s0.g0.f0.k.z0);
            this.u = new c.a.s0.x2.c.q.f(tbPageContext, c.a.s0.g0.f0.k.B0);
            this.q = new c.a.s0.x2.c.q.a(tbPageContext, c.a.s0.g0.f0.e.T0);
            this.r = new c.a.s0.x2.c.q.c(tbPageContext, c.a.s0.g0.f0.f.T0);
            this.v.add(this.a);
            this.v.add(this.f25587b);
            this.v.add(this.f25588c);
            this.v.add(this.f25589d);
            this.v.add(this.f25590e);
            this.v.add(this.f25591f);
            this.v.add(this.f25592g);
            this.v.add(this.f25593h);
            this.v.add(this.f25594i);
            this.v.add(this.f25595j);
            this.v.add(this.f25596k);
            this.v.add(this.l);
            this.v.add(this.m);
            this.v.add(this.n);
            this.v.add(this.o);
            this.v.add(this.p);
            this.v.add(this.s);
            this.v.add(this.t);
            this.v.add(this.u);
            this.v.add(this.q);
            this.v.add(this.r);
            bdTypeRecyclerView.addAdapters(this.v);
            c("page_recommend");
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.w.getListAdapter() == null) {
            return;
        }
        this.w.getListAdapter().notifyDataSetChanged();
    }

    public final void c(String str) {
        List<c.a.d.m.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (list = this.v) == null) {
            return;
        }
        for (c.a.d.m.e.a aVar : list) {
            if (aVar instanceof c.a.s0.t.f) {
                ((c.a.s0.t.f) aVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.i0(z);
            this.f25588c.k0(z);
            this.m.l0(z);
            this.n.j0(z);
            this.o.k0(z);
            this.p.j0(z);
            this.q.m0(z);
            this.r.l0(z);
            this.s.l0(z);
            this.t.l0(z);
            this.u.l0(z);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.m.m = bdUniqueId;
            this.n.m = bdUniqueId;
            this.o.m = bdUniqueId;
            this.p.m = bdUniqueId;
            this.s.m = bdUniqueId;
            this.t.m = bdUniqueId;
            this.u.m = bdUniqueId;
            this.q.m = bdUniqueId;
            this.r.m = bdUniqueId;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.m.m0(i2);
            this.n.k0(i2);
            this.o.l0(i2);
            this.p.k0(i2);
            this.q.n0(i2);
            this.r.m0(i2);
            this.s.m0(i2);
            this.t.m0(i2);
            this.u.m0(i2);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.m.n0(i2);
            this.n.l0(i2);
            this.o.m0(i2);
            this.p.l0(i2);
            this.q.o0(i2);
            this.r.n0(i2);
            this.s.n0(i2);
            this.t.n0(i2);
            this.u.n0(i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.m.o0(i2);
            this.n.m0(i2);
            this.o.n0(i2);
            this.p.m0(i2);
            this.q.p0(i2);
            this.r.o0(i2);
            this.s.o0(i2);
            this.t.o0(i2);
            this.u.o0(i2);
        }
    }
}
