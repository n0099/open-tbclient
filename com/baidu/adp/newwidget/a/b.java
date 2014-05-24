package com.baidu.adp.newwidget.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.k;
/* loaded from: classes.dex */
public abstract class b extends ImageView implements g {
    protected e a;
    protected a b;
    protected boolean c;
    private final int d;
    private final int e;
    private final int f;
    private int g;
    private ImageView.ScaleType h;
    private ImageView.ScaleType i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private d p;
    private boolean q;
    private Drawable r;
    private Drawable s;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.d = 4;
        this.e = 1;
        this.f = 637534208;
        this.g = 0;
        this.h = ImageView.ScaleType.CENTER_INSIDE;
        this.i = null;
        this.a = new e();
        this.j = true;
        this.c = true;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
        this.p = new d();
        a((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 4;
        this.e = 1;
        this.f = 637534208;
        this.g = 0;
        this.h = ImageView.ScaleType.CENTER_INSIDE;
        this.i = null;
        this.a = new e();
        this.j = true;
        this.c = true;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
        this.p = new d();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.baidu.adp.g.BDImageView);
            this.a.a = obtainStyledAttributes.getDimensionPixelSize(0, k.a(getContext(), 4.0f));
            this.a.b = obtainStyledAttributes.getBoolean(1, false);
            this.a.c = obtainStyledAttributes.getBoolean(2, false);
            this.a.d = obtainStyledAttributes.getDimensionPixelSize(3, k.a(getContext(), 1.0f));
            this.a.e = obtainStyledAttributes.getColor(4, 637534208);
            this.a.g = obtainStyledAttributes.getBoolean(5, false);
            this.a.h = obtainStyledAttributes.getBoolean(6, true);
            this.a.i = obtainStyledAttributes.getDrawable(7);
            if (this.a.i == null) {
                this.a.i = getResources().getDrawable(com.baidu.adp.c.icon_gif);
            }
            this.a.l = obtainStyledAttributes.getColor(12, 0);
            this.g = obtainStyledAttributes.getInt(8, 0);
            this.n = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.o = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.q = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.a.a = k.a(getContext(), 4.0f);
            this.a.d = k.a(getContext(), 1.0f);
            this.a.e = 637534208;
            if (this.a.i == null) {
                this.a.i = getResources().getDrawable(com.baidu.adp.c.icon_gif);
            }
        }
        this.b = f.a().a(this.g);
        this.b.a(this.a);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.l = View.MeasureSpec.getMode(i);
        this.m = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int d = this.p.d();
        int e = this.p.e();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = e + paddingTop;
        int max = Math.max(d + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.p.c || !this.q) {
            max = a(max, this.n, i);
            max2 = a(max2, this.o, i2);
        }
        this.p.f();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
    }

    private int a(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(Math.min(i, size), i2);
            case 0:
                return Math.min(i, i2);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.k = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.p.a = (BitmapDrawable) getDrawable();
        this.p.b = getBdImage();
        if (this.p.a()) {
            this.p.b = null;
            c();
            this.p.c = false;
            if (this.s != null) {
                setBackgroundDrawable(this.s);
            }
        } else if (this.p.b()) {
            this.p.a = null;
            c();
            this.p.c = false;
            if (this.s != null) {
                setBackgroundDrawable(this.s);
            }
        } else {
            this.p.a = null;
            this.p.b = getDefaultBdImage();
            this.p.c = true;
            ImageView.ScaleType scaleType2 = this.p.b() ? this.h : scaleType;
            if (this.r != null) {
                setBackgroundDrawable(this.r);
            }
            scaleType = scaleType2;
        }
        if (this.i != scaleType) {
            this.i = scaleType;
            this.c = true;
        }
    }

    private void c() {
        if (this.p.c) {
            this.c = true;
            if (this.q || this.l != 1073741824 || this.m != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        d();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        d();
    }

    private void d() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.j = true;
            } else {
                this.j = false;
            }
            this.c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.j) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.b.a(canvas, this);
        a(canvas);
        this.b.b(canvas, this);
        this.p.f();
    }

    private void e() {
        if (this.k && this.j && this.c) {
            this.b.a(this.p, this, this.i);
            this.c = false;
        }
    }

    private void a(Canvas canvas) {
        if (this.p.c()) {
            e();
            this.b.a(canvas, this.p, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.h != scaleType) {
            this.h = scaleType;
            this.c = true;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.a.a != i) {
            this.a.a = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.a.b != z) {
            this.a.b = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.a.f != z) {
            this.a.f = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.a.c != z) {
            this.a.c = z;
            this.c = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.a.d != i) {
            this.a.d = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.a.e != i) {
            this.a.e = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.a.g != z) {
            this.a.g = z;
            this.c = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.a.h != z) {
            this.a.h = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.a.i != drawable) {
            this.a.i = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.g != i) {
            this.g = i;
            this.b = f.a().a(this.g);
            this.b.a(this.a);
            this.c = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.q) {
            this.q = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.a.k = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.j) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.i == ImageView.ScaleType.MATRIX) {
            this.b.a(matrix);
            this.c = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.j ? super.getImageMatrix() : this.b.a();
    }

    public RectF getImageBounds() {
        return this.b.b();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int d = this.p.d();
        this.p.f();
        return d;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int e = this.p.e();
        this.p.f();
        return e;
    }

    public void setDefaultBg(Drawable drawable) {
        this.r = drawable;
    }

    public void setBg(Drawable drawable) {
        this.s = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.a.l != i) {
            this.a.l = i;
            invalidate();
        }
    }

    public boolean a() {
        return this.a.f;
    }
}
