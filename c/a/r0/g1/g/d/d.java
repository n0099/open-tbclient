package c.a.r0.g1.g.d;

import c.a.e.l.e.n;
import c.a.e.l.e.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18129a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.l.e.a> f18130b;

    /* renamed from: c  reason: collision with root package name */
    public s f18131c;

    /* renamed from: d  reason: collision with root package name */
    public c f18132d;

    /* renamed from: e  reason: collision with root package name */
    public h f18133e;

    /* renamed from: f  reason: collision with root package name */
    public b f18134f;

    /* renamed from: g  reason: collision with root package name */
    public f f18135g;

    /* renamed from: h  reason: collision with root package name */
    public e f18136h;

    /* renamed from: i  reason: collision with root package name */
    public g f18137i;

    /* renamed from: j  reason: collision with root package name */
    public i f18138j;

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
        this.f18129a = tbPageContext;
        this.f18131c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18130b = new ArrayList();
            c cVar = new c(this.f18129a);
            this.f18132d = cVar;
            cVar.k0(this.f18131c);
            this.f18130b.add(this.f18132d);
            h hVar = new h(this.f18129a);
            this.f18133e = hVar;
            hVar.k0(this.f18131c);
            this.f18130b.add(this.f18133e);
            b bVar = new b(this.f18129a);
            this.f18134f = bVar;
            bVar.k0(this.f18131c);
            this.f18130b.add(this.f18134f);
            f fVar = new f(this.f18129a);
            this.f18135g = fVar;
            fVar.k0(this.f18131c);
            this.f18130b.add(this.f18135g);
            e eVar = new e(this.f18129a);
            this.f18136h = eVar;
            eVar.k0(this.f18131c);
            this.f18130b.add(this.f18136h);
            g gVar = new g(this.f18129a);
            this.f18137i = gVar;
            gVar.k0(this.f18131c);
            this.f18130b.add(this.f18137i);
            i iVar = new i(this.f18129a);
            this.f18138j = iVar;
            iVar.k0(this.f18131c);
            this.f18130b.add(this.f18138j);
            this.f18131c.addAdapters(this.f18130b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f18131c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f18131c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(c.a.q0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (c.a.e.l.e.a aVar : this.f18130b) {
                if (aVar instanceof a) {
                    ((a) aVar).j0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (c.a.e.l.e.a aVar : this.f18130b) {
                aVar.f0(bdUniqueId);
            }
        }
    }
}
