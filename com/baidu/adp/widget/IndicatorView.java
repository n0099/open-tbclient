package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class IndicatorView extends View {
    private boolean aup;
    private int auq;
    private float aur;
    private final f aus;
    private int mCount;
    private float mPosition;
    private Drawable mSelector;
    private Drawable wz;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aus = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.auq = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        this.wz = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        if (this.wz != null) {
            this.wz.setBounds(0, 0, this.wz.getIntrinsicWidth(), this.wz.getIntrinsicHeight());
        }
        this.mSelector = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        if (this.mSelector != null) {
            this.mSelector.setBounds(0, 0, this.mSelector.getIntrinsicWidth(), this.mSelector.getIntrinsicHeight());
        }
        this.aup = obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.aus.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.aus.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.aup = z;
    }

    public void setDrawable(Drawable drawable) {
        this.wz = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.wz;
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
        this.auq = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.auq;
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
        private final int aut;
        private long auu;
        private long auv;
        private int auw;
        private float aux;
        private boolean auy;
        private final HandlerC0026a auz = new HandlerC0026a();

        a() {
            this.aut = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            if (IndicatorView.this.wz == null || IndicatorView.this.mSelector == null || IndicatorView.this.mCount == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(dD(i), dE(i2));
        }

        private int dD(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.auq * (IndicatorView.this.mCount - 1)) + (Math.max(IndicatorView.this.wz.getIntrinsicWidth(), IndicatorView.this.mSelector.getIntrinsicWidth()) * IndicatorView.this.mCount);
            switch (i2) {
                case Integer.MIN_VALUE:
                    int min = Math.min(i3, max);
                    IndicatorView.this.wz.setBounds(0, 0, IndicatorView.this.wz.getIntrinsicWidth(), IndicatorView.this.wz.getBounds().height());
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getIntrinsicWidth(), IndicatorView.this.mSelector.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.wz.setBounds(0, 0, IndicatorView.this.wz.getIntrinsicWidth(), 0);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.auq * (IndicatorView.this.mCount - 1))) / IndicatorView.this.mCount);
                    IndicatorView.this.mSelector.setBounds(0, 0, i4, IndicatorView.this.mSelector.getBounds().height());
                    IndicatorView.this.wz.setBounds(0, 0, i4, IndicatorView.this.wz.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int dE(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.wz.getIntrinsicHeight(), IndicatorView.this.mSelector.getIntrinsicHeight());
            switch (i2) {
                case Integer.MIN_VALUE:
                    int min = Math.min(i3, max);
                    IndicatorView.this.wz.setBounds(0, 0, IndicatorView.this.wz.getBounds().width(), min);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.wz.setBounds(0, 0, IndicatorView.this.wz.getBounds().width(), max);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.wz.setBounds(0, 0, IndicatorView.this.wz.getBounds().width(), i3);
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
                    canvas.translate(IndicatorView.this.wz.getBounds().width() + IndicatorView.this.auq, 0.0f);
                }
                IndicatorView.this.wz.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.mSelector.getBounds().width() + IndicatorView.this.auq) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.mSelector.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.aux = ((((float) (uptimeMillis - this.auu)) / 1000.0f) * this.auw) + this.aux;
            this.auu = uptimeMillis;
            this.auv = this.auu + 16;
            if (this.auw < 0) {
                if (this.aux < IndicatorView.this.aur) {
                    IndicatorView.this.mPosition = IndicatorView.this.aur;
                    this.auy = false;
                } else {
                    IndicatorView.this.mPosition = this.aux;
                    this.auz.removeMessages(1000);
                    this.auz.sendEmptyMessageAtTime(1000, this.auv);
                }
            } else if (this.aux > IndicatorView.this.aur) {
                IndicatorView.this.mPosition = IndicatorView.this.aur;
                this.auy = false;
            } else {
                IndicatorView.this.mPosition = this.aux;
                this.auz.removeMessages(1000);
                this.auz.sendEmptyMessageAtTime(1000, this.auv);
            }
            IndicatorView.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.adp.widget.IndicatorView$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0026a extends Handler {
            private HandlerC0026a() {
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
