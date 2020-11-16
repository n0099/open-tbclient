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
/* loaded from: classes16.dex */
public class h extends a {
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> Df;
    private final LongSparseArray<LinearGradient> Dg;
    private final LongSparseArray<RadialGradient> Dh;
    private final RectF Dj;
    private final GradientType Dk;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Dl;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Dm;
    private final int Dn;
    private final String name;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.jV().toPaintCap(), eVar.jW().toPaintJoin(), eVar.jZ(), eVar.jJ(), eVar.jU(), eVar.jX(), eVar.jY());
        this.Dg = new LongSparseArray<>();
        this.Dh = new LongSparseArray<>();
        this.Dj = new RectF();
        this.name = eVar.getName();
        this.Dk = eVar.jP();
        this.Dn = (int) (gVar.getComposition().iv() / 32.0f);
        this.Df = eVar.jR().jD();
        this.Df.b(this);
        aVar.a(this.Df);
        this.Dl = eVar.jS().jD();
        this.Dl.b(this);
        aVar.a(this.Dl);
        this.Dm = eVar.jT().jD();
        this.Dm.b(this);
        aVar.a(this.Dm);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.Dj, matrix);
        if (this.Dk == GradientType.Linear) {
            this.paint.setShader(iX());
        } else {
            this.paint.setShader(iY());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iX() {
        int iZ = iZ();
        LinearGradient linearGradient = this.Dg.get(iZ);
        if (linearGradient == null) {
            PointF value = this.Dl.getValue();
            PointF value2 = this.Dm.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Df.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.Dj.left + (this.Dj.width() / 2.0f) + value.x), (int) (value.y + this.Dj.top + (this.Dj.height() / 2.0f)), (int) (this.Dj.left + (this.Dj.width() / 2.0f) + value2.x), (int) (this.Dj.top + (this.Dj.height() / 2.0f) + value2.y), value3.getColors(), value3.jO(), Shader.TileMode.CLAMP);
            this.Dg.put(iZ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iY() {
        int iZ = iZ();
        RadialGradient radialGradient = this.Dh.get(iZ);
        if (radialGradient == null) {
            PointF value = this.Dl.getValue();
            PointF value2 = this.Dm.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Df.getValue();
            int[] colors = value3.getColors();
            float[] jO = value3.jO();
            int width = (int) (this.Dj.left + (this.Dj.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.Dj.top + (this.Dj.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.Dj.left + (this.Dj.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.Dj.top + (this.Dj.height() / 2.0f)))) - height), colors, jO, Shader.TileMode.CLAMP);
            this.Dh.put(iZ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iZ() {
        int round = Math.round(this.Dl.getProgress() * this.Dn);
        int round2 = Math.round(this.Dm.getProgress() * this.Dn);
        int round3 = Math.round(this.Df.getProgress() * this.Dn);
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
