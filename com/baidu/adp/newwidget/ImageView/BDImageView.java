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
import d.b.b.e.p.l;
import d.b.b.f.a.a;
import d.b.b.f.a.d;
import d.b.b.f.a.e;
import d.b.b.f.a.f;
import d.b.b.f.a.i;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class BDImageView extends ImageView implements ViewTreeObserver.OnPreDrawListener, i {

    /* renamed from: e  reason: collision with root package name */
    public int f2179e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView.ScaleType f2180f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView.ScaleType f2181g;

    /* renamed from: h  reason: collision with root package name */
    public e f2182h;
    public a i;
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
        this.f2179e = 0;
        this.f2180f = ImageView.ScaleType.CENTER_INSIDE;
        this.f2181g = null;
        this.f2182h = new e();
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
        this.q.f42155a = (BitmapDrawable) getDrawable();
        this.q.f42156b = getBdImage();
        if (this.q.e()) {
            this.q.f42156b = null;
            c();
            this.q.f42157c = false;
            this.u = this.t;
        } else if (this.q.d()) {
            this.q.f42155a = null;
            c();
            this.q.f42157c = false;
            this.u = this.t;
        } else {
            d dVar = this.q;
            dVar.f42155a = null;
            dVar.f42156b = getDefaultBdImage();
            this.q.f42157c = true;
            if (this.q.d()) {
                scaleType = this.f2180f;
            }
            this.u = this.s;
        }
        if (this.f2181g != scaleType) {
            this.f2181g = scaleType;
            this.l = true;
        }
    }

    public static float[] h(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return j(0.0f);
        }
        String[] split = app.getString(i).split(",");
        int min = Math.min(split.length, 4);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < min; i2++) {
            float g2 = g(split[i2]);
            int i3 = i2 * 2;
            fArr[i3] = g2;
            fArr[i3 + 1] = g2;
        }
        return fArr;
    }

    public static float[] j(float f2) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, f2);
        return fArr;
    }

    public final void c() {
        if (this.q.f42157c) {
            this.l = true;
            if (!this.r && this.m == 1073741824 && this.n == 1073741824) {
                return;
            }
            requestLayout();
        }
    }

    public final void d() {
        if (this.k && this.j && this.l) {
            this.i.c(this.q, this, this.f2181g);
            this.l = false;
        }
    }

    public final void e(Canvas canvas) {
        if (!this.q.c()) {
            if (this.f2182h.o) {
                this.i.q();
                this.i.a(this.q, this);
                this.i.f(canvas, this);
                return;
            }
            return;
        }
        d();
        this.i.g(canvas, this.q, this);
    }

    public void f(Canvas canvas, ImageView imageView) {
    }

    public abstract d.b.b.j.d.a getBdImage();

    public abstract d.b.b.j.d.a getDefaultBdImage();

    public boolean getDrawBorder() {
        return this.f2182h.f42160c;
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
        return this.i.k();
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
            this.f2182h.f42158a = j(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.e(getContext(), 4.0f)));
            this.f2182h.f42159b = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.f2182h.f42160c = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.f2182h.f42161d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.e(getContext(), 1.0f));
            this.f2182h.f42162e = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.f2182h.f42164g = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.f2182h.i = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.f2182h.m = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.f2179e = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, Integer.MAX_VALUE);
            this.p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, Integer.MAX_VALUE);
            this.r = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.f2182h.f42158a = j(l.e(getContext(), 4.0f));
            this.f2182h.f42161d = l.e(getContext(), 1.0f);
            this.f2182h.f42162e = 201326592;
        }
        a a2 = f.b().a(this.f2179e);
        this.i = a2;
        a2.p(this.f2182h);
    }

    public final int k(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                return mode != 1073741824 ? i : size;
            }
            return Math.min(i, i2);
        }
        return Math.min(Math.min(i, size), i2);
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
        this.i.d(canvas, this, this.u);
        e(canvas);
        f(canvas, this);
        this.i.i(canvas, this);
        this.q.f();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.m = View.MeasureSpec.getMode(i);
        this.n = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int b2 = this.q.b();
        int a2 = this.q.a();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int max = Math.max(b2 + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(a2 + paddingTop, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.q.f42157c || !this.r) {
            max = k(max, this.o, i);
            max2 = k(max2, this.p, i2);
        }
        this.q.f();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
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
        if (Math.abs(this.f2182h.k - f2) > 1.0E-4f) {
            this.f2182h.k = f2;
            invalidate();
        }
    }

    public void setBg(Drawable drawable) {
        this.t = drawable;
    }

    public void setBorderColor(int i) {
        e eVar = this.f2182h;
        if (eVar.f42162e != i) {
            eVar.f42162e = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        e eVar = this.f2182h;
        if (eVar.f42164g != z) {
            eVar.f42164g = z;
            this.l = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        e eVar = this.f2182h;
        if (eVar.f42161d != i) {
            eVar.f42161d = i;
            invalidate();
        }
    }

    public void setDefaultBg(Drawable drawable) {
        this.s = drawable;
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.f2180f != scaleType) {
            this.f2180f = scaleType;
            this.l = true;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        e eVar = this.f2182h;
        if (eVar.f42160c != z) {
            eVar.f42160c = z;
            this.l = true;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.f2179e != i) {
            this.f2179e = i;
            a a2 = f.b().a(this.f2179e);
            this.i = a2;
            a2.p(this.f2182h);
            this.l = true;
            invalidate();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.f2182h.l = matrix;
        invalidate();
    }

    public void setForegroundColor(int i) {
        e eVar = this.f2182h;
        if (eVar.m != i) {
            eVar.m = i;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.k = true;
        return frame;
    }

    public void setGifIconSupport(boolean z) {
        e eVar = this.f2182h;
        if (eVar.i != z) {
            eVar.i = z;
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
        } else if (matrix == null || this.f2181g != ImageView.ScaleType.MATRIX) {
        } else {
            this.i.n(matrix);
            this.l = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        l();
    }

    public void setIsNight(boolean z) {
        e eVar = this.f2182h;
        if (eVar.f42163f != z) {
            eVar.f42163f = z;
            invalidate();
        }
    }

    public void setIsPreDrawBorder(boolean z) {
        e eVar = this.f2182h;
        if (eVar.o != z) {
            eVar.o = z;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        e eVar = this.f2182h;
        if (eVar.f42159b != z) {
            eVar.f42159b = z;
            invalidate();
        }
    }

    public void setLongIconSupport(boolean z) {
        e eVar = this.f2182h;
        if (eVar.f42165h != z) {
            eVar.f42165h = z;
            invalidate();
        }
    }

    public void setRadius(int i) {
        float[] j = j(i);
        if (Arrays.equals(this.f2182h.f42158a, j)) {
            return;
        }
        this.f2182h.f42158a = j;
        invalidate();
    }

    public void setRadiusById(int i) {
        float[] h2 = h(i);
        if (Arrays.equals(this.f2182h.f42158a, h2)) {
            return;
        }
        this.f2182h.f42158a = h2;
        invalidate();
    }

    public void setTLIconType(int i) {
        e eVar = this.f2182h;
        if (eVar.j != i) {
            eVar.j = i;
            invalidate();
        }
    }

    public BDImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2179e = 0;
        this.f2180f = ImageView.ScaleType.CENTER_INSIDE;
        this.f2181g = null;
        this.f2182h = new e();
        this.j = true;
        this.l = true;
        this.o = Integer.MAX_VALUE;
        this.p = Integer.MAX_VALUE;
        this.q = new d();
        i(attributeSet);
    }
}
