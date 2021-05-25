package com.baidu.adp.newwidget.ImageView;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import d.a.c.e.p.l;
import d.a.c.f.a.a;
import d.a.c.f.a.d;
import d.a.c.f.a.e;
import d.a.c.f.a.f;
import d.a.c.f.a.i;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class BDImageView extends ImageView implements ViewTreeObserver.OnPreDrawListener, i {

    /* renamed from: e  reason: collision with root package name */
    public int f2187e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView.ScaleType f2188f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView.ScaleType f2189g;

    /* renamed from: h  reason: collision with root package name */
    public e f2190h;

    /* renamed from: i  reason: collision with root package name */
    public a f2191i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public d q;
    public boolean r;
    public Drawable s;
    public Drawable t;
    public Drawable u;

    public BDImageView(Context context) {
        super(context);
        this.f2187e = 0;
        this.f2188f = ImageView.ScaleType.CENTER_INSIDE;
        this.f2189g = null;
        this.f2190h = new e();
        this.j = true;
        this.l = true;
        this.o = Integer.MAX_VALUE;
        this.p = Integer.MAX_VALUE;
        this.q = new d();
        i(null);
    }

    public static float g(String str) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return 0.0f;
        }
        if (str.endsWith("H")) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        Resources resources = app.getResources();
        Resources resources2 = app.getResources();
        return resources.getDimensionPixelSize(resources2.getIdentifier("tbds" + str, "dimen", app.getPackageName()));
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.q.f39018a = (BitmapDrawable) getDrawable();
        this.q.f39019b = getBdImage();
        if (this.q.e()) {
            this.q.f39019b = null;
            c();
            this.q.f39020c = false;
            this.u = this.t;
        } else if (this.q.d()) {
            this.q.f39018a = null;
            c();
            this.q.f39020c = false;
            this.u = this.t;
        } else {
            d dVar = this.q;
            dVar.f39018a = null;
            dVar.f39019b = getDefaultBdImage();
            this.q.f39020c = true;
            if (this.q.d()) {
                scaleType = this.f2188f;
            }
            this.u = this.s;
        }
        if (this.f2189g != scaleType) {
            this.f2189g = scaleType;
            this.l = true;
        }
    }

    public static float[] h(int i2) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return j(0.0f);
        }
        String[] split = app.getString(i2).split(",");
        int min = Math.min(split.length, 4);
        float[] fArr = new float[8];
        for (int i3 = 0; i3 < min; i3++) {
            float g2 = g(split[i3]);
            int i4 = i3 * 2;
            fArr[i4] = g2;
            fArr[i4 + 1] = g2;
        }
        return fArr;
    }

    public static float[] j(float f2) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, f2);
        return fArr;
    }

    public final void c() {
        if (this.q.f39020c) {
            this.l = true;
            if (!this.r && this.m == 1073741824 && this.n == 1073741824) {
                return;
            }
            requestLayout();
        }
    }

    public final void d() {
        if (this.k && this.j && this.l) {
            this.f2191i.c(this.q, this, this.f2189g);
            this.l = false;
        }
    }

    public final void e(Canvas canvas) {
        if (!this.q.c()) {
            if (this.f2190h.o) {
                this.f2191i.q();
                this.f2191i.a(this.q, this);
                this.f2191i.f(canvas, this);
                return;
            }
            return;
        }
        d();
        this.f2191i.g(canvas, this.q, this);
    }

    public void f(Canvas canvas, ImageView imageView) {
    }

    public abstract d.a.c.j.d.a getBdImage();

    public abstract d.a.c.j.d.a getDefaultBdImage();

    public boolean getDrawBorder() {
        return this.f2190h.f39023c;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int a2 = this.q.a();
        this.q.f();
        return a2;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        if (!this.j) {
            return super.getImageMatrix();
        }
        return this.f2191i.k();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int b2 = this.q.b();
        this.q.f();
        return b2;
    }

    public void i(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.f2190h.f39021a = j(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.e(getContext(), 4.0f)));
            this.f2190h.f39022b = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.f2190h.f39023c = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.f2190h.f39024d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.e(getContext(), 1.0f));
            this.f2190h.f39025e = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.f2190h.f39027g = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.f2190h.f39029i = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.f2190h.m = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.f2187e = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, Integer.MAX_VALUE);
            this.p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, Integer.MAX_VALUE);
            this.r = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.f2190h.f39021a = j(l.e(getContext(), 4.0f));
            this.f2190h.f39024d = l.e(getContext(), 1.0f);
            this.f2190h.f39025e = 201326592;
        }
        a a2 = f.b().a(this.f2187e);
        this.f2191i = a2;
        a2.p(this.f2190h);
    }

    public final int k(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                return mode != 1073741824 ? i2 : size;
            }
            return Math.min(i2, i3);
        }
        return Math.min(Math.min(i2, size), i3);
    }

    public final void l() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            this.j = true;
        } else {
            this.j = false;
        }
        this.l = true;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.j) {
            super.onDraw(canvas);
            f(canvas, this);
            return;
        }
        getDisplayBdImage();
        this.f2191i.d(canvas, this, this.u);
        e(canvas);
        f(canvas, this);
        this.f2191i.i(canvas, this);
        this.q.f();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        this.m = View.MeasureSpec.getMode(i2);
        this.n = View.MeasureSpec.getMode(i3);
        View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getSize(i3);
        getDisplayBdImage();
        int b2 = this.q.b();
        int a2 = this.q.a();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int max = Math.max(b2 + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(a2 + paddingTop, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.q.f39020c || !this.r) {
            max = k(max, this.o, i2);
            max2 = k(max2, this.p, i3);
        }
        this.q.f();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.l = true;
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.r) {
            this.r = z;
            requestLayout();
        }
    }

    public void setAlphaValue(float f2) {
        if (Math.abs(this.f2190h.k - f2) > 1.0E-4f) {
            this.f2190h.k = f2;
            invalidate();
        }
    }

    public void setBg(Drawable drawable) {
        this.t = drawable;
    }

    public void setBorderColor(int i2) {
        e eVar = this.f2190h;
        if (eVar.f39025e != i2) {
            eVar.f39025e = i2;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        e eVar = this.f2190h;
        if (eVar.f39027g != z) {
            eVar.f39027g = z;
            this.l = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        e eVar = this.f2190h;
        if (eVar.f39024d != i2) {
            eVar.f39024d = i2;
            invalidate();
        }
    }

    public void setDefaultBg(Drawable drawable) {
        this.s = drawable;
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.f2188f != scaleType) {
            this.f2188f = scaleType;
            this.l = true;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        e eVar = this.f2190h;
        if (eVar.f39023c != z) {
            eVar.f39023c = z;
            this.l = true;
            invalidate();
        }
    }

    public void setDrawerType(int i2) {
        if (this.f2187e != i2) {
            this.f2187e = i2;
            a a2 = f.b().a(this.f2187e);
            this.f2191i = a2;
            a2.p(this.f2190h);
            this.l = true;
            invalidate();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.f2190h.l = matrix;
        invalidate();
    }

    public void setForegroundColor(int i2) {
        e eVar = this.f2190h;
        if (eVar.m != i2) {
            eVar.m = i2;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        this.k = true;
        return frame;
    }

    public void setGifIconSupport(boolean z) {
        e eVar = this.f2190h;
        if (eVar.f39029i != z) {
            eVar.f39029i = z;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.j) {
            super.setImageMatrix(matrix);
        } else if (matrix == null || this.f2189g != ImageView.ScaleType.MATRIX) {
        } else {
            this.f2191i.n(matrix);
            this.l = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        l();
    }

    public void setIsNight(boolean z) {
        e eVar = this.f2190h;
        if (eVar.f39026f != z) {
            eVar.f39026f = z;
            invalidate();
        }
    }

    public void setIsPreDrawBorder(boolean z) {
        e eVar = this.f2190h;
        if (eVar.o != z) {
            eVar.o = z;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        e eVar = this.f2190h;
        if (eVar.f39022b != z) {
            eVar.f39022b = z;
            invalidate();
        }
    }

    public void setLongIconSupport(boolean z) {
        e eVar = this.f2190h;
        if (eVar.f39028h != z) {
            eVar.f39028h = z;
            invalidate();
        }
    }

    public void setRadius(int i2) {
        float[] j = j(i2);
        if (Arrays.equals(this.f2190h.f39021a, j)) {
            return;
        }
        this.f2190h.f39021a = j;
        invalidate();
    }

    public void setRadiusById(int i2) {
        float[] h2 = h(i2);
        if (Arrays.equals(this.f2190h.f39021a, h2)) {
            return;
        }
        this.f2190h.f39021a = h2;
        invalidate();
    }

    public void setTLIconType(int i2) {
        e eVar = this.f2190h;
        if (eVar.j != i2) {
            eVar.j = i2;
            invalidate();
        }
    }

    public BDImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2187e = 0;
        this.f2188f = ImageView.ScaleType.CENTER_INSIDE;
        this.f2189g = null;
        this.f2190h = new e();
        this.j = true;
        this.l = true;
        this.o = Integer.MAX_VALUE;
        this.p = Integer.MAX_VALUE;
        this.q = new d();
        i(attributeSet);
    }
}
