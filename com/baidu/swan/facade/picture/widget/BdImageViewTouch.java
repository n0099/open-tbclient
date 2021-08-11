package com.baidu.swan.facade.picture.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
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
/* loaded from: classes6.dex */
public class BdImageViewTouch extends BdImageViewTouchBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDoubleTapDirection;
    public boolean mDoubleTapEnabled;
    public GestureDetector mGestureDetector;
    public GestureDetector.OnGestureListener mGestureListener;
    public ScaleGestureDetector mScaleDetector;
    public boolean mScaleEnabled;
    public float mScaleFactor;
    public ScaleGestureDetector.OnScaleGestureListener mScaleListener;
    public boolean mScrollEnabled;
    public int mTouchSlop;
    public b q;
    public c r;

    /* loaded from: classes6.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouch f46586e;

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
            this.f46586e = bdImageViewTouch;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                BdImageViewTouch bdImageViewTouch = this.f46586e;
                if (bdImageViewTouch.mDoubleTapEnabled) {
                    bdImageViewTouch.mUserScaled = true;
                    float scale = bdImageViewTouch.getScale();
                    BdImageViewTouch bdImageViewTouch2 = this.f46586e;
                    this.f46586e.zoomTo(Math.min(this.f46586e.getMaxScale(), Math.max(bdImageViewTouch2.onDoubleTapPost(scale, bdImageViewTouch2.getMaxScale()), this.f46586e.getMinScale())), motionEvent.getX(), motionEvent.getY(), 200.0f);
                    this.f46586e.invalidate();
                }
                if (this.f46586e.q != null) {
                    this.f46586e.q.a();
                }
                return super.onDoubleTap(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.f46586e.onDown(motionEvent) : invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f46586e.mScrollEnabled && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1) {
                    ScaleGestureDetector scaleGestureDetector = this.f46586e.mScaleDetector;
                    if ((scaleGestureDetector == null || !scaleGestureDetector.isInProgress()) && this.f46586e.getScale() != 1.0f) {
                        return this.f46586e.onFling(motionEvent, motionEvent2, f2, f3);
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) || !this.f46586e.isLongClickable() || (scaleGestureDetector = this.f46586e.mScaleDetector) == null || scaleGestureDetector.isInProgress()) {
                return;
            }
            this.f46586e.setPressed(true);
            this.f46586e.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f46586e.mScrollEnabled && motionEvent != null && motionEvent2 != null && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1) {
                    ScaleGestureDetector scaleGestureDetector = this.f46586e.mScaleDetector;
                    if (scaleGestureDetector == null || !scaleGestureDetector.isInProgress()) {
                        return this.f46586e.onScroll(motionEvent, motionEvent2, f2, f3);
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
                if (this.f46586e.r != null) {
                    this.f46586e.r.a();
                }
                return this.f46586e.onSingleTapConfirmed(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) ? this.f46586e.onSingleTapUp(motionEvent) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes6.dex */
    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f46587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouch f46588f;

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
            this.f46588f = bdImageViewTouch;
            this.f46587e = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scaleGestureDetector)) == null) {
                float currentSpan = scaleGestureDetector.getCurrentSpan() - scaleGestureDetector.getPreviousSpan();
                float scale = this.f46588f.getScale() * scaleGestureDetector.getScaleFactor();
                BdImageViewTouch bdImageViewTouch = this.f46588f;
                if (bdImageViewTouch.mScaleEnabled) {
                    if (this.f46587e && currentSpan != 0.0f) {
                        bdImageViewTouch.mUserScaled = true;
                        this.f46588f.zoomTo(Math.min(bdImageViewTouch.getMaxScale(), Math.max(scale, this.f46588f.getMinScale() - 0.0f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                        this.f46588f.invalidate();
                        return true;
                    } else if (!this.f46587e) {
                        this.f46587e = true;
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
        this.mDoubleTapEnabled = true;
        this.mScaleEnabled = true;
        this.mScrollEnabled = true;
    }

    public boolean canScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            RectF bitmapRect = getBitmapRect();
            updateRect(bitmapRect, this.mScrollRect);
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            if (bitmapRect == null) {
                return false;
            }
            float f2 = bitmapRect.right;
            int i3 = rect.right;
            return (f2 < ((float) i3) || i2 >= 0) ? ((double) Math.abs(bitmapRect.left - this.mScrollRect.left)) > 1.0d : Math.abs(f2 - ((float) i3)) > 1.0f;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void doSetImageDrawable(Drawable drawable, Matrix matrix, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{drawable, matrix, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.doSetImageDrawable(drawable, matrix, f2, f3);
            this.mScaleFactor = getMaxScale() / 3.0f;
        }
    }

    public boolean getDoubleTapEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDoubleTapEnabled : invokeV.booleanValue;
    }

    public GestureDetector.OnGestureListener getGestureListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this) : (GestureDetector.OnGestureListener) invokeV.objValue;
    }

    public ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new d(this) : (ScaleGestureDetector.OnScaleGestureListener) invokeV.objValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void init(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, context, attributeSet, i2) == null) {
            super.init(context, attributeSet, i2);
            this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.mGestureListener = getGestureListener();
            this.mGestureDetector = new GestureDetector(getContext(), this.mGestureListener, null);
            this.mScaleListener = getScaleListener();
            this.mScaleDetector = new ScaleGestureDetector(getContext(), this.mScaleListener);
            this.mDoubleTapDirection = 1;
        }
    }

    public float onDoubleTapPost(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.mDoubleTapDirection == 1) {
                this.mDoubleTapDirection = -1;
                return f3;
            }
            this.mDoubleTapDirection = 1;
            return 1.0f;
        }
        return invokeCommon.floatValue;
    }

    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            if (Math.abs(f2) > 800.0f || Math.abs(f3) > 800.0f) {
                this.mUserScaled = true;
                scrollBy(x / 2.0f, y / 2.0f, 300.0d);
                invalidate();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (getScale() == 1.0f) {
                return false;
            }
            this.mUserScaled = true;
            scrollBy(-f2, -f3);
            invalidate();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            ScaleGestureDetector scaleGestureDetector = this.mScaleDetector;
            if (scaleGestureDetector != null) {
                scaleGestureDetector.onTouchEvent(motionEvent);
                if (!this.mScaleDetector.isInProgress()) {
                    this.mGestureDetector.onTouchEvent(motionEvent);
                }
            }
            if ((motionEvent.getAction() & 255) == 1) {
                return onUp(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean onUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            if (getScale() < getMinScale()) {
                zoomTo(getMinScale(), 50.0f);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void onZoomAnimationCompleted(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048590, this, f2) == null) || f2 >= getMinScale()) {
            return;
        }
        zoomTo(getMinScale(), 50.0f);
    }

    public void setDoubleTapEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mDoubleTapEnabled = z;
        }
    }

    public void setDoubleTapListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.q = bVar;
        }
    }

    public void setScaleEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mScaleEnabled = z;
        }
    }

    public void setScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mScrollEnabled = z;
        }
    }

    public void setSingleTapListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.r = cVar;
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
        this.mDoubleTapEnabled = true;
        this.mScaleEnabled = true;
        this.mScrollEnabled = true;
    }
}
