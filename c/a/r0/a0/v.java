package c.a.r0.a0;

import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.e2;
import c.a.q0.s.q.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class v extends c.a.r0.a0.b<e2> implements Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public TbImageView B;
    public String C;
    public String D;
    public String E;
    public View F;
    public ViewGroup G;
    public final View.OnClickListener H;
    public OriginalThreadCardView.b I;
    public HeadPendantClickableView m;
    public ThreadUserInfoLayout n;
    public TextView o;
    public TextView p;
    public OriginalThreadCardView q;
    public ThreadCommentAndPraiseInfoLayout r;
    public ThreadSourceShareAndPraiseLayout s;
    public NEGFeedBackView t;
    public View u;
    public View v;
    public TbImageView w;
    public TbPageContext<?> x;
    public e2 y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f15688e;

        public a(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15688e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f15688e.g() != null) {
                    this.f15688e.g().a(view, this.f15688e.y);
                }
                if (this.f15688e.y == null || this.f15688e.y.f14161e == null) {
                    return;
                }
                m.a(this.f15688e.y.f14161e.f0());
                v vVar = this.f15688e;
                vVar.B(vVar.y.f14161e.f0());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f15689e;

        public b(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15689e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f15689e.g() != null) {
                    this.f15689e.g().a(view, this.f15689e.y);
                }
                v vVar = this.f15689e;
                if (view == vVar.s.mForumNameView || vVar.y == null || this.f15689e.y.f14161e == null) {
                    return;
                }
                m.a(this.f15689e.y.f14161e.f0());
                v vVar2 = this.f15689e;
                vVar2.B(vVar2.y.f14161e.f0());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f15690e;

        public c(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15690e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15690e.r.changeSelectStatus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f15691a;

        public d(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15691a = vVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                SkinManager.setBackgroundColor(this.f15691a.F, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d2 f15692e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ v f15693f;

        public e(v vVar, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15693f = vVar;
            this.f15692e = d2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f15693f.x != null) {
                    this.f15693f.f15549f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.f15693f.f15549f.getContext(), "", this.f15692e.A1, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f15694e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ v f15695f;

        public f(v vVar, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15695f = vVar;
            this.f15694e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f15695f.x.getPageActivity(), this.f15694e.getCardId())));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f15696e;

        public g(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15696e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15696e.g() == null) {
                return;
            }
            this.f15696e.g().a(view, this.f15696e.y);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f15697a;

        public h(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15697a = vVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || this.f15697a.y == null || this.f15697a.y.f14161e == null) {
                return;
            }
            if (this.f15697a.g() != null) {
                b0<e2> g2 = this.f15697a.g();
                v vVar = this.f15697a;
                g2.a(vVar.q, vVar.y);
            }
            String f0 = this.f15697a.y.f14161e.f0();
            m.a(f0);
            this.f15697a.B(f0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.z = true;
        this.H = new g(this);
        this.I = new h(this);
        this.x = tbPageContext;
        View j2 = j();
        ViewGroup viewGroup = (ViewGroup) j2.findViewById(R.id.thread_content_layout_outter);
        this.G = viewGroup;
        viewGroup.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) j2.findViewById(R.id.thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setRadius(c.a.e.e.p.l.g(this.x.getPageActivity(), R.dimen.ds70));
            this.m.getHeadView().setPlaceHolder(1);
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.n = (ThreadUserInfoLayout) j2.findViewById(R.id.thread_user_info_layout);
        this.t = new NEGFeedBackView(this.x);
        this.t.attachToViewUpperRightConner((ViewGroup) j(), c.a.e.e.p.l.g(this.f15550g, R.dimen.tbds92), c.a.e.e.p.l.g(d(), R.dimen.tbds16));
        this.o = (TextView) j2.findViewById(R.id.thread_title);
        this.p = (TextView) j2.findViewById(R.id.thread_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) j2.findViewById(R.id.original_thread_view);
        this.q = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.I);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) j2.findViewById(R.id.thread_comment_layout);
        this.r = threadCommentAndPraiseInfoLayout;
        if (threadCommentAndPraiseInfoLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.r.setLayoutParams(layoutParams);
        }
        j2.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.r.setReplyTimeVisible(false);
        this.r.setShowPraiseNum(true);
        this.r.setNeedAddPraiseIcon(true);
        this.r.setNeedAddReplyIcon(true);
        this.r.setShareVisible(true);
        this.r.setForumAfterClickListener(new a(this));
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) j2.findViewById(R.id.card_transmit_source_read_share_layout);
        this.s = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this);
        this.s.mSharePraiseView.setNeedAddReplyIcon(true);
        this.s.setForumAfterClickListener(new b(this));
        this.u = j2.findViewById(R.id.divider_line_above_praise);
        this.v = j2.findViewById(R.id.card_divider_line);
        this.w = (TbImageView) j2.findViewById(R.id.thread_theme_card);
        this.B = (TbImageView) j2.findViewById(R.id.frs_normal_item_star_view);
        View findViewById = j2.findViewById(R.id.thread_multi_del_mask_view);
        this.F = findViewById;
        findViewById.setOnClickListener(new c(this));
        this.r.setOnSelectStatusChangeListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: A */
    public void k(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) {
            if (e2Var != null && e2Var.f14161e != null) {
                if (j() != null) {
                    j().setVisibility(0);
                }
                this.y = e2Var;
                d2 d2Var = e2Var.f14161e;
                if (this.t != null) {
                    SparseArray<String> S = d2Var.S();
                    if (S != null && S.size() > 0 && this.z) {
                        x0 x0Var = new x0();
                        x0Var.p(d2Var.s1());
                        x0Var.l(d2Var.T());
                        x0Var.o(d2Var.F0());
                        x0Var.k(S);
                        x0Var.f14351g = d2Var.k1;
                        this.t.setData(x0Var);
                        this.t.setFirstRowSingleColumn(true);
                        this.t.setVisibility(y(d2Var) ? 8 : 0);
                    } else {
                        this.t.setVisibility(8);
                    }
                }
                if (this.y.f14164h == 1) {
                    this.n.setFrom(3);
                    x(d2Var);
                    P(d2Var);
                }
                this.n.setIsFromConcern(this.A);
                this.n.setData(d2Var);
                this.n.setUserAfterClickListener(this.H);
                if (this.n.getHeaderImg() != null) {
                    if (this.n.getIsSimpleThread()) {
                        this.n.getHeaderImg().setVisibility(8);
                        this.m.setVisibility(8);
                    } else if (d2Var.J() != null && d2Var.J().getPendantData() != null && !StringUtils.isNull(d2Var.J().getPendantData().getImgUrl())) {
                        this.n.getHeaderImg().setVisibility(4);
                        this.m.setVisibility(0);
                        this.m.setData(d2Var);
                    } else {
                        this.m.setVisibility(8);
                        this.n.getHeaderImg().setVisibility(0);
                        this.n.getHeaderImg().setData(d2Var);
                    }
                }
                N(d2Var);
                this.q.fillData(d2Var.x1);
                O(u(1));
                L(h());
                l(this.x, TbadkCoreApplication.getInst().getSkinType());
                B(d2Var.f0());
                if (this.r.isInFrsAllThread() && (c.a.r0.w0.b.f().i() || c.a.r0.w0.a.h().j())) {
                    this.F.setVisibility(0);
                    if (!d2Var.j2() && !d2Var.k2() && !d2Var.C2()) {
                        this.F.setBackgroundResource(R.color.transparent);
                        return;
                    } else {
                        SkinManager.setBackgroundColor(this.F, R.color.CAM_X0201);
                        return;
                    }
                }
                this.F.setVisibility(8);
            } else if (j() != null) {
                j().setVisibility(8);
            }
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            m.l(this.o, str, R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(this.p, str, R.color.CAM_X0105, R.color.CAM_X0109);
            this.q.setReadState(m.k(str));
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        L(bdUniqueId);
    }

    public void J(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (view = this.v) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.z = z;
        }
    }

    public final void L(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            n(bdUniqueId);
            NEGFeedBackView nEGFeedBackView = this.t;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setUniqueId(bdUniqueId);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public final void N(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, d2Var) == null) || d2Var == null) {
            return;
        }
        if (!StringUtils.isNull(this.C) && !StringUtils.isNull(this.E)) {
            d2Var.w4(this.C, this.E);
        }
        SpannableStringBuilder V2 = d2Var.V2(false, true);
        if (V2 != null && !StringUtils.isNull(V2.toString())) {
            this.o.setVisibility(0);
            this.o.setOnTouchListener(new c.a.r0.b4.h(V2));
            this.o.setText(V2);
            m.l(this.o, d2Var.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        this.o.setVisibility(8);
    }

    public void O(int i2) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (e2Var = this.y) == null || e2Var.f14161e == null) {
            return;
        }
        if (i2 == 1) {
            this.r.setVisibility(8);
            this.s.setFrom(this.y.f14163g);
            this.s.setShareReportFrom(this.y.f14164h);
            this.s.setStType(this.y.f14162f);
            this.s.setData(this.y.f14161e);
            this.n.showForumNameView(false);
            return;
        }
        this.r.setFrom(e2Var.f14163g);
        this.r.setShareReportFrom(this.y.f14164h);
        this.r.setStType(this.y.f14162f);
        this.r.setData(this.y.f14161e);
        this.r.setDisPraiseFrom(this.y.f14165i);
        this.s.setVisibility(8);
        this.n.showForumNameView(true);
    }

    public final void P(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d2Var) == null) || this.B == null) {
            return;
        }
        if (this.w != null && d2Var != null) {
            if (!StringUtils.isNull(d2Var.z1) && this.w.getVisibility() != 0) {
                NEGFeedBackView nEGFeedBackView = this.t;
                if (nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0 && (this.B.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                    layoutParams.rightMargin = c.a.e.e.p.l.g(this.x.getPageActivity(), R.dimen.tbds106);
                    this.B.setLayoutParams(layoutParams);
                }
                this.B.setVisibility(0);
                this.B.setImageDrawable(null);
                this.B.startLoad(d2Var.z1, 10, false);
                this.B.setOnClickListener(new e(this, d2Var));
                return;
            }
            this.B.setVisibility(8);
            return;
        }
        this.B.setVisibility(8);
    }

    @Override // c.a.r0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.layout.card_transmit_thread_view : invokeV.intValue;
    }

    @Override // c.a.r0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, tbPageContext, i2) == null) {
            if (this.f15548e != i2) {
                SkinManager.setBackgroundResource(j(), R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
                this.r.onChangeSkinType();
                this.n.onChangeSkinType();
                NEGFeedBackView nEGFeedBackView = this.t;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.onChangeSkinType();
                }
                this.q.onChangeSkinType();
                SkinManager.setBackgroundColor(this.v, R.color.CAM_X0205);
                this.s.onChangeSkinType();
            }
            e2 e2Var = this.y;
            if (e2Var != null && (d2Var = e2Var.f14161e) != null) {
                SkinManager.setBackgroundColor(this.F, (d2Var.j2() || this.y.f14161e.k2()) ? R.color.CAM_X0201 : R.color.transparent);
            }
            HeadPendantClickableView headPendantClickableView = this.m;
            if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.m.getHeadView() instanceof TbImageView)) {
                this.m.getHeadView().setPlaceHolder(1);
            }
            this.f15548e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            if (g() != null) {
                g().a(view, this.y);
            }
            if (view == j() || view.getId() == R.id.thread_content_layout_outter) {
                z();
            }
        }
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.D = str;
        }
    }

    public int u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? c.a.r0.o.d.c().b(this.D, i2) : invokeI.intValue;
    }

    public ClickableHeaderImageView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                return threadUserInfoLayout.mHeaderImg;
            }
            return null;
        }
        return (ClickableHeaderImageView) invokeV.objValue;
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                return threadUserInfoLayout.mUsername;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void x(d2 d2Var) {
        MetaData J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, d2Var) == null) || d2Var == null || this.w == null || (J = d2Var.J()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = J.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
            this.w.setVisibility(0);
            this.w.setImageBitmap(null);
            this.w.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.w.setOnClickListener(new f(this, themeCard));
            return;
        }
        this.w.setVisibility(8);
    }

    public final boolean y(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, d2Var)) == null) {
            if (d2Var == null || d2Var.J() == null || StringUtils.isNull(d2Var.J().getUserId())) {
                return false;
            }
            return d2Var.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
        }
        return invokeL.booleanValue;
    }

    public final void z() {
        e2 e2Var;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (e2Var = this.y) == null || (d2Var = e2Var.f14161e) == null) {
            return;
        }
        m.a(d2Var.f0());
        B(d2Var.f0());
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.x.getPageActivity()).createFromThreadCfg(d2Var, null, this.y.f14162f, 18003, true, false, false);
        createFromThreadCfg.setStartFrom(this.l);
        createFromThreadCfg.setIsShareThread(true);
        m.a(d2Var.s1());
        this.x.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }
}
