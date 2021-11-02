package b.a.r0.w.f.b.a;

import android.widget.BaseAdapter;
import b.a.e.a.f;
import b.a.e.l.e.n;
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
    public f f24521a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24522b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f24523c;

    /* renamed from: d  reason: collision with root package name */
    public a f24524d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.w.f.h.a.a f24525e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.w.f.h.a.b f24526f;

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
        this.f24523c = new ArrayList();
        this.f24521a = tbPageContext;
        this.f24522b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.r0.w.f.h.a.b bVar = new b.a.r0.w.f.h.a.b((TbPageContext) this.f24521a);
            this.f24526f = bVar;
            bVar.j0(1);
            b.a.r0.w.f.h.a.a aVar = new b.a.r0.w.f.h.a.a((TbPageContext) this.f24521a);
            this.f24525e = aVar;
            aVar.j0(1);
            this.f24524d = new a((TbPageContext) this.f24521a, b.a.r0.w.f.b.b.b.j);
            this.f24523c.add(this.f24526f);
            this.f24523c.add(this.f24525e);
            this.f24523c.add(this.f24524d);
            this.f24522b.addAdapters(this.f24523c);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f24522b) != null && (bdTypeListView.getAdapter2() instanceof BaseAdapter)) {
            this.f24522b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(b.a.r0.w.f.h.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f24526f.l0(fVar);
            this.f24525e.l0(fVar);
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f24522b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f24526f.k0(i2);
            this.f24525e.k0(i2);
        }
    }

    public void f(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iAlaSquareTabController) == null) {
            this.f24524d.l0(iAlaSquareTabController);
        }
    }
}
