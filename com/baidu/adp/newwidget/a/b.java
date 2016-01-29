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
    private boolean BA;
    private boolean BB;
    protected boolean BC;
    private int BD;
    private int BE;
    private int BF;
    private d BG;
    private boolean BH;
    private Drawable BI;
    private Drawable BJ;
    private Drawable BK;
    protected e Bs;
    private int Bw;
    private ImageView.ScaleType Bx;
    private ImageView.ScaleType By;
    protected a Bz;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.Bw = 0;
        this.Bx = ImageView.ScaleType.CENTER_INSIDE;
        this.By = null;
        this.Bs = new e();
        this.BA = true;
        this.BC = true;
        this.BF = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.BG = new d();
        b((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bw = 0;
        this.Bx = ImageView.ScaleType.CENTER_INSIDE;
        this.By = null;
        this.Bs = new e();
        this.BA = true;
        this.BC = true;
        this.BF = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.BG = new d();
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Bs.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.Bs.BO = obtainStyledAttributes.getBoolean(1, false);
            this.Bs.BP = obtainStyledAttributes.getBoolean(2, false);
            this.Bs.BQ = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.Bs.BR = obtainStyledAttributes.getColor(4, 201326592);
            this.Bs.BT = obtainStyledAttributes.getBoolean(5, false);
            this.Bs.BU = obtainStyledAttributes.getBoolean(6, true);
            this.Bs.BV = obtainStyledAttributes.getDrawable(7);
            if (this.Bs.BV == null) {
                this.Bs.BV = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.Bs.BX = obtainStyledAttributes.getColor(12, 0);
            this.Bw = obtainStyledAttributes.getInt(8, 0);
            this.BF = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.BH = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Bs.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.Bs.BQ = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.Bs.BR = 201326592;
            if (this.Bs.BV == null) {
                this.Bs.BV = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.Bz = f.kw().az(this.Bw);
        this.Bz.a(this.Bs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.BD = View.MeasureSpec.getMode(i);
        this.BE = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.BG.getWidth();
        int height = this.BG.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.BG.isDefault || !this.BH) {
            max = i(max, this.BF, i);
            max2 = i(max2, this.mMaxHeight, i2);
        }
        this.BG.reset();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
    }

    private int i(int i, int i2, int i3) {
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
        this.BB = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.BC = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.BG.BM = (BitmapDrawable) getDrawable();
        this.BG.BN = getBdImage();
        if (this.BG.ku()) {
            this.BG.BN = null;
            kr();
            this.BG.isDefault = false;
            this.BK = this.BJ;
        } else if (this.BG.kv()) {
            this.BG.BM = null;
            kr();
            this.BG.isDefault = false;
            this.BK = this.BJ;
        } else {
            this.BG.BM = null;
            this.BG.BN = getDefaultBdImage();
            this.BG.isDefault = true;
            ImageView.ScaleType scaleType2 = this.BG.kv() ? this.Bx : scaleType;
            this.BK = this.BI;
            scaleType = scaleType2;
        }
        if (this.By != scaleType) {
            this.By = scaleType;
            this.BC = true;
        }
    }

    private void kr() {
        if (this.BG.isDefault) {
            this.BC = true;
            if (this.BH || this.BD != 1073741824 || this.BE != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        ks();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        ks();
    }

    private void ks() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.BA = true;
            } else {
                this.BA = false;
            }
            this.BC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.BA) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.Bz.a(canvas, this, this.BK);
        b(canvas);
        this.Bz.a(canvas, this);
        this.BG.reset();
    }

    private void kt() {
        if (this.BB && this.BA && this.BC) {
            this.Bz.a(this.BG, this, this.By);
            this.BC = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.BG.isAvailable()) {
            kt();
            this.Bz.a(canvas, this.BG, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.Bx != scaleType) {
            this.Bx = scaleType;
            this.BC = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Bs.mAlpha - f) > 1.0E-4f) {
            this.Bs.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Bs.mRadius != i) {
            this.Bs.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Bs.BO != z) {
            this.Bs.BO = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Bs.BS != z) {
            this.Bs.BS = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Bs.BP != z) {
            this.Bs.BP = z;
            this.BC = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.Bs.BQ != i) {
            this.Bs.BQ = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Bs.BR != i) {
            this.Bs.BR = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Bs.BT != z) {
            this.Bs.BT = z;
            this.BC = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Bs.BU != z) {
            this.Bs.BU = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.Bs.BV != drawable) {
            this.Bs.BV = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Bw != i) {
            this.Bw = i;
            this.Bz = f.kw().az(this.Bw);
            this.Bz.a(this.Bs);
            this.BC = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.BH) {
            this.BH = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Bs.BW = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.BA) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.By == ImageView.ScaleType.MATRIX) {
            this.Bz.a(matrix);
            this.BC = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.BA ? super.getImageMatrix() : this.Bz.ko();
    }

    public RectF getImageBounds() {
        return this.Bz.kp();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.BG.getWidth();
        this.BG.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.BG.getHeight();
        this.BG.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.BI = drawable;
    }

    public void setBg(Drawable drawable) {
        this.BJ = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Bs.BX != i) {
            this.Bs.BX = i;
            invalidate();
        }
    }
}
