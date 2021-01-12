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
/* loaded from: classes3.dex */
public class g implements d, j, a.InterfaceC0007a {
    private final com.airbnb.lottie.f BH;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> DK;
    private final GradientType DR;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> DS;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> DT;
    private final int DU;
    private final com.airbnb.lottie.model.layer.a Ds;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Dw;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> Dz;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> DM = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> DN = new LongSparseArray<>();
    private final Matrix DO = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF DQ = new RectF();
    private final List<l> DA = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.Ds = aVar;
        this.name = dVar.getName();
        this.BH = fVar;
        this.DR = dVar.jo();
        this.path.setFillType(dVar.jp());
        this.DU = (int) (fVar.getComposition().hS() / 32.0f);
        this.DK = dVar.jq().jc();
        this.DK.b(this);
        aVar.a(this.DK);
        this.Dw = dVar.ji().jc();
        this.Dw.b(this);
        aVar.a(this.Dw);
        this.DS = dVar.jr().jc();
        this.DS.b(this);
        aVar.a(this.DS);
        this.DT = dVar.js().jc();
        this.DT.b(this);
        aVar.a(this.DT);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void is() {
        this.BH.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
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

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        Shader ix;
        com.airbnb.lottie.c.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.DA.size(); i2++) {
            this.path.addPath(this.DA.get(i2).iv(), matrix);
        }
        this.path.computeBounds(this.DQ, false);
        if (this.DR == GradientType.Linear) {
            ix = iw();
        } else {
            ix = ix();
        }
        this.DO.set(matrix);
        ix.setLocalMatrix(this.DO);
        this.paint.setShader(ix);
        if (this.Dz != null) {
            this.paint.setColorFilter(this.Dz.getValue());
        }
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.Dw.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.c.bb("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.DA.size(); i++) {
            this.path.addPath(this.DA.get(i).iv(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iw() {
        int iy = iy();
        LinearGradient linearGradient = this.DM.get(iy);
        if (linearGradient == null) {
            PointF value = this.DS.getValue();
            PointF value2 = this.DT.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DK.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.jn(), Shader.TileMode.CLAMP);
            this.DM.put(iy, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient ix() {
        int iy = iy();
        RadialGradient radialGradient = this.DN.get(iy);
        if (radialGradient == null) {
            PointF value = this.DS.getValue();
            PointF value2 = this.DT.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DK.getValue();
            int[] colors = value3.getColors();
            float[] jn = value3.jn();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, jn, Shader.TileMode.CLAMP);
            this.DN.put(iy, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iy() {
        int round = Math.round(this.DS.getProgress() * this.DU);
        int round2 = Math.round(this.DT.getProgress() * this.DU);
        int round3 = Math.round(this.DK.getProgress() * this.DU);
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
        if (t == com.airbnb.lottie.j.Db) {
            if (cVar == null) {
                this.Dz = null;
                return;
            }
            this.Dz = new com.airbnb.lottie.a.b.p(cVar);
            this.Dz.b(this);
            this.Ds.a(this.Dz);
        }
    }
}
