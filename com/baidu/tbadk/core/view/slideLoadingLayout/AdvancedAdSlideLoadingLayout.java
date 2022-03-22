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
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
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
/* loaded from: classes5.dex */
public class AdvancedAdSlideLoadingLayout extends LottieSlideLoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int W;
    public static final int g0;
    public static final int h0;
    public static final int i0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public float D;
    public ViewGroup E;
    public View F;
    public TbImageView G;
    public ImageView H;
    public BaseSlideLoadingLayout.f I;
    public TextView J;
    public boolean K;
    public int L;
    public ValueAnimator M;
    public ValueAnimator N;
    public Boolean O;
    public NavigationBar P;
    public Runnable Q;
    public View.OnClickListener R;
    public Animator.AnimatorListener S;
    public ValueAnimator.AnimatorUpdateListener T;
    public Animator.AnimatorListener U;
    public ValueAnimator.AnimatorUpdateListener V;
    public c.a.o0.r.r.d x;
    public boolean y;
    public TbImageView z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvancedAdSlideLoadingLayout a;

        public a(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advancedAdSlideLoadingLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.x == null) {
                return;
            }
            boolean c0 = this.a.c0();
            this.a.Z();
            if (c0) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_AUTO_JUMP_H5).param("fid", this.a.x.j).param("obj_id", this.a.x.i));
                ThirdStatisticHelper.sendReq(this.a.x.f10833e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvancedAdSlideLoadingLayout a;

        public b(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advancedAdSlideLoadingLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.x == null) {
                return;
            }
            boolean c0 = this.a.c0();
            this.a.Z();
            if (c0) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_CLICK_JUMP_H5).param("fid", this.a.x.j).param("obj_id", this.a.x.i));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_AUTO_JUMP_H5).param("fid", this.a.x.j).param("obj_id", this.a.x.i));
                ThirdStatisticHelper.sendReq(this.a.x.f10833e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvancedAdSlideLoadingLayout a;

        public c(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advancedAdSlideLoadingLayout;
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
                this.a.J.setAlpha(1.0f);
                this.a.t.setAlpha(0.0f);
                this.a.N.setStartDelay(150L);
                this.a.N.start();
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

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvancedAdSlideLoadingLayout a;

        public d(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advancedAdSlideLoadingLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) ((-this.a.getLoadingVewMaxHeight()) + (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.a.getGuideStayPointToLoadingTopBoundsDistance()));
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.a;
                FrameLayout.LayoutParams layoutParams = advancedAdSlideLoadingLayout.l;
                layoutParams.topMargin = floatValue;
                advancedAdSlideLoadingLayout.k.setLayoutParams(layoutParams);
                float q = this.a.q(floatValue);
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout2 = this.a;
                advancedAdSlideLoadingLayout2.G(advancedAdSlideLoadingLayout2.p(q), q);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvancedAdSlideLoadingLayout a;

        public e(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advancedAdSlideLoadingLayout;
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
                AdvancedAdSlideLoadingLayout.S(this.a);
                if (this.a.L != 2) {
                    this.a.J.setAlpha(1.0f);
                    this.a.t.setAlpha(0.0f);
                    this.a.M.setStartDelay(250L);
                    this.a.M.start();
                    return;
                }
                this.a.setEnable(true);
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

    /* loaded from: classes5.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvancedAdSlideLoadingLayout a;

        public f(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advancedAdSlideLoadingLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) ((-this.a.getLoadingVewMaxHeight()) + (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.a.getGuideStayPointToLoadingTopBoundsDistance()));
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.a;
                FrameLayout.LayoutParams layoutParams = advancedAdSlideLoadingLayout.l;
                layoutParams.topMargin = floatValue;
                advancedAdSlideLoadingLayout.k.setLayoutParams(layoutParams);
                float q = this.a.q(floatValue);
                AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout2 = this.a;
                advancedAdSlideLoadingLayout2.G(advancedAdSlideLoadingLayout2.p(q), q);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdvancedAdSlideLoadingLayout f30269b;

        public g(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30269b = advancedAdSlideLoadingLayout;
            this.a = i;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            float f2;
            float f3;
            float f4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                c.a.d.o.d.a bdImage = this.f30269b.z != null ? this.f30269b.z.getBdImage() : null;
                if (bdImage == null) {
                    return;
                }
                this.f30269b.C = true;
                int r = bdImage.r();
                int m = bdImage.m();
                if (this.f30269b.A * r > this.f30269b.B * m) {
                    f2 = this.f30269b.A / m;
                    f4 = (this.f30269b.B - (r * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = this.f30269b.B / r;
                    f3 = this.f30269b.A - (m * f2);
                    f4 = 0.0f;
                }
                if (this.f30269b.z != null) {
                    this.f30269b.z.getImageMatrix().setScale(f2, f2);
                    this.f30269b.z.getImageMatrix().setTranslate(f4, f3);
                    int i = this.a;
                    if (r < i) {
                        this.f30269b.z.setPivotX(0.0f);
                        this.f30269b.z.setScaleX(i / r);
                    }
                }
                this.f30269b.D = f3;
                if (this.f30269b.K) {
                    this.f30269b.e0();
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvancedAdSlideLoadingLayout a;

        public h(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advancedAdSlideLoadingLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advancedAdSlideLoadingLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.Z();
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
        W = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
        g0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds300);
        h0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds300);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ int S(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
        int i = advancedAdSlideLoadingLayout.L;
        advancedAdSlideLoadingLayout.L = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getGuideStayPointToLoadingTopBoundsDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? getLoadingVewMaxHeight() + i0 : invokeV.intValue;
    }

    private float getShowAdPointRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? (((getLoadingVewMaxHeight() + W) + g0) * 1.0f) / getMaxFingerSlideDistance() : invokeV.floatValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void A(int i, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.y) {
                this.J.setAlpha((1.0f - f3) * 1.0f);
                this.t.setAlpha(f3 * 1.0f);
                return;
            }
            super.A(i, f2, f3);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void D(int i, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.y) {
                ContinuousAnimationView continuousAnimationView = this.t;
                float f4 = 1.0f - f3;
                continuousAnimationView.setAlpha(continuousAnimationView.getAlpha() * f4 * 0.3f);
                this.J.setAlpha(this.t.getAlpha() * f4 * 0.3f);
                return;
            }
            super.D(i, f2, f3);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void E(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            if (this.y) {
                if (f2 < getLoadingPointRatio()) {
                    this.J.setAlpha(1.0f);
                    this.t.setAlpha(0.0f);
                    this.J.setText(R.string.obfuscated_res_0x7f0f11fd);
                    return;
                } else if (f2 < getShowAdPointRatio()) {
                    this.J.setAlpha(1.0f);
                    this.t.setAlpha(0.0f);
                    this.J.setText(R.string.obfuscated_res_0x7f0f11fc);
                    return;
                } else {
                    this.J.setAlpha(1.0f);
                    this.t.setAlpha(0.0f);
                    this.J.setText(R.string.obfuscated_res_0x7f0f11fe);
                    return;
                }
            }
            super.E(i, f2);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void F(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            if (this.y) {
                if (f2 < getLoadingPointRatio()) {
                    x();
                    return;
                } else if (f2 < getShowAdPointRatio()) {
                    H();
                    return;
                } else {
                    d0();
                    x();
                    return;
                }
            }
            super.F(i, f2);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void G(int i, float f2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            super.G(i, f2);
            if (this.y && (tbImageView = this.z) != null && this.C) {
                tbImageView.getImageMatrix().setTranslate(0.0f, this.D + i);
                float f3 = f2 * 2.0f;
                if (f3 > 1.0f) {
                    f3 = 1.0f;
                }
                this.z.setAlpha(f3);
                if (i == 0) {
                    this.P.setAlpha(1.0f);
                } else {
                    this.P.setAlpha(0.0f);
                }
            }
        }
    }

    public void X(c.a.o0.r.r.d dVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, dVar, viewGroup) == null) {
            if (viewGroup != null) {
                this.x = dVar;
                this.E = viewGroup;
                return;
            }
            throw new IllegalArgumentException("Can not add null view as complete advanced ad container");
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.J.setAlpha(0.0f);
            this.t.setAlpha(1.0f);
            TbImageView tbImageView = this.z;
            if (tbImageView != null) {
                tbImageView.setAlpha(0.0f);
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.F.getParent() == null) {
            return;
        }
        ViewGroup viewGroup = this.E;
        if (viewGroup != null) {
            viewGroup.removeView(this.F);
        }
        if (getContext() instanceof BaseActivity) {
            ((BaseActivity) getContext()).setSwipeBackEnabled(this.O.booleanValue());
        } else if (getContext() instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) getContext()).setSwipeBackEnabled(this.O.booleanValue());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.FALSE));
        c.a.d.f.m.e.a().removeCallbacks(this.Q);
    }

    public final TbPageContext a0(Context context) {
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

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public final boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TbPageContext<?> a0 = a0(getContext());
            if (a0 != null && this.x != null) {
                Context baseContext = a0.getPageActivity().getBaseContext();
                c.a.o0.r.r.d dVar = this.x;
                if (!UtilHelper.isMatchScheme(baseContext, dVar.f10834f, dVar.f10835g)) {
                    UrlManager.getInstance().dealOneLink(a0, new String[]{this.x.f10830b}, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.FALSE));
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.x == null || this.E == null) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0208, (ViewGroup) null);
        this.F = inflate;
        if (inflate.getParent() != null) {
            return;
        }
        this.F.setOnClickListener(this.R);
        this.E.addView(this.F);
        TbImageView tbImageView = (TbImageView) this.F.findViewById(R.id.obfuscated_res_0x7f090140);
        this.G = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.G.J(this.x.a, 10, false);
        ImageView imageView = (ImageView) this.F.findViewById(R.id.obfuscated_res_0x7f09013f);
        this.H = imageView;
        imageView.setOnClickListener(new h(this));
        WebPManager.setPureDrawable(this.H, R.drawable.obfuscated_res_0x7f0809b0, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.TRUE));
        if (getContext() instanceof BaseActivity) {
            this.O = Boolean.valueOf(((BaseActivity) getContext()).isSwipeBackEnabled());
            ((BaseActivity) getContext()).setSwipeBackEnabled(false);
        } else if (getContext() instanceof BaseFragmentActivity) {
            this.O = Boolean.valueOf(((BaseFragmentActivity) getContext()).isSwipeBackEnabled());
            ((BaseFragmentActivity) getContext()).setSwipeBackEnabled(false);
        }
        int i = n.i(getContext()) - this.I.a.getLayoutParams().height;
        if (i < 0) {
            i = 0;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.F, "Y", -i, 0.0f);
        ofFloat.setDuration((int) (((i * 1.0f) / 4800.0f) * 1000.0f));
        ofFloat.start();
        int i2 = this.x.f10831c;
        if (i2 < 500) {
            i2 = 500;
        }
        c.a.d.f.m.e.a().postDelayed(this.Q, i2);
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_COMPLETE_SHOW).param("fid", this.x.j).param("obj_id", this.x.i));
        ThirdStatisticHelper.sendReq(this.x.f10832d);
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.K = true;
            if (this.C) {
                this.K = false;
                setEnable(false);
                this.J.setAlpha(1.0f);
                this.t.setAlpha(0.0f);
                this.J.setText(R.string.obfuscated_res_0x7f0f11fd);
                this.M.setStartDelay(0L);
                this.N.setStartDelay(0L);
                this.L = 0;
                this.M.start();
            }
        }
    }

    public TbImageView getAdvancedAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.z : (TbImageView) invokeV.objValue;
    }

    public c.a.o0.r.r.d getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.x : (c.a.o0.r.r.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public int getLoadingPointDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.y) {
                return W;
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
            if (this.y) {
                return g0 + h0;
            }
            return super.getLoadingPointToBottomDistance();
        }
        return invokeV.intValue;
    }

    public void setAdvancedAdStyle(boolean z) {
        c.a.o0.r.r.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.y = z;
            if (z && (dVar = this.x) != null) {
                this.z.J(dVar.a, 10, false);
            } else {
                Y();
            }
        }
    }

    public void setAdvancedAdView(TbImageView tbImageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048594, this, tbImageView, i, i2) == null) {
            this.z = tbImageView;
            this.A = i;
            this.B = i2;
            tbImageView.setEvent(new g(this, i2));
        }
    }

    public void setBgView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            this.I = l(view);
        }
    }

    public void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, navigationBar) == null) {
            this.P = navigationBar;
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void t(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, frameLayout) == null) {
            super.t(frameLayout);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0085, (ViewGroup) frameLayout, true);
            this.J = (TextView) frameLayout.findViewById(R.id.obfuscated_res_0x7f091318);
            Y();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedAdSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.Q = new a(this);
        this.R = new b(this);
        this.S = new c(this);
        this.T = new d(this);
        this.U = new e(this);
        this.V = new f(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.M = ofFloat;
        ofFloat.setDuration(800L);
        this.M.addListener(this.S);
        this.M.addUpdateListener(this.T);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.N = ofFloat2;
        ofFloat2.setDuration(800L);
        this.N.addListener(this.U);
        this.N.addUpdateListener(this.V);
    }
}
