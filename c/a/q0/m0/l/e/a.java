package c.a.q0.m0.l.e;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.s.q.p1;
import c.a.p0.s.q.q1;
import c.a.q0.o2.i;
import c.a.q0.v0.c1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.concern.view.RecommendBarLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f22174a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.m0.l.b f22175b;

    /* renamed from: c  reason: collision with root package name */
    public String f22176c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f22177d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f22178e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f22179f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f22180g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.s.f0.g f22181h;

    /* renamed from: i  reason: collision with root package name */
    public c1 f22182i;

    /* renamed from: j  reason: collision with root package name */
    public SmartBubbleAnimatedView f22183j;
    public c.a.q0.m0.l.e.b k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public i p;
    public c.a.q0.m0.l.a q;
    public BdListView.p r;
    public RecyclerView.OnScrollListener s;
    public View.OnClickListener t;
    public c.a.p0.n.f u;
    public View.OnClickListener v;
    public PullLeftRefreshLayout.f w;

    /* renamed from: c.a.q0.m0.l.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1029a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22184e;

        public C1029a(a aVar) {
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
            this.f22184e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f22184e.f22179f != null) {
                    this.f22184e.f22179f.stopScroll();
                }
                if (this.f22184e.f22180g == null || this.f22184e.f22175b == null) {
                    return;
                }
                if (j.z()) {
                    this.f22184e.f22179f.setNextPage(this.f22184e.f22180g);
                    this.f22184e.f22180g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f22184e.f22180g.z(null);
                    if (this.f22184e.o) {
                        this.f22184e.f22180g.L();
                        this.f22184e.f22175b.callLoadMore();
                        return;
                    }
                    this.f22184e.f22180g.A(this.f22184e.f22174a.getResources().getString(R.string.list_has_no_more));
                    this.f22184e.f22180g.f();
                    return;
                }
                this.f22184e.f22179f.setNextPage(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f22185a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f22186b;

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
            this.f22186b = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f22186b.p != null) {
                    this.f22186b.p.n(this.f22186b.f22179f.getFirstVisiblePosition(), this.f22186b.f22179f.getLastVisiblePosition(), this.f22185a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f22186b.k())));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.f22185a = false;
                } else {
                    this.f22185a = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22187e;

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
            this.f22187e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f22187e.f22179f != null) {
                    this.f22187e.f22179f.stopScroll();
                }
                if (this.f22187e.f22180g == null || this.f22187e.f22175b == null || !j.z()) {
                    return;
                }
                this.f22187e.f22180g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f22187e.f22180g.z(null);
                if (this.f22187e.o) {
                    this.f22187e.f22180g.L();
                    this.f22187e.f22175b.callLoadMore();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.p0.n.f<p1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22188e;

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
            this.f22188e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f
        /* renamed from: b */
        public void c(View view, p1 p1Var, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, p1Var, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || p1Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13642");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", p1Var.o());
            if (this.f22188e.n.mFrom != 0) {
                if (this.f22188e.n.mFrom == 1) {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f22188e.f22176c);
                }
            } else {
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.f22188e.n.mHasLikeForum ? 3 : 1);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f
        /* renamed from: d */
        public void a(View view, p1 p1Var, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, p1Var, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (p1Var == null) {
                    c.a.q0.m0.b.a(this.f22188e.f22174a.getPageContext(), this.f22188e.f22176c);
                    if (this.f22188e.n == null) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_MORE);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_type", this.f22188e.n.mHasLikeForum ? 5 : 1);
                    statisticItem.param("obj_source", 5);
                    TiebaStatic.log(statisticItem);
                } else if (p1Var == null || this.f22188e.f22174a == null) {
                } else {
                    String p = p1Var.p();
                    if (k.isForumName(p)) {
                        this.f22188e.f22174a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f22188e.f22174a.getFragmentActivity()).createNormalCfg(p, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.f22188e.n == null) {
                            return;
                        }
                        StatisticItem statisticItem2 = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_FORUM_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("fid", p1Var.o());
                        if (this.f22188e.n.mFrom != 0) {
                            if (this.f22188e.n.mFrom == 1) {
                                statisticItem2.param("obj_locate", 2);
                                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f22188e.f22176c);
                            }
                        } else {
                            statisticItem2.param("obj_locate", 1);
                            statisticItem2.param("obj_type", this.f22188e.n.mHasLikeForum ? 4 : 1);
                        }
                        TiebaStatic.log(statisticItem2);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22189e;

        public e(a aVar) {
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
            this.f22189e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.m0.b.a(this.f22189e.f22174a.getPageContext(), this.f22189e.f22176c);
                if (this.f22189e.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_MORE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.f22189e.n.mHasLikeForum ? 5 : 1);
                statisticItem.param("obj_source", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f22190a;

        public f(a aVar) {
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
            this.f22190a = aVar;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.m0.b.a(this.f22190a.f22174a.getPageContext(), this.f22190a.f22176c);
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_MORE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.f22190a.n.mHasLikeForum ? 5 : 1);
                statisticItem.param("obj_source", 4);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f22191a;

        public g(a aVar) {
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
            this.f22191a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f22191a.p == null) {
                return;
            }
            this.f22191a.p.k(view);
        }
    }

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, c.a.q0.m0.l.b bVar, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, bVar, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new C1029a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.w = new f(this);
        this.f22174a = enterForumTabFeedFragment;
        this.f22175b = bVar;
        this.f22176c = str;
        i(viewGroup);
        this.q = new c.a.q0.m0.l.a(enterForumTabFeedFragment, this.f22179f);
        q(false);
    }

    public final void i(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            this.f22177d = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f22179f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f22174a.getContext()));
            this.f22179f.setFadingEdgeLength(0);
            this.f22179f.setOverScrollMode(2);
            this.f22179f.setOnSrollToBottomListener(this.r);
            this.f22179f.addOnScrollListener(this.s);
            c.a.p0.s.f0.g gVar = new c.a.p0.s.f0.g(this.f22174a.getPageContext());
            this.f22181h = gVar;
            gVar.a(this.f22175b);
            this.f22179f.setRecyclerListener(new g(this));
            PbListView pbListView = new PbListView(this.f22174a.getPageContext().getPageActivity());
            this.f22180g = pbListView;
            pbListView.b();
            this.f22180g.o(R.color.CAM_X0205);
            this.f22180g.r(l.g(this.f22174a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f22180g.v();
            this.f22180g.E(R.dimen.tbfontsize33);
            this.f22180g.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f22180g.y(R.color.CAM_X0110);
            this.f22180g.q();
            this.f22180g.z(this.t);
            if (this.f22178e == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f22178e = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f22181h);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22178e.getLayoutParams();
                marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f22174a.getPageContext().getPageActivity(), R.dimen.tbds219);
                this.f22178e.setLayoutParams(marginLayoutParams);
            }
            this.f22182i = new c1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f22174a.getContext());
            this.f22183j = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f22174a.getContext(), R.dimen.tbds83)));
            if (this.p == null) {
                i iVar = new i(this.f22174a.getPageContext(), this.f22179f);
                this.p = iVar;
                iVar.p(1);
                this.p.t(this.f22174a.getUniqueId());
            }
            c.a.q0.m0.l.e.b bVar = new c.a.q0.m0.l.e.b(this.f22174a.getPageContext());
            this.k = bVar;
            bVar.g(this.f22176c);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m == null) {
            TextView textView = new TextView(this.f22174a.getContext());
            this.m = textView;
            textView.setPadding(l.g(this.f22174a.getContext(), R.dimen.tbds44), l.g(this.f22174a.getContext(), R.dimen.tbds60), 0, l.g(this.f22174a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.tab_feed_title);
            this.m.setTextSize(0, l.g(this.f22174a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f22179f.removeHeaderView(this.m);
            this.f22179f.addHeaderView(this.m, 0);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f22179f;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f22179f.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            c.a.p0.s.f0.g gVar = this.f22181h;
            if (gVar != null) {
                gVar.D(i2);
            }
            PbListView pbListView = this.f22180g;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f22180g.d(i2);
            }
            c.a.q0.m0.l.a aVar = this.q;
            if (aVar != null) {
                aVar.b();
            }
            TextView textView = this.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            c.a.q0.m0.l.e.b bVar = this.k;
            if (bVar != null) {
                bVar.e();
            }
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                recommendForumLayout.onChangeSkinType();
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.f22183j;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.onChangeSkinType(i2);
            }
        }
    }

    public void m(c.a.q0.m0.l.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            if (bVar != null) {
                this.o = bVar.f22165c;
            }
            q(false);
            if (bVar == null || this.q == null || this.f22179f == null || this.f22180g == null) {
                return;
            }
            j();
            u(bVar);
            v(bVar);
            if (bVar.f22167e > 0) {
                int firstVisiblePosition = this.f22179f.getFirstVisiblePosition();
                View childAt = this.f22179f.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f22179f.getLayoutManager();
                int i2 = firstVisiblePosition - bVar.f22167e;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f22179f.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f22179f.stopIntercerceptLayout();
                }
                bVar.f22167e = 0;
            }
            this.q.d(bVar.f22166d);
            this.q.c(bVar.f22164b);
            this.q.b();
            if (bVar.f22170h) {
                s(bVar.f22168f);
            }
            i iVar = this.p;
            if (iVar != null) {
                iVar.n(this.f22179f.getFirstVisiblePosition(), this.f22179f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void n() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.x();
        this.p.q(false);
    }

    public void o(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || (bdTypeRecyclerView = this.f22179f) == null || i2 >= i3) {
            return;
        }
        bdTypeRecyclerView.removeItemList(i2, i3);
    }

    public void p() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.q(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f22179f;
        if (bdTypeRecyclerView != null) {
            this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f22179f.getLastVisiblePosition(), false, true);
        }
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdSwipeRefreshLayout = this.f22178e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f22178e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public final void s(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 < 0) {
            return;
        }
        this.f22182i.f();
        if (i2 > 0) {
            string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
        }
        if (TextUtils.isEmpty(string) || !j.z()) {
            return;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f22183j;
        smartBubbleAnimatedView.tipText = string;
        smartBubbleAnimatedView.delayDuring = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f22174a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.f22177d;
        if (viewGroup != null) {
            viewGroup.removeView(this.f22183j);
            this.f22177d.addView(this.f22183j, layoutParams);
            this.f22183j.playExpansionAnimation();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bdTypeRecyclerView = this.f22179f) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public final void u(c.a.q0.m0.l.d.b bVar) {
        List<ShortUserInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            c.a.q0.m0.l.d.c cVar = bVar.f22169g;
            if (cVar != null && (list = cVar.f22171a) != null && list.size() > 0 && !TextUtils.isEmpty(bVar.f22169g.f22172b)) {
                this.k.f(bVar.f22169g);
                if (this.k.d().getParent() != null || this.l) {
                    return;
                }
                this.l = true;
                this.f22179f.addHeaderView(this.k.d(), 0);
                StatisticItem statisticItem = new StatisticItem("c13656");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f22176c);
                TiebaStatic.log(statisticItem);
                return;
            }
            this.l = false;
            this.f22179f.removeHeaderView(this.k.d());
        }
    }

    public final void v(c.a.q0.m0.l.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) || bVar == null || this.f22179f == null || this.f22174a == null || !bVar.f22170h) {
            return;
        }
        q1 q1Var = bVar.f22163a;
        if (!((q1Var == null || ListUtils.isEmpty(q1Var.k())) ? false : true)) {
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                this.f22179f.removeHeaderView(recommendForumLayout);
                return;
            }
            return;
        }
        if (this.n == null) {
            RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.f22174a.getPageContext());
            this.n = recommendForumLayout2;
            recommendForumLayout2.setShowMore(true);
            this.n.setSquareEntranceAtStart(true);
            this.n.setTabName(this.f22176c);
            this.n.setFrom(1);
        }
        this.n.setOnClickRightArrowListener(this.v);
        this.n.setOnRullOkCallbackr(this.w);
        this.n.setOnItemCoverListener(this.u);
        this.n.bindData(bVar.f22163a);
        this.f22179f.removeHeaderView(this.n);
        this.f22179f.addHeaderView(this.n, 0);
        StatisticItem statisticItem = new StatisticItem("c13641");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 2);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f22176c);
        TiebaStatic.log(statisticItem);
    }
}
