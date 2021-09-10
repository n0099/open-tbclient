package c.a.r0.d2.d.c;

import c.a.e.l.e.n;
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
/* loaded from: classes3.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f17122a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f17123b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f17124c;

    /* renamed from: d  reason: collision with root package name */
    public j f17125d;

    /* renamed from: e  reason: collision with root package name */
    public c f17126e;

    /* renamed from: f  reason: collision with root package name */
    public e f17127f;

    /* renamed from: g  reason: collision with root package name */
    public d f17128g;

    /* renamed from: h  reason: collision with root package name */
    public f f17129h;

    /* renamed from: i  reason: collision with root package name */
    public k f17130i;

    /* renamed from: j  reason: collision with root package name */
    public g f17131j;
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
        this.f17122a = tbPageContext;
        this.f17123b = bdUniqueId;
        this.f17124c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.f17122a, d2.f3, this.f17123b);
            this.f17125d = jVar;
            jVar.o0(this.f17124c);
            this.o.add(this.f17125d);
            c cVar = new c(this.f17122a, d2.k3, this.f17123b);
            this.f17126e = cVar;
            cVar.p0(this.f17124c);
            this.o.add(this.f17126e);
            e eVar = new e(this.f17122a, d2.i3, this.f17123b);
            this.f17127f = eVar;
            eVar.o0(this.f17124c);
            this.o.add(this.f17127f);
            d dVar = new d(this.f17122a, d2.j3, this.f17123b);
            this.f17128g = dVar;
            dVar.o0(this.f17124c);
            this.o.add(this.f17128g);
            f fVar = new f(this.f17122a, d2.g3, this.f17123b);
            this.f17129h = fVar;
            fVar.o0(this.f17124c);
            this.o.add(this.f17129h);
            k kVar = new k(this.f17122a, d2.w3, this.f17123b);
            this.f17130i = kVar;
            kVar.r0(this.f17124c);
            this.o.add(this.f17130i);
            g gVar = new g(this.f17122a, d2.p3, this.f17123b);
            this.f17131j = gVar;
            gVar.o0(this.f17124c);
            this.o.add(this.f17131j);
            h hVar = new h(this.f17122a, d2.l3, this.f17123b);
            this.k = hVar;
            hVar.o0(this.f17124c);
            this.o.add(this.k);
            b bVar = new b(this.f17122a, d2.o3, this.f17123b);
            this.l = bVar;
            bVar.p0(this.f17124c);
            this.o.add(this.l);
            m mVar = new m(this.f17122a, x.f14342f);
            this.m = mVar;
            mVar.n0(this.f17124c);
            this.o.add(this.m);
            i iVar = new i(this.f17122a, c.a.r0.a0.d0.k.v0);
            this.n = iVar;
            this.o.add(iVar);
            this.f17124c.addAdapters(this.o);
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
            this.f17124c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17124c.setData(list);
        }
    }
}
