package c.a.s0.o1.g.d;

import c.a.d.m.e.n;
import c.a.d.m.e.s;
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
    public List<c.a.d.m.e.a> f20904b;

    /* renamed from: c  reason: collision with root package name */
    public s f20905c;

    /* renamed from: d  reason: collision with root package name */
    public c f20906d;

    /* renamed from: e  reason: collision with root package name */
    public h f20907e;

    /* renamed from: f  reason: collision with root package name */
    public b f20908f;

    /* renamed from: g  reason: collision with root package name */
    public f f20909g;

    /* renamed from: h  reason: collision with root package name */
    public e f20910h;

    /* renamed from: i  reason: collision with root package name */
    public g f20911i;

    /* renamed from: j  reason: collision with root package name */
    public i f20912j;

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
        this.f20905c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20904b = new ArrayList();
            c cVar = new c(this.a);
            this.f20906d = cVar;
            cVar.j0(this.f20905c);
            this.f20904b.add(this.f20906d);
            h hVar = new h(this.a);
            this.f20907e = hVar;
            hVar.j0(this.f20905c);
            this.f20904b.add(this.f20907e);
            b bVar = new b(this.a);
            this.f20908f = bVar;
            bVar.j0(this.f20905c);
            this.f20904b.add(this.f20908f);
            f fVar = new f(this.a);
            this.f20909g = fVar;
            fVar.j0(this.f20905c);
            this.f20904b.add(this.f20909g);
            e eVar = new e(this.a);
            this.f20910h = eVar;
            eVar.j0(this.f20905c);
            this.f20904b.add(this.f20910h);
            g gVar = new g(this.a);
            this.f20911i = gVar;
            gVar.j0(this.f20905c);
            this.f20904b.add(this.f20911i);
            i iVar = new i(this.a);
            this.f20912j = iVar;
            iVar.j0(this.f20905c);
            this.f20904b.add(this.f20912j);
            this.f20905c.addAdapters(this.f20904b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f20905c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f20905c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(c.a.r0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (c.a.d.m.e.a aVar : this.f20904b) {
                if (aVar instanceof a) {
                    ((a) aVar).i0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (c.a.d.m.e.a aVar : this.f20904b) {
                aVar.e0(bdUniqueId);
            }
        }
    }
}
