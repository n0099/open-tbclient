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
    protected e Cb;
    private int Cf;
    private ImageView.ScaleType Cg;
    private ImageView.ScaleType Ch;
    protected a Ci;
    private boolean Cj;
    private boolean Ck;
    protected boolean Cl;
    private int Cm;
    private int Cn;
    private int Co;
    private d Cp;
    private boolean Cq;
    private Drawable Cr;
    private Drawable Cs;
    private Drawable Ct;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.Cf = 0;
        this.Cg = ImageView.ScaleType.CENTER_INSIDE;
        this.Ch = null;
        this.Cb = new e();
        this.Cj = true;
        this.Cl = true;
        this.Co = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Cp = new d();
        b((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Cf = 0;
        this.Cg = ImageView.ScaleType.CENTER_INSIDE;
        this.Ch = null;
        this.Cb = new e();
        this.Cj = true;
        this.Cl = true;
        this.Co = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Cp = new d();
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Cb.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.Cb.Cx = obtainStyledAttributes.getBoolean(1, false);
            this.Cb.Cy = obtainStyledAttributes.getBoolean(2, false);
            this.Cb.Cz = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.Cb.CA = obtainStyledAttributes.getColor(4, 201326592);
            this.Cb.CC = obtainStyledAttributes.getBoolean(5, false);
            this.Cb.CD = obtainStyledAttributes.getBoolean(6, true);
            this.Cb.CE = obtainStyledAttributes.getDrawable(7);
            if (this.Cb.CE == null) {
                this.Cb.CE = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.Cb.CG = obtainStyledAttributes.getColor(12, 0);
            this.Cf = obtainStyledAttributes.getInt(8, 0);
            this.Co = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.Cq = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Cb.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.Cb.Cz = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.Cb.CA = 201326592;
            if (this.Cb.CE == null) {
                this.Cb.CE = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.Ci = f.iD().aC(this.Cf);
        this.Ci.a(this.Cb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.Cm = View.MeasureSpec.getMode(i);
        this.Cn = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Cp.getWidth();
        int height = this.Cp.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Cp.isDefault || !this.Cq) {
            max = h(max, this.Co, i);
            max2 = h(max2, this.mMaxHeight, i2);
        }
        this.Cp.reset();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
    }

    private int h(int i, int i2, int i3) {
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
        this.Ck = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Cl = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Cp.Cv = (BitmapDrawable) getDrawable();
        this.Cp.Cw = getBdImage();
        if (this.Cp.iB()) {
            this.Cp.Cw = null;
            iy();
            this.Cp.isDefault = false;
            this.Ct = this.Cs;
        } else if (this.Cp.iC()) {
            this.Cp.Cv = null;
            iy();
            this.Cp.isDefault = false;
            this.Ct = this.Cs;
        } else {
            this.Cp.Cv = null;
            this.Cp.Cw = getDefaultBdImage();
            this.Cp.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Cp.iC() ? this.Cg : scaleType;
            this.Ct = this.Cr;
            scaleType = scaleType2;
        }
        if (this.Ch != scaleType) {
            this.Ch = scaleType;
            this.Cl = true;
        }
    }

    private void iy() {
        if (this.Cp.isDefault) {
            this.Cl = true;
            if (this.Cq || this.Cm != 1073741824 || this.Cn != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        iz();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        iz();
    }

    private void iz() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.Cj = true;
            } else {
                this.Cj = false;
            }
            this.Cl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.Cj) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.Ci.a(canvas, this, this.Ct);
        b(canvas);
        this.Ci.a(canvas, this);
        this.Cp.reset();
    }

    private void iA() {
        if (this.Ck && this.Cj && this.Cl) {
            this.Ci.a(this.Cp, this, this.Ch);
            this.Cl = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.Cp.isAvailable()) {
            iA();
            this.Ci.a(canvas, this.Cp, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.Cg != scaleType) {
            this.Cg = scaleType;
            this.Cl = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Cb.mAlpha - f) > 1.0E-4f) {
            this.Cb.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Cb.mRadius != i) {
            this.Cb.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Cb.Cx != z) {
            this.Cb.Cx = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Cb.CB != z) {
            this.Cb.CB = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Cb.Cy != z) {
            this.Cb.Cy = z;
            this.Cl = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.Cb.Cz != i) {
            this.Cb.Cz = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Cb.CA != i) {
            this.Cb.CA = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Cb.CC != z) {
            this.Cb.CC = z;
            this.Cl = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Cb.CD != z) {
            this.Cb.CD = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.Cb.CE != drawable) {
            this.Cb.CE = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Cf != i) {
            this.Cf = i;
            this.Ci = f.iD().aC(this.Cf);
            this.Ci.a(this.Cb);
            this.Cl = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.Cq) {
            this.Cq = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Cb.CF = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.Cj) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.Ch == ImageView.ScaleType.MATRIX) {
            this.Ci.b(matrix);
            this.Cl = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.Cj ? super.getImageMatrix() : this.Ci.iv();
    }

    public RectF getImageBounds() {
        return this.Ci.iw();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Cp.getWidth();
        this.Cp.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Cp.getHeight();
        this.Cp.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.Cr = drawable;
    }

    public void setBg(Drawable drawable) {
        this.Cs = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Cb.CG != i) {
            this.Cb.CG = i;
            invalidate();
        }
    }
}
