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
    private boolean Ho;
    private int Hp;
    private float Hq;
    private Drawable Hr;
    private Drawable Hs;
    private final j Ht;
    private float mPosition;
    private int wS;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ht = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.Hp = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.wS = obtainStyledAttributes.getInteger(4, 0);
        this.Hr = obtainStyledAttributes.getDrawable(1);
        if (this.Hr == null) {
            Log.d("IndicatorView$IndicatorView", "Drawable not defined in xml");
        } else {
            this.Hr.setBounds(0, 0, this.Hr.getIntrinsicWidth(), this.Hr.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Drawable bounds=" + this.Hr.getBounds());
        }
        this.Hs = obtainStyledAttributes.getDrawable(2);
        if (this.Hs == null) {
            Log.d("IndicatorView$IndicatorView", "Selector not defined in xml");
        } else {
            this.Hs.setBounds(0, 0, this.Hs.getIntrinsicWidth(), this.Hs.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Selector bound=" + this.Hs.getBounds());
        }
        this.Ho = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Ht.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Ht.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.Ho = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Hr = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Hr;
    }

    public void setSelector(Drawable drawable) {
        this.Hs = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.Hs;
    }

    public void setSpacing(int i) {
        this.Hp = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.Hp;
    }

    public int getCount() {
        return this.wS;
    }

    public void setCount(int i) {
        this.wS = i;
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
        private final HandlerC0014a HA = new HandlerC0014a(this, null);
        private final int Hu;
        private long Hv;
        private long Hw;
        private int Hx;
        private float Hy;
        private boolean Hz;

        a() {
            this.Hu = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.Hr == null || IndicatorView.this.Hs == null || IndicatorView.this.wS == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                Log.d("IndicatorView$IndicatorView", "will not draw.");
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            int aE = aE(i);
            int aF = aF(i2);
            Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + aE);
            Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + aF);
            IndicatorView.this.setMeasuredDimension(aE, aF);
            Log.d("IndicatorView$IndicatorView", "drawable bound = " + IndicatorView.this.Hr.getBounds().toShortString());
            Log.d("IndicatorView$IndicatorView", "selector bound = " + IndicatorView.this.Hs.getBounds().toShortString());
        }

        private int aE(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            Log.d("IndicatorView$IndicatorView", "@measureWidth size=" + i3);
            int max = (IndicatorView.this.Hp * (IndicatorView.this.wS - 1)) + (Math.max(IndicatorView.this.Hr.getIntrinsicWidth(), IndicatorView.this.Hs.getIntrinsicWidth()) * IndicatorView.this.wS);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Hr.setBounds(0, 0, IndicatorView.this.Hr.getIntrinsicWidth(), IndicatorView.this.Hr.getBounds().height());
                    IndicatorView.this.Hs.setBounds(0, 0, IndicatorView.this.Hs.getIntrinsicWidth(), IndicatorView.this.Hs.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.Hr.setBounds(0, 0, IndicatorView.this.Hr.getIntrinsicWidth(), 0);
                    IndicatorView.this.Hs.setBounds(0, 0, IndicatorView.this.Hs.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.Hp * (IndicatorView.this.wS - 1))) / IndicatorView.this.wS);
                    IndicatorView.this.Hs.setBounds(0, 0, i4, IndicatorView.this.Hs.getBounds().height());
                    IndicatorView.this.Hr.setBounds(0, 0, i4, IndicatorView.this.Hr.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aF(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.Hr.getIntrinsicHeight(), IndicatorView.this.Hs.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    Log.d("IndicatorView$IndicatorView", "min size = " + min);
                    IndicatorView.this.Hr.setBounds(0, 0, IndicatorView.this.Hr.getBounds().width(), min);
                    IndicatorView.this.Hs.setBounds(0, 0, IndicatorView.this.Hs.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.Hr.setBounds(0, 0, IndicatorView.this.Hr.getBounds().width(), max);
                    IndicatorView.this.Hs.setBounds(0, 0, IndicatorView.this.Hs.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.Hr.setBounds(0, 0, IndicatorView.this.Hr.getBounds().width(), i3);
                    IndicatorView.this.Hs.setBounds(0, 0, IndicatorView.this.Hs.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.j
        public void draw(Canvas canvas) {
            Log.d("IndicatorView$IndicatorView", "draw");
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.wS; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.Hr.getBounds().width() + IndicatorView.this.Hp, 0.0f);
                }
                IndicatorView.this.Hr.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.Hs.getBounds().width() + IndicatorView.this.Hp) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.Hs.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Hy = ((((float) (uptimeMillis - this.Hv)) / 1000.0f) * this.Hx) + this.Hy;
            this.Hv = uptimeMillis;
            this.Hw = this.Hv + 16;
            if (this.Hx < 0) {
                if (this.Hy < IndicatorView.this.Hq) {
                    IndicatorView.this.mPosition = IndicatorView.this.Hq;
                    this.Hz = false;
                } else {
                    IndicatorView.this.mPosition = this.Hy;
                    this.HA.removeMessages(1000);
                    this.HA.sendEmptyMessageAtTime(1000, this.Hw);
                }
            } else if (this.Hy > IndicatorView.this.Hq) {
                IndicatorView.this.mPosition = IndicatorView.this.Hq;
                this.Hz = false;
            } else {
                IndicatorView.this.mPosition = this.Hy;
                this.HA.removeMessages(1000);
                this.HA.sendEmptyMessageAtTime(1000, this.Hw);
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
