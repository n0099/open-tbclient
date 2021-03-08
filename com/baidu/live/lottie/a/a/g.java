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
/* loaded from: classes9.dex */
public class g implements d, j, a.InterfaceC0192a {
    private final int Fn;
    private final com.baidu.live.lottie.model.layer.a btP;
    private final com.baidu.live.lottie.a.b.a<Integer, Integer> btR;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> btT;
    private final com.baidu.live.lottie.a.b.a<com.baidu.live.lottie.model.content.c, com.baidu.live.lottie.model.content.c> btZ;
    private final GradientType bua;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> bub;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> buc;
    private final com.baidu.live.lottie.h lottieDrawable;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> Fg = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> Fh = new LongSparseArray<>();
    private final Matrix Fi = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF Fj = new RectF();
    private final List<l> EX = new ArrayList();

    public g(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.d dVar) {
        this.btP = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = hVar;
        this.bua = dVar.NG();
        this.path.setFillType(dVar.jo());
        this.Fn = (int) (hVar.getComposition().hR() / 32.0f);
        this.btZ = dVar.NH().Nv();
        this.btZ.b(this);
        aVar.a(this.btZ);
        this.btR = dVar.NB().Nv();
        this.btR.b(this);
        aVar.a(this.btR);
        this.bub = dVar.NI().Nv();
        this.bub.b(this);
        aVar.a(this.bub);
        this.buc = dVar.NJ().Nv();
        this.buc.b(this);
        aVar.a(this.buc);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0192a
    public void ir() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.EX.add((l) bVar);
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
        for (int i2 = 0; i2 < this.EX.size(); i2++) {
            this.path.addPath(this.EX.get(i2).iu(), matrix);
        }
        this.path.computeBounds(this.Fj, false);
        if (this.bua == GradientType.Linear) {
            iw = iv();
        } else {
            iw = iw();
        }
        this.Fi.set(matrix);
        iw.setLocalMatrix(this.Fi);
        this.paint.setShader(iw);
        if (this.btT != null) {
            this.paint.setColorFilter(this.btT.getValue());
        }
        this.paint.setAlpha(com.baidu.live.lottie.d.e.clamp((int) (((this.btR.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.baidu.live.lottie.d.bf("GradientFillContent#draw");
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.EX.size(); i++) {
            this.path.addPath(this.EX.get(i).iu(), matrix);
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
        LinearGradient linearGradient = this.Fg.get(ix);
        if (linearGradient == null) {
            PointF value = this.bub.getValue();
            PointF value2 = this.buc.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.btZ.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.jm(), Shader.TileMode.CLAMP);
            this.Fg.put(ix, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iw() {
        int ix = ix();
        RadialGradient radialGradient = this.Fh.get(ix);
        if (radialGradient == null) {
            PointF value = this.bub.getValue();
            PointF value2 = this.buc.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.btZ.getValue();
            int[] colors = value3.getColors();
            float[] jm = value3.jm();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, jm, Shader.TileMode.CLAMP);
            this.Fh.put(ix, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int ix() {
        int round = Math.round(this.bub.getProgress() * this.Fn);
        int round2 = Math.round(this.buc.getProgress() * this.Fn);
        int round3 = Math.round(this.btZ.getProgress() * this.Fn);
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
        if (t == com.baidu.live.lottie.l.Ex) {
            if (cVar == null) {
                this.btT = null;
                return;
            }
            this.btT = new com.baidu.live.lottie.a.b.p(cVar);
            this.btT.b(this);
            this.btP.a(this.btT);
        }
    }
}
