package c.a.r0.a0.g.a;

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
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.d.m.e.a> f14272b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f14273c;

    /* renamed from: d  reason: collision with root package name */
    public e f14274d;

    /* renamed from: e  reason: collision with root package name */
    public h f14275e;

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
        this.f14272b = new ArrayList();
        this.a = fVar;
        this.f14273c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14274d = new e((TbPageContext) this.a, c.a.r0.a0.g.b.c.f14284f);
            this.f14275e = new h((TbPageContext) this.a, c.a.r0.a0.g.b.c.f14285g);
            this.f14272b.add(this.f14274d);
            this.f14272b.add(this.f14275e);
            this.f14273c.addAdapters(this.f14272b);
        }
    }

    public void b(c.a.r0.a0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            e eVar2 = this.f14274d;
            if (eVar2 != null) {
                eVar2.i0(eVar);
            }
            h hVar = this.f14275e;
            if (hVar != null) {
                hVar.i0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f14273c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
