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
    private Drawable BB;
    private Drawable BC;
    protected e Bk;
    private int Bo;
    private ImageView.ScaleType Bp;
    private ImageView.ScaleType Bq;
    protected a Br;
    private boolean Bs;
    private boolean Bt;
    protected boolean Bu;
    private int Bv;
    private int Bw;
    private int Bx;
    private d By;
    private boolean Bz;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.Bo = 0;
        this.Bp = ImageView.ScaleType.CENTER_INSIDE;
        this.Bq = null;
        this.Bk = new e();
        this.Bs = true;
        this.Bu = true;
        this.Bx = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.By = new d();
        a(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bo = 0;
        this.Bp = ImageView.ScaleType.CENTER_INSIDE;
        this.Bq = null;
        this.Bk = new e();
        this.Bs = true;
        this.Bu = true;
        this.Bx = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.By = new d();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Bk.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.Bk.BG = obtainStyledAttributes.getBoolean(1, false);
            this.Bk.BH = obtainStyledAttributes.getBoolean(2, false);
            this.Bk.BI = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.Bk.BJ = obtainStyledAttributes.getColor(4, 201326592);
            this.Bk.BL = obtainStyledAttributes.getBoolean(5, false);
            this.Bk.BM = obtainStyledAttributes.getBoolean(6, true);
            this.Bk.BN = obtainStyledAttributes.getDrawable(7);
            if (this.Bk.BN == null) {
                this.Bk.BN = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.Bk.BP = obtainStyledAttributes.getColor(12, 0);
            this.Bo = obtainStyledAttributes.getInt(8, 0);
            this.Bx = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.Bz = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Bk.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.Bk.BI = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.Bk.BJ = 201326592;
            if (this.Bk.BN == null) {
                this.Bk.BN = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.Br = f.km().an(this.Bo);
        this.Br.a(this.Bk);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.Bv = View.MeasureSpec.getMode(i);
        this.Bw = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.By.getWidth();
        int height = this.By.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.By.isDefault || !this.Bz) {
            max = i(max, this.Bx, i);
            max2 = i(max2, this.mMaxHeight, i2);
        }
        this.By.reset();
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
        this.Bt = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Bu = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.By.BE = (BitmapDrawable) getDrawable();
        this.By.BF = getBdImage();
        if (this.By.kk()) {
            this.By.BF = null;
            kh();
            this.By.isDefault = false;
            this.BC = this.BB;
        } else if (this.By.kl()) {
            this.By.BE = null;
            kh();
            this.By.isDefault = false;
            this.BC = this.BB;
        } else {
            this.By.BE = null;
            this.By.BF = getDefaultBdImage();
            this.By.isDefault = true;
            ImageView.ScaleType scaleType2 = this.By.kl() ? this.Bp : scaleType;
            this.BC = this.BA;
            scaleType = scaleType2;
        }
        if (this.Bq != scaleType) {
            this.Bq = scaleType;
            this.Bu = true;
        }
    }

    private void kh() {
        if (this.By.isDefault) {
            this.Bu = true;
            if (this.Bz || this.Bv != 1073741824 || this.Bw != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        ki();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        ki();
    }

    private void ki() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.Bs = true;
            } else {
                this.Bs = false;
            }
            this.Bu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.Bs) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.Br.a(canvas, this, this.BC);
        b(canvas);
        this.Br.a(canvas, this);
        this.By.reset();
    }

    private void kj() {
        if (this.Bt && this.Bs && this.Bu) {
            this.Br.a(this.By, this, this.Bq);
            this.Bu = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.By.isAvailable()) {
            kj();
            this.Br.a(canvas, this.By, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.Bp != scaleType) {
            this.Bp = scaleType;
            this.Bu = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Bk.mAlpha - f) > 1.0E-4f) {
            this.Bk.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Bk.mRadius != i) {
            this.Bk.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Bk.BG != z) {
            this.Bk.BG = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Bk.BK != z) {
            this.Bk.BK = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Bk.BH != z) {
            this.Bk.BH = z;
            this.Bu = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.Bk.BI != i) {
            this.Bk.BI = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Bk.BJ != i) {
            this.Bk.BJ = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Bk.BL != z) {
            this.Bk.BL = z;
            this.Bu = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Bk.BM != z) {
            this.Bk.BM = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.Bk.BN != drawable) {
            this.Bk.BN = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.Bo != i) {
            this.Bo = i;
            this.Br = f.km().an(this.Bo);
            this.Br.a(this.Bk);
            this.Bu = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.Bz) {
            this.Bz = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Bk.BO = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.Bs) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.Bq == ImageView.ScaleType.MATRIX) {
            this.Br.a(matrix);
            this.Bu = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.Bs ? super.getImageMatrix() : this.Br.ke();
    }

    public RectF getImageBounds() {
        return this.Br.kf();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.By.getWidth();
        this.By.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.By.getHeight();
        this.By.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.BA = drawable;
    }

    public void setBg(Drawable drawable) {
        this.BB = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Bk.BP != i) {
            this.Bk.BP = i;
            invalidate();
        }
    }
}
