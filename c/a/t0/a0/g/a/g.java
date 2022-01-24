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
    public BdTypeListView f14886b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f14887c;

    /* renamed from: d  reason: collision with root package name */
    public f f14888d;

    /* renamed from: e  reason: collision with root package name */
    public c f14889e;

    /* renamed from: f  reason: collision with root package name */
    public a f14890f;

    /* renamed from: g  reason: collision with root package name */
    public b f14891g;

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
        this.f14887c = new ArrayList();
        this.a = fVar;
        this.f14886b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.a, c.a.t0.a0.j.b.a.f14987g);
                this.f14889e = cVar;
                this.f14887c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.a, c.a.t0.a0.j.b.a.f14987g);
                this.f14888d = fVar;
                this.f14887c.add(fVar);
            }
            this.f14890f = new a((TbPageContext) this.a, c.a.t0.a0.g.b.a.f14892e);
            this.f14891g = new b((TbPageContext) this.a, c.a.t0.a0.g.b.b.f14893e);
            this.f14887c.add(this.f14890f);
            this.f14887c.add(this.f14891g);
            this.f14886b.addAdapters(this.f14887c);
        }
    }

    public void b(c.a.t0.a0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            f fVar = this.f14888d;
            if (fVar != null) {
                fVar.b0(eVar);
            }
            c cVar = this.f14889e;
            if (cVar != null) {
                cVar.b0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f14886b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
