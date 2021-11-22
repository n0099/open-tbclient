package b.a.r0.m1.b.p;

import b.a.e.m.e.n;
import b.a.e.m.e.w;
import b.a.e.m.e.x;
import b.a.r0.b0.d0;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f22278a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f22279b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.m.e.a> f22280c;

    /* renamed from: d  reason: collision with root package name */
    public b f22281d;

    /* renamed from: e  reason: collision with root package name */
    public b f22282e;

    /* renamed from: f  reason: collision with root package name */
    public b f22283f;

    /* renamed from: g  reason: collision with root package name */
    public b f22284g;

    /* renamed from: h  reason: collision with root package name */
    public b f22285h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22280c = new LinkedList();
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f22278a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bdTypeRecyclerView = this.f22278a) == null) {
            return;
        }
        bdTypeRecyclerView.removeItem(i2);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f22281d = new b(tbPageContext, a.x);
            this.f22282e = new b(tbPageContext, a.y);
            this.f22283f = new b(tbPageContext, a.B);
            this.f22284g = new b(tbPageContext, a.A);
            this.f22285h = new b(tbPageContext, a.z);
            this.f22280c.add(this.f22281d);
            this.f22280c.add(this.f22282e);
            this.f22280c.add(this.f22283f);
            this.f22280c.add(this.f22284g);
            this.f22280c.add(this.f22285h);
            this.f22278a.addAdapters(this.f22280c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22278a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (b.a.e.m.e.a aVar : this.f22280c) {
            }
        }
    }

    public void e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            for (b.a.e.m.e.a aVar : this.f22280c) {
                if (aVar != null) {
                    aVar.c0(wVar);
                }
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f22278a.setData(arrayList);
            this.f22279b = arrayList;
        }
    }

    public void g(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xVar) == null) {
            for (b.a.e.m.e.a aVar : this.f22280c) {
                if (aVar != null) {
                    aVar.d0(xVar);
                }
            }
        }
    }

    public void h(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, d0Var) == null) {
            this.f22285h.i0(d0Var);
            this.f22284g.i0(d0Var);
            this.f22283f.i0(d0Var);
        }
    }
}
