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
    private final String name;
    private final com.airbnb.lottie.f nc;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> oK;
    private final GradientType oP;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> oQ;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> oR;
    private final int oS;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> oy;
    private final LongSparseArray<LinearGradient> oL = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> oM = new LongSparseArray<>();
    private final Matrix oN = new Matrix();
    private final Path ot = new Path();
    private final Paint paint = new Paint(1);
    private final RectF oO = new RectF();
    private final List<k> oB = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.nc = fVar;
        this.oP = dVar.ed();
        this.ot.setFillType(dVar.getFillType());
        this.oS = (int) (fVar.cS().getDuration() / 32);
        this.oK = dVar.ee().dF();
        this.oK.b(this);
        aVar.a(this.oK);
        this.oy = dVar.dU().dF();
        this.oy.b(this);
        aVar.a(this.oy);
        this.oQ = dVar.ef().dF();
        this.oQ.b(this);
        aVar.a(this.oQ);
        this.oR = dVar.eg().dF();
        this.oR.b(this);
        aVar.a(this.oR);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void dc() {
        this.nc.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.oB.add((k) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader dg;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.ot.reset();
        for (int i2 = 0; i2 < this.oB.size(); i2++) {
            this.ot.addPath(this.oB.get(i2).getPath(), matrix);
        }
        this.ot.computeBounds(this.oO, false);
        if (this.oP == GradientType.Linear) {
            dg = df();
        } else {
            dg = dg();
        }
        this.oN.set(matrix);
        dg.setLocalMatrix(this.oN);
        this.paint.setShader(dg);
        this.paint.setAlpha((int) (((this.oy.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.ot, this.paint);
        com.airbnb.lottie.d.U("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.ot.reset();
        for (int i = 0; i < this.oB.size(); i++) {
            this.ot.addPath(this.oB.get(i).getPath(), matrix);
        }
        this.ot.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient df() {
        int dh = dh();
        LinearGradient linearGradient = this.oL.get(dh);
        if (linearGradient == null) {
            PointF value = this.oQ.getValue();
            PointF value2 = this.oR.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oK.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.ec(), Shader.TileMode.CLAMP);
            this.oL.put(dh, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient dg() {
        int dh = dh();
        RadialGradient radialGradient = this.oM.get(dh);
        if (radialGradient == null) {
            PointF value = this.oQ.getValue();
            PointF value2 = this.oR.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oK.getValue();
            int[] colors = value3.getColors();
            float[] ec = value3.ec();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, ec, Shader.TileMode.CLAMP);
            this.oM.put(dh, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int dh() {
        int round = Math.round(this.oQ.getProgress() * this.oS);
        int round2 = Math.round(this.oR.getProgress() * this.oS);
        int round3 = Math.round(this.oK.getProgress() * this.oS);
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
