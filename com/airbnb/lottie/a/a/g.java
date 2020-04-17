package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g implements d, j, a.InterfaceC0010a {
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> BC;
    private final GradientType BH;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> BI;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> BJ;
    private final int BK;
    private final com.airbnb.lottie.model.layer.a Bm;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Bq;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> Bt;
    private final com.airbnb.lottie.g lottieDrawable;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> BD = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> BE = new LongSparseArray<>();
    private final Matrix BF = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF BG = new RectF();
    private final List<l> Bu = new ArrayList();

    public g(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.Bm = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = gVar;
        this.BH = dVar.hW();
        this.path.setFillType(dVar.hX());
        this.BK = (int) (gVar.getComposition().gD() / 32.0f);
        this.BC = dVar.hY().hK();
        this.BC.b(this);
        aVar.a(this.BC);
        this.Bq = dVar.hQ().hK();
        this.Bq.b(this);
        aVar.a(this.Bq);
        this.BI = dVar.hZ().hK();
        this.BI.b(this);
        aVar.a(this.BI);
        this.BJ = dVar.ia().hK();
        this.BJ.b(this);
        aVar.a(this.BJ);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void ha() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.Bu.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader hf;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.Bu.size(); i2++) {
            this.path.addPath(this.Bu.get(i2).hd(), matrix);
        }
        this.path.computeBounds(this.BG, false);
        if (this.BH == GradientType.Linear) {
            hf = he();
        } else {
            hf = hf();
        }
        this.BF.set(matrix);
        hf.setLocalMatrix(this.BF);
        this.paint.setShader(hf);
        if (this.Bt != null) {
            this.paint.setColorFilter(this.Bt.getValue());
        }
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.Bq.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.d.aV("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.Bu.size(); i++) {
            this.path.addPath(this.Bu.get(i).hd(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient he() {
        int hg = hg();
        LinearGradient linearGradient = this.BD.get(hg);
        if (linearGradient == null) {
            PointF value = this.BI.getValue();
            PointF value2 = this.BJ.getValue();
            com.airbnb.lottie.model.content.c value3 = this.BC.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.hV(), Shader.TileMode.CLAMP);
            this.BD.put(hg, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient hf() {
        int hg = hg();
        RadialGradient radialGradient = this.BE.get(hg);
        if (radialGradient == null) {
            PointF value = this.BI.getValue();
            PointF value2 = this.BJ.getValue();
            com.airbnb.lottie.model.content.c value3 = this.BC.getValue();
            int[] colors = value3.getColors();
            float[] hV = value3.hV();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, hV, Shader.TileMode.CLAMP);
            this.BE.put(hg, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int hg() {
        int round = Math.round(this.BI.getProgress() * this.BK);
        int round2 = Math.round(this.BJ.getProgress() * this.BK);
        int round3 = Math.round(this.BC.getProgress() * this.BK);
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

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.AV) {
            if (cVar == null) {
                this.Bt = null;
                return;
            }
            this.Bt = new com.airbnb.lottie.a.b.p(cVar);
            this.Bt.b(this);
            this.Bm.a(this.Bt);
        }
    }
}
