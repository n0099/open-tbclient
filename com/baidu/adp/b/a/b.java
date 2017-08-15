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
    protected e Dh;
    private int Dl;
    private ImageView.ScaleType Dm;
    private ImageView.ScaleType Dn;
    protected a Do;
    private boolean Dp;
    private boolean Dq;
    protected boolean Dr;
    private int Ds;
    private int Dt;
    private d Du;
    private boolean Dv;
    private Drawable Dw;
    private Drawable Dx;
    private Drawable Dy;
    private int mMaxHeight;
    private int mp;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.Dl = 0;
        this.Dm = ImageView.ScaleType.CENTER_INSIDE;
        this.Dn = null;
        this.Dh = new e();
        this.Dp = true;
        this.Dr = true;
        this.mp = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Du = new d();
        init(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Dl = 0;
        this.Dm = ImageView.ScaleType.CENTER_INSIDE;
        this.Dn = null;
        this.Dh = new e();
        this.Dp = true;
        this.Dr = true;
        this.mp = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Du = new d();
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Dh.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.Dh.DC = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.Dh.DD = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.Dh.DE = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.Dh.DF = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.Dh.DH = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.Dh.DI = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.Dh.DJ = obtainStyledAttributes.getDrawable(R.styleable.BDImageView_gifIcon);
            if (this.Dh.DJ == null) {
                this.Dh.DJ = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.Dh.DL = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.Dl = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mp = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, Integer.MAX_VALUE);
            this.Dv = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Dh.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.Dh.DE = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.Dh.DF = 201326592;
            if (this.Dh.DJ == null) {
                this.Dh.DJ = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.Do = f.iO().aD(this.Dl);
        this.Do.a(this.Dh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.Ds = View.MeasureSpec.getMode(i);
        this.Dt = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Du.getWidth();
        int height = this.Du.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Du.isDefault || !this.Dv) {
            max = h(max, this.mp, i);
            max2 = h(max2, this.mMaxHeight, i2);
        }
        this.Du.reset();
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
        this.Dq = true;
        return frame;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Dr = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Du.DA = (BitmapDrawable) getDrawable();
        this.Du.DB = getBdImage();
        if (this.Du.iM()) {
            this.Du.DB = null;
            iJ();
            this.Du.isDefault = false;
            this.Dy = this.Dx;
        } else if (this.Du.iN()) {
            this.Du.DA = null;
            iJ();
            this.Du.isDefault = false;
            this.Dy = this.Dx;
        } else {
            this.Du.DA = null;
            this.Du.DB = getDefaultBdImage();
            this.Du.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Du.iN() ? this.Dm : scaleType;
            this.Dy = this.Dw;
            scaleType = scaleType2;
        }
        if (this.Dn != scaleType) {
            this.Dn = scaleType;
            this.Dr = true;
        }
    }

    private void iJ() {
        if (this.Du.isDefault) {
            this.Dr = true;
            if (this.Dv || this.Ds != 1073741824 || this.Dt != 1073741824) {
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
                this.Dp = true;
            } else {
                this.Dp = false;
            }
            this.Dr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.Dp) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.Do.a(canvas, this, this.Dy);
        b(canvas);
        this.Do.a(canvas, this);
        this.Du.reset();
    }

    private void iL() {
        if (this.Dq && this.Dp && this.Dr) {
            this.Do.a(this.Du, this, this.Dn);
            this.Dr = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.Du.isAvailable()) {
            iL();
            this.Do.a(canvas, this.Du, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.Dm != scaleType) {
            this.Dm = scaleType;
            this.Dr = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Dh.mAlpha - f) > 1.0E-4f) {
            this.Dh.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Dh.mRadius != i) {
            this.Dh.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Dh.DC != z) {
            this.Dh.DC = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Dh.DG != z) {
            this.Dh.DG = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Dh.DD != z) {
            this.Dh.DD = z;
            this.Dr = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.Dh.DE != i) {
            this.Dh.DE = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Dh.DF != i) {
            this.Dh.DF = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Dh.DH != z) {
            this.Dh.DH = z;
            this.Dr = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Dh.DI != z) {
            this.Dh.DI = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.Dh.DJ != drawable) {
            this.Dh.DJ = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Dl != i) {
            this.Dl = i;
            this.Do = f.iO().aD(this.Dl);
            this.Do.a(this.Dh);
            this.Dr = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.Dv) {
            this.Dv = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Dh.DK = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.Dp) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.Dn == ImageView.ScaleType.MATRIX) {
            this.Do.b(matrix);
            this.Dr = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.Dp ? super.getImageMatrix() : this.Do.iG();
    }

    public RectF getImageBounds() {
        return this.Do.iH();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Du.getWidth();
        this.Du.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Du.getHeight();
        this.Du.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.Dw = drawable;
    }

    public void setBg(Drawable drawable) {
        this.Dx = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Dh.DL != i) {
            this.Dh.DL = i;
            invalidate();
        }
    }
}
