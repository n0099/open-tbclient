package c.a.s0.o1.j;

import android.view.View;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.v1;
import c.a.r0.s.r.x;
import c.a.s0.o1.j.g.g;
import c.a.s0.o1.j.g.h;
import c.a.s0.o1.j.g.i;
import c.a.s0.o1.j.g.j;
import c.a.s0.o1.j.g.k;
import c.a.s0.o1.j.g.l;
import c.a.s0.o1.j.g.m;
import c.a.s0.o1.j.g.n;
import c.a.s0.o1.j.g.o;
import c.a.s0.o1.j.g.p;
import c.a.s0.o1.j.g.q;
import c.a.s0.o1.j.g.r;
import c.a.s0.o1.j.g.s;
import c.a.s0.o1.j.g.t;
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
    public BdTypeRecyclerView f21113b;

    /* renamed from: c  reason: collision with root package name */
    public r f21114c;

    /* renamed from: d  reason: collision with root package name */
    public k f21115d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.o1.j.g.f f21116e;

    /* renamed from: f  reason: collision with root package name */
    public h f21117f;

    /* renamed from: g  reason: collision with root package name */
    public g f21118g;

    /* renamed from: h  reason: collision with root package name */
    public i f21119h;

    /* renamed from: i  reason: collision with root package name */
    public s f21120i;

    /* renamed from: j  reason: collision with root package name */
    public j f21121j;

    /* renamed from: k  reason: collision with root package name */
    public m f21122k;
    public o l;
    public n m;
    public q n;
    public c.a.s0.o1.j.g.d o;
    public c.a.s0.o1.j.g.b p;
    public c.a.s0.o1.j.g.a q;
    public c.a.s0.o1.j.g.c r;
    public l s;
    public p t;
    public c.a.s0.o1.j.g.e u;
    public t v;
    public List<c.a.d.m.e.a> w;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21123e;

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
            this.f21123e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.f21123e.f21113b.getCount() != 0 && (this.f21123e.f21113b.getItem(0) instanceof c.a.s0.o1.j.h.a)) {
                    this.f21123e.f21113b.removeItem(0);
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
        this.f21113b = bdTypeRecyclerView;
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
            r rVar = new r(this.a.getPageContext(), d2.m3, this.a.getUniqueId(), this.a.getTabName(), this.a.getTabCode());
            this.f21114c = rVar;
            rVar.k0(this.f21113b);
            this.w.add(this.f21114c);
            k kVar = new k(this.a.getPageContext());
            this.f21115d = kVar;
            kVar.j0(this.f21113b);
            this.w.add(this.f21115d);
            c.a.s0.o1.j.g.f fVar = new c.a.s0.o1.j.g.f(this.a.getPageContext(), d2.r3, this.a.getUniqueId(), this.a.getTabName());
            this.f21116e = fVar;
            fVar.l0(this.f21113b);
            this.w.add(this.f21116e);
            h hVar = new h(this.a.getPageContext(), d2.p3, this.a.getUniqueId(), this.a.getTabName());
            this.f21117f = hVar;
            hVar.k0(this.f21113b);
            this.w.add(this.f21117f);
            g gVar = new g(this.a.getPageContext(), d2.q3, this.a.getUniqueId(), this.a.getTabName());
            this.f21118g = gVar;
            gVar.k0(this.f21113b);
            this.w.add(this.f21118g);
            i iVar = new i(this.a.getPageContext(), d2.n3, this.a.getUniqueId(), this.a.getTabName());
            this.f21119h = iVar;
            iVar.k0(this.f21113b);
            this.w.add(this.f21119h);
            s sVar = new s(this.a.getPageContext(), d2.E3, this.a.getUniqueId(), this.a.getTabName());
            this.f21120i = sVar;
            sVar.n0(this.f21113b);
            this.w.add(this.f21120i);
            j jVar = new j(this.a.getPageContext(), d2.x3, this.a.getUniqueId(), this.a.getTabName());
            this.f21121j = jVar;
            jVar.k0(this.f21113b);
            if (CardUserInfoLayout.TAB_CODE_FASHION.equals(this.a.getTabCode()) || MainTabActivity.TAB_CODE_LOCAL.equals(this.a.getTabCode())) {
                this.w.add(this.f21121j);
            }
            m mVar = new m(this.a.getPageContext(), d2.y3, this.a.getUniqueId(), this.a.getTabName());
            this.f21122k = mVar;
            mVar.i0(this.f21113b);
            this.w.add(this.f21122k);
            o oVar = new o(this.a.getPageContext(), d2.A3, this.a.getUniqueId(), this.a.getTabName());
            this.l = oVar;
            oVar.j0(this.f21113b);
            this.w.add(this.l);
            n nVar = new n(this.a.getPageContext(), d2.B3, this.a.getUniqueId(), this.a.getTabName());
            this.m = nVar;
            nVar.i0(this.f21113b);
            this.w.add(this.m);
            q qVar = new q(this.a.getPageContext(), d2.t3, this.a.getUniqueId(), this.a.getTabName());
            this.n = qVar;
            qVar.j0(this.f21113b);
            this.w.add(this.n);
            c.a.s0.o1.j.g.d dVar = new c.a.s0.o1.j.g.d(this.a.getPageContext(), d2.w3, this.a.getUniqueId(), this.a.getTabName());
            this.o = dVar;
            dVar.l0(this.f21113b);
            this.w.add(this.o);
            c.a.s0.o1.j.g.c cVar = new c.a.s0.o1.j.g.c(this.a.getPageContext(), c.a.s0.g0.f0.j.T0, this.a.getTabName());
            this.r = cVar;
            this.w.add(cVar);
            c.a.s0.o1.j.g.b bVar = new c.a.s0.o1.j.g.b(this.a.getPageContext(), v1.f13447i);
            this.p = bVar;
            bVar.j0(this.f21113b);
            this.w.add(this.p);
            c.a.s0.o1.j.g.a aVar = new c.a.s0.o1.j.g.a(this.a.getPageContext(), x.f13461f);
            this.q = aVar;
            aVar.m0(this.f21113b);
            this.w.add(this.q);
            l lVar = new l(this.a.getPageContext());
            this.s = lVar;
            lVar.i0(this.f21113b);
            this.w.add(this.s);
            p pVar = new p(this.a.getPageContext());
            this.t = pVar;
            pVar.i0(this.f21113b);
            this.w.add(this.t);
            c.a.s0.o1.j.g.e eVar = new c.a.s0.o1.j.g.e(this.a.getPageContext(), b());
            this.u = eVar;
            this.w.add(eVar);
            t tVar = new t(this.a.getPageContext());
            this.v = tVar;
            this.w.add(tVar);
            this.f21113b.addAdapters(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21113b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<c.a.d.m.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f21113b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        t tVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (tVar = this.v) == null) {
            return;
        }
        tVar.i0(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (c.a.d.m.e.a aVar : this.w) {
                if (aVar instanceof d) {
                    ((d) aVar).i(str);
                }
            }
        }
    }
}
