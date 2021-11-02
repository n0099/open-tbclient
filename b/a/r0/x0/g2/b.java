package b.a.r0.x0.g2;

import b.a.e.a.f;
import b.a.e.l.e.n;
import b.a.r0.x0.g2.a;
import b.a.r0.x0.g2.d.d;
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
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f25752a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25753b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f25754c;

    /* renamed from: d  reason: collision with root package name */
    public a f25755d;

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
        this.f25754c = new ArrayList();
        this.f25752a = fVar;
        this.f25753b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = new a((TbPageContext) this.f25752a, d.l);
            this.f25755d = aVar;
            this.f25754c.add(aVar);
            this.f25753b.addAdapters(this.f25754c);
        }
    }

    public void b(a.InterfaceC1269a interfaceC1269a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1269a) == null) {
            this.f25755d.i0(interfaceC1269a);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f25753b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
