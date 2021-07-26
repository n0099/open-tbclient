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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import d.a.d.e.p.l;
/* loaded from: classes3.dex */
public class AdvancedAdSlideLoadingLayout extends LottieSlideLoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int i0;
    public static final int j0;
    public static final int k0;
    public static final int l0;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.s.q.d B;
    public boolean C;
    public TbImageView D;
    public int E;
    public int F;
    public boolean G;
    public float H;
    public ViewGroup I;
    public View J;
    public TbImageView K;
    public ImageView L;
    public BaseSlideLoadingLayout.f M;
    public TextView N;
    public boolean O;
    public int P;
    public ValueAnimator Q;
    public ValueAnimator R;
    public Boolean S;
    public NavigationBar T;
    public Runnable U;
    public View.OnClickListener V;
    public Animator.AnimatorListener W;
    public ValueAnimator.AnimatorUpdateListener a0;
    public Animator.AnimatorListener b0;
    public ValueAnimator.AnimatorUpdateListener c0;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f12755e;

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
            this.f12755e = advancedAdSlideLoadingLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12755e.b0();
                this.f12755e.Y();
                TiebaStatic.log(CommonStatisticKey.KEY_FRS_ADVANCED_AD_AUTO_JUMP_H5);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f12756e;

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
            this.f12756e = advancedAdSlideLoadingLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12756e.b0();
                this.f12756e.Y();
                TiebaStatic.log(CommonStatisticKey.KEY_FRS_ADVANCED_AD_CLICK_JUMP_H5);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f12757e;

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
            this.f12757e = advancedAdSlideLoadingLayout;
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
                this.f12757e.N.setAlpha(1.0f);
                this.f12757e.x.setAlpha(0.0f);
                this.f12757e.R.setStartDelay(150L);
                this.f12757e.R.start();
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

    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f12758e;

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
            this.f12758e = advancedAdSlideLoadingLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) ((-this.f12758e.getLoadingVewMaxHeight()) + (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f12758e.getGuideStayPointToLoadingTopBoundsDistance()));
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f12758e;
                FrameLayout.LayoutParams layoutParams = advancedAdSlideLoadingLayout.p;
                layoutParams.topMargin = floatValue;
                advancedAdSlideLoadingLayout.o.setLayoutParams(layoutParams);
                float q = this.f12758e.q(floatValue);
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout2 = this.f12758e;
                advancedAdSlideLoadingLayout2.G(advancedAdSlideLoadingLayout2.p(q), q);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f12759e;

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
            this.f12759e = advancedAdSlideLoadingLayout;
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
                AdvancedAdSlideLoadingLayout.Q(this.f12759e);
                if (this.f12759e.P != 3) {
                    this.f12759e.N.setAlpha(1.0f);
                    this.f12759e.x.setAlpha(0.0f);
                    this.f12759e.Q.setStartDelay(250L);
                    this.f12759e.Q.start();
                    return;
                }
                this.f12759e.setEnable(true);
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

    /* loaded from: classes3.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f12760e;

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
            this.f12760e = advancedAdSlideLoadingLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) ((-this.f12760e.getLoadingVewMaxHeight()) + (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f12760e.getGuideStayPointToLoadingTopBoundsDistance()));
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f12760e;
                FrameLayout.LayoutParams layoutParams = advancedAdSlideLoadingLayout.p;
                layoutParams.topMargin = floatValue;
                advancedAdSlideLoadingLayout.o.setLayoutParams(layoutParams);
                float q = this.f12760e.q(floatValue);
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout2 = this.f12760e;
                advancedAdSlideLoadingLayout2.G(advancedAdSlideLoadingLayout2.p(q), q);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f12761a;

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
            this.f12761a = advancedAdSlideLoadingLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f12761a.G = true;
                int r = this.f12761a.D.getBdImage().r();
                int m = this.f12761a.D.getBdImage().m();
                float f4 = 0.0f;
                if (this.f12761a.E * r > this.f12761a.F * m) {
                    f2 = this.f12761a.E / m;
                    f4 = (this.f12761a.F - (r * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = this.f12761a.F / r;
                    f3 = this.f12761a.E - (m * f2);
                }
                this.f12761a.D.getImageMatrix().setScale(f2, f2);
                this.f12761a.D.getImageMatrix().setTranslate(f4, f3);
                this.f12761a.H = f3;
                if (this.f12761a.O) {
                    this.f12761a.d0();
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

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f12762e;

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
            this.f12762e = advancedAdSlideLoadingLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12762e.Y();
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
        i0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
        j0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds300);
        k0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds300);
        l0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds260);
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

    public static /* synthetic */ int Q(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
        int i2 = advancedAdSlideLoadingLayout.P;
        advancedAdSlideLoadingLayout.P = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getGuideStayPointToLoadingTopBoundsDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? getLoadingVewMaxHeight() + l0 : invokeV.intValue;
    }

    private float getShowAdPointRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? (((getLoadingVewMaxHeight() + i0) + j0) * 1.0f) / getMaxFingerSlideDistance() : invokeV.floatValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void A(int i2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.C) {
                this.N.setAlpha((1.0f - f3) * 1.0f);
                this.x.setAlpha(f3 * 1.0f);
                return;
            }
            super.A(i2, f2, f3);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void D(int i2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.C) {
                ContinuousAnimationView continuousAnimationView = this.x;
                float f4 = 1.0f - f3;
                continuousAnimationView.setAlpha(continuousAnimationView.getAlpha() * f4 * 0.3f);
                this.N.setAlpha(this.x.getAlpha() * f4 * 0.3f);
                return;
            }
            super.D(i2, f2, f3);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void E(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.C) {
                if (f2 < getLoadingPointRatio()) {
                    this.N.setAlpha(1.0f);
                    this.x.setAlpha(0.0f);
                    this.N.setText(R.string.surprise_in_drop_down);
                    return;
                } else if (f2 < getShowAdPointRatio()) {
                    this.N.setAlpha(1.0f);
                    this.x.setAlpha(0.0f);
                    this.N.setText(R.string.surprise_continue_drop_down);
                    return;
                } else {
                    this.N.setAlpha(1.0f);
                    this.x.setAlpha(0.0f);
                    this.N.setText(R.string.surprise_when_release_hand);
                    return;
                }
            }
            super.E(i2, f2);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void F(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.C) {
                if (f2 < getLoadingPointRatio()) {
                    x();
                    return;
                } else if (f2 < getShowAdPointRatio()) {
                    H();
                    return;
                } else {
                    c0();
                    x();
                    return;
                }
            }
            super.F(i2, f2);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void G(int i2, float f2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            super.G(i2, f2);
            if (this.C && (tbImageView = this.D) != null && this.G) {
                tbImageView.getImageMatrix().setTranslate(0.0f, this.H + i2);
                float f3 = f2 * 2.0f;
                if (f3 > 1.0f) {
                    f3 = 1.0f;
                }
                this.D.setAlpha(f3);
                if (i2 == 0) {
                    this.T.setAlpha(1.0f);
                } else {
                    this.T.setAlpha(0.0f);
                }
            }
        }
    }

    public void W(d.a.p0.s.q.d dVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, dVar, viewGroup) == null) {
            if (viewGroup != null) {
                this.B = dVar;
                this.I = viewGroup;
                return;
            }
            throw new IllegalArgumentException("Can not add null view as complete advanced ad container");
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.N.setAlpha(0.0f);
            this.x.setAlpha(1.0f);
            TbImageView tbImageView = this.D;
            if (tbImageView != null) {
                tbImageView.setAlpha(0.0f);
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.J.getParent() == null) {
            return;
        }
        ViewGroup viewGroup = this.I;
        if (viewGroup != null) {
            viewGroup.removeView(this.J);
        }
        if (getContext() instanceof BaseActivity) {
            ((BaseActivity) getContext()).setSwipeBackEnabled(this.S.booleanValue());
        } else if (getContext() instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) getContext()).setSwipeBackEnabled(this.S.booleanValue());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.FALSE));
        d.a.d.e.m.e.a().removeCallbacks(this.U);
    }

    public final TbPageContext Z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
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

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public final void b0() {
        TbPageContext<?> Z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (Z = Z(getContext())) == null || this.B == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(Z, new String[]{this.B.f53280b}, true);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.FALSE));
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.B == null || this.I == null) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cover_advanced_ad_view, (ViewGroup) null);
        this.J = inflate;
        if (inflate.getParent() != null) {
            return;
        }
        this.J.setOnClickListener(this.V);
        this.I.addView(this.J);
        TbImageView tbImageView = (TbImageView) this.J.findViewById(R.id.advanced_ad_image_view);
        this.K = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.K.M(this.B.f53279a, 10, false);
        ImageView imageView = (ImageView) this.J.findViewById(R.id.advanced_ad_close_btn);
        this.L = imageView;
        imageView.setOnClickListener(new h(this));
        WebPManager.setPureDrawable(this.L, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.TRUE));
        if (getContext() instanceof BaseActivity) {
            this.S = Boolean.valueOf(((BaseActivity) getContext()).isSwipeBackEnabled());
            ((BaseActivity) getContext()).setSwipeBackEnabled(false);
        } else if (getContext() instanceof BaseFragmentActivity) {
            this.S = Boolean.valueOf(((BaseFragmentActivity) getContext()).isSwipeBackEnabled());
            ((BaseFragmentActivity) getContext()).setSwipeBackEnabled(false);
        }
        int i2 = l.i(getContext()) - this.M.f12779a.getLayoutParams().height;
        if (i2 < 0) {
            i2 = 0;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.J, "Y", -i2, 0.0f);
        ofFloat.setDuration((int) (((i2 * 1.0f) / 4800.0f) * 1000.0f));
        ofFloat.start();
        int i3 = this.B.f53281c;
        if (i3 < 500) {
            i3 = 500;
        }
        d.a.d.e.m.e.a().postDelayed(this.U, i3);
        TiebaStatic.log(CommonStatisticKey.KEY_FRS_ADVANCED_AD_COMPLETE_SHOW);
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.O = true;
            if (this.G) {
                this.O = false;
                setEnable(false);
                this.N.setAlpha(1.0f);
                this.x.setAlpha(0.0f);
                this.N.setText(R.string.surprise_in_drop_down);
                this.Q.setStartDelay(0L);
                this.R.setStartDelay(0L);
                this.P = 0;
                this.Q.start();
            }
        }
    }

    public TbImageView getAdvancedAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.D : (TbImageView) invokeV.objValue;
    }

    public d.a.p0.s.q.d getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.B : (d.a.p0.s.q.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public int getLoadingPointDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.C) {
                return i0;
            }
            return super.getLoadingPointDistance();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public int getLoadingPointToBottomDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.C) {
                return j0 + k0;
            }
            return super.getLoadingPointToBottomDistance();
        }
        return invokeV.intValue;
    }

    public void setAdvancedAdStyle(boolean z) {
        d.a.p0.s.q.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.C = z;
            if (z && (dVar = this.B) != null) {
                this.D.M(dVar.f53279a, 10, false);
            } else {
                X();
            }
        }
    }

    public void setAdvancedAdView(TbImageView tbImageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048594, this, tbImageView, i2, i3) == null) {
            this.D = tbImageView;
            this.E = i2;
            this.F = i3;
            tbImageView.setEvent(new g(this));
        }
    }

    public void setBgView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            this.M = l(view);
        }
    }

    public void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, navigationBar) == null) {
            this.T = navigationBar;
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void t(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, frameLayout) == null) {
            super.t(frameLayout);
            LayoutInflater.from(getContext()).inflate(R.layout.advanced_ad_slide_loading_view, (ViewGroup) frameLayout, true);
            this.N = (TextView) frameLayout.findViewById(R.id.loading_text_view);
            X();
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
        this.U = new a(this);
        this.V = new b(this);
        this.W = new c(this);
        this.a0 = new d(this);
        this.b0 = new e(this);
        this.c0 = new f(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.Q = ofFloat;
        ofFloat.setDuration(800L);
        this.Q.addListener(this.W);
        this.Q.addUpdateListener(this.a0);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.R = ofFloat2;
        ofFloat2.setDuration(800L);
        this.R.addListener(this.b0);
        this.R.addUpdateListener(this.c0);
    }
}
