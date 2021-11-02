package b.a.r0.e2.d.c;

import b.a.e.l.e.n;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x;
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
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f16273a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f16274b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f16275c;

    /* renamed from: d  reason: collision with root package name */
    public j f16276d;

    /* renamed from: e  reason: collision with root package name */
    public c f16277e;

    /* renamed from: f  reason: collision with root package name */
    public e f16278f;

    /* renamed from: g  reason: collision with root package name */
    public d f16279g;

    /* renamed from: h  reason: collision with root package name */
    public f f16280h;

    /* renamed from: i  reason: collision with root package name */
    public k f16281i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<b.a.e.l.e.a> o;

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
        this.f16273a = tbPageContext;
        this.f16274b = bdUniqueId;
        this.f16275c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.f16273a, d2.g3, this.f16274b);
            this.f16276d = jVar;
            jVar.o0(this.f16275c);
            this.o.add(this.f16276d);
            c cVar = new c(this.f16273a, d2.l3, this.f16274b);
            this.f16277e = cVar;
            cVar.p0(this.f16275c);
            this.o.add(this.f16277e);
            e eVar = new e(this.f16273a, d2.j3, this.f16274b);
            this.f16278f = eVar;
            eVar.o0(this.f16275c);
            this.o.add(this.f16278f);
            d dVar = new d(this.f16273a, d2.k3, this.f16274b);
            this.f16279g = dVar;
            dVar.o0(this.f16275c);
            this.o.add(this.f16279g);
            f fVar = new f(this.f16273a, d2.h3, this.f16274b);
            this.f16280h = fVar;
            fVar.o0(this.f16275c);
            this.o.add(this.f16280h);
            k kVar = new k(this.f16273a, d2.x3, this.f16274b);
            this.f16281i = kVar;
            kVar.r0(this.f16275c);
            this.o.add(this.f16281i);
            g gVar = new g(this.f16273a, d2.q3, this.f16274b);
            this.j = gVar;
            gVar.o0(this.f16275c);
            this.o.add(this.j);
            h hVar = new h(this.f16273a, d2.m3, this.f16274b);
            this.k = hVar;
            hVar.o0(this.f16275c);
            this.o.add(this.k);
            b bVar = new b(this.f16273a, d2.p3, this.f16274b);
            this.l = bVar;
            bVar.p0(this.f16275c);
            this.o.add(this.l);
            m mVar = new m(this.f16273a, x.f13475f);
            this.m = mVar;
            mVar.n0(this.f16275c);
            this.o.add(this.m);
            i iVar = new i(this.f16273a, b.a.r0.b0.e0.k.v0);
            this.n = iVar;
            this.o.add(iVar);
            this.f16275c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (b.a.e.l.e.a aVar : this.o) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16275c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f16275c.setData(list);
        }
    }
}
