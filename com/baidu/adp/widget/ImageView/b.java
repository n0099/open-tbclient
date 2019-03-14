package com.baidu.adp.widget.ImageView;

import android.content.res.ColorStateList;
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
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends Drawable {
    private final int mBitmapHeight;
    private final Paint mBitmapPaint;
    private final BitmapShader mBitmapShader;
    private final int mBitmapWidth;
    private final Paint mBorderPaint;
    private final RectF IS = new RectF();
    private final RectF mDrawableRect = new RectF();
    private final RectF Ok = new RectF();
    private final RectF mBorderRect = new RectF();
    private final Matrix mShaderMatrix = new Matrix();
    private float mCornerRadius = 0.0f;
    private boolean Ol = false;
    private float mBorderWidth = 0.0f;
    private ColorStateList Om = ColorStateList.valueOf(0);
    private ImageView.ScaleType On = ImageView.ScaleType.FIT_XY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Bitmap bitmap) {
        this.mBitmapWidth = bitmap.getWidth();
        this.mBitmapHeight = bitmap.getHeight();
        this.Ok.set(0.0f, 0.0f, this.mBitmapWidth, this.mBitmapHeight);
        this.mBitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setStyle(Paint.Style.FILL);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setShader(this.mBitmapShader);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.Om.getColorForState(getState(), 0));
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    }

    public static Bitmap b(Drawable drawable) {
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

    public static Drawable c(Drawable drawable) {
        if (drawable != null && !(drawable instanceof b) && !(drawable instanceof ColorDrawable)) {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), c(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            } else if (drawable instanceof StateListDrawable) {
                return (StateListDrawable) drawable;
            } else {
                Bitmap b = b(drawable);
                if (b != null && !b.isRecycled()) {
                    return new b(b);
                }
                Log.w("BdRoundedDrawable", "Failed to create bitmap from drawable!");
                return drawable;
            }
        }
        return drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.Om.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.Om.getColorForState(iArr, 0);
        if (this.mBorderPaint.getColor() != colorForState) {
            this.mBorderPaint.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    private void updateShaderMatrix() {
        float min;
        float width;
        float f;
        float f2 = 0.0f;
        this.mBorderRect.set(this.IS);
        this.mDrawableRect.set(this.mBorderWidth, this.mBorderWidth, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
        switch (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.On.ordinal()]) {
            case 1:
                this.mBorderRect.set(this.IS);
                this.mDrawableRect.set(this.mBorderWidth, this.mBorderWidth, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
                this.mShaderMatrix.set(null);
                this.mShaderMatrix.setTranslate((int) (((this.mDrawableRect.width() - this.mBitmapWidth) * 0.5f) + 0.5f), (int) (((this.mDrawableRect.height() - this.mBitmapHeight) * 0.5f) + 0.5f));
                break;
            case 2:
                this.mBorderRect.set(this.IS);
                this.mDrawableRect.set(this.mBorderWidth, this.mBorderWidth, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
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
                if (this.mBitmapWidth <= this.IS.width() && this.mBitmapHeight <= this.IS.height()) {
                    min = 1.0f;
                } else {
                    min = Math.min(this.IS.width() / this.mBitmapWidth, this.IS.height() / this.mBitmapHeight);
                }
                this.mShaderMatrix.setScale(min, min);
                this.mShaderMatrix.postTranslate((int) (((this.IS.width() - (this.mBitmapWidth * min)) * 0.5f) + 0.5f), (int) (((this.IS.height() - (this.mBitmapHeight * min)) * 0.5f) + 0.5f));
                this.mBorderRect.set(this.Ok);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                this.mDrawableRect.set(this.mBorderRect.left + this.mBorderWidth, this.mBorderRect.top + this.mBorderWidth, this.mBorderRect.right - this.mBorderWidth, this.mBorderRect.bottom - this.mBorderWidth);
                this.mShaderMatrix.setRectToRect(this.Ok, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.mBorderRect.set(this.Ok);
                this.mShaderMatrix.setRectToRect(this.Ok, this.IS, Matrix.ScaleToFit.CENTER);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                this.mDrawableRect.set(this.mBorderRect.left + this.mBorderWidth, this.mBorderRect.top + this.mBorderWidth, this.mBorderRect.right - this.mBorderWidth, this.mBorderRect.bottom - this.mBorderWidth);
                this.mShaderMatrix.setRectToRect(this.Ok, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.mBorderRect.set(this.Ok);
                this.mShaderMatrix.setRectToRect(this.Ok, this.IS, Matrix.ScaleToFit.END);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                this.mDrawableRect.set(this.mBorderRect.left + this.mBorderWidth, this.mBorderRect.top + this.mBorderWidth, this.mBorderRect.right - this.mBorderWidth, this.mBorderRect.bottom - this.mBorderWidth);
                this.mShaderMatrix.setRectToRect(this.Ok, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.mBorderRect.set(this.Ok);
                this.mShaderMatrix.setRectToRect(this.Ok, this.IS, Matrix.ScaleToFit.START);
                this.mShaderMatrix.mapRect(this.mBorderRect);
                this.mDrawableRect.set(this.mBorderRect.left + this.mBorderWidth, this.mBorderRect.top + this.mBorderWidth, this.mBorderRect.right - this.mBorderWidth, this.mBorderRect.bottom - this.mBorderWidth);
                this.mShaderMatrix.setRectToRect(this.Ok, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.mBorderRect.set(this.IS);
                this.mDrawableRect.set(this.mBorderWidth + 0.0f, 0.0f + this.mBorderWidth, this.mBorderRect.width() - this.mBorderWidth, this.mBorderRect.height() - this.mBorderWidth);
                this.mShaderMatrix.set(null);
                this.mShaderMatrix.setRectToRect(this.Ok, this.mDrawableRect, Matrix.ScaleToFit.FILL);
                break;
        }
        this.mBorderRect.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.adp.widget.ImageView.b$1  reason: invalid class name */
    /* loaded from: classes.dex */
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
        this.IS.set(rect);
        updateShaderMatrix();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.Ol) {
            if (this.mBorderWidth > 0.0f) {
                canvas.drawOval(this.mBorderRect, this.mBorderPaint);
                canvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
                return;
            }
            canvas.drawOval(this.mDrawableRect, this.mBitmapPaint);
        } else if (this.mBorderWidth > 0.0f) {
            canvas.drawRoundRect(this.mBorderRect, this.mCornerRadius, this.mCornerRadius, this.mBorderPaint);
            canvas.drawRoundRect(this.mDrawableRect, Math.max(this.mCornerRadius - this.mBorderWidth, 0.0f), Math.max(this.mCornerRadius - this.mBorderWidth, 0.0f), this.mBitmapPaint);
        } else {
            canvas.drawRoundRect(this.mDrawableRect, this.mCornerRadius, this.mCornerRadius, this.mBitmapPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mBitmapPaint.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mBitmapPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public b L(float f) {
        this.mCornerRadius = f;
        return this;
    }

    public b aQ(int i) {
        this.mBorderWidth = i;
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        return this;
    }

    public b a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.Om = colorStateList;
        this.mBorderPaint.setColor(this.Om.getColorForState(getState(), 0));
        return this;
    }

    public b av(boolean z) {
        this.Ol = z;
        return this;
    }

    public b b(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_XY;
        }
        if (this.On != scaleType) {
            this.On = scaleType;
            updateShaderMatrix();
        }
        return this;
    }
}
