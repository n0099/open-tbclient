package com.baidu.swan.facade.picture.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public abstract class BdImageViewTouchBase extends ImageView {
    public e a;
    public Matrix b;
    public Matrix c;
    public Matrix d;
    public Handler e;
    public Runnable f;
    public boolean g;
    public float h;
    public float i;
    public boolean j;
    public boolean k;
    public final Matrix l;
    public final float[] m;
    public int n;
    public int o;
    public PointF p;
    public DisplayType q;
    public boolean r;
    public boolean s;
    public RectF t;
    public RectF u;
    public RectF v;
    public f w;
    public g x;
    public boolean y;

    /* loaded from: classes4.dex */
    public enum DisplayType {
        NONE,
        FIT_TO_SCREEN,
        FIT_IF_BIGGER
    }

    /* loaded from: classes4.dex */
    public interface e {
        double easeInOut(double d, double d2, double d3, double d4);

        double easeOut(double d, double d2, double d3, double d4);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void onDrawableChanged(Drawable drawable);
    }

    /* loaded from: classes4.dex */
    public interface g {
        void onLayoutChanged(boolean z, int i, int i2, int i3, int i4);
    }

    @Override // android.view.View
    public float getRotation() {
        return 0.0f;
    }

    public void p() {
    }

    public void r(float f2) {
    }

    public void s(float f2) {
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ Drawable a;
        public final /* synthetic */ Matrix b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;

        public a(Drawable drawable, Matrix matrix, float f, float f2) {
            this.a = drawable;
            this.b = matrix;
            this.c = f;
            this.d = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BdImageViewTouchBase.this.setImageDrawable(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public double a = 0.0d;
        public double b = 0.0d;
        public final /* synthetic */ double c;
        public final /* synthetic */ long d;
        public final /* synthetic */ double e;
        public final /* synthetic */ double f;

        public b(double d, long j, double d2, double d3) {
            this.c = d;
            this.d = j;
            this.e = d2;
            this.f = d3;
        }

        @Override // java.lang.Runnable
        public void run() {
            double min = Math.min(this.c, System.currentTimeMillis() - this.d);
            double easeOut = BdImageViewTouchBase.this.a.easeOut(min, 0.0d, this.e, this.c);
            double easeOut2 = BdImageViewTouchBase.this.a.easeOut(min, 0.0d, this.f, this.c);
            BdImageViewTouchBase.this.t(easeOut - this.a, easeOut2 - this.b);
            this.a = easeOut;
            this.b = easeOut2;
            if (min < this.c) {
                BdImageViewTouchBase.this.e.post(this);
                return;
            }
            BdImageViewTouchBase bdImageViewTouchBase = BdImageViewTouchBase.this;
            RectF h = bdImageViewTouchBase.h(bdImageViewTouchBase.c, true, true);
            if (h.left != 0.0f || h.top != 0.0f) {
                BdImageViewTouchBase.this.w(h.left, h.top);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public final /* synthetic */ float a;
        public final /* synthetic */ long b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;
        public final /* synthetic */ float f;

        public c(float f, long j, float f2, float f3, float f4, float f5) {
            this.a = f;
            this.b = j;
            this.c = f2;
            this.d = f3;
            this.e = f4;
            this.f = f5;
        }

        @Override // java.lang.Runnable
        public void run() {
            float min = Math.min(this.a, (float) (System.currentTimeMillis() - this.b));
            BdImageViewTouchBase.this.B(this.d + ((float) BdImageViewTouchBase.this.a.easeInOut(min, 0.0d, this.c, this.a)), this.e, this.f);
            if (min < this.a) {
                BdImageViewTouchBase.this.e.post(this);
                return;
            }
            BdImageViewTouchBase bdImageViewTouchBase = BdImageViewTouchBase.this;
            bdImageViewTouchBase.s(bdImageViewTouchBase.getScale());
            BdImageViewTouchBase.this.a(true, true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements e {
        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.e
        public double easeInOut(double d, double d2, double d3, double d4) {
            double d5;
            double d6 = d / (d4 / 2.0d);
            if (d6 < 1.0d) {
                d5 = (d3 / 2.0d) * d6 * d6 * d6;
            } else {
                double d7 = d6 - 2.0d;
                d5 = (d3 / 2.0d) * ((d7 * d7 * d7) + 2.0d);
            }
            return d5 + d2;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.e
        public double easeOut(double d, double d2, double d3, double d4) {
            double d5 = (d / d4) - 1.0d;
            return (d3 * ((d5 * d5 * d5) + 1.0d)) + d2;
        }

        public d() {
        }
    }

    public BdImageViewTouchBase(Context context) {
        this(context, null);
    }

    public void e(Drawable drawable) {
        f fVar = this.w;
        if (fVar != null) {
            fVar.onDrawableChanged(drawable);
        }
    }

    public RectF g(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        Matrix j = j(matrix);
        this.t.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        j.mapRect(this.t);
        return this.t;
    }

    public float i(DisplayType displayType) {
        if (displayType == DisplayType.FIT_TO_SCREEN) {
            return 1.0f;
        }
        if (displayType == DisplayType.FIT_IF_BIGGER) {
            return Math.max(1.0f, 1.0f / l(this.b));
        }
        return 1.0f / l(this.b);
    }

    public Matrix j(Matrix matrix) {
        this.l.set(this.b);
        this.l.postConcat(matrix);
        return this.l;
    }

    public float l(Matrix matrix) {
        return m(matrix, 0);
    }

    public void o(Drawable drawable) {
        e(drawable);
    }

    public void setCalcBaseMatrix(boolean z) {
        this.y = z;
    }

    public void setDisplayType(DisplayType displayType) {
        if (displayType != this.q) {
            this.g = false;
            this.q = displayType;
            this.r = true;
            requestLayout();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        setImageDrawable(drawable, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        boolean z;
        Matrix imageMatrix = getImageMatrix();
        if ((matrix == null && !imageMatrix.isIdentity()) || (matrix != null && !imageMatrix.equals(matrix))) {
            z = true;
        } else {
            z = false;
        }
        super.setImageMatrix(matrix);
        if (z) {
            p();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public void setMaxScale(float f2) {
        this.h = f2;
    }

    public void setMinScale(float f2) {
        this.i = f2;
    }

    public void setOnDrawableChangedListener(f fVar) {
        this.w = fVar;
    }

    public void setOnLayoutChangeListener(g gVar) {
        this.x = gVar;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        }
    }

    public void z(float f2) {
        if (f2 > getMaxScale()) {
            f2 = getMaxScale();
        }
        if (f2 < getMinScale()) {
            f2 = getMinScale();
        }
        PointF center = getCenter();
        B(f2, center.x, center.y);
    }

    public BdImageViewTouchBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void A(float f2, float f3) {
        PointF center = getCenter();
        C(f2, center.x, center.y, f3);
    }

    public void a(boolean z, boolean z2) {
        if (getDrawable() == null) {
            return;
        }
        RectF h = h(this.c, z, z2);
        if (h.left != 0.0f || h.top != 0.0f) {
            v(h.left, h.top);
        }
    }

    public void k(Drawable drawable, Matrix matrix) {
        float f2 = this.n;
        float f3 = this.o;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        float min = Math.min(f2 / intrinsicWidth, f3 / intrinsicHeight);
        matrix.postScale(min, min);
        matrix.postTranslate((f2 - (intrinsicWidth * min)) / 2.0f, (f3 - (intrinsicHeight * min)) / 2.0f);
    }

    public float m(Matrix matrix, int i) {
        matrix.getValues(this.m);
        return this.m[i];
    }

    public void t(double d2, double d3) {
        RectF bitmapRect = getBitmapRect();
        this.v.set((float) d2, (float) d3, 0.0f, 0.0f);
        y(bitmapRect, this.v);
        RectF rectF = this.v;
        v(rectF.left, rectF.top);
        a(true, true);
    }

    public void v(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            this.c.postTranslate(f2, f3);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void w(float f2, float f3) {
        t(f2, f3);
    }

    public BdImageViewTouchBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new d();
        this.b = new Matrix();
        this.c = new Matrix();
        this.e = new Handler();
        this.f = null;
        this.g = false;
        this.h = -1.0f;
        this.i = -1.0f;
        this.l = new Matrix();
        this.m = new float[9];
        this.n = -1;
        this.o = -1;
        this.p = new PointF();
        this.q = DisplayType.NONE;
        this.t = new RectF();
        this.u = new RectF();
        this.v = new RectF();
        this.y = true;
        n(context, attributeSet, i);
    }

    public void B(float f2, float f3, float f4) {
        if (f2 > getMaxScale()) {
            f2 = getMaxScale();
        }
        u(f2 / getScale(), f3, f4);
        r(getScale());
        a(true, true);
    }

    public void n(Context context, AttributeSet attributeSet, int i) {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void u(float f2, float f3, float f4) {
        this.c.postScale(f2, f2, f3, f4);
        setImageMatrix(getImageViewMatrix());
    }

    public void x(float f2, float f3, double d2) {
        this.e.post(new b(d2, System.currentTimeMillis(), f2, f3));
    }

    public void C(float f2, float f3, float f4, float f5) {
        if (f2 > getMaxScale()) {
            f2 = getMaxScale();
        }
        long currentTimeMillis = System.currentTimeMillis();
        float scale = getScale();
        Matrix matrix = new Matrix(this.c);
        matrix.postScale(f2, f2, f3, f4);
        RectF h = h(matrix, true, true);
        this.e.post(new c(f5, currentTimeMillis, f2 - scale, scale, f3 + (h.left * f2), f4 + (h.top * f2)));
    }

    public void d(Drawable drawable, Matrix matrix, float f2, float f3) {
        if (drawable != null) {
            super.setImageDrawable(drawable);
        } else {
            this.b.reset();
            super.setImageDrawable(null);
        }
        if (f2 != -1.0f && f3 != -1.0f) {
            float min = Math.min(f2, f3);
            float max = Math.max(min, f3);
            this.i = min;
            this.h = max;
            this.k = true;
            this.j = true;
        } else {
            this.i = -1.0f;
            this.h = -1.0f;
            this.k = false;
            this.j = false;
        }
        if (matrix != null) {
            this.d = new Matrix(matrix);
        }
        this.s = true;
        requestLayout();
    }

    public float b() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return 1.0f;
        }
        return Math.max(drawable.getIntrinsicWidth() / this.n, drawable.getIntrinsicHeight() / this.o) * 8.0f;
    }

    public float c() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.min(1.0f, 1.0f / l(this.b));
    }

    public RectF getBitmapRect() {
        return g(this.c);
    }

    public PointF getCenter() {
        return this.p;
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.c);
    }

    public DisplayType getDisplayType() {
        return this.q;
    }

    public Matrix getImageViewMatrix() {
        return j(this.c);
    }

    public float getMaxScale() {
        if (this.h == -1.0f) {
            this.h = b();
        }
        return this.h;
    }

    public float getMinScale() {
        if (this.i == -1.0f) {
            this.i = c();
        }
        return this.i;
    }

    public float getScale() {
        return l(this.c);
    }

    public void f(int i, int i2, int i3, int i4) {
        g gVar = this.x;
        if (gVar != null) {
            gVar.onLayoutChanged(true, i, i2, i3, i4);
        }
    }

    public void q(int i, int i2, int i3, int i4) {
        f(i, i2, i3, i4);
    }

    public void setImageBitmap(Bitmap bitmap, Matrix matrix, float f2, float f3) {
        if (bitmap != null) {
            setImageDrawable(new BitmapDrawable(getContext().getResources(), bitmap), matrix, f2, f3);
        } else {
            setImageDrawable(null, matrix, f2, f3);
        }
    }

    public void setImageDrawable(Drawable drawable, Matrix matrix, float f2, float f3) {
        if (getWidth() <= 0) {
            this.f = new a(drawable, matrix, f2, f3);
        } else {
            d(drawable, matrix, f2, f3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (r7 < r8) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RectF h(Matrix matrix, boolean z, boolean z2) {
        float f2;
        float f3;
        float f4;
        if (getDrawable() == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.u.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF g2 = g(matrix);
        float height = g2.height();
        float width = g2.width();
        if (z2) {
            int i = this.o;
            float f5 = i;
            if (height < f5) {
                f2 = ((f5 - height) / 2.0f) - g2.top;
            } else {
                float f6 = g2.top;
                if (f6 > 0.0f) {
                    f2 = -f6;
                } else {
                    float f7 = g2.bottom;
                    if (f7 < f5) {
                        f2 = i - f7;
                    }
                }
            }
            if (z) {
                float f8 = this.n;
                if (width < f8) {
                    f8 = (f8 - width) / 2.0f;
                    f4 = g2.left;
                } else {
                    float f9 = g2.left;
                    if (f9 > 0.0f) {
                        f3 = -f9;
                        this.u.set(f3, f2, 0.0f, 0.0f);
                        return this.u;
                    }
                    f4 = g2.right;
                }
                f3 = f8 - f4;
                this.u.set(f3, f2, 0.0f, 0.0f);
                return this.u;
            }
            f3 = 0.0f;
            this.u.set(f3, f2, 0.0f, 0.0f);
            return this.u;
        }
        f2 = 0.0f;
        if (z) {
        }
        f3 = 0.0f;
        this.u.set(f3, f2, 0.0f, 0.0f);
        return this.u;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int i7 = this.n;
            int i8 = this.o;
            int i9 = i3 - i;
            this.n = i9;
            int i10 = i4 - i2;
            this.o = i10;
            i5 = i9 - i7;
            i6 = i10 - i8;
            PointF pointF = this.p;
            pointF.x = i9 / 2.0f;
            pointF.y = i10 / 2.0f;
        } else {
            i5 = 0;
            i6 = 0;
        }
        Runnable runnable = this.f;
        if (runnable != null) {
            this.f = null;
            runnable.run();
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (z || this.r || this.s) {
                float l = l(this.b);
                float scale = getScale();
                float f2 = 1.0f;
                float min = Math.min(1.0f, 1.0f / l);
                if (this.y) {
                    k(drawable, this.b);
                }
                float l2 = l(this.b);
                if (!this.s && !this.r) {
                    if (z) {
                        if (!this.k) {
                            this.i = -1.0f;
                        }
                        if (!this.j) {
                            this.h = -1.0f;
                        }
                        setImageMatrix(getImageViewMatrix());
                        v(-i5, -i6);
                        if (!this.g) {
                            f2 = i(this.q);
                            z(f2);
                        } else {
                            if (Math.abs(scale - min) > 0.001d) {
                                f2 = (l / l2) * scale;
                            }
                            z(f2);
                        }
                    }
                } else {
                    Matrix matrix = this.d;
                    if (matrix != null) {
                        this.c.set(matrix);
                        this.d = null;
                        f2 = getScale();
                    } else {
                        this.c.reset();
                    }
                    setImageMatrix(getImageViewMatrix());
                    if (f2 != getScale()) {
                        z(f2);
                    }
                }
                this.g = false;
                if (f2 > getMaxScale() || f2 < getMinScale()) {
                    z(f2);
                }
                a(true, true);
                if (this.s) {
                    o(drawable);
                }
                if (z || this.s || this.r) {
                    q(i, i2, i3, i4);
                }
                if (this.r) {
                    this.r = false;
                }
                if (this.s) {
                    this.s = false;
                    return;
                }
                return;
            }
            return;
        }
        if (this.s) {
            o(null);
        }
        if (z || this.s || this.r) {
            q(i, i2, i3, i4);
        }
        this.s = false;
        this.r = false;
    }

    public void y(RectF rectF, RectF rectF2) {
        if (rectF == null) {
            return;
        }
        if (rectF.top >= 0.0f && rectF.bottom <= this.o) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= this.n) {
            rectF2.left = 0.0f;
        }
        float f2 = rectF.top;
        if (rectF2.top + f2 >= 0.0f && rectF.bottom > this.o) {
            rectF2.top = (int) (0.0f - f2);
        }
        float f3 = rectF.bottom;
        int i = this.o;
        if (rectF2.top + f3 <= i + 0 && rectF.top < 0.0f) {
            rectF2.top = (int) ((i + 0) - f3);
        }
        float f4 = rectF.left;
        if (rectF2.left + f4 >= 0.0f) {
            rectF2.left = (int) (0.0f - f4);
        }
        float f5 = rectF.right;
        int i2 = this.n;
        if (rectF2.left + f5 <= i2 + 0) {
            rectF2.left = (int) ((i2 + 0) - f5);
        }
    }
}
