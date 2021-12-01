package c.a.r0.a0.g.a;

import c.a.d.m.e.n;
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
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f14276b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.m.e.a> f14277c;

    /* renamed from: d  reason: collision with root package name */
    public f f14278d;

    /* renamed from: e  reason: collision with root package name */
    public c f14279e;

    /* renamed from: f  reason: collision with root package name */
    public a f14280f;

    /* renamed from: g  reason: collision with root package name */
    public b f14281g;

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
        this.f14277c = new ArrayList();
        this.a = fVar;
        this.f14276b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.a, c.a.r0.a0.j.b.a.f14385g);
                this.f14279e = cVar;
                this.f14277c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.a, c.a.r0.a0.j.b.a.f14385g);
                this.f14278d = fVar;
                this.f14277c.add(fVar);
            }
            this.f14280f = new a((TbPageContext) this.a, c.a.r0.a0.g.b.a.f14282e);
            this.f14281g = new b((TbPageContext) this.a, c.a.r0.a0.g.b.b.f14283e);
            this.f14277c.add(this.f14280f);
            this.f14277c.add(this.f14281g);
            this.f14276b.addAdapters(this.f14277c);
        }
    }

    public void b(c.a.r0.a0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            f fVar = this.f14278d;
            if (fVar != null) {
                fVar.i0(eVar);
            }
            c cVar = this.f14279e;
            if (cVar != null) {
                cVar.i0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f14276b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
