package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class IndicatorView extends View {
    private boolean Gq;
    private int Gr;
    private float Gs;
    private Drawable Gt;
    private final f Gu;
    private int mCount;
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
        this.Gu = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.Gr = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        this.Gt = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        if (this.Gt != null) {
            this.Gt.setBounds(0, 0, this.Gt.getIntrinsicWidth(), this.Gt.getIntrinsicHeight());
        }
        this.mSelector = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        if (this.mSelector != null) {
            this.mSelector.setBounds(0, 0, this.mSelector.getIntrinsicWidth(), this.mSelector.getIntrinsicHeight());
        }
        this.Gq = obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Gu.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Gu.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.Gq = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Gt = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Gt;
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
        this.Gr = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.Gr;
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
        private boolean GA;
        private final HandlerC0013a GB = new HandlerC0013a();
        private final int Gv;
        private long Gw;
        private long Gx;
        private int Gy;
        private float Gz;

        a() {
            this.Gv = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            if (IndicatorView.this.Gt == null || IndicatorView.this.mSelector == null || IndicatorView.this.mCount == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(aJ(i), aK(i2));
        }

        private int aJ(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.Gr * (IndicatorView.this.mCount - 1)) + (Math.max(IndicatorView.this.Gt.getIntrinsicWidth(), IndicatorView.this.mSelector.getIntrinsicWidth()) * IndicatorView.this.mCount);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Gt.setBounds(0, 0, IndicatorView.this.Gt.getIntrinsicWidth(), IndicatorView.this.Gt.getBounds().height());
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getIntrinsicWidth(), IndicatorView.this.mSelector.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.Gt.setBounds(0, 0, IndicatorView.this.Gt.getIntrinsicWidth(), 0);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.Gr * (IndicatorView.this.mCount - 1))) / IndicatorView.this.mCount);
                    IndicatorView.this.mSelector.setBounds(0, 0, i4, IndicatorView.this.mSelector.getBounds().height());
                    IndicatorView.this.Gt.setBounds(0, 0, i4, IndicatorView.this.Gt.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aK(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.Gt.getIntrinsicHeight(), IndicatorView.this.mSelector.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Gt.setBounds(0, 0, IndicatorView.this.Gt.getBounds().width(), min);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.Gt.setBounds(0, 0, IndicatorView.this.Gt.getBounds().width(), max);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.Gt.setBounds(0, 0, IndicatorView.this.Gt.getBounds().width(), i3);
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
                    canvas.translate(IndicatorView.this.Gt.getBounds().width() + IndicatorView.this.Gr, 0.0f);
                }
                IndicatorView.this.Gt.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.mSelector.getBounds().width() + IndicatorView.this.Gr) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.mSelector.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ku() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gz = ((((float) (uptimeMillis - this.Gw)) / 1000.0f) * this.Gy) + this.Gz;
            this.Gw = uptimeMillis;
            this.Gx = this.Gw + 16;
            if (this.Gy < 0) {
                if (this.Gz < IndicatorView.this.Gs) {
                    IndicatorView.this.mPosition = IndicatorView.this.Gs;
                    this.GA = false;
                } else {
                    IndicatorView.this.mPosition = this.Gz;
                    this.GB.removeMessages(1000);
                    this.GB.sendEmptyMessageAtTime(1000, this.Gx);
                }
            } else if (this.Gz > IndicatorView.this.Gs) {
                IndicatorView.this.mPosition = IndicatorView.this.Gs;
                this.GA = false;
            } else {
                IndicatorView.this.mPosition = this.Gz;
                this.GB.removeMessages(1000);
                this.GB.sendEmptyMessageAtTime(1000, this.Gx);
            }
            IndicatorView.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.adp.widget.IndicatorView$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0013a extends Handler {
            private HandlerC0013a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1000:
                        a.this.ku();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
