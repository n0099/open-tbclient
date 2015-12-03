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
    private boolean GL;
    private int GM;
    private float GN;
    private Drawable GP;
    private Drawable GQ;
    private final j GR;
    private float mPosition;
    private int wH;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.GR = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.GM = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.wH = obtainStyledAttributes.getInteger(4, 0);
        this.GP = obtainStyledAttributes.getDrawable(1);
        if (this.GP == null) {
            Log.d("IndicatorView$IndicatorView", "Drawable not defined in xml");
        } else {
            this.GP.setBounds(0, 0, this.GP.getIntrinsicWidth(), this.GP.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Drawable bounds=" + this.GP.getBounds());
        }
        this.GQ = obtainStyledAttributes.getDrawable(2);
        if (this.GQ == null) {
            Log.d("IndicatorView$IndicatorView", "Selector not defined in xml");
        } else {
            this.GQ.setBounds(0, 0, this.GQ.getIntrinsicWidth(), this.GQ.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Selector bound=" + this.GQ.getBounds());
        }
        this.GL = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.GR.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.GR.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.GL = z;
    }

    public void setDrawable(Drawable drawable) {
        this.GP = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.GP;
    }

    public void setSelector(Drawable drawable) {
        this.GQ = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.GQ;
    }

    public void setSpacing(int i) {
        this.GM = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.GM;
    }

    public int getCount() {
        return this.wH;
    }

    public void setCount(int i) {
        this.wH = i;
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
        private final int GS;
        private long GT;
        private long GU;
        private int GV;
        private float GW;
        private boolean GX;
        private final HandlerC0013a GY = new HandlerC0013a(this, null);

        a() {
            this.GS = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.GP == null || IndicatorView.this.GQ == null || IndicatorView.this.wH == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                Log.d("IndicatorView$IndicatorView", "will not draw.");
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            int az = az(i);
            int aA = aA(i2);
            Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + az);
            Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + aA);
            IndicatorView.this.setMeasuredDimension(az, aA);
            Log.d("IndicatorView$IndicatorView", "drawable bound = " + IndicatorView.this.GP.getBounds().toShortString());
            Log.d("IndicatorView$IndicatorView", "selector bound = " + IndicatorView.this.GQ.getBounds().toShortString());
        }

        private int az(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            Log.d("IndicatorView$IndicatorView", "@measureWidth size=" + i3);
            int max = (IndicatorView.this.GM * (IndicatorView.this.wH - 1)) + (Math.max(IndicatorView.this.GP.getIntrinsicWidth(), IndicatorView.this.GQ.getIntrinsicWidth()) * IndicatorView.this.wH);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.GP.setBounds(0, 0, IndicatorView.this.GP.getIntrinsicWidth(), IndicatorView.this.GP.getBounds().height());
                    IndicatorView.this.GQ.setBounds(0, 0, IndicatorView.this.GQ.getIntrinsicWidth(), IndicatorView.this.GQ.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.GP.setBounds(0, 0, IndicatorView.this.GP.getIntrinsicWidth(), 0);
                    IndicatorView.this.GQ.setBounds(0, 0, IndicatorView.this.GQ.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.GM * (IndicatorView.this.wH - 1))) / IndicatorView.this.wH);
                    IndicatorView.this.GQ.setBounds(0, 0, i4, IndicatorView.this.GQ.getBounds().height());
                    IndicatorView.this.GP.setBounds(0, 0, i4, IndicatorView.this.GP.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aA(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.GP.getIntrinsicHeight(), IndicatorView.this.GQ.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    Log.d("IndicatorView$IndicatorView", "min size = " + min);
                    IndicatorView.this.GP.setBounds(0, 0, IndicatorView.this.GP.getBounds().width(), min);
                    IndicatorView.this.GQ.setBounds(0, 0, IndicatorView.this.GQ.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.GP.setBounds(0, 0, IndicatorView.this.GP.getBounds().width(), max);
                    IndicatorView.this.GQ.setBounds(0, 0, IndicatorView.this.GQ.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.GP.setBounds(0, 0, IndicatorView.this.GP.getBounds().width(), i3);
                    IndicatorView.this.GQ.setBounds(0, 0, IndicatorView.this.GQ.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.j
        public void draw(Canvas canvas) {
            Log.d("IndicatorView$IndicatorView", "draw");
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.wH; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.GP.getBounds().width() + IndicatorView.this.GM, 0.0f);
                }
                IndicatorView.this.GP.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.GQ.getBounds().width() + IndicatorView.this.GM) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.GQ.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mP() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GW = ((((float) (uptimeMillis - this.GT)) / 1000.0f) * this.GV) + this.GW;
            this.GT = uptimeMillis;
            this.GU = this.GT + 16;
            if (this.GV < 0) {
                if (this.GW < IndicatorView.this.GN) {
                    IndicatorView.this.mPosition = IndicatorView.this.GN;
                    this.GX = false;
                } else {
                    IndicatorView.this.mPosition = this.GW;
                    this.GY.removeMessages(1000);
                    this.GY.sendEmptyMessageAtTime(1000, this.GU);
                }
            } else if (this.GW > IndicatorView.this.GN) {
                IndicatorView.this.mPosition = IndicatorView.this.GN;
                this.GX = false;
            } else {
                IndicatorView.this.mPosition = this.GW;
                this.GY.removeMessages(1000);
                this.GY.sendEmptyMessageAtTime(1000, this.GU);
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
                        a.this.mP();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
