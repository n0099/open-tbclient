package com.baidu.searchbox.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.Log;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class RoundedDrawable extends Drawable {
    public static final String TAG = "RoundedDrawable";
    public final int mBitmapHeight;
    public final Paint mBitmapPaint;
    public final BitmapShader mBitmapShader;
    public final int mBitmapWidth;
    public int mBorderColor;
    public final Paint mBorderPaint;
    public int mBorderWidth;
    public float mCornerRadius;
    public final RectF mBounds = new RectF();
    public final RectF mDrawableRect = new RectF();
    public final RectF mBitmapRect = new RectF();
    public final RectF mBorderRect = new RectF();
    public final Matrix mShaderMatrix = new Matrix();
    public ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_XY;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* renamed from: com.baidu.searchbox.ui.RoundedDrawable$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedDrawable(Bitmap bitmap, float f, int i, int i2) {
        this.mBorderWidth = i;
        this.mBorderColor = i2;
        this.mBitmapWidth = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.mBitmapHeight = height;
        this.mBitmapRect.set(0.0f, 0.0f, this.mBitmapWidth, height);
        this.mCornerRadius = f;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.mBitmapShader = bitmapShader;
        bitmapShader.setLocalMatrix(this.mShaderMatrix);
        Paint paint = new Paint();
        this.mBitmapPaint = paint;
        paint.setAntiAlias(true);
        this.mBitmapPaint.setShader(this.mBitmapShader);
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(i);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mBorderWidth > 0) {
            RectF rectF = this.mBorderRect;
            float f = this.mCornerRadius;
            canvas.drawRoundRect(rectF, f, f, this.mBorderPaint);
            canvas.drawRoundRect(this.mDrawableRect, Math.max(this.mCornerRadius - this.mBorderWidth, 0.0f), Math.max(this.mCornerRadius - this.mBorderWidth, 0.0f), this.mBitmapPaint);
            return;
        }
        RectF rectF2 = this.mDrawableRect;
        float f2 = this.mCornerRadius;
        canvas.drawRoundRect(rectF2, f2, f2, this.mBitmapPaint);
    }

    public static Drawable fromDrawable(Drawable drawable, float f) {
        return fromDrawable(drawable, null, f, 0, 0);
    }

    public static Drawable fromDrawable(Drawable drawable, ImageView.ScaleType scaleType, float f, int i, int i2) {
        if (drawable != null) {
            if (drawable instanceof TransitionDrawable) {
                TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                int numberOfLayers = transitionDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i3 = 0; i3 < numberOfLayers; i3++) {
                    Drawable drawable2 = transitionDrawable.getDrawable(i3);
                    if (drawable2 instanceof ColorDrawable) {
                        drawableArr[i3] = drawable2;
                    } else if (drawable2 instanceof RoundedDrawable) {
                        drawableArr[i3] = drawable2;
                    } else {
                        drawableArr[i3] = new RoundedDrawable(drawableToBitmap(drawable2), f, i, i2);
                        if (scaleType != null) {
                            ((RoundedDrawable) drawableArr[i3]).setScaleType(scaleType);
                        }
                    }
                }
                return new TransitionDrawable(drawableArr);
            }
            Bitmap drawableToBitmap = drawableToBitmap(drawable);
            if (drawableToBitmap != null) {
                RoundedDrawable roundedDrawable = new RoundedDrawable(drawableToBitmap, f, i, i2);
                if (scaleType != null) {
                    roundedDrawable.setScaleType(scaleType);
                }
                return roundedDrawable;
            }
            Log.w(TAG, "Failed to create bitmap from drawable!");
        }
        return drawable;
    }

    private void setMatrix() {
        float width;
        float height;
        float min;
        this.mBorderRect.set(this.mBounds);
        RectF rectF = this.mDrawableRect;
        int i = this.mBorderWidth;
        rectF.set(i + 0, i + 0, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
        switch (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
            case 1:
                this.mBorderRect.set(this.mBounds);
                RectF rectF2 = this.mDrawableRect;
                int i2 = this.mBorderWidth;
                rectF2.set(i2 + 0, i2 + 0, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
                this.mShaderMatrix.set(null);
                this.mShaderMatrix.setTranslate((int) (((this.mDrawableRect.width() - this.mBitmapWidth) * 0.5f) + 0.5f), (int) (((this.mDrawableRect.height() - this.mBitmapHeight) * 0.5f) + 0.5f));
                break;
            case 2:
                this.mBorderRect.set(this.mBounds);
                RectF rectF3 = this.mDrawableRect;
                int i3 = this.mBorderWidth;
                rectF3.set(i3 + 0, i3 + 0, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
                this.mShaderMatrix.set(null);
                float f = 0.0f;
                if (this.mBitmapWidth * this.mDrawableRect.height() > this.mDrawableRect.width() * this.mBitmapHeight) {
                    width = this.mDrawableRect.height() / this.mBitmapHeight;
                    f = (this.mDrawableRect.width() - (this.mBitmapWidth * width)) * 0.5f;
                    height = 0.0f;
                } else {
                    width = this.mDrawableRect.width() / this.mBitmapWidth;
                    height = (this.mDrawableRect.height() - (this.mBitmapHeight * width)) * 0.5f;
                }
                this.mShaderMatrix.setScale(width, width);
                Matrix matrix = this.mShaderMatrix;
                int i4 = this.mBorderWidth;
                matrix.postTranslate(((int) (f + 0.5f)) + i4, ((int) (height + 0.5f)) + i4);
                break;
            case 3:
                this.mShaderMatrix.set(null);
                if (this.mBitmapWidth <= this.mBounds.width() && this.mBitmapHeight <= this.mBounds.height()) {
                    min = 1.0f;
                } else {
                    min = Math.min(this.mBounds.width() / this.mBitmapWidth, this.mBounds.height() / this.mBitmapHeight);
                }
                this.mShaderMatrix.setScale(min, min);
                this.mShaderMatrix.postTranslate((int) (((this.mBounds.width() - (this.mBitmapWidth * min)) * 0.5f) + 0.5f), (int) (((this.mBounds.height() - (this.mBitmapHeight * min)) * 0.5f) + 0.5f));
                this.mBorderRect.set(this.mBitmapRect);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                RectF rectF4 = this.mDrawableRect;
                RectF rectF5 = this.mBorderRect;
                float f2 = rectF5.left;
                int i5 = this.mBorderWidth;
                rectF4.set(f2 + i5, rectF5.top + i5, rectF5.right - i5, rectF5.bottom - i5);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.mBorderRect.set(this.mBitmapRect);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.CENTER);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                RectF rectF6 = this.mDrawableRect;
                RectF rectF7 = this.mBorderRect;
                float f3 = rectF7.left;
                int i6 = this.mBorderWidth;
                rectF6.set(f3 + i6, rectF7.top + i6, rectF7.right - i6, rectF7.bottom - i6);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.mBorderRect.set(this.mBitmapRect);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.END);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                RectF rectF8 = this.mDrawableRect;
                RectF rectF9 = this.mBorderRect;
                float f4 = rectF9.left;
                int i7 = this.mBorderWidth;
                rectF8.set(f4 + i7, rectF9.top + i7, rectF9.right - i7, rectF9.bottom - i7);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.mBorderRect.set(this.mBitmapRect);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.START);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                RectF rectF10 = this.mDrawableRect;
                RectF rectF11 = this.mBorderRect;
                float f5 = rectF11.left;
                int i8 = this.mBorderWidth;
                rectF10.set(f5 + i8, rectF11.top + i8, rectF11.right - i8, rectF11.bottom - i8);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.mBorderRect.set(this.mBounds);
                RectF rectF12 = this.mDrawableRect;
                int i9 = this.mBorderWidth;
                rectF12.set(i9 + 0, i9 + 0, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
                this.mShaderMatrix.set(null);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
        }
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mBounds.set(rect);
        setMatrix();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mBitmapPaint.setAlpha(i);
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
        this.mBorderPaint.setColor(i);
    }

    public void setBorderWidth(int i) {
        this.mBorderWidth = i;
        this.mBorderPaint.setStrokeWidth(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mBitmapPaint.setColorFilter(colorFilter);
    }

    public void setCornerRadius(float f) {
        this.mCornerRadius = f;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_XY;
        }
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            setMatrix();
        }
    }
}
