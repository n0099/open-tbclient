package c.a.r0.w.g.a;

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
    public c.a.e.a.f f26136a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26137b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f26138c;

    /* renamed from: d  reason: collision with root package name */
    public f f26139d;

    /* renamed from: e  reason: collision with root package name */
    public c f26140e;

    /* renamed from: f  reason: collision with root package name */
    public a f26141f;

    /* renamed from: g  reason: collision with root package name */
    public b f26142g;

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
        this.f26138c = new ArrayList();
        this.f26136a = fVar;
        this.f26137b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.f26136a, c.a.r0.w.j.b.a.f26249g);
                this.f26140e = cVar;
                this.f26138c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.f26136a, c.a.r0.w.j.b.a.f26249g);
                this.f26139d = fVar;
                this.f26138c.add(fVar);
            }
            this.f26141f = new a((TbPageContext) this.f26136a, c.a.r0.w.g.b.a.f26143e);
            this.f26142g = new b((TbPageContext) this.f26136a, c.a.r0.w.g.b.b.f26144e);
            this.f26138c.add(this.f26141f);
            this.f26138c.add(this.f26142g);
            this.f26137b.addAdapters(this.f26138c);
        }
    }

    public void b(c.a.r0.w.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            f fVar = this.f26139d;
            if (fVar != null) {
                fVar.j0(eVar);
            }
            c cVar = this.f26140e;
            if (cVar != null) {
                cVar.j0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f26137b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
