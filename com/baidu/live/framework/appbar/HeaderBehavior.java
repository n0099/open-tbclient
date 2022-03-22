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
/* loaded from: classes4.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f25814d;

    /* renamed from: e  reason: collision with root package name */
    public OverScroller f25815e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25816f;

    /* renamed from: g  reason: collision with root package name */
    public int f25817g;

    /* renamed from: h  reason: collision with root package name */
    public int f25818h;
    public int i;
    public VelocityTracker j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CoordinatorLayout a;

        /* renamed from: b  reason: collision with root package name */
        public final V f25819b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HeaderBehavior f25820c;

        public a(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headerBehavior, coordinatorLayout, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25820c = headerBehavior;
            this.a = coordinatorLayout;
            this.f25819b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25819b == null || (overScroller = this.f25820c.f25815e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                HeaderBehavior headerBehavior = this.f25820c;
                headerBehavior.P(this.a, this.f25819b, headerBehavior.f25815e.getCurrY());
                ViewCompat.postOnAnimation(this.f25819b, this);
                return;
            }
            this.f25820c.N(this.a, this.f25819b);
        }
    }

    public HeaderBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25817g = -1;
        this.i = -1;
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
            if (this.i < 0) {
                this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    VelocityTracker velocityTracker = this.j;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                        this.j.computeCurrentVelocity(1000);
                        J(coordinatorLayout, v, -L(v), 0, this.j.getYVelocity(this.f25817g));
                    }
                } else if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f25817g);
                    if (findPointerIndex == -1) {
                        return false;
                    }
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i = this.f25818h - y;
                    if (!this.f25816f) {
                        int abs = Math.abs(i);
                        int i2 = this.i;
                        if (abs > i2) {
                            this.f25816f = true;
                            i = i > 0 ? i - i2 : i + i2;
                        }
                    }
                    int i3 = i;
                    if (this.f25816f) {
                        this.f25818h = y;
                        O(coordinatorLayout, v, i3, K(v), 0);
                    }
                }
                this.f25816f = false;
                this.f25817g = -1;
                VelocityTracker velocityTracker2 = this.j;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.j = null;
                }
            } else {
                int y2 = (int) motionEvent.getY();
                if (!coordinatorLayout.v(v, (int) motionEvent.getX(), y2) || !H(v)) {
                    return false;
                }
                this.f25818h = y2;
                this.f25817g = motionEvent.getPointerId(0);
                I();
            }
            VelocityTracker velocityTracker3 = this.j;
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    public final boolean J(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            Runnable runnable = this.f25814d;
            if (runnable != null) {
                v.removeCallbacks(runnable);
                this.f25814d = null;
            }
            if (this.f25815e == null) {
                this.f25815e = new OverScroller(v.getContext());
            }
            this.f25815e.fling(0, E(), 0, Math.round(f2), 0, 0, i, i2);
            if (this.f25815e.computeScrollOffset()) {
                a aVar = new a(this, coordinatorLayout, v);
                this.f25814d = aVar;
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

    public final int O(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? Q(coordinatorLayout, v, M() - i, i2, i3) : invokeCommon.intValue;
    }

    public int P(CoordinatorLayout coordinatorLayout, V v, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, coordinatorLayout, v, i)) == null) ? Q(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE) : invokeLLI.intValue;
    }

    public int Q(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int clamp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int E = E();
            if (i2 == 0 || E < i2 || E > i3 || E == (clamp = MathUtils.clamp(i, i2, i3))) {
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
            if (this.i < 0) {
                this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            if (motionEvent.getAction() == 2 && this.f25816f) {
                return true;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i = this.f25817g;
                        if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.f25818h) > this.i) {
                                this.f25816f = true;
                                this.f25818h = y;
                            }
                        }
                    }
                }
                this.f25816f = false;
                this.f25817g = -1;
                VelocityTracker velocityTracker = this.j;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.j = null;
                }
            } else {
                this.f25816f = false;
                int x = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                if (H(v) && coordinatorLayout.v(v, x, y2)) {
                    this.f25818h = y2;
                    this.f25817g = motionEvent.getPointerId(0);
                    I();
                }
            }
            VelocityTracker velocityTracker2 = this.j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return this.f25816f;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25817g = -1;
        this.i = -1;
    }
}
