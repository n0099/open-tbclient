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
import com.baidu.sapi2.result.OneKeyLoginResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String BOTTOM = "bottom";
    private static final int MSG_ANIMATE_BOTTOM = -101;
    private static final int MSG_ANIMATE_BOTTOM_OPEN = -105;
    private static final int MSG_ANIMATE_TOP = -100;
    private static final int MSG_ANIMATE_TOP_OPEN = -104;
    public static final int STATE_COLLAPSE_BOTTOM = 10001;
    public static final int STATE_COLLAPSE_TOP = 10000;
    public static final int STATE_EXPAND = 10004;
    private static final String TAG = "VerticalTranslateLayout";
    private static final int TAP_THRESHOLD = 35;
    public static final String TOP = "top";
    public static final String VERTICAL = "vertical";
    private final Animator mAnimator;
    private final Paint mBackgroundPaint;
    private final Rect mBottomFrameForTap;
    private float mBottomHeight;
    private float mBottomOffset;
    private boolean mBottomTapBack;
    private final AnimationHandler mHandler;
    private int mLastDownX;
    private int mLastDownY;
    private int mLastMoveY;
    private boolean mLastMoveYBeenSet;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private OnBottomAnimationListener mOnBottomAnimationListener;
    private final List<OnOpenAnimationListener> mOnOpenAnimationListener;
    private OnTopAnimationListener mOnTopAnimationListener;
    private OnVerticalTrackListener mOnVerticalTrackListener;
    private int mPositionState;
    private final Rect mTopFrameForTap;
    private float mTopHeight;
    private float mTopOffset;
    private boolean mTopTapBack;
    private int mTopTranslate;
    private final int mTouchThreshold;
    private TrackDirection mTrackDirection;
    private final Tracker mTracker;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface OnBottomAnimationListener {
        void onBottomAnimationEnd();

        void onRightAnimationStart();
    }

    /* loaded from: classes11.dex */
    interface OnBottomTrackListener {
        void onBottomTrackStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface OnOpenAnimationListener {
        void onOpenAnimationEnd();

        void onOpenAnimationStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface OnTopAnimationListener {
        void onLeftAnimationStart();

        void onTopAnimationEnd();
    }

    /* loaded from: classes11.dex */
    interface OnTopTrackListener {
        void onTopTrackStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface OnVerticalTrackListener {
        void onStartVerticalTrack(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mTopFrameForTap = new Rect();
        this.mBottomFrameForTap = new Rect();
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
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.sdk_VerticalTranslateLayout);
        this.mTopOffset = obtainStyledAttributes.getDimension(R.styleable.sdk_VerticalTranslateLayout_topOffset, -1.0f);
        this.mBottomOffset = obtainStyledAttributes.getDimension(R.styleable.sdk_VerticalTranslateLayout_bottomOffset, -1.0f);
        this.mTopHeight = obtainStyledAttributes.getDimension(R.styleable.sdk_VerticalTranslateLayout_topHeight, -1.0f);
        this.mBottomHeight = obtainStyledAttributes.getDimension(R.styleable.sdk_VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.sdk_VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (canTop() && canBottom() && VERTICAL.equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.mTrackDirection = TrackDirection.vertical;
            } else if (canBottom() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.mTrackDirection = TrackDirection.bottom;
            } else if (canTop() && TOP.equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.mTrackDirection = TrackDirection.top;
            } else {
                this.mTrackDirection = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.sdk_VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if (TOP.equals(str) && this.mTopOffset != -1.0f) {
                    this.mTopTapBack = true;
                } else if ("bottom".equals(str) && this.mBottomOffset != -1.0f) {
                    this.mBottomTapBack = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.mBackgroundPaint.setColor(obtainStyledAttributes.getColor(R.styleable.sdk_VerticalTranslateLayout_transBackground, 0));
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
                this.mTopTranslate = (int) ((this.mTopOffset - this.mMeasuredHeight) * (-f));
            } else if (f > 0.0f) {
                this.mTopTranslate = (int) ((this.mMeasuredHeight - this.mBottomOffset) * f);
            } else if (f == 0.0f) {
                this.mTopTranslate = 0;
                this.mPositionState = 10004;
            } else if (f == -1.0f) {
                this.mTopOffset -= this.mMeasuredHeight;
                this.mPositionState = 10000;
            } else if (f == 1.0f) {
                this.mTopOffset = this.mMeasuredHeight - this.mBottomOffset;
                this.mPositionState = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.mTopOffset;
    }

    public int getBottomOffset() {
        return (int) this.mBottomOffset;
    }

    public boolean isTopTapBack() {
        return this.mTopTapBack;
    }

    public boolean isBottomTapBack() {
        return this.mBottomTapBack;
    }

    public void setTopTapBack(boolean z) {
        this.mTopTapBack = z;
    }

    public void setBottomTapBack(boolean z) {
        this.mBottomTapBack = z;
    }

    public void collapseTop(boolean z) {
        if (canTop()) {
            if (z) {
                this.mAnimator.animateTop(-this.mAnimator.kVelocity);
                return;
            }
            this.mTopTranslate = (int) (this.mTopOffset - this.mMeasuredHeight);
            this.mPositionState = 10000;
            invalidate();
        }
    }

    public void collapseBottom(boolean z) {
        if (canBottom()) {
            if (z) {
                this.mAnimator.animateBottom(this.mAnimator.kVelocity);
                return;
            }
            this.mTopTranslate = (int) (this.mMeasuredHeight - this.mBottomOffset);
            this.mPositionState = 10001;
            invalidate();
        }
    }

    public void expand(boolean z) {
        if (z) {
            switch (this.mPositionState) {
                case 10000:
                    this.mAnimator.animateTopOpen(this.mAnimator.kVelocity);
                    return;
                case 10001:
                    this.mAnimator.animateBottomOpen(-this.mAnimator.kVelocity);
                    return;
                default:
                    return;
            }
        }
        this.mTopTranslate = 0;
        this.mPositionState = 10004;
        invalidate();
    }

    public int getState() {
        return this.mPositionState;
    }

    public void setTopAnimationListener(OnTopAnimationListener onTopAnimationListener) {
        this.mOnTopAnimationListener = onTopAnimationListener;
    }

    public void setBottomAnimationListener(OnBottomAnimationListener onBottomAnimationListener) {
        this.mOnBottomAnimationListener = onBottomAnimationListener;
    }

    public void addOpenAnimationListener(OnOpenAnimationListener onOpenAnimationListener) {
        this.mOnOpenAnimationListener.add(onOpenAnimationListener);
    }

    public void removeOpenAnimationListener(OnOpenAnimationListener onOpenAnimationListener) {
        this.mOnOpenAnimationListener.remove(onOpenAnimationListener);
    }

    public void setVerticalTrackListener(OnVerticalTrackListener onVerticalTrackListener) {
        this.mOnVerticalTrackListener = onVerticalTrackListener;
    }

    private boolean canTop() {
        return (this.mTopOffset == -1.0f && this.mBottomHeight == -1.0f) ? false : true;
    }

    private boolean canBottom() {
        return (this.mBottomOffset == -1.0f && this.mTopHeight == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.mTopTranslate);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.mTopTranslate);
        canvas.drawRect(0.0f, 0.0f, this.mMeasuredWidth, this.mMeasuredHeight, this.mBackgroundPaint);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.mTopTranslate;
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
                    this.mHandler.removeMessages(-104);
                    this.mHandler.removeMessages(-101);
                    this.mHandler.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.mTopTranslate);
                    return prepareTracking(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean prepareTracking(int i, int i2) {
        return i >= this.mLastDownX - this.mTouchThreshold && i <= this.mLastDownX + this.mTouchThreshold && (i2 < this.mLastDownY - this.mTouchThreshold || i2 > this.mLastDownY + this.mTouchThreshold) && this.mTracker.prepareTracking(i2 - this.mLastDownY);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.mLastMoveYBeenSet = false;
                    if (this.mTracker.tracking) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.mTracker.stopTracking();
                        this.mTracker.fling();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.mTracker.tracking) {
                        if (!this.mLastMoveYBeenSet) {
                            if (y > this.mLastDownY) {
                                this.mLastMoveY = this.mLastDownY + this.mTouchThreshold;
                                this.mLastMoveYBeenSet = true;
                            } else {
                                this.mLastMoveY = this.mLastDownY - this.mTouchThreshold;
                                this.mLastMoveYBeenSet = true;
                            }
                        }
                        this.mTracker.move(this.mLastMoveY - y);
                        this.mLastMoveY = y;
                        this.mTracker.velocityTracker.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.mPositionState != 10000 || !this.mTopFrameForTap.contains(x, y)) && (this.mPositionState != 10001 || !this.mBottomFrameForTap.contains(x, y))) {
                    return false;
                }
                if (!this.mTracker.tracking) {
                    this.mLastMoveY = y;
                    this.mTracker.prepareTracking(y);
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
            this.mTracker.move(this.mLastMoveY - y);
            this.mLastMoveY = y;
            this.mTracker.velocityTracker.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.mTopOffset != -1.0f) {
                this.mTopFrameForTap.set(i, i2, i3, (int) (i2 + this.mTopOffset));
            }
            if (this.mBottomOffset != -1.0f) {
                this.mBottomFrameForTap.set(i, (int) (i4 - this.mBottomOffset), i3, i4);
            }
        }
        if (!this.mAnimator.iAnimating && !this.mTracker.tracking) {
            offset();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.mTopHeight != -1.0f) {
            this.mTopOffset = i3 - this.mBottomHeight;
        }
        if (this.mBottomHeight != -1.0f) {
            this.mBottomOffset = i3 - this.mTopHeight;
        }
        if (!$assertionsDisabled && i3 < this.mTopOffset) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.mBottomOffset) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.mMeasuredWidth = getMeasuredWidth();
        this.mMeasuredHeight = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void offset() {
        switch (this.mPositionState) {
            case 10000:
                this.mTopTranslate = (int) (this.mTopOffset - this.mMeasuredHeight);
                invalidate();
                return;
            case 10001:
                this.mTopTranslate = (int) (this.mMeasuredHeight - this.mBottomOffset);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.mTopTranslate = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (VerticalTranslateLayout.this.mAnimator.iAnimating) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.mAnimator.computeBottomOpenAnimation();
                        return;
                    case -104:
                        VerticalTranslateLayout.this.mAnimator.computeTopOpenAnimation();
                        return;
                    case -103:
                    case OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.mAnimator.computeBottomAnimation();
                        return;
                    case -100:
                        VerticalTranslateLayout.this.mAnimator.computeTopAnimation();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class Tracker {
        static final float MIN_VELOCITY = 500.0f;
        static final int VELOCITY_UNIT = 200;
        final int minVelocity;
        boolean tracking;
        VelocityTracker velocityTracker;
        final int velocityUnit;

        Tracker() {
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.velocityUnit = (int) ((200.0f * f) + 0.5f);
            this.minVelocity = (int) ((f * MIN_VELOCITY) + 0.5f);
        }

        boolean prepareTracking(int i) {
            switch (VerticalTranslateLayout.this.mTrackDirection) {
                case top:
                    if (VerticalTranslateLayout.this.mPositionState != 10004 && VerticalTranslateLayout.this.mPositionState != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.mPositionState != 10004 && VerticalTranslateLayout.this.mPositionState != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.mOnVerticalTrackListener != null) {
                        VerticalTranslateLayout.this.mOnVerticalTrackListener.onStartVerticalTrack(i);
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
                int i2 = VerticalTranslateLayout.this.mTopTranslate - i;
                switch (VerticalTranslateLayout.this.mTrackDirection) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.mTopOffset - VerticalTranslateLayout.this.mMeasuredHeight && i2 < 0) {
                            VerticalTranslateLayout.this.mTopTranslate -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.mMeasuredHeight - VerticalTranslateLayout.this.mBottomOffset && i2 > 0) {
                            VerticalTranslateLayout.this.mTopTranslate -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.mTopOffset - VerticalTranslateLayout.this.mMeasuredHeight && i2 <= VerticalTranslateLayout.this.mMeasuredHeight - VerticalTranslateLayout.this.mBottomOffset) {
                            VerticalTranslateLayout.this.mTopTranslate -= i;
                            VerticalTranslateLayout.this.invalidate();
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
            float yVelocity = this.velocityTracker.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.minVelocity);
            } else {
                max = Math.max(yVelocity, this.minVelocity);
            }
            switch (VerticalTranslateLayout.this.mTrackDirection) {
                case top:
                    topFling(max);
                    break;
                case bottom:
                    bottomFling(max);
                    break;
                case vertical:
                    verticalFling(max);
                    break;
            }
            this.velocityTracker.recycle();
            this.velocityTracker = null;
        }

        private void verticalFling(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.mTopTranslate;
            if (i <= 0 && i >= VerticalTranslateLayout.this.mTopOffset - VerticalTranslateLayout.this.mMeasuredHeight) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.mAnimator.animateTop(f);
                } else {
                    VerticalTranslateLayout.this.mAnimator.animateTopOpen(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.mMeasuredHeight - VerticalTranslateLayout.this.mBottomOffset) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.mAnimator.animateBottomOpen(f);
                } else {
                    VerticalTranslateLayout.this.mAnimator.animateBottom(f);
                }
            }
        }

        private void topFling(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.mAnimator.animateTop(f);
            } else {
                VerticalTranslateLayout.this.mAnimator.animateTopOpen(f);
            }
        }

        private void bottomFling(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.mAnimator.animateBottomOpen(f);
            } else {
                VerticalTranslateLayout.this.mAnimator.animateBottom(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
            this.kVelocity = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.iAnimatingPosition = ((((float) (uptimeMillis - this.iLastAnimationTime)) / 1000.0f) * this.iAnimatingVelocity) + this.iAnimatingPosition;
            this.iLastAnimationTime = uptimeMillis;
            this.iCurrentAnimationTime += 16;
        }

        void computeTopAnimation() {
            compute();
            if (this.iAnimatingPosition <= this.iAnimationDistance) {
                OnTopAnimationListener onTopAnimationListener = VerticalTranslateLayout.this.mOnTopAnimationListener;
                if (onTopAnimationListener != null) {
                    onTopAnimationListener.onTopAnimationEnd();
                }
                this.iAnimating = false;
                VerticalTranslateLayout.this.mPositionState = 10000;
                VerticalTranslateLayout.this.offset();
                return;
            }
            VerticalTranslateLayout.this.mTopTranslate = (int) (AnimationConfig.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-100, this.iCurrentAnimationTime);
        }

        void computeBottomAnimation() {
            compute();
            if (this.iAnimatingPosition >= this.iAnimationDistance) {
                OnBottomAnimationListener onBottomAnimationListener = VerticalTranslateLayout.this.mOnBottomAnimationListener;
                if (onBottomAnimationListener != null) {
                    onBottomAnimationListener.onBottomAnimationEnd();
                }
                this.iAnimating = false;
                VerticalTranslateLayout.this.mPositionState = 10001;
                VerticalTranslateLayout.this.offset();
                return;
            }
            VerticalTranslateLayout.this.mTopTranslate = (int) (AnimationConfig.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-101, this.iCurrentAnimationTime);
        }

        void computeTopOpenAnimation() {
            compute();
            if (this.iAnimatingPosition >= this.iAnimationDistance) {
                for (OnOpenAnimationListener onOpenAnimationListener : VerticalTranslateLayout.this.mOnOpenAnimationListener) {
                    if (onOpenAnimationListener != null) {
                        onOpenAnimationListener.onOpenAnimationEnd();
                    }
                }
                this.iAnimating = false;
                VerticalTranslateLayout.this.mPositionState = 10004;
                VerticalTranslateLayout.this.offset();
                return;
            }
            VerticalTranslateLayout.this.mTopTranslate = (int) (AnimationConfig.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-104, this.iCurrentAnimationTime);
        }

        void computeBottomOpenAnimation() {
            compute();
            if (this.iAnimatingPosition <= this.iAnimationDistance) {
                for (OnOpenAnimationListener onOpenAnimationListener : VerticalTranslateLayout.this.mOnOpenAnimationListener) {
                    if (onOpenAnimationListener != null) {
                        onOpenAnimationListener.onOpenAnimationEnd();
                    }
                }
                this.iAnimating = false;
                VerticalTranslateLayout.this.mPositionState = 10004;
                VerticalTranslateLayout.this.offset();
                return;
            }
            VerticalTranslateLayout.this.mTopTranslate = (int) (AnimationConfig.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-105, this.iCurrentAnimationTime);
        }

        void animateTopOpen(float f) {
            for (OnOpenAnimationListener onOpenAnimationListener : VerticalTranslateLayout.this.mOnOpenAnimationListener) {
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
            this.iAnimationDistance = 0 - VerticalTranslateLayout.this.mTopTranslate;
            this.iAnimationStart = VerticalTranslateLayout.this.mTopTranslate;
            VerticalTranslateLayout.this.mHandler.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.iAnimationDistance);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-104, this.iCurrentAnimationTime);
        }

        void animateBottomOpen(float f) {
            for (OnOpenAnimationListener onOpenAnimationListener : VerticalTranslateLayout.this.mOnOpenAnimationListener) {
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
            this.iAnimationDistance = 0 - VerticalTranslateLayout.this.mTopTranslate;
            this.iAnimationStart = VerticalTranslateLayout.this.mTopTranslate;
            BdLog.d("Animator@animateBottomOpen " + this.iAnimationDistance);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.mHandler.removeMessages(-105);
            VerticalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-105, this.iCurrentAnimationTime);
        }

        void animateTop(float f) {
            OnTopAnimationListener onTopAnimationListener = VerticalTranslateLayout.this.mOnTopAnimationListener;
            if (onTopAnimationListener != null) {
                onTopAnimationListener.onLeftAnimationStart();
            }
            this.iAnimating = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.iLastAnimationTime = uptimeMillis;
            this.iCurrentAnimationTime = uptimeMillis + 16;
            this.iAnimatingVelocity = f;
            this.iAnimatingPosition = 0.0f;
            this.iAnimationDistance = ((-VerticalTranslateLayout.this.mMeasuredHeight) + VerticalTranslateLayout.this.mTopOffset) - VerticalTranslateLayout.this.mTopTranslate;
            this.iAnimationStart = VerticalTranslateLayout.this.mTopTranslate;
            BdLog.d("Animator@animateTop " + this.iAnimationDistance);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.mHandler.removeMessages(-100);
            VerticalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-100, this.iCurrentAnimationTime);
        }

        void animateBottom(float f) {
            OnBottomAnimationListener onBottomAnimationListener = VerticalTranslateLayout.this.mOnBottomAnimationListener;
            if (onBottomAnimationListener != null) {
                onBottomAnimationListener.onRightAnimationStart();
            }
            this.iAnimating = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.iLastAnimationTime = uptimeMillis;
            this.iCurrentAnimationTime = uptimeMillis + 16;
            this.iAnimatingVelocity = f;
            this.iAnimatingPosition = 0.0f;
            this.iAnimationDistance = (VerticalTranslateLayout.this.mMeasuredHeight - VerticalTranslateLayout.this.mBottomOffset) - VerticalTranslateLayout.this.mTopTranslate;
            this.iAnimationStart = VerticalTranslateLayout.this.mTopTranslate;
            BdLog.d("Animator@animateBottom " + this.iAnimationDistance);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.mHandler.removeMessages(-101);
            VerticalTranslateLayout.this.mHandler.sendEmptyMessageAtTime(-101, this.iCurrentAnimationTime);
        }
    }

    public void dump() {
        BdLog.d("VerticalTranslateLayout@dump top offset " + this.mTopOffset);
        BdLog.d("VerticalTranslateLayout@dump bottom offset " + this.mBottomOffset);
        BdLog.d("VerticalTranslateLayout@dump track " + this.mTrackDirection);
        BdLog.d("VerticalTranslateLayout@dump top tap " + this.mTopTapBack);
        BdLog.d("VerticalTranslateLayout@dump bottom tap " + this.mBottomOffset);
    }
}
