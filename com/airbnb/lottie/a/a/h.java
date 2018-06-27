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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> lI;
    private final LongSparseArray<LinearGradient> lJ;
    private final LongSparseArray<RadialGradient> lK;
    private final RectF lM;
    private final GradientType lN;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lO;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lP;
    private final int lQ;
    private final String name;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.cN().toPaintCap(), eVar.cO().toPaintJoin(), eVar.cz(), eVar.cM(), eVar.cP(), eVar.cQ());
        this.lJ = new LongSparseArray<>();
        this.lK = new LongSparseArray<>();
        this.lM = new RectF();
        this.name = eVar.getName();
        this.lN = eVar.cI();
        this.lQ = (int) (fVar.bx().getDuration() / 32);
        this.lI = eVar.cJ().ck();
        this.lI.b(this);
        aVar.a(this.lI);
        this.lO = eVar.cK().ck();
        this.lO.b(this);
        aVar.a(this.lO);
        this.lP = eVar.cL().ck();
        this.lP.b(this);
        aVar.a(this.lP);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.lM, matrix);
        if (this.lN == GradientType.Linear) {
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
        LinearGradient linearGradient = this.lJ.get(bM);
        if (linearGradient == null) {
            PointF value = this.lO.getValue();
            PointF value2 = this.lP.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lI.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.lM.left + (this.lM.width() / 2.0f) + value.x), (int) (value.y + this.lM.top + (this.lM.height() / 2.0f)), (int) (this.lM.left + (this.lM.width() / 2.0f) + value2.x), (int) (this.lM.top + (this.lM.height() / 2.0f) + value2.y), value3.getColors(), value3.cH(), Shader.TileMode.CLAMP);
            this.lJ.put(bM, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bL() {
        int bM = bM();
        RadialGradient radialGradient = this.lK.get(bM);
        if (radialGradient == null) {
            PointF value = this.lO.getValue();
            PointF value2 = this.lP.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lI.getValue();
            int[] colors = value3.getColors();
            float[] cH = value3.cH();
            int width = (int) (this.lM.left + (this.lM.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.lM.top + (this.lM.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.lM.left + (this.lM.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.lM.top + (this.lM.height() / 2.0f)))) - height), colors, cH, Shader.TileMode.CLAMP);
            this.lK.put(bM, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bM() {
        int round = Math.round(this.lO.getProgress() * this.lQ);
        int round2 = Math.round(this.lP.getProgress() * this.lQ);
        int round3 = Math.round(this.lI.getProgress() * this.lQ);
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
