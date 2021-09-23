package com.baidu.adp.widget.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BdSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT = 1;
    public static final int FINISH = 4;
    public static final int LARGE = 0;
    public static final int[] P;
    public static final int PULL_TO_REFRESH = 0;
    public static final int REFRESHED = 3;
    public static final int REFRESHING = 2;
    public static final int RELEASE_TO_REFRESH = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public int B;
    public Animation C;
    public Animation D;
    public boolean E;
    public int F;
    public boolean G;
    public j H;
    public boolean I;
    public boolean J;
    public boolean K;
    public k L;
    public Animation.AnimationListener M;
    public final Animation N;
    public final Animation O;

    /* renamed from: e  reason: collision with root package name */
    public int f36660e;

    /* renamed from: f  reason: collision with root package name */
    public View f36661f;

    /* renamed from: g  reason: collision with root package name */
    public l f36662g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36663h;

    /* renamed from: i  reason: collision with root package name */
    public int f36664i;

    /* renamed from: j  reason: collision with root package name */
    public float f36665j;
    public float k;
    public final NestedScrollingParentHelper l;
    public final NestedScrollingChildHelper m;
    public int mFrom;
    public int mOriginalOffsetTop;
    public final int[] n;
    public final int[] o;
    public boolean p;
    public int q;
    public float r;
    public float s;
    public boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public final DecelerateInterpolator x;
    public i y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f36666a;

        public a(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36666a = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @SuppressLint({"NewApi"})
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f36666a;
                if (bdSwipeRefreshLayout.f36663h) {
                    bdSwipeRefreshLayout.t();
                    BdSwipeRefreshLayout bdSwipeRefreshLayout2 = this.f36666a;
                    bdSwipeRefreshLayout2.q = bdSwipeRefreshLayout2.y.getView().getTop();
                    return;
                }
                bdSwipeRefreshLayout.v();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f36667e;

        public b(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36667e = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                this.f36667e.setAnimationProgress(1.0f - f2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f36668a;

        public c(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36668a = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f36668a;
                if (!bdSwipeRefreshLayout.v) {
                    bdSwipeRefreshLayout.z(null);
                }
                this.f36668a.l();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f36669e;

        public d(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36669e = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f36669e;
                if (!bdSwipeRefreshLayout.G) {
                    i2 = bdSwipeRefreshLayout.B - Math.abs(bdSwipeRefreshLayout.mOriginalOffsetTop);
                } else {
                    i2 = bdSwipeRefreshLayout.B;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout2 = this.f36669e;
                int i3 = bdSwipeRefreshLayout2.mFrom;
                this.f36669e.x((i3 + ((int) ((i2 - i3) * f2))) - bdSwipeRefreshLayout2.y.getView().getTop(), false, "AnimateToCorrectPosition");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f36670e;

        public e(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36670e = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                this.f36670e.q(f2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f36671e;

        public f(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36671e = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f36671e;
                float f3 = bdSwipeRefreshLayout.A;
                bdSwipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
                this.f36671e.q(f2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f36672e;

        public g(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36672e = bdSwipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f36672e;
                bdSwipeRefreshLayout.h(bdSwipeRefreshLayout.q, bdSwipeRefreshLayout.M);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public BdCircleImageView f36673e;

        /* renamed from: f  reason: collision with root package name */
        public c.a.e.l.k.a f36674f;

        /* renamed from: g  reason: collision with root package name */
        public Animation f36675g;

        /* renamed from: h  reason: collision with root package name */
        public Animation f36676h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f36677i;

        /* loaded from: classes4.dex */
        public class a extends Animation {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f36678e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f36679f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ h f36680g;

            public a(h hVar, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36680g = hVar;
                this.f36678e = i2;
                this.f36679f = i3;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                    c.a.e.l.k.a aVar = this.f36680g.f36674f;
                    int i2 = this.f36678e;
                    aVar.setAlpha((int) (i2 + ((this.f36679f - i2) * f2)));
                }
            }
        }

        public h(BdSwipeRefreshLayout bdSwipeRefreshLayout, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36677i = bdSwipeRefreshLayout;
            this.f36673e = new BdCircleImageView(bdSwipeRefreshLayout.getContext(), SwipeRefreshLayout.CIRCLE_BG_LIGHT);
            c.a.e.l.k.a aVar = new c.a.e.l.k.a(context, this.f36673e);
            this.f36674f = aVar;
            aVar.e(SwipeRefreshLayout.CIRCLE_BG_LIGHT);
            this.f36673e.setImageDrawable(this.f36674f);
            this.f36673e.setVisibility(8);
        }

        public void a(@ColorInt int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f36673e.setBackgroundColor(i2);
                this.f36674f.e(i2);
            }
        }

        public void b(@ColorInt int... iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) {
                this.f36674f.f(iArr);
            }
        }

        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f36673e.setImageDrawable(null);
                this.f36674f.n(i2);
                this.f36673e.setImageDrawable(this.f36674f);
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public long getCompleteAnimTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36673e : (View) invokeV.objValue;
        }

        @SuppressLint({"NewApi"})
        public final Animation h(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
                if (this.f36677i.n()) {
                    return null;
                }
                a aVar = new a(this, i2, i3);
                aVar.setDuration(300L);
                this.f36673e.setAnimationListener(null);
                this.f36673e.clearAnimation();
                this.f36673e.startAnimation(aVar);
                return aVar;
            }
            return (Animation) invokeII.objValue;
        }

        @SuppressLint({"NewApi"})
        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f36676h = h(this.f36674f.getAlpha(), 255);
            }
        }

        @SuppressLint({"NewApi"})
        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f36675g = h(this.f36674f.getAlpha(), 76);
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void onCompleteRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.f36674f.j(0.0f, 0.0f);
                this.f36674f.stop();
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void onPullPercentChange(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f36674f.j(0.0f, Math.min(0.8f, f2 * 0.8f));
                this.f36674f.d(Math.min(1.0f, f2));
                this.f36674f.g((((f2 * 0.4f) - 0.25f) + (f3 * 2.0f)) * 0.5f);
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void onPullToRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.f36674f.setAlpha(76);
                this.f36674f.l(true);
                if (this.f36674f.getAlpha() <= 76 || this.f36677i.o(this.f36675g)) {
                    return;
                }
                j();
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void onRefreshing() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                if (Build.VERSION.SDK_INT >= 11) {
                    this.f36674f.setAlpha(255);
                }
                this.f36674f.d(0.0f);
                this.f36674f.setAlpha(255);
                this.f36674f.start();
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void onReleaseToRefresh() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f36674f.getAlpha() >= 255 || this.f36677i.o(this.f36676h)) {
                return;
            }
            i();
        }
    }

    /* loaded from: classes4.dex */
    public interface i {
        long getCompleteAnimTime();

        View getView();

        void onCompleteRefresh();

        void onFinish();

        void onPullPercentChange(float f2, float f3);

        void onPullToRefresh();

        void onRefreshing();

        void onReleaseToRefresh();
    }

    /* loaded from: classes4.dex */
    public interface j {
        boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, @Nullable View view);
    }

    /* loaded from: classes4.dex */
    public interface k {
        void a(int i2, int i3, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface l {
        void onRefresh();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(824758143, "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(824758143, "Lcom/baidu/adp/widget/refresh/BdSwipeRefreshLayout;");
                return;
            }
        }
        P = new int[]{16842766};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdSwipeRefreshLayout(Context context) {
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

    @SuppressLint({"NewApi"})
    private void setColorViewAlpha(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65545, this, i2) == null) || (iVar = this.y) == null || iVar.getView() == null || this.y.getView().getBackground() == null) {
            return;
        }
        this.y.getView().getBackground().setAlpha(i2);
    }

    @SuppressLint({"NewApi"})
    public final void A(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, animationListener) == null) {
            this.mFrom = i2;
            this.A = ViewCompat.getScaleX(this.y.getView());
            f fVar = new f(this);
            this.D = fVar;
            fVar.setDuration(150L);
            if (animationListener != null) {
                this.D.setAnimationListener(animationListener);
            }
            this.y.getView().clearAnimation();
            this.y.getView().startAnimation(this.D);
        }
    }

    public boolean canChildScrollUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            j jVar = this.H;
            if (jVar != null) {
                return jVar.a(this, this.f36661f);
            }
            if (Build.VERSION.SDK_INT < 14) {
                View view = this.f36661f;
                if (!(view instanceof AbsListView)) {
                    return ViewCompat.canScrollVertically(view, -1) || this.f36661f.getScrollY() > 0;
                }
                AbsListView absListView = (AbsListView) view;
                return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
            }
            return ViewCompat.canScrollVertically(this.f36661f, -1);
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.m.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.m.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.m.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.m.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) ? super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public final void g(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, animationListener) == null) {
            this.mFrom = i2;
            this.N.reset();
            this.N.setDuration(200L);
            this.N.setInterpolator(this.x);
            if (animationListener != null) {
                this.N.setAnimationListener(animationListener);
            }
            if (this.y.getView().getVisibility() != 0) {
                this.y.getView().setVisibility(0);
            }
            this.y.getView().clearAnimation();
            this.y.getView().startAnimation(this.N);
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            int i4 = this.z;
            return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
        }
        return invokeII.intValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l.getNestedScrollAxes() : invokeV.intValue;
    }

    public int getProgressCircleDiameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.F : invokeV.intValue;
    }

    public int getProgressViewEndOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.B : invokeV.intValue;
    }

    public int getProgressViewStartOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mOriginalOffsetTop : invokeV.intValue;
    }

    public final void h(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, animationListener) == null) {
            if (this.v) {
                A(i2, animationListener);
                return;
            }
            this.mFrom = i2;
            this.O.reset();
            this.O.setDuration(200L);
            this.O.setInterpolator(this.x);
            if (animationListener != null) {
                this.O.setAnimationListener(animationListener);
            }
            this.y.getView().clearAnimation();
            this.y.getView().startAnimation(this.O);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f36660e = 3;
            this.y.onCompleteRefresh();
            postDelayed(new g(this), this.y.getCompleteAnimTime());
        }
    }

    public void interruptRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            k();
            this.f36663h = false;
            q(1.0f);
            v();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.m.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    public boolean isRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f36663h : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            h hVar = new h(this, getContext());
            this.y = hVar;
            addView(hVar.getView());
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.f36661f == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.y.getView())) {
                    this.f36661f = childAt;
                    return;
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f36660e = 4;
            this.y.getView().clearAnimation();
            this.y.onFinish();
        }
    }

    public final void m(float f2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f2), str}) == null) {
            if (f2 > this.f36665j) {
                w(true, true);
                return;
            }
            this.f36663h = false;
            h(this.q, this.v ? null : new c(this));
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? Build.VERSION.SDK_INT < 11 : invokeV.booleanValue;
    }

    public final boolean o(Animation animation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, animation)) == null) ? (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDetachedFromWindow();
            v();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            k();
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.w && actionMasked == 0) {
                this.w = false;
            }
            if (!isEnabled() || this.w || canChildScrollUp() || this.p) {
                return false;
            }
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i2 = this.u;
                        if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                            return false;
                        }
                        y(motionEvent.getY(findPointerIndex), "onInterceptTouchEvent");
                    } else if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            r(motionEvent);
                        }
                    }
                }
                this.t = false;
                this.u = -1;
            } else {
                int pointerId = motionEvent.getPointerId(0);
                this.u = pointerId;
                this.t = false;
                int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                this.s = motionEvent.getY(findPointerIndex2);
            }
            return this.t;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (getChildCount() == 0) {
                return;
            }
            if (this.f36661f == null) {
                k();
            }
            View view = this.f36661f;
            if (view == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = (getPaddingTop() + this.q) - this.mOriginalOffsetTop;
            if (this.K) {
                paddingTop = getPaddingTop();
            }
            view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
            int measuredWidth2 = this.y.getView().getMeasuredWidth();
            int measuredHeight2 = this.y.getView().getMeasuredHeight();
            int i6 = measuredWidth / 2;
            int i7 = measuredWidth2 / 2;
            int i8 = this.q;
            this.y.getView().layout(i6 - i7, i8, i6 + i7, i8 + measuredHeight2);
            k kVar = this.L;
            if (kVar != null) {
                kVar.a(this.q, measuredHeight2, this.I);
                this.I = false;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048604, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.f36661f == null) {
                k();
            }
            View view = this.f36661f;
            if (view == null) {
                return;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.y.getView().measure(View.MeasureSpec.makeMeasureSpec(this.F, 1073741824), View.MeasureSpec.makeMeasureSpec(this.F, 1073741824));
            this.z = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.y.getView()) {
                    this.z = i4;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            int i3 = this.f36660e;
            if ((i3 == 3 || i3 == 2) && f3 > 0.0f && (i2 = this.q) > this.mOriginalOffsetTop) {
                h(i2, null);
            }
            return dispatchNestedFling(f2, f3, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int i2 = this.f36660e;
            if (i2 == 3 || i2 == 2 || this.y.getView() == null || this.y.getView().getBottom() <= 0) {
                return dispatchNestedPreFling(f2, f3);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            if (i3 > 0) {
                float f2 = this.k;
                if (f2 > 0.0f) {
                    float f3 = i3;
                    if (f3 > f2) {
                        iArr[1] = i3 - ((int) f2);
                        this.k = 0.0f;
                    } else {
                        this.k = f2 - f3;
                        iArr[1] = i3;
                    }
                    p(this.k, "onNestedPreScroll-2");
                }
            }
            if (this.G && i3 > 0 && this.k == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
                this.y.getView().setVisibility(8);
            }
            int[] iArr2 = this.n;
            if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
            }
            int i4 = i3 - iArr[1];
            if ((isRefreshing() || this.f36660e == 3) && Math.abs(i4) > 0) {
                if ((i4 <= 0 || this.q <= this.mOriginalOffsetTop) && (i4 >= 0 || this.q >= this.mOriginalOffsetTop + this.B || canChildScrollUp())) {
                    return;
                }
                p(Math.max(Math.min(this.B, (this.q - this.mOriginalOffsetTop) - i4), 0.0f), "onNestedPreScroll-1");
                iArr[1] = iArr[1] + i4;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchNestedScroll(i2, i3, i4, i5, this.o);
            int i6 = i5 + this.o[1];
            if (i6 >= 0 || canChildScrollUp() || this.f36663h) {
                return;
            }
            float abs = this.k + Math.abs(i6);
            this.k = abs;
            if (this.J) {
                float f2 = this.f36665j;
                if (abs > f2 * 0.6f) {
                    this.k = f2 * 0.6f;
                }
                if (this.k > this.f36665j * 0.6f * 0.8f) {
                    this.I = true;
                }
            }
            p(this.k, "onNestedScroll");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048609, this, view, view2, i2) == null) {
            this.l.onNestedScrollAccepted(view, view2, i2);
            startNestedScroll(i2 & 2);
            this.k = 0.0f;
            this.p = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, view, view2, i2)) == null) ? (!isEnabled() || this.w || (i2 & 2) == 0) ? false : true : invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            this.l.onStopNestedScroll(view);
            this.p = false;
            float f2 = this.k;
            if (f2 > 0.0f) {
                m(f2, "onStopNestedScroll");
                this.k = 0.0f;
            }
            stopNestedScroll();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.w && actionMasked == 0) {
                this.w = false;
            }
            if (!isEnabled() || this.w || canChildScrollUp() || this.f36663h || this.p) {
                return false;
            }
            if (actionMasked == 0) {
                this.u = motionEvent.getPointerId(0);
                this.t = false;
            } else if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.u);
                if (findPointerIndex < 0) {
                    return false;
                }
                if (this.t) {
                    float y = (motionEvent.getY(findPointerIndex) - this.r) * 0.5f;
                    this.t = false;
                    if (this.J) {
                        float f2 = this.f36665j;
                        if (y > f2 * 0.6f) {
                            y = f2 * 0.6f;
                        }
                        if (y > this.f36665j * 0.6f * 0.8f) {
                            this.I = true;
                        }
                    }
                    m(y, "onTouchEvent(ACTION_UP)");
                }
                this.u = -1;
                return false;
            } else if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.u);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                float y2 = motionEvent.getY(findPointerIndex2);
                y(y2, "onTouchEvent");
                if (this.t) {
                    float f3 = (y2 - this.r) * 0.5f;
                    if (f3 <= 0.0f) {
                        return false;
                    }
                    if (this.J) {
                        float f4 = this.f36665j;
                        if (f3 > f4 * 0.6f) {
                            f3 = f4 * 0.6f;
                        }
                        this.I = false;
                    }
                    p(f3, "onTouchEvent(ACTION_MOVE)");
                }
            } else if (actionMasked == 3) {
                return false;
            } else {
                if (actionMasked == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    if (actionIndex < 0) {
                        return false;
                    }
                    this.u = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    r(motionEvent);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public final void p(float f2, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Float.valueOf(f2), str}) == null) {
            float min = Math.min(1.0f, Math.abs(f2 / this.f36665j));
            float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            float abs = Math.abs(f2) - this.f36665j;
            float f3 = this.G ? this.B - this.mOriginalOffsetTop : this.B;
            double max2 = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
            float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
            int i3 = this.mOriginalOffsetTop + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
            if (this.y.getView().getVisibility() != 0) {
                this.y.getView().setVisibility(0);
            }
            if (!this.v) {
                ViewCompat.setScaleX(this.y.getView(), 1.0f);
                ViewCompat.setScaleY(this.y.getView(), 1.0f);
            }
            if (this.v) {
                setAnimationProgress(Math.min(1.0f, f2 / this.f36665j));
            }
            if (!this.f36663h && (i2 = this.f36660e) != 3) {
                int i4 = this.mOriginalOffsetTop;
                int i5 = this.q;
                if (i4 >= i5 || i5 >= i4 + this.B) {
                    if (this.q >= this.mOriginalOffsetTop + this.B && this.f36660e != 1) {
                        u();
                    }
                } else if (i2 != 0) {
                    s();
                }
                this.y.onPullPercentChange(max, pow);
            }
            x(i3 - this.q, true, "moveSpinner");
        }
    }

    public void q(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f2) == null) {
            int i2 = this.mFrom;
            x((i2 + ((int) ((this.mOriginalOffsetTop - i2) * f2))) - this.y.getView().getTop(), false, "moveToStart");
        }
    }

    public final void r(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (motionEvent.getPointerId(actionIndex) == this.u) {
                this.u = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21 || !(this.f36661f instanceof AbsListView)) {
                View view = this.f36661f;
                if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                    super.requestDisallowInterceptTouchEvent(z);
                }
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.f36660e = 0;
            this.y.onPullToRefresh();
        }
    }

    public void setAnimationProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048618, this, f2) == null) {
            if (n()) {
                setColorViewAlpha((int) (f2 * 255.0f));
                return;
            }
            ViewCompat.setScaleX(this.y.getView(), f2);
            ViewCompat.setScaleY(this.y.getView(), f2);
        }
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, iArr) == null) {
            k();
            i iVar = this.y;
            if (iVar instanceof h) {
                ((h) iVar).b(iArr);
            }
        }
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, iArr) == null) {
            getContext();
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = getContext().getResources().getColor(iArr[i2]);
            }
            setColorSchemeColors(iArr2);
        }
    }

    public void setDistanceToTriggerSync(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.f36665j = i2;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                return;
            }
            v();
        }
    }

    public void setLimitDragDistance(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.J = z;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.m.setNestedScrollingEnabled(z);
        }
    }

    public void setNoMoveTargetView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.K = z;
        }
    }

    public void setOnChildScrollUpCallback(@Nullable j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, jVar) == null) {
            this.H = jVar;
        }
    }

    public void setOnRefreshListener(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, lVar) == null) {
            this.f36662g = lVar;
        }
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            setProgressBackgroundColorSchemeResource(i2);
        }
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            i iVar = this.y;
            if (iVar instanceof h) {
                ((h) iVar).a(i2);
            }
        }
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            setProgressBackgroundColorSchemeColor(getContext().getResources().getColor(i2));
        }
    }

    public void setProgressView(i iVar) {
        i iVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, iVar) == null) || iVar == null || iVar.getView() == null || iVar == (iVar2 = this.y) || this.f36660e != 4) {
            return;
        }
        removeView(iVar2.getView());
        this.y = iVar;
        iVar.getView().setVisibility(8);
        addView(this.y.getView(), 0);
    }

    public void setProgressViewCallback(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, kVar) == null) {
            this.L = kVar;
        }
    }

    public void setProgressViewEndTarget(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.B = i2;
            this.v = z;
            this.y.getView().invalidate();
        }
    }

    public void setProgressViewOffset(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.v = z;
            this.mOriginalOffsetTop = i2;
            this.B = i3;
            this.G = true;
            v();
            this.f36663h = false;
        }
    }

    public void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (z && this.f36663h != z) {
                w(z, false);
            } else {
                w(z, false);
            }
        }
    }

    public void setSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            if ((i2 == 0 || i2 == 1) && (this.y instanceof h)) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                if (i2 == 0) {
                    this.F = (int) (displayMetrics.density * 56.0f);
                } else {
                    this.F = (int) (displayMetrics.density * 61.0f);
                }
                ((h) this.y).f(i2);
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i2)) == null) ? this.m.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.m.stopNestedScroll();
        }
    }

    public final void t() {
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.f36660e = 2;
            this.y.onRefreshing();
            if (!this.E || (lVar = this.f36662g) == null) {
                return;
            }
            lVar.onRefresh();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.f36660e = 1;
            this.y.onReleaseToRefresh();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            l();
            this.y.getView().setVisibility(8);
            setColorViewAlpha(255);
            if (this.v) {
                setAnimationProgress(0.0f);
            } else {
                x(this.mOriginalOffsetTop - this.q, true, "reset");
            }
            this.q = this.y.getView().getTop();
        }
    }

    public final void w(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f36663h == z) {
            return;
        }
        this.E = z2;
        k();
        this.f36663h = z;
        if (z) {
            g(this.q, this.M);
        } else {
            i();
        }
    }

    public void x(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.y.getView().bringToFront();
            ViewCompat.offsetTopAndBottom(this.y.getView(), i2);
            View view = this.f36661f;
            if (view != null && !this.K) {
                ViewCompat.offsetTopAndBottom(view, i2);
            }
            this.q = this.y.getView().getTop();
            if (!z || Build.VERSION.SDK_INT >= 11) {
                return;
            }
            invalidate();
        }
    }

    @SuppressLint({"NewApi"})
    public final void y(float f2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{Float.valueOf(f2), str}) == null) {
            float f3 = this.s;
            int i2 = this.f36664i;
            if (f2 - f3 <= i2 || this.t) {
                return;
            }
            this.r = f3 + i2;
            this.t = true;
        }
    }

    public void z(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, animationListener) == null) {
            b bVar = new b(this);
            this.C = bVar;
            bVar.setDuration(150L);
            this.C.setAnimationListener(animationListener);
            this.y.getView().clearAnimation();
            this.y.getView().startAnimation(this.C);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36660e = 4;
        this.f36663h = false;
        this.f36665j = -1.0f;
        this.n = new int[2];
        this.o = new int[2];
        this.u = -1;
        this.z = -1;
        this.M = new a(this);
        this.N = new d(this);
        this.O = new e(this);
        this.f36664i = ViewConfiguration.get(context).getScaledTouchSlop();
        getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.x = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.F = displayMetrics.widthPixels;
        j();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int i4 = (int) (displayMetrics.density * 86.0f);
        this.B = i4;
        this.f36665j = i4;
        this.l = new NestedScrollingParentHelper(this);
        this.m = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i5 = -this.F;
        this.q = i5;
        this.mOriginalOffsetTop = i5;
        q(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
}
