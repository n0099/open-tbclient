package c.a.t0.y2.c;

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
/* loaded from: classes9.dex */
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
    public c.a.t0.v2.g.d f25595j;
    public c.a.t0.v2.g.a k;
    public p l;
    public c.a.t0.y2.c.q.g m;
    public c.a.t0.y2.c.q.d n;
    public c.a.t0.y2.c.q.i o;
    public c.a.t0.y2.c.q.h p;
    public c.a.t0.y2.c.q.a q;
    public c.a.t0.y2.c.q.c r;
    public c.a.t0.y2.c.q.b s;
    public c.a.t0.y2.c.q.e t;
    public c.a.t0.y2.c.q.f u;
    public List<c.a.d.n.e.a> v;
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
            this.f25592g = new e(tbPageContext, c.a.t0.y2.e.g.l);
            this.f25593h = new k(tbPageContext);
            this.f25594i = new d(tbPageContext);
            this.f25595j = new c.a.t0.v2.g.d(tbPageContext, c.a.t0.v2.g.f.f24716f);
            this.k = new c.a.t0.v2.g.a(tbPageContext.getPageActivity(), c.a.t0.v2.d.f24697h);
            this.l = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new c.a.t0.y2.c.q.g(tbPageContext, c.a.t0.g0.f0.k.v0);
            this.n = new c.a.t0.y2.c.q.d(tbPageContext, c.a.t0.g0.f0.k.x0);
            this.o = new c.a.t0.y2.c.q.i(tbPageContext, c.a.t0.g0.f0.l.Z);
            this.p = new c.a.t0.y2.c.q.h(tbPageContext, c.a.t0.g0.f0.k.y0);
            this.s = new c.a.t0.y2.c.q.b(tbPageContext, c.a.t0.g0.f0.k.A0);
            this.t = new c.a.t0.y2.c.q.e(tbPageContext, c.a.t0.g0.f0.k.z0);
            this.u = new c.a.t0.y2.c.q.f(tbPageContext, c.a.t0.g0.f0.k.B0);
            this.q = new c.a.t0.y2.c.q.a(tbPageContext, c.a.t0.g0.f0.e.U0);
            this.r = new c.a.t0.y2.c.q.c(tbPageContext, c.a.t0.g0.f0.f.U0);
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
            this.v.add(this.k);
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
        List<c.a.d.n.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (list = this.v) == null) {
            return;
        }
        for (c.a.d.n.e.a aVar : list) {
            if (aVar instanceof c.a.t0.t.f) {
                ((c.a.t0.t.f) aVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.b0(z);
            this.f25588c.d0(z);
            this.m.e0(z);
            this.n.c0(z);
            this.o.d0(z);
            this.p.c0(z);
            this.q.f0(z);
            this.r.e0(z);
            this.s.e0(z);
            this.t.e0(z);
            this.u.e0(z);
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
            this.m.f0(i2);
            this.n.d0(i2);
            this.o.e0(i2);
            this.p.d0(i2);
            this.q.g0(i2);
            this.r.f0(i2);
            this.s.f0(i2);
            this.t.f0(i2);
            this.u.f0(i2);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.m.g0(i2);
            this.n.e0(i2);
            this.o.f0(i2);
            this.p.e0(i2);
            this.q.h0(i2);
            this.r.g0(i2);
            this.s.g0(i2);
            this.t.g0(i2);
            this.u.g0(i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.m.h0(i2);
            this.n.f0(i2);
            this.o.g0(i2);
            this.p.f0(i2);
            this.q.i0(i2);
            this.r.h0(i2);
            this.s.h0(i2);
            this.t.h0(i2);
            this.u.h0(i2);
        }
    }
}
