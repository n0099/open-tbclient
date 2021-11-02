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
/* loaded from: classes7.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f38838d;

    /* renamed from: e  reason: collision with root package name */
    public OverScroller f38839e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38840f;

    /* renamed from: g  reason: collision with root package name */
    public int f38841g;

    /* renamed from: h  reason: collision with root package name */
    public int f38842h;

    /* renamed from: i  reason: collision with root package name */
    public int f38843i;
    public VelocityTracker j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final CoordinatorLayout f38844e;

        /* renamed from: f  reason: collision with root package name */
        public final V f38845f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HeaderBehavior f38846g;

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
            this.f38846g = headerBehavior;
            this.f38844e = coordinatorLayout;
            this.f38845f = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f38845f == null || (overScroller = this.f38846g.f38839e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                HeaderBehavior headerBehavior = this.f38846g;
                headerBehavior.P(this.f38844e, this.f38845f, headerBehavior.f38839e.getCurrY());
                ViewCompat.postOnAnimation(this.f38845f, this);
                return;
            }
            this.f38846g.N(this.f38844e, this.f38845f);
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
        this.f38841g = -1;
        this.f38843i = -1;
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
            if (this.f38843i < 0) {
                this.f38843i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    VelocityTracker velocityTracker = this.j;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                        this.j.computeCurrentVelocity(1000);
                        J(coordinatorLayout, v, -L(v), 0, this.j.getYVelocity(this.f38841g));
                    }
                } else if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f38841g);
                    if (findPointerIndex == -1) {
                        return false;
                    }
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i2 = this.f38842h - y;
                    if (!this.f38840f) {
                        int abs = Math.abs(i2);
                        int i3 = this.f38843i;
                        if (abs > i3) {
                            this.f38840f = true;
                            i2 = i2 > 0 ? i2 - i3 : i2 + i3;
                        }
                    }
                    int i4 = i2;
                    if (this.f38840f) {
                        this.f38842h = y;
                        O(coordinatorLayout, v, i4, K(v), 0);
                    }
                }
                this.f38840f = false;
                this.f38841g = -1;
                VelocityTracker velocityTracker2 = this.j;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.j = null;
                }
            } else {
                int y2 = (int) motionEvent.getY();
                if (!coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), y2) || !H(v)) {
                    return false;
                }
                this.f38842h = y2;
                this.f38841g = motionEvent.getPointerId(0);
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

    public final boolean J(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
            Runnable runnable = this.f38838d;
            if (runnable != null) {
                v.removeCallbacks(runnable);
                this.f38838d = null;
            }
            if (this.f38839e == null) {
                this.f38839e = new OverScroller(v.getContext());
            }
            this.f38839e.fling(0, E(), 0, Math.round(f2), 0, 0, i2, i3);
            if (this.f38839e.computeScrollOffset()) {
                a aVar = new a(this, coordinatorLayout, v);
                this.f38838d = aVar;
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
            if (this.f38843i < 0) {
                this.f38843i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            if (motionEvent.getAction() == 2 && this.f38840f) {
                return true;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i2 = this.f38841g;
                        if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1) {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.f38842h) > this.f38843i) {
                                this.f38840f = true;
                                this.f38842h = y;
                            }
                        }
                    }
                }
                this.f38840f = false;
                this.f38841g = -1;
                VelocityTracker velocityTracker = this.j;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.j = null;
                }
            } else {
                this.f38840f = false;
                int x = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                if (H(v) && coordinatorLayout.isPointInChildBounds(v, x, y2)) {
                    this.f38842h = y2;
                    this.f38841g = motionEvent.getPointerId(0);
                    I();
                }
            }
            VelocityTracker velocityTracker2 = this.j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return this.f38840f;
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
        this.f38841g = -1;
        this.f38843i = -1;
    }
}
