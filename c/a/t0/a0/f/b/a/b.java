package c.a.t0.a0.f.b.a;

import android.widget.BaseAdapter;
import c.a.d.a.f;
import c.a.d.n.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
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
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f14706b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f14707c;

    /* renamed from: d  reason: collision with root package name */
    public a f14708d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.a0.f.h.a.a f14709e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.a0.f.h.a.b f14710f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14707c = new ArrayList();
        this.a = tbPageContext;
        this.f14706b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.t0.a0.f.h.a.b bVar = new c.a.t0.a0.f.h.a.b((TbPageContext) this.a);
            this.f14710f = bVar;
            bVar.c0(1);
            c.a.t0.a0.f.h.a.a aVar = new c.a.t0.a0.f.h.a.a((TbPageContext) this.a);
            this.f14709e = aVar;
            aVar.c0(1);
            this.f14708d = new a((TbPageContext) this.a, c.a.t0.a0.f.b.b.b.f14717j);
            this.f14707c.add(this.f14710f);
            this.f14707c.add(this.f14709e);
            this.f14707c.add(this.f14708d);
            this.f14706b.addAdapters(this.f14707c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f14706b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.f14706b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(c.a.t0.a0.f.h.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f14710f.e0(fVar);
            this.f14709e.e0(fVar);
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f14706b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f14710f.d0(i2);
            this.f14709e.d0(i2);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.f14708d.e0(iAlaSquareTabController);
        }
    }
}
