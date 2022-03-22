package c.a.p0.e0;

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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.f0.h;
import c.a.o0.r.t.a;
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
import tbclient.ElectionInfo.NoticeContent;
import tbclient.ManagerElection;
/* loaded from: classes2.dex */
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
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public BarVoteActivity f13708b;

    /* renamed from: c  reason: collision with root package name */
    public int f13709c;

    /* renamed from: d  reason: collision with root package name */
    public int f13710d;

    /* renamed from: e  reason: collision with root package name */
    public int f13711e;

    /* renamed from: f  reason: collision with root package name */
    public float f13712f;

    /* renamed from: g  reason: collision with root package name */
    public int f13713g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.e0.b.f f13714h;
    public LinearLayoutManager i;
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

    /* renamed from: c.a.p0.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1033a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1033a(a aVar) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A()) {
                if (this.a.J != null) {
                    this.a.J.dettachView(this.a.k);
                    this.a.J = null;
                }
                this.a.f13708b.reload();
                if (this.a.s != null) {
                    this.a.s.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements VoteStatusCard.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.b
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f13708b == null) {
                return;
            }
            this.a.f13708b.refresh();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                this.a.f13713g = i;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if ((this.a.f13713g != 1 && this.a.f13713g != 2) || this.a.l == null || this.a.p == null || this.a.p.getBarBgView() == null || this.a.p.getBackImageView() == null) {
                    return;
                }
                a aVar = this.a;
                aVar.f13712f = Math.abs(aVar.l.getTop()) / this.a.a;
                this.a.p.getBarBgView().setAlpha(this.a.f13712f);
                this.a.q.setAlpha(this.a.f13712f);
                if (this.a.f13712f > 0.5d) {
                    if (this.a.f13711e == 0) {
                        SkinManager.setImageResource(this.a.p.getBackImageView(), R.drawable.icon_return_bg_s, this.a.f13709c);
                        SkinManager.setViewTextColor(this.a.r, R.color.CAM_X0105, 1, this.a.f13709c);
                        SkinManager.setViewTextColor(this.a.p.mCenterText, R.color.CAM_X0105, 1, this.a.f13709c);
                        this.a.f13711e = 1;
                    }
                    this.a.p.getBackImageView().setAlpha((this.a.f13712f * 2.0f) - 1.0f);
                    this.a.r.setAlpha((this.a.f13712f * 2.0f) - 1.0f);
                    this.a.p.mCenterText.setAlpha((this.a.f13712f * 2.0f) - 1.0f);
                } else if (this.a.f13712f <= 0.5d) {
                    if (this.a.f13711e == 1) {
                        SkinManager.setImageResource(this.a.p.getBackImageView(), R.drawable.icon_return_bg, this.a.f13709c);
                        SkinManager.setViewTextColor(this.a.r, R.color.CAM_X0101, 1, this.a.f13709c);
                        SkinManager.setViewTextColor(this.a.p.mCenterText, R.color.CAM_X0101, 1, this.a.f13709c);
                        this.a.f13711e = 0;
                    }
                    this.a.p.getBackImageView().setAlpha(1.0f - (this.a.f13712f * 2.0f));
                    this.a.r.setAlpha(1.0f - (this.a.f13712f * 2.0f));
                    this.a.p.mCenterText.setAlpha(1.0f - (this.a.f13712f * 2.0f));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.s != null) {
                    this.a.s.stopScroll();
                }
                if (this.a.G == null || this.a.f13708b == null) {
                    return;
                }
                if (l.z()) {
                    if (this.a.f13710d == c.a.p0.e0.e.c.f13761c) {
                        this.a.G.M(n.f(this.a.f13708b, R.dimen.tbds152));
                    }
                    this.a.s.setNextPage(this.a.G);
                    this.a.G.C(null);
                    if (this.a.N) {
                        this.a.G.O();
                        this.a.f13708b.loadmore();
                        return;
                    }
                    this.a.G.D(this.a.f13708b.getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                    this.a.G.f();
                    return;
                }
                this.a.s.setNextPage(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.p0.e0.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1034a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1034a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
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
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.f13708b);
                View inflate = LayoutInflater.from(this.a.f13708b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0140, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090342);
                textView.setText(this.a.f13708b.getResources().getString(R.string.obfuscated_res_0x7f0f153e) + "\n" + this.a.f13708b.getResources().getString(R.string.obfuscated_res_0x7f0f153f));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.setContentView(inflate);
                aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new C1034a(this));
                aVar.create(this.a.f13708b.getPageContext());
                SkinManager.setBackgroundShapeDrawable(aVar.getRealView(), n.f(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                aVar.show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BarVoteActivity barVoteActivity = this.a.f13708b;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(barVoteActivity, this.a.f13708b.fid + "")));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13709c = 3;
        this.f13710d = -1;
        this.f13711e = 0;
        this.f13712f = 0.0f;
        this.M = new View$OnClickListenerC1033a(this);
        this.O = new b(this);
        this.P = new c(this);
        this.Q = new d(this);
        this.f13708b = barVoteActivity;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(barVoteActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d013f, (ViewGroup) null);
        this.j = relativeLayout;
        this.f13708b.addContentView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        BarVoteActivity barVoteActivity2 = this.f13708b;
        barVoteActivity2.showLoadingView(this.j, false, n.f(barVoteActivity2, R.dimen.obfuscated_res_0x7f0702b0));
        this.k = this.j.findViewById(R.id.obfuscated_res_0x7f09127b);
        this.K = (ViewGroup) this.j.findViewById(R.id.obfuscated_res_0x7f091581);
        this.o = this.j.findViewById(R.id.obfuscated_res_0x7f0914f4);
        View findViewById = this.j.findViewById(R.id.obfuscated_res_0x7f0914f5);
        this.q = findViewById;
        findViewById.setAlpha(0.0f);
        NavigationBar navigationBar = (NavigationBar) this.j.findViewById(R.id.obfuscated_res_0x7f092427);
        this.p = navigationBar;
        navigationBar.setCenterTextTitle(this.f13708b.getResources().getString(R.string.obfuscated_res_0x7f0f02d6));
        if (this.p.getBarBgView() != null) {
            this.p.getBarBgView().setAlpha(0.0f);
        }
        this.a = n.f(this.f13708b, R.dimen.tbds402);
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView textView = (TextView) this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05e4, this.f13708b).findViewById(R.id.obfuscated_res_0x7f091ab8);
        this.r = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f02cd);
        this.r.setOnClickListener(this.f13708b);
        this.s = (BdRecyclerView) this.j.findViewById(R.id.obfuscated_res_0x7f092425);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f13708b);
        this.i = linearLayoutManager;
        this.s.setLayoutManager(linearLayoutManager);
        VoteAdapter voteAdapter = new VoteAdapter(barVoteActivity.getPageContext());
        this.C = voteAdapter;
        this.s.setAdapter(voteAdapter);
        this.l = (ViewGroup) LayoutInflater.from(this.f13708b).inflate(R.layout.obfuscated_res_0x7f0d08b7, (ViewGroup) null, false);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.m = (TbImageView) this.l.findViewById(R.id.obfuscated_res_0x7f090d22);
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, (n.k(this.f13708b) * 884) / 1076));
        this.s.s(this.l);
        this.s.addOnScrollListener(this.P);
        this.s.setOnSrollToBottomListener(this.Q);
        this.F = this.f13708b.getResources().getDimensionPixelSize(R.dimen.tbds134);
        View view = new View(this.f13708b);
        this.n = view;
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.F));
        this.n.setVisibility(4);
        this.s.r(this.n);
        this.t = (VoteStatusCard) this.l.findViewById(R.id.obfuscated_res_0x7f09242b);
        View findViewById2 = this.l.findViewById(R.id.obfuscated_res_0x7f092437);
        this.u = findViewById2;
        findViewById2.setOnClickListener(new e(this));
        this.v = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f092439);
        this.w = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f092438);
        this.t.setOnRefreshListener(this.O);
        this.y = this.l.findViewById(R.id.obfuscated_res_0x7f090320);
        this.z = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f090324);
        SelectRuleView selectRuleView = (SelectRuleView) this.l.findViewById(R.id.obfuscated_res_0x7f090321);
        this.A = selectRuleView;
        selectRuleView.setType(1);
        this.x = (VoteCandidateCard) this.l.findViewById(R.id.obfuscated_res_0x7f09241b);
        SearchView searchView = (SearchView) this.l.findViewById(R.id.obfuscated_res_0x7f092429);
        this.B = searchView;
        searchView.a(new f(this));
        this.D = (FloatMyRecordCard) this.j.findViewById(R.id.obfuscated_res_0x7f0909d1);
        this.E = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f092433);
        PbListView pbListView = new PbListView(this.f13708b);
        this.G = pbListView;
        pbListView.b();
        this.G.p(R.color.CAM_X0204);
        this.G.t(n.f(this.f13708b, R.dimen.tbds182));
        this.G.y();
        this.G.H(R.dimen.tbfontsize33);
        this.G.F(SkinManager.getColor(R.color.CAM_X0107));
        this.G.B(R.color.CAM_X0110);
        this.G.s();
        this.H = (NoNetworkView) this.j.findViewById(R.id.obfuscated_res_0x7f09159c);
    }

    public void A(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z || this.f13709c != i) {
                this.f13709c = i;
                h hVar = this.J;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201, i);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i);
                NavigationBar navigationBar = this.p;
                if (navigationBar != null) {
                    SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207, i);
                    float f2 = this.f13712f;
                    if (f2 > 0.5d) {
                        SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
                        SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i);
                    } else if (f2 <= 0.5d) {
                        c.a.p0.e0.b.f fVar = this.f13714h;
                        if (fVar != null && fVar.a() != null && this.f13714h.a().g() <= 2 && this.f13714h.a().g() >= 1) {
                            SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg, i);
                            SkinManager.setViewTextColor(this.r, R.color.CAM_X0101, 1, i);
                            SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0101, 1, i);
                        } else {
                            SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i);
                            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
                            SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i);
                        }
                    }
                    SkinManager.setBackgroundResource(this.q, R.drawable.top_view_shadow, i);
                }
                SkinManager.setImageResource(this.m, R.drawable.pic_bg_recruit, i);
                this.t.f(i);
                this.x.c(i);
                this.B.d(i);
                SkinManager.setBackgroundResource(this.y, R.drawable.bar_select_bg_shadow_and_radius, i);
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0105);
                SelectRuleView selectRuleView = this.A;
                if (selectRuleView != null) {
                    selectRuleView.d(i);
                }
                SkinManager.setViewTextColor(this.E, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0108, 1, i);
                SkinManager.setBackgroundResource(this.w, R.drawable.icon_common_explain12_gray66, i);
                this.D.d(i);
                PbListView pbListView = this.G;
                if (pbListView != null) {
                    pbListView.F(SkinManager.getColor(i, (int) R.color.CAM_X0107));
                    this.G.d(i);
                }
                this.H.c(this.f13708b.getPageContext(), i);
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
            if (this.f13710d == c.a.p0.e0.e.c.f13761c) {
                this.G.M(n.f(this.f13708b, R.dimen.tbds152));
            }
            this.G.C(this.f13708b);
            this.s.setNextPage(this.G);
            if (this.N) {
                this.G.N();
                return;
            }
            this.G.D(this.f13708b.getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
            this.G.f();
        }
    }

    public void C(c.a.p0.e0.b.f fVar) {
        c.a.p0.e0.b.e a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || fVar == null) {
            return;
        }
        this.N = fVar.d();
        if (fVar.a() != null && (a = fVar.a()) != null) {
            int g2 = a.g();
            this.f13710d = g2;
            if (g2 == c.a.p0.e0.e.c.f13761c) {
                this.B.setVisibility(8);
                this.E.setVisibility(8);
                this.x.setVisibility(8);
            }
            NoticeContent e2 = a.e();
            if (e2 != null && !TextUtils.isEmpty(e2.public_notice)) {
                G(e2.public_notice + "占");
            } else {
                G(this.f13708b.getResources().getString(R.string.obfuscated_res_0x7f0f153d) + "占");
            }
        }
        this.t.setData(fVar);
        VoteAdapter voteAdapter = this.C;
        if (voteAdapter != null) {
            this.f13714h = fVar;
            voteAdapter.g(fVar);
        }
        int i = this.f13710d;
        if (i == c.a.p0.e0.e.c.f13761c) {
            this.D.setVisibility(0);
            this.D.setData(fVar);
            this.u.setVisibility(0);
            this.y.setVisibility(8);
        } else if (i == c.a.p0.e0.e.c.f13760b) {
            this.x.setData(VoteCandidateCard.A, fVar);
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
            this.f13708b.hideLoadingView(w());
            if (this.I != null) {
                x();
            }
            if (this.J == null) {
                this.J = new h(this.f13708b, this.M);
            }
            this.J.k(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds340));
            this.J.m(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c15));
            this.J.attachView(this.k, true);
            this.J.p();
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
            this.f13708b.hideLoadingView(w());
            if (this.I == null) {
                NoDataView a = NoDataViewFactory.a(this.f13708b, this.K, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.e.c(str), null);
                this.I = a;
                a.setOnClickListener(this.L);
            }
            this.I.setTextOption(NoDataViewFactory.e.c(str));
            this.I.f(this.f13708b.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.I.setVisibility(0);
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_common_explain12_gray66);
            drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
            c.a.d.o.b bVar = new c.a.d.o.b(drawable, 0);
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
        voteStatusCard.e();
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            A(i, false);
        }
    }
}
