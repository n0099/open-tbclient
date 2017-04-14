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
    protected e BC;
    private int BG;
    private ImageView.ScaleType BH;
    private ImageView.ScaleType BI;
    protected a BJ;
    private boolean BK;
    private boolean BL;
    protected boolean BM;
    private int BN;
    private int BO;
    private int BP;
    private d BQ;
    private boolean BR;
    private Drawable BS;
    private Drawable BT;
    private Drawable BU;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.BG = 0;
        this.BH = ImageView.ScaleType.CENTER_INSIDE;
        this.BI = null;
        this.BC = new e();
        this.BK = true;
        this.BM = true;
        this.BP = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.BQ = new d();
        b((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BG = 0;
        this.BH = ImageView.ScaleType.CENTER_INSIDE;
        this.BI = null;
        this.BC = new e();
        this.BK = true;
        this.BM = true;
        this.BP = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.BQ = new d();
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.BC.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.BC.BY = obtainStyledAttributes.getBoolean(1, false);
            this.BC.BZ = obtainStyledAttributes.getBoolean(2, false);
            this.BC.Ca = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.BC.Cb = obtainStyledAttributes.getColor(4, 201326592);
            this.BC.Cd = obtainStyledAttributes.getBoolean(5, false);
            this.BC.Ce = obtainStyledAttributes.getBoolean(6, true);
            this.BC.Cf = obtainStyledAttributes.getDrawable(7);
            if (this.BC.Cf == null) {
                this.BC.Cf = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.BC.Ch = obtainStyledAttributes.getColor(12, 0);
            this.BG = obtainStyledAttributes.getInt(8, 0);
            this.BP = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.BR = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.BC.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.BC.Ca = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.BC.Cb = 201326592;
            if (this.BC.Cf == null) {
                this.BC.Cf = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.BJ = f.iH().aB(this.BG);
        this.BJ.a(this.BC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.BN = View.MeasureSpec.getMode(i);
        this.BO = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.BQ.getWidth();
        int height = this.BQ.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.BQ.isDefault || !this.BR) {
            max = h(max, this.BP, i);
            max2 = h(max2, this.mMaxHeight, i2);
        }
        this.BQ.reset();
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
        this.BL = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.BM = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.BQ.BW = (BitmapDrawable) getDrawable();
        this.BQ.BX = getBdImage();
        if (this.BQ.iF()) {
            this.BQ.BX = null;
            iC();
            this.BQ.isDefault = false;
            this.BU = this.BT;
        } else if (this.BQ.iG()) {
            this.BQ.BW = null;
            iC();
            this.BQ.isDefault = false;
            this.BU = this.BT;
        } else {
            this.BQ.BW = null;
            this.BQ.BX = getDefaultBdImage();
            this.BQ.isDefault = true;
            ImageView.ScaleType scaleType2 = this.BQ.iG() ? this.BH : scaleType;
            this.BU = this.BS;
            scaleType = scaleType2;
        }
        if (this.BI != scaleType) {
            this.BI = scaleType;
            this.BM = true;
        }
    }

    private void iC() {
        if (this.BQ.isDefault) {
            this.BM = true;
            if (this.BR || this.BN != 1073741824 || this.BO != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        iD();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        iD();
    }

    private void iD() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.BK = true;
            } else {
                this.BK = false;
            }
            this.BM = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.BK) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.BJ.a(canvas, this, this.BU);
        b(canvas);
        this.BJ.a(canvas, this);
        this.BQ.reset();
    }

    private void iE() {
        if (this.BL && this.BK && this.BM) {
            this.BJ.a(this.BQ, this, this.BI);
            this.BM = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.BQ.isAvailable()) {
            iE();
            this.BJ.a(canvas, this.BQ, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.BH != scaleType) {
            this.BH = scaleType;
            this.BM = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.BC.mAlpha - f) > 1.0E-4f) {
            this.BC.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.BC.mRadius != i) {
            this.BC.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.BC.BY != z) {
            this.BC.BY = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.BC.Cc != z) {
            this.BC.Cc = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.BC.BZ != z) {
            this.BC.BZ = z;
            this.BM = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.BC.Ca != i) {
            this.BC.Ca = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.BC.Cb != i) {
            this.BC.Cb = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.BC.Cd != z) {
            this.BC.Cd = z;
            this.BM = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.BC.Ce != z) {
            this.BC.Ce = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.BC.Cf != drawable) {
            this.BC.Cf = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.BG != i) {
            this.BG = i;
            this.BJ = f.iH().aB(this.BG);
            this.BJ.a(this.BC);
            this.BM = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.BR) {
            this.BR = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.BC.Cg = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.BK) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.BI == ImageView.ScaleType.MATRIX) {
            this.BJ.b(matrix);
            this.BM = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.BK ? super.getImageMatrix() : this.BJ.iz();
    }

    public RectF getImageBounds() {
        return this.BJ.iA();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.BQ.getWidth();
        this.BQ.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.BQ.getHeight();
        this.BQ.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.BS = drawable;
    }

    public void setBg(Drawable drawable) {
        this.BT = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.BC.Ch != i) {
            this.BC.Ch = i;
            invalidate();
        }
    }
}
