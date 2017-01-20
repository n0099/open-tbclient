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
    private boolean As;
    private int At;
    private float Au;
    private Drawable Av;
    private Drawable Aw;
    private final j Ax;
    private int mCount;
    private float mPosition;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ax = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.At = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(4, 0);
        this.Av = obtainStyledAttributes.getDrawable(1);
        if (this.Av != null) {
            this.Av.setBounds(0, 0, this.Av.getIntrinsicWidth(), this.Av.getIntrinsicHeight());
        }
        this.Aw = obtainStyledAttributes.getDrawable(2);
        if (this.Aw != null) {
            this.Aw.setBounds(0, 0, this.Aw.getIntrinsicWidth(), this.Aw.getIntrinsicHeight());
        }
        this.As = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Ax.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Ax.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.As = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Av = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Av;
    }

    public void setSelector(Drawable drawable) {
        this.Aw = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.Aw;
    }

    public void setSpacing(int i) {
        this.At = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.At;
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
    public class a implements j {
        private long AA;
        private int AB;
        private float AC;
        private boolean AD;
        private final HandlerC0013a AE = new HandlerC0013a(this, null);
        private final int Ay;
        private long Az;

        a() {
            this.Ay = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.Av == null || IndicatorView.this.Aw == null || IndicatorView.this.mCount == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(aI(i), aJ(i2));
        }

        private int aI(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.At * (IndicatorView.this.mCount - 1)) + (Math.max(IndicatorView.this.Av.getIntrinsicWidth(), IndicatorView.this.Aw.getIntrinsicWidth()) * IndicatorView.this.mCount);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Av.setBounds(0, 0, IndicatorView.this.Av.getIntrinsicWidth(), IndicatorView.this.Av.getBounds().height());
                    IndicatorView.this.Aw.setBounds(0, 0, IndicatorView.this.Aw.getIntrinsicWidth(), IndicatorView.this.Aw.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.Av.setBounds(0, 0, IndicatorView.this.Av.getIntrinsicWidth(), 0);
                    IndicatorView.this.Aw.setBounds(0, 0, IndicatorView.this.Aw.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.At * (IndicatorView.this.mCount - 1))) / IndicatorView.this.mCount);
                    IndicatorView.this.Aw.setBounds(0, 0, i4, IndicatorView.this.Aw.getBounds().height());
                    IndicatorView.this.Av.setBounds(0, 0, i4, IndicatorView.this.Av.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aJ(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.Av.getIntrinsicHeight(), IndicatorView.this.Aw.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Av.setBounds(0, 0, IndicatorView.this.Av.getBounds().width(), min);
                    IndicatorView.this.Aw.setBounds(0, 0, IndicatorView.this.Aw.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.Av.setBounds(0, 0, IndicatorView.this.Av.getBounds().width(), max);
                    IndicatorView.this.Aw.setBounds(0, 0, IndicatorView.this.Aw.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.Av.setBounds(0, 0, IndicatorView.this.Av.getBounds().width(), i3);
                    IndicatorView.this.Aw.setBounds(0, 0, IndicatorView.this.Aw.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.j
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.mCount; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.Av.getBounds().width() + IndicatorView.this.At, 0.0f);
                }
                IndicatorView.this.Av.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.Aw.getBounds().width() + IndicatorView.this.At) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.Aw.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jC() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.AC = ((((float) (uptimeMillis - this.Az)) / 1000.0f) * this.AB) + this.AC;
            this.Az = uptimeMillis;
            this.AA = this.Az + 16;
            if (this.AB < 0) {
                if (this.AC < IndicatorView.this.Au) {
                    IndicatorView.this.mPosition = IndicatorView.this.Au;
                    this.AD = false;
                } else {
                    IndicatorView.this.mPosition = this.AC;
                    this.AE.removeMessages(1000);
                    this.AE.sendEmptyMessageAtTime(1000, this.AA);
                }
            } else if (this.AC > IndicatorView.this.Au) {
                IndicatorView.this.mPosition = IndicatorView.this.Au;
                this.AD = false;
            } else {
                IndicatorView.this.mPosition = this.AC;
                this.AE.removeMessages(1000);
                this.AE.sendEmptyMessageAtTime(1000, this.AA);
            }
            IndicatorView.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.adp.widget.IndicatorView$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0013a extends Handler {
            private HandlerC0013a() {
            }

            /* synthetic */ HandlerC0013a(a aVar, HandlerC0013a handlerC0013a) {
                this();
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1000:
                        a.this.jC();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
