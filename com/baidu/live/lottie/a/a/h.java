package com.baidu.live.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.baidu.live.lottie.model.content.GradientType;
/* loaded from: classes9.dex */
public class h extends a {
    private final LongSparseArray<LinearGradient> DM;
    private final LongSparseArray<RadialGradient> DN;
    private final RectF DQ;
    private final int DU;
    private final com.baidu.live.lottie.a.b.a<com.baidu.live.lottie.model.content.c, com.baidu.live.lottie.model.content.c> boX;
    private final GradientType boY;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> boZ;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> bpa;
    private final String name;

    public h(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.e eVar) {
        super(hVar, aVar, eVar.Mk().toPaintCap(), eVar.Ml().toPaintJoin(), eVar.jy(), eVar.Ma(), eVar.Mj(), eVar.jw(), eVar.Mm());
        this.DM = new LongSparseArray<>();
        this.DN = new LongSparseArray<>();
        this.DQ = new RectF();
        this.name = eVar.getName();
        this.boY = eVar.Mf();
        this.DU = (int) (hVar.getComposition().hS() / 32.0f);
        this.boX = eVar.Mg().LU();
        this.boX.b(this);
        aVar.a(this.boX);
        this.boZ = eVar.Mh().LU();
        this.boZ.b(this);
        aVar.a(this.boZ);
        this.bpa = eVar.Mi().LU();
        this.bpa.b(this);
        aVar.a(this.bpa);
    }

    @Override // com.baidu.live.lottie.a.a.a, com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        d(this.DQ, matrix);
        if (this.boY == GradientType.Linear) {
            this.paint.setShader(iw());
        } else {
            this.paint.setShader(ix());
        }
        super.c(canvas, matrix, i);
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iw() {
        int iy = iy();
        LinearGradient linearGradient = this.DM.get(iy);
        if (linearGradient == null) {
            PointF value = this.boZ.getValue();
            PointF value2 = this.bpa.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.boX.getValue();
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
            PointF value = this.boZ.getValue();
            PointF value2 = this.bpa.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.boX.getValue();
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
        int round = Math.round(this.boZ.getProgress() * this.DU);
        int round2 = Math.round(this.bpa.getProgress() * this.DU);
        int round3 = Math.round(this.boX.getProgress() * this.DU);
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
