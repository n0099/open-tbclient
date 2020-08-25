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
/* loaded from: classes18.dex */
public class h extends a {
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> CJ;
    private final LongSparseArray<LinearGradient> CK;
    private final LongSparseArray<RadialGradient> CL;
    private final RectF CO;
    private final GradientType CP;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> CQ;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> CV;
    private final int CW;
    private final String name;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.jT().toPaintCap(), eVar.jU().toPaintJoin(), eVar.jX(), eVar.jH(), eVar.jS(), eVar.jV(), eVar.jW());
        this.CK = new LongSparseArray<>();
        this.CL = new LongSparseArray<>();
        this.CO = new RectF();
        this.name = eVar.getName();
        this.CP = eVar.jN();
        this.CW = (int) (gVar.getComposition().iu() / 32.0f);
        this.CJ = eVar.jP().jB();
        this.CJ.b(this);
        aVar.a(this.CJ);
        this.CQ = eVar.jQ().jB();
        this.CQ.b(this);
        aVar.a(this.CQ);
        this.CV = eVar.jR().jB();
        this.CV.b(this);
        aVar.a(this.CV);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.CO, matrix);
        if (this.CP == GradientType.Linear) {
            this.paint.setShader(iV());
        } else {
            this.paint.setShader(iW());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iV() {
        int iX = iX();
        LinearGradient linearGradient = this.CK.get(iX);
        if (linearGradient == null) {
            PointF value = this.CQ.getValue();
            PointF value2 = this.CV.getValue();
            com.airbnb.lottie.model.content.c value3 = this.CJ.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.CO.left + (this.CO.width() / 2.0f) + value.x), (int) (value.y + this.CO.top + (this.CO.height() / 2.0f)), (int) (this.CO.left + (this.CO.width() / 2.0f) + value2.x), (int) (this.CO.top + (this.CO.height() / 2.0f) + value2.y), value3.getColors(), value3.jM(), Shader.TileMode.CLAMP);
            this.CK.put(iX, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iW() {
        int iX = iX();
        RadialGradient radialGradient = this.CL.get(iX);
        if (radialGradient == null) {
            PointF value = this.CQ.getValue();
            PointF value2 = this.CV.getValue();
            com.airbnb.lottie.model.content.c value3 = this.CJ.getValue();
            int[] colors = value3.getColors();
            float[] jM = value3.jM();
            int width = (int) (this.CO.left + (this.CO.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.CO.top + (this.CO.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.CO.left + (this.CO.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.CO.top + (this.CO.height() / 2.0f)))) - height), colors, jM, Shader.TileMode.CLAMP);
            this.CL.put(iX, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iX() {
        int round = Math.round(this.CQ.getProgress() * this.CW);
        int round2 = Math.round(this.CV.getProgress() * this.CW);
        int round3 = Math.round(this.CJ.getProgress() * this.CW);
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
