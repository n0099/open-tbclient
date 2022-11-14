package com.baidu.nadcore.max.uiwidget.basic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n31;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
/* loaded from: classes2.dex */
public class WebViewContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OverScroller a;
    public float b;
    public GestureDetector c;
    public VelocityTracker d;
    public c e;
    public int f;
    public int g;
    public int h;
    public d i;
    public b j;
    public boolean k;
    public a l;
    public int m;
    public boolean n;
    public boolean o;
    public float p;
    public int q;

    /* loaded from: classes2.dex */
    public interface a {
        boolean a(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean a();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onScroll(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(boolean z);
    }

    /* loaded from: classes2.dex */
    public static class e extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebViewContainer a;

        public e(WebViewContainer webViewContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, motionEvent)) != null) {
                return invokeL.booleanValue;
            }
            this.a.b = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            WebViewContainer webViewContainer;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (Math.abs(f2) <= Math.abs(f) || (webViewContainer = this.a) == null) {
                    return false;
                }
                if (f2 > 0.0f) {
                    webViewContainer.k = true;
                    if (this.a.f <= this.a.q) {
                        return false;
                    }
                    return true;
                }
                webViewContainer.k = false;
                if (this.a.n && this.a.o && this.a.f < this.a.g) {
                    return true;
                }
                if (this.a.j != null) {
                    z = this.a.j.a();
                } else {
                    z = true;
                }
                if (this.a.f >= this.a.g || !z) {
                    return false;
                }
                if (this.a.f <= this.a.q && this.a.h != 3) {
                    return false;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewContainer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.g = 0;
        this.h = 1;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        m(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewContainer(Context context, AttributeSet attributeSet) {
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
        this.f = 0;
        this.g = 0;
        this.h = 1;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        m(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.g = 0;
        this.h = 1;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        m(context);
    }

    public final int j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int i2 = this.f;
            int i3 = i2 - i;
            int i4 = this.q;
            if (i3 < i4) {
                int i5 = i2 - i4;
                this.f = i4;
                return i5;
            }
            int i6 = this.g;
            if (i3 > i6) {
                int i7 = i2 - i6;
                this.f = i6;
                return i7;
            }
            this.f = i2 - i;
            return i;
        }
        return invokeI.intValue;
    }

    public final boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            OverScroller overScroller = this.a;
            if (overScroller != null && this.f >= this.g) {
                overScroller.fling(0, (int) this.b, 0, i, 0, 0, ErrorCode.SERVER_ERROR, 10000);
                invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.a = new OverScroller(context);
            this.c = new GestureDetector(context, new e(this));
            setMotionEventSplittingEnabled(false);
        }
    }

    public void setHandleTopYMove(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.n = z;
        }
    }

    public void setInterceptFlingListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void setInterceptScrollLister(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void setMinFlingVelocity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.m = n31.c.a(getContext(), i);
        }
    }

    public void setMinTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.q = i;
        }
    }

    public void setOnScrollChangeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            this.e = cVar;
        }
    }

    public void setOnUpListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
            this.i = dVar;
        }
    }

    public void setStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.h = i;
        }
    }

    public void setTopLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.g = i;
        }
    }

    public void setTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.f = i;
        }
    }

    public void setUpYVelocityRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f) == null) {
            this.p = f;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.computeScrollOffset()) {
            int j = j(this.a.getCurrY());
            scrollBy(0, j);
            this.b -= j;
            invalidate();
        }
    }

    public int getMinTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public int getTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final void l() {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d.computeCurrentVelocity(1000);
            int yVelocity = (int) this.d.getYVelocity();
            if (this.k) {
                float f = this.p;
                if (f > 0.0f) {
                    yVelocity = (int) (yVelocity * f);
                }
            }
            boolean z = false;
            if (Math.abs(yVelocity) > this.m && ((yVelocity > 0 && this.f < this.g) || (yVelocity < 0 && this.f >= this.q))) {
                a aVar = this.l;
                if (aVar != null) {
                    z = aVar.a(this.k);
                }
                if (!z) {
                    k(-yVelocity);
                }
            }
            if (!z && (dVar = this.i) != null) {
                dVar.a(this.k);
            }
            this.d.recycle();
            this.d = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (this.h == 2) {
                return false;
            }
            if (this.f > ((int) motionEvent.getY())) {
                z = true;
            } else {
                z = false;
            }
            this.o = z;
            if ((z && !this.n) || !this.c.onTouchEvent(motionEvent)) {
                return false;
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            if (this.e != null) {
                int i5 = i2 - i4;
                if (i5 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.k = z;
                this.e.onScroll(i - i3, i5);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (this.h == 2) {
                return false;
            }
            int y = (int) motionEvent.getY();
            if (this.f > y && !this.n) {
                return false;
            }
            super.onTouchEvent(motionEvent);
            if (this.d == null) {
                this.d = VelocityTracker.obtain();
            }
            this.d.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3 && this.n) {
                            l();
                        }
                    } else {
                        int j = j((int) (this.b - motionEvent.getRawY()));
                        scrollBy(0, j);
                        this.b -= j;
                    }
                } else {
                    l();
                }
            } else if (!this.a.isFinished()) {
                this.a.abortAnimation();
            }
            if (this.f > y) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
