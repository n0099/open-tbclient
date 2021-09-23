package c.a.r0.v.l.b;

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
    public TbPageContext f26128a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26129b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f26130c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f26131d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.v.l.e.a f26132e;

    /* renamed from: f  reason: collision with root package name */
    public j f26133f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, c.a.r0.v.l.e.a aVar) {
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
        this.f26128a = tbPageContext;
        this.f26129b = bdTypeListView;
        this.f26130c = new ArrayList();
        this.f26131d = new ArrayList();
        this.f26132e = aVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.f26128a);
            g gVar = new g(this.f26128a);
            h hVar = new h(this.f26128a);
            a aVar = new a(this.f26128a);
            f fVar = new f(this.f26128a);
            i iVar = new i(this.f26128a);
            e eVar = new e(this.f26128a);
            b bVar = new b(this.f26128a);
            this.f26133f = new j(this.f26128a);
            l lVar = new l(this.f26128a, this.f26132e);
            k kVar = new k(this.f26128a);
            this.f26130c.add(cVar);
            this.f26130c.add(this.f26133f);
            this.f26130c.add(gVar);
            this.f26130c.add(hVar);
            this.f26130c.add(aVar);
            this.f26130c.add(fVar);
            this.f26130c.add(iVar);
            this.f26130c.add(eVar);
            this.f26130c.add(bVar);
            this.f26130c.add(lVar);
            this.f26130c.add(kVar);
            this.f26129b.addAdapters(this.f26130c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f26129b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f26131d.clear();
        this.f26131d.addAll(list);
        this.f26129b.setData(this.f26131d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f26133f) == null) {
            return;
        }
        jVar.s0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f26133f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f26133f) == null) {
            return;
        }
        jVar.t0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f26133f) == null) {
            return;
        }
        jVar.u0(z);
    }
}
