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
    private Drawable BA;
    protected e Bi;
    private int Bm;
    private ImageView.ScaleType Bn;
    private ImageView.ScaleType Bo;
    protected a Bp;
    private boolean Bq;
    private boolean Br;
    protected boolean Bs;
    private int Bt;
    private int Bu;
    private int Bv;
    private d Bw;
    private boolean Bx;
    private Drawable By;
    private Drawable Bz;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.Bm = 0;
        this.Bn = ImageView.ScaleType.CENTER_INSIDE;
        this.Bo = null;
        this.Bi = new e();
        this.Bq = true;
        this.Bs = true;
        this.Bv = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Bw = new d();
        a(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bm = 0;
        this.Bn = ImageView.ScaleType.CENTER_INSIDE;
        this.Bo = null;
        this.Bi = new e();
        this.Bq = true;
        this.Bs = true;
        this.Bv = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Bw = new d();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Bi.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.Bi.BE = obtainStyledAttributes.getBoolean(1, false);
            this.Bi.BF = obtainStyledAttributes.getBoolean(2, false);
            this.Bi.BG = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.Bi.BH = obtainStyledAttributes.getColor(4, 201326592);
            this.Bi.BJ = obtainStyledAttributes.getBoolean(5, false);
            this.Bi.BK = obtainStyledAttributes.getBoolean(6, true);
            this.Bi.BL = obtainStyledAttributes.getDrawable(7);
            if (this.Bi.BL == null) {
                this.Bi.BL = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.Bi.BN = obtainStyledAttributes.getColor(12, 0);
            this.Bm = obtainStyledAttributes.getInt(8, 0);
            this.Bv = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.Bx = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Bi.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.Bi.BG = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.Bi.BH = 201326592;
            if (this.Bi.BL == null) {
                this.Bi.BL = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.Bp = f.kl().an(this.Bm);
        this.Bp.a(this.Bi);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.Bt = View.MeasureSpec.getMode(i);
        this.Bu = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Bw.getWidth();
        int height = this.Bw.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Bw.isDefault || !this.Bx) {
            max = i(max, this.Bv, i);
            max2 = i(max2, this.mMaxHeight, i2);
        }
        this.Bw.reset();
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
        this.Br = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Bs = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Bw.BC = (BitmapDrawable) getDrawable();
        this.Bw.BD = getBdImage();
        if (this.Bw.kj()) {
            this.Bw.BD = null;
            kg();
            this.Bw.isDefault = false;
            this.BA = this.Bz;
        } else if (this.Bw.kk()) {
            this.Bw.BC = null;
            kg();
            this.Bw.isDefault = false;
            this.BA = this.Bz;
        } else {
            this.Bw.BC = null;
            this.Bw.BD = getDefaultBdImage();
            this.Bw.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Bw.kk() ? this.Bn : scaleType;
            this.BA = this.By;
            scaleType = scaleType2;
        }
        if (this.Bo != scaleType) {
            this.Bo = scaleType;
            this.Bs = true;
        }
    }

    private void kg() {
        if (this.Bw.isDefault) {
            this.Bs = true;
            if (this.Bx || this.Bt != 1073741824 || this.Bu != 1073741824) {
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
                this.Bq = true;
            } else {
                this.Bq = false;
            }
            this.Bs = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.Bq) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.Bp.a(canvas, this, this.BA);
        b(canvas);
        this.Bp.a(canvas, this);
        this.Bw.reset();
    }

    private void ki() {
        if (this.Br && this.Bq && this.Bs) {
            this.Bp.a(this.Bw, this, this.Bo);
            this.Bs = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.Bw.isAvailable()) {
            ki();
            this.Bp.a(canvas, this.Bw, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.Bn != scaleType) {
            this.Bn = scaleType;
            this.Bs = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Bi.mAlpha - f) > 1.0E-4f) {
            this.Bi.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Bi.mRadius != i) {
            this.Bi.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Bi.BE != z) {
            this.Bi.BE = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Bi.BI != z) {
            this.Bi.BI = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Bi.BF != z) {
            this.Bi.BF = z;
            this.Bs = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.Bi.BG != i) {
            this.Bi.BG = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Bi.BH != i) {
            this.Bi.BH = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Bi.BJ != z) {
            this.Bi.BJ = z;
            this.Bs = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Bi.BK != z) {
            this.Bi.BK = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.Bi.BL != drawable) {
            this.Bi.BL = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Bm != i) {
            this.Bm = i;
            this.Bp = f.kl().an(this.Bm);
            this.Bp.a(this.Bi);
            this.Bs = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.Bx) {
            this.Bx = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Bi.BM = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.Bq) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.Bo == ImageView.ScaleType.MATRIX) {
            this.Bp.a(matrix);
            this.Bs = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.Bq ? super.getImageMatrix() : this.Bp.kd();
    }

    public RectF getImageBounds() {
        return this.Bp.ke();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Bw.getWidth();
        this.Bw.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Bw.getHeight();
        this.Bw.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.By = drawable;
    }

    public void setBg(Drawable drawable) {
        this.Bz = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Bi.BN != i) {
            this.Bi.BN = i;
            invalidate();
        }
    }
}
