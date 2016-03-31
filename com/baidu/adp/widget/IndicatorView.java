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
    private boolean Hu;
    private int Hv;
    private float Hw;
    private Drawable Hx;
    private Drawable Hy;
    private final j Hz;
    private float mPosition;
    private int xj;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Hz = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.Hv = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.xj = obtainStyledAttributes.getInteger(4, 0);
        this.Hx = obtainStyledAttributes.getDrawable(1);
        if (this.Hx != null) {
            this.Hx.setBounds(0, 0, this.Hx.getIntrinsicWidth(), this.Hx.getIntrinsicHeight());
        }
        this.Hy = obtainStyledAttributes.getDrawable(2);
        if (this.Hy != null) {
            this.Hy.setBounds(0, 0, this.Hy.getIntrinsicWidth(), this.Hy.getIntrinsicHeight());
        }
        this.Hu = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Hz.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Hz.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.Hu = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Hx = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Hx;
    }

    public void setSelector(Drawable drawable) {
        this.Hy = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.Hy;
    }

    public void setSpacing(int i) {
        this.Hv = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.Hv;
    }

    public int getCount() {
        return this.xj;
    }

    public void setCount(int i) {
        this.xj = i;
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
    public class a implements j {
        private final int HA;
        private long HB;
        private long HC;
        private int HD;
        private float HE;
        private boolean HF;
        private final HandlerC0014a HG = new HandlerC0014a(this, null);

        a() {
            this.HA = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.Hx == null || IndicatorView.this.Hy == null || IndicatorView.this.xj == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(aD(i), aE(i2));
        }

        private int aD(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.Hv * (IndicatorView.this.xj - 1)) + (Math.max(IndicatorView.this.Hx.getIntrinsicWidth(), IndicatorView.this.Hy.getIntrinsicWidth()) * IndicatorView.this.xj);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Hx.setBounds(0, 0, IndicatorView.this.Hx.getIntrinsicWidth(), IndicatorView.this.Hx.getBounds().height());
                    IndicatorView.this.Hy.setBounds(0, 0, IndicatorView.this.Hy.getIntrinsicWidth(), IndicatorView.this.Hy.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.Hx.setBounds(0, 0, IndicatorView.this.Hx.getIntrinsicWidth(), 0);
                    IndicatorView.this.Hy.setBounds(0, 0, IndicatorView.this.Hy.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.Hv * (IndicatorView.this.xj - 1))) / IndicatorView.this.xj);
                    IndicatorView.this.Hy.setBounds(0, 0, i4, IndicatorView.this.Hy.getBounds().height());
                    IndicatorView.this.Hx.setBounds(0, 0, i4, IndicatorView.this.Hx.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aE(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.Hx.getIntrinsicHeight(), IndicatorView.this.Hy.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Hx.setBounds(0, 0, IndicatorView.this.Hx.getBounds().width(), min);
                    IndicatorView.this.Hy.setBounds(0, 0, IndicatorView.this.Hy.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.Hx.setBounds(0, 0, IndicatorView.this.Hx.getBounds().width(), max);
                    IndicatorView.this.Hy.setBounds(0, 0, IndicatorView.this.Hy.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.Hx.setBounds(0, 0, IndicatorView.this.Hx.getBounds().width(), i3);
                    IndicatorView.this.Hy.setBounds(0, 0, IndicatorView.this.Hy.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.j
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.xj; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.Hx.getBounds().width() + IndicatorView.this.Hv, 0.0f);
                }
                IndicatorView.this.Hx.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.Hy.getBounds().width() + IndicatorView.this.Hv) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.Hy.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.HE = ((((float) (uptimeMillis - this.HB)) / 1000.0f) * this.HD) + this.HE;
            this.HB = uptimeMillis;
            this.HC = this.HB + 16;
            if (this.HD < 0) {
                if (this.HE < IndicatorView.this.Hw) {
                    IndicatorView.this.mPosition = IndicatorView.this.Hw;
                    this.HF = false;
                } else {
                    IndicatorView.this.mPosition = this.HE;
                    this.HG.removeMessages(1000);
                    this.HG.sendEmptyMessageAtTime(1000, this.HC);
                }
            } else if (this.HE > IndicatorView.this.Hw) {
                IndicatorView.this.mPosition = IndicatorView.this.Hw;
                this.HF = false;
            } else {
                IndicatorView.this.mPosition = this.HE;
                this.HG.removeMessages(1000);
                this.HG.sendEmptyMessageAtTime(1000, this.HC);
            }
            IndicatorView.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.adp.widget.IndicatorView$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0014a extends Handler {
            private HandlerC0014a() {
            }

            /* synthetic */ HandlerC0014a(a aVar, HandlerC0014a handlerC0014a) {
                this();
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
