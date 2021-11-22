package b.a.r0.e2.d.c;

import b.a.e.m.e.n;
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
    public TbPageContext<?> f17286a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f17287b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f17288c;

    /* renamed from: d  reason: collision with root package name */
    public j f17289d;

    /* renamed from: e  reason: collision with root package name */
    public c f17290e;

    /* renamed from: f  reason: collision with root package name */
    public e f17291f;

    /* renamed from: g  reason: collision with root package name */
    public d f17292g;

    /* renamed from: h  reason: collision with root package name */
    public f f17293h;

    /* renamed from: i  reason: collision with root package name */
    public k f17294i;
    public g j;
    public h k;
    public b l;
    public m m;
    public i n;
    public List<b.a.e.m.e.a> o;

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
        this.f17286a = tbPageContext;
        this.f17287b = bdUniqueId;
        this.f17288c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = new j(this.f17286a, d2.h3, this.f17287b);
            this.f17289d = jVar;
            jVar.o0(this.f17288c);
            this.o.add(this.f17289d);
            c cVar = new c(this.f17286a, d2.m3, this.f17287b);
            this.f17290e = cVar;
            cVar.p0(this.f17288c);
            this.o.add(this.f17290e);
            e eVar = new e(this.f17286a, d2.k3, this.f17287b);
            this.f17291f = eVar;
            eVar.o0(this.f17288c);
            this.o.add(this.f17291f);
            d dVar = new d(this.f17286a, d2.l3, this.f17287b);
            this.f17292g = dVar;
            dVar.o0(this.f17288c);
            this.o.add(this.f17292g);
            f fVar = new f(this.f17286a, d2.i3, this.f17287b);
            this.f17293h = fVar;
            fVar.o0(this.f17288c);
            this.o.add(this.f17293h);
            k kVar = new k(this.f17286a, d2.z3, this.f17287b);
            this.f17294i = kVar;
            kVar.r0(this.f17288c);
            this.o.add(this.f17294i);
            g gVar = new g(this.f17286a, d2.s3, this.f17287b);
            this.j = gVar;
            gVar.o0(this.f17288c);
            this.o.add(this.j);
            h hVar = new h(this.f17286a, d2.o3, this.f17287b);
            this.k = hVar;
            hVar.o0(this.f17288c);
            this.o.add(this.k);
            b bVar = new b(this.f17286a, d2.r3, this.f17287b);
            this.l = bVar;
            bVar.p0(this.f17288c);
            this.o.add(this.l);
            m mVar = new m(this.f17286a, x.f14257f);
            this.m = mVar;
            mVar.n0(this.f17288c);
            this.o.add(this.m);
            i iVar = new i(this.f17286a, b.a.r0.b0.f0.k.x0);
            this.n = iVar;
            this.o.add(iVar);
            this.f17288c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (b.a.e.m.e.a aVar : this.o) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17288c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f17288c.setData(list);
        }
    }
}
