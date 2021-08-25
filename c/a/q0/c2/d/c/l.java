package c.a.q0.c2.d.c;

import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.x;
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
/* loaded from: classes3.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f16578a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f16579b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f16580c;

    /* renamed from: d  reason: collision with root package name */
    public j f16581d;

    /* renamed from: e  reason: collision with root package name */
    public c f16582e;

    /* renamed from: f  reason: collision with root package name */
    public e f16583f;

    /* renamed from: g  reason: collision with root package name */
    public d f16584g;

    /* renamed from: h  reason: collision with root package name */
    public f f16585h;

    /* renamed from: i  reason: collision with root package name */
    public k f16586i;

    /* renamed from: j  reason: collision with root package name */
    public g f16587j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<c.a.e.l.e.a> o;

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
        this.f16578a = tbPageContext;
        this.f16579b = bdUniqueId;
        this.f16580c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.f16578a, c2.c3, this.f16579b);
            this.f16581d = jVar;
            jVar.o0(this.f16580c);
            this.o.add(this.f16581d);
            c cVar = new c(this.f16578a, c2.h3, this.f16579b);
            this.f16582e = cVar;
            cVar.p0(this.f16580c);
            this.o.add(this.f16582e);
            e eVar = new e(this.f16578a, c2.f3, this.f16579b);
            this.f16583f = eVar;
            eVar.o0(this.f16580c);
            this.o.add(this.f16583f);
            d dVar = new d(this.f16578a, c2.g3, this.f16579b);
            this.f16584g = dVar;
            dVar.o0(this.f16580c);
            this.o.add(this.f16584g);
            f fVar = new f(this.f16578a, c2.d3, this.f16579b);
            this.f16585h = fVar;
            fVar.o0(this.f16580c);
            this.o.add(this.f16585h);
            k kVar = new k(this.f16578a, c2.t3, this.f16579b);
            this.f16586i = kVar;
            kVar.r0(this.f16580c);
            this.o.add(this.f16586i);
            g gVar = new g(this.f16578a, c2.m3, this.f16579b);
            this.f16587j = gVar;
            gVar.o0(this.f16580c);
            this.o.add(this.f16587j);
            h hVar = new h(this.f16578a, c2.i3, this.f16579b);
            this.k = hVar;
            hVar.o0(this.f16580c);
            this.o.add(this.k);
            b bVar = new b(this.f16578a, c2.l3, this.f16579b);
            this.l = bVar;
            bVar.p0(this.f16580c);
            this.o.add(this.l);
            m mVar = new m(this.f16578a, x.f14378f);
            this.m = mVar;
            mVar.n0(this.f16580c);
            this.o.add(this.m);
            i iVar = new i(this.f16578a, c.a.q0.a0.d0.k.v0);
            this.n = iVar;
            this.o.add(iVar);
            this.f16580c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (c.a.e.l.e.a aVar : this.o) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16580c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f16580c.setData(list);
        }
    }
}
