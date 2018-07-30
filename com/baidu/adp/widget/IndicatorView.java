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
/* loaded from: classes.dex */
public class IndicatorView extends View {
    private boolean KW;
    private int KX;
    private float KY;
    private final f KZ;
    private int mCount;
    private Drawable mDrawable;
    private float mPosition;
    private Drawable mSelector;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KZ = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.KX = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        this.mDrawable = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(0, 0, this.mDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }
        this.mSelector = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        if (this.mSelector != null) {
            this.mSelector.setBounds(0, 0, this.mSelector.getIntrinsicWidth(), this.mSelector.getIntrinsicHeight());
        }
        this.KW = obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.KZ.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.KZ.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.KW = z;
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
        this.KX = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.KX;
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
        private final int La;
        private long Lb;
        private long Lc;
        private int Ld;
        private float Le;
        private boolean Lf;
        private final HandlerC0024a Lg = new HandlerC0024a();

        a() {
            this.La = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            if (IndicatorView.this.mDrawable == null || IndicatorView.this.mSelector == null || IndicatorView.this.mCount == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(aG(i), aH(i2));
        }

        private int aG(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.KX * (IndicatorView.this.mCount - 1)) + (Math.max(IndicatorView.this.mDrawable.getIntrinsicWidth(), IndicatorView.this.mSelector.getIntrinsicWidth()) * IndicatorView.this.mCount);
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
                    int i4 = (int) ((i3 - (IndicatorView.this.KX * (IndicatorView.this.mCount - 1))) / IndicatorView.this.mCount);
                    IndicatorView.this.mSelector.setBounds(0, 0, i4, IndicatorView.this.mSelector.getBounds().height());
                    IndicatorView.this.mDrawable.setBounds(0, 0, i4, IndicatorView.this.mDrawable.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aH(int i) {
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

        @Override // com.baidu.adp.widget.f
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.mCount; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.mDrawable.getBounds().width() + IndicatorView.this.KX, 0.0f);
                }
                IndicatorView.this.mDrawable.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.mSelector.getBounds().width() + IndicatorView.this.KX) * IndicatorView.this.mPosition, 0.0f);
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
        public void aI(int i) {
            if (IndicatorView.this.KY <= IndicatorView.this.mPosition) {
                if (IndicatorView.this.KY < IndicatorView.this.mPosition) {
                    this.Ld = -this.La;
                } else {
                    return;
                }
            } else {
                this.Ld = this.La;
            }
            this.Le = IndicatorView.this.mPosition;
            this.Lb = SystemClock.uptimeMillis();
            this.Lc = this.Lb + 16;
            this.Lg.removeMessages(1000);
            this.Lg.sendEmptyMessageAtTime(1000, this.Lc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Le = ((((float) (uptimeMillis - this.Lb)) / 1000.0f) * this.Ld) + this.Le;
            this.Lb = uptimeMillis;
            this.Lc = this.Lb + 16;
            if (this.Ld < 0) {
                if (this.Le < IndicatorView.this.KY) {
                    IndicatorView.this.mPosition = IndicatorView.this.KY;
                    this.Lf = false;
                } else {
                    IndicatorView.this.mPosition = this.Le;
                    this.Lg.removeMessages(1000);
                    this.Lg.sendEmptyMessageAtTime(1000, this.Lc);
                }
            } else if (this.Le > IndicatorView.this.KY) {
                IndicatorView.this.mPosition = IndicatorView.this.KY;
                this.Lf = false;
            } else {
                IndicatorView.this.mPosition = this.Le;
                this.Lg.removeMessages(1000);
                this.Lg.sendEmptyMessageAtTime(1000, this.Lc);
            }
            IndicatorView.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.adp.widget.IndicatorView$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0024a extends Handler {
            private HandlerC0024a() {
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
