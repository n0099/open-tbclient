package com.baidu.live.business.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BdSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] J;
    public transient /* synthetic */ FieldHolder $fh;
    public Animation A;
    public Animation B;
    public boolean C;
    public int D;
    public boolean E;
    public i F;
    public Animation.AnimationListener G;
    public final Animation H;
    public final Animation I;
    public int a;
    public View b;
    public j c;
    public boolean d;
    public int e;
    public float f;
    public float g;
    public final NestedScrollingParentHelper h;
    public final NestedScrollingChildHelper i;
    public final int[] j;
    public final int[] k;
    public boolean l;
    public int m;
    public float n;
    public float o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public final DecelerateInterpolator t;
    public h u;
    public int v;
    public int w;
    public float x;
    public int y;
    public int z;

    /* loaded from: classes2.dex */
    public interface h {
        void a();

        void b();

        void c(float f, float f2);

        void d();

        void e();

        long getCompleteAnimTime();

        View getView();

        void onFinish();
    }

    /* loaded from: classes2.dex */
    public interface i {
        boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, @Nullable View view2);
    }

    /* loaded from: classes2.dex */
    public interface j {
        void onRefresh();
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSwipeRefreshLayout a;

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
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a;
                if (!bdSwipeRefreshLayout.d) {
                    bdSwipeRefreshLayout.t();
                    return;
                }
                bdSwipeRefreshLayout.r();
                BdSwipeRefreshLayout bdSwipeRefreshLayout2 = this.a;
                bdSwipeRefreshLayout2.m = bdSwipeRefreshLayout2.u.getView().getTop();
            }
        }
    }

    /* loaded from: classes2.dex */
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
        public void applyTransformation(float f, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) == null) {
                this.a.setAnimationProgress(1.0f - f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSwipeRefreshLayout a;

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
                if (!bdSwipeRefreshLayout.r) {
                    bdSwipeRefreshLayout.x(null);
                }
                this.a.j();
            }
        }
    }

    /* loaded from: classes2.dex */
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
        public void applyTransformation(float f, Transformation transformation) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a;
                if (!bdSwipeRefreshLayout.E) {
                    i = bdSwipeRefreshLayout.z - Math.abs(bdSwipeRefreshLayout.y);
                } else {
                    i = bdSwipeRefreshLayout.z;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout2 = this.a;
                int i2 = bdSwipeRefreshLayout2.w;
                this.a.v((i2 + ((int) ((i - i2) * f))) - bdSwipeRefreshLayout2.u.getView().getTop(), false, "AnimateToCorrectPosition");
            }
        }
    }

    /* loaded from: classes2.dex */
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
        public void applyTransformation(float f, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) == null) {
                this.a.o(f);
            }
        }
    }

    /* loaded from: classes2.dex */
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
        public void applyTransformation(float f, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a;
                float f2 = bdSwipeRefreshLayout.x;
                bdSwipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
                this.a.o(f);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                bdSwipeRefreshLayout.f(bdSwipeRefreshLayout.m, bdSwipeRefreshLayout.G);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-315587200, "Lcom/baidu/live/business/refresh/BdSwipeRefreshLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-315587200, "Lcom/baidu/live/business/refresh/BdSwipeRefreshLayout;");
                return;
            }
        }
        J = new int[]{16842766};
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            i iVar = this.F;
            if (iVar != null) {
                return iVar.a(this, this.b);
            }
            return ViewCompat.canScrollVertically(this.b, -1);
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h.getNestedScrollAxes();
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a = 3;
            this.u.d();
            postDelayed(new g(this), this.u.getCompleteAnimTime());
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.i.hasNestedScrollingParent();
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.b == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.u.getView())) {
                    this.b = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.i.isNestedScrollingEnabled();
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a = 4;
            this.u.getView().clearAnimation();
            this.u.onFinish();
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDetachedFromWindow();
            t();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.a = 0;
            this.u.a();
        }
    }

    public final void r() {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.a = 2;
            this.u.e();
            if (this.C && (jVar = this.c) != null) {
                jVar.onRefresh();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.a = 1;
            this.u.b();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.i.stopNestedScroll();
        }
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

    private void setColorViewAlpha(int i2) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65543, this, i2) == null) && (hVar = this.u) != null && hVar.getView() != null && this.u.getView().getBackground() != null) {
            this.u.getView().getBackground().setAlpha(i2);
        }
    }

    public void setProgressView(h hVar) {
        h hVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, hVar) != null) || hVar == null || hVar.getView() == null || hVar == (hVar2 = this.u) || this.a != 4) {
            return;
        }
        if (hVar2 != null) {
            removeView(hVar2.getView());
        }
        this.u = hVar;
        hVar.getView().setVisibility(8);
        addView(this.u.getView(), 0);
    }

    public void x(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, animationListener) == null) {
            b bVar = new b(this);
            this.A = bVar;
            bVar.setDuration(150L);
            this.A.setAnimationListener(animationListener);
            this.u.getView().clearAnimation();
            this.u.getView().startAnimation(this.A);
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
        this.d = false;
        this.f = -1.0f;
        this.j = new int[2];
        this.k = new int[2];
        this.q = -1;
        this.v = -1;
        this.G = new a(this);
        this.H = new d(this);
        this.I = new e(this);
        this.e = ViewConfiguration.get(context).getScaledTouchSlop();
        getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.t = new DecelerateInterpolator(2.0f);
        this.D = getResources().getDisplayMetrics().widthPixels;
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        if ("baidu".equals(LiveFeedPageSdk.getInstance().getHost())) {
            this.z = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070617);
        } else if (LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
            this.z = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070618);
        } else if (LiveFeedPageSdk.HOST_QUANMIN.equals(LiveFeedPageSdk.getInstance().getHost())) {
            this.z = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070619);
        } else if ("tieba".equals(LiveFeedPageSdk.getInstance().getHost())) {
            this.z = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070617);
        }
        this.f = this.z;
        this.h = new NestedScrollingParentHelper(this);
        this.i = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i4 = -this.D;
        this.m = i4;
        this.y = i4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, J);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    public final void n(float f2, String str) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), str}) == null) {
            float min = Math.min(1.0f, Math.abs(f2 / this.f));
            float abs = Math.abs(f2) - this.f;
            if (this.E) {
                i2 = this.z - this.y;
            } else {
                i2 = this.z;
            }
            float f3 = i2;
            double max = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
            float pow = ((float) (max - Math.pow(max, 2.0d))) * 2.0f;
            int i4 = this.y + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
            if (this.u.getView().getVisibility() != 0) {
                this.u.getView().setVisibility(0);
            }
            if (!this.r) {
                ViewCompat.setScaleX(this.u.getView(), 1.0f);
                ViewCompat.setScaleY(this.u.getView(), 1.0f);
            }
            if (this.r) {
                setAnimationProgress(Math.min(1.0f, f2 / this.f));
            }
            if (!this.d && (i3 = this.a) != 3) {
                int i5 = this.y;
                int i6 = this.m;
                if (i5 < i6 && i6 < i5 + this.z) {
                    if (i3 != 0) {
                        q();
                    }
                } else if (this.m >= this.y + this.z && this.a != 1) {
                    s();
                }
                if (!"baidu".equals(LiveFeedPageSdk.getInstance().getHost()) && !LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                    if (LiveFeedPageSdk.HOST_QUANMIN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                        f2 -= (int) (this.f * 0.6d);
                    } else if (!"tieba".equals(LiveFeedPageSdk.getInstance().getHost())) {
                        f2 = 0.0f;
                    }
                }
                if (f2 >= 0.0f) {
                    this.u.c(Math.min(1.0f, f2 / this.f), pow);
                }
            }
            v(i4 - this.m, true, "moveSpinner");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void o(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            int i2 = this.w;
            v((i2 + ((int) ((this.y - i2) * f2))) - this.u.getView().getTop(), false, "moveToStart");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            this.h.onStopNestedScroll(view2);
            this.l = false;
            float f2 = this.g;
            if (f2 > 0.0f) {
                k(f2, "onStopNestedScroll");
                this.g = 0.0f;
            }
            stopNestedScroll();
        }
    }

    public final void p(MotionEvent motionEvent) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (motionEvent.getPointerId(actionIndex) == this.q) {
                if (actionIndex == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                this.q = motionEvent.getPointerId(i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21 || !(this.b instanceof AbsListView)) {
                View view2 = this.b;
                if (view2 != null && !ViewCompat.isNestedScrollingEnabled(view2)) {
                    return;
                }
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setAnimationProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
            if (l()) {
                setColorViewAlpha((int) (f2 * 255.0f));
                return;
            }
            ViewCompat.setScaleX(this.u.getView(), f2);
            ViewCompat.setScaleY(this.u.getView(), f2);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            super.setEnabled(z);
            if (!z) {
                this.m = 0;
                t();
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.i.setNestedScrollingEnabled(z);
        }
    }

    public void setOnRefreshListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jVar) == null) {
            this.c = jVar;
        }
    }

    public void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048618, this, z) != null) || !isEnabled()) {
            return;
        }
        if (z && this.d != z) {
            u(z, false);
        } else {
            u(z, false);
        }
    }

    public void setScene(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            if ("recommend".equals(str)) {
                this.z = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070617);
            }
            this.f = this.z;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
            return this.i.startNestedScroll(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view2, View view3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048604, this, view2, view3, i2) == null) {
            this.h.onNestedScrollAccepted(view2, view3, i2);
            startNestedScroll(i2 & 2);
            this.g = 0.0f;
            this.l = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view2, View view3, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048605, this, view2, view3, i2)) == null) {
            if (isEnabled() && !this.s && (i2 & 2) != 0) {
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            return this.i.dispatchNestedFling(f2, f3, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return this.i.dispatchNestedPreFling(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            int i4 = this.v;
            if (i4 < 0) {
                return i3;
            }
            if (i3 == i2 - 1) {
                return i4;
            }
            if (i3 >= i4) {
                return i3 + 1;
            }
            return i3;
        }
        return invokeII.intValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) {
            return this.i.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) {
            return this.i.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }
        return invokeCommon.booleanValue;
    }

    public final void e(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, animationListener) == null) {
            this.w = i2;
            this.H.reset();
            this.H.setDuration(200L);
            this.H.setInterpolator(this.t);
            if (animationListener != null) {
                this.H.setAnimationListener(animationListener);
            }
            if (this.u.getView().getVisibility() != 0) {
                this.u.getView().setVisibility(0);
            }
            this.u.getView().clearAnimation();
            this.u.getView().startAnimation(this.H);
        }
    }

    public final void f(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, animationListener) == null) {
            if (this.r) {
                y(i2, animationListener);
                return;
            }
            this.w = i2;
            this.I.reset();
            this.I.setDuration(200L);
            this.I.setInterpolator(this.t);
            if (animationListener != null) {
                this.I.setAnimationListener(animationListener);
            }
            this.u.getView().clearAnimation();
            this.u.getView().startAnimation(this.I);
        }
    }

    public final void k(float f2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), str}) == null) {
            if (f2 > this.f) {
                u(true, true);
                return;
            }
            this.d = false;
            c cVar = null;
            if (!this.r) {
                cVar = new c(this);
            }
            f(this.m, cVar);
        }
    }

    public final void u(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.d != z) {
            this.C = z2;
            i();
            this.d = z;
            if (z) {
                e(this.m, this.G);
            } else {
                h();
            }
        }
    }

    public final void w(float f2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Float.valueOf(f2), str}) == null) {
            float f3 = this.o;
            int i2 = this.e;
            if (f2 - f3 > i2 && !this.p) {
                this.n = f3 + i2;
                this.p = true;
            }
        }
    }

    public final void y(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048627, this, i2, animationListener) == null) {
            this.w = i2;
            this.x = ViewCompat.getScaleX(this.u.getView());
            f fVar = new f(this);
            this.B = fVar;
            fVar.setDuration(150L);
            if (animationListener != null) {
                this.B.setAnimationListener(animationListener);
            }
            this.u.getView().clearAnimation();
            this.u.getView().startAnimation(this.B);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            i();
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.s && actionMasked == 0) {
                this.s = false;
            }
            if (!isEnabled() || this.s || g() || this.l) {
                return false;
            }
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 6) {
                                p(motionEvent);
                            }
                        }
                    } else {
                        int i2 = this.q;
                        if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                            return false;
                        }
                        w(motionEvent.getY(findPointerIndex), "onInterceptTouchEvent");
                    }
                }
                this.p = false;
                this.q = -1;
            } else {
                int pointerId = motionEvent.getPointerId(0);
                this.q = pointerId;
                this.p = false;
                int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                this.o = motionEvent.getY(findPointerIndex2);
            }
            return this.p;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (getChildCount() == 0) {
                return;
            }
            if (this.b == null) {
                i();
            }
            View view2 = this.b;
            if (view2 == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = (getPaddingTop() + this.m) - this.y;
            view2.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
            int measuredWidth2 = this.u.getView().getMeasuredWidth();
            int measuredHeight2 = this.u.getView().getMeasuredHeight();
            int i6 = measuredWidth / 2;
            int i7 = measuredWidth2 / 2;
            int i8 = this.m;
            this.u.getView().layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.b == null) {
                i();
            }
            View view2 = this.b;
            if (view2 == null) {
                return;
            }
            view2.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.u.getView().measure(View.MeasureSpec.makeMeasureSpec(this.D, 1073741824), View.MeasureSpec.makeMeasureSpec(this.D, 1073741824));
            this.v = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.u.getView()) {
                    this.v = i4;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view2, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            int i3 = this.a;
            if ((i3 == 3 || i3 == 2) && f3 > 0.0f && (i2 = this.m) > this.y) {
                f(i2, null);
            }
            return dispatchNestedFling(f2, f3, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int i2 = this.a;
            if (i2 != 3 && i2 != 2 && this.u.getView() != null && this.u.getView().getBottom() > 0) {
                return true;
            }
            return dispatchNestedPreFling(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public void v(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.u.getView().bringToFront();
            ViewCompat.offsetTopAndBottom(this.u.getView(), i2);
            View view2 = this.b;
            if (view2 != null) {
                ViewCompat.offsetTopAndBottom(view2, i2);
            }
            this.m = this.u.getView().getTop();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view2, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            if (i3 > 0) {
                float f2 = this.g;
                if (f2 > 0.0f) {
                    float f3 = i3;
                    if (f3 > f2) {
                        iArr[1] = i3 - ((int) f2);
                        this.g = 0.0f;
                    } else {
                        this.g = f2 - f3;
                        iArr[1] = i3;
                    }
                    n(this.g, "onNestedPreScroll-2");
                }
            }
            if (this.E && i3 > 0 && this.g == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
                this.u.getView().setVisibility(8);
            }
            int[] iArr2 = this.j;
            if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
            }
            int i4 = i3 - iArr[1];
            if ((m() || this.a == 3) && Math.abs(i4) > 0) {
                if ((i4 > 0 && this.m > this.y) || (i4 < 0 && this.m < this.y + this.z && !g())) {
                    n(Math.max(Math.min(this.z, (this.m - this.y) - i4), 0.0f), "onNestedPreScroll-1");
                    iArr[1] = iArr[1] + i4;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view2, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchNestedScroll(i2, i3, i4, i5, this.k);
            int i6 = i5 + this.k[1];
            if (i6 < 0 && !g() && !this.d) {
                float abs = this.g + Math.abs(i6);
                this.g = abs;
                n(abs, "onNestedScroll");
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.s && actionMasked == 0) {
                this.s = false;
            }
            if (!isEnabled() || this.s || g() || this.d || this.l) {
                return false;
            }
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked == 3) {
                            return false;
                        }
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                p(motionEvent);
                            }
                        } else {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            if (actionIndex < 0) {
                                return false;
                            }
                            this.q = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.q);
                        if (findPointerIndex < 0) {
                            return false;
                        }
                        float y = motionEvent.getY(findPointerIndex);
                        w(y, "onTouchEvent");
                        if (this.p) {
                            float f2 = (y - this.n) * 0.5f;
                            if (f2 <= 0.0f) {
                                return false;
                            }
                            n(f2, "onTouchEvent(ACTION_MOVE)");
                        }
                    }
                } else {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.q);
                    if (findPointerIndex2 < 0) {
                        return false;
                    }
                    if (this.p) {
                        this.p = false;
                        k((motionEvent.getY(findPointerIndex2) - this.n) * 0.5f, "onTouchEvent(ACTION_UP)");
                    }
                    this.q = -1;
                    return false;
                }
            } else {
                this.q = motionEvent.getPointerId(0);
                this.p = false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            j();
            this.u.getView().setVisibility(8);
            setColorViewAlpha(255);
            if (this.r) {
                setAnimationProgress(0.0f);
            } else {
                v(this.y - this.m, true, "reset");
            }
            this.m = this.u.getView().getTop();
        }
    }
}
