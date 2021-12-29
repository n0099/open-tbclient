package c.a.t0.d1.h2;

import c.a.d.a.f;
import c.a.d.n.e.n;
import c.a.t0.d1.h2.a;
import c.a.t0.d1.h2.d.d;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f16431b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f16432c;

    /* renamed from: d  reason: collision with root package name */
    public a f16433d;

    public b(f fVar, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16432c = new ArrayList();
        this.a = fVar;
        this.f16431b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = new a((TbPageContext) this.a, d.l);
            this.f16433d = aVar;
            this.f16432c.add(aVar);
            this.f16431b.addAdapters(this.f16432c);
        }
    }

    public void b(a.InterfaceC1012a interfaceC1012a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1012a) == null) {
            this.f16433d.b0(interfaceC1012a);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f16431b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
