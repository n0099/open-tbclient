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
    private boolean Gs;
    private int Gt;
    private float Gu;
    private Drawable Gv;
    private Drawable Gw;
    private final j Gx;
    private float mPosition;
    private int wA;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Gx = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.Gt = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.wA = obtainStyledAttributes.getInteger(4, 0);
        this.Gv = obtainStyledAttributes.getDrawable(1);
        if (this.Gv != null) {
            this.Gv.setBounds(0, 0, this.Gv.getIntrinsicWidth(), this.Gv.getIntrinsicHeight());
        }
        this.Gw = obtainStyledAttributes.getDrawable(2);
        if (this.Gw != null) {
            this.Gw.setBounds(0, 0, this.Gw.getIntrinsicWidth(), this.Gw.getIntrinsicHeight());
        }
        this.Gs = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Gx.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Gx.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.Gs = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Gv = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Gv;
    }

    public void setSelector(Drawable drawable) {
        this.Gw = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.Gw;
    }

    public void setSpacing(int i) {
        this.Gt = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.Gt;
    }

    public int getCount() {
        return this.wA;
    }

    public void setCount(int i) {
        this.wA = i;
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
        private long GA;
        private int GB;
        private float GC;
        private boolean GD;
        private final HandlerC0013a GE = new HandlerC0013a(this, null);
        private final int Gy;
        private long Gz;

        a() {
            this.Gy = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.Gv == null || IndicatorView.this.Gw == null || IndicatorView.this.wA == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(ay(i), az(i2));
        }

        private int ay(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.Gt * (IndicatorView.this.wA - 1)) + (Math.max(IndicatorView.this.Gv.getIntrinsicWidth(), IndicatorView.this.Gw.getIntrinsicWidth()) * IndicatorView.this.wA);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Gv.setBounds(0, 0, IndicatorView.this.Gv.getIntrinsicWidth(), IndicatorView.this.Gv.getBounds().height());
                    IndicatorView.this.Gw.setBounds(0, 0, IndicatorView.this.Gw.getIntrinsicWidth(), IndicatorView.this.Gw.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.Gv.setBounds(0, 0, IndicatorView.this.Gv.getIntrinsicWidth(), 0);
                    IndicatorView.this.Gw.setBounds(0, 0, IndicatorView.this.Gw.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.Gt * (IndicatorView.this.wA - 1))) / IndicatorView.this.wA);
                    IndicatorView.this.Gw.setBounds(0, 0, i4, IndicatorView.this.Gw.getBounds().height());
                    IndicatorView.this.Gv.setBounds(0, 0, i4, IndicatorView.this.Gv.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int az(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.Gv.getIntrinsicHeight(), IndicatorView.this.Gw.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Gv.setBounds(0, 0, IndicatorView.this.Gv.getBounds().width(), min);
                    IndicatorView.this.Gw.setBounds(0, 0, IndicatorView.this.Gw.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.Gv.setBounds(0, 0, IndicatorView.this.Gv.getBounds().width(), max);
                    IndicatorView.this.Gw.setBounds(0, 0, IndicatorView.this.Gw.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.Gv.setBounds(0, 0, IndicatorView.this.Gv.getBounds().width(), i3);
                    IndicatorView.this.Gw.setBounds(0, 0, IndicatorView.this.Gw.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.j
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.wA; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.Gv.getBounds().width() + IndicatorView.this.Gt, 0.0f);
                }
                IndicatorView.this.Gv.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.Gw.getBounds().width() + IndicatorView.this.Gt) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.Gw.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GC = ((((float) (uptimeMillis - this.Gz)) / 1000.0f) * this.GB) + this.GC;
            this.Gz = uptimeMillis;
            this.GA = this.Gz + 16;
            if (this.GB < 0) {
                if (this.GC < IndicatorView.this.Gu) {
                    IndicatorView.this.mPosition = IndicatorView.this.Gu;
                    this.GD = false;
                } else {
                    IndicatorView.this.mPosition = this.GC;
                    this.GE.removeMessages(1000);
                    this.GE.sendEmptyMessageAtTime(1000, this.GA);
                }
            } else if (this.GC > IndicatorView.this.Gu) {
                IndicatorView.this.mPosition = IndicatorView.this.Gu;
                this.GD = false;
            } else {
                IndicatorView.this.mPosition = this.GC;
                this.GE.removeMessages(1000);
                this.GE.sendEmptyMessageAtTime(1000, this.GA);
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
                        a.this.mJ();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
