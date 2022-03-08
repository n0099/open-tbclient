package c.a.r0.d1.u2;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import c.a.q0.r.r.a2;
import c.a.q0.r.r.e2;
import c.a.r0.a3.c;
import c.a.r0.a3.t;
import c.a.r0.d1.j1.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AbstractData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageViewModel;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes2.dex */
public final class r extends c.a.r0.f0.b<c.a.r0.d1.j1.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.OnClickListener A;
    public final RelativeLayout B;
    public final HeadImageView C;
    public final EMTextView D;
    public final TextView E;
    public final View.OnClickListener F;
    public final FrameLayout G;
    public final FrameLayout H;
    public final c.a.r0.a3.c I;
    public final OperableVideoNetworkStateTipView J;
    public final RelativeLayout K;
    public final TextView L;
    public int M;
    public final int N;
    public final int O;
    public final int P;
    public final ImageView Q;
    public final RelativeLayout R;
    public final TextView S;
    public final View.OnClickListener T;
    public final FrameLayout U;
    public final TextView V;
    public String W;
    public String X;
    public SpannableString Y;
    public final View.OnClickListener Z;
    public final ThreadCardBottomOpSegmentLayout a0;
    public final c.g0 b0;
    public final c.t c0;
    public final c.f0 d0;
    public final VideoMiddlePageViewModel m;
    public final int n;
    public final int o;
    public c.a.r0.d1.j1.g p;
    public e2 q;
    public int r;
    public int s;
    public boolean t;
    public final View.OnClickListener u;
    public final RelativeLayout v;
    public final BarImageView w;
    public final SingleLineEllipsizeTextView x;
    public final TextView y;
    public final TextView z;

    /* loaded from: classes2.dex */
    public static final class a implements c.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext<?> f16561b;

        public a(r rVar, TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
            this.f16561b = tbPageContext;
        }

        @Override // c.a.r0.a3.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.T()) {
                this.a.F(this.f16561b);
            }
        }

        @Override // c.a.r0.a3.c.t
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.T()) {
                this.a.G(this.f16561b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements c.f0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public b(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.r0.a3.c.f0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.r0.a3.c.f0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.a3.c.f0
        public void onPaused() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.r0.a3.c.f0
        public void onPlayEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.L() == 1 && !this.a.N().R0()) {
                this.a.S().playNextVideo();
            }
        }

        @Override // c.a.r0.a3.c.f0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // c.a.r0.a3.c.f0
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // c.a.r0.a3.c.f0
        public void onUpdateProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1460852868, "Lc/a/r0/d1/u2/r;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1460852868, "Lc/a/r0/d1/u2/r;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(final TbPageContext<?> pageContext, VideoMiddlePageViewModel viewModel) {
        super(pageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, viewModel};
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
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.m = viewModel;
        this.n = (int) (c.a.d.f.p.n.k(pageContext.getPageActivity()) * 0.5625d);
        this.o = (int) (c.a.d.f.p.n.k(pageContext.getPageActivity()) * 1.0d);
        this.s = 1;
        this.u = new View.OnClickListener() { // from class: c.a.r0.d1.u2.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.z(r.this, pageContext, view);
                }
            }
        };
        View findViewById = j().findViewById(R.id.forum_info_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.forum_info_layout)");
        this.v = (RelativeLayout) findViewById;
        View findViewById2 = j().findViewById(R.id.forum_info_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.forum_info_image)");
        this.w = (BarImageView) findViewById2;
        View findViewById3 = j().findViewById(R.id.forum_info_barname);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.forum_info_barname)");
        this.x = (SingleLineEllipsizeTextView) findViewById3;
        View findViewById4 = j().findViewById(R.id.forum_info_author);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.forum_info_author)");
        this.y = (TextView) findViewById4;
        View findViewById5 = j().findViewById(R.id.forum_info_reply_time);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.forum_info_reply_time)");
        this.z = (TextView) findViewById5;
        this.A = new View.OnClickListener() { // from class: c.a.r0.d1.u2.o
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.H(r.this, pageContext, view);
                }
            }
        };
        View findViewById6 = j().findViewById(R.id.user_info_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.user_info_layout)");
        this.B = (RelativeLayout) findViewById6;
        View findViewById7 = j().findViewById(R.id.user_info_avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.user_info_avatar)");
        this.C = (HeadImageView) findViewById7;
        View findViewById8 = j().findViewById(R.id.user_info_name);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.user_info_name)");
        this.D = (EMTextView) findViewById8;
        View findViewById9 = j().findViewById(R.id.user_info_reply_time);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.user_info_reply_time)");
        this.E = (TextView) findViewById9;
        this.F = new View.OnClickListener() { // from class: c.a.r0.d1.u2.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.a0(r.this, pageContext, view);
                }
            }
        };
        View findViewById10 = j().findViewById(R.id.video_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.video_layout)");
        this.G = (FrameLayout) findViewById10;
        View findViewById11 = j().findViewById(R.id.video_container);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.video_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById11;
        this.H = frameLayout;
        this.I = new c.a.r0.a3.c(pageContext, frameLayout, false);
        View findViewById12 = j().findViewById(R.id.video_network_state_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.video_network_state_tip)");
        this.J = (OperableVideoNetworkStateTipView) findViewById12;
        View findViewById13 = j().findViewById(R.id.video_info_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.video_info_layout)");
        this.K = (RelativeLayout) findViewById13;
        View findViewById14 = j().findViewById(R.id.video_info_title);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.video_info_title)");
        this.L = (TextView) findViewById14;
        this.N = 1;
        this.O = 3;
        this.P = (c.a.d.f.p.n.k(TbadkCoreApplication.getInst()) - this.K.getPaddingLeft()) - this.K.getPaddingRight();
        View findViewById15 = j().findViewById(R.id.video_info_expand_title_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "view.findViewById(R.id.v…eo_info_expand_title_btn)");
        this.Q = (ImageView) findViewById15;
        View findViewById16 = j().findViewById(R.id.video_info_expand_title_btn_wrapper);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "view.findViewById(R.id.v…expand_title_btn_wrapper)");
        this.R = (RelativeLayout) findViewById16;
        View findViewById17 = j().findViewById(R.id.video_info_play_count);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "view.findViewById(R.id.video_info_play_count)");
        this.S = (TextView) findViewById17;
        this.T = new View.OnClickListener() { // from class: c.a.r0.d1.u2.i
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.Z(r.this, view);
                }
            }
        };
        View findViewById18 = j().findViewById(R.id.reply_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "view.findViewById(R.id.reply_layout)");
        this.U = (FrameLayout) findViewById18;
        View findViewById19 = j().findViewById(R.id.reply_content);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "view.findViewById(R.id.reply_content)");
        this.V = (TextView) findViewById19;
        this.W = "";
        this.X = "";
        this.Z = new View.OnClickListener() { // from class: c.a.r0.d1.u2.c
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.W(r.this, pageContext, view);
                }
            }
        };
        View findViewById20 = j().findViewById(R.id.op_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "view.findViewById(R.id.op_layout)");
        this.a0 = (ThreadCardBottomOpSegmentLayout) findViewById20;
        this.b0 = new c.g0() { // from class: c.a.r0.d1.u2.f
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // c.a.r0.a3.c.g0
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    r.b0(r.this);
                }
            }
        };
        this.c0 = new a(this, pageContext);
        this.d0 = new b(this);
        this.v.setOnClickListener(this.A);
        this.w.setShowOval(true);
        this.w.setAutoChangeStyle(true);
        this.w.setStrokeWith(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.w.setStrokeColorResId(R.color.CAM_X0401);
        this.w.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.w.setPlaceHolder(1);
        this.w.setOnClickListener(this.A);
        this.x.setEllipsisSuffix(j().getResources().getString(R.string.ellipsis_suffix_bar));
        this.x.setOnClickListener(this.A);
        this.x.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X005), 0, 0);
        this.B.setOnClickListener(this.F);
        this.C.setIsRound(true);
        this.C.setPlaceHolder(1);
        this.C.setOnClickListener(this.F);
        this.D.setOnClickListener(this.F);
        this.I.N1("2005");
        this.I.p1(true);
        this.I.q1(true);
        this.I.r1(true);
        this.I.u1(true);
        this.I.s1(true);
        this.I.q1(true);
        this.I.L1(false, false);
        this.I.n1(false);
        this.I.x1(this.c0);
        this.I.T1(this.b0);
        this.I.k1(this.d0);
        this.J.setPlayViewOnClickListener(new View.OnClickListener() { // from class: c.a.r0.d1.u2.k
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.p(r.this, view);
                }
            }
        });
        MutableLiveData<Configuration> configuration = this.m.getConfiguration();
        Activity pageActivity = pageContext.getPageActivity();
        if (pageActivity != null) {
            configuration.observe((LifecycleOwner) pageActivity, new Observer() { // from class: c.a.r0.d1.u2.l
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        r.q(r.this, pageContext, (Configuration) obj);
                    }
                }
            });
            this.K.setOnClickListener(this.u);
            this.R.setOnClickListener(this.T);
            this.U.setOnClickListener(this.Z);
            this.a0.setReplyTimeVisible(false);
            this.a0.setShowPraiseNum(true);
            this.a0.setNeedAddPraiseIcon(true);
            this.a0.setNeedAddReplyIcon(true);
            this.a0.setShareVisible(true);
            this.a0.hideDisagree();
            l(pageContext, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        if ((r14.length() > 0) == true) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void H(r this$0, TbPageContext pageContext, View view) {
        a2 a2Var;
        a2 a2Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, pageContext, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            c.a.r0.d1.j1.g J = this$0.J();
            boolean z = true;
            if (J != null && (a2Var = J.B) != null && (r14 = a2Var.f13159b) != null) {
            }
            z = false;
            if (z) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this$0.getContext());
                c.a.r0.d1.j1.g J2 = this$0.J();
                String str = null;
                if (J2 != null && (a2Var2 = J2.B) != null) {
                    str = a2Var2.f13159b;
                }
                FrsActivityConfig createNormalCfg = frsActivityConfig.createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                e2 O = this$0.O();
                c.a.r0.d1.j1.g J3 = this$0.J();
                c.a.r0.x3.c.g().c(pageContext.getUniqueId(), c.a.r0.x3.a.d(O, "a023", "common_click", 9, J3 == null ? 0 : J3.I, false, null, null));
            }
        }
    }

    public static final String Q(AbstractData abstractData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, abstractData)) == null) {
            int f2 = c.a.q0.e1.n.e.f(Integer.valueOf(abstractData.type));
            if (f2 != 4) {
                if (f2 == 8) {
                    return "[图片]";
                }
                if (f2 != 17 && f2 != 20) {
                    String str = abstractData.text;
                    if (str == null) {
                        str = "";
                    }
                    return String.valueOf(str);
                }
            }
            return "[表情]";
        }
        return (String) invokeL.objValue;
    }

    public static final void W(r this$0, TbPageContext pageContext, View view) {
        a2 a2Var;
        List<c.a.r0.y3.k0.p> list;
        c.a.r0.y3.k0.p pVar;
        List<c.a.r0.y3.k0.p> list2;
        c.a.r0.y3.k0.p pVar2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, pageContext, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            if (this$0.J() == null) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this$0.f17262g);
            c.a.r0.d1.j1.g J = this$0.J();
            String str2 = null;
            String str3 = J == null ? null : J.f15706f;
            c.a.r0.d1.j1.g J2 = this$0.J();
            String str4 = "";
            if (J2 != null && (list2 = J2.D) != null && (pVar2 = list2.get(0)) != null && (str = pVar2.a) != null) {
                str4 = str;
            }
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(str3, str4, null);
            createNormalCfg.setStartFrom(24);
            c.a.r0.d1.j1.g J3 = this$0.J();
            createNormalCfg.setForumId(J3 == null ? null : J3.f15705e);
            c.a.r0.d1.j1.g J4 = this$0.J();
            createNormalCfg.setForumName((J4 == null || (a2Var = J4.B) == null) ? null : a2Var.f13159b);
            c.a.r0.d1.j1.g J5 = this$0.J();
            if (J5 != null && (list = J5.D) != null && (pVar = list.get(0)) != null) {
                str2 = pVar.a;
            }
            createNormalCfg.setHighLightPostId(str2);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            e2 O = this$0.O();
            c.a.r0.d1.j1.g J6 = this$0.J();
            c.a.r0.x3.c.g().c(pageContext.getUniqueId(), c.a.r0.x3.a.d(O, "a023", "common_click", 5, J6 == null ? 0 : J6.I, false, null, null));
        }
    }

    public static final void Z(r this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.M() == 1) {
                this$0.B(2);
            } else if (this$0.M() == 2) {
                this$0.B(1);
            }
        }
    }

    public static final void a0(r this$0, TbPageContext pageContext, View view) {
        g.b bVar;
        g.b bVar2;
        g.b bVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, this$0, pageContext, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            c.a.r0.d1.j1.g J = this$0.J();
            String str = null;
            String str2 = (J == null || (bVar = J.y) == null) ? null : bVar.a;
            c.a.r0.d1.j1.g J2 = this$0.J();
            String str3 = (J2 == null || (bVar2 = J2.y) == null) ? null : bVar2.f15717c;
            if (str3 == null || StringsKt__StringsJVMKt.isBlank(str3)) {
                c.a.r0.d1.j1.g J3 = this$0.J();
                if (J3 != null && (bVar3 = J3.y) != null) {
                    str = bVar3.f15716b;
                }
                str3 = str;
            }
            if (str2 != null && (StringsKt__StringsJVMKt.isBlank(str2) ^ true)) {
                if (str3 != null && (StringsKt__StringsJVMKt.isBlank(str3) ^ true)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this$0.getContext(), str2, str3)));
                }
            }
            e2 O = this$0.O();
            c.a.r0.d1.j1.g J4 = this$0.J();
            c.a.r0.x3.c.g().c(pageContext.getUniqueId(), c.a.r0.x3.a.d(O, "a023", "common_click", 2, J4 == null ? 0 : J4.I, false, null, null));
        }
    }

    public static final void b0(r this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int K = this$0.K();
            Integer value = this$0.S().getCurPlayingVideoPos().getValue();
            if (value != null && K == value.intValue()) {
                return;
            }
            this$0.S().playVideoAtPosition(this$0.K());
        }
    }

    public static final void p(r this$0, View view) {
        g.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.R().setVisibility(8);
            this$0.R().setHasAgreeToPlay(true);
            this$0.N().j2();
            this$0.N().m1(false);
            c.a.r0.d1.j1.g J = this$0.J();
            if ((J == null ? null : J.z) != null) {
                c.a.r0.a3.c N = this$0.N();
                c.a.r0.d1.j1.g J2 = this$0.J();
                String str = (J2 == null || (cVar = J2.z) == null) ? null : cVar.f15730d;
                c.a.r0.d1.j1.g J3 = this$0.J();
                N.c2(str, J3 != null ? J3.f15706f : null);
            }
        }
    }

    public static final void q(r this$0, TbPageContext pageContext, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, this$0, pageContext, configuration) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            Integer value = this$0.S().getCurPlayingVideoPos().getValue();
            int K = this$0.K();
            if (value != null && value.intValue() == K) {
                int L = this$0.L();
                int i2 = configuration.orientation;
                if (L != i2) {
                    if (i2 == 2) {
                        this$0.F(pageContext);
                    } else {
                        this$0.G(pageContext);
                    }
                    this$0.N().U0(pageContext, configuration);
                    this$0.X(configuration.orientation);
                }
            }
        }
    }

    public static final void z(r this$0, TbPageContext pageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, this$0, pageContext, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            if (this$0.J() == null) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this$0.f17262g);
            c.a.r0.d1.j1.g J = this$0.J();
            pbActivityConfig.createNormalCfg(J == null ? null : J.f15706f, null, null);
            pbActivityConfig.setVideo_source("auto_midpage");
            c.a.r0.d1.j1.g J2 = this$0.J();
            pbActivityConfig.setBjhData(J2 != null ? J2.A : null);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            e2 O = this$0.O();
            c.a.r0.d1.j1.g J3 = this$0.J();
            c.a.r0.x3.c.g().c(pageContext.getUniqueId(), c.a.r0.x3.a.d(O, "a023", "common_click", 1, J3 == null ? 0 : J3.I, false, null, null));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        if ((r0.length() > 0) == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = true;
            if (!StringsKt__StringsJVMKt.isBlank(this.W)) {
                if (this.X.length() > 0) {
                    SpannableString spannableString = this.Y;
                    if (spannableString != null) {
                    }
                    z = false;
                    if (z) {
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0108));
                        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0106));
                        SpannableString spannableString2 = this.Y;
                        if (spannableString2 != null) {
                            spannableString2.setSpan(foregroundColorSpan, 0, this.W.length(), 33);
                        }
                        SpannableString spannableString3 = this.Y;
                        if (spannableString3 != null) {
                            spannableString3.setSpan(foregroundColorSpan2, this.W.length(), this.W.length() + this.X.length(), 33);
                        }
                        this.V.setText(this.Y);
                    }
                }
            }
        }
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.M = i2;
            if (i2 == 0) {
                E();
            } else if (i2 == 1) {
                C();
            } else if (i2 != 2) {
            } else {
                D();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.R.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.Q, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            this.L.setEllipsize(TextUtils.TruncateAt.END);
            this.L.setMaxLines(this.N);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.R.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.Q, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
            this.L.setEllipsize(null);
            this.L.setMaxLines(this.O);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.R.setVisibility(8);
            this.L.setEllipsize(null);
            this.L.setMaxLines(this.N);
        }
    }

    public final void F(TbPageContext<?> tbPageContext) {
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (pageActivity != null) {
                ((BaseFragmentActivity) pageActivity).setSwipeBackEnabled(false);
                Activity pageActivity2 = tbPageContext.getPageActivity();
                View view = null;
                if (pageActivity2 != null && (window = pageActivity2.getWindow()) != null) {
                    view = window.getDecorView();
                }
                if (view != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (this.H.getParent() != null) {
                        if (this.H.getParent() == frameLayout) {
                            frameLayout.removeView(this.H);
                        } else {
                            ViewParent parent = this.H.getParent();
                            FrameLayout frameLayout2 = this.G;
                            if (parent == frameLayout2) {
                                frameLayout2.removeView(this.H);
                            }
                        }
                    }
                    if (this.H.getParent() != null) {
                        return;
                    }
                    frameLayout.addView(this.H);
                    ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
                    if (layoutParams != null) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        layoutParams2.height = -1;
                        this.H.setLayoutParams(layoutParams2);
                        this.I.q0();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.BaseFragmentActivity");
        }
    }

    public final void G(TbPageContext<?> tbPageContext) {
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (pageActivity != null) {
                ((BaseFragmentActivity) pageActivity).setSwipeBackEnabled(true);
                Activity pageActivity2 = tbPageContext.getPageActivity();
                View view = null;
                if (pageActivity2 != null && (window = pageActivity2.getWindow()) != null) {
                    view = window.getDecorView();
                }
                if (view != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (this.H.getParent() != null) {
                        if (this.H.getParent() == frameLayout) {
                            frameLayout.removeView(this.H);
                        } else {
                            ViewParent parent = this.H.getParent();
                            FrameLayout frameLayout2 = this.G;
                            if (parent == frameLayout2) {
                                frameLayout2.removeView(this.H);
                            }
                        }
                    }
                    if (this.H.getParent() != null) {
                        return;
                    }
                    this.G.addView(this.H, 0);
                    ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
                    if (layoutParams != null) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        layoutParams2.height = this.t ? this.o : this.n;
                        this.H.setLayoutParams(layoutParams2);
                        this.I.q0();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.BaseFragmentActivity");
        }
    }

    public final t I(c.a.r0.d1.j1.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gVar)) == null) {
            t tVar = new t();
            tVar.f14940c = gVar.f15706f;
            tVar.t = gVar.f15707g;
            tVar.f14941d = gVar.f15705e;
            tVar.f14942e = TbadkCoreApplication.getCurrentAccount();
            tVar.a = "13";
            tVar.f14943f = gVar.q;
            tVar.f14944g = gVar.r;
            tVar.f14946i = this.m.getFrom();
            tVar.l = gVar.t;
            tVar.k = this.m.getFromTid();
            tVar.o = gVar.s;
            tVar.p = this.t ? "1" : "0";
            tVar.f14947j = gVar.o();
            return tVar;
        }
        return (t) invokeL.objValue;
    }

    public final c.a.r0.d1.j1.g J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p : (c.a.r0.d1.j1.g) invokeV.objValue;
    }

    public final int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.intValue;
    }

    public final int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : invokeV.intValue;
    }

    public final int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.M : invokeV.intValue;
    }

    public final c.a.r0.a3.c N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.I : (c.a.r0.a3.c) invokeV.objValue;
    }

    public final e2 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.q : (e2) invokeV.objValue;
    }

    public final String P(List<? extends AbstractData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            if (list == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (AbstractData abstractData : list) {
                sb.append(Q(abstractData));
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "postContent.toString()");
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public final OperableVideoNetworkStateTipView R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.J : (OperableVideoNetworkStateTipView) invokeV.objValue;
    }

    public final VideoMiddlePageViewModel S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m : (VideoMiddlePageViewModel) invokeV.objValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.t : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: U */
    public void k(c.a.r0.d1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, gVar) == null) {
        }
    }

    public final void V(c.a.r0.d1.j1.g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048595, this, gVar, i2) == null) || gVar == null) {
            return;
        }
        this.p = gVar;
        this.q = c.a.r0.d1.j1.g.g(gVar);
        this.r = i2;
        this.t = gVar.p();
        u(gVar);
        x(i2, gVar);
        y(gVar);
        w(gVar);
        v(gVar, this.q);
    }

    public final void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.s = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Y(g.b bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) || bVar == null) {
            return;
        }
        if (!StringUtils.isNull(bVar.f15718d)) {
            String str = bVar.f15718d;
            Intrinsics.checkNotNullExpressionValue(str, "data.portrait");
            if (StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null)) {
                this.C.startLoad(bVar.f15718d, 10, false);
                this.C.setBjhAuthIconRes(0);
                z = bVar.f15721g;
                if (!z) {
                    this.C.setShowV(z);
                    this.C.setIsBigV(bVar.f15721g);
                } else {
                    boolean z2 = bVar.f15720f;
                    if (z2) {
                        this.C.setShowV(z2);
                        this.C.setIsBigV(bVar.f15720f);
                    } else {
                        this.C.setShowV(z2);
                        this.C.setIsBigV(bVar.f15720f);
                    }
                }
                this.C.setGodIconWidth(R.dimen.tbds36);
            }
        }
        this.C.startLoad(bVar.f15718d, 12, false);
        this.C.setBjhAuthIconRes(0);
        z = bVar.f15721g;
        if (!z) {
        }
        this.C.setGodIconWidth(R.dimen.tbds36);
    }

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? R.layout.card_video_middle_page_light_layout : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> pageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, pageContext, i2) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            SkinManager.setBackgroundColor(j(), R.color.CAM_X0201);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
            int f2 = c.a.d.f.p.n.f(getContext(), R.dimen.tbds42);
            pureDrawable.setBounds(0, 0, f2, f2);
            this.x.setCompoundDrawables(null, null, pureDrawable, null);
            this.x.setCompoundDrawablePadding(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X002));
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.E, (int) R.color.CAM_X0109);
            this.L.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            B(this.M);
            this.S.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.U);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            A();
            this.a0.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.I.v0();
        }
    }

    public final void u(c.a.r0.d1.j1.g gVar) {
        a2 a2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, gVar) == null) {
            String str = null;
            if (gVar.o() == 1 && (a2Var = gVar.B) != null) {
                String str2 = a2Var.f13159b;
                if (str2 != null && (StringsKt__StringsJVMKt.isBlank(str2) ^ true)) {
                    this.v.setVisibility(0);
                    this.B.setVisibility(8);
                    BarImageView barImageView = this.w;
                    a2 a2Var2 = gVar.B;
                    barImageView.startLoad(a2Var2 == null ? null : a2Var2.f13160c, 10, false);
                    SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.x;
                    String string = getContext().getString(R.string.chosen_pb_original_bar);
                    Object[] objArr = new Object[1];
                    a2 a2Var3 = gVar.B;
                    objArr[0] = a2Var3 == null ? null : a2Var3.f13159b;
                    singleLineEllipsizeTextView.setText(String.format(string, objArr));
                    TextView textView = this.y;
                    g.b bVar = gVar.y;
                    if (TextUtils.isEmpty(bVar == null ? null : bVar.f15717c)) {
                        g.b bVar2 = gVar.y;
                        if (bVar2 != null) {
                            str = bVar2.f15716b;
                        }
                    } else {
                        g.b bVar3 = gVar.y;
                        if (bVar3 != null) {
                            str = bVar3.f15717c;
                        }
                    }
                    textView.setText(Intrinsics.stringPlus(str, TbadkCoreApplication.getInst().getString(R.string.home_publish)));
                    if (gVar.C > 0) {
                        this.z.setVisibility(0);
                        this.z.setText(Intrinsics.stringPlus(TbadkCoreApplication.getInst().getString(R.string.repley_when), StringHelper.getFormatTimeForHomeC(gVar.C * 1000)));
                        return;
                    }
                    this.z.setVisibility(8);
                    return;
                }
            }
            this.B.setVisibility(0);
            this.v.setVisibility(8);
            g.b bVar4 = gVar.y;
            Intrinsics.checkNotNullExpressionValue(bVar4, "data.author");
            Y(bVar4);
            EMTextView eMTextView = this.D;
            g.b bVar5 = gVar.y;
            if (TextUtils.isEmpty(bVar5 == null ? null : bVar5.f15717c)) {
                g.b bVar6 = gVar.y;
                if (bVar6 != null) {
                    str = bVar6.f15716b;
                }
            } else {
                g.b bVar7 = gVar.y;
                if (bVar7 != null) {
                    str = bVar7.f15717c;
                }
            }
            eMTextView.setText(str);
            if (gVar.C > 0) {
                this.E.setVisibility(0);
                this.E.setText(Intrinsics.stringPlus(TbadkCoreApplication.getInst().getString(R.string.repley_when), StringHelper.getFormatTimeForHomeC(gVar.C * 1000)));
                return;
            }
            this.E.setVisibility(8);
        }
    }

    public final boolean v(c.a.r0.d1.j1.g gVar, e2 e2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, gVar, e2Var)) == null) ? this.a0.setData(e2Var) : invokeLL.booleanValue;
    }

    public final void w(c.a.r0.d1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, gVar) == null) {
            List<c.a.r0.y3.k0.p> list = gVar.D;
            if ((list == null || list.isEmpty()) ? false : true) {
                this.U.setVisibility(0);
                c.a.r0.y3.k0.p pVar = gVar.D.get(0);
                MetaData metaData = pVar.f25058b;
                String name_show = metaData == null ? null : metaData.getName_show();
                if (name_show == null) {
                    name_show = TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt);
                    Intrinsics.checkNotNullExpressionValue(name_show, "getInst().getString(R.st…ng.user_name_default_txt)");
                }
                this.W = name_show;
                this.X = Intrinsics.stringPlus("：", P(pVar.f25059c));
                this.Y = new SpannableString(Intrinsics.stringPlus(this.W, this.X));
                A();
                return;
            }
            this.U.setVisibility(8);
        }
    }

    public final void x(int i2, c.a.r0.d1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048606, this, i2, gVar) == null) || gVar.z == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = this.t ? this.o : this.n;
            this.G.setLayoutParams(layoutParams2);
            this.I.K1(i2);
            this.I.R1(gVar.z.f15736j);
            this.I.V1(3);
            this.I.S1(gVar.z.f15731e);
            this.I.X1(gVar.z.f15730d, gVar.f15706f);
            this.I.l1(gVar.f15705e);
            this.I.I0().setVideoStatData(I(gVar));
            this.I.Z0();
            this.I.Z1();
            this.J.setVideoLength(gVar.z.f15734h);
            this.J.setVideoDuration(gVar.z.f15731e);
            this.J.setTid(gVar.f15706f);
            if (gVar.F) {
                this.I.b2(false);
                if (this.J.isShowNetworkTips()) {
                    this.J.changeViewLayout(this.t, this.I.R0());
                    this.J.setVisibility(0);
                    this.I.m1(true);
                    return;
                }
                this.J.setVisibility(8);
                this.I.m1(false);
                this.I.c2(gVar.z.f15730d, gVar.f15706f);
                return;
            }
            this.J.setVisibility(8);
            this.I.j2();
            this.I.b2(true);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final void y(c.a.r0.d1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, gVar) == null) {
            String str = gVar.x;
            if (str == null) {
                str = TbadkCoreApplication.getInst().getString(R.string.video_title_str);
                Intrinsics.checkNotNullExpressionValue(str, "getInst().getString(R.string.video_title_str)");
            }
            int i2 = 0;
            float measureText = this.L.getPaint().measureText(str, 0, str.length());
            float textSize = this.L.getTextSize();
            int i3 = this.N;
            if (measureText + (textSize * i3) > this.P * i3) {
                int i4 = this.M;
                i2 = (i4 == 1 || i4 == 2) ? this.M : 1;
            }
            B(i2);
            this.L.setText(str);
            this.S.setText(Intrinsics.stringPlus(StringHelper.numberUniformFormatExtra(gVar.f15710j), TbadkCoreApplication.getInst().getString(R.string.play)));
        }
    }
}
