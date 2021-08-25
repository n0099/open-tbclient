package c.a.q0.v0.v1;

import c.a.e.a.f;
import c.a.e.l.e.n;
import c.a.q0.v0.v1.a;
import c.a.q0.v0.v1.d.d;
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
    public f f27240a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f27241b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f27242c;

    /* renamed from: d  reason: collision with root package name */
    public a f27243d;

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
        this.f27242c = new ArrayList();
        this.f27240a = fVar;
        this.f27241b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = new a((TbPageContext) this.f27240a, d.l);
            this.f27243d = aVar;
            this.f27242c.add(aVar);
            this.f27241b.addAdapters(this.f27242c);
        }
    }

    public void b(a.InterfaceC1275a interfaceC1275a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1275a) == null) {
            this.f27243d.j0(interfaceC1275a);
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f27241b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
