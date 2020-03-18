package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
/* loaded from: classes6.dex */
public class h extends a {
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> fZ;
    private final LongSparseArray<LinearGradient> gb;
    private final LongSparseArray<RadialGradient> gc;
    private final RectF ge;
    private final GradientType gf;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> gg;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> gh;
    private final int gi;
    private final String name;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.cF().toPaintCap(), eVar.cG().toPaintJoin(), eVar.cJ(), eVar.ct(), eVar.cE(), eVar.cH(), eVar.cI());
        this.gb = new LongSparseArray<>();
        this.gc = new LongSparseArray<>();
        this.ge = new RectF();
        this.name = eVar.getName();
        this.gf = eVar.cz();
        this.gi = (int) (gVar.getComposition().bg() / 32.0f);
        this.fZ = eVar.cB().cn();
        this.fZ.b(this);
        aVar.a(this.fZ);
        this.gg = eVar.cC().cn();
        this.gg.b(this);
        aVar.a(this.gg);
        this.gh = eVar.cD().cn();
        this.gh.b(this);
        aVar.a(this.gh);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.ge, matrix);
        if (this.gf == GradientType.Linear) {
            this.paint.setShader(bH());
        } else {
            this.paint.setShader(bI());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bH() {
        int bJ = bJ();
        LinearGradient linearGradient = this.gb.get(bJ);
        if (linearGradient == null) {
            PointF value = this.gg.getValue();
            PointF value2 = this.gh.getValue();
            com.airbnb.lottie.model.content.c value3 = this.fZ.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.ge.left + (this.ge.width() / 2.0f) + value.x), (int) (value.y + this.ge.top + (this.ge.height() / 2.0f)), (int) (this.ge.left + (this.ge.width() / 2.0f) + value2.x), (int) (this.ge.top + (this.ge.height() / 2.0f) + value2.y), value3.getColors(), value3.cy(), Shader.TileMode.CLAMP);
            this.gb.put(bJ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bI() {
        int bJ = bJ();
        RadialGradient radialGradient = this.gc.get(bJ);
        if (radialGradient == null) {
            PointF value = this.gg.getValue();
            PointF value2 = this.gh.getValue();
            com.airbnb.lottie.model.content.c value3 = this.fZ.getValue();
            int[] colors = value3.getColors();
            float[] cy = value3.cy();
            int width = (int) (this.ge.left + (this.ge.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.ge.top + (this.ge.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.ge.left + (this.ge.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.ge.top + (this.ge.height() / 2.0f)))) - height), colors, cy, Shader.TileMode.CLAMP);
            this.gc.put(bJ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bJ() {
        int round = Math.round(this.gg.getProgress() * this.gi);
        int round2 = Math.round(this.gh.getProgress() * this.gi);
        int round3 = Math.round(this.fZ.getProgress() * this.gi);
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
