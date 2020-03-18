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
    private final com.airbnb.lottie.model.layer.a fJ;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> fN;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> fQ;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> fZ;
    private final GradientType gf;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> gg;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> gh;
    private final int gi;
    private final com.airbnb.lottie.g lottieDrawable;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> gb = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> gc = new LongSparseArray<>();
    private final Matrix gd = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF ge = new RectF();
    private final List<l> fR = new ArrayList();

    public g(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.fJ = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = gVar;
        this.gf = dVar.cz();
        this.path.setFillType(dVar.cA());
        this.gi = (int) (gVar.getComposition().bg() / 32.0f);
        this.fZ = dVar.cB().cn();
        this.fZ.b(this);
        aVar.a(this.fZ);
        this.fN = dVar.ct().cn();
        this.fN.b(this);
        aVar.a(this.fN);
        this.gg = dVar.cC().cn();
        this.gg.b(this);
        aVar.a(this.gg);
        this.gh = dVar.cD().cn();
        this.gh.b(this);
        aVar.a(this.gh);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bD() {
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
                    this.fR.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader bI;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.fR.size(); i2++) {
            this.path.addPath(this.fR.get(i2).bG(), matrix);
        }
        this.path.computeBounds(this.ge, false);
        if (this.gf == GradientType.Linear) {
            bI = bH();
        } else {
            bI = bI();
        }
        this.gd.set(matrix);
        bI.setLocalMatrix(this.gd);
        this.paint.setShader(bI);
        if (this.fQ != null) {
            this.paint.setColorFilter(this.fQ.getValue());
        }
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.fN.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.d.F("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.fR.size(); i++) {
            this.path.addPath(this.fR.get(i).bG(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient bH() {
        int bJ = bJ();
        LinearGradient linearGradient = this.gb.get(bJ);
        if (linearGradient == null) {
            PointF value = this.gg.getValue();
            PointF value2 = this.gh.getValue();
            com.airbnb.lottie.model.content.c value3 = this.fZ.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.cy(), Shader.TileMode.CLAMP);
            this.gb.put(bJ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient bI() {
        int bJ = bJ();
        RadialGradient radialGradient = this.gc.get(bJ);
        if (radialGradient == null) {
            PointF value = this.gg.getValue();
            PointF value2 = this.gh.getValue();
            com.airbnb.lottie.model.content.c value3 = this.fZ.getValue();
            int[] colors = value3.getColors();
            float[] cy = value3.cy();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, cy, Shader.TileMode.CLAMP);
            this.gc.put(bJ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int bJ() {
        int round = Math.round(this.gg.getProgress() * this.gi);
        int round2 = Math.round(this.gh.getProgress() * this.gi);
        int round3 = Math.round(this.fZ.getProgress() * this.gi);
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
        if (t == com.airbnb.lottie.k.fo) {
            if (cVar == null) {
                this.fQ = null;
                return;
            }
            this.fQ = new com.airbnb.lottie.a.b.p(cVar);
            this.fQ.b(this);
            this.fJ.a(this.fQ);
        }
    }
}
