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
    private final Rect pe;
    private final Rect pf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.airbnb.lottie.f fVar, Layer layer, float f) {
        super(fVar, layer);
        this.paint = new Paint(3);
        this.pe = new Rect();
        this.pf = new Rect();
        this.density = f;
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            this.paint.setAlpha(i);
            canvas.save();
            canvas.concat(matrix);
            this.pe.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.pf.set(0, 0, (int) (bitmap.getWidth() * this.density), (int) (bitmap.getHeight() * this.density));
            canvas.drawBitmap(bitmap, this.pe, this.pf, this.paint);
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, bitmap.getWidth()), Math.min(rectF.bottom, bitmap.getHeight()));
            this.oO.mapRect(rectF);
        }
    }

    @Nullable
    private Bitmap getBitmap() {
        return this.jY.H(this.oP.getRefId());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
