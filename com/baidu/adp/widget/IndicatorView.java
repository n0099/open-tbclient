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
    private boolean Hh;
    private int Hi;
    private float Hj;
    private Drawable Hk;
    private final f Hl;
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
        this.Hl = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.Hi = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        this.Hk = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        if (this.Hk != null) {
            this.Hk.setBounds(0, 0, this.Hk.getIntrinsicWidth(), this.Hk.getIntrinsicHeight());
        }
        this.mSelector = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        if (this.mSelector != null) {
            this.mSelector.setBounds(0, 0, this.mSelector.getIntrinsicWidth(), this.mSelector.getIntrinsicHeight());
        }
        this.Hh = obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Hl.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Hl.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.Hh = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Hk = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Hk;
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
        this.Hi = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.Hi;
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
        private final int Hm;
        private long Hn;
        private long Ho;
        private int Hp;
        private float Hq;
        private boolean Hr;
        private final HandlerC0014a Hs = new HandlerC0014a();

        a() {
            this.Hm = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.f
        public void measure(int i, int i2) {
            if (IndicatorView.this.Hk == null || IndicatorView.this.mSelector == null || IndicatorView.this.mCount == 0) {
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
            int max = (IndicatorView.this.Hi * (IndicatorView.this.mCount - 1)) + (Math.max(IndicatorView.this.Hk.getIntrinsicWidth(), IndicatorView.this.mSelector.getIntrinsicWidth()) * IndicatorView.this.mCount);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Hk.setBounds(0, 0, IndicatorView.this.Hk.getIntrinsicWidth(), IndicatorView.this.Hk.getBounds().height());
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getIntrinsicWidth(), IndicatorView.this.mSelector.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.Hk.setBounds(0, 0, IndicatorView.this.Hk.getIntrinsicWidth(), 0);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.Hi * (IndicatorView.this.mCount - 1))) / IndicatorView.this.mCount);
                    IndicatorView.this.mSelector.setBounds(0, 0, i4, IndicatorView.this.mSelector.getBounds().height());
                    IndicatorView.this.Hk.setBounds(0, 0, i4, IndicatorView.this.Hk.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aI(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.Hk.getIntrinsicHeight(), IndicatorView.this.mSelector.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Hk.setBounds(0, 0, IndicatorView.this.Hk.getBounds().width(), min);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.Hk.setBounds(0, 0, IndicatorView.this.Hk.getBounds().width(), max);
                    IndicatorView.this.mSelector.setBounds(0, 0, IndicatorView.this.mSelector.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.Hk.setBounds(0, 0, IndicatorView.this.Hk.getBounds().width(), i3);
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
                    canvas.translate(IndicatorView.this.Hk.getBounds().width() + IndicatorView.this.Hi, 0.0f);
                }
                IndicatorView.this.Hk.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.mSelector.getBounds().width() + IndicatorView.this.Hi) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.mSelector.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kx() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Hq = ((((float) (uptimeMillis - this.Hn)) / 1000.0f) * this.Hp) + this.Hq;
            this.Hn = uptimeMillis;
            this.Ho = this.Hn + 16;
            if (this.Hp < 0) {
                if (this.Hq < IndicatorView.this.Hj) {
                    IndicatorView.this.mPosition = IndicatorView.this.Hj;
                    this.Hr = false;
                } else {
                    IndicatorView.this.mPosition = this.Hq;
                    this.Hs.removeMessages(1000);
                    this.Hs.sendEmptyMessageAtTime(1000, this.Ho);
                }
            } else if (this.Hq > IndicatorView.this.Hj) {
                IndicatorView.this.mPosition = IndicatorView.this.Hj;
                this.Hr = false;
            } else {
                IndicatorView.this.mPosition = this.Hq;
                this.Hs.removeMessages(1000);
                this.Hs.sendEmptyMessageAtTime(1000, this.Ho);
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
