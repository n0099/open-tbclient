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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> eJ;
    private final LongSparseArray<LinearGradient> eK;
    private final LongSparseArray<RadialGradient> eL;
    private final RectF eN;
    private final GradientType eO;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> eP;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> eQ;
    private final int eR;
    private final String name;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.cC().toPaintCap(), eVar.cD().toPaintJoin(), eVar.cn(), eVar.cB(), eVar.cE(), eVar.cF());
        this.eK = new LongSparseArray<>();
        this.eL = new LongSparseArray<>();
        this.eN = new RectF();
        this.name = eVar.getName();
        this.eO = eVar.cw();
        this.eR = (int) (fVar.bj().getDuration() / 32);
        this.eJ = eVar.cy().bY();
        this.eJ.b(this);
        aVar.a(this.eJ);
        this.eP = eVar.cz().bY();
        this.eP.b(this);
        aVar.a(this.eP);
        this.eQ = eVar.cA().bY();
        this.eQ.b(this);
        aVar.a(this.eQ);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.eN, matrix);
        if (this.eO == GradientType.Linear) {
            this.paint.setShader(bx());
        } else {
            this.paint.setShader(by());
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

    private LinearGradient bx() {
        int bz = bz();
        LinearGradient linearGradient = this.eK.get(bz);
        if (linearGradient == null) {
            PointF value = this.eP.getValue();
            PointF value2 = this.eQ.getValue();
            com.airbnb.lottie.model.content.c value3 = this.eJ.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.eN.left + (this.eN.width() / 2.0f) + value.x), (int) (value.y + this.eN.top + (this.eN.height() / 2.0f)), (int) (this.eN.left + (this.eN.width() / 2.0f) + value2.x), (int) (this.eN.top + (this.eN.height() / 2.0f) + value2.y), value3.getColors(), value3.cv(), Shader.TileMode.CLAMP);
            this.eK.put(bz, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient by() {
        int bz = bz();
        RadialGradient radialGradient = this.eL.get(bz);
        if (radialGradient == null) {
            PointF value = this.eP.getValue();
            PointF value2 = this.eQ.getValue();
            com.airbnb.lottie.model.content.c value3 = this.eJ.getValue();
            int[] colors = value3.getColors();
            float[] cv = value3.cv();
            int width = (int) (this.eN.left + (this.eN.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.eN.top + (this.eN.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.eN.left + (this.eN.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.eN.top + (this.eN.height() / 2.0f)))) - height), colors, cv, Shader.TileMode.CLAMP);
            this.eL.put(bz, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bz() {
        int round = Math.round(this.eP.getProgress() * this.eR);
        int round2 = Math.round(this.eQ.getProgress() * this.eR);
        int round3 = Math.round(this.eJ.getProgress() * this.eR);
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
