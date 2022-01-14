package c.a.t0.m2.d.c;

import c.a.d.n.e.n;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.x;
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
    public BdUniqueId f19333b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f19334c;

    /* renamed from: d  reason: collision with root package name */
    public j f19335d;

    /* renamed from: e  reason: collision with root package name */
    public c f19336e;

    /* renamed from: f  reason: collision with root package name */
    public e f19337f;

    /* renamed from: g  reason: collision with root package name */
    public d f19338g;

    /* renamed from: h  reason: collision with root package name */
    public f f19339h;

    /* renamed from: i  reason: collision with root package name */
    public k f19340i;

    /* renamed from: j  reason: collision with root package name */
    public g f19341j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<c.a.d.n.e.a> o;

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
        this.f19333b = bdUniqueId;
        this.f19334c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.a, e2.o3, this.f19333b);
            this.f19335d = jVar;
            jVar.h0(this.f19334c);
            this.o.add(this.f19335d);
            c cVar = new c(this.a, e2.t3, this.f19333b);
            this.f19336e = cVar;
            cVar.i0(this.f19334c);
            this.o.add(this.f19336e);
            e eVar = new e(this.a, e2.r3, this.f19333b);
            this.f19337f = eVar;
            eVar.h0(this.f19334c);
            this.o.add(this.f19337f);
            d dVar = new d(this.a, e2.s3, this.f19333b);
            this.f19338g = dVar;
            dVar.h0(this.f19334c);
            this.o.add(this.f19338g);
            f fVar = new f(this.a, e2.p3, this.f19333b);
            this.f19339h = fVar;
            fVar.h0(this.f19334c);
            this.o.add(this.f19339h);
            k kVar = new k(this.a, e2.G3, this.f19333b);
            this.f19340i = kVar;
            kVar.k0(this.f19334c);
            this.o.add(this.f19340i);
            g gVar = new g(this.a, e2.z3, this.f19333b);
            this.f19341j = gVar;
            gVar.h0(this.f19334c);
            this.o.add(this.f19341j);
            h hVar = new h(this.a, e2.v3, this.f19333b);
            this.k = hVar;
            hVar.h0(this.f19334c);
            this.o.add(this.k);
            b bVar = new b(this.a, e2.y3, this.f19333b);
            this.l = bVar;
            bVar.i0(this.f19334c);
            this.o.add(this.l);
            m mVar = new m(this.a, x.f13523f);
            this.m = mVar;
            mVar.g0(this.f19334c);
            this.o.add(this.m);
            i iVar = new i(this.a, c.a.t0.g0.f0.k.y0);
            this.n = iVar;
            this.o.add(iVar);
            this.f19334c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (c.a.d.n.e.a aVar : this.o) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19334c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f19334c.setData(list);
        }
    }
}
