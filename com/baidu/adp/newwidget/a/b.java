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
    protected e Ba;
    private int Be;
    private ImageView.ScaleType Bf;
    private ImageView.ScaleType Bg;
    protected a Bh;
    private boolean Bi;
    private boolean Bj;
    protected boolean Bk;
    private int Bl;
    private int Bm;
    private int Bn;
    private d Bo;
    private boolean Bp;
    private Drawable Bq;
    private Drawable Br;
    private Drawable Bs;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.Be = 0;
        this.Bf = ImageView.ScaleType.CENTER_INSIDE;
        this.Bg = null;
        this.Ba = new e();
        this.Bi = true;
        this.Bk = true;
        this.Bn = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Bo = new d();
        a(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Be = 0;
        this.Bf = ImageView.ScaleType.CENTER_INSIDE;
        this.Bg = null;
        this.Ba = new e();
        this.Bi = true;
        this.Bk = true;
        this.Bn = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Bo = new d();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Ba.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.Ba.Bw = obtainStyledAttributes.getBoolean(1, false);
            this.Ba.Bx = obtainStyledAttributes.getBoolean(2, false);
            this.Ba.By = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.Ba.Bz = obtainStyledAttributes.getColor(4, 201326592);
            this.Ba.BB = obtainStyledAttributes.getBoolean(5, false);
            this.Ba.BC = obtainStyledAttributes.getBoolean(6, true);
            this.Ba.BD = obtainStyledAttributes.getDrawable(7);
            if (this.Ba.BD == null) {
                this.Ba.BD = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.Ba.BF = obtainStyledAttributes.getColor(12, 0);
            this.Be = obtainStyledAttributes.getInt(8, 0);
            this.Bn = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.Bp = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Ba.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.Ba.By = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.Ba.Bz = 201326592;
            if (this.Ba.BD == null) {
                this.Ba.BD = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.Bh = f.ki().am(this.Be);
        this.Bh.a(this.Ba);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.Bl = View.MeasureSpec.getMode(i);
        this.Bm = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Bo.getWidth();
        int height = this.Bo.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Bo.isDefault || !this.Bp) {
            max = i(max, this.Bn, i);
            max2 = i(max2, this.mMaxHeight, i2);
        }
        this.Bo.reset();
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
        this.Bj = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Bk = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Bo.Bu = (BitmapDrawable) getDrawable();
        this.Bo.Bv = getBdImage();
        if (this.Bo.kg()) {
            this.Bo.Bv = null;
            kd();
            this.Bo.isDefault = false;
            this.Bs = this.Br;
        } else if (this.Bo.kh()) {
            this.Bo.Bu = null;
            kd();
            this.Bo.isDefault = false;
            this.Bs = this.Br;
        } else {
            this.Bo.Bu = null;
            this.Bo.Bv = getDefaultBdImage();
            this.Bo.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Bo.kh() ? this.Bf : scaleType;
            this.Bs = this.Bq;
            scaleType = scaleType2;
        }
        if (this.Bg != scaleType) {
            this.Bg = scaleType;
            this.Bk = true;
        }
    }

    private void kd() {
        if (this.Bo.isDefault) {
            this.Bk = true;
            if (this.Bp || this.Bl != 1073741824 || this.Bm != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        ke();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        ke();
    }

    private void ke() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.Bi = true;
            } else {
                this.Bi = false;
            }
            this.Bk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.Bi) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.Bh.a(canvas, this, this.Bs);
        b(canvas);
        this.Bh.a(canvas, this);
        this.Bo.reset();
    }

    private void kf() {
        if (this.Bj && this.Bi && this.Bk) {
            this.Bh.a(this.Bo, this, this.Bg);
            this.Bk = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.Bo.isAvailable()) {
            kf();
            this.Bh.a(canvas, this.Bo, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.Bf != scaleType) {
            this.Bf = scaleType;
            this.Bk = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Ba.mAlpha - f) > 1.0E-4f) {
            this.Ba.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Ba.mRadius != i) {
            this.Ba.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Ba.Bw != z) {
            this.Ba.Bw = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Ba.BA != z) {
            this.Ba.BA = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Ba.Bx != z) {
            this.Ba.Bx = z;
            this.Bk = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.Ba.By != i) {
            this.Ba.By = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Ba.Bz != i) {
            this.Ba.Bz = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Ba.BB != z) {
            this.Ba.BB = z;
            this.Bk = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Ba.BC != z) {
            this.Ba.BC = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.Ba.BD != drawable) {
            this.Ba.BD = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Be != i) {
            this.Be = i;
            this.Bh = f.ki().am(this.Be);
            this.Bh.a(this.Ba);
            this.Bk = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.Bp) {
            this.Bp = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Ba.BE = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.Bi) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.Bg == ImageView.ScaleType.MATRIX) {
            this.Bh.a(matrix);
            this.Bk = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.Bi ? super.getImageMatrix() : this.Bh.ka();
    }

    public RectF getImageBounds() {
        return this.Bh.kb();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Bo.getWidth();
        this.Bo.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Bo.getHeight();
        this.Bo.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.Bq = drawable;
    }

    public void setBg(Drawable drawable) {
        this.Br = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Ba.BF != i) {
            this.Ba.BF = i;
            invalidate();
        }
    }
}
