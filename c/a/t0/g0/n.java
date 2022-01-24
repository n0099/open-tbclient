package c.a.t0.g0;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
public class n extends c.a.t0.g0.b<c.a.t0.g0.f0.k> implements c.a.t0.t.e {
    public static /* synthetic */ Interceptable $ic;
    public static final int L;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstrainImageGroup A;
    public View B;
    public boolean C;
    public boolean D;
    public RelativeLayout E;
    public String F;
    public ThreadForumEnterButton G;
    public String H;
    public View.OnClickListener I;
    public final View.OnClickListener J;
    public final View.OnClickListener K;
    public HeadPendantClickableView m;
    public PlayVoiceBntNew n;
    public ThreadCommentAndPraiseInfoLayout o;
    public ThreadGodReplyLayout p;
    public ThreadUserInfoLayout q;
    public LinearLayout r;
    public NEGFeedBackView s;
    public View t;
    public ThreadSourceShareAndPraiseLayout u;
    public int v;
    public c.a.t0.g0.f0.k w;
    public TbPageContext<?> x;
    public TextView y;
    public TextView z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f17660e;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17660e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17660e.g() != null) {
                    this.f17660e.g().a(view, this.f17660e.w);
                }
                if (this.f17660e.w == null || this.f17660e.w.f17600e == null) {
                    return;
                }
                m.a(this.f17660e.w.f17600e.h0());
                if (this.f17660e.B()) {
                    return;
                }
                m.l(this.f17660e.y, this.f17660e.w.getThreadData().h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
                m.l(this.f17660e.z, this.f17660e.w.f17600e.h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
                m.l(this.f17660e.p.getGodReplyContent(), this.f17660e.w.f17600e.h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f17661e;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17661e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17661e.g() != null) {
                    this.f17661e.g().a(view, this.f17661e.w);
                }
                if (this.f17661e.w == null || this.f17661e.w.f17600e == null) {
                    return;
                }
                n nVar = this.f17661e;
                if (view == nVar.u.mForumNameView) {
                    return;
                }
                m.a(nVar.w.f17600e.h0());
                if (this.f17661e.B()) {
                    return;
                }
                m.l(this.f17661e.y, this.f17661e.w.getThreadData().h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
                m.l(this.f17661e.z, this.f17661e.w.f17600e.h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
                m.l(this.f17661e.p.getGodReplyContent(), this.f17661e.w.f17600e.h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.s0.f1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e2 f17662b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ n f17663c;

        public c(n nVar, LinkedList linkedList, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, linkedList, e2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17663c = nVar;
            this.a = linkedList;
            this.f17662b = e2Var;
        }

        @Override // c.a.s0.f1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                d0<c.a.t0.g0.f0.k> g2 = this.f17663c.g();
                if (g2 != null) {
                    view.setTag("1");
                    if (this.f17663c.K != null) {
                        this.f17663c.K.onClick(this.f17663c.A);
                    }
                    g2.a(view, this.f17663c.w);
                }
                if (z) {
                    this.f17663c.C();
                } else {
                    this.f17663c.O(view, this.a, i2, this.f17662b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f17664e;

        public d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17664e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17664e.w != null) {
                    this.f17664e.w.k = 1;
                }
                if (this.f17664e.g() != null) {
                    this.f17664e.g().a(view, this.f17664e.w);
                }
                n nVar = this.f17664e;
                nVar.D(view == nVar.p);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f17665e;

        public e(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17665e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0<c.a.t0.g0.f0.k> g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f17665e.g()) == null) {
                return;
            }
            view.setTag("2");
            g2.a(view, this.f17665e.w);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f17666e;

        public f(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17666e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17666e.w == null) {
                    if (this.f17666e.g() != null) {
                        this.f17666e.g().a(view, this.f17666e.w);
                        return;
                    }
                    return;
                }
                if (view == this.f17666e.q.getUserName()) {
                    this.f17666e.w.k = 3;
                } else if (view == this.f17666e.q.getHeaderImg()) {
                    this.f17666e.w.k = 4;
                } else if (view == this.f17666e.A) {
                    this.f17666e.w.k = 2;
                    return;
                } else {
                    this.f17666e.w.k = 1;
                }
                if (this.f17666e.g() != null) {
                    this.f17666e.g().a(view, this.f17666e.w);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975383686, "Lc/a/t0/g0/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(975383686, "Lc/a/t0/g0/n;");
                return;
            }
        }
        L = c.a.d.f.p.n.k(TbadkCoreApplication.getInst()) - ((c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.r1.c.M_W_X005) + c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.r1.c.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.s = null;
        this.v = 3;
        this.C = true;
        this.D = true;
        this.I = new d(this);
        this.J = new e(this);
        this.K = new f(this);
        View j2 = j();
        this.x = tbPageContext;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) j2.findViewById(c.a.t0.r1.e.card_home_page_normal_thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setPlaceHolder(1);
            this.m.getHeadView().setRadius(c.a.d.f.p.n.f(this.x.getPageActivity(), c.a.t0.r1.c.ds70));
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.y = (TextView) j2.findViewById(c.a.t0.r1.e.card_home_page_normal_thread_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) j2.findViewById(c.a.t0.r1.e.card_home_page_normal_thread_abstract_voice);
        this.n = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.J);
        this.z = (TextView) j2.findViewById(c.a.t0.r1.e.card_home_page_normal_thread_abstract);
        this.A = (ConstrainImageGroup) j2.findViewById(c.a.t0.r1.e.card_home_page_normal_thread_img_layout);
        this.B = j2.findViewById(c.a.t0.r1.e.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.r1.c.tbds20);
        this.A.setChildClickListener(this.I);
        this.A.setImageMargin(dimensionPixelSize);
        c.a.s0.f1.j.f fVar = new c.a.s0.f1.j.f(3);
        fVar.d(1.0d);
        this.A.setImageProcessor(fVar);
        this.t = j2.findViewById(c.a.t0.r1.e.divider_line_above_praise);
        this.o = (ThreadCommentAndPraiseInfoLayout) j2.findViewById(c.a.t0.r1.e.card_home_page_normal_thread_info_layout);
        this.q = (ThreadUserInfoLayout) j2.findViewById(c.a.t0.r1.e.card_home_page_normal_thread_user_info_layout);
        this.s = new NEGFeedBackView(this.x);
        this.E = (RelativeLayout) j2.findViewById(c.a.t0.r1.e.card_home_page_normal_thread_root);
        this.s.attachToViewUpperRightConner(this.E, c.a.d.f.p.n.f(this.f17590g, c.a.t0.r1.c.tbds120), 0);
        if (this.o.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.o.setLayoutParams(layoutParams);
        }
        this.o.setOnClickListener(this.I);
        this.o.setReplyTimeVisible(false);
        this.o.setShowPraiseNum(true);
        this.o.setNeedAddPraiseIcon(true);
        this.o.setNeedAddReplyIcon(true);
        this.o.setShareVisible(true);
        this.o.setFrom(1);
        this.o.setShareReportFrom(3);
        this.o.setForumAfterClickListener(new a(this));
        this.r = (LinearLayout) j2.findViewById(c.a.t0.r1.e.card_home_page_normal_thread_content_layout);
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) j2.findViewById(c.a.t0.r1.e.card_home_page_god_reply_layout);
        this.p = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this.I);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) j2.findViewById(c.a.t0.r1.e.card_home_page_source_read_share_layout);
        this.u = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this.I);
        this.u.setFrom(1);
        this.u.setShareReportFrom(3);
        this.u.setForumAfterClickListener(new b(this));
        this.G = (ThreadForumEnterButton) j2.findViewById(c.a.t0.r1.e.card_home_page_forum_enter_button);
    }

    public int A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? c.a.t0.t.d.c().b(this.F, i2) : invokeI.intValue;
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.t0.g0.f0.k kVar = this.w;
            return kVar.W && !kVar.X;
        }
        return invokeV.booleanValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            D(false);
        }
    }

    public final void D(boolean z) {
        c.a.t0.g0.f0.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (kVar = this.w) == null || kVar.f17600e == null) {
            return;
        }
        if (!B()) {
            m.a(this.w.f17600e.h0());
            m.l(this.y, this.w.getThreadData().h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
            m.l(this.z, this.w.f17600e.h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
            m.l(this.p.getGodReplyContent(), this.w.f17600e.h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.x.getPageActivity()).createFromThreadCfg(this.w.f17600e, null, m.g(), 18003, true, false, false).addLocateParam(this.w.getPbInputLocate());
        addLocateParam.setForumId(String.valueOf(this.w.f17600e.U()));
        addLocateParam.setFrom("from_personalize");
        addLocateParam.setForumName(this.w.f17600e.b0());
        addLocateParam.setStartFrom(this.l);
        if (z) {
            addLocateParam.setJumpGodReply(true);
        }
        m.a(this.w.getThreadData().w1());
        this.x.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: E */
    public void k(c.a.t0.g0.f0.k kVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            if (kVar != null && kVar.getThreadData() != null) {
                this.w = kVar;
                if (j() != null) {
                    j().setVisibility(0);
                    j().setOnClickListener(this.I);
                }
                if (this.s != null) {
                    SparseArray<String> sparseArray = this.w.feedBackReasonMap;
                    if (sparseArray != null && sparseArray.size() > 0) {
                        x0 x0Var = new x0();
                        x0Var.o(this.w.getThreadData().w1());
                        x0Var.k(this.w.getThreadData().U());
                        x0Var.n(this.w.getThreadData().H0());
                        x0Var.j(this.w.feedBackReasonMap);
                        this.s.setData(x0Var);
                        this.s.setFirstRowSingleColumn(true);
                        if (kVar.f17600e.J() != null && !StringUtils.isNull(kVar.f17600e.J().getUserId())) {
                            if (kVar.f17600e.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                                this.s.setVisibility(8);
                            } else {
                                NEGFeedBackView nEGFeedBackView = this.s;
                                if (nEGFeedBackView != null) {
                                    nEGFeedBackView.setVisibility(this.D ? 0 : 8);
                                }
                            }
                        }
                    } else {
                        this.s.setVisibility(8);
                    }
                }
                this.q.setData(kVar.f17600e);
                this.p.setFromCDN(this.C);
                this.p.setData(kVar.f17600e.z1());
                if (!B() && m.k(this.w.f17600e.h0())) {
                    m.l(this.y, this.w.getThreadData().h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
                    m.l(this.z, this.w.f17600e.h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
                    m.l(this.p.getGodReplyContent(), this.w.f17600e.h0(), c.a.t0.r1.b.CAM_X0105, c.a.t0.r1.b.CAM_X0109);
                }
                this.q.setUserAfterClickListener(this.K);
                e2 threadData = kVar.getThreadData();
                if (this.q.getHeaderImg() != null) {
                    if (this.q.getIsSimpleThread()) {
                        this.q.getHeaderImg().setVisibility(8);
                        this.m.setVisibility(8);
                    } else if (threadData.J() != null && threadData.J().getPendantData() != null && !StringUtils.isNull(threadData.J().getPendantData().getImgUrl())) {
                        this.q.getHeaderImg().setVisibility(4);
                        this.m.setVisibility(0);
                        this.m.setData(threadData);
                    } else {
                        this.m.setVisibility(8);
                        this.q.getHeaderImg().setVisibility(0);
                        this.q.getHeaderImg().setData(threadData);
                    }
                }
                ThreadCardUtils.setTitle(this.y, threadData);
                ThreadCardUtils.setAbstract(this.z, this.y, threadData, L);
                ArrayList<VoiceData$VoiceModel> G1 = kVar.f17600e.G1();
                if (ListUtils.isEmpty(G1)) {
                    this.n.setVisibility(8);
                    z = false;
                } else {
                    this.n.setVisibility(0);
                    VoiceData$VoiceModel voiceData$VoiceModel = G1.get(0);
                    this.n.setVoiceModel(voiceData$VoiceModel);
                    this.n.setTag(voiceData$VoiceModel);
                    this.n.changeSkin();
                    if (voiceData$VoiceModel != null) {
                        this.n.refreshViewState(voiceData$VoiceModel.voice_status.intValue());
                    }
                    this.n.resetLayoutParams();
                    z = true;
                }
                if (this.w.W && z) {
                    this.A.setVisibility(8);
                } else {
                    ArrayList<MediaData> G0 = threadData.G0();
                    if (c.a.s0.s.k.c().g() && ListUtils.getCount(G0) != 0) {
                        LinkedList linkedList = new LinkedList();
                        for (int i2 = 0; i2 < G0.size(); i2++) {
                            MediaData mediaData = (MediaData) ListUtils.getItem(G0, i2);
                            if (mediaData != null && mediaData.getType() == 3) {
                                linkedList.add(mediaData);
                            }
                        }
                        if (ListUtils.getCount(linkedList) > 0) {
                            this.A.setVisibility(0);
                            this.A.setFromCDN(this.C);
                            this.A.setImageClickListener(new c(this, linkedList, threadData));
                            this.A.setImageMediaList(linkedList);
                        } else {
                            this.A.setVisibility(8);
                        }
                    } else {
                        this.A.setVisibility(8);
                    }
                }
                P();
                J();
                L(h());
                this.G.setVisibility(8);
                N(A(1));
                l(this.x, TbadkCoreApplication.getInst().getSkinType());
            } else if (j() != null) {
                j().setVisibility(8);
            }
        }
    }

    public void F(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        L(bdUniqueId);
    }

    public void G(c.a.d.f.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (constrainImageGroup = this.A) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void H(c.a.d.f.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (constrainImageGroup = this.A) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.C = z;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!this.w.X) {
                this.n.setClickable(false);
            } else {
                this.n.setClickable(true);
            }
            int childCount = this.A.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt != null) {
                    if (!this.w.X) {
                        childAt.setClickable(false);
                    } else {
                        childAt.setClickable(true);
                    }
                }
            }
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.D = z;
        }
    }

    public final void L(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            n(bdUniqueId);
            ConstrainImageGroup constrainImageGroup = this.A;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
            NEGFeedBackView nEGFeedBackView = this.s;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setUniqueId(bdUniqueId);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.q;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public void M(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (view = this.B) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void N(int i2) {
        c.a.t0.g0.f0.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (kVar = this.w) == null || kVar.f17600e == null) {
            return;
        }
        this.H = m.g();
        if (i2 == 1) {
            this.o.setVisibility(8);
            this.u.setStType(this.H);
            this.u.setData(this.w.f17600e);
            this.q.showForumNameView(false);
            return;
        }
        this.o.setData(this.w.f17600e);
        this.o.setStType(this.H);
        this.u.setVisibility(8);
        this.q.showForumNameView(true);
    }

    public final void O(View view, List<MediaData> list, int i2, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048590, this, view, list, i2, e2Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                c.a.d.f.p.n.M(this.x.getPageActivity(), c.a.t0.r1.h.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    arrayList.add(mediaData.getSrc_pic());
                    if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = this.C ? 13 : 14;
                        imageUrlData.imageUrl = mediaData.getPicUrl();
                        imageUrlData.originalUrl = mediaData.getOriginalUrl();
                        imageUrlData.originalSize = mediaData.getOriginalSize();
                        imageUrlData.isLongPic = mediaData.isLongPic();
                        imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                        imageUrlData.threadId = c.a.d.f.m.b.g(e2Var.w1(), -1L);
                        imageUrlData.postId = mediaData.getPostId();
                        concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                for (MediaData mediaData2 : list) {
                    if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                        arrayList.add(mediaData2.getPicUrl());
                    }
                }
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(arrayList);
            bVar.B(i2);
            bVar.z(e2Var.b0());
            bVar.y(String.valueOf(e2Var.U()));
            bVar.O(e2Var.w1());
            bVar.C(this.C);
            bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig v = bVar.v(this.x.getPageActivity());
            if (this.l == 2) {
                v.getIntent().putExtra("from", "index");
            } else {
                v.getIntent().putExtra("from", "other");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.x;
            historyMessage.threadId = e2Var.h0();
            historyMessage.threadName = e2Var.getTitle();
            historyMessage.forumName = e2Var.b0();
            historyMessage.postID = e2Var.X();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public final void P() {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.t == null || (constrainImageGroup = this.A) == null || this.p == null) {
            return;
        }
        if (constrainImageGroup.getVisibility() == 8 && this.p.getVisibility() == 8) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    @Override // c.a.t0.t.e
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.F = str;
        }
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? c.a.t0.r1.f.card_home_page_multi_img_new : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i2) == null) {
            if (this.v != i2) {
                SkinManager.setBackgroundResource(j(), c.a.t0.r1.d.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.t, c.a.t0.r1.b.transparent);
                this.A.onChangeSkinType();
                this.o.onChangeSkinType();
                this.p.onChangeSkinType();
                this.q.onChangeSkinType();
                NEGFeedBackView nEGFeedBackView = this.s;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.onChangeSkinType();
                }
                SkinManager.setBackgroundColor(this.B, c.a.t0.r1.b.CAM_X0204);
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.u;
                if (threadSourceShareAndPraiseLayout != null) {
                    threadSourceShareAndPraiseLayout.onChangeSkinType();
                }
            }
            this.v = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
        }
    }
}
