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
    protected e qH;
    private final int qL;
    private final int qM;
    private final int qN;
    private int qO;
    private ImageView.ScaleType qP;
    private ImageView.ScaleType qQ;
    protected a qR;
    private boolean qS;
    private boolean qT;
    protected boolean qU;
    private int qV;
    private int qW;
    private int qX;
    private d qY;
    private boolean qZ;
    private Drawable ra;
    private Drawable rb;
    private Drawable rc;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.qL = 4;
        this.qM = 1;
        this.qN = 201326592;
        this.qO = 0;
        this.qP = ImageView.ScaleType.CENTER_INSIDE;
        this.qQ = null;
        this.qH = new e();
        this.qS = true;
        this.qU = true;
        this.qX = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.qY = new d();
        a(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qL = 4;
        this.qM = 1;
        this.qN = 201326592;
        this.qO = 0;
        this.qP = ImageView.ScaleType.CENTER_INSIDE;
        this.qQ = null;
        this.qH = new e();
        this.qS = true;
        this.qU = true;
        this.qX = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.qY = new d();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.qH.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f));
            this.qH.rg = obtainStyledAttributes.getBoolean(1, false);
            this.qH.rh = obtainStyledAttributes.getBoolean(2, false);
            this.qH.ri = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f));
            this.qH.rj = obtainStyledAttributes.getColor(4, 201326592);
            this.qH.rl = obtainStyledAttributes.getBoolean(5, false);
            this.qH.rm = obtainStyledAttributes.getBoolean(6, true);
            this.qH.ro = obtainStyledAttributes.getDrawable(7);
            if (this.qH.ro == null) {
                this.qH.ro = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.qH.rq = obtainStyledAttributes.getColor(12, 0);
            this.qO = obtainStyledAttributes.getInt(8, 0);
            this.qX = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.qZ = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.qH.mRadius = com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
            this.qH.ri = com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f);
            this.qH.rj = 201326592;
            if (this.qH.ro == null) {
                this.qH.ro = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.qR = f.gG().aj(this.qO);
        this.qR.a(this.qH);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.qV = View.MeasureSpec.getMode(i);
        this.qW = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.qY.getWidth();
        int height = this.qY.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.qY.isDefault || !this.qZ) {
            max = m(max, this.qX, i);
            max2 = m(max2, this.mMaxHeight, i2);
        }
        this.qY.reset();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
    }

    private int m(int i, int i2, int i3) {
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
        this.qT = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.qU = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.qY.re = (BitmapDrawable) getDrawable();
        this.qY.rf = getBdImage();
        if (this.qY.gE()) {
            this.qY.rf = null;
            gB();
            this.qY.isDefault = false;
            this.rc = this.rb;
        } else if (this.qY.gF()) {
            this.qY.re = null;
            gB();
            this.qY.isDefault = false;
            this.rc = this.rb;
        } else {
            this.qY.re = null;
            this.qY.rf = getDefaultBdImage();
            this.qY.isDefault = true;
            ImageView.ScaleType scaleType2 = this.qY.gF() ? this.qP : scaleType;
            this.rc = this.ra;
            scaleType = scaleType2;
        }
        if (this.qQ != scaleType) {
            this.qQ = scaleType;
            this.qU = true;
        }
    }

    private void gB() {
        if (this.qY.isDefault) {
            this.qU = true;
            if (this.qZ || this.qV != 1073741824 || this.qW != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        gC();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        gC();
    }

    private void gC() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.qS = true;
            } else {
                this.qS = false;
            }
            this.qU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.qS) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.qR.a(canvas, this, this.rc);
        drawContent(canvas);
        this.qR.a(canvas, this);
        this.qY.reset();
    }

    private void gD() {
        if (this.qT && this.qS && this.qU) {
            this.qR.a(this.qY, this, this.qQ);
            this.qU = false;
        }
    }

    private void drawContent(Canvas canvas) {
        if (this.qY.isAvailable()) {
            gD();
            this.qR.a(canvas, this.qY, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.qP != scaleType) {
            this.qP = scaleType;
            this.qU = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.qH.mAlpha - f) > 1.0E-4f) {
            this.qH.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.qH.mRadius != i) {
            this.qH.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.qH.rg != z) {
            this.qH.rg = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.qH.rk != z) {
            this.qH.rk = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.qH.rh != z) {
            this.qH.rh = z;
            this.qU = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.qH.ri != i) {
            this.qH.ri = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.qH.rj != i) {
            this.qH.rj = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.qH.rl != z) {
            this.qH.rl = z;
            this.qU = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.qH.rm != z) {
            this.qH.rm = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.qH.ro != drawable) {
            this.qH.ro = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.qO != i) {
            this.qO = i;
            this.qR = f.gG().aj(this.qO);
            this.qR.a(this.qH);
            this.qU = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.qZ) {
            this.qZ = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.qH.rp = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.qS) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.qQ == ImageView.ScaleType.MATRIX) {
            this.qR.a(matrix);
            this.qU = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.qS ? super.getImageMatrix() : this.qR.gy();
    }

    public RectF getImageBounds() {
        return this.qR.gz();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.qY.getWidth();
        this.qY.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.qY.getHeight();
        this.qY.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.ra = drawable;
    }

    public void setBg(Drawable drawable) {
        this.rb = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.qH.rq != i) {
            this.qH.rq = i;
            invalidate();
        }
    }
}
