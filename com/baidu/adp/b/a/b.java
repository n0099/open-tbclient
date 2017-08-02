package com.baidu.adp.b.a;

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
        init(null);
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
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.BF.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.BF.Cb = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.BF.Cc = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.BF.Cd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.BF.Ce = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.BF.Cg = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.BF.Ch = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.BF.Ci = obtainStyledAttributes.getDrawable(R.styleable.BDImageView_gifIcon);
            if (this.BF.Ci == null) {
                this.BF.Ci = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.BF.Ck = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.BJ = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.BS = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, Integer.MAX_VALUE);
            this.BU = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.BF.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.BF.Cd = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.BF.Ce = 201326592;
            if (this.BF.Ci == null) {
                this.BF.Ci = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.BM = f.iE().aB(this.BJ);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.BP = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.BT.BZ = (BitmapDrawable) getDrawable();
        this.BT.Ca = getBdImage();
        if (this.BT.iC()) {
            this.BT.Ca = null;
            iz();
            this.BT.isDefault = false;
            this.BX = this.BW;
        } else if (this.BT.iD()) {
            this.BT.BZ = null;
            iz();
            this.BT.isDefault = false;
            this.BX = this.BW;
        } else {
            this.BT.BZ = null;
            this.BT.Ca = getDefaultBdImage();
            this.BT.isDefault = true;
            ImageView.ScaleType scaleType2 = this.BT.iD() ? this.BK : scaleType;
            this.BX = this.BV;
            scaleType = scaleType2;
        }
        if (this.BL != scaleType) {
            this.BL = scaleType;
            this.BP = true;
        }
    }

    private void iz() {
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
        iA();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        iA();
    }

    private void iA() {
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

    private void iB() {
        if (this.BO && this.BN && this.BP) {
            this.BM.a(this.BT, this, this.BL);
            this.BP = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.BT.isAvailable()) {
            iB();
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
            this.BM = f.iE().aB(this.BJ);
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
        return !this.BN ? super.getImageMatrix() : this.BM.iw();
    }

    public RectF getImageBounds() {
        return this.BM.ix();
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
