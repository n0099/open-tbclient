package c.a.p0.v.j.b;

import c.a.e.k.e.n;
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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25294a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25295b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.k.e.a> f25296c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f25297d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.v.j.e.a f25298e;

    /* renamed from: f  reason: collision with root package name */
    public j f25299f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, c.a.p0.v.j.e.a aVar) {
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
        this.f25294a = tbPageContext;
        this.f25295b = bdTypeListView;
        this.f25296c = new ArrayList();
        this.f25297d = new ArrayList();
        this.f25298e = aVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.f25294a);
            g gVar = new g(this.f25294a);
            h hVar = new h(this.f25294a);
            a aVar = new a(this.f25294a);
            f fVar = new f(this.f25294a);
            i iVar = new i(this.f25294a);
            e eVar = new e(this.f25294a);
            b bVar = new b(this.f25294a);
            this.f25299f = new j(this.f25294a);
            l lVar = new l(this.f25294a, this.f25298e);
            k kVar = new k(this.f25294a);
            this.f25296c.add(cVar);
            this.f25296c.add(this.f25299f);
            this.f25296c.add(gVar);
            this.f25296c.add(hVar);
            this.f25296c.add(aVar);
            this.f25296c.add(fVar);
            this.f25296c.add(iVar);
            this.f25296c.add(eVar);
            this.f25296c.add(bVar);
            this.f25296c.add(lVar);
            this.f25296c.add(kVar);
            this.f25295b.addAdapters(this.f25296c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f25295b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f25297d.clear();
        this.f25297d.addAll(list);
        this.f25295b.setData(this.f25297d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f25299f) == null) {
            return;
        }
        jVar.s0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f25299f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f25299f) == null) {
            return;
        }
        jVar.t0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f25299f) == null) {
            return;
        }
        jVar.u0(z);
    }
}
