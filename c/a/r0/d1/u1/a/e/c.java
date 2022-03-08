package c.a.r0.d1.u1.a.e;

import c.a.d.o.e.n;
import c.a.d.o.e.v;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f16525b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f16526c;

    /* renamed from: d  reason: collision with root package name */
    public b f16527d;

    public c(c.a.d.a.f fVar, BdTypeListView bdTypeListView) {
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
        this.f16526c = new ArrayList();
        this.a = fVar;
        this.f16525b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b((TbPageContext) this.a, c.a.r0.d1.u1.a.a.b.f16493f);
            this.f16527d = bVar;
            this.f16526c.add(bVar);
            this.f16525b.addAdapters(this.f16526c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f16525b.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f16525b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vVar) == null) {
            for (c.a.d.o.e.a aVar : this.f16526c) {
                if (aVar != null) {
                    aVar.V(vVar);
                }
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f16525b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
