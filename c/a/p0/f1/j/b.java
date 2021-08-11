package c.a.p0.f1.j;

import c.a.o0.s.q.c2;
import c.a.o0.s.q.u1;
import c.a.o0.s.q.x;
import c.a.p0.f1.j.g.g;
import c.a.p0.f1.j.g.h;
import c.a.p0.f1.j.g.i;
import c.a.p0.f1.j.g.j;
import c.a.p0.f1.j.g.k;
import c.a.p0.f1.j.g.l;
import c.a.p0.f1.j.g.m;
import c.a.p0.f1.j.g.n;
import c.a.p0.f1.j.g.o;
import c.a.p0.f1.j.g.p;
import c.a.p0.f1.j.g.q;
import c.a.p0.f1.j.g.r;
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
    public HomePageTabFeedFragment f17521a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17522b;

    /* renamed from: c  reason: collision with root package name */
    public q f17523c;

    /* renamed from: d  reason: collision with root package name */
    public j f17524d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f1.j.g.e f17525e;

    /* renamed from: f  reason: collision with root package name */
    public g f17526f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.f1.j.g.f f17527g;

    /* renamed from: h  reason: collision with root package name */
    public h f17528h;

    /* renamed from: i  reason: collision with root package name */
    public r f17529i;

    /* renamed from: j  reason: collision with root package name */
    public i f17530j;
    public l k;
    public n l;
    public m m;
    public p n;
    public c.a.p0.f1.j.g.d o;
    public c.a.p0.f1.j.g.b p;
    public c.a.p0.f1.j.g.a q;
    public c.a.p0.f1.j.g.c r;
    public k s;
    public o t;
    public List<c.a.e.k.e.a> u;

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
        this.f17521a = homePageTabFeedFragment;
        this.f17522b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q qVar = new q(this.f17521a.getPageContext(), c2.c3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.f17523c = qVar;
            qVar.l0(this.f17522b);
            this.u.add(this.f17523c);
            j jVar = new j(this.f17521a.getPageContext());
            this.f17524d = jVar;
            jVar.k0(this.f17522b);
            this.u.add(this.f17524d);
            c.a.p0.f1.j.g.e eVar = new c.a.p0.f1.j.g.e(this.f17521a.getPageContext(), c2.h3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.f17525e = eVar;
            eVar.m0(this.f17522b);
            this.u.add(this.f17525e);
            g gVar = new g(this.f17521a.getPageContext(), c2.f3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.f17526f = gVar;
            gVar.l0(this.f17522b);
            this.u.add(this.f17526f);
            c.a.p0.f1.j.g.f fVar = new c.a.p0.f1.j.g.f(this.f17521a.getPageContext(), c2.g3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.f17527g = fVar;
            fVar.l0(this.f17522b);
            this.u.add(this.f17527g);
            h hVar = new h(this.f17521a.getPageContext(), c2.d3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.f17528h = hVar;
            hVar.l0(this.f17522b);
            this.u.add(this.f17528h);
            r rVar = new r(this.f17521a.getPageContext(), c2.t3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.f17529i = rVar;
            rVar.o0(this.f17522b);
            this.u.add(this.f17529i);
            i iVar = new i(this.f17521a.getPageContext(), c2.m3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.f17530j = iVar;
            iVar.l0(this.f17522b);
            l lVar = new l(this.f17521a.getPageContext(), c2.n3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.k = lVar;
            lVar.j0(this.f17522b);
            this.u.add(this.k);
            n nVar = new n(this.f17521a.getPageContext(), c2.p3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.l = nVar;
            nVar.k0(this.f17522b);
            this.u.add(this.l);
            m mVar = new m(this.f17521a.getPageContext(), c2.q3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.m = mVar;
            mVar.j0(this.f17522b);
            this.u.add(this.m);
            p pVar = new p(this.f17521a.getPageContext(), c2.i3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.n = pVar;
            pVar.k0(this.f17522b);
            this.u.add(this.n);
            c.a.p0.f1.j.g.d dVar = new c.a.p0.f1.j.g.d(this.f17521a.getPageContext(), c2.l3, this.f17521a.getUniqueId(), this.f17521a.getTabName());
            this.o = dVar;
            dVar.m0(this.f17522b);
            this.u.add(this.o);
            c.a.p0.f1.j.g.c cVar = new c.a.p0.f1.j.g.c(this.f17521a.getPageContext(), c.a.p0.a0.d0.j.P0, this.f17521a.getTabName());
            this.r = cVar;
            this.u.add(cVar);
            c.a.p0.f1.j.g.b bVar = new c.a.p0.f1.j.g.b(this.f17521a.getPageContext(), u1.f14052i);
            this.p = bVar;
            bVar.k0(this.f17522b);
            this.u.add(this.p);
            c.a.p0.f1.j.g.a aVar = new c.a.p0.f1.j.g.a(this.f17521a.getPageContext(), x.f14072f);
            this.q = aVar;
            aVar.n0(this.f17522b);
            this.u.add(this.q);
            k kVar = new k(this.f17521a.getPageContext());
            this.s = kVar;
            kVar.j0(this.f17522b);
            this.u.add(this.s);
            o oVar = new o(this.f17521a.getPageContext());
            this.t = oVar;
            oVar.j0(this.f17522b);
            this.u.add(this.t);
            this.f17522b.addAdapters(this.u);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17522b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<c.a.e.k.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f17522b.setData(arrayList);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            for (c.a.e.k.e.a aVar : this.u) {
                if (aVar instanceof d) {
                    ((d) aVar).i(str);
                }
            }
        }
    }
}
