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
    private int nL;
    private boolean yp;
    private int yq;
    private float yr;
    private Drawable ys;
    private Drawable yt;
    private final j yu;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yu = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.yq = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.nL = obtainStyledAttributes.getInteger(4, 0);
        this.ys = obtainStyledAttributes.getDrawable(1);
        if (this.ys != null) {
            this.ys.setBounds(0, 0, this.ys.getIntrinsicWidth(), this.ys.getIntrinsicHeight());
        }
        this.yt = obtainStyledAttributes.getDrawable(2);
        if (this.yt != null) {
            this.yt.setBounds(0, 0, this.yt.getIntrinsicWidth(), this.yt.getIntrinsicHeight());
        }
        this.yp = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.yu.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.yu.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.yp = z;
    }

    public void setDrawable(Drawable drawable) {
        this.ys = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.ys;
    }

    public void setSelector(Drawable drawable) {
        this.yt = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.yt;
    }

    public void setSpacing(int i) {
        this.yq = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.yq;
    }

    public int getCount() {
        return this.nL;
    }

    public void setCount(int i) {
        this.nL = i;
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
        private boolean yA;
        private final HandlerC0014a yB = new HandlerC0014a(this, null);
        private final int yv;
        private long yw;
        private long yx;
        private int yy;
        private float yz;

        a() {
            this.yv = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.ys == null || IndicatorView.this.yt == null || IndicatorView.this.nL == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            IndicatorView.this.setMeasuredDimension(au(i), av(i2));
        }

        private int au(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = (IndicatorView.this.yq * (IndicatorView.this.nL - 1)) + (Math.max(IndicatorView.this.ys.getIntrinsicWidth(), IndicatorView.this.yt.getIntrinsicWidth()) * IndicatorView.this.nL);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.ys.setBounds(0, 0, IndicatorView.this.ys.getIntrinsicWidth(), IndicatorView.this.ys.getBounds().height());
                    IndicatorView.this.yt.setBounds(0, 0, IndicatorView.this.yt.getIntrinsicWidth(), IndicatorView.this.yt.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.ys.setBounds(0, 0, IndicatorView.this.ys.getIntrinsicWidth(), 0);
                    IndicatorView.this.yt.setBounds(0, 0, IndicatorView.this.yt.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.yq * (IndicatorView.this.nL - 1))) / IndicatorView.this.nL);
                    IndicatorView.this.yt.setBounds(0, 0, i4, IndicatorView.this.yt.getBounds().height());
                    IndicatorView.this.ys.setBounds(0, 0, i4, IndicatorView.this.ys.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int av(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.ys.getIntrinsicHeight(), IndicatorView.this.yt.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.ys.setBounds(0, 0, IndicatorView.this.ys.getBounds().width(), min);
                    IndicatorView.this.yt.setBounds(0, 0, IndicatorView.this.yt.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.ys.setBounds(0, 0, IndicatorView.this.ys.getBounds().width(), max);
                    IndicatorView.this.yt.setBounds(0, 0, IndicatorView.this.yt.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.ys.setBounds(0, 0, IndicatorView.this.ys.getBounds().width(), i3);
                    IndicatorView.this.yt.setBounds(0, 0, IndicatorView.this.yt.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.j
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.nL; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.ys.getBounds().width() + IndicatorView.this.yq, 0.0f);
                }
                IndicatorView.this.ys.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.yt.getBounds().width() + IndicatorView.this.yq) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.yt.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.yz = ((((float) (uptimeMillis - this.yw)) / 1000.0f) * this.yy) + this.yz;
            this.yw = uptimeMillis;
            this.yx = this.yw + 16;
            if (this.yy < 0) {
                if (this.yz < IndicatorView.this.yr) {
                    IndicatorView.this.mPosition = IndicatorView.this.yr;
                    this.yA = false;
                } else {
                    IndicatorView.this.mPosition = this.yz;
                    this.yB.removeMessages(1000);
                    this.yB.sendEmptyMessageAtTime(1000, this.yx);
                }
            } else if (this.yz > IndicatorView.this.yr) {
                IndicatorView.this.mPosition = IndicatorView.this.yr;
                this.yA = false;
            } else {
                IndicatorView.this.mPosition = this.yz;
                this.yB.removeMessages(1000);
                this.yB.sendEmptyMessageAtTime(1000, this.yx);
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
                        a.this.iJ();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
