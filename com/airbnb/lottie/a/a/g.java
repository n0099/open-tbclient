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
    private final com.airbnb.lottie.f BJ;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> DC;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> DN;
    private final GradientType DT;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> DU;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> DV;
    private final int DW;
    private final com.airbnb.lottie.model.layer.a Du;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Dy;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> DO = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> DQ = new LongSparseArray<>();
    private final Matrix DR = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF DS = new RectF();
    private final List<l> DD = new ArrayList();

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.Du = aVar;
        this.name = dVar.getName();
        this.BJ = fVar;
        this.DT = dVar.jo();
        this.path.setFillType(dVar.jp());
        this.DW = (int) (fVar.getComposition().hS() / 32.0f);
        this.DN = dVar.jq().jc();
        this.DN.b(this);
        aVar.a(this.DN);
        this.Dy = dVar.ji().jc();
        this.Dy.b(this);
        aVar.a(this.Dy);
        this.DU = dVar.jr().jc();
        this.DU.b(this);
        aVar.a(this.DU);
        this.DV = dVar.js().jc();
        this.DV.b(this);
        aVar.a(this.DV);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void is() {
        this.BJ.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.DD.add((l) bVar);
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
        for (int i2 = 0; i2 < this.DD.size(); i2++) {
            this.path.addPath(this.DD.get(i2).iv(), matrix);
        }
        this.path.computeBounds(this.DS, false);
        if (this.DT == GradientType.Linear) {
            ix = iw();
        } else {
            ix = ix();
        }
        this.DR.set(matrix);
        ix.setLocalMatrix(this.DR);
        this.paint.setShader(ix);
        if (this.DC != null) {
            this.paint.setColorFilter(this.DC.getValue());
        }
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.Dy.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.c.bb("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.DD.size(); i++) {
            this.path.addPath(this.DD.get(i).iv(), matrix);
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
        LinearGradient linearGradient = this.DO.get(iy);
        if (linearGradient == null) {
            PointF value = this.DU.getValue();
            PointF value2 = this.DV.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DN.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.jn(), Shader.TileMode.CLAMP);
            this.DO.put(iy, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient ix() {
        int iy = iy();
        RadialGradient radialGradient = this.DQ.get(iy);
        if (radialGradient == null) {
            PointF value = this.DU.getValue();
            PointF value2 = this.DV.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DN.getValue();
            int[] colors = value3.getColors();
            float[] jn = value3.jn();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, jn, Shader.TileMode.CLAMP);
            this.DQ.put(iy, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iy() {
        int round = Math.round(this.DU.getProgress() * this.DW);
        int round2 = Math.round(this.DV.getProgress() * this.DW);
        int round3 = Math.round(this.DN.getProgress() * this.DW);
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
        if (t == com.airbnb.lottie.j.Dd) {
            if (cVar == null) {
                this.DC = null;
                return;
            }
            this.DC = new com.airbnb.lottie.a.b.p(cVar);
            this.DC.b(this);
            this.Du.a(this.DC);
        }
    }
}
