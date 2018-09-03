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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> lA;
    private final LongSparseArray<LinearGradient> lB;
    private final LongSparseArray<RadialGradient> lC;
    private final RectF lE;
    private final GradientType lF;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lG;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lH;
    private final int lI;
    private final String name;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.cL().toPaintCap(), eVar.cM().toPaintJoin(), eVar.cx(), eVar.cK(), eVar.cN(), eVar.cO());
        this.lB = new LongSparseArray<>();
        this.lC = new LongSparseArray<>();
        this.lE = new RectF();
        this.name = eVar.getName();
        this.lF = eVar.cG();
        this.lI = (int) (fVar.bv().getDuration() / 32);
        this.lA = eVar.cH().ci();
        this.lA.b(this);
        aVar.a(this.lA);
        this.lG = eVar.cI().ci();
        this.lG.b(this);
        aVar.a(this.lG);
        this.lH = eVar.cJ().ci();
        this.lH.b(this);
        aVar.a(this.lH);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.lE, matrix);
        if (this.lF == GradientType.Linear) {
            this.paint.setShader(bI());
        } else {
            this.paint.setShader(bJ());
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

    private LinearGradient bI() {
        int bK = bK();
        LinearGradient linearGradient = this.lB.get(bK);
        if (linearGradient == null) {
            PointF value = this.lG.getValue();
            PointF value2 = this.lH.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lA.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.lE.left + (this.lE.width() / 2.0f) + value.x), (int) (value.y + this.lE.top + (this.lE.height() / 2.0f)), (int) (this.lE.left + (this.lE.width() / 2.0f) + value2.x), (int) (this.lE.top + (this.lE.height() / 2.0f) + value2.y), value3.getColors(), value3.cF(), Shader.TileMode.CLAMP);
            this.lB.put(bK, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bJ() {
        int bK = bK();
        RadialGradient radialGradient = this.lC.get(bK);
        if (radialGradient == null) {
            PointF value = this.lG.getValue();
            PointF value2 = this.lH.getValue();
            com.airbnb.lottie.model.content.c value3 = this.lA.getValue();
            int[] colors = value3.getColors();
            float[] cF = value3.cF();
            int width = (int) (this.lE.left + (this.lE.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.lE.top + (this.lE.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.lE.left + (this.lE.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.lE.top + (this.lE.height() / 2.0f)))) - height), colors, cF, Shader.TileMode.CLAMP);
            this.lC.put(bK, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bK() {
        int round = Math.round(this.lG.getProgress() * this.lI);
        int round2 = Math.round(this.lH.getProgress() * this.lI);
        int round3 = Math.round(this.lA.getProgress() * this.lI);
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
