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
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> mj;
    private final LongSparseArray<LinearGradient> mk;
    private final LongSparseArray<RadialGradient> ml;
    private final RectF mn;
    private final GradientType mo;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> mp;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> mq;
    private final int mr;
    private final String name;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.dj().toPaintCap(), eVar.dk().toPaintJoin(), eVar.cU(), eVar.di(), eVar.dl(), eVar.dm());
        this.mk = new LongSparseArray<>();
        this.ml = new LongSparseArray<>();
        this.mn = new RectF();
        this.name = eVar.getName();
        this.mo = eVar.dd();
        this.mr = (int) (fVar.bQ().getDuration() / 32);
        this.mj = eVar.df().cF();
        this.mj.b(this);
        aVar.a(this.mj);
        this.mp = eVar.dg().cF();
        this.mp.b(this);
        aVar.a(this.mp);
        this.mq = eVar.dh().cF();
        this.mq.b(this);
        aVar.a(this.mq);
    }

    @Override // com.airbnb.lottie.a.a.a, com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.mn, matrix);
        if (this.mo == GradientType.Linear) {
            this.paint.setShader(ce());
        } else {
            this.paint.setShader(cf());
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

    private LinearGradient ce() {
        int cg = cg();
        LinearGradient linearGradient = this.mk.get(cg);
        if (linearGradient == null) {
            PointF value = this.mp.getValue();
            PointF value2 = this.mq.getValue();
            com.airbnb.lottie.model.content.c value3 = this.mj.getValue();
            LinearGradient linearGradient2 = new LinearGradient((int) (this.mn.left + (this.mn.width() / 2.0f) + value.x), (int) (value.y + this.mn.top + (this.mn.height() / 2.0f)), (int) (this.mn.left + (this.mn.width() / 2.0f) + value2.x), (int) (this.mn.top + (this.mn.height() / 2.0f) + value2.y), value3.getColors(), value3.dc(), Shader.TileMode.CLAMP);
            this.mk.put(cg, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient cf() {
        int cg = cg();
        RadialGradient radialGradient = this.ml.get(cg);
        if (radialGradient == null) {
            PointF value = this.mp.getValue();
            PointF value2 = this.mq.getValue();
            com.airbnb.lottie.model.content.c value3 = this.mj.getValue();
            int[] colors = value3.getColors();
            float[] dc = value3.dc();
            int width = (int) (this.mn.left + (this.mn.width() / 2.0f) + value.x);
            int height = (int) (value.y + this.mn.top + (this.mn.height() / 2.0f));
            float f = value2.y;
            RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(((int) ((this.mn.left + (this.mn.width() / 2.0f)) + value2.x)) - width, ((int) (f + (this.mn.top + (this.mn.height() / 2.0f)))) - height), colors, dc, Shader.TileMode.CLAMP);
            this.ml.put(cg, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int cg() {
        int round = Math.round(this.mp.getProgress() * this.mr);
        int round2 = Math.round(this.mq.getProgress() * this.mr);
        int round3 = Math.round(this.mj.getProgress() * this.mr);
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
