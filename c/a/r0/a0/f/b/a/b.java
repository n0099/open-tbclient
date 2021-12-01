package c.a.r0.a0.f.b.a;

import android.widget.BaseAdapter;
import c.a.d.a.f;
import c.a.d.m.e.n;
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
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f13866b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.m.e.a> f13867c;

    /* renamed from: d  reason: collision with root package name */
    public a f13868d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.a0.f.h.a.a f13869e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a0.f.h.a.b f13870f;

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
        this.f13867c = new ArrayList();
        this.a = tbPageContext;
        this.f13866b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.r0.a0.f.h.a.b bVar = new c.a.r0.a0.f.h.a.b((TbPageContext) this.a);
            this.f13870f = bVar;
            bVar.j0(1);
            c.a.r0.a0.f.h.a.a aVar = new c.a.r0.a0.f.h.a.a((TbPageContext) this.a);
            this.f13869e = aVar;
            aVar.j0(1);
            this.f13868d = new a((TbPageContext) this.a, c.a.r0.a0.f.b.b.b.f13877j);
            this.f13867c.add(this.f13870f);
            this.f13867c.add(this.f13869e);
            this.f13867c.add(this.f13868d);
            this.f13866b.addAdapters(this.f13867c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f13866b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.f13866b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(c.a.r0.a0.f.h.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f13870f.l0(fVar);
            this.f13869e.l0(fVar);
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f13866b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f13870f.k0(i2);
            this.f13869e.k0(i2);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.f13868d.l0(iAlaSquareTabController);
        }
    }
}
