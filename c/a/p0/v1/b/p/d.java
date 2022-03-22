package c.a.p0.v1.b.p;

import c.a.d.o.e.n;
import c.a.d.o.e.w;
import c.a.d.o.e.x;
import c.a.p0.h0.b0;
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
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f19174b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f19175c;

    /* renamed from: d  reason: collision with root package name */
    public b f19176d;

    /* renamed from: e  reason: collision with root package name */
    public b f19177e;

    /* renamed from: f  reason: collision with root package name */
    public b f19178f;

    /* renamed from: g  reason: collision with root package name */
    public b f19179g;

    /* renamed from: h  reason: collision with root package name */
    public b f19180h;

    public d(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19175c = new LinkedList();
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (bdTypeRecyclerView = this.a) == null) {
            return;
        }
        bdTypeRecyclerView.E(i);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            b bVar = new b(tbPageContext, a.t);
            this.f19176d = bVar;
            bVar.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            b bVar2 = new b(tbPageContext, a.u);
            this.f19177e = bVar2;
            bVar2.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            b bVar3 = new b(tbPageContext, a.x);
            this.f19178f = bVar3;
            bVar3.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            b bVar4 = new b(tbPageContext, a.w);
            this.f19179g = bVar4;
            bVar4.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            b bVar5 = new b(tbPageContext, a.v);
            this.f19180h = bVar5;
            bVar5.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.f19175c.add(this.f19176d);
            this.f19175c.add(this.f19177e);
            this.f19175c.add(this.f19178f);
            this.f19175c.add(this.f19179g);
            this.f19175c.add(this.f19180h);
            this.a.a(this.f19175c);
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
            for (c.a.d.o.e.a aVar : this.f19175c) {
            }
        }
    }

    public void e(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            for (c.a.d.o.e.a aVar : this.f19175c) {
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
            this.f19174b = arrayList;
        }
    }

    public void g(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xVar) == null) {
            for (c.a.d.o.e.a aVar : this.f19175c) {
                if (aVar != null) {
                    aVar.W(xVar);
                }
            }
        }
    }

    public void h(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b0Var) == null) {
            this.f19180h.c0(b0Var);
            this.f19179g.c0(b0Var);
            this.f19178f.c0(b0Var);
        }
    }
}
