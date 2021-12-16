package c.a.s0.m2.d.c;

import c.a.d.m.e.n;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.x;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f19416b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f19417c;

    /* renamed from: d  reason: collision with root package name */
    public j f19418d;

    /* renamed from: e  reason: collision with root package name */
    public c f19419e;

    /* renamed from: f  reason: collision with root package name */
    public e f19420f;

    /* renamed from: g  reason: collision with root package name */
    public d f19421g;

    /* renamed from: h  reason: collision with root package name */
    public f f19422h;

    /* renamed from: i  reason: collision with root package name */
    public k f19423i;

    /* renamed from: j  reason: collision with root package name */
    public g f19424j;

    /* renamed from: k  reason: collision with root package name */
    public h f19425k;
    public b l;
    public m m;
    public i n;
    public List<c.a.d.m.e.a> o;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new LinkedList();
        this.a = tbPageContext;
        this.f19416b = bdUniqueId;
        this.f19417c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.a, d2.m3, this.f19416b);
            this.f19418d = jVar;
            jVar.o0(this.f19417c);
            this.o.add(this.f19418d);
            c cVar = new c(this.a, d2.r3, this.f19416b);
            this.f19419e = cVar;
            cVar.p0(this.f19417c);
            this.o.add(this.f19419e);
            e eVar = new e(this.a, d2.p3, this.f19416b);
            this.f19420f = eVar;
            eVar.o0(this.f19417c);
            this.o.add(this.f19420f);
            d dVar = new d(this.a, d2.q3, this.f19416b);
            this.f19421g = dVar;
            dVar.o0(this.f19417c);
            this.o.add(this.f19421g);
            f fVar = new f(this.a, d2.n3, this.f19416b);
            this.f19422h = fVar;
            fVar.o0(this.f19417c);
            this.o.add(this.f19422h);
            k kVar = new k(this.a, d2.E3, this.f19416b);
            this.f19423i = kVar;
            kVar.r0(this.f19417c);
            this.o.add(this.f19423i);
            g gVar = new g(this.a, d2.x3, this.f19416b);
            this.f19424j = gVar;
            gVar.o0(this.f19417c);
            this.o.add(this.f19424j);
            h hVar = new h(this.a, d2.t3, this.f19416b);
            this.f19425k = hVar;
            hVar.o0(this.f19417c);
            this.o.add(this.f19425k);
            b bVar = new b(this.a, d2.w3, this.f19416b);
            this.l = bVar;
            bVar.p0(this.f19417c);
            this.o.add(this.l);
            m mVar = new m(this.a, x.f13461f);
            this.m = mVar;
            mVar.n0(this.f19417c);
            this.o.add(this.m);
            i iVar = new i(this.a, c.a.s0.g0.f0.k.y0);
            this.n = iVar;
            this.o.add(iVar);
            this.f19417c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (c.a.d.m.e.a aVar : this.o) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19417c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f19417c.setData(list);
        }
    }
}
