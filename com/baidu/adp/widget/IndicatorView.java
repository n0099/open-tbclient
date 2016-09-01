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
    private boolean AC;
    private int AD;
    private float AE;
    private Drawable AF;
    private Drawable AG;
    private final j AH;
    private float mPosition;
    private int qg;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.AH = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.AD = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.qg = obtainStyledAttributes.getInteger(4, 0);
        this.AF = obtainStyledAttributes.getDrawable(1);
        if (this.AF != null) {
            this.AF.setBounds(0, 0, this.AF.getIntrinsicWidth(), this.AF.getIntrinsicHeight());
        }
        this.AG = obtainStyledAttributes.getDrawable(2);
        if (this.AG != null) {
            this.AG.setBounds(0, 0, this.AG.getIntrinsicWidth(), this.AG.getIntrinsicHeight());
        }
        this.AC = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.AH.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.AH.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.AC = z;
    }

    public void setDrawable(Drawable drawable) {
        this.AF = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.AF;
    }

    public void setSelector(Drawable drawable) {
        this.AG = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.AG;
    }

    public void setSpacing(int i) {
        this.AD = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.AD;
    }

    public int getCount() {
        return this.qg;
    }

    public void setCount(int i) {
        this.qg = i;
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
        private final int AI;
        private long AJ;
        private long AK;
        private int AM;
        private float AN;
        private boolean AO;
        private final HandlerC0014a AP = new HandlerC0014a(this, null);

        a() {
            this.AI = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.AF == null || IndicatorView.this.AG == null || IndicatorView.this.qg == 0) {
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
            int max = (IndicatorView.this.AD * (IndicatorView.this.qg - 1)) + (Math.max(IndicatorView.this.AF.getIntrinsicWidth(), IndicatorView.this.AG.getIntrinsicWidth()) * IndicatorView.this.qg);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.AF.setBounds(0, 0, IndicatorView.this.AF.getIntrinsicWidth(), IndicatorView.this.AF.getBounds().height());
                    IndicatorView.this.AG.setBounds(0, 0, IndicatorView.this.AG.getIntrinsicWidth(), IndicatorView.this.AG.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.AF.setBounds(0, 0, IndicatorView.this.AF.getIntrinsicWidth(), 0);
                    IndicatorView.this.AG.setBounds(0, 0, IndicatorView.this.AG.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.AD * (IndicatorView.this.qg - 1))) / IndicatorView.this.qg);
                    IndicatorView.this.AG.setBounds(0, 0, i4, IndicatorView.this.AG.getBounds().height());
                    IndicatorView.this.AF.setBounds(0, 0, i4, IndicatorView.this.AF.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int aI(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.AF.getIntrinsicHeight(), IndicatorView.this.AG.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.AF.setBounds(0, 0, IndicatorView.this.AF.getBounds().width(), min);
                    IndicatorView.this.AG.setBounds(0, 0, IndicatorView.this.AG.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.AF.setBounds(0, 0, IndicatorView.this.AF.getBounds().width(), max);
                    IndicatorView.this.AG.setBounds(0, 0, IndicatorView.this.AG.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.AF.setBounds(0, 0, IndicatorView.this.AF.getBounds().width(), i3);
                    IndicatorView.this.AG.setBounds(0, 0, IndicatorView.this.AG.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.j
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.qg; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.AF.getBounds().width() + IndicatorView.this.AD, 0.0f);
                }
                IndicatorView.this.AF.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.AG.getBounds().width() + IndicatorView.this.AD) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.AG.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jE() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.AN = ((((float) (uptimeMillis - this.AJ)) / 1000.0f) * this.AM) + this.AN;
            this.AJ = uptimeMillis;
            this.AK = this.AJ + 16;
            if (this.AM < 0) {
                if (this.AN < IndicatorView.this.AE) {
                    IndicatorView.this.mPosition = IndicatorView.this.AE;
                    this.AO = false;
                } else {
                    IndicatorView.this.mPosition = this.AN;
                    this.AP.removeMessages(1000);
                    this.AP.sendEmptyMessageAtTime(1000, this.AK);
                }
            } else if (this.AN > IndicatorView.this.AE) {
                IndicatorView.this.mPosition = IndicatorView.this.AE;
                this.AO = false;
            } else {
                IndicatorView.this.mPosition = this.AN;
                this.AP.removeMessages(1000);
                this.AP.sendEmptyMessageAtTime(1000, this.AK);
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
                        a.this.jE();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
