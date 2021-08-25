package c.a.q0.v.d.b.a;

import android.widget.BaseAdapter;
import c.a.e.a.f;
import c.a.e.l.e.n;
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
    public f f24996a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24997b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f24998c;

    /* renamed from: d  reason: collision with root package name */
    public a f24999d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.v.d.h.a.a f25000e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.v.d.h.a.b f25001f;

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
        this.f24998c = new ArrayList();
        this.f24996a = tbPageContext;
        this.f24997b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.q0.v.d.h.a.b bVar = new c.a.q0.v.d.h.a.b((TbPageContext) this.f24996a);
            this.f25001f = bVar;
            bVar.k0(1);
            c.a.q0.v.d.h.a.a aVar = new c.a.q0.v.d.h.a.a((TbPageContext) this.f24996a);
            this.f25000e = aVar;
            aVar.k0(1);
            this.f24999d = new a((TbPageContext) this.f24996a, c.a.q0.v.d.b.b.b.f25009j);
            this.f24998c.add(this.f25001f);
            this.f24998c.add(this.f25000e);
            this.f24998c.add(this.f24999d);
            this.f24997b.addAdapters(this.f24998c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f24997b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.f24997b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(c.a.q0.v.d.h.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f25001f.m0(fVar);
            this.f25000e.m0(fVar);
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f24997b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f25001f.l0(i2);
            this.f25000e.l0(i2);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.f24999d.m0(iAlaSquareTabController);
        }
    }
}
