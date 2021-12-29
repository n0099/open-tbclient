package c.a.t0.o1.j;

import android.view.View;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.v1;
import c.a.s0.s.q.x;
import c.a.t0.o1.j.g.g;
import c.a.t0.o1.j.g.h;
import c.a.t0.o1.j.g.i;
import c.a.t0.o1.j.g.j;
import c.a.t0.o1.j.g.k;
import c.a.t0.o1.j.g.l;
import c.a.t0.o1.j.g.m;
import c.a.t0.o1.j.g.n;
import c.a.t0.o1.j.g.o;
import c.a.t0.o1.j.g.p;
import c.a.t0.o1.j.g.q;
import c.a.t0.o1.j.g.r;
import c.a.t0.o1.j.g.s;
import c.a.t0.o1.j.g.t;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f21154b;

    /* renamed from: c  reason: collision with root package name */
    public r f21155c;

    /* renamed from: d  reason: collision with root package name */
    public k f21156d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.o1.j.g.f f21157e;

    /* renamed from: f  reason: collision with root package name */
    public h f21158f;

    /* renamed from: g  reason: collision with root package name */
    public g f21159g;

    /* renamed from: h  reason: collision with root package name */
    public i f21160h;

    /* renamed from: i  reason: collision with root package name */
    public s f21161i;

    /* renamed from: j  reason: collision with root package name */
    public j f21162j;

    /* renamed from: k  reason: collision with root package name */
    public m f21163k;
    public o l;
    public n m;
    public q n;
    public c.a.t0.o1.j.g.d o;
    public c.a.t0.o1.j.g.b p;
    public c.a.t0.o1.j.g.a q;
    public c.a.t0.o1.j.g.c r;
    public l s;
    public p t;
    public c.a.t0.o1.j.g.e u;
    public t v;
    public List<c.a.d.n.e.a> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21164e;

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
            this.f21164e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.f21164e.f21154b.getCount() != 0 && (this.f21164e.f21154b.getItem(0) instanceof c.a.t0.o1.j.h.a)) {
                    this.f21164e.f21154b.removeItem(0);
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
        this.f21154b = bdTypeRecyclerView;
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
            r rVar = new r(this.a.getPageContext(), d2.o3, this.a.getUniqueId(), this.a.getTabName(), this.a.getTabCode());
            this.f21155c = rVar;
            rVar.d0(this.f21154b);
            this.w.add(this.f21155c);
            k kVar = new k(this.a.getPageContext());
            this.f21156d = kVar;
            kVar.c0(this.f21154b);
            this.w.add(this.f21156d);
            c.a.t0.o1.j.g.f fVar = new c.a.t0.o1.j.g.f(this.a.getPageContext(), d2.t3, this.a.getUniqueId(), this.a.getTabName());
            this.f21157e = fVar;
            fVar.e0(this.f21154b);
            this.w.add(this.f21157e);
            h hVar = new h(this.a.getPageContext(), d2.r3, this.a.getUniqueId(), this.a.getTabName());
            this.f21158f = hVar;
            hVar.d0(this.f21154b);
            this.w.add(this.f21158f);
            g gVar = new g(this.a.getPageContext(), d2.s3, this.a.getUniqueId(), this.a.getTabName());
            this.f21159g = gVar;
            gVar.d0(this.f21154b);
            this.w.add(this.f21159g);
            i iVar = new i(this.a.getPageContext(), d2.p3, this.a.getUniqueId(), this.a.getTabName());
            this.f21160h = iVar;
            iVar.d0(this.f21154b);
            this.w.add(this.f21160h);
            s sVar = new s(this.a.getPageContext(), d2.G3, this.a.getUniqueId(), this.a.getTabName());
            this.f21161i = sVar;
            sVar.g0(this.f21154b);
            this.w.add(this.f21161i);
            j jVar = new j(this.a.getPageContext(), d2.z3, this.a.getUniqueId(), this.a.getTabName());
            this.f21162j = jVar;
            jVar.d0(this.f21154b);
            if (CardUserInfoLayout.TAB_CODE_FASHION.equals(this.a.getTabCode()) || MainTabActivity.TAB_CODE_LOCAL.equals(this.a.getTabCode())) {
                this.w.add(this.f21162j);
            }
            m mVar = new m(this.a.getPageContext(), d2.A3, this.a.getUniqueId(), this.a.getTabName());
            this.f21163k = mVar;
            mVar.b0(this.f21154b);
            this.w.add(this.f21163k);
            o oVar = new o(this.a.getPageContext(), d2.C3, this.a.getUniqueId(), this.a.getTabName());
            this.l = oVar;
            oVar.c0(this.f21154b);
            this.w.add(this.l);
            n nVar = new n(this.a.getPageContext(), d2.D3, this.a.getUniqueId(), this.a.getTabName());
            this.m = nVar;
            nVar.b0(this.f21154b);
            this.w.add(this.m);
            q qVar = new q(this.a.getPageContext(), d2.v3, this.a.getUniqueId(), this.a.getTabName());
            this.n = qVar;
            qVar.c0(this.f21154b);
            this.w.add(this.n);
            c.a.t0.o1.j.g.d dVar = new c.a.t0.o1.j.g.d(this.a.getPageContext(), d2.y3, this.a.getUniqueId(), this.a.getTabName());
            this.o = dVar;
            dVar.e0(this.f21154b);
            this.w.add(this.o);
            c.a.t0.o1.j.g.c cVar = new c.a.t0.o1.j.g.c(this.a.getPageContext(), c.a.t0.g0.f0.j.U0, this.a.getTabName());
            this.r = cVar;
            this.w.add(cVar);
            c.a.t0.o1.j.g.b bVar = new c.a.t0.o1.j.g.b(this.a.getPageContext(), v1.f13823i);
            this.p = bVar;
            bVar.c0(this.f21154b);
            this.w.add(this.p);
            c.a.t0.o1.j.g.a aVar = new c.a.t0.o1.j.g.a(this.a.getPageContext(), x.f13837f);
            this.q = aVar;
            aVar.f0(this.f21154b);
            this.w.add(this.q);
            l lVar = new l(this.a.getPageContext());
            this.s = lVar;
            lVar.b0(this.f21154b);
            this.w.add(this.s);
            p pVar = new p(this.a.getPageContext());
            this.t = pVar;
            pVar.b0(this.f21154b);
            this.w.add(this.t);
            c.a.t0.o1.j.g.e eVar = new c.a.t0.o1.j.g.e(this.a.getPageContext(), b());
            this.u = eVar;
            this.w.add(eVar);
            t tVar = new t(this.a.getPageContext());
            this.v = tVar;
            this.w.add(tVar);
            this.f21154b.addAdapters(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21154b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<c.a.d.n.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f21154b.setData(arrayList);
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
            for (c.a.d.n.e.a aVar : this.w) {
                if (aVar instanceof d) {
                    ((d) aVar).i(str);
                }
            }
        }
    }
}
