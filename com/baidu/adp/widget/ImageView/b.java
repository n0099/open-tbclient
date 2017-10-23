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
    private final Paint AV;
    private final BitmapShader GG;
    private final Paint GH;
    private final int GI;
    private final int GJ;
    private final RectF AY = new RectF();
    private final RectF GE = new RectF();
    private final RectF GF = new RectF();
    private final RectF AZ = new RectF();
    private final Matrix BU = new Matrix();
    private float GK = 0.0f;
    private boolean GL = false;
    private float GM = 0.0f;
    private ColorStateList GN = ColorStateList.valueOf(0);
    private ImageView.ScaleType GO = ImageView.ScaleType.FIT_XY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Bitmap bitmap) {
        this.GI = bitmap.getWidth();
        this.GJ = bitmap.getHeight();
        this.GF.set(0.0f, 0.0f, this.GI, this.GJ);
        this.GG = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.GG.setLocalMatrix(this.BU);
        this.GH = new Paint();
        this.GH.setStyle(Paint.Style.FILL);
        this.GH.setAntiAlias(true);
        this.GH.setShader(this.GG);
        this.AV = new Paint();
        this.AV.setStyle(Paint.Style.STROKE);
        this.AV.setAntiAlias(true);
        this.AV.setColor(this.GN.getColorForState(getState(), 0));
        this.AV.setStrokeWidth(this.GM);
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
                if (b != null) {
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
        return this.GN.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.GN.getColorForState(iArr, 0);
        if (this.AV.getColor() != colorForState) {
            this.AV.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    private void kV() {
        float min;
        float width;
        float f;
        float f2 = 0.0f;
        this.AZ.set(this.AY);
        this.GE.set(this.GM, this.GM, this.AZ.width() - this.GM, this.AZ.height() - this.GM);
        switch (AnonymousClass1.GP[this.GO.ordinal()]) {
            case 1:
                this.AZ.set(this.AY);
                this.GE.set(this.GM, this.GM, this.AZ.width() - this.GM, this.AZ.height() - this.GM);
                this.BU.set(null);
                this.BU.setTranslate((int) (((this.GE.width() - this.GI) * 0.5f) + 0.5f), (int) (((this.GE.height() - this.GJ) * 0.5f) + 0.5f));
                break;
            case 2:
                this.AZ.set(this.AY);
                this.GE.set(this.GM, this.GM, this.AZ.width() - this.GM, this.AZ.height() - this.GM);
                this.BU.set(null);
                if (this.GI * this.GE.height() > this.GE.width() * this.GJ) {
                    width = this.GE.height() / this.GJ;
                    f = (this.GE.width() - (this.GI * width)) * 0.5f;
                } else {
                    width = this.GE.width() / this.GI;
                    f = 0.0f;
                    f2 = (this.GE.height() - (this.GJ * width)) * 0.5f;
                }
                this.BU.setScale(width, width);
                this.BU.postTranslate(((int) (f + 0.5f)) + this.GM, ((int) (f2 + 0.5f)) + this.GM);
                break;
            case 3:
                this.BU.set(null);
                if (this.GI <= this.AY.width() && this.GJ <= this.AY.height()) {
                    min = 1.0f;
                } else {
                    min = Math.min(this.AY.width() / this.GI, this.AY.height() / this.GJ);
                }
                this.BU.setScale(min, min);
                this.BU.postTranslate((int) (((this.AY.width() - (this.GI * min)) * 0.5f) + 0.5f), (int) (((this.AY.height() - (this.GJ * min)) * 0.5f) + 0.5f));
                this.AZ.set(this.GF);
                this.BU.mapRect(this.AZ);
                this.GE.set(this.AZ.left + this.GM, this.AZ.top + this.GM, this.AZ.right - this.GM, this.AZ.bottom - this.GM);
                this.BU.setRectToRect(this.GF, this.GE, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.AZ.set(this.GF);
                this.BU.setRectToRect(this.GF, this.AY, Matrix.ScaleToFit.CENTER);
                this.BU.mapRect(this.AZ);
                this.GE.set(this.AZ.left + this.GM, this.AZ.top + this.GM, this.AZ.right - this.GM, this.AZ.bottom - this.GM);
                this.BU.setRectToRect(this.GF, this.GE, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.AZ.set(this.GF);
                this.BU.setRectToRect(this.GF, this.AY, Matrix.ScaleToFit.END);
                this.BU.mapRect(this.AZ);
                this.GE.set(this.AZ.left + this.GM, this.AZ.top + this.GM, this.AZ.right - this.GM, this.AZ.bottom - this.GM);
                this.BU.setRectToRect(this.GF, this.GE, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.AZ.set(this.GF);
                this.BU.setRectToRect(this.GF, this.AY, Matrix.ScaleToFit.START);
                this.BU.mapRect(this.AZ);
                this.GE.set(this.AZ.left + this.GM, this.AZ.top + this.GM, this.AZ.right - this.GM, this.AZ.bottom - this.GM);
                this.BU.setRectToRect(this.GF, this.GE, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.AZ.set(this.AY);
                this.GE.set(this.GM + 0.0f, 0.0f + this.GM, this.AZ.width() - this.GM, this.AZ.height() - this.GM);
                this.BU.set(null);
                this.BU.setRectToRect(this.GF, this.GE, Matrix.ScaleToFit.FILL);
                break;
        }
        this.AZ.inset(this.GM / 2.0f, this.GM / 2.0f);
        this.GG.setLocalMatrix(this.BU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.adp.widget.ImageView.b$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] GP = new int[ImageView.ScaleType.values().length];

        static {
            try {
                GP[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                GP[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                GP[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                GP[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                GP[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                GP[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                GP[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.AY.set(rect);
        kV();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.GL) {
            if (this.GM > 0.0f) {
                canvas.drawOval(this.AZ, this.AV);
                canvas.drawOval(this.GE, this.GH);
                return;
            }
            canvas.drawOval(this.GE, this.GH);
        } else if (this.GM > 0.0f) {
            canvas.drawRoundRect(this.AZ, this.GK, this.GK, this.AV);
            canvas.drawRoundRect(this.GE, Math.max(this.GK - this.GM, 0.0f), Math.max(this.GK - this.GM, 0.0f), this.GH);
        } else {
            canvas.drawRoundRect(this.GE, this.GK, this.GK, this.GH);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.GH.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.GH.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.GI;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.GJ;
    }

    public b u(float f) {
        this.GK = f;
        return this;
    }

    public b aK(int i) {
        this.GM = i;
        this.AV.setStrokeWidth(this.GM);
        return this;
    }

    public b a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.GN = colorStateList;
        this.AV.setColor(this.GN.getColorForState(getState(), 0));
        return this;
    }

    public b T(boolean z) {
        this.GL = z;
        return this;
    }

    public b b(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_XY;
        }
        if (this.GO != scaleType) {
            this.GO = scaleType;
            kV();
        }
        return this;
    }
}
