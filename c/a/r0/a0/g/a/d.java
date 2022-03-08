package c.a.r0.a0.g.a;

import c.a.d.o.e.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f14571b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f14572c;

    /* renamed from: d  reason: collision with root package name */
    public e f14573d;

    /* renamed from: e  reason: collision with root package name */
    public h f14574e;

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
        this.f14571b = new ArrayList();
        this.a = fVar;
        this.f14572c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14573d = new e((TbPageContext) this.a, c.a.r0.a0.g.b.c.f14583f);
            this.f14574e = new h((TbPageContext) this.a, c.a.r0.a0.g.b.c.f14584g);
            this.f14571b.add(this.f14573d);
            this.f14571b.add(this.f14574e);
            this.f14572c.addAdapters(this.f14571b);
        }
    }

    public void b(c.a.r0.a0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            e eVar2 = this.f14573d;
            if (eVar2 != null) {
                eVar2.b0(eVar);
            }
            h hVar = this.f14574e;
            if (hVar != null) {
                hVar.b0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f14572c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
