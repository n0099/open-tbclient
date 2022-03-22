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
/* loaded from: classes3.dex */
public class BdSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] P;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public Animation B;
    public Animation C;
    public boolean D;
    public int E;
    public boolean F;
    public j G;
    public boolean H;
    public boolean I;
    public boolean J;
    public k K;
    public boolean L;
    public Animation.AnimationListener M;
    public final Animation N;
    public final Animation O;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public View f24062b;

    /* renamed from: c  reason: collision with root package name */
    public l f24063c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24064d;

    /* renamed from: e  reason: collision with root package name */
    public int f24065e;

    /* renamed from: f  reason: collision with root package name */
    public float f24066f;

    /* renamed from: g  reason: collision with root package name */
    public float f24067g;

    /* renamed from: h  reason: collision with root package name */
    public final NestedScrollingParentHelper f24068h;
    public final NestedScrollingChildHelper i;
    public final int[] j;
    public final int[] k;
    public boolean l;
    public int m;
    public float n;
    public float o;
    public float p;
    public boolean q;
    public int r;
    public boolean s;
    public boolean t;
    public final DecelerateInterpolator u;
    public i v;
    public int w;
    public int x;
    public float y;
    public int z;

    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSwipeRefreshLayout a;

        public a(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @SuppressLint({"NewApi"})
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a;
                if (bdSwipeRefreshLayout.f24064d) {
                    bdSwipeRefreshLayout.w();
                    BdSwipeRefreshLayout bdSwipeRefreshLayout2 = this.a;
                    bdSwipeRefreshLayout2.m = bdSwipeRefreshLayout2.v.getView().getTop();
                    return;
                }
                bdSwipeRefreshLayout.y();
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

    /* loaded from: classes3.dex */
    public class b extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSwipeRefreshLayout a;

        public b(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                this.a.setAnimationProgress(1.0f - f2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSwipeRefreshLayout a;

        public c(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a;
                if (!bdSwipeRefreshLayout.s) {
                    bdSwipeRefreshLayout.C(null);
                }
                this.a.m();
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

    /* loaded from: classes3.dex */
    public class d extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSwipeRefreshLayout a;

        public d(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a;
                if (!bdSwipeRefreshLayout.F) {
                    i = bdSwipeRefreshLayout.A - Math.abs(bdSwipeRefreshLayout.z);
                } else {
                    i = bdSwipeRefreshLayout.A;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout2 = this.a;
                int i2 = bdSwipeRefreshLayout2.x;
                this.a.A((i2 + ((int) ((i - i2) * f2))) - bdSwipeRefreshLayout2.v.getView().getTop(), false, "AnimateToCorrectPosition");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSwipeRefreshLayout a;

        public e(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                this.a.t(f2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSwipeRefreshLayout a;

        public f(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a;
                float f3 = bdSwipeRefreshLayout.y;
                bdSwipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
                this.a.t(f2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSwipeRefreshLayout a;

        public g(BdSwipeRefreshLayout bdSwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSwipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a;
                bdSwipeRefreshLayout.h(bdSwipeRefreshLayout.m, bdSwipeRefreshLayout.M);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BdCircleImageView a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.d.o.k.a f24069b;

        /* renamed from: c  reason: collision with root package name */
        public Animation f24070c;

        /* renamed from: d  reason: collision with root package name */
        public Animation f24071d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f24072e;

        /* loaded from: classes3.dex */
        public class a extends Animation {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f24073b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ h f24074c;

            public a(h hVar, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24074c = hVar;
                this.a = i;
                this.f24073b = i2;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                    c.a.d.o.k.a aVar = this.f24074c.f24069b;
                    int i = this.a;
                    aVar.setAlpha((int) (i + ((this.f24073b - i) * f2)));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24072e = bdSwipeRefreshLayout;
            this.a = new BdCircleImageView(bdSwipeRefreshLayout.getContext(), SwipeRefreshLayout.CIRCLE_BG_LIGHT);
            c.a.d.o.k.a aVar = new c.a.d.o.k.a(context, this.a);
            this.f24069b = aVar;
            aVar.e(SwipeRefreshLayout.CIRCLE_BG_LIGHT);
            this.a.setImageDrawable(this.f24069b);
            this.a.setVisibility(8);
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24069b.setAlpha(76);
                this.f24069b.l(true);
                if (this.f24069b.getAlpha() <= 76 || this.f24072e.q(this.f24070c)) {
                    return;
                }
                o();
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f24069b.getAlpha() >= 255 || this.f24072e.q(this.f24071d)) {
                return;
            }
            n();
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void c(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f24069b.j(0.0f, Math.min(0.8f, f2 * 0.8f));
                this.f24069b.d(Math.min(1.0f, f2));
                this.f24069b.g((((f2 * 0.4f) - 0.25f) + (f3 * 2.0f)) * 0.5f);
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (Build.VERSION.SDK_INT >= 11) {
                    this.f24069b.setAlpha(255);
                }
                this.f24069b.d(0.0f);
                this.f24069b.setAlpha(255);
                this.f24069b.start();
            }
        }

        public void f(@ColorInt int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.a.setBackgroundColor(i);
                this.f24069b.e(i);
            }
        }

        public void g(@ColorInt int... iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
                this.f24069b.f(iArr);
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public long getCompleteAnimTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : (View) invokeV.objValue;
        }

        public void k(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.a.setImageDrawable(null);
                this.f24069b.n(i);
                this.a.setImageDrawable(this.f24069b);
            }
        }

        @SuppressLint({"NewApi"})
        public final Animation m(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i, i2)) == null) {
                if (this.f24072e.p()) {
                    return null;
                }
                a aVar = new a(this, i, i2);
                aVar.setDuration(300L);
                this.a.setAnimationListener(null);
                this.a.clearAnimation();
                this.a.startAnimation(aVar);
                return aVar;
            }
            return (Animation) invokeII.objValue;
        }

        @SuppressLint({"NewApi"})
        public final void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.f24071d = m(this.f24069b.getAlpha(), 255);
            }
        }

        @SuppressLint({"NewApi"})
        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                this.f24070c = m(this.f24069b.getAlpha(), 76);
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                this.f24069b.j(0.0f, 0.0f);
                this.f24069b.stop();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a();

        void b();

        void c(float f2, float f3);

        void d();

        void e();

        long getCompleteAnimTime();

        View getView();

        void onFinish();
    }

    /* loaded from: classes3.dex */
    public interface j {
        boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, @Nullable View view);
    }

    /* loaded from: classes3.dex */
    public interface k {
        void a(int i, int i2, boolean z);
    }

    /* loaded from: classes3.dex */
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
        if (!(interceptable == null || interceptable.invokeI(65545, this, i2) == null) || (iVar = this.v) == null || iVar.getView() == null || this.v.getView().getBackground() == null) {
            return;
        }
        this.v.getView().getBackground().setAlpha(i2);
    }

    public void A(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.v.getView().bringToFront();
            ViewCompat.offsetTopAndBottom(this.v.getView(), i2);
            View view = this.f24062b;
            if (view != null && !this.J) {
                ViewCompat.offsetTopAndBottom(view, i2);
            }
            this.m = this.v.getView().getTop();
            if (!z || Build.VERSION.SDK_INT >= 11) {
                return;
            }
            invalidate();
        }
    }

    @SuppressLint({"NewApi"})
    public final void B(float f2, float f3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), str}) == null) {
            float f4 = f2 - this.p;
            float f5 = f3 - this.o;
            boolean z = !this.L || Math.abs(f5) <= ((float) this.f24065e) || ((double) Math.abs(f4 / f5)) > Math.tan(Math.toRadians(30.0d));
            int i2 = this.f24065e;
            if (f4 <= i2 || this.q || !z) {
                return;
            }
            this.n = this.p + i2;
            this.q = true;
        }
    }

    public void C(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animationListener) == null) {
            b bVar = new b(this);
            this.B = bVar;
            bVar.setDuration(150L);
            this.B.setAnimationListener(animationListener);
            this.v.getView().clearAnimation();
            this.v.getView().startAnimation(this.B);
        }
    }

    @SuppressLint({"NewApi"})
    public final void D(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, animationListener) == null) {
            this.x = i2;
            this.y = ViewCompat.getScaleX(this.v.getView());
            f fVar = new f(this);
            this.C = fVar;
            fVar.setDuration(150L);
            if (animationListener != null) {
                this.C.setAnimationListener(animationListener);
            }
            this.v.getView().clearAnimation();
            this.v.getView().startAnimation(this.C);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.i.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.i.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.i.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.i.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) ? super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public final void g(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, animationListener) == null) {
            this.x = i2;
            this.N.reset();
            this.N.setDuration(200L);
            this.N.setInterpolator(this.u);
            if (animationListener != null) {
                this.N.setAnimationListener(animationListener);
            }
            if (this.v.getView().getVisibility() != 0) {
                this.v.getView().setVisibility(0);
            }
            this.v.getView().clearAnimation();
            this.v.getView().startAnimation(this.N);
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            int i4 = this.w;
            return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
        }
        return invokeII.intValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f24068h.getNestedScrollAxes() : invokeV.intValue;
    }

    public int getProgressCircleDiameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.E : invokeV.intValue;
    }

    public int getProgressViewEndOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.A : invokeV.intValue;
    }

    public int getProgressViewStartOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.z : invokeV.intValue;
    }

    public final void h(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, animationListener) == null) {
            if (this.s) {
                D(i2, animationListener);
                return;
            }
            this.x = i2;
            this.O.reset();
            this.O.setDuration(200L);
            this.O.setInterpolator(this.u);
            if (animationListener != null) {
                this.O.setAnimationListener(animationListener);
            }
            this.v.getView().clearAnimation();
            this.v.getView().startAnimation(this.O);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.i.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            j jVar = this.G;
            if (jVar != null) {
                return jVar.a(this, this.f24062b);
            }
            if (Build.VERSION.SDK_INT < 14) {
                View view = this.f24062b;
                if (!(view instanceof AbsListView)) {
                    return ViewCompat.canScrollVertically(view, -1) || this.f24062b.getScrollY() > 0;
                }
                AbsListView absListView = (AbsListView) view;
                return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
            }
            return ViewCompat.canScrollVertically(this.f24062b, -1);
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.i.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a = 3;
            this.v.d();
            postDelayed(new g(this), this.v.getCompleteAnimTime());
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            h hVar = new h(this, getContext());
            this.v = hVar;
            addView(hVar.getView());
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.f24062b == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.v.getView())) {
                    this.f24062b = childAt;
                    return;
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.a = 4;
            this.v.getView().clearAnimation();
            this.v.onFinish();
        }
    }

    public final void n(float f2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), str}) == null) {
            if (f2 > this.f24066f) {
                z(true, true);
                return;
            }
            this.f24064d = false;
            h(this.m, this.s ? null : new c(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            l();
            this.f24064d = false;
            t(1.0f);
            y();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDetachedFromWindow();
            y();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            l();
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.t && actionMasked == 0) {
                this.t = false;
            }
            if (!isEnabled() || this.t || i() || this.l) {
                return false;
            }
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i2 = this.r;
                        if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                            return false;
                        }
                        B(motionEvent.getY(findPointerIndex), motionEvent.getX(findPointerIndex), "onInterceptTouchEvent");
                    } else if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            u(motionEvent);
                        }
                    }
                }
                this.q = false;
                this.r = -1;
            } else {
                int pointerId = motionEvent.getPointerId(0);
                this.r = pointerId;
                this.q = false;
                int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                this.o = motionEvent.getX(findPointerIndex2);
                this.p = motionEvent.getY(findPointerIndex2);
            }
            return this.q;
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
            if (this.f24062b == null) {
                l();
            }
            View view = this.f24062b;
            if (view == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = (getPaddingTop() + this.m) - this.z;
            if (this.J) {
                paddingTop = getPaddingTop();
            }
            view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
            int measuredWidth2 = this.v.getView().getMeasuredWidth();
            int measuredHeight2 = this.v.getView().getMeasuredHeight();
            int i6 = measuredWidth / 2;
            int i7 = measuredWidth2 / 2;
            int i8 = this.m;
            this.v.getView().layout(i6 - i7, i8, i6 + i7, i8 + measuredHeight2);
            k kVar = this.K;
            if (kVar != null) {
                kVar.a(this.m, measuredHeight2, this.H);
                this.H = false;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048604, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.f24062b == null) {
                l();
            }
            View view = this.f24062b;
            if (view == null) {
                return;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.v.getView().measure(View.MeasureSpec.makeMeasureSpec(this.E, 1073741824), View.MeasureSpec.makeMeasureSpec(this.E, 1073741824));
            this.w = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.v.getView()) {
                    this.w = i4;
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
            int i3 = this.a;
            if ((i3 == 3 || i3 == 2) && f3 > 0.0f && (i2 = this.m) > this.z) {
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
            int i2 = this.a;
            if (i2 == 3 || i2 == 2 || this.v.getView() == null || this.v.getView().getBottom() <= 0) {
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
                float f2 = this.f24067g;
                if (f2 > 0.0f) {
                    float f3 = i3;
                    if (f3 > f2) {
                        iArr[1] = i3 - ((int) f2);
                        this.f24067g = 0.0f;
                    } else {
                        this.f24067g = f2 - f3;
                        iArr[1] = i3;
                    }
                    s(this.f24067g, "onNestedPreScroll-2");
                }
            }
            if (this.F && i3 > 0 && this.f24067g == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
                this.v.getView().setVisibility(8);
            }
            int[] iArr2 = this.j;
            if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
            }
            int i4 = i3 - iArr[1];
            if ((r() || this.a == 3) && Math.abs(i4) > 0) {
                if ((i4 <= 0 || this.m <= this.z) && (i4 >= 0 || this.m >= this.z + this.A || i())) {
                    return;
                }
                s(Math.max(Math.min(this.A, (this.m - this.z) - i4), 0.0f), "onNestedPreScroll-1");
                iArr[1] = iArr[1] + i4;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchNestedScroll(i2, i3, i4, i5, this.k);
            int i6 = i5 + this.k[1];
            if (i6 >= 0 || i() || this.f24064d) {
                return;
            }
            float abs = this.f24067g + Math.abs(i6);
            this.f24067g = abs;
            if (this.I) {
                float f2 = this.f24066f;
                if (abs > f2 * 0.6f) {
                    this.f24067g = f2 * 0.6f;
                }
                if (this.f24067g > this.f24066f * 0.6f * 0.8f) {
                    this.H = true;
                }
            }
            s(this.f24067g, "onNestedScroll");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048609, this, view, view2, i2) == null) {
            this.f24068h.onNestedScrollAccepted(view, view2, i2);
            startNestedScroll(i2 & 2);
            this.f24067g = 0.0f;
            this.l = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, view, view2, i2)) == null) ? (!isEnabled() || this.t || (i2 & 2) == 0) ? false : true : invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            this.f24068h.onStopNestedScroll(view);
            this.l = false;
            float f2 = this.f24067g;
            if (f2 > 0.0f) {
                n(f2, "onStopNestedScroll");
                this.f24067g = 0.0f;
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
            if (this.t && actionMasked == 0) {
                this.t = false;
            }
            if (!isEnabled() || this.t || i() || this.f24064d || this.l) {
                return false;
            }
            if (actionMasked == 0) {
                this.r = motionEvent.getPointerId(0);
                this.q = false;
            } else if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.r);
                if (findPointerIndex < 0) {
                    return false;
                }
                if (this.q) {
                    float y = (motionEvent.getY(findPointerIndex) - this.n) * 0.5f;
                    this.q = false;
                    if (this.I) {
                        float f2 = this.f24066f;
                        if (y > f2 * 0.6f) {
                            y = f2 * 0.6f;
                        }
                        if (y > this.f24066f * 0.6f * 0.8f) {
                            this.H = true;
                        }
                    }
                    n(y, "onTouchEvent(ACTION_UP)");
                }
                this.r = -1;
                return false;
            } else if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.r);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                float x = motionEvent.getX(findPointerIndex2);
                float y2 = motionEvent.getY(findPointerIndex2);
                B(y2, x, "onTouchEvent");
                if (this.q) {
                    float f3 = (y2 - this.n) * 0.5f;
                    if (f3 <= 0.0f) {
                        return false;
                    }
                    if (this.I) {
                        float f4 = this.f24066f;
                        if (f3 > f4 * 0.6f) {
                            f3 = f4 * 0.6f;
                        }
                        this.H = false;
                    }
                    s(f3, "onTouchEvent(ACTION_MOVE)");
                }
            } else if (actionMasked == 3) {
                return false;
            } else {
                if (actionMasked == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    if (actionIndex < 0) {
                        return false;
                    }
                    this.r = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    u(motionEvent);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? Build.VERSION.SDK_INT < 11 : invokeV.booleanValue;
    }

    public final boolean q(Animation animation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, animation)) == null) ? (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true : invokeL.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f24064d : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21 || !(this.f24062b instanceof AbsListView)) {
                View view = this.f24062b;
                if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                    super.requestDisallowInterceptTouchEvent(z);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void s(float f2, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Float.valueOf(f2), str}) == null) {
            float min = Math.min(1.0f, Math.abs(f2 / this.f24066f));
            float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            float abs = Math.abs(f2) - this.f24066f;
            float f3 = this.F ? this.A - this.z : this.A;
            double max2 = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
            float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
            int i3 = this.z + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
            if (this.v.getView().getVisibility() != 0) {
                this.v.getView().setVisibility(0);
            }
            if (!this.s) {
                ViewCompat.setScaleX(this.v.getView(), 1.0f);
                ViewCompat.setScaleY(this.v.getView(), 1.0f);
            }
            if (this.s) {
                setAnimationProgress(Math.min(1.0f, f2 / this.f24066f));
            }
            if (!this.f24064d && (i2 = this.a) != 3) {
                int i4 = this.z;
                int i5 = this.m;
                if (i4 >= i5 || i5 >= i4 + this.A) {
                    if (this.m >= this.z + this.A && this.a != 1) {
                        x();
                    }
                } else if (i2 != 0) {
                    v();
                }
                this.v.c(max, pow);
            }
            A(i3 - this.m, true, "moveSpinner");
        }
    }

    public void setAnimationProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048618, this, f2) == null) {
            if (p()) {
                setColorViewAlpha((int) (f2 * 255.0f));
                return;
            }
            ViewCompat.setScaleX(this.v.getView(), f2);
            ViewCompat.setScaleY(this.v.getView(), f2);
        }
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, iArr) == null) {
            l();
            i iVar = this.v;
            if (iVar instanceof h) {
                ((h) iVar).g(iArr);
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
            this.f24066f = i2;
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
            y();
        }
    }

    public void setLimitDragDistance(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.I = z;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.i.setNestedScrollingEnabled(z);
        }
    }

    public void setNoMoveTargetView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.J = z;
        }
    }

    public void setOnChildScrollUpCallback(@Nullable j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, jVar) == null) {
            this.G = jVar;
        }
    }

    public void setOnRefreshListener(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, lVar) == null) {
            this.f24063c = lVar;
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
            i iVar = this.v;
            if (iVar instanceof h) {
                ((h) iVar).f(i2);
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
        if (!(interceptable == null || interceptable.invokeL(1048631, this, iVar) == null) || iVar == null || iVar.getView() == null || iVar == (iVar2 = this.v) || this.a != 4) {
            return;
        }
        removeView(iVar2.getView());
        this.v = iVar;
        iVar.getView().setVisibility(8);
        addView(this.v.getView(), 0);
    }

    public void setProgressViewCallback(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, kVar) == null) {
            this.K = kVar;
        }
    }

    public void setProgressViewEndTarget(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.A = i2;
            this.s = z;
            this.v.getView().invalidate();
        }
    }

    public void setProgressViewOffset(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.s = z;
            this.z = i2;
            this.A = i3;
            this.F = true;
            y();
            this.f24064d = false;
        }
    }

    public void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (z && this.f24064d != z) {
                z(z, false);
            } else {
                z(z, false);
            }
        }
    }

    public void setSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            if ((i2 == 0 || i2 == 1) && (this.v instanceof h)) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                if (i2 == 0) {
                    this.E = (int) (displayMetrics.density * 56.0f);
                } else {
                    this.E = (int) (displayMetrics.density * 61.0f);
                }
                ((h) this.v).k(i2);
            }
        }
    }

    public void setUseSlideAngleToPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.L = z;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i2)) == null) ? this.i.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.i.stopNestedScroll();
        }
    }

    public void t(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048640, this, f2) == null) {
            int i2 = this.x;
            A((i2 + ((int) ((this.z - i2) * f2))) - this.v.getView().getTop(), false, "moveToStart");
        }
    }

    public final void u(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (motionEvent.getPointerId(actionIndex) == this.r) {
                this.r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.a = 0;
            this.v.a();
        }
    }

    public final void w() {
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.a = 2;
            this.v.e();
            if (!this.D || (lVar = this.f24063c) == null) {
                return;
            }
            lVar.onRefresh();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            this.a = 1;
            this.v.b();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            m();
            this.v.getView().setVisibility(8);
            setColorViewAlpha(255);
            if (this.s) {
                setAnimationProgress(0.0f);
            } else {
                A(this.z - this.m, true, "reset");
            }
            this.m = this.v.getView().getTop();
        }
    }

    public final void z(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f24064d == z) {
            return;
        }
        this.D = z2;
        l();
        this.f24064d = z;
        if (z) {
            g(this.m, this.M);
        } else {
            j();
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
        this.a = 4;
        this.f24064d = false;
        this.f24066f = -1.0f;
        this.j = new int[2];
        this.k = new int[2];
        this.r = -1;
        this.w = -1;
        this.L = false;
        this.M = new a(this);
        this.N = new d(this);
        this.O = new e(this);
        this.f24065e = ViewConfiguration.get(context).getScaledTouchSlop();
        getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.E = displayMetrics.widthPixels;
        k();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int i4 = (int) (displayMetrics.density * 86.0f);
        this.A = i4;
        this.f24066f = i4;
        this.f24068h = new NestedScrollingParentHelper(this);
        this.i = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i5 = -this.E;
        this.m = i5;
        this.z = i5;
        t(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
}
