package b.a.r0.b0;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
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
/* loaded from: classes4.dex */
public class n extends b.a.r0.b0.b<b.a.r0.b0.e0.k> implements b.a.r0.p.e {
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
    public b.a.r0.b0.e0.k w;
    public TbPageContext<?> x;
    public TextView y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f14824e;

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
            this.f14824e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14824e.f() != null) {
                    this.f14824e.f().a(view, this.f14824e.w);
                }
                if (this.f14824e.w == null || this.f14824e.w.f14748e == null) {
                    return;
                }
                m.a(this.f14824e.w.f14748e.f0());
                if (this.f14824e.A()) {
                    return;
                }
                m.l(this.f14824e.y, this.f14824e.w.getThreadData().f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
                m.l(this.f14824e.z, this.f14824e.w.f14748e.f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
                m.l(this.f14824e.p.getGodReplyContent(), this.f14824e.w.f14748e.f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f14825e;

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
            this.f14825e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14825e.f() != null) {
                    this.f14825e.f().a(view, this.f14825e.w);
                }
                if (this.f14825e.w == null || this.f14825e.w.f14748e == null) {
                    return;
                }
                n nVar = this.f14825e;
                if (view == nVar.u.mForumNameView) {
                    return;
                }
                m.a(nVar.w.f14748e.f0());
                if (this.f14825e.A()) {
                    return;
                }
                m.l(this.f14825e.y, this.f14825e.w.getThreadData().f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
                m.l(this.f14825e.z, this.f14825e.w.f14748e.f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
                m.l(this.f14825e.p.getGodReplyContent(), this.f14825e.w.f14748e.f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.a.q0.f1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f14826a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d2 f14827b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ n f14828c;

        public c(n nVar, LinkedList linkedList, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, linkedList, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14828c = nVar;
            this.f14826a = linkedList;
            this.f14827b = d2Var;
        }

        @Override // b.a.q0.f1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                c0<b.a.r0.b0.e0.k> f2 = this.f14828c.f();
                if (f2 != null) {
                    view.setTag("1");
                    if (this.f14828c.K != null) {
                        this.f14828c.K.onClick(this.f14828c.A);
                    }
                    f2.a(view, this.f14828c.w);
                }
                if (z) {
                    this.f14828c.B();
                } else {
                    this.f14828c.U(view, this.f14826a, i2, this.f14827b);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f14829e;

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
            this.f14829e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14829e.w != null) {
                    this.f14829e.w.k = 1;
                }
                if (this.f14829e.f() != null) {
                    this.f14829e.f().a(view, this.f14829e.w);
                }
                n nVar = this.f14829e;
                nVar.D(view == nVar.p);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f14830e;

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
            this.f14830e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c0<b.a.r0.b0.e0.k> f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (f2 = this.f14830e.f()) == null) {
                return;
            }
            view.setTag("2");
            f2.a(view, this.f14830e.w);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f14831e;

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
            this.f14831e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14831e.w == null) {
                    if (this.f14831e.f() != null) {
                        this.f14831e.f().a(view, this.f14831e.w);
                        return;
                    }
                    return;
                }
                if (view == this.f14831e.q.getUserName()) {
                    this.f14831e.w.k = 3;
                } else if (view == this.f14831e.q.getHeaderImg()) {
                    this.f14831e.w.k = 4;
                } else if (view == this.f14831e.A) {
                    this.f14831e.w.k = 2;
                    return;
                } else {
                    this.f14831e.w.k = 1;
                }
                if (this.f14831e.f() != null) {
                    this.f14831e.f().a(view, this.f14831e.w);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1651029988, "Lb/a/r0/b0/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1651029988, "Lb/a/r0/b0/n;");
                return;
            }
        }
        L = b.a.e.e.p.l.k(TbadkCoreApplication.getInst()) - ((b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.j1.c.M_W_X005) + b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.j1.c.M_W_X004)) * 2);
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
        View i4 = i();
        this.x = tbPageContext;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) i4.findViewById(b.a.r0.j1.e.card_home_page_normal_thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setPlaceHolder(1);
            this.m.getHeadView().setRadius(b.a.e.e.p.l.g(this.x.getPageActivity(), b.a.r0.j1.c.ds70));
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.y = (TextView) i4.findViewById(b.a.r0.j1.e.card_home_page_normal_thread_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) i4.findViewById(b.a.r0.j1.e.card_home_page_normal_thread_abstract_voice);
        this.n = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.J);
        this.z = (TextView) i4.findViewById(b.a.r0.j1.e.card_home_page_normal_thread_abstract);
        this.A = (ConstrainImageGroup) i4.findViewById(b.a.r0.j1.e.card_home_page_normal_thread_img_layout);
        this.B = i4.findViewById(b.a.r0.j1.e.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.a.r0.j1.c.tbds20);
        this.A.setChildClickListener(this.I);
        this.A.setImageMargin(dimensionPixelSize);
        b.a.q0.f1.j.f fVar = new b.a.q0.f1.j.f(3);
        fVar.d(1.0d);
        this.A.setImageProcessor(fVar);
        this.t = i4.findViewById(b.a.r0.j1.e.divider_line_above_praise);
        this.o = (ThreadCommentAndPraiseInfoLayout) i4.findViewById(b.a.r0.j1.e.card_home_page_normal_thread_info_layout);
        this.q = (ThreadUserInfoLayout) i4.findViewById(b.a.r0.j1.e.card_home_page_normal_thread_user_info_layout);
        this.s = new NEGFeedBackView(this.x);
        this.E = (RelativeLayout) i4.findViewById(b.a.r0.j1.e.card_home_page_normal_thread_root);
        this.s.attachToViewUpperRightConner(this.E, b.a.e.e.p.l.g(this.f14738g, b.a.r0.j1.c.tbds120), 0);
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
        this.r = (LinearLayout) i4.findViewById(b.a.r0.j1.e.card_home_page_normal_thread_content_layout);
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) i4.findViewById(b.a.r0.j1.e.card_home_page_god_reply_layout);
        this.p = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this.I);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) i4.findViewById(b.a.r0.j1.e.card_home_page_source_read_share_layout);
        this.u = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this.I);
        this.u.setFrom(1);
        this.u.setShareReportFrom(3);
        this.u.setForumAfterClickListener(new b(this));
        this.G = (ThreadForumEnterButton) i4.findViewById(b.a.r0.j1.e.card_home_page_forum_enter_button);
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.r0.b0.e0.k kVar = this.w;
            return kVar.U && !kVar.V;
        }
        return invokeV.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            D(false);
        }
    }

    public final void D(boolean z) {
        b.a.r0.b0.e0.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (kVar = this.w) == null || kVar.f14748e == null) {
            return;
        }
        if (!A()) {
            m.a(this.w.f14748e.f0());
            m.l(this.y, this.w.getThreadData().f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
            m.l(this.z, this.w.f14748e.f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
            m.l(this.p.getGodReplyContent(), this.w.f14748e.f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.x.getPageActivity()).createFromThreadCfg(this.w.f14748e, null, m.g(), 18003, true, false, false).addLocateParam(this.w.getPbInputLocate());
        addLocateParam.setForumId(String.valueOf(this.w.f14748e.T()));
        addLocateParam.setFrom("from_personalize");
        addLocateParam.setForumName(this.w.f14748e.Z());
        addLocateParam.setStartFrom(this.l);
        if (z) {
            addLocateParam.setJumpGodReply(true);
        }
        m.a(this.w.getThreadData().s1());
        this.x.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: I */
    public void j(b.a.r0.b0.e0.k kVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) {
            if (kVar != null && kVar.getThreadData() != null) {
                this.w = kVar;
                if (i() != null) {
                    i().setVisibility(0);
                    i().setOnClickListener(this.I);
                }
                if (this.s != null) {
                    SparseArray<String> sparseArray = this.w.feedBackReasonMap;
                    if (sparseArray != null && sparseArray.size() > 0) {
                        x0 x0Var = new x0();
                        x0Var.o(this.w.getThreadData().s1());
                        x0Var.k(this.w.getThreadData().T());
                        x0Var.n(this.w.getThreadData().F0());
                        x0Var.j(this.w.feedBackReasonMap);
                        this.s.setData(x0Var);
                        this.s.setFirstRowSingleColumn(true);
                        if (kVar.f14748e.J() != null && !StringUtils.isNull(kVar.f14748e.J().getUserId())) {
                            if (kVar.f14748e.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
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
                this.q.setData(kVar.f14748e);
                this.p.setFromCDN(this.C);
                this.p.setData(kVar.f14748e.v1());
                if (!A() && m.k(this.w.f14748e.f0())) {
                    m.l(this.y, this.w.getThreadData().f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
                    m.l(this.z, this.w.f14748e.f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
                    m.l(this.p.getGodReplyContent(), this.w.f14748e.f0(), b.a.r0.j1.b.CAM_X0105, b.a.r0.j1.b.CAM_X0109);
                }
                this.q.setUserAfterClickListener(this.K);
                d2 threadData = kVar.getThreadData();
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
                ArrayList<VoiceData$VoiceModel> D1 = kVar.f14748e.D1();
                if (ListUtils.isEmpty(D1)) {
                    this.n.setVisibility(8);
                    z = false;
                } else {
                    this.n.setVisibility(0);
                    VoiceData$VoiceModel voiceData$VoiceModel = D1.get(0);
                    this.n.setVoiceModel(voiceData$VoiceModel);
                    this.n.setTag(voiceData$VoiceModel);
                    this.n.changeSkin();
                    if (voiceData$VoiceModel != null) {
                        this.n.refreshViewState(voiceData$VoiceModel.voice_status.intValue());
                    }
                    this.n.resetLayoutParams();
                    z = true;
                }
                if (this.w.U && z) {
                    this.A.setVisibility(8);
                } else {
                    ArrayList<MediaData> E0 = threadData.E0();
                    if (b.a.q0.s.k.c().g() && ListUtils.getCount(E0) != 0) {
                        LinkedList linkedList = new LinkedList();
                        for (int i2 = 0; i2 < E0.size(); i2++) {
                            MediaData mediaData = (MediaData) ListUtils.getItem(E0, i2);
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
                V();
                P();
                R(g());
                this.G.setVisibility(8);
                T(z(1));
                k(this.x, TbadkCoreApplication.getInst().getSkinType());
            } else if (i() != null) {
                i().setVisibility(8);
            }
        }
    }

    public void J(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        R(bdUniqueId);
    }

    public void K(b.a.e.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (constrainImageGroup = this.A) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void M(b.a.e.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (constrainImageGroup = this.A) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.C = z;
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!this.w.V) {
                this.n.setClickable(false);
            } else {
                this.n.setClickable(true);
            }
            int childCount = this.A.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt != null) {
                    if (!this.w.V) {
                        childAt.setClickable(false);
                    } else {
                        childAt.setClickable(true);
                    }
                }
            }
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.D = z;
        }
    }

    public final void R(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            m(bdUniqueId);
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

    public void S(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (view = this.B) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void T(int i2) {
        b.a.r0.b0.e0.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (kVar = this.w) == null || kVar.f14748e == null) {
            return;
        }
        this.H = m.g();
        if (i2 == 1) {
            this.o.setVisibility(8);
            this.u.setStType(this.H);
            this.u.setData(this.w.f14748e);
            this.q.showForumNameView(false);
            return;
        }
        this.o.setData(this.w.f14748e);
        this.o.setStType(this.H);
        this.u.setVisibility(8);
        this.q.showForumNameView(true);
    }

    public final void U(View view, List<MediaData> list, int i2, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048589, this, view, list, i2, d2Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                b.a.e.e.p.l.L(this.x.getPageActivity(), b.a.r0.j1.h.plugin_image_viewer_install_error_tips);
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
                        imageUrlData.threadId = b.a.e.e.m.b.g(d2Var.s1(), -1L);
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
            bVar.z(d2Var.Z());
            bVar.y(String.valueOf(d2Var.T()));
            bVar.O(d2Var.s1());
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
            historyMessage.threadId = d2Var.f0();
            historyMessage.threadName = d2Var.getTitle();
            historyMessage.forumName = d2Var.Z();
            historyMessage.postID = d2Var.W();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public final void V() {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.t == null || (constrainImageGroup = this.A) == null || this.p == null) {
            return;
        }
        if (constrainImageGroup.getVisibility() == 8 && this.p.getVisibility() == 8) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? b.a.r0.j1.f.card_home_page_multi_img_new : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, tbPageContext, i2) == null) {
            if (this.v != i2) {
                SkinManager.setBackgroundResource(i(), b.a.r0.j1.d.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.t, b.a.r0.j1.b.transparent);
                this.A.onChangeSkinType();
                this.o.onChangeSkinType();
                this.p.onChangeSkinType();
                this.q.onChangeSkinType();
                NEGFeedBackView nEGFeedBackView = this.s;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.onChangeSkinType();
                }
                SkinManager.setBackgroundColor(this.B, b.a.r0.j1.b.CAM_X0204);
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
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
        }
    }

    @Override // b.a.r0.p.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.F = str;
        }
    }

    public int z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? b.a.r0.p.d.c().b(this.F, i2) : invokeI.intValue;
    }
}
