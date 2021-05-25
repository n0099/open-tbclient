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
import d.a.c.j.j;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class IndicatorView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f2295e;

    /* renamed from: f  reason: collision with root package name */
    public int f2296f;

    /* renamed from: g  reason: collision with root package name */
    public float f2297g;

    /* renamed from: h  reason: collision with root package name */
    public float f2298h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f2299i;
    public Drawable j;
    public final j k;

    /* loaded from: classes.dex */
    public class b implements j {

        /* renamed from: e  reason: collision with root package name */
        public final int f2300e;

        /* renamed from: f  reason: collision with root package name */
        public long f2301f;

        /* renamed from: g  reason: collision with root package name */
        public long f2302g;

        /* renamed from: h  reason: collision with root package name */
        public int f2303h;

        /* renamed from: i  reason: collision with root package name */
        public float f2304i;
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
            this.f2300e = (int) ((IndicatorView.this.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // d.a.c.j.j
        public boolean a(MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.c.j.j
        public void b(int i2, int i3) {
            if (IndicatorView.this.f2299i != null && IndicatorView.this.j != null && IndicatorView.this.f2296f != 0) {
                IndicatorView.this.setWillNotDraw(false);
                IndicatorView.this.setMeasuredDimension(i(i2), h(i3));
                return;
            }
            IndicatorView.this.setWillNotDraw(true);
            IndicatorView.this.setMeasuredDimension(0, 0);
        }

        @Override // d.a.c.j.j
        public void c(int i2) {
            if (IndicatorView.this.f2298h <= IndicatorView.this.f2297g) {
                if (IndicatorView.this.f2298h >= IndicatorView.this.f2297g) {
                    return;
                }
                this.f2303h = -this.f2300e;
            } else {
                this.f2303h = this.f2300e;
            }
            this.f2304i = IndicatorView.this.f2297g;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2301f = uptimeMillis;
            this.f2302g = uptimeMillis + 16;
            this.j.removeMessages(1000);
            this.j.sendEmptyMessageAtTime(1000, this.f2302g);
        }

        @Override // d.a.c.j.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.c.j.j
        public void draw(Canvas canvas) {
            int save = canvas.save();
            for (int i2 = 0; i2 < IndicatorView.this.f2296f; i2++) {
                if (i2 != 0) {
                    canvas.translate(IndicatorView.this.f2299i.getBounds().width() + IndicatorView.this.f2295e, 0.0f);
                }
                IndicatorView.this.f2299i.draw(canvas);
            }
            if (save >= 1 && save <= canvas.getSaveCount()) {
                canvas.restoreToCount(save);
            }
            int save2 = canvas.save();
            if (IndicatorView.this.f2297g > (IndicatorView.this.f2296f - 1) + 0.5d) {
                IndicatorView.this.f2297g = 0.0f;
            }
            canvas.translate((IndicatorView.this.j.getBounds().width() + IndicatorView.this.f2295e) * IndicatorView.this.f2297g, 0.0f);
            IndicatorView.this.j.draw(canvas);
            if (save2 < 1 || save2 > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(save2);
        }

        @Override // d.a.c.j.j
        public boolean e(MotionEvent motionEvent) {
            return false;
        }

        public final void g() {
            long uptimeMillis = SystemClock.uptimeMillis();
            float f2 = this.f2304i;
            int i2 = this.f2303h;
            float f3 = f2 + (i2 * (((float) (uptimeMillis - this.f2301f)) / 1000.0f));
            this.f2304i = f3;
            this.f2301f = uptimeMillis;
            this.f2302g = uptimeMillis + 16;
            if (i2 < 0) {
                if (f3 < IndicatorView.this.f2298h) {
                    IndicatorView indicatorView = IndicatorView.this;
                    indicatorView.f2297g = indicatorView.f2298h;
                } else {
                    IndicatorView.this.f2297g = this.f2304i;
                    this.j.removeMessages(1000);
                    this.j.sendEmptyMessageAtTime(1000, this.f2302g);
                }
            } else if (f3 > IndicatorView.this.f2298h) {
                IndicatorView indicatorView2 = IndicatorView.this;
                indicatorView2.f2297g = indicatorView2.f2298h;
            } else {
                IndicatorView.this.f2297g = this.f2304i;
                this.j.removeMessages(1000);
                this.j.sendEmptyMessageAtTime(1000, this.f2302g);
            }
            IndicatorView.this.invalidate();
        }

        public final int h(int i2) {
            int i3 = (-1073741824) & i2;
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int max = Math.max(IndicatorView.this.f2299i.getIntrinsicHeight(), IndicatorView.this.j.getIntrinsicHeight());
            if (i3 == Integer.MIN_VALUE) {
                int min = Math.min(i4, max);
                IndicatorView.this.f2299i.setBounds(0, 0, IndicatorView.this.f2299i.getBounds().width(), min);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getBounds().width(), min);
                return min;
            } else if (i3 == 0) {
                IndicatorView.this.f2299i.setBounds(0, 0, IndicatorView.this.f2299i.getBounds().width(), max);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getBounds().width(), max);
                return max;
            } else if (i3 != 1073741824) {
                return i4;
            } else {
                IndicatorView.this.f2299i.setBounds(0, 0, IndicatorView.this.f2299i.getBounds().width(), i4);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getBounds().width(), i4);
                return i4;
            }
        }

        public final int i(int i2) {
            int i3 = (-1073741824) & i2;
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int max = (IndicatorView.this.f2295e * (IndicatorView.this.f2296f - 1)) + (Math.max(IndicatorView.this.f2299i.getIntrinsicWidth(), IndicatorView.this.j.getIntrinsicWidth()) * IndicatorView.this.f2296f);
            if (i3 == Integer.MIN_VALUE) {
                int min = Math.min(i4, max);
                IndicatorView.this.f2299i.setBounds(0, 0, IndicatorView.this.f2299i.getIntrinsicWidth(), IndicatorView.this.f2299i.getBounds().height());
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getIntrinsicWidth(), IndicatorView.this.j.getBounds().height());
                return min;
            } else if (i3 == 0) {
                IndicatorView.this.f2299i.setBounds(0, 0, IndicatorView.this.f2299i.getIntrinsicWidth(), 0);
                IndicatorView.this.j.setBounds(0, 0, IndicatorView.this.j.getIntrinsicWidth(), 0);
                return max;
            } else if (i3 != 1073741824) {
                return i4;
            } else {
                int i5 = (int) ((i4 - (IndicatorView.this.f2295e * (IndicatorView.this.f2296f - 1))) / IndicatorView.this.f2296f);
                IndicatorView.this.j.setBounds(0, 0, i5, IndicatorView.this.j.getBounds().height());
                IndicatorView.this.f2299i.setBounds(0, 0, i5, IndicatorView.this.f2299i.getBounds().height());
                return i4;
            }
        }
    }

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public int getCount() {
        return this.f2296f;
    }

    public Drawable getDrawable() {
        return this.f2299i;
    }

    public float getPosition() {
        return this.f2297g;
    }

    public Drawable getSelector() {
        return this.j;
    }

    public int getSpacing() {
        return this.f2295e;
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
        this.f2296f = i2;
        requestLayout();
        invalidate();
    }

    public void setDrawable(Drawable drawable) {
        this.f2299i = drawable;
        requestLayout();
        invalidate();
    }

    public void setPosition(float f2) {
        this.f2297g = f2;
        invalidate();
    }

    public void setSelector(Drawable drawable) {
        this.j = drawable;
        requestLayout();
        invalidate();
    }

    public void setSpacing(int i2) {
        this.f2295e = i2;
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
        this.f2295e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.f2296f = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        this.f2299i = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f2299i.getIntrinsicHeight());
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        this.j = drawable2;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.j.getIntrinsicHeight());
        }
        obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }
}
