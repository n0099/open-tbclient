package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class c extends a {
    private final float density;
    private final Paint paint;
    private final Rect se;
    private final Rect sf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.airbnb.lottie.f fVar, Layer layer, float f) {
        super(fVar, layer);
        this.paint = new Paint(3);
        this.se = new Rect();
        this.sf = new Rect();
        this.density = f;
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            this.paint.setAlpha(i);
            canvas.save();
            canvas.concat(matrix);
            this.se.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.sf.set(0, 0, (int) (bitmap.getWidth() * this.density), (int) (bitmap.getHeight() * this.density));
            canvas.drawBitmap(bitmap, this.se, this.sf, this.paint);
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, bitmap.getWidth()), Math.min(rectF.bottom, bitmap.getHeight()));
            this.rO.mapRect(rectF);
        }
    }

    @Nullable
    private Bitmap getBitmap() {
        return this.nc.Y(this.rP.getRefId());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
