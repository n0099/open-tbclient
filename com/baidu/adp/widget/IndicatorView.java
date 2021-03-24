package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.R;
import d.b.b.j.j;
/* loaded from: classes.dex */
public class IndicatorView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f2279e;

    /* renamed from: f  reason: collision with root package name */
    public int f2280f;

    /* renamed from: g  reason: collision with root package name */
    public float f2281g;

    /* renamed from: h  reason: collision with root package name */
    public float f2282h;
    public Drawable i;
    public Drawable j;
    public final j k;

    /* loaded from: classes.dex */
    public class b implements j {

        /* renamed from: e  reason: collision with root package name */
        public final int f2283e;

        /* renamed from: f  reason: collision with root package name */
        public long f2284f;

        /* renamed from: g  reason: collision with root package name */
        public long f2285g;

        /* renamed from: h  reason: collision with root package name */
        public int f2286h;
        public float i;
        public final a j = new a();

        /* loaded from: classes.dex */
        public class a extends Handler {
            public a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1000) {
                    return;
                }
                b.this.g();
            }
        }

        public b() {
            this.f2283e = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // d.b.b.j.j
        public boolean b(MotionEvent motionEvent) {
            return false;
        }

        @Override // d.b.b.j.j
        public boolean c(MotionEvent motionEvent) {
            return false;
        }

        @Override // d.b.b.j.j
        public void d(int i, int i2) {
            if (IndicatorView.this.i != null && IndicatorView.this.j != null && IndicatorView.this.f2280f != 0) {
                IndicatorView.this.setWillNotDraw(false);
                IndicatorView.this.setMeasuredDimension(i(i), h(i2));
                return;
            }
            IndicatorView.this.setWillNotDraw(true);
            IndicatorView.this.setMeasuredDimension(0, 0);
        }

        @Override // d.b.b.j.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // d.b.b.j.j
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i = 0; i < IndicatorView.this.f2280f; i++) {
                if (i != 0) {
                    canvas.translate(IndicatorView.this.i.getBounds().width() + IndicatorView.this.f2279e, 0.0f);
                }
                IndicatorView.this.i.draw(canvas);
            }
            if (save >= 1 && save <= canvas.getSaveCount()) {
                canvas.restoreToCount(save);
            }
            int save2 = canvas.save();
            canvas.translate((IndicatorView.this.j.getBounds().width() + IndicatorView.this.f2279e) * IndicatorView.this.f2281g, 0.0f);
            IndicatorView.this.j.draw(canvas);
            if (save2 < 1 || save2 > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(save2);
        }

        @Override // d.b.b.j.j
        public void e(int i) {
            if (IndicatorView.this.f2282h <= IndicatorView.this.f2281g) {
                if (IndicatorView.this.f2282h >= IndicatorView.this.f2281g) {
                    return;
                }
                this.f2286h = -this.f2283e;
            } else {
                this.f2286h = this.f2283e;
            }
            this.i = IndicatorView.this.f2281g;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2284f = uptimeMillis;
            this.f2285g = uptimeMillis + 16;
            this.j.removeMessages(1000);
            this.j.sendEmptyMessageAtTime(1000, this.f2285g);
        }

        public final void g() {
            long uptimeMillis = SystemClock.uptimeMillis();
            float f2 = this.i;
            int i = this.f2286h;
            float f3 = f2 + (i * (((float) (uptimeMillis - this.f2284f)) / 1000.0f));
            this.i = f3;
            this.f2284f = uptimeMillis;
            this.f2285g = uptimeMillis + 16;
            if (i < 0) {
                if (f3 < IndicatorView.this.f2282h) {
                    IndicatorView indicatorView = IndicatorView.this;
                    indicatorView.f2281g = indicatorView.f2282h;
                } else {
                    IndicatorView.this.f2281g = this.i;
                    this.j.removeMessages(1000);
                    this.j.sendEmptyMessageAtTime(1000, this.f2285g);
                }
            } else if (f3 > IndicatorView.this.f2282h) {
                IndicatorView indicatorView2 = IndicatorView.this;
                indicatorView2.f2281g = indicatorView2.f2282h;
            } else {
                IndicatorView.this.f2281g = this.i;
                this.j.removeMessages(1000);
                this.j.sendEmptyMessageAtTime(1000, this.f2285g);
            }
            IndicatorView.this.invalidate();
        }

        public final int h(int i) {
            int i2 = (-1073741824) & i;
            int i3 = i & 1073741823;
            int max = Math.max(IndicatorView.this.i.getIntrinsicHeight(), IndicatorView.this.j.getIntrinsicHeight());
            if (i2 == Integer.MIN_VALUE) {
                int min = Math.min(i3, max);
                IndicatorView.this.i.setBounds(0, 0, IndicatorView.this.i.getBounds().width(), min);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getBounds().width(), min);
                return min;
            } else if (i2 == 0) {
                IndicatorView.this.i.setBounds(0, 0, IndicatorView.this.i.getBounds().width(), max);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getBounds().width(), max);
                return max;
            } else if (i2 != 1073741824) {
                return i3;
            } else {
                IndicatorView.this.i.setBounds(0, 0, IndicatorView.this.i.getBounds().width(), i3);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getBounds().width(), i3);
                return i3;
            }
        }

        public final int i(int i) {
            int i2 = (-1073741824) & i;
            int i3 = i & 1073741823;
            int max = (IndicatorView.this.f2279e * (IndicatorView.this.f2280f - 1)) + (Math.max(IndicatorView.this.i.getIntrinsicWidth(), IndicatorView.this.j.getIntrinsicWidth()) * IndicatorView.this.f2280f);
            if (i2 == Integer.MIN_VALUE) {
                int min = Math.min(i3, max);
                IndicatorView.this.i.setBounds(0, 0, IndicatorView.this.i.getIntrinsicWidth(), IndicatorView.this.i.getBounds().height());
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getIntrinsicWidth(), IndicatorView.this.j.getBounds().height());
                return min;
            } else if (i2 == 0) {
                IndicatorView.this.i.setBounds(0, 0, IndicatorView.this.i.getIntrinsicWidth(), 0);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getIntrinsicWidth(), 0);
                return max;
            } else if (i2 != 1073741824) {
                return i3;
            } else {
                int i4 = (int) ((i3 - (IndicatorView.this.f2279e * (IndicatorView.this.f2280f - 1))) / IndicatorView.this.f2280f);
                IndicatorView.this.j.setBounds(0, 0, i4, IndicatorView.this.j.getBounds().height());
                IndicatorView.this.i.setBounds(0, 0, i4, IndicatorView.this.i.getBounds().height());
                return i3;
            }
        }
    }

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public int getCount() {
        return this.f2280f;
    }

    public Drawable getDrawable() {
        return this.i;
    }

    public float getPosition() {
        return this.f2281g;
    }

    public Drawable getSelector() {
        return this.j;
    }

    public int getSpacing() {
        return this.f2279e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.k.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.k.d(i, i2);
    }

    public void setAutoHide(boolean z) {
    }

    public void setCount(int i) {
        this.f2280f = i;
        requestLayout();
        invalidate();
    }

    public void setDrawable(Drawable drawable) {
        this.i = drawable;
        requestLayout();
        invalidate();
    }

    public void setPosition(float f2) {
        this.f2281g = f2;
        invalidate();
    }

    public void setSelector(Drawable drawable) {
        this.j = drawable;
        requestLayout();
        invalidate();
    }

    public void setSpacing(int i) {
        this.f2279e = i;
        requestLayout();
        invalidate();
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.f2279e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.f2280f = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        this.i = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.i.getIntrinsicHeight());
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        this.j = drawable2;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.j.getIntrinsicHeight());
        }
        obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }
}
