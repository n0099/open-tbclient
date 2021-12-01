package c.a.r0.n1.j;

import c.a.q0.s.q.d2;
import c.a.q0.s.q.v1;
import c.a.q0.s.q.x;
import c.a.r0.n1.j.g.g;
import c.a.r0.n1.j.g.h;
import c.a.r0.n1.j.g.i;
import c.a.r0.n1.j.g.j;
import c.a.r0.n1.j.g.k;
import c.a.r0.n1.j.g.l;
import c.a.r0.n1.j.g.m;
import c.a.r0.n1.j.g.n;
import c.a.r0.n1.j.g.o;
import c.a.r0.n1.j.g.p;
import c.a.r0.n1.j.g.q;
import c.a.r0.n1.j.g.r;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20591b;

    /* renamed from: c  reason: collision with root package name */
    public q f20592c;

    /* renamed from: d  reason: collision with root package name */
    public j f20593d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.n1.j.g.e f20594e;

    /* renamed from: f  reason: collision with root package name */
    public g f20595f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.n1.j.g.f f20596g;

    /* renamed from: h  reason: collision with root package name */
    public h f20597h;

    /* renamed from: i  reason: collision with root package name */
    public r f20598i;

    /* renamed from: j  reason: collision with root package name */
    public i f20599j;

    /* renamed from: k  reason: collision with root package name */
    public l f20600k;
    public n l;
    public m m;
    public p n;
    public c.a.r0.n1.j.g.d o;
    public c.a.r0.n1.j.g.b p;
    public c.a.r0.n1.j.g.a q;
    public c.a.r0.n1.j.g.c r;
    public k s;
    public o t;
    public List<c.a.d.m.e.a> u;

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
        this.a = homePageTabFeedFragment;
        this.f20591b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q qVar = new q(this.a.getPageContext(), d2.l3, this.a.getUniqueId(), this.a.getTabName(), this.a.getTabCode());
            this.f20592c = qVar;
            qVar.k0(this.f20591b);
            this.u.add(this.f20592c);
            j jVar = new j(this.a.getPageContext());
            this.f20593d = jVar;
            jVar.j0(this.f20591b);
            this.u.add(this.f20593d);
            c.a.r0.n1.j.g.e eVar = new c.a.r0.n1.j.g.e(this.a.getPageContext(), d2.q3, this.a.getUniqueId(), this.a.getTabName());
            this.f20594e = eVar;
            eVar.l0(this.f20591b);
            this.u.add(this.f20594e);
            g gVar = new g(this.a.getPageContext(), d2.o3, this.a.getUniqueId(), this.a.getTabName());
            this.f20595f = gVar;
            gVar.k0(this.f20591b);
            this.u.add(this.f20595f);
            c.a.r0.n1.j.g.f fVar = new c.a.r0.n1.j.g.f(this.a.getPageContext(), d2.p3, this.a.getUniqueId(), this.a.getTabName());
            this.f20596g = fVar;
            fVar.k0(this.f20591b);
            this.u.add(this.f20596g);
            h hVar = new h(this.a.getPageContext(), d2.m3, this.a.getUniqueId(), this.a.getTabName());
            this.f20597h = hVar;
            hVar.k0(this.f20591b);
            this.u.add(this.f20597h);
            r rVar = new r(this.a.getPageContext(), d2.D3, this.a.getUniqueId(), this.a.getTabName());
            this.f20598i = rVar;
            rVar.n0(this.f20591b);
            this.u.add(this.f20598i);
            i iVar = new i(this.a.getPageContext(), d2.w3, this.a.getUniqueId(), this.a.getTabName());
            this.f20599j = iVar;
            iVar.k0(this.f20591b);
            if (CardUserInfoLayout.TAB_CODE_FASHION.equals(this.a.getTabCode()) || MainTabActivity.TAB_CODE_LOCAL.equals(this.a.getTabCode())) {
                this.u.add(this.f20599j);
            }
            l lVar = new l(this.a.getPageContext(), d2.x3, this.a.getUniqueId(), this.a.getTabName());
            this.f20600k = lVar;
            lVar.i0(this.f20591b);
            this.u.add(this.f20600k);
            n nVar = new n(this.a.getPageContext(), d2.z3, this.a.getUniqueId(), this.a.getTabName());
            this.l = nVar;
            nVar.j0(this.f20591b);
            this.u.add(this.l);
            m mVar = new m(this.a.getPageContext(), d2.A3, this.a.getUniqueId(), this.a.getTabName());
            this.m = mVar;
            mVar.i0(this.f20591b);
            this.u.add(this.m);
            p pVar = new p(this.a.getPageContext(), d2.s3, this.a.getUniqueId(), this.a.getTabName());
            this.n = pVar;
            pVar.j0(this.f20591b);
            this.u.add(this.n);
            c.a.r0.n1.j.g.d dVar = new c.a.r0.n1.j.g.d(this.a.getPageContext(), d2.v3, this.a.getUniqueId(), this.a.getTabName());
            this.o = dVar;
            dVar.l0(this.f20591b);
            this.u.add(this.o);
            c.a.r0.n1.j.g.c cVar = new c.a.r0.n1.j.g.c(this.a.getPageContext(), c.a.r0.g0.f0.j.T0, this.a.getTabName());
            this.r = cVar;
            this.u.add(cVar);
            c.a.r0.n1.j.g.b bVar = new c.a.r0.n1.j.g.b(this.a.getPageContext(), v1.f13067i);
            this.p = bVar;
            bVar.j0(this.f20591b);
            this.u.add(this.p);
            c.a.r0.n1.j.g.a aVar = new c.a.r0.n1.j.g.a(this.a.getPageContext(), x.f13081f);
            this.q = aVar;
            aVar.m0(this.f20591b);
            this.u.add(this.q);
            k kVar = new k(this.a.getPageContext());
            this.s = kVar;
            kVar.i0(this.f20591b);
            this.u.add(this.s);
            o oVar = new o(this.a.getPageContext());
            this.t = oVar;
            oVar.i0(this.f20591b);
            this.u.add(this.t);
            this.f20591b.addAdapters(this.u);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20591b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<c.a.d.m.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f20591b.setData(arrayList);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            for (c.a.d.m.e.a aVar : this.u) {
                if (aVar instanceof d) {
                    ((d) aVar).i(str);
                }
            }
        }
    }
}
