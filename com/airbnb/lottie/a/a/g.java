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
    private final com.airbnb.lottie.f jR;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> lA;
    private final GradientType lF;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lG;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lH;
    private final int lI;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lm;
    private final String name;
    private final LongSparseArray<LinearGradient> lB = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> lC = new LongSparseArray<>();
    private final Matrix lD = new Matrix();
    private final Path lh = new Path();
    private final Paint paint = new Paint(1);
    private final RectF lE = new RectF();
    private final List<k> lp = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.jR = fVar;
        this.lF = dVar.cG();
        this.lh.setFillType(dVar.getFillType());
        this.lI = (int) (fVar.bv().getDuration() / 32);
        this.lA = dVar.cH().ci();
        this.lA.b(this);
        aVar.a(this.lA);
        this.lm = dVar.cx().ci();
        this.lm.b(this);
        aVar.a(this.lm);
        this.lG = dVar.cI().ci();
        this.lG.b(this);
        aVar.a(this.lG);
        this.lH = dVar.cJ().ci();
        this.lH.b(this);
        aVar.a(this.lH);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        this.jR.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.lp.add((k) bVar);
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
        this.lh.reset();
        for (int i2 = 0; i2 < this.lp.size(); i2++) {
            this.lh.addPath(this.lp.get(i2).getPath(), matrix);
        }
        this.lh.computeBounds(this.lE, false);
        if (this.lF == GradientType.Linear) {
            bJ = bI();
        } else {
            bJ = bJ();
        }
        this.lD.set(matrix);
        bJ.setLocalMatrix(this.lD);
        this.paint.setShader(bJ);
        this.paint.setAlpha((int) (((this.lm.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.lh, this.paint);
        com.airbnb.lottie.d.D("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lh.reset();
        for (int i = 0; i < this.lp.size(); i++) {
            this.lh.addPath(this.lp.get(i).getPath(), matrix);
        }
        this.lh.computeBounds(rectF, false);
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
        LinearGradient linearGradient = this.lB.get(bK);
        if (linearGradient == null) {
            PointF value = this.lG.getValue();
            PointF value2 = this.lH.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lA.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cF(), Shader.TileMode.CLAMP);
            this.lB.put(bK, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bJ() {
        int bK = bK();
        RadialGradient radialGradient = this.lC.get(bK);
        if (radialGradient == null) {
            PointF value = this.lG.getValue();
            PointF value2 = this.lH.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lA.getValue();
            int[] colors = value3.getColors();
            float[] cF = value3.cF();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cF, Shader.TileMode.CLAMP);
            this.lC.put(bK, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bK() {
        int round = Math.round(this.lG.getProgress() * this.lI);
        int round2 = Math.round(this.lH.getProgress() * this.lI);
        int round3 = Math.round(this.lA.getProgress() * this.lI);
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
