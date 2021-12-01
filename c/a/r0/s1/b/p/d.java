package c.a.r0.s1.b.p;

import c.a.d.m.e.n;
import c.a.d.m.e.w;
import c.a.d.m.e.x;
import c.a.r0.g0.d0;
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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f23434b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.m.e.a> f23435c;

    /* renamed from: d  reason: collision with root package name */
    public b f23436d;

    /* renamed from: e  reason: collision with root package name */
    public b f23437e;

    /* renamed from: f  reason: collision with root package name */
    public b f23438f;

    /* renamed from: g  reason: collision with root package name */
    public b f23439g;

    /* renamed from: h  reason: collision with root package name */
    public b f23440h;

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
        this.f23435c = new LinkedList();
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bdTypeRecyclerView = this.a) == null) {
            return;
        }
        bdTypeRecyclerView.removeItem(i2);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f23436d = new b(tbPageContext, a.x);
            this.f23437e = new b(tbPageContext, a.y);
            this.f23438f = new b(tbPageContext, a.B);
            this.f23439g = new b(tbPageContext, a.A);
            this.f23440h = new b(tbPageContext, a.z);
            this.f23435c.add(this.f23436d);
            this.f23435c.add(this.f23437e);
            this.f23435c.add(this.f23438f);
            this.f23435c.add(this.f23439g);
            this.f23435c.add(this.f23440h);
            this.a.addAdapters(this.f23435c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.d.m.e.a aVar : this.f23435c) {
            }
        }
    }

    public void e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            for (c.a.d.m.e.a aVar : this.f23435c) {
                if (aVar != null) {
                    aVar.c0(wVar);
                }
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.f23434b = arrayList;
        }
    }

    public void g(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xVar) == null) {
            for (c.a.d.m.e.a aVar : this.f23435c) {
                if (aVar != null) {
                    aVar.d0(xVar);
                }
            }
        }
    }

    public void h(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, d0Var) == null) {
            this.f23440h.i0(d0Var);
            this.f23439g.i0(d0Var);
            this.f23438f.i0(d0Var);
        }
    }
}
