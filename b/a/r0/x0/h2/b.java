package b.a.r0.x0.h2;

import b.a.e.a.f;
import b.a.e.m.e.n;
import b.a.r0.x0.h2.a;
import b.a.r0.x0.h2.d.d;
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
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f27348a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f27349b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.e.m.e.a> f27350c;

    /* renamed from: d  reason: collision with root package name */
    public a f27351d;

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
        this.f27350c = new ArrayList();
        this.f27348a = fVar;
        this.f27349b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = new a((TbPageContext) this.f27348a, d.l);
            this.f27351d = aVar;
            this.f27350c.add(aVar);
            this.f27349b.addAdapters(this.f27350c);
        }
    }

    public void b(a.InterfaceC1342a interfaceC1342a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1342a) == null) {
            this.f27351d.i0(interfaceC1342a);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f27349b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
