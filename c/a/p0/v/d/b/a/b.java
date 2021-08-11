package c.a.p0.v.d.b.a;

import android.widget.BaseAdapter;
import c.a.e.a.f;
import c.a.e.k.e.n;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f24663a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24664b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.k.e.a> f24665c;

    /* renamed from: d  reason: collision with root package name */
    public a f24666d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.v.d.h.a.a f24667e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.v.d.h.a.b f24668f;

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
        this.f24665c = new ArrayList();
        this.f24663a = tbPageContext;
        this.f24664b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.p0.v.d.h.a.b bVar = new c.a.p0.v.d.h.a.b((TbPageContext) this.f24663a);
            this.f24668f = bVar;
            bVar.k0(1);
            c.a.p0.v.d.h.a.a aVar = new c.a.p0.v.d.h.a.a((TbPageContext) this.f24663a);
            this.f24667e = aVar;
            aVar.k0(1);
            this.f24666d = new a((TbPageContext) this.f24663a, c.a.p0.v.d.b.b.b.f24676j);
            this.f24665c.add(this.f24668f);
            this.f24665c.add(this.f24667e);
            this.f24665c.add(this.f24666d);
            this.f24664b.addAdapters(this.f24665c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f24664b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.f24664b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(c.a.p0.v.d.h.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f24668f.m0(fVar);
            this.f24667e.m0(fVar);
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f24664b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f24668f.l0(i2);
            this.f24667e.l0(i2);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.f24666d.m0(iAlaSquareTabController);
        }
    }
}
