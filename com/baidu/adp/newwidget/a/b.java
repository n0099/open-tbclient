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
    protected e BA;
    private final int BE;
    private final int BF;
    private final int BG;
    private int BH;
    private ImageView.ScaleType BI;
    private ImageView.ScaleType BJ;
    protected a BK;
    private boolean BL;
    private boolean BM;
    protected boolean BN;
    private int BO;
    private int BP;
    private int BQ;
    private d BR;
    private boolean BS;
    private Drawable BT;
    private Drawable BU;
    private Drawable BV;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.BE = 4;
        this.BF = 1;
        this.BG = 201326592;
        this.BH = 0;
        this.BI = ImageView.ScaleType.CENTER_INSIDE;
        this.BJ = null;
        this.BA = new e();
        this.BL = true;
        this.BN = true;
        this.BQ = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.BR = new d();
        a(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BE = 4;
        this.BF = 1;
        this.BG = 201326592;
        this.BH = 0;
        this.BI = ImageView.ScaleType.CENTER_INSIDE;
        this.BJ = null;
        this.BA = new e();
        this.BL = true;
        this.BN = true;
        this.BQ = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.BR = new d();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.BA.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.n.dip2px(getContext(), 4.0f));
            this.BA.BZ = obtainStyledAttributes.getBoolean(1, false);
            this.BA.Ca = obtainStyledAttributes.getBoolean(2, false);
            this.BA.Cb = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.n.dip2px(getContext(), 1.0f));
            this.BA.Cc = obtainStyledAttributes.getColor(4, 201326592);
            this.BA.Ce = obtainStyledAttributes.getBoolean(5, false);
            this.BA.Cf = obtainStyledAttributes.getBoolean(6, true);
            this.BA.Cg = obtainStyledAttributes.getDrawable(7);
            if (this.BA.Cg == null) {
                this.BA.Cg = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.BA.Ci = obtainStyledAttributes.getColor(12, 0);
            this.BH = obtainStyledAttributes.getInt(8, 0);
            this.BQ = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.BS = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.BA.mRadius = com.baidu.adp.lib.util.n.dip2px(getContext(), 4.0f);
            this.BA.Cb = com.baidu.adp.lib.util.n.dip2px(getContext(), 1.0f);
            this.BA.Cc = 201326592;
            if (this.BA.Cg == null) {
                this.BA.Cg = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.BK = f.kb().am(this.BH);
        this.BK.a(this.BA);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.BO = View.MeasureSpec.getMode(i);
        this.BP = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.BR.getWidth();
        int height = this.BR.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.BR.isDefault || !this.BS) {
            max = m(max, this.BQ, i);
            max2 = m(max2, this.mMaxHeight, i2);
        }
        this.BR.reset();
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
        this.BM = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.BN = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.BR.BX = (BitmapDrawable) getDrawable();
        this.BR.BY = getBdImage();
        if (this.BR.jZ()) {
            this.BR.BY = null;
            jW();
            this.BR.isDefault = false;
            this.BV = this.BU;
        } else if (this.BR.ka()) {
            this.BR.BX = null;
            jW();
            this.BR.isDefault = false;
            this.BV = this.BU;
        } else {
            this.BR.BX = null;
            this.BR.BY = getDefaultBdImage();
            this.BR.isDefault = true;
            ImageView.ScaleType scaleType2 = this.BR.ka() ? this.BI : scaleType;
            this.BV = this.BT;
            scaleType = scaleType2;
        }
        if (this.BJ != scaleType) {
            this.BJ = scaleType;
            this.BN = true;
        }
    }

    private void jW() {
        if (this.BR.isDefault) {
            this.BN = true;
            if (this.BS || this.BO != 1073741824 || this.BP != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        jX();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        jX();
    }

    private void jX() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.BL = true;
            } else {
                this.BL = false;
            }
            this.BN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.BL) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.BK.a(canvas, this, this.BV);
        drawContent(canvas);
        this.BK.a(canvas, this);
        this.BR.reset();
    }

    private void jY() {
        if (this.BM && this.BL && this.BN) {
            this.BK.a(this.BR, this, this.BJ);
            this.BN = false;
        }
    }

    private void drawContent(Canvas canvas) {
        if (this.BR.isAvailable()) {
            jY();
            this.BK.a(canvas, this.BR, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.BI != scaleType) {
            this.BI = scaleType;
            this.BN = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.BA.mAlpha - f) > 1.0E-4f) {
            this.BA.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.BA.mRadius != i) {
            this.BA.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.BA.BZ != z) {
            this.BA.BZ = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.BA.Cd != z) {
            this.BA.Cd = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.BA.Ca != z) {
            this.BA.Ca = z;
            this.BN = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.BA.Cb != i) {
            this.BA.Cb = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.BA.Cc != i) {
            this.BA.Cc = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.BA.Ce != z) {
            this.BA.Ce = z;
            this.BN = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.BA.Cf != z) {
            this.BA.Cf = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.BA.Cg != drawable) {
            this.BA.Cg = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.BH != i) {
            this.BH = i;
            this.BK = f.kb().am(this.BH);
            this.BK.a(this.BA);
            this.BN = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.BS) {
            this.BS = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.BA.Ch = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.BL) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.BJ == ImageView.ScaleType.MATRIX) {
            this.BK.a(matrix);
            this.BN = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.BL ? super.getImageMatrix() : this.BK.jT();
    }

    public RectF getImageBounds() {
        return this.BK.jU();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.BR.getWidth();
        this.BR.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.BR.getHeight();
        this.BR.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.BT = drawable;
    }

    public void setBg(Drawable drawable) {
        this.BU = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.BA.Ci != i) {
            this.BA.Ci = i;
            invalidate();
        }
    }
}
