package b.a.r0.w.l.b;

import b.a.e.m.e.n;
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

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26655a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26656b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.m.e.a> f26657c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f26658d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.w.l.e.a f26659e;

    /* renamed from: f  reason: collision with root package name */
    public j f26660f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, b.a.r0.w.l.e.a aVar) {
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
        this.f26655a = tbPageContext;
        this.f26656b = bdTypeListView;
        this.f26657c = new ArrayList();
        this.f26658d = new ArrayList();
        this.f26659e = aVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.f26655a);
            g gVar = new g(this.f26655a);
            h hVar = new h(this.f26655a);
            a aVar = new a(this.f26655a);
            f fVar = new f(this.f26655a);
            i iVar = new i(this.f26655a);
            e eVar = new e(this.f26655a);
            b bVar = new b(this.f26655a);
            this.f26660f = new j(this.f26655a);
            l lVar = new l(this.f26655a, this.f26659e);
            k kVar = new k(this.f26655a);
            this.f26657c.add(cVar);
            this.f26657c.add(this.f26660f);
            this.f26657c.add(gVar);
            this.f26657c.add(hVar);
            this.f26657c.add(aVar);
            this.f26657c.add(fVar);
            this.f26657c.add(iVar);
            this.f26657c.add(eVar);
            this.f26657c.add(bVar);
            this.f26657c.add(lVar);
            this.f26657c.add(kVar);
            this.f26656b.addAdapters(this.f26657c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f26656b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f26658d.clear();
        this.f26658d.addAll(list);
        this.f26656b.setData(this.f26658d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f26660f) == null) {
            return;
        }
        jVar.r0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f26660f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f26660f) == null) {
            return;
        }
        jVar.s0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f26660f) == null) {
            return;
        }
        jVar.t0(z);
    }
}
