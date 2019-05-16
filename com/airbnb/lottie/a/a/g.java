package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g implements d, a.InterfaceC0007a {
    private final com.airbnb.lottie.f kC;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lX;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> mk;
    private final GradientType mp;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> mq;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> mr;
    private final int mt;
    private final String name;
    private final LongSparseArray<LinearGradient> ml = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> mm = new LongSparseArray<>();
    private final Matrix mn = new Matrix();
    private final Path lS = new Path();
    private final Paint paint = new Paint(1);
    private final RectF mo = new RectF();
    private final List<k> ma = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.kC = fVar;
        this.mp = dVar.cX();
        this.lS.setFillType(dVar.getFillType());
        this.mt = (int) (fVar.bM().getDuration() / 32);
        this.mk = dVar.cY().cz();
        this.mk.b(this);
        aVar.a(this.mk);
        this.lX = dVar.cO().cz();
        this.lX.b(this);
        aVar.a(this.lX);
        this.mq = dVar.cZ().cz();
        this.mq.b(this);
        aVar.a(this.mq);
        this.mr = dVar.da().cz();
        this.mr.b(this);
        aVar.a(this.mr);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bW() {
        this.kC.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.ma.add((k) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader ca;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.lS.reset();
        for (int i2 = 0; i2 < this.ma.size(); i2++) {
            this.lS.addPath(this.ma.get(i2).getPath(), matrix);
        }
        this.lS.computeBounds(this.mo, false);
        if (this.mp == GradientType.Linear) {
            ca = bZ();
        } else {
            ca = ca();
        }
        this.mn.set(matrix);
        ca.setLocalMatrix(this.mn);
        this.paint.setShader(ca);
        this.paint.setAlpha((int) (((this.lX.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.lS, this.paint);
        com.airbnb.lottie.d.D("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lS.reset();
        for (int i = 0; i < this.ma.size(); i++) {
            this.lS.addPath(this.ma.get(i).getPath(), matrix);
        }
        this.lS.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bZ() {
        int cb = cb();
        LinearGradient linearGradient = this.ml.get(cb);
        if (linearGradient == null) {
            PointF value = this.mq.getValue();
            PointF value2 = this.mr.getValue();
            com.airbnb.lottie.model.content.c value3 = this.mk.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cW(), Shader.TileMode.CLAMP);
            this.ml.put(cb, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient ca() {
        int cb = cb();
        RadialGradient radialGradient = this.mm.get(cb);
        if (radialGradient == null) {
            PointF value = this.mq.getValue();
            PointF value2 = this.mr.getValue();
            com.airbnb.lottie.model.content.c value3 = this.mk.getValue();
            int[] colors = value3.getColors();
            float[] cW = value3.cW();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cW, Shader.TileMode.CLAMP);
            this.mm.put(cb, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int cb() {
        int round = Math.round(this.mq.getProgress() * this.mt);
        int round2 = Math.round(this.mr.getProgress() * this.mt);
        int round3 = Math.round(this.mk.getProgress() * this.mt);
        int i = 17;
        if (round != 0) {
            i = round * 527;
        }
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        if (round3 != 0) {
            return i * 31 * round3;
        }
        return i;
    }
}
