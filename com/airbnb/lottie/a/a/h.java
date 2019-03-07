package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
/* loaded from: classes2.dex */
public class h extends a {
    private final String name;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> oK;
    private final LongSparseArray<LinearGradient> oL;
    private final LongSparseArray<RadialGradient> oM;
    private final RectF oO;
    private final GradientType oP;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> oQ;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> oR;
    private final int oS;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.ei().toPaintCap(), eVar.ej().toPaintJoin(), eVar.dU(), eVar.eh(), eVar.ek(), eVar.el());
        this.oL = new LongSparseArray<>();
        this.oM = new LongSparseArray<>();
        this.oO = new RectF();
        this.name = eVar.getName();
        this.oP = eVar.ed();
        this.oS = (int) (fVar.cS().getDuration() / 32);
        this.oK = eVar.ee().dF();
        this.oK.b(this);
        aVar.a(this.oK);
        this.oQ = eVar.ef().dF();
        this.oQ.b(this);
        aVar.a(this.oQ);
        this.oR = eVar.eg().dF();
        this.oR.b(this);
        aVar.a(this.oR);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.oO, matrix);
        if (this.oP == GradientType.Linear) {
            this.paint.setShader(df());
        } else {
            this.paint.setShader(dg());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient df() {
        int dh = dh();
        LinearGradient linearGradient = this.oL.get(dh);
        if (linearGradient == null) {
            PointF value = this.oQ.getValue();
            PointF value2 = this.oR.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oK.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.oO.left + (this.oO.width() / 2.0f) + value.x), (int) (value.y + this.oO.top + (this.oO.height() / 2.0f)), (int) (this.oO.left + (this.oO.width() / 2.0f) + value2.x), (int) (this.oO.top + (this.oO.height() / 2.0f) + value2.y), value3.getColors(), value3.ec(), Shader.TileMode.CLAMP);
            this.oL.put(dh, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient dg() {
        int dh = dh();
        RadialGradient radialGradient = this.oM.get(dh);
        if (radialGradient == null) {
            PointF value = this.oQ.getValue();
            PointF value2 = this.oR.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oK.getValue();
            int[] colors = value3.getColors();
            float[] ec = value3.ec();
            int width = (int) (this.oO.left + (this.oO.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.oO.top + (this.oO.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.oO.left + (this.oO.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.oO.top + (this.oO.height() / 2.0f)))) - height), colors, ec, Shader.TileMode.CLAMP);
            this.oM.put(dh, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int dh() {
        int round = Math.round(this.oQ.getProgress() * this.oS);
        int round2 = Math.round(this.oR.getProgress() * this.oS);
        int round3 = Math.round(this.oK.getProgress() * this.oS);
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
