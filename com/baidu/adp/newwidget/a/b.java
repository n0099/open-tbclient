package com.baidu.adp.newwidget.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public abstract class b extends ImageView implements i {
    private int mMaxHeight;
    protected e qM;
    private final int qQ;
    private final int qR;
    private final int qS;
    private int qT;
    private ImageView.ScaleType qU;
    private ImageView.ScaleType qV;
    protected a qW;
    private boolean qX;
    private boolean qY;
    protected boolean qZ;
    private int ra;
    private int rb;
    private int rc;
    private d rd;
    private boolean re;
    private Drawable rf;
    private Drawable rg;
    private Drawable rh;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.qQ = 4;
        this.qR = 1;
        this.qS = 201326592;
        this.qT = 0;
        this.qU = ImageView.ScaleType.CENTER_INSIDE;
        this.qV = null;
        this.qM = new e();
        this.qX = true;
        this.qZ = true;
        this.rc = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.rd = new d();
        a(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qQ = 4;
        this.qR = 1;
        this.qS = 201326592;
        this.qT = 0;
        this.qU = ImageView.ScaleType.CENTER_INSIDE;
        this.qV = null;
        this.qM = new e();
        this.qX = true;
        this.qZ = true;
        this.rc = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.rd = new d();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.qM.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f));
            this.qM.rl = obtainStyledAttributes.getBoolean(1, false);
            this.qM.rm = obtainStyledAttributes.getBoolean(2, false);
            this.qM.ro = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f));
            this.qM.rp = obtainStyledAttributes.getColor(4, 201326592);
            this.qM.rr = obtainStyledAttributes.getBoolean(5, false);
            this.qM.rs = obtainStyledAttributes.getBoolean(6, true);
            this.qM.rt = obtainStyledAttributes.getDrawable(7);
            if (this.qM.rt == null) {
                this.qM.rt = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.qM.rv = obtainStyledAttributes.getColor(12, 0);
            this.qT = obtainStyledAttributes.getInt(8, 0);
            this.rc = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.re = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.qM.mRadius = com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
            this.qM.ro = com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f);
            this.qM.rp = 201326592;
            if (this.qM.rt == null) {
                this.qM.rt = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.qW = f.gF().ao(this.qT);
        this.qW.a(this.qM);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.ra = View.MeasureSpec.getMode(i);
        this.rb = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.rd.getWidth();
        int height = this.rd.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.rd.isDefault || !this.re) {
            max = m(max, this.rc, i);
            max2 = m(max2, this.mMaxHeight, i2);
        }
        this.rd.reset();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
    }

    private int m(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        switch (mode) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
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
        this.qY = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.qZ = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.rd.rj = (BitmapDrawable) getDrawable();
        this.rd.rk = getBdImage();
        if (this.rd.gD()) {
            this.rd.rk = null;
            gA();
            this.rd.isDefault = false;
            this.rh = this.rg;
        } else if (this.rd.gE()) {
            this.rd.rj = null;
            gA();
            this.rd.isDefault = false;
            this.rh = this.rg;
        } else {
            this.rd.rj = null;
            this.rd.rk = getDefaultBdImage();
            this.rd.isDefault = true;
            ImageView.ScaleType scaleType2 = this.rd.gE() ? this.qU : scaleType;
            this.rh = this.rf;
            scaleType = scaleType2;
        }
        if (this.qV != scaleType) {
            this.qV = scaleType;
            this.qZ = true;
        }
    }

    private void gA() {
        if (this.rd.isDefault) {
            this.qZ = true;
            if (this.re || this.ra != 1073741824 || this.rb != 1073741824) {
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
                this.qX = true;
            } else {
                this.qX = false;
            }
            this.qZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.qX) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.qW.a(canvas, this, this.rh);
        drawContent(canvas);
        this.qW.a(canvas, this);
        this.rd.reset();
    }

    private void gC() {
        if (this.qY && this.qX && this.qZ) {
            this.qW.a(this.rd, this, this.qV);
            this.qZ = false;
        }
    }

    private void drawContent(Canvas canvas) {
        if (this.rd.isAvailable()) {
            gC();
            this.qW.a(canvas, this.rd, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.qU != scaleType) {
            this.qU = scaleType;
            this.qZ = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.qM.mAlpha - f) > 1.0E-4f) {
            this.qM.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.qM.mRadius != i) {
            this.qM.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.qM.rl != z) {
            this.qM.rl = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.qM.rq != z) {
            this.qM.rq = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.qM.rm != z) {
            this.qM.rm = z;
            this.qZ = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.qM.ro != i) {
            this.qM.ro = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.qM.rp != i) {
            this.qM.rp = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.qM.rr != z) {
            this.qM.rr = z;
            this.qZ = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.qM.rs != z) {
            this.qM.rs = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.qM.rt != drawable) {
            this.qM.rt = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.qT != i) {
            this.qT = i;
            this.qW = f.gF().ao(this.qT);
            this.qW.a(this.qM);
            this.qZ = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.re) {
            this.re = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.qM.ru = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.qX) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.qV == ImageView.ScaleType.MATRIX) {
            this.qW.a(matrix);
            this.qZ = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.qX ? super.getImageMatrix() : this.qW.gx();
    }

    public RectF getImageBounds() {
        return this.qW.gy();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.rd.getWidth();
        this.rd.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.rd.getHeight();
        this.rd.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.rf = drawable;
    }

    public void setBg(Drawable drawable) {
        this.rg = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.qM.rv != i) {
            this.qM.rv = i;
            invalidate();
        }
    }
}
