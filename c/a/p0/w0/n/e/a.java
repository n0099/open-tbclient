package c.a.p0.w0.n.e;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.r.n1;
import c.a.o0.r.r.o1;
import c.a.p0.c3.k;
import c.a.p0.f1.d1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w0.n.b f19552b;

    /* renamed from: c  reason: collision with root package name */
    public String f19553c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f19554d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f19555e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f19556f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f19557g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.r.l0.g f19558h;
    public d1 i;
    public SmartBubbleAnimatedView j;
    public c.a.p0.w0.n.e.b k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public k p;
    public c.a.p0.w0.n.a q;
    public BdListView.p r;
    public RecyclerView.OnScrollListener s;
    public View.OnClickListener t;
    public c.a.o0.m.f u;
    public View.OnClickListener v;
    public PullLeftRefreshLayout.f w;

    /* renamed from: c.a.p0.w0.n.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1477a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1477a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f19556f != null) {
                    this.a.f19556f.stopScroll();
                }
                if (this.a.f19557g == null || this.a.f19552b == null) {
                    return;
                }
                if (l.z()) {
                    this.a.f19556f.setNextPage(this.a.f19557g);
                    this.a.f19557g.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.f19557g.C(null);
                    if (this.a.o) {
                        this.a.f19557g.O();
                        this.a.f19552b.e();
                        return;
                    }
                    this.a.f19557g.D(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                    this.a.f19557g.f();
                    return;
                }
                this.a.f19556f.setNextPage(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f19559b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19559b = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.f19559b.p != null) {
                    this.f19559b.p.n(this.f19559b.f19556f.getFirstVisiblePosition(), this.f19559b.f19556f.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f19559b.k())));
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
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f19556f != null) {
                    this.a.f19556f.stopScroll();
                }
                if (this.a.f19557g == null || this.a.f19552b == null || !l.z()) {
                    return;
                }
                this.a.f19557g.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.f19557g.C(null);
                if (this.a.o) {
                    this.a.f19557g.O();
                    this.a.f19552b.e();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.a.o0.m.f<n1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, n1Var, Integer.valueOf(i), Long.valueOf(j)}) == null) || n1Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13642");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", n1Var.k());
            if (this.a.n.l != 0) {
                if (this.a.n.l == 1) {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.a.f19553c);
                }
            } else {
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.a.n.n ? 3 : 1);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, n1Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (n1Var == null) {
                    c.a.p0.w0.b.b(this.a.a.getPageContext(), this.a.f19553c);
                    if (this.a.n == null) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13645");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_type", this.a.n.n ? 5 : 1);
                    statisticItem.param("obj_source", 5);
                    TiebaStatic.log(statisticItem);
                } else if (n1Var == null || this.a.a == null) {
                } else {
                    String m = n1Var.m();
                    if (m.isForumName(m)) {
                        this.a.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getFragmentActivity()).createNormalCfg(m, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.a.n == null) {
                            return;
                        }
                        StatisticItem statisticItem2 = new StatisticItem("c13643");
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("fid", n1Var.k());
                        if (this.a.n.l != 0) {
                            if (this.a.n.l == 1) {
                                statisticItem2.param("obj_locate", 2);
                                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.a.f19553c);
                            }
                        } else {
                            statisticItem2.param("obj_locate", 1);
                            statisticItem2.param("obj_type", this.a.n.n ? 4 : 1);
                        }
                        TiebaStatic.log(statisticItem2);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.w0.b.b(this.a.a.getPageContext(), this.a.f19553c);
                if (this.a.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.a.n.n ? 5 : 1);
                statisticItem.param("obj_source", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                c.a.p0.w0.b.b(this.a.a.getPageContext(), this.a.f19553c);
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.a.n.n ? 5 : 1);
                statisticItem.param("obj_source", 4);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, c.a.p0.w0.n.b bVar, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, bVar, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new C1477a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.w = new f(this);
        this.a = enterForumTabFeedFragment;
        this.f19552b = bVar;
        this.f19553c = str;
        i(viewGroup);
        this.q = new c.a.p0.w0.n.a(enterForumTabFeedFragment, this.f19556f);
        q(false);
    }

    public final void i(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            this.f19554d = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091e42);
            this.f19556f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.f19556f.setFadingEdgeLength(0);
            this.f19556f.setOverScrollMode(2);
            this.f19556f.setOnSrollToBottomListener(this.r);
            this.f19556f.addOnScrollListener(this.s);
            c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(this.a.getPageContext());
            this.f19558h = gVar;
            gVar.f(this.f19552b);
            this.f19556f.setRecyclerListener(new g(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f19557g = pbListView;
            pbListView.b();
            this.f19557g.p(R.color.CAM_X0205);
            this.f19557g.t(n.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f19557g.y();
            this.f19557g.H(R.dimen.tbfontsize33);
            this.f19557g.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f19557g.B(R.color.CAM_X0110);
            this.f19557g.s();
            this.f19557g.C(this.t);
            if (this.f19555e == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091e41);
                this.f19555e = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f19558h);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f19555e.getLayoutParams();
                marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + n.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds219);
                this.f19555e.setLayoutParams(marginLayoutParams);
            }
            this.i = new d1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.a.getContext());
            this.j = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, n.f(this.a.getContext(), R.dimen.tbds83)));
            if (this.p == null) {
                this.p = new k(this.a.getPageContext(), this.f19556f);
                if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    this.p.p(2);
                } else {
                    this.p.p(1);
                }
                this.p.u(this.a.getUniqueId());
            }
            c.a.p0.w0.n.e.b bVar = new c.a.p0.w0.n.e.b(this.a.getPageContext());
            this.k = bVar;
            bVar.g(this.f19553c);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m == null) {
            TextView textView = new TextView(this.a.getContext());
            this.m = textView;
            textView.setPadding(n.f(this.a.getContext(), R.dimen.tbds44), n.f(this.a.getContext(), R.dimen.tbds60), 0, n.f(this.a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.obfuscated_res_0x7f0f1319);
            this.m.setTextSize(0, n.f(this.a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f19556f.removeHeaderView(this.m);
            this.f19556f.t(this.m, 0);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19556f;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f19556f.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            c.a.o0.r.l0.g gVar = this.f19558h;
            if (gVar != null) {
                gVar.H(i);
            }
            PbListView pbListView = this.f19557g;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.f19557g.d(i);
            }
            c.a.p0.w0.n.a aVar = this.q;
            if (aVar != null) {
                aVar.b();
            }
            TextView textView = this.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            c.a.p0.w0.n.e.b bVar = this.k;
            if (bVar != null) {
                bVar.e();
            }
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                recommendForumLayout.c();
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.e(i);
            }
        }
    }

    public void m(c.a.p0.w0.n.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            if (bVar != null) {
                this.o = bVar.f19544c;
            }
            q(false);
            if (bVar == null || this.q == null || this.f19556f == null || this.f19557g == null) {
                return;
            }
            j();
            u(bVar);
            v(bVar);
            if (bVar.f19546e > 0) {
                int firstVisiblePosition = this.f19556f.getFirstVisiblePosition();
                View childAt = this.f19556f.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f19556f.getLayoutManager();
                int i = firstVisiblePosition - bVar.f19546e;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f19556f.A();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.f19556f.B();
                }
                bVar.f19546e = 0;
            }
            this.q.d(bVar.f19545d);
            this.q.c(bVar.f19543b);
            this.q.b();
            if (bVar.f19549h) {
                s(bVar.f19547f);
            }
            k kVar = this.p;
            if (kVar != null) {
                kVar.n(this.f19556f.getFirstVisiblePosition(), this.f19556f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void n() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (kVar = this.p) == null) {
            return;
        }
        kVar.y();
        this.p.r(false);
    }

    public void o(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) || (bdTypeRecyclerView = this.f19556f) == null || i >= i2) {
            return;
        }
        bdTypeRecyclerView.F(i, i2);
    }

    public void p() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (kVar = this.p) == null) {
            return;
        }
        kVar.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f19556f;
        if (bdTypeRecyclerView != null) {
            this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f19556f.getLastVisiblePosition(), false, true);
        }
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdSwipeRefreshLayout = this.f19555e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f19555e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public final void s(int i) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i < 0) {
            return;
        }
        this.i.f();
        if (i > 0) {
            string = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f4e), Integer.valueOf(i));
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f4d);
        }
        if (TextUtils.isEmpty(string) || !l.z()) {
            return;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
        smartBubbleAnimatedView.a = string;
        smartBubbleAnimatedView.f32337b = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + n.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.f19554d;
        if (viewGroup != null) {
            viewGroup.removeView(this.j);
            this.f19554d.addView(this.j, layoutParams);
            this.j.g();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bdTypeRecyclerView = this.f19556f) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public final void u(c.a.p0.w0.n.d.b bVar) {
        List<ShortUserInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            c.a.p0.w0.n.d.c cVar = bVar.f19548g;
            if (cVar != null && (list = cVar.a) != null && list.size() > 0 && !TextUtils.isEmpty(bVar.f19548g.f19550b)) {
                this.k.f(bVar.f19548g);
                if (this.k.d().getParent() != null || this.l) {
                    return;
                }
                this.l = true;
                this.f19556f.t(this.k.d(), 0);
                StatisticItem statisticItem = new StatisticItem("c13656");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f19553c);
                TiebaStatic.log(statisticItem);
                return;
            }
            this.l = false;
            this.f19556f.removeHeaderView(this.k.d());
        }
    }

    public final void v(c.a.p0.w0.n.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) || bVar == null || this.f19556f == null || this.a == null || !bVar.f19549h) {
            return;
        }
        o1 o1Var = bVar.a;
        if (!((o1Var == null || ListUtils.isEmpty(o1Var.i())) ? false : true)) {
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                this.f19556f.removeHeaderView(recommendForumLayout);
                return;
            }
            return;
        }
        if (this.n == null) {
            RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.a.getPageContext());
            this.n = recommendForumLayout2;
            recommendForumLayout2.setShowMore(true);
            this.n.setSquareEntranceAtStart(true);
            this.n.setTabName(this.f19553c);
            this.n.setFrom(1);
        }
        this.n.setOnClickRightArrowListener(this.v);
        this.n.setOnRullOkCallbackr(this.w);
        this.n.setOnItemCoverListener(this.u);
        this.n.a(bVar.a);
        this.f19556f.removeHeaderView(this.n);
        this.f19556f.t(this.n, 0);
        StatisticItem statisticItem = new StatisticItem("c13641");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 2);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f19553c);
        TiebaStatic.log(statisticItem);
    }
}
