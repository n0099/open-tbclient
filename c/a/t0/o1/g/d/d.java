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
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.n.e.a> f20947b;

    /* renamed from: c  reason: collision with root package name */
    public s f20948c;

    /* renamed from: d  reason: collision with root package name */
    public c f20949d;

    /* renamed from: e  reason: collision with root package name */
    public h f20950e;

    /* renamed from: f  reason: collision with root package name */
    public b f20951f;

    /* renamed from: g  reason: collision with root package name */
    public f f20952g;

    /* renamed from: h  reason: collision with root package name */
    public e f20953h;

    /* renamed from: i  reason: collision with root package name */
    public g f20954i;

    /* renamed from: j  reason: collision with root package name */
    public i f20955j;

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
        this.f20948c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20947b = new ArrayList();
            c cVar = new c(this.a);
            this.f20949d = cVar;
            cVar.c0(this.f20948c);
            this.f20947b.add(this.f20949d);
            h hVar = new h(this.a);
            this.f20950e = hVar;
            hVar.c0(this.f20948c);
            this.f20947b.add(this.f20950e);
            b bVar = new b(this.a);
            this.f20951f = bVar;
            bVar.c0(this.f20948c);
            this.f20947b.add(this.f20951f);
            f fVar = new f(this.a);
            this.f20952g = fVar;
            fVar.c0(this.f20948c);
            this.f20947b.add(this.f20952g);
            e eVar = new e(this.a);
            this.f20953h = eVar;
            eVar.c0(this.f20948c);
            this.f20947b.add(this.f20953h);
            g gVar = new g(this.a);
            this.f20954i = gVar;
            gVar.c0(this.f20948c);
            this.f20947b.add(this.f20954i);
            i iVar = new i(this.a);
            this.f20955j = iVar;
            iVar.c0(this.f20948c);
            this.f20947b.add(this.f20955j);
            this.f20948c.addAdapters(this.f20947b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f20948c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f20948c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(c.a.s0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (c.a.d.n.e.a aVar : this.f20947b) {
                if (aVar instanceof a) {
                    ((a) aVar).b0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (c.a.d.n.e.a aVar : this.f20947b) {
                aVar.X(bdUniqueId);
            }
        }
    }
}
