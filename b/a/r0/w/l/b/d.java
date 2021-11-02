package b.a.r0.w.l.b;

import b.a.e.l.e.n;
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
    public TbPageContext f25138a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25139b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.l.e.a> f25140c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f25141d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.w.l.e.a f25142e;

    /* renamed from: f  reason: collision with root package name */
    public j f25143f;

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
        this.f25138a = tbPageContext;
        this.f25139b = bdTypeListView;
        this.f25140c = new ArrayList();
        this.f25141d = new ArrayList();
        this.f25142e = aVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.f25138a);
            g gVar = new g(this.f25138a);
            h hVar = new h(this.f25138a);
            a aVar = new a(this.f25138a);
            f fVar = new f(this.f25138a);
            i iVar = new i(this.f25138a);
            e eVar = new e(this.f25138a);
            b bVar = new b(this.f25138a);
            this.f25143f = new j(this.f25138a);
            l lVar = new l(this.f25138a, this.f25142e);
            k kVar = new k(this.f25138a);
            this.f25140c.add(cVar);
            this.f25140c.add(this.f25143f);
            this.f25140c.add(gVar);
            this.f25140c.add(hVar);
            this.f25140c.add(aVar);
            this.f25140c.add(fVar);
            this.f25140c.add(iVar);
            this.f25140c.add(eVar);
            this.f25140c.add(bVar);
            this.f25140c.add(lVar);
            this.f25140c.add(kVar);
            this.f25139b.addAdapters(this.f25140c);
        }
    }

    public void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f25139b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.f25141d.clear();
        this.f25141d.addAll(list);
        this.f25139b.setData(this.f25141d);
    }

    public void c(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f25143f) == null) {
            return;
        }
        jVar.r0(str);
    }

    public void d(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (jVar = this.f25143f) == null) {
            return;
        }
        jVar.a(str);
    }

    public void e(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (jVar = this.f25143f) == null) {
            return;
        }
        jVar.s0(str);
    }

    public void f(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (jVar = this.f25143f) == null) {
            return;
        }
        jVar.t0(z);
    }
}
