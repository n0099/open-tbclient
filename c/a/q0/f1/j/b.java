package c.a.q0.f1.j;

import c.a.p0.s.q.c2;
import c.a.p0.s.q.u1;
import c.a.p0.s.q.x;
import c.a.q0.f1.j.g.g;
import c.a.q0.f1.j.g.h;
import c.a.q0.f1.j.g.i;
import c.a.q0.f1.j.g.j;
import c.a.q0.f1.j.g.k;
import c.a.q0.f1.j.g.l;
import c.a.q0.f1.j.g.m;
import c.a.q0.f1.j.g.n;
import c.a.q0.f1.j.g.o;
import c.a.q0.f1.j.g.p;
import c.a.q0.f1.j.g.q;
import c.a.q0.f1.j.g.r;
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
    public HomePageTabFeedFragment f17869a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17870b;

    /* renamed from: c  reason: collision with root package name */
    public q f17871c;

    /* renamed from: d  reason: collision with root package name */
    public j f17872d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.f1.j.g.e f17873e;

    /* renamed from: f  reason: collision with root package name */
    public g f17874f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.f1.j.g.f f17875g;

    /* renamed from: h  reason: collision with root package name */
    public h f17876h;

    /* renamed from: i  reason: collision with root package name */
    public r f17877i;

    /* renamed from: j  reason: collision with root package name */
    public i f17878j;
    public l k;
    public n l;
    public m m;
    public p n;
    public c.a.q0.f1.j.g.d o;
    public c.a.q0.f1.j.g.b p;
    public c.a.q0.f1.j.g.a q;
    public c.a.q0.f1.j.g.c r;
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
        this.f17869a = homePageTabFeedFragment;
        this.f17870b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q qVar = new q(this.f17869a.getPageContext(), c2.c3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.f17871c = qVar;
            qVar.l0(this.f17870b);
            this.u.add(this.f17871c);
            j jVar = new j(this.f17869a.getPageContext());
            this.f17872d = jVar;
            jVar.k0(this.f17870b);
            this.u.add(this.f17872d);
            c.a.q0.f1.j.g.e eVar = new c.a.q0.f1.j.g.e(this.f17869a.getPageContext(), c2.h3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.f17873e = eVar;
            eVar.m0(this.f17870b);
            this.u.add(this.f17873e);
            g gVar = new g(this.f17869a.getPageContext(), c2.f3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.f17874f = gVar;
            gVar.l0(this.f17870b);
            this.u.add(this.f17874f);
            c.a.q0.f1.j.g.f fVar = new c.a.q0.f1.j.g.f(this.f17869a.getPageContext(), c2.g3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.f17875g = fVar;
            fVar.l0(this.f17870b);
            this.u.add(this.f17875g);
            h hVar = new h(this.f17869a.getPageContext(), c2.d3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.f17876h = hVar;
            hVar.l0(this.f17870b);
            this.u.add(this.f17876h);
            r rVar = new r(this.f17869a.getPageContext(), c2.t3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.f17877i = rVar;
            rVar.o0(this.f17870b);
            this.u.add(this.f17877i);
            i iVar = new i(this.f17869a.getPageContext(), c2.m3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.f17878j = iVar;
            iVar.l0(this.f17870b);
            l lVar = new l(this.f17869a.getPageContext(), c2.n3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.k = lVar;
            lVar.j0(this.f17870b);
            this.u.add(this.k);
            n nVar = new n(this.f17869a.getPageContext(), c2.p3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.l = nVar;
            nVar.k0(this.f17870b);
            this.u.add(this.l);
            m mVar = new m(this.f17869a.getPageContext(), c2.q3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.m = mVar;
            mVar.j0(this.f17870b);
            this.u.add(this.m);
            p pVar = new p(this.f17869a.getPageContext(), c2.i3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.n = pVar;
            pVar.k0(this.f17870b);
            this.u.add(this.n);
            c.a.q0.f1.j.g.d dVar = new c.a.q0.f1.j.g.d(this.f17869a.getPageContext(), c2.l3, this.f17869a.getUniqueId(), this.f17869a.getTabName());
            this.o = dVar;
            dVar.m0(this.f17870b);
            this.u.add(this.o);
            c.a.q0.f1.j.g.c cVar = new c.a.q0.f1.j.g.c(this.f17869a.getPageContext(), c.a.q0.a0.d0.j.P0, this.f17869a.getTabName());
            this.r = cVar;
            this.u.add(cVar);
            c.a.q0.f1.j.g.b bVar = new c.a.q0.f1.j.g.b(this.f17869a.getPageContext(), u1.f14358i);
            this.p = bVar;
            bVar.k0(this.f17870b);
            this.u.add(this.p);
            c.a.q0.f1.j.g.a aVar = new c.a.q0.f1.j.g.a(this.f17869a.getPageContext(), x.f14378f);
            this.q = aVar;
            aVar.n0(this.f17870b);
            this.u.add(this.q);
            k kVar = new k(this.f17869a.getPageContext());
            this.s = kVar;
            kVar.j0(this.f17870b);
            this.u.add(this.s);
            o oVar = new o(this.f17869a.getPageContext());
            this.t = oVar;
            oVar.j0(this.f17870b);
            this.u.add(this.t);
            this.f17870b.addAdapters(this.u);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17870b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<c.a.e.l.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f17870b.setData(arrayList);
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
