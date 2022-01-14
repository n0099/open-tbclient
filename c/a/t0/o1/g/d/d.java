package c.a.t0.o1.g.d;

import c.a.d.n.e.n;
import c.a.d.n.e.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.n.e.a> f20385b;

    /* renamed from: c  reason: collision with root package name */
    public s f20386c;

    /* renamed from: d  reason: collision with root package name */
    public c f20387d;

    /* renamed from: e  reason: collision with root package name */
    public h f20388e;

    /* renamed from: f  reason: collision with root package name */
    public b f20389f;

    /* renamed from: g  reason: collision with root package name */
    public f f20390g;

    /* renamed from: h  reason: collision with root package name */
    public e f20391h;

    /* renamed from: i  reason: collision with root package name */
    public g f20392i;

    /* renamed from: j  reason: collision with root package name */
    public i f20393j;

    public d(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f20386c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20385b = new ArrayList();
            c cVar = new c(this.a);
            this.f20387d = cVar;
            cVar.c0(this.f20386c);
            this.f20385b.add(this.f20387d);
            h hVar = new h(this.a);
            this.f20388e = hVar;
            hVar.c0(this.f20386c);
            this.f20385b.add(this.f20388e);
            b bVar = new b(this.a);
            this.f20389f = bVar;
            bVar.c0(this.f20386c);
            this.f20385b.add(this.f20389f);
            f fVar = new f(this.a);
            this.f20390g = fVar;
            fVar.c0(this.f20386c);
            this.f20385b.add(this.f20390g);
            e eVar = new e(this.a);
            this.f20391h = eVar;
            eVar.c0(this.f20386c);
            this.f20385b.add(this.f20391h);
            g gVar = new g(this.a);
            this.f20392i = gVar;
            gVar.c0(this.f20386c);
            this.f20385b.add(this.f20392i);
            i iVar = new i(this.a);
            this.f20393j = iVar;
            iVar.c0(this.f20386c);
            this.f20385b.add(this.f20393j);
            this.f20386c.addAdapters(this.f20385b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f20386c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f20386c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(c.a.s0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (c.a.d.n.e.a aVar : this.f20385b) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (c.a.d.n.e.a aVar : this.f20385b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
