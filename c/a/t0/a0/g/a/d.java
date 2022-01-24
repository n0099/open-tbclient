package c.a.t0.a0.g.a;

import c.a.d.n.e.n;
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
    public final List<c.a.d.n.e.a> f14882b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f14883c;

    /* renamed from: d  reason: collision with root package name */
    public e f14884d;

    /* renamed from: e  reason: collision with root package name */
    public h f14885e;

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
        this.f14882b = new ArrayList();
        this.a = fVar;
        this.f14883c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14884d = new e((TbPageContext) this.a, c.a.t0.a0.g.b.c.f14894f);
            this.f14885e = new h((TbPageContext) this.a, c.a.t0.a0.g.b.c.f14895g);
            this.f14882b.add(this.f14884d);
            this.f14882b.add(this.f14885e);
            this.f14883c.addAdapters(this.f14882b);
        }
    }

    public void b(c.a.t0.a0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            e eVar2 = this.f14884d;
            if (eVar2 != null) {
                eVar2.b0(eVar);
            }
            h hVar = this.f14885e;
            if (hVar != null) {
                hVar.b0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f14883c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
