package com.baidu.searchbox.ui.bubble;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes4.dex */
public class BubbleDrawable extends Drawable {
    public float mArrowHeight;
    public float mArrowPosition;
    public float mArrowWidth;
    public float mCornersRadius;
    public Paint mPaint;
    public Path mPath = new Path();
    public RectF mRect;
    public Paint mStrokePaint;
    public Path mStrokePath;
    public float mStrokeWidth;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    /* renamed from: com.baidu.searchbox.ui.bubble.BubbleDrawable$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[ArrowDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[ArrowDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BubbleDrawable(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        this.mRect = rectF;
        this.mArrowWidth = f;
        this.mCornersRadius = f2;
        this.mArrowHeight = f3;
        this.mArrowPosition = f4;
        this.mStrokeWidth = f5;
        paint.setColor(i2);
        if (f5 > 0.0f) {
            Paint paint2 = new Paint(1);
            this.mStrokePaint = paint2;
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mStrokePaint.setColor(i);
            this.mStrokePath = new Path();
            initPath(arrowDirection, this.mPath, this.mStrokeWidth);
            initPath(arrowDirection, this.mStrokePath, 0.0f);
            return;
        }
        initPath(arrowDirection, this.mPath, 0.0f);
    }

    private void initBottomRoundedPath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.mCornersRadius + f, rectF.top + f);
        path.lineTo((rectF.width() - this.mCornersRadius) - f, rectF.top + f);
        float f2 = rectF.right;
        float f3 = this.mCornersRadius;
        float f4 = rectF.top;
        path.arcTo(new RectF(f2 - f3, f4 + f, f2 - f, f3 + f4), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.mArrowHeight) - this.mCornersRadius) - f);
        float f5 = rectF.right;
        float f6 = this.mCornersRadius;
        float f7 = rectF.bottom;
        float f8 = this.mArrowHeight;
        path.arcTo(new RectF(f5 - f6, (f7 - f6) - f8, f5 - f, (f7 - f8) - f), 0.0f, 90.0f);
        float f9 = f / 2.0f;
        path.lineTo(((rectF.left + this.mArrowWidth) + this.mArrowPosition) - f9, (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + this.mArrowPosition + (this.mArrowWidth / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.mArrowPosition + f9, (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + Math.min(this.mCornersRadius, this.mArrowPosition) + f, (rectF.bottom - this.mArrowHeight) - f);
        float f10 = rectF.left;
        float f11 = rectF.bottom;
        float f12 = this.mCornersRadius;
        float f13 = this.mArrowHeight;
        path.arcTo(new RectF(f10 + f, (f11 - f12) - f13, f12 + f10, (f11 - f13) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.mCornersRadius + f);
        float f14 = rectF.left;
        float f15 = rectF.top;
        float f16 = this.mCornersRadius;
        path.arcTo(new RectF(f14 + f, f + f15, f14 + f16, f16 + f15), 180.0f, 90.0f);
        path.close();
    }

    private void initLeftRoundedPath(RectF rectF, Path path, float f) {
        path.moveTo(this.mArrowWidth + rectF.left + this.mCornersRadius + f, rectF.top + f);
        path.lineTo((rectF.width() - this.mCornersRadius) - f, rectF.top + f);
        float f2 = rectF.right;
        float f3 = this.mCornersRadius;
        float f4 = rectF.top;
        path.arcTo(new RectF(f2 - f3, f4 + f, f2 - f, f3 + f4), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.mCornersRadius) - f);
        float f5 = rectF.right;
        float f6 = this.mCornersRadius;
        float f7 = rectF.bottom;
        path.arcTo(new RectF(f5 - f6, f7 - f6, f5 - f, f7 - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.mArrowWidth + this.mCornersRadius + f, rectF.bottom - f);
        float f8 = rectF.left;
        float f9 = this.mArrowWidth;
        float f10 = rectF.bottom;
        float f11 = this.mCornersRadius;
        path.arcTo(new RectF(f8 + f9 + f, f10 - f11, f11 + f8 + f9, f10 - f), 90.0f, 90.0f);
        float f12 = f / 2.0f;
        path.lineTo(rectF.left + this.mArrowWidth + f, (this.mArrowHeight + this.mArrowPosition) - f12);
        path.lineTo(rectF.left + f + f, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo(rectF.left + this.mArrowWidth + f, this.mArrowPosition + f12);
        path.lineTo(rectF.left + this.mArrowWidth + f, rectF.top + this.mCornersRadius + f);
        float f13 = rectF.left;
        float f14 = this.mArrowWidth;
        float f15 = rectF.top;
        float f16 = this.mCornersRadius;
        path.arcTo(new RectF(f13 + f14 + f, f + f15, f13 + f16 + f14, f16 + f15), 180.0f, 90.0f);
        path.close();
    }

    private void initTopRoundedPath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.mArrowPosition, this.mCornersRadius) + f, rectF.top + this.mArrowHeight + f);
        float f2 = f / 2.0f;
        path.lineTo(rectF.left + this.mArrowPosition + f2, rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.left + (this.mArrowWidth / 2.0f) + this.mArrowPosition, rectF.top + f + f);
        path.lineTo(((rectF.left + this.mArrowWidth) + this.mArrowPosition) - f2, rectF.top + this.mArrowHeight + f);
        path.lineTo((rectF.right - this.mCornersRadius) - f, rectF.top + this.mArrowHeight + f);
        float f3 = rectF.right;
        float f4 = this.mCornersRadius;
        float f5 = rectF.top;
        float f6 = this.mArrowHeight;
        path.arcTo(new RectF(f3 - f4, f5 + f6 + f, f3 - f, f4 + f5 + f6), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.mCornersRadius) - f);
        float f7 = rectF.right;
        float f8 = this.mCornersRadius;
        float f9 = rectF.bottom;
        path.arcTo(new RectF(f7 - f8, f9 - f8, f7 - f, f9 - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.mCornersRadius + f, rectF.bottom - f);
        float f10 = rectF.left;
        float f11 = rectF.bottom;
        float f12 = this.mCornersRadius;
        path.arcTo(new RectF(f10 + f, f11 - f12, f12 + f10, f11 - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.mArrowHeight + this.mCornersRadius + f);
        float f13 = rectF.left;
        float f14 = f13 + f;
        float f15 = rectF.top;
        float f16 = this.mArrowHeight;
        float f17 = f15 + f16 + f;
        float f18 = this.mCornersRadius;
        path.arcTo(new RectF(f14, f17, f13 + f18, f18 + f15 + f16), 180.0f, 90.0f);
        path.close();
    }

    private void initBottomSquarePath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.mArrowHeight) - f);
        float f2 = f / 2.0f;
        path.lineTo(((rectF.left + this.mArrowWidth) + this.mArrowPosition) - f2, (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + this.mArrowPosition + (this.mArrowWidth / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.mArrowPosition + f2, (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + this.mArrowPosition + f, (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.mArrowHeight) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void initLeftSquarePath(RectF rectF, Path path, float f) {
        path.moveTo(this.mArrowWidth + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.mArrowWidth + f, rectF.bottom - f);
        float f2 = f / 2.0f;
        path.lineTo(rectF.left + this.mArrowWidth + f, (this.mArrowHeight + this.mArrowPosition) - f2);
        path.lineTo(rectF.left + f + f, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo(rectF.left + this.mArrowWidth + f, this.mArrowPosition + f2);
        path.lineTo(rectF.left + this.mArrowWidth + f, rectF.top + f);
        path.close();
    }

    private void initRightSquarePath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.mArrowWidth) - f, rectF.top + f);
        float f2 = f / 2.0f;
        path.lineTo((rectF.right - this.mArrowWidth) - f, this.mArrowPosition + f2);
        path.lineTo((rectF.right - f) - f, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo((rectF.right - this.mArrowWidth) - f, (this.mArrowPosition + this.mArrowHeight) - f2);
        path.lineTo((rectF.right - this.mArrowWidth) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void initTopSquarePath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.mArrowPosition + f, rectF.top + this.mArrowHeight + f);
        float f2 = f / 2.0f;
        path.lineTo(rectF.left + this.mArrowPosition + f2, rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.left + (this.mArrowWidth / 2.0f) + this.mArrowPosition, rectF.top + f + f);
        path.lineTo(((rectF.left + this.mArrowWidth) + this.mArrowPosition) - f2, rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.right - f, rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.mArrowHeight + f);
        path.lineTo(rectF.left + this.mArrowPosition + f, rectF.top + this.mArrowHeight + f);
        path.close();
    }

    private void initPath(ArrowDirection arrowDirection, Path path, float f) {
        int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$ui$bubble$ArrowDirection[arrowDirection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        float f2 = this.mCornersRadius;
                        if (f2 <= 0.0f) {
                            initBottomSquarePath(this.mRect, path, f);
                            return;
                        } else if (f > 0.0f && f > f2) {
                            initBottomSquarePath(this.mRect, path, f);
                            return;
                        } else {
                            initBottomRoundedPath(this.mRect, path, f);
                            return;
                        }
                    }
                    return;
                }
                float f3 = this.mCornersRadius;
                if (f3 <= 0.0f) {
                    initRightSquarePath(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > f3) {
                    initRightSquarePath(this.mRect, path, f);
                    return;
                } else {
                    initRightRoundedPath(this.mRect, path, f);
                    return;
                }
            }
            float f4 = this.mCornersRadius;
            if (f4 <= 0.0f) {
                initTopSquarePath(this.mRect, path, f);
                return;
            } else if (f > 0.0f && f > f4) {
                initTopSquarePath(this.mRect, path, f);
                return;
            } else {
                initTopRoundedPath(this.mRect, path, f);
                return;
            }
        }
        float f5 = this.mCornersRadius;
        if (f5 <= 0.0f) {
            initLeftSquarePath(this.mRect, path, f);
        } else if (f > 0.0f && f > f5) {
            initLeftSquarePath(this.mRect, path, f);
        } else {
            initLeftRoundedPath(this.mRect, path, f);
        }
    }

    private void initRightRoundedPath(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.mCornersRadius + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.mCornersRadius) - this.mArrowWidth) - f, rectF.top + f);
        float f2 = rectF.right;
        float f3 = this.mCornersRadius;
        float f4 = this.mArrowWidth;
        float f5 = rectF.top;
        path.arcTo(new RectF((f2 - f3) - f4, f5 + f, (f2 - f4) - f, f3 + f5), 270.0f, 90.0f);
        float f6 = f / 2.0f;
        path.lineTo((rectF.right - this.mArrowWidth) - f, this.mArrowPosition + f6);
        path.lineTo((rectF.right - f) - f, this.mArrowPosition + (this.mArrowHeight / 2.0f));
        path.lineTo((rectF.right - this.mArrowWidth) - f, (this.mArrowPosition + this.mArrowHeight) - f6);
        path.lineTo((rectF.right - this.mArrowWidth) - f, (rectF.bottom - this.mCornersRadius) - f);
        float f7 = rectF.right;
        float f8 = this.mCornersRadius;
        float f9 = this.mArrowWidth;
        float f10 = rectF.bottom;
        path.arcTo(new RectF((f7 - f8) - f9, f10 - f8, (f7 - f9) - f, f10 - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.mArrowWidth + f, rectF.bottom - f);
        float f11 = rectF.left;
        float f12 = rectF.bottom;
        float f13 = this.mCornersRadius;
        path.arcTo(new RectF(f11 + f, f12 - f13, f13 + f11, f12 - f), 90.0f, 90.0f);
        float f14 = rectF.left;
        float f15 = rectF.top;
        float f16 = this.mCornersRadius;
        path.arcTo(new RectF(f14 + f, f + f15, f14 + f16, f16 + f15), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mStrokeWidth > 0.0f) {
            canvas.drawPath(this.mStrokePath, this.mStrokePaint);
        }
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.mRect.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.mRect.width();
    }
}
