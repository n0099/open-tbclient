package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class GestureDetectorCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final GestureDetectorCompatImpl mImpl;

    /* loaded from: classes.dex */
    public interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    /* loaded from: classes.dex */
    public static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DOUBLE_TAP_TIMEOUT;
        public static final int LONGPRESS_TIMEOUT;
        public static final int LONG_PRESS = 2;
        public static final int SHOW_PRESS = 1;
        public static final int TAP = 3;
        public static final int TAP_TIMEOUT;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mAlwaysInBiggerTapRegion;
        public boolean mAlwaysInTapRegion;
        public MotionEvent mCurrentDownEvent;
        public boolean mDeferConfirmSingleTap;
        public GestureDetector.OnDoubleTapListener mDoubleTapListener;
        public int mDoubleTapSlopSquare;
        public float mDownFocusX;
        public float mDownFocusY;
        public final Handler mHandler;
        public boolean mInLongPress;
        public boolean mIsDoubleTapping;
        public boolean mIsLongpressEnabled;
        public float mLastFocusX;
        public float mLastFocusY;
        public final GestureDetector.OnGestureListener mListener;
        public int mMaximumFlingVelocity;
        public int mMinimumFlingVelocity;
        public MotionEvent mPreviousUpEvent;
        public boolean mStillDown;
        public int mTouchSlopSquare;
        public VelocityTracker mVelocityTracker;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2108701248, "Landroidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplBase;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2108701248, "Landroidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplBase;");
                    return;
                }
            }
            LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
            TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
            DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        }

        public GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, onGestureListener, handler};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (handler != null) {
                this.mHandler = new GestureHandler(this, handler);
            } else {
                this.mHandler = new GestureHandler(this);
            }
            this.mListener = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                this.mHandler.removeMessages(3);
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                this.mIsDoubleTapping = false;
                this.mStillDown = false;
                this.mAlwaysInTapRegion = false;
                this.mAlwaysInBiggerTapRegion = false;
                this.mDeferConfirmSingleTap = false;
                if (this.mInLongPress) {
                    this.mInLongPress = false;
                }
            }
        }

        private void cancelTaps() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                this.mHandler.removeMessages(3);
                this.mIsDoubleTapping = false;
                this.mAlwaysInTapRegion = false;
                this.mAlwaysInBiggerTapRegion = false;
                this.mDeferConfirmSingleTap = false;
                if (this.mInLongPress) {
                    this.mInLongPress = false;
                }
            }
        }

        private void init(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65540, this, context) == null) {
                if (context != null) {
                    if (this.mListener != null) {
                        this.mIsLongpressEnabled = true;
                        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                        this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                        this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                        this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
                        this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
                        return;
                    }
                    throw new IllegalArgumentException("OnGestureListener must not be null");
                }
                throw new IllegalArgumentException("Context must not be null");
            }
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, motionEvent, motionEvent2, motionEvent3)) == null) {
                if (this.mAlwaysInBiggerTapRegion && motionEvent3.getEventTime() - motionEvent2.getEventTime() <= DOUBLE_TAP_TIMEOUT) {
                    int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
                    int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
                    return (x * x) + (y * y) < this.mDoubleTapSlopSquare;
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public void dispatchLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mHandler.removeMessages(3);
                this.mDeferConfirmSingleTap = false;
                this.mInLongPress = true;
                this.mListener.onLongPress(this.mCurrentDownEvent);
            }
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIsLongpressEnabled : invokeV.booleanValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:109:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0223  */
        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            boolean z;
            MotionEvent motionEvent2;
            MotionEvent motionEvent3;
            boolean onFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                int i2 = action & 255;
                boolean z2 = i2 == 6;
                int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
                int pointerCount = motionEvent.getPointerCount();
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (int i3 = 0; i3 < pointerCount; i3++) {
                    if (actionIndex != i3) {
                        f2 += motionEvent.getX(i3);
                        f3 += motionEvent.getY(i3);
                    }
                }
                float f4 = z2 ? pointerCount - 1 : pointerCount;
                float f5 = f2 / f4;
                float f6 = f3 / f4;
                if (i2 == 0) {
                    if (this.mDoubleTapListener != null) {
                        boolean hasMessages = this.mHandler.hasMessages(3);
                        if (hasMessages) {
                            this.mHandler.removeMessages(3);
                        }
                        MotionEvent motionEvent4 = this.mCurrentDownEvent;
                        if (motionEvent4 != null && (motionEvent3 = this.mPreviousUpEvent) != null && hasMessages && isConsideredDoubleTap(motionEvent4, motionEvent3, motionEvent)) {
                            this.mIsDoubleTapping = true;
                            z = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                            this.mLastFocusX = f5;
                            this.mDownFocusX = f5;
                            this.mLastFocusY = f6;
                            this.mDownFocusY = f6;
                            motionEvent2 = this.mCurrentDownEvent;
                            if (motionEvent2 != null) {
                                motionEvent2.recycle();
                            }
                            this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                            this.mAlwaysInTapRegion = true;
                            this.mAlwaysInBiggerTapRegion = true;
                            this.mStillDown = true;
                            this.mInLongPress = false;
                            this.mDeferConfirmSingleTap = false;
                            if (this.mIsLongpressEnabled) {
                                this.mHandler.removeMessages(2);
                                this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
                            }
                            this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
                            return z | this.mListener.onDown(motionEvent);
                        }
                        this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
                    }
                    z = false;
                    this.mLastFocusX = f5;
                    this.mDownFocusX = f5;
                    this.mLastFocusY = f6;
                    this.mDownFocusY = f6;
                    motionEvent2 = this.mCurrentDownEvent;
                    if (motionEvent2 != null) {
                    }
                    this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                    this.mAlwaysInTapRegion = true;
                    this.mAlwaysInBiggerTapRegion = true;
                    this.mStillDown = true;
                    this.mInLongPress = false;
                    this.mDeferConfirmSingleTap = false;
                    if (this.mIsLongpressEnabled) {
                    }
                    this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
                    return z | this.mListener.onDown(motionEvent);
                }
                if (i2 == 1) {
                    this.mStillDown = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.mIsDoubleTapping) {
                        onFling = this.mDoubleTapListener.onDoubleTapEvent(motionEvent) | false;
                    } else {
                        if (this.mInLongPress) {
                            this.mHandler.removeMessages(3);
                            this.mInLongPress = false;
                        } else if (this.mAlwaysInTapRegion) {
                            boolean onSingleTapUp = this.mListener.onSingleTapUp(motionEvent);
                            if (this.mDeferConfirmSingleTap && (onDoubleTapListener = this.mDoubleTapListener) != null) {
                                onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                            }
                            onFling = onSingleTapUp;
                        } else {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            int pointerId = motionEvent.getPointerId(0);
                            velocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                            float yVelocity = velocityTracker.getYVelocity(pointerId);
                            float xVelocity = velocityTracker.getXVelocity(pointerId);
                            if (Math.abs(yVelocity) > this.mMinimumFlingVelocity || Math.abs(xVelocity) > this.mMinimumFlingVelocity) {
                                onFling = this.mListener.onFling(this.mCurrentDownEvent, motionEvent, xVelocity, yVelocity);
                            }
                        }
                        onFling = false;
                    }
                    MotionEvent motionEvent5 = this.mPreviousUpEvent;
                    if (motionEvent5 != null) {
                        motionEvent5.recycle();
                    }
                    this.mPreviousUpEvent = obtain;
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.mIsDoubleTapping = false;
                    this.mDeferConfirmSingleTap = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        cancel();
                        return false;
                    } else if (i2 == 5) {
                        this.mLastFocusX = f5;
                        this.mDownFocusX = f5;
                        this.mLastFocusY = f6;
                        this.mDownFocusY = f6;
                        cancelTaps();
                        return false;
                    } else if (i2 != 6) {
                        return false;
                    } else {
                        this.mLastFocusX = f5;
                        this.mDownFocusX = f5;
                        this.mLastFocusY = f6;
                        this.mDownFocusY = f6;
                        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                        int actionIndex2 = motionEvent.getActionIndex();
                        int pointerId2 = motionEvent.getPointerId(actionIndex2);
                        float xVelocity2 = this.mVelocityTracker.getXVelocity(pointerId2);
                        float yVelocity2 = this.mVelocityTracker.getYVelocity(pointerId2);
                        for (int i4 = 0; i4 < pointerCount; i4++) {
                            if (i4 != actionIndex2) {
                                int pointerId3 = motionEvent.getPointerId(i4);
                                if ((this.mVelocityTracker.getXVelocity(pointerId3) * xVelocity2) + (this.mVelocityTracker.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                    this.mVelocityTracker.clear();
                                    return false;
                                }
                            }
                        }
                        return false;
                    }
                } else if (this.mInLongPress) {
                    return false;
                } else {
                    float f7 = this.mLastFocusX - f5;
                    float f8 = this.mLastFocusY - f6;
                    if (this.mIsDoubleTapping) {
                        return false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                    }
                    if (this.mAlwaysInTapRegion) {
                        int i5 = (int) (f5 - this.mDownFocusX);
                        int i6 = (int) (f6 - this.mDownFocusY);
                        int i7 = (i5 * i5) + (i6 * i6);
                        if (i7 > this.mTouchSlopSquare) {
                            onFling = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f7, f8);
                            this.mLastFocusX = f5;
                            this.mLastFocusY = f6;
                            this.mAlwaysInTapRegion = false;
                            this.mHandler.removeMessages(3);
                            this.mHandler.removeMessages(1);
                            this.mHandler.removeMessages(2);
                        } else {
                            onFling = false;
                        }
                        if (i7 > this.mTouchSlopSquare) {
                            this.mAlwaysInBiggerTapRegion = false;
                        }
                    } else if (Math.abs(f7) >= 1.0f || Math.abs(f8) >= 1.0f) {
                        boolean onScroll = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f7, f8);
                        this.mLastFocusX = f5;
                        this.mLastFocusY = f6;
                        return onScroll;
                    } else {
                        return false;
                    }
                }
                return onFling;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.mIsLongpressEnabled = z;
            }
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, onDoubleTapListener) == null) {
                this.mDoubleTapListener = onDoubleTapListener;
            }
        }

        /* loaded from: classes.dex */
        public class GestureHandler extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GestureDetectorCompatImplBase this$0;

            public GestureHandler(GestureDetectorCompatImplBase gestureDetectorCompatImplBase) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gestureDetectorCompatImplBase};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = gestureDetectorCompatImplBase;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    int i2 = message.what;
                    if (i2 == 1) {
                        GestureDetectorCompatImplBase gestureDetectorCompatImplBase = this.this$0;
                        gestureDetectorCompatImplBase.mListener.onShowPress(gestureDetectorCompatImplBase.mCurrentDownEvent);
                    } else if (i2 == 2) {
                        this.this$0.dispatchLongPress();
                    } else if (i2 == 3) {
                        GestureDetectorCompatImplBase gestureDetectorCompatImplBase2 = this.this$0;
                        GestureDetector.OnDoubleTapListener onDoubleTapListener = gestureDetectorCompatImplBase2.mDoubleTapListener;
                        if (onDoubleTapListener != null) {
                            if (!gestureDetectorCompatImplBase2.mStillDown) {
                                onDoubleTapListener.onSingleTapConfirmed(gestureDetectorCompatImplBase2.mCurrentDownEvent);
                            } else {
                                gestureDetectorCompatImplBase2.mDeferConfirmSingleTap = true;
                            }
                        }
                    } else {
                        throw new RuntimeException("Unknown message " + message);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GestureHandler(GestureDetectorCompatImplBase gestureDetectorCompatImplBase, Handler handler) {
                super(handler.getLooper());
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gestureDetectorCompatImplBase, handler};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.this$0 = gestureDetectorCompatImplBase;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final GestureDetector mDetector;

        public GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, onGestureListener, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDetector = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDetector.isLongpressEnabled() : invokeV.booleanValue;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.mDetector.onTouchEvent(motionEvent) : invokeL.booleanValue;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.mDetector.setIsLongpressEnabled(z);
            }
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, onDoubleTapListener) == null) {
                this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onGestureListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (GestureDetector.OnGestureListener) objArr2[1], (Handler) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean isLongpressEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mImpl.isLongpressEnabled() : invokeV.booleanValue;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.mImpl.onTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public void setIsLongpressEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mImpl.setIsLongpressEnabled(z);
        }
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onDoubleTapListener) == null) {
            this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onGestureListener, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (Build.VERSION.SDK_INT > 17) {
            this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.mImpl = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }
}
