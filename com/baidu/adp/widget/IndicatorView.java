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
    private boolean Gu;
    private int Gv;
    private float Gw;
    private Drawable Gx;
    private Drawable Gy;
    private final j Gz;
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
        this.Gz = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.Gv = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.wB = obtainStyledAttributes.getInteger(4, 0);
        this.Gx = obtainStyledAttributes.getDrawable(1);
        if (this.Gx == null) {
            Log.d("IndicatorView$IndicatorView", "Drawable not defined in xml");
        } else {
            this.Gx.setBounds(0, 0, this.Gx.getIntrinsicWidth(), this.Gx.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Drawable bounds=" + this.Gx.getBounds());
        }
        this.Gy = obtainStyledAttributes.getDrawable(2);
        if (this.Gy == null) {
            Log.d("IndicatorView$IndicatorView", "Selector not defined in xml");
        } else {
            this.Gy.setBounds(0, 0, this.Gy.getIntrinsicWidth(), this.Gy.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Selector bound=" + this.Gy.getBounds());
        }
        this.Gu = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Gz.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Gz.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.Gu = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Gx = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Gx;
    }

    public void setSelector(Drawable drawable) {
        this.Gy = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.Gy;
    }

    public void setSpacing(int i) {
        this.Gv = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.Gv;
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
        private final int GA;
        private long GB;
        private long GC;
        private int GD;
        private float GE;
        private boolean GF;
        private final HandlerC0013a GG = new HandlerC0013a(this, null);

        a() {
            this.GA = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.Gx == null || IndicatorView.this.Gy == null || IndicatorView.this.wB == 0) {
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
            Log.d("IndicatorView$IndicatorView", "drawable bound = " + IndicatorView.this.Gx.getBounds().toShortString());
            Log.d("IndicatorView$IndicatorView", "selector bound = " + IndicatorView.this.Gy.getBounds().toShortString());
        }

        private int ay(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            Log.d("IndicatorView$IndicatorView", "@measureWidth size=" + i3);
            int max = (IndicatorView.this.Gv * (IndicatorView.this.wB - 1)) + (Math.max(IndicatorView.this.Gx.getIntrinsicWidth(), IndicatorView.this.Gy.getIntrinsicWidth()) * IndicatorView.this.wB);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Gx.setBounds(0, 0, IndicatorView.this.Gx.getIntrinsicWidth(), IndicatorView.this.Gx.getBounds().height());
                    IndicatorView.this.Gy.setBounds(0, 0, IndicatorView.this.Gy.getIntrinsicWidth(), IndicatorView.this.Gy.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.Gx.setBounds(0, 0, IndicatorView.this.Gx.getIntrinsicWidth(), 0);
                    IndicatorView.this.Gy.setBounds(0, 0, IndicatorView.this.Gy.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.Gv * (IndicatorView.this.wB - 1))) / IndicatorView.this.wB);
                    IndicatorView.this.Gy.setBounds(0, 0, i4, IndicatorView.this.Gy.getBounds().height());
                    IndicatorView.this.Gx.setBounds(0, 0, i4, IndicatorView.this.Gx.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int az(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.Gx.getIntrinsicHeight(), IndicatorView.this.Gy.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    Log.d("IndicatorView$IndicatorView", "min size = " + min);
                    IndicatorView.this.Gx.setBounds(0, 0, IndicatorView.this.Gx.getBounds().width(), min);
                    IndicatorView.this.Gy.setBounds(0, 0, IndicatorView.this.Gy.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.Gx.setBounds(0, 0, IndicatorView.this.Gx.getBounds().width(), max);
                    IndicatorView.this.Gy.setBounds(0, 0, IndicatorView.this.Gy.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.Gx.setBounds(0, 0, IndicatorView.this.Gx.getBounds().width(), i3);
                    IndicatorView.this.Gy.setBounds(0, 0, IndicatorView.this.Gy.getBounds().width(), i3);
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
                    canvas.translate(IndicatorView.this.Gx.getBounds().width() + IndicatorView.this.Gv, 0.0f);
                }
                IndicatorView.this.Gx.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.Gy.getBounds().width() + IndicatorView.this.Gv) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.Gy.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mL() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GE = ((((float) (uptimeMillis - this.GB)) / 1000.0f) * this.GD) + this.GE;
            this.GB = uptimeMillis;
            this.GC = this.GB + 16;
            if (this.GD < 0) {
                if (this.GE < IndicatorView.this.Gw) {
                    IndicatorView.this.mPosition = IndicatorView.this.Gw;
                    this.GF = false;
                } else {
                    IndicatorView.this.mPosition = this.GE;
                    this.GG.removeMessages(1000);
                    this.GG.sendEmptyMessageAtTime(1000, this.GC);
                }
            } else if (this.GE > IndicatorView.this.Gw) {
                IndicatorView.this.mPosition = IndicatorView.this.Gw;
                this.GF = false;
            } else {
                IndicatorView.this.mPosition = this.GE;
                this.GG.removeMessages(1000);
                this.GG.sendEmptyMessageAtTime(1000, this.GC);
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
                        a.this.mL();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
