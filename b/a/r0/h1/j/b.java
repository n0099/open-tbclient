package b.a.r0.h1.j;

import b.a.q0.s.q.d2;
import b.a.q0.s.q.v1;
import b.a.q0.s.q.x;
import b.a.r0.h1.j.g.g;
import b.a.r0.h1.j.g.h;
import b.a.r0.h1.j.g.i;
import b.a.r0.h1.j.g.j;
import b.a.r0.h1.j.g.k;
import b.a.r0.h1.j.g.l;
import b.a.r0.h1.j.g.m;
import b.a.r0.h1.j.g.n;
import b.a.r0.h1.j.g.o;
import b.a.r0.h1.j.g.p;
import b.a.r0.h1.j.g.q;
import b.a.r0.h1.j.g.r;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f18981a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f18982b;

    /* renamed from: c  reason: collision with root package name */
    public q f18983c;

    /* renamed from: d  reason: collision with root package name */
    public j f18984d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.h1.j.g.e f18985e;

    /* renamed from: f  reason: collision with root package name */
    public g f18986f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.h1.j.g.f f18987g;

    /* renamed from: h  reason: collision with root package name */
    public h f18988h;

    /* renamed from: i  reason: collision with root package name */
    public r f18989i;
    public i j;
    public l k;
    public n l;
    public m m;
    public p n;
    public b.a.r0.h1.j.g.d o;
    public b.a.r0.h1.j.g.b p;
    public b.a.r0.h1.j.g.a q;
    public b.a.r0.h1.j.g.c r;
    public k s;
    public o t;
    public List<b.a.e.m.e.a> u;

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
        this.f18981a = homePageTabFeedFragment;
        this.f18982b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q qVar = new q(this.f18981a.getPageContext(), d2.h3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.f18983c = qVar;
            qVar.k0(this.f18982b);
            this.u.add(this.f18983c);
            j jVar = new j(this.f18981a.getPageContext());
            this.f18984d = jVar;
            jVar.j0(this.f18982b);
            this.u.add(this.f18984d);
            b.a.r0.h1.j.g.e eVar = new b.a.r0.h1.j.g.e(this.f18981a.getPageContext(), d2.m3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.f18985e = eVar;
            eVar.l0(this.f18982b);
            this.u.add(this.f18985e);
            g gVar = new g(this.f18981a.getPageContext(), d2.k3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.f18986f = gVar;
            gVar.k0(this.f18982b);
            this.u.add(this.f18986f);
            b.a.r0.h1.j.g.f fVar = new b.a.r0.h1.j.g.f(this.f18981a.getPageContext(), d2.l3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.f18987g = fVar;
            fVar.k0(this.f18982b);
            this.u.add(this.f18987g);
            h hVar = new h(this.f18981a.getPageContext(), d2.i3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.f18988h = hVar;
            hVar.k0(this.f18982b);
            this.u.add(this.f18988h);
            r rVar = new r(this.f18981a.getPageContext(), d2.z3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.f18989i = rVar;
            rVar.n0(this.f18982b);
            this.u.add(this.f18989i);
            i iVar = new i(this.f18981a.getPageContext(), d2.s3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.j = iVar;
            iVar.k0(this.f18982b);
            l lVar = new l(this.f18981a.getPageContext(), d2.t3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.k = lVar;
            lVar.i0(this.f18982b);
            this.u.add(this.k);
            n nVar = new n(this.f18981a.getPageContext(), d2.v3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.l = nVar;
            nVar.j0(this.f18982b);
            this.u.add(this.l);
            m mVar = new m(this.f18981a.getPageContext(), d2.w3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.m = mVar;
            mVar.i0(this.f18982b);
            this.u.add(this.m);
            p pVar = new p(this.f18981a.getPageContext(), d2.o3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.n = pVar;
            pVar.j0(this.f18982b);
            this.u.add(this.n);
            b.a.r0.h1.j.g.d dVar = new b.a.r0.h1.j.g.d(this.f18981a.getPageContext(), d2.r3, this.f18981a.getUniqueId(), this.f18981a.getTabName());
            this.o = dVar;
            dVar.l0(this.f18982b);
            this.u.add(this.o);
            b.a.r0.h1.j.g.c cVar = new b.a.r0.h1.j.g.c(this.f18981a.getPageContext(), b.a.r0.b0.f0.j.S0, this.f18981a.getTabName());
            this.r = cVar;
            this.u.add(cVar);
            b.a.r0.h1.j.g.b bVar = new b.a.r0.h1.j.g.b(this.f18981a.getPageContext(), v1.f14244i);
            this.p = bVar;
            bVar.j0(this.f18982b);
            this.u.add(this.p);
            b.a.r0.h1.j.g.a aVar = new b.a.r0.h1.j.g.a(this.f18981a.getPageContext(), x.f14257f);
            this.q = aVar;
            aVar.m0(this.f18982b);
            this.u.add(this.q);
            k kVar = new k(this.f18981a.getPageContext());
            this.s = kVar;
            kVar.i0(this.f18982b);
            this.u.add(this.s);
            o oVar = new o(this.f18981a.getPageContext());
            this.t = oVar;
            oVar.i0(this.f18982b);
            this.u.add(this.t);
            this.f18982b.addAdapters(this.u);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18982b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<b.a.e.m.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f18982b.setData(arrayList);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            for (b.a.e.m.e.a aVar : this.u) {
                if (aVar instanceof d) {
                    ((d) aVar).i(str);
                }
            }
        }
    }
}
