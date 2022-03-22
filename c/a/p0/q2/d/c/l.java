package c.a.p0.q2.d.c;

import c.a.d.o.e.n;
import c.a.o0.r.r.x;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f17651b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f17652c;

    /* renamed from: d  reason: collision with root package name */
    public j f17653d;

    /* renamed from: e  reason: collision with root package name */
    public c f17654e;

    /* renamed from: f  reason: collision with root package name */
    public e f17655f;

    /* renamed from: g  reason: collision with root package name */
    public d f17656g;

    /* renamed from: h  reason: collision with root package name */
    public f f17657h;
    public k i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<c.a.d.o.e.a> o;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new LinkedList();
        this.a = tbPageContext;
        this.f17651b = bdUniqueId;
        this.f17652c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.a, ThreadData.TYPE_USER_NORMAL, this.f17651b);
            this.f17653d = jVar;
            jVar.h0(this.f17652c);
            this.o.add(this.f17653d);
            c cVar = new c(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.f17651b);
            this.f17654e = cVar;
            cVar.i0(this.f17652c);
            this.o.add(this.f17654e);
            e eVar = new e(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.f17651b);
            this.f17655f = eVar;
            eVar.h0(this.f17652c);
            this.o.add(this.f17655f);
            d dVar = new d(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.f17651b);
            this.f17656g = dVar;
            dVar.h0(this.f17652c);
            this.o.add(this.f17656g);
            f fVar = new f(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.f17651b);
            this.f17657h = fVar;
            fVar.h0(this.f17652c);
            this.o.add(this.f17657h);
            k kVar = new k(this.a, ThreadData.TYPE_VIDEO, this.f17651b);
            this.i = kVar;
            kVar.k0(this.f17652c);
            this.o.add(this.i);
            g gVar = new g(this.a, ThreadData.TYPE_ENTER_FORUM, this.f17651b);
            this.j = gVar;
            gVar.h0(this.f17652c);
            this.o.add(this.j);
            h hVar = new h(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.f17651b);
            this.k = hVar;
            hVar.h0(this.f17652c);
            this.o.add(this.k);
            b bVar = new b(this.a, ThreadData.TYPE_ARTICLE, this.f17651b);
            this.l = bVar;
            bVar.i0(this.f17652c);
            this.o.add(this.l);
            m mVar = new m(this.a, x.f10985b);
            this.m = mVar;
            mVar.g0(this.f17652c);
            this.o.add(this.m);
            i iVar = new i(this.a, c.a.p0.h0.e0.k.r0);
            this.n = iVar;
            this.o.add(iVar);
            this.f17652c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (c.a.d.o.e.a aVar : this.o) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17652c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17652c.setData(list);
        }
    }
}
