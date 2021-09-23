package com.baidu.live.business.refresh;

import android.annotation.SuppressLint;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.PathUtils;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BdSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FINISH = 4;
    public static final int[] L;
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
    public i H;
    public Animation.AnimationListener I;
    public final Animation J;
    public final Animation K;

    /* renamed from: e  reason: collision with root package name */
    public int f40850e;

    /* renamed from: f  reason: collision with root package name */
    public View f40851f;

    /* renamed from: g  reason: collision with root package name */
    public j f40852g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40853h;

    /* renamed from: i  reason: collision with root package name */
    public int f40854i;

    /* renamed from: j  reason: collision with root package name */
    public float f40855j;
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
    public h y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f40856a;

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
            this.f40856a = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @SuppressLint({"NewApi"})
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f40856a;
                if (bdSwipeRefreshLayout.f40853h) {
                    bdSwipeRefreshLayout.p();
                    BdSwipeRefreshLayout bdSwipeRefreshLayout2 = this.f40856a;
                    bdSwipeRefreshLayout2.q = bdSwipeRefreshLayout2.y.getView().getTop();
                    return;
                }
                bdSwipeRefreshLayout.r();
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

    /* loaded from: classes5.dex */
    public class b extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f40857e;

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
            this.f40857e = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                this.f40857e.setAnimationProgress(1.0f - f2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f40858a;

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
            this.f40858a = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f40858a;
                if (!bdSwipeRefreshLayout.v) {
                    bdSwipeRefreshLayout.v(null);
                }
                this.f40858a.i();
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

    /* loaded from: classes5.dex */
    public class d extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f40859e;

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
            this.f40859e = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f40859e;
                if (!bdSwipeRefreshLayout.G) {
                    i2 = bdSwipeRefreshLayout.B - Math.abs(bdSwipeRefreshLayout.mOriginalOffsetTop);
                } else {
                    i2 = bdSwipeRefreshLayout.B;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout2 = this.f40859e;
                int i3 = bdSwipeRefreshLayout2.mFrom;
                this.f40859e.t((i3 + ((int) ((i2 - i3) * f2))) - bdSwipeRefreshLayout2.y.getView().getTop(), false, "AnimateToCorrectPosition");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f40860e;

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
            this.f40860e = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                this.f40860e.m(f2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f40861e;

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
            this.f40861e = bdSwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f40861e;
                float f3 = bdSwipeRefreshLayout.A;
                bdSwipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
                this.f40861e.m(f2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwipeRefreshLayout f40862e;

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
            this.f40862e = bdSwipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f40862e;
                bdSwipeRefreshLayout.f(bdSwipeRefreshLayout.q, bdSwipeRefreshLayout.I);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        long getCompleteAnimTime();

        View getView();

        void onCompleteRefresh();

        void onFinish();

        void onPullPercentChange(float f2, float f3);

        void onPullToRefresh();

        void onRefreshing();

        void onReleaseToRefresh();
    }

    /* loaded from: classes5.dex */
    public interface i {
        boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, @Nullable View view);
    }

    /* loaded from: classes5.dex */
    public interface j {
        void onRefresh();
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
        L = new int[]{16842766};
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
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, this, i2) == null) || (hVar = this.y) == null || hVar.getView() == null || this.y.getView().getBackground() == null) {
            return;
        }
        this.y.getView().getBackground().setAlpha(i2);
    }

    public boolean canChildScrollUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i iVar = this.H;
            if (iVar != null) {
                return iVar.a(this, this.f40851f);
            }
            if (Build.VERSION.SDK_INT < 14) {
                View view = this.f40851f;
                if (!(view instanceof AbsListView)) {
                    return ViewCompat.canScrollVertically(view, -1) || this.f40851f.getScrollY() > 0;
                }
                AbsListView absListView = (AbsListView) view;
                return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
            }
            return ViewCompat.canScrollVertically(this.f40851f, -1);
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.m.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.m.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.m.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.m.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) ? super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public final void e(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, animationListener) == null) {
            this.mFrom = i2;
            this.J.reset();
            this.J.setDuration(200L);
            this.J.setInterpolator(this.x);
            if (animationListener != null) {
                this.J.setAnimationListener(animationListener);
            }
            if (this.y.getView().getVisibility() != 0) {
                this.y.getView().setVisibility(0);
            }
            this.y.getView().clearAnimation();
            this.y.getView().startAnimation(this.J);
        }
    }

    public final void f(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, animationListener) == null) {
            if (this.v) {
                w(i2, animationListener);
                return;
            }
            this.mFrom = i2;
            this.K.reset();
            this.K.setDuration(200L);
            this.K.setInterpolator(this.x);
            if (animationListener != null) {
                this.K.setAnimationListener(animationListener);
            }
            this.y.getView().clearAnimation();
            this.y.getView().startAnimation(this.K);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f40850e = 3;
            this.y.onCompleteRefresh();
            postDelayed(new g(this), this.y.getCompleteAnimTime());
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            int i4 = this.z;
            return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
        }
        return invokeII.intValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l.getNestedScrollAxes() : invokeV.intValue;
    }

    public int getProgressCircleDiameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.F : invokeV.intValue;
    }

    public int getProgressViewEndOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.B : invokeV.intValue;
    }

    public int getProgressViewStartOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mOriginalOffsetTop : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.f40851f == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.y.getView())) {
                    this.f40851f = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f40850e = 4;
            this.y.getView().clearAnimation();
            this.y.onFinish();
        }
    }

    public void interruptRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            h();
            this.f40853h = false;
            m(1.0f);
            r();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.m.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    public boolean isRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f40853h : invokeV.booleanValue;
    }

    public final void j(float f2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f2), str}) == null) {
            if (f2 > this.f40855j) {
                s(true, true);
                return;
            }
            this.f40853h = false;
            f(this.q, this.v ? null : new c(this));
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? Build.VERSION.SDK_INT < 11 : invokeV.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public final void l(float f2, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f2), str}) == null) {
            float min = Math.min(1.0f, Math.abs(f2 / this.f40855j));
            float abs = Math.abs(f2) - this.f40855j;
            float f3 = this.G ? this.B - this.mOriginalOffsetTop : this.B;
            double max = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
            float pow = ((float) (max - Math.pow(max, 2.0d))) * 2.0f;
            int i3 = this.mOriginalOffsetTop + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
            if (this.y.getView().getVisibility() != 0) {
                this.y.getView().setVisibility(0);
            }
            if (!this.v) {
                ViewCompat.setScaleX(this.y.getView(), 1.0f);
                ViewCompat.setScaleY(this.y.getView(), 1.0f);
            }
            if (this.v) {
                setAnimationProgress(Math.min(1.0f, f2 / this.f40855j));
            }
            if (!this.f40853h && (i2 = this.f40850e) != 3) {
                int i4 = this.mOriginalOffsetTop;
                int i5 = this.q;
                if (i4 >= i5 || i5 >= i4 + this.B) {
                    if (this.q >= this.mOriginalOffsetTop + this.B && this.f40850e != 1) {
                        q();
                    }
                } else if (i2 != 0) {
                    o();
                }
                if (!PathUtils.DIRCTORY_BAIDU.equals(LiveFeedPageSdk.e().d()) && !"haokan".equals(LiveFeedPageSdk.e().d())) {
                    if ("quanmin".equals(LiveFeedPageSdk.e().d())) {
                        f2 -= (int) (this.f40855j * 0.6d);
                    } else if (!"tieba".equals(LiveFeedPageSdk.e().d())) {
                        f2 = 0.0f;
                    }
                }
                if (f2 >= 0.0f) {
                    this.y.onPullPercentChange(Math.min(1.0f, f2 / this.f40855j), pow);
                }
            }
            t(i3 - this.q, true, "moveSpinner");
        }
    }

    public void m(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            int i2 = this.mFrom;
            t((i2 + ((int) ((this.mOriginalOffsetTop - i2) * f2))) - this.y.getView().getTop(), false, "moveToStart");
        }
    }

    public final void n(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (motionEvent.getPointerId(actionIndex) == this.u) {
                this.u = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f40850e = 0;
            this.y.onPullToRefresh();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            r();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            h();
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
                        u(motionEvent.getY(findPointerIndex), "onInterceptTouchEvent");
                    } else if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            n(motionEvent);
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
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (getChildCount() == 0) {
                return;
            }
            if (this.f40851f == null) {
                h();
            }
            View view = this.f40851f;
            if (view == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = (getPaddingTop() + this.q) - this.mOriginalOffsetTop;
            view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
            int measuredWidth2 = this.y.getView().getMeasuredWidth();
            int measuredHeight2 = this.y.getView().getMeasuredHeight();
            int i6 = measuredWidth / 2;
            int i7 = measuredWidth2 / 2;
            int i8 = this.q;
            this.y.getView().layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.f40851f == null) {
                h();
            }
            View view = this.f40851f;
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            int i3 = this.f40850e;
            if ((i3 == 3 || i3 == 2) && f3 > 0.0f && (i2 = this.q) > this.mOriginalOffsetTop) {
                f(i2, null);
            }
            return dispatchNestedFling(f2, f3, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int i2 = this.f40850e;
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
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
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
                    l(this.k, "onNestedPreScroll-2");
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
            if ((isRefreshing() || this.f40850e == 3) && Math.abs(i4) > 0) {
                if ((i4 <= 0 || this.q <= this.mOriginalOffsetTop) && (i4 >= 0 || this.q >= this.mOriginalOffsetTop + this.B || canChildScrollUp())) {
                    return;
                }
                l(Math.max(Math.min(this.B, (this.q - this.mOriginalOffsetTop) - i4), 0.0f), "onNestedPreScroll-1");
                iArr[1] = iArr[1] + i4;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchNestedScroll(i2, i3, i4, i5, this.o);
            int i6 = i5 + this.o[1];
            if (i6 >= 0 || canChildScrollUp() || this.f40853h) {
                return;
            }
            float abs = this.k + Math.abs(i6);
            this.k = abs;
            l(abs, "onNestedScroll");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048610, this, view, view2, i2) == null) {
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
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048611, this, view, view2, i2)) == null) ? (!isEnabled() || this.w || (i2 & 2) == 0) ? false : true : invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view) == null) {
            this.l.onStopNestedScroll(view);
            this.p = false;
            float f2 = this.k;
            if (f2 > 0.0f) {
                j(f2, "onStopNestedScroll");
                this.k = 0.0f;
            }
            stopNestedScroll();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.w && actionMasked == 0) {
                this.w = false;
            }
            if (!isEnabled() || this.w || canChildScrollUp() || this.f40853h || this.p) {
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
                    this.t = false;
                    j((motionEvent.getY(findPointerIndex) - this.r) * 0.5f, "onTouchEvent(ACTION_UP)");
                }
                this.u = -1;
                return false;
            } else if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.u);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                float y = motionEvent.getY(findPointerIndex2);
                u(y, "onTouchEvent");
                if (this.t) {
                    float f2 = (y - this.r) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    l(f2, "onTouchEvent(ACTION_MOVE)");
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
                    n(motionEvent);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p() {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f40850e = 2;
            this.y.onRefreshing();
            if (!this.E || (jVar = this.f40852g) == null) {
                return;
            }
            jVar.onRefresh();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.f40850e = 1;
            this.y.onReleaseToRefresh();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            i();
            this.y.getView().setVisibility(8);
            setColorViewAlpha(255);
            if (this.v) {
                setAnimationProgress(0.0f);
            } else {
                t(this.mOriginalOffsetTop - this.q, true, "reset");
            }
            this.q = this.y.getView().getTop();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21 || !(this.f40851f instanceof AbsListView)) {
                View view = this.f40851f;
                if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                    super.requestDisallowInterceptTouchEvent(z);
                }
            }
        }
    }

    public final void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f40853h == z) {
            return;
        }
        this.E = z2;
        h();
        this.f40853h = z;
        if (z) {
            e(this.q, this.I);
        } else {
            g();
        }
    }

    public void setAnimationProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            if (k()) {
                setColorViewAlpha((int) (f2 * 255.0f));
                return;
            }
            ViewCompat.setScaleX(this.y.getView(), f2);
            ViewCompat.setScaleY(this.y.getView(), f2);
        }
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, iArr) == null) {
            h();
        }
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, iArr) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.f40855j = i2;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                return;
            }
            r();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.m.setNestedScrollingEnabled(z);
        }
    }

    public void setOnChildScrollUpCallback(@Nullable i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, iVar) == null) {
            this.H = iVar;
        }
    }

    public void setOnRefreshListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, jVar) == null) {
            this.f40852g = jVar;
        }
    }

    public void setProgressView(h hVar) {
        h hVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, hVar) == null) || hVar == null || hVar.getView() == null || hVar == (hVar2 = this.y) || this.f40850e != 4) {
            return;
        }
        if (hVar2 != null) {
            removeView(hVar2.getView());
        }
        this.y = hVar;
        hVar.getView().setVisibility(8);
        addView(this.y.getView(), 0);
    }

    public void setProgressViewEndTarget(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.B = i2;
            this.v = z;
            this.y.getView().invalidate();
        }
    }

    public void setProgressViewOffset(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.v = z;
            this.mOriginalOffsetTop = i2;
            this.B = i3;
            this.G = true;
            r();
            this.f40853h = false;
        }
    }

    public void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            if (z && this.f40853h != z) {
                s(z, false);
            } else {
                s(z, false);
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) ? this.m.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.m.stopNestedScroll();
        }
    }

    public void t(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.y.getView().bringToFront();
            ViewCompat.offsetTopAndBottom(this.y.getView(), i2);
            View view = this.f40851f;
            if (view != null) {
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
    public final void u(float f2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Float.valueOf(f2), str}) == null) {
            float f3 = this.s;
            int i2 = this.f40854i;
            if (f2 - f3 <= i2 || this.t) {
                return;
            }
            this.r = f3 + i2;
            this.t = true;
        }
    }

    public void v(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, animationListener) == null) {
            b bVar = new b(this);
            this.C = bVar;
            bVar.setDuration(150L);
            this.C.setAnimationListener(animationListener);
            this.y.getView().clearAnimation();
            this.y.getView().startAnimation(this.C);
        }
    }

    @SuppressLint({"NewApi"})
    public final void w(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048636, this, i2, animationListener) == null) {
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
        this.f40850e = 4;
        this.f40853h = false;
        this.f40855j = -1.0f;
        this.n = new int[2];
        this.o = new int[2];
        this.u = -1;
        this.z = -1;
        this.I = new a(this);
        this.J = new d(this);
        this.K = new e(this);
        this.f40854i = ViewConfiguration.get(context).getScaledTouchSlop();
        getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.x = new DecelerateInterpolator(2.0f);
        this.F = getResources().getDisplayMetrics().widthPixels;
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        if (PathUtils.DIRCTORY_BAIDU.equals(LiveFeedPageSdk.e().d())) {
            this.B = getResources().getDimensionPixelSize(c.a.w.c.a.a.pull_down_refersh_height_bd);
        } else if ("haokan".equals(LiveFeedPageSdk.e().d())) {
            this.B = getResources().getDimensionPixelSize(c.a.w.c.a.a.pull_down_refersh_height_hk);
        } else if ("quanmin".equals(LiveFeedPageSdk.e().d())) {
            this.B = getResources().getDimensionPixelSize(c.a.w.c.a.a.pull_down_refersh_height_qm);
        } else if ("tieba".equals(LiveFeedPageSdk.e().d())) {
            this.B = getResources().getDimensionPixelSize(c.a.w.c.a.a.pull_down_refersh_height_bd);
        }
        this.f40855j = this.B;
        this.l = new NestedScrollingParentHelper(this);
        this.m = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i4 = -this.F;
        this.q = i4;
        this.mOriginalOffsetTop = i4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
}
