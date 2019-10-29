package com.baidu.live.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.adp.R;
/* loaded from: classes6.dex */
public class IndicatorView extends View {
    private static final int DEFAULT_SPACING = 5;
    private static final String TAG = "IndicatorView$IndicatorView";
    private boolean mAutoHide;
    private int mCount;
    private Drawable mDrawable;
    private float mPosition;
    private Drawable mSelector;
    private int mSpacing;
    private float mTargetPosition;
    private final ViewInjector mViewInjector;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mViewInjector = new HorizontalViewInjector();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sdk_IndicatorView);
        this.mSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sdk_IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(R.styleable.sdk_IndicatorView_count, 0);
        this.mDrawable = obtainStyledAttributes.getDrawable(R.styleable.sdk_IndicatorView_drawable);
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(0, 0, this.mDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }
        this.mSelector = obtainStyledAttributes.getDrawable(R.styleable.sdk_IndicatorView_selector);
        if (this.mSelector != null) {
            this.mSelector.setBounds(0, 0, this.mSelector.getIntrinsicWidth(), this.mSelector.getIntrinsicHeight());
        }
        this.mAutoHide = obtainStyledAttributes.getBoolean(R.styleable.sdk_IndicatorView_autoHide, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mViewInjector.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mViewInjector.draw(canvas);
    }

    public boolean isAutoHide() {
        return this.mAutoHide;
    }

    public void setAutoHide(boolean z) {
        this.mAutoHide = z;
    }

    public void setDrawable(Drawable drawable) {
        this.mDrawable = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public void setSelector(Drawable drawable) {
        this.mSelector = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.mSelector;
    }

    public void setSpacing(int i) {
        this.mSpacing = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.mSpacing;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setCount(int i) {
        this.mCount = i;
        requestLayout();
        invalidate();
    }

    public void setPosition(float f) {
        this.mPosition = f;
        invalidate();
    }

    public float getPosition() {
        return this.mPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class HorizontalViewInjector implements ViewInjector {
        private boolean animating;
        private float animatingPosition;
        private int animatingVelocity;
        private long currentAnimatingTime;
        private final AnimationHandler handler = new AnimationHandler();
        private final int kVelocity;
        private long lastAnimationTime;

        HorizontalViewInjector() {
            this.kVelocity = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public void measure(int i, int i2) {
            if (IndicatorView.this.mDrawable == null || IndicatorView.this.mSelector == null || IndicatorView.this.mCount == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(measureWidth(i), measureHeight(i2));
        }

        private int measureWidth(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.mSpacing * (IndicatorView.this.mCount - 1)) + (Math.max(IndicatorView.this.mDrawable.getIntrinsicWidth(), IndicatorView.this.mSelector.getIntrinsicWidth()) * IndicatorView.this.mCount);
            switch (i2) {
                case Integer.MIN_VALUE:
                    int min = Math.min(i3, max);
                    IndicatorView.this.mDrawable.setBounds(0, 0, IndicatorView.this.mDrawable.getIntrinsicWidth(), IndicatorView.this.mDrawable.getBounds().height());
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getIntrinsicWidth(), IndicatorView.this.mSelector.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.mDrawable.setBounds(0, 0, IndicatorView.this.mDrawable.getIntrinsicWidth(), 0);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.mSpacing * (IndicatorView.this.mCount - 1))) / IndicatorView.this.mCount);
                    IndicatorView.this.mSelector.setBounds(0, 0, i4, IndicatorView.this.mSelector.getBounds().height());
                    IndicatorView.this.mDrawable.setBounds(0, 0, i4, IndicatorView.this.mDrawable.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int measureHeight(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.mDrawable.getIntrinsicHeight(), IndicatorView.this.mSelector.getIntrinsicHeight());
            switch (i2) {
                case Integer.MIN_VALUE:
                    int min = Math.min(i3, max);
                    IndicatorView.this.mDrawable.setBounds(0, 0, IndicatorView.this.mDrawable.getBounds().width(), min);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.mDrawable.setBounds(0, 0, IndicatorView.this.mDrawable.getBounds().width(), max);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.mDrawable.setBounds(0, 0, IndicatorView.this.mDrawable.getBounds().width(), i3);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.mCount; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.mDrawable.getBounds().width() + IndicatorView.this.mSpacing, 0.0f);
                }
                IndicatorView.this.mDrawable.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.mSelector.getBounds().width() + IndicatorView.this.mSpacing) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.mSelector.draw(canvas);
            canvas.restoreToCount(save2);
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean interceptionTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean touchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public void animate(int i) {
            if (IndicatorView.this.mTargetPosition <= IndicatorView.this.mPosition) {
                if (IndicatorView.this.mTargetPosition < IndicatorView.this.mPosition) {
                    this.animatingVelocity = -this.kVelocity;
                } else {
                    return;
                }
            } else {
                this.animatingVelocity = this.kVelocity;
            }
            this.animatingPosition = IndicatorView.this.mPosition;
            this.lastAnimationTime = SystemClock.uptimeMillis();
            this.currentAnimatingTime = this.lastAnimationTime + 16;
            this.handler.removeMessages(1000);
            this.handler.sendEmptyMessageAtTime(1000, this.currentAnimatingTime);
        }

        @Override // com.baidu.live.adp.widget.ViewInjector
        public boolean isAnimating() {
            return this.animating;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.animatingPosition = ((((float) (uptimeMillis - this.lastAnimationTime)) / 1000.0f) * this.animatingVelocity) + this.animatingPosition;
            this.lastAnimationTime = uptimeMillis;
            this.currentAnimatingTime = this.lastAnimationTime + 16;
            if (this.animatingVelocity < 0) {
                if (this.animatingPosition < IndicatorView.this.mTargetPosition) {
                    IndicatorView.this.mPosition = IndicatorView.this.mTargetPosition;
                    this.animating = false;
                } else {
                    IndicatorView.this.mPosition = this.animatingPosition;
                    this.handler.removeMessages(1000);
                    this.handler.sendEmptyMessageAtTime(1000, this.currentAnimatingTime);
                }
            } else if (this.animatingPosition > IndicatorView.this.mTargetPosition) {
                IndicatorView.this.mPosition = IndicatorView.this.mTargetPosition;
                this.animating = false;
            } else {
                IndicatorView.this.mPosition = this.animatingPosition;
                this.handler.removeMessages(1000);
                this.handler.sendEmptyMessageAtTime(1000, this.currentAnimatingTime);
            }
            IndicatorView.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes6.dex */
        public class AnimationHandler extends Handler {
            private static final int MSG_ANIMATE = 1000;

            private AnimationHandler() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1000:
                        HorizontalViewInjector.this.compute();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
