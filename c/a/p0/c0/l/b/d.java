package c.a.p0.c0.l.b;

import c.a.d.o.e.n;
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
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f13269b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f13270c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f13271d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.c0.l.e.a f13272e;

    /* renamed from: f  reason: collision with root package name */
    public j f13273f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, c.a.p0.c0.l.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f13269b = bdTypeListView;
        this.f13270c = new ArrayList();
        this.f13271d = new ArrayList();
        this.f13272e = aVar;
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
            this.f13273f = new j(this.a);
            l lVar = new l(this.a, this.f13272e);
            k kVar = new k(this.a);
            this.f13270c.add(cVar);
            this.f13270c.add(this.f13273f);
            this.f13270c.add(gVar);
            this.f13270c.add(hVar);
            this.f13270c.add(aVar);
            this.f13270c.add(fVar);
            this.f13270c.add(iVar);
            this.f13270c.add(eVar);
            this.f13270c.add(bVar);
            this.f13270c.add(lVar);
            this.f13270c.add(kVar);
            this.f13269b.a(this.f13270c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f13269b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f13271d.clear();
        this.f13271d.addAll(list);
        this.f13269b.setData(this.f13271d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f13273f) == null) {
            return;
        }
        jVar.k0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f13273f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f13273f) == null) {
            return;
        }
        jVar.l0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f13273f) == null) {
            return;
        }
        jVar.m0(z);
    }
}
