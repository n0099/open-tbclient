package com.baidu.searchbox.live.gesture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class HorizonMotionEventCaptureView extends FrameLayout {
    public static final int INVALID_POINTER = -1;
    public static final int SLID_DIRECTION_INVALID = -1;
    public static final int SLID_DIRECTION_LEFT = 1;
    public static final int SLID_DIRECTION_RIGHT = 2;
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

    /* loaded from: classes3.dex */
    public static class CaptureEvent {
        public static final int ACTION_INTERCEPT = 1;
        public static final int ACTION_MOVE = 2;
        public static final int ACTION_UP = 3;
        public int action;
        public int delX;
        public int direction;
        public int distance;
        public int velocity;
        public int x;
        public int y;
    }

    public HorizonMotionEventCaptureView(@NonNull Context context) {
        super(context);
        this.mBeingDraggedDirection = -1;
        this.mActivePointerId = -1;
        init();
    }

    private void up(int i) {
        CaptureEvent captureEvent = new CaptureEvent();
        captureEvent.velocity = i;
        captureEvent.action = 3;
        captureEvent.direction = this.mBeingDraggedDirection;
        IEventAdapter iEventAdapter = this.mEventAdapter;
        if (iEventAdapter != null) {
            iEventAdapter.onEvent(captureEvent);
        }
    }

    public void setCapture(ICapture iCapture) {
        this.mCapture = iCapture;
    }

    public void setEventAdapter(IEventAdapter iEventAdapter) {
        this.mEventAdapter = iEventAdapter;
    }

    public HorizonMotionEventCaptureView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBeingDraggedDirection = -1;
        this.mActivePointerId = -1;
        init();
    }

    private void move(int i, int i2) {
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

    private void init() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void intercept() {
        CaptureEvent captureEvent = new CaptureEvent();
        captureEvent.action = 1;
        captureEvent.direction = this.mBeingDraggedDirection;
        IEventAdapter iEventAdapter = this.mEventAdapter;
        if (iEventAdapter != null) {
            iEventAdapter.onEvent(captureEvent);
        }
    }

    private boolean isBeingDragged() {
        int i = this.mBeingDraggedDirection;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
        if (r0 != 3) goto L29;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
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

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
        if (r0 != 3) goto L22;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
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
        int i = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex != -1) {
                        int x = (int) motionEvent.getX(findPointerIndex);
                        int y = (int) motionEvent.getY(findPointerIndex);
                        int i2 = x - this.mLastMotionX;
                        if (!isBeingDragged() && Math.abs(i2) > this.mTouchSlop && Math.abs(i2) * 0.5f > Math.abs(y - this.mInitialMotionY)) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            if (i2 > 0) {
                                this.mBeingDraggedDirection = 2;
                                i2 -= this.mTouchSlop;
                            } else {
                                this.mBeingDraggedDirection = 1;
                                i2 += this.mTouchSlop;
                            }
                            intercept();
                        }
                        if (isBeingDragged()) {
                            this.mLastMotionX = x;
                            move(i2, x - this.mInitialMotionX);
                        }
                    }
                }
            }
            if (isBeingDragged()) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                    i = xVelocity;
                }
                up(i);
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
}
