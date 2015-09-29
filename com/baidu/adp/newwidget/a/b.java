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
    protected e Bb;
    private int Bf;
    private ImageView.ScaleType Bg;
    private ImageView.ScaleType Bh;
    protected a Bi;
    private boolean Bj;
    private boolean Bk;
    protected boolean Bl;
    private int Bm;
    private int Bn;
    private int Bo;
    private d Bp;
    private boolean Bq;
    private Drawable Br;
    private Drawable Bs;
    private Drawable Bt;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.Bf = 0;
        this.Bg = ImageView.ScaleType.CENTER_INSIDE;
        this.Bh = null;
        this.Bb = new e();
        this.Bj = true;
        this.Bl = true;
        this.Bo = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Bp = new d();
        a(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bf = 0;
        this.Bg = ImageView.ScaleType.CENTER_INSIDE;
        this.Bh = null;
        this.Bb = new e();
        this.Bj = true;
        this.Bl = true;
        this.Bo = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Bp = new d();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Bb.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.Bb.Bx = obtainStyledAttributes.getBoolean(1, false);
            this.Bb.By = obtainStyledAttributes.getBoolean(2, false);
            this.Bb.Bz = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.Bb.BA = obtainStyledAttributes.getColor(4, 201326592);
            this.Bb.BC = obtainStyledAttributes.getBoolean(5, false);
            this.Bb.BD = obtainStyledAttributes.getBoolean(6, true);
            this.Bb.BE = obtainStyledAttributes.getDrawable(7);
            if (this.Bb.BE == null) {
                this.Bb.BE = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.Bb.BG = obtainStyledAttributes.getColor(12, 0);
            this.Bf = obtainStyledAttributes.getInt(8, 0);
            this.Bo = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.Bq = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Bb.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.Bb.Bz = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.Bb.BA = 201326592;
            if (this.Bb.BE == null) {
                this.Bb.BE = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.Bi = f.kj().am(this.Bf);
        this.Bi.a(this.Bb);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.Bm = View.MeasureSpec.getMode(i);
        this.Bn = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Bp.getWidth();
        int height = this.Bp.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Bp.isDefault || !this.Bq) {
            max = i(max, this.Bo, i);
            max2 = i(max2, this.mMaxHeight, i2);
        }
        this.Bp.reset();
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
        this.Bk = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Bl = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Bp.Bv = (BitmapDrawable) getDrawable();
        this.Bp.Bw = getBdImage();
        if (this.Bp.kh()) {
            this.Bp.Bw = null;
            ke();
            this.Bp.isDefault = false;
            this.Bt = this.Bs;
        } else if (this.Bp.ki()) {
            this.Bp.Bv = null;
            ke();
            this.Bp.isDefault = false;
            this.Bt = this.Bs;
        } else {
            this.Bp.Bv = null;
            this.Bp.Bw = getDefaultBdImage();
            this.Bp.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Bp.ki() ? this.Bg : scaleType;
            this.Bt = this.Br;
            scaleType = scaleType2;
        }
        if (this.Bh != scaleType) {
            this.Bh = scaleType;
            this.Bl = true;
        }
    }

    private void ke() {
        if (this.Bp.isDefault) {
            this.Bl = true;
            if (this.Bq || this.Bm != 1073741824 || this.Bn != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        kf();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        kf();
    }

    private void kf() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.Bj = true;
            } else {
                this.Bj = false;
            }
            this.Bl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.Bj) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.Bi.a(canvas, this, this.Bt);
        b(canvas);
        this.Bi.a(canvas, this);
        this.Bp.reset();
    }

    private void kg() {
        if (this.Bk && this.Bj && this.Bl) {
            this.Bi.a(this.Bp, this, this.Bh);
            this.Bl = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.Bp.isAvailable()) {
            kg();
            this.Bi.a(canvas, this.Bp, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.Bg != scaleType) {
            this.Bg = scaleType;
            this.Bl = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Bb.mAlpha - f) > 1.0E-4f) {
            this.Bb.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Bb.mRadius != i) {
            this.Bb.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Bb.Bx != z) {
            this.Bb.Bx = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Bb.BB != z) {
            this.Bb.BB = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Bb.By != z) {
            this.Bb.By = z;
            this.Bl = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.Bb.Bz != i) {
            this.Bb.Bz = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Bb.BA != i) {
            this.Bb.BA = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Bb.BC != z) {
            this.Bb.BC = z;
            this.Bl = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Bb.BD != z) {
            this.Bb.BD = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.Bb.BE != drawable) {
            this.Bb.BE = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Bf != i) {
            this.Bf = i;
            this.Bi = f.kj().am(this.Bf);
            this.Bi.a(this.Bb);
            this.Bl = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.Bq) {
            this.Bq = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Bb.BF = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.Bj) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.Bh == ImageView.ScaleType.MATRIX) {
            this.Bi.a(matrix);
            this.Bl = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.Bj ? super.getImageMatrix() : this.Bi.kb();
    }

    public RectF getImageBounds() {
        return this.Bi.kc();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Bp.getWidth();
        this.Bp.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Bp.getHeight();
        this.Bp.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.Br = drawable;
    }

    public void setBg(Drawable drawable) {
        this.Bs = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Bb.BG != i) {
            this.Bb.BG = i;
            invalidate();
        }
    }
}
