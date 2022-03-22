package c.a.p0.f1.p1.g;

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
import c.a.o0.r.l;
import c.a.o0.r.r.r;
import c.a.o0.r.r.u;
import c.a.o0.r.r.y0;
import c.a.p0.f1.s2.i;
import c.a.p0.h0.b0;
import c.a.p0.h0.z;
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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class c extends c.a.p0.h0.b<ThreadData> implements z, Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public View B;
    public TbImageView C;
    public String D;
    public i E;
    public View F;
    public AppletsCellView G;
    public View.OnClickListener H;
    public final View.OnClickListener I;
    public final View.OnClickListener J;
    public HeadPendantClickableView i;
    public PlayVoiceBntNew j;
    public ThreadCommentAndPraiseInfoLayout k;
    public ThreadSourceShareAndPraiseLayout l;
    public ThreadGodReplyLayout m;
    public ThreadUserInfoLayout n;
    public RelativeLayout o;
    public View p;
    public TbImageView q;
    public LinearLayout r;
    public String s;
    public String t;
    public int u;
    public ThreadData v;
    public TbPageContext<?> w;
    public TextView x;
    public TextView y;
    public ConstrainImageGroup z;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (threadCommentAndPraiseInfoLayout = this.a.k) == null) {
                return;
            }
            threadCommentAndPraiseInfoLayout.changeSelectStatus();
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.F == null) {
                return;
            }
            this.a.F.setBackgroundColor(SkinManager.getColor(z ? R.color.CAM_X0201 : R.color.transparent));
        }
    }

    /* renamed from: c.a.p0.f1.p1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1085c implements c.a.o0.e1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ThreadData f14376b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f14377c;

        public C1085c(c cVar, LinkedList linkedList, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, linkedList, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14377c = cVar;
            this.a = linkedList;
            this.f14376b = threadData;
        }

        @Override // c.a.o0.e1.j.d
        public void a(View view, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                b0<ThreadData> h2 = this.f14377c.h();
                if (!z) {
                    if (h2 != null) {
                        view.setTag("1");
                        h2.a = Boolean.FALSE;
                        h2.a(view, this.f14377c.v);
                    }
                    this.f14377c.K(view, this.a, i, this.f14376b);
                    return;
                }
                if (h2 != null) {
                    view.setTag("1");
                    h2.a = Boolean.TRUE;
                    h2.a(view, this.f14377c.v);
                }
                this.f14377c.y(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f14378b;

        public d(c cVar, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14378b = cVar;
            this.a = threadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14378b.w != null) {
                    this.f14378b.f15304b.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.f14378b.f15304b.getContext(), "", this.a.iconLink, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThemeCardInUserData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f14379b;

        public e(c cVar, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14379b = cVar;
            this.a = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f14379b.w.getPageActivity(), this.a.getCardId())));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!c.a.p0.f1.b.f().i() && !c.a.p0.f1.a.h().j()) {
                    if (this.a.h() != null) {
                        this.a.h().a(view, this.a.v);
                    }
                    c cVar = this.a;
                    cVar.y(view == cVar.m);
                    return;
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a.k;
                if (threadCommentAndPraiseInfoLayout != null) {
                    threadCommentAndPraiseInfoLayout.changeSelectStatus();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<ThreadData> h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (h2 = this.a.h()) == null) {
                return;
            }
            view.setTag("2");
            h2.a(view, this.a.v);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.h() == null) {
                return;
            }
            this.a.h().a(view, this.a.v);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = 3;
        this.A = true;
        this.H = new f(this);
        this.I = new g(this);
        this.J = new h(this);
        View k = k();
        o(bdUniqueId);
        this.w = tbPageContext;
        this.f15310h = 3;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) k.findViewById(R.id.obfuscated_res_0x7f090544);
        this.i = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.i.getHeadView().setIsRound(true);
            this.i.getHeadView().setDrawBorder(false);
            this.i.getHeadView().setDefaultResource(17170445);
            this.i.getHeadView().setRadius(n.f(this.w.getPageActivity(), R.dimen.obfuscated_res_0x7f070266));
        }
        this.i.setHasPendantStyle();
        if (this.i.getPendantView() != null) {
            this.i.getPendantView().setIsRound(true);
            this.i.getPendantView().setDrawBorder(false);
        }
        this.i.setAfterClickListener(this.J);
        this.p = k.findViewById(R.id.obfuscated_res_0x7f0907f4);
        this.x = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09053c);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) k.findViewById(R.id.obfuscated_res_0x7f090533);
        this.j = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.I);
        TextView textView = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090532);
        this.y = textView;
        textView.setVisibility(8);
        this.B = k.findViewById(R.id.obfuscated_res_0x7f0907f8);
        this.z = (ConstrainImageGroup) k.findViewById(R.id.obfuscated_res_0x7f090537);
        this.z.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.z.setChildClickListener(this.H);
        c.a.o0.e1.j.f fVar = new c.a.o0.e1.j.f(3);
        fVar.d(1.0d);
        this.z.setImageProcessor(fVar);
        this.k = (ThreadCommentAndPraiseInfoLayout) k.findViewById(R.id.obfuscated_res_0x7f090538);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) k.findViewById(R.id.obfuscated_res_0x7f090542);
        this.n = threadUserInfoLayout;
        threadUserInfoLayout.setUserAfterClickListener(this.J);
        this.n.setFrom(3);
        this.k.setOnClickListener(this.H);
        this.k.setForumAfterClickListener(this.J);
        this.k.setReplyTimeVisible(false);
        this.k.setShowPraiseNum(true);
        this.k.setNeedAddPraiseIcon(true);
        this.k.setNeedAddReplyIcon(true);
        this.k.setIsBarViewVisible(false);
        this.k.setShareVisible(true);
        this.k.setShareReportFrom(1);
        this.k.setStType("frs_page");
        this.k.setFrom(2);
        this.k.N = 3;
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) k.findViewById(R.id.obfuscated_res_0x7f090545);
        this.l = threadSourceShareAndPraiseLayout;
        if (threadSourceShareAndPraiseLayout != null) {
            threadSourceShareAndPraiseLayout.f30173b.setOnClickListener(this.H);
            this.l.setFrom(2);
            this.l.setShareReportFrom(1);
            this.l.setSourceFromForPb(3);
            this.l.setStType("frs_page");
            this.l.setHideBarName(true);
            this.l.f30173b.setNeedAddReplyIcon(true);
        }
        RelativeLayout relativeLayout = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f090539);
        this.o = relativeLayout;
        i iVar = new i(this.w, relativeLayout);
        this.E = iVar;
        iVar.d(i());
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) k.findViewById(R.id.obfuscated_res_0x7f090527);
        this.m = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this.H);
        TbImageView tbImageView = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f090b9d);
        this.q = tbImageView;
        tbImageView.setPageId(i());
        TbImageView tbImageView2 = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f090b9c);
        this.C = tbImageView2;
        if (tbImageView2 != null) {
            tbImageView2.setPageId(i());
        }
        View findViewById = k.findViewById(R.id.obfuscated_res_0x7f091fba);
        this.F = findViewById;
        findViewById.setOnClickListener(new a(this));
        this.k.setOnSelectStatusChangeListener(new b(this));
        this.r = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090534);
        this.G = (AppletsCellView) k.findViewById(R.id.obfuscated_res_0x7f09053a);
    }

    public void A(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) || bdUniqueId == null || this.k == null) {
            return;
        }
        F(bdUniqueId);
    }

    public final void B(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            if (threadData != null && u(2) == 1) {
                if (!StringUtils.isNull(this.s) && !StringUtils.isNull(this.t)) {
                    threadData.setSpecUrl(this.s, this.t);
                }
                SpannableString parseAbstract = threadData.parseAbstract();
                if (parseAbstract != null && !m.isEmpty(parseAbstract.toString())) {
                    this.y.setVisibility(0);
                    this.y.setOnTouchListener(new c.a.p0.q4.i(parseAbstract));
                    this.y.setText(parseAbstract);
                    c.a.p0.h0.m.l(this.y, threadData.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
                    return;
                }
                this.y.setVisibility(8);
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public void C(c.a.d.f.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (constrainImageGroup = this.z) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void D(c.a.d.f.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || (constrainImageGroup = this.z) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.j.setClickable(true);
            int childCount = this.z.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.z.getChildAt(i);
                if (childAt != null) {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public final void F(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
            ConstrainImageGroup constrainImageGroup = this.z;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void G(double d2) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2)}) == null) || (constrainImageGroup = this.z) == null) {
            return;
        }
        constrainImageGroup.setSingleImageRatio(d2);
    }

    public final boolean H(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
            if (!StringUtils.isNull(this.s) && !StringUtils.isNull(this.t)) {
                threadData.setSpecUrl(this.s, this.t);
            }
            SpannableStringBuilder parseTitleOrAbstractForFrsNew = threadData.parseTitleOrAbstractForFrsNew(false, true);
            if (parseTitleOrAbstractForFrsNew != null && !StringUtils.isNull(parseTitleOrAbstractForFrsNew.toString())) {
                this.x.setVisibility(0);
                this.x.setOnTouchListener(new c.a.p0.q4.i(parseTitleOrAbstractForFrsNew));
                this.x.setText(parseTitleOrAbstractForFrsNew);
                c.a.p0.h0.m.l(this.x, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            } else {
                this.x.setVisibility(8);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void I(int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (threadData = this.v) == null) {
            return;
        }
        if (i == 1) {
            this.k.setVisibility(8);
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.l;
            if (threadSourceShareAndPraiseLayout != null) {
                threadSourceShareAndPraiseLayout.g(this.v);
                return;
            }
            return;
        }
        this.k.setData(threadData);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout2 = this.l;
        if (threadSourceShareAndPraiseLayout2 != null) {
            threadSourceShareAndPraiseLayout2.setVisibility(8);
        }
    }

    public final void J(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) || this.C == null) {
            return;
        }
        if (this.q != null && threadData != null) {
            if (!StringUtils.isNull(threadData.iconPicUrl) && this.q.getVisibility() != 0) {
                i iVar = this.E;
                if (iVar != null && iVar.b() && (this.C.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
                    layoutParams.rightMargin = n.f(this.w.getPageActivity(), R.dimen.tbds106);
                    this.C.setLayoutParams(layoutParams);
                }
                this.C.setVisibility(0);
                this.C.setImageDrawable(null);
                this.C.J(threadData.iconPicUrl, 10, false);
                this.C.setOnClickListener(new d(this, threadData));
                return;
            }
            this.C.setVisibility(8);
            return;
        }
        this.C.setVisibility(8);
    }

    public final void K(View view, List<MediaData> list, int i, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048586, this, view, list, i, threadData) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                n.M(this.w.getPageActivity(), R.string.obfuscated_res_0x7f0f0e63);
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
                    imageUrlData.urlType = this.A ? 13 : 14;
                    imageUrlData.imageUrl = v(mediaData);
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = c.a.d.f.m.b.g(threadData.getTid(), -1L);
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
            bVar.B(i);
            bVar.z(threadData.getForum_name());
            bVar.y(String.valueOf(threadData.getFid()));
            bVar.O(threadData.getTid());
            bVar.C(this.A);
            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            bVar.N(threadData);
            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig v = bVar.v(this.w.getPageActivity());
            v.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.w;
            historyMessage.threadId = threadData.getId();
            historyMessage.threadName = threadData.getTitle();
            historyMessage.forumName = threadData.getForum_name();
            historyMessage.postID = threadData.getFirstPostId();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public final void L() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (textView = this.x) == null || this.j == null || this.z == null || this.f15305c == null || textView.getVisibility() != 8) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.topMargin = this.f15305c.getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.j.setLayoutParams(layoutParams);
        if (this.j.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.z.getLayoutParams();
            layoutParams2.topMargin = this.f15305c.getResources().getDimensionPixelSize(R.dimen.tbds28);
            this.z.setLayoutParams(layoutParams2);
        }
    }

    public final void M() {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.B == null || (constrainImageGroup = this.z) == null || this.m == null) {
            return;
        }
        if (constrainImageGroup.getVisibility() == 8 && this.m.getVisibility() == 8 && this.G.getVisibility() == 8) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
    }

    @Override // c.a.p0.h0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.D = str;
        }
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? R.layout.obfuscated_res_0x7f0d01a0 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, tbPageContext, i) == null) {
            if (this.u != i) {
                SkinManager.setBackgroundResource(k(), R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
                this.z.b();
                this.k.onChangeSkinType();
                this.n.h();
                AppletsCellView appletsCellView = this.G;
                if (appletsCellView != null) {
                    appletsCellView.c();
                }
                this.E.c();
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.l;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.l.f();
                }
                HeadPendantClickableView headPendantClickableView = this.i;
                if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.i.getHeadView() instanceof TbImageView)) {
                    this.i.getHeadView().setPlaceHolder(1);
                }
            }
            this.u = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
        }
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.f15310h = i;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.k;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.N = i;
                threadCommentAndPraiseInfoLayout.setFrom(2);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setFrom(3);
            }
        }
    }

    public int u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) ? c.a.p0.v.d.c().b(this.D, i) : invokeI.intValue;
    }

    public final String v(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, mediaData)) == null) {
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

    public void w(ThreadData threadData) {
        MetaData author;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, threadData) == null) || threadData == null || this.q == null || (author = threadData.getAuthor()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = author.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
            this.q.setVisibility(0);
            this.q.setImageDrawable(null);
            this.q.J(themeCard.getCardImageUrlAndroid(), 10, false);
            this.q.setOnClickListener(new e(this, themeCard));
            return;
        }
        this.q.setVisibility(8);
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y(boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (threadData = this.v) == null) {
            return;
        }
        c.a.p0.h0.m.a(threadData.getId());
        c.a.p0.h0.m.l(this.x, this.v.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        c.a.p0.h0.m.l(this.y, this.v.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
        c.a.p0.h0.m.l(this.m.getGodReplyContent(), this.v.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        u cartoonThreadData = this.v.getCartoonThreadData();
        if (cartoonThreadData != null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(this.f15305c);
                return;
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.w.getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                return;
            }
        }
        ThreadData threadData2 = this.v;
        r rVar = threadData2.bookChapterData;
        if (threadData2.isBookChapter == 1 && rVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
            String str = rVar.a;
            long j = rVar.f10938b;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, new y0()));
            return;
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.w.getPageActivity()).createFromThreadCfg(this.v, null, "frs_page", 18003, true, false, false).addLocateParam("");
        addLocateParam.setStartFrom(this.f15310h);
        addLocateParam.setFrom("from_frs");
        if (z) {
            addLocateParam.setJumpGodReply(true);
        }
        if (this.v.isInterviewLiveStyle() && addLocateParam.getIntent() != null) {
            addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        this.w.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: z */
    public void l(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, threadData) == null) {
            if (threadData == null) {
                if (k() != null) {
                    k().setVisibility(8);
                    return;
                }
                return;
            }
            this.v = threadData;
            if (k() != null) {
                k().setVisibility(0);
                k().setOnClickListener(this.H);
            }
            this.m.k();
            if (!x() && c.a.p0.h0.m.k(this.v.getId())) {
                c.a.p0.h0.m.l(this.x, this.v.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                c.a.p0.h0.m.l(this.y, this.v.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
                c.a.p0.h0.m.l(this.m.getGodReplyContent(), this.v.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
            }
            w(threadData);
            this.E.a(this.v);
            J(threadData);
            this.n.j(this.v);
            this.m.setFromCDN(this.A);
            this.m.setData(this.v.getTopAgreePost());
            this.n.setUserAfterClickListener(this.J);
            I(u(1));
            if (this.n.getHeaderImg() != null) {
                if (this.n.getIsSimpleThread()) {
                    this.n.getHeaderImg().setVisibility(8);
                    this.i.setVisibility(8);
                } else if (threadData.getAuthor() != null && threadData.getAuthor().getPendantData() != null && !StringUtils.isNull(threadData.getAuthor().getPendantData().getImgUrl())) {
                    this.n.getHeaderImg().setVisibility(4);
                    this.i.setVisibility(0);
                    this.i.setData(threadData);
                } else {
                    this.i.setVisibility(8);
                    this.n.getHeaderImg().setVisibility(0);
                    this.n.getHeaderImg().setData(threadData);
                }
            }
            H(threadData);
            B(threadData);
            this.G.setData(threadData.getSmartApp());
            this.G.setForumId(String.valueOf(threadData.getFid()));
            this.G.setFrom("frs_card");
            ArrayList<VoiceData.VoiceModel> voice = threadData.getVoice();
            if (ListUtils.isEmpty(voice)) {
                this.j.setVisibility(8);
            } else {
                this.j.o();
                this.j.setVisibility(0);
                VoiceData.VoiceModel voiceModel = voice.get(0);
                this.j.setVoiceModel(voiceModel);
                this.j.setTag(voiceModel);
                this.j.d();
                if (voiceModel != null) {
                    this.j.m(voiceModel.voice_status.intValue());
                }
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            if (l.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.z.setVisibility(0);
                    this.z.setFromCDN(this.A);
                    this.z.setImageClickListener(new C1085c(this, linkedList, threadData));
                    this.z.setImageMediaList(linkedList);
                } else {
                    this.z.setVisibility(8);
                }
            } else {
                this.z.setVisibility(8);
            }
            M();
            E();
            L();
            if ((c.a.p0.f1.b.f().i() || c.a.p0.f1.a.h().j()) && this.k.isInFrsAllThread()) {
                this.F.setVisibility(0);
                if (!this.v.isMarkToDel() && !this.v.isMarkToMove() && !this.v.isTransportThread()) {
                    this.F.setBackgroundResource(R.color.transparent);
                } else {
                    SkinManager.setBackgroundColor(this.F, R.color.CAM_X0201);
                }
            } else {
                this.F.setVisibility(8);
            }
            m(this.w, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
