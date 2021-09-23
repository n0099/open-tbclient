package c.a.r0.v.f.b.a;

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
    public f f25497a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25498b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f25499c;

    /* renamed from: d  reason: collision with root package name */
    public a f25500d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.v.f.h.a.a f25501e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.v.f.h.a.b f25502f;

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
        this.f25499c = new ArrayList();
        this.f25497a = tbPageContext;
        this.f25498b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.r0.v.f.h.a.b bVar = new c.a.r0.v.f.h.a.b((TbPageContext) this.f25497a);
            this.f25502f = bVar;
            bVar.k0(1);
            c.a.r0.v.f.h.a.a aVar = new c.a.r0.v.f.h.a.a((TbPageContext) this.f25497a);
            this.f25501e = aVar;
            aVar.k0(1);
            this.f25500d = new a((TbPageContext) this.f25497a, c.a.r0.v.f.b.b.b.f25510j);
            this.f25499c.add(this.f25502f);
            this.f25499c.add(this.f25501e);
            this.f25499c.add(this.f25500d);
            this.f25498b.addAdapters(this.f25499c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f25498b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.f25498b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(c.a.r0.v.f.h.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f25502f.m0(fVar);
            this.f25501e.m0(fVar);
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f25498b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f25502f.l0(i2);
            this.f25501e.l0(i2);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.f25500d.m0(iAlaSquareTabController);
        }
    }
}
