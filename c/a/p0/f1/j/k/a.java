package c.a.p0.f1.j.k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.o0.s.f0.g;
import c.a.p0.a0.t;
import c.a.p0.f1.j.e;
import c.a.p0.o2.i;
import c.a.p0.v0.c1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f17582a;

    /* renamed from: b  reason: collision with root package name */
    public e f17583b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f17584c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f17585d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f17586e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f17587f;

    /* renamed from: g  reason: collision with root package name */
    public g f17588g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f17589h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedHeaderView f17590i;

    /* renamed from: j  reason: collision with root package name */
    public i f17591j;
    public c.a.p0.f1.j.b k;
    public String l;
    public boolean m;
    public int n;
    public BdListView.p o;
    public RecyclerView.OnScrollListener p;
    public View.OnClickListener q;

    /* renamed from: c.a.p0.f1.j.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0850a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17592e;

        public C0850a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17592e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f17592e.f17586e != null) {
                    this.f17592e.f17586e.stopScroll();
                }
                this.f17592e.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f17593a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f17594b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17594b = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f17594b.f17591j != null) {
                    this.f17594b.f17591j.n(this.f17594b.f17586e.getFirstVisiblePosition(), this.f17594b.f17586e.getLastVisiblePosition(), this.f17593a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f17594b.h())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.f17593a = false;
                } else {
                    this.f17593a = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17595e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17595e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17595e.f17586e != null) {
                    this.f17595e.f17586e.stopScroll();
                }
                if (this.f17595e.f17587f == null || this.f17595e.f17583b == null || !j.z()) {
                    return;
                }
                this.f17595e.f17587f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f17595e.f17587f.z(null);
                if (this.f17595e.m) {
                    this.f17595e.f17587f.L();
                    this.f17595e.f17583b.callLoadMore();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17596a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17596a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f17596a.f17591j == null) {
                return;
            }
            this.f17596a.f17591j.k(view);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, e eVar, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, eVar, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = true;
        this.n = 3;
        this.o = new C0850a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.f17582a = homePageTabFeedFragment;
        this.f17583b = eVar;
        this.l = str;
        g(viewGroup);
        c.a.p0.f1.j.b bVar = new c.a.p0.f1.j.b(homePageTabFeedFragment, this.f17586e);
        this.k = bVar;
        bVar.d(str);
        o(false);
    }

    public BdTypeRecyclerView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17586e : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void g(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            this.f17584c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f17586e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f17582a.getContext()));
            this.f17586e.setFadingEdgeLength(0);
            this.f17586e.setOverScrollMode(2);
            this.f17586e.setOnSrollToBottomListener(this.o);
            this.f17586e.addOnScrollListener(this.p);
            g gVar = new g(this.f17582a.getPageContext());
            this.f17588g = gVar;
            gVar.a(this.f17583b);
            this.f17586e.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f17586e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.f17582a.getPageContext().getPageActivity());
            this.f17587f = pbListView;
            pbListView.b();
            this.f17587f.o(R.color.transparent);
            this.f17587f.r(l.g(this.f17582a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f17587f.v();
            this.f17587f.E(R.dimen.tbfontsize33);
            this.f17587f.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f17587f.y(R.color.CAM_X0110);
            this.f17587f.q();
            this.f17587f.z(this.q);
            if (this.f17585d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f17585d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f17588g);
            }
            new c1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f17582a.getContext());
            this.f17589h = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f17582a.getContext(), R.dimen.tbds83)));
            if (this.f17591j == null) {
                i iVar = new i(this.f17582a.getPageContext(), this.f17586e);
                this.f17591j = iVar;
                iVar.p(1);
                this.f17591j.t(this.f17582a.getUniqueId());
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f17586e;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f17586e.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.n == i2) {
            return;
        }
        g gVar = this.f17588g;
        if (gVar != null) {
            gVar.D(i2);
        }
        PbListView pbListView = this.f17587f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f17587f.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f17590i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.onChangeSkinType(i2);
        }
        c.a.p0.f1.j.b bVar = this.k;
        if (bVar != null) {
            bVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f17589h;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.onChangeSkinType(i2);
        }
        this.n = i2;
    }

    public void j() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (iVar = this.f17591j) == null) {
            return;
        }
        iVar.h();
    }

    public void k(c.a.p0.f1.j.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            o(false);
            if (cVar == null || this.k == null || this.f17586e == null || this.f17587f == null) {
                return;
            }
            this.m = cVar.f17575c;
            if (cVar.f17577e == null && cVar.f17578f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f17590i;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f17586e.removeHeaderView(this.f17590i);
                    this.f17590i = null;
                }
            } else {
                if (this.f17590i == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f17582a.getContext());
                    this.f17590i = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.l);
                    this.f17586e.addHeaderView(this.f17590i);
                }
                this.f17590i.setData(cVar);
            }
            if (cVar.f17574b > 0) {
                int firstVisiblePosition = this.f17586e.getFirstVisiblePosition();
                View childAt = this.f17586e.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f17586e.getLayoutManager();
                int i2 = firstVisiblePosition - cVar.f17574b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f17586e.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f17586e.stopIntercerceptLayout();
                }
            }
            this.k.c(cVar.f17573a);
            this.k.b();
            i iVar = this.f17591j;
            if (iVar != null) {
                iVar.n(this.f17586e.getFirstVisiblePosition(), this.f17586e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void l() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (iVar = this.f17591j) == null) {
            return;
        }
        iVar.x();
        this.f17591j.q(false);
    }

    public void m(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) || (bdTypeRecyclerView = this.f17586e) == null || i2 >= i3) {
            return;
        }
        bdTypeRecyclerView.removeItemList(i2, i3);
    }

    public void n() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (iVar = this.f17591j) == null) {
            return;
        }
        iVar.q(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f17586e;
        if (bdTypeRecyclerView != null) {
            this.f17591j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f17586e.getLastVisiblePosition(), false, true);
        }
    }

    public void o(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f17585d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void p(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (bdSwipeRefreshLayout = this.f17585d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f17587f == null || this.f17583b == null) {
            return;
        }
        if (j.z()) {
            this.f17586e.setNextPage(this.f17587f);
            this.f17587f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f17587f.z(null);
            if (this.m) {
                this.f17587f.L();
                this.f17583b.callLoadMore();
                return;
            }
            this.f17587f.A(this.f17582a.getResources().getString(R.string.list_has_no_more));
            this.f17587f.f();
            return;
        }
        this.f17586e.setNextPage(null);
    }

    public void r() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bdTypeRecyclerView = this.f17586e) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }
}
