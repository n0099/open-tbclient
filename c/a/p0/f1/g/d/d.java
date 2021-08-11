package c.a.p0.f1.g.d;

import c.a.e.k.e.n;
import c.a.e.k.e.s;
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
    public TbPageContext f17250a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.k.e.a> f17251b;

    /* renamed from: c  reason: collision with root package name */
    public s f17252c;

    /* renamed from: d  reason: collision with root package name */
    public c f17253d;

    /* renamed from: e  reason: collision with root package name */
    public h f17254e;

    /* renamed from: f  reason: collision with root package name */
    public b f17255f;

    /* renamed from: g  reason: collision with root package name */
    public f f17256g;

    /* renamed from: h  reason: collision with root package name */
    public e f17257h;

    /* renamed from: i  reason: collision with root package name */
    public g f17258i;

    /* renamed from: j  reason: collision with root package name */
    public i f17259j;

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
        this.f17250a = tbPageContext;
        this.f17252c = sVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17251b = new ArrayList();
            c cVar = new c(this.f17250a);
            this.f17253d = cVar;
            cVar.k0(this.f17252c);
            this.f17251b.add(this.f17253d);
            h hVar = new h(this.f17250a);
            this.f17254e = hVar;
            hVar.k0(this.f17252c);
            this.f17251b.add(this.f17254e);
            b bVar = new b(this.f17250a);
            this.f17255f = bVar;
            bVar.k0(this.f17252c);
            this.f17251b.add(this.f17255f);
            f fVar = new f(this.f17250a);
            this.f17256g = fVar;
            fVar.k0(this.f17252c);
            this.f17251b.add(this.f17256g);
            e eVar = new e(this.f17250a);
            this.f17257h = eVar;
            eVar.k0(this.f17252c);
            this.f17251b.add(this.f17257h);
            g gVar = new g(this.f17250a);
            this.f17258i = gVar;
            gVar.k0(this.f17252c);
            this.f17251b.add(this.f17258i);
            i iVar = new i(this.f17250a);
            this.f17259j = iVar;
            iVar.k0(this.f17252c);
            this.f17251b.add(this.f17259j);
            this.f17252c.addAdapters(this.f17251b);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f17252c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (sVar = this.f17252c) == null) {
            return;
        }
        sVar.setData(list);
        b();
    }

    public void d(c.a.o0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            for (c.a.e.k.e.a aVar : this.f17251b) {
                if (aVar instanceof a) {
                    ((a) aVar).j0(fVar);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (c.a.e.k.e.a aVar : this.f17251b) {
                aVar.f0(bdUniqueId);
            }
        }
    }
}
