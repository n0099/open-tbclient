package com.baidu.prologue.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class a extends BitmapTransformation {
    private BitmapPool cuU;
    private int cuV;
    private int cuW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull Context context) {
        this(Glide.get(context).getBitmapPool());
    }

    a(@NonNull BitmapPool bitmapPool) {
        this.cuV = 0;
        this.cuW = 0;
        this.cuU = bitmapPool;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return a(bitmapPool, bitmap);
    }

    private Bitmap a(BitmapPool bitmapPool, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (bitmap.getWidth() - min) / 2;
        int height = (bitmap.getHeight() - min) / 2;
        Bitmap bitmap2 = this.cuU.get(min, min, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        if (width != 0 || height != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(-width, -height);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        if (this.cuV == 0) {
            float f = min / 2.0f;
            canvas.drawCircle(f, f, f, paint);
            return bitmap2;
        }
        float f2 = min / 2.0f;
        if (this.cuW != 0) {
            Paint paint2 = new Paint(1);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            paint2.setColor(this.cuW);
            canvas.drawCircle(f2, f2, f2, paint2);
        }
        canvas.drawCircle(f2, f2, f2 - this.cuV, paint);
        return bitmap2;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
