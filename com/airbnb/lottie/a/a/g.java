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
public class g implements d, a.InterfaceC0009a {
    private final String name;
    private final com.airbnb.lottie.f nh;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> oD;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> oP;
    private final GradientType oU;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> oV;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> oW;
    private final int oX;
    private final LongSparseArray<LinearGradient> oQ = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> oR = new LongSparseArray<>();
    private final Matrix oS = new Matrix();
    private final Path oy = new Path();
    private final Paint paint = new Paint(1);
    private final RectF oT = new RectF();
    private final List<k> oG = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.nh = fVar;
        this.oU = dVar.ee();
        this.oy.setFillType(dVar.getFillType());
        this.oX = (int) (fVar.cT().getDuration() / 32);
        this.oP = dVar.ef().dG();
        this.oP.b(this);
        aVar.a(this.oP);
        this.oD = dVar.dV().dG();
        this.oD.b(this);
        aVar.a(this.oD);
        this.oV = dVar.eg().dG();
        this.oV.b(this);
        aVar.a(this.oV);
        this.oW = dVar.eh().dG();
        this.oW.b(this);
        aVar.a(this.oW);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void dd() {
        this.nh.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.oG.add((k) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader dh;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.oy.reset();
        for (int i2 = 0; i2 < this.oG.size(); i2++) {
            this.oy.addPath(this.oG.get(i2).getPath(), matrix);
        }
        this.oy.computeBounds(this.oT, false);
        if (this.oU == GradientType.Linear) {
            dh = dg();
        } else {
            dh = dh();
        }
        this.oS.set(matrix);
        dh.setLocalMatrix(this.oS);
        this.paint.setShader(dh);
        this.paint.setAlpha((int) (((this.oD.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.oy, this.paint);
        com.airbnb.lottie.d.U("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.oy.reset();
        for (int i = 0; i < this.oG.size(); i++) {
            this.oy.addPath(this.oG.get(i).getPath(), matrix);
        }
        this.oy.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient dg() {
        int di = di();
        LinearGradient linearGradient = this.oQ.get(di);
        if (linearGradient == null) {
            PointF value = this.oV.getValue();
            PointF value2 = this.oW.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oP.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.ed(), Shader.TileMode.CLAMP);
            this.oQ.put(di, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient dh() {
        int di = di();
        RadialGradient radialGradient = this.oR.get(di);
        if (radialGradient == null) {
            PointF value = this.oV.getValue();
            PointF value2 = this.oW.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oP.getValue();
            int[] colors = value3.getColors();
            float[] ed = value3.ed();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, ed, Shader.TileMode.CLAMP);
            this.oR.put(di, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int di() {
        int round = Math.round(this.oV.getProgress() * this.oX);
        int round2 = Math.round(this.oW.getProgress() * this.oX);
        int round3 = Math.round(this.oP.getProgress() * this.oX);
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
