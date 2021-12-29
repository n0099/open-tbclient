package com.baidu.live.framework.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.core.math.MathUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f36029d;

    /* renamed from: e  reason: collision with root package name */
    public OverScroller f36030e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36031f;

    /* renamed from: g  reason: collision with root package name */
    public int f36032g;

    /* renamed from: h  reason: collision with root package name */
    public int f36033h;

    /* renamed from: i  reason: collision with root package name */
    public int f36034i;

    /* renamed from: j  reason: collision with root package name */
    public VelocityTracker f36035j;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final CoordinatorLayout f36036e;

        /* renamed from: f  reason: collision with root package name */
        public final V f36037f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HeaderBehavior f36038g;

        public a(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headerBehavior, coordinatorLayout, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36038g = headerBehavior;
            this.f36036e = coordinatorLayout;
            this.f36037f = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f36037f == null || (overScroller = this.f36038g.f36030e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                HeaderBehavior headerBehavior = this.f36038g;
                headerBehavior.P(this.f36036e, this.f36037f, headerBehavior.f36030e.getCurrY());
                ViewCompat.postOnAnimation(this.f36037f, this);
                return;
            }
            this.f36038g.N(this.f36036e, this.f36037f);
        }
    }

    public HeaderBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36032g = -1;
        this.f36034i = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, coordinatorLayout, v, motionEvent)) == null) {
            if (this.f36034i < 0) {
                this.f36034i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    VelocityTracker velocityTracker = this.f36035j;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                        this.f36035j.computeCurrentVelocity(1000);
                        J(coordinatorLayout, v, -L(v), 0, this.f36035j.getYVelocity(this.f36032g));
                    }
                } else if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f36032g);
                    if (findPointerIndex == -1) {
                        return false;
                    }
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i2 = this.f36033h - y;
                    if (!this.f36031f) {
                        int abs = Math.abs(i2);
                        int i3 = this.f36034i;
                        if (abs > i3) {
                            this.f36031f = true;
                            i2 = i2 > 0 ? i2 - i3 : i2 + i3;
                        }
                    }
                    int i4 = i2;
                    if (this.f36031f) {
                        this.f36033h = y;
                        O(coordinatorLayout, v, i4, K(v), 0);
                    }
                }
                this.f36031f = false;
                this.f36032g = -1;
                VelocityTracker velocityTracker2 = this.f36035j;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f36035j = null;
                }
            } else {
                int y2 = (int) motionEvent.getY();
                if (!coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), y2) || !H(v)) {
                    return false;
                }
                this.f36033h = y2;
                this.f36032g = motionEvent.getPointerId(0);
                I();
            }
            VelocityTracker velocityTracker3 = this.f36035j;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean H(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f36035j == null) {
            this.f36035j = VelocityTracker.obtain();
        }
    }

    public final boolean J(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
            Runnable runnable = this.f36029d;
            if (runnable != null) {
                v.removeCallbacks(runnable);
                this.f36029d = null;
            }
            if (this.f36030e == null) {
                this.f36030e = new OverScroller(v.getContext());
            }
            this.f36030e.fling(0, E(), 0, Math.round(f2), 0, 0, i2, i3);
            if (this.f36030e.computeScrollOffset()) {
                a aVar = new a(this, coordinatorLayout, v);
                this.f36029d = aVar;
                ViewCompat.postOnAnimation(v, aVar);
                return true;
            }
            N(coordinatorLayout, v);
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public int K(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, v)) == null) ? -v.getHeight() : invokeL.intValue;
    }

    public int L(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, v)) == null) ? v.getHeight() : invokeL.intValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? E() : invokeV.intValue;
    }

    public void N(CoordinatorLayout coordinatorLayout, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, coordinatorLayout, v) == null) {
        }
    }

    public final int O(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? Q(coordinatorLayout, v, M() - i2, i3, i4) : invokeCommon.intValue;
    }

    public int P(CoordinatorLayout coordinatorLayout, V v, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, coordinatorLayout, v, i2)) == null) ? Q(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE) : invokeLLI.intValue;
    }

    public int Q(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int clamp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int E = E();
            if (i3 == 0 || E < i3 || E > i4 || E == (clamp = MathUtils.clamp(i2, i3, i4))) {
                return 0;
            }
            G(clamp);
            return E - clamp;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (r0 != 3) goto L19;
     */
    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, coordinatorLayout, v, motionEvent)) == null) {
            if (this.f36034i < 0) {
                this.f36034i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            if (motionEvent.getAction() == 2 && this.f36031f) {
                return true;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i2 = this.f36032g;
                        if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1) {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.f36033h) > this.f36034i) {
                                this.f36031f = true;
                                this.f36033h = y;
                            }
                        }
                    }
                }
                this.f36031f = false;
                this.f36032g = -1;
                VelocityTracker velocityTracker = this.f36035j;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f36035j = null;
                }
            } else {
                this.f36031f = false;
                int x = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                if (H(v) && coordinatorLayout.isPointInChildBounds(v, x, y2)) {
                    this.f36033h = y2;
                    this.f36032g = motionEvent.getPointerId(0);
                    I();
                }
            }
            VelocityTracker velocityTracker2 = this.f36035j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return this.f36031f;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36032g = -1;
        this.f36034i = -1;
    }
}
