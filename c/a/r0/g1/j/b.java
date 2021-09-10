package c.a.r0.g1.j;

import c.a.q0.s.q.d2;
import c.a.q0.s.q.v1;
import c.a.q0.s.q.x;
import c.a.r0.g1.j.g.g;
import c.a.r0.g1.j.g.h;
import c.a.r0.g1.j.g.i;
import c.a.r0.g1.j.g.j;
import c.a.r0.g1.j.g.k;
import c.a.r0.g1.j.g.l;
import c.a.r0.g1.j.g.m;
import c.a.r0.g1.j.g.n;
import c.a.r0.g1.j.g.o;
import c.a.r0.g1.j.g.p;
import c.a.r0.g1.j.g.q;
import c.a.r0.g1.j.g.r;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f18403a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f18404b;

    /* renamed from: c  reason: collision with root package name */
    public q f18405c;

    /* renamed from: d  reason: collision with root package name */
    public j f18406d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.g1.j.g.e f18407e;

    /* renamed from: f  reason: collision with root package name */
    public g f18408f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.g1.j.g.f f18409g;

    /* renamed from: h  reason: collision with root package name */
    public h f18410h;

    /* renamed from: i  reason: collision with root package name */
    public r f18411i;

    /* renamed from: j  reason: collision with root package name */
    public i f18412j;
    public l k;
    public n l;
    public m m;
    public p n;
    public c.a.r0.g1.j.g.d o;
    public c.a.r0.g1.j.g.b p;
    public c.a.r0.g1.j.g.a q;
    public c.a.r0.g1.j.g.c r;
    public k s;
    public o t;
    public List<c.a.e.l.e.a> u;

    public b(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new LinkedList();
        this.f18403a = homePageTabFeedFragment;
        this.f18404b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q qVar = new q(this.f18403a.getPageContext(), d2.f3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.f18405c = qVar;
            qVar.l0(this.f18404b);
            this.u.add(this.f18405c);
            j jVar = new j(this.f18403a.getPageContext());
            this.f18406d = jVar;
            jVar.k0(this.f18404b);
            this.u.add(this.f18406d);
            c.a.r0.g1.j.g.e eVar = new c.a.r0.g1.j.g.e(this.f18403a.getPageContext(), d2.k3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.f18407e = eVar;
            eVar.m0(this.f18404b);
            this.u.add(this.f18407e);
            g gVar = new g(this.f18403a.getPageContext(), d2.i3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.f18408f = gVar;
            gVar.l0(this.f18404b);
            this.u.add(this.f18408f);
            c.a.r0.g1.j.g.f fVar = new c.a.r0.g1.j.g.f(this.f18403a.getPageContext(), d2.j3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.f18409g = fVar;
            fVar.l0(this.f18404b);
            this.u.add(this.f18409g);
            h hVar = new h(this.f18403a.getPageContext(), d2.g3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.f18410h = hVar;
            hVar.l0(this.f18404b);
            this.u.add(this.f18410h);
            r rVar = new r(this.f18403a.getPageContext(), d2.w3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.f18411i = rVar;
            rVar.o0(this.f18404b);
            this.u.add(this.f18411i);
            i iVar = new i(this.f18403a.getPageContext(), d2.p3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.f18412j = iVar;
            iVar.l0(this.f18404b);
            l lVar = new l(this.f18403a.getPageContext(), d2.q3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.k = lVar;
            lVar.j0(this.f18404b);
            this.u.add(this.k);
            n nVar = new n(this.f18403a.getPageContext(), d2.s3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.l = nVar;
            nVar.k0(this.f18404b);
            this.u.add(this.l);
            m mVar = new m(this.f18403a.getPageContext(), d2.t3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.m = mVar;
            mVar.j0(this.f18404b);
            this.u.add(this.m);
            p pVar = new p(this.f18403a.getPageContext(), d2.l3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.n = pVar;
            pVar.k0(this.f18404b);
            this.u.add(this.n);
            c.a.r0.g1.j.g.d dVar = new c.a.r0.g1.j.g.d(this.f18403a.getPageContext(), d2.o3, this.f18403a.getUniqueId(), this.f18403a.getTabName());
            this.o = dVar;
            dVar.m0(this.f18404b);
            this.u.add(this.o);
            c.a.r0.g1.j.g.c cVar = new c.a.r0.g1.j.g.c(this.f18403a.getPageContext(), c.a.r0.a0.d0.j.P0, this.f18403a.getTabName());
            this.r = cVar;
            this.u.add(cVar);
            c.a.r0.g1.j.g.b bVar = new c.a.r0.g1.j.g.b(this.f18403a.getPageContext(), v1.f14328i);
            this.p = bVar;
            bVar.k0(this.f18404b);
            this.u.add(this.p);
            c.a.r0.g1.j.g.a aVar = new c.a.r0.g1.j.g.a(this.f18403a.getPageContext(), x.f14342f);
            this.q = aVar;
            aVar.n0(this.f18404b);
            this.u.add(this.q);
            k kVar = new k(this.f18403a.getPageContext());
            this.s = kVar;
            kVar.j0(this.f18404b);
            this.u.add(this.s);
            o oVar = new o(this.f18403a.getPageContext());
            this.t = oVar;
            oVar.j0(this.f18404b);
            this.u.add(this.t);
            this.f18404b.addAdapters(this.u);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18404b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<c.a.e.l.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f18404b.setData(arrayList);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            for (c.a.e.l.e.a aVar : this.u) {
                if (aVar instanceof d) {
                    ((d) aVar).i(str);
                }
            }
        }
    }
}
