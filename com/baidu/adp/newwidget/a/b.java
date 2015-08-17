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

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

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
        a(null);
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
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Bc.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.Bc.By = obtainStyledAttributes.getBoolean(1, false);
            this.Bc.Bz = obtainStyledAttributes.getBoolean(2, false);
            this.Bc.BA = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.Bc.BB = obtainStyledAttributes.getColor(4, 201326592);
            this.Bc.BD = obtainStyledAttributes.getBoolean(5, false);
            this.Bc.BE = obtainStyledAttributes.getBoolean(6, true);
            this.Bc.BF = obtainStyledAttributes.getDrawable(7);
            if (this.Bc.BF == null) {
                this.Bc.BF = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.Bc.BH = obtainStyledAttributes.getColor(12, 0);
            this.Bg = obtainStyledAttributes.getInt(8, 0);
            this.Bp = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.Br = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Bc.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.Bc.BA = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.Bc.BB = 201326592;
            if (this.Bc.BF == null) {
                this.Bc.BF = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.Bj = f.kl().am(this.Bg);
        this.Bj.a(this.Bc);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
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
            max = j(max, this.Bp, i);
            max2 = j(max2, this.mMaxHeight, i2);
        }
        this.Bq.reset();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
    }

    private int j(int i, int i2, int i3) {
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

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Bm = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Bq.Bw = (BitmapDrawable) getDrawable();
        this.Bq.Bx = getBdImage();
        if (this.Bq.kj()) {
            this.Bq.Bx = null;
            kg();
            this.Bq.isDefault = false;
            this.Bu = this.Bt;
        } else if (this.Bq.kk()) {
            this.Bq.Bw = null;
            kg();
            this.Bq.isDefault = false;
            this.Bu = this.Bt;
        } else {
            this.Bq.Bw = null;
            this.Bq.Bx = getDefaultBdImage();
            this.Bq.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Bq.kk() ? this.Bh : scaleType;
            this.Bu = this.Bs;
            scaleType = scaleType2;
        }
        if (this.Bi != scaleType) {
            this.Bi = scaleType;
            this.Bm = true;
        }
    }

    private void kg() {
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
        kh();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        kh();
    }

    private void kh() {
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
            return;
        }
        getDisplayBdImage();
        this.Bj.a(canvas, this, this.Bu);
        b(canvas);
        this.Bj.a(canvas, this);
        this.Bq.reset();
    }

    private void ki() {
        if (this.Bl && this.Bk && this.Bm) {
            this.Bj.a(this.Bq, this, this.Bi);
            this.Bm = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.Bq.isAvailable()) {
            ki();
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

    public void setGifIconSupport(boolean z) {
        if (this.Bc.BE != z) {
            this.Bc.BE = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.Bc.BF != drawable) {
            this.Bc.BF = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Bg != i) {
            this.Bg = i;
            this.Bj = f.kl().am(this.Bg);
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
        return !this.Bk ? super.getImageMatrix() : this.Bj.kd();
    }

    public RectF getImageBounds() {
        return this.Bj.ke();
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
