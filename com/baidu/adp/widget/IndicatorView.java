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
    private float mPosition;
    private int ni;
    private boolean xO;
    private int xP;
    private float xQ;
    private Drawable xR;
    private Drawable xS;
    private final j xT;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xT = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.xP = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.ni = obtainStyledAttributes.getInteger(4, 0);
        this.xR = obtainStyledAttributes.getDrawable(1);
        if (this.xR != null) {
            this.xR.setBounds(0, 0, this.xR.getIntrinsicWidth(), this.xR.getIntrinsicHeight());
        }
        this.xS = obtainStyledAttributes.getDrawable(2);
        if (this.xS != null) {
            this.xS.setBounds(0, 0, this.xS.getIntrinsicWidth(), this.xS.getIntrinsicHeight());
        }
        this.xO = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.xT.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.xT.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.xO = z;
    }

    public void setDrawable(Drawable drawable) {
        this.xR = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.xR;
    }

    public void setSelector(Drawable drawable) {
        this.xS = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.xS;
    }

    public void setSpacing(int i) {
        this.xP = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.xP;
    }

    public int getCount() {
        return this.ni;
    }

    public void setCount(int i) {
        this.ni = i;
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
        private final int xU;
        private long xV;
        private long xW;
        private int xX;
        private float xY;
        private boolean xZ;
        private final HandlerC0014a ya = new HandlerC0014a(this, null);

        a() {
            this.xU = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.xR == null || IndicatorView.this.xS == null || IndicatorView.this.ni == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(ar(i), as(i2));
        }

        private int ar(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.xP * (IndicatorView.this.ni - 1)) + (Math.max(IndicatorView.this.xR.getIntrinsicWidth(), IndicatorView.this.xS.getIntrinsicWidth()) * IndicatorView.this.ni);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.xR.setBounds(0, 0, IndicatorView.this.xR.getIntrinsicWidth(), IndicatorView.this.xR.getBounds().height());
                    IndicatorView.this.xS.setBounds(0, 0, IndicatorView.this.xS.getIntrinsicWidth(), IndicatorView.this.xS.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.xR.setBounds(0, 0, IndicatorView.this.xR.getIntrinsicWidth(), 0);
                    IndicatorView.this.xS.setBounds(0, 0, IndicatorView.this.xS.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.xP * (IndicatorView.this.ni - 1))) / IndicatorView.this.ni);
                    IndicatorView.this.xS.setBounds(0, 0, i4, IndicatorView.this.xS.getBounds().height());
                    IndicatorView.this.xR.setBounds(0, 0, i4, IndicatorView.this.xR.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int as(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.xR.getIntrinsicHeight(), IndicatorView.this.xS.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.xR.setBounds(0, 0, IndicatorView.this.xR.getBounds().width(), min);
                    IndicatorView.this.xS.setBounds(0, 0, IndicatorView.this.xS.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.xR.setBounds(0, 0, IndicatorView.this.xR.getBounds().width(), max);
                    IndicatorView.this.xS.setBounds(0, 0, IndicatorView.this.xS.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.xR.setBounds(0, 0, IndicatorView.this.xR.getBounds().width(), i3);
                    IndicatorView.this.xS.setBounds(0, 0, IndicatorView.this.xS.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.j
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.ni; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.xR.getBounds().width() + IndicatorView.this.xP, 0.0f);
                }
                IndicatorView.this.xR.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.xS.getBounds().width() + IndicatorView.this.xP) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.xS.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iK() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xY = ((((float) (uptimeMillis - this.xV)) / 1000.0f) * this.xX) + this.xY;
            this.xV = uptimeMillis;
            this.xW = this.xV + 16;
            if (this.xX < 0) {
                if (this.xY < IndicatorView.this.xQ) {
                    IndicatorView.this.mPosition = IndicatorView.this.xQ;
                    this.xZ = false;
                } else {
                    IndicatorView.this.mPosition = this.xY;
                    this.ya.removeMessages(1000);
                    this.ya.sendEmptyMessageAtTime(1000, this.xW);
                }
            } else if (this.xY > IndicatorView.this.xQ) {
                IndicatorView.this.mPosition = IndicatorView.this.xQ;
                this.xZ = false;
            } else {
                IndicatorView.this.mPosition = this.xY;
                this.ya.removeMessages(1000);
                this.ya.sendEmptyMessageAtTime(1000, this.xW);
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
                        a.this.iK();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
