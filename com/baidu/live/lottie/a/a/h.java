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
    private final LongSparseArray<LinearGradient> Fg;
    private final LongSparseArray<RadialGradient> Fh;
    private final RectF Fj;
    private final int Fn;
    private final com.baidu.live.lottie.a.b.a<com.baidu.live.lottie.model.content.c, com.baidu.live.lottie.model.content.c> btZ;
    private final GradientType bua;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> bub;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> buc;
    private final String name;

    public h(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.e eVar) {
        super(hVar, aVar, eVar.NL().toPaintCap(), eVar.NM().toPaintJoin(), eVar.jx(), eVar.NB(), eVar.NK(), eVar.jv(), eVar.NN());
        this.Fg = new LongSparseArray<>();
        this.Fh = new LongSparseArray<>();
        this.Fj = new RectF();
        this.name = eVar.getName();
        this.bua = eVar.NG();
        this.Fn = (int) (hVar.getComposition().hR() / 32.0f);
        this.btZ = eVar.NH().Nv();
        this.btZ.b(this);
        aVar.a(this.btZ);
        this.bub = eVar.NI().Nv();
        this.bub.b(this);
        aVar.a(this.bub);
        this.buc = eVar.NJ().Nv();
        this.buc.b(this);
        aVar.a(this.buc);
    }

    @Override // com.baidu.live.lottie.a.a.a, com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        d(this.Fj, matrix);
        if (this.bua == GradientType.Linear) {
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
        LinearGradient linearGradient = this.Fg.get(ix);
        if (linearGradient == null) {
            PointF value = this.bub.getValue();
            PointF value2 = this.buc.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.btZ.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.Fj.left + (this.Fj.width() / 2.0f) + value.x), (int) (value.y + this.Fj.top + (this.Fj.height() / 2.0f)), (int) (this.Fj.left + (this.Fj.width() / 2.0f) + value2.x), (int) (this.Fj.top + (this.Fj.height() / 2.0f) + value2.y), value3.getColors(), value3.jm(), Shader.TileMode.CLAMP);
            this.Fg.put(ix, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iw() {
        int ix = ix();
        RadialGradient radialGradient = this.Fh.get(ix);
        if (radialGradient == null) {
            PointF value = this.bub.getValue();
            PointF value2 = this.buc.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.btZ.getValue();
            int[] colors = value3.getColors();
            float[] jm = value3.jm();
            int width = (int) (this.Fj.left + (this.Fj.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.Fj.top + (this.Fj.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.Fj.left + (this.Fj.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.Fj.top + (this.Fj.height() / 2.0f)))) - height), colors, jm, Shader.TileMode.CLAMP);
            this.Fh.put(ix, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int ix() {
        int round = Math.round(this.bub.getProgress() * this.Fn);
        int round2 = Math.round(this.buc.getProgress() * this.Fn);
        int round3 = Math.round(this.btZ.getProgress() * this.Fn);
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
