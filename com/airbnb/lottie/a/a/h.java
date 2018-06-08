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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> lK;
    private final LongSparseArray<LinearGradient> lL;
    private final LongSparseArray<RadialGradient> lM;
    private final RectF lO;
    private final GradientType lP;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lQ;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lR;
    private final int lS;
    private final String name;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.cN().toPaintCap(), eVar.cO().toPaintJoin(), eVar.cz(), eVar.cM(), eVar.cP(), eVar.cQ());
        this.lL = new LongSparseArray<>();
        this.lM = new LongSparseArray<>();
        this.lO = new RectF();
        this.name = eVar.getName();
        this.lP = eVar.cI();
        this.lS = (int) (fVar.bx().getDuration() / 32);
        this.lK = eVar.cJ().ck();
        this.lK.b(this);
        aVar.a(this.lK);
        this.lQ = eVar.cK().ck();
        this.lQ.b(this);
        aVar.a(this.lQ);
        this.lR = eVar.cL().ck();
        this.lR.b(this);
        aVar.a(this.lR);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.lO, matrix);
        if (this.lP == GradientType.Linear) {
            this.paint.setShader(bK());
        } else {
            this.paint.setShader(bL());
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

    private LinearGradient bK() {
        int bM = bM();
        LinearGradient linearGradient = this.lL.get(bM);
        if (linearGradient == null) {
            PointF value = this.lQ.getValue();
            PointF value2 = this.lR.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lK.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.lO.left + (this.lO.width() / 2.0f) + value.x), (int) (value.y + this.lO.top + (this.lO.height() / 2.0f)), (int) (this.lO.left + (this.lO.width() / 2.0f) + value2.x), (int) (this.lO.top + (this.lO.height() / 2.0f) + value2.y), value3.getColors(), value3.cH(), Shader.TileMode.CLAMP);
            this.lL.put(bM, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bL() {
        int bM = bM();
        RadialGradient radialGradient = this.lM.get(bM);
        if (radialGradient == null) {
            PointF value = this.lQ.getValue();
            PointF value2 = this.lR.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lK.getValue();
            int[] colors = value3.getColors();
            float[] cH = value3.cH();
            int width = (int) (this.lO.left + (this.lO.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.lO.top + (this.lO.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.lO.left + (this.lO.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.lO.top + (this.lO.height() / 2.0f)))) - height), colors, cH, Shader.TileMode.CLAMP);
            this.lM.put(bM, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bM() {
        int round = Math.round(this.lQ.getProgress() * this.lS);
        int round2 = Math.round(this.lR.getProgress() * this.lS);
        int round3 = Math.round(this.lK.getProgress() * this.lS);
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
