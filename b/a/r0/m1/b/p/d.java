package b.a.r0.m1.b.p;

import b.a.e.l.e.n;
import b.a.e.l.e.w;
import b.a.e.l.e.x;
import b.a.r0.b0.c0;
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
    public BdTypeRecyclerView f21123a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f21124b;

    /* renamed from: c  reason: collision with root package name */
    public List<b.a.e.l.e.a> f21125c;

    /* renamed from: d  reason: collision with root package name */
    public b f21126d;

    /* renamed from: e  reason: collision with root package name */
    public b f21127e;

    /* renamed from: f  reason: collision with root package name */
    public b f21128f;

    /* renamed from: g  reason: collision with root package name */
    public b f21129g;

    /* renamed from: h  reason: collision with root package name */
    public b f21130h;

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
        this.f21125c = new LinkedList();
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f21123a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bdTypeRecyclerView = this.f21123a) == null) {
            return;
        }
        bdTypeRecyclerView.removeItem(i2);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f21126d = new b(tbPageContext, a.x);
            this.f21127e = new b(tbPageContext, a.y);
            this.f21128f = new b(tbPageContext, a.B);
            this.f21129g = new b(tbPageContext, a.A);
            this.f21130h = new b(tbPageContext, a.z);
            this.f21125c.add(this.f21126d);
            this.f21125c.add(this.f21127e);
            this.f21125c.add(this.f21128f);
            this.f21125c.add(this.f21129g);
            this.f21125c.add(this.f21130h);
            this.f21123a.addAdapters(this.f21125c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21123a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (b.a.e.l.e.a aVar : this.f21125c) {
            }
        }
    }

    public void e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            for (b.a.e.l.e.a aVar : this.f21125c) {
                if (aVar != null) {
                    aVar.c0(wVar);
                }
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f21123a.setData(arrayList);
            this.f21124b = arrayList;
        }
    }

    public void g(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xVar) == null) {
            for (b.a.e.l.e.a aVar : this.f21125c) {
                if (aVar != null) {
                    aVar.d0(xVar);
                }
            }
        }
    }

    public void h(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c0Var) == null) {
            this.f21130h.i0(c0Var);
            this.f21129g.i0(c0Var);
            this.f21128f.i0(c0Var);
        }
    }
}
