package c.a.r0.n0.l;

import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x1;
import c.a.r0.n0.l.c.c;
import c.a.r0.n0.l.c.d;
import c.a.r0.n0.l.c.e;
import c.a.r0.n0.l.c.f;
import c.a.r0.n0.l.c.g;
import c.a.r0.n0.l.c.h;
import c.a.r0.n0.l.c.i;
import c.a.r0.n0.l.c.j;
import c.a.r0.n0.l.c.k;
import c.a.r0.n0.l.c.l;
import c.a.r0.n0.l.c.m;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f22686a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f22687b;

    /* renamed from: c  reason: collision with root package name */
    public k f22688c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.n0.l.c.b f22689d;

    /* renamed from: e  reason: collision with root package name */
    public d f22690e;

    /* renamed from: f  reason: collision with root package name */
    public c f22691f;

    /* renamed from: g  reason: collision with root package name */
    public e f22692g;

    /* renamed from: h  reason: collision with root package name */
    public l f22693h;

    /* renamed from: i  reason: collision with root package name */
    public g f22694i;

    /* renamed from: j  reason: collision with root package name */
    public i f22695j;
    public h k;
    public f l;
    public j m;
    public c.a.r0.n0.l.c.a n;
    public m o;
    public List<c.a.e.l.e.a> p;

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
        this.f22686a = enterForumTabFeedFragment;
        this.f22687b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.f22686a.getPageContext(), d2.f3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.f22688c = kVar;
            kVar.l0(this.f22687b);
            this.p.add(this.f22688c);
            c.a.r0.n0.l.c.b bVar = new c.a.r0.n0.l.c.b(this.f22686a.getPageContext(), d2.k3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.f22689d = bVar;
            bVar.m0(this.f22687b);
            this.p.add(this.f22689d);
            d dVar = new d(this.f22686a.getPageContext(), d2.i3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.f22690e = dVar;
            dVar.l0(this.f22687b);
            this.p.add(this.f22690e);
            c cVar = new c(this.f22686a.getPageContext(), d2.j3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.f22691f = cVar;
            cVar.l0(this.f22687b);
            this.p.add(this.f22691f);
            e eVar = new e(this.f22686a.getPageContext(), d2.g3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.f22692g = eVar;
            eVar.l0(this.f22687b);
            this.p.add(this.f22692g);
            l lVar = new l(this.f22686a.getPageContext(), d2.w3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.f22693h = lVar;
            lVar.o0(this.f22687b);
            this.p.add(this.f22693h);
            g gVar = new g(this.f22686a.getPageContext(), d2.q3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.f22694i = gVar;
            gVar.j0(this.f22687b);
            this.p.add(this.f22694i);
            i iVar = new i(this.f22686a.getPageContext(), d2.s3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.f22695j = iVar;
            iVar.l0(this.f22687b);
            this.p.add(this.f22695j);
            h hVar = new h(this.f22686a.getPageContext(), d2.t3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.k = hVar;
            hVar.j0(this.f22687b);
            this.p.add(this.k);
            f fVar = new f(this.f22686a.getPageContext(), d2.p3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.l = fVar;
            fVar.l0(this.f22687b);
            this.p.add(this.l);
            j jVar = new j(this.f22686a.getPageContext(), d2.l3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.m = jVar;
            jVar.l0(this.f22687b);
            this.p.add(this.m);
            c.a.r0.n0.l.c.a aVar = new c.a.r0.n0.l.c.a(this.f22686a.getPageContext(), d2.o3, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.n = aVar;
            aVar.m0(this.f22687b);
            this.p.add(this.n);
            m mVar = new m(this.f22686a.getPageContext(), x1.f14355h, this.f22686a.getUniqueId(), this.f22686a.getTabName());
            this.o = mVar;
            mVar.k0(this.f22687b);
            this.p.add(this.o);
            this.f22687b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22687b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f22687b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.r0.n0.l.c.b bVar = this.f22689d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f22691f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f22690e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
