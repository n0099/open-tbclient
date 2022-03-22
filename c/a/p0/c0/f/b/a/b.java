package c.a.p0.c0.f.b.a;

import android.widget.BaseAdapter;
import c.a.d.a.f;
import c.a.d.o.e.n;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f12871b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f12872c;

    /* renamed from: d  reason: collision with root package name */
    public a f12873d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.c0.f.h.a.a f12874e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.c0.f.h.a.b f12875f;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12872c = new ArrayList();
        this.a = tbPageContext;
        this.f12871b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.p0.c0.f.h.a.b bVar = new c.a.p0.c0.f.h.a.b((TbPageContext) this.a);
            this.f12875f = bVar;
            bVar.c0(1);
            c.a.p0.c0.f.h.a.a aVar = new c.a.p0.c0.f.h.a.a((TbPageContext) this.a);
            this.f12874e = aVar;
            aVar.c0(1);
            this.f12873d = new a((TbPageContext) this.a, c.a.p0.c0.f.b.b.b.f12882f);
            this.f12872c.add(this.f12875f);
            this.f12872c.add(this.f12874e);
            this.f12872c.add(this.f12873d);
            this.f12871b.a(this.f12872c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f12871b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.f12871b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(c.a.p0.c0.f.h.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f12875f.e0(fVar);
            this.f12874e.e0(fVar);
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f12871b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f12875f.d0(i);
            this.f12874e.d0(i);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.f12873d.e0(iAlaSquareTabController);
        }
    }
}
