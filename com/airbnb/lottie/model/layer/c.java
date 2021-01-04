package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.j;
/* loaded from: classes3.dex */
public class c extends a {
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> DC;
    private final Rect dst;
    private final Paint paint;
    private final Rect src;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.paint = new Paint(3);
        this.src = new Rect();
        this.dst = new Rect();
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void d(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmap = getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            float kA = com.airbnb.lottie.d.f.kA();
            this.paint.setAlpha(i);
            if (this.DC != null) {
                this.paint.setColorFilter(this.DC.getValue());
            }
            canvas.save();
            canvas.concat(matrix);
            this.src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.dst.set(0, 0, (int) (bitmap.getWidth() * kA), (int) (kA * bitmap.getHeight()));
            canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, bitmap.getWidth()), Math.min(rectF.bottom, bitmap.getHeight()));
            this.Gz.mapRect(rectF);
        }
    }

    @Nullable
    private Bitmap getBitmap() {
        return this.BJ.bf(this.GA.getRefId());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((c) t, (com.airbnb.lottie.e.c<c>) cVar);
        if (t == j.Dd) {
            if (cVar == null) {
                this.DC = null;
            } else {
                this.DC = new p(cVar);
            }
        }
    }
}
