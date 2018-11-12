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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> oP;
    private final LongSparseArray<LinearGradient> oQ;
    private final LongSparseArray<RadialGradient> oR;
    private final RectF oT;
    private final GradientType oU;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> oV;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> oW;
    private final int oX;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.ej().toPaintCap(), eVar.ek().toPaintJoin(), eVar.dV(), eVar.ei(), eVar.el(), eVar.em());
        this.oQ = new LongSparseArray<>();
        this.oR = new LongSparseArray<>();
        this.oT = new RectF();
        this.name = eVar.getName();
        this.oU = eVar.ee();
        this.oX = (int) (fVar.cT().getDuration() / 32);
        this.oP = eVar.ef().dG();
        this.oP.b(this);
        aVar.a(this.oP);
        this.oV = eVar.eg().dG();
        this.oV.b(this);
        aVar.a(this.oV);
        this.oW = eVar.eh().dG();
        this.oW.b(this);
        aVar.a(this.oW);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.oT, matrix);
        if (this.oU == GradientType.Linear) {
            this.paint.setShader(dg());
        } else {
            this.paint.setShader(dh());
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

    private LinearGradient dg() {
        int di = di();
        LinearGradient linearGradient = this.oQ.get(di);
        if (linearGradient == null) {
            PointF value = this.oV.getValue();
            PointF value2 = this.oW.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oP.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.oT.left + (this.oT.width() / 2.0f) + value.x), (int) (value.y + this.oT.top + (this.oT.height() / 2.0f)), (int) (this.oT.left + (this.oT.width() / 2.0f) + value2.x), (int) (this.oT.top + (this.oT.height() / 2.0f) + value2.y), value3.getColors(), value3.ed(), Shader.TileMode.CLAMP);
            this.oQ.put(di, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient dh() {
        int di = di();
        RadialGradient radialGradient = this.oR.get(di);
        if (radialGradient == null) {
            PointF value = this.oV.getValue();
            PointF value2 = this.oW.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oP.getValue();
            int[] colors = value3.getColors();
            float[] ed = value3.ed();
            int width = (int) (this.oT.left + (this.oT.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.oT.top + (this.oT.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.oT.left + (this.oT.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.oT.top + (this.oT.height() / 2.0f)))) - height), colors, ed, Shader.TileMode.CLAMP);
            this.oR.put(di, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int di() {
        int round = Math.round(this.oV.getProgress() * this.oX);
        int round2 = Math.round(this.oW.getProgress() * this.oX);
        int round3 = Math.round(this.oP.getProgress() * this.oX);
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
