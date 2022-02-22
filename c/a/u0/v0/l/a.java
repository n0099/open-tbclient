package c.a.u0.v0.l;

import c.a.d.o.e.n;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.x1;
import c.a.u0.v0.l.c.c;
import c.a.u0.v0.l.c.d;
import c.a.u0.v0.l.c.e;
import c.a.u0.v0.l.c.f;
import c.a.u0.v0.l.c.g;
import c.a.u0.v0.l.c.h;
import c.a.u0.v0.l.c.i;
import c.a.u0.v0.l.c.j;
import c.a.u0.v0.l.c.k;
import c.a.u0.v0.l.c.l;
import c.a.u0.v0.l.c.m;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f24582b;

    /* renamed from: c  reason: collision with root package name */
    public k f24583c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.u0.v0.l.c.b f24584d;

    /* renamed from: e  reason: collision with root package name */
    public d f24585e;

    /* renamed from: f  reason: collision with root package name */
    public c f24586f;

    /* renamed from: g  reason: collision with root package name */
    public e f24587g;

    /* renamed from: h  reason: collision with root package name */
    public l f24588h;

    /* renamed from: i  reason: collision with root package name */
    public g f24589i;

    /* renamed from: j  reason: collision with root package name */
    public i f24590j;
    public h k;
    public f l;
    public j m;
    public c.a.u0.v0.l.c.a n;
    public m o;
    public List<c.a.d.o.e.a> p;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new LinkedList();
        this.a = enterForumTabFeedFragment;
        this.f24582b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.a.getPageContext(), e2.p3, this.a.getUniqueId(), this.a.getTabName());
            this.f24583c = kVar;
            kVar.d0(this.f24582b);
            this.p.add(this.f24583c);
            c.a.u0.v0.l.c.b bVar = new c.a.u0.v0.l.c.b(this.a.getPageContext(), e2.u3, this.a.getUniqueId(), this.a.getTabName());
            this.f24584d = bVar;
            bVar.e0(this.f24582b);
            this.p.add(this.f24584d);
            d dVar = new d(this.a.getPageContext(), e2.s3, this.a.getUniqueId(), this.a.getTabName());
            this.f24585e = dVar;
            dVar.d0(this.f24582b);
            this.p.add(this.f24585e);
            c cVar = new c(this.a.getPageContext(), e2.t3, this.a.getUniqueId(), this.a.getTabName());
            this.f24586f = cVar;
            cVar.d0(this.f24582b);
            this.p.add(this.f24586f);
            e eVar = new e(this.a.getPageContext(), e2.q3, this.a.getUniqueId(), this.a.getTabName());
            this.f24587g = eVar;
            eVar.d0(this.f24582b);
            this.p.add(this.f24587g);
            l lVar = new l(this.a.getPageContext(), e2.H3, this.a.getUniqueId(), this.a.getTabName());
            this.f24588h = lVar;
            lVar.g0(this.f24582b);
            this.p.add(this.f24588h);
            g gVar = new g(this.a.getPageContext(), e2.B3, this.a.getUniqueId(), this.a.getTabName());
            this.f24589i = gVar;
            gVar.b0(this.f24582b);
            this.p.add(this.f24589i);
            i iVar = new i(this.a.getPageContext(), e2.D3, this.a.getUniqueId(), this.a.getTabName());
            this.f24590j = iVar;
            iVar.d0(this.f24582b);
            this.p.add(this.f24590j);
            h hVar = new h(this.a.getPageContext(), e2.E3, this.a.getUniqueId(), this.a.getTabName());
            this.k = hVar;
            hVar.b0(this.f24582b);
            this.p.add(this.k);
            f fVar = new f(this.a.getPageContext(), e2.A3, this.a.getUniqueId(), this.a.getTabName());
            this.l = fVar;
            fVar.d0(this.f24582b);
            this.p.add(this.l);
            j jVar = new j(this.a.getPageContext(), e2.w3, this.a.getUniqueId(), this.a.getTabName());
            this.m = jVar;
            jVar.d0(this.f24582b);
            this.p.add(this.m);
            c.a.u0.v0.l.c.a aVar = new c.a.u0.v0.l.c.a(this.a.getPageContext(), e2.z3, this.a.getUniqueId(), this.a.getTabName());
            this.n = aVar;
            aVar.e0(this.f24582b);
            this.p.add(this.n);
            m mVar = new m(this.a.getPageContext(), x1.f14000h, this.a.getUniqueId(), this.a.getTabName());
            this.o = mVar;
            mVar.c0(this.f24582b);
            this.p.add(this.o);
            this.f24582b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24582b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f24582b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.u0.v0.l.c.b bVar = this.f24584d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f24586f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f24585e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
