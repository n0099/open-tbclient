package com.baidu.adp.widget;

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
import com.baidu.adp.R;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
/* loaded from: classes.dex */
public class IndicatorView extends View {
    private boolean NP;
    private float NQ;
    private final f NR;
    private int mCount;
    private Drawable mDrawable;
    private float mPosition;
    private Drawable mSelector;
    private int mSpacing;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NR = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.mSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        this.mDrawable = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(0, 0, this.mDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }
        this.mSelector = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        if (this.mSelector != null) {
            this.mSelector.setBounds(0, 0, this.mSelector.getIntrinsicWidth(), this.mSelector.getIntrinsicHeight());
        }
        this.NP = obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.NR.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.NR.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.NP = z;
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
    /* loaded from: classes.dex */
    public class a implements f {
        private final int NT;
        private long NU;
        private long NV;
        private int NW;
        private float NX;
        private boolean NY;
        private final HandlerC0027a NZ = new HandlerC0027a();

        a() {
            this.NT = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            if (IndicatorView.this.mDrawable == null || IndicatorView.this.mSelector == null || IndicatorView.this.mCount == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(aQ(i), aR(i2));
        }

        private int aQ(int i) {
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
                case AiAppsFileUtils.GB /* 1073741824 */:
                    int i4 = (int) ((i3 - (IndicatorView.this.mSpacing * (IndicatorView.this.mCount - 1))) / IndicatorView.this.mCount);
                    IndicatorView.this.mSelector.setBounds(0, 0, i4, IndicatorView.this.mSelector.getBounds().height());
                    IndicatorView.this.mDrawable.setBounds(0, 0, i4, IndicatorView.this.mDrawable.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aR(int i) {
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
                case AiAppsFileUtils.GB /* 1073741824 */:
                    IndicatorView.this.mDrawable.setBounds(0, 0, IndicatorView.this.mDrawable.getBounds().width(), i3);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.f
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

        @Override // com.baidu.adp.widget.f
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.adp.widget.f
        public boolean l(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.adp.widget.f
        public boolean m(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.adp.widget.f
        public void aS(int i) {
            if (IndicatorView.this.NQ <= IndicatorView.this.mPosition) {
                if (IndicatorView.this.NQ < IndicatorView.this.mPosition) {
                    this.NW = -this.NT;
                } else {
                    return;
                }
            } else {
                this.NW = this.NT;
            }
            this.NX = IndicatorView.this.mPosition;
            this.NU = SystemClock.uptimeMillis();
            this.NV = this.NU + 16;
            this.NZ.removeMessages(1000);
            this.NZ.sendEmptyMessageAtTime(1000, this.NV);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NX = ((((float) (uptimeMillis - this.NU)) / 1000.0f) * this.NW) + this.NX;
            this.NU = uptimeMillis;
            this.NV = this.NU + 16;
            if (this.NW < 0) {
                if (this.NX < IndicatorView.this.NQ) {
                    IndicatorView.this.mPosition = IndicatorView.this.NQ;
                    this.NY = false;
                } else {
                    IndicatorView.this.mPosition = this.NX;
                    this.NZ.removeMessages(1000);
                    this.NZ.sendEmptyMessageAtTime(1000, this.NV);
                }
            } else if (this.NX > IndicatorView.this.NQ) {
                IndicatorView.this.mPosition = IndicatorView.this.NQ;
                this.NY = false;
            } else {
                IndicatorView.this.mPosition = this.NX;
                this.NZ.removeMessages(1000);
                this.NZ.sendEmptyMessageAtTime(1000, this.NV);
            }
            IndicatorView.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.adp.widget.IndicatorView$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0027a extends Handler {
            private HandlerC0027a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1000:
                        a.this.compute();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
