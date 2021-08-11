package com.baidu.tbadk.core.view.slideLoadingLayout;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AdvancedAdSlideLoadingLayout extends LottieSlideLoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int a0;
    public static final int b0;
    public static final int c0;
    public static final int i0;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public int B;
    public int C;
    public boolean D;
    public float E;
    public ViewGroup F;
    public View G;
    public TbImageView H;
    public ImageView I;
    public BaseSlideLoadingLayout.f J;
    public TextView K;
    public boolean L;
    public int M;
    public ValueAnimator N;
    public ValueAnimator O;
    public Boolean P;
    public NavigationBar Q;
    public Runnable R;
    public View.OnClickListener S;
    public Animator.AnimatorListener T;
    public ValueAnimator.AnimatorUpdateListener U;
    public Animator.AnimatorListener V;
    public ValueAnimator.AnimatorUpdateListener W;
    public c.a.o0.s.q.d y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f47741e;

        public a(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47741e = advancedAdSlideLoadingLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47741e.B();
                this.f47741e.closeCompleteAd();
                TiebaStatic.log(CommonStatisticKey.KEY_FRS_ADVANCED_AD_AUTO_JUMP_H5);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f47742e;

        public b(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47742e = advancedAdSlideLoadingLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47742e.B();
                this.f47742e.closeCompleteAd();
                TiebaStatic.log(CommonStatisticKey.KEY_FRS_ADVANCED_AD_CLICK_JUMP_H5);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f47743e;

        public c(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47743e = advancedAdSlideLoadingLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f47743e.K.setAlpha(1.0f);
                this.f47743e.mLoadingLottieView.setAlpha(0.0f);
                this.f47743e.O.setStartDelay(150L);
                this.f47743e.O.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f47744e;

        public d(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47744e = advancedAdSlideLoadingLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) ((-this.f47744e.getLoadingVewMaxHeight()) + (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f47744e.getGuideStayPointToLoadingTopBoundsDistance()));
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f47744e;
                FrameLayout.LayoutParams layoutParams = advancedAdSlideLoadingLayout.mLoadingLayoutParams;
                layoutParams.topMargin = floatValue;
                advancedAdSlideLoadingLayout.mLoadingLayout.setLayoutParams(layoutParams);
                float curScrollRatioByTopMargin = this.f47744e.getCurScrollRatioByTopMargin(floatValue);
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout2 = this.f47744e;
                advancedAdSlideLoadingLayout2.onScroll(advancedAdSlideLoadingLayout2.getCurOffsetYByRatio(curScrollRatioByTopMargin), curScrollRatioByTopMargin);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f47745e;

        public e(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47745e = advancedAdSlideLoadingLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                AdvancedAdSlideLoadingLayout.t(this.f47745e);
                if (this.f47745e.M != 3) {
                    this.f47745e.K.setAlpha(1.0f);
                    this.f47745e.mLoadingLottieView.setAlpha(0.0f);
                    this.f47745e.N.setStartDelay(250L);
                    this.f47745e.N.start();
                    return;
                }
                this.f47745e.setEnable(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f47746e;

        public f(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47746e = advancedAdSlideLoadingLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) ((-this.f47746e.getLoadingVewMaxHeight()) + (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f47746e.getGuideStayPointToLoadingTopBoundsDistance()));
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f47746e;
                FrameLayout.LayoutParams layoutParams = advancedAdSlideLoadingLayout.mLoadingLayoutParams;
                layoutParams.topMargin = floatValue;
                advancedAdSlideLoadingLayout.mLoadingLayout.setLayoutParams(layoutParams);
                float curScrollRatioByTopMargin = this.f47746e.getCurScrollRatioByTopMargin(floatValue);
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout2 = this.f47746e;
                advancedAdSlideLoadingLayout2.onScroll(advancedAdSlideLoadingLayout2.getCurOffsetYByRatio(curScrollRatioByTopMargin), curScrollRatioByTopMargin);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f47747a;

        public g(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47747a = advancedAdSlideLoadingLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f47747a.D = true;
                int r = this.f47747a.A.getBdImage().r();
                int m = this.f47747a.A.getBdImage().m();
                float f4 = 0.0f;
                if (this.f47747a.B * r > this.f47747a.C * m) {
                    f2 = this.f47747a.B / m;
                    f4 = (this.f47747a.C - (r * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = this.f47747a.C / r;
                    f3 = this.f47747a.B - (m * f2);
                }
                this.f47747a.A.getImageMatrix().setScale(f2, f2);
                this.f47747a.A.getImageMatrix().setTranslate(f4, f3);
                this.f47747a.E = f3;
                if (this.f47747a.L) {
                    this.f47747a.showGuideAnim();
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f47748e;

        public h(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47748e = advancedAdSlideLoadingLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47748e.closeCompleteAd();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(587210884, "Lcom/baidu/tbadk/core/view/slideLoadingLayout/AdvancedAdSlideLoadingLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(587210884, "Lcom/baidu/tbadk/core/view/slideLoadingLayout/AdvancedAdSlideLoadingLayout;");
                return;
            }
        }
        a0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
        b0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds300);
        c0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds300);
        i0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds260);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdvancedAdSlideLoadingLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getGuideStayPointToLoadingTopBoundsDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? getLoadingVewMaxHeight() + i0 : invokeV.intValue;
    }

    private float getShowAdPointRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? (((getLoadingVewMaxHeight() + a0) + b0) * 1.0f) / getMaxFingerSlideDistance() : invokeV.floatValue;
    }

    public static /* synthetic */ int t(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
        int i2 = advancedAdSlideLoadingLayout.M;
        advancedAdSlideLoadingLayout.M = i2 + 1;
        return i2;
    }

    public final TbPageContext A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public final void B() {
        TbPageContext<?> A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (A = A(getContext())) == null || this.y == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(A, new String[]{this.y.f13875b}, true);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.FALSE));
    }

    public void bindAdData(c.a.o0.s.q.d dVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, viewGroup) == null) {
            if (viewGroup != null) {
                this.y = dVar;
                this.F = viewGroup;
                return;
            }
            throw new IllegalArgumentException("Can not add null view as complete advanced ad container");
        }
    }

    public void closeCompleteAd() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.G.getParent() == null) {
            return;
        }
        ViewGroup viewGroup = this.F;
        if (viewGroup != null) {
            viewGroup.removeView(this.G);
        }
        if (getContext() instanceof BaseActivity) {
            ((BaseActivity) getContext()).setSwipeBackEnabled(this.P.booleanValue());
        } else if (getContext() instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) getContext()).setSwipeBackEnabled(this.P.booleanValue());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.FALSE));
        c.a.e.e.m.e.a().removeCallbacks(this.R);
    }

    public TbImageView getAdvancedAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.A : (TbImageView) invokeV.objValue;
    }

    public c.a.o0.s.q.d getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.y : (c.a.o0.s.q.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public int getLoadingPointDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.z) {
                return a0;
            }
            return super.getLoadingPointDistance();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public int getLoadingPointToBottomDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.z) {
                return b0 + c0;
            }
            return super.getLoadingPointToBottomDistance();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void initLoadingView(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frameLayout) == null) {
            super.initLoadingView(frameLayout);
            LayoutInflater.from(getContext()).inflate(R.layout.advanced_ad_slide_loading_view, (ViewGroup) frameLayout, true);
            this.K = (TextView) frameLayout.findViewById(R.id.loading_text_view);
            z();
        }
    }

    public boolean isAdvancedAdStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.z : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onAnimToLoadingPointUpdate(int i2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.z) {
                this.K.setAlpha((1.0f - f3) * 1.0f);
                this.mLoadingLottieView.setAlpha(f3 * 1.0f);
                return;
            }
            super.onAnimToLoadingPointUpdate(i2, f2, f3);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onAnimToTopUpdate(int i2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.z) {
                ContinuousAnimationView continuousAnimationView = this.mLoadingLottieView;
                float f4 = 1.0f - f3;
                continuousAnimationView.setAlpha(continuousAnimationView.getAlpha() * f4 * 0.3f);
                this.K.setAlpha(this.mLoadingLottieView.getAlpha() * f4 * 0.3f);
                return;
            }
            super.onAnimToTopUpdate(i2, f2, f3);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onFingerDrag(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.z) {
                if (f2 < getLoadingPointRatio()) {
                    this.K.setAlpha(1.0f);
                    this.mLoadingLottieView.setAlpha(0.0f);
                    this.K.setText(R.string.surprise_in_drop_down);
                    return;
                } else if (f2 < getShowAdPointRatio()) {
                    this.K.setAlpha(1.0f);
                    this.mLoadingLottieView.setAlpha(0.0f);
                    this.K.setText(R.string.surprise_continue_drop_down);
                    return;
                } else {
                    this.K.setAlpha(1.0f);
                    this.mLoadingLottieView.setAlpha(0.0f);
                    this.K.setText(R.string.surprise_when_release_hand);
                    return;
                }
            }
            super.onFingerDrag(i2, f2);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onFingerDragEnd(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.z) {
                if (f2 < getLoadingPointRatio()) {
                    loadingViewScrollToTop();
                    return;
                } else if (f2 < getShowAdPointRatio()) {
                    startLoading();
                    return;
                } else {
                    showCompleteAd();
                    loadingViewScrollToTop();
                    return;
                }
            }
            super.onFingerDragEnd(i2, f2);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onScroll(int i2, float f2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            super.onScroll(i2, f2);
            if (this.z && (tbImageView = this.A) != null && this.D) {
                tbImageView.getImageMatrix().setTranslate(0.0f, this.E + i2);
                float f3 = f2 * 2.0f;
                if (f3 > 1.0f) {
                    f3 = 1.0f;
                }
                this.A.setAlpha(f3);
                if (i2 == 0) {
                    this.Q.setAlpha(1.0f);
                } else {
                    this.Q.setAlpha(0.0f);
                }
            }
        }
    }

    public void setAdvancedAdStyle(boolean z) {
        c.a.o0.s.q.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.z = z;
            if (z && (dVar = this.y) != null) {
                this.A.startLoad(dVar.f13874a, 10, false);
            } else {
                z();
            }
        }
    }

    public void setAdvancedAdView(TbImageView tbImageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, tbImageView, i2, i3) == null) {
            this.A = tbImageView;
            this.B = i2;
            this.C = i3;
            tbImageView.setEvent(new g(this));
        }
    }

    public void setBgView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
            this.J = addSyncHeightView(view);
        }
    }

    public void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, navigationBar) == null) {
            this.Q = navigationBar;
        }
    }

    public void showCompleteAd() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.y == null || this.F == null) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cover_advanced_ad_view, (ViewGroup) null);
        this.G = inflate;
        if (inflate.getParent() != null) {
            return;
        }
        this.G.setOnClickListener(this.S);
        this.F.addView(this.G);
        TbImageView tbImageView = (TbImageView) this.G.findViewById(R.id.advanced_ad_image_view);
        this.H = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.H.startLoad(this.y.f13874a, 10, false);
        ImageView imageView = (ImageView) this.G.findViewById(R.id.advanced_ad_close_btn);
        this.I = imageView;
        imageView.setOnClickListener(new h(this));
        WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.TRUE));
        if (getContext() instanceof BaseActivity) {
            this.P = Boolean.valueOf(((BaseActivity) getContext()).isSwipeBackEnabled());
            ((BaseActivity) getContext()).setSwipeBackEnabled(false);
        } else if (getContext() instanceof BaseFragmentActivity) {
            this.P = Boolean.valueOf(((BaseFragmentActivity) getContext()).isSwipeBackEnabled());
            ((BaseFragmentActivity) getContext()).setSwipeBackEnabled(false);
        }
        int i2 = l.i(getContext()) - this.J.f47766a.getLayoutParams().height;
        if (i2 < 0) {
            i2 = 0;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.G, "Y", -i2, 0.0f);
        ofFloat.setDuration((int) (((i2 * 1.0f) / 4800.0f) * 1000.0f));
        ofFloat.start();
        int i3 = this.y.f13876c;
        if (i3 < 500) {
            i3 = 500;
        }
        c.a.e.e.m.e.a().postDelayed(this.R, i3);
        TiebaStatic.log(CommonStatisticKey.KEY_FRS_ADVANCED_AD_COMPLETE_SHOW);
    }

    public void showGuideAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.L = true;
            if (this.D) {
                this.L = false;
                setEnable(false);
                this.K.setAlpha(1.0f);
                this.mLoadingLottieView.setAlpha(0.0f);
                this.K.setText(R.string.surprise_in_drop_down);
                this.N.setStartDelay(0L);
                this.O.setStartDelay(0L);
                this.M = 0;
                this.N.start();
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.K.setAlpha(0.0f);
            this.mLoadingLottieView.setAlpha(1.0f);
            TbImageView tbImageView = this.A;
            if (tbImageView != null) {
                tbImageView.setAlpha(0.0f);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdvancedAdSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedAdSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.R = new a(this);
        this.S = new b(this);
        this.T = new c(this);
        this.U = new d(this);
        this.V = new e(this);
        this.W = new f(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.N = ofFloat;
        ofFloat.setDuration(800L);
        this.N.addListener(this.T);
        this.N.addUpdateListener(this.U);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.O = ofFloat2;
        ofFloat2.setDuration(800L);
        this.O.addListener(this.V);
        this.O.addUpdateListener(this.W);
    }
}
