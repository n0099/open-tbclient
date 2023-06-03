package com.baidu.searchbox.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes4.dex */
public class HighlightView {
    public static final int GROW_BOTTOM_EDGE = 16;
    public static final int GROW_LEFT_EDGE = 2;
    public static final int GROW_NONE = 1;
    public static final int GROW_RIGHT_EDGE = 4;
    public static final int GROW_TOP_EDGE = 8;
    public static final int MOVE = 32;
    public static final String TAG = "HighlightView";
    public View mContext;
    public RectF mCropRect;
    public Rect mDrawRect;
    public boolean mHidden;
    public RectF mImageRect;
    public float mInitialAspectRatio;
    public boolean mIsFocused;
    public Matrix mMatrix;
    public Drawable mResizeDrawableDiagonal;
    public Drawable mResizeDrawableHeight;
    public Drawable mResizeDrawableWidth;
    public ModifyMode mMode = ModifyMode.None;
    public boolean mMaintainAspectRatio = false;
    public boolean mCircle = false;
    public final Paint mFocusPaint = new Paint();
    public final Paint mNoFocusPaint = new Paint();
    public final Paint mOutlinePaint = new Paint();

    /* loaded from: classes4.dex */
    public enum ModifyMode {
        None,
        Move,
        Grow
    }

    public HighlightView(View view2) {
        this.mContext = view2;
    }

    public void setFocus(boolean z) {
        this.mIsFocused = z;
    }

    public void setHidden(boolean z) {
        this.mHidden = z;
    }

    public void setMode(ModifyMode modifyMode) {
        if (modifyMode != this.mMode) {
            this.mMode = modifyMode;
            this.mContext.invalidate();
        }
    }

    private Rect computeLayout() {
        RectF rectF = this.mCropRect;
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.mMatrix.mapRect(rectF2);
        return new Rect(Math.round(rectF2.left), Math.round(rectF2.top), Math.round(rectF2.right), Math.round(rectF2.bottom));
    }

    private void init() {
        Resources resources = this.mContext.getResources();
        this.mResizeDrawableWidth = resources.getDrawable(com.baidu.tieba.R.drawable.camera_crop_width);
        this.mResizeDrawableHeight = resources.getDrawable(com.baidu.tieba.R.drawable.camera_crop_height);
        this.mResizeDrawableDiagonal = resources.getDrawable(com.baidu.tieba.R.drawable.indicator_autocrop);
    }

    public Rect getCropRect() {
        RectF rectF = this.mCropRect;
        return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public boolean hasFocus() {
        return this.mIsFocused;
    }

    public void invalidate() {
        this.mDrawRect = computeLayout();
    }

    public void draw(Canvas canvas) {
        Paint paint;
        if (this.mHidden) {
            return;
        }
        canvas.save();
        Path path = new Path();
        if (!hasFocus()) {
            this.mOutlinePaint.setColor(-16777216);
            canvas.drawRect(this.mDrawRect, this.mOutlinePaint);
            return;
        }
        Rect rect = new Rect();
        this.mContext.getDrawingRect(rect);
        if (this.mCircle) {
            Rect rect2 = this.mDrawRect;
            float width = this.mDrawRect.width() / 2.0f;
            path.addCircle(rect2.left + width, rect2.top + (this.mDrawRect.height() / 2.0f), width, Path.Direction.CW);
            this.mOutlinePaint.setColor(-1112874);
        } else {
            path.addRect(new RectF(this.mDrawRect), Path.Direction.CW);
            this.mOutlinePaint.setColor(-30208);
        }
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        if (hasFocus()) {
            paint = this.mFocusPaint;
        } else {
            paint = this.mNoFocusPaint;
        }
        canvas.drawRect(rect, paint);
        canvas.restore();
        canvas.drawPath(path, this.mOutlinePaint);
        if (this.mMode == ModifyMode.Grow) {
            if (this.mCircle) {
                int intrinsicWidth = this.mResizeDrawableDiagonal.getIntrinsicWidth();
                int intrinsicHeight = this.mResizeDrawableDiagonal.getIntrinsicHeight();
                int round = (int) Math.round(Math.cos(0.7853981633974483d) * (this.mDrawRect.width() / 2.0d));
                Rect rect3 = this.mDrawRect;
                int width2 = ((rect3.left + (rect3.width() / 2)) + round) - (intrinsicWidth / 2);
                Rect rect4 = this.mDrawRect;
                int height = ((rect4.top + (rect4.height() / 2)) - round) - (intrinsicHeight / 2);
                Drawable drawable = this.mResizeDrawableDiagonal;
                drawable.setBounds(width2, height, drawable.getIntrinsicWidth() + width2, this.mResizeDrawableDiagonal.getIntrinsicHeight() + height);
                this.mResizeDrawableDiagonal.draw(canvas);
                return;
            }
            Rect rect5 = this.mDrawRect;
            int i = rect5.left + 1;
            int i2 = rect5.right + 1;
            int i3 = rect5.top + 4;
            int i4 = rect5.bottom + 3;
            int intrinsicWidth2 = this.mResizeDrawableWidth.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = this.mResizeDrawableWidth.getIntrinsicHeight() / 2;
            int intrinsicHeight3 = this.mResizeDrawableHeight.getIntrinsicHeight() / 2;
            int intrinsicWidth3 = this.mResizeDrawableHeight.getIntrinsicWidth() / 2;
            Rect rect6 = this.mDrawRect;
            int i5 = rect6.left;
            int i6 = i5 + ((rect6.right - i5) / 2);
            int i7 = rect6.top;
            int i8 = i7 + ((rect6.bottom - i7) / 2);
            int i9 = i8 - intrinsicHeight2;
            int i10 = i8 + intrinsicHeight2;
            this.mResizeDrawableWidth.setBounds(i - intrinsicWidth2, i9, i + intrinsicWidth2, i10);
            this.mResizeDrawableWidth.draw(canvas);
            this.mResizeDrawableWidth.setBounds(i2 - intrinsicWidth2, i9, i2 + intrinsicWidth2, i10);
            this.mResizeDrawableWidth.draw(canvas);
            int i11 = i6 - intrinsicWidth3;
            int i12 = i6 + intrinsicWidth3;
            this.mResizeDrawableHeight.setBounds(i11, i3 - intrinsicHeight3, i12, i3 + intrinsicHeight3);
            this.mResizeDrawableHeight.draw(canvas);
            this.mResizeDrawableHeight.setBounds(i11, i4 - intrinsicHeight3, i12, i4 + intrinsicHeight3);
            this.mResizeDrawableHeight.draw(canvas);
        }
    }

    public int getHit(float f, float f2) {
        boolean z;
        int i;
        Rect computeLayout = computeLayout();
        if (this.mCircle) {
            float centerX = f - computeLayout.centerX();
            float centerY = f2 - computeLayout.centerY();
            int sqrt = (int) Math.sqrt((centerX * centerX) + (centerY * centerY));
            int width = this.mDrawRect.width() / 2;
            if (Math.abs(sqrt - width) <= 20.0f) {
                if (Math.abs(centerY) > Math.abs(centerX)) {
                    if (centerY < 0.0f) {
                        return 8;
                    }
                    return 16;
                } else if (centerX < 0.0f) {
                    return 2;
                } else {
                    return 4;
                }
            } else if (sqrt < width) {
                return 32;
            } else {
                return 1;
            }
        }
        boolean z2 = false;
        if (f2 >= computeLayout.top - 20.0f && f2 < computeLayout.bottom + 20.0f) {
            z = true;
        } else {
            z = false;
        }
        if (f >= computeLayout.left - 20.0f && f < computeLayout.right + 20.0f) {
            z2 = true;
        }
        if (Math.abs(computeLayout.left - f) < 20.0f && z) {
            i = 3;
        } else {
            i = 1;
        }
        if (Math.abs(computeLayout.right - f) < 20.0f && z) {
            i |= 4;
        }
        if (Math.abs(computeLayout.top - f2) < 20.0f && z2) {
            i |= 8;
        }
        if (Math.abs(computeLayout.bottom - f2) < 20.0f && z2) {
            i |= 16;
        }
        if (i == 1 && computeLayout.contains((int) f, (int) f2)) {
            return 32;
        }
        return i;
    }

    public void growBy(float f, float f2) {
        if (this.mMaintainAspectRatio) {
            if (f != 0.0f) {
                f2 = f / this.mInitialAspectRatio;
            } else if (f2 != 0.0f) {
                f = this.mInitialAspectRatio * f2;
            }
        }
        RectF rectF = new RectF(this.mCropRect);
        if (f > 0.0f && rectF.width() + (f * 2.0f) > this.mImageRect.width()) {
            f = (this.mImageRect.width() - rectF.width()) / 2.0f;
            if (this.mMaintainAspectRatio) {
                f2 = f / this.mInitialAspectRatio;
            }
        }
        if (f2 > 0.0f && rectF.height() + (f2 * 2.0f) > this.mImageRect.height()) {
            f2 = (this.mImageRect.height() - rectF.height()) / 2.0f;
            if (this.mMaintainAspectRatio) {
                f = this.mInitialAspectRatio * f2;
            }
        }
        rectF.inset(-f, -f2);
        float f3 = 25.0f;
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        if (this.mMaintainAspectRatio) {
            f3 = 25.0f / this.mInitialAspectRatio;
        }
        if (rectF.height() < f3) {
            rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
        }
        float f4 = rectF.left;
        RectF rectF2 = this.mImageRect;
        float f5 = rectF2.left;
        if (f4 < f5) {
            rectF.offset(f5 - f4, 0.0f);
        } else {
            float f6 = rectF.right;
            float f7 = rectF2.right;
            if (f6 > f7) {
                rectF.offset(-(f6 - f7), 0.0f);
            }
        }
        float f8 = rectF.top;
        RectF rectF3 = this.mImageRect;
        float f9 = rectF3.top;
        if (f8 < f9) {
            rectF.offset(0.0f, f9 - f8);
        } else {
            float f10 = rectF.bottom;
            float f11 = rectF3.bottom;
            if (f10 > f11) {
                rectF.offset(0.0f, -(f10 - f11));
            }
        }
        this.mCropRect.set(rectF);
        this.mDrawRect = computeLayout();
        this.mContext.invalidate();
    }

    public void handleMotion(int i, float f, float f2) {
        int i2;
        Rect computeLayout = computeLayout();
        int i3 = 1;
        if (i == 1) {
            return;
        }
        if (i == 32) {
            moveBy(f * (this.mCropRect.width() / computeLayout.width()), f2 * (this.mCropRect.height() / computeLayout.height()));
            return;
        }
        if ((i & 6) == 0) {
            f = 0.0f;
        }
        if ((i & 24) == 0) {
            f2 = 0.0f;
        }
        float width = f * (this.mCropRect.width() / computeLayout.width());
        float height = f2 * (this.mCropRect.height() / computeLayout.height());
        if ((i & 2) != 0) {
            i2 = -1;
        } else {
            i2 = 1;
        }
        float f3 = i2 * width;
        if ((i & 8) != 0) {
            i3 = -1;
        }
        growBy(f3, i3 * height);
    }

    public void moveBy(float f, float f2) {
        Rect rect = new Rect(this.mDrawRect);
        this.mCropRect.offset(f, f2);
        RectF rectF = this.mCropRect;
        rectF.offset(Math.max(0.0f, this.mImageRect.left - rectF.left), Math.max(0.0f, this.mImageRect.top - this.mCropRect.top));
        RectF rectF2 = this.mCropRect;
        rectF2.offset(Math.min(0.0f, this.mImageRect.right - rectF2.right), Math.min(0.0f, this.mImageRect.bottom - this.mCropRect.bottom));
        Rect computeLayout = computeLayout();
        this.mDrawRect = computeLayout;
        rect.union(computeLayout);
        rect.inset(-10, -10);
        this.mContext.invalidate(rect);
    }

    public void setup(Matrix matrix, Rect rect, RectF rectF, boolean z, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.mMatrix = new Matrix(matrix);
        this.mCropRect = rectF;
        this.mImageRect = new RectF(rect);
        this.mMaintainAspectRatio = z2;
        this.mCircle = z;
        this.mInitialAspectRatio = this.mCropRect.width() / this.mCropRect.height();
        this.mDrawRect = computeLayout();
        this.mFocusPaint.setARGB(125, 50, 50, 50);
        this.mNoFocusPaint.setARGB(125, 50, 50, 50);
        this.mOutlinePaint.setStrokeWidth(3.0f);
        this.mOutlinePaint.setStyle(Paint.Style.STROKE);
        this.mOutlinePaint.setAntiAlias(true);
        this.mMode = ModifyMode.None;
        init();
    }
}
