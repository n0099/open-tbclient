package c.a.r0.a0.l.b;

import c.a.d.m.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f14433b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.m.e.a> f14434c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f14435d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.a0.l.e.a f14436e;

    /* renamed from: f  reason: collision with root package name */
    public j f14437f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, c.a.r0.a0.l.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, aVar};
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
        this.f14433b = bdTypeListView;
        this.f14434c = new ArrayList();
        this.f14435d = new ArrayList();
        this.f14436e = aVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.a);
            g gVar = new g(this.a);
            h hVar = new h(this.a);
            a aVar = new a(this.a);
            f fVar = new f(this.a);
            i iVar = new i(this.a);
            e eVar = new e(this.a);
            b bVar = new b(this.a);
            this.f14437f = new j(this.a);
            l lVar = new l(this.a, this.f14436e);
            k kVar = new k(this.a);
            this.f14434c.add(cVar);
            this.f14434c.add(this.f14437f);
            this.f14434c.add(gVar);
            this.f14434c.add(hVar);
            this.f14434c.add(aVar);
            this.f14434c.add(fVar);
            this.f14434c.add(iVar);
            this.f14434c.add(eVar);
            this.f14434c.add(bVar);
            this.f14434c.add(lVar);
            this.f14434c.add(kVar);
            this.f14433b.addAdapters(this.f14434c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f14433b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f14435d.clear();
        this.f14435d.addAll(list);
        this.f14433b.setData(this.f14435d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f14437f) == null) {
            return;
        }
        jVar.r0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f14437f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f14437f) == null) {
            return;
        }
        jVar.s0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f14437f) == null) {
            return;
        }
        jVar.t0(z);
    }
}
