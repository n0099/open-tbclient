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
    private Drawable GT;
    private boolean GV;
    private int GW;
    private float GX;
    private final f GY;
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
        this.GY = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.GW = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        this.GT = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        if (this.GT != null) {
            this.GT.setBounds(0, 0, this.GT.getIntrinsicWidth(), this.GT.getIntrinsicHeight());
        }
        this.mSelector = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        if (this.mSelector != null) {
            this.mSelector.setBounds(0, 0, this.mSelector.getIntrinsicWidth(), this.mSelector.getIntrinsicHeight());
        }
        this.GV = obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.GY.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.GY.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.GV = z;
    }

    public void setDrawable(Drawable drawable) {
        this.GT = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.GT;
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
        this.GW = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.GW;
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
        private final int GZ;
        private long Ha;
        private long Hb;
        private int Hc;
        private float Hd;
        private boolean He;
        private final HandlerC0014a Hf = new HandlerC0014a();

        a() {
            this.GZ = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            if (IndicatorView.this.GT == null || IndicatorView.this.mSelector == null || IndicatorView.this.mCount == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(aL(i), aM(i2));
        }

        private int aL(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.GW * (IndicatorView.this.mCount - 1)) + (Math.max(IndicatorView.this.GT.getIntrinsicWidth(), IndicatorView.this.mSelector.getIntrinsicWidth()) * IndicatorView.this.mCount);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.GT.setBounds(0, 0, IndicatorView.this.GT.getIntrinsicWidth(), IndicatorView.this.GT.getBounds().height());
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getIntrinsicWidth(), IndicatorView.this.mSelector.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.GT.setBounds(0, 0, IndicatorView.this.GT.getIntrinsicWidth(), 0);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.GW * (IndicatorView.this.mCount - 1))) / IndicatorView.this.mCount);
                    IndicatorView.this.mSelector.setBounds(0, 0, i4, IndicatorView.this.mSelector.getBounds().height());
                    IndicatorView.this.GT.setBounds(0, 0, i4, IndicatorView.this.GT.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aM(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.GT.getIntrinsicHeight(), IndicatorView.this.mSelector.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.GT.setBounds(0, 0, IndicatorView.this.GT.getBounds().width(), min);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.GT.setBounds(0, 0, IndicatorView.this.GT.getBounds().width(), max);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.GT.setBounds(0, 0, IndicatorView.this.GT.getBounds().width(), i3);
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
                    canvas.translate(IndicatorView.this.GT.getBounds().width() + IndicatorView.this.GW, 0.0f);
                }
                IndicatorView.this.GT.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.mSelector.getBounds().width() + IndicatorView.this.GW) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.mSelector.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kx() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Hd = ((((float) (uptimeMillis - this.Ha)) / 1000.0f) * this.Hc) + this.Hd;
            this.Ha = uptimeMillis;
            this.Hb = this.Ha + 16;
            if (this.Hc < 0) {
                if (this.Hd < IndicatorView.this.GX) {
                    IndicatorView.this.mPosition = IndicatorView.this.GX;
                    this.He = false;
                } else {
                    IndicatorView.this.mPosition = this.Hd;
                    this.Hf.removeMessages(1000);
                    this.Hf.sendEmptyMessageAtTime(1000, this.Hb);
                }
            } else if (this.Hd > IndicatorView.this.GX) {
                IndicatorView.this.mPosition = IndicatorView.this.GX;
                this.He = false;
            } else {
                IndicatorView.this.mPosition = this.Hd;
                this.Hf.removeMessages(1000);
                this.Hf.sendEmptyMessageAtTime(1000, this.Hb);
            }
            IndicatorView.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.adp.widget.IndicatorView$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0014a extends Handler {
            private HandlerC0014a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1000:
                        a.this.kx();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
