package c.a.t0.d1.d2.a.e;

import c.a.d.n.e.n;
import c.a.d.n.e.w;
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
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f16341b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f16342c;

    /* renamed from: d  reason: collision with root package name */
    public b f16343d;

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
        this.f16342c = new ArrayList();
        this.a = fVar;
        this.f16341b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b((TbPageContext) this.a, c.a.t0.d1.d2.a.a.b.f16308f);
            this.f16343d = bVar;
            this.f16342c.add(bVar);
            this.f16341b.addAdapters(this.f16342c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f16341b.getAdapter2() instanceof c.a.d.n.e.e)) {
            this.f16341b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wVar) == null) {
            for (c.a.d.n.e.a aVar : this.f16342c) {
                if (aVar != null) {
                    aVar.V(wVar);
                }
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f16341b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
