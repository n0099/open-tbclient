package com.baidu.live.adp.newwidget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.live.adp.R;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.imageview.BdImage;
/* loaded from: classes6.dex */
public abstract class BDImageView extends ImageView implements IRefresh {
    private static final int DEFAULT_BORDER_COLOR = 201326592;
    private static final int DEFAULT_BORDER_WIDTH = 1;
    private static final int DEFAULT_RADIUS = 4;
    private boolean mAdjustViewBounds;
    protected DrawerArgs mArgs;
    private Drawable mBg;
    private Drawable mCurBg;
    private ImageView.ScaleType mCurrentScaleType;
    private Drawable mDefaultBg;
    private ImageView.ScaleType mDefaultScaleType;
    protected AbsDrawer mDrawer;
    private int mDrawerType;
    private int mHeightMeasureMode;
    private DisplayImage mImage;
    private boolean mIsBitmap;
    private boolean mIsHasFrame;
    private int mMaxHeight;
    private int mMaxWidth;
    protected boolean mNeedRecomputeMatrix;
    private int mWidthMeasureMode;

    protected abstract BdImage getBdImage();

    protected abstract BdImage getDefaultBdImage();

    public BDImageView(Context context) {
        super(context);
        this.mDrawerType = 0;
        this.mDefaultScaleType = ImageView.ScaleType.CENTER_INSIDE;
        this.mCurrentScaleType = null;
        this.mArgs = new DrawerArgs();
        this.mIsBitmap = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mImage = new DisplayImage();
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
        this.mArgs = new DrawerArgs();
        this.mIsBitmap = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mImage = new DisplayImage();
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.sdk_BDImageView);
            this.mArgs.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sdk_BDImageView_radius, BdUtilHelper.dip2px(getContext(), 4.0f));
            this.mArgs.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.sdk_BDImageView_isRound, false);
            this.mArgs.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.sdk_BDImageView_hasBorder, false);
            this.mArgs.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sdk_BDImageView_borderWidth, BdUtilHelper.dip2px(getContext(), 1.0f));
            this.mArgs.mBorderColor = obtainStyledAttributes.getColor(R.styleable.sdk_BDImageView_sdk_borderColor, DEFAULT_BORDER_COLOR);
            this.mArgs.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.sdk_BDImageView_borderSurroundContent, false);
            this.mArgs.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.sdk_BDImageView_showGifIcon, true);
            this.mArgs.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.sdk_BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.sdk_BDImageView_sdk_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sdk_BDImageView_maxWidth, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sdk_BDImageView_maxHeight, Integer.MAX_VALUE);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.sdk_BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.mArgs.mRadius = BdUtilHelper.dip2px(getContext(), 4.0f);
            this.mArgs.mBorderWidth = BdUtilHelper.dip2px(getContext(), 1.0f);
            this.mArgs.mBorderColor = DEFAULT_BORDER_COLOR;
        }
        this.mDrawer = DrawerFactory.getInstance().getDecoratorByType(this.mDrawerType);
        this.mDrawer.updateArgs(this.mArgs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.mWidthMeasureMode = View.MeasureSpec.getMode(i);
        this.mHeightMeasureMode = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.mImage.getWidth();
        int height = this.mImage.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.mImage.isDefault || !this.mAdjustViewBounds) {
            max = resolveAdjustedSize(max, this.mMaxWidth, i);
            max2 = resolveAdjustedSize(max2, this.mMaxHeight, i2);
        }
        this.mImage.reset();
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

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mNeedRecomputeMatrix = true;
    }

    private void getDisplayBdImage() {
        ImageView.ScaleType scaleType = getScaleType();
        this.mImage.drawable = (BitmapDrawable) getDrawable();
        this.mImage.bdImg = getBdImage();
        if (this.mImage.isDrawableAvalible()) {
            this.mImage.bdImg = null;
            checkReLayout();
            this.mImage.isDefault = false;
            this.mCurBg = this.mBg;
        } else if (this.mImage.isBdImgAvailable()) {
            this.mImage.drawable = null;
            checkReLayout();
            this.mImage.isDefault = false;
            this.mCurBg = this.mBg;
        } else {
            this.mImage.drawable = null;
            this.mImage.bdImg = getDefaultBdImage();
            this.mImage.isDefault = true;
            ImageView.ScaleType scaleType2 = this.mImage.isBdImgAvailable() ? this.mDefaultScaleType : scaleType;
            this.mCurBg = this.mDefaultBg;
            scaleType = scaleType2;
        }
        if (this.mCurrentScaleType != scaleType) {
            this.mCurrentScaleType = scaleType;
            this.mNeedRecomputeMatrix = true;
        }
    }

    private void checkReLayout() {
        if (this.mImage.isDefault) {
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
        this.mDrawer.drawBackground(canvas, this, this.mCurBg);
        drawContent(canvas);
        drawContentTag(canvas, this);
        this.mDrawer.drawForeground(canvas, this);
        this.mImage.reset();
    }

    public void drawContentTag(Canvas canvas, ImageView imageView) {
    }

    private void computeBounds() {
        if (this.mIsHasFrame && this.mIsBitmap && this.mNeedRecomputeMatrix) {
            this.mDrawer.computeBounds(this.mImage, this, this.mCurrentScaleType);
            this.mNeedRecomputeMatrix = false;
        }
    }

    private void drawContent(Canvas canvas) {
        if (this.mImage.isAvailable()) {
            computeBounds();
            this.mDrawer.drawContent(canvas, this.mImage, this);
        }
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.mDefaultScaleType != scaleType) {
            this.mDefaultScaleType = scaleType;
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.mArgs.mAlpha - f) > 1.0E-4f) {
            this.mArgs.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        if (this.mArgs.mRadius != i) {
            this.mArgs.mRadius = i;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.mArgs.mIsRound != z) {
            this.mArgs.mIsRound = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.mArgs.mIsNight != z) {
            this.mArgs.mIsNight = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.mArgs.mHasBorder != z) {
            this.mArgs.mHasBorder = z;
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.mArgs.mBorderWidth != i) {
            this.mArgs.mBorderWidth = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.mArgs.mBorderColor != i) {
            this.mArgs.mBorderColor = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.mArgs.mBorderSurroundContent != z) {
            this.mArgs.mBorderSurroundContent = z;
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public void setLongIconSupport(boolean z) {
        if (this.mArgs.mIsShowLongIcon != z) {
            this.mArgs.mIsShowLongIcon = z;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.mArgs.mIsShowGifIcon != z) {
            this.mArgs.mIsShowGifIcon = z;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.mDrawerType != i) {
            this.mDrawerType = i;
            this.mDrawer = DrawerFactory.getInstance().getDecoratorByType(this.mDrawerType);
            this.mDrawer.updateArgs(this.mArgs);
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
        this.mArgs.mExtraMatrix = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.mIsBitmap) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.mCurrentScaleType == ImageView.ScaleType.MATRIX) {
            this.mDrawer.setDrawMatrix(matrix);
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.mIsBitmap ? super.getImageMatrix() : this.mDrawer.getDrawMatrix();
    }

    public RectF getImageBounds() {
        return this.mDrawer.getBounds();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.mImage.getWidth();
        this.mImage.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.mImage.getHeight();
        this.mImage.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.mDefaultBg = drawable;
    }

    public void setBg(Drawable drawable) {
        this.mBg = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.mArgs.mForegroundColor != i) {
            this.mArgs.mForegroundColor = i;
            invalidate();
        }
    }

    public boolean isNight() {
        return this.mArgs.mIsNight;
    }
}
