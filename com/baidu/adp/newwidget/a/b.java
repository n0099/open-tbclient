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
    protected e uV;
    private int uZ;
    private ImageView.ScaleType va;
    private ImageView.ScaleType vb;
    protected a vc;
    private boolean vd;
    private boolean ve;
    protected boolean vf;
    private int vg;
    private int vh;
    private int vi;
    private d vj;
    private boolean vk;
    private Drawable vl;
    private Drawable vm;
    private Drawable vn;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.uZ = 0;
        this.va = ImageView.ScaleType.CENTER_INSIDE;
        this.vb = null;
        this.uV = new e();
        this.vd = true;
        this.vf = true;
        this.vi = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.vj = new d();
        b((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uZ = 0;
        this.va = ImageView.ScaleType.CENTER_INSIDE;
        this.vb = null;
        this.uV = new e();
        this.vd = true;
        this.vf = true;
        this.vi = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.vj = new d();
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.uV.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.uV.vr = obtainStyledAttributes.getBoolean(1, false);
            this.uV.vs = obtainStyledAttributes.getBoolean(2, false);
            this.uV.vt = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.uV.vu = obtainStyledAttributes.getColor(4, 201326592);
            this.uV.vw = obtainStyledAttributes.getBoolean(5, false);
            this.uV.vx = obtainStyledAttributes.getBoolean(6, true);
            this.uV.vy = obtainStyledAttributes.getDrawable(7);
            if (this.uV.vy == null) {
                this.uV.vy = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.uV.vA = obtainStyledAttributes.getColor(12, 0);
            this.uZ = obtainStyledAttributes.getInt(8, 0);
            this.vi = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.vk = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.uV.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.uV.vt = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.uV.vu = 201326592;
            if (this.uV.vy == null) {
                this.uV.vy = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.vc = f.hL().aB(this.uZ);
        this.vc.a(this.uV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.vg = View.MeasureSpec.getMode(i);
        this.vh = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.vj.getWidth();
        int height = this.vj.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.vj.isDefault || !this.vk) {
            max = i(max, this.vi, i);
            max2 = i(max2, this.mMaxHeight, i2);
        }
        this.vj.reset();
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
        this.ve = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.vf = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.vj.vp = (BitmapDrawable) getDrawable();
        this.vj.vq = getBdImage();
        if (this.vj.hJ()) {
            this.vj.vq = null;
            hG();
            this.vj.isDefault = false;
            this.vn = this.vm;
        } else if (this.vj.hK()) {
            this.vj.vp = null;
            hG();
            this.vj.isDefault = false;
            this.vn = this.vm;
        } else {
            this.vj.vp = null;
            this.vj.vq = getDefaultBdImage();
            this.vj.isDefault = true;
            ImageView.ScaleType scaleType2 = this.vj.hK() ? this.va : scaleType;
            this.vn = this.vl;
            scaleType = scaleType2;
        }
        if (this.vb != scaleType) {
            this.vb = scaleType;
            this.vf = true;
        }
    }

    private void hG() {
        if (this.vj.isDefault) {
            this.vf = true;
            if (this.vk || this.vg != 1073741824 || this.vh != 1073741824) {
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
                this.vd = true;
            } else {
                this.vd = false;
            }
            this.vf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.vd) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.vc.a(canvas, this, this.vn);
        b(canvas);
        this.vc.a(canvas, this);
        this.vj.reset();
    }

    private void hI() {
        if (this.ve && this.vd && this.vf) {
            this.vc.a(this.vj, this, this.vb);
            this.vf = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.vj.isAvailable()) {
            hI();
            this.vc.a(canvas, this.vj, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.va != scaleType) {
            this.va = scaleType;
            this.vf = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.uV.mAlpha - f) > 1.0E-4f) {
            this.uV.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.uV.mRadius != i) {
            this.uV.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.uV.vr != z) {
            this.uV.vr = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.uV.vv != z) {
            this.uV.vv = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.uV.vs != z) {
            this.uV.vs = z;
            this.vf = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.uV.vt != i) {
            this.uV.vt = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.uV.vu != i) {
            this.uV.vu = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.uV.vw != z) {
            this.uV.vw = z;
            this.vf = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.uV.vx != z) {
            this.uV.vx = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.uV.vy != drawable) {
            this.uV.vy = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.uZ != i) {
            this.uZ = i;
            this.vc = f.hL().aB(this.uZ);
            this.vc.a(this.uV);
            this.vf = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.vk) {
            this.vk = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.uV.vz = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.vd) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.vb == ImageView.ScaleType.MATRIX) {
            this.vc.b(matrix);
            this.vf = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.vd ? super.getImageMatrix() : this.vc.hD();
    }

    public RectF getImageBounds() {
        return this.vc.hE();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.vj.getWidth();
        this.vj.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.vj.getHeight();
        this.vj.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.vl = drawable;
    }

    public void setBg(Drawable drawable) {
        this.vm = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.uV.vA != i) {
            this.uV.vA = i;
            invalidate();
        }
    }
}
