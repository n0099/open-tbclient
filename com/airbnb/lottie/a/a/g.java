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
    private final com.airbnb.lottie.f kB;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lW;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> mj;
    private final GradientType mo;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> mp;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> mq;
    private final int mr;
    private final String name;
    private final LongSparseArray<LinearGradient> mk = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> ml = new LongSparseArray<>();
    private final Matrix mm = new Matrix();
    private final Path lR = new Path();
    private final Paint paint = new Paint(1);
    private final RectF mn = new RectF();
    private final List<k> lZ = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.kB = fVar;
        this.mo = dVar.dd();
        this.lR.setFillType(dVar.de());
        this.mr = (int) (fVar.bQ().getDuration() / 32);
        this.mj = dVar.df().cF();
        this.mj.b(this);
        aVar.a(this.mj);
        this.lW = dVar.cU().cF();
        this.lW.b(this);
        aVar.a(this.lW);
        this.mp = dVar.dg().cF();
        this.mp.b(this);
        aVar.a(this.mp);
        this.mq = dVar.dh().cF();
        this.mq.b(this);
        aVar.a(this.mq);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ca() {
        this.kB.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.lZ.add((k) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader cf;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.lR.reset();
        for (int i2 = 0; i2 < this.lZ.size(); i2++) {
            this.lR.addPath(this.lZ.get(i2).cd(), matrix);
        }
        this.lR.computeBounds(this.mn, false);
        if (this.mo == GradientType.Linear) {
            cf = ce();
        } else {
            cf = cf();
        }
        this.mm.set(matrix);
        cf.setLocalMatrix(this.mm);
        this.paint.setShader(cf);
        this.paint.setAlpha((int) (((this.lW.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.lR, this.paint);
        com.airbnb.lottie.d.D("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lR.reset();
        for (int i = 0; i < this.lZ.size(); i++) {
            this.lR.addPath(this.lZ.get(i).cd(), matrix);
        }
        this.lR.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient ce() {
        int cg = cg();
        LinearGradient linearGradient = this.mk.get(cg);
        if (linearGradient == null) {
            PointF value = this.mp.getValue();
            PointF value2 = this.mq.getValue();
            com.airbnb.lottie.model.content.c value3 = this.mj.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.dc(), Shader.TileMode.CLAMP);
            this.mk.put(cg, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient cf() {
        int cg = cg();
        RadialGradient radialGradient = this.ml.get(cg);
        if (radialGradient == null) {
            PointF value = this.mp.getValue();
            PointF value2 = this.mq.getValue();
            com.airbnb.lottie.model.content.c value3 = this.mj.getValue();
            int[] colors = value3.getColors();
            float[] dc = value3.dc();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, dc, Shader.TileMode.CLAMP);
            this.ml.put(cg, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int cg() {
        int round = Math.round(this.mp.getProgress() * this.mr);
        int round2 = Math.round(this.mq.getProgress() * this.mr);
        int round3 = Math.round(this.mj.getProgress() * this.mr);
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
