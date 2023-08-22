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
import com.baidu.tieba.uo3;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class DrawableCenterTextView extends TextView {
    public GradientDrawable a;
    public Paint b;
    public Pair<Object, Object> c;
    public Object d;
    public Object e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public float k;
    public float l;
    public boolean m;

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public void b(int i) {
        this.k = i;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        f(canvas);
        h(canvas);
        super.onDraw(canvas);
    }

    public void setAnimationModeActive(boolean z) {
        this.m = z;
    }

    public void setAnimationPercent(float f) {
        if (this.l != f) {
            this.l = f;
            postInvalidate();
        }
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new GradientDrawable();
        this.b = null;
        new Path();
        this.c = null;
        this.j = false;
        this.k = -1.0f;
        this.l = 0.0f;
    }

    public final void a() {
        if (this.a == null) {
            return;
        }
        int[] iArr = {getWidth(), getHeight()};
        if (this.m) {
            iArr[0] = (int) (getWidth() * this.l);
            iArr[1] = getHeight();
        }
        int width = getWidth() / 2;
        this.a.setBounds(width - (iArr[0] / 2), 0, width + (iArr[0] / 2), getHeight());
    }

    public void c(Drawable drawable, int i, int i2, int i3) {
        if (drawable != null && i > -1 && i <= 3) {
            if (i2 <= 0 || i3 <= 0) {
                i2 = drawable.getIntrinsicWidth();
                i3 = drawable.getIntrinsicHeight();
            }
            drawable.setBounds(0, 0, i2, i3);
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            setCompoundDrawables(null, null, null, drawable);
                            return;
                        }
                        return;
                    }
                    setCompoundDrawables(null, null, drawable, null);
                    return;
                }
                setCompoundDrawables(null, drawable, null, null);
                return;
            }
            setCompoundDrawables(drawable, null, null, null);
        }
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f, float f2, float f3, int i) {
        int i2;
        int i3;
        int i4;
        d();
        RectF rectF = new RectF(f, f, f, f);
        rectF.offset(f2, f3);
        float f4 = rectF.left;
        int i5 = 0;
        if (f4 < 0.0f) {
            i2 = 0;
        } else {
            i2 = (int) (f4 + 0.5f);
        }
        float f5 = rectF.right;
        if (f5 < 0.0f) {
            i3 = 0;
        } else {
            i3 = (int) (f5 + 0.5f);
        }
        float f6 = rectF.top;
        if (f6 < 0.0f) {
            i4 = 0;
        } else {
            i4 = (int) (f6 + 0.5f);
        }
        float f7 = rectF.bottom;
        if (f7 >= 0.0f) {
            i5 = (int) (f7 + 0.5f);
        }
        setPadding(i2, i4, i3, i5);
        this.b.setShadowLayer(f, f2, f3, i);
    }

    public final void d() {
        if (this.b == null) {
            Paint paint = new Paint();
            this.b = paint;
            paint.setColor(0);
            this.b.setStyle(Paint.Style.STROKE);
            this.b.setAntiAlias(true);
            this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
    }

    public final boolean e() {
        if (this.g && this.c != null) {
            return true;
        }
        return false;
    }

    public final void f(Canvas canvas) {
        if (!e()) {
            return;
        }
        float f = this.k;
        if (f >= 0.0f) {
            this.a.setCornerRadius(f);
        } else {
            this.a.setCornerRadius(4.0f);
        }
        if (this.h) {
            int f2 = uo3.f(getContext(), 0.5f);
            Object obj = this.d;
            if (obj instanceof String) {
                this.a.setStroke(f2, Color.parseColor(obj.toString()));
            } else if (obj instanceof Integer) {
                this.a.setStroke(f2, getResources().getColor(Integer.valueOf(this.d.toString()).intValue()));
            }
        }
        if (this.j) {
            Object obj2 = this.c.second;
            if (obj2 instanceof String) {
                this.a.setColor(Color.parseColor(obj2.toString()));
            } else if (obj2 instanceof Integer) {
                this.a.setColor(getResources().getColor(Integer.valueOf(this.c.second.toString()).intValue()));
            }
        } else {
            Object obj3 = this.c.first;
            if (obj3 instanceof String) {
                this.a.setColor(Color.parseColor(obj3.toString()));
            } else if (obj3 instanceof Integer) {
                this.a.setColor(getResources().getColor(Integer.valueOf(this.c.first.toString()).intValue()));
            }
        }
        canvas.save();
        if (this.m) {
            a();
        } else {
            this.a.setBounds(0, 0, getWidth(), getHeight());
        }
        this.a.draw(canvas);
        if (this.i) {
            g(canvas);
        }
        canvas.restore();
    }

    public final void g(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float width = getWidth();
        float height = getHeight();
        Paint paint = new Paint();
        paint.setStrokeWidth(uo3.f(getContext(), 0.5f));
        Object obj = this.e;
        if (obj instanceof String) {
            paint.setColor(Color.parseColor(obj.toString()));
        } else if (obj instanceof Integer) {
            paint.setColor(getResources().getColor(Integer.valueOf(this.e.toString()).intValue()));
        }
        int i = this.f;
        float f4 = 0.0f;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        f3 = width;
                        f = height;
                    } else {
                        f3 = width;
                        f = height;
                        f2 = getHeight();
                    }
                } else {
                    f3 = width;
                    f = height;
                    f4 = getWidth();
                }
                f2 = 0.0f;
            } else {
                f3 = width;
                f2 = 0.0f;
                f = 0.0f;
            }
        } else {
            f = height;
            f2 = 0.0f;
            f3 = 0.0f;
        }
        canvas.drawLine(f4, f2, f3, f, paint);
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
        int w = uo3.w(this);
        int v = uo3.v(this);
        int compoundDrawablePadding = getCompoundDrawablePadding();
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            i2 = bounds.right - bounds.left;
            i3 = bounds.bottom - bounds.top;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i != 0 && i != 2) {
            if (i != 1 && i != 3) {
                i5 = 0;
            } else {
                i5 = v + i3 + compoundDrawablePadding;
            }
            i4 = 0;
        } else {
            i4 = i2 + w + compoundDrawablePadding;
            i5 = 0;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        setGravity(19);
                        i6 = width - w;
                    } else {
                        setGravity(81);
                        i7 = i5 - height;
                    }
                } else {
                    setGravity(21);
                    i8 = i4 - width;
                    i7 = 0;
                }
            } else {
                setGravity(49);
                i7 = height - i5;
            }
            canvas.translate(i8 / 2, i7 / 2);
        }
        setGravity(19);
        i6 = width - i4;
        i8 = i6;
        i7 = 0;
        canvas.translate(i8 / 2, i7 / 2);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3 && e()) {
                    this.j = false;
                    invalidate();
                }
            } else if (e()) {
                this.j = false;
                invalidate();
            }
        } else if (e()) {
            this.j = true;
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }
}
