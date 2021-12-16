package c.a.s0.u0.l;

import c.a.d.m.e.n;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.x1;
import c.a.s0.u0.l.c.c;
import c.a.s0.u0.l.c.d;
import c.a.s0.u0.l.c.e;
import c.a.s0.u0.l.c.f;
import c.a.s0.u0.l.c.g;
import c.a.s0.u0.l.c.h;
import c.a.s0.u0.l.c.i;
import c.a.s0.u0.l.c.j;
import c.a.s0.u0.l.c.k;
import c.a.s0.u0.l.c.l;
import c.a.s0.u0.l.c.m;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f24278b;

    /* renamed from: c  reason: collision with root package name */
    public k f24279c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.u0.l.c.b f24280d;

    /* renamed from: e  reason: collision with root package name */
    public d f24281e;

    /* renamed from: f  reason: collision with root package name */
    public c f24282f;

    /* renamed from: g  reason: collision with root package name */
    public e f24283g;

    /* renamed from: h  reason: collision with root package name */
    public l f24284h;

    /* renamed from: i  reason: collision with root package name */
    public g f24285i;

    /* renamed from: j  reason: collision with root package name */
    public i f24286j;

    /* renamed from: k  reason: collision with root package name */
    public h f24287k;
    public f l;
    public j m;
    public c.a.s0.u0.l.c.a n;
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
        this.f24278b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.a.getPageContext(), d2.m3, this.a.getUniqueId(), this.a.getTabName());
            this.f24279c = kVar;
            kVar.k0(this.f24278b);
            this.p.add(this.f24279c);
            c.a.s0.u0.l.c.b bVar = new c.a.s0.u0.l.c.b(this.a.getPageContext(), d2.r3, this.a.getUniqueId(), this.a.getTabName());
            this.f24280d = bVar;
            bVar.l0(this.f24278b);
            this.p.add(this.f24280d);
            d dVar = new d(this.a.getPageContext(), d2.p3, this.a.getUniqueId(), this.a.getTabName());
            this.f24281e = dVar;
            dVar.k0(this.f24278b);
            this.p.add(this.f24281e);
            c cVar = new c(this.a.getPageContext(), d2.q3, this.a.getUniqueId(), this.a.getTabName());
            this.f24282f = cVar;
            cVar.k0(this.f24278b);
            this.p.add(this.f24282f);
            e eVar = new e(this.a.getPageContext(), d2.n3, this.a.getUniqueId(), this.a.getTabName());
            this.f24283g = eVar;
            eVar.k0(this.f24278b);
            this.p.add(this.f24283g);
            l lVar = new l(this.a.getPageContext(), d2.E3, this.a.getUniqueId(), this.a.getTabName());
            this.f24284h = lVar;
            lVar.n0(this.f24278b);
            this.p.add(this.f24284h);
            g gVar = new g(this.a.getPageContext(), d2.y3, this.a.getUniqueId(), this.a.getTabName());
            this.f24285i = gVar;
            gVar.i0(this.f24278b);
            this.p.add(this.f24285i);
            i iVar = new i(this.a.getPageContext(), d2.A3, this.a.getUniqueId(), this.a.getTabName());
            this.f24286j = iVar;
            iVar.k0(this.f24278b);
            this.p.add(this.f24286j);
            h hVar = new h(this.a.getPageContext(), d2.B3, this.a.getUniqueId(), this.a.getTabName());
            this.f24287k = hVar;
            hVar.i0(this.f24278b);
            this.p.add(this.f24287k);
            f fVar = new f(this.a.getPageContext(), d2.x3, this.a.getUniqueId(), this.a.getTabName());
            this.l = fVar;
            fVar.k0(this.f24278b);
            this.p.add(this.l);
            j jVar = new j(this.a.getPageContext(), d2.t3, this.a.getUniqueId(), this.a.getTabName());
            this.m = jVar;
            jVar.k0(this.f24278b);
            this.p.add(this.m);
            c.a.s0.u0.l.c.a aVar = new c.a.s0.u0.l.c.a(this.a.getPageContext(), d2.w3, this.a.getUniqueId(), this.a.getTabName());
            this.n = aVar;
            aVar.l0(this.f24278b);
            this.p.add(this.n);
            m mVar = new m(this.a.getPageContext(), x1.f13474h, this.a.getUniqueId(), this.a.getTabName());
            this.o = mVar;
            mVar.j0(this.f24278b);
            this.p.add(this.o);
            this.f24278b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24278b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f24278b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.s0.u0.l.c.b bVar = this.f24280d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f24282f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f24281e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
