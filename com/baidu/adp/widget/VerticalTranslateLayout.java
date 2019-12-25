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
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private TrackDirection BB;
    private final a BC;
    private final b BD;
    private final g BE;
    private e BF;
    private c BG;
    private f BH;
    private final Paint mBackgroundPaint;
    private final Rect mBottomFrameForTap;
    private float mBottomHeight;
    private float mBottomOffset;
    private boolean mBottomTapBack;
    private int mLastDownX;
    private int mLastDownY;
    private int mLastMoveY;
    private boolean mLastMoveYBeenSet;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private final List<d> mOnOpenAnimationListener;
    private int mPositionState;
    private final Rect mTopFrameForTap;
    private float mTopHeight;
    private float mTopOffset;
    private boolean mTopTapBack;
    private int mTopTranslate;
    private final int mTouchThreshold;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void onBottomAnimationEnd();

        void onRightAnimationStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void onOpenAnimationEnd();

        void onOpenAnimationStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void onLeftAnimationStart();

        void onTopAnimationEnd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void onStartVerticalTrack(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mTopFrameForTap = new Rect();
        this.mBottomFrameForTap = new Rect();
        this.mOnOpenAnimationListener = new ArrayList();
        this.BC = new a();
        this.BD = new b();
        this.BE = new g();
        this.mPositionState = 10004;
        Resources resources = getResources();
        this.mBackgroundPaint = new Paint();
        this.mBackgroundPaint.setColor(-1);
        this.mTouchThreshold = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        loadAttrs(attributeSet);
    }

    private void loadAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.mTopOffset = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.mBottomOffset = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.mTopHeight = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.mBottomHeight = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (canTop() && canBottom() && com.baidu.live.adp.widget.VerticalTranslateLayout.VERTICAL.equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.BB = TrackDirection.vertical;
            } else if (canBottom() && com.baidu.live.adp.widget.VerticalTranslateLayout.BOTTOM.equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.BB = TrackDirection.bottom;
            } else if (canTop() && com.baidu.live.adp.widget.VerticalTranslateLayout.TOP.equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.BB = TrackDirection.top;
            } else {
                this.BB = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if (com.baidu.live.adp.widget.VerticalTranslateLayout.TOP.equals(str) && this.mTopOffset != -1.0f) {
                    this.mTopTapBack = true;
                } else if (com.baidu.live.adp.widget.VerticalTranslateLayout.BOTTOM.equals(str) && this.mBottomOffset != -1.0f) {
                    this.mBottomTapBack = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.mBackgroundPaint.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
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
                this.mTopTranslate = (int) ((this.mTopOffset - this.mMeasuredHeight) * (-f2));
            } else if (f2 > 0.0f) {
                this.mTopTranslate = (int) ((this.mMeasuredHeight - this.mBottomOffset) * f2);
            } else if (f2 == 0.0f) {
                this.mTopTranslate = 0;
                this.mPositionState = 10004;
            } else if (f2 == -1.0f) {
                this.mTopOffset -= this.mMeasuredHeight;
                this.mPositionState = 10000;
            } else if (f2 == 1.0f) {
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

    public void setTopTapBack(boolean z) {
        this.mTopTapBack = z;
    }

    public void setBottomTapBack(boolean z) {
        this.mBottomTapBack = z;
    }

    public int getState() {
        return this.mPositionState;
    }

    public void setTopAnimationListener(e eVar) {
        this.BF = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.BG = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.BH = fVar;
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

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.BB == TrackDirection.none) {
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
                    this.BC.removeMessages(-100);
                    this.BC.removeMessages(-104);
                    this.BC.removeMessages(-101);
                    this.BC.removeMessages(-105);
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
        return i >= this.mLastDownX - this.mTouchThreshold && i <= this.mLastDownX + this.mTouchThreshold && (i2 < this.mLastDownY - this.mTouchThreshold || i2 > this.mLastDownY + this.mTouchThreshold) && this.BE.prepareTracking(i2 - this.mLastDownY);
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
                    if (this.BE.tracking) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.BE.stopTracking();
                        this.BE.fling();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.BE.tracking) {
                        if (!this.mLastMoveYBeenSet) {
                            if (y > this.mLastDownY) {
                                this.mLastMoveY = this.mLastDownY + this.mTouchThreshold;
                                this.mLastMoveYBeenSet = true;
                            } else {
                                this.mLastMoveY = this.mLastDownY - this.mTouchThreshold;
                                this.mLastMoveYBeenSet = true;
                            }
                        }
                        this.BE.move(this.mLastMoveY - y);
                        this.mLastMoveY = y;
                        this.BE.velocityTracker.addMovement(motionEvent);
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
                if (!this.BE.tracking) {
                    this.mLastMoveY = y;
                    this.BE.prepareTracking(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.BE.tracking) {
                    this.BE.stopTracking();
                    this.BE.fling();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.BE.tracking) {
            this.BE.move(this.mLastMoveY - y);
            this.mLastMoveY = y;
            this.BE.velocityTracker.addMovement(motionEvent);
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
        if (!this.BD.iAnimating && !this.BE.tracking) {
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
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (VerticalTranslateLayout.this.BD.iAnimating) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.BD.computeBottomOpenAnimation();
                        return;
                    case -104:
                        VerticalTranslateLayout.this.BD.computeTopOpenAnimation();
                        return;
                    case SapiErrorCode.INVALID_ARG /* -103 */:
                    case -102:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.BD.computeBottomAnimation();
                        return;
                    case -100:
                        VerticalTranslateLayout.this.BD.computeTopAnimation();
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
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.velocityUnit = (int) ((200.0f * f) + 0.5f);
            this.minVelocity = (int) ((f * 500.0f) + 0.5f);
        }

        boolean prepareTracking(int i) {
            switch (VerticalTranslateLayout.this.BB) {
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
                    if (VerticalTranslateLayout.this.BH != null) {
                        VerticalTranslateLayout.this.BH.onStartVerticalTrack(i);
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
                switch (VerticalTranslateLayout.this.BB) {
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
            switch (VerticalTranslateLayout.this.BB) {
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
                    VerticalTranslateLayout.this.BD.animateTop(f);
                } else {
                    VerticalTranslateLayout.this.BD.animateTopOpen(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.mMeasuredHeight - VerticalTranslateLayout.this.mBottomOffset) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.BD.animateBottomOpen(f);
                } else {
                    VerticalTranslateLayout.this.BD.animateBottom(f);
                }
            }
        }

        private void topFling(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.BD.animateTop(f);
            } else {
                VerticalTranslateLayout.this.BD.animateTopOpen(f);
            }
        }

        private void bottomFling(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.BD.animateBottomOpen(f);
            } else {
                VerticalTranslateLayout.this.BD.animateBottom(f);
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
                e eVar = VerticalTranslateLayout.this.BF;
                if (eVar != null) {
                    eVar.onTopAnimationEnd();
                }
                this.iAnimating = false;
                VerticalTranslateLayout.this.mPositionState = 10000;
                VerticalTranslateLayout.this.offset();
                return;
            }
            VerticalTranslateLayout.this.mTopTranslate = (int) (com.baidu.adp.widget.a.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.BC.sendEmptyMessageAtTime(-100, this.iCurrentAnimationTime);
        }

        void computeBottomAnimation() {
            compute();
            if (this.iAnimatingPosition >= this.iAnimationDistance) {
                c cVar = VerticalTranslateLayout.this.BG;
                if (cVar != null) {
                    cVar.onBottomAnimationEnd();
                }
                this.iAnimating = false;
                VerticalTranslateLayout.this.mPositionState = 10001;
                VerticalTranslateLayout.this.offset();
                return;
            }
            VerticalTranslateLayout.this.mTopTranslate = (int) (com.baidu.adp.widget.a.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.BC.sendEmptyMessageAtTime(-101, this.iCurrentAnimationTime);
        }

        void computeTopOpenAnimation() {
            compute();
            if (this.iAnimatingPosition >= this.iAnimationDistance) {
                for (d dVar : VerticalTranslateLayout.this.mOnOpenAnimationListener) {
                    if (dVar != null) {
                        dVar.onOpenAnimationEnd();
                    }
                }
                this.iAnimating = false;
                VerticalTranslateLayout.this.mPositionState = 10004;
                VerticalTranslateLayout.this.offset();
                return;
            }
            VerticalTranslateLayout.this.mTopTranslate = (int) (com.baidu.adp.widget.a.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.BC.sendEmptyMessageAtTime(-104, this.iCurrentAnimationTime);
        }

        void computeBottomOpenAnimation() {
            compute();
            if (this.iAnimatingPosition <= this.iAnimationDistance) {
                for (d dVar : VerticalTranslateLayout.this.mOnOpenAnimationListener) {
                    if (dVar != null) {
                        dVar.onOpenAnimationEnd();
                    }
                }
                this.iAnimating = false;
                VerticalTranslateLayout.this.mPositionState = 10004;
                VerticalTranslateLayout.this.offset();
                return;
            }
            VerticalTranslateLayout.this.mTopTranslate = (int) (com.baidu.adp.widget.a.computeInterpolator(this.iAnimationDistance, this.iAnimatingPosition, false) + this.iAnimationStart);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.BC.sendEmptyMessageAtTime(-105, this.iCurrentAnimationTime);
        }

        void animateTopOpen(float f) {
            for (d dVar : VerticalTranslateLayout.this.mOnOpenAnimationListener) {
                if (dVar != null) {
                    dVar.onOpenAnimationStart();
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
            VerticalTranslateLayout.this.BC.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.iAnimationDistance);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.BC.sendEmptyMessageAtTime(-104, this.iCurrentAnimationTime);
        }

        void animateBottomOpen(float f) {
            for (d dVar : VerticalTranslateLayout.this.mOnOpenAnimationListener) {
                if (dVar != null) {
                    dVar.onOpenAnimationStart();
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
            VerticalTranslateLayout.this.BC.removeMessages(-105);
            VerticalTranslateLayout.this.BC.sendEmptyMessageAtTime(-105, this.iCurrentAnimationTime);
        }

        void animateTop(float f) {
            e eVar = VerticalTranslateLayout.this.BF;
            if (eVar != null) {
                eVar.onLeftAnimationStart();
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
            VerticalTranslateLayout.this.BC.removeMessages(-100);
            VerticalTranslateLayout.this.BC.sendEmptyMessageAtTime(-100, this.iCurrentAnimationTime);
        }

        void animateBottom(float f) {
            c cVar = VerticalTranslateLayout.this.BG;
            if (cVar != null) {
                cVar.onRightAnimationStart();
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
            VerticalTranslateLayout.this.BC.removeMessages(-101);
            VerticalTranslateLayout.this.BC.sendEmptyMessageAtTime(-101, this.iCurrentAnimationTime);
        }
    }
}
