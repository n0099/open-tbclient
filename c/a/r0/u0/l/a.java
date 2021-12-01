package c.a.r0.u0.l;

import c.a.d.m.e.n;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x1;
import c.a.r0.u0.l.c.c;
import c.a.r0.u0.l.c.d;
import c.a.r0.u0.l.c.e;
import c.a.r0.u0.l.c.f;
import c.a.r0.u0.l.c.g;
import c.a.r0.u0.l.c.h;
import c.a.r0.u0.l.c.i;
import c.a.r0.u0.l.c.j;
import c.a.r0.u0.l.c.k;
import c.a.r0.u0.l.c.l;
import c.a.r0.u0.l.c.m;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f24265b;

    /* renamed from: c  reason: collision with root package name */
    public k f24266c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.u0.l.c.b f24267d;

    /* renamed from: e  reason: collision with root package name */
    public d f24268e;

    /* renamed from: f  reason: collision with root package name */
    public c f24269f;

    /* renamed from: g  reason: collision with root package name */
    public e f24270g;

    /* renamed from: h  reason: collision with root package name */
    public l f24271h;

    /* renamed from: i  reason: collision with root package name */
    public g f24272i;

    /* renamed from: j  reason: collision with root package name */
    public i f24273j;

    /* renamed from: k  reason: collision with root package name */
    public h f24274k;
    public f l;
    public j m;
    public c.a.r0.u0.l.c.a n;
    public m o;
    public List<c.a.d.m.e.a> p;

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
        this.f24265b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.a.getPageContext(), d2.l3, this.a.getUniqueId(), this.a.getTabName());
            this.f24266c = kVar;
            kVar.k0(this.f24265b);
            this.p.add(this.f24266c);
            c.a.r0.u0.l.c.b bVar = new c.a.r0.u0.l.c.b(this.a.getPageContext(), d2.q3, this.a.getUniqueId(), this.a.getTabName());
            this.f24267d = bVar;
            bVar.l0(this.f24265b);
            this.p.add(this.f24267d);
            d dVar = new d(this.a.getPageContext(), d2.o3, this.a.getUniqueId(), this.a.getTabName());
            this.f24268e = dVar;
            dVar.k0(this.f24265b);
            this.p.add(this.f24268e);
            c cVar = new c(this.a.getPageContext(), d2.p3, this.a.getUniqueId(), this.a.getTabName());
            this.f24269f = cVar;
            cVar.k0(this.f24265b);
            this.p.add(this.f24269f);
            e eVar = new e(this.a.getPageContext(), d2.m3, this.a.getUniqueId(), this.a.getTabName());
            this.f24270g = eVar;
            eVar.k0(this.f24265b);
            this.p.add(this.f24270g);
            l lVar = new l(this.a.getPageContext(), d2.D3, this.a.getUniqueId(), this.a.getTabName());
            this.f24271h = lVar;
            lVar.n0(this.f24265b);
            this.p.add(this.f24271h);
            g gVar = new g(this.a.getPageContext(), d2.x3, this.a.getUniqueId(), this.a.getTabName());
            this.f24272i = gVar;
            gVar.i0(this.f24265b);
            this.p.add(this.f24272i);
            i iVar = new i(this.a.getPageContext(), d2.z3, this.a.getUniqueId(), this.a.getTabName());
            this.f24273j = iVar;
            iVar.k0(this.f24265b);
            this.p.add(this.f24273j);
            h hVar = new h(this.a.getPageContext(), d2.A3, this.a.getUniqueId(), this.a.getTabName());
            this.f24274k = hVar;
            hVar.i0(this.f24265b);
            this.p.add(this.f24274k);
            f fVar = new f(this.a.getPageContext(), d2.w3, this.a.getUniqueId(), this.a.getTabName());
            this.l = fVar;
            fVar.k0(this.f24265b);
            this.p.add(this.l);
            j jVar = new j(this.a.getPageContext(), d2.s3, this.a.getUniqueId(), this.a.getTabName());
            this.m = jVar;
            jVar.k0(this.f24265b);
            this.p.add(this.m);
            c.a.r0.u0.l.c.a aVar = new c.a.r0.u0.l.c.a(this.a.getPageContext(), d2.v3, this.a.getUniqueId(), this.a.getTabName());
            this.n = aVar;
            aVar.l0(this.f24265b);
            this.p.add(this.n);
            m mVar = new m(this.a.getPageContext(), x1.f13094h, this.a.getUniqueId(), this.a.getTabName());
            this.o = mVar;
            mVar.j0(this.f24265b);
            this.p.add(this.o);
            this.f24265b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24265b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f24265b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.r0.u0.l.c.b bVar = this.f24267d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f24269f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f24268e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
