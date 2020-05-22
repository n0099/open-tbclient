package com.baidu.adp.widget;

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
import com.baidu.adp.R;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.sapi2.result.OneKeyLoginResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private TrackDirection Tn;
    private final a To;
    private final b Tp;
    private final g Tq;
    private d Tr;
    private f Ts;
    private c Tt;
    private final Paint mBackgroundPaint;
    private int mLastDownX;
    private int mLastDownY;
    private int mLastMoveX;
    private boolean mLastMoveXBeenSet;
    private final Rect mLeftFrameForTap;
    private float mLeftOffset;
    private boolean mLeftTapBack;
    private int mLeftTranslate;
    private int mMeasuredWidth;
    private final List<e> mOnOpenAnimationListener;
    private int mPositionState;
    private final Rect mRightFrameForTap;
    private float mRightOffset;
    private boolean mRightTapBack;
    private final int mTouchThreshold;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void onStartHorizontalTrack(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void onLeftAnimationEnd();

        void onLeftAnimationStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void onOpenAnimationEnd();

        void onOpenAnimationStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void onRightAnimationEnd();

        void onRightAnimationStart();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mLeftFrameForTap = new Rect();
        this.mRightFrameForTap = new Rect();
        this.mOnOpenAnimationListener = new ArrayList();
        this.To = new a();
        this.Tp = new b();
        this.Tq = new g();
        this.mPositionState = 10004;
        Resources resources = getResources();
        this.mBackgroundPaint = new Paint();
        this.mBackgroundPaint.setColor(-1);
        this.mTouchThreshold = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        loadAttrs(attributeSet);
    }

    private void loadAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.mLeftOffset = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.mRightOffset = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.mLeftOffset != -1.0f && this.mRightOffset != -1.0f && com.baidu.live.adp.widget.HorizontalTranslateLayout.HORIZONTAL.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.Tn = TrackDirection.horizontal;
            } else if (this.mRightOffset != -1.0f && com.baidu.live.adp.widget.HorizontalTranslateLayout.DIRECTION_RIGHT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.Tn = TrackDirection.right;
            } else if (this.mLeftOffset != -1.0f && "left".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.Tn = TrackDirection.left;
            } else {
                this.Tn = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if ("left".equals(str) && this.mLeftOffset != -1.0f) {
                    this.mLeftTapBack = true;
                } else if (com.baidu.live.adp.widget.HorizontalTranslateLayout.DIRECTION_RIGHT.equals(str) && this.mRightOffset != -1.0f) {
                    this.mRightTapBack = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.mBackgroundPaint.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundPaint.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.mLeftTranslate = (int) ((this.mLeftOffset - this.mMeasuredWidth) * (-f2));
            } else if (f2 > 0.0f) {
                this.mLeftTranslate = (int) ((this.mMeasuredWidth - this.mRightOffset) * f2);
            } else if (f2 == 0.0f) {
                this.mLeftTranslate = 0;
                this.mPositionState = 10004;
            } else if (f2 == -1.0f) {
                this.mLeftOffset -= getMeasuredWidth();
                this.mPositionState = 10000;
            } else if (f2 == 1.0f) {
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

    public void setLeftTapBack(boolean z) {
        this.mLeftTapBack = z;
    }

    public void setRightTapBack(boolean z) {
        this.mRightTapBack = z;
    }

    public int getState() {
        return this.mPositionState;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Tr = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Ts = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Tt = cVar;
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

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Tn == TrackDirection.none) {
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
                    this.To.removeMessages(-100);
                    this.To.removeMessages(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
                    this.To.removeMessages(-101);
                    this.To.removeMessages(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL);
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
        return i2 >= this.mLastDownY - this.mTouchThreshold && i2 <= this.mLastDownY + this.mTouchThreshold && (i < this.mLastDownX - this.mTouchThreshold || i > this.mLastDownX + this.mTouchThreshold) && this.Tq.prepareTracking(i - this.mLastDownX);
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
                    if (this.Tq.tracking) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Tq.stopTracking();
                        this.Tq.fling();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Tq.tracking) {
                        if (!this.mLastMoveXBeenSet) {
                            if (x > this.mLastDownX) {
                                this.mLastMoveX = this.mLastDownX + this.mTouchThreshold;
                                this.mLastMoveXBeenSet = true;
                            } else {
                                this.mLastMoveX = this.mLastDownX - this.mTouchThreshold;
                                this.mLastMoveXBeenSet = true;
                            }
                        }
                        this.Tq.move(this.mLastMoveX - x);
                        this.mLastMoveX = x;
                        this.Tq.velocityTracker.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.mLeftFrameForTap);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.mRightFrameForTap);
        switch (action) {
            case 0:
                if ((this.mPositionState != 10000 || !this.mLeftFrameForTap.contains(x, y)) && (this.mPositionState != 10001 || !this.mRightFrameForTap.contains(x, y))) {
                    return false;
                }
                if (!this.Tq.tracking) {
                    this.mLastMoveX = x;
                    this.Tq.prepareTracking(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Tq.tracking) {
                    this.Tq.stopTracking();
                    this.Tq.fling();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Tq.tracking) {
            this.Tq.move(this.mLastMoveX - x);
            this.mLastMoveX = x;
            this.Tq.velocityTracker.addMovement(motionEvent);
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
        if (!this.Tp.iAnimating && !this.Tq.tracking) {
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
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (HorizontalTranslateLayout.this.Tp.iAnimating) {
                switch (message.what) {
                    case OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL /* -105 */:
                        HorizontalTranslateLayout.this.Tp.computeRightOpenAnimation();
                        return;
                    case OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS /* -104 */:
                        HorizontalTranslateLayout.this.Tp.computeLeftOpenAnimation();
                        return;
                    case -103:
                    case OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Tp.computeRightAnimation();
                        return;
                    case -100:
                        HorizontalTranslateLayout.this.Tp.computeLeftAnimation();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final int minVelocity;
        boolean tracking;
        VelocityTracker velocityTracker;
        final int velocityUnit;

        g() {
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.velocityUnit = (int) ((200.0f * f) + 0.5f);
            this.minVelocity = (int) ((f * 500.0f) + 0.5f);
        }

        boolean prepareTracking(int i) {
            switch (HorizontalTranslateLayout.this.Tn) {
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
                    if (HorizontalTranslateLayout.this.Tt != null) {
                        HorizontalTranslateLayout.this.Tt.onStartHorizontalTrack(i);
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
                switch (HorizontalTranslateLayout.this.Tn) {
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
            switch (HorizontalTranslateLayout.this.Tn) {
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
                    HorizontalTranslateLayout.this.Tp.animateLeft(f);
                } else {
                    HorizontalTranslateLayout.this.Tp.animateLeftOpen(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.mRightOffset) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Tp.animateRightOpen(f);
                } else {
                    HorizontalTranslateLayout.this.Tp.animateRight(f);
                }
            }
        }

        private void leftFling(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Tp.animateLeft(f);
            } else {
                HorizontalTranslateLayout.this.Tp.animateLeftOpen(f);
            }
        }

        private void rightFling(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Tp.animateRightOpen(f);
            } else {
                HorizontalTranslateLayout.this.Tp.animateRight(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        boolean iAnimating;
        float iAnimatingPosition;
        float iAnimatingVelocity;
        float iAnimationDistance;
        float iAnimationStart;
        long iCurrentAnimationTime;
        long iLastAnimationTime;
        final float kVelocity;

        b() {
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
                d dVar = HorizontalTranslateLayout.this.Tr;
                if (dVar != null) {
                    dVar.onLeftAnimationEnd();
                }
                this.iAnimating = false;
                HorizontalTranslateLayout.this.mPositionState = 10000;
                HorizontalTranslateLayout.this.offset();
                return;
            }
            HorizontalTranslateLayout.this.mLeftTranslate = (int) (com.baidu.adp.widget.d.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.To.sendEmptyMessageAtTime(-100, this.iCurrentAnimationTime);
        }

        void computeRightAnimation() {
            compute();
            if (this.iAnimatingPosition >= this.iAnimationDistance) {
                f fVar = HorizontalTranslateLayout.this.Ts;
                if (fVar != null) {
                    fVar.onRightAnimationEnd();
                }
                this.iAnimating = false;
                HorizontalTranslateLayout.this.mPositionState = 10001;
                HorizontalTranslateLayout.this.offset();
                return;
            }
            HorizontalTranslateLayout.this.mLeftTranslate = (int) (com.baidu.adp.widget.d.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.To.sendEmptyMessageAtTime(-101, this.iCurrentAnimationTime);
        }

        void computeLeftOpenAnimation() {
            compute();
            if (this.iAnimatingPosition >= this.iAnimationDistance) {
                for (e eVar : HorizontalTranslateLayout.this.mOnOpenAnimationListener) {
                    if (eVar != null) {
                        eVar.onOpenAnimationEnd();
                    }
                }
                this.iAnimating = false;
                HorizontalTranslateLayout.this.mPositionState = 10004;
                HorizontalTranslateLayout.this.offset();
                return;
            }
            HorizontalTranslateLayout.this.mLeftTranslate = (int) (com.baidu.adp.widget.d.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.To.sendEmptyMessageAtTime(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS, this.iCurrentAnimationTime);
        }

        void computeRightOpenAnimation() {
            compute();
            if (this.iAnimatingPosition <= this.iAnimationDistance) {
                for (e eVar : HorizontalTranslateLayout.this.mOnOpenAnimationListener) {
                    if (eVar != null) {
                        eVar.onOpenAnimationEnd();
                    }
                }
                this.iAnimating = false;
                HorizontalTranslateLayout.this.mPositionState = 10004;
                HorizontalTranslateLayout.this.offset();
                return;
            }
            HorizontalTranslateLayout.this.mLeftTranslate = (int) (com.baidu.adp.widget.d.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.To.sendEmptyMessageAtTime(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, this.iCurrentAnimationTime);
        }

        void animateLeftOpen(float f) {
            for (e eVar : HorizontalTranslateLayout.this.mOnOpenAnimationListener) {
                if (eVar != null) {
                    eVar.onOpenAnimationStart();
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
            HorizontalTranslateLayout.this.To.removeMessages(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
            BdLog.d("Animator@animateTopOpen " + this.iAnimationDistance);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.To.sendEmptyMessageAtTime(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS, this.iCurrentAnimationTime);
        }

        void animateRightOpen(float f) {
            for (e eVar : HorizontalTranslateLayout.this.mOnOpenAnimationListener) {
                if (eVar != null) {
                    eVar.onOpenAnimationStart();
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
            HorizontalTranslateLayout.this.To.removeMessages(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL);
            HorizontalTranslateLayout.this.To.sendEmptyMessageAtTime(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, this.iCurrentAnimationTime);
        }

        void animateLeft(float f) {
            d dVar = HorizontalTranslateLayout.this.Tr;
            if (dVar != null) {
                dVar.onLeftAnimationStart();
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
            HorizontalTranslateLayout.this.To.removeMessages(-100);
            HorizontalTranslateLayout.this.To.sendEmptyMessageAtTime(-100, this.iCurrentAnimationTime);
        }

        void animateRight(float f) {
            f fVar = HorizontalTranslateLayout.this.Ts;
            if (fVar != null) {
                fVar.onRightAnimationStart();
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
            HorizontalTranslateLayout.this.To.removeMessages(-101);
            HorizontalTranslateLayout.this.To.sendEmptyMessageAtTime(-101, this.iCurrentAnimationTime);
        }
    }
}
