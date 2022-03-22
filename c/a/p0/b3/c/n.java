package c.a.p0.b3.c;

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
/* loaded from: classes2.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m a;

    /* renamed from: b  reason: collision with root package name */
    public b f12617b;

    /* renamed from: c  reason: collision with root package name */
    public i f12618c;

    /* renamed from: d  reason: collision with root package name */
    public a f12619d;

    /* renamed from: e  reason: collision with root package name */
    public c f12620e;

    /* renamed from: f  reason: collision with root package name */
    public h f12621f;

    /* renamed from: g  reason: collision with root package name */
    public e f12622g;

    /* renamed from: h  reason: collision with root package name */
    public k f12623h;
    public d i;
    public c.a.p0.y2.h.d j;
    public c.a.p0.y2.h.a k;
    public p l;
    public c.a.p0.b3.c.q.g m;
    public c.a.p0.b3.c.q.d n;
    public c.a.p0.b3.c.q.i o;
    public c.a.p0.b3.c.q.h p;
    public c.a.p0.b3.c.q.a q;
    public c.a.p0.b3.c.q.c r;
    public c.a.p0.b3.c.q.b s;
    public c.a.p0.b3.c.q.e t;
    public c.a.p0.b3.c.q.f u;
    public List<c.a.d.o.e.a> v;
    public BdTypeRecyclerView w;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.f12617b = new b(tbPageContext);
            this.f12618c = new i(tbPageContext);
            this.f12619d = new a(tbPageContext);
            this.f12620e = new c(tbPageContext);
            this.f12621f = new h(tbPageContext, tbPageContext.getUniqueId());
            this.f12622g = new e(tbPageContext, c.a.p0.b3.e.g.f12718h);
            this.f12623h = new k(tbPageContext);
            this.i = new d(tbPageContext);
            this.j = new c.a.p0.y2.h.d(tbPageContext, c.a.p0.y2.h.f.f20800b);
            this.k = new c.a.p0.y2.h.a(tbPageContext.getPageActivity(), c.a.p0.y2.d.f20780d);
            this.l = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new c.a.p0.b3.c.q.g(tbPageContext, c.a.p0.h0.e0.k.o0);
            this.n = new c.a.p0.b3.c.q.d(tbPageContext, c.a.p0.h0.e0.k.q0);
            this.o = new c.a.p0.b3.c.q.i(tbPageContext, c.a.p0.h0.e0.l.U);
            this.p = new c.a.p0.b3.c.q.h(tbPageContext, c.a.p0.h0.e0.k.r0);
            this.s = new c.a.p0.b3.c.q.b(tbPageContext, c.a.p0.h0.e0.k.t0);
            this.t = new c.a.p0.b3.c.q.e(tbPageContext, c.a.p0.h0.e0.k.s0);
            this.u = new c.a.p0.b3.c.q.f(tbPageContext, c.a.p0.h0.e0.k.u0);
            this.q = new c.a.p0.b3.c.q.a(tbPageContext, c.a.p0.h0.e0.e.N0);
            this.r = new c.a.p0.b3.c.q.c(tbPageContext, c.a.p0.h0.e0.f.N0);
            this.v.add(this.a);
            this.v.add(this.f12617b);
            this.v.add(this.f12618c);
            this.v.add(this.f12619d);
            this.v.add(this.f12620e);
            this.v.add(this.f12621f);
            this.v.add(this.f12622g);
            this.v.add(this.f12623h);
            this.v.add(this.i);
            this.v.add(this.j);
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
            bdTypeRecyclerView.a(this.v);
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
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (list = this.v) == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (aVar instanceof c.a.p0.v.f) {
                ((c.a.p0.v.f) aVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.b0(z);
            this.f12618c.d0(z);
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
            this.m.i = bdUniqueId;
            this.n.i = bdUniqueId;
            this.o.i = bdUniqueId;
            this.p.i = bdUniqueId;
            this.s.i = bdUniqueId;
            this.t.i = bdUniqueId;
            this.u.i = bdUniqueId;
            this.q.i = bdUniqueId;
            this.r.i = bdUniqueId;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.m.f0(i);
            this.n.d0(i);
            this.o.e0(i);
            this.p.d0(i);
            this.q.g0(i);
            this.r.f0(i);
            this.s.f0(i);
            this.t.f0(i);
            this.u.f0(i);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m.g0(i);
            this.n.e0(i);
            this.o.f0(i);
            this.p.e0(i);
            this.q.h0(i);
            this.r.g0(i);
            this.s.g0(i);
            this.t.g0(i);
            this.u.g0(i);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m.h0(i);
            this.n.f0(i);
            this.o.g0(i);
            this.p.f0(i);
            this.q.i0(i);
            this.r.h0(i);
            this.s.h0(i);
            this.t.h0(i);
            this.u.h0(i);
        }
    }
}
