package b.a.r0.o0.l;

import b.a.e.l.e.n;
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
    public EnterForumTabFeedFragment f21756a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f21757b;

    /* renamed from: c  reason: collision with root package name */
    public k f21758c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.o0.l.c.b f21759d;

    /* renamed from: e  reason: collision with root package name */
    public d f21760e;

    /* renamed from: f  reason: collision with root package name */
    public c f21761f;

    /* renamed from: g  reason: collision with root package name */
    public e f21762g;

    /* renamed from: h  reason: collision with root package name */
    public l f21763h;

    /* renamed from: i  reason: collision with root package name */
    public g f21764i;
    public i j;
    public h k;
    public f l;
    public j m;
    public b.a.r0.o0.l.c.a n;
    public m o;
    public List<b.a.e.l.e.a> p;

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
        this.f21756a = enterForumTabFeedFragment;
        this.f21757b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.f21756a.getPageContext(), d2.g3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.f21758c = kVar;
            kVar.k0(this.f21757b);
            this.p.add(this.f21758c);
            b.a.r0.o0.l.c.b bVar = new b.a.r0.o0.l.c.b(this.f21756a.getPageContext(), d2.l3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.f21759d = bVar;
            bVar.l0(this.f21757b);
            this.p.add(this.f21759d);
            d dVar = new d(this.f21756a.getPageContext(), d2.j3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.f21760e = dVar;
            dVar.k0(this.f21757b);
            this.p.add(this.f21760e);
            c cVar = new c(this.f21756a.getPageContext(), d2.k3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.f21761f = cVar;
            cVar.k0(this.f21757b);
            this.p.add(this.f21761f);
            e eVar = new e(this.f21756a.getPageContext(), d2.h3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.f21762g = eVar;
            eVar.k0(this.f21757b);
            this.p.add(this.f21762g);
            l lVar = new l(this.f21756a.getPageContext(), d2.x3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.f21763h = lVar;
            lVar.n0(this.f21757b);
            this.p.add(this.f21763h);
            g gVar = new g(this.f21756a.getPageContext(), d2.r3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.f21764i = gVar;
            gVar.i0(this.f21757b);
            this.p.add(this.f21764i);
            i iVar = new i(this.f21756a.getPageContext(), d2.t3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.j = iVar;
            iVar.k0(this.f21757b);
            this.p.add(this.j);
            h hVar = new h(this.f21756a.getPageContext(), d2.u3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.k = hVar;
            hVar.i0(this.f21757b);
            this.p.add(this.k);
            f fVar = new f(this.f21756a.getPageContext(), d2.q3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.l = fVar;
            fVar.k0(this.f21757b);
            this.p.add(this.l);
            j jVar = new j(this.f21756a.getPageContext(), d2.m3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.m = jVar;
            jVar.k0(this.f21757b);
            this.p.add(this.m);
            b.a.r0.o0.l.c.a aVar = new b.a.r0.o0.l.c.a(this.f21756a.getPageContext(), d2.p3, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.n = aVar;
            aVar.l0(this.f21757b);
            this.p.add(this.n);
            m mVar = new m(this.f21756a.getPageContext(), x1.f13487h, this.f21756a.getUniqueId(), this.f21756a.getTabName());
            this.o = mVar;
            mVar.j0(this.f21757b);
            this.p.add(this.o);
            this.f21757b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21757b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f21757b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            b.a.r0.o0.l.c.b bVar = this.f21759d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f21761f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f21760e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
