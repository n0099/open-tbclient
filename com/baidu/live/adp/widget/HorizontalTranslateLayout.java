package com.baidu.live.adp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.live.adp.R;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String HORIZONTAL = "horizontal";
    public static final String LEFT = "left";
    private static final int MSG_ANIMATE_LEFT = -100;
    private static final int MSG_ANIMATE_LEFT_OPEN = -104;
    private static final int MSG_ANIMATE_RIGHT = -101;
    private static final int MSG_ANIMATE_RIGHT_OPEN = -105;
    public static final String RIGHT = "right";
    public static final int STATE_COLLAPSE_LEFT = 10000;
    public static final int STATE_COLLAPSE_RIGHT = 10001;
    public static final int STATE_EXPAND = 10004;
    private static final String TAG = "HorizontalTranslateLayout";
    private static final int TAP_THRESHOLD = 35;
    private final Animator mAnimator;
    private final Paint mBackgroundPaint;
    private final AnimationHandler mHandler;
    private int mLastDownX;
    private int mLastDownY;
    private int mLastMoveX;
    private boolean mLastMoveXBeenSet;
    private final Rect mLeftFrameForTap;
    private float mLeftOffset;
    private boolean mLeftTapBack;
    private int mLeftTranslate;
    private int mMeasuredWidth;
    private OnHorizontalTrackListener mOnHorizontalTrackListener;
    private OnLeftAnimationListener mOnLeftAnimationListener;
    private final List<OnOpenAnimationListener> mOnOpenAnimationListener;
    private OnRightAnimationListener mOnRightAnimationListener;
    private int mPositionState;
    private final Rect mRightFrameForTap;
    private float mRightOffset;
    private boolean mRightTapBack;
    private final int mTouchThreshold;
    private TrackDirection mTrackDirection;
    private final Tracker mTracker;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface OnHorizontalTrackListener {
        void onStartHorizontalTrack(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface OnLeftAnimationListener {
        void onLeftAnimationEnd();

        void onLeftAnimationStart();
    }

    /* loaded from: classes2.dex */
    interface OnLeftTrackListener {
        void onLeftTrackStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface OnOpenAnimationListener {
        void onOpenAnimationEnd();

        void onOpenAnimationStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface OnRightAnimationListener {
        void onRightAnimationEnd();

        void onRightAnimationStart();
    }

    /* loaded from: classes2.dex */
    interface OnRightTrackListener {
        void onRightTrackStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mLeftFrameForTap = new Rect();
        this.mRightFrameForTap = new Rect();
        this.mOnOpenAnimationListener = new ArrayList();
        this.mHandler = new AnimationHandler();
        this.mAnimator = new Animator();
        this.mTracker = new Tracker();
        this.mPositionState = 10004;
        Resources resources = getResources();
        this.mBackgroundPaint = new Paint();
        this.mBackgroundPaint.setColor(-1);
        this.mTouchThreshold = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        loadAttrs(attributeSet);
    }

    private void loadAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.sdk_HorizontalTranslateLayout);
        this.mLeftOffset = obtainStyledAttributes.getDimension(R.styleable.sdk_HorizontalTranslateLayout_leftOffset, -1.0f);
        this.mRightOffset = obtainStyledAttributes.getDimension(R.styleable.sdk_HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.sdk_HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.mLeftOffset != -1.0f && this.mRightOffset != -1.0f && HORIZONTAL.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.mTrackDirection = TrackDirection.horizontal;
            } else if (this.mRightOffset != -1.0f && RIGHT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.mTrackDirection = TrackDirection.right;
            } else if (this.mLeftOffset != -1.0f && "left".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.mTrackDirection = TrackDirection.left;
            } else {
                this.mTrackDirection = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.sdk_HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if ("left".equals(str) && this.mLeftOffset != -1.0f) {
                    this.mLeftTapBack = true;
                } else if (RIGHT.equals(str) && this.mRightOffset != -1.0f) {
                    this.mRightTapBack = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.mBackgroundPaint.setColor(obtainStyledAttributes.getColor(R.styleable.sdk_HorizontalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundPaint.setColor(i);
        invalidate();
    }

    public void setProportion(float f) {
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                this.mLeftTranslate = (int) ((this.mLeftOffset - this.mMeasuredWidth) * (-f));
            } else if (f > 0.0f) {
                this.mLeftTranslate = (int) ((this.mMeasuredWidth - this.mRightOffset) * f);
            } else if (f == 0.0f) {
                this.mLeftTranslate = 0;
                this.mPositionState = 10004;
            } else if (f == -1.0f) {
                this.mLeftOffset -= getMeasuredWidth();
                this.mPositionState = 10000;
            } else if (f == 1.0f) {
                this.mLeftOffset = getMeasuredWidth() - this.mRightOffset;
                this.mPositionState = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.mLeftOffset;
    }

    public int getRightOffset() {
        return (int) this.mRightOffset;
    }

    public boolean isLeftTapBack() {
        return this.mLeftTapBack;
    }

    public boolean isRightTapBack() {
        return this.mRightTapBack;
    }

    public void setLeftTapBack(boolean z) {
        this.mLeftTapBack = z;
    }

    public void setRightTapBack(boolean z) {
        this.mRightTapBack = z;
    }

    public void left() {
        this.mLeftTranslate = (int) (this.mLeftOffset - getMeasuredWidth());
        this.mPositionState = 10000;
        invalidate();
    }

    public void right() {
        this.mLeftTranslate = (int) (getMeasuredWidth() - this.mRightOffset);
        this.mPositionState = 10001;
        invalidate();
    }

    public void open() {
        this.mLeftTranslate = 0;
        this.mPositionState = 10004;
        invalidate();
    }

    public void animateLeft() {
        if (canLeft()) {
            this.mAnimator.animateLeft(-this.mAnimator.kVelocity);
        }
    }

    public void animateRight() {
        if (canRight()) {
            this.mAnimator.animateRight(this.mAnimator.kVelocity);
        }
    }

    public void animateOpen() {
        switch (this.mPositionState) {
            case 10000:
                this.mAnimator.animateLeftOpen(this.mAnimator.kVelocity);
                return;
            case 10001:
                this.mAnimator.animateRightOpen(-this.mAnimator.kVelocity);
                return;
            default:
                return;
        }
    }

    public int getState() {
        return this.mPositionState;
    }

    public void setLeftAnimationListener(OnLeftAnimationListener onLeftAnimationListener) {
        this.mOnLeftAnimationListener = onLeftAnimationListener;
    }

    public void setRightAnimationListener(OnRightAnimationListener onRightAnimationListener) {
        this.mOnRightAnimationListener = onRightAnimationListener;
    }

    public void addOpenAnimationListener(OnOpenAnimationListener onOpenAnimationListener) {
        this.mOnOpenAnimationListener.add(onOpenAnimationListener);
    }

    public void removeOpenAnimationListener(OnOpenAnimationListener onOpenAnimationListener) {
        this.mOnOpenAnimationListener.remove(onOpenAnimationListener);
    }

    public void setHorizontalTrackListener(OnHorizontalTrackListener onHorizontalTrackListener) {
        this.mOnHorizontalTrackListener = onHorizontalTrackListener;
    }

    private boolean canLeft() {
        return this.mLeftOffset != -1.0f && this.mPositionState == 10004;
    }

    private boolean canRight() {
        return this.mRightOffset != -1.0f && this.mPositionState == 10004;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.mLeftTranslate, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.mLeftTranslate);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.mBackgroundPaint);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.mLeftTranslate;
    }

    public boolean isAnimating() {
        return this.mAnimator.iAnimating;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mTrackDirection == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.mPositionState == 10004) {
            switch (action) {
                case 0:
                    this.mLastDownX = x;
                    this.mLastDownY = y;
                    this.mHandler.removeMessages(-100);
                    this.mHandler.removeMessages(MSG_ANIMATE_LEFT_OPEN);
                    this.mHandler.removeMessages(-101);
                    this.mHandler.removeMessages(MSG_ANIMATE_RIGHT_OPEN);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.mLeftTranslate, 0.0f);
                    return prepareTracking(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean prepareTracking(int i, int i2) {
        return i2 >= this.mLastDownY - this.mTouchThreshold && i2 <= this.mLastDownY + this.mTouchThreshold && (i < this.mLastDownX - this.mTouchThreshold || i > this.mLastDownX + this.mTouchThreshold) && this.mTracker.prepareTracking(i - this.mLastDownX);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.mPositionState == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.mLastMoveXBeenSet = false;
                    if (this.mTracker.tracking) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.mTracker.stopTracking();
                        this.mTracker.fling();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.mTracker.tracking) {
                        if (!this.mLastMoveXBeenSet) {
                            if (x > this.mLastDownX) {
                                this.mLastMoveX = this.mLastDownX + this.mTouchThreshold;
                                this.mLastMoveXBeenSet = true;
                            } else {
                                this.mLastMoveX = this.mLastDownX - this.mTouchThreshold;
                                this.mLastMoveXBeenSet = true;
                            }
                        }
                        this.mTracker.move(this.mLastMoveX - x);
                        this.mLastMoveX = x;
                        this.mTracker.velocityTracker.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d(TAG + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.mLeftFrameForTap);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.mRightFrameForTap);
        switch (action) {
            case 0:
                if ((this.mPositionState != 10000 || !this.mLeftFrameForTap.contains(x, y)) && (this.mPositionState != 10001 || !this.mRightFrameForTap.contains(x, y))) {
                    return false;
                }
                if (!this.mTracker.tracking) {
                    this.mLastMoveX = x;
                    this.mTracker.prepareTracking(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.mTracker.tracking) {
                    this.mTracker.stopTracking();
                    this.mTracker.fling();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.mTracker.tracking) {
            this.mTracker.move(this.mLastMoveX - x);
            this.mLastMoveX = x;
            this.mTracker.velocityTracker.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.mLeftOffset != -1.0f) {
                this.mLeftFrameForTap.set(i, i2, (int) (i + this.mLeftOffset), i4);
            }
            if (this.mRightOffset != -1.0f) {
                this.mRightFrameForTap.set((int) (i3 - this.mRightOffset), i2, i3, i4);
            }
        }
        if (!this.mAnimator.iAnimating && !this.mTracker.tracking) {
            offset();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.mLeftOffset) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.mRightOffset) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.mMeasuredWidth = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void offset() {
        switch (this.mPositionState) {
            case 10000:
                this.mLeftTranslate = (int) (this.mLeftOffset - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.mLeftTranslate = (int) (getMeasuredWidth() - this.mRightOffset);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.mLeftTranslate = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (HorizontalTranslateLayout.this.mAnimator.iAnimating) {
                switch (message.what) {
                    case HorizontalTranslateLayout.MSG_ANIMATE_RIGHT_OPEN /* -105 */:
                        HorizontalTranslateLayout.this.mAnimator.computeRightOpenAnimation();
                        return;
                    case HorizontalTranslateLayout.MSG_ANIMATE_LEFT_OPEN /* -104 */:
                        HorizontalTranslateLayout.this.mAnimator.computeLeftOpenAnimation();
                        return;
                    case SapiErrorCode.INVALID_ARG /* -103 */:
                    case -102:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.mAnimator.computeRightAnimation();
                        return;
                    case -100:
                        HorizontalTranslateLayout.this.mAnimator.computeLeftAnimation();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Tracker {
        static final float MIN_VELOCITY = 500.0f;
        static final int VELOCITY_UNIT = 200;
        final int minVelocity;
        boolean tracking;
        VelocityTracker velocityTracker;
        final int velocityUnit;

        Tracker() {
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.velocityUnit = (int) ((200.0f * f) + 0.5f);
            this.minVelocity = (int) ((f * MIN_VELOCITY) + 0.5f);
        }

        boolean prepareTracking(int i) {
            switch (HorizontalTranslateLayout.this.mTrackDirection) {
                case left:
                    if (HorizontalTranslateLayout.this.mPositionState != 10004 && HorizontalTranslateLayout.this.mPositionState != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.mPositionState != 10004 && HorizontalTranslateLayout.this.mPositionState != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.mOnHorizontalTrackListener != null) {
                        HorizontalTranslateLayout.this.mOnHorizontalTrackListener.onStartHorizontalTrack(i);
                        break;
                    }
                    break;
            }
            this.velocityTracker = VelocityTracker.obtain();
            this.tracking = true;
            return true;
        }

        void stopTracking() {
            this.tracking = false;
        }

        void move(int i) {
            if (this.tracking) {
                int i2 = HorizontalTranslateLayout.this.mLeftTranslate - i;
                switch (HorizontalTranslateLayout.this.mTrackDirection) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.mLeftOffset - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.mLeftTranslate -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.mRightOffset && i2 > 0) {
                            HorizontalTranslateLayout.this.mLeftTranslate -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.mLeftOffset - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.mRightOffset) {
                            HorizontalTranslateLayout.this.mLeftTranslate -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fling() {
            float max;
            this.velocityTracker.computeCurrentVelocity(this.velocityUnit);
            float xVelocity = this.velocityTracker.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.minVelocity);
            } else {
                max = Math.max(xVelocity, this.minVelocity);
            }
            switch (HorizontalTranslateLayout.this.mTrackDirection) {
                case left:
                    leftFling(max);
                    break;
                case right:
                    rightFling(max);
                    break;
                case horizontal:
                    horizontalFling(max);
                    break;
            }
            this.velocityTracker.recycle();
            this.velocityTracker = null;
        }

        private void horizontalFling(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.mLeftTranslate;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.mLeftOffset - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.mAnimator.animateLeft(f);
                } else {
                    HorizontalTranslateLayout.this.mAnimator.animateLeftOpen(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.mRightOffset) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.mAnimator.animateRightOpen(f);
                } else {
                    HorizontalTranslateLayout.this.mAnimator.animateRight(f);
                }
            }
        }

        private void leftFling(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.mAnimator.animateLeft(f);
            } else {
                HorizontalTranslateLayout.this.mAnimator.animateLeftOpen(f);
            }
        }

        private void rightFling(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.mAnimator.animateRightOpen(f);
            } else {
                HorizontalTranslateLayout.this.mAnimator.animateRight(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Animator {
        static final String TAG = "Animator";
        static final int VELOCITY = 600;
        boolean iAnimating;
        float iAnimatingPosition;
        float iAnimatingVelocity;
        float iAnimationDistance;
        float iAnimationStart;
        long iCurrentAnimationTime;
        long iLastAnimationTime;
        final float kVelocity;

        Animator() {
            this.kVelocity = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.iAnimatingPosition = ((((float) (uptimeMillis - this.iLastAnimationTime)) / 1000.0f) * this.iAnimatingVelocity) + this.iAnimatingPosition;
            this.iLastAnimationTime = uptimeMillis;
            this.iCurrentAnimationTime += 16;
        }

        void computeLeftAnimation() {
            compute();
            if (this.iAnimatingPosition <= this.iAnimationDistance) {
                OnLeftAnimationListener onLeftAnimationListener = HorizontalTranslateLayout.this.mOnLeftAnimationListener;
                if (onLeftAnimationListener != null) {
                    onLeftAnimationListener.onLeftAnimationEnd();
                }
                this.iAnimating = false;
                HorizontalTranslateLayout.this.mPositionState = 10000;
                HorizontalTranslateLayout.this.offset();
                return;
            }
            HorizontalTranslateLayout.this.mLeftTranslate = (int) (ViewConfig.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-100, this.iCurrentAnimationTime);
        }

        void computeRightAnimation() {
            compute();
            if (this.iAnimatingPosition >= this.iAnimationDistance) {
                OnRightAnimationListener onRightAnimationListener = HorizontalTranslateLayout.this.mOnRightAnimationListener;
                if (onRightAnimationListener != null) {
                    onRightAnimationListener.onRightAnimationEnd();
                }
                this.iAnimating = false;
                HorizontalTranslateLayout.this.mPositionState = 10001;
                HorizontalTranslateLayout.this.offset();
                return;
            }
            HorizontalTranslateLayout.this.mLeftTranslate = (int) (ViewConfig.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-101, this.iCurrentAnimationTime);
        }

        void computeLeftOpenAnimation() {
            compute();
            if (this.iAnimatingPosition >= this.iAnimationDistance) {
                for (OnOpenAnimationListener onOpenAnimationListener : HorizontalTranslateLayout.this.mOnOpenAnimationListener) {
                    if (onOpenAnimationListener != null) {
                        onOpenAnimationListener.onOpenAnimationEnd();
                    }
                }
                this.iAnimating = false;
                HorizontalTranslateLayout.this.mPositionState = 10004;
                HorizontalTranslateLayout.this.offset();
                return;
            }
            HorizontalTranslateLayout.this.mLeftTranslate = (int) (ViewConfig.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(HorizontalTranslateLayout.MSG_ANIMATE_LEFT_OPEN, this.iCurrentAnimationTime);
        }

        void computeRightOpenAnimation() {
            compute();
            if (this.iAnimatingPosition <= this.iAnimationDistance) {
                for (OnOpenAnimationListener onOpenAnimationListener : HorizontalTranslateLayout.this.mOnOpenAnimationListener) {
                    if (onOpenAnimationListener != null) {
                        onOpenAnimationListener.onOpenAnimationEnd();
                    }
                }
                this.iAnimating = false;
                HorizontalTranslateLayout.this.mPositionState = 10004;
                HorizontalTranslateLayout.this.offset();
                return;
            }
            HorizontalTranslateLayout.this.mLeftTranslate = (int) (ViewConfig.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(HorizontalTranslateLayout.MSG_ANIMATE_RIGHT_OPEN, this.iCurrentAnimationTime);
        }

        void animateLeftOpen(float f) {
            for (OnOpenAnimationListener onOpenAnimationListener : HorizontalTranslateLayout.this.mOnOpenAnimationListener) {
                if (onOpenAnimationListener != null) {
                    onOpenAnimationListener.onOpenAnimationStart();
                }
            }
            this.iAnimating = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.iLastAnimationTime = uptimeMillis;
            this.iCurrentAnimationTime = uptimeMillis + 16;
            this.iAnimatingVelocity = f;
            this.iAnimatingPosition = 0.0f;
            this.iAnimationDistance = 0 - HorizontalTranslateLayout.this.mLeftTranslate;
            this.iAnimationStart = HorizontalTranslateLayout.this.mLeftTranslate;
            HorizontalTranslateLayout.this.mHandler.removeMessages(HorizontalTranslateLayout.MSG_ANIMATE_LEFT_OPEN);
            BdLog.d("Animator@animateTopOpen " + this.iAnimationDistance);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(HorizontalTranslateLayout.MSG_ANIMATE_LEFT_OPEN, this.iCurrentAnimationTime);
        }

        void animateRightOpen(float f) {
            for (OnOpenAnimationListener onOpenAnimationListener : HorizontalTranslateLayout.this.mOnOpenAnimationListener) {
                if (onOpenAnimationListener != null) {
                    onOpenAnimationListener.onOpenAnimationStart();
                }
            }
            this.iAnimating = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.iLastAnimationTime = uptimeMillis;
            this.iCurrentAnimationTime = uptimeMillis + 16;
            this.iAnimatingVelocity = f;
            this.iAnimatingPosition = 0.0f;
            this.iAnimationDistance = 0 - HorizontalTranslateLayout.this.mLeftTranslate;
            this.iAnimationStart = HorizontalTranslateLayout.this.mLeftTranslate;
            BdLog.d("Animator@animateBottomOpen " + this.iAnimationDistance);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.mHandler.removeMessages(HorizontalTranslateLayout.MSG_ANIMATE_RIGHT_OPEN);
            HorizontalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(HorizontalTranslateLayout.MSG_ANIMATE_RIGHT_OPEN, this.iCurrentAnimationTime);
        }

        void animateLeft(float f) {
            OnLeftAnimationListener onLeftAnimationListener = HorizontalTranslateLayout.this.mOnLeftAnimationListener;
            if (onLeftAnimationListener != null) {
                onLeftAnimationListener.onLeftAnimationStart();
            }
            this.iAnimating = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.iLastAnimationTime = uptimeMillis;
            this.iCurrentAnimationTime = uptimeMillis + 16;
            this.iAnimatingVelocity = f;
            this.iAnimatingPosition = 0.0f;
            this.iAnimationDistance = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.mLeftOffset) - HorizontalTranslateLayout.this.mLeftTranslate;
            this.iAnimationStart = HorizontalTranslateLayout.this.mLeftTranslate;
            BdLog.d("Animator@animateTop " + this.iAnimationDistance);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.mHandler.removeMessages(-100);
            HorizontalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-100, this.iCurrentAnimationTime);
        }

        void animateRight(float f) {
            OnRightAnimationListener onRightAnimationListener = HorizontalTranslateLayout.this.mOnRightAnimationListener;
            if (onRightAnimationListener != null) {
                onRightAnimationListener.onRightAnimationStart();
            }
            this.iAnimating = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.iLastAnimationTime = uptimeMillis;
            this.iCurrentAnimationTime = uptimeMillis + 16;
            this.iAnimatingVelocity = f;
            this.iAnimatingPosition = 0.0f;
            this.iAnimationDistance = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.mRightOffset) - HorizontalTranslateLayout.this.mLeftTranslate;
            this.iAnimationStart = HorizontalTranslateLayout.this.mLeftTranslate;
            BdLog.d("Animator@animateBottom " + this.iAnimationDistance);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.mHandler.removeMessages(-101);
            HorizontalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-101, this.iCurrentAnimationTime);
        }
    }

    public void dump() {
        BdLog.d("HorizontalTranslateLayout@dump top offset " + this.mLeftOffset);
        BdLog.d("HorizontalTranslateLayout@dump bottom offset " + this.mRightOffset);
        BdLog.d("HorizontalTranslateLayout@dump track " + this.mTrackDirection);
        BdLog.d("HorizontalTranslateLayout@dump top tap " + this.mLeftTapBack);
        BdLog.d("HorizontalTranslateLayout@dump bottom tap " + this.mRightOffset);
    }
}
