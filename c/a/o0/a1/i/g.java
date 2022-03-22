package c.a.o0.a1.i;

import android.app.Activity;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.o.e.n;
import c.a.o0.a1.e.a;
import c.a.o0.a1.e.c;
import c.a.o0.a1.g.h;
import c.a.o0.r.l0.f;
import c.a.p0.c3.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class g<Q extends c.a.o0.a1.e.c, P extends c.a.o0.a1.e.a> extends c.a.o0.a1.i.b<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.a1.a.a f9834b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.a1.b<Q, P> f9835c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.a1.f.c f9836d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f9837e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f9838f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.a1.c.a f9839g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f9840h;
    public BdSwipeRefreshLayout i;
    public c.a.o0.r.l0.g j;
    public c.a.o0.a1.i.c k;
    public c.a.o0.a1.i.d<P> l;
    public BdListView.p m;
    public k n;
    public View.OnClickListener o;
    public final BdListView.p p;
    public final RecyclerView.OnScrollListener q;
    public final RecyclerView.RecyclerListener r;
    public final f.g s;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.a1.h.a.b(" ----LoadMoreClickListener----");
                if (this.a.f9840h != null) {
                    this.a.f9840h.stopScroll();
                }
                this.a.o();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a1.h.a.b(" ----onScrollToBottom----");
                if (this.a.f9840h != null) {
                    this.a.f9840h.stopScroll();
                }
                if (this.a.m != null) {
                    this.a.m.onScrollToBottom();
                }
                this.a.o();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f9841b;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9841b = gVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                this.f9841b.B(this.a);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || viewHolder.itemView == null || this.a.n == null) {
                return;
            }
            this.a.n.k(viewHolder.itemView);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.o0.a1.h.a.b(" ----onListPullRefresh---- auto=" + z);
                this.a.p(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.o0.a1.i.d f9842b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.o0.a1.i.c f9843c;

        /* renamed from: d  reason: collision with root package name */
        public h.c f9844d;

        /* renamed from: e  reason: collision with root package name */
        public List<c.a.d.o.e.a> f9845e;

        /* renamed from: f  reason: collision with root package name */
        public c.a.o0.m.f<c.a.o0.r.r.a> f9846f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.o0.a1.c.q.a f9847g;

        /* renamed from: h  reason: collision with root package name */
        public int f9848h;
        public int i;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = 2;
        }

        public f a(List<c.a.d.o.e.a> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                this.f9845e = list;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f b(h.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.f9844d = cVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public g c(TbPageContext<?> tbPageContext) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
                this.a = tbPageContext;
                d();
                return new g(this, null);
            }
            return (g) invokeL.objValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f9844d == null) {
                this.f9844d = new h.c();
            }
        }

        public f e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.f9848h = i;
                return this;
            }
            return (f) invokeI.objValue;
        }

        public f f(c.a.o0.a1.i.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
                this.f9843c = cVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f g(c.a.o0.m.f<c.a.o0.r.r.a> fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
                this.f9846f = fVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f h(c.a.o0.a1.c.q.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
                this.f9847g = aVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f i(c.a.o0.a1.i.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar)) == null) {
                this.f9842b = dVar;
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    public /* synthetic */ g(f fVar, a aVar) {
        this(fVar);
    }

    public void A() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (kVar = this.n) == null) {
            return;
        }
        kVar.r(true);
        B(false);
    }

    public final void B(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdTypeRecyclerView = this.f9840h) == null || (kVar = this.n) == null) {
            return;
        }
        kVar.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f9840h.getLastVisiblePosition(), z, true);
    }

    public final void C(c.a.o0.a1.d.d dVar) {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null || (list = dVar.a) == null) {
            return;
        }
        J(list);
    }

    public void D(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (bdSwipeRefreshLayout = this.i) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!r()) {
                I();
            } else {
                G();
            }
        }
    }

    public final void F(P p) {
        c.a.o0.a1.i.d<P> dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, p) == null) || this.f9840h == null || (dVar = this.l) == null || dVar.getView() == null) {
            return;
        }
        if (this.l.a(p) != null) {
            this.f9840h.setHeaderView(this.l.getView());
        } else {
            this.f9840h.removeHeaderView(this.l.getView());
        }
    }

    public final void G() {
        c.a.o0.a1.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.k) == null) {
            return;
        }
        cVar.a();
    }

    public final void H() {
        c.a.o0.a1.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cVar = this.k) == null) {
            return;
        }
        cVar.b();
    }

    public final void I() {
        c.a.o0.a1.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (cVar = this.k) == null) {
            return;
        }
        cVar.c();
    }

    public void J(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            c.a.o0.a1.h.a.b(" ----submitDataList--size =" + ListUtils.getCount(list));
            c.a.o0.a1.c.a aVar = this.f9839g;
            if (aVar != null) {
                aVar.h(list);
            }
        }
    }

    public void K() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdTypeRecyclerView = this.f9840h) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f9840h.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0202);
        }
    }

    @Override // c.a.o0.a1.i.b
    public void e() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (kVar = this.n) == null) {
            return;
        }
        kVar.h();
    }

    @Override // c.a.o0.a1.i.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            x();
        }
    }

    @Override // c.a.o0.a1.i.b
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            A();
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f9838f.getPageActivity() : (Activity) invokeV.objValue;
    }

    @Override // c.a.o0.a1.i.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    @Override // c.a.o0.a1.i.b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.o0.a1.h.a.b(" ----sendReq---- ");
            p(true);
        }
    }

    @Override // c.a.o0.a1.i.b
    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            k kVar = this.n;
            if (kVar != null) {
                kVar.u(bdUniqueId);
            }
            c.a.o0.a1.f.c cVar = this.f9836d;
            if (cVar != null) {
                cVar.e(bdUniqueId);
            }
            c.a.o0.a1.c.a aVar = this.f9839g;
            if (aVar != null) {
                aVar.j(bdUniqueId);
            }
        }
    }

    @Override // c.a.o0.a1.i.b
    public void j(c.a.o0.a1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            this.f9835c = bVar;
            bVar.b(this.f9834b);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.o0.a1.h.a.b(" ----loadMore---- ");
            if (r()) {
                H();
                if (u()) {
                    this.f9835c.r();
                } else {
                    this.f9835c.s();
                }
                this.f9835c.g();
                return;
            }
            if (u()) {
                this.f9835c.r();
            } else {
                this.f9835c.s();
            }
            G();
        }
    }

    @Override // c.a.o0.a1.i.f
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            c.a.o0.a1.i.c cVar = this.k;
            if (cVar != null) {
                cVar.onChangeSkinType(i);
            }
            c.a.o0.r.l0.g gVar = this.j;
            if (gVar != null) {
                gVar.H(i);
            }
            c.a.o0.a1.i.d<P> dVar = this.l;
            if (dVar != null) {
                dVar.onChangeSkinType(i);
            }
            L();
            v();
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            c.a.o0.a1.h.a.b(" ----callRefresh---- ");
            if (z) {
                if (u()) {
                    this.f9835c.r();
                } else {
                    K();
                    D(true);
                }
            }
            this.f9835c.f(true);
        }
    }

    public final String q(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i, objArr)) == null) ? TbadkCoreApplication.getInst().getResources().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f9834b.c() : invokeV.booleanValue;
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            if (i == 1 || i == 0 || i == 2) {
                k kVar = new k(this.f9838f, this.f9840h);
                this.n = kVar;
                kVar.p(i);
                this.n.u(this.f9837e);
            }
        }
    }

    public final void t(h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cVar) == null) {
            this.i = new BdSwipeRefreshLayout(getActivity());
            this.f9840h = new BdTypeRecyclerView(getActivity());
            L();
            this.i.addView(this.f9840h);
            this.f9840h.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.f9840h.setFadingEdgeLength(0);
            this.f9840h.setVerticalScrollBarEnabled(false);
            this.f9840h.setOverScrollMode(2);
            this.f9840h.setOnSrollToBottomListener(this.p);
            this.f9840h.addOnScrollListener(this.q);
            this.f9840h.setRecyclerListener(this.r);
            if (this.k == null) {
                cVar.f9832h = this.o;
                this.k = new h(this.f9838f, this.f9840h, cVar);
            }
            c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(this.f9838f);
            this.j = gVar;
            gVar.f(this.s);
            this.i.setProgressView(this.j);
            c.a.o0.a1.f.c cVar2 = new c.a.o0.a1.f.c(this.f9840h);
            this.f9836d = cVar2;
            cVar2.e(this.f9837e);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? ListUtils.isEmpty(this.f9840h.getData()) : invokeV.booleanValue;
    }

    public void v() {
        c.a.o0.a1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (aVar = this.f9839g) == null) {
            return;
        }
        aVar.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a1.i.e
    /* renamed from: w */
    public c.a.o0.a1.d.d a(P p) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, p)) == null) {
            c.a.o0.a1.h.a.b(" ----onBindDataToView---- ");
            D(false);
            if (p != null && p.getErrorCode() == 0) {
                c.a.o0.a1.h.a.b(" ----showContent---- ");
                c.a.o0.a1.d.d d2 = this.f9836d.d(this.f9835c.e(), this.f9835c.d());
                if (d2 != null && !ListUtils.isEmpty(d2.a)) {
                    this.f9835c.s();
                    F(p);
                    E();
                    C(d2);
                    B(false);
                } else {
                    this.f9835c.p(p.getErrorMsg());
                }
                return d2;
            }
            c.a.o0.a1.h.a.b(" ----showError---- ");
            if (!ListUtils.isEmpty(this.f9840h.getData())) {
                E();
                return null;
            }
            this.f9835c.q(p != null ? p.getErrorMsg() : q(R.string.obfuscated_res_0x7f0f0598, new Object[0]));
            return null;
        }
        return (c.a.o0.a1.d.d) invokeL.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            y();
        }
    }

    public final void y() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (kVar = this.n) == null) {
            return;
        }
        kVar.y();
        this.n.r(false);
    }

    public void z(List<c.a.d.o.e.a> list) {
        c.a.o0.a1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, list) == null) || (aVar = this.f9839g) == null) {
            return;
        }
        aVar.g(list);
        this.f9839g.k(this.f9840h);
    }

    public g(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        TbPageContext<?> tbPageContext = fVar.a;
        this.f9838f = tbPageContext;
        this.k = fVar.f9843c;
        this.l = fVar.f9842b;
        this.f9837e = tbPageContext.getUniqueId();
        this.f9834b = new c.a.o0.a1.a.a();
        t(fVar.f9844d);
        s(fVar.i);
        c.a.o0.a1.c.a aVar = new c.a.o0.a1.c.a(this.f9838f, this.f9840h);
        this.f9839g = aVar;
        aVar.a(fVar.f9845e);
        this.f9839g.k(this.f9840h);
        this.f9839g.i(fVar.f9846f);
        this.f9839g.f(fVar.f9847g);
        this.f9839g.e(fVar.f9848h);
    }
}
