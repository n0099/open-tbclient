package c.a.p0.v.e.a;

import c.a.e.k.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f f25127a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25128b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.k.e.a> f25129c;

    /* renamed from: d  reason: collision with root package name */
    public f f25130d;

    /* renamed from: e  reason: collision with root package name */
    public c f25131e;

    /* renamed from: f  reason: collision with root package name */
    public a f25132f;

    /* renamed from: g  reason: collision with root package name */
    public b f25133g;

    public g(c.a.e.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
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
        this.f25129c = new ArrayList();
        this.f25127a = fVar;
        this.f25128b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.f25127a, c.a.p0.v.h.b.a.f25240g);
                this.f25131e = cVar;
                this.f25129c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.f25127a, c.a.p0.v.h.b.a.f25240g);
                this.f25130d = fVar;
                this.f25129c.add(fVar);
            }
            this.f25132f = new a((TbPageContext) this.f25127a, c.a.p0.v.e.b.a.f25134e);
            this.f25133g = new b((TbPageContext) this.f25127a, c.a.p0.v.e.b.b.f25135e);
            this.f25129c.add(this.f25132f);
            this.f25129c.add(this.f25133g);
            this.f25128b.addAdapters(this.f25129c);
        }
    }

    public void b(c.a.p0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            f fVar = this.f25130d;
            if (fVar != null) {
                fVar.j0(cVar);
            }
            c cVar2 = this.f25131e;
            if (cVar2 != null) {
                cVar2.j0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f25128b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
