package c.a.r0.v.j.b;

import c.a.e.l.e.n;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26105a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26106b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26107c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f26108d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.v.j.e.a f26109e;

    /* renamed from: f  reason: collision with root package name */
    public j f26110f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, c.a.r0.v.j.e.a aVar) {
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
        this.f26105a = tbPageContext;
        this.f26106b = bdTypeListView;
        this.f26107c = new ArrayList();
        this.f26108d = new ArrayList();
        this.f26109e = aVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.f26105a);
            g gVar = new g(this.f26105a);
            h hVar = new h(this.f26105a);
            a aVar = new a(this.f26105a);
            f fVar = new f(this.f26105a);
            i iVar = new i(this.f26105a);
            e eVar = new e(this.f26105a);
            b bVar = new b(this.f26105a);
            this.f26110f = new j(this.f26105a);
            l lVar = new l(this.f26105a, this.f26109e);
            k kVar = new k(this.f26105a);
            this.f26107c.add(cVar);
            this.f26107c.add(this.f26110f);
            this.f26107c.add(gVar);
            this.f26107c.add(hVar);
            this.f26107c.add(aVar);
            this.f26107c.add(fVar);
            this.f26107c.add(iVar);
            this.f26107c.add(eVar);
            this.f26107c.add(bVar);
            this.f26107c.add(lVar);
            this.f26107c.add(kVar);
            this.f26106b.addAdapters(this.f26107c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f26106b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f26108d.clear();
        this.f26108d.addAll(list);
        this.f26106b.setData(this.f26108d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f26110f) == null) {
            return;
        }
        jVar.s0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f26110f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f26110f) == null) {
            return;
        }
        jVar.t0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f26110f) == null) {
            return;
        }
        jVar.u0(z);
    }
}
