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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> gb;
    private final LongSparseArray<LinearGradient> gc;
    private final LongSparseArray<RadialGradient> gd;
    private final RectF gf;
    private final GradientType gg;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> gh;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> gi;
    private final int gj;
    private final String name;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.cF().toPaintCap(), eVar.cG().toPaintJoin(), eVar.cJ(), eVar.ct(), eVar.cE(), eVar.cH(), eVar.cI());
        this.gc = new LongSparseArray<>();
        this.gd = new LongSparseArray<>();
        this.gf = new RectF();
        this.name = eVar.getName();
        this.gg = eVar.cz();
        this.gj = (int) (gVar.getComposition().bg() / 32.0f);
        this.gb = eVar.cB().cn();
        this.gb.b(this);
        aVar.a(this.gb);
        this.gh = eVar.cC().cn();
        this.gh.b(this);
        aVar.a(this.gh);
        this.gi = eVar.cD().cn();
        this.gi.b(this);
        aVar.a(this.gi);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.gf, matrix);
        if (this.gg == GradientType.Linear) {
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
        LinearGradient linearGradient = this.gc.get(bJ);
        if (linearGradient == null) {
            PointF value = this.gh.getValue();
            PointF value2 = this.gi.getValue();
            com.airbnb.lottie.model.content.c value3 = this.gb.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.gf.left + (this.gf.width() / 2.0f) + value.x), (int) (value.y + this.gf.top + (this.gf.height() / 2.0f)), (int) (this.gf.left + (this.gf.width() / 2.0f) + value2.x), (int) (this.gf.top + (this.gf.height() / 2.0f) + value2.y), value3.getColors(), value3.cy(), Shader.TileMode.CLAMP);
            this.gc.put(bJ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bI() {
        int bJ = bJ();
        RadialGradient radialGradient = this.gd.get(bJ);
        if (radialGradient == null) {
            PointF value = this.gh.getValue();
            PointF value2 = this.gi.getValue();
            com.airbnb.lottie.model.content.c value3 = this.gb.getValue();
            int[] colors = value3.getColors();
            float[] cy = value3.cy();
            int width = (int) (this.gf.left + (this.gf.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.gf.top + (this.gf.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.gf.left + (this.gf.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.gf.top + (this.gf.height() / 2.0f)))) - height), colors, cy, Shader.TileMode.CLAMP);
            this.gd.put(bJ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bJ() {
        int round = Math.round(this.gh.getProgress() * this.gj);
        int round2 = Math.round(this.gi.getProgress() * this.gj);
        int round3 = Math.round(this.gb.getProgress() * this.gj);
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
