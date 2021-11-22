package b.a.r0.o0.l;

import b.a.e.m.e.n;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x1;
import b.a.r0.o0.l.c.c;
import b.a.r0.o0.l.c.d;
import b.a.r0.o0.l.c.e;
import b.a.r0.o0.l.c.f;
import b.a.r0.o0.l.c.g;
import b.a.r0.o0.l.c.h;
import b.a.r0.o0.l.c.i;
import b.a.r0.o0.l.c.j;
import b.a.r0.o0.l.c.k;
import b.a.r0.o0.l.c.l;
import b.a.r0.o0.l.c.m;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f23255a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f23256b;

    /* renamed from: c  reason: collision with root package name */
    public k f23257c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.o0.l.c.b f23258d;

    /* renamed from: e  reason: collision with root package name */
    public d f23259e;

    /* renamed from: f  reason: collision with root package name */
    public c f23260f;

    /* renamed from: g  reason: collision with root package name */
    public e f23261g;

    /* renamed from: h  reason: collision with root package name */
    public l f23262h;

    /* renamed from: i  reason: collision with root package name */
    public g f23263i;
    public i j;
    public h k;
    public f l;
    public j m;
    public b.a.r0.o0.l.c.a n;
    public m o;
    public List<b.a.e.m.e.a> p;

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
        this.f23255a = enterForumTabFeedFragment;
        this.f23256b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.f23255a.getPageContext(), d2.h3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.f23257c = kVar;
            kVar.k0(this.f23256b);
            this.p.add(this.f23257c);
            b.a.r0.o0.l.c.b bVar = new b.a.r0.o0.l.c.b(this.f23255a.getPageContext(), d2.m3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.f23258d = bVar;
            bVar.l0(this.f23256b);
            this.p.add(this.f23258d);
            d dVar = new d(this.f23255a.getPageContext(), d2.k3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.f23259e = dVar;
            dVar.k0(this.f23256b);
            this.p.add(this.f23259e);
            c cVar = new c(this.f23255a.getPageContext(), d2.l3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.f23260f = cVar;
            cVar.k0(this.f23256b);
            this.p.add(this.f23260f);
            e eVar = new e(this.f23255a.getPageContext(), d2.i3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.f23261g = eVar;
            eVar.k0(this.f23256b);
            this.p.add(this.f23261g);
            l lVar = new l(this.f23255a.getPageContext(), d2.z3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.f23262h = lVar;
            lVar.n0(this.f23256b);
            this.p.add(this.f23262h);
            g gVar = new g(this.f23255a.getPageContext(), d2.t3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.f23263i = gVar;
            gVar.i0(this.f23256b);
            this.p.add(this.f23263i);
            i iVar = new i(this.f23255a.getPageContext(), d2.v3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.j = iVar;
            iVar.k0(this.f23256b);
            this.p.add(this.j);
            h hVar = new h(this.f23255a.getPageContext(), d2.w3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.k = hVar;
            hVar.i0(this.f23256b);
            this.p.add(this.k);
            f fVar = new f(this.f23255a.getPageContext(), d2.s3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.l = fVar;
            fVar.k0(this.f23256b);
            this.p.add(this.l);
            j jVar = new j(this.f23255a.getPageContext(), d2.o3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.m = jVar;
            jVar.k0(this.f23256b);
            this.p.add(this.m);
            b.a.r0.o0.l.c.a aVar = new b.a.r0.o0.l.c.a(this.f23255a.getPageContext(), d2.r3, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.n = aVar;
            aVar.l0(this.f23256b);
            this.p.add(this.n);
            m mVar = new m(this.f23255a.getPageContext(), x1.f14269h, this.f23255a.getUniqueId(), this.f23255a.getTabName());
            this.o = mVar;
            mVar.j0(this.f23256b);
            this.p.add(this.o);
            this.f23256b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23256b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f23256b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            b.a.r0.o0.l.c.b bVar = this.f23258d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f23260f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f23259e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
