package c.a.u0.u1.b.p;

import c.a.d.o.e.n;
import c.a.d.o.e.v;
import c.a.d.o.e.w;
import c.a.u0.g0.b0;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f23041b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f23042c;

    /* renamed from: d  reason: collision with root package name */
    public b f23043d;

    /* renamed from: e  reason: collision with root package name */
    public b f23044e;

    /* renamed from: f  reason: collision with root package name */
    public b f23045f;

    /* renamed from: g  reason: collision with root package name */
    public b f23046g;

    /* renamed from: h  reason: collision with root package name */
    public b f23047h;

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
        this.f23042c = new LinkedList();
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
            b bVar = new b(tbPageContext, a.x);
            this.f23043d = bVar;
            bVar.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            b bVar2 = new b(tbPageContext, a.y);
            this.f23044e = bVar2;
            bVar2.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            b bVar3 = new b(tbPageContext, a.B);
            this.f23045f = bVar3;
            bVar3.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            b bVar4 = new b(tbPageContext, a.A);
            this.f23046g = bVar4;
            bVar4.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            b bVar5 = new b(tbPageContext, a.z);
            this.f23047h = bVar5;
            bVar5.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.f23042c.add(this.f23043d);
            this.f23042c.add(this.f23044e);
            this.f23042c.add(this.f23045f);
            this.f23042c.add(this.f23046g);
            this.f23042c.add(this.f23047h);
            this.a.addAdapters(this.f23042c);
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
            for (c.a.d.o.e.a aVar : this.f23042c) {
            }
        }
    }

    public void e(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vVar) == null) {
            for (c.a.d.o.e.a aVar : this.f23042c) {
                if (aVar != null) {
                    aVar.V(vVar);
                }
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.f23041b = arrayList;
        }
    }

    public void g(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wVar) == null) {
            for (c.a.d.o.e.a aVar : this.f23042c) {
                if (aVar != null) {
                    aVar.W(wVar);
                }
            }
        }
    }

    public void h(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b0Var) == null) {
            this.f23047h.c0(b0Var);
            this.f23046g.c0(b0Var);
            this.f23045f.c0(b0Var);
        }
    }
}
