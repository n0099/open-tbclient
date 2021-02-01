package com.baidu.live.lottie.a.a;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class g implements d, j, a.InterfaceC0186a {
    private final int DU;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> bsA;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> bsB;
    private final com.baidu.live.lottie.model.layer.a bso;
    private final com.baidu.live.lottie.a.b.a<Integer, Integer> bsq;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> bss;
    private final com.baidu.live.lottie.a.b.a<com.baidu.live.lottie.model.content.c, com.baidu.live.lottie.model.content.c> bsy;
    private final GradientType bsz;
    private final com.baidu.live.lottie.h lottieDrawable;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> DM = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> DN = new LongSparseArray<>();
    private final Matrix DO = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF DQ = new RectF();
    private final List<l> DA = new ArrayList();

    public g(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.d dVar) {
        this.bso = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = hVar;
        this.bsz = dVar.ND();
        this.path.setFillType(dVar.jo());
        this.DU = (int) (hVar.getComposition().hR() / 32.0f);
        this.bsy = dVar.NE().Ns();
        this.bsy.b(this);
        aVar.a(this.bsy);
        this.bsq = dVar.Ny().Ns();
        this.bsq.b(this);
        aVar.a(this.bsq);
        this.bsA = dVar.NF().Ns();
        this.bsA.b(this);
        aVar.a(this.bsA);
        this.bsB = dVar.NG().Ns();
        this.bsB.b(this);
        aVar.a(this.bsB);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0186a
    public void ir() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.DA.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        Shader iw;
        com.baidu.live.lottie.d.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.DA.size(); i2++) {
            this.path.addPath(this.DA.get(i2).iu(), matrix);
        }
        this.path.computeBounds(this.DQ, false);
        if (this.bsz == GradientType.Linear) {
            iw = iv();
        } else {
            iw = iw();
        }
        this.DO.set(matrix);
        iw.setLocalMatrix(this.DO);
        this.paint.setShader(iw);
        if (this.bss != null) {
            this.paint.setColorFilter(this.bss.getValue());
        }
        this.paint.setAlpha(com.baidu.live.lottie.d.e.clamp((int) (((this.bsq.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.baidu.live.lottie.d.bb("GradientFillContent#draw");
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.DA.size(); i++) {
            this.path.addPath(this.DA.get(i).iu(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iv() {
        int ix = ix();
        LinearGradient linearGradient = this.DM.get(ix);
        if (linearGradient == null) {
            PointF value = this.bsA.getValue();
            PointF value2 = this.bsB.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.bsy.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.jm(), Shader.TileMode.CLAMP);
            this.DM.put(ix, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iw() {
        int ix = ix();
        RadialGradient radialGradient = this.DN.get(ix);
        if (radialGradient == null) {
            PointF value = this.bsA.getValue();
            PointF value2 = this.bsB.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.bsy.getValue();
            int[] colors = value3.getColors();
            float[] jm = value3.jm();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, jm, Shader.TileMode.CLAMP);
            this.DN.put(ix, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int ix() {
        int round = Math.round(this.bsA.getProgress() * this.DU);
        int round2 = Math.round(this.bsB.getProgress() * this.DU);
        int round3 = Math.round(this.bsy.getProgress() * this.DU);
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

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.Db) {
            if (cVar == null) {
                this.bss = null;
                return;
            }
            this.bss = new com.baidu.live.lottie.a.b.p(cVar);
            this.bss.b(this);
            this.bso.a(this.bss);
        }
    }
}
