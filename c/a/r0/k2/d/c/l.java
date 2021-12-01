package c.a.r0.k2.d.c;

import c.a.d.m.e.n;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x;
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
/* loaded from: classes6.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f18632b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f18633c;

    /* renamed from: d  reason: collision with root package name */
    public j f18634d;

    /* renamed from: e  reason: collision with root package name */
    public c f18635e;

    /* renamed from: f  reason: collision with root package name */
    public e f18636f;

    /* renamed from: g  reason: collision with root package name */
    public d f18637g;

    /* renamed from: h  reason: collision with root package name */
    public f f18638h;

    /* renamed from: i  reason: collision with root package name */
    public k f18639i;

    /* renamed from: j  reason: collision with root package name */
    public g f18640j;

    /* renamed from: k  reason: collision with root package name */
    public h f18641k;
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
        this.f18632b = bdUniqueId;
        this.f18633c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.a, d2.l3, this.f18632b);
            this.f18634d = jVar;
            jVar.o0(this.f18633c);
            this.o.add(this.f18634d);
            c cVar = new c(this.a, d2.q3, this.f18632b);
            this.f18635e = cVar;
            cVar.p0(this.f18633c);
            this.o.add(this.f18635e);
            e eVar = new e(this.a, d2.o3, this.f18632b);
            this.f18636f = eVar;
            eVar.o0(this.f18633c);
            this.o.add(this.f18636f);
            d dVar = new d(this.a, d2.p3, this.f18632b);
            this.f18637g = dVar;
            dVar.o0(this.f18633c);
            this.o.add(this.f18637g);
            f fVar = new f(this.a, d2.m3, this.f18632b);
            this.f18638h = fVar;
            fVar.o0(this.f18633c);
            this.o.add(this.f18638h);
            k kVar = new k(this.a, d2.D3, this.f18632b);
            this.f18639i = kVar;
            kVar.r0(this.f18633c);
            this.o.add(this.f18639i);
            g gVar = new g(this.a, d2.w3, this.f18632b);
            this.f18640j = gVar;
            gVar.o0(this.f18633c);
            this.o.add(this.f18640j);
            h hVar = new h(this.a, d2.s3, this.f18632b);
            this.f18641k = hVar;
            hVar.o0(this.f18633c);
            this.o.add(this.f18641k);
            b bVar = new b(this.a, d2.v3, this.f18632b);
            this.l = bVar;
            bVar.p0(this.f18633c);
            this.o.add(this.l);
            m mVar = new m(this.a, x.f13081f);
            this.m = mVar;
            mVar.n0(this.f18633c);
            this.o.add(this.m);
            i iVar = new i(this.a, c.a.r0.g0.f0.k.y0);
            this.n = iVar;
            this.o.add(iVar);
            this.f18633c.addAdapters(this.o);
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
            this.f18633c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f18633c.setData(list);
        }
    }
}
