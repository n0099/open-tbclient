package c.a.r0.v.g.a;

import c.a.e.l.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f f25961a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25962b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f25963c;

    /* renamed from: d  reason: collision with root package name */
    public f f25964d;

    /* renamed from: e  reason: collision with root package name */
    public c f25965e;

    /* renamed from: f  reason: collision with root package name */
    public a f25966f;

    /* renamed from: g  reason: collision with root package name */
    public b f25967g;

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
        this.f25963c = new ArrayList();
        this.f25961a = fVar;
        this.f25962b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.f25961a, c.a.r0.v.j.b.a.f26074g);
                this.f25965e = cVar;
                this.f25963c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.f25961a, c.a.r0.v.j.b.a.f26074g);
                this.f25964d = fVar;
                this.f25963c.add(fVar);
            }
            this.f25966f = new a((TbPageContext) this.f25961a, c.a.r0.v.g.b.a.f25968e);
            this.f25967g = new b((TbPageContext) this.f25961a, c.a.r0.v.g.b.b.f25969e);
            this.f25963c.add(this.f25966f);
            this.f25963c.add(this.f25967g);
            this.f25962b.addAdapters(this.f25963c);
        }
    }

    public void b(c.a.r0.v.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            f fVar = this.f25964d;
            if (fVar != null) {
                fVar.j0(eVar);
            }
            c cVar = this.f25965e;
            if (cVar != null) {
                cVar.j0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f25962b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
