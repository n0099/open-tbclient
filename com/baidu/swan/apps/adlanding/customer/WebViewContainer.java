package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class WebViewContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public OverScroller f43298e;

    /* renamed from: f  reason: collision with root package name */
    public float f43299f;

    /* renamed from: g  reason: collision with root package name */
    public float f43300g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector f43301h;

    /* renamed from: i  reason: collision with root package name */
    public VelocityTracker f43302i;
    public int j;
    public int k;
    public c l;
    public b m;
    public boolean n;
    public boolean o;
    public a p;
    public int q;
    public boolean r;
    public boolean s;
    public float t;
    public int u;
    public int v;
    public b.a.p0.a.p.e.c w;

    /* loaded from: classes8.dex */
    public interface a {
        boolean a(boolean z);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public static class d extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final WebViewContainer f43303e;

        public d(WebViewContainer webViewContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43303e = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f43303e.f43300g = motionEvent.getRawY();
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            WebViewContainer webViewContainer;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (Math.abs(f3) <= Math.abs(f2) || (webViewContainer = this.f43303e) == null || webViewContainer.w.getWebViewScrollY() > 10) {
                    return false;
                }
                if (f3 > 0.0f) {
                    this.f43303e.o = true;
                    return this.f43303e.j > this.f43303e.u;
                }
                this.f43303e.o = false;
                return (this.f43303e.r && this.f43303e.s && this.f43303e.j < this.f43303e.k) || this.f43303e.j < this.f43303e.k;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = 0;
        this.q = 2000;
        this.r = false;
        this.t = 1.0f;
        this.u = 0;
        l(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f43298e.computeScrollOffset()) {
                int i2 = i(this.f43298e.getCurrY());
                if (this.n) {
                    scrollTo(0, i2);
                } else {
                    scrollBy(0, i2);
                }
                this.f43300g -= i2;
                invalidate();
            }
            if (!this.n || (bVar = this.m) == null) {
                return;
            }
            bVar.a();
            this.n = false;
        }
    }

    public int getMinTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : invokeV.intValue;
    }

    public int getTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.intValue;
    }

    public float getYVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v : invokeV.floatValue;
    }

    public final int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (this.n) {
                this.j = this.k - i2;
                return i2;
            }
            int i3 = this.j;
            int i4 = i3 - i2;
            int i5 = this.u;
            if (i4 < i5) {
                int i6 = i3 - i5;
                this.j = i5;
                return i6;
            }
            int i7 = this.k;
            if (i4 > i7) {
                int i8 = i3 - i7;
                this.j = i7;
                return i8;
            }
            this.j = i3 - i2;
            return i2;
        }
        return invokeI.intValue;
    }

    public final boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            OverScroller overScroller = this.f43298e;
            if (overScroller == null || this.j < this.k) {
                return false;
            }
            overScroller.fling(0, (int) this.f43300g, 0, i2, 0, 0, -500, 10000);
            invalidate();
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void k() {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f43302i.computeCurrentVelocity(1000);
            int yVelocity = (int) this.f43302i.getYVelocity();
            this.v = yVelocity;
            if (this.o) {
                float f2 = this.t;
                if (f2 > 0.0f) {
                    this.v = (int) (yVelocity * f2);
                }
            }
            if (Math.abs(this.v) > this.q && ((this.v > 0 && this.j < this.k) || (this.v < 0 && this.j >= this.u))) {
                a aVar = this.p;
                r0 = aVar != null ? aVar.a(this.o) : false;
                if (!r0) {
                    j(-this.v);
                }
            }
            if (!r0 && (cVar = this.l) != null) {
                cVar.a(this.o);
            }
            this.f43302i.recycle();
            this.f43302i = null;
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.f43298e = new OverScroller(context);
            this.f43301h = new GestureDetector(context, new d(this));
            setMotionEventSplittingEnabled(false);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            boolean z = this.j > ((int) motionEvent.getY());
            this.s = z;
            if ((!z || this.r) && this.f43301h.onTouchEvent(motionEvent)) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            this.n = false;
            int y = (int) motionEvent.getY();
            if (this.j <= y || this.r) {
                super.onTouchEvent(motionEvent);
                if (this.f43302i == null) {
                    this.f43302i = VelocityTracker.obtain();
                }
                this.f43302i.addMovement(motionEvent);
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        k();
                    } else if (action != 2) {
                        if (action == 3 && this.r) {
                            k();
                        }
                    } else {
                        float rawY = motionEvent.getRawY();
                        this.f43299f = rawY;
                        int i2 = i((int) (this.f43300g - rawY));
                        scrollBy(0, i2);
                        this.f43300g -= i2;
                    }
                } else if (!this.f43298e.isFinished()) {
                    this.f43298e.abortAnimation();
                }
                return this.j <= y;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAutoScroll2TopListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setInterceptFlingListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void setInternalWebView(b.a.p0.a.p.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.w = cVar;
        }
    }

    public void setMinFlingVelocity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.q = n0.g(i2);
        }
    }

    public void setOnUpListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.l = cVar;
        }
    }

    public void setTopLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setTopMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.j = i2;
        }
    }

    public void setUpYVelocityRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            this.t = f2;
        }
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
        this.j = 0;
        this.k = 0;
        this.q = 2000;
        this.r = false;
        this.t = 1.0f;
        this.u = 0;
        l(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = 0;
        this.q = 2000;
        this.r = false;
        this.t = 1.0f;
        this.u = 0;
        l(context);
    }
}
