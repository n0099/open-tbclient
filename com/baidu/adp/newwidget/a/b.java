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
import com.baidu.adp.R;
/* loaded from: classes.dex */
public abstract class b extends ImageView implements i {
    private int mMaxHeight;
    protected e qN;
    private final int qR;
    private final int qS;
    private final int qT;
    private int qU;
    private ImageView.ScaleType qV;
    private ImageView.ScaleType qW;
    protected a qX;
    private boolean qY;
    private boolean qZ;
    protected boolean ra;
    private int rb;
    private int rc;
    private int rd;
    private d re;
    private boolean rf;
    private Drawable rg;
    private Drawable rh;
    private Drawable ri;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.qR = 4;
        this.qS = 1;
        this.qT = 201326592;
        this.qU = 0;
        this.qV = ImageView.ScaleType.CENTER_INSIDE;
        this.qW = null;
        this.qN = new e();
        this.qY = true;
        this.ra = true;
        this.rd = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.re = new d();
        a((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qR = 4;
        this.qS = 1;
        this.qT = 201326592;
        this.qU = 0;
        this.qV = ImageView.ScaleType.CENTER_INSIDE;
        this.qW = null;
        this.qN = new e();
        this.qY = true;
        this.ra = true;
        this.rd = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.re = new d();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.qN.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.m.dip2px(getContext(), 4.0f));
            this.qN.rm = obtainStyledAttributes.getBoolean(1, false);
            this.qN.ro = obtainStyledAttributes.getBoolean(2, false);
            this.qN.rp = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.m.dip2px(getContext(), 1.0f));
            this.qN.rq = obtainStyledAttributes.getColor(4, 201326592);
            this.qN.rs = obtainStyledAttributes.getBoolean(5, false);
            this.qN.rt = obtainStyledAttributes.getBoolean(6, true);
            this.qN.ru = obtainStyledAttributes.getDrawable(7);
            if (this.qN.ru == null) {
                this.qN.ru = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.qN.rw = obtainStyledAttributes.getColor(12, 0);
            this.qU = obtainStyledAttributes.getInt(8, 0);
            this.rd = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.rf = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.qN.mRadius = com.baidu.adp.lib.util.m.dip2px(getContext(), 4.0f);
            this.qN.rp = com.baidu.adp.lib.util.m.dip2px(getContext(), 1.0f);
            this.qN.rq = 201326592;
            if (this.qN.ru == null) {
                this.qN.ru = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.qX = f.gF().ab(this.qU);
        this.qX.a(this.qN);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.rb = View.MeasureSpec.getMode(i);
        this.rc = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.re.getWidth();
        int height = this.re.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.re.isDefault || !this.rf) {
            max = h(max, this.rd, i);
            max2 = h(max2, this.mMaxHeight, i2);
        }
        this.re.reset();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
    }

    private int h(int i, int i2, int i3) {
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
        this.qZ = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.ra = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.re.rk = (BitmapDrawable) getDrawable();
        this.re.rl = getBdImage();
        if (this.re.gD()) {
            this.re.rl = null;
            gA();
            this.re.isDefault = false;
            this.ri = this.rh;
        } else if (this.re.gE()) {
            this.re.rk = null;
            gA();
            this.re.isDefault = false;
            this.ri = this.rh;
        } else {
            this.re.rk = null;
            this.re.rl = getDefaultBdImage();
            this.re.isDefault = true;
            ImageView.ScaleType scaleType2 = this.re.gE() ? this.qV : scaleType;
            this.ri = this.rg;
            scaleType = scaleType2;
        }
        if (this.qW != scaleType) {
            this.qW = scaleType;
            this.ra = true;
        }
    }

    private void gA() {
        if (this.re.isDefault) {
            this.ra = true;
            if (this.rf || this.rb != 1073741824 || this.rc != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        gB();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        gB();
    }

    private void gB() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.qY = true;
            } else {
                this.qY = false;
            }
            this.ra = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.qY) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.qX.a(canvas, this, this.ri);
        a(canvas);
        this.qX.a(canvas, this);
        this.re.reset();
    }

    private void gC() {
        if (this.qZ && this.qY && this.ra) {
            this.qX.a(this.re, this, this.qW);
            this.ra = false;
        }
    }

    private void a(Canvas canvas) {
        if (this.re.isAvailable()) {
            gC();
            this.qX.a(canvas, this.re, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.qV != scaleType) {
            this.qV = scaleType;
            this.ra = true;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.qN.mRadius != i) {
            this.qN.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.qN.rm != z) {
            this.qN.rm = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.qN.rr != z) {
            this.qN.rr = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.qN.ro != z) {
            this.qN.ro = z;
            this.ra = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.qN.rp != i) {
            this.qN.rp = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.qN.rq != i) {
            this.qN.rq = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.qN.rs != z) {
            this.qN.rs = z;
            this.ra = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.qN.rt != z) {
            this.qN.rt = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.qN.ru != drawable) {
            this.qN.ru = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.qU != i) {
            this.qU = i;
            this.qX = f.gF().ab(this.qU);
            this.qX.a(this.qN);
            this.ra = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.rf) {
            this.rf = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.qN.rv = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.qY) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.qW == ImageView.ScaleType.MATRIX) {
            this.qX.a(matrix);
            this.ra = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.qY ? super.getImageMatrix() : this.qX.gx();
    }

    public RectF getImageBounds() {
        return this.qX.gy();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.re.getWidth();
        this.re.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.re.getHeight();
        this.re.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.rg = drawable;
    }

    public void setBg(Drawable drawable) {
        this.rh = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.qN.rw != i) {
            this.qN.rw = i;
            invalidate();
        }
    }
}
