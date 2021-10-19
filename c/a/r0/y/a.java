package c.a.r0.y;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.g0.h;
import c.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CandidateSearchActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteActivity;
import com.baidu.tieba.barselect.VoteAdapter;
import com.baidu.tieba.barselect.view.FloatMyRecordCard;
import com.baidu.tieba.barselect.view.SearchView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.barselect.view.VoteStatusCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
import tbclient.ElectionInfo.NoticeContent;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SelectRuleView A;
    public SearchView B;
    public VoteAdapter C;
    public FloatMyRecordCard D;
    public TextView E;
    public int F;
    public PbListView G;
    public NoNetworkView H;
    public NoDataView I;
    public h J;
    public ViewGroup K;
    public View.OnClickListener L;
    public View.OnClickListener M;
    public boolean N;
    public VoteStatusCard.b O;
    public RecyclerView.OnScrollListener P;
    public BdListView.p Q;

    /* renamed from: a  reason: collision with root package name */
    public int f28409a;

    /* renamed from: b  reason: collision with root package name */
    public BarVoteActivity f28410b;

    /* renamed from: c  reason: collision with root package name */
    public int f28411c;

    /* renamed from: d  reason: collision with root package name */
    public int f28412d;

    /* renamed from: e  reason: collision with root package name */
    public int f28413e;

    /* renamed from: f  reason: collision with root package name */
    public float f28414f;

    /* renamed from: g  reason: collision with root package name */
    public int f28415g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.y.b.f f28416h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f28417i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f28418j;
    public View k;
    public ViewGroup l;
    public TbImageView m;
    public View n;
    public View o;
    public NavigationBar p;
    public View q;
    public TextView r;
    public BdRecyclerView s;
    public VoteStatusCard t;
    public View u;
    public TextView v;
    public TextView w;
    public VoteCandidateCard x;
    public View y;
    public TextView z;

    /* renamed from: c.a.r0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1336a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28419e;

        public View$OnClickListenerC1336a(a aVar) {
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
            this.f28419e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                if (this.f28419e.J != null) {
                    this.f28419e.J.dettachView(this.f28419e.k);
                    this.f28419e.J = null;
                }
                this.f28419e.f28410b.reload();
                if (this.f28419e.s != null) {
                    this.f28419e.s.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements VoteStatusCard.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28420a;

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
            this.f28420a = aVar;
        }

        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.b
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28420a.f28410b == null) {
                return;
            }
            this.f28420a.f28410b.refresh();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28421a;

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
            this.f28421a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                this.f28421a.f28415g = i2;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if ((this.f28421a.f28415g != 1 && this.f28421a.f28415g != 2) || this.f28421a.l == null || this.f28421a.p == null || this.f28421a.p.getBarBgView() == null || this.f28421a.p.getBackImageView() == null) {
                    return;
                }
                a aVar = this.f28421a;
                aVar.f28414f = Math.abs(aVar.l.getTop()) / this.f28421a.f28409a;
                this.f28421a.p.getBarBgView().setAlpha(this.f28421a.f28414f);
                this.f28421a.q.setAlpha(this.f28421a.f28414f);
                if (this.f28421a.f28414f > 0.5d) {
                    if (this.f28421a.f28413e == 0) {
                        SkinManager.setImageResource(this.f28421a.p.getBackImageView(), R.drawable.icon_return_bg_s, this.f28421a.f28411c);
                        SkinManager.setViewTextColor(this.f28421a.r, R.color.CAM_X0105, 1, this.f28421a.f28411c);
                        SkinManager.setViewTextColor(this.f28421a.p.mCenterText, R.color.CAM_X0105, 1, this.f28421a.f28411c);
                        this.f28421a.f28413e = 1;
                    }
                    this.f28421a.p.getBackImageView().setAlpha((this.f28421a.f28414f * 2.0f) - 1.0f);
                    this.f28421a.r.setAlpha((this.f28421a.f28414f * 2.0f) - 1.0f);
                    this.f28421a.p.mCenterText.setAlpha((this.f28421a.f28414f * 2.0f) - 1.0f);
                } else if (this.f28421a.f28414f <= 0.5d) {
                    if (this.f28421a.f28413e == 1) {
                        SkinManager.setImageResource(this.f28421a.p.getBackImageView(), R.drawable.icon_return_bg, this.f28421a.f28411c);
                        SkinManager.setViewTextColor(this.f28421a.r, R.color.CAM_X0101, 1, this.f28421a.f28411c);
                        SkinManager.setViewTextColor(this.f28421a.p.mCenterText, R.color.CAM_X0101, 1, this.f28421a.f28411c);
                        this.f28421a.f28413e = 0;
                    }
                    this.f28421a.p.getBackImageView().setAlpha(1.0f - (this.f28421a.f28414f * 2.0f));
                    this.f28421a.r.setAlpha(1.0f - (this.f28421a.f28414f * 2.0f));
                    this.f28421a.p.mCenterText.setAlpha(1.0f - (this.f28421a.f28414f * 2.0f));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28422e;

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
            this.f28422e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f28422e.s != null) {
                    this.f28422e.s.stopScroll();
                }
                if (this.f28422e.G == null || this.f28422e.f28410b == null) {
                    return;
                }
                if (j.z()) {
                    if (this.f28422e.f28412d == c.a.r0.y.e.c.f28496c) {
                        this.f28422e.G.J(l.g(this.f28422e.f28410b, R.dimen.tbds152));
                    }
                    this.f28422e.s.setNextPage(this.f28422e.G);
                    this.f28422e.G.z(null);
                    if (this.f28422e.N) {
                        this.f28422e.G.L();
                        this.f28422e.f28410b.loadmore();
                        return;
                    }
                    this.f28422e.G.A(this.f28422e.f28410b.getResources().getString(R.string.list_has_no_more));
                    this.f28422e.G.f();
                    return;
                }
                this.f28422e.s.setNextPage(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28423e;

        /* renamed from: c.a.r0.y.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1337a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1337a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

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
            this.f28423e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f28423e.f28410b);
                View inflate = LayoutInflater.from(this.f28423e.f28410b.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(this.f28423e.f28410b.getResources().getString(R.string.vote_ueg_tip_detail_1) + StringUtils.LF + this.f28423e.f28410b.getResources().getString(R.string.vote_ueg_tip_detail_2));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.setContentView(inflate);
                aVar.setNegativeButton(R.string.know, new C1337a(this));
                aVar.create(this.f28423e.f28410b.getPageContext());
                ViewGroup realView = aVar.getRealView();
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int i2 = R.color.CAM_X0201;
                SkinManager.setBackgroundShapeDrawable(realView, g2, i2, i2);
                aVar.show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28424e;

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
            this.f28424e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BarVoteActivity barVoteActivity = this.f28424e.f28410b;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(barVoteActivity, this.f28424e.f28410b.fid + "")));
            }
        }
    }

    public a(BarVoteActivity barVoteActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {barVoteActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28411c = 3;
        this.f28412d = -1;
        this.f28413e = 0;
        this.f28414f = 0.0f;
        this.M = new View$OnClickListenerC1336a(this);
        this.O = new b(this);
        this.P = new c(this);
        this.Q = new d(this);
        this.f28410b = barVoteActivity;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(barVoteActivity.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.f28418j = relativeLayout;
        this.f28410b.addContentView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        BarVoteActivity barVoteActivity2 = this.f28410b;
        barVoteActivity2.showLoadingView(this.f28418j, false, l.g(barVoteActivity2, R.dimen.ds400));
        this.k = this.f28418j.findViewById(R.id.list_container);
        this.K = (ViewGroup) this.f28418j.findViewById(R.id.no_data_container);
        this.o = this.f28418j.findViewById(R.id.nav_bar_container);
        View findViewById = this.f28418j.findViewById(R.id.nav_bar_shadow);
        this.q = findViewById;
        findViewById.setAlpha(0.0f);
        NavigationBar navigationBar = (NavigationBar) this.f28418j.findViewById(R.id.vote_navigation_bar);
        this.p = navigationBar;
        navigationBar.setCenterTextTitle(this.f28410b.getResources().getString(R.string.bar_manager_recruit));
        if (this.p.getBarBgView() != null) {
            this.p.getBarBgView().setAlpha(0.0f);
        }
        this.f28409a = l.g(this.f28410b, R.dimen.tbds402);
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView textView = (TextView) this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f28410b).findViewById(R.id.right_textview);
        this.r = textView;
        textView.setText(R.string.bar_election_rule);
        this.r.setOnClickListener(this.f28410b);
        this.s = (BdRecyclerView) this.f28418j.findViewById(R.id.vote_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f28410b);
        this.f28417i = linearLayoutManager;
        this.s.setLayoutManager(linearLayoutManager);
        VoteAdapter voteAdapter = new VoteAdapter(barVoteActivity.getPageContext());
        this.C = voteAdapter;
        this.s.setAdapter(voteAdapter);
        this.l = (ViewGroup) LayoutInflater.from(this.f28410b).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.m = (TbImageView) this.l.findViewById(R.id.head_main_iv);
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.k(this.f28410b) * 884) / 1076));
        this.s.addHeaderView(this.l);
        this.s.addOnScrollListener(this.P);
        this.s.setOnSrollToBottomListener(this.Q);
        this.F = this.f28410b.getResources().getDimensionPixelSize(R.dimen.tbds134);
        View view = new View(this.f28410b);
        this.n = view;
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.F));
        this.n.setVisibility(4);
        this.s.addFooterView(this.n);
        this.t = (VoteStatusCard) this.l.findViewById(R.id.vote_status_card);
        View findViewById2 = this.l.findViewById(R.id.vote_ueg_tip_container);
        this.u = findViewById2;
        findViewById2.setOnClickListener(new e(this));
        this.v = (TextView) this.l.findViewById(R.id.vote_ueg_tip_tv);
        this.w = (TextView) this.l.findViewById(R.id.vote_ueg_tip_img);
        this.t.setOnRefreshListener(this.O);
        this.y = this.l.findViewById(R.id.bar_select_rule_bg);
        this.z = (TextView) this.l.findViewById(R.id.bar_select_rule_main_title);
        SelectRuleView selectRuleView = (SelectRuleView) this.l.findViewById(R.id.bar_select_rule_container);
        this.A = selectRuleView;
        selectRuleView.setType(1);
        this.x = (VoteCandidateCard) this.l.findViewById(R.id.vote_for_mine);
        SearchView searchView = (SearchView) this.l.findViewById(R.id.vote_search_view);
        this.B = searchView;
        searchView.addOnClickListener(new f(this));
        this.D = (FloatMyRecordCard) this.f28418j.findViewById(R.id.float_my_record_card);
        this.E = (TextView) this.l.findViewById(R.id.vote_tip);
        PbListView pbListView = new PbListView(this.f28410b);
        this.G = pbListView;
        pbListView.b();
        this.G.o(R.color.CAM_X0204);
        this.G.r(l.g(this.f28410b, R.dimen.tbds182));
        this.G.v();
        this.G.E(R.dimen.tbfontsize33);
        this.G.C(SkinManager.getColor(R.color.CAM_X0107));
        this.G.y(R.color.CAM_X0110);
        this.G.q();
        this.H = (NoNetworkView) this.f28418j.findViewById(R.id.no_network_view);
    }

    public void A(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z || this.f28411c != i2) {
                this.f28411c = i2;
                h hVar = this.J;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                SkinManager.setBackgroundColor(this.f28418j, R.color.CAM_X0201, i2);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i2);
                NavigationBar navigationBar = this.p;
                if (navigationBar != null) {
                    SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207, i2);
                    float f2 = this.f28414f;
                    if (f2 > 0.5d) {
                        SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i2);
                        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i2);
                        SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i2);
                    } else if (f2 <= 0.5d) {
                        c.a.r0.y.b.f fVar = this.f28416h;
                        if (fVar != null && fVar.a() != null && this.f28416h.a().g() <= 2 && this.f28416h.a().g() >= 1) {
                            SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg, i2);
                            SkinManager.setViewTextColor(this.r, R.color.CAM_X0101, 1, i2);
                            SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0101, 1, i2);
                        } else {
                            SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i2);
                            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i2);
                            SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i2);
                        }
                    }
                    SkinManager.setBackgroundResource(this.q, R.drawable.top_view_shadow, i2);
                }
                SkinManager.setImageResource(this.m, R.drawable.pic_bg_recruit, i2);
                this.t.onSkinChange(i2);
                this.x.onSkinChange(i2);
                this.B.onSkinChange(i2);
                SkinManager.setBackgroundResource(this.y, R.drawable.bar_select_bg_shadow_and_radius, i2);
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
                SelectRuleView selectRuleView = this.A;
                if (selectRuleView != null) {
                    selectRuleView.onSkinTypeChange(i2);
                }
                SkinManager.setViewTextColor(this.E, R.color.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0108, 1, i2);
                SkinManager.setBackgroundResource(this.w, R.drawable.icon_common_explain12_gray66, i2);
                this.D.onSkinChange(i2);
                PbListView pbListView = this.G;
                if (pbListView != null) {
                    pbListView.C(SkinManager.getColor(i2, R.color.CAM_X0107));
                    this.G.d(i2);
                }
                this.H.onChangeSkinType(this.f28410b.getPageContext(), i2);
                VoteAdapter voteAdapter = this.C;
                if (voteAdapter != null) {
                    voteAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f28412d == c.a.r0.y.e.c.f28496c) {
                this.G.J(l.g(this.f28410b, R.dimen.tbds152));
            }
            this.G.z(this.f28410b);
            this.s.setNextPage(this.G);
            if (this.N) {
                this.G.K();
                return;
            }
            this.G.A(this.f28410b.getResources().getString(R.string.list_has_no_more));
            this.G.f();
        }
    }

    public void C(c.a.r0.y.b.f fVar) {
        c.a.r0.y.b.e a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || fVar == null) {
            return;
        }
        this.N = fVar.d();
        if (fVar.a() != null && (a2 = fVar.a()) != null) {
            int g2 = a2.g();
            this.f28412d = g2;
            if (g2 == c.a.r0.y.e.c.f28496c) {
                this.B.setVisibility(8);
                this.E.setVisibility(8);
                this.x.setVisibility(8);
            }
            NoticeContent e2 = a2.e();
            if (e2 != null && !TextUtils.isEmpty(e2.public_notice)) {
                G(e2.public_notice + "占");
            } else {
                G(this.f28410b.getResources().getString(R.string.vote_ueg_tip) + "占");
            }
        }
        this.t.setData(fVar);
        VoteAdapter voteAdapter = this.C;
        if (voteAdapter != null) {
            this.f28416h = fVar;
            voteAdapter.setVoteData(fVar);
        }
        int i2 = this.f28412d;
        if (i2 == c.a.r0.y.e.c.f28496c) {
            this.D.setVisibility(0);
            this.D.setData(fVar);
            this.u.setVisibility(0);
            this.y.setVisibility(8);
        } else if (i2 == c.a.r0.y.e.c.f28495b) {
            this.x.setData(VoteCandidateCard.MINE_VOTE, fVar);
            this.D.setVisibility(8);
            this.u.setVisibility(8);
            this.B.setRank(fVar.a().b());
            if (fVar.e() != null) {
                ManagerElection e3 = fVar.e();
                if (ListUtils.isEmpty(e3.vote_condition_pic) && ListUtils.isEmpty(e3.vote_condition_title) && ListUtils.isEmpty(e3.vote_condition)) {
                    this.y.setVisibility(8);
                } else {
                    this.y.setVisibility(0);
                    this.A.setData(e3.vote_condition_pic, e3.vote_condition_title, e3.vote_condition);
                }
            } else {
                this.y.setVisibility(8);
            }
        } else {
            this.D.setVisibility(8);
            this.u.setVisibility(8);
            this.y.setVisibility(8);
        }
        B();
        A(TbadkCoreApplication.getInst().getSkinType(), true);
    }

    public void D(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.L = onClickListener;
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdRecyclerView bdRecyclerView = this.s;
            if (bdRecyclerView != null) {
                bdRecyclerView.setVisibility(8);
            }
            this.f28410b.hideLoadingView(w());
            if (this.I != null) {
                x();
            }
            if (this.J == null) {
                this.J = new h(this.f28410b, this.M);
            }
            this.J.j(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds340));
            this.J.l(TbadkCoreApplication.getInst().getString(R.string.neterror));
            this.J.attachView(this.k, true);
            this.J.o();
            this.J.onChangeSkinType();
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            h hVar = this.J;
            if (hVar != null) {
                hVar.dettachView(this.k);
                this.J = null;
            }
            this.f28410b.hideLoadingView(w());
            if (this.I == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f28410b, this.K, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.e.c(str), null);
                this.I = a2;
                a2.setOnClickListener(this.L);
            }
            this.I.setTextOption(NoDataViewFactory.e.c(str));
            this.I.onChangeSkinType(this.f28410b.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.I.setVisibility(0);
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_common_explain12_gray66);
            drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
            c.a.e.l.b bVar = new c.a.e.l.b(drawable, 0);
            bVar.b(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
            spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
            this.v.setText(spannableString);
        }
    }

    public BdRecyclerView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : (BdRecyclerView) invokeV.objValue;
    }

    public PbListView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.G : (PbListView) invokeV.objValue;
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28418j : (View) invokeV.objValue;
    }

    public void x() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (noDataView = this.I) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public void y() {
        VoteStatusCard voteStatusCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (voteStatusCard = this.t) == null) {
            return;
        }
        voteStatusCard.onDestroy();
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            A(i2, false);
        }
    }
}
