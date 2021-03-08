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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g implements d, j, a.InterfaceC0013a {
    private final com.airbnb.lottie.f Df;
    private final com.airbnb.lottie.model.layer.a EO;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> ET;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> EW;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> Ff;
    private final GradientType Fk;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Fl;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Fm;
    private final int Fn;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> Fg = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> Fh = new LongSparseArray<>();
    private final Matrix Fi = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF Fj = new RectF();
    private final List<l> EX = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.EO = aVar;
        this.name = dVar.getName();
        this.Df = fVar;
        this.Fk = dVar.jn();
        this.path.setFillType(dVar.jo());
        this.Fn = (int) (fVar.getComposition().hR() / 32.0f);
        this.Ff = dVar.jp().jb();
        this.Ff.b(this);
        aVar.a(this.Ff);
        this.ET = dVar.jh().jb();
        this.ET.b(this);
        aVar.a(this.ET);
        this.Fl = dVar.jq().jb();
        this.Fl.b(this);
        aVar.a(this.Fl);
        this.Fm = dVar.jr().jb();
        this.Fm.b(this);
        aVar.a(this.Fm);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0013a
    public void ir() {
        this.Df.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
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

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        Shader iw;
        com.airbnb.lottie.c.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.EX.size(); i2++) {
            this.path.addPath(this.EX.get(i2).iu(), matrix);
        }
        this.path.computeBounds(this.Fj, false);
        if (this.Fk == GradientType.Linear) {
            iw = iv();
        } else {
            iw = iw();
        }
        this.Fi.set(matrix);
        iw.setLocalMatrix(this.Fi);
        this.paint.setShader(iw);
        if (this.EW != null) {
            this.paint.setColorFilter(this.EW.getValue());
        }
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.ET.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.c.bf("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.EX.size(); i++) {
            this.path.addPath(this.EX.get(i).iu(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iv() {
        int ix = ix();
        LinearGradient linearGradient = this.Fg.get(ix);
        if (linearGradient == null) {
            PointF value = this.Fl.getValue();
            PointF value2 = this.Fm.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Ff.getValue();
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
            PointF value = this.Fl.getValue();
            PointF value2 = this.Fm.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Ff.getValue();
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
        int round = Math.round(this.Fl.getProgress() * this.Fn);
        int round2 = Math.round(this.Fm.getProgress() * this.Fn);
        int round3 = Math.round(this.Ff.getProgress() * this.Fn);
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
        if (t == com.airbnb.lottie.j.Ex) {
            if (cVar == null) {
                this.EW = null;
                return;
            }
            this.EW = new com.airbnb.lottie.a.b.p(cVar);
            this.EW.b(this);
            this.EO.a(this.EW);
        }
    }
}
