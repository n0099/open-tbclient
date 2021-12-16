package c.a.s0.a0.g.a;

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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f14616b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.m.e.a> f14617c;

    /* renamed from: d  reason: collision with root package name */
    public f f14618d;

    /* renamed from: e  reason: collision with root package name */
    public c f14619e;

    /* renamed from: f  reason: collision with root package name */
    public a f14620f;

    /* renamed from: g  reason: collision with root package name */
    public b f14621g;

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
        this.f14617c = new ArrayList();
        this.a = fVar;
        this.f14616b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.a, c.a.s0.a0.j.b.a.f14725g);
                this.f14619e = cVar;
                this.f14617c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.a, c.a.s0.a0.j.b.a.f14725g);
                this.f14618d = fVar;
                this.f14617c.add(fVar);
            }
            this.f14620f = new a((TbPageContext) this.a, c.a.s0.a0.g.b.a.f14622e);
            this.f14621g = new b((TbPageContext) this.a, c.a.s0.a0.g.b.b.f14623e);
            this.f14617c.add(this.f14620f);
            this.f14617c.add(this.f14621g);
            this.f14616b.addAdapters(this.f14617c);
        }
    }

    public void b(c.a.s0.a0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            f fVar = this.f14618d;
            if (fVar != null) {
                fVar.i0(eVar);
            }
            c cVar = this.f14619e;
            if (cVar != null) {
                cVar.i0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f14616b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
