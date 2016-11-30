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
    protected e uW;
    private int va;
    private ImageView.ScaleType vb;
    private ImageView.ScaleType vc;
    protected a vd;
    private boolean ve;
    private boolean vf;
    protected boolean vg;
    private int vh;
    private int vi;
    private int vj;
    private d vk;
    private boolean vl;
    private Drawable vm;
    private Drawable vn;
    private Drawable vo;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.va = 0;
        this.vb = ImageView.ScaleType.CENTER_INSIDE;
        this.vc = null;
        this.uW = new e();
        this.ve = true;
        this.vg = true;
        this.vj = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.vk = new d();
        b((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.va = 0;
        this.vb = ImageView.ScaleType.CENTER_INSIDE;
        this.vc = null;
        this.uW = new e();
        this.ve = true;
        this.vg = true;
        this.vj = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.vk = new d();
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.uW.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.uW.vs = obtainStyledAttributes.getBoolean(1, false);
            this.uW.vt = obtainStyledAttributes.getBoolean(2, false);
            this.uW.vu = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.uW.vv = obtainStyledAttributes.getColor(4, 201326592);
            this.uW.vx = obtainStyledAttributes.getBoolean(5, false);
            this.uW.vy = obtainStyledAttributes.getBoolean(6, true);
            this.uW.vz = obtainStyledAttributes.getDrawable(7);
            if (this.uW.vz == null) {
                this.uW.vz = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.uW.vB = obtainStyledAttributes.getColor(12, 0);
            this.va = obtainStyledAttributes.getInt(8, 0);
            this.vj = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.vl = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.uW.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.uW.vu = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.uW.vv = 201326592;
            if (this.uW.vz == null) {
                this.uW.vz = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.vd = f.hL().aB(this.va);
        this.vd.a(this.uW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.vh = View.MeasureSpec.getMode(i);
        this.vi = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.vk.getWidth();
        int height = this.vk.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.vk.isDefault || !this.vl) {
            max = i(max, this.vj, i);
            max2 = i(max2, this.mMaxHeight, i2);
        }
        this.vk.reset();
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
        this.vf = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.vg = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.vk.vq = (BitmapDrawable) getDrawable();
        this.vk.vr = getBdImage();
        if (this.vk.hJ()) {
            this.vk.vr = null;
            hG();
            this.vk.isDefault = false;
            this.vo = this.vn;
        } else if (this.vk.hK()) {
            this.vk.vq = null;
            hG();
            this.vk.isDefault = false;
            this.vo = this.vn;
        } else {
            this.vk.vq = null;
            this.vk.vr = getDefaultBdImage();
            this.vk.isDefault = true;
            ImageView.ScaleType scaleType2 = this.vk.hK() ? this.vb : scaleType;
            this.vo = this.vm;
            scaleType = scaleType2;
        }
        if (this.vc != scaleType) {
            this.vc = scaleType;
            this.vg = true;
        }
    }

    private void hG() {
        if (this.vk.isDefault) {
            this.vg = true;
            if (this.vl || this.vh != 1073741824 || this.vi != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        hH();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        hH();
    }

    private void hH() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.ve = true;
            } else {
                this.ve = false;
            }
            this.vg = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.ve) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.vd.a(canvas, this, this.vo);
        b(canvas);
        this.vd.a(canvas, this);
        this.vk.reset();
    }

    private void hI() {
        if (this.vf && this.ve && this.vg) {
            this.vd.a(this.vk, this, this.vc);
            this.vg = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.vk.isAvailable()) {
            hI();
            this.vd.a(canvas, this.vk, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.vb != scaleType) {
            this.vb = scaleType;
            this.vg = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.uW.mAlpha - f) > 1.0E-4f) {
            this.uW.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.uW.mRadius != i) {
            this.uW.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.uW.vs != z) {
            this.uW.vs = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.uW.vw != z) {
            this.uW.vw = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.uW.vt != z) {
            this.uW.vt = z;
            this.vg = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.uW.vu != i) {
            this.uW.vu = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.uW.vv != i) {
            this.uW.vv = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.uW.vx != z) {
            this.uW.vx = z;
            this.vg = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.uW.vy != z) {
            this.uW.vy = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.uW.vz != drawable) {
            this.uW.vz = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.va != i) {
            this.va = i;
            this.vd = f.hL().aB(this.va);
            this.vd.a(this.uW);
            this.vg = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.vl) {
            this.vl = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.uW.vA = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.ve) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.vc == ImageView.ScaleType.MATRIX) {
            this.vd.b(matrix);
            this.vg = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.ve ? super.getImageMatrix() : this.vd.hD();
    }

    public RectF getImageBounds() {
        return this.vd.hE();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.vk.getWidth();
        this.vk.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.vk.getHeight();
        this.vk.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.vm = drawable;
    }

    public void setBg(Drawable drawable) {
        this.vn = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.uW.vB != i) {
            this.uW.vB = i;
            invalidate();
        }
    }
}
