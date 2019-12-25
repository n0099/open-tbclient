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
/* loaded from: classes4.dex */
public class h extends a {
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> fW;
    private final LongSparseArray<LinearGradient> fX;
    private final LongSparseArray<RadialGradient> fY;
    private final RectF gb;
    private final GradientType gc;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> gd;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> ge;
    private final int gf;
    private final String name;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.cE().toPaintCap(), eVar.cF().toPaintJoin(), eVar.cI(), eVar.cs(), eVar.cD(), eVar.cG(), eVar.cH());
        this.fX = new LongSparseArray<>();
        this.fY = new LongSparseArray<>();
        this.gb = new RectF();
        this.name = eVar.getName();
        this.gc = eVar.cy();
        this.gf = (int) (gVar.getComposition().bf() / 32.0f);
        this.fW = eVar.cA().cm();
        this.fW.b(this);
        aVar.a(this.fW);
        this.gd = eVar.cB().cm();
        this.gd.b(this);
        aVar.a(this.gd);
        this.ge = eVar.cC().cm();
        this.ge.b(this);
        aVar.a(this.ge);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.gb, matrix);
        if (this.gc == GradientType.Linear) {
            this.paint.setShader(bG());
        } else {
            this.paint.setShader(bH());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bG() {
        int bI = bI();
        LinearGradient linearGradient = this.fX.get(bI);
        if (linearGradient == null) {
            PointF value = this.gd.getValue();
            PointF value2 = this.ge.getValue();
            com.airbnb.lottie.model.content.c value3 = this.fW.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.gb.left + (this.gb.width() / 2.0f) + value.x), (int) (value.y + this.gb.top + (this.gb.height() / 2.0f)), (int) (this.gb.left + (this.gb.width() / 2.0f) + value2.x), (int) (this.gb.top + (this.gb.height() / 2.0f) + value2.y), value3.getColors(), value3.cx(), Shader.TileMode.CLAMP);
            this.fX.put(bI, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bH() {
        int bI = bI();
        RadialGradient radialGradient = this.fY.get(bI);
        if (radialGradient == null) {
            PointF value = this.gd.getValue();
            PointF value2 = this.ge.getValue();
            com.airbnb.lottie.model.content.c value3 = this.fW.getValue();
            int[] colors = value3.getColors();
            float[] cx = value3.cx();
            int width = (int) (this.gb.left + (this.gb.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.gb.top + (this.gb.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.gb.left + (this.gb.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.gb.top + (this.gb.height() / 2.0f)))) - height), colors, cx, Shader.TileMode.CLAMP);
            this.fY.put(bI, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bI() {
        int round = Math.round(this.gd.getProgress() * this.gf);
        int round2 = Math.round(this.ge.getProgress() * this.gf);
        int round3 = Math.round(this.fW.getProgress() * this.gf);
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
