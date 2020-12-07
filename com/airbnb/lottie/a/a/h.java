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
/* loaded from: classes7.dex */
public class h extends a {
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> DZ;
    private final LongSparseArray<LinearGradient> Ea;
    private final LongSparseArray<RadialGradient> Eb;
    private final RectF Ed;
    private final GradientType Ee;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Ef;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Eg;
    private final int Eh;
    private final String name;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.jV().toPaintCap(), eVar.jW().toPaintJoin(), eVar.jZ(), eVar.jJ(), eVar.jU(), eVar.jX(), eVar.jY());
        this.Ea = new LongSparseArray<>();
        this.Eb = new LongSparseArray<>();
        this.Ed = new RectF();
        this.name = eVar.getName();
        this.Ee = eVar.jP();
        this.Eh = (int) (gVar.getComposition().iv() / 32.0f);
        this.DZ = eVar.jR().jD();
        this.DZ.b(this);
        aVar.a(this.DZ);
        this.Ef = eVar.jS().jD();
        this.Ef.b(this);
        aVar.a(this.Ef);
        this.Eg = eVar.jT().jD();
        this.Eg.b(this);
        aVar.a(this.Eg);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.Ed, matrix);
        if (this.Ee == GradientType.Linear) {
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
        LinearGradient linearGradient = this.Ea.get(iZ);
        if (linearGradient == null) {
            PointF value = this.Ef.getValue();
            PointF value2 = this.Eg.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DZ.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.Ed.left + (this.Ed.width() / 2.0f) + value.x), (int) (value.y + this.Ed.top + (this.Ed.height() / 2.0f)), (int) (this.Ed.left + (this.Ed.width() / 2.0f) + value2.x), (int) (this.Ed.top + (this.Ed.height() / 2.0f) + value2.y), value3.getColors(), value3.jO(), Shader.TileMode.CLAMP);
            this.Ea.put(iZ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iY() {
        int iZ = iZ();
        RadialGradient radialGradient = this.Eb.get(iZ);
        if (radialGradient == null) {
            PointF value = this.Ef.getValue();
            PointF value2 = this.Eg.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DZ.getValue();
            int[] colors = value3.getColors();
            float[] jO = value3.jO();
            int width = (int) (this.Ed.left + (this.Ed.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.Ed.top + (this.Ed.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.Ed.left + (this.Ed.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.Ed.top + (this.Ed.height() / 2.0f)))) - height), colors, jO, Shader.TileMode.CLAMP);
            this.Eb.put(iZ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iZ() {
        int round = Math.round(this.Ef.getProgress() * this.Eh);
        int round2 = Math.round(this.Eg.getProgress() * this.Eh);
        int round3 = Math.round(this.DZ.getProgress() * this.Eh);
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
