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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> oa;
    private final LongSparseArray<LinearGradient> ob;
    private final LongSparseArray<RadialGradient> oc;
    private final RectF oe;
    private final GradientType of;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> og;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> oh;
    private final int oi;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.dS().toPaintCap(), eVar.dT().toPaintJoin(), eVar.dE(), eVar.dR(), eVar.dU(), eVar.dV());
        this.ob = new LongSparseArray<>();
        this.oc = new LongSparseArray<>();
        this.oe = new RectF();
        this.name = eVar.getName();
        this.of = eVar.dN();
        this.oi = (int) (fVar.cC().getDuration() / 32);
        this.oa = eVar.dO().dp();
        this.oa.b(this);
        aVar.a(this.oa);
        this.og = eVar.dP().dp();
        this.og.b(this);
        aVar.a(this.og);
        this.oh = eVar.dQ().dp();
        this.oh.b(this);
        aVar.a(this.oh);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.oe, matrix);
        if (this.of == GradientType.Linear) {
            this.paint.setShader(cP());
        } else {
            this.paint.setShader(cQ());
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

    private LinearGradient cP() {
        int cR = cR();
        LinearGradient linearGradient = this.ob.get(cR);
        if (linearGradient == null) {
            PointF value = this.og.getValue();
            PointF value2 = this.oh.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oa.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.oe.left + (this.oe.width() / 2.0f) + value.x), (int) (value.y + this.oe.top + (this.oe.height() / 2.0f)), (int) (this.oe.left + (this.oe.width() / 2.0f) + value2.x), (int) (this.oe.top + (this.oe.height() / 2.0f) + value2.y), value3.getColors(), value3.dM(), Shader.TileMode.CLAMP);
            this.ob.put(cR, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient cQ() {
        int cR = cR();
        RadialGradient radialGradient = this.oc.get(cR);
        if (radialGradient == null) {
            PointF value = this.og.getValue();
            PointF value2 = this.oh.getValue();
            com.airbnb.lottie.model.content.c value3 = this.oa.getValue();
            int[] colors = value3.getColors();
            float[] dM = value3.dM();
            int width = (int) (this.oe.left + (this.oe.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.oe.top + (this.oe.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.oe.left + (this.oe.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.oe.top + (this.oe.height() / 2.0f)))) - height), colors, dM, Shader.TileMode.CLAMP);
            this.oc.put(cR, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int cR() {
        int round = Math.round(this.og.getProgress() * this.oi);
        int round2 = Math.round(this.oh.getProgress() * this.oi);
        int round3 = Math.round(this.oa.getProgress() * this.oi);
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
