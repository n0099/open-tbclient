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
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.k;
/* loaded from: classes20.dex */
public class c extends a {
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> BV;
    private final Rect dst;
    private final Paint paint;
    private final Rect src;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.paint = new Paint(3);
        this.src = new Rect();
        this.dst = new Rect();
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmap = getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            float jA = com.airbnb.lottie.d.f.jA();
            this.paint.setAlpha(i);
            if (this.BV != null) {
                this.paint.setColorFilter(this.BV.getValue());
            }
            canvas.save();
            canvas.concat(matrix);
            this.src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.dst.set(0, 0, (int) (bitmap.getWidth() * jA), (int) (jA * bitmap.getHeight()));
            canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, bitmap.getWidth()), Math.min(rectF.bottom, bitmap.getHeight()));
            this.EZ.mapRect(rectF);
        }
    }

    @Nullable
    private Bitmap getBitmap() {
        return this.lottieDrawable.ba(this.Fa.getRefId());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((c) t, (com.airbnb.lottie.e.c<c>) cVar);
        if (t == k.Bx) {
            if (cVar == null) {
                this.BV = null;
            } else {
                this.BV = new p(cVar);
            }
        }
    }
}
