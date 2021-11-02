package b.a.r0.p2.c;

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
/* loaded from: classes5.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public m f22158a;

    /* renamed from: b  reason: collision with root package name */
    public b f22159b;

    /* renamed from: c  reason: collision with root package name */
    public i f22160c;

    /* renamed from: d  reason: collision with root package name */
    public a f22161d;

    /* renamed from: e  reason: collision with root package name */
    public c f22162e;

    /* renamed from: f  reason: collision with root package name */
    public h f22163f;

    /* renamed from: g  reason: collision with root package name */
    public e f22164g;

    /* renamed from: h  reason: collision with root package name */
    public k f22165h;

    /* renamed from: i  reason: collision with root package name */
    public d f22166i;
    public b.a.r0.m2.g.d j;
    public b.a.r0.m2.g.a k;
    public p l;
    public b.a.r0.p2.c.q.g m;
    public b.a.r0.p2.c.q.d n;
    public b.a.r0.p2.c.q.i o;
    public b.a.r0.p2.c.q.h p;
    public b.a.r0.p2.c.q.a q;
    public b.a.r0.p2.c.q.c r;
    public b.a.r0.p2.c.q.b s;
    public b.a.r0.p2.c.q.e t;
    public b.a.r0.p2.c.q.f u;
    public List<b.a.e.l.e.a> v;
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
            this.f22158a = new m(tbPageContext);
            this.f22159b = new b(tbPageContext);
            this.f22160c = new i(tbPageContext);
            this.f22161d = new a(tbPageContext);
            this.f22162e = new c(tbPageContext);
            this.f22163f = new h(tbPageContext, tbPageContext.getUniqueId());
            this.f22164g = new e(tbPageContext, b.a.r0.p2.e.g.l);
            this.f22165h = new k(tbPageContext);
            this.f22166i = new d(tbPageContext);
            this.j = new b.a.r0.m2.g.d(tbPageContext, b.a.r0.m2.g.f.f21184f);
            this.k = new b.a.r0.m2.g.a(tbPageContext.getPageActivity(), b.a.r0.m2.d.f21161h);
            this.l = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new b.a.r0.p2.c.q.g(tbPageContext, b.a.r0.b0.e0.k.s0);
            this.n = new b.a.r0.p2.c.q.d(tbPageContext, b.a.r0.b0.e0.k.u0);
            this.o = new b.a.r0.p2.c.q.i(tbPageContext, b.a.r0.b0.e0.l.X);
            this.p = new b.a.r0.p2.c.q.h(tbPageContext, b.a.r0.b0.e0.k.v0);
            this.s = new b.a.r0.p2.c.q.b(tbPageContext, b.a.r0.b0.e0.k.x0);
            this.t = new b.a.r0.p2.c.q.e(tbPageContext, b.a.r0.b0.e0.k.w0);
            this.u = new b.a.r0.p2.c.q.f(tbPageContext, b.a.r0.b0.e0.k.y0);
            this.q = new b.a.r0.p2.c.q.a(tbPageContext, b.a.r0.b0.e0.e.P0);
            this.r = new b.a.r0.p2.c.q.c(tbPageContext, b.a.r0.b0.e0.f.P0);
            this.v.add(this.f22158a);
            this.v.add(this.f22159b);
            this.v.add(this.f22160c);
            this.v.add(this.f22161d);
            this.v.add(this.f22162e);
            this.v.add(this.f22163f);
            this.v.add(this.f22164g);
            this.v.add(this.f22165h);
            this.v.add(this.f22166i);
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
        List<b.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (list = this.v) == null) {
            return;
        }
        for (b.a.e.l.e.a aVar : list) {
            if (aVar instanceof b.a.r0.p.f) {
                ((b.a.r0.p.f) aVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.i0(z);
            this.f22160c.k0(z);
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
