package c.a.p0.v0.v1;

import c.a.e.a.f;
import c.a.e.k.e.n;
import c.a.p0.v0.v1.a;
import c.a.p0.v0.v1.d.d;
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
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f26901a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26902b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.k.e.a> f26903c;

    /* renamed from: d  reason: collision with root package name */
    public a f26904d;

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
        this.f26903c = new ArrayList();
        this.f26901a = fVar;
        this.f26902b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = new a((TbPageContext) this.f26901a, d.l);
            this.f26904d = aVar;
            this.f26903c.add(aVar);
            this.f26902b.addAdapters(this.f26903c);
        }
    }

    public void b(a.InterfaceC1265a interfaceC1265a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1265a) == null) {
            this.f26904d.j0(interfaceC1265a);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f26902b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
