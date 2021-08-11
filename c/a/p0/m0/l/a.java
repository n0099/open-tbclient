package c.a.p0.m0.l;

import c.a.e.k.e.n;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.w1;
import c.a.p0.m0.l.c.c;
import c.a.p0.m0.l.c.d;
import c.a.p0.m0.l.c.e;
import c.a.p0.m0.l.c.f;
import c.a.p0.m0.l.c.g;
import c.a.p0.m0.l.c.h;
import c.a.p0.m0.l.c.i;
import c.a.p0.m0.l.c.j;
import c.a.p0.m0.l.c.k;
import c.a.p0.m0.l.c.l;
import c.a.p0.m0.l.c.m;
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
    public EnterForumTabFeedFragment f21788a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f21789b;

    /* renamed from: c  reason: collision with root package name */
    public k f21790c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.m0.l.c.b f21791d;

    /* renamed from: e  reason: collision with root package name */
    public d f21792e;

    /* renamed from: f  reason: collision with root package name */
    public c f21793f;

    /* renamed from: g  reason: collision with root package name */
    public e f21794g;

    /* renamed from: h  reason: collision with root package name */
    public l f21795h;

    /* renamed from: i  reason: collision with root package name */
    public g f21796i;

    /* renamed from: j  reason: collision with root package name */
    public i f21797j;
    public h k;
    public f l;
    public j m;
    public c.a.p0.m0.l.c.a n;
    public m o;
    public List<c.a.e.k.e.a> p;

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
        this.f21788a = enterForumTabFeedFragment;
        this.f21789b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.f21788a.getPageContext(), c2.c3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.f21790c = kVar;
            kVar.l0(this.f21789b);
            this.p.add(this.f21790c);
            c.a.p0.m0.l.c.b bVar = new c.a.p0.m0.l.c.b(this.f21788a.getPageContext(), c2.h3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.f21791d = bVar;
            bVar.m0(this.f21789b);
            this.p.add(this.f21791d);
            d dVar = new d(this.f21788a.getPageContext(), c2.f3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.f21792e = dVar;
            dVar.l0(this.f21789b);
            this.p.add(this.f21792e);
            c cVar = new c(this.f21788a.getPageContext(), c2.g3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.f21793f = cVar;
            cVar.l0(this.f21789b);
            this.p.add(this.f21793f);
            e eVar = new e(this.f21788a.getPageContext(), c2.d3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.f21794g = eVar;
            eVar.l0(this.f21789b);
            this.p.add(this.f21794g);
            l lVar = new l(this.f21788a.getPageContext(), c2.t3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.f21795h = lVar;
            lVar.o0(this.f21789b);
            this.p.add(this.f21795h);
            g gVar = new g(this.f21788a.getPageContext(), c2.n3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.f21796i = gVar;
            gVar.j0(this.f21789b);
            this.p.add(this.f21796i);
            i iVar = new i(this.f21788a.getPageContext(), c2.p3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.f21797j = iVar;
            iVar.l0(this.f21789b);
            this.p.add(this.f21797j);
            h hVar = new h(this.f21788a.getPageContext(), c2.q3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.k = hVar;
            hVar.j0(this.f21789b);
            this.p.add(this.k);
            f fVar = new f(this.f21788a.getPageContext(), c2.m3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.l = fVar;
            fVar.l0(this.f21789b);
            this.p.add(this.l);
            j jVar = new j(this.f21788a.getPageContext(), c2.i3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.m = jVar;
            jVar.l0(this.f21789b);
            this.p.add(this.m);
            c.a.p0.m0.l.c.a aVar = new c.a.p0.m0.l.c.a(this.f21788a.getPageContext(), c2.l3, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.n = aVar;
            aVar.m0(this.f21789b);
            this.p.add(this.n);
            m mVar = new m(this.f21788a.getPageContext(), w1.f14068h, this.f21788a.getUniqueId(), this.f21788a.getTabName());
            this.o = mVar;
            mVar.k0(this.f21789b);
            this.p.add(this.o);
            this.f21789b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21789b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f21789b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.p0.m0.l.c.b bVar = this.f21791d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f21793f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f21792e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
