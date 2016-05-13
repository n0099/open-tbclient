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
    private boolean xM;
    private int xN;
    private float xO;
    private Drawable xP;
    private Drawable xQ;
    private final j xR;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xR = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.xN = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.ni = obtainStyledAttributes.getInteger(4, 0);
        this.xP = obtainStyledAttributes.getDrawable(1);
        if (this.xP != null) {
            this.xP.setBounds(0, 0, this.xP.getIntrinsicWidth(), this.xP.getIntrinsicHeight());
        }
        this.xQ = obtainStyledAttributes.getDrawable(2);
        if (this.xQ != null) {
            this.xQ.setBounds(0, 0, this.xQ.getIntrinsicWidth(), this.xQ.getIntrinsicHeight());
        }
        this.xM = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.xR.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.xR.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.xM = z;
    }

    public void setDrawable(Drawable drawable) {
        this.xP = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.xP;
    }

    public void setSelector(Drawable drawable) {
        this.xQ = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.xQ;
    }

    public void setSpacing(int i) {
        this.xN = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.xN;
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
        private final int xS;
        private long xT;
        private long xU;
        private int xV;
        private float xW;
        private boolean xX;
        private final HandlerC0014a xY = new HandlerC0014a(this, null);

        a() {
            this.xS = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.xP == null || IndicatorView.this.xQ == null || IndicatorView.this.ni == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(aq(i), ar(i2));
        }

        private int aq(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.xN * (IndicatorView.this.ni - 1)) + (Math.max(IndicatorView.this.xP.getIntrinsicWidth(), IndicatorView.this.xQ.getIntrinsicWidth()) * IndicatorView.this.ni);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.xP.setBounds(0, 0, IndicatorView.this.xP.getIntrinsicWidth(), IndicatorView.this.xP.getBounds().height());
                    IndicatorView.this.xQ.setBounds(0, 0, IndicatorView.this.xQ.getIntrinsicWidth(), IndicatorView.this.xQ.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.xP.setBounds(0, 0, IndicatorView.this.xP.getIntrinsicWidth(), 0);
                    IndicatorView.this.xQ.setBounds(0, 0, IndicatorView.this.xQ.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.xN * (IndicatorView.this.ni - 1))) / IndicatorView.this.ni);
                    IndicatorView.this.xQ.setBounds(0, 0, i4, IndicatorView.this.xQ.getBounds().height());
                    IndicatorView.this.xP.setBounds(0, 0, i4, IndicatorView.this.xP.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int ar(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.xP.getIntrinsicHeight(), IndicatorView.this.xQ.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.xP.setBounds(0, 0, IndicatorView.this.xP.getBounds().width(), min);
                    IndicatorView.this.xQ.setBounds(0, 0, IndicatorView.this.xQ.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.xP.setBounds(0, 0, IndicatorView.this.xP.getBounds().width(), max);
                    IndicatorView.this.xQ.setBounds(0, 0, IndicatorView.this.xQ.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.xP.setBounds(0, 0, IndicatorView.this.xP.getBounds().width(), i3);
                    IndicatorView.this.xQ.setBounds(0, 0, IndicatorView.this.xQ.getBounds().width(), i3);
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
                    canvas.translate(IndicatorView.this.xP.getBounds().width() + IndicatorView.this.xN, 0.0f);
                }
                IndicatorView.this.xP.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.xQ.getBounds().width() + IndicatorView.this.xN) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.xQ.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iH() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xW = ((((float) (uptimeMillis - this.xT)) / 1000.0f) * this.xV) + this.xW;
            this.xT = uptimeMillis;
            this.xU = this.xT + 16;
            if (this.xV < 0) {
                if (this.xW < IndicatorView.this.xO) {
                    IndicatorView.this.mPosition = IndicatorView.this.xO;
                    this.xX = false;
                } else {
                    IndicatorView.this.mPosition = this.xW;
                    this.xY.removeMessages(1000);
                    this.xY.sendEmptyMessageAtTime(1000, this.xU);
                }
            } else if (this.xW > IndicatorView.this.xO) {
                IndicatorView.this.mPosition = IndicatorView.this.xO;
                this.xX = false;
            } else {
                IndicatorView.this.mPosition = this.xW;
                this.xY.removeMessages(1000);
                this.xY.sendEmptyMessageAtTime(1000, this.xU);
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
                        a.this.iH();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
