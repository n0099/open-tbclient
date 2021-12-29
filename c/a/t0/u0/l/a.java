package c.a.t0.u0.l;

import c.a.d.n.e.n;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.x1;
import c.a.t0.u0.l.c.c;
import c.a.t0.u0.l.c.d;
import c.a.t0.u0.l.c.e;
import c.a.t0.u0.l.c.f;
import c.a.t0.u0.l.c.g;
import c.a.t0.u0.l.c.h;
import c.a.t0.u0.l.c.i;
import c.a.t0.u0.l.c.j;
import c.a.t0.u0.l.c.k;
import c.a.t0.u0.l.c.l;
import c.a.t0.u0.l.c.m;
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
    public BdTypeRecyclerView f24798b;

    /* renamed from: c  reason: collision with root package name */
    public k f24799c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.u0.l.c.b f24800d;

    /* renamed from: e  reason: collision with root package name */
    public d f24801e;

    /* renamed from: f  reason: collision with root package name */
    public c f24802f;

    /* renamed from: g  reason: collision with root package name */
    public e f24803g;

    /* renamed from: h  reason: collision with root package name */
    public l f24804h;

    /* renamed from: i  reason: collision with root package name */
    public g f24805i;

    /* renamed from: j  reason: collision with root package name */
    public i f24806j;

    /* renamed from: k  reason: collision with root package name */
    public h f24807k;
    public f l;
    public j m;
    public c.a.t0.u0.l.c.a n;
    public m o;
    public List<c.a.d.n.e.a> p;

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
        this.f24798b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.a.getPageContext(), d2.o3, this.a.getUniqueId(), this.a.getTabName());
            this.f24799c = kVar;
            kVar.d0(this.f24798b);
            this.p.add(this.f24799c);
            c.a.t0.u0.l.c.b bVar = new c.a.t0.u0.l.c.b(this.a.getPageContext(), d2.t3, this.a.getUniqueId(), this.a.getTabName());
            this.f24800d = bVar;
            bVar.e0(this.f24798b);
            this.p.add(this.f24800d);
            d dVar = new d(this.a.getPageContext(), d2.r3, this.a.getUniqueId(), this.a.getTabName());
            this.f24801e = dVar;
            dVar.d0(this.f24798b);
            this.p.add(this.f24801e);
            c cVar = new c(this.a.getPageContext(), d2.s3, this.a.getUniqueId(), this.a.getTabName());
            this.f24802f = cVar;
            cVar.d0(this.f24798b);
            this.p.add(this.f24802f);
            e eVar = new e(this.a.getPageContext(), d2.p3, this.a.getUniqueId(), this.a.getTabName());
            this.f24803g = eVar;
            eVar.d0(this.f24798b);
            this.p.add(this.f24803g);
            l lVar = new l(this.a.getPageContext(), d2.G3, this.a.getUniqueId(), this.a.getTabName());
            this.f24804h = lVar;
            lVar.g0(this.f24798b);
            this.p.add(this.f24804h);
            g gVar = new g(this.a.getPageContext(), d2.A3, this.a.getUniqueId(), this.a.getTabName());
            this.f24805i = gVar;
            gVar.b0(this.f24798b);
            this.p.add(this.f24805i);
            i iVar = new i(this.a.getPageContext(), d2.C3, this.a.getUniqueId(), this.a.getTabName());
            this.f24806j = iVar;
            iVar.d0(this.f24798b);
            this.p.add(this.f24806j);
            h hVar = new h(this.a.getPageContext(), d2.D3, this.a.getUniqueId(), this.a.getTabName());
            this.f24807k = hVar;
            hVar.b0(this.f24798b);
            this.p.add(this.f24807k);
            f fVar = new f(this.a.getPageContext(), d2.z3, this.a.getUniqueId(), this.a.getTabName());
            this.l = fVar;
            fVar.d0(this.f24798b);
            this.p.add(this.l);
            j jVar = new j(this.a.getPageContext(), d2.v3, this.a.getUniqueId(), this.a.getTabName());
            this.m = jVar;
            jVar.d0(this.f24798b);
            this.p.add(this.m);
            c.a.t0.u0.l.c.a aVar = new c.a.t0.u0.l.c.a(this.a.getPageContext(), d2.y3, this.a.getUniqueId(), this.a.getTabName());
            this.n = aVar;
            aVar.e0(this.f24798b);
            this.p.add(this.n);
            m mVar = new m(this.a.getPageContext(), x1.f13850h, this.a.getUniqueId(), this.a.getTabName());
            this.o = mVar;
            mVar.c0(this.f24798b);
            this.p.add(this.o);
            this.f24798b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24798b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f24798b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.t0.u0.l.c.b bVar = this.f24800d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f24802f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f24801e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
