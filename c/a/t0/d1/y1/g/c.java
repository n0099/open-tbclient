package c.a.t0.d1.y1.g;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.k;
import c.a.s0.s.q.a1;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.r;
import c.a.s0.s.q.u;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import c.a.t0.d1.z2.i;
import c.a.t0.g0.b0;
import c.a.t0.g0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class c extends c.a.t0.g0.b<d2> implements b0, Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> A;
    public TextView B;
    public TextView C;
    public ConstrainImageGroup D;
    public boolean E;
    public View F;
    public TbImageView G;
    public String H;
    public i I;
    public View J;
    public AppletsCellView K;
    public View.OnClickListener L;
    public final View.OnClickListener M;
    public final View.OnClickListener N;
    public HeadPendantClickableView m;
    public PlayVoiceBntNew n;
    public ThreadCommentAndPraiseInfoLayout o;
    public ThreadSourceShareAndPraiseLayout p;
    public ThreadGodReplyLayout q;
    public ThreadUserInfoLayout r;
    public RelativeLayout s;
    public View t;
    public TbImageView u;
    public LinearLayout v;
    public String w;
    public String x;
    public int y;
    public d2 z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17273e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17273e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (threadCommentAndPraiseInfoLayout = this.f17273e.o) == null) {
                return;
            }
            threadCommentAndPraiseInfoLayout.changeSelectStatus();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ThreadCommentAndPraiseInfoLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.J == null) {
                return;
            }
            this.a.J.setBackgroundColor(SkinManager.getColor(z ? c1.CAM_X0201 : c1.transparent));
        }
    }

    /* renamed from: c.a.t0.d1.y1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1055c implements c.a.s0.g1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d2 f17274b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f17275c;

        public C1055c(c cVar, LinkedList linkedList, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, linkedList, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17275c = cVar;
            this.a = linkedList;
            this.f17274b = d2Var;
        }

        @Override // c.a.s0.g1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                d0<d2> g2 = this.f17275c.g();
                if (!z) {
                    if (g2 != null) {
                        view.setTag("1");
                        g2.a = Boolean.FALSE;
                        g2.a(view, this.f17275c.z);
                    }
                    this.f17275c.J(view, this.a, i2, this.f17274b);
                    return;
                }
                if (g2 != null) {
                    view.setTag("1");
                    g2.a = Boolean.TRUE;
                    g2.a(view, this.f17275c.z);
                }
                this.f17275c.x(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d2 f17276e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f17277f;

        public d(c cVar, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17277f = cVar;
            this.f17276e = d2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17277f.A != null) {
                    this.f17277f.f18210f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.f17277f.f18210f.getContext(), "", this.f17276e.D1, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f17278e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f17279f;

        public e(c cVar, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17279f = cVar;
            this.f17278e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f17279f.A.getPageActivity(), this.f17278e.getCardId())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17280e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17280e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!c.a.t0.d1.b.f().i() && !c.a.t0.d1.a.h().j()) {
                    if (this.f17280e.g() != null) {
                        this.f17280e.g().a(view, this.f17280e.z);
                    }
                    c cVar = this.f17280e;
                    cVar.x(view == cVar.q);
                    return;
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.f17280e.o;
                if (threadCommentAndPraiseInfoLayout != null) {
                    threadCommentAndPraiseInfoLayout.changeSelectStatus();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17281e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17281e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0<d2> g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f17281e.g()) == null) {
                return;
            }
            view.setTag("2");
            g2.a(view, this.f17281e.z);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17282e;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17282e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17282e.g() == null) {
                return;
            }
            this.f17282e.g().a(view, this.f17282e.z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.y = 3;
        this.E = true;
        this.L = new f(this);
        this.M = new g(this);
        this.N = new h(this);
        View j2 = j();
        n(bdUniqueId);
        this.A = tbPageContext;
        this.l = 3;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) j2.findViewById(f1.card_home_page_normal_thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setRadius(n.f(this.A.getPageActivity(), d1.ds70));
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.m.setAfterClickListener(this.N);
        this.t = j2.findViewById(f1.divider_line);
        this.B = (TextView) j2.findViewById(f1.card_home_page_normal_thread_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) j2.findViewById(f1.card_home_page_normal_thread_abstract_voice);
        this.n = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.M);
        TextView textView = (TextView) j2.findViewById(f1.card_home_page_normal_thread_abstract);
        this.C = textView;
        textView.setVisibility(8);
        this.F = j2.findViewById(f1.divider_line_above_praise);
        this.D = (ConstrainImageGroup) j2.findViewById(f1.card_home_page_normal_thread_img_layout);
        this.D.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.tbds20));
        this.D.setChildClickListener(this.L);
        c.a.s0.g1.j.f fVar = new c.a.s0.g1.j.f(3);
        fVar.d(1.0d);
        this.D.setImageProcessor(fVar);
        this.o = (ThreadCommentAndPraiseInfoLayout) j2.findViewById(f1.card_home_page_normal_thread_info_layout);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) j2.findViewById(f1.card_home_page_normal_thread_user_info_layout);
        this.r = threadUserInfoLayout;
        threadUserInfoLayout.setUserAfterClickListener(this.N);
        this.r.setFrom(3);
        this.o.setOnClickListener(this.L);
        this.o.setForumAfterClickListener(this.N);
        this.o.setReplyTimeVisible(false);
        this.o.setShowPraiseNum(true);
        this.o.setNeedAddPraiseIcon(true);
        this.o.setNeedAddReplyIcon(true);
        this.o.setIsBarViewVisible(false);
        this.o.setShareVisible(true);
        this.o.setShareReportFrom(1);
        this.o.setStType(FrsFragment.STAR_FRS);
        this.o.setFrom(2);
        this.o.sourceFromForPb = 3;
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) j2.findViewById(f1.card_home_page_source_read_share_layout);
        this.p = threadSourceShareAndPraiseLayout;
        if (threadSourceShareAndPraiseLayout != null) {
            threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this.L);
            this.p.setFrom(2);
            this.p.setShareReportFrom(1);
            this.p.setSourceFromForPb(3);
            this.p.setStType(FrsFragment.STAR_FRS);
            this.p.setHideBarName(true);
            this.p.mSharePraiseView.setNeedAddReplyIcon(true);
        }
        RelativeLayout relativeLayout = (RelativeLayout) j2.findViewById(f1.card_home_page_normal_thread_root);
        this.s = relativeLayout;
        i iVar = new i(this.A, relativeLayout);
        this.I = iVar;
        iVar.d(h());
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) j2.findViewById(f1.card_frs_god_reply_layout);
        this.q = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this.L);
        TbImageView tbImageView = (TbImageView) j2.findViewById(f1.frs_normal_item_theme_card);
        this.u = tbImageView;
        tbImageView.setPageId(h());
        TbImageView tbImageView2 = (TbImageView) j2.findViewById(f1.frs_normal_item_star_view);
        this.G = tbImageView2;
        if (tbImageView2 != null) {
            tbImageView2.setPageId(h());
        }
        View findViewById = j2.findViewById(f1.thread_multi_del_mask_view);
        this.J = findViewById;
        findViewById.setOnClickListener(new a(this));
        this.o.setOnSelectStatusChangeListener(new b(this));
        this.v = (LinearLayout) j2.findViewById(f1.card_home_page_normal_thread_content_layout);
        this.K = (AppletsCellView) j2.findViewById(f1.card_home_page_normal_thread_share_info);
    }

    public final void A(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
            if (d2Var != null && t(2) == 1) {
                if (!StringUtils.isNull(this.w) && !StringUtils.isNull(this.x)) {
                    d2Var.A4(this.w, this.x);
                }
                SpannableString P2 = d2Var.P2();
                if (P2 != null && !m.isEmpty(P2.toString())) {
                    this.C.setVisibility(0);
                    this.C.setOnTouchListener(new c.a.t0.n4.h(P2));
                    this.C.setText(P2);
                    c.a.t0.g0.m.l(this.C, d2Var.g0(), c1.CAM_X0107, c1.CAM_X0109);
                    return;
                }
                this.C.setVisibility(8);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public void B(c.a.d.f.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (constrainImageGroup = this.D) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void C(c.a.d.f.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (constrainImageGroup = this.D) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.n.setClickable(true);
            int childCount = this.D.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.D.getChildAt(i2);
                if (childAt != null) {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public final void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.r;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
            ConstrainImageGroup constrainImageGroup = this.D;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void F(double d2) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d2)}) == null) || (constrainImageGroup = this.D) == null) {
            return;
        }
        constrainImageGroup.setSingleImageRatio(d2);
    }

    public final boolean G(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d2Var)) == null) {
            if (!StringUtils.isNull(this.w) && !StringUtils.isNull(this.x)) {
                d2Var.A4(this.w, this.x);
            }
            SpannableStringBuilder Z2 = d2Var.Z2(false, true);
            if (Z2 != null && !StringUtils.isNull(Z2.toString())) {
                this.B.setVisibility(0);
                this.B.setOnTouchListener(new c.a.t0.n4.h(Z2));
                this.B.setText(Z2);
                c.a.t0.g0.m.l(this.B, d2Var.g0(), c1.CAM_X0105, c1.CAM_X0109);
            } else {
                this.B.setVisibility(8);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void H(int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (d2Var = this.z) == null) {
            return;
        }
        if (i2 == 1) {
            this.o.setVisibility(8);
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.p;
            if (threadSourceShareAndPraiseLayout != null) {
                threadSourceShareAndPraiseLayout.setData(this.z);
                return;
            }
            return;
        }
        this.o.setData(d2Var);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout2 = this.p;
        if (threadSourceShareAndPraiseLayout2 != null) {
            threadSourceShareAndPraiseLayout2.setVisibility(8);
        }
    }

    public final void I(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d2Var) == null) || this.G == null) {
            return;
        }
        if (this.u != null && d2Var != null) {
            if (!StringUtils.isNull(d2Var.C1) && this.u.getVisibility() != 0) {
                i iVar = this.I;
                if (iVar != null && iVar.b() && (this.G.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                    layoutParams.rightMargin = n.f(this.A.getPageActivity(), d1.tbds106);
                    this.G.setLayoutParams(layoutParams);
                }
                this.G.setVisibility(0);
                this.G.setImageDrawable(null);
                this.G.startLoad(d2Var.C1, 10, false);
                this.G.setOnClickListener(new d(this, d2Var));
                return;
            }
            this.G.setVisibility(8);
            return;
        }
        this.G.setVisibility(8);
    }

    public final void J(View view, List<MediaData> list, int i2, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048585, this, view, list, i2, d2Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                n.L(this.A.getPageActivity(), i1.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                String str = null;
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    str = mediaData.getSrc_pic();
                } else if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                }
                if (!StringUtils.isNull(str)) {
                    arrayList.add(str);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.E ? 13 : 14;
                    imageUrlData.imageUrl = u(mediaData);
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = c.a.d.f.m.b.g(d2Var.v1(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(str, imageUrlData);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(arrayList);
            bVar.B(i2);
            bVar.z(d2Var.a0());
            bVar.y(String.valueOf(d2Var.U()));
            bVar.O(d2Var.v1());
            bVar.C(this.E);
            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            bVar.N(d2Var);
            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig v = bVar.v(this.A.getPageActivity());
            v.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.A;
            historyMessage.threadId = d2Var.g0();
            historyMessage.threadName = d2Var.getTitle();
            historyMessage.forumName = d2Var.a0();
            historyMessage.postID = d2Var.X();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public final void K() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (textView = this.B) == null || this.n == null || this.D == null || this.f18211g == null || textView.getVisibility() != 8) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.topMargin = this.f18211g.getResources().getDimensionPixelSize(d1.tbds20);
        this.n.setLayoutParams(layoutParams);
        if (this.n.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams2.topMargin = this.f18211g.getResources().getDimensionPixelSize(d1.tbds28);
            this.D.setLayoutParams(layoutParams2);
        }
    }

    public final void L() {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.F == null || (constrainImageGroup = this.D) == null || this.q == null) {
            return;
        }
        if (constrainImageGroup.getVisibility() == 8 && this.q.getVisibility() == 8 && this.K.getVisibility() == 8) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
    }

    @Override // c.a.t0.g0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.H = str;
        }
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? g1.card_home_page_multi_img_new_frame : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, tbPageContext, i2) == null) {
            if (this.y != i2) {
                SkinManager.setBackgroundResource(j(), e1.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.t, c1.CAM_X0204);
                this.D.onChangeSkinType();
                this.o.onChangeSkinType();
                this.r.onChangeSkinType();
                AppletsCellView appletsCellView = this.K;
                if (appletsCellView != null) {
                    appletsCellView.onChangeSkinType();
                }
                this.I.c();
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.p;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.p.onChangeSkinType();
                }
                HeadPendantClickableView headPendantClickableView = this.m;
                if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.m.getHeadView() instanceof TbImageView)) {
                    this.m.getHeadView().setPlaceHolder(1);
                }
            }
            this.y = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
        }
    }

    @Override // c.a.t0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.l = i2;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.o;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.sourceFromForPb = i2;
                threadCommentAndPraiseInfoLayout.setFrom(2);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.r;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setFrom(3);
            }
        }
    }

    public int t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? c.a.t0.t.d.c().b(this.H, i2) : invokeI.intValue;
    }

    public final String u(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, mediaData)) == null) {
            if (mediaData == null) {
                return "";
            }
            String picUrl = mediaData.getPicUrl();
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getSmallUrl();
            }
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getThumbnails_url();
            }
            return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
        }
        return (String) invokeL.objValue;
    }

    public void v(d2 d2Var) {
        MetaData J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, d2Var) == null) || d2Var == null || this.u == null || (J = d2Var.J()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = J.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
            this.u.setVisibility(0);
            this.u.setImageDrawable(null);
            this.u.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.u.setOnClickListener(new e(this, themeCard));
            return;
        }
        this.u.setVisibility(8);
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void x(boolean z) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (d2Var = this.z) == null) {
            return;
        }
        c.a.t0.g0.m.a(d2Var.g0());
        c.a.t0.g0.m.l(this.B, this.z.g0(), c1.CAM_X0105, c1.CAM_X0109);
        c.a.t0.g0.m.l(this.C, this.z.g0(), c1.CAM_X0107, c1.CAM_X0109);
        c.a.t0.g0.m.l(this.q.getGodReplyContent(), this.z.g0(), c1.CAM_X0106, c1.CAM_X0109);
        u M = this.z.M();
        if (M != null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(this.f18211g);
                return;
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.A.getPageActivity(), M.a(), M.b(), 2)));
                return;
            }
        }
        d2 d2Var2 = this.z;
        r rVar = d2Var2.X0;
        if (d2Var2.W0 == 1 && rVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
            String str = rVar.a;
            long j2 = rVar.f13792b;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, new a1()));
            return;
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.A.getPageActivity()).createFromThreadCfg(this.z, null, FrsFragment.STAR_FRS, 18003, true, false, false).addLocateParam("");
        addLocateParam.setStartFrom(this.l);
        addLocateParam.setFrom("from_frs");
        if (z) {
            addLocateParam.setJumpGodReply(true);
        }
        if (this.z.g2() && addLocateParam.getIntent() != null) {
            addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        this.A.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: y */
    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, d2Var) == null) {
            if (d2Var == null) {
                if (j() != null) {
                    j().setVisibility(8);
                    return;
                }
                return;
            }
            this.z = d2Var;
            if (j() != null) {
                j().setVisibility(0);
                j().setOnClickListener(this.L);
            }
            this.q.onChangeSkinType();
            if (!w() && c.a.t0.g0.m.k(this.z.g0())) {
                c.a.t0.g0.m.l(this.B, this.z.g0(), c1.CAM_X0105, c1.CAM_X0109);
                c.a.t0.g0.m.l(this.C, this.z.g0(), c1.CAM_X0107, c1.CAM_X0109);
                c.a.t0.g0.m.l(this.q.getGodReplyContent(), this.z.g0(), c1.CAM_X0106, c1.CAM_X0109);
            }
            v(d2Var);
            this.I.a(this.z);
            I(d2Var);
            this.r.setData(this.z);
            this.q.setFromCDN(this.E);
            this.q.setData(this.z.y1());
            this.r.setUserAfterClickListener(this.N);
            H(t(1));
            if (this.r.getHeaderImg() != null) {
                if (this.r.getIsSimpleThread()) {
                    this.r.getHeaderImg().setVisibility(8);
                    this.m.setVisibility(8);
                } else if (d2Var.J() != null && d2Var.J().getPendantData() != null && !StringUtils.isNull(d2Var.J().getPendantData().getImgUrl())) {
                    this.r.getHeaderImg().setVisibility(4);
                    this.m.setVisibility(0);
                    this.m.setData(d2Var);
                } else {
                    this.m.setVisibility(8);
                    this.r.getHeaderImg().setVisibility(0);
                    this.r.getHeaderImg().setData(d2Var);
                }
            }
            G(d2Var);
            A(d2Var);
            this.K.setData(d2Var.g1());
            this.K.setForumId(String.valueOf(d2Var.U()));
            this.K.setFrom(AppletsCellView.FRS_SHARE_CARD_LITE_PROGRAM_FROM);
            ArrayList<VoiceData$VoiceModel> F1 = d2Var.F1();
            if (ListUtils.isEmpty(F1)) {
                this.n.setVisibility(8);
            } else {
                this.n.resetLayoutParams();
                this.n.setVisibility(0);
                VoiceData$VoiceModel voiceData$VoiceModel = F1.get(0);
                this.n.setVoiceModel(voiceData$VoiceModel);
                this.n.setTag(voiceData$VoiceModel);
                this.n.changeSkin();
                if (voiceData$VoiceModel != null) {
                    this.n.refreshViewState(voiceData$VoiceModel.voice_status.intValue());
                }
            }
            ArrayList<MediaData> F0 = d2Var.F0();
            if (k.c().g() && ListUtils.getCount(F0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < F0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(F0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.D.setVisibility(0);
                    this.D.setFromCDN(this.E);
                    this.D.setImageClickListener(new C1055c(this, linkedList, d2Var));
                    this.D.setImageMediaList(linkedList);
                } else {
                    this.D.setVisibility(8);
                }
            } else {
                this.D.setVisibility(8);
            }
            L();
            D();
            K();
            if ((c.a.t0.d1.b.f().i() || c.a.t0.d1.a.h().j()) && this.o.isInFrsAllThread()) {
                this.J.setVisibility(0);
                if (!this.z.m2() && !this.z.n2() && !this.z.F2()) {
                    this.J.setBackgroundResource(c1.transparent);
                } else {
                    SkinManager.setBackgroundColor(this.J, c1.CAM_X0201);
                }
            } else {
                this.J.setVisibility(8);
            }
            l(this.A, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, bdUniqueId) == null) || bdUniqueId == null || this.o == null) {
            return;
        }
        E(bdUniqueId);
    }
}
