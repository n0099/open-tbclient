package c.a.p0.c0.g.a;

import c.a.d.o.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f13166b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f13167c;

    /* renamed from: d  reason: collision with root package name */
    public f f13168d;

    /* renamed from: e  reason: collision with root package name */
    public c f13169e;

    /* renamed from: f  reason: collision with root package name */
    public a f13170f;

    /* renamed from: g  reason: collision with root package name */
    public b f13171g;

    public g(c.a.d.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13167c = new ArrayList();
        this.a = fVar;
        this.f13166b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.a, c.a.p0.c0.j.b.a.f13234c);
                this.f13169e = cVar;
                this.f13167c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.a, c.a.p0.c0.j.b.a.f13234c);
                this.f13168d = fVar;
                this.f13167c.add(fVar);
            }
            this.f13170f = new a((TbPageContext) this.a, c.a.p0.c0.g.b.a.a);
            this.f13171g = new b((TbPageContext) this.a, c.a.p0.c0.g.b.b.a);
            this.f13167c.add(this.f13170f);
            this.f13167c.add(this.f13171g);
            this.f13166b.a(this.f13167c);
        }
    }

    public void b(c.a.p0.c0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            f fVar = this.f13168d;
            if (fVar != null) {
                fVar.b0(eVar);
            }
            c cVar = this.f13169e;
            if (cVar != null) {
                cVar.b0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f13166b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
