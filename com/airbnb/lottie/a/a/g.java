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
    private final com.airbnb.lottie.f jY;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> lK;
    private final GradientType lP;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lQ;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lR;
    private final int lS;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lx;
    private final String name;
    private final LongSparseArray<LinearGradient> lL = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> lM = new LongSparseArray<>();
    private final Matrix lN = new Matrix();
    private final Path lp = new Path();
    private final Paint paint = new Paint(1);
    private final RectF lO = new RectF();
    private final List<k> lB = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.jY = fVar;
        this.lP = dVar.cI();
        this.lp.setFillType(dVar.getFillType());
        this.lS = (int) (fVar.bx().getDuration() / 32);
        this.lK = dVar.cJ().ck();
        this.lK.b(this);
        aVar.a(this.lK);
        this.lx = dVar.cz().ck();
        this.lx.b(this);
        aVar.a(this.lx);
        this.lQ = dVar.cK().ck();
        this.lQ.b(this);
        aVar.a(this.lQ);
        this.lR = dVar.cL().ck();
        this.lR.b(this);
        aVar.a(this.lR);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        this.jY.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.lB.add((k) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader bL;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.lp.reset();
        for (int i2 = 0; i2 < this.lB.size(); i2++) {
            this.lp.addPath(this.lB.get(i2).getPath(), matrix);
        }
        this.lp.computeBounds(this.lO, false);
        if (this.lP == GradientType.Linear) {
            bL = bK();
        } else {
            bL = bL();
        }
        this.lN.set(matrix);
        bL.setLocalMatrix(this.lN);
        this.paint.setShader(bL);
        this.paint.setAlpha((int) (((this.lx.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.lp, this.paint);
        com.airbnb.lottie.d.D("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lp.reset();
        for (int i = 0; i < this.lB.size(); i++) {
            this.lp.addPath(this.lB.get(i).getPath(), matrix);
        }
        this.lp.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bK() {
        int bM = bM();
        LinearGradient linearGradient = this.lL.get(bM);
        if (linearGradient == null) {
            PointF value = this.lQ.getValue();
            PointF value2 = this.lR.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lK.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cH(), Shader.TileMode.CLAMP);
            this.lL.put(bM, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bL() {
        int bM = bM();
        RadialGradient radialGradient = this.lM.get(bM);
        if (radialGradient == null) {
            PointF value = this.lQ.getValue();
            PointF value2 = this.lR.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lK.getValue();
            int[] colors = value3.getColors();
            float[] cH = value3.cH();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cH, Shader.TileMode.CLAMP);
            this.lM.put(bM, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bM() {
        int round = Math.round(this.lQ.getProgress() * this.lS);
        int round2 = Math.round(this.lR.getProgress() * this.lS);
        int round3 = Math.round(this.lK.getProgress() * this.lS);
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
