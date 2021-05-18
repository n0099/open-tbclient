package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
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
import d.a.i0.a.v2.n0;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class DrawableCenterTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public GradientDrawable f11189e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f11190f;

    /* renamed from: g  reason: collision with root package name */
    public Pair<Object, Object> f11191g;

    /* renamed from: h  reason: collision with root package name */
    public Object f11192h;

    /* renamed from: i  reason: collision with root package name */
    public Object f11193i;
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
        if (this.f11189e == null) {
            return;
        }
        int[] iArr = {getWidth(), getHeight()};
        if (this.q) {
            iArr[0] = (int) (getWidth() * this.p);
            iArr[1] = getHeight();
        }
        int width = getWidth() / 2;
        this.f11189e.setBounds(width - (iArr[0] / 2), 0, width + (iArr[0] / 2), getHeight());
    }

    public void b(int i2) {
        this.o = i2;
    }

    public void c(Drawable drawable, int i2, int i3, int i4) {
        if (drawable != null && i2 > -1 && i2 <= 3) {
            if (i3 <= 0 || i4 <= 0) {
                i3 = drawable.getIntrinsicWidth();
                i4 = drawable.getIntrinsicHeight();
            }
            drawable.setBounds(0, 0, i3, i4);
            if (i2 == 0) {
                setCompoundDrawables(drawable, null, null, null);
            } else if (i2 == 1) {
                setCompoundDrawables(null, drawable, null, null);
            } else if (i2 == 2) {
                setCompoundDrawables(null, null, drawable, null);
            } else if (i2 != 3) {
            } else {
                setCompoundDrawables(null, null, null, drawable);
            }
        }
    }

    public final void d() {
        if (this.f11190f == null) {
            Paint paint = new Paint();
            this.f11190f = paint;
            paint.setColor(0);
            this.f11190f.setStyle(Paint.Style.STROKE);
            this.f11190f.setAntiAlias(true);
            this.f11190f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
    }

    public final boolean e() {
        return this.k && this.f11191g != null;
    }

    public final void f(Canvas canvas) {
        if (e()) {
            float f2 = this.o;
            if (f2 >= 0.0f) {
                this.f11189e.setCornerRadius(f2);
            } else {
                this.f11189e.setCornerRadius(4.0f);
            }
            if (this.l) {
                int f3 = n0.f(getContext(), 0.5f);
                Object obj = this.f11192h;
                if (obj instanceof String) {
                    this.f11189e.setStroke(f3, Color.parseColor(obj.toString()));
                } else if (obj instanceof Integer) {
                    this.f11189e.setStroke(f3, getResources().getColor(Integer.valueOf(this.f11192h.toString()).intValue()));
                }
            }
            if (this.n) {
                Object obj2 = this.f11191g.second;
                if (obj2 instanceof String) {
                    this.f11189e.setColor(Color.parseColor(obj2.toString()));
                } else if (obj2 instanceof Integer) {
                    this.f11189e.setColor(getResources().getColor(Integer.valueOf(this.f11191g.second.toString()).intValue()));
                }
            } else {
                Object obj3 = this.f11191g.first;
                if (obj3 instanceof String) {
                    this.f11189e.setColor(Color.parseColor(obj3.toString()));
                } else if (obj3 instanceof Integer) {
                    this.f11189e.setColor(getResources().getColor(Integer.valueOf(this.f11191g.first.toString()).intValue()));
                }
            }
            canvas.save();
            if (this.q) {
                a();
            } else {
                this.f11189e.setBounds(0, 0, getWidth(), getHeight());
            }
            this.f11189e.draw(canvas);
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
        paint.setStrokeWidth(n0.f(getContext(), 0.5f));
        Object obj = this.f11193i;
        if (obj instanceof String) {
            paint.setColor(Color.parseColor(obj.toString()));
        } else if (obj instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.f11193i.toString()).intValue()));
        }
        int i2 = this.j;
        float f5 = 0.0f;
        if (i2 == 0) {
            f2 = height;
            f3 = 0.0f;
            f4 = 0.0f;
        } else if (i2 != 1) {
            if (i2 == 2) {
                f4 = width;
                f2 = height;
                f5 = getWidth();
            } else if (i2 != 3) {
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
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Drawable[] compoundDrawables = getCompoundDrawables();
        int i9 = 0;
        if (compoundDrawables != null) {
            i2 = 0;
            while (i2 < compoundDrawables.length) {
                if (compoundDrawables[i2] != null) {
                    drawable = compoundDrawables[i2];
                    break;
                }
                i2++;
            }
        }
        drawable = null;
        i2 = -1;
        int x = n0.x(this);
        int w = n0.w(this);
        int compoundDrawablePadding = getCompoundDrawablePadding();
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            i3 = bounds.right - bounds.left;
            i4 = bounds.bottom - bounds.top;
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (i2 == 0 || i2 == 2) {
            i5 = i3 + x + compoundDrawablePadding;
            i6 = 0;
        } else {
            i6 = (i2 == 1 || i2 == 3) ? w + i4 + compoundDrawablePadding : 0;
            i5 = 0;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (i2 == 0) {
            setGravity(19);
            i7 = width - i5;
        } else {
            if (i2 == 1) {
                setGravity(49);
                i8 = height - i6;
            } else if (i2 == 2) {
                setGravity(21);
                i9 = i5 - width;
                i8 = 0;
            } else if (i2 != 3) {
                setGravity(19);
                i7 = width - x;
            } else {
                setGravity(81);
                i8 = i6 - height;
            }
            canvas.translate(i9 / 2, i8 / 2);
        }
        i9 = i7;
        i8 = 0;
        canvas.translate(i9 / 2, i8 / 2);
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
    public void setShadowLayer(float f2, float f3, float f4, int i2) {
        d();
        RectF rectF = new RectF(f2, f2, f2, f2);
        rectF.offset(f3, f4);
        float f5 = rectF.left;
        int i3 = f5 < 0.0f ? 0 : (int) (f5 + 0.5f);
        float f6 = rectF.right;
        int i4 = f6 < 0.0f ? 0 : (int) (f6 + 0.5f);
        float f7 = rectF.top;
        int i5 = f7 < 0.0f ? 0 : (int) (f7 + 0.5f);
        float f8 = rectF.bottom;
        setPadding(i3, i5, i4, f8 >= 0.0f ? (int) (f8 + 0.5f) : 0);
        this.f11190f.setShadowLayer(f2, f3, f4, i2);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11189e = new GradientDrawable();
        this.f11190f = null;
        new Path();
        this.f11191g = null;
        this.n = false;
        this.o = -1.0f;
        this.p = 0.0f;
    }
}
