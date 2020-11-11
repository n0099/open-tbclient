package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
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
/* loaded from: classes10.dex */
public class c extends Drawable {
    private final int mBitmapHeight;
    private final Paint mBitmapPaint;
    private final BitmapShader mBitmapShader;
    private final int mBitmapWidth;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private int mBorderWidth;
    private float mCornerRadius;
    private final RectF mBounds = new RectF();
    private final RectF mDrawableRect = new RectF();
    private final RectF mBitmapRect = new RectF();
    private final RectF mBorderRect = new RectF();
    private final Matrix mShaderMatrix = new Matrix();
    private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_XY;

    public c(Bitmap bitmap, float f, int i, int i2) {
        this.mBorderWidth = i;
        this.mBorderColor = i2;
        this.mBitmapWidth = bitmap.getWidth();
        this.mBitmapHeight = bitmap.getHeight();
        this.mBitmapRect.set(0.0f, 0.0f, this.mBitmapWidth, this.mBitmapHeight);
        this.mCornerRadius = f;
        this.mBitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setShader(this.mBitmapShader);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setAntiAlias(true);
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

    @SuppressLint({"SwanDebugLog"})
    public static Drawable a(Drawable drawable, ImageView.ScaleType scaleType, float f, int i, int i2) {
        if (drawable != null) {
            if (drawable instanceof TransitionDrawable) {
                TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                int numberOfLayers = transitionDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i3 = 0; i3 < numberOfLayers; i3++) {
                    Drawable drawable2 = transitionDrawable.getDrawable(i3);
                    if (drawable2 instanceof ColorDrawable) {
                        drawableArr[i3] = drawable2;
                    } else if (drawable2 instanceof c) {
                        drawableArr[i3] = drawable2;
                    } else {
                        drawableArr[i3] = new c(drawableToBitmap(drawable2), f, i, i2);
                        if (scaleType != null) {
                            ((c) drawableArr[i3]).setScaleType(scaleType);
                        }
                    }
                }
                return new TransitionDrawable(drawableArr);
            }
            Bitmap drawableToBitmap = drawableToBitmap(drawable);
            if (drawableToBitmap != null) {
                c cVar = new c(drawableToBitmap, f, i, i2);
                if (scaleType != null) {
                    cVar.setScaleType(scaleType);
                    return cVar;
                }
                return cVar;
            }
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return drawable;
        }
        return drawable;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_XY;
        }
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            aGm();
        }
    }

    private void aGm() {
        float min;
        float width;
        float f;
        float f2 = 0.0f;
        this.mBorderRect.set(this.mBounds);
        this.mDrawableRect.set(this.mBorderWidth + 0, this.mBorderWidth + 0, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
        switch (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
            case 1:
                this.mBorderRect.set(this.mBounds);
                this.mDrawableRect.set(this.mBorderWidth + 0, this.mBorderWidth + 0, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
                this.mShaderMatrix.set(null);
                this.mShaderMatrix.setTranslate((int) (((this.mDrawableRect.width() - this.mBitmapWidth) * 0.5f) + 0.5f), (int) (((this.mDrawableRect.height() - this.mBitmapHeight) * 0.5f) + 0.5f));
                break;
            case 2:
                this.mBorderRect.set(this.mBounds);
                this.mDrawableRect.set(this.mBorderWidth + 0, this.mBorderWidth + 0, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
                this.mShaderMatrix.set(null);
                if (this.mBitmapWidth * this.mDrawableRect.height() > this.mDrawableRect.width() * this.mBitmapHeight) {
                    width = this.mDrawableRect.height() / this.mBitmapHeight;
                    f = (this.mDrawableRect.width() - (this.mBitmapWidth * width)) * 0.5f;
                } else {
                    width = this.mDrawableRect.width() / this.mBitmapWidth;
                    f = 0.0f;
                    f2 = (this.mDrawableRect.height() - (this.mBitmapHeight * width)) * 0.5f;
                }
                this.mShaderMatrix.setScale(width, width);
                this.mShaderMatrix.postTranslate(((int) (f + 0.5f)) + this.mBorderWidth, ((int) (f2 + 0.5f)) + this.mBorderWidth);
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
                this.mDrawableRect.set(this.mBorderRect.left + this.mBorderWidth, this.mBorderRect.top + this.mBorderWidth, this.mBorderRect.right - this.mBorderWidth, this.mBorderRect.bottom - this.mBorderWidth);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.mBorderRect.set(this.mBitmapRect);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.CENTER);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                this.mDrawableRect.set(this.mBorderRect.left + this.mBorderWidth, this.mBorderRect.top + this.mBorderWidth, this.mBorderRect.right - this.mBorderWidth, this.mBorderRect.bottom - this.mBorderWidth);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.mBorderRect.set(this.mBitmapRect);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.END);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                this.mDrawableRect.set(this.mBorderRect.left + this.mBorderWidth, this.mBorderRect.top + this.mBorderWidth, this.mBorderRect.right - this.mBorderWidth, this.mBorderRect.bottom - this.mBorderWidth);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.mBorderRect.set(this.mBitmapRect);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBounds, Matrix.ScaleToFit.START);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                this.mDrawableRect.set(this.mBorderRect.left + this.mBorderWidth, this.mBorderRect.top + this.mBorderWidth, this.mBorderRect.right - this.mBorderWidth, this.mBorderRect.bottom - this.mBorderWidth);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.mBorderRect.set(this.mBounds);
                this.mDrawableRect.set(this.mBorderWidth + 0, this.mBorderWidth + 0, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
                this.mShaderMatrix.set(null);
                this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
        }
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.res.ui.c$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ImageView.ScaleType.values().length];

        static {
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mBounds.set(rect);
        aGm();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mBorderWidth > 0) {
            canvas.drawRoundRect(this.mBorderRect, this.mCornerRadius, this.mCornerRadius, this.mBorderPaint);
            canvas.drawRoundRect(this.mDrawableRect, Math.max(this.mCornerRadius - this.mBorderWidth, 0.0f), Math.max(this.mCornerRadius - this.mBorderWidth, 0.0f), this.mBitmapPaint);
            return;
        }
        canvas.drawRoundRect(this.mDrawableRect, this.mCornerRadius, this.mCornerRadius, this.mBitmapPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mBitmapPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mBitmapPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public void setCornerRadius(float f) {
        this.mCornerRadius = f;
    }

    public void setBorderWidth(int i) {
        this.mBorderWidth = i;
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
        this.mBorderPaint.setColor(i);
    }
}
