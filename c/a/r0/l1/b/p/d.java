package c.a.r0.l1.b.p;

import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.e.l.e.x;
import c.a.r0.a0.b0;
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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f22021a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f22022b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.l.e.a> f22023c;

    /* renamed from: d  reason: collision with root package name */
    public b f22024d;

    /* renamed from: e  reason: collision with root package name */
    public b f22025e;

    /* renamed from: f  reason: collision with root package name */
    public b f22026f;

    /* renamed from: g  reason: collision with root package name */
    public b f22027g;

    /* renamed from: h  reason: collision with root package name */
    public b f22028h;

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
        this.f22023c = new LinkedList();
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f22021a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bdTypeRecyclerView = this.f22021a) == null) {
            return;
        }
        bdTypeRecyclerView.removeItem(i2);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f22024d = new b(tbPageContext, a.x);
            this.f22025e = new b(tbPageContext, a.y);
            this.f22026f = new b(tbPageContext, a.B);
            this.f22027g = new b(tbPageContext, a.A);
            this.f22028h = new b(tbPageContext, a.z);
            this.f22023c.add(this.f22024d);
            this.f22023c.add(this.f22025e);
            this.f22023c.add(this.f22026f);
            this.f22023c.add(this.f22027g);
            this.f22023c.add(this.f22028h);
            this.f22021a.addAdapters(this.f22023c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22021a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.e.l.e.a aVar : this.f22023c) {
            }
        }
    }

    public void e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            for (c.a.e.l.e.a aVar : this.f22023c) {
                if (aVar != null) {
                    aVar.d0(wVar);
                }
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f22021a.setData(arrayList);
            this.f22022b = arrayList;
        }
    }

    public void g(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xVar) == null) {
            for (c.a.e.l.e.a aVar : this.f22023c) {
                if (aVar != null) {
                    aVar.e0(xVar);
                }
            }
        }
    }

    public void h(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b0Var) == null) {
            this.f22028h.j0(b0Var);
            this.f22027g.j0(b0Var);
            this.f22026f.j0(b0Var);
        }
    }
}
