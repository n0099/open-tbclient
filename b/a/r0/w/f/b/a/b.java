package b.a.r0.w.f.b.a;

import android.widget.BaseAdapter;
import b.a.e.a.f;
import b.a.e.m.e.n;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f26038a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f26039b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.e.m.e.a> f26040c;

    /* renamed from: d  reason: collision with root package name */
    public a f26041d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.w.f.h.a.a f26042e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.w.f.h.a.b f26043f;

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
        this.f26040c = new ArrayList();
        this.f26038a = tbPageContext;
        this.f26039b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.r0.w.f.h.a.b bVar = new b.a.r0.w.f.h.a.b((TbPageContext) this.f26038a);
            this.f26043f = bVar;
            bVar.j0(1);
            b.a.r0.w.f.h.a.a aVar = new b.a.r0.w.f.h.a.a((TbPageContext) this.f26038a);
            this.f26042e = aVar;
            aVar.j0(1);
            this.f26041d = new a((TbPageContext) this.f26038a, b.a.r0.w.f.b.b.b.j);
            this.f26040c.add(this.f26043f);
            this.f26040c.add(this.f26042e);
            this.f26040c.add(this.f26041d);
            this.f26039b.addAdapters(this.f26040c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f26039b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.f26039b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(b.a.r0.w.f.h.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f26043f.l0(fVar);
            this.f26042e.l0(fVar);
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f26039b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f26043f.k0(i2);
            this.f26042e.k0(i2);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.f26041d.l0(iAlaSquareTabController);
        }
    }
}
