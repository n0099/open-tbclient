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
    protected e BN;
    private int BR;
    private ImageView.ScaleType BS;
    private ImageView.ScaleType BT;
    protected a BU;
    private boolean BV;
    private boolean BW;
    protected boolean BX;
    private int BY;
    private int BZ;
    private int Ca;
    private d Cb;
    private boolean Cc;
    private Drawable Cd;
    private Drawable Ce;
    private Drawable Cf;
    private int mMaxHeight;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.BR = 0;
        this.BS = ImageView.ScaleType.CENTER_INSIDE;
        this.BT = null;
        this.BN = new e();
        this.BV = true;
        this.BX = true;
        this.Ca = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Cb = new d();
        b((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BR = 0;
        this.BS = ImageView.ScaleType.CENTER_INSIDE;
        this.BT = null;
        this.BN = new e();
        this.BV = true;
        this.BX = true;
        this.Ca = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.Cb = new d();
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.BN.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.BN.Cj = obtainStyledAttributes.getBoolean(1, false);
            this.BN.Ck = obtainStyledAttributes.getBoolean(2, false);
            this.BN.Cl = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.BN.Cm = obtainStyledAttributes.getColor(4, 201326592);
            this.BN.Co = obtainStyledAttributes.getBoolean(5, false);
            this.BN.Cp = obtainStyledAttributes.getBoolean(6, true);
            this.BN.Cq = obtainStyledAttributes.getDrawable(7);
            if (this.BN.Cq == null) {
                this.BN.Cq = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.BN.Cs = obtainStyledAttributes.getColor(12, 0);
            this.BR = obtainStyledAttributes.getInt(8, 0);
            this.Ca = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.Cc = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.BN.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.BN.Cl = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.BN.Cm = 201326592;
            if (this.BN.Cq == null) {
                this.BN.Cq = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.BU = f.kC().aw(this.BR);
        this.BU.a(this.BN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.BY = View.MeasureSpec.getMode(i);
        this.BZ = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Cb.getWidth();
        int height = this.Cb.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Cb.isDefault || !this.Cc) {
            max = i(max, this.Ca, i);
            max2 = i(max2, this.mMaxHeight, i2);
        }
        this.Cb.reset();
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
        this.BW = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.BX = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Cb.Ch = (BitmapDrawable) getDrawable();
        this.Cb.Ci = getBdImage();
        if (this.Cb.kA()) {
            this.Cb.Ci = null;
            kx();
            this.Cb.isDefault = false;
            this.Cf = this.Ce;
        } else if (this.Cb.kB()) {
            this.Cb.Ch = null;
            kx();
            this.Cb.isDefault = false;
            this.Cf = this.Ce;
        } else {
            this.Cb.Ch = null;
            this.Cb.Ci = getDefaultBdImage();
            this.Cb.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Cb.kB() ? this.BS : scaleType;
            this.Cf = this.Cd;
            scaleType = scaleType2;
        }
        if (this.BT != scaleType) {
            this.BT = scaleType;
            this.BX = true;
        }
    }

    private void kx() {
        if (this.Cb.isDefault) {
            this.BX = true;
            if (this.Cc || this.BY != 1073741824 || this.BZ != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        ky();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        ky();
    }

    private void ky() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.BV = true;
            } else {
                this.BV = false;
            }
            this.BX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.BV) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.BU.a(canvas, this, this.Cf);
        b(canvas);
        this.BU.a(canvas, this);
        this.Cb.reset();
    }

    private void kz() {
        if (this.BW && this.BV && this.BX) {
            this.BU.a(this.Cb, this, this.BT);
            this.BX = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.Cb.isAvailable()) {
            kz();
            this.BU.a(canvas, this.Cb, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.BS != scaleType) {
            this.BS = scaleType;
            this.BX = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.BN.mAlpha - f) > 1.0E-4f) {
            this.BN.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.BN.mRadius != i) {
            this.BN.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.BN.Cj != z) {
            this.BN.Cj = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.BN.Cn != z) {
            this.BN.Cn = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.BN.Ck != z) {
            this.BN.Ck = z;
            this.BX = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.BN.Cl != i) {
            this.BN.Cl = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.BN.Cm != i) {
            this.BN.Cm = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.BN.Co != z) {
            this.BN.Co = z;
            this.BX = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.BN.Cp != z) {
            this.BN.Cp = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.BN.Cq != drawable) {
            this.BN.Cq = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.BR != i) {
            this.BR = i;
            this.BU = f.kC().aw(this.BR);
            this.BU.a(this.BN);
            this.BX = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.Cc) {
            this.Cc = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.BN.Cr = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.BV) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.BT == ImageView.ScaleType.MATRIX) {
            this.BU.a(matrix);
            this.BX = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.BV ? super.getImageMatrix() : this.BU.ku();
    }

    public RectF getImageBounds() {
        return this.BU.kv();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Cb.getWidth();
        this.Cb.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Cb.getHeight();
        this.Cb.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.Cd = drawable;
    }

    public void setBg(Drawable drawable) {
        this.Ce = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.BN.Cs != i) {
            this.BN.Cs = i;
            invalidate();
        }
    }
}
