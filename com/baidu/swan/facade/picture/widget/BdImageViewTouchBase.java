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
/* loaded from: classes3.dex */
public abstract class BdImageViewTouchBase extends ImageView {
    public f A;
    public g B;
    public boolean C;

    /* renamed from: e  reason: collision with root package name */
    public e f11538e;

    /* renamed from: f  reason: collision with root package name */
    public Matrix f11539f;

    /* renamed from: g  reason: collision with root package name */
    public Matrix f11540g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f11541h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f11542i;
    public Runnable j;
    public boolean k;
    public float l;
    public float m;
    public boolean n;
    public boolean o;
    public final Matrix p;
    public final float[] q;
    public int r;
    public int s;
    public PointF t;
    public DisplayType u;
    public boolean v;
    public boolean w;
    public RectF x;
    public RectF y;
    public RectF z;

    /* loaded from: classes3.dex */
    public enum DisplayType {
        NONE,
        FIT_TO_SCREEN,
        FIT_IF_BIGGER
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Drawable f11543e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Matrix f11544f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f11545g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f11546h;

        public a(Drawable drawable, Matrix matrix, float f2, float f3) {
            this.f11543e = drawable;
            this.f11544f = matrix;
            this.f11545g = f2;
            this.f11546h = f3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BdImageViewTouchBase.this.setImageDrawable(this.f11543e, this.f11544f, this.f11545g, this.f11546h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public double f11548e = 0.0d;

        /* renamed from: f  reason: collision with root package name */
        public double f11549f = 0.0d;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ double f11550g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f11551h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ double f11552i;
        public final /* synthetic */ double j;

        public b(double d2, long j, double d3, double d4) {
            this.f11550g = d2;
            this.f11551h = j;
            this.f11552i = d3;
            this.j = d4;
        }

        @Override // java.lang.Runnable
        public void run() {
            double min = Math.min(this.f11550g, System.currentTimeMillis() - this.f11551h);
            double a2 = BdImageViewTouchBase.this.f11538e.a(min, 0.0d, this.f11552i, this.f11550g);
            double a3 = BdImageViewTouchBase.this.f11538e.a(min, 0.0d, this.j, this.f11550g);
            BdImageViewTouchBase.this.t(a2 - this.f11548e, a3 - this.f11549f);
            this.f11548e = a2;
            this.f11549f = a3;
            if (min < this.f11550g) {
                BdImageViewTouchBase.this.f11542i.post(this);
                return;
            }
            BdImageViewTouchBase bdImageViewTouchBase = BdImageViewTouchBase.this;
            RectF h2 = bdImageViewTouchBase.h(bdImageViewTouchBase.f11540g, true, true);
            if (h2.left == 0.0f && h2.top == 0.0f) {
                return;
            }
            BdImageViewTouchBase.this.w(h2.left, h2.top);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f11553e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f11554f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f11555g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f11556h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ float f11557i;
        public final /* synthetic */ float j;

        public c(float f2, long j, float f3, float f4, float f5, float f6) {
            this.f11553e = f2;
            this.f11554f = j;
            this.f11555g = f3;
            this.f11556h = f4;
            this.f11557i = f5;
            this.j = f6;
        }

        @Override // java.lang.Runnable
        public void run() {
            float min = Math.min(this.f11553e, (float) (System.currentTimeMillis() - this.f11554f));
            BdImageViewTouchBase.this.B(this.f11556h + ((float) BdImageViewTouchBase.this.f11538e.b(min, 0.0d, this.f11555g, this.f11553e)), this.f11557i, this.j);
            if (min < this.f11553e) {
                BdImageViewTouchBase.this.f11542i.post(this);
                return;
            }
            BdImageViewTouchBase bdImageViewTouchBase = BdImageViewTouchBase.this;
            bdImageViewTouchBase.s(bdImageViewTouchBase.getScale());
            BdImageViewTouchBase.this.a(true, true);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements e {
        public d() {
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.e
        public double a(double d2, double d3, double d4, double d5) {
            double d6 = (d2 / d5) - 1.0d;
            return (d4 * ((d6 * d6 * d6) + 1.0d)) + d3;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.e
        public double b(double d2, double d3, double d4, double d5) {
            double d6;
            double d7 = d2 / (d5 / 2.0d);
            if (d7 < 1.0d) {
                d6 = (d4 / 2.0d) * d7 * d7 * d7;
            } else {
                double d8 = d7 - 2.0d;
                d6 = (d4 / 2.0d) * ((d8 * d8 * d8) + 2.0d);
            }
            return d6 + d3;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        double a(double d2, double d3, double d4, double d5);

        double b(double d2, double d3, double d4, double d5);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(Drawable drawable);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(boolean z, int i2, int i3, int i4, int i5);
    }

    public BdImageViewTouchBase(Context context) {
        this(context, null);
    }

    public void A(float f2, float f3) {
        PointF center = getCenter();
        C(f2, center.x, center.y, f3);
    }

    public void B(float f2, float f3, float f4) {
        if (f2 > getMaxScale()) {
            f2 = getMaxScale();
        }
        u(f2 / getScale(), f3, f4);
        r(getScale());
        a(true, true);
    }

    public void C(float f2, float f3, float f4, float f5) {
        if (f2 > getMaxScale()) {
            f2 = getMaxScale();
        }
        long currentTimeMillis = System.currentTimeMillis();
        float scale = getScale();
        Matrix matrix = new Matrix(this.f11540g);
        matrix.postScale(f2, f2, f3, f4);
        RectF h2 = h(matrix, true, true);
        this.f11542i.post(new c(f5, currentTimeMillis, f2 - scale, scale, f3 + (h2.left * f2), f4 + (h2.top * f2)));
    }

    public void a(boolean z, boolean z2) {
        if (getDrawable() == null) {
            return;
        }
        RectF h2 = h(this.f11540g, z, z2);
        if (h2.left == 0.0f && h2.top == 0.0f) {
            return;
        }
        v(h2.left, h2.top);
    }

    public float b() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return 1.0f;
        }
        return Math.max(drawable.getIntrinsicWidth() / this.r, drawable.getIntrinsicHeight() / this.s) * 8.0f;
    }

    public float c() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.min(1.0f, 1.0f / l(this.f11539f));
    }

    public void d(Drawable drawable, Matrix matrix, float f2, float f3) {
        if (drawable != null) {
            super.setImageDrawable(drawable);
        } else {
            this.f11539f.reset();
            super.setImageDrawable(null);
        }
        if (f2 != -1.0f && f3 != -1.0f) {
            float min = Math.min(f2, f3);
            float max = Math.max(min, f3);
            this.m = min;
            this.l = max;
            this.o = true;
            this.n = true;
        } else {
            this.m = -1.0f;
            this.l = -1.0f;
            this.o = false;
            this.n = false;
        }
        if (matrix != null) {
            this.f11541h = new Matrix(matrix);
        }
        this.w = true;
        requestLayout();
    }

    public void e(Drawable drawable) {
        f fVar = this.A;
        if (fVar != null) {
            fVar.a(drawable);
        }
    }

    public void f(int i2, int i3, int i4, int i5) {
        g gVar = this.B;
        if (gVar != null) {
            gVar.a(true, i2, i3, i4, i5);
        }
    }

    public RectF g(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        Matrix j = j(matrix);
        this.x.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        j.mapRect(this.x);
        return this.x;
    }

    public RectF getBitmapRect() {
        return g(this.f11540g);
    }

    public PointF getCenter() {
        return this.t;
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.f11540g);
    }

    public DisplayType getDisplayType() {
        return this.u;
    }

    public Matrix getImageViewMatrix() {
        return j(this.f11540g);
    }

    public float getMaxScale() {
        if (this.l == -1.0f) {
            this.l = b();
        }
        return this.l;
    }

    public float getMinScale() {
        if (this.m == -1.0f) {
            this.m = c();
        }
        return this.m;
    }

    @Override // android.view.View
    public float getRotation() {
        return 0.0f;
    }

    public float getScale() {
        return l(this.f11540g);
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
        this.y.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF g2 = g(matrix);
        float height = g2.height();
        float width = g2.width();
        if (z2) {
            int i2 = this.s;
            float f5 = i2;
            if (height < f5) {
                f2 = ((f5 - height) / 2.0f) - g2.top;
            } else {
                float f6 = g2.top;
                if (f6 > 0.0f) {
                    f2 = -f6;
                } else {
                    float f7 = g2.bottom;
                    if (f7 < f5) {
                        f2 = i2 - f7;
                    }
                }
            }
            if (z) {
                float f8 = this.r;
                if (width < f8) {
                    f8 = (f8 - width) / 2.0f;
                    f4 = g2.left;
                } else {
                    float f9 = g2.left;
                    if (f9 <= 0.0f) {
                        f4 = g2.right;
                    } else {
                        f3 = -f9;
                        this.y.set(f3, f2, 0.0f, 0.0f);
                        return this.y;
                    }
                }
                f3 = f8 - f4;
                this.y.set(f3, f2, 0.0f, 0.0f);
                return this.y;
            }
            f3 = 0.0f;
            this.y.set(f3, f2, 0.0f, 0.0f);
            return this.y;
        }
        f2 = 0.0f;
        if (z) {
        }
        f3 = 0.0f;
        this.y.set(f3, f2, 0.0f, 0.0f);
        return this.y;
    }

    public float i(DisplayType displayType) {
        if (displayType == DisplayType.FIT_TO_SCREEN) {
            return 1.0f;
        }
        if (displayType == DisplayType.FIT_IF_BIGGER) {
            return Math.max(1.0f, 1.0f / l(this.f11539f));
        }
        return 1.0f / l(this.f11539f);
    }

    public Matrix j(Matrix matrix) {
        this.p.set(this.f11539f);
        this.p.postConcat(matrix);
        return this.p;
    }

    public void k(Drawable drawable, Matrix matrix) {
        float f2 = this.r;
        float f3 = this.s;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        float min = Math.min(f2 / intrinsicWidth, f3 / intrinsicHeight);
        matrix.postScale(min, min);
        matrix.postTranslate((f2 - (intrinsicWidth * min)) / 2.0f, (f3 - (intrinsicHeight * min)) / 2.0f);
    }

    public float l(Matrix matrix) {
        return m(matrix, 0);
    }

    public float m(Matrix matrix, int i2) {
        matrix.getValues(this.q);
        return this.q[i2];
    }

    public void n(Context context, AttributeSet attributeSet, int i2) {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void o(Drawable drawable) {
        e(drawable);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            int i8 = this.r;
            int i9 = this.s;
            int i10 = i4 - i2;
            this.r = i10;
            int i11 = i5 - i3;
            this.s = i11;
            i6 = i10 - i8;
            i7 = i11 - i9;
            PointF pointF = this.t;
            pointF.x = i10 / 2.0f;
            pointF.y = i11 / 2.0f;
        } else {
            i6 = 0;
            i7 = 0;
        }
        Runnable runnable = this.j;
        if (runnable != null) {
            this.j = null;
            runnable.run();
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (z || this.v || this.w) {
                float l = l(this.f11539f);
                float scale = getScale();
                float min = Math.min(1.0f, 1.0f / l);
                if (this.C) {
                    k(drawable, this.f11539f);
                }
                float l2 = l(this.f11539f);
                if (this.w || this.v) {
                    Matrix matrix = this.f11541h;
                    if (matrix != null) {
                        this.f11540g.set(matrix);
                        this.f11541h = null;
                        r12 = getScale();
                    } else {
                        this.f11540g.reset();
                    }
                    setImageMatrix(getImageViewMatrix());
                    if (r12 != getScale()) {
                        z(r12);
                    }
                } else if (z) {
                    if (!this.o) {
                        this.m = -1.0f;
                    }
                    if (!this.n) {
                        this.l = -1.0f;
                    }
                    setImageMatrix(getImageViewMatrix());
                    v(-i6, -i7);
                    if (!this.k) {
                        r12 = i(this.u);
                        z(r12);
                    } else {
                        r12 = ((double) Math.abs(scale - min)) > 0.001d ? (l / l2) * scale : 1.0f;
                        z(r12);
                    }
                }
                this.k = false;
                if (r12 > getMaxScale() || r12 < getMinScale()) {
                    z(r12);
                }
                a(true, true);
                if (this.w) {
                    o(drawable);
                }
                if (z || this.w || this.v) {
                    q(i2, i3, i4, i5);
                }
                if (this.v) {
                    this.v = false;
                }
                if (this.w) {
                    this.w = false;
                    return;
                }
                return;
            }
            return;
        }
        if (this.w) {
            o(null);
        }
        if (z || this.w || this.v) {
            q(i2, i3, i4, i5);
        }
        this.w = false;
        this.v = false;
    }

    public void p() {
    }

    public void q(int i2, int i3, int i4, int i5) {
        f(i2, i3, i4, i5);
    }

    public void r(float f2) {
    }

    public void s(float f2) {
    }

    public void setCalcBaseMatrix(boolean z) {
        this.C = z;
    }

    public void setDisplayType(DisplayType displayType) {
        if (displayType != this.u) {
            this.k = false;
            this.u = displayType;
            this.v = true;
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
        Matrix imageMatrix = getImageMatrix();
        boolean z = (matrix == null && !imageMatrix.isIdentity()) || !(matrix == null || imageMatrix.equals(matrix));
        super.setImageMatrix(matrix);
        if (z) {
            p();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        setImageDrawable(getContext().getResources().getDrawable(i2));
    }

    public void setMaxScale(float f2) {
        this.l = f2;
    }

    public void setMinScale(float f2) {
        this.m = f2;
    }

    public void setOnDrawableChangedListener(f fVar) {
        this.A = fVar;
    }

    public void setOnLayoutChangeListener(g gVar) {
        this.B = gVar;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        }
    }

    public void t(double d2, double d3) {
        RectF bitmapRect = getBitmapRect();
        this.z.set((float) d2, (float) d3, 0.0f, 0.0f);
        y(bitmapRect, this.z);
        RectF rectF = this.z;
        v(rectF.left, rectF.top);
        a(true, true);
    }

    public void u(float f2, float f3, float f4) {
        this.f11540g.postScale(f2, f2, f3, f4);
        setImageMatrix(getImageViewMatrix());
    }

    public void v(float f2, float f3) {
        if (f2 == 0.0f && f3 == 0.0f) {
            return;
        }
        this.f11540g.postTranslate(f2, f3);
        setImageMatrix(getImageViewMatrix());
    }

    public void w(float f2, float f3) {
        t(f2, f3);
    }

    public void x(float f2, float f3, double d2) {
        this.f11542i.post(new b(d2, System.currentTimeMillis(), f2, f3));
    }

    public void y(RectF rectF, RectF rectF2) {
        if (rectF == null) {
            return;
        }
        if (rectF.top >= 0.0f && rectF.bottom <= this.s) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= this.r) {
            rectF2.left = 0.0f;
        }
        float f2 = rectF.top;
        if (rectF2.top + f2 >= 0.0f && rectF.bottom > this.s) {
            rectF2.top = (int) (0.0f - f2);
        }
        float f3 = rectF.bottom;
        int i2 = this.s;
        if (rectF2.top + f3 <= i2 + 0 && rectF.top < 0.0f) {
            rectF2.top = (int) ((i2 + 0) - f3);
        }
        float f4 = rectF.left;
        if (rectF2.left + f4 >= 0.0f) {
            rectF2.left = (int) (0.0f - f4);
        }
        float f5 = rectF.right;
        int i3 = this.r;
        if (rectF2.left + f5 <= i3 + 0) {
            rectF2.left = (int) ((i3 + 0) - f5);
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

    public void setImageBitmap(Bitmap bitmap, Matrix matrix, float f2, float f3) {
        if (bitmap != null) {
            setImageDrawable(new BitmapDrawable(getContext().getResources(), bitmap), matrix, f2, f3);
        } else {
            setImageDrawable(null, matrix, f2, f3);
        }
    }

    public void setImageDrawable(Drawable drawable, Matrix matrix, float f2, float f3) {
        if (getWidth() <= 0) {
            this.j = new a(drawable, matrix, f2, f3);
        } else {
            d(drawable, matrix, f2, f3);
        }
    }

    public BdImageViewTouchBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11538e = new d();
        this.f11539f = new Matrix();
        this.f11540g = new Matrix();
        this.f11542i = new Handler();
        this.j = null;
        this.k = false;
        this.l = -1.0f;
        this.m = -1.0f;
        this.p = new Matrix();
        this.q = new float[9];
        this.r = -1;
        this.s = -1;
        this.t = new PointF();
        this.u = DisplayType.NONE;
        this.x = new RectF();
        this.y = new RectF();
        this.z = new RectF();
        this.C = true;
        n(context, attributeSet, i2);
    }
}
