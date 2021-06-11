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
import d.a.c.k.j;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class IndicatorView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f2314e;

    /* renamed from: f  reason: collision with root package name */
    public int f2315f;

    /* renamed from: g  reason: collision with root package name */
    public float f2316g;

    /* renamed from: h  reason: collision with root package name */
    public float f2317h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f2318i;
    public Drawable j;
    public final j k;

    /* loaded from: classes.dex */
    public class b implements j {

        /* renamed from: e  reason: collision with root package name */
        public final int f2319e;

        /* renamed from: f  reason: collision with root package name */
        public long f2320f;

        /* renamed from: g  reason: collision with root package name */
        public long f2321g;

        /* renamed from: h  reason: collision with root package name */
        public int f2322h;

        /* renamed from: i  reason: collision with root package name */
        public float f2323i;
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
            this.f2319e = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // d.a.c.k.j
        public boolean a(MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.c.k.j
        public void b(int i2, int i3) {
            if (IndicatorView.this.f2318i != null && IndicatorView.this.j != null && IndicatorView.this.f2315f != 0) {
                IndicatorView.this.setWillNotDraw(false);
                IndicatorView.this.setMeasuredDimension(i(i2), h(i3));
                return;
            }
            IndicatorView.this.setWillNotDraw(true);
            IndicatorView.this.setMeasuredDimension(0, 0);
        }

        @Override // d.a.c.k.j
        public void c(int i2) {
            if (IndicatorView.this.f2317h <= IndicatorView.this.f2316g) {
                if (IndicatorView.this.f2317h >= IndicatorView.this.f2316g) {
                    return;
                }
                this.f2322h = -this.f2319e;
            } else {
                this.f2322h = this.f2319e;
            }
            this.f2323i = IndicatorView.this.f2316g;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2320f = uptimeMillis;
            this.f2321g = uptimeMillis + 16;
            this.j.removeMessages(1000);
            this.j.sendEmptyMessageAtTime(1000, this.f2321g);
        }

        @Override // d.a.c.k.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.c.k.j
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i2 = 0; i2 < IndicatorView.this.f2315f; i2++) {
                if (i2 != 0) {
                    canvas.translate(IndicatorView.this.f2318i.getBounds().width() + IndicatorView.this.f2314e, 0.0f);
                }
                IndicatorView.this.f2318i.draw(canvas);
            }
            if (save >= 1 && save <= canvas.getSaveCount()) {
                canvas.restoreToCount(save);
            }
            int save2 = canvas.save();
            if (IndicatorView.this.f2316g > (IndicatorView.this.f2315f - 1) + 0.5d) {
                IndicatorView.this.f2316g = 0.0f;
            }
            canvas.translate((IndicatorView.this.j.getBounds().width() + IndicatorView.this.f2314e) * IndicatorView.this.f2316g, 0.0f);
            IndicatorView.this.j.draw(canvas);
            if (save2 < 1 || save2 > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(save2);
        }

        @Override // d.a.c.k.j
        public boolean e(MotionEvent motionEvent) {
            return false;
        }

        public final void g() {
            long uptimeMillis = SystemClock.uptimeMillis();
            float f2 = this.f2323i;
            int i2 = this.f2322h;
            float f3 = f2 + (i2 * (((float) (uptimeMillis - this.f2320f)) / 1000.0f));
            this.f2323i = f3;
            this.f2320f = uptimeMillis;
            this.f2321g = uptimeMillis + 16;
            if (i2 < 0) {
                if (f3 < IndicatorView.this.f2317h) {
                    IndicatorView indicatorView = IndicatorView.this;
                    indicatorView.f2316g = indicatorView.f2317h;
                } else {
                    IndicatorView.this.f2316g = this.f2323i;
                    this.j.removeMessages(1000);
                    this.j.sendEmptyMessageAtTime(1000, this.f2321g);
                }
            } else if (f3 > IndicatorView.this.f2317h) {
                IndicatorView indicatorView2 = IndicatorView.this;
                indicatorView2.f2316g = indicatorView2.f2317h;
            } else {
                IndicatorView.this.f2316g = this.f2323i;
                this.j.removeMessages(1000);
                this.j.sendEmptyMessageAtTime(1000, this.f2321g);
            }
            IndicatorView.this.invalidate();
        }

        public final int h(int i2) {
            int i3 = (-1073741824) & i2;
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int max = Math.max(IndicatorView.this.f2318i.getIntrinsicHeight(), IndicatorView.this.j.getIntrinsicHeight());
            if (i3 == Integer.MIN_VALUE) {
                int min = Math.min(i4, max);
                IndicatorView.this.f2318i.setBounds(0, 0, IndicatorView.this.f2318i.getBounds().width(), min);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getBounds().width(), min);
                return min;
            } else if (i3 == 0) {
                IndicatorView.this.f2318i.setBounds(0, 0, IndicatorView.this.f2318i.getBounds().width(), max);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getBounds().width(), max);
                return max;
            } else if (i3 != 1073741824) {
                return i4;
            } else {
                IndicatorView.this.f2318i.setBounds(0, 0, IndicatorView.this.f2318i.getBounds().width(), i4);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getBounds().width(), i4);
                return i4;
            }
        }

        public final int i(int i2) {
            int i3 = (-1073741824) & i2;
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int max = (IndicatorView.this.f2314e * (IndicatorView.this.f2315f - 1)) + (Math.max(IndicatorView.this.f2318i.getIntrinsicWidth(), IndicatorView.this.j.getIntrinsicWidth()) * IndicatorView.this.f2315f);
            if (i3 == Integer.MIN_VALUE) {
                int min = Math.min(i4, max);
                IndicatorView.this.f2318i.setBounds(0, 0, IndicatorView.this.f2318i.getIntrinsicWidth(), IndicatorView.this.f2318i.getBounds().height());
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getIntrinsicWidth(), IndicatorView.this.j.getBounds().height());
                return min;
            } else if (i3 == 0) {
                IndicatorView.this.f2318i.setBounds(0, 0, IndicatorView.this.f2318i.getIntrinsicWidth(), 0);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getIntrinsicWidth(), 0);
                return max;
            } else if (i3 != 1073741824) {
                return i4;
            } else {
                int i5 = (int) ((i4 - (IndicatorView.this.f2314e * (IndicatorView.this.f2315f - 1))) / IndicatorView.this.f2315f);
                IndicatorView.this.j.setBounds(0, 0, i5, IndicatorView.this.j.getBounds().height());
                IndicatorView.this.f2318i.setBounds(0, 0, i5, IndicatorView.this.f2318i.getBounds().height());
                return i4;
            }
        }
    }

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public int getCount() {
        return this.f2315f;
    }

    public Drawable getDrawable() {
        return this.f2318i;
    }

    public float getPosition() {
        return this.f2316g;
    }

    public Drawable getSelector() {
        return this.j;
    }

    public int getSpacing() {
        return this.f2314e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.k.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.k.b(i2, i3);
    }

    public void setAutoHide(boolean z) {
    }

    public void setCount(int i2) {
        this.f2315f = i2;
        requestLayout();
        invalidate();
    }

    public void setDrawable(Drawable drawable) {
        this.f2318i = drawable;
        requestLayout();
        invalidate();
    }

    public void setPosition(float f2) {
        this.f2316g = f2;
        invalidate();
    }

    public void setSelector(Drawable drawable) {
        this.j = drawable;
        requestLayout();
        invalidate();
    }

    public void setSpacing(int i2) {
        this.f2314e = i2;
        requestLayout();
        invalidate();
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.f2314e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.f2315f = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        this.f2318i = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f2318i.getIntrinsicHeight());
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        this.j = drawable2;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.j.getIntrinsicHeight());
        }
        obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }
}
