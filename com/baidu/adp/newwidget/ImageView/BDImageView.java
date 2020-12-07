package com.baidu.adp.newwidget.ImageView;

import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class BDImageView extends ImageView implements i {
    protected e St;
    protected a Su;
    private d Sv;
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
        this.St = new e();
        this.mIsBitmap = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMaxHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.Sv = new d();
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
        this.St = new e();
        this.mIsBitmap = true;
        this.mNeedRecomputeMatrix = true;
        this.mMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMaxHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.Sv = new d();
        init(attributeSet);
    }

    protected void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.St.mRadius = m(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f)));
            this.St.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.St.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.St.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f));
            this.St.mBorderColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.St.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.St.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.St.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.St.mRadius = m(com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f));
            this.St.mBorderWidth = com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f);
            this.St.mBorderColor = 201326592;
        }
        this.Su = f.pe().aI(this.mDrawerType);
        this.Su.a(this.St);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.mWidthMeasureMode = View.MeasureSpec.getMode(i);
        this.mHeightMeasureMode = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        getDisplayBdImage();
        int width = this.Sv.getWidth();
        int height = this.Sv.getHeight();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = height + paddingTop;
        int max = Math.max(width + paddingLeft, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (max <= paddingLeft || max2 <= paddingTop || this.Sv.isDefault || !this.mAdjustViewBounds) {
            max = resolveAdjustedSize(max, this.mMaxWidth, i);
            max2 = resolveAdjustedSize(max2, this.mMaxHeight, i2);
        }
        this.Sv.reset();
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
        this.Sv.drawable = (BitmapDrawable) getDrawable();
        this.Sv.Sy = getBdImage();
        if (this.Sv.isDrawableAvalible()) {
            this.Sv.Sy = null;
            checkReLayout();
            this.Sv.isDefault = false;
            this.mCurBg = this.mBg;
        } else if (this.Sv.isBdImgAvailable()) {
            this.Sv.drawable = null;
            checkReLayout();
            this.Sv.isDefault = false;
            this.mCurBg = this.mBg;
        } else {
            this.Sv.drawable = null;
            this.Sv.Sy = getDefaultBdImage();
            this.Sv.isDefault = true;
            ImageView.ScaleType scaleType2 = this.Sv.isBdImgAvailable() ? this.mDefaultScaleType : scaleType;
            this.mCurBg = this.mDefaultBg;
            scaleType = scaleType2;
        }
        if (this.mCurrentScaleType != scaleType) {
            this.mCurrentScaleType = scaleType;
            this.mNeedRecomputeMatrix = true;
        }
    }

    private void checkReLayout() {
        if (this.Sv.isDefault) {
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
        this.Su.drawBackground(canvas, this, this.mCurBg);
        drawContent(canvas);
        drawContentTag(canvas, this);
        this.Su.drawForeground(canvas, this);
        this.Sv.reset();
    }

    public void drawContentTag(Canvas canvas, ImageView imageView) {
    }

    private void computeBounds() {
        if (this.mIsHasFrame && this.mIsBitmap && this.mNeedRecomputeMatrix) {
            this.Su.a(this.Sv, this, this.mCurrentScaleType);
            this.mNeedRecomputeMatrix = false;
        }
    }

    private void drawContent(Canvas canvas) {
        if (!this.Sv.isAvailable()) {
            if (this.St.SA) {
                this.Su.updatePaint();
                this.Su.a(this.Sv, this);
                this.Su.drawBorder(canvas, this);
                return;
            }
            return;
        }
        computeBounds();
        this.Su.a(canvas, this.Sv, this);
    }

    public void setDefaultScaleType(ImageView.ScaleType scaleType) {
        if (this.mDefaultScaleType != scaleType) {
            this.mDefaultScaleType = scaleType;
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public void setAlphaValue(float f) {
        if (Math.abs(this.St.mAlpha - f) > 1.0E-4f) {
            this.St.mAlpha = f;
            invalidate();
        }
    }

    public void setRadius(int i) {
        float[] m = m(i);
        if (!Arrays.equals(this.St.mRadius, m)) {
            this.St.mRadius = m;
            invalidate();
        }
    }

    public void setRadiusById(int i) {
        float[] aH = aH(i);
        if (!Arrays.equals(this.St.mRadius, aH)) {
            this.St.mRadius = aH;
            invalidate();
        }
    }

    public void setIsRound(boolean z) {
        if (this.St.mIsRound != z) {
            this.St.mIsRound = z;
            invalidate();
        }
    }

    public void setIsNight(boolean z) {
        if (this.St.mIsNight != z) {
            this.St.mIsNight = z;
            invalidate();
        }
    }

    public void setIsPreDrawBorder(boolean z) {
        if (this.St.SA != z) {
            this.St.SA = z;
            invalidate();
        }
    }

    public void setDrawBorder(boolean z) {
        if (this.St.mHasBorder != z) {
            this.St.mHasBorder = z;
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public boolean getDrawBorder() {
        return this.St.mHasBorder;
    }

    public void setBorderWidth(int i) {
        if (this.St.mBorderWidth != i) {
            this.St.mBorderWidth = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.St.mBorderColor != i) {
            this.St.mBorderColor = i;
            invalidate();
        }
    }

    public void setBorderSurroundContent(boolean z) {
        if (this.St.mBorderSurroundContent != z) {
            this.St.mBorderSurroundContent = z;
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    public void setLongIconSupport(boolean z) {
        if (this.St.mIsShowLongIcon != z) {
            this.St.mIsShowLongIcon = z;
            invalidate();
        }
    }

    public void setGifIconSupport(boolean z) {
        if (this.St.mIsShowGifIcon != z) {
            this.St.mIsShowGifIcon = z;
            invalidate();
        }
    }

    public void setTLIconType(int i) {
        if (this.St.Sz != i) {
            this.St.Sz = i;
            invalidate();
        }
    }

    public void setDrawerType(int i) {
        if (this.mDrawerType != i) {
            this.mDrawerType = i;
            this.Su = f.pe().aI(this.mDrawerType);
            this.Su.a(this.St);
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
        this.St.mExtraMatrix = matrix;
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (!this.mIsBitmap) {
            super.setImageMatrix(matrix);
        } else if (matrix != null && this.mCurrentScaleType == ImageView.ScaleType.MATRIX) {
            this.Su.setDrawMatrix(matrix);
            this.mNeedRecomputeMatrix = true;
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return !this.mIsBitmap ? super.getImageMatrix() : this.Su.getDrawMatrix();
    }

    public int getImageWidth() {
        getDisplayBdImage();
        int width = this.Sv.getWidth();
        this.Sv.reset();
        return width;
    }

    public int getImageHeight() {
        getDisplayBdImage();
        int height = this.Sv.getHeight();
        this.Sv.reset();
        return height;
    }

    public void setDefaultBg(Drawable drawable) {
        this.mDefaultBg = drawable;
    }

    public void setBg(Drawable drawable) {
        this.mBg = drawable;
    }

    public void setForegroundColor(int i) {
        if (this.St.mForegroundColor != i) {
            this.St.mForegroundColor = i;
            invalidate();
        }
    }

    public static float[] m(float f) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, f);
        return fArr;
    }

    private static float[] aH(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return m(0.0f);
        }
        String[] split = app.getString(i).split(",");
        int min = Math.min(split.length, 4);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < min; i2++) {
            float cp = cp(split[i2]);
            fArr[i2 * 2] = cp;
            fArr[(i2 * 2) + 1] = cp;
        }
        return fArr;
    }

    private static float cp(String str) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return 0.0f;
        }
        if (str.endsWith(IEruptionStrategyGroup.STRATEGY_MODIFIER_H)) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        return app.getResources().getDimensionPixelSize(app.getResources().getIdentifier("tbds" + str, "dimen", app.getPackageName()));
    }
}
