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
    protected e sF;
    private int sJ;
    private ImageView.ScaleType sK;
    private ImageView.ScaleType sL;
    protected a sM;
    private boolean sN;
    private boolean sO;
    protected boolean sP;
    private int sQ;
    private int sR;
    private int sS;
    private d sT;
    private boolean sU;
    private Drawable sV;
    private Drawable sW;
    private Drawable sX;

    protected abstract com.baidu.adp.widget.a.a getBdImage();

    protected abstract com.baidu.adp.widget.a.a getDefaultBdImage();

    public b(Context context) {
        super(context);
        this.sJ = 0;
        this.sK = ImageView.ScaleType.CENTER_INSIDE;
        this.sL = null;
        this.sF = new e();
        this.sN = true;
        this.sP = true;
        this.sS = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.sT = new d();
        b((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sJ = 0;
        this.sK = ImageView.ScaleType.CENTER_INSIDE;
        this.sL = null;
        this.sF = new e();
        this.sN = true;
        this.sP = true;
        this.sS = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.sT = new d();
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.sF.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f));
            this.sF.tc = obtainStyledAttributes.getBoolean(1, false);
            this.sF.td = obtainStyledAttributes.getBoolean(2, false);
            this.sF.te = obtainStyledAttributes.getDimensionPixelSize(3, com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f));
            this.sF.tf = obtainStyledAttributes.getColor(4, 201326592);
            this.sF.th = obtainStyledAttributes.getBoolean(5, false);
            this.sF.ti = obtainStyledAttributes.getBoolean(6, true);
            this.sF.tj = obtainStyledAttributes.getDrawable(7);
            if (this.sF.tj == null) {
                this.sF.tj = getResources().getDrawable(R.drawable.icon_gif);
            }
            this.sF.tl = obtainStyledAttributes.getColor(12, 0);
            this.sJ = obtainStyledAttributes.getInt(8, 0);
            this.sS = obtainStyledAttributes.getDimensionPixelSize(9, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(10, Integer.MAX_VALUE);
            this.sU = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
        } else {
            this.sF.mRadius = com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
            this.sF.te = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
            this.sF.tf = 201326592;
            if (this.sF.tj == null) {
                this.sF.tj = getResources().getDrawable(R.drawable.icon_gif);
            }
        }
        this.sM = f.gQ().ao(this.sJ);
        this.sM.a(this.sF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.sQ = View.MeasureSpec.getMode(i);
        this.sR = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.sT.getWidth();
        int height = this.sT.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.sT.isDefault || !this.sU) {
            max = i(max, this.sS, i);
            max2 = i(max2, this.mMaxHeight, i2);
        }
        this.sT.reset();
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
        this.sO = true;
        return frame;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.sP = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.sT.sZ = (BitmapDrawable) getDrawable();
        this.sT.tb = getBdImage();
        if (this.sT.gO()) {
            this.sT.tb = null;
            gL();
            this.sT.isDefault = false;
            this.sX = this.sW;
        } else if (this.sT.gP()) {
            this.sT.sZ = null;
            gL();
            this.sT.isDefault = false;
            this.sX = this.sW;
        } else {
            this.sT.sZ = null;
            this.sT.tb = getDefaultBdImage();
            this.sT.isDefault = true;
            ImageView.ScaleType scaleType2 = this.sT.gP() ? this.sK : scaleType;
            this.sX = this.sV;
            scaleType = scaleType2;
        }
        if (this.sL != scaleType) {
            this.sL = scaleType;
            this.sP = true;
        }
    }

    private void gL() {
        if (this.sT.isDefault) {
            this.sP = true;
            if (this.sU || this.sQ != 1073741824 || this.sR != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        gM();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        gM();
    }

    private void gM() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.sN = true;
            } else {
                this.sN = false;
            }
            this.sP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.sN) {
            super.onDraw(canvas);
            return;
        }
        getDisplayBdImage();
        this.sM.a(canvas, this, this.sX);
        b(canvas);
        this.sM.a(canvas, this);
        this.sT.reset();
    }

    private void gN() {
        if (this.sO && this.sN && this.sP) {
            this.sM.a(this.sT, this, this.sL);
            this.sP = false;
        }
    }

    private void b(Canvas canvas) {
        if (this.sT.isAvailable()) {
            gN();
            this.sM.a(canvas, this.sT, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.sK != scaleType) {
            this.sK = scaleType;
            this.sP = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.sF.mAlpha - f) > 1.0E-4f) {
            this.sF.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.sF.mRadius != i) {
            this.sF.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.sF.tc != z) {
            this.sF.tc = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.sF.tg != z) {
            this.sF.tg = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.sF.td != z) {
            this.sF.td = z;
            this.sP = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.sF.te != i) {
            this.sF.te = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.sF.tf != i) {
            this.sF.tf = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.sF.th != z) {
            this.sF.th = z;
            this.sP = true;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.sF.ti != z) {
            this.sF.ti = z;
            invalidate();
        }
    }

    public void setGifIcon(Drawable drawable) {
        if (this.sF.tj != drawable) {
            this.sF.tj = drawable;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.sJ != i) {
            this.sJ = i;
            this.sM = f.gQ().ao(this.sJ);
            this.sM.a(this.sF);
            this.sP = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.sU) {
            this.sU = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.sF.tk = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.sN) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.sL == ImageView.ScaleType.MATRIX) {
            this.sM.b(matrix);
            this.sP = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.sN ? super.getImageMatrix() : this.sM.gI();
    }

    public RectF getImageBounds() {
        return this.sM.gJ();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.sT.getWidth();
        this.sT.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.sT.getHeight();
        this.sT.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.sV = drawable;
    }

    public void setBg(Drawable drawable) {
        this.sW = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.sF.tl != i) {
            this.sF.tl = i;
            invalidate();
        }
    }
}
