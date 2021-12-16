package c.a.s0.a0.g.a;

import c.a.d.m.e.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.d.m.e.a> f14612b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f14613c;

    /* renamed from: d  reason: collision with root package name */
    public e f14614d;

    /* renamed from: e  reason: collision with root package name */
    public h f14615e;

    public d(c.a.d.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeMultiColumnListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14612b = new ArrayList();
        this.a = fVar;
        this.f14613c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14614d = new e((TbPageContext) this.a, c.a.s0.a0.g.b.c.f14624f);
            this.f14615e = new h((TbPageContext) this.a, c.a.s0.a0.g.b.c.f14625g);
            this.f14612b.add(this.f14614d);
            this.f14612b.add(this.f14615e);
            this.f14613c.addAdapters(this.f14612b);
        }
    }

    public void b(c.a.s0.a0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            e eVar2 = this.f14614d;
            if (eVar2 != null) {
                eVar2.i0(eVar);
            }
            h hVar = this.f14615e;
            if (hVar != null) {
                hVar.i0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f14613c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
