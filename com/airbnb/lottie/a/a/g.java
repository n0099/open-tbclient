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
public class g implements d, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jQ;
    private final GradientType lE;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lF;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lG;
    private final int lH;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> ll;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> ly;
    private final String name;
    private final LongSparseArray<LinearGradient> lA = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> lB = new LongSparseArray<>();
    private final Matrix lC = new Matrix();
    private final Path lg = new Path();
    private final Paint paint = new Paint(1);
    private final RectF lD = new RectF();
    private final List<k> lo = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.jQ = fVar;
        this.lE = dVar.cG();
        this.lg.setFillType(dVar.getFillType());
        this.lH = (int) (fVar.bv().getDuration() / 32);
        this.ly = dVar.cH().ci();
        this.ly.b(this);
        aVar.a(this.ly);
        this.ll = dVar.cx().ci();
        this.ll.b(this);
        aVar.a(this.ll);
        this.lF = dVar.cI().ci();
        this.lF.b(this);
        aVar.a(this.lF);
        this.lG = dVar.cJ().ci();
        this.lG.b(this);
        aVar.a(this.lG);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        this.jQ.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.lo.add((k) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader bJ;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.lg.reset();
        for (int i2 = 0; i2 < this.lo.size(); i2++) {
            this.lg.addPath(this.lo.get(i2).getPath(), matrix);
        }
        this.lg.computeBounds(this.lD, false);
        if (this.lE == GradientType.Linear) {
            bJ = bI();
        } else {
            bJ = bJ();
        }
        this.lC.set(matrix);
        bJ.setLocalMatrix(this.lC);
        this.paint.setShader(bJ);
        this.paint.setAlpha((int) (((this.ll.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.lg, this.paint);
        com.airbnb.lottie.d.D("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lg.reset();
        for (int i = 0; i < this.lo.size(); i++) {
            this.lg.addPath(this.lo.get(i).getPath(), matrix);
        }
        this.lg.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bI() {
        int bK = bK();
        LinearGradient linearGradient = this.lA.get(bK);
        if (linearGradient == null) {
            PointF value = this.lF.getValue();
            PointF value2 = this.lG.getValue();
            com.airbnb.lottie.model.content.c value3 = this.ly.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cF(), Shader.TileMode.CLAMP);
            this.lA.put(bK, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bJ() {
        int bK = bK();
        RadialGradient radialGradient = this.lB.get(bK);
        if (radialGradient == null) {
            PointF value = this.lF.getValue();
            PointF value2 = this.lG.getValue();
            com.airbnb.lottie.model.content.c value3 = this.ly.getValue();
            int[] colors = value3.getColors();
            float[] cF = value3.cF();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cF, Shader.TileMode.CLAMP);
            this.lB.put(bK, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bK() {
        int round = Math.round(this.lF.getProgress() * this.lH);
        int round2 = Math.round(this.lG.getProgress() * this.lH);
        int round3 = Math.round(this.ly.getProgress() * this.lH);
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
