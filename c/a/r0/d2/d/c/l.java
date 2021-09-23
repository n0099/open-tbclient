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
    public TbPageContext<?> f17132a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f17133b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f17134c;

    /* renamed from: d  reason: collision with root package name */
    public j f17135d;

    /* renamed from: e  reason: collision with root package name */
    public c f17136e;

    /* renamed from: f  reason: collision with root package name */
    public e f17137f;

    /* renamed from: g  reason: collision with root package name */
    public d f17138g;

    /* renamed from: h  reason: collision with root package name */
    public f f17139h;

    /* renamed from: i  reason: collision with root package name */
    public k f17140i;

    /* renamed from: j  reason: collision with root package name */
    public g f17141j;
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
        this.f17132a = tbPageContext;
        this.f17133b = bdUniqueId;
        this.f17134c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.f17132a, d2.g3, this.f17133b);
            this.f17135d = jVar;
            jVar.o0(this.f17134c);
            this.o.add(this.f17135d);
            c cVar = new c(this.f17132a, d2.l3, this.f17133b);
            this.f17136e = cVar;
            cVar.p0(this.f17134c);
            this.o.add(this.f17136e);
            e eVar = new e(this.f17132a, d2.j3, this.f17133b);
            this.f17137f = eVar;
            eVar.o0(this.f17134c);
            this.o.add(this.f17137f);
            d dVar = new d(this.f17132a, d2.k3, this.f17133b);
            this.f17138g = dVar;
            dVar.o0(this.f17134c);
            this.o.add(this.f17138g);
            f fVar = new f(this.f17132a, d2.h3, this.f17133b);
            this.f17139h = fVar;
            fVar.o0(this.f17134c);
            this.o.add(this.f17139h);
            k kVar = new k(this.f17132a, d2.x3, this.f17133b);
            this.f17140i = kVar;
            kVar.r0(this.f17134c);
            this.o.add(this.f17140i);
            g gVar = new g(this.f17132a, d2.q3, this.f17133b);
            this.f17141j = gVar;
            gVar.o0(this.f17134c);
            this.o.add(this.f17141j);
            h hVar = new h(this.f17132a, d2.m3, this.f17133b);
            this.k = hVar;
            hVar.o0(this.f17134c);
            this.o.add(this.k);
            b bVar = new b(this.f17132a, d2.p3, this.f17133b);
            this.l = bVar;
            bVar.p0(this.f17134c);
            this.o.add(this.l);
            m mVar = new m(this.f17132a, x.f14342f);
            this.m = mVar;
            mVar.n0(this.f17134c);
            this.o.add(this.m);
            i iVar = new i(this.f17132a, c.a.r0.a0.d0.k.v0);
            this.n = iVar;
            this.o.add(iVar);
            this.f17134c.addAdapters(this.o);
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
            this.f17134c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17134c.setData(list);
        }
    }
}
