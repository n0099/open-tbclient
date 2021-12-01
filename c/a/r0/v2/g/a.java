package c.a.r0.v2.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.d1.q0;
import c.a.r0.f2.c;
import c.a.r0.v2.e.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.tieba.view.GodRecommendLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import tbclient.BaijiahaoInfo;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final int b0;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadPendantView A;
    public RelativeLayout B;
    public GodRecommendLayout C;
    public ImageView D;
    public TBLottieAnimationView E;
    public AnimatorSet F;
    public View G;
    public View.OnClickListener H;
    public ViewGroup I;
    public View J;
    public TextView K;
    public ImageView L;
    public View M;
    public TextView N;
    public ImageView O;
    public c.a.r0.f2.c P;
    public boolean Q;
    public AnimatorSet R;
    public ValueAnimator S;
    public ObjectAnimator T;
    public ObjectAnimator U;
    public c.a.r0.v2.d.a V;
    public boolean W;
    public boolean X;
    public FollowUserSpinnerBtn.b Y;
    public c.b Z;
    public TbPageContext a;
    public View.OnClickListener a0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24829b;

    /* renamed from: c  reason: collision with root package name */
    public View f24830c;

    /* renamed from: d  reason: collision with root package name */
    public UserData f24831d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.j1.b f24832e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24833f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24834g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f24835h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f24836i;

    /* renamed from: j  reason: collision with root package name */
    public UserIconBox f24837j;

    /* renamed from: k  reason: collision with root package name */
    public FrameLayout f24838k;
    public TextView l;
    public TextView m;
    public FrameLayout n;
    public TextView o;
    public TextView p;
    public FrameLayout q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public FollowUserSpinnerBtn w;
    public TBSpecificationBtn x;
    public TbImageView y;
    public ImageView z;

    /* renamed from: c.a.r0.v2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1416a implements FollowUserSpinnerBtn.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1416a(a aVar) {
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
            this.a = aVar;
        }

        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.b
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                this.a.W = z2;
                this.a.X = false;
                if (z) {
                    this.a.C.setCouldStatistic(true);
                    if (this.a.f24831d != null) {
                        this.a.P.i(this.a.f24831d.getPortrait(), 0);
                    }
                } else {
                    this.a.C.setCouldStatistic(false);
                    this.a.Q = false;
                    this.a.J();
                    if (this.a.R != null) {
                        this.a.R.start();
                    }
                }
                if (!z || z2) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13900"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.r0.f2.c.b
        public void a(q qVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, qVar, i2) == null) {
                if (qVar == null || i2 != 0) {
                    if (i2 == 1) {
                        BdToast.c(this.a.a.getPageActivity(), this.a.a.getPageActivity().getText(c.a.r0.w2.g.god_get_error)).q();
                        return;
                    } else if (i2 == 3) {
                        BdToast.c(this.a.a.getPageActivity(), this.a.a.getPageActivity().getText(c.a.r0.w2.g.god_get_refresh_error)).q();
                        return;
                    } else {
                        BdToast.c(this.a.a.getPageActivity(), this.a.a.getPageActivity().getText(c.a.r0.w2.g.god_get_limit_error)).q();
                        return;
                    }
                }
                this.a.C.setData(qVar.a());
                if (!this.a.X) {
                    this.a.Q = true;
                    this.a.J();
                    if (this.a.R != null) {
                        this.a.R.start();
                    }
                }
                TiebaStatic.log(new StatisticItem("c13901").param("obj_type", this.a.W ? 1 : 2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24839e;

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
            this.f24839e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f24839e.P != null && this.f24839e.f24831d != null) {
                    this.f24839e.X = true;
                    this.f24839e.P.h(this.f24839e.f24831d.getPortrait());
                }
                TiebaStatic.log(new StatisticItem("c13904"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24840e;

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
            this.f24840e = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * a.b0;
                ViewGroup.LayoutParams layoutParams = this.f24840e.C.getLayoutParams();
                if (this.f24840e.Q) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (a.b0 - floatValue);
                }
                if (this.f24840e.V != null) {
                    c.a.r0.v2.d.a aVar = this.f24840e.V;
                    if (!this.f24840e.Q) {
                        floatValue = -floatValue;
                    }
                    aVar.b((int) floatValue);
                }
                this.f24840e.C.setLayoutParams(layoutParams);
                this.f24840e.C.onChangeSkinType();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24841e;

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
            this.f24841e = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = this.f24841e.C.getLayoutParams();
                if (this.f24841e.Q) {
                    layoutParams.height = a.b0;
                } else {
                    layoutParams.height = 0;
                }
                this.f24841e.C.setLayoutParams(layoutParams);
                if (this.f24841e.V != null) {
                    this.f24841e.V.a(this.f24841e.Q);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaijiahaoInfo f24842e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f24843f;

        public f(a aVar, BaijiahaoInfo baijiahaoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, baijiahaoInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24843f = aVar;
            this.f24842e = baijiahaoInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f24843f.f24834g.getLayout()) == null) {
                return;
            }
            int lineCount = layout.getLineCount();
            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                if (!this.f24843f.f24829b) {
                    this.f24843f.f24834g.setEnabled(false);
                } else {
                    BaijiahaoInfo baijiahaoInfo = this.f24842e;
                    if (baijiahaoInfo != null && !k.isEmpty(baijiahaoInfo.auth_desc)) {
                        this.f24843f.f24834g.setEnabled(false);
                    }
                }
                this.f24843f.f24835h.setVisibility(8);
                return;
            }
            this.f24843f.f24835h.setVisibility(0);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24844e;

        public g(a aVar) {
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
            this.f24844e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24844e.E.playAnimation();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1918573354, "Lc/a/r0/v2/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1918573354, "Lc/a/r0/v2/g/a;");
                return;
            }
        }
        b0 = l.f(TbadkCoreApplication.getInst().getContext(), c.a.r0.w2.b.tbds648);
    }

    public a(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.Y = new C1416a(this);
        this.Z = new b(this);
        this.a0 = new c(this);
        this.a = tbPageContext;
        this.f24829b = z;
        this.H = onClickListener;
        G();
        F();
    }

    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.M : (View) invokeV.objValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.J : (View) invokeV.objValue;
    }

    public UserIconBox C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24837j : (UserIconBox) invokeV.objValue;
    }

    public TextView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24833f : (TextView) invokeV.objValue;
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f24830c : (View) invokeV.objValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.S = ofFloat;
            ofFloat.addUpdateListener(new d(this));
            this.S.setDuration(260L);
            this.S.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.C, AnimationProperty.OPACITY, 0.0f);
            this.T = ofFloat2;
            ofFloat2.setDuration(240L);
            this.T.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.w.getArrow(), "rotation", 0.0f);
            this.U = ofFloat3;
            ofFloat3.setDuration(100L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.R = animatorSet;
            animatorSet.addListener(new e(this));
            this.R.play(this.S).with(this.T).with(this.U);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(c.a.r0.w2.e.person_header_layout, (ViewGroup) null);
            this.f24830c = inflate;
            TextView textView = (TextView) inflate.findViewById(c.a.r0.w2.d.person_user_name);
            this.f24833f = textView;
            textView.setOnClickListener(this.H);
            TextView textView2 = (TextView) this.f24830c.findViewById(c.a.r0.w2.d.person_introduction);
            this.f24834g = textView2;
            textView2.setAlpha(0.85f);
            this.f24834g.setOnClickListener(this.H);
            ImageView imageView = (ImageView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_intro_more_icon);
            this.f24835h = imageView;
            imageView.setOnClickListener(this.H);
            UserIconBox userIconBox = (UserIconBox) this.f24830c.findViewById(c.a.r0.w2.d.person_header_label_box);
            this.f24837j = userIconBox;
            userIconBox.setOnClickListener(this.H);
            this.f24837j.setAutoChangedStyle(false);
            this.l = (TextView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_fans_num);
            FrameLayout frameLayout = (FrameLayout) this.f24830c.findViewById(c.a.r0.w2.d.person_header_fans_layout);
            this.f24838k = frameLayout;
            frameLayout.setOnClickListener(this.H);
            TextView textView3 = (TextView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_fans_suffix);
            this.m = textView3;
            textView3.setAlpha(0.8f);
            this.u = (ImageView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_fans_icon);
            this.f24836i = (ImageView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_fans_red_tip);
            this.o = (TextView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_attention_num);
            FrameLayout frameLayout2 = (FrameLayout) this.f24830c.findViewById(c.a.r0.w2.d.person_header_attention_layout);
            this.n = frameLayout2;
            frameLayout2.setOnClickListener(this.H);
            TextView textView4 = (TextView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_attention_suffix);
            this.p = textView4;
            textView4.setAlpha(0.8f);
            this.v = (ImageView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_attention_icon);
            this.r = (TextView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_forum_num);
            FrameLayout frameLayout3 = (FrameLayout) this.f24830c.findViewById(c.a.r0.w2.d.person_header_forum_layout);
            this.q = frameLayout3;
            frameLayout3.setOnClickListener(this.H);
            TextView textView5 = (TextView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_forum_suffix);
            this.s = textView5;
            textView5.setAlpha(0.8f);
            this.t = (ImageView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_forum_icon);
            FollowUserSpinnerBtn followUserSpinnerBtn = (FollowUserSpinnerBtn) this.f24830c.findViewById(c.a.r0.w2.d.person_attention_btn);
            this.w = followUserSpinnerBtn;
            followUserSpinnerBtn.bindOnClickListener(this.H);
            this.w.setOpenListener(this.Y);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f24830c.findViewById(c.a.r0.w2.d.person_gift_icon_btn);
            this.x = tBSpecificationBtn;
            tBSpecificationBtn.setOnClickListener(this.H);
            c.a.q0.s.g0.n.d dVar = new c.a.q0.s.g0.n.d();
            dVar.p(c.a.r0.w2.a.CAM_X0101);
            dVar.g(l.f(TbadkCoreApplication.getInst().getContext(), c.a.r0.w2.b.tbds62));
            dVar.u(c.a.r0.w2.c.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
            this.x.setConfig(dVar);
            TbImageView tbImageView = (TbImageView) this.f24830c.findViewById(c.a.r0.w2.d.person_user_vip_icon);
            this.y = tbImageView;
            tbImageView.setOnClickListener(this.H);
            this.z = (ImageView) this.f24830c.findViewById(c.a.r0.w2.d.person_user_sex_icon);
            HeadPendantView headPendantView = (HeadPendantView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_header_view);
            this.A = headPendantView;
            headPendantView.setHasPendantStyle();
            this.A.setDefalutResid(c.a.r0.w2.c.pic_mycenter_avatar_def_i);
            this.A.getHeadView().setIsRound(true);
            this.A.getHeadView().setDrawBorder(false);
            this.A.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.A.setOnClickListener(this.H);
            this.A.setBigVDimenSize(c.a.r0.w2.b.tbds57);
            this.A.setAuthIconType(3);
            this.A.setShowSimpleIcon(false);
            this.A.setBigVIconResId(c.a.r0.w2.c.ic_icon_mask_shen20_n);
            View findViewById = this.f24830c.findViewById(c.a.r0.w2.d.person_header_ring);
            this.G = findViewById;
            findViewById.setAlpha(0.33f);
            GodRecommendLayout godRecommendLayout = (GodRecommendLayout) this.f24830c.findViewById(c.a.r0.w2.d.recommend_god);
            this.C = godRecommendLayout;
            godRecommendLayout.setPageContext(this.a);
            this.C.setPageUniqueId(this.a.getUniqueId());
            this.C.setRefreshListener(this.a0);
            c.a.r0.f2.c cVar = new c.a.r0.f2.c(this.a.getUniqueId());
            this.P = cVar;
            cVar.j(this.Z);
            this.I = (ViewGroup) this.f24830c.findViewById(c.a.r0.w2.d.person_center_my_extra_layout);
            this.J = this.f24830c.findViewById(c.a.r0.w2.d.person_center_my_store_layout);
            this.K = (TextView) this.f24830c.findViewById(c.a.r0.w2.d.btn_person_center_my_store_text);
            this.L = (ImageView) this.f24830c.findViewById(c.a.r0.w2.d.btn_person_center_my_store_img);
            this.J.setOnClickListener(this.H);
            this.M = this.f24830c.findViewById(c.a.r0.w2.d.person_center_my_friends_room_layout);
            this.N = (TextView) this.f24830c.findViewById(c.a.r0.w2.d.btn_person_center_my_friends_room_text);
            this.O = (ImageView) this.f24830c.findViewById(c.a.r0.w2.d.btn_person_center_my_friends_room_img);
            this.M.setOnClickListener(this.H);
            this.D = (ImageView) this.f24830c.findViewById(c.a.r0.w2.d.person_header_ala_live);
            this.E = (TBLottieAnimationView) this.f24830c.findViewById(c.a.r0.w2.d.living_bg_lottie);
            this.B = (RelativeLayout) this.f24830c.findViewById(c.a.r0.w2.d.userheaderview_container);
            H(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.t, c.a.r0.w2.c.ic_icon_pure_gerenba_ba_n_svg, c.a.r0.w2.a.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, c.a.r0.w2.c.ic_icon_pure_gerenba_fans_n_svg, c.a.r0.w2.a.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.v, c.a.r0.w2.c.ic_icon_pure_gerenba_concern_n_svg, c.a.r0.w2.a.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.x.changeSkinType();
            this.w.onChangeSkinType(i2);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f24835h, c.a.r0.w2.c.ic_icon_pure_common_arrow16_n_svg, c.a.r0.w2.a.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.D.setImageDrawable(new SvgMaskType(c.a.r0.w2.c.ic_pic_live_mine).getDrawable());
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.L, c.a.r0.w2.c.ic_icon_pure_personalba_shop_svg, c.a.r0.w2.a.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O, c.a.r0.w2.c.ic_icon_mask_wo_yujin_16, c.a.r0.w2.a.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f24833f, c.a.r0.w2.a.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.f24834g, c.a.r0.w2.a.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.l, c.a.r0.w2.a.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.m, c.a.r0.w2.a.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.o, c.a.r0.w2.a.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.p, c.a.r0.w2.a.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.r, c.a.r0.w2.a.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.s, c.a.r0.w2.a.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.K, c.a.r0.w2.a.CAM_X0101, 1, i2);
            SkinManager.setViewTextColor(this.N, c.a.r0.w2.a.CAM_X0101, 1, i2);
            SkinManager.setImageResource(this.f24836i, c.a.r0.w2.c.icon_news_down_bar_one);
            SkinManager.setBackgroundResource(this.G, c.a.r0.w2.c.person_header_bg, i2);
            this.C.onChangeSkinType();
            UserData userData = this.f24831d;
            if (userData != null) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, userData.getSex() == 2 ? c.a.r0.w2.c.icon_mask_girl16_svg : c.a.r0.w2.c.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (i2 == 4) {
                TBLottieAnimationView tBLottieAnimationView = this.E;
                if (tBLottieAnimationView != null) {
                    tBLottieAnimationView.setAnimation("live/personcenter_live_bg_black.json");
                }
                ImageView imageView = this.D;
                if (imageView != null) {
                    imageView.setImageDrawable(new SvgMaskType(c.a.r0.w2.c.ic_pic_live_mine_2).getDrawable());
                }
            } else if (i2 == 1) {
                TBLottieAnimationView tBLottieAnimationView2 = this.E;
                if (tBLottieAnimationView2 != null) {
                    tBLottieAnimationView2.setAnimation("live/personcenter_live_bg_night.json");
                }
                ImageView imageView2 = this.D;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(new SvgMaskType(c.a.r0.w2.c.ic_pic_live_mine_1).getDrawable());
                }
            } else {
                TBLottieAnimationView tBLottieAnimationView3 = this.E;
                if (tBLottieAnimationView3 != null) {
                    tBLottieAnimationView3.setAnimation("live/personcenter_live_bg.json");
                }
                ImageView imageView3 = this.D;
                if (imageView3 != null) {
                    imageView3.setImageDrawable(new SvgMaskType(c.a.r0.w2.c.ic_pic_live_mine).getDrawable());
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AnimatorSet animatorSet = this.F;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            TBLottieAnimationView tBLottieAnimationView = this.E;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            AnimatorSet animatorSet2 = this.R;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            c.a.r0.f2.c cVar = this.P;
            if (cVar != null) {
                cVar.g();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ObjectAnimator objectAnimator = this.T;
            if (objectAnimator != null) {
                if (this.Q) {
                    objectAnimator.setFloatValues(0.0f, 1.0f);
                } else {
                    objectAnimator.setFloatValues(1.0f, 0.0f);
                }
            }
            ObjectAnimator objectAnimator2 = this.U;
            if (objectAnimator2 != null) {
                if (this.Q) {
                    objectAnimator2.setFloatValues(0.0f, 180.0f);
                } else {
                    objectAnimator2.setFloatValues(180.0f, 360.0f);
                }
            }
        }
    }

    public void K(c.a.r0.v2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.V = aVar;
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.f24836i.setVisibility(0);
            } else {
                this.f24836i.setVisibility(8);
            }
        }
    }

    public final void M(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, 1.0f, 0.8f);
            long j2 = 500;
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_Y, 1.0f, 0.8f);
            ofFloat2.setDuration(j2);
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat2.setRepeatCount(-1);
            ofFloat2.setRepeatMode(2);
            AnimatorSet animatorSet = new AnimatorSet();
            this.F = animatorSet;
            animatorSet.play(ofFloat).with(ofFloat2);
            this.F.start();
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.w.updateLikeStatus(z);
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.A.startLoadPendantUrl(str);
        }
    }

    public void q(UserData userData, c.a.r0.j1.b bVar) {
        String intro;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, userData, bVar) == null) || userData == null) {
            return;
        }
        this.f24831d = userData;
        this.f24832e = bVar;
        if (!k.isEmpty(userData.getName_show())) {
            this.f24833f.setText(this.f24831d.getName_show());
        }
        this.f24834g.setVisibility(0);
        BaijiahaoInfo baijiahaoInfo = this.f24831d.getBaijiahaoInfo();
        if (this.f24831d.isNewGod() && !k.isEmpty(this.f24831d.getNewGodData().getFieldName())) {
            Resources resources = this.a.getResources();
            int i2 = c.a.r0.w2.g.person_auth_perfix;
            intro = resources.getString(i2, this.f24831d.getNewGodData().getFieldName() + q0.c(this.f24831d.getNewGodData().isVideoGod()));
        } else if (this.f24831d.showBazhuGrade()) {
            intro = this.a.getResources().getString(c.a.r0.w2.g.person_auth_perfix, StringHelper.cutChineseAndEnglishWithSuffix(this.f24831d.getBazhuGradeData().getDesc(), 32, "..."));
        } else {
            intro = this.f24831d.getIntro();
            if (!k.isEmpty(intro)) {
                intro = this.a.getResources().getString(c.a.r0.w2.g.person_sign_prefix, intro);
            } else if (this.f24829b) {
                intro = this.a.getResources().getString(c.a.r0.w2.g.person_default_sign, "o(〃'▽'〃)o");
            }
        }
        if (!k.isEmpty(intro)) {
            this.f24834g.setVisibility(0);
            this.f24834g.setText(intro);
            this.f24834g.setEnabled(true);
            c.a.d.f.m.e.a().post(new f(this, baijiahaoInfo));
        } else {
            this.f24834g.setVisibility(8);
        }
        this.f24837j.loadIcon(this.f24831d.getIconInfo(), 9, this.a.getResources().getDimensionPixelSize(c.a.r0.w2.b.tbds42), this.a.getResources().getDimensionPixelSize(c.a.r0.w2.b.tbds42), this.a.getResources().getDimensionPixelSize(c.a.r0.w2.b.tbds10), true);
        this.l.setText(StringHelper.numFormatOverWanNa(this.f24831d.getFansNum()));
        this.r.setText(StringHelper.numFormatOverWanNa(this.f24831d.getLike_bars()));
        this.o.setText(StringHelper.numFormatOverWanNa(this.f24831d.getConcernNum()));
        if (this.f24829b) {
            this.w.setVisibility(8);
            this.x.setVisibility(8);
        } else {
            this.x.setVisibility(0);
            this.w.setVisibility(0);
            this.w.setShowPullBtn(userData.isNewGod());
            this.w.setFirstUpdate(true);
            N(this.f24831d.getHave_attention() == 1);
        }
        UserVipInfoData userVipInfo = this.f24831d.getUserVipInfo();
        if (this.f24831d.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.y.startLoad(userVipInfo.getVipIconUrl(), 10, false);
            this.y.setVisibility(0);
        } else if (this.f24829b) {
            this.y.setImageDrawable(SkinManager.getDrawable(c.a.r0.w2.c.icon_crown_super_non));
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(8);
        }
        int i3 = c.a.r0.w2.c.icon_mask_boy16_svg;
        UserData userData2 = this.f24831d;
        if (userData2 != null) {
            i3 = userData2.getSex() == 2 ? c.a.r0.w2.c.icon_mask_girl16_svg : c.a.r0.w2.c.icon_mask_boy16_svg;
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, i3, SvgManager.SvgResourceStateType.NORMAL);
        if (this.f24831d.getSex() == 0) {
            this.z.setVisibility(8);
        } else {
            this.z.setVisibility(0);
        }
        AlaUserInfoData alaUserData = this.f24831d.getAlaUserData();
        if (alaUserData != null && alaUserData.live_status == 1) {
            this.E.setVisibility(0);
            this.E.loop(true);
            this.E.post(new g(this));
            this.G.setVisibility(8);
            M(this.B);
            this.D.setVisibility(0);
            this.A.setIsclearmode(true);
            this.A.startLoadOnlyHeadUrl(this.f24831d.getAvater());
        } else {
            this.A.startLoadWithPendantAndBigV(this.f24831d);
            this.D.setVisibility(8);
            this.A.setIsclearmode(false);
            this.G.setVisibility(0);
        }
        c.a.r0.j1.b bVar2 = this.f24832e;
        if (bVar2 != null && bVar2.a() && !TextUtils.isEmpty(this.f24832e.f18293b)) {
            this.J.setVisibility(0);
            if (this.f24829b) {
                TiebaStatic.log(new StatisticItem("c13612").param("obj_param1", "0"));
            } else {
                TiebaStatic.log(new StatisticItem("c13612").param("obj_param1", "1"));
            }
        } else {
            this.J.setVisibility(8);
        }
        UserData userData3 = this.f24831d;
        if (userData3 != null && userData3.getLiveRoomInfo() != null && this.f24831d.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.f24831d.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.f24831d.getLiveRoomInfo().btn_title)) {
            this.N.setText(this.f24831d.getLiveRoomInfo().btn_title);
            this.M.setVisibility(0);
        } else {
            this.M.setVisibility(8);
        }
        if (this.J.getVisibility() != 0 && this.M.getVisibility() != 0) {
            this.I.setVisibility(8);
        } else {
            this.I.setVisibility(0);
        }
    }

    public FollowUserSpinnerBtn r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.w : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public FrameLayout s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.n : (FrameLayout) invokeV.objValue;
    }

    public FrameLayout t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f24838k : (FrameLayout) invokeV.objValue;
    }

    public FrameLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.q : (FrameLayout) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.x : (View) invokeV.objValue;
    }

    public HeadPendantView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.A : (HeadPendantView) invokeV.objValue;
    }

    public ImageView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f24835h : (ImageView) invokeV.objValue;
    }

    public TextView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f24834g : (TextView) invokeV.objValue;
    }

    public TbImageView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.y : (TbImageView) invokeV.objValue;
    }
}
