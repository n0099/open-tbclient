package b.a.r0.y;

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
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.q0.g0.h;
import b.a.q0.s.s.a;
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
/* loaded from: classes6.dex */
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
    public int f28646a;

    /* renamed from: b  reason: collision with root package name */
    public BarVoteActivity f28647b;

    /* renamed from: c  reason: collision with root package name */
    public int f28648c;

    /* renamed from: d  reason: collision with root package name */
    public int f28649d;

    /* renamed from: e  reason: collision with root package name */
    public int f28650e;

    /* renamed from: f  reason: collision with root package name */
    public float f28651f;

    /* renamed from: g  reason: collision with root package name */
    public int f28652g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.y.b.f f28653h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f28654i;
    public RelativeLayout j;
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

    /* renamed from: b.a.r0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1403a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28655e;

        public View$OnClickListenerC1403a(a aVar) {
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
            this.f28655e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                if (this.f28655e.J != null) {
                    this.f28655e.J.dettachView(this.f28655e.k);
                    this.f28655e.J = null;
                }
                this.f28655e.f28647b.reload();
                if (this.f28655e.s != null) {
                    this.f28655e.s.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements VoteStatusCard.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28656a;

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
            this.f28656a = aVar;
        }

        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.b
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28656a.f28647b == null) {
                return;
            }
            this.f28656a.f28647b.refresh();
        }
    }

    /* loaded from: classes6.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28657a;

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
            this.f28657a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                this.f28657a.f28652g = i2;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if ((this.f28657a.f28652g != 1 && this.f28657a.f28652g != 2) || this.f28657a.l == null || this.f28657a.p == null || this.f28657a.p.getBarBgView() == null || this.f28657a.p.getBackImageView() == null) {
                    return;
                }
                a aVar = this.f28657a;
                aVar.f28651f = Math.abs(aVar.l.getTop()) / this.f28657a.f28646a;
                this.f28657a.p.getBarBgView().setAlpha(this.f28657a.f28651f);
                this.f28657a.q.setAlpha(this.f28657a.f28651f);
                if (this.f28657a.f28651f > 0.5d) {
                    if (this.f28657a.f28650e == 0) {
                        SkinManager.setImageResource(this.f28657a.p.getBackImageView(), R.drawable.icon_return_bg_s, this.f28657a.f28648c);
                        SkinManager.setViewTextColor(this.f28657a.r, R.color.CAM_X0105, 1, this.f28657a.f28648c);
                        SkinManager.setViewTextColor(this.f28657a.p.mCenterText, R.color.CAM_X0105, 1, this.f28657a.f28648c);
                        this.f28657a.f28650e = 1;
                    }
                    this.f28657a.p.getBackImageView().setAlpha((this.f28657a.f28651f * 2.0f) - 1.0f);
                    this.f28657a.r.setAlpha((this.f28657a.f28651f * 2.0f) - 1.0f);
                    this.f28657a.p.mCenterText.setAlpha((this.f28657a.f28651f * 2.0f) - 1.0f);
                } else if (this.f28657a.f28651f <= 0.5d) {
                    if (this.f28657a.f28650e == 1) {
                        SkinManager.setImageResource(this.f28657a.p.getBackImageView(), R.drawable.icon_return_bg, this.f28657a.f28648c);
                        SkinManager.setViewTextColor(this.f28657a.r, R.color.CAM_X0101, 1, this.f28657a.f28648c);
                        SkinManager.setViewTextColor(this.f28657a.p.mCenterText, R.color.CAM_X0101, 1, this.f28657a.f28648c);
                        this.f28657a.f28650e = 0;
                    }
                    this.f28657a.p.getBackImageView().setAlpha(1.0f - (this.f28657a.f28651f * 2.0f));
                    this.f28657a.r.setAlpha(1.0f - (this.f28657a.f28651f * 2.0f));
                    this.f28657a.p.mCenterText.setAlpha(1.0f - (this.f28657a.f28651f * 2.0f));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28658e;

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
            this.f28658e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f28658e.s != null) {
                    this.f28658e.s.stopScroll();
                }
                if (this.f28658e.G == null || this.f28658e.f28647b == null) {
                    return;
                }
                if (j.z()) {
                    if (this.f28658e.f28649d == b.a.r0.y.e.c.f28729c) {
                        this.f28658e.G.L(l.g(this.f28658e.f28647b, R.dimen.tbds152));
                    }
                    this.f28658e.s.setNextPage(this.f28658e.G);
                    this.f28658e.G.B(null);
                    if (this.f28658e.N) {
                        this.f28658e.G.N();
                        this.f28658e.f28647b.loadmore();
                        return;
                    }
                    this.f28658e.G.C(this.f28658e.f28647b.getResources().getString(R.string.list_has_no_more));
                    this.f28658e.G.f();
                    return;
                }
                this.f28658e.s.setNextPage(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28659e;

        /* renamed from: b.a.r0.y.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1404a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1404a(e eVar) {
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

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
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
            this.f28659e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f28659e.f28647b);
                View inflate = LayoutInflater.from(this.f28659e.f28647b.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(this.f28659e.f28647b.getResources().getString(R.string.vote_ueg_tip_detail_1) + StringUtils.LF + this.f28659e.f28647b.getResources().getString(R.string.vote_ueg_tip_detail_2));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.setContentView(inflate);
                aVar.setNegativeButton(R.string.know, new C1404a(this));
                aVar.create(this.f28659e.f28647b.getPageContext());
                ViewGroup realView = aVar.getRealView();
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int i2 = R.color.CAM_X0201;
                SkinManager.setBackgroundShapeDrawable(realView, g2, i2, i2);
                aVar.show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28660e;

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
            this.f28660e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BarVoteActivity barVoteActivity = this.f28660e.f28647b;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(barVoteActivity, this.f28660e.f28647b.fid + "")));
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
        this.f28648c = 3;
        this.f28649d = -1;
        this.f28650e = 0;
        this.f28651f = 0.0f;
        this.M = new View$OnClickListenerC1403a(this);
        this.O = new b(this);
        this.P = new c(this);
        this.Q = new d(this);
        this.f28647b = barVoteActivity;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(barVoteActivity.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.j = relativeLayout;
        this.f28647b.addContentView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        BarVoteActivity barVoteActivity2 = this.f28647b;
        barVoteActivity2.showLoadingView(this.j, false, l.g(barVoteActivity2, R.dimen.ds400));
        this.k = this.j.findViewById(R.id.list_container);
        this.K = (ViewGroup) this.j.findViewById(R.id.no_data_container);
        this.o = this.j.findViewById(R.id.nav_bar_container);
        View findViewById = this.j.findViewById(R.id.nav_bar_shadow);
        this.q = findViewById;
        findViewById.setAlpha(0.0f);
        NavigationBar navigationBar = (NavigationBar) this.j.findViewById(R.id.vote_navigation_bar);
        this.p = navigationBar;
        navigationBar.setCenterTextTitle(this.f28647b.getResources().getString(R.string.bar_manager_recruit));
        if (this.p.getBarBgView() != null) {
            this.p.getBarBgView().setAlpha(0.0f);
        }
        this.f28646a = l.g(this.f28647b, R.dimen.tbds402);
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView textView = (TextView) this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f28647b).findViewById(R.id.right_textview);
        this.r = textView;
        textView.setText(R.string.bar_election_rule);
        this.r.setOnClickListener(this.f28647b);
        this.s = (BdRecyclerView) this.j.findViewById(R.id.vote_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f28647b);
        this.f28654i = linearLayoutManager;
        this.s.setLayoutManager(linearLayoutManager);
        VoteAdapter voteAdapter = new VoteAdapter(barVoteActivity.getPageContext());
        this.C = voteAdapter;
        this.s.setAdapter(voteAdapter);
        this.l = (ViewGroup) LayoutInflater.from(this.f28647b).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.m = (TbImageView) this.l.findViewById(R.id.head_main_iv);
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.k(this.f28647b) * 884) / 1076));
        this.s.addHeaderView(this.l);
        this.s.addOnScrollListener(this.P);
        this.s.setOnSrollToBottomListener(this.Q);
        this.F = this.f28647b.getResources().getDimensionPixelSize(R.dimen.tbds134);
        View view = new View(this.f28647b);
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
        this.D = (FloatMyRecordCard) this.j.findViewById(R.id.float_my_record_card);
        this.E = (TextView) this.l.findViewById(R.id.vote_tip);
        PbListView pbListView = new PbListView(this.f28647b);
        this.G = pbListView;
        pbListView.b();
        this.G.p(R.color.CAM_X0204);
        this.G.s(l.g(this.f28647b, R.dimen.tbds182));
        this.G.x();
        this.G.G(R.dimen.tbfontsize33);
        this.G.E(SkinManager.getColor(R.color.CAM_X0107));
        this.G.A(R.color.CAM_X0110);
        this.G.r();
        this.H = (NoNetworkView) this.j.findViewById(R.id.no_network_view);
    }

    public void A(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z || this.f28648c != i2) {
                this.f28648c = i2;
                h hVar = this.J;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201, i2);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i2);
                NavigationBar navigationBar = this.p;
                if (navigationBar != null) {
                    SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207, i2);
                    float f2 = this.f28651f;
                    if (f2 > 0.5d) {
                        SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i2);
                        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i2);
                        SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i2);
                    } else if (f2 <= 0.5d) {
                        b.a.r0.y.b.f fVar = this.f28653h;
                        if (fVar != null && fVar.a() != null && this.f28653h.a().g() <= 2 && this.f28653h.a().g() >= 1) {
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
                    pbListView.E(SkinManager.getColor(i2, R.color.CAM_X0107));
                    this.G.d(i2);
                }
                this.H.onChangeSkinType(this.f28647b.getPageContext(), i2);
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
            if (this.f28649d == b.a.r0.y.e.c.f28729c) {
                this.G.L(l.g(this.f28647b, R.dimen.tbds152));
            }
            this.G.B(this.f28647b);
            this.s.setNextPage(this.G);
            if (this.N) {
                this.G.M();
                return;
            }
            this.G.C(this.f28647b.getResources().getString(R.string.list_has_no_more));
            this.G.f();
        }
    }

    public void C(b.a.r0.y.b.f fVar) {
        b.a.r0.y.b.e a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || fVar == null) {
            return;
        }
        this.N = fVar.d();
        if (fVar.a() != null && (a2 = fVar.a()) != null) {
            int g2 = a2.g();
            this.f28649d = g2;
            if (g2 == b.a.r0.y.e.c.f28729c) {
                this.B.setVisibility(8);
                this.E.setVisibility(8);
                this.x.setVisibility(8);
            }
            NoticeContent e2 = a2.e();
            if (e2 != null && !TextUtils.isEmpty(e2.public_notice)) {
                G(e2.public_notice + "占");
            } else {
                G(this.f28647b.getResources().getString(R.string.vote_ueg_tip) + "占");
            }
        }
        this.t.setData(fVar);
        VoteAdapter voteAdapter = this.C;
        if (voteAdapter != null) {
            this.f28653h = fVar;
            voteAdapter.setVoteData(fVar);
        }
        int i2 = this.f28649d;
        if (i2 == b.a.r0.y.e.c.f28729c) {
            this.D.setVisibility(0);
            this.D.setData(fVar);
            this.u.setVisibility(0);
            this.y.setVisibility(8);
        } else if (i2 == b.a.r0.y.e.c.f28728b) {
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
            this.f28647b.hideLoadingView(w());
            if (this.I != null) {
                x();
            }
            if (this.J == null) {
                this.J = new h(this.f28647b, this.M);
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
            this.f28647b.hideLoadingView(w());
            if (this.I == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f28647b, this.K, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.e.c(str), null);
                this.I = a2;
                a2.setOnClickListener(this.L);
            }
            this.I.setTextOption(NoDataViewFactory.e.c(str));
            this.I.onChangeSkinType(this.f28647b.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.I.setVisibility(0);
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_common_explain12_gray66);
            drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
            b.a.e.m.b bVar = new b.a.e.m.b(drawable, 0);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (View) invokeV.objValue;
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
