package com.baidu.adp.newwidget.ImageView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public abstract class BDImageView extends ImageView implements i {
    protected e Qk;
    protected a Ql;
    private d Qm;
    protected boolean mAdjustViewBounds;
    private Drawable mBg;
    private Drawable mCurBg;
    private ImageView.ScaleType mCurrentScaleType;
    private Drawable mDefaultBg;
    private ImageView.ScaleType mDefaultScaleType;
    protected int mDrawerType;
    private int mHeightMeasureMode;
    private boolean mIsBitmap;
    private boolean mIsHasFrame;
    protected int mMaxHeight;
    protected int mMaxWidth;
    protected boolean mNeedRecomputeMatrix;
    private int mWidthMeasureMode;

    protected abstract com.baidu.adp.widget.ImageView.a getBdImage();

    protected abstract com.baidu.adp.widget.ImageView.a getDefaultBdImage();

    public BDImageView(Context context) {
        super(context);
        this.mDrawerType = 0;
        this.mDefaultScaleType = ImageView.ScaleType.CENTER_INSIDE;
        this.mCurrentScaleType = null;
        this.Qk = new e();
        this.mIsBitmap = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMaxHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.Qm = new d();
        init(null);
    }

    public BDImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawerType = 0;
        this.mDefaultScaleType = ImageView.ScaleType.CENTER_INSIDE;
        this.mCurrentScaleType = null;
        this.Qk = new e();
        this.mIsBitmap = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMaxHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.Qm = new d();
        init(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.Qk.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f));
            this.Qk.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.Qk.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.Qk.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f));
            this.Qk.mBorderColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.Qk.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.Qk.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.Qk.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.Qk.mRadius = com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
            this.Qk.mBorderWidth = com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f);
            this.Qk.mBorderColor = 201326592;
        }
        this.Ql = f.ny().ay(this.mDrawerType);
        this.Ql.a(this.Qk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.mWidthMeasureMode = View.MeasureSpec.getMode(i);
        this.mHeightMeasureMode = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Qm.getWidth();
        int height = this.Qm.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Qm.isDefault || !this.mAdjustViewBounds) {
            max = resolveAdjustedSize(max, this.mMaxWidth, i);
            max2 = resolveAdjustedSize(max2, this.mMaxHeight, i2);
        }
        this.Qm.reset();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(max2, 1073741824));
    }

    private int resolveAdjustedSize(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        switch (mode) {
            case Integer.MIN_VALUE:
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
        this.mIsHasFrame = true;
        return frame;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mNeedRecomputeMatrix = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.Qm.drawable = (BitmapDrawable) getDrawable();
        this.Qm.Qp = getBdImage();
        if (this.Qm.isDrawableAvalible()) {
            this.Qm.Qp = null;
            checkReLayout();
            this.Qm.isDefault = false;
            this.mCurBg = this.mBg;
        } else if (this.Qm.isBdImgAvailable()) {
            this.Qm.drawable = null;
            checkReLayout();
            this.Qm.isDefault = false;
            this.mCurBg = this.mBg;
        } else {
            this.Qm.drawable = null;
            this.Qm.Qp = getDefaultBdImage();
            this.Qm.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Qm.isBdImgAvailable() ? this.mDefaultScaleType : scaleType;
            this.mCurBg = this.mDefaultBg;
            scaleType = scaleType2;
        }
        if (this.mCurrentScaleType != scaleType) {
            this.mCurrentScaleType = scaleType;
            this.mNeedRecomputeMatrix = true;
        }
    }

    private void checkReLayout() {
        if (this.Qm.isDefault) {
            this.mNeedRecomputeMatrix = true;
            if (this.mAdjustViewBounds || this.mWidthMeasureMode != 1073741824 || this.mHeightMeasureMode != 1073741824) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        updateFlag();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        updateFlag();
    }

    private void updateFlag() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                this.mIsBitmap = true;
            } else {
                this.mIsBitmap = false;
            }
            this.mNeedRecomputeMatrix = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.mIsBitmap) {
            super.onDraw(canvas);
            drawContentTag(canvas, this);
            return;
        }
        getDisplayBdImage();
        this.Ql.drawBackground(canvas, this, this.mCurBg);
        drawContent(canvas);
        drawContentTag(canvas, this);
        this.Ql.drawForeground(canvas, this);
        this.Qm.reset();
    }

    public void drawContentTag(Canvas canvas, ImageView imageView) {
    }

    private void computeBounds() {
        if (this.mIsHasFrame && this.mIsBitmap && this.mNeedRecomputeMatrix) {
            this.Ql.a(this.Qm, this, this.mCurrentScaleType);
            this.mNeedRecomputeMatrix = false;
        }
    }

    private void drawContent(Canvas canvas) {
        if (!this.Qm.isAvailable()) {
            if (this.Qk.Qr) {
                this.Ql.updatePaint();
                this.Ql.a(this.Qm, this);
                this.Ql.drawBorder(canvas, this);
                return;
            }
            return;
        }
        computeBounds();
        this.Ql.a(canvas, this.Qm, this);
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.mDefaultScaleType != scaleType) {
            this.mDefaultScaleType = scaleType;
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.Qk.mAlpha - f) > 1.0E-4f) {
            this.Qk.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.Qk.mRadius != i) {
            this.Qk.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.Qk.mIsRound != z) {
            this.Qk.mIsRound = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.Qk.mIsNight != z) {
            this.Qk.mIsNight = z;
            invalidate();
        }
    }

    public void setIsPreDrawBorder(boolean z) {
        if (this.Qk.Qr != z) {
            this.Qk.Qr = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.Qk.mHasBorder != z) {
            this.Qk.mHasBorder = z;
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public boolean getDrawBorder() {
        return this.Qk.mHasBorder;
    }

    public void setBorderWidth(int i) {
        if (this.Qk.mBorderWidth != i) {
            this.Qk.mBorderWidth = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.Qk.mBorderColor != i) {
            this.Qk.mBorderColor = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.Qk.mBorderSurroundContent != z) {
            this.Qk.mBorderSurroundContent = z;
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public void setLongIconSupport(boolean z) {
        if (this.Qk.mIsShowLongIcon != z) {
            this.Qk.mIsShowLongIcon = z;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.Qk.mIsShowGifIcon != z) {
            this.Qk.mIsShowGifIcon = z;
            invalidate();
        }
    }

    public void setTLIconType(int i) {
        if (this.Qk.Qq != i) {
            this.Qk.Qq = i;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.mDrawerType != i) {
            this.mDrawerType = i;
            this.Ql = f.ny().ay(this.mDrawerType);
            this.Ql.a(this.Qk);
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z != this.mAdjustViewBounds) {
            this.mAdjustViewBounds = z;
            requestLayout();
        }
    }

    public void setExtraMatrix(Matrix matrix) {
        this.Qk.mExtraMatrix = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.mIsBitmap) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.mCurrentScaleType == ImageView.ScaleType.MATRIX) {
            this.Ql.setDrawMatrix(matrix);
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.mIsBitmap ? super.getImageMatrix() : this.Ql.getDrawMatrix();
    }

    public RectF getImageBounds() {
        return this.Ql.getBounds();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Qm.getWidth();
        this.Qm.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Qm.getHeight();
        this.Qm.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.mDefaultBg = drawable;
    }

    public void setBg(Drawable drawable) {
        this.mBg = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.Qk.mForegroundColor != i) {
            this.Qk.mForegroundColor = i;
            invalidate();
        }
    }
}
