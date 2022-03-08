package c.a.r0.u0.l;

import c.a.d.o.e.n;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.x1;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f22692b;

    /* renamed from: c  reason: collision with root package name */
    public k f22693c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.u0.l.c.b f22694d;

    /* renamed from: e  reason: collision with root package name */
    public d f22695e;

    /* renamed from: f  reason: collision with root package name */
    public c f22696f;

    /* renamed from: g  reason: collision with root package name */
    public e f22697g;

    /* renamed from: h  reason: collision with root package name */
    public l f22698h;

    /* renamed from: i  reason: collision with root package name */
    public g f22699i;

    /* renamed from: j  reason: collision with root package name */
    public i f22700j;
    public h k;
    public f l;
    public j m;
    public c.a.r0.u0.l.c.a n;
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
        this.f22692b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.a.getPageContext(), e2.p3, this.a.getUniqueId(), this.a.getTabName());
            this.f22693c = kVar;
            kVar.d0(this.f22692b);
            this.p.add(this.f22693c);
            c.a.r0.u0.l.c.b bVar = new c.a.r0.u0.l.c.b(this.a.getPageContext(), e2.u3, this.a.getUniqueId(), this.a.getTabName());
            this.f22694d = bVar;
            bVar.e0(this.f22692b);
            this.p.add(this.f22694d);
            d dVar = new d(this.a.getPageContext(), e2.s3, this.a.getUniqueId(), this.a.getTabName());
            this.f22695e = dVar;
            dVar.d0(this.f22692b);
            this.p.add(this.f22695e);
            c cVar = new c(this.a.getPageContext(), e2.t3, this.a.getUniqueId(), this.a.getTabName());
            this.f22696f = cVar;
            cVar.d0(this.f22692b);
            this.p.add(this.f22696f);
            e eVar = new e(this.a.getPageContext(), e2.q3, this.a.getUniqueId(), this.a.getTabName());
            this.f22697g = eVar;
            eVar.d0(this.f22692b);
            this.p.add(this.f22697g);
            l lVar = new l(this.a.getPageContext(), e2.H3, this.a.getUniqueId(), this.a.getTabName());
            this.f22698h = lVar;
            lVar.g0(this.f22692b);
            this.p.add(this.f22698h);
            g gVar = new g(this.a.getPageContext(), e2.B3, this.a.getUniqueId(), this.a.getTabName());
            this.f22699i = gVar;
            gVar.b0(this.f22692b);
            this.p.add(this.f22699i);
            i iVar = new i(this.a.getPageContext(), e2.D3, this.a.getUniqueId(), this.a.getTabName());
            this.f22700j = iVar;
            iVar.d0(this.f22692b);
            this.p.add(this.f22700j);
            h hVar = new h(this.a.getPageContext(), e2.E3, this.a.getUniqueId(), this.a.getTabName());
            this.k = hVar;
            hVar.b0(this.f22692b);
            this.p.add(this.k);
            f fVar = new f(this.a.getPageContext(), e2.A3, this.a.getUniqueId(), this.a.getTabName());
            this.l = fVar;
            fVar.d0(this.f22692b);
            this.p.add(this.l);
            j jVar = new j(this.a.getPageContext(), e2.w3, this.a.getUniqueId(), this.a.getTabName());
            this.m = jVar;
            jVar.d0(this.f22692b);
            this.p.add(this.m);
            c.a.r0.u0.l.c.a aVar = new c.a.r0.u0.l.c.a(this.a.getPageContext(), e2.z3, this.a.getUniqueId(), this.a.getTabName());
            this.n = aVar;
            aVar.e0(this.f22692b);
            this.p.add(this.n);
            m mVar = new m(this.a.getPageContext(), x1.f13416h, this.a.getUniqueId(), this.a.getTabName());
            this.o = mVar;
            mVar.c0(this.f22692b);
            this.p.add(this.o);
            this.f22692b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22692b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f22692b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.r0.u0.l.c.b bVar = this.f22694d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f22696f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f22695e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
