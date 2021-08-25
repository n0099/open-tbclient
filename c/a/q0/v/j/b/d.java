package c.a.q0.v.j.b;

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
    public TbPageContext f25627a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25628b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f25629c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f25630d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.v.j.e.a f25631e;

    /* renamed from: f  reason: collision with root package name */
    public j f25632f;

    public d(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, c.a.q0.v.j.e.a aVar) {
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
        this.f25627a = tbPageContext;
        this.f25628b = bdTypeListView;
        this.f25629c = new ArrayList();
        this.f25630d = new ArrayList();
        this.f25631e = aVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.f25627a);
            g gVar = new g(this.f25627a);
            h hVar = new h(this.f25627a);
            a aVar = new a(this.f25627a);
            f fVar = new f(this.f25627a);
            i iVar = new i(this.f25627a);
            e eVar = new e(this.f25627a);
            b bVar = new b(this.f25627a);
            this.f25632f = new j(this.f25627a);
            l lVar = new l(this.f25627a, this.f25631e);
            k kVar = new k(this.f25627a);
            this.f25629c.add(cVar);
            this.f25629c.add(this.f25632f);
            this.f25629c.add(gVar);
            this.f25629c.add(hVar);
            this.f25629c.add(aVar);
            this.f25629c.add(fVar);
            this.f25629c.add(iVar);
            this.f25629c.add(eVar);
            this.f25629c.add(bVar);
            this.f25629c.add(lVar);
            this.f25629c.add(kVar);
            this.f25628b.addAdapters(this.f25629c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f25628b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f25630d.clear();
        this.f25630d.addAll(list);
        this.f25628b.setData(this.f25630d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f25632f) == null) {
            return;
        }
        jVar.s0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f25632f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f25632f) == null) {
            return;
        }
        jVar.t0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f25632f) == null) {
            return;
        }
        jVar.u0(z);
    }
}
