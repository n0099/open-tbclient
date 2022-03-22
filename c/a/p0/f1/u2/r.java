package c.a.p0.f1.u2;

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
import c.a.o0.r.r.x1;
import c.a.p0.c3.c;
import c.a.p0.c3.u;
import c.a.p0.f1.j1.g;
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
import com.baidu.tbadk.core.data.ThreadData;
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
public final class r extends c.a.p0.h0.b<c.a.p0.f1.j1.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView A;
    public final View.OnClickListener B;
    public final FrameLayout C;
    public final FrameLayout D;
    public final c.a.p0.c3.c E;
    public final OperableVideoNetworkStateTipView F;
    public final RelativeLayout G;
    public final TextView H;
    public int I;
    public final int J;
    public final int K;
    public final int L;
    public final ImageView M;
    public final RelativeLayout N;
    public final TextView O;
    public final View.OnClickListener P;
    public final FrameLayout Q;
    public final TextView R;
    public String S;
    public String T;
    public SpannableString U;
    public final View.OnClickListener V;
    public final ThreadCardBottomOpSegmentLayout W;
    public final c.g0 X;
    public final c.t Y;
    public final c.f0 Z;
    public final VideoMiddlePageViewModel i;
    public final int j;
    public final int k;
    public c.a.p0.f1.j1.g l;
    public ThreadData m;
    public int n;
    public int o;
    public boolean p;
    public final View.OnClickListener q;
    public final RelativeLayout r;
    public final BarImageView s;
    public final SingleLineEllipsizeTextView t;
    public final TextView u;
    public final TextView v;
    public final View.OnClickListener w;
    public final RelativeLayout x;
    public final HeadImageView y;
    public final EMTextView z;

    /* loaded from: classes2.dex */
    public static final class a implements c.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext<?> f14738b;

        public a(r rVar, TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
            this.f14738b = tbPageContext;
        }

        @Override // c.a.p0.c3.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.U()) {
                this.a.G(this.f14738b);
            }
        }

        @Override // c.a.p0.c3.c.t
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.U()) {
                this.a.H(this.f14738b);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.p0.c3.c.f0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.p0.c3.c.f0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.p0.c3.c.f0
        public void onPaused() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.p0.c3.c.f0
        public void onPlayEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.M() == 1 && !this.a.O().R0()) {
                this.a.T().n();
            }
        }

        @Override // c.a.p0.c3.c.f0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // c.a.p0.c3.c.f0
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // c.a.p0.c3.c.f0
        public void onUpdateProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-49558336, "Lc/a/p0/f1/u2/r;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-49558336, "Lc/a/p0/f1/u2/r;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.i = viewModel;
        this.j = (int) (c.a.d.f.p.n.k(pageContext.getPageActivity()) * 0.5625d);
        this.k = (int) (c.a.d.f.p.n.k(pageContext.getPageActivity()) * 1.0d);
        this.o = 1;
        this.q = new View.OnClickListener() { // from class: c.a.p0.f1.u2.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.A(r.this, pageContext, view);
                }
            }
        };
        View findViewById = k().findViewById(R.id.obfuscated_res_0x7f090a51);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.forum_info_layout)");
        this.r = (RelativeLayout) findViewById;
        View findViewById2 = k().findViewById(R.id.obfuscated_res_0x7f090a50);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.forum_info_image)");
        this.s = (BarImageView) findViewById2;
        View findViewById3 = k().findViewById(R.id.obfuscated_res_0x7f090a4f);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.forum_info_barname)");
        this.t = (SingleLineEllipsizeTextView) findViewById3;
        View findViewById4 = k().findViewById(R.id.obfuscated_res_0x7f090a4e);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.forum_info_author)");
        this.u = (TextView) findViewById4;
        View findViewById5 = k().findViewById(R.id.obfuscated_res_0x7f090a53);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.forum_info_reply_time)");
        this.v = (TextView) findViewById5;
        this.w = new View.OnClickListener() { // from class: c.a.p0.f1.u2.o
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.I(r.this, pageContext, view);
                }
            }
        };
        View findViewById6 = k().findViewById(R.id.obfuscated_res_0x7f0922b0);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.user_info_layout)");
        this.x = (RelativeLayout) findViewById6;
        View findViewById7 = k().findViewById(R.id.obfuscated_res_0x7f0922ae);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.user_info_avatar)");
        this.y = (HeadImageView) findViewById7;
        View findViewById8 = k().findViewById(R.id.obfuscated_res_0x7f0922b2);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.user_info_name)");
        this.z = (EMTextView) findViewById8;
        View findViewById9 = k().findViewById(R.id.obfuscated_res_0x7f0922b3);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.user_info_reply_time)");
        this.A = (TextView) findViewById9;
        this.B = new View.OnClickListener() { // from class: c.a.p0.f1.u2.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.b0(r.this, pageContext, view);
                }
            }
        };
        View findViewById10 = k().findViewById(R.id.obfuscated_res_0x7f09233d);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.video_layout)");
        this.C = (FrameLayout) findViewById10;
        View findViewById11 = k().findViewById(R.id.obfuscated_res_0x7f09231b);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.video_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById11;
        this.D = frameLayout;
        this.E = new c.a.p0.c3.c(pageContext, frameLayout, false);
        View findViewById12 = k().findViewById(R.id.obfuscated_res_0x7f09234e);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.video_network_state_tip)");
        this.F = (OperableVideoNetworkStateTipView) findViewById12;
        View findViewById13 = k().findViewById(R.id.obfuscated_res_0x7f092339);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.video_info_layout)");
        this.G = (RelativeLayout) findViewById13;
        View findViewById14 = k().findViewById(R.id.obfuscated_res_0x7f09233b);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.video_info_title)");
        this.H = (TextView) findViewById14;
        this.J = 1;
        this.K = 3;
        this.L = (c.a.d.f.p.n.k(TbadkCoreApplication.getInst()) - this.G.getPaddingLeft()) - this.G.getPaddingRight();
        View findViewById15 = k().findViewById(R.id.obfuscated_res_0x7f092334);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "view.findViewById(R.id.v…eo_info_expand_title_btn)");
        this.M = (ImageView) findViewById15;
        View findViewById16 = k().findViewById(R.id.obfuscated_res_0x7f092335);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "view.findViewById(R.id.v…expand_title_btn_wrapper)");
        this.N = (RelativeLayout) findViewById16;
        View findViewById17 = k().findViewById(R.id.obfuscated_res_0x7f09233a);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "view.findViewById(R.id.video_info_play_count)");
        this.O = (TextView) findViewById17;
        this.P = new View.OnClickListener() { // from class: c.a.p0.f1.u2.i
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.a0(r.this, view);
                }
            }
        };
        View findViewById18 = k().findViewById(R.id.obfuscated_res_0x7f091a61);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "view.findViewById(R.id.reply_layout)");
        this.Q = (FrameLayout) findViewById18;
        View findViewById19 = k().findViewById(R.id.obfuscated_res_0x7f091a5a);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "view.findViewById(R.id.reply_content)");
        this.R = (TextView) findViewById19;
        this.S = "";
        this.T = "";
        this.V = new View.OnClickListener() { // from class: c.a.p0.f1.u2.c
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.X(r.this, pageContext, view);
                }
            }
        };
        View findViewById20 = k().findViewById(R.id.obfuscated_res_0x7f091601);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "view.findViewById(R.id.op_layout)");
        this.W = (ThreadCardBottomOpSegmentLayout) findViewById20;
        this.X = new c.g0() { // from class: c.a.p0.f1.u2.f
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // c.a.p0.c3.c.g0
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    r.c0(r.this);
                }
            }
        };
        this.Y = new a(this, pageContext);
        this.Z = new b(this);
        this.r.setOnClickListener(this.w);
        this.s.setShowOval(true);
        this.s.setAutoChangeStyle(true);
        this.s.setStrokeWith(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.s.setStrokeColorResId(R.color.CAM_X0401);
        this.s.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.s.setPlaceHolder(1);
        this.s.setOnClickListener(this.w);
        this.t.setEllipsisSuffix(k().getResources().getString(R.string.obfuscated_res_0x7f0f0526));
        this.t.setOnClickListener(this.w);
        this.t.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X005), 0, 0);
        this.x.setOnClickListener(this.B);
        this.y.setIsRound(true);
        this.y.setPlaceHolder(1);
        this.y.setOnClickListener(this.B);
        this.z.setOnClickListener(this.B);
        this.E.N1("2005");
        this.E.p1(true);
        this.E.q1(true);
        this.E.r1(true);
        this.E.u1(true);
        this.E.s1(true);
        this.E.q1(true);
        this.E.L1(false, false);
        this.E.n1(false);
        this.E.x1(this.Y);
        this.E.T1(this.X);
        this.E.k1(this.Z);
        this.F.setPlayViewOnClickListener(new View.OnClickListener() { // from class: c.a.p0.f1.u2.k
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    r.q(r.this, view);
                }
            }
        });
        MutableLiveData<Configuration> b2 = this.i.b();
        Activity pageActivity = pageContext.getPageActivity();
        if (pageActivity != null) {
            b2.observe((LifecycleOwner) pageActivity, new Observer() { // from class: c.a.p0.f1.u2.l
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        r.s(r.this, pageContext, (Configuration) obj);
                    }
                }
            });
            this.G.setOnClickListener(this.q);
            this.N.setOnClickListener(this.P);
            this.Q.setOnClickListener(this.V);
            this.W.setReplyTimeVisible(false);
            this.W.setShowPraiseNum(true);
            this.W.setNeedAddPraiseIcon(true);
            this.W.setNeedAddReplyIcon(true);
            this.W.setShareVisible(true);
            this.W.hideDisagree();
            m(pageContext, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public static final void A(r this$0, TbPageContext pageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, pageContext, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            if (this$0.K() == null) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this$0.f15305c);
            c.a.p0.f1.j1.g K = this$0.K();
            pbActivityConfig.createNormalCfg(K == null ? null : K.f14123b, null, null);
            pbActivityConfig.setVideo_source("auto_midpage");
            c.a.p0.f1.j1.g K2 = this$0.K();
            pbActivityConfig.setBjhData(K2 != null ? K2.w : null);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            ThreadData P = this$0.P();
            c.a.p0.f1.j1.g K3 = this$0.K();
            c.a.p0.z3.c.g().c(pageContext.getUniqueId(), c.a.p0.z3.a.d(P, "a023", "common_click", 1, K3 == null ? 0 : K3.E, false, null, null));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        if ((r14.length() > 0) == true) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void I(r this$0, TbPageContext pageContext, View view) {
        x1 x1Var;
        x1 x1Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, this$0, pageContext, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            c.a.p0.f1.j1.g K = this$0.K();
            boolean z = true;
            if (K != null && (x1Var = K.x) != null && (r14 = x1Var.f10991b) != null) {
            }
            z = false;
            if (z) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this$0.getContext());
                c.a.p0.f1.j1.g K2 = this$0.K();
                String str = null;
                if (K2 != null && (x1Var2 = K2.x) != null) {
                    str = x1Var2.f10991b;
                }
                FrsActivityConfig createNormalCfg = frsActivityConfig.createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                ThreadData P = this$0.P();
                c.a.p0.f1.j1.g K3 = this$0.K();
                c.a.p0.z3.c.g().c(pageContext.getUniqueId(), c.a.p0.z3.a.d(P, "a023", "common_click", 9, K3 == null ? 0 : K3.E, false, null, null));
            }
        }
    }

    public static final String R(AbstractData abstractData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, abstractData)) == null) {
            int f2 = c.a.o0.e1.n.e.f(Integer.valueOf(abstractData.type));
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

    public static final void X(r this$0, TbPageContext pageContext, View view) {
        x1 x1Var;
        List<c.a.p0.a4.k0.p> list;
        c.a.p0.a4.k0.p pVar;
        List<c.a.p0.a4.k0.p> list2;
        c.a.p0.a4.k0.p pVar2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, this$0, pageContext, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            if (this$0.K() == null) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this$0.f15305c);
            c.a.p0.f1.j1.g K = this$0.K();
            String str2 = null;
            String str3 = K == null ? null : K.f14123b;
            c.a.p0.f1.j1.g K2 = this$0.K();
            String str4 = "";
            if (K2 != null && (list2 = K2.z) != null && (pVar2 = list2.get(0)) != null && (str = pVar2.a) != null) {
                str4 = str;
            }
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(str3, str4, null);
            createNormalCfg.setStartFrom(24);
            c.a.p0.f1.j1.g K3 = this$0.K();
            createNormalCfg.setForumId(K3 == null ? null : K3.a);
            c.a.p0.f1.j1.g K4 = this$0.K();
            createNormalCfg.setForumName((K4 == null || (x1Var = K4.x) == null) ? null : x1Var.f10991b);
            c.a.p0.f1.j1.g K5 = this$0.K();
            if (K5 != null && (list = K5.z) != null && (pVar = list.get(0)) != null) {
                str2 = pVar.a;
            }
            createNormalCfg.setHighLightPostId(str2);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            ThreadData P = this$0.P();
            c.a.p0.f1.j1.g K6 = this$0.K();
            c.a.p0.z3.c.g().c(pageContext.getUniqueId(), c.a.p0.z3.a.d(P, "a023", "common_click", 5, K6 == null ? 0 : K6.E, false, null, null));
        }
    }

    public static final void a0(r this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.N() == 1) {
                this$0.C(2);
            } else if (this$0.N() == 2) {
                this$0.C(1);
            }
        }
    }

    public static final void b0(r this$0, TbPageContext pageContext, View view) {
        g.b bVar;
        g.b bVar2;
        g.b bVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, this$0, pageContext, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            c.a.p0.f1.j1.g K = this$0.K();
            String str = null;
            String str2 = (K == null || (bVar = K.u) == null) ? null : bVar.a;
            c.a.p0.f1.j1.g K2 = this$0.K();
            String str3 = (K2 == null || (bVar2 = K2.u) == null) ? null : bVar2.f14136c;
            if (str3 == null || StringsKt__StringsJVMKt.isBlank(str3)) {
                c.a.p0.f1.j1.g K3 = this$0.K();
                if (K3 != null && (bVar3 = K3.u) != null) {
                    str = bVar3.f14135b;
                }
                str3 = str;
            }
            if (str2 != null && (StringsKt__StringsJVMKt.isBlank(str2) ^ true)) {
                if (str3 != null && (StringsKt__StringsJVMKt.isBlank(str3) ^ true)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this$0.getContext(), str2, str3)));
                }
            }
            ThreadData P = this$0.P();
            c.a.p0.f1.j1.g K4 = this$0.K();
            c.a.p0.z3.c.g().c(pageContext.getUniqueId(), c.a.p0.z3.a.d(P, "a023", "common_click", 2, K4 == null ? 0 : K4.E, false, null, null));
        }
    }

    public static final void c0(r this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int L = this$0.L();
            Integer value = this$0.T().c().getValue();
            if (value != null && L == value.intValue()) {
                return;
            }
            this$0.T().o(this$0.L());
        }
    }

    public static final void q(r this$0, View view) {
        g.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.S().setVisibility(8);
            this$0.S().setHasAgreeToPlay(true);
            this$0.O().j2();
            this$0.O().m1(false);
            c.a.p0.f1.j1.g K = this$0.K();
            if ((K == null ? null : K.v) != null) {
                c.a.p0.c3.c O = this$0.O();
                c.a.p0.f1.j1.g K2 = this$0.K();
                String str = (K2 == null || (cVar = K2.v) == null) ? null : cVar.f14149d;
                c.a.p0.f1.j1.g K3 = this$0.K();
                O.c2(str, K3 != null ? K3.f14123b : null);
            }
        }
    }

    public static final void s(r this$0, TbPageContext pageContext, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, this$0, pageContext, configuration) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            Integer value = this$0.T().c().getValue();
            int L = this$0.L();
            if (value != null && value.intValue() == L) {
                int M = this$0.M();
                int i = configuration.orientation;
                if (M != i) {
                    if (i == 2) {
                        this$0.G(pageContext);
                    } else {
                        this$0.H(pageContext);
                    }
                    this$0.O().U0(pageContext, configuration);
                    this$0.Y(configuration.orientation);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        if ((r0.length() > 0) == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = true;
            if (!StringsKt__StringsJVMKt.isBlank(this.S)) {
                if (this.T.length() > 0) {
                    SpannableString spannableString = this.U;
                    if (spannableString != null) {
                    }
                    z = false;
                    if (z) {
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0108));
                        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0106));
                        SpannableString spannableString2 = this.U;
                        if (spannableString2 != null) {
                            spannableString2.setSpan(foregroundColorSpan, 0, this.S.length(), 33);
                        }
                        SpannableString spannableString3 = this.U;
                        if (spannableString3 != null) {
                            spannableString3.setSpan(foregroundColorSpan2, this.S.length(), this.S.length() + this.T.length(), 33);
                        }
                        this.R.setText(this.U);
                    }
                }
            }
        }
    }

    public final void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.I = i;
            if (i == 0) {
                F();
            } else if (i == 1) {
                D();
            } else if (i != 2) {
            } else {
                E();
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.N.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.M, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            this.H.setEllipsize(TextUtils.TruncateAt.END);
            this.H.setMaxLines(this.J);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.N.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.M, R.drawable.obfuscated_res_0x7f0808ff, R.color.CAM_X0105, null);
            this.H.setEllipsize(null);
            this.H.setMaxLines(this.K);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.N.setVisibility(8);
            this.H.setEllipsize(null);
            this.H.setMaxLines(this.J);
        }
    }

    public final void G(TbPageContext<?> tbPageContext) {
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
                    if (this.D.getParent() != null) {
                        if (this.D.getParent() == frameLayout) {
                            frameLayout.removeView(this.D);
                        } else {
                            ViewParent parent = this.D.getParent();
                            FrameLayout frameLayout2 = this.C;
                            if (parent == frameLayout2) {
                                frameLayout2.removeView(this.D);
                            }
                        }
                    }
                    if (this.D.getParent() != null) {
                        return;
                    }
                    frameLayout.addView(this.D);
                    ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
                    if (layoutParams != null) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        layoutParams2.height = -1;
                        this.D.setLayoutParams(layoutParams2);
                        this.E.q0();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.BaseFragmentActivity");
        }
    }

    public final void H(TbPageContext<?> tbPageContext) {
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
                    if (this.D.getParent() != null) {
                        if (this.D.getParent() == frameLayout) {
                            frameLayout.removeView(this.D);
                        } else {
                            ViewParent parent = this.D.getParent();
                            FrameLayout frameLayout2 = this.C;
                            if (parent == frameLayout2) {
                                frameLayout2.removeView(this.D);
                            }
                        }
                    }
                    if (this.D.getParent() != null) {
                        return;
                    }
                    this.C.addView(this.D, 0);
                    ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
                    if (layoutParams != null) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        layoutParams2.height = this.p ? this.k : this.j;
                        this.D.setLayoutParams(layoutParams2);
                        this.E.q0();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.BaseFragmentActivity");
        }
    }

    public final u J(c.a.p0.f1.j1.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gVar)) == null) {
            u uVar = new u();
            uVar.f13504c = gVar.f14123b;
            uVar.t = gVar.f14124c;
            uVar.f13505d = gVar.a;
            uVar.f13506e = TbadkCoreApplication.getCurrentAccount();
            uVar.a = "13";
            uVar.f13507f = gVar.m;
            uVar.f13508g = gVar.n;
            uVar.i = this.i.d();
            uVar.l = gVar.p;
            uVar.k = this.i.e();
            uVar.o = gVar.o;
            uVar.p = this.p ? "1" : "0";
            uVar.j = gVar.i();
            return uVar;
        }
        return (u) invokeL.objValue;
    }

    public final c.a.p0.f1.j1.g K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : (c.a.p0.f1.j1.g) invokeV.objValue;
    }

    public final int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.n : invokeV.intValue;
    }

    public final int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : invokeV.intValue;
    }

    public final int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.I : invokeV.intValue;
    }

    public final c.a.p0.c3.c O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.E : (c.a.p0.c3.c) invokeV.objValue;
    }

    public final ThreadData P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.m : (ThreadData) invokeV.objValue;
    }

    public final String Q(List<? extends AbstractData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            if (list == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (AbstractData abstractData : list) {
                sb.append(R(abstractData));
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "postContent.toString()");
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public final OperableVideoNetworkStateTipView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.F : (OperableVideoNetworkStateTipView) invokeV.objValue;
    }

    public final VideoMiddlePageViewModel T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.i : (VideoMiddlePageViewModel) invokeV.objValue;
    }

    public final boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.p : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: V */
    public void l(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, gVar) == null) {
        }
    }

    public final void W(c.a.p0.f1.j1.g gVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048595, this, gVar, i) == null) || gVar == null) {
            return;
        }
        this.l = gVar;
        this.m = c.a.p0.f1.j1.g.e(gVar);
        this.n = i;
        this.p = gVar.k();
        v(gVar);
        y(i, gVar);
        z(gVar);
        x(gVar);
        w(gVar, this.m);
    }

    public final void Y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.o = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Z(g.b bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) || bVar == null) {
            return;
        }
        if (!StringUtils.isNull(bVar.f14137d)) {
            String str = bVar.f14137d;
            Intrinsics.checkNotNullExpressionValue(str, "data.portrait");
            if (StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null)) {
                this.y.J(bVar.f14137d, 10, false);
                this.y.setBjhAuthIconRes(0);
                z = bVar.f14140g;
                if (!z) {
                    this.y.setShowV(z);
                    this.y.setIsBigV(bVar.f14140g);
                } else {
                    boolean z2 = bVar.f14139f;
                    if (z2) {
                        this.y.setShowV(z2);
                        this.y.setIsBigV(bVar.f14139f);
                    } else {
                        this.y.setShowV(z2);
                        this.y.setIsBigV(bVar.f14139f);
                    }
                }
                this.y.setGodIconWidth(R.dimen.tbds36);
            }
        }
        this.y.J(bVar.f14137d, 12, false);
        this.y.setBjhAuthIconRes(0);
        z = bVar.f14140g;
        if (!z) {
        }
        this.y.setGodIconWidth(R.dimen.tbds36);
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? R.layout.obfuscated_res_0x7f0d01c9 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> pageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, pageContext, i) == null) {
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            SkinManager.setBackgroundColor(k(), R.color.CAM_X0201);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
            int f2 = c.a.d.f.p.n.f(getContext(), R.dimen.tbds42);
            pureDrawable.setBounds(0, 0, f2, f2);
            this.t.setCompoundDrawables(null, null, pureDrawable, null);
            this.t.setCompoundDrawablePadding(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X002));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.A, (int) R.color.CAM_X0109);
            this.H.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            C(this.I);
            this.O.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.Q);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            B();
            this.W.onChangeSkinType();
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
            this.E.v0();
        }
    }

    public final void v(c.a.p0.f1.j1.g gVar) {
        x1 x1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, gVar) == null) {
            String str = null;
            if (gVar.i() == 1 && (x1Var = gVar.x) != null) {
                String str2 = x1Var.f10991b;
                if (str2 != null && (StringsKt__StringsJVMKt.isBlank(str2) ^ true)) {
                    this.r.setVisibility(0);
                    this.x.setVisibility(8);
                    BarImageView barImageView = this.s;
                    x1 x1Var2 = gVar.x;
                    barImageView.J(x1Var2 == null ? null : x1Var2.f10992c, 10, false);
                    SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.t;
                    String string = getContext().getString(R.string.obfuscated_res_0x7f0f03c0);
                    Object[] objArr = new Object[1];
                    x1 x1Var3 = gVar.x;
                    objArr[0] = x1Var3 == null ? null : x1Var3.f10991b;
                    singleLineEllipsizeTextView.setText(String.format(string, objArr));
                    TextView textView = this.u;
                    g.b bVar = gVar.u;
                    if (TextUtils.isEmpty(bVar == null ? null : bVar.f14136c)) {
                        g.b bVar2 = gVar.u;
                        if (bVar2 != null) {
                            str = bVar2.f14135b;
                        }
                    } else {
                        g.b bVar3 = gVar.u;
                        if (bVar3 != null) {
                            str = bVar3.f14136c;
                        }
                    }
                    textView.setText(Intrinsics.stringPlus(str, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0848)));
                    if (gVar.y > 0) {
                        this.v.setVisibility(0);
                        this.v.setText(Intrinsics.stringPlus(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f87), StringHelper.getFormatTimeForHomeC(gVar.y * 1000)));
                        return;
                    }
                    this.v.setVisibility(8);
                    return;
                }
            }
            this.x.setVisibility(0);
            this.r.setVisibility(8);
            g.b bVar4 = gVar.u;
            Intrinsics.checkNotNullExpressionValue(bVar4, "data.author");
            Z(bVar4);
            EMTextView eMTextView = this.z;
            g.b bVar5 = gVar.u;
            if (TextUtils.isEmpty(bVar5 == null ? null : bVar5.f14136c)) {
                g.b bVar6 = gVar.u;
                if (bVar6 != null) {
                    str = bVar6.f14135b;
                }
            } else {
                g.b bVar7 = gVar.u;
                if (bVar7 != null) {
                    str = bVar7.f14136c;
                }
            }
            eMTextView.setText(str);
            if (gVar.y > 0) {
                this.A.setVisibility(0);
                this.A.setText(Intrinsics.stringPlus(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f87), StringHelper.getFormatTimeForHomeC(gVar.y * 1000)));
                return;
            }
            this.A.setVisibility(8);
        }
    }

    public final boolean w(c.a.p0.f1.j1.g gVar, ThreadData threadData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, gVar, threadData)) == null) ? this.W.setData(threadData) : invokeLL.booleanValue;
    }

    public final void x(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, gVar) == null) {
            List<c.a.p0.a4.k0.p> list = gVar.z;
            if ((list == null || list.isEmpty()) ? false : true) {
                this.Q.setVisibility(0);
                c.a.p0.a4.k0.p pVar = gVar.z.get(0);
                MetaData metaData = pVar.f12258b;
                String name_show = metaData == null ? null : metaData.getName_show();
                if (name_show == null) {
                    name_show = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14ac);
                    Intrinsics.checkNotNullExpressionValue(name_show, "getInst().getString(R.st…ng.user_name_default_txt)");
                }
                this.S = name_show;
                this.T = Intrinsics.stringPlus("：", Q(pVar.f12259c));
                this.U = new SpannableString(Intrinsics.stringPlus(this.S, this.T));
                B();
                return;
            }
            this.Q.setVisibility(8);
        }
    }

    public final void y(int i, c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048606, this, i, gVar) == null) || gVar.v == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = this.p ? this.k : this.j;
            this.C.setLayoutParams(layoutParams2);
            this.E.K1(i);
            this.E.R1(gVar.v.j);
            this.E.V1(3);
            this.E.S1(gVar.v.f14150e);
            this.E.X1(gVar.v.f14149d, gVar.f14123b);
            this.E.l1(gVar.a);
            this.E.I0().setVideoStatData(J(gVar));
            this.E.Z0();
            this.E.Z1();
            this.F.setVideoLength(gVar.v.f14153h);
            this.F.setVideoDuration(gVar.v.f14150e);
            this.F.setTid(gVar.f14123b);
            if (gVar.B) {
                this.E.b2(false);
                if (this.F.d()) {
                    this.F.a(this.p, this.E.R0());
                    this.F.setVisibility(0);
                    this.E.m1(true);
                    return;
                }
                this.F.setVisibility(8);
                this.E.m1(false);
                this.E.c2(gVar.v.f14149d, gVar.f14123b);
                return;
            }
            this.F.setVisibility(8);
            this.E.j2();
            this.E.b2(true);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final void z(c.a.p0.f1.j1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, gVar) == null) {
            String str = gVar.t;
            if (str == null) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14f7);
                Intrinsics.checkNotNullExpressionValue(str, "getInst().getString(R.string.video_title_str)");
            }
            int i = 0;
            float measureText = this.H.getPaint().measureText(str, 0, str.length());
            float textSize = this.H.getTextSize();
            int i2 = this.J;
            if (measureText + (textSize * i2) > this.L * i2) {
                int i3 = this.I;
                i = (i3 == 1 || i3 == 2) ? this.I : 1;
            }
            C(i);
            this.H.setText(str);
            this.O.setText(Intrinsics.stringPlus(StringHelper.numberUniformFormatExtra(gVar.f14127f), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e49)));
        }
    }
}
