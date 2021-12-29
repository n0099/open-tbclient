package c.a.t0.t1.b.p;

import c.a.d.n.e.n;
import c.a.d.n.e.w;
import c.a.d.n.e.x;
import c.a.t0.g0.d0;
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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f24502b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.n.e.a> f24503c;

    /* renamed from: d  reason: collision with root package name */
    public b f24504d;

    /* renamed from: e  reason: collision with root package name */
    public b f24505e;

    /* renamed from: f  reason: collision with root package name */
    public b f24506f;

    /* renamed from: g  reason: collision with root package name */
    public b f24507g;

    /* renamed from: h  reason: collision with root package name */
    public b f24508h;

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
        this.f24503c = new LinkedList();
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
            this.f24504d = bVar;
            bVar.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            b bVar2 = new b(tbPageContext, a.y);
            this.f24505e = bVar2;
            bVar2.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            b bVar3 = new b(tbPageContext, a.B);
            this.f24506f = bVar3;
            bVar3.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            b bVar4 = new b(tbPageContext, a.A);
            this.f24507g = bVar4;
            bVar4.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            b bVar5 = new b(tbPageContext, a.z);
            this.f24508h = bVar5;
            bVar5.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.f24503c.add(this.f24504d);
            this.f24503c.add(this.f24505e);
            this.f24503c.add(this.f24506f);
            this.f24503c.add(this.f24507g);
            this.f24503c.add(this.f24508h);
            this.a.addAdapters(this.f24503c);
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
            for (c.a.d.n.e.a aVar : this.f24503c) {
            }
        }
    }

    public void e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            for (c.a.d.n.e.a aVar : this.f24503c) {
                if (aVar != null) {
                    aVar.V(wVar);
                }
            }
        }
    }

    public void f(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.f24502b = arrayList;
        }
    }

    public void g(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xVar) == null) {
            for (c.a.d.n.e.a aVar : this.f24503c) {
                if (aVar != null) {
                    aVar.W(xVar);
                }
            }
        }
    }

    public void h(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, d0Var) == null) {
            this.f24508h.c0(d0Var);
            this.f24507g.c0(d0Var);
            this.f24506f.c0(d0Var);
        }
    }
}
