package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class WebViewContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OverScroller a;

    /* renamed from: b  reason: collision with root package name */
    public float f28734b;

    /* renamed from: c  reason: collision with root package name */
    public float f28735c;

    /* renamed from: d  reason: collision with root package name */
    public GestureDetector f28736d;

    /* renamed from: e  reason: collision with root package name */
    public VelocityTracker f28737e;

    /* renamed from: f  reason: collision with root package name */
    public int f28738f;

    /* renamed from: g  reason: collision with root package name */
    public int f28739g;

    /* renamed from: h  reason: collision with root package name */
    public c f28740h;
    public b i;
    public boolean j;
    public boolean k;
    public a l;
    public int m;
    public boolean n;
    public boolean o;
    public float p;
    public int q;
    public int r;
    public c.a.n0.a.f.e.c s;

    /* loaded from: classes4.dex */
    public interface a {
        boolean a(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public static class d extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebViewContainer a;

        public d(WebViewContainer webViewContainer) {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.a.f28735c = motionEvent.getRawY();
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
                if (Math.abs(f3) <= Math.abs(f2) || (webViewContainer = this.a) == null || webViewContainer.s.getWebViewScrollY() > 10) {
                    return false;
                }
                if (f3 > 0.0f) {
                    this.a.k = true;
                    return this.a.f28738f > this.a.q;
                }
                this.a.k = false;
                return (this.a.n && this.a.o && this.a.f28738f < this.a.f28739g) || this.a.f28738f < this.a.f28739g;
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
        this.f28738f = 0;
        this.f28739g = 0;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        l(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.computeScrollOffset()) {
                int i = i(this.a.getCurrY());
                if (this.j) {
                    scrollTo(0, i);
                } else {
                    scrollBy(0, i);
                }
                this.f28735c -= i;
                invalidate();
            }
            if (!this.j || (bVar = this.i) == null) {
                return;
            }
            bVar.a();
            this.j = false;
        }
    }

    public int getMinTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : invokeV.intValue;
    }

    public int getTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28738f : invokeV.intValue;
    }

    public float getYVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.r : invokeV.floatValue;
    }

    public final int i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.j) {
                this.f28738f = this.f28739g - i;
                return i;
            }
            int i2 = this.f28738f;
            int i3 = i2 - i;
            int i4 = this.q;
            if (i3 < i4) {
                int i5 = i2 - i4;
                this.f28738f = i4;
                return i5;
            }
            int i6 = this.f28739g;
            if (i3 > i6) {
                int i7 = i2 - i6;
                this.f28738f = i6;
                return i7;
            }
            this.f28738f = i2 - i;
            return i;
        }
        return invokeI.intValue;
    }

    public final boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            OverScroller overScroller = this.a;
            if (overScroller == null || this.f28738f < this.f28739g) {
                return false;
            }
            overScroller.fling(0, (int) this.f28735c, 0, i, 0, 0, -500, 10000);
            invalidate();
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void k() {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f28737e.computeCurrentVelocity(1000);
            int yVelocity = (int) this.f28737e.getYVelocity();
            this.r = yVelocity;
            if (this.k) {
                float f2 = this.p;
                if (f2 > 0.0f) {
                    this.r = (int) (yVelocity * f2);
                }
            }
            if (Math.abs(this.r) > this.m && ((this.r > 0 && this.f28738f < this.f28739g) || (this.r < 0 && this.f28738f >= this.q))) {
                a aVar = this.l;
                r0 = aVar != null ? aVar.a(this.k) : false;
                if (!r0) {
                    j(-this.r);
                }
            }
            if (!r0 && (cVar = this.f28740h) != null) {
                cVar.a(this.k);
            }
            this.f28737e.recycle();
            this.f28737e = null;
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.a = new OverScroller(context);
            this.f28736d = new GestureDetector(context, new d(this));
            setMotionEventSplittingEnabled(false);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            boolean z = this.f28738f > ((int) motionEvent.getY());
            this.o = z;
            if ((!z || this.n) && this.f28736d.onTouchEvent(motionEvent)) {
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
            this.j = false;
            int y = (int) motionEvent.getY();
            if (this.f28738f <= y || this.n) {
                super.onTouchEvent(motionEvent);
                if (this.f28737e == null) {
                    this.f28737e = VelocityTracker.obtain();
                }
                this.f28737e.addMovement(motionEvent);
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        k();
                    } else if (action != 2) {
                        if (action == 3 && this.n) {
                            k();
                        }
                    } else {
                        float rawY = motionEvent.getRawY();
                        this.f28734b = rawY;
                        int i = i((int) (this.f28735c - rawY));
                        scrollBy(0, i);
                        this.f28735c -= i;
                    }
                } else if (!this.a.isFinished()) {
                    this.a.abortAnimation();
                }
                return this.f28738f <= y;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAutoScroll2TopListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void setInterceptFlingListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void setInternalWebView(c.a.n0.a.f.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void setMinFlingVelocity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.m = n0.g(i);
        }
    }

    public void setOnUpListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.f28740h = cVar;
        }
    }

    public void setTopLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.f28739g = i;
        }
    }

    public void setTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f28738f = i;
        }
    }

    public void setUpYVelocityRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            this.p = f2;
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
        this.f28738f = 0;
        this.f28739g = 0;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        l(context);
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
        this.f28738f = 0;
        this.f28739g = 0;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        l(context);
    }
}
