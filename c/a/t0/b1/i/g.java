package c.a.t0.b1.i;

import android.app.Activity;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.o.e.n;
import c.a.t0.b1.e.a;
import c.a.t0.b1.e.c;
import c.a.t0.b1.g.h;
import c.a.t0.s.l0.f;
import c.a.u0.b3.k;
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
/* loaded from: classes6.dex */
public class g<Q extends c.a.t0.b1.e.c, P extends c.a.t0.b1.e.a> extends c.a.t0.b1.i.b<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.b1.a.a f12641f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.b1.b<Q, P> f12642g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.b1.f.c f12643h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f12644i;

    /* renamed from: j  reason: collision with root package name */
    public TbPageContext f12645j;
    public c.a.t0.b1.c.a k;
    public BdTypeRecyclerView l;
    public BdSwipeRefreshLayout m;
    public c.a.t0.s.l0.g n;
    public c.a.t0.b1.i.c o;
    public c.a.t0.b1.i.d<P> p;
    public BdListView.p q;
    public k r;
    public View.OnClickListener s;
    public final BdListView.p t;
    public final RecyclerView.OnScrollListener u;
    public final RecyclerView.RecyclerListener v;
    public final f.g w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f12646e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12646e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.b1.h.a.b(" ----LoadMoreClickListener----");
                if (this.f12646e.l != null) {
                    this.f12646e.l.stopScroll();
                }
                this.f12646e.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f12647e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12647e = gVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.t0.b1.h.a.b(" ----onScrollToBottom----");
                if (this.f12647e.l != null) {
                    this.f12647e.l.stopScroll();
                }
                if (this.f12647e.q != null) {
                    this.f12647e.q.onScrollToBottom();
                }
                this.f12647e.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f12648b;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12648b = gVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                this.f12648b.A(this.a);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || viewHolder.itemView == null || this.a.r == null) {
                return;
            }
            this.a.r.k(viewHolder.itemView);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f12649e;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12649e = gVar;
        }

        @Override // c.a.t0.s.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.t0.b1.h.a.b(" ----onListPullRefresh---- auto=" + z);
                this.f12649e.o(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.t0.b1.i.d f12650b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.t0.b1.i.c f12651c;

        /* renamed from: d  reason: collision with root package name */
        public h.c f12652d;

        /* renamed from: e  reason: collision with root package name */
        public List<c.a.d.o.e.a> f12653e;

        /* renamed from: f  reason: collision with root package name */
        public c.a.t0.n.f<c.a.t0.s.r.a> f12654f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.t0.b1.c.q.a f12655g;

        /* renamed from: h  reason: collision with root package name */
        public int f12656h;

        /* renamed from: i  reason: collision with root package name */
        public int f12657i;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12657i = 2;
        }

        public f a(List<c.a.d.o.e.a> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                this.f12653e = list;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f b(h.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.f12652d = cVar;
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
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f12652d == null) {
                this.f12652d = new h.c();
            }
        }

        public f e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f12656h = i2;
                return this;
            }
            return (f) invokeI.objValue;
        }

        public f f(c.a.t0.b1.i.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
                this.f12651c = cVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f g(c.a.t0.n.f<c.a.t0.s.r.a> fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
                this.f12654f = fVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f h(c.a.t0.b1.c.q.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
                this.f12655g = aVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f i(c.a.t0.b1.i.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar)) == null) {
                this.f12650b = dVar;
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    public /* synthetic */ g(f fVar, a aVar) {
        this(fVar);
    }

    public final void A(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (bdTypeRecyclerView = this.l) == null || (kVar = this.r) == null) {
            return;
        }
        kVar.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.l.getLastVisiblePosition(), z, true);
    }

    public final void B(c.a.t0.b1.d.d dVar) {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null || (list = dVar.a) == null) {
            return;
        }
        I(list);
    }

    public void C(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (bdSwipeRefreshLayout = this.m) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!q()) {
                H();
            } else {
                F();
            }
        }
    }

    public final void E(P p) {
        c.a.t0.b1.i.d<P> dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, p) == null) || this.l == null || (dVar = this.p) == null || dVar.getView() == null) {
            return;
        }
        if (this.p.onBindDataToView(p) != null) {
            this.l.setHeaderView(this.p.getView());
        } else {
            this.l.removeHeaderView(this.p.getView());
        }
    }

    public final void F() {
        c.a.t0.b1.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.o) == null) {
            return;
        }
        cVar.a();
    }

    public final void G() {
        c.a.t0.b1.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.o) == null) {
            return;
        }
        cVar.b();
    }

    public final void H() {
        c.a.t0.b1.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cVar = this.o) == null) {
            return;
        }
        cVar.c();
    }

    public void I(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            c.a.t0.b1.h.a.b(" ----submitDataList--size =" + ListUtils.getCount(list));
            c.a.t0.b1.c.a aVar = this.k;
            if (aVar != null) {
                aVar.h(list);
            }
        }
    }

    public void J() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bdTypeRecyclerView = this.l) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.l.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0202);
        }
    }

    @Override // c.a.t0.b1.i.b
    public void d() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (kVar = this.r) == null) {
            return;
        }
        kVar.h();
    }

    @Override // c.a.t0.b1.i.b
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            w();
        }
    }

    @Override // c.a.t0.b1.i.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            z();
        }
    }

    @Override // c.a.t0.b1.i.b
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.t0.b1.h.a.b(" ----sendReq---- ");
            o(true);
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f12645j.getPageActivity() : (Activity) invokeV.objValue;
    }

    @Override // c.a.t0.b1.i.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    @Override // c.a.t0.b1.i.b
    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            k kVar = this.r;
            if (kVar != null) {
                kVar.u(bdUniqueId);
            }
            c.a.t0.b1.f.c cVar = this.f12643h;
            if (cVar != null) {
                cVar.e(bdUniqueId);
            }
            c.a.t0.b1.c.a aVar = this.k;
            if (aVar != null) {
                aVar.j(bdUniqueId);
            }
        }
    }

    @Override // c.a.t0.b1.i.b
    public void i(c.a.t0.b1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.f12642g = bVar;
            bVar.b(this.f12641f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.t0.b1.h.a.b(" ----loadMore---- ");
            if (q()) {
                G();
                if (t()) {
                    this.f12642g.r();
                } else {
                    this.f12642g.s();
                }
                this.f12642g.g();
                return;
            }
            if (t()) {
                this.f12642g.r();
            } else {
                this.f12642g.s();
            }
            F();
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            c.a.t0.b1.h.a.b(" ----callRefresh---- ");
            if (z) {
                if (t()) {
                    this.f12642g.r();
                } else {
                    J();
                    C(true);
                }
            }
            this.f12642g.f(true);
        }
    }

    @Override // c.a.t0.b1.i.f
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            c.a.t0.b1.i.c cVar = this.o;
            if (cVar != null) {
                cVar.onChangeSkinType(i2);
            }
            c.a.t0.s.l0.g gVar = this.n;
            if (gVar != null) {
                gVar.C(i2);
            }
            c.a.t0.b1.i.d<P> dVar = this.p;
            if (dVar != null) {
                dVar.onChangeSkinType(i2);
            }
            K();
            u();
        }
    }

    public final String p(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048599, this, i2, objArr)) == null) ? TbadkCoreApplication.getInst().getResources().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f12641f.c() : invokeV.booleanValue;
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            if (i2 == 1 || i2 == 0 || i2 == 2) {
                k kVar = new k(this.f12645j, this.l);
                this.r = kVar;
                kVar.p(i2);
                this.r.u(this.f12644i);
            }
        }
    }

    public final void s(h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.m = new BdSwipeRefreshLayout(getActivity());
            this.l = new BdTypeRecyclerView(getActivity());
            K();
            this.m.addView(this.l);
            this.l.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.l.setFadingEdgeLength(0);
            this.l.setVerticalScrollBarEnabled(false);
            this.l.setOverScrollMode(2);
            this.l.setOnSrollToBottomListener(this.t);
            this.l.addOnScrollListener(this.u);
            this.l.setRecyclerListener(this.v);
            if (this.o == null) {
                cVar.f12638h = this.s;
                this.o = new h(this.f12645j, this.l, cVar);
            }
            c.a.t0.s.l0.g gVar = new c.a.t0.s.l0.g(this.f12645j);
            this.n = gVar;
            gVar.a(this.w);
            this.m.setProgressView(this.n);
            c.a.t0.b1.f.c cVar2 = new c.a.t0.b1.f.c(this.l);
            this.f12643h = cVar2;
            cVar2.e(this.f12644i);
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? ListUtils.isEmpty(this.l.getData()) : invokeV.booleanValue;
    }

    public void u() {
        c.a.t0.b1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.b1.i.e
    /* renamed from: v */
    public c.a.t0.b1.d.d onBindDataToView(P p) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, p)) == null) {
            c.a.t0.b1.h.a.b(" ----onBindDataToView---- ");
            C(false);
            if (p != null && p.getErrorCode() == 0) {
                c.a.t0.b1.h.a.b(" ----showContent---- ");
                c.a.t0.b1.d.d d2 = this.f12643h.d(this.f12642g.e(), this.f12642g.d());
                if (d2 != null && !ListUtils.isEmpty(d2.a)) {
                    this.f12642g.s();
                    E(p);
                    D();
                    B(d2);
                    A(false);
                } else {
                    this.f12642g.p(p.getErrorMsg());
                }
                return d2;
            }
            c.a.t0.b1.h.a.b(" ----showError---- ");
            if (!ListUtils.isEmpty(this.l.getData())) {
                D();
                return null;
            }
            this.f12642g.q(p != null ? p.getErrorMsg() : p(R.string.error_unkown_try_again, new Object[0]));
            return null;
        }
        return (c.a.t0.b1.d.d) invokeL.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            x();
        }
    }

    public final void x() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (kVar = this.r) == null) {
            return;
        }
        kVar.y();
        this.r.r(false);
    }

    public void y(List<c.a.d.o.e.a> list) {
        c.a.t0.b1.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, list) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.g(list);
        this.k.k(this.l);
    }

    public void z() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (kVar = this.r) == null) {
            return;
        }
        kVar.r(true);
        A(false);
    }

    public g(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.v = new d(this);
        this.w = new e(this);
        TbPageContext<?> tbPageContext = fVar.a;
        this.f12645j = tbPageContext;
        this.o = fVar.f12651c;
        this.p = fVar.f12650b;
        this.f12644i = tbPageContext.getUniqueId();
        this.f12641f = new c.a.t0.b1.a.a();
        s(fVar.f12652d);
        r(fVar.f12657i);
        c.a.t0.b1.c.a aVar = new c.a.t0.b1.c.a(this.f12645j, this.l);
        this.k = aVar;
        aVar.a(fVar.f12653e);
        this.k.k(this.l);
        this.k.i(fVar.f12654f);
        this.k.f(fVar.f12655g);
        this.k.e(fVar.f12656h);
    }
}
