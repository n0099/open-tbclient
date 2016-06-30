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
    protected e sa;
    private int se;
    private ImageView.ScaleType sf;
    private ImageView.ScaleType sg;
    protected a sh;
    private boolean si;
    private boolean sj;
    protected boolean sk;
    private int sl;
    private int sm;
    private int so;
    private d sq;
    private boolean sr;
    private Drawable ss;
    private Drawable su;
    private Drawable sv;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.se = 0;
        this.sf = ImageView.ScaleType.CENTER_INSIDE;
        this.sg = null;
        this.sa = new e();
        this.si = true;
        this.sk = true;
        this.so = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.sq = new d();
        b((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.se = 0;
        this.sf = ImageView.ScaleType.CENTER_INSIDE;
        this.sg = null;
        this.sa = new e();
        this.si = true;
        this.sk = true;
        this.so = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.sq = new d();
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.sa.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.sa.sz = obtainStyledAttributes.getBoolean(1, false);
            this.sa.sA = obtainStyledAttributes.getBoolean(2, false);
            this.sa.sB = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.sa.sC = obtainStyledAttributes.getColor(4, 201326592);
            this.sa.sE = obtainStyledAttributes.getBoolean(5, false);
            this.sa.sF = obtainStyledAttributes.getBoolean(6, true);
            this.sa.sG = obtainStyledAttributes.getDrawable(7);
            if (this.sa.sG == null) {
                this.sa.sG = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.sa.sI = obtainStyledAttributes.getColor(12, 0);
            this.se = obtainStyledAttributes.getInt(8, 0);
            this.so = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.sr = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.sa.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.sa.sB = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.sa.sC = 201326592;
            if (this.sa.sG == null) {
                this.sa.sG = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.sh = f.gR().al(this.se);
        this.sh.a(this.sa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.sl = View.MeasureSpec.getMode(i);
        this.sm = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.sq.getWidth();
        int height = this.sq.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.sq.isDefault || !this.sr) {
            max = h(max, this.so, i);
            max2 = h(max2, this.mMaxHeight, i2);
        }
        this.sq.reset();
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
        this.sj = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.sk = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.sq.sx = (BitmapDrawable) getDrawable();
        this.sq.sy = getBdImage();
        if (this.sq.gP()) {
            this.sq.sy = null;
            gM();
            this.sq.isDefault = false;
            this.sv = this.su;
        } else if (this.sq.gQ()) {
            this.sq.sx = null;
            gM();
            this.sq.isDefault = false;
            this.sv = this.su;
        } else {
            this.sq.sx = null;
            this.sq.sy = getDefaultBdImage();
            this.sq.isDefault = true;
            ImageView.ScaleType scaleType2 = this.sq.gQ() ? this.sf : scaleType;
            this.sv = this.ss;
            scaleType = scaleType2;
        }
        if (this.sg != scaleType) {
            this.sg = scaleType;
            this.sk = true;
        }
    }

    private void gM() {
        if (this.sq.isDefault) {
            this.sk = true;
            if (this.sr || this.sl != 1073741824 || this.sm != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        gN();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        gN();
    }

    private void gN() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.si = true;
            } else {
                this.si = false;
            }
            this.sk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.si) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.sh.a(canvas, this, this.sv);
        b(canvas);
        this.sh.a(canvas, this);
        this.sq.reset();
    }

    private void gO() {
        if (this.sj && this.si && this.sk) {
            this.sh.a(this.sq, this, this.sg);
            this.sk = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.sq.isAvailable()) {
            gO();
            this.sh.a(canvas, this.sq, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.sf != scaleType) {
            this.sf = scaleType;
            this.sk = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.sa.mAlpha - f) > 1.0E-4f) {
            this.sa.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.sa.mRadius != i) {
            this.sa.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.sa.sz != z) {
            this.sa.sz = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.sa.sD != z) {
            this.sa.sD = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.sa.sA != z) {
            this.sa.sA = z;
            this.sk = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.sa.sB != i) {
            this.sa.sB = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.sa.sC != i) {
            this.sa.sC = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.sa.sE != z) {
            this.sa.sE = z;
            this.sk = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.sa.sF != z) {
            this.sa.sF = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.sa.sG != drawable) {
            this.sa.sG = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.se != i) {
            this.se = i;
            this.sh = f.gR().al(this.se);
            this.sh.a(this.sa);
            this.sk = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.sr) {
            this.sr = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.sa.sH = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.si) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.sg == ImageView.ScaleType.MATRIX) {
            this.sh.a(matrix);
            this.sk = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.si ? super.getImageMatrix() : this.sh.gJ();
    }

    public RectF getImageBounds() {
        return this.sh.gK();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.sq.getWidth();
        this.sq.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.sq.getHeight();
        this.sq.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.ss = drawable;
    }

    public void setBg(Drawable drawable) {
        this.su = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.sa.sI != i) {
            this.sa.sI = i;
            invalidate();
        }
    }
}
