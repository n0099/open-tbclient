package c.a.p0.q1.k;

import android.view.View;
import c.a.o0.r.r.s1;
import c.a.o0.r.r.x;
import c.a.p0.q1.k.g.g;
import c.a.p0.q1.k.g.h;
import c.a.p0.q1.k.g.i;
import c.a.p0.q1.k.g.j;
import c.a.p0.q1.k.g.k;
import c.a.p0.q1.k.g.l;
import c.a.p0.q1.k.g.m;
import c.a.p0.q1.k.g.n;
import c.a.p0.q1.k.g.o;
import c.a.p0.q1.k.g.p;
import c.a.p0.q1.k.g.q;
import c.a.p0.q1.k.g.r;
import c.a.p0.q1.k.g.s;
import c.a.p0.q1.k.g.t;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f17493b;

    /* renamed from: c  reason: collision with root package name */
    public r f17494c;

    /* renamed from: d  reason: collision with root package name */
    public k f17495d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.q1.k.g.f f17496e;

    /* renamed from: f  reason: collision with root package name */
    public h f17497f;

    /* renamed from: g  reason: collision with root package name */
    public g f17498g;

    /* renamed from: h  reason: collision with root package name */
    public i f17499h;
    public s i;
    public j j;
    public m k;
    public o l;
    public n m;
    public q n;
    public c.a.p0.q1.k.g.d o;
    public c.a.p0.q1.k.g.b p;
    public c.a.p0.q1.k.g.a q;
    public c.a.p0.q1.k.g.c r;
    public l s;
    public p t;
    public c.a.p0.q1.k.g.e u;
    public t v;
    public List<c.a.d.o.e.a> w;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.f17493b.getCount() != 0 && (this.a.f17493b.C(0) instanceof c.a.p0.q1.k.h.a)) {
                    this.a.f17493b.E(0);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new LinkedList();
        this.a = homePageTabFeedFragment;
        this.f17493b = bdTypeRecyclerView;
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
            r rVar = new r(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.P0(), this.a.O0());
            this.f17494c = rVar;
            rVar.d0(this.f17493b);
            this.w.add(this.f17494c);
            k kVar = new k(this.a.getPageContext());
            this.f17495d = kVar;
            kVar.c0(this.f17493b);
            this.w.add(this.f17495d);
            c.a.p0.q1.k.g.f fVar = new c.a.p0.q1.k.g.f(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.P0());
            this.f17496e = fVar;
            fVar.e0(this.f17493b);
            this.w.add(this.f17496e);
            h hVar = new h(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.P0());
            this.f17497f = hVar;
            hVar.d0(this.f17493b);
            this.w.add(this.f17497f);
            g gVar = new g(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.P0());
            this.f17498g = gVar;
            gVar.d0(this.f17493b);
            this.w.add(this.f17498g);
            i iVar = new i(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.P0());
            this.f17499h = iVar;
            iVar.d0(this.f17493b);
            this.w.add(this.f17499h);
            s sVar = new s(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.P0());
            this.i = sVar;
            sVar.g0(this.f17493b);
            this.w.add(this.i);
            j jVar = new j(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.P0());
            this.j = jVar;
            jVar.d0(this.f17493b);
            if ("fashion".equals(this.a.O0()) || "local".equals(this.a.O0())) {
                this.w.add(this.j);
            }
            m mVar = new m(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.P0());
            this.k = mVar;
            mVar.b0(this.f17493b);
            this.w.add(this.k);
            o oVar = new o(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.P0());
            this.l = oVar;
            oVar.c0(this.f17493b);
            this.w.add(this.l);
            n nVar = new n(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.P0());
            this.m = nVar;
            nVar.b0(this.f17493b);
            this.w.add(this.m);
            q qVar = new q(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.P0());
            this.n = qVar;
            qVar.c0(this.f17493b);
            this.w.add(this.n);
            c.a.p0.q1.k.g.d dVar = new c.a.p0.q1.k.g.d(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.P0());
            this.o = dVar;
            dVar.e0(this.f17493b);
            this.w.add(this.o);
            c.a.p0.q1.k.g.c cVar = new c.a.p0.q1.k.g.c(this.a.getPageContext(), c.a.p0.h0.e0.j.N0, this.a.P0());
            this.r = cVar;
            this.w.add(cVar);
            c.a.p0.q1.k.g.b bVar = new c.a.p0.q1.k.g.b(this.a.getPageContext(), s1.f10951e);
            this.p = bVar;
            bVar.c0(this.f17493b);
            this.w.add(this.p);
            c.a.p0.q1.k.g.a aVar = new c.a.p0.q1.k.g.a(this.a.getPageContext(), x.f10985b);
            this.q = aVar;
            aVar.f0(this.f17493b);
            this.w.add(this.q);
            l lVar = new l(this.a.getPageContext());
            this.s = lVar;
            lVar.b0(this.f17493b);
            this.w.add(this.s);
            p pVar = new p(this.a.getPageContext());
            this.t = pVar;
            pVar.b0(this.f17493b);
            this.w.add(this.t);
            c.a.p0.q1.k.g.e eVar = new c.a.p0.q1.k.g.e(this.a.getPageContext(), b());
            this.u = eVar;
            this.w.add(eVar);
            t tVar = new t(this.a.getPageContext());
            this.v = tVar;
            this.w.add(tVar);
            this.f17493b.a(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17493b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<c.a.d.o.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f17493b.setData(arrayList);
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
