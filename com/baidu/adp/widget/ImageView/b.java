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
    private final Paint AU;
    private final BitmapShader GF;
    private final Paint GG;
    private final int GH;
    private final int GI;
    private final RectF AX = new RectF();
    private final RectF GD = new RectF();
    private final RectF GE = new RectF();
    private final RectF AY = new RectF();
    private final Matrix BT = new Matrix();
    private float GJ = 0.0f;
    private boolean GK = false;
    private float GL = 0.0f;
    private ColorStateList GM = ColorStateList.valueOf(0);
    private ImageView.ScaleType GN = ImageView.ScaleType.FIT_XY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Bitmap bitmap) {
        this.GH = bitmap.getWidth();
        this.GI = bitmap.getHeight();
        this.GE.set(0.0f, 0.0f, this.GH, this.GI);
        this.GF = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.GF.setLocalMatrix(this.BT);
        this.GG = new Paint();
        this.GG.setStyle(Paint.Style.FILL);
        this.GG.setAntiAlias(true);
        this.GG.setShader(this.GF);
        this.AU = new Paint();
        this.AU.setStyle(Paint.Style.STROKE);
        this.AU.setAntiAlias(true);
        this.AU.setColor(this.GM.getColorForState(getState(), 0));
        this.AU.setStrokeWidth(this.GL);
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
        return this.GM.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.GM.getColorForState(iArr, 0);
        if (this.AU.getColor() != colorForState) {
            this.AU.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    private void kV() {
        float min;
        float width;
        float f;
        float f2 = 0.0f;
        this.AY.set(this.AX);
        this.GD.set(this.GL, this.GL, this.AY.width() - this.GL, this.AY.height() - this.GL);
        switch (AnonymousClass1.GO[this.GN.ordinal()]) {
            case 1:
                this.AY.set(this.AX);
                this.GD.set(this.GL, this.GL, this.AY.width() - this.GL, this.AY.height() - this.GL);
                this.BT.set(null);
                this.BT.setTranslate((int) (((this.GD.width() - this.GH) * 0.5f) + 0.5f), (int) (((this.GD.height() - this.GI) * 0.5f) + 0.5f));
                break;
            case 2:
                this.AY.set(this.AX);
                this.GD.set(this.GL, this.GL, this.AY.width() - this.GL, this.AY.height() - this.GL);
                this.BT.set(null);
                if (this.GH * this.GD.height() > this.GD.width() * this.GI) {
                    width = this.GD.height() / this.GI;
                    f = (this.GD.width() - (this.GH * width)) * 0.5f;
                } else {
                    width = this.GD.width() / this.GH;
                    f = 0.0f;
                    f2 = (this.GD.height() - (this.GI * width)) * 0.5f;
                }
                this.BT.setScale(width, width);
                this.BT.postTranslate(((int) (f + 0.5f)) + this.GL, ((int) (f2 + 0.5f)) + this.GL);
                break;
            case 3:
                this.BT.set(null);
                if (this.GH <= this.AX.width() && this.GI <= this.AX.height()) {
                    min = 1.0f;
                } else {
                    min = Math.min(this.AX.width() / this.GH, this.AX.height() / this.GI);
                }
                this.BT.setScale(min, min);
                this.BT.postTranslate((int) (((this.AX.width() - (this.GH * min)) * 0.5f) + 0.5f), (int) (((this.AX.height() - (this.GI * min)) * 0.5f) + 0.5f));
                this.AY.set(this.GE);
                this.BT.mapRect(this.AY);
                this.GD.set(this.AY.left + this.GL, this.AY.top + this.GL, this.AY.right - this.GL, this.AY.bottom - this.GL);
                this.BT.setRectToRect(this.GE, this.GD, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.AY.set(this.GE);
                this.BT.setRectToRect(this.GE, this.AX, Matrix.ScaleToFit.CENTER);
                this.BT.mapRect(this.AY);
                this.GD.set(this.AY.left + this.GL, this.AY.top + this.GL, this.AY.right - this.GL, this.AY.bottom - this.GL);
                this.BT.setRectToRect(this.GE, this.GD, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.AY.set(this.GE);
                this.BT.setRectToRect(this.GE, this.AX, Matrix.ScaleToFit.END);
                this.BT.mapRect(this.AY);
                this.GD.set(this.AY.left + this.GL, this.AY.top + this.GL, this.AY.right - this.GL, this.AY.bottom - this.GL);
                this.BT.setRectToRect(this.GE, this.GD, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.AY.set(this.GE);
                this.BT.setRectToRect(this.GE, this.AX, Matrix.ScaleToFit.START);
                this.BT.mapRect(this.AY);
                this.GD.set(this.AY.left + this.GL, this.AY.top + this.GL, this.AY.right - this.GL, this.AY.bottom - this.GL);
                this.BT.setRectToRect(this.GE, this.GD, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.AY.set(this.AX);
                this.GD.set(this.GL + 0.0f, 0.0f + this.GL, this.AY.width() - this.GL, this.AY.height() - this.GL);
                this.BT.set(null);
                this.BT.setRectToRect(this.GE, this.GD, Matrix.ScaleToFit.FILL);
                break;
        }
        this.AY.inset(this.GL / 2.0f, this.GL / 2.0f);
        this.GF.setLocalMatrix(this.BT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.adp.widget.ImageView.b$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] GO = new int[ImageView.ScaleType.values().length];

        static {
            try {
                GO[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                GO[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                GO[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                GO[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                GO[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                GO[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                GO[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.AX.set(rect);
        kV();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.GK) {
            if (this.GL > 0.0f) {
                canvas.drawOval(this.AY, this.AU);
                canvas.drawOval(this.GD, this.GG);
                return;
            }
            canvas.drawOval(this.GD, this.GG);
        } else if (this.GL > 0.0f) {
            canvas.drawRoundRect(this.AY, this.GJ, this.GJ, this.AU);
            canvas.drawRoundRect(this.GD, Math.max(this.GJ - this.GL, 0.0f), Math.max(this.GJ - this.GL, 0.0f), this.GG);
        } else {
            canvas.drawRoundRect(this.GD, this.GJ, this.GJ, this.GG);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.GG.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.GG.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.GH;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.GI;
    }

    public b u(float f) {
        this.GJ = f;
        return this;
    }

    public b aK(int i) {
        this.GL = i;
        this.AU.setStrokeWidth(this.GL);
        return this;
    }

    public b a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.GM = colorStateList;
        this.AU.setColor(this.GM.getColorForState(getState(), 0));
        return this;
    }

    public b T(boolean z) {
        this.GK = z;
        return this;
    }

    public b b(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_XY;
        }
        if (this.GN != scaleType) {
            this.GN = scaleType;
            kV();
        }
        return this;
    }
}
