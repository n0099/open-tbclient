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
    private boolean HF;
    private int HG;
    private float HH;
    private Drawable HI;
    private Drawable HJ;
    private final j HK;
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
        this.HK = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.HG = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(4, 0);
        this.HI = obtainStyledAttributes.getDrawable(1);
        if (this.HI != null) {
            this.HI.setBounds(0, 0, this.HI.getIntrinsicWidth(), this.HI.getIntrinsicHeight());
        }
        this.HJ = obtainStyledAttributes.getDrawable(2);
        if (this.HJ != null) {
            this.HJ.setBounds(0, 0, this.HJ.getIntrinsicWidth(), this.HJ.getIntrinsicHeight());
        }
        this.HF = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.HK.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.HK.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.HF = z;
    }

    public void setDrawable(Drawable drawable) {
        this.HI = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.HI;
    }

    public void setSelector(Drawable drawable) {
        this.HJ = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.HJ;
    }

    public void setSpacing(int i) {
        this.HG = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.HG;
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
        private final int HL;
        private long HM;
        private long HN;
        private int HO;
        private float HP;
        private boolean HQ;
        private final HandlerC0012a HR = new HandlerC0012a(this, null);

        a() {
            this.HL = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.HI == null || IndicatorView.this.HJ == null || IndicatorView.this.mCount == 0) {
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
            int max = (IndicatorView.this.HG * (IndicatorView.this.mCount - 1)) + (Math.max(IndicatorView.this.HI.getIntrinsicWidth(), IndicatorView.this.HJ.getIntrinsicWidth()) * IndicatorView.this.mCount);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.HI.setBounds(0, 0, IndicatorView.this.HI.getIntrinsicWidth(), IndicatorView.this.HI.getBounds().height());
                    IndicatorView.this.HJ.setBounds(0, 0, IndicatorView.this.HJ.getIntrinsicWidth(), IndicatorView.this.HJ.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.HI.setBounds(0, 0, IndicatorView.this.HI.getIntrinsicWidth(), 0);
                    IndicatorView.this.HJ.setBounds(0, 0, IndicatorView.this.HJ.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.HG * (IndicatorView.this.mCount - 1))) / IndicatorView.this.mCount);
                    IndicatorView.this.HJ.setBounds(0, 0, i4, IndicatorView.this.HJ.getBounds().height());
                    IndicatorView.this.HI.setBounds(0, 0, i4, IndicatorView.this.HI.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aJ(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.HI.getIntrinsicHeight(), IndicatorView.this.HJ.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.HI.setBounds(0, 0, IndicatorView.this.HI.getBounds().width(), min);
                    IndicatorView.this.HJ.setBounds(0, 0, IndicatorView.this.HJ.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.HI.setBounds(0, 0, IndicatorView.this.HI.getBounds().width(), max);
                    IndicatorView.this.HJ.setBounds(0, 0, IndicatorView.this.HJ.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.HI.setBounds(0, 0, IndicatorView.this.HI.getBounds().width(), i3);
                    IndicatorView.this.HJ.setBounds(0, 0, IndicatorView.this.HJ.getBounds().width(), i3);
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
                    canvas.translate(IndicatorView.this.HI.getBounds().width() + IndicatorView.this.HG, 0.0f);
                }
                IndicatorView.this.HI.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.HJ.getBounds().width() + IndicatorView.this.HG) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.HJ.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kw() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.HP = ((((float) (uptimeMillis - this.HM)) / 1000.0f) * this.HO) + this.HP;
            this.HM = uptimeMillis;
            this.HN = this.HM + 16;
            if (this.HO < 0) {
                if (this.HP < IndicatorView.this.HH) {
                    IndicatorView.this.mPosition = IndicatorView.this.HH;
                    this.HQ = false;
                } else {
                    IndicatorView.this.mPosition = this.HP;
                    this.HR.removeMessages(1000);
                    this.HR.sendEmptyMessageAtTime(1000, this.HN);
                }
            } else if (this.HP > IndicatorView.this.HH) {
                IndicatorView.this.mPosition = IndicatorView.this.HH;
                this.HQ = false;
            } else {
                IndicatorView.this.mPosition = this.HP;
                this.HR.removeMessages(1000);
                this.HR.sendEmptyMessageAtTime(1000, this.HN);
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
                        a.this.kw();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
