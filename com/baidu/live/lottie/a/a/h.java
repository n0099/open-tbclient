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
    private final LongSparseArray<LinearGradient> DO;
    private final LongSparseArray<RadialGradient> DQ;
    private final RectF DS;
    private final int DW;
    private final com.baidu.live.lottie.a.b.a<com.baidu.live.lottie.model.content.c, com.baidu.live.lottie.model.content.c> btK;
    private final GradientType btL;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> btM;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> btN;
    private final String name;

    public h(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.e eVar) {
        super(hVar, aVar, eVar.Qf().toPaintCap(), eVar.Qg().toPaintJoin(), eVar.jy(), eVar.PV(), eVar.Qe(), eVar.jw(), eVar.Qh());
        this.DO = new LongSparseArray<>();
        this.DQ = new LongSparseArray<>();
        this.DS = new RectF();
        this.name = eVar.getName();
        this.btL = eVar.Qa();
        this.DW = (int) (hVar.getComposition().hS() / 32.0f);
        this.btK = eVar.Qb().PP();
        this.btK.b(this);
        aVar.a(this.btK);
        this.btM = eVar.Qc().PP();
        this.btM.b(this);
        aVar.a(this.btM);
        this.btN = eVar.Qd().PP();
        this.btN.b(this);
        aVar.a(this.btN);
    }

    @Override // com.baidu.live.lottie.a.a.a, com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        d(this.DS, matrix);
        if (this.btL == GradientType.Linear) {
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
        LinearGradient linearGradient = this.DO.get(iy);
        if (linearGradient == null) {
            PointF value = this.btM.getValue();
            PointF value2 = this.btN.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.btK.getValue();
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
            PointF value = this.btM.getValue();
            PointF value2 = this.btN.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.btK.getValue();
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
        int round = Math.round(this.btM.getProgress() * this.DW);
        int round2 = Math.round(this.btN.getProgress() * this.DW);
        int round3 = Math.round(this.btK.getProgress() * this.DW);
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
