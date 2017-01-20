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
    private int mMaxHeight;
    protected e uN;
    private int uR;
    private ImageView.ScaleType uS;
    private ImageView.ScaleType uT;
    protected a uU;
    private boolean uV;
    private boolean uW;
    protected boolean uX;
    private int uY;
    private int uZ;
    private int va;
    private d vb;
    private boolean vc;
    private Drawable vd;
    private Drawable ve;
    private Drawable vf;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.uR = 0;
        this.uS = ImageView.ScaleType.CENTER_INSIDE;
        this.uT = null;
        this.uN = new e();
        this.uV = true;
        this.uX = true;
        this.va = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.vb = new d();
        b((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uR = 0;
        this.uS = ImageView.ScaleType.CENTER_INSIDE;
        this.uT = null;
        this.uN = new e();
        this.uV = true;
        this.uX = true;
        this.va = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.vb = new d();
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.uN.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.uN.vj = obtainStyledAttributes.getBoolean(1, false);
            this.uN.vk = obtainStyledAttributes.getBoolean(2, false);
            this.uN.vl = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.uN.vm = obtainStyledAttributes.getColor(4, 201326592);
            this.uN.vo = obtainStyledAttributes.getBoolean(5, false);
            this.uN.vp = obtainStyledAttributes.getBoolean(6, true);
            this.uN.vq = obtainStyledAttributes.getDrawable(7);
            if (this.uN.vq == null) {
                this.uN.vq = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.uN.vs = obtainStyledAttributes.getColor(12, 0);
            this.uR = obtainStyledAttributes.getInt(8, 0);
            this.va = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.vc = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.uN.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.uN.vl = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.uN.vm = 201326592;
            if (this.uN.vq == null) {
                this.uN.vq = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.uU = f.hJ().aC(this.uR);
        this.uU.a(this.uN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.uY = View.MeasureSpec.getMode(i);
        this.uZ = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.vb.getWidth();
        int height = this.vb.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.vb.isDefault || !this.vc) {
            max = h(max, this.va, i);
            max2 = h(max2, this.mMaxHeight, i2);
        }
        this.vb.reset();
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
        this.uW = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.uX = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.vb.vh = (BitmapDrawable) getDrawable();
        this.vb.vi = getBdImage();
        if (this.vb.hH()) {
            this.vb.vi = null;
            hE();
            this.vb.isDefault = false;
            this.vf = this.ve;
        } else if (this.vb.hI()) {
            this.vb.vh = null;
            hE();
            this.vb.isDefault = false;
            this.vf = this.ve;
        } else {
            this.vb.vh = null;
            this.vb.vi = getDefaultBdImage();
            this.vb.isDefault = true;
            ImageView.ScaleType scaleType2 = this.vb.hI() ? this.uS : scaleType;
            this.vf = this.vd;
            scaleType = scaleType2;
        }
        if (this.uT != scaleType) {
            this.uT = scaleType;
            this.uX = true;
        }
    }

    private void hE() {
        if (this.vb.isDefault) {
            this.uX = true;
            if (this.vc || this.uY != 1073741824 || this.uZ != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        hF();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        hF();
    }

    private void hF() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.uV = true;
            } else {
                this.uV = false;
            }
            this.uX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.uV) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.uU.a(canvas, this, this.vf);
        b(canvas);
        this.uU.a(canvas, this);
        this.vb.reset();
    }

    private void hG() {
        if (this.uW && this.uV && this.uX) {
            this.uU.a(this.vb, this, this.uT);
            this.uX = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.vb.isAvailable()) {
            hG();
            this.uU.a(canvas, this.vb, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.uS != scaleType) {
            this.uS = scaleType;
            this.uX = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.uN.mAlpha - f) > 1.0E-4f) {
            this.uN.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.uN.mRadius != i) {
            this.uN.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.uN.vj != z) {
            this.uN.vj = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.uN.vn != z) {
            this.uN.vn = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.uN.vk != z) {
            this.uN.vk = z;
            this.uX = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.uN.vl != i) {
            this.uN.vl = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.uN.vm != i) {
            this.uN.vm = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.uN.vo != z) {
            this.uN.vo = z;
            this.uX = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.uN.vp != z) {
            this.uN.vp = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.uN.vq != drawable) {
            this.uN.vq = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.uR != i) {
            this.uR = i;
            this.uU = f.hJ().aC(this.uR);
            this.uU.a(this.uN);
            this.uX = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.vc) {
            this.vc = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.uN.vr = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.uV) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.uT == ImageView.ScaleType.MATRIX) {
            this.uU.b(matrix);
            this.uX = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.uV ? super.getImageMatrix() : this.uU.hB();
    }

    public RectF getImageBounds() {
        return this.uU.hC();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.vb.getWidth();
        this.vb.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.vb.getHeight();
        this.vb.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.vd = drawable;
    }

    public void setBg(Drawable drawable) {
        this.ve = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.uN.vs != i) {
            this.uN.vs = i;
            invalidate();
        }
    }
}
