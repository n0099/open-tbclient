package b.a.r0.w.g.a;

import b.a.e.m.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.a.f f26498a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26499b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.e.m.e.a> f26500c;

    /* renamed from: d  reason: collision with root package name */
    public f f26501d;

    /* renamed from: e  reason: collision with root package name */
    public c f26502e;

    /* renamed from: f  reason: collision with root package name */
    public a f26503f;

    /* renamed from: g  reason: collision with root package name */
    public b f26504g;

    public g(b.a.e.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
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
        this.f26500c = new ArrayList();
        this.f26498a = fVar;
        this.f26499b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.f26498a, b.a.r0.w.j.b.a.f26603g);
                this.f26502e = cVar;
                this.f26500c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.f26498a, b.a.r0.w.j.b.a.f26603g);
                this.f26501d = fVar;
                this.f26500c.add(fVar);
            }
            this.f26503f = new a((TbPageContext) this.f26498a, b.a.r0.w.g.b.a.f26505e);
            this.f26504g = new b((TbPageContext) this.f26498a, b.a.r0.w.g.b.b.f26506e);
            this.f26500c.add(this.f26503f);
            this.f26500c.add(this.f26504g);
            this.f26499b.addAdapters(this.f26500c);
        }
    }

    public void b(b.a.r0.w.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            f fVar = this.f26501d;
            if (fVar != null) {
                fVar.i0(eVar);
            }
            c cVar = this.f26502e;
            if (cVar != null) {
                cVar.i0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f26499b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
