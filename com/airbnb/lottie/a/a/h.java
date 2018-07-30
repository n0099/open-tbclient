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
    private final LongSparseArray<LinearGradient> lA;
    private final LongSparseArray<RadialGradient> lB;
    private final RectF lD;
    private final GradientType lE;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lF;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> lG;
    private final int lH;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> ly;
    private final String name;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.cL().toPaintCap(), eVar.cM().toPaintJoin(), eVar.cx(), eVar.cK(), eVar.cN(), eVar.cO());
        this.lA = new LongSparseArray<>();
        this.lB = new LongSparseArray<>();
        this.lD = new RectF();
        this.name = eVar.getName();
        this.lE = eVar.cG();
        this.lH = (int) (fVar.bv().getDuration() / 32);
        this.ly = eVar.cH().ci();
        this.ly.b(this);
        aVar.a(this.ly);
        this.lF = eVar.cI().ci();
        this.lF.b(this);
        aVar.a(this.lF);
        this.lG = eVar.cJ().ci();
        this.lG.b(this);
        aVar.a(this.lG);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.lD, matrix);
        if (this.lE == GradientType.Linear) {
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
        LinearGradient linearGradient = this.lA.get(bK);
        if (linearGradient == null) {
            PointF value = this.lF.getValue();
            PointF value2 = this.lG.getValue();
            com.airbnb.lottie.model.content.c value3 = this.ly.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.lD.left + (this.lD.width() / 2.0f) + value.x), (int) (value.y + this.lD.top + (this.lD.height() / 2.0f)), (int) (this.lD.left + (this.lD.width() / 2.0f) + value2.x), (int) (this.lD.top + (this.lD.height() / 2.0f) + value2.y), value3.getColors(), value3.cF(), Shader.TileMode.CLAMP);
            this.lA.put(bK, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bJ() {
        int bK = bK();
        RadialGradient radialGradient = this.lB.get(bK);
        if (radialGradient == null) {
            PointF value = this.lF.getValue();
            PointF value2 = this.lG.getValue();
            com.airbnb.lottie.model.content.c value3 = this.ly.getValue();
            int[] colors = value3.getColors();
            float[] cF = value3.cF();
            int width = (int) (this.lD.left + (this.lD.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.lD.top + (this.lD.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.lD.left + (this.lD.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.lD.top + (this.lD.height() / 2.0f)))) - height), colors, cF, Shader.TileMode.CLAMP);
            this.lB.put(bK, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bK() {
        int round = Math.round(this.lF.getProgress() * this.lH);
        int round2 = Math.round(this.lG.getProgress() * this.lH);
        int round3 = Math.round(this.ly.getProgress() * this.lH);
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
