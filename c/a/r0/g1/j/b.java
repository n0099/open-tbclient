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
    public HomePageTabFeedFragment f18412a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f18413b;

    /* renamed from: c  reason: collision with root package name */
    public q f18414c;

    /* renamed from: d  reason: collision with root package name */
    public j f18415d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.g1.j.g.e f18416e;

    /* renamed from: f  reason: collision with root package name */
    public g f18417f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.g1.j.g.f f18418g;

    /* renamed from: h  reason: collision with root package name */
    public h f18419h;

    /* renamed from: i  reason: collision with root package name */
    public r f18420i;

    /* renamed from: j  reason: collision with root package name */
    public i f18421j;
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
        this.f18412a = homePageTabFeedFragment;
        this.f18413b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q qVar = new q(this.f18412a.getPageContext(), d2.g3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.f18414c = qVar;
            qVar.l0(this.f18413b);
            this.u.add(this.f18414c);
            j jVar = new j(this.f18412a.getPageContext());
            this.f18415d = jVar;
            jVar.k0(this.f18413b);
            this.u.add(this.f18415d);
            c.a.r0.g1.j.g.e eVar = new c.a.r0.g1.j.g.e(this.f18412a.getPageContext(), d2.l3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.f18416e = eVar;
            eVar.m0(this.f18413b);
            this.u.add(this.f18416e);
            g gVar = new g(this.f18412a.getPageContext(), d2.j3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.f18417f = gVar;
            gVar.l0(this.f18413b);
            this.u.add(this.f18417f);
            c.a.r0.g1.j.g.f fVar = new c.a.r0.g1.j.g.f(this.f18412a.getPageContext(), d2.k3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.f18418g = fVar;
            fVar.l0(this.f18413b);
            this.u.add(this.f18418g);
            h hVar = new h(this.f18412a.getPageContext(), d2.h3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.f18419h = hVar;
            hVar.l0(this.f18413b);
            this.u.add(this.f18419h);
            r rVar = new r(this.f18412a.getPageContext(), d2.x3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.f18420i = rVar;
            rVar.o0(this.f18413b);
            this.u.add(this.f18420i);
            i iVar = new i(this.f18412a.getPageContext(), d2.q3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.f18421j = iVar;
            iVar.l0(this.f18413b);
            l lVar = new l(this.f18412a.getPageContext(), d2.r3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.k = lVar;
            lVar.j0(this.f18413b);
            this.u.add(this.k);
            n nVar = new n(this.f18412a.getPageContext(), d2.t3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.l = nVar;
            nVar.k0(this.f18413b);
            this.u.add(this.l);
            m mVar = new m(this.f18412a.getPageContext(), d2.u3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.m = mVar;
            mVar.j0(this.f18413b);
            this.u.add(this.m);
            p pVar = new p(this.f18412a.getPageContext(), d2.m3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.n = pVar;
            pVar.k0(this.f18413b);
            this.u.add(this.n);
            c.a.r0.g1.j.g.d dVar = new c.a.r0.g1.j.g.d(this.f18412a.getPageContext(), d2.p3, this.f18412a.getUniqueId(), this.f18412a.getTabName());
            this.o = dVar;
            dVar.m0(this.f18413b);
            this.u.add(this.o);
            c.a.r0.g1.j.g.c cVar = new c.a.r0.g1.j.g.c(this.f18412a.getPageContext(), c.a.r0.a0.d0.j.P0, this.f18412a.getTabName());
            this.r = cVar;
            this.u.add(cVar);
            c.a.r0.g1.j.g.b bVar = new c.a.r0.g1.j.g.b(this.f18412a.getPageContext(), v1.f14328i);
            this.p = bVar;
            bVar.k0(this.f18413b);
            this.u.add(this.p);
            c.a.r0.g1.j.g.a aVar = new c.a.r0.g1.j.g.a(this.f18412a.getPageContext(), x.f14342f);
            this.q = aVar;
            aVar.n0(this.f18413b);
            this.u.add(this.q);
            k kVar = new k(this.f18412a.getPageContext());
            this.s = kVar;
            kVar.j0(this.f18413b);
            this.u.add(this.s);
            o oVar = new o(this.f18412a.getPageContext());
            this.t = oVar;
            oVar.j0(this.f18413b);
            this.u.add(this.t);
            this.f18413b.addAdapters(this.u);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18413b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<c.a.e.l.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f18413b.setData(arrayList);
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
