package c.a.r0.e2.d.c;

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
    public TbPageContext<?> f17298a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f17299b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f17300c;

    /* renamed from: d  reason: collision with root package name */
    public j f17301d;

    /* renamed from: e  reason: collision with root package name */
    public c f17302e;

    /* renamed from: f  reason: collision with root package name */
    public e f17303f;

    /* renamed from: g  reason: collision with root package name */
    public d f17304g;

    /* renamed from: h  reason: collision with root package name */
    public f f17305h;

    /* renamed from: i  reason: collision with root package name */
    public k f17306i;

    /* renamed from: j  reason: collision with root package name */
    public g f17307j;
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
        this.f17298a = tbPageContext;
        this.f17299b = bdUniqueId;
        this.f17300c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.f17298a, d2.g3, this.f17299b);
            this.f17301d = jVar;
            jVar.p0(this.f17300c);
            this.o.add(this.f17301d);
            c cVar = new c(this.f17298a, d2.l3, this.f17299b);
            this.f17302e = cVar;
            cVar.q0(this.f17300c);
            this.o.add(this.f17302e);
            e eVar = new e(this.f17298a, d2.j3, this.f17299b);
            this.f17303f = eVar;
            eVar.p0(this.f17300c);
            this.o.add(this.f17303f);
            d dVar = new d(this.f17298a, d2.k3, this.f17299b);
            this.f17304g = dVar;
            dVar.p0(this.f17300c);
            this.o.add(this.f17304g);
            f fVar = new f(this.f17298a, d2.h3, this.f17299b);
            this.f17305h = fVar;
            fVar.p0(this.f17300c);
            this.o.add(this.f17305h);
            k kVar = new k(this.f17298a, d2.x3, this.f17299b);
            this.f17306i = kVar;
            kVar.s0(this.f17300c);
            this.o.add(this.f17306i);
            g gVar = new g(this.f17298a, d2.q3, this.f17299b);
            this.f17307j = gVar;
            gVar.p0(this.f17300c);
            this.o.add(this.f17307j);
            h hVar = new h(this.f17298a, d2.m3, this.f17299b);
            this.k = hVar;
            hVar.p0(this.f17300c);
            this.o.add(this.k);
            b bVar = new b(this.f17298a, d2.p3, this.f17299b);
            this.l = bVar;
            bVar.q0(this.f17300c);
            this.o.add(this.l);
            m mVar = new m(this.f17298a, x.f14362f);
            this.m = mVar;
            mVar.o0(this.f17300c);
            this.o.add(this.m);
            i iVar = new i(this.f17298a, c.a.r0.b0.e0.k.v0);
            this.n = iVar;
            this.o.add(iVar);
            this.f17300c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (c.a.e.l.e.a aVar : this.o) {
                if (aVar instanceof a) {
                    ((a) aVar).j0(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17300c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17300c.setData(list);
        }
    }
}
