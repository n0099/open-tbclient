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
/* loaded from: classes10.dex */
public class h extends a {
    private final LongSparseArray<LinearGradient> DM;
    private final LongSparseArray<RadialGradient> DN;
    private final RectF DQ;
    private final int DU;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> bsA;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> bsB;
    private final com.baidu.live.lottie.a.b.a<com.baidu.live.lottie.model.content.c, com.baidu.live.lottie.model.content.c> bsy;
    private final GradientType bsz;
    private final String name;

    public h(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.e eVar) {
        super(hVar, aVar, eVar.NI().toPaintCap(), eVar.NJ().toPaintJoin(), eVar.jx(), eVar.Ny(), eVar.NH(), eVar.jv(), eVar.NK());
        this.DM = new LongSparseArray<>();
        this.DN = new LongSparseArray<>();
        this.DQ = new RectF();
        this.name = eVar.getName();
        this.bsz = eVar.ND();
        this.DU = (int) (hVar.getComposition().hR() / 32.0f);
        this.bsy = eVar.NE().Ns();
        this.bsy.b(this);
        aVar.a(this.bsy);
        this.bsA = eVar.NF().Ns();
        this.bsA.b(this);
        aVar.a(this.bsA);
        this.bsB = eVar.NG().Ns();
        this.bsB.b(this);
        aVar.a(this.bsB);
    }

    @Override // com.baidu.live.lottie.a.a.a, com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        d(this.DQ, matrix);
        if (this.bsz == GradientType.Linear) {
            this.paint.setShader(iv());
        } else {
            this.paint.setShader(iw());
        }
        super.c(canvas, matrix, i);
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iv() {
        int ix = ix();
        LinearGradient linearGradient = this.DM.get(ix);
        if (linearGradient == null) {
            PointF value = this.bsA.getValue();
            PointF value2 = this.bsB.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.bsy.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.DQ.left + (this.DQ.width() / 2.0f) + value.x), (int) (value.y + this.DQ.top + (this.DQ.height() / 2.0f)), (int) (this.DQ.left + (this.DQ.width() / 2.0f) + value2.x), (int) (this.DQ.top + (this.DQ.height() / 2.0f) + value2.y), value3.getColors(), value3.jm(), Shader.TileMode.CLAMP);
            this.DM.put(ix, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iw() {
        int ix = ix();
        RadialGradient radialGradient = this.DN.get(ix);
        if (radialGradient == null) {
            PointF value = this.bsA.getValue();
            PointF value2 = this.bsB.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.bsy.getValue();
            int[] colors = value3.getColors();
            float[] jm = value3.jm();
            int width = (int) (this.DQ.left + (this.DQ.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.DQ.top + (this.DQ.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.DQ.left + (this.DQ.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.DQ.top + (this.DQ.height() / 2.0f)))) - height), colors, jm, Shader.TileMode.CLAMP);
            this.DN.put(ix, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int ix() {
        int round = Math.round(this.bsA.getProgress() * this.DU);
        int round2 = Math.round(this.bsB.getProgress() * this.DU);
        int round3 = Math.round(this.bsy.getProgress() * this.DU);
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
