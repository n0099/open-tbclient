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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> lI;
    private final GradientType lN;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lO;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lP;
    private final int lQ;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> lu;
    private final String name;
    private final LongSparseArray<LinearGradient> lJ = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> lK = new LongSparseArray<>();
    private final Matrix lL = new Matrix();
    private final Path lo = new Path();
    private final Paint paint = new Paint(1);
    private final RectF lM = new RectF();
    private final List<k> ly = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.name = dVar.getName();
        this.jY = fVar;
        this.lN = dVar.cI();
        this.lo.setFillType(dVar.getFillType());
        this.lQ = (int) (fVar.bx().getDuration() / 32);
        this.lI = dVar.cJ().ck();
        this.lI.b(this);
        aVar.a(this.lI);
        this.lu = dVar.cz().ck();
        this.lu.b(this);
        aVar.a(this.lu);
        this.lO = dVar.cK().ck();
        this.lO.b(this);
        aVar.a(this.lO);
        this.lP = dVar.cL().ck();
        this.lP.b(this);
        aVar.a(this.lP);
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
                    this.ly.add((k) bVar);
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
        this.lo.reset();
        for (int i2 = 0; i2 < this.ly.size(); i2++) {
            this.lo.addPath(this.ly.get(i2).getPath(), matrix);
        }
        this.lo.computeBounds(this.lM, false);
        if (this.lN == GradientType.Linear) {
            bL = bK();
        } else {
            bL = bL();
        }
        this.lL.set(matrix);
        bL.setLocalMatrix(this.lL);
        this.paint.setShader(bL);
        this.paint.setAlpha((int) (((this.lu.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.lo, this.paint);
        com.airbnb.lottie.d.D("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lo.reset();
        for (int i = 0; i < this.ly.size(); i++) {
            this.lo.addPath(this.ly.get(i).getPath(), matrix);
        }
        this.lo.computeBounds(rectF, false);
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
        LinearGradient linearGradient = this.lJ.get(bM);
        if (linearGradient == null) {
            PointF value = this.lO.getValue();
            PointF value2 = this.lP.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lI.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cH(), Shader.TileMode.CLAMP);
            this.lJ.put(bM, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bL() {
        int bM = bM();
        RadialGradient radialGradient = this.lK.get(bM);
        if (radialGradient == null) {
            PointF value = this.lO.getValue();
            PointF value2 = this.lP.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lI.getValue();
            int[] colors = value3.getColors();
            float[] cH = value3.cH();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cH, Shader.TileMode.CLAMP);
            this.lK.put(bM, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bM() {
        int round = Math.round(this.lO.getProgress() * this.lQ);
        int round2 = Math.round(this.lP.getProgress() * this.lQ);
        int round3 = Math.round(this.lI.getProgress() * this.lQ);
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
