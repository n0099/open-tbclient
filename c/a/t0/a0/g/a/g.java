package c.a.t0.a0.g.a;

import c.a.d.n.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f14746b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f14747c;

    /* renamed from: d  reason: collision with root package name */
    public f f14748d;

    /* renamed from: e  reason: collision with root package name */
    public c f14749e;

    /* renamed from: f  reason: collision with root package name */
    public a f14750f;

    /* renamed from: g  reason: collision with root package name */
    public b f14751g;

    public g(c.a.d.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14747c = new ArrayList();
        this.a = fVar;
        this.f14746b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.a, c.a.t0.a0.j.b.a.f14847g);
                this.f14749e = cVar;
                this.f14747c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.a, c.a.t0.a0.j.b.a.f14847g);
                this.f14748d = fVar;
                this.f14747c.add(fVar);
            }
            this.f14750f = new a((TbPageContext) this.a, c.a.t0.a0.g.b.a.f14752e);
            this.f14751g = new b((TbPageContext) this.a, c.a.t0.a0.g.b.b.f14753e);
            this.f14747c.add(this.f14750f);
            this.f14747c.add(this.f14751g);
            this.f14746b.addAdapters(this.f14747c);
        }
    }

    public void b(c.a.t0.a0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            f fVar = this.f14748d;
            if (fVar != null) {
                fVar.b0(eVar);
            }
            c cVar = this.f14749e;
            if (cVar != null) {
                cVar.b0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f14746b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
