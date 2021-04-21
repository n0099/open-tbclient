package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.widget.TextView;
import d.b.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class DrawableCenterTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public GradientDrawable f12125e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12126f;

    /* renamed from: g  reason: collision with root package name */
    public Pair<Object, Object> f12127g;

    /* renamed from: h  reason: collision with root package name */
    public Object f12128h;
    public Object i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public float o;
    public float p;
    public boolean q;

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public final void a() {
        if (this.f12125e == null) {
            return;
        }
        int[] iArr = {getWidth(), getHeight()};
        if (this.q) {
            iArr[0] = (int) (getWidth() * this.p);
            iArr[1] = getHeight();
        }
        int width = getWidth() / 2;
        this.f12125e.setBounds(width - (iArr[0] / 2), 0, width + (iArr[0] / 2), getHeight());
    }

    public void b(int i) {
        this.o = i;
    }

    public void c(Drawable drawable, int i, int i2, int i3) {
        if (drawable != null && i > -1 && i <= 3) {
            if (i2 <= 0 || i3 <= 0) {
                i2 = drawable.getIntrinsicWidth();
                i3 = drawable.getIntrinsicHeight();
            }
            drawable.setBounds(0, 0, i2, i3);
            if (i == 0) {
                setCompoundDrawables(drawable, null, null, null);
            } else if (i == 1) {
                setCompoundDrawables(null, drawable, null, null);
            } else if (i == 2) {
                setCompoundDrawables(null, null, drawable, null);
            } else if (i != 3) {
            } else {
                setCompoundDrawables(null, null, null, drawable);
            }
        }
    }

    public final void d() {
        if (this.f12126f == null) {
            Paint paint = new Paint();
            this.f12126f = paint;
            paint.setColor(0);
            this.f12126f.setStyle(Paint.Style.STROKE);
            this.f12126f.setAntiAlias(true);
            this.f12126f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
    }

    public final boolean e() {
        return this.k && this.f12127g != null;
    }

    public final void f(Canvas canvas) {
        if (e()) {
            float f2 = this.o;
            if (f2 >= 0.0f) {
                this.f12125e.setCornerRadius(f2);
            } else {
                this.f12125e.setCornerRadius(4.0f);
            }
            if (this.l) {
                int e2 = h0.e(getContext(), 0.5f);
                Object obj = this.f12128h;
                if (obj instanceof String) {
                    this.f12125e.setStroke(e2, Color.parseColor(obj.toString()));
                } else if (obj instanceof Integer) {
                    this.f12125e.setStroke(e2, getResources().getColor(Integer.valueOf(this.f12128h.toString()).intValue()));
                }
            }
            if (this.n) {
                Object obj2 = this.f12127g.second;
                if (obj2 instanceof String) {
                    this.f12125e.setColor(Color.parseColor(obj2.toString()));
                } else if (obj2 instanceof Integer) {
                    this.f12125e.setColor(getResources().getColor(Integer.valueOf(this.f12127g.second.toString()).intValue()));
                }
            } else {
                Object obj3 = this.f12127g.first;
                if (obj3 instanceof String) {
                    this.f12125e.setColor(Color.parseColor(obj3.toString()));
                } else if (obj3 instanceof Integer) {
                    this.f12125e.setColor(getResources().getColor(Integer.valueOf(this.f12127g.first.toString()).intValue()));
                }
            }
            canvas.save();
            if (this.q) {
                a();
            } else {
                this.f12125e.setBounds(0, 0, getWidth(), getHeight());
            }
            this.f12125e.draw(canvas);
            if (this.m) {
                g(canvas);
            }
            canvas.restore();
        }
    }

    public final void g(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float width = getWidth();
        float height = getHeight();
        Paint paint = new Paint();
        paint.setStrokeWidth(h0.e(getContext(), 0.5f));
        Object obj = this.i;
        if (obj instanceof String) {
            paint.setColor(Color.parseColor(obj.toString()));
        } else if (obj instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.i.toString()).intValue()));
        }
        int i = this.j;
        float f5 = 0.0f;
        if (i == 0) {
            f2 = height;
            f3 = 0.0f;
            f4 = 0.0f;
        } else if (i != 1) {
            if (i == 2) {
                f4 = width;
                f2 = height;
                f5 = getWidth();
            } else if (i != 3) {
                f4 = width;
                f2 = height;
            } else {
                f4 = width;
                f2 = height;
                f3 = getHeight();
            }
            f3 = 0.0f;
        } else {
            f4 = width;
            f3 = 0.0f;
            f2 = 0.0f;
        }
        canvas.drawLine(f5, f3, f4, f2, paint);
    }

    public final void h(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Drawable[] compoundDrawables = getCompoundDrawables();
        int i8 = 0;
        if (compoundDrawables != null) {
            i = 0;
            while (i < compoundDrawables.length) {
                if (compoundDrawables[i] != null) {
                    drawable = compoundDrawables[i];
                    break;
                }
                i++;
            }
        }
        drawable = null;
        i = -1;
        int v = h0.v(this);
        int u = h0.u(this);
        int compoundDrawablePadding = getCompoundDrawablePadding();
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            i2 = bounds.right - bounds.left;
            i3 = bounds.bottom - bounds.top;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i == 0 || i == 2) {
            i4 = i2 + v + compoundDrawablePadding;
            i5 = 0;
        } else {
            i5 = (i == 1 || i == 3) ? u + i3 + compoundDrawablePadding : 0;
            i4 = 0;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (i == 0) {
            setGravity(19);
            i6 = width - i4;
        } else {
            if (i == 1) {
                setGravity(49);
                i7 = height - i5;
            } else if (i == 2) {
                setGravity(21);
                i8 = i4 - width;
                i7 = 0;
            } else if (i != 3) {
                setGravity(19);
                i6 = width - v;
            } else {
                setGravity(81);
                i7 = i5 - height;
            }
            canvas.translate(i8 / 2, i7 / 2);
        }
        i8 = i6;
        i7 = 0;
        canvas.translate(i8 / 2, i7 / 2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        f(canvas);
        h(canvas);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3 && e()) {
                    this.n = false;
                    invalidate();
                }
            } else if (e()) {
                this.n = false;
                invalidate();
            }
        } else if (e()) {
            this.n = true;
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimationModeActive(boolean z) {
        this.q = z;
    }

    public void setAnimationPercent(float f2) {
        if (this.p != f2) {
            this.p = f2;
            postInvalidate();
        }
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f2, float f3, float f4, int i) {
        d();
        RectF rectF = new RectF(f2, f2, f2, f2);
        rectF.offset(f3, f4);
        float f5 = rectF.left;
        int i2 = f5 < 0.0f ? 0 : (int) (f5 + 0.5f);
        float f6 = rectF.right;
        int i3 = f6 < 0.0f ? 0 : (int) (f6 + 0.5f);
        float f7 = rectF.top;
        int i4 = f7 < 0.0f ? 0 : (int) (f7 + 0.5f);
        float f8 = rectF.bottom;
        setPadding(i2, i4, i3, f8 >= 0.0f ? (int) (f8 + 0.5f) : 0);
        this.f12126f.setShadowLayer(f2, f3, f4, i);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12125e = new GradientDrawable();
        this.f12126f = null;
        new Path();
        this.f12127g = null;
        this.n = false;
        this.o = -1.0f;
        this.p = 0.0f;
    }
}
