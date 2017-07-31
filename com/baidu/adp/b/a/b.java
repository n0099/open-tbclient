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
    protected e Df;
    private int Dj;
    private ImageView.ScaleType Dk;
    private ImageView.ScaleType Dl;
    protected a Dm;
    private boolean Dn;
    private boolean Do;
    protected boolean Dp;
    private int Dq;
    private int Dr;
    private d Ds;
    private boolean Dt;
    private Drawable Du;
    private Drawable Dv;
    private Drawable Dw;
    private int mMaxHeight;
    private int mp;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.Dj = 0;
        this.Dk = ImageView.ScaleType.CENTER_INSIDE;
        this.Dl = null;
        this.Df = new e();
        this.Dn = true;
        this.Dp = true;
        this.mp = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Ds = new d();
        init(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Dj = 0;
        this.Dk = ImageView.ScaleType.CENTER_INSIDE;
        this.Dl = null;
        this.Df = new e();
        this.Dn = true;
        this.Dp = true;
        this.mp = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Ds = new d();
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Df.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.Df.DA = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.Df.DB = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.Df.DC = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.Df.DD = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.Df.DF = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.Df.DG = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.Df.DH = obtainStyledAttributes.getDrawable(R.styleable.BDImageView_gifIcon);
            if (this.Df.DH == null) {
                this.Df.DH = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.Df.DJ = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.Dj = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mp = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, Integer.MAX_VALUE);
            this.Dt = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Df.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.Df.DC = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.Df.DD = 201326592;
            if (this.Df.DH == null) {
                this.Df.DH = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.Dm = f.iO().aD(this.Dj);
        this.Dm.a(this.Df);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.Dq = View.MeasureSpec.getMode(i);
        this.Dr = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Ds.getWidth();
        int height = this.Ds.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Ds.isDefault || !this.Dt) {
            max = h(max, this.mp, i);
            max2 = h(max2, this.mMaxHeight, i2);
        }
        this.Ds.reset();
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
        this.Do = true;
        return frame;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Dp = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Ds.Dy = (BitmapDrawable) getDrawable();
        this.Ds.Dz = getBdImage();
        if (this.Ds.iM()) {
            this.Ds.Dz = null;
            iJ();
            this.Ds.isDefault = false;
            this.Dw = this.Dv;
        } else if (this.Ds.iN()) {
            this.Ds.Dy = null;
            iJ();
            this.Ds.isDefault = false;
            this.Dw = this.Dv;
        } else {
            this.Ds.Dy = null;
            this.Ds.Dz = getDefaultBdImage();
            this.Ds.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Ds.iN() ? this.Dk : scaleType;
            this.Dw = this.Du;
            scaleType = scaleType2;
        }
        if (this.Dl != scaleType) {
            this.Dl = scaleType;
            this.Dp = true;
        }
    }

    private void iJ() {
        if (this.Ds.isDefault) {
            this.Dp = true;
            if (this.Dt || this.Dq != 1073741824 || this.Dr != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        iK();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        iK();
    }

    private void iK() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.Dn = true;
            } else {
                this.Dn = false;
            }
            this.Dp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.Dn) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.Dm.a(canvas, this, this.Dw);
        b(canvas);
        this.Dm.a(canvas, this);
        this.Ds.reset();
    }

    private void iL() {
        if (this.Do && this.Dn && this.Dp) {
            this.Dm.a(this.Ds, this, this.Dl);
            this.Dp = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.Ds.isAvailable()) {
            iL();
            this.Dm.a(canvas, this.Ds, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.Dk != scaleType) {
            this.Dk = scaleType;
            this.Dp = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Df.mAlpha - f) > 1.0E-4f) {
            this.Df.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Df.mRadius != i) {
            this.Df.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Df.DA != z) {
            this.Df.DA = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Df.DE != z) {
            this.Df.DE = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Df.DB != z) {
            this.Df.DB = z;
            this.Dp = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.Df.DC != i) {
            this.Df.DC = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Df.DD != i) {
            this.Df.DD = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Df.DF != z) {
            this.Df.DF = z;
            this.Dp = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Df.DG != z) {
            this.Df.DG = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.Df.DH != drawable) {
            this.Df.DH = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Dj != i) {
            this.Dj = i;
            this.Dm = f.iO().aD(this.Dj);
            this.Dm.a(this.Df);
            this.Dp = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.Dt) {
            this.Dt = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Df.DI = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.Dn) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.Dl == ImageView.ScaleType.MATRIX) {
            this.Dm.b(matrix);
            this.Dp = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.Dn ? super.getImageMatrix() : this.Dm.iG();
    }

    public RectF getImageBounds() {
        return this.Dm.iH();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Ds.getWidth();
        this.Ds.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Ds.getHeight();
        this.Ds.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.Du = drawable;
    }

    public void setBg(Drawable drawable) {
        this.Dv = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Df.DJ != i) {
            this.Df.DJ = i;
            invalidate();
        }
    }
}
