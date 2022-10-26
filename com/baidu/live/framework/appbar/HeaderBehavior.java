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
/* loaded from: classes2.dex */
public abstract class HeaderBehavior extends ViewOffsetBehavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable d;
    public OverScroller e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public VelocityTracker j;

    public boolean H(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void N(CoordinatorLayout coordinatorLayout, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, coordinatorLayout, view2) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CoordinatorLayout a;
        public final View b;
        public final /* synthetic */ HeaderBehavior c;

        public a(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headerBehavior, coordinatorLayout, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = headerBehavior;
            this.a = coordinatorLayout;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b != null && (overScroller = this.c.e) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = this.c;
                    headerBehavior.P(this.a, this.b, headerBehavior.e.getCurrY());
                    ViewCompat.postOnAnimation(this.b, this);
                    return;
                }
                this.c.N(this.a, this.b);
            }
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
        this.g = -1;
        this.i = -1;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return E();
        }
        return invokeV.intValue;
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
        this.g = -1;
        this.i = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean D(CoordinatorLayout coordinatorLayout, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, coordinatorLayout, view2, motionEvent)) == null) {
            if (this.i < 0) {
                this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.g);
                        if (findPointerIndex == -1) {
                            return false;
                        }
                        int y = (int) motionEvent.getY(findPointerIndex);
                        int i = this.h - y;
                        if (!this.f) {
                            int abs = Math.abs(i);
                            int i2 = this.i;
                            if (abs > i2) {
                                this.f = true;
                                i = i > 0 ? i - i2 : i + i2;
                            }
                        }
                        int i3 = i;
                        if (this.f) {
                            this.h = y;
                            O(coordinatorLayout, view2, i3, K(view2), 0);
                        }
                    }
                } else {
                    VelocityTracker velocityTracker = this.j;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                        this.j.computeCurrentVelocity(1000);
                        J(coordinatorLayout, view2, -L(view2), 0, this.j.getYVelocity(this.g));
                    }
                }
                this.f = false;
                this.g = -1;
                VelocityTracker velocityTracker2 = this.j;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.j = null;
                }
            } else {
                int y2 = (int) motionEvent.getY();
                if (!coordinatorLayout.v(view2, (int) motionEvent.getX(), y2) || !H(view2)) {
                    return false;
                }
                this.h = y2;
                this.g = motionEvent.getPointerId(0);
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (r0 != 3) goto L19;
     */
    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k(CoordinatorLayout coordinatorLayout, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, coordinatorLayout, view2, motionEvent)) == null) {
            if (this.i < 0) {
                this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            if (motionEvent.getAction() == 2 && this.f) {
                return true;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i = this.g;
                        if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.h) > this.i) {
                                this.f = true;
                                this.h = y;
                            }
                        }
                    }
                }
                this.f = false;
                this.g = -1;
                VelocityTracker velocityTracker = this.j;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.j = null;
                }
            } else {
                this.f = false;
                int x = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                if (H(view2) && coordinatorLayout.v(view2, x, y2)) {
                    this.h = y2;
                    this.g = motionEvent.getPointerId(0);
                    I();
                }
            }
            VelocityTracker velocityTracker2 = this.j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return this.f;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean J(CoordinatorLayout coordinatorLayout, View view2, int i, int i2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{coordinatorLayout, view2, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)})) == null) {
            Runnable runnable = this.d;
            if (runnable != null) {
                view2.removeCallbacks(runnable);
                this.d = null;
            }
            if (this.e == null) {
                this.e = new OverScroller(view2.getContext());
            }
            this.e.fling(0, E(), 0, Math.round(f), 0, 0, i, i2);
            if (this.e.computeScrollOffset()) {
                a aVar = new a(this, coordinatorLayout, view2);
                this.d = aVar;
                ViewCompat.postOnAnimation(view2, aVar);
                return true;
            }
            N(coordinatorLayout, view2);
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public int K(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            return -view2.getHeight();
        }
        return invokeL.intValue;
    }

    public int L(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            return view2.getHeight();
        }
        return invokeL.intValue;
    }

    public final int O(CoordinatorLayout coordinatorLayout, View view2, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            return Q(coordinatorLayout, view2, M() - i, i2, i3);
        }
        return invokeCommon.intValue;
    }

    public int P(CoordinatorLayout coordinatorLayout, View view2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, coordinatorLayout, view2, i)) == null) {
            return Q(coordinatorLayout, view2, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return invokeLLI.intValue;
    }

    public int Q(CoordinatorLayout coordinatorLayout, View view2, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int clamp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{coordinatorLayout, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int E = E();
            if (i2 != 0 && E >= i2 && E <= i3 && E != (clamp = MathUtils.clamp(i, i2, i3))) {
                G(clamp);
                return E - clamp;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }
}
