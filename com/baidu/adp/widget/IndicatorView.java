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
    private boolean Hi;
    private int Hj;
    private float Hk;
    private Drawable Hl;
    private Drawable Hm;
    private final j Hn;
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
        this.Hn = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.Hj = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(4, 0);
        this.Hl = obtainStyledAttributes.getDrawable(1);
        if (this.Hl != null) {
            this.Hl.setBounds(0, 0, this.Hl.getIntrinsicWidth(), this.Hl.getIntrinsicHeight());
        }
        this.Hm = obtainStyledAttributes.getDrawable(2);
        if (this.Hm != null) {
            this.Hm.setBounds(0, 0, this.Hm.getIntrinsicWidth(), this.Hm.getIntrinsicHeight());
        }
        this.Hi = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Hn.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Hn.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.Hi = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Hl = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Hl;
    }

    public void setSelector(Drawable drawable) {
        this.Hm = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.Hm;
    }

    public void setSpacing(int i) {
        this.Hj = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.Hj;
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
        private final int Ho;
        private long Hp;
        private long Hq;
        private int Hr;
        private float Hs;
        private boolean Ht;
        private final HandlerC0012a Hu = new HandlerC0012a(this, null);

        a() {
            this.Ho = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.Hl == null || IndicatorView.this.Hm == null || IndicatorView.this.mCount == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(aH(i), aI(i2));
        }

        private int aH(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.Hj * (IndicatorView.this.mCount - 1)) + (Math.max(IndicatorView.this.Hl.getIntrinsicWidth(), IndicatorView.this.Hm.getIntrinsicWidth()) * IndicatorView.this.mCount);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Hl.setBounds(0, 0, IndicatorView.this.Hl.getIntrinsicWidth(), IndicatorView.this.Hl.getBounds().height());
                    IndicatorView.this.Hm.setBounds(0, 0, IndicatorView.this.Hm.getIntrinsicWidth(), IndicatorView.this.Hm.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.Hl.setBounds(0, 0, IndicatorView.this.Hl.getIntrinsicWidth(), 0);
                    IndicatorView.this.Hm.setBounds(0, 0, IndicatorView.this.Hm.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.Hj * (IndicatorView.this.mCount - 1))) / IndicatorView.this.mCount);
                    IndicatorView.this.Hm.setBounds(0, 0, i4, IndicatorView.this.Hm.getBounds().height());
                    IndicatorView.this.Hl.setBounds(0, 0, i4, IndicatorView.this.Hl.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aI(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.Hl.getIntrinsicHeight(), IndicatorView.this.Hm.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Hl.setBounds(0, 0, IndicatorView.this.Hl.getBounds().width(), min);
                    IndicatorView.this.Hm.setBounds(0, 0, IndicatorView.this.Hm.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.Hl.setBounds(0, 0, IndicatorView.this.Hl.getBounds().width(), max);
                    IndicatorView.this.Hm.setBounds(0, 0, IndicatorView.this.Hm.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.Hl.setBounds(0, 0, IndicatorView.this.Hl.getBounds().width(), i3);
                    IndicatorView.this.Hm.setBounds(0, 0, IndicatorView.this.Hm.getBounds().width(), i3);
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
                    canvas.translate(IndicatorView.this.Hl.getBounds().width() + IndicatorView.this.Hj, 0.0f);
                }
                IndicatorView.this.Hl.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.Hm.getBounds().width() + IndicatorView.this.Hj) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.Hm.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kB() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Hs = ((((float) (uptimeMillis - this.Hp)) / 1000.0f) * this.Hr) + this.Hs;
            this.Hp = uptimeMillis;
            this.Hq = this.Hp + 16;
            if (this.Hr < 0) {
                if (this.Hs < IndicatorView.this.Hk) {
                    IndicatorView.this.mPosition = IndicatorView.this.Hk;
                    this.Ht = false;
                } else {
                    IndicatorView.this.mPosition = this.Hs;
                    this.Hu.removeMessages(1000);
                    this.Hu.sendEmptyMessageAtTime(1000, this.Hq);
                }
            } else if (this.Hs > IndicatorView.this.Hk) {
                IndicatorView.this.mPosition = IndicatorView.this.Hk;
                this.Ht = false;
            } else {
                IndicatorView.this.mPosition = this.Hs;
                this.Hu.removeMessages(1000);
                this.Hu.sendEmptyMessageAtTime(1000, this.Hq);
            }
            IndicatorView.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.adp.widget.IndicatorView$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0012a extends Handler {
            private HandlerC0012a() {
            }

            /* synthetic */ HandlerC0012a(a aVar, HandlerC0012a handlerC0012a) {
                this();
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1000:
                        a.this.kB();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
