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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> mk;
    private final LongSparseArray<LinearGradient> ml;
    private final LongSparseArray<RadialGradient> mm;
    private final RectF mo;
    private final GradientType mp;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> mq;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> mr;
    private final int mt;
    private final String name;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.dc().toPaintCap(), eVar.dd().toPaintJoin(), eVar.cO(), eVar.db(), eVar.de(), eVar.df());
        this.ml = new LongSparseArray<>();
        this.mm = new LongSparseArray<>();
        this.mo = new RectF();
        this.name = eVar.getName();
        this.mp = eVar.cX();
        this.mt = (int) (fVar.bM().getDuration() / 32);
        this.mk = eVar.cY().cz();
        this.mk.b(this);
        aVar.a(this.mk);
        this.mq = eVar.cZ().cz();
        this.mq.b(this);
        aVar.a(this.mq);
        this.mr = eVar.da().cz();
        this.mr.b(this);
        aVar.a(this.mr);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.mo, matrix);
        if (this.mp == GradientType.Linear) {
            this.paint.setShader(bZ());
        } else {
            this.paint.setShader(ca());
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

    private LinearGradient bZ() {
        int cb = cb();
        LinearGradient linearGradient = this.ml.get(cb);
        if (linearGradient == null) {
            PointF value = this.mq.getValue();
            PointF value2 = this.mr.getValue();
            com.airbnb.lottie.model.content.c value3 = this.mk.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.mo.left + (this.mo.width() / 2.0f) + value.x), (int) (value.y + this.mo.top + (this.mo.height() / 2.0f)), (int) (this.mo.left + (this.mo.width() / 2.0f) + value2.x), (int) (this.mo.top + (this.mo.height() / 2.0f) + value2.y), value3.getColors(), value3.cW(), Shader.TileMode.CLAMP);
            this.ml.put(cb, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient ca() {
        int cb = cb();
        RadialGradient radialGradient = this.mm.get(cb);
        if (radialGradient == null) {
            PointF value = this.mq.getValue();
            PointF value2 = this.mr.getValue();
            com.airbnb.lottie.model.content.c value3 = this.mk.getValue();
            int[] colors = value3.getColors();
            float[] cW = value3.cW();
            int width = (int) (this.mo.left + (this.mo.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.mo.top + (this.mo.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.mo.left + (this.mo.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.mo.top + (this.mo.height() / 2.0f)))) - height), colors, cW, Shader.TileMode.CLAMP);
            this.mm.put(cb, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int cb() {
        int round = Math.round(this.mq.getProgress() * this.mt);
        int round2 = Math.round(this.mr.getProgress() * this.mt);
        int round3 = Math.round(this.mk.getProgress() * this.mt);
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
