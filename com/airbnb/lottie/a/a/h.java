package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
/* loaded from: classes3.dex */
public class h extends a {
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> DK;
    private final LongSparseArray<LinearGradient> DM;
    private final LongSparseArray<RadialGradient> DN;
    private final RectF DQ;
    private final GradientType DR;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> DS;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> DT;
    private final int DU;
    private final String name;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.ju().toPaintCap(), eVar.jv().toPaintJoin(), eVar.jy(), eVar.ji(), eVar.jt(), eVar.jw(), eVar.jx());
        this.DM = new LongSparseArray<>();
        this.DN = new LongSparseArray<>();
        this.DQ = new RectF();
        this.name = eVar.getName();
        this.DR = eVar.jo();
        this.DU = (int) (fVar.getComposition().hS() / 32.0f);
        this.DK = eVar.jq().jc();
        this.DK.b(this);
        aVar.a(this.DK);
        this.DS = eVar.jr().jc();
        this.DS.b(this);
        aVar.a(this.DS);
        this.DT = eVar.js().jc();
        this.DT.b(this);
        aVar.a(this.DT);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        d(this.DQ, matrix);
        if (this.DR == GradientType.Linear) {
            this.paint.setShader(iw());
        } else {
            this.paint.setShader(ix());
        }
        super.c(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iw() {
        int iy = iy();
        LinearGradient linearGradient = this.DM.get(iy);
        if (linearGradient == null) {
            PointF value = this.DS.getValue();
            PointF value2 = this.DT.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DK.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.DQ.left + (this.DQ.width() / 2.0f) + value.x), (int) (value.y + this.DQ.top + (this.DQ.height() / 2.0f)), (int) (this.DQ.left + (this.DQ.width() / 2.0f) + value2.x), (int) (this.DQ.top + (this.DQ.height() / 2.0f) + value2.y), value3.getColors(), value3.jn(), Shader.TileMode.CLAMP);
            this.DM.put(iy, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient ix() {
        int iy = iy();
        RadialGradient radialGradient = this.DN.get(iy);
        if (radialGradient == null) {
            PointF value = this.DS.getValue();
            PointF value2 = this.DT.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DK.getValue();
            int[] colors = value3.getColors();
            float[] jn = value3.jn();
            int width = (int) (this.DQ.left + (this.DQ.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.DQ.top + (this.DQ.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.DQ.left + (this.DQ.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.DQ.top + (this.DQ.height() / 2.0f)))) - height), colors, jn, Shader.TileMode.CLAMP);
            this.DN.put(iy, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iy() {
        int round = Math.round(this.DS.getProgress() * this.DU);
        int round2 = Math.round(this.DT.getProgress() * this.DU);
        int round3 = Math.round(this.DK.getProgress() * this.DU);
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
