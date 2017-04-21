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
    protected e BF;
    private int BJ;
    private ImageView.ScaleType BK;
    private ImageView.ScaleType BL;
    protected a BM;
    private boolean BN;
    private boolean BO;
    protected boolean BP;
    private int BQ;
    private int BR;
    private int BS;
    private d BT;
    private boolean BU;
    private Drawable BV;
    private Drawable BW;
    private Drawable BX;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.BJ = 0;
        this.BK = ImageView.ScaleType.CENTER_INSIDE;
        this.BL = null;
        this.BF = new e();
        this.BN = true;
        this.BP = true;
        this.BS = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.BT = new d();
        b((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BJ = 0;
        this.BK = ImageView.ScaleType.CENTER_INSIDE;
        this.BL = null;
        this.BF = new e();
        this.BN = true;
        this.BP = true;
        this.BS = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.BT = new d();
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.BF.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.BF.Cb = obtainStyledAttributes.getBoolean(1, false);
            this.BF.Cc = obtainStyledAttributes.getBoolean(2, false);
            this.BF.Cd = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.BF.Ce = obtainStyledAttributes.getColor(4, 201326592);
            this.BF.Cg = obtainStyledAttributes.getBoolean(5, false);
            this.BF.Ch = obtainStyledAttributes.getBoolean(6, true);
            this.BF.Ci = obtainStyledAttributes.getDrawable(7);
            if (this.BF.Ci == null) {
                this.BF.Ci = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.BF.Ck = obtainStyledAttributes.getColor(12, 0);
            this.BJ = obtainStyledAttributes.getInt(8, 0);
            this.BS = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.BU = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.BF.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.BF.Cd = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.BF.Ce = 201326592;
            if (this.BF.Ci == null) {
                this.BF.Ci = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.BM = f.iI().aB(this.BJ);
        this.BM.a(this.BF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.BQ = View.MeasureSpec.getMode(i);
        this.BR = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.BT.getWidth();
        int height = this.BT.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.BT.isDefault || !this.BU) {
            max = h(max, this.BS, i);
            max2 = h(max2, this.mMaxHeight, i2);
        }
        this.BT.reset();
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
        this.BO = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.BP = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.BT.BZ = (BitmapDrawable) getDrawable();
        this.BT.Ca = getBdImage();
        if (this.BT.iG()) {
            this.BT.Ca = null;
            iD();
            this.BT.isDefault = false;
            this.BX = this.BW;
        } else if (this.BT.iH()) {
            this.BT.BZ = null;
            iD();
            this.BT.isDefault = false;
            this.BX = this.BW;
        } else {
            this.BT.BZ = null;
            this.BT.Ca = getDefaultBdImage();
            this.BT.isDefault = true;
            ImageView.ScaleType scaleType2 = this.BT.iH() ? this.BK : scaleType;
            this.BX = this.BV;
            scaleType = scaleType2;
        }
        if (this.BL != scaleType) {
            this.BL = scaleType;
            this.BP = true;
        }
    }

    private void iD() {
        if (this.BT.isDefault) {
            this.BP = true;
            if (this.BU || this.BQ != 1073741824 || this.BR != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        iE();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        iE();
    }

    private void iE() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.BN = true;
            } else {
                this.BN = false;
            }
            this.BP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.BN) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.BM.a(canvas, this, this.BX);
        b(canvas);
        this.BM.a(canvas, this);
        this.BT.reset();
    }

    private void iF() {
        if (this.BO && this.BN && this.BP) {
            this.BM.a(this.BT, this, this.BL);
            this.BP = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.BT.isAvailable()) {
            iF();
            this.BM.a(canvas, this.BT, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.BK != scaleType) {
            this.BK = scaleType;
            this.BP = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.BF.mAlpha - f) > 1.0E-4f) {
            this.BF.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.BF.mRadius != i) {
            this.BF.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.BF.Cb != z) {
            this.BF.Cb = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.BF.Cf != z) {
            this.BF.Cf = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.BF.Cc != z) {
            this.BF.Cc = z;
            this.BP = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.BF.Cd != i) {
            this.BF.Cd = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.BF.Ce != i) {
            this.BF.Ce = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.BF.Cg != z) {
            this.BF.Cg = z;
            this.BP = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.BF.Ch != z) {
            this.BF.Ch = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.BF.Ci != drawable) {
            this.BF.Ci = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.BJ != i) {
            this.BJ = i;
            this.BM = f.iI().aB(this.BJ);
            this.BM.a(this.BF);
            this.BP = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.BU) {
            this.BU = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.BF.Cj = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.BN) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.BL == ImageView.ScaleType.MATRIX) {
            this.BM.b(matrix);
            this.BP = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.BN ? super.getImageMatrix() : this.BM.iA();
    }

    public RectF getImageBounds() {
        return this.BM.iB();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.BT.getWidth();
        this.BT.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.BT.getHeight();
        this.BT.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.BV = drawable;
    }

    public void setBg(Drawable drawable) {
        this.BW = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.BF.Ck != i) {
            this.BF.Ck = i;
            invalidate();
        }
    }
}
