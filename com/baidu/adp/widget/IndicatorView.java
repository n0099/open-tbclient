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
    private boolean Hc;
    private int Hd;
    private float He;
    private Drawable Hf;
    private Drawable Hg;
    private final j Hh;
    private float mPosition;
    private int wJ;

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Hh = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.Hd = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.wJ = obtainStyledAttributes.getInteger(4, 0);
        this.Hf = obtainStyledAttributes.getDrawable(1);
        if (this.Hf == null) {
            Log.d("IndicatorView$IndicatorView", "Drawable not defined in xml");
        } else {
            this.Hf.setBounds(0, 0, this.Hf.getIntrinsicWidth(), this.Hf.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Drawable bounds=" + this.Hf.getBounds());
        }
        this.Hg = obtainStyledAttributes.getDrawable(2);
        if (this.Hg == null) {
            Log.d("IndicatorView$IndicatorView", "Selector not defined in xml");
        } else {
            this.Hg.setBounds(0, 0, this.Hg.getIntrinsicWidth(), this.Hg.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Selector bound=" + this.Hg.getBounds());
        }
        this.Hc = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Hh.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Hh.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.Hc = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Hf = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Hf;
    }

    public void setSelector(Drawable drawable) {
        this.Hg = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.Hg;
    }

    public void setSpacing(int i) {
        this.Hd = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.Hd;
    }

    public int getCount() {
        return this.wJ;
    }

    public void setCount(int i) {
        this.wJ = i;
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
        private final int Hi;
        private long Hj;
        private long Hk;
        private int Hl;
        private float Hm;
        private boolean Hn;
        private final HandlerC0014a Ho = new HandlerC0014a(this, null);

        a() {
            this.Hi = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.adp.widget.j
        public void measure(int i, int i2) {
            if (IndicatorView.this.Hf == null || IndicatorView.this.Hg == null || IndicatorView.this.wJ == 0) {
                IndicatorView.this.setWillNotDraw(true);
                IndicatorView.this.setMeasuredDimension(0, 0);
                Log.d("IndicatorView$IndicatorView", "will not draw.");
                return;
            }
            IndicatorView.this.setWillNotDraw(false);
            int as = as(i);
            int at = at(i2);
            Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + as);
            Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + at);
            IndicatorView.this.setMeasuredDimension(as, at);
            Log.d("IndicatorView$IndicatorView", "drawable bound = " + IndicatorView.this.Hf.getBounds().toShortString());
            Log.d("IndicatorView$IndicatorView", "selector bound = " + IndicatorView.this.Hg.getBounds().toShortString());
        }

        private int as(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            Log.d("IndicatorView$IndicatorView", "@measureWidth size=" + i3);
            int max = (IndicatorView.this.Hd * (IndicatorView.this.wJ - 1)) + (Math.max(IndicatorView.this.Hf.getIntrinsicWidth(), IndicatorView.this.Hg.getIntrinsicWidth()) * IndicatorView.this.wJ);
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    IndicatorView.this.Hf.setBounds(0, 0, IndicatorView.this.Hf.getIntrinsicWidth(), IndicatorView.this.Hf.getBounds().height());
                    IndicatorView.this.Hg.setBounds(0, 0, IndicatorView.this.Hg.getIntrinsicWidth(), IndicatorView.this.Hg.getBounds().height());
                    return min;
                case 0:
                    IndicatorView.this.Hf.setBounds(0, 0, IndicatorView.this.Hf.getIntrinsicWidth(), 0);
                    IndicatorView.this.Hg.setBounds(0, 0, IndicatorView.this.Hg.getIntrinsicWidth(), 0);
                    return max;
                case 1073741824:
                    int i4 = (int) ((i3 - (IndicatorView.this.Hd * (IndicatorView.this.wJ - 1))) / IndicatorView.this.wJ);
                    IndicatorView.this.Hg.setBounds(0, 0, i4, IndicatorView.this.Hg.getBounds().height());
                    IndicatorView.this.Hf.setBounds(0, 0, i4, IndicatorView.this.Hf.getBounds().height());
                    return i3;
                default:
                    return i3;
            }
        }

        private int at(int i) {
            int i2 = i & (-1073741824);
            int i3 = 1073741823 & i;
            int max = Math.max(IndicatorView.this.Hf.getIntrinsicHeight(), IndicatorView.this.Hg.getIntrinsicHeight());
            switch (i2) {
                case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                    int min = Math.min(i3, max);
                    Log.d("IndicatorView$IndicatorView", "min size = " + min);
                    IndicatorView.this.Hf.setBounds(0, 0, IndicatorView.this.Hf.getBounds().width(), min);
                    IndicatorView.this.Hg.setBounds(0, 0, IndicatorView.this.Hg.getBounds().width(), min);
                    return min;
                case 0:
                    IndicatorView.this.Hf.setBounds(0, 0, IndicatorView.this.Hf.getBounds().width(), max);
                    IndicatorView.this.Hg.setBounds(0, 0, IndicatorView.this.Hg.getBounds().width(), max);
                    return max;
                case 1073741824:
                    IndicatorView.this.Hf.setBounds(0, 0, IndicatorView.this.Hf.getBounds().width(), i3);
                    IndicatorView.this.Hg.setBounds(0, 0, IndicatorView.this.Hg.getBounds().width(), i3);
                    return i3;
                default:
                    return i3;
            }
        }

        @Override // com.baidu.adp.widget.j
        public void draw(Canvas canvas) {
            Log.d("IndicatorView$IndicatorView", "draw");
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.wJ; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.Hf.getBounds().width() + IndicatorView.this.Hd, 0.0f);
                }
                IndicatorView.this.Hf.draw(canvas);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.Hg.getBounds().width() + IndicatorView.this.Hd) * IndicatorView.this.mPosition, 0.0f);
            IndicatorView.this.Hg.draw(canvas);
            canvas.restoreToCount(save2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mn() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Hm = ((((float) (uptimeMillis - this.Hj)) / 1000.0f) * this.Hl) + this.Hm;
            this.Hj = uptimeMillis;
            this.Hk = this.Hj + 16;
            if (this.Hl < 0) {
                if (this.Hm < IndicatorView.this.He) {
                    IndicatorView.this.mPosition = IndicatorView.this.He;
                    this.Hn = false;
                } else {
                    IndicatorView.this.mPosition = this.Hm;
                    this.Ho.removeMessages(1000);
                    this.Ho.sendEmptyMessageAtTime(1000, this.Hk);
                }
            } else if (this.Hm > IndicatorView.this.He) {
                IndicatorView.this.mPosition = IndicatorView.this.He;
                this.Hn = false;
            } else {
                IndicatorView.this.mPosition = this.Hm;
                this.Ho.removeMessages(1000);
                this.Ho.sendEmptyMessageAtTime(1000, this.Hk);
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
                        a.this.mn();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
