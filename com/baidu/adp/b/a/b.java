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
    protected e Bd;
    private int Bh;
    private ImageView.ScaleType Bi;
    private ImageView.ScaleType Bj;
    protected a Bk;
    private boolean Bl;
    private boolean Bm;
    protected boolean Bn;
    private int Bo;
    private int Bp;
    private int Bq;
    private d Br;
    private boolean Bs;
    private Drawable Bt;
    private Drawable Bu;
    private Drawable Bv;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.ImageView.a getBdImage();

    protected abstract com.baidu.adp.widget.ImageView.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.Bh = 0;
        this.Bi = ImageView.ScaleType.CENTER_INSIDE;
        this.Bj = null;
        this.Bd = new e();
        this.Bl = true;
        this.Bn = true;
        this.Bq = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Br = new d();
        init(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bh = 0;
        this.Bi = ImageView.ScaleType.CENTER_INSIDE;
        this.Bj = null;
        this.Bd = new e();
        this.Bl = true;
        this.Bn = true;
        this.Bq = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Br = new d();
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Bd.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f));
            this.Bd.Bz = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.Bd.BA = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.Bd.BB = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f));
            this.Bd.BC = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.Bd.BE = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.Bd.BG = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.Bd.BI = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.Bh = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.Bq = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, Integer.MAX_VALUE);
            this.Bs = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Bd.mRadius = com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
            this.Bd.BB = com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f);
            this.Bd.BC = 201326592;
        }
        this.Bk = f.iF().aE(this.Bh);
        this.Bk.a(this.Bd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.Bo = View.MeasureSpec.getMode(i);
        this.Bp = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Br.getWidth();
        int height = this.Br.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Br.isDefault || !this.Bs) {
            max = h(max, this.Bq, i);
            max2 = h(max2, this.mMaxHeight, i2);
        }
        this.Br.reset();
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
        this.Bm = true;
        return frame;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Bn = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Br.Bx = (BitmapDrawable) getDrawable();
        this.Br.By = getBdImage();
        if (this.Br.iD()) {
            this.Br.By = null;
            iA();
            this.Br.isDefault = false;
            this.Bv = this.Bu;
        } else if (this.Br.iE()) {
            this.Br.Bx = null;
            iA();
            this.Br.isDefault = false;
            this.Bv = this.Bu;
        } else {
            this.Br.Bx = null;
            this.Br.By = getDefaultBdImage();
            this.Br.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Br.iE() ? this.Bi : scaleType;
            this.Bv = this.Bt;
            scaleType = scaleType2;
        }
        if (this.Bj != scaleType) {
            this.Bj = scaleType;
            this.Bn = true;
        }
    }

    private void iA() {
        if (this.Br.isDefault) {
            this.Bn = true;
            if (this.Bs || this.Bo != 1073741824 || this.Bp != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        iB();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        iB();
    }

    private void iB() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.Bl = true;
            } else {
                this.Bl = false;
            }
            this.Bn = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.Bl) {
            super.onDraw(canvas);
            c(canvas, this);
            return;
        }
        getDisplayBdImage();
        this.Bk.a(canvas, this, this.Bv);
        d(canvas);
        c(canvas, this);
        this.Bk.a(canvas, this);
        this.Br.reset();
    }

    public void c(Canvas canvas, ImageView imageView) {
    }

    private void iC() {
        if (this.Bm && this.Bl && this.Bn) {
            this.Bk.a(this.Br, this, this.Bj);
            this.Bn = false;
        }
    }

    private void d(Canvas canvas) {
        if (this.Br.isAvailable()) {
            iC();
            this.Bk.a(canvas, this.Br, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.Bi != scaleType) {
            this.Bi = scaleType;
            this.Bn = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Bd.mAlpha - f) > 1.0E-4f) {
            this.Bd.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Bd.mRadius != i) {
            this.Bd.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Bd.Bz != z) {
            this.Bd.Bz = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Bd.BD != z) {
            this.Bd.BD = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Bd.BA != z) {
            this.Bd.BA = z;
            this.Bn = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.Bd.BB != i) {
            this.Bd.BB = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Bd.BC != i) {
            this.Bd.BC = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Bd.BE != z) {
            this.Bd.BE = z;
            this.Bn = true;
            invalidate();
        }
    }

    public void setLongIconSupport(boolean z) {
        if (this.Bd.BF != z) {
            this.Bd.BF = z;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Bd.BG != z) {
            this.Bd.BG = z;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Bh != i) {
            this.Bh = i;
            this.Bk = f.iF().aE(this.Bh);
            this.Bk.a(this.Bd);
            this.Bn = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.Bs) {
            this.Bs = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Bd.BH = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.Bl) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.Bj == ImageView.ScaleType.MATRIX) {
            this.Bk.a(matrix);
            this.Bn = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.Bl ? super.getImageMatrix() : this.Bk.ix();
    }

    public RectF getImageBounds() {
        return this.Bk.iy();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Br.getWidth();
        this.Br.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Br.getHeight();
        this.Br.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.Bt = drawable;
    }

    public void setBg(Drawable drawable) {
        this.Bu = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Bd.BI != i) {
            this.Bd.BI = i;
            invalidate();
        }
    }
}
