package c.a.s0.u0.l.e;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.s.r.q1;
import c.a.r0.s.r.r1;
import c.a.s0.d1.n1;
import c.a.s0.z2.i;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.u0.l.b f24326b;

    /* renamed from: c  reason: collision with root package name */
    public String f24327c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f24328d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f24329e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f24330f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f24331g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.s.i0.g f24332h;

    /* renamed from: i  reason: collision with root package name */
    public n1 f24333i;

    /* renamed from: j  reason: collision with root package name */
    public SmartBubbleAnimatedView f24334j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.s0.u0.l.e.b f24335k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public i p;
    public c.a.s0.u0.l.a q;
    public BdListView.p r;
    public RecyclerView.OnScrollListener s;
    public View.OnClickListener t;
    public c.a.r0.n.f u;
    public View.OnClickListener v;
    public PullLeftRefreshLayout.f w;

    /* renamed from: c.a.s0.u0.l.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1424a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24336e;

        public C1424a(a aVar) {
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
            this.f24336e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f24336e.f24330f != null) {
                    this.f24336e.f24330f.stopScroll();
                }
                if (this.f24336e.f24331g == null || this.f24336e.f24326b == null) {
                    return;
                }
                if (k.z()) {
                    this.f24336e.f24330f.setNextPage(this.f24336e.f24331g);
                    this.f24336e.f24331g.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f24336e.f24331g.C(null);
                    if (this.f24336e.o) {
                        this.f24336e.f24331g.O();
                        this.f24336e.f24326b.callLoadMore();
                        return;
                    }
                    this.f24336e.f24331g.D(this.f24336e.a.getResources().getString(R.string.list_has_no_more));
                    this.f24336e.f24331g.f();
                    return;
                }
                this.f24336e.f24330f.setNextPage(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f24337b;

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
            this.f24337b = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f24337b.p != null) {
                    this.f24337b.p.n(this.f24337b.f24330f.getFirstVisiblePosition(), this.f24337b.f24330f.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f24337b.k())));
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

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24338e;

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
            this.f24338e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f24338e.f24330f != null) {
                    this.f24338e.f24330f.stopScroll();
                }
                if (this.f24338e.f24331g == null || this.f24338e.f24326b == null || !k.z()) {
                    return;
                }
                this.f24338e.f24331g.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f24338e.f24331g.C(null);
                if (this.f24338e.o) {
                    this.f24338e.f24331g.O();
                    this.f24338e.f24326b.callLoadMore();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements c.a.r0.n.f<q1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24339e;

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
            this.f24339e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.n.f
        /* renamed from: b */
        public void c(View view, q1 q1Var, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, q1Var, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || q1Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13642");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", q1Var.o());
            if (this.f24339e.n.mFrom != 0) {
                if (this.f24339e.n.mFrom == 1) {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f24339e.f24327c);
                }
            } else {
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.f24339e.n.mHasLikeForum ? 3 : 1);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.n.f
        /* renamed from: d */
        public void a(View view, q1 q1Var, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, q1Var, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (q1Var == null) {
                    c.a.s0.u0.b.a(this.f24339e.a.getPageContext(), this.f24339e.f24327c);
                    if (this.f24339e.n == null) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_MORE);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_type", this.f24339e.n.mHasLikeForum ? 5 : 1);
                    statisticItem.param("obj_source", 5);
                    TiebaStatic.log(statisticItem);
                } else if (q1Var == null || this.f24339e.a == null) {
                } else {
                    String p = q1Var.p();
                    if (l.isForumName(p)) {
                        this.f24339e.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f24339e.a.getFragmentActivity()).createNormalCfg(p, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.f24339e.n == null) {
                            return;
                        }
                        StatisticItem statisticItem2 = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_FORUM_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("fid", q1Var.o());
                        if (this.f24339e.n.mFrom != 0) {
                            if (this.f24339e.n.mFrom == 1) {
                                statisticItem2.param("obj_locate", 2);
                                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f24339e.f24327c);
                            }
                        } else {
                            statisticItem2.param("obj_locate", 1);
                            statisticItem2.param("obj_type", this.f24339e.n.mHasLikeForum ? 4 : 1);
                        }
                        TiebaStatic.log(statisticItem2);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24340e;

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
            this.f24340e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.s0.u0.b.a(this.f24340e.a.getPageContext(), this.f24340e.f24327c);
                if (this.f24340e.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_MORE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.f24340e.n.mHasLikeForum ? 5 : 1);
                statisticItem.param("obj_source", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.u0.b.a(this.a.a.getPageContext(), this.a.f24327c);
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_MORE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.a.n.mHasLikeForum ? 5 : 1);
                statisticItem.param("obj_source", 4);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.a.p == null) {
                return;
            }
            this.a.p.k(view);
        }
    }

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, c.a.s0.u0.l.b bVar, ViewGroup viewGroup, String str) {
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
        this.r = new C1424a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.w = new f(this);
        this.a = enterForumTabFeedFragment;
        this.f24326b = bVar;
        this.f24327c = str;
        i(viewGroup);
        this.q = new c.a.s0.u0.l.a(enterForumTabFeedFragment, this.f24330f);
        q(false);
    }

    public final void i(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            this.f24328d = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f24330f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.f24330f.setFadingEdgeLength(0);
            this.f24330f.setOverScrollMode(2);
            this.f24330f.setOnSrollToBottomListener(this.r);
            this.f24330f.addOnScrollListener(this.s);
            c.a.r0.s.i0.g gVar = new c.a.r0.s.i0.g(this.a.getPageContext());
            this.f24332h = gVar;
            gVar.a(this.f24326b);
            this.f24330f.setRecyclerListener(new g(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f24331g = pbListView;
            pbListView.b();
            this.f24331g.p(R.color.CAM_X0205);
            this.f24331g.t(m.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f24331g.y();
            this.f24331g.H(R.dimen.tbfontsize33);
            this.f24331g.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f24331g.B(R.color.CAM_X0110);
            this.f24331g.s();
            this.f24331g.C(this.t);
            if (this.f24329e == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f24329e = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f24332h);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f24329e.getLayoutParams();
                marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + m.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds219);
                this.f24329e.setLayoutParams(marginLayoutParams);
            }
            this.f24333i = new n1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.a.getContext());
            this.f24334j = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, m.f(this.a.getContext(), R.dimen.tbds83)));
            if (this.p == null) {
                i iVar = new i(this.a.getPageContext(), this.f24330f);
                this.p = iVar;
                iVar.p(2);
                this.p.u(this.a.getUniqueId());
            }
            c.a.s0.u0.l.e.b bVar = new c.a.s0.u0.l.e.b(this.a.getPageContext());
            this.f24335k = bVar;
            bVar.g(this.f24327c);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m == null) {
            TextView textView = new TextView(this.a.getContext());
            this.m = textView;
            textView.setPadding(m.f(this.a.getContext(), R.dimen.tbds44), m.f(this.a.getContext(), R.dimen.tbds60), 0, m.f(this.a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.tab_feed_title);
            this.m.setTextSize(0, m.f(this.a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f24330f.removeHeaderView(this.m);
            this.f24330f.addHeaderView(this.m, 0);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f24330f;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f24330f.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            c.a.r0.s.i0.g gVar = this.f24332h;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.f24331g;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.f24331g.d(i2);
            }
            c.a.s0.u0.l.a aVar = this.q;
            if (aVar != null) {
                aVar.b();
            }
            TextView textView = this.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            c.a.s0.u0.l.e.b bVar = this.f24335k;
            if (bVar != null) {
                bVar.e();
            }
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                recommendForumLayout.onChangeSkinType();
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.f24334j;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.onChangeSkinType(i2);
            }
        }
    }

    public void m(c.a.s0.u0.l.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            if (bVar != null) {
                this.o = bVar.f24318c;
            }
            q(false);
            if (bVar == null || this.q == null || this.f24330f == null || this.f24331g == null) {
                return;
            }
            j();
            u(bVar);
            v(bVar);
            if (bVar.f24320e > 0) {
                int firstVisiblePosition = this.f24330f.getFirstVisiblePosition();
                View childAt = this.f24330f.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f24330f.getLayoutManager();
                int i2 = firstVisiblePosition - bVar.f24320e;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f24330f.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f24330f.stopIntercerceptLayout();
                }
                bVar.f24320e = 0;
            }
            this.q.d(bVar.f24319d);
            this.q.c(bVar.f24317b);
            this.q.b();
            if (bVar.f24323h) {
                s(bVar.f24321f);
            }
            i iVar = this.p;
            if (iVar != null) {
                iVar.n(this.f24330f.getFirstVisiblePosition(), this.f24330f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void n() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.y();
        this.p.r(false);
    }

    public void o(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || (bdTypeRecyclerView = this.f24330f) == null || i2 >= i3) {
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
        iVar.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f24330f;
        if (bdTypeRecyclerView != null) {
            this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f24330f.getLastVisiblePosition(), false, true);
        }
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdSwipeRefreshLayout = this.f24329e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f24329e) == null) {
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
        this.f24333i.f();
        if (i2 > 0) {
            string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
        }
        if (TextUtils.isEmpty(string) || !k.z()) {
            return;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f24334j;
        smartBubbleAnimatedView.tipText = string;
        smartBubbleAnimatedView.delayDuring = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + m.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.f24328d;
        if (viewGroup != null) {
            viewGroup.removeView(this.f24334j);
            this.f24328d.addView(this.f24334j, layoutParams);
            this.f24334j.playExpansionAnimation();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bdTypeRecyclerView = this.f24330f) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public final void u(c.a.s0.u0.l.d.b bVar) {
        List<ShortUserInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            c.a.s0.u0.l.d.c cVar = bVar.f24322g;
            if (cVar != null && (list = cVar.a) != null && list.size() > 0 && !TextUtils.isEmpty(bVar.f24322g.f24324b)) {
                this.f24335k.f(bVar.f24322g);
                if (this.f24335k.d().getParent() != null || this.l) {
                    return;
                }
                this.l = true;
                this.f24330f.addHeaderView(this.f24335k.d(), 0);
                StatisticItem statisticItem = new StatisticItem("c13656");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f24327c);
                TiebaStatic.log(statisticItem);
                return;
            }
            this.l = false;
            this.f24330f.removeHeaderView(this.f24335k.d());
        }
    }

    public final void v(c.a.s0.u0.l.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) || bVar == null || this.f24330f == null || this.a == null || !bVar.f24323h) {
            return;
        }
        r1 r1Var = bVar.a;
        if (!((r1Var == null || ListUtils.isEmpty(r1Var.k())) ? false : true)) {
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                this.f24330f.removeHeaderView(recommendForumLayout);
                return;
            }
            return;
        }
        if (this.n == null) {
            RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.a.getPageContext());
            this.n = recommendForumLayout2;
            recommendForumLayout2.setShowMore(true);
            this.n.setSquareEntranceAtStart(true);
            this.n.setTabName(this.f24327c);
            this.n.setFrom(1);
        }
        this.n.setOnClickRightArrowListener(this.v);
        this.n.setOnRullOkCallbackr(this.w);
        this.n.setOnItemCoverListener(this.u);
        this.n.bindData(bVar.a);
        this.f24330f.removeHeaderView(this.n);
        this.f24330f.addHeaderView(this.n, 0);
        StatisticItem statisticItem = new StatisticItem("c13641");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 2);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f24327c);
        TiebaStatic.log(statisticItem);
    }
}
