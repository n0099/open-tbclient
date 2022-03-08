package c.a.r0.a0.f.b.a;

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
    public BdTypeListView f14185b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f14186c;

    /* renamed from: d  reason: collision with root package name */
    public a f14187d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.a0.f.h.a.a f14188e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a0.f.h.a.b f14189f;

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
        this.f14186c = new ArrayList();
        this.a = tbPageContext;
        this.f14185b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.r0.a0.f.h.a.b bVar = new c.a.r0.a0.f.h.a.b((TbPageContext) this.a);
            this.f14189f = bVar;
            bVar.c0(1);
            c.a.r0.a0.f.h.a.a aVar = new c.a.r0.a0.f.h.a.a((TbPageContext) this.a);
            this.f14188e = aVar;
            aVar.c0(1);
            this.f14187d = new a((TbPageContext) this.a, c.a.r0.a0.f.b.b.b.f14196j);
            this.f14186c.add(this.f14189f);
            this.f14186c.add(this.f14188e);
            this.f14186c.add(this.f14187d);
            this.f14185b.addAdapters(this.f14186c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f14185b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.f14185b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(c.a.r0.a0.f.h.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f14189f.e0(fVar);
            this.f14188e.e0(fVar);
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f14185b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f14189f.d0(i2);
            this.f14188e.d0(i2);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.f14187d.e0(iAlaSquareTabController);
        }
    }
}
