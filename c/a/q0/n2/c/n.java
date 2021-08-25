package c.a.q0.n2.c;

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
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public m f22477a;

    /* renamed from: b  reason: collision with root package name */
    public b f22478b;

    /* renamed from: c  reason: collision with root package name */
    public i f22479c;

    /* renamed from: d  reason: collision with root package name */
    public a f22480d;

    /* renamed from: e  reason: collision with root package name */
    public c f22481e;

    /* renamed from: f  reason: collision with root package name */
    public h f22482f;

    /* renamed from: g  reason: collision with root package name */
    public e f22483g;

    /* renamed from: h  reason: collision with root package name */
    public k f22484h;

    /* renamed from: i  reason: collision with root package name */
    public d f22485i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.k2.g.d f22486j;
    public c.a.q0.k2.g.a k;
    public p l;
    public c.a.q0.n2.c.q.g m;
    public c.a.q0.n2.c.q.d n;
    public c.a.q0.n2.c.q.i o;
    public c.a.q0.n2.c.q.h p;
    public c.a.q0.n2.c.q.a q;
    public c.a.q0.n2.c.q.c r;
    public c.a.q0.n2.c.q.b s;
    public c.a.q0.n2.c.q.e t;
    public c.a.q0.n2.c.q.f u;
    public List<c.a.e.l.e.a> v;
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
            this.f22477a = new m(tbPageContext);
            this.f22478b = new b(tbPageContext);
            this.f22479c = new i(tbPageContext);
            this.f22480d = new a(tbPageContext);
            this.f22481e = new c(tbPageContext);
            this.f22482f = new h(tbPageContext, tbPageContext.getUniqueId());
            this.f22483g = new e(tbPageContext, c.a.q0.n2.e.g.l);
            this.f22484h = new k(tbPageContext);
            this.f22485i = new d(tbPageContext);
            this.f22486j = new c.a.q0.k2.g.d(tbPageContext, c.a.q0.k2.g.f.f21503f);
            this.k = new c.a.q0.k2.g.a(tbPageContext.getPageActivity(), c.a.q0.k2.d.f21480h);
            this.l = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new c.a.q0.n2.c.q.g(tbPageContext, c.a.q0.a0.d0.k.s0);
            this.n = new c.a.q0.n2.c.q.d(tbPageContext, c.a.q0.a0.d0.k.u0);
            this.o = new c.a.q0.n2.c.q.i(tbPageContext, c.a.q0.a0.d0.l.X);
            this.p = new c.a.q0.n2.c.q.h(tbPageContext, c.a.q0.a0.d0.k.v0);
            this.s = new c.a.q0.n2.c.q.b(tbPageContext, c.a.q0.a0.d0.k.x0);
            this.t = new c.a.q0.n2.c.q.e(tbPageContext, c.a.q0.a0.d0.k.w0);
            this.u = new c.a.q0.n2.c.q.f(tbPageContext, c.a.q0.a0.d0.k.y0);
            this.q = new c.a.q0.n2.c.q.a(tbPageContext, c.a.q0.a0.d0.e.P0);
            this.r = new c.a.q0.n2.c.q.c(tbPageContext, c.a.q0.a0.d0.f.P0);
            this.v.add(this.f22477a);
            this.v.add(this.f22478b);
            this.v.add(this.f22479c);
            this.v.add(this.f22480d);
            this.v.add(this.f22481e);
            this.v.add(this.f22482f);
            this.v.add(this.f22483g);
            this.v.add(this.f22484h);
            this.v.add(this.f22485i);
            this.v.add(this.f22486j);
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
        List<c.a.e.l.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (list = this.v) == null) {
            return;
        }
        for (c.a.e.l.e.a aVar : list) {
            if (aVar instanceof c.a.q0.o.f) {
                ((c.a.q0.o.f) aVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.j0(z);
            this.f22479c.l0(z);
            this.m.m0(z);
            this.n.k0(z);
            this.o.l0(z);
            this.p.k0(z);
            this.q.n0(z);
            this.r.m0(z);
            this.s.m0(z);
            this.t.m0(z);
            this.u.m0(z);
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

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
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

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.m.p0(i2);
            this.n.n0(i2);
            this.o.o0(i2);
            this.p.n0(i2);
            this.q.q0(i2);
            this.r.p0(i2);
            this.s.p0(i2);
            this.t.p0(i2);
            this.u.p0(i2);
        }
    }
}
