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
import android.util.Log;
import android.view.View;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class IndicatorView extends View {
    private boolean Gt;
    private int Gu;
    private float Gv;
    private Drawable Gw;
    private Drawable Gx;
    private final j Gy;
    private float mPosition;
    private int wB;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Gy = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.Gu = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.wB = obtainStyledAttributes.getInteger(4, 0);
        this.Gw = obtainStyledAttributes.getDrawable(1);
        if (this.Gw == null) {
            Log.d("IndicatorView$IndicatorView", "Drawable not defined in xml");
        } else {
            this.Gw.setBounds(0, 0, this.Gw.getIntrinsicWidth(), this.Gw.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Drawable bounds=" + this.Gw.getBounds());
        }
        this.Gx = obtainStyledAttributes.getDrawable(2);
        if (this.Gx == null) {
            Log.d("IndicatorView$IndicatorView", "Selector not defined in xml");
        } else {
            this.Gx.setBounds(0, 0, this.Gx.getIntrinsicWidth(), this.Gx.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Selector bound=" + this.Gx.getBounds());
        }
        this.Gt = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Gy.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Gy.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.Gt = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Gw = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Gw;
    }

    public void setSelector(Drawable drawable) {
        this.Gx = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.Gx;
    }

    public void setSpacing(int i) {
        this.Gu = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.Gu;
    }

    public int getCount() {
        return this.wB;
    }

    public void setCount(int i) {
        this.wB = i;
        requestLayout();
        invalidate();
    }

    public void setPosition(float f) {
        Log.d("IndicatorView$IndicatorView", "@setPosition");
        this.mPosition = f;
        invalidate();
    }

    public float getPosition() {
        return this.mPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements j {
        private long GA;
        private long GB;
        private int GC;
        private float GD;
        private boolean GE;
        private final HandlerC0013a GF = new HandlerC0013a(this, null);
        private final int Gz;

        a() {
            this.Gz = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.Gw == null || IndicatorView.this.Gx == null || IndicatorView.this.wB == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                Log.d("IndicatorView$IndicatorView", "will not draw.");
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            int ay = ay(i);
            int az = az(i2);
            Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + ay);
            Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + az);
            IndicatorView.this.setMeasuredDimension(ay, az);
            Log.d("IndicatorView$IndicatorView", "drawable bound = " + IndicatorView.this.Gw.getBounds().toShortString());
            Log.d("IndicatorView$IndicatorView", "selector bound = " + IndicatorView.this.Gx.getBounds().toShortString());
        }

        private int ay(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            Log.d("IndicatorView$IndicatorView", "@measureWidth size=" + i3);
            int max = (IndicatorView.this.Gu * (IndicatorView.this.wB - 1)) + (Math.max(IndicatorView.this.Gw.getIntrinsicWidth(), IndicatorView.this.Gx.getIntrinsicWidth()) * IndicatorView.this.wB);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Gw.setBounds(0, 0, IndicatorView.this.Gw.getIntrinsicWidth(), IndicatorView.this.Gw.getBounds().height());
                    IndicatorView.this.Gx.setBounds(0, 0, IndicatorView.this.Gx.getIntrinsicWidth(), IndicatorView.this.Gx.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.Gw.setBounds(0, 0, IndicatorView.this.Gw.getIntrinsicWidth(), 0);
                    IndicatorView.this.Gx.setBounds(0, 0, IndicatorView.this.Gx.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.Gu * (IndicatorView.this.wB - 1))) / IndicatorView.this.wB);
                    IndicatorView.this.Gx.setBounds(0, 0, i4, IndicatorView.this.Gx.getBounds().height());
                    IndicatorView.this.Gw.setBounds(0, 0, i4, IndicatorView.this.Gw.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int az(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.Gw.getIntrinsicHeight(), IndicatorView.this.Gx.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    Log.d("IndicatorView$IndicatorView", "min size = " + min);
                    IndicatorView.this.Gw.setBounds(0, 0, IndicatorView.this.Gw.getBounds().width(), min);
                    IndicatorView.this.Gx.setBounds(0, 0, IndicatorView.this.Gx.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.Gw.setBounds(0, 0, IndicatorView.this.Gw.getBounds().width(), max);
                    IndicatorView.this.Gx.setBounds(0, 0, IndicatorView.this.Gx.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.Gw.setBounds(0, 0, IndicatorView.this.Gw.getBounds().width(), i3);
                    IndicatorView.this.Gx.setBounds(0, 0, IndicatorView.this.Gx.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.j
        public void draw(Canvas canvas) {
            Log.d("IndicatorView$IndicatorView", "draw");
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.wB; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.Gw.getBounds().width() + IndicatorView.this.Gu, 0.0f);
                }
                IndicatorView.this.Gw.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.Gx.getBounds().width() + IndicatorView.this.Gu) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.Gx.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mK() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GD = ((((float) (uptimeMillis - this.GA)) / 1000.0f) * this.GC) + this.GD;
            this.GA = uptimeMillis;
            this.GB = this.GA + 16;
            if (this.GC < 0) {
                if (this.GD < IndicatorView.this.Gv) {
                    IndicatorView.this.mPosition = IndicatorView.this.Gv;
                    this.GE = false;
                } else {
                    IndicatorView.this.mPosition = this.GD;
                    this.GF.removeMessages(1000);
                    this.GF.sendEmptyMessageAtTime(1000, this.GB);
                }
            } else if (this.GD > IndicatorView.this.Gv) {
                IndicatorView.this.mPosition = IndicatorView.this.Gv;
                this.GE = false;
            } else {
                IndicatorView.this.mPosition = this.GD;
                this.GF.removeMessages(1000);
                this.GF.sendEmptyMessageAtTime(1000, this.GB);
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
                        a.this.mK();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
