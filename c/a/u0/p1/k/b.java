package c.a.u0.p1.k;

import android.view.View;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.v1;
import c.a.t0.s.r.x;
import c.a.u0.p1.k.g.g;
import c.a.u0.p1.k.g.h;
import c.a.u0.p1.k.g.i;
import c.a.u0.p1.k.g.j;
import c.a.u0.p1.k.g.k;
import c.a.u0.p1.k.g.l;
import c.a.u0.p1.k.g.m;
import c.a.u0.p1.k.g.n;
import c.a.u0.p1.k.g.o;
import c.a.u0.p1.k.g.p;
import c.a.u0.p1.k.g.q;
import c.a.u0.p1.k.g.r;
import c.a.u0.p1.k.g.s;
import c.a.u0.p1.k.g.t;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20802b;

    /* renamed from: c  reason: collision with root package name */
    public r f20803c;

    /* renamed from: d  reason: collision with root package name */
    public k f20804d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.u0.p1.k.g.f f20805e;

    /* renamed from: f  reason: collision with root package name */
    public h f20806f;

    /* renamed from: g  reason: collision with root package name */
    public g f20807g;

    /* renamed from: h  reason: collision with root package name */
    public i f20808h;

    /* renamed from: i  reason: collision with root package name */
    public s f20809i;

    /* renamed from: j  reason: collision with root package name */
    public j f20810j;
    public m k;
    public o l;
    public n m;
    public q n;
    public c.a.u0.p1.k.g.d o;
    public c.a.u0.p1.k.g.b p;
    public c.a.u0.p1.k.g.a q;
    public c.a.u0.p1.k.g.c r;
    public l s;
    public p t;
    public c.a.u0.p1.k.g.e u;
    public t v;
    public List<c.a.d.o.e.a> w;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20811e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20811e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.f20811e.f20802b.getCount() != 0 && (this.f20811e.f20802b.getItem(0) instanceof c.a.u0.p1.k.h.a)) {
                    this.f20811e.f20802b.removeItem(0);
                }
            }
        }
    }

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
        this.w = new LinkedList();
        this.a = homePageTabFeedFragment;
        this.f20802b = bdTypeRecyclerView;
        c();
    }

    public final View.OnClickListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (View.OnClickListener) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r rVar = new r(this.a.getPageContext(), e2.p3, this.a.getUniqueId(), this.a.getTabName(), this.a.getTabCode());
            this.f20803c = rVar;
            rVar.d0(this.f20802b);
            this.w.add(this.f20803c);
            k kVar = new k(this.a.getPageContext());
            this.f20804d = kVar;
            kVar.c0(this.f20802b);
            this.w.add(this.f20804d);
            c.a.u0.p1.k.g.f fVar = new c.a.u0.p1.k.g.f(this.a.getPageContext(), e2.u3, this.a.getUniqueId(), this.a.getTabName());
            this.f20805e = fVar;
            fVar.e0(this.f20802b);
            this.w.add(this.f20805e);
            h hVar = new h(this.a.getPageContext(), e2.s3, this.a.getUniqueId(), this.a.getTabName());
            this.f20806f = hVar;
            hVar.d0(this.f20802b);
            this.w.add(this.f20806f);
            g gVar = new g(this.a.getPageContext(), e2.t3, this.a.getUniqueId(), this.a.getTabName());
            this.f20807g = gVar;
            gVar.d0(this.f20802b);
            this.w.add(this.f20807g);
            i iVar = new i(this.a.getPageContext(), e2.q3, this.a.getUniqueId(), this.a.getTabName());
            this.f20808h = iVar;
            iVar.d0(this.f20802b);
            this.w.add(this.f20808h);
            s sVar = new s(this.a.getPageContext(), e2.H3, this.a.getUniqueId(), this.a.getTabName());
            this.f20809i = sVar;
            sVar.g0(this.f20802b);
            this.w.add(this.f20809i);
            j jVar = new j(this.a.getPageContext(), e2.A3, this.a.getUniqueId(), this.a.getTabName());
            this.f20810j = jVar;
            jVar.d0(this.f20802b);
            if (CardUserInfoLayout.TAB_CODE_FASHION.equals(this.a.getTabCode()) || MainTabActivity.TAB_CODE_LOCAL.equals(this.a.getTabCode())) {
                this.w.add(this.f20810j);
            }
            m mVar = new m(this.a.getPageContext(), e2.B3, this.a.getUniqueId(), this.a.getTabName());
            this.k = mVar;
            mVar.b0(this.f20802b);
            this.w.add(this.k);
            o oVar = new o(this.a.getPageContext(), e2.D3, this.a.getUniqueId(), this.a.getTabName());
            this.l = oVar;
            oVar.c0(this.f20802b);
            this.w.add(this.l);
            n nVar = new n(this.a.getPageContext(), e2.E3, this.a.getUniqueId(), this.a.getTabName());
            this.m = nVar;
            nVar.b0(this.f20802b);
            this.w.add(this.m);
            q qVar = new q(this.a.getPageContext(), e2.w3, this.a.getUniqueId(), this.a.getTabName());
            this.n = qVar;
            qVar.c0(this.f20802b);
            this.w.add(this.n);
            c.a.u0.p1.k.g.d dVar = new c.a.u0.p1.k.g.d(this.a.getPageContext(), e2.z3, this.a.getUniqueId(), this.a.getTabName());
            this.o = dVar;
            dVar.e0(this.f20802b);
            this.w.add(this.o);
            c.a.u0.p1.k.g.c cVar = new c.a.u0.p1.k.g.c(this.a.getPageContext(), c.a.u0.g0.d0.j.R0, this.a.getTabName());
            this.r = cVar;
            this.w.add(cVar);
            c.a.u0.p1.k.g.b bVar = new c.a.u0.p1.k.g.b(this.a.getPageContext(), v1.f13975i);
            this.p = bVar;
            bVar.c0(this.f20802b);
            this.w.add(this.p);
            c.a.u0.p1.k.g.a aVar = new c.a.u0.p1.k.g.a(this.a.getPageContext(), x.f13988f);
            this.q = aVar;
            aVar.f0(this.f20802b);
            this.w.add(this.q);
            l lVar = new l(this.a.getPageContext());
            this.s = lVar;
            lVar.b0(this.f20802b);
            this.w.add(this.s);
            p pVar = new p(this.a.getPageContext());
            this.t = pVar;
            pVar.b0(this.f20802b);
            this.w.add(this.t);
            c.a.u0.p1.k.g.e eVar = new c.a.u0.p1.k.g.e(this.a.getPageContext(), b());
            this.u = eVar;
            this.w.add(eVar);
            t tVar = new t(this.a.getPageContext());
            this.v = tVar;
            this.w.add(tVar);
            this.f20802b.addAdapters(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f20802b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<c.a.d.o.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f20802b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (tVar = this.v) == null) {
            return;
        }
        tVar.b0(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (c.a.d.o.e.a aVar : this.w) {
                if (aVar instanceof d) {
                    ((d) aVar).i(str);
                }
            }
        }
    }
}
