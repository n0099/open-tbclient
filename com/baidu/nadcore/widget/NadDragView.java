package com.baidu.nadcore.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.c61;
import com.baidu.tieba.kk0;
import com.baidu.tieba.x51;
/* loaded from: classes3.dex */
public class NadDragView extends RelativeLayout {
    public static final int p = c61.c.c(kk0.b()) / 5;
    public final Matrix a;
    public View b;
    public Bitmap c;
    public Rect d;
    public Rect e;
    public Rect f;
    public float g;
    public float h;
    public boolean i;
    public boolean j;
    public boolean k;
    public float l;
    public float m;
    public a n;
    public RectF o;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public final void c() {
        a aVar = this.n;
        if (aVar != null) {
            aVar.b();
        }
    }

    public NadDragView(Context context) {
        super(context);
        this.a = new Matrix();
        this.k = false;
        this.l = 0.0f;
        this.m = 1.0f;
        this.o = new RectF();
    }

    public void setDragToExitListener(@Nullable a aVar) {
        this.n = aVar;
    }

    public void setDragView(@NonNull View view2) {
        View view3 = this.b;
        if (view3 != null) {
            removeView(view3);
        }
        this.b = view2;
        addView(view2);
    }

    public NadDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Matrix();
        this.k = false;
        this.l = 0.0f;
        this.m = 1.0f;
        this.o = new RectF();
    }

    public NadDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Matrix();
        this.k = false;
        this.l = 0.0f;
        this.m = 1.0f;
        this.o = new RectF();
    }

    public final boolean a(float f, float f2) {
        boolean z;
        View view2 = this.b;
        if (view2 != null && view2.getVisibility() == 0) {
            if (this.c != null && getScrollY() == 0) {
                if ((f2 < -15.0f && !this.k) || (f2 > 15.0f && !this.k)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.k = true;
                    this.l = 0.0f;
                    this.m = 1.0f;
                    a aVar = this.n;
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            }
            if (this.k && this.c != null) {
                this.l -= f2;
                float measuredHeight = getMeasuredHeight();
                if (this.l > measuredHeight) {
                    this.l = measuredHeight;
                }
                float f3 = f2 / measuredHeight;
                Matrix matrix = this.a;
                float f4 = this.m;
                matrix.postTranslate((-f) * 1.5f * f4, f2 * (-1.5f) * f4);
                if (this.m * (f3 + 1.0f) > 1.0f || this.l < 0.0f) {
                    f3 = -f3;
                }
                float f5 = f3 + 1.0f;
                this.a.preScale(f5, f5, (this.m * this.c.getWidth()) / 2.0f, this.m * (this.c.getHeight() / 2));
                this.m *= f5;
                invalidate();
                return true;
            }
        }
        return false;
    }

    public final RectF b(float f, float f2, float f3, float f4) {
        float f5 = f3 / 2.0f;
        float f6 = f4 / 2.0f;
        return new RectF(f - f5, f2 - f6, f + f5, f2 + f6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this.i && (bitmap2 = this.c) != null && !bitmap2.isRecycled() && this.k) {
            canvas.drawColor(Color.argb((int) (this.m * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.o == null) {
                this.o = new RectF();
            }
            this.a.mapRect(this.o, new RectF(this.d));
            canvas.drawBitmap(this.c, this.f, this.o, (Paint) null);
        } else if (this.j && (bitmap = this.c) != null && !bitmap.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.m * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            canvas.drawBitmap(this.c, this.f, this.o, (Paint) null);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        a aVar;
        Bitmap bitmap;
        if (this.b == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.i && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.i || this.j) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.c == null) {
                this.c = x51.a(this.b);
            }
            if (this.d == null && this.c != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.c.getWidth()) * this.c.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF b = b(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.d = new Rect((int) b.left, (int) b.top, (int) b.right, (int) b.bottom);
            }
            if (this.e == null && (bitmap = this.c) != null) {
                int height = bitmap.getHeight();
                int width = bitmap.getWidth();
                float b2 = c61.c.b(getContext());
                int i2 = (int) (height * b2);
                int i3 = (int) (width * b2);
                if (i3 > this.c.getWidth() && this.c.getWidth() != 0) {
                    i2 = (int) (i2 / ((i3 * 1.0f) / this.c.getWidth()));
                    i3 = this.c.getWidth();
                }
                if (i2 > this.c.getHeight() && this.c.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.c.getHeight()));
                    i2 = this.c.getHeight();
                }
                int c = (c61.c.c(getContext()) - i2) / 2;
                int e = (c61.c.e(getContext()) - i3) / 2;
                this.e = new Rect(e, c, i3 + e, i2 + c);
                this.f = new Rect(0, 0, this.c.getWidth(), this.c.getHeight());
            }
            this.g = x;
            this.h = y;
        }
        if (i == 2) {
            this.i = a(this.g - x, this.h - y);
            this.g = x;
            this.h = y;
        }
        if (!this.i && !this.j) {
            z = super.dispatchTouchEvent(motionEvent);
        } else {
            z = true;
        }
        if (i == 1 || i == 3) {
            this.g = 0.0f;
            this.h = 0.0f;
            if ((-this.l) > p * 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.l > p) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z2 && !z3) {
                if (this.i && (aVar = this.n) != null) {
                    aVar.c();
                }
                this.m = 1.0f;
                invalidate();
            } else {
                this.j = true;
                c();
            }
            this.k = false;
            this.a.reset();
            this.i = false;
        }
        return z;
    }
}
