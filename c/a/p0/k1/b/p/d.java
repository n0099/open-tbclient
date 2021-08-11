package c.a.p0.k1.b.p;

import c.a.e.k.e.n;
import c.a.e.k.e.w;
import c.a.e.k.e.x;
import c.a.p0.a0.b0;
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
    public BdTypeRecyclerView f21111a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f21112b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.e.k.e.a> f21113c;

    /* renamed from: d  reason: collision with root package name */
    public b f21114d;

    /* renamed from: e  reason: collision with root package name */
    public b f21115e;

    /* renamed from: f  reason: collision with root package name */
    public b f21116f;

    /* renamed from: g  reason: collision with root package name */
    public b f21117g;

    /* renamed from: h  reason: collision with root package name */
    public b f21118h;

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
        this.f21113c = new LinkedList();
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.f21111a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bdTypeRecyclerView = this.f21111a) == null) {
            return;
        }
        bdTypeRecyclerView.removeItem(i2);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f21114d = new b(tbPageContext, a.x);
            this.f21115e = new b(tbPageContext, a.y);
            this.f21116f = new b(tbPageContext, a.B);
            this.f21117g = new b(tbPageContext, a.A);
            this.f21118h = new b(tbPageContext, a.z);
            this.f21113c.add(this.f21114d);
            this.f21113c.add(this.f21115e);
            this.f21113c.add(this.f21116f);
            this.f21113c.add(this.f21117g);
            this.f21113c.add(this.f21118h);
            this.f21111a.addAdapters(this.f21113c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21111a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.e.k.e.a aVar : this.f21113c) {
            }
        }
    }

    public void e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            for (c.a.e.k.e.a aVar : this.f21113c) {
                if (aVar != null) {
                    aVar.d0(wVar);
                }
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f21111a.setData(arrayList);
            this.f21112b = arrayList;
        }
    }

    public void g(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xVar) == null) {
            for (c.a.e.k.e.a aVar : this.f21113c) {
                if (aVar != null) {
                    aVar.e0(xVar);
                }
            }
        }
    }

    public void h(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b0Var) == null) {
            this.f21118h.j0(b0Var);
            this.f21117g.j0(b0Var);
            this.f21116f.j0(b0Var);
        }
    }
}
