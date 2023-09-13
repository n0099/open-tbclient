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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tieba.e15;
import com.baidu.tieba.f15;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AdvancedAdSlideLoadingLayout extends LottieSlideLoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int b0;
    public static final int c0;
    public static final int d0;
    public static final int e0;
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
    public boolean Q;
    public boolean R;
    public Runnable S;

    /* renamed from: T  reason: collision with root package name */
    public View.OnClickListener f1080T;
    public Animator.AnimatorListener U;
    public ValueAnimator.AnimatorUpdateListener V;
    public Animator.AnimatorListener W;
    public ValueAnimator.AnimatorUpdateListener a0;
    public e15 x;
    public boolean y;
    public TbImageView z;

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.x == null) {
                return;
            }
            boolean e0 = this.a.e0();
            this.a.a0();
            if (e0) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_AUTO_JUMP_H5).param("fid", this.a.x.j).param("obj_id", this.a.x.i));
                ThirdStatisticHelper.sendReq(this.a.x.e);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.x == null) {
                return;
            }
            boolean e0 = this.a.e0();
            this.a.a0();
            if (e0) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_CLICK_JUMP_H5).param("fid", this.a.x.j).param("obj_id", this.a.x.i));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_AUTO_JUMP_H5).param("fid", this.a.x.j).param("obj_id", this.a.x.i));
                ThirdStatisticHelper.sendReq(this.a.x.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvancedAdSlideLoadingLayout a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.J.setAlpha(1.0f);
                this.a.t.setAlpha(0.0f);
                this.a.N.setStartDelay(150L);
                this.a.N.start();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvancedAdSlideLoadingLayout a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                AdvancedAdSlideLoadingLayout.T(this.a);
                if (this.a.L == 2) {
                    this.a.setEnable(true);
                    this.a.R = false;
                    return;
                }
                this.a.J.setAlpha(1.0f);
                this.a.t.setAlpha(0.0f);
                this.a.M.setStartDelay(250L);
                this.a.M.start();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class g implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ AdvancedAdSlideLoadingLayout b;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

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
            this.b = advancedAdSlideLoadingLayout;
            this.a = i;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            float f;
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                BdImage bdImage = null;
                if (this.b.z != null) {
                    bdImage = this.b.z.getBdImage();
                }
                if (bdImage == null) {
                    return;
                }
                this.b.C = true;
                int width = bdImage.getWidth();
                int height = bdImage.getHeight();
                if (this.b.A * width > this.b.B * height) {
                    f = this.b.A / height;
                    f3 = (this.b.B - (width * f)) * 0.5f;
                    f2 = 0.0f;
                } else {
                    f = this.b.B / width;
                    f2 = this.b.A - (height * f);
                    f3 = 0.0f;
                }
                if (this.b.z != null) {
                    this.b.z.getImageMatrix().setScale(f, f);
                    this.b.z.getImageMatrix().setTranslate(f3, f2);
                    int i = this.a;
                    if (width < i) {
                        this.b.z.setPivotX(0.0f);
                        this.b.z.setScaleX(i / width);
                        float screenHeight = UtilHelper.getScreenHeight(TbadkApplication.getInst()) / height;
                        if (screenHeight > 1.0f) {
                            this.b.z.setPivotY(0.0f);
                            this.b.z.setScaleY(screenHeight);
                        }
                    }
                }
                this.b.D = f2;
                if (this.b.K) {
                    this.b.g0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a0();
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
        b0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
        c0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds300);
        d0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds300);
        e0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds260);
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            TbPageContext<?> b02 = b0(getContext());
            if (b02 != null && this.x != null) {
                Context baseContext = b02.getPageActivity().getBaseContext();
                e15 e15Var = this.x;
                if (!UtilHelper.isMatchScheme(baseContext, e15Var.f, e15Var.g)) {
                    UrlManager.getInstance().dealOneLink(b02, new String[]{this.x.b}, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.FALSE));
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.K = true;
            this.Q = true;
            if (!this.C) {
                return;
            }
            this.R = true;
            this.K = false;
            setEnable(false);
            this.J.setAlpha(1.0f);
            this.t.setAlpha(0.0f);
            this.J.setText(R.string.surprise_in_drop_down);
            this.M.setStartDelay(0L);
            this.N.setStartDelay(0L);
            this.L = 0;
            this.M.start();
        }
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

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void t(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, frameLayout) == null) {
            super.t(frameLayout);
            LayoutInflater.from(getContext()).inflate(R.layout.advanced_ad_slide_loading_view, (ViewGroup) frameLayout, true);
            TextView textView = (TextView) frameLayout.findViewById(R.id.loading_text_view);
            this.J = textView;
            textView.setVisibility(8);
            Z();
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

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void F(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            this.Q = false;
            if (this.y) {
                if (f2 < getLoadingPointRatio()) {
                    x();
                    return;
                } else if (f2 < getShowAdPointRatio()) {
                    H();
                    return;
                } else {
                    f0();
                    x();
                    return;
                }
            }
            super.F(i, f2);
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
        this.R = false;
        this.S = new a(this);
        this.f1080T = new b(this);
        this.U = new c(this);
        this.V = new d(this);
        this.W = new e(this);
        this.a0 = new f(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.M = ofFloat;
        ofFloat.setDuration(800L);
        this.M.addListener(this.U);
        this.M.addUpdateListener(this.V);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.N = ofFloat2;
        ofFloat2.setDuration(800L);
        this.N.addListener(this.W);
        this.N.addUpdateListener(this.a0);
    }

    public static /* synthetic */ int T(AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout) {
        int i = advancedAdSlideLoadingLayout.L;
        advancedAdSlideLoadingLayout.L = i + 1;
        return i;
    }

    public final TbPageContext b0(Context context) {
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

    public void setAdvancedAdStyle(boolean z) {
        e15 e15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.y = z;
            if (z && (e15Var = this.x) != null) {
                this.z.startLoad(e15Var.a, 10, false);
            } else {
                Z();
            }
        }
    }

    public void setBgView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            this.I = l(view2);
        }
    }

    public void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, navigationBar) == null) {
            this.P = navigationBar;
        }
    }

    public void Y(e15 e15Var, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, e15Var, viewGroup) == null) {
            if (viewGroup != null) {
                this.x = e15Var;
                this.E = viewGroup;
                return;
            }
            throw new IllegalArgumentException("Can not add null view as complete advanced ad container");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getGuideStayPointToLoadingTopBoundsDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            return getLoadingVewMaxHeight() + e0;
        }
        return invokeV.intValue;
    }

    private float getShowAdPointRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            return (((getLoadingVewMaxHeight() + b0) + c0) * 1.0f) / getMaxFingerSlideDistance();
        }
        return invokeV.floatValue;
    }

    public final void Z() {
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

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.R;
        }
        return invokeV.booleanValue;
    }

    public TbImageView getAdvancedAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.z;
        }
        return (TbImageView) invokeV.objValue;
    }

    public e15 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.x;
        }
        return (e15) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public int getLoadingPointDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.y) {
                return b0;
            }
            return super.getLoadingPointDistance();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout, com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public int getLoadingPointToBottomDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.y) {
                return c0 + d0;
            }
            return super.getLoadingPointToBottomDistance();
        }
        return invokeV.intValue;
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
            this.Q = true;
            if (this.y) {
                if (f2 < getLoadingPointRatio()) {
                    this.J.setAlpha(1.0f);
                    this.t.setAlpha(0.0f);
                    this.J.setText(R.string.surprise_in_drop_down);
                    return;
                } else if (f2 < getShowAdPointRatio()) {
                    this.J.setAlpha(1.0f);
                    this.t.setAlpha(0.0f);
                    this.J.setText(R.string.surprise_continue_drop_down);
                    return;
                } else {
                    this.J.setAlpha(1.0f);
                    this.t.setAlpha(0.0f);
                    this.J.setText(R.string.surprise_when_release_hand);
                    return;
                }
            }
            super.E(i, f2);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void G(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            super.G(i, f2);
            if (this.y && this.z != null && this.C) {
                f15.a().f(f2, getLoadingPointRatio(), getShowAdPointRatio(), this.Q);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921679, f15.a()));
                this.z.getImageMatrix().setTranslate(0.0f, this.D + i);
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

    public void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.F.getParent() != null) {
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
            SafeHandler.getInst().removeCallbacks(this.S);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.x != null && this.E != null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cover_advanced_ad_view, (ViewGroup) null);
            this.F = inflate;
            if (inflate.getParent() != null) {
                return;
            }
            this.F.setOnClickListener(this.f1080T);
            this.E.addView(this.F);
            TbImageView tbImageView = (TbImageView) this.F.findViewById(R.id.advanced_ad_image_view);
            this.G = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.G.startLoad(this.x.a, 10, false);
            ImageView imageView = (ImageView) this.F.findViewById(R.id.advanced_ad_close_btn);
            this.H = imageView;
            imageView.setOnClickListener(new h(this));
            WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921586, Boolean.TRUE));
            if (getContext() instanceof BaseActivity) {
                this.O = Boolean.valueOf(((BaseActivity) getContext()).isSwipeBackEnabled());
                ((BaseActivity) getContext()).setSwipeBackEnabled(false);
            } else if (getContext() instanceof BaseFragmentActivity) {
                this.O = Boolean.valueOf(((BaseFragmentActivity) getContext()).isSwipeBackEnabled());
                ((BaseFragmentActivity) getContext()).setSwipeBackEnabled(false);
            }
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(getContext()) - this.I.a.getLayoutParams().height;
            if (equipmentHeight < 0) {
                equipmentHeight = 0;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.F, "Y", -equipmentHeight, 0.0f);
            ofFloat.setDuration((int) (((equipmentHeight * 1.0f) / 4800.0f) * 1000.0f));
            ofFloat.start();
            int i = this.x.c;
            if (i < 500) {
                i = 500;
            }
            SafeHandler.getInst().postDelayed(this.S, i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921681));
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_COMPLETE_SHOW).param("fid", this.x.j).param("obj_id", this.x.i));
            ThirdStatisticHelper.sendReq(this.x.d);
        }
    }

    public void setAdvancedAdView(TbImageView tbImageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048595, this, tbImageView, i, i2) == null) {
            this.z = tbImageView;
            this.A = i;
            this.B = i2;
            tbImageView.setEvent(new g(this, i2));
        }
    }
}
