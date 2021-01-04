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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> DN;
    private final LongSparseArray<LinearGradient> DO;
    private final LongSparseArray<RadialGradient> DQ;
    private final RectF DS;
    private final GradientType DT;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> DU;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> DV;
    private final int DW;
    private final String name;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.ju().toPaintCap(), eVar.jv().toPaintJoin(), eVar.jy(), eVar.ji(), eVar.jt(), eVar.jw(), eVar.jx());
        this.DO = new LongSparseArray<>();
        this.DQ = new LongSparseArray<>();
        this.DS = new RectF();
        this.name = eVar.getName();
        this.DT = eVar.jo();
        this.DW = (int) (fVar.getComposition().hS() / 32.0f);
        this.DN = eVar.jq().jc();
        this.DN.b(this);
        aVar.a(this.DN);
        this.DU = eVar.jr().jc();
        this.DU.b(this);
        aVar.a(this.DU);
        this.DV = eVar.js().jc();
        this.DV.b(this);
        aVar.a(this.DV);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        d(this.DS, matrix);
        if (this.DT == GradientType.Linear) {
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
        LinearGradient linearGradient = this.DO.get(iy);
        if (linearGradient == null) {
            PointF value = this.DU.getValue();
            PointF value2 = this.DV.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DN.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.DS.left + (this.DS.width() / 2.0f) + value.x), (int) (value.y + this.DS.top + (this.DS.height() / 2.0f)), (int) (this.DS.left + (this.DS.width() / 2.0f) + value2.x), (int) (this.DS.top + (this.DS.height() / 2.0f) + value2.y), value3.getColors(), value3.jn(), Shader.TileMode.CLAMP);
            this.DO.put(iy, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient ix() {
        int iy = iy();
        RadialGradient radialGradient = this.DQ.get(iy);
        if (radialGradient == null) {
            PointF value = this.DU.getValue();
            PointF value2 = this.DV.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DN.getValue();
            int[] colors = value3.getColors();
            float[] jn = value3.jn();
            int width = (int) (this.DS.left + (this.DS.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.DS.top + (this.DS.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.DS.left + (this.DS.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.DS.top + (this.DS.height() / 2.0f)))) - height), colors, jn, Shader.TileMode.CLAMP);
            this.DQ.put(iy, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iy() {
        int round = Math.round(this.DU.getProgress() * this.DW);
        int round2 = Math.round(this.DV.getProgress() * this.DW);
        int round3 = Math.round(this.DN.getProgress() * this.DW);
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
