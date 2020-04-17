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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> BC;
    private final LongSparseArray<LinearGradient> BD;
    private final LongSparseArray<RadialGradient> BE;
    private final RectF BG;
    private final GradientType BH;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> BI;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> BJ;
    private final int BK;
    private final String name;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.ic().toPaintCap(), eVar.ie().toPaintJoin(), eVar.ih(), eVar.hQ(), eVar.ib(), eVar.m8if(), eVar.ig());
        this.BD = new LongSparseArray<>();
        this.BE = new LongSparseArray<>();
        this.BG = new RectF();
        this.name = eVar.getName();
        this.BH = eVar.hW();
        this.BK = (int) (gVar.getComposition().gD() / 32.0f);
        this.BC = eVar.hY().hK();
        this.BC.b(this);
        aVar.a(this.BC);
        this.BI = eVar.hZ().hK();
        this.BI.b(this);
        aVar.a(this.BI);
        this.BJ = eVar.ia().hK();
        this.BJ.b(this);
        aVar.a(this.BJ);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.BG, matrix);
        if (this.BH == GradientType.Linear) {
            this.paint.setShader(he());
        } else {
            this.paint.setShader(hf());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient he() {
        int hg = hg();
        LinearGradient linearGradient = this.BD.get(hg);
        if (linearGradient == null) {
            PointF value = this.BI.getValue();
            PointF value2 = this.BJ.getValue();
            com.airbnb.lottie.model.content.c value3 = this.BC.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.BG.left + (this.BG.width() / 2.0f) + value.x), (int) (value.y + this.BG.top + (this.BG.height() / 2.0f)), (int) (this.BG.left + (this.BG.width() / 2.0f) + value2.x), (int) (this.BG.top + (this.BG.height() / 2.0f) + value2.y), value3.getColors(), value3.hV(), Shader.TileMode.CLAMP);
            this.BD.put(hg, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient hf() {
        int hg = hg();
        RadialGradient radialGradient = this.BE.get(hg);
        if (radialGradient == null) {
            PointF value = this.BI.getValue();
            PointF value2 = this.BJ.getValue();
            com.airbnb.lottie.model.content.c value3 = this.BC.getValue();
            int[] colors = value3.getColors();
            float[] hV = value3.hV();
            int width = (int) (this.BG.left + (this.BG.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.BG.top + (this.BG.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.BG.left + (this.BG.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.BG.top + (this.BG.height() / 2.0f)))) - height), colors, hV, Shader.TileMode.CLAMP);
            this.BE.put(hg, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int hg() {
        int round = Math.round(this.BI.getProgress() * this.BK);
        int round2 = Math.round(this.BJ.getProgress() * this.BK);
        int round3 = Math.round(this.BC.getProgress() * this.BK);
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
