package com.baidu.ar.recommend;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class c extends Drawable {
    protected float a;
    protected final RectF c;
    protected final BitmapShader d;
    protected final Paint f;
    protected final float g;
    protected float h;
    protected final RectF b = new RectF();
    protected final Paint e = new Paint();

    public c(Bitmap bitmap, Integer num, float f) {
        this.a = Math.min(bitmap.getWidth(), bitmap.getHeight()) / 2;
        this.d = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.c = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        this.e.setAntiAlias(true);
        this.e.setShader(this.d);
        this.e.setFilterBitmap(true);
        this.e.setDither(true);
        if (num == null) {
            this.f = null;
        } else {
            this.f = new Paint();
            this.f.setStyle(Paint.Style.STROKE);
            this.f.setColor(num.intValue());
            this.f.setStrokeWidth(f);
            this.f.setAntiAlias(true);
        }
        this.g = f;
        this.h = this.a - (f / 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(this.a, this.a, this.a, this.e);
        if (this.f != null) {
            canvas.drawCircle(this.a, this.a, this.h, this.f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.b.set(0.0f, 0.0f, rect.width(), rect.height());
        this.a = Math.min(rect.width(), rect.height()) / 2;
        this.h = this.a - (this.g / 2.0f);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
        this.d.setLocalMatrix(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
    }
}
