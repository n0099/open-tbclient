package b.a.r0.b0;

import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.e2;
import b.a.q0.s.q.x0;
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
/* loaded from: classes4.dex */
public class x extends b.a.r0.b0.b<e2> implements Object {
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f16367e;

        public a(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16367e = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16367e.f() != null) {
                    this.f16367e.f().a(view, this.f16367e.y);
                }
                if (this.f16367e.y == null || this.f16367e.y.f14074e == null) {
                    return;
                }
                m.a(this.f16367e.y.f14074e.f0());
                x xVar = this.f16367e;
                xVar.A(xVar.y.f14074e.f0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f16368e;

        public b(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16368e = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16368e.f() != null) {
                    this.f16368e.f().a(view, this.f16368e.y);
                }
                x xVar = this.f16368e;
                if (view == xVar.s.mForumNameView || xVar.y == null || this.f16368e.y.f14074e == null) {
                    return;
                }
                m.a(this.f16368e.y.f14074e.f0());
                x xVar2 = this.f16368e;
                xVar2.A(xVar2.y.f14074e.f0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f16369e;

        public c(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16369e = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16369e.r.changeSelectStatus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x f16370a;

        public d(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16370a = xVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                SkinManager.setBackgroundColor(this.f16370a.F, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d2 f16371e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ x f16372f;

        public e(x xVar, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16372f = xVar;
            this.f16371e = d2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16372f.x != null) {
                    this.f16372f.f16224f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.f16372f.f16224f.getContext(), "", this.f16371e.B1, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f16373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ x f16374f;

        public f(x xVar, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16374f = xVar;
            this.f16373e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f16374f.x.getPageActivity(), this.f16373e.getCardId())));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f16375e;

        public g(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16375e = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16375e.f() == null) {
                return;
            }
            this.f16375e.f().a(view, this.f16375e.y);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x f16376a;

        public h(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16376a = xVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || this.f16376a.y == null || this.f16376a.y.f14074e == null) {
                return;
            }
            if (this.f16376a.f() != null) {
                d0<e2> f2 = this.f16376a.f();
                x xVar = this.f16376a;
                f2.a(xVar.q, xVar.y);
            }
            String f0 = this.f16376a.y.f14074e.f0();
            m.a(f0);
            this.f16376a.A(f0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(TbPageContext<?> tbPageContext) {
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
        View i4 = i();
        ViewGroup viewGroup = (ViewGroup) i4.findViewById(R.id.thread_content_layout_outter);
        this.G = viewGroup;
        viewGroup.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) i4.findViewById(R.id.thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setRadius(b.a.e.f.p.l.g(this.x.getPageActivity(), R.dimen.ds70));
            this.m.getHeadView().setPlaceHolder(1);
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.n = (ThreadUserInfoLayout) i4.findViewById(R.id.thread_user_info_layout);
        this.t = new NEGFeedBackView(this.x);
        this.t.attachToViewUpperRightConner((ViewGroup) i(), b.a.e.f.p.l.g(this.f16225g, R.dimen.tbds92), b.a.e.f.p.l.g(getContext(), R.dimen.tbds16));
        this.o = (TextView) i4.findViewById(R.id.thread_title);
        this.p = (TextView) i4.findViewById(R.id.thread_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) i4.findViewById(R.id.original_thread_view);
        this.q = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.I);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) i4.findViewById(R.id.thread_comment_layout);
        this.r = threadCommentAndPraiseInfoLayout;
        if (threadCommentAndPraiseInfoLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.r.setLayoutParams(layoutParams);
        }
        i4.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.r.setReplyTimeVisible(false);
        this.r.setShowPraiseNum(true);
        this.r.setNeedAddPraiseIcon(true);
        this.r.setNeedAddReplyIcon(true);
        this.r.setShareVisible(true);
        this.r.setForumAfterClickListener(new a(this));
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) i4.findViewById(R.id.card_transmit_source_read_share_layout);
        this.s = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this);
        this.s.mSharePraiseView.setNeedAddReplyIcon(true);
        this.s.setForumAfterClickListener(new b(this));
        this.u = i4.findViewById(R.id.divider_line_above_praise);
        this.v = i4.findViewById(R.id.card_divider_line);
        this.w = (TbImageView) i4.findViewById(R.id.thread_theme_card);
        this.B = (TbImageView) i4.findViewById(R.id.frs_normal_item_star_view);
        View findViewById = i4.findViewById(R.id.thread_multi_del_mask_view);
        this.F = findViewById;
        findViewById.setOnClickListener(new c(this));
        this.r.setOnSelectStatusChangeListener(new d(this));
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            m.l(this.o, str, R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(this.p, str, R.color.CAM_X0105, R.color.CAM_X0109);
            this.q.setReadState(m.k(str));
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        L(bdUniqueId);
    }

    public void D(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (view = this.v) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.z = z;
        }
    }

    public final void L(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            m(bdUniqueId);
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

    public final void M(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, d2Var) == null) || d2Var == null) {
            return;
        }
        if (!StringUtils.isNull(this.C) && !StringUtils.isNull(this.E)) {
            d2Var.y4(this.C, this.E);
        }
        SpannableStringBuilder X2 = d2Var.X2(false, true);
        if (X2 != null && !StringUtils.isNull(X2.toString())) {
            this.o.setVisibility(0);
            this.o.setOnTouchListener(new b.a.r0.d4.h(X2));
            this.o.setText(X2);
            m.l(this.o, d2Var.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        this.o.setVisibility(8);
    }

    public void N(int i2) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (e2Var = this.y) == null || e2Var.f14074e == null) {
            return;
        }
        if (i2 == 1) {
            this.r.setVisibility(8);
            this.s.setFrom(this.y.f14076g);
            this.s.setShareReportFrom(this.y.f14077h);
            this.s.setStType(this.y.f14075f);
            this.s.setData(this.y.f14074e);
            this.n.showForumNameView(false);
            return;
        }
        this.r.setFrom(e2Var.f14076g);
        this.r.setShareReportFrom(this.y.f14077h);
        this.r.setStType(this.y.f14075f);
        this.r.setData(this.y.f14074e);
        this.r.setDisPraiseFrom(this.y.f14078i);
        this.s.setVisibility(8);
        this.n.showForumNameView(true);
    }

    public final void O(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, d2Var) == null) || this.B == null) {
            return;
        }
        if (this.w != null && d2Var != null) {
            if (!StringUtils.isNull(d2Var.A1) && this.w.getVisibility() != 0) {
                NEGFeedBackView nEGFeedBackView = this.t;
                if (nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0 && (this.B.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                    layoutParams.rightMargin = b.a.e.f.p.l.g(this.x.getPageActivity(), R.dimen.tbds106);
                    this.B.setLayoutParams(layoutParams);
                }
                this.B.setVisibility(0);
                this.B.setImageDrawable(null);
                this.B.startLoad(d2Var.A1, 10, false);
                this.B.setOnClickListener(new e(this, d2Var));
                return;
            }
            this.B.setVisibility(8);
            return;
        }
        this.B.setVisibility(8);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? R.layout.card_transmit_thread_view : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, tbPageContext, i2) == null) {
            if (this.f16223e != i2) {
                SkinManager.setBackgroundResource(i(), R.drawable.addresslist_item_bg);
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
            if (e2Var != null && (d2Var = e2Var.f14074e) != null) {
                SkinManager.setBackgroundColor(this.F, (d2Var.l2() || this.y.f14074e.m2()) ? R.color.CAM_X0201 : R.color.transparent);
            }
            HeadPendantClickableView headPendantClickableView = this.m;
            if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.m.getHeadView() instanceof TbImageView)) {
                this.m.getHeadView().setPlaceHolder(1);
            }
            this.f16223e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (f() != null) {
                f().a(view, this.y);
            }
            if (view == i() || view.getId() == R.id.thread_content_layout_outter) {
                y();
            }
        }
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.D = str;
        }
    }

    public int t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? b.a.r0.p.d.c().b(this.D, i2) : invokeI.intValue;
    }

    public ClickableHeaderImageView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                return threadUserInfoLayout.mHeaderImg;
            }
            return null;
        }
        return (ClickableHeaderImageView) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                return threadUserInfoLayout.mUsername;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void w(d2 d2Var) {
        MetaData J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, d2Var) == null) || d2Var == null || this.w == null || (J = d2Var.J()) == null) {
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

    public final boolean x(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, d2Var)) == null) {
            if (d2Var == null || d2Var.J() == null || StringUtils.isNull(d2Var.J().getUserId())) {
                return false;
            }
            return d2Var.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
        }
        return invokeL.booleanValue;
    }

    public final void y() {
        e2 e2Var;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (e2Var = this.y) == null || (d2Var = e2Var.f14074e) == null) {
            return;
        }
        m.a(d2Var.f0());
        A(d2Var.f0());
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.x.getPageActivity()).createFromThreadCfg(d2Var, null, this.y.f14075f, 18003, true, false, false);
        createFromThreadCfg.setStartFrom(this.l);
        createFromThreadCfg.setIsShareThread(true);
        m.a(d2Var.t1());
        this.x.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: z */
    public void j(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, e2Var) == null) {
            if (e2Var != null && e2Var.f14074e != null) {
                if (i() != null) {
                    i().setVisibility(0);
                }
                this.y = e2Var;
                d2 d2Var = e2Var.f14074e;
                if (this.t != null) {
                    SparseArray<String> S = d2Var.S();
                    if (S != null && S.size() > 0 && this.z) {
                        x0 x0Var = new x0();
                        x0Var.o(d2Var.t1());
                        x0Var.k(d2Var.T());
                        x0Var.n(d2Var.F0());
                        x0Var.j(S);
                        x0Var.f14266g = d2Var.l1;
                        this.t.setData(x0Var);
                        this.t.setFirstRowSingleColumn(true);
                        this.t.setVisibility(x(d2Var) ? 8 : 0);
                    } else {
                        this.t.setVisibility(8);
                    }
                }
                if (this.y.f14077h == 1) {
                    this.n.setFrom(3);
                    w(d2Var);
                    O(d2Var);
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
                M(d2Var);
                this.q.fillData(d2Var.y1);
                N(t(1));
                L(g());
                k(this.x, TbadkCoreApplication.getInst().getSkinType());
                A(d2Var.f0());
                if (this.r.isInFrsAllThread() && (b.a.r0.x0.b.f().i() || b.a.r0.x0.a.h().j())) {
                    this.F.setVisibility(0);
                    if (!d2Var.l2() && !d2Var.m2() && !d2Var.E2()) {
                        this.F.setBackgroundResource(R.color.transparent);
                        return;
                    } else {
                        SkinManager.setBackgroundColor(this.F, R.color.CAM_X0201);
                        return;
                    }
                }
                this.F.setVisibility(8);
            } else if (i() != null) {
                i().setVisibility(8);
            }
        }
    }
}
