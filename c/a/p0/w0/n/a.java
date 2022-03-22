package c.a.p0.w0.n;

import c.a.d.o.e.n;
import c.a.o0.r.r.u1;
import c.a.p0.w0.n.c.c;
import c.a.p0.w0.n.c.d;
import c.a.p0.w0.n.c.e;
import c.a.p0.w0.n.c.f;
import c.a.p0.w0.n.c.g;
import c.a.p0.w0.n.c.h;
import c.a.p0.w0.n.c.i;
import c.a.p0.w0.n.c.j;
import c.a.p0.w0.n.c.k;
import c.a.p0.w0.n.c.l;
import c.a.p0.w0.n.c.m;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
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
    public BdTypeRecyclerView f19518b;

    /* renamed from: c  reason: collision with root package name */
    public k f19519c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.w0.n.c.b f19520d;

    /* renamed from: e  reason: collision with root package name */
    public d f19521e;

    /* renamed from: f  reason: collision with root package name */
    public c f19522f;

    /* renamed from: g  reason: collision with root package name */
    public e f19523g;

    /* renamed from: h  reason: collision with root package name */
    public l f19524h;
    public g i;
    public i j;
    public h k;
    public f l;
    public j m;
    public c.a.p0.w0.n.c.a n;
    public m o;
    public List<c.a.d.o.e.a> p;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new LinkedList();
        this.a = enterForumTabFeedFragment;
        this.f19518b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = new k(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E0());
            this.f19519c = kVar;
            kVar.d0(this.f19518b);
            this.p.add(this.f19519c);
            c.a.p0.w0.n.c.b bVar = new c.a.p0.w0.n.c.b(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E0());
            this.f19520d = bVar;
            bVar.e0(this.f19518b);
            this.p.add(this.f19520d);
            d dVar = new d(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E0());
            this.f19521e = dVar;
            dVar.d0(this.f19518b);
            this.p.add(this.f19521e);
            c cVar = new c(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E0());
            this.f19522f = cVar;
            cVar.d0(this.f19518b);
            this.p.add(this.f19522f);
            e eVar = new e(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E0());
            this.f19523g = eVar;
            eVar.d0(this.f19518b);
            this.p.add(this.f19523g);
            l lVar = new l(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E0());
            this.f19524h = lVar;
            lVar.g0(this.f19518b);
            this.p.add(this.f19524h);
            g gVar = new g(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E0());
            this.i = gVar;
            gVar.b0(this.f19518b);
            this.p.add(this.i);
            i iVar = new i(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E0());
            this.j = iVar;
            iVar.d0(this.f19518b);
            this.p.add(this.j);
            h hVar = new h(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E0());
            this.k = hVar;
            hVar.b0(this.f19518b);
            this.p.add(this.k);
            f fVar = new f(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E0());
            this.l = fVar;
            fVar.d0(this.f19518b);
            this.p.add(this.l);
            j jVar = new j(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E0());
            this.m = jVar;
            jVar.d0(this.f19518b);
            this.p.add(this.m);
            c.a.p0.w0.n.c.a aVar = new c.a.p0.w0.n.c.a(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E0());
            this.n = aVar;
            aVar.e0(this.f19518b);
            this.p.add(this.n);
            m mVar = new m(this.a.getPageContext(), u1.f10958d, this.a.getUniqueId(), this.a.E0());
            this.o = mVar;
            mVar.c0(this.f19518b);
            this.p.add(this.o);
            this.f19518b.a(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19518b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f19518b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.p0.w0.n.c.b bVar = this.f19520d;
            if (bVar != null) {
                bVar.setFromCDN(z);
            }
            c cVar = this.f19522f;
            if (cVar != null) {
                cVar.setFromCDN(z);
            }
            d dVar = this.f19521e;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
        }
    }
}
