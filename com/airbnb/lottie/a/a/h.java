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
/* loaded from: classes20.dex */
public class h extends a {
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> Ce;
    private final LongSparseArray<LinearGradient> Cf;
    private final LongSparseArray<RadialGradient> Cg;
    private final RectF Ci;
    private final GradientType Cj;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Ck;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Cl;
    private final int Cm;
    private final String name;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.iu().toPaintCap(), eVar.iv().toPaintJoin(), eVar.iy(), eVar.ih(), eVar.it(), eVar.iw(), eVar.ix());
        this.Cf = new LongSparseArray<>();
        this.Cg = new LongSparseArray<>();
        this.Ci = new RectF();
        this.name = eVar.getName();
        this.Cj = eVar.in();
        this.Cm = (int) (gVar.getComposition().gT() / 32.0f);
        this.Ce = eVar.iq().ia();
        this.Ce.b(this);
        aVar.a(this.Ce);
        this.Ck = eVar.ir().ia();
        this.Ck.b(this);
        aVar.a(this.Ck);
        this.Cl = eVar.is().ia();
        this.Cl.b(this);
        aVar.a(this.Cl);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.Ci, matrix);
        if (this.Cj == GradientType.Linear) {
            this.paint.setShader(hu());
        } else {
            this.paint.setShader(hv());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient hu() {
        int hw = hw();
        LinearGradient linearGradient = this.Cf.get(hw);
        if (linearGradient == null) {
            PointF value = this.Ck.getValue();
            PointF value2 = this.Cl.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Ce.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.Ci.left + (this.Ci.width() / 2.0f) + value.x), (int) (value.y + this.Ci.top + (this.Ci.height() / 2.0f)), (int) (this.Ci.left + (this.Ci.width() / 2.0f) + value2.x), (int) (this.Ci.top + (this.Ci.height() / 2.0f) + value2.y), value3.getColors(), value3.im(), Shader.TileMode.CLAMP);
            this.Cf.put(hw, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient hv() {
        int hw = hw();
        RadialGradient radialGradient = this.Cg.get(hw);
        if (radialGradient == null) {
            PointF value = this.Ck.getValue();
            PointF value2 = this.Cl.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Ce.getValue();
            int[] colors = value3.getColors();
            float[] im = value3.im();
            int width = (int) (this.Ci.left + (this.Ci.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.Ci.top + (this.Ci.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.Ci.left + (this.Ci.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.Ci.top + (this.Ci.height() / 2.0f)))) - height), colors, im, Shader.TileMode.CLAMP);
            this.Cg.put(hw, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int hw() {
        int round = Math.round(this.Ck.getProgress() * this.Cm);
        int round2 = Math.round(this.Cl.getProgress() * this.Cm);
        int round3 = Math.round(this.Ce.getProgress() * this.Cm);
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
