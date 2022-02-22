package c.a.u0.a0.l.b;

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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f15307b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f15308c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f15309d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.u0.a0.l.e.a f15310e;

    /* renamed from: f  reason: collision with root package name */
    public j f15311f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, c.a.u0.a0.l.e.a aVar) {
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
        this.f15307b = bdTypeListView;
        this.f15308c = new ArrayList();
        this.f15309d = new ArrayList();
        this.f15310e = aVar;
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
            this.f15311f = new j(this.a);
            l lVar = new l(this.a, this.f15310e);
            k kVar = new k(this.a);
            this.f15308c.add(cVar);
            this.f15308c.add(this.f15311f);
            this.f15308c.add(gVar);
            this.f15308c.add(hVar);
            this.f15308c.add(aVar);
            this.f15308c.add(fVar);
            this.f15308c.add(iVar);
            this.f15308c.add(eVar);
            this.f15308c.add(bVar);
            this.f15308c.add(lVar);
            this.f15308c.add(kVar);
            this.f15307b.addAdapters(this.f15308c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f15307b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f15309d.clear();
        this.f15309d.addAll(list);
        this.f15307b.setData(this.f15309d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f15311f) == null) {
            return;
        }
        jVar.k0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f15311f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f15311f) == null) {
            return;
        }
        jVar.l0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f15311f) == null) {
            return;
        }
        jVar.m0(z);
    }
}
