package com.baidu.swan.facade.picture.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BdImageViewTouch extends BdImageViewTouchBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScaleGestureDetector D;
    public GestureDetector E;
    public int F;
    public GestureDetector.OnGestureListener G;
    public ScaleGestureDetector.OnScaleGestureListener H;
    public boolean I;
    public boolean J;
    public boolean K;
    public b L;
    public c M;

    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouch f11684e;

        public a(BdImageViewTouch bdImageViewTouch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11684e = bdImageViewTouch;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                BdImageViewTouch bdImageViewTouch = this.f11684e;
                if (bdImageViewTouch.I) {
                    bdImageViewTouch.k = true;
                    float scale = bdImageViewTouch.getScale();
                    BdImageViewTouch bdImageViewTouch2 = this.f11684e;
                    this.f11684e.C(Math.min(this.f11684e.getMaxScale(), Math.max(bdImageViewTouch2.F(scale, bdImageViewTouch2.getMaxScale()), this.f11684e.getMinScale())), motionEvent.getX(), motionEvent.getY(), 200.0f);
                    this.f11684e.invalidate();
                }
                if (this.f11684e.L != null) {
                    this.f11684e.L.a();
                }
                return super.onDoubleTap(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.f11684e.G(motionEvent) : invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f11684e.K && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1) {
                    ScaleGestureDetector scaleGestureDetector = this.f11684e.D;
                    if ((scaleGestureDetector == null || !scaleGestureDetector.isInProgress()) && this.f11684e.getScale() != 1.0f) {
                        return this.f11684e.H(motionEvent, motionEvent2, f2, f3);
                    }
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            ScaleGestureDetector scaleGestureDetector;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) || !this.f11684e.isLongClickable() || (scaleGestureDetector = this.f11684e.D) == null || scaleGestureDetector.isInProgress()) {
                return;
            }
            this.f11684e.setPressed(true);
            this.f11684e.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f11684e.K && motionEvent != null && motionEvent2 != null && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1) {
                    ScaleGestureDetector scaleGestureDetector = this.f11684e.D;
                    if (scaleGestureDetector == null || !scaleGestureDetector.isInProgress()) {
                        return this.f11684e.I(motionEvent, motionEvent2, f2, f3);
                    }
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                if (this.f11684e.M != null) {
                    this.f11684e.M.a();
                }
                return this.f11684e.J(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) ? this.f11684e.K(motionEvent) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes4.dex */
    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11685e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouch f11686f;

        public d(BdImageViewTouch bdImageViewTouch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11686f = bdImageViewTouch;
            this.f11685e = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scaleGestureDetector)) == null) {
                float currentSpan = scaleGestureDetector.getCurrentSpan() - scaleGestureDetector.getPreviousSpan();
                float scale = this.f11686f.getScale() * scaleGestureDetector.getScaleFactor();
                BdImageViewTouch bdImageViewTouch = this.f11686f;
                if (bdImageViewTouch.J) {
                    if (this.f11685e && currentSpan != 0.0f) {
                        bdImageViewTouch.k = true;
                        this.f11686f.B(Math.min(bdImageViewTouch.getMaxScale(), Math.max(scale, this.f11686f.getMinScale() - 0.0f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                        this.f11686f.invalidate();
                        return true;
                    } else if (!this.f11685e) {
                        this.f11685e = true;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdImageViewTouch(Context context) {
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
        this.I = true;
        this.J = true;
        this.K = true;
    }

    public float F(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.F == 1) {
                this.F = -1;
                return f3;
            }
            this.F = 1;
            return 1.0f;
        }
        return invokeCommon.floatValue;
    }

    public boolean G(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean H(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            if (Math.abs(f2) > 800.0f || Math.abs(f3) > 800.0f) {
                this.k = true;
                x(x / 2.0f, y / 2.0f, 300.0d);
                invalidate();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean I(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (getScale() == 1.0f) {
                return false;
            }
            this.k = true;
            w(-f2, -f3);
            invalidate();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public boolean J(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean K(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean L(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (getScale() < getMinScale()) {
                A(getMinScale(), 50.0f);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void d(Drawable drawable, Matrix matrix, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{drawable, matrix, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.d(drawable, matrix, f2, f3);
            getMaxScale();
        }
    }

    public boolean getDoubleTapEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public GestureDetector.OnGestureListener getGestureListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new a(this) : (GestureDetector.OnGestureListener) invokeV.objValue;
    }

    public ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new d(this) : (ScaleGestureDetector.OnScaleGestureListener) invokeV.objValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void n(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, context, attributeSet, i2) == null) {
            super.n(context, attributeSet, i2);
            ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.G = getGestureListener();
            this.E = new GestureDetector(getContext(), this.G, null);
            this.H = getScaleListener();
            this.D = new ScaleGestureDetector(getContext(), this.H);
            this.F = 1;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            ScaleGestureDetector scaleGestureDetector = this.D;
            if (scaleGestureDetector != null) {
                scaleGestureDetector.onTouchEvent(motionEvent);
                if (!this.D.isInProgress()) {
                    this.E.onTouchEvent(motionEvent);
                }
            }
            if ((motionEvent.getAction() & 255) == 1) {
                return L(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void s(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048589, this, f2) == null) || f2 >= getMinScale()) {
            return;
        }
        A(getMinScale(), 50.0f);
    }

    public void setDoubleTapEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.I = z;
        }
    }

    public void setDoubleTapListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.L = bVar;
        }
    }

    public void setScaleEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.J = z;
        }
    }

    public void setScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.K = z;
        }
    }

    public void setSingleTapListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            this.M = cVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdImageViewTouch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdImageViewTouch(Context context, AttributeSet attributeSet, int i2) {
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
        this.I = true;
        this.J = true;
        this.K = true;
    }
}
