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
    private final com.airbnb.lottie.f mp;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> nO;
    private final String name;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> oa;
    private final GradientType of;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> og;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> oh;
    private final int oi;
    private final LongSparseArray<LinearGradient> ob = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> oc = new LongSparseArray<>();
    private final Matrix od = new Matrix();
    private final Path nJ = new Path();
    private final Paint paint = new Paint(1);
    private final RectF oe = new RectF();
    private final List<k> nR = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.mp = fVar;
        this.of = dVar.dN();
        this.nJ.setFillType(dVar.getFillType());
        this.oi = (int) (fVar.cC().getDuration() / 32);
        this.oa = dVar.dO().dp();
        this.oa.b(this);
        aVar.a(this.oa);
        this.nO = dVar.dE().dp();
        this.nO.b(this);
        aVar.a(this.nO);
        this.og = dVar.dP().dp();
        this.og.b(this);
        aVar.a(this.og);
        this.oh = dVar.dQ().dp();
        this.oh.b(this);
        aVar.a(this.oh);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void cM() {
        this.mp.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.nR.add((k) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader cQ;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.nJ.reset();
        for (int i2 = 0; i2 < this.nR.size(); i2++) {
            this.nJ.addPath(this.nR.get(i2).getPath(), matrix);
        }
        this.nJ.computeBounds(this.oe, false);
        if (this.of == GradientType.Linear) {
            cQ = cP();
        } else {
            cQ = cQ();
        }
        this.od.set(matrix);
        cQ.setLocalMatrix(this.od);
        this.paint.setShader(cQ);
        this.paint.setAlpha((int) (((this.nO.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.nJ, this.paint);
        com.airbnb.lottie.d.U("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.nJ.reset();
        for (int i = 0; i < this.nR.size(); i++) {
            this.nJ.addPath(this.nR.get(i).getPath(), matrix);
        }
        this.nJ.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient cP() {
        int cR = cR();
        LinearGradient linearGradient = this.ob.get(cR);
        if (linearGradient == null) {
            PointF value = this.og.getValue();
            PointF value2 = this.oh.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oa.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.dM(), Shader.TileMode.CLAMP);
            this.ob.put(cR, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient cQ() {
        int cR = cR();
        RadialGradient radialGradient = this.oc.get(cR);
        if (radialGradient == null) {
            PointF value = this.og.getValue();
            PointF value2 = this.oh.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oa.getValue();
            int[] colors = value3.getColors();
            float[] dM = value3.dM();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, dM, Shader.TileMode.CLAMP);
            this.oc.put(cR, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int cR() {
        int round = Math.round(this.og.getProgress() * this.oi);
        int round2 = Math.round(this.oh.getProgress() * this.oi);
        int round3 = Math.round(this.oa.getProgress() * this.oi);
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
