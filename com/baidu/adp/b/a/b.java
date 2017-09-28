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
    protected e Bc;
    private int Bg;
    private ImageView.ScaleType Bh;
    private ImageView.ScaleType Bi;
    protected a Bj;
    private boolean Bk;
    private boolean Bl;
    protected boolean Bm;
    private int Bn;
    private int Bo;
    private int Bp;
    private d Bq;
    private boolean Br;
    private Drawable Bs;
    private Drawable Bt;
    private Drawable Bu;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.ImageView.a getBdImage();

    protected abstract com.baidu.adp.widget.ImageView.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.Bg = 0;
        this.Bh = ImageView.ScaleType.CENTER_INSIDE;
        this.Bi = null;
        this.Bc = new e();
        this.Bk = true;
        this.Bm = true;
        this.Bp = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Bq = new d();
        init(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bg = 0;
        this.Bh = ImageView.ScaleType.CENTER_INSIDE;
        this.Bi = null;
        this.Bc = new e();
        this.Bk = true;
        this.Bm = true;
        this.Bp = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Bq = new d();
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Bc.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f));
            this.Bc.By = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.Bc.Bz = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.Bc.BA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f));
            this.Bc.BB = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.Bc.BD = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.Bc.BF = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.Bc.BH = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.Bg = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.Bp = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, Integer.MAX_VALUE);
            this.Br = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Bc.mRadius = com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
            this.Bc.BA = com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f);
            this.Bc.BB = 201326592;
        }
        this.Bj = f.iF().aE(this.Bg);
        this.Bj.a(this.Bc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.Bn = View.MeasureSpec.getMode(i);
        this.Bo = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Bq.getWidth();
        int height = this.Bq.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Bq.isDefault || !this.Br) {
            max = h(max, this.Bp, i);
            max2 = h(max2, this.mMaxHeight, i2);
        }
        this.Bq.reset();
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
        this.Bl = true;
        return frame;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Bm = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Bq.Bw = (BitmapDrawable) getDrawable();
        this.Bq.Bx = getBdImage();
        if (this.Bq.iD()) {
            this.Bq.Bx = null;
            iA();
            this.Bq.isDefault = false;
            this.Bu = this.Bt;
        } else if (this.Bq.iE()) {
            this.Bq.Bw = null;
            iA();
            this.Bq.isDefault = false;
            this.Bu = this.Bt;
        } else {
            this.Bq.Bw = null;
            this.Bq.Bx = getDefaultBdImage();
            this.Bq.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Bq.iE() ? this.Bh : scaleType;
            this.Bu = this.Bs;
            scaleType = scaleType2;
        }
        if (this.Bi != scaleType) {
            this.Bi = scaleType;
            this.Bm = true;
        }
    }

    private void iA() {
        if (this.Bq.isDefault) {
            this.Bm = true;
            if (this.Br || this.Bn != 1073741824 || this.Bo != 1073741824) {
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
                this.Bk = true;
            } else {
                this.Bk = false;
            }
            this.Bm = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.Bk) {
            super.onDraw(canvas);
            c(canvas, this);
            return;
        }
        getDisplayBdImage();
        this.Bj.a(canvas, this, this.Bu);
        d(canvas);
        c(canvas, this);
        this.Bj.a(canvas, this);
        this.Bq.reset();
    }

    public void c(Canvas canvas, ImageView imageView) {
    }

    private void iC() {
        if (this.Bl && this.Bk && this.Bm) {
            this.Bj.a(this.Bq, this, this.Bi);
            this.Bm = false;
        }
    }

    private void d(Canvas canvas) {
        if (this.Bq.isAvailable()) {
            iC();
            this.Bj.a(canvas, this.Bq, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.Bh != scaleType) {
            this.Bh = scaleType;
            this.Bm = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Bc.mAlpha - f) > 1.0E-4f) {
            this.Bc.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Bc.mRadius != i) {
            this.Bc.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Bc.By != z) {
            this.Bc.By = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Bc.BC != z) {
            this.Bc.BC = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Bc.Bz != z) {
            this.Bc.Bz = z;
            this.Bm = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.Bc.BA != i) {
            this.Bc.BA = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Bc.BB != i) {
            this.Bc.BB = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Bc.BD != z) {
            this.Bc.BD = z;
            this.Bm = true;
            invalidate();
        }
    }

    public void setLongIconSupport(boolean z) {
        if (this.Bc.BE != z) {
            this.Bc.BE = z;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Bc.BF != z) {
            this.Bc.BF = z;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Bg != i) {
            this.Bg = i;
            this.Bj = f.iF().aE(this.Bg);
            this.Bj.a(this.Bc);
            this.Bm = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.Br) {
            this.Br = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Bc.BG = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.Bk) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.Bi == ImageView.ScaleType.MATRIX) {
            this.Bj.a(matrix);
            this.Bm = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.Bk ? super.getImageMatrix() : this.Bj.ix();
    }

    public RectF getImageBounds() {
        return this.Bj.iy();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Bq.getWidth();
        this.Bq.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Bq.getHeight();
        this.Bq.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.Bs = drawable;
    }

    public void setBg(Drawable drawable) {
        this.Bt = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Bc.BH != i) {
            this.Bc.BH = i;
            invalidate();
        }
    }
}
