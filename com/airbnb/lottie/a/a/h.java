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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> Cc;
    private final LongSparseArray<LinearGradient> Cd;
    private final LongSparseArray<RadialGradient> Ce;
    private final RectF Cg;
    private final GradientType Ch;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Ci;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Cj;
    private final int Ck;
    private final String name;

    public h(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.iu().toPaintCap(), eVar.iv().toPaintJoin(), eVar.iy(), eVar.ih(), eVar.it(), eVar.iw(), eVar.ix());
        this.Cd = new LongSparseArray<>();
        this.Ce = new LongSparseArray<>();
        this.Cg = new RectF();
        this.name = eVar.getName();
        this.Ch = eVar.in();
        this.Ck = (int) (gVar.getComposition().gT() / 32.0f);
        this.Cc = eVar.iq().ia();
        this.Cc.b(this);
        aVar.a(this.Cc);
        this.Ci = eVar.ir().ia();
        this.Ci.b(this);
        aVar.a(this.Ci);
        this.Cj = eVar.is().ia();
        this.Cj.b(this);
        aVar.a(this.Cj);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.Cg, matrix);
        if (this.Ch == GradientType.Linear) {
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
        LinearGradient linearGradient = this.Cd.get(hw);
        if (linearGradient == null) {
            PointF value = this.Ci.getValue();
            PointF value2 = this.Cj.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Cc.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.Cg.left + (this.Cg.width() / 2.0f) + value.x), (int) (value.y + this.Cg.top + (this.Cg.height() / 2.0f)), (int) (this.Cg.left + (this.Cg.width() / 2.0f) + value2.x), (int) (this.Cg.top + (this.Cg.height() / 2.0f) + value2.y), value3.getColors(), value3.im(), Shader.TileMode.CLAMP);
            this.Cd.put(hw, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient hv() {
        int hw = hw();
        RadialGradient radialGradient = this.Ce.get(hw);
        if (radialGradient == null) {
            PointF value = this.Ci.getValue();
            PointF value2 = this.Cj.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Cc.getValue();
            int[] colors = value3.getColors();
            float[] im = value3.im();
            int width = (int) (this.Cg.left + (this.Cg.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.Cg.top + (this.Cg.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.Cg.left + (this.Cg.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.Cg.top + (this.Cg.height() / 2.0f)))) - height), colors, im, Shader.TileMode.CLAMP);
            this.Ce.put(hw, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int hw() {
        int round = Math.round(this.Ci.getProgress() * this.Ck);
        int round2 = Math.round(this.Cj.getProgress() * this.Ck);
        int round3 = Math.round(this.Cc.getProgress() * this.Ck);
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
