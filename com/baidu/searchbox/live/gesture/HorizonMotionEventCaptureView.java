package com.baidu.searchbox.live.gesture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class HorizonMotionEventCaptureView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_POINTER = -1;
    public static final int SLID_DIRECTION_INVALID = -1;
    public static final int SLID_DIRECTION_LEFT = 1;
    public static final int SLID_DIRECTION_RIGHT = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActivePointerId;
    public int mBeingDraggedDirection;
    public ICapture mCapture;
    public IEventAdapter mEventAdapter;
    public int mInitialMotionX;
    public int mInitialMotionY;
    public int mLastMotionX;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;

    /* loaded from: classes2.dex */
    public static class CaptureEvent {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ACTION_INTERCEPT = 1;
        public static final int ACTION_MOVE = 2;
        public static final int ACTION_UP = 3;
        public transient /* synthetic */ FieldHolder $fh;
        public int action;
        public int delX;
        public int direction;
        public int distance;
        public int velocity;
        public int x;
        public int y;

        public CaptureEvent() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonMotionEventCaptureView(@NonNull Context context) {
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
        this.mBeingDraggedDirection = -1;
        this.mActivePointerId = -1;
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void intercept() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            CaptureEvent captureEvent = new CaptureEvent();
            captureEvent.action = 1;
            captureEvent.direction = this.mBeingDraggedDirection;
            IEventAdapter iEventAdapter = this.mEventAdapter;
            if (iEventAdapter != null) {
                iEventAdapter.onEvent(captureEvent);
            }
        }
    }

    private boolean isBeingDragged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int i = this.mBeingDraggedDirection;
            return i == 1 || i == 2;
        }
        return invokeV.booleanValue;
    }

    private void move(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65542, this, i, i2) == null) {
            CaptureEvent captureEvent = new CaptureEvent();
            captureEvent.action = 2;
            captureEvent.delX = i;
            captureEvent.distance = i2;
            captureEvent.direction = this.mBeingDraggedDirection;
            IEventAdapter iEventAdapter = this.mEventAdapter;
            if (iEventAdapter != null) {
                iEventAdapter.onEvent(captureEvent);
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (velocityTracker = this.mVelocityTracker) == null) {
            return;
        }
        velocityTracker.recycle();
        this.mVelocityTracker = null;
    }

    private void up(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            CaptureEvent captureEvent = new CaptureEvent();
            captureEvent.velocity = i;
            captureEvent.action = 3;
            captureEvent.direction = this.mBeingDraggedDirection;
            IEventAdapter iEventAdapter = this.mEventAdapter;
            if (iEventAdapter != null) {
                iEventAdapter.onEvent(captureEvent);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0042, code lost:
        if (r0 != 3) goto L31;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            ICapture iCapture = this.mCapture;
            if (iCapture != null && !iCapture.isEnable()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            IEventAdapter iEventAdapter = this.mEventAdapter;
            if (iEventAdapter != null && !iEventAdapter.isEnable()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if ((action == 2 && isBeingDragged()) || super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            int i = action & 255;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int i2 = this.mActivePointerId;
                        if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1) {
                            int x = (int) motionEvent.getX(findPointerIndex);
                            int y = (int) motionEvent.getY(findPointerIndex);
                            int i3 = x - this.mLastMotionX;
                            if (Math.abs(i3) > this.mTouchSlop && Math.abs(i3) * 0.5f > Math.abs(y - this.mInitialMotionY)) {
                                this.mLastMotionX = x;
                                initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(motionEvent);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                                if (i3 > 0) {
                                    this.mBeingDraggedDirection = 2;
                                } else {
                                    this.mBeingDraggedDirection = 1;
                                }
                                intercept();
                            }
                        }
                    }
                }
                this.mActivePointerId = -1;
                recycleVelocityTracker();
            } else {
                int x2 = (int) motionEvent.getX();
                this.mInitialMotionX = x2;
                this.mLastMotionX = x2;
                this.mInitialMotionY = (int) motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                initVelocityTrackerIfNotExists();
                this.mVelocityTracker.addMovement(motionEvent);
            }
            return isBeingDragged();
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0034, code lost:
        if (r0 != 3) goto L24;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            ICapture iCapture = this.mCapture;
            if (iCapture != null && !iCapture.isEnable()) {
                return super.onTouchEvent(motionEvent);
            }
            IEventAdapter iEventAdapter = this.mEventAdapter;
            if (iEventAdapter != null && !iEventAdapter.isEnable()) {
                return super.onTouchEvent(motionEvent);
            }
            initVelocityTrackerIfNotExists();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex != -1) {
                            int x = (int) motionEvent.getX(findPointerIndex);
                            int y = (int) motionEvent.getY(findPointerIndex);
                            int i = x - this.mLastMotionX;
                            if (!isBeingDragged() && Math.abs(i) > this.mTouchSlop && Math.abs(i) * 0.5f > Math.abs(y - this.mInitialMotionY)) {
                                ViewParent parent2 = getParent();
                                if (parent2 != null) {
                                    parent2.requestDisallowInterceptTouchEvent(true);
                                }
                                if (i > 0) {
                                    this.mBeingDraggedDirection = 2;
                                    i -= this.mTouchSlop;
                                } else {
                                    this.mBeingDraggedDirection = 1;
                                    i += this.mTouchSlop;
                                }
                                intercept();
                            }
                            if (isBeingDragged()) {
                                this.mLastMotionX = x;
                                move(i, x - this.mInitialMotionX);
                            }
                        }
                    }
                }
                if (isBeingDragged()) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                    up(Math.abs(xVelocity) > this.mMinimumVelocity ? xVelocity : 0);
                    this.mActivePointerId = -1;
                    this.mBeingDraggedDirection = -1;
                    recycleVelocityTracker();
                }
            } else {
                if (isBeingDragged() && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                int x2 = (int) motionEvent.getX();
                this.mInitialMotionX = x2;
                this.mLastMotionX = x2;
                this.mInitialMotionY = (int) motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                initVelocityTrackerIfNotExists();
            }
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setCapture(ICapture iCapture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iCapture) == null) {
            this.mCapture = iCapture;
        }
    }

    public void setEventAdapter(IEventAdapter iEventAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iEventAdapter) == null) {
            this.mEventAdapter = iEventAdapter;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonMotionEventCaptureView(@NonNull Context context, AttributeSet attributeSet) {
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
        this.mBeingDraggedDirection = -1;
        this.mActivePointerId = -1;
        init();
    }
}
