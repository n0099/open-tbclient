package c.a.r0.x0.s1.a.e;

import c.a.e.l.e.n;
import c.a.e.l.e.w;
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
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f f27997a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f27998b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f27999c;

    /* renamed from: d  reason: collision with root package name */
    public b f28000d;

    public c(c.a.e.a.f fVar, BdTypeListView bdTypeListView) {
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
        this.f27999c = new ArrayList();
        this.f27997a = fVar;
        this.f27998b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b((TbPageContext) this.f27997a, c.a.r0.x0.s1.a.a.b.f27957f);
            this.f28000d = bVar;
            this.f27999c.add(bVar);
            this.f27998b.addAdapters(this.f27999c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f27998b.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f27998b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wVar) == null) {
            for (c.a.e.l.e.a aVar : this.f27999c) {
                if (aVar != null) {
                    aVar.d0(wVar);
                }
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f27998b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
