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
    private final com.airbnb.lottie.f dh;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> eJ;
    private final GradientType eO;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> eP;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> eQ;
    private final int eR;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> ex;
    private final String name;
    private final LongSparseArray<LinearGradient> eK = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> eL = new LongSparseArray<>();
    private final Matrix eM = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF eN = new RectF();
    private final List<k> eA = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.dh = fVar;
        this.eO = dVar.cw();
        this.path.setFillType(dVar.cx());
        this.eR = (int) (fVar.bj().getDuration() / 32);
        this.eJ = dVar.cy().bY();
        this.eJ.b(this);
        aVar.a(this.eJ);
        this.ex = dVar.cn().bY();
        this.ex.b(this);
        aVar.a(this.ex);
        this.eP = dVar.cz().bY();
        this.eP.b(this);
        aVar.a(this.eP);
        this.eQ = dVar.cA().bY();
        this.eQ.b(this);
        aVar.a(this.eQ);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bt() {
        this.dh.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.eA.add((k) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader by;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.eA.size(); i2++) {
            this.path.addPath(this.eA.get(i2).bw(), matrix);
        }
        this.path.computeBounds(this.eN, false);
        if (this.eO == GradientType.Linear) {
            by = bx();
        } else {
            by = by();
        }
        this.eM.set(matrix);
        by.setLocalMatrix(this.eM);
        this.paint.setShader(by);
        this.paint.setAlpha((int) (((this.ex.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.d.D("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.eA.size(); i++) {
            this.path.addPath(this.eA.get(i).bw(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bx() {
        int bz = bz();
        LinearGradient linearGradient = this.eK.get(bz);
        if (linearGradient == null) {
            PointF value = this.eP.getValue();
            PointF value2 = this.eQ.getValue();
            com.airbnb.lottie.model.content.c value3 = this.eJ.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cv(), Shader.TileMode.CLAMP);
            this.eK.put(bz, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient by() {
        int bz = bz();
        RadialGradient radialGradient = this.eL.get(bz);
        if (radialGradient == null) {
            PointF value = this.eP.getValue();
            PointF value2 = this.eQ.getValue();
            com.airbnb.lottie.model.content.c value3 = this.eJ.getValue();
            int[] colors = value3.getColors();
            float[] cv = value3.cv();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cv, Shader.TileMode.CLAMP);
            this.eL.put(bz, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bz() {
        int round = Math.round(this.eP.getProgress() * this.eR);
        int round2 = Math.round(this.eQ.getProgress() * this.eR);
        int round3 = Math.round(this.eJ.getProgress() * this.eR);
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
