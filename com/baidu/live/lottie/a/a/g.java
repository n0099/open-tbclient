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
public class g implements d, j, a.InterfaceC0194a {
    private final int DW;
    private final com.baidu.live.lottie.model.layer.a btA;
    private final com.baidu.live.lottie.a.b.a<Integer, Integer> btC;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> btE;
    private final com.baidu.live.lottie.a.b.a<com.baidu.live.lottie.model.content.c, com.baidu.live.lottie.model.content.c> btK;
    private final GradientType btL;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> btM;
    private final com.baidu.live.lottie.a.b.a<PointF, PointF> btN;
    private final com.baidu.live.lottie.h lottieDrawable;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> DO = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> DQ = new LongSparseArray<>();
    private final Matrix DR = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF DS = new RectF();
    private final List<l> DD = new ArrayList();

    public g(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.d dVar) {
        this.btA = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = hVar;
        this.btL = dVar.Qa();
        this.path.setFillType(dVar.jp());
        this.DW = (int) (hVar.getComposition().hS() / 32.0f);
        this.btK = dVar.Qb().PP();
        this.btK.b(this);
        aVar.a(this.btK);
        this.btC = dVar.PV().PP();
        this.btC.b(this);
        aVar.a(this.btC);
        this.btM = dVar.Qc().PP();
        this.btM.b(this);
        aVar.a(this.btM);
        this.btN = dVar.Qd().PP();
        this.btN.b(this);
        aVar.a(this.btN);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0194a
    public void is() {
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
                    this.DD.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        Shader ix;
        com.baidu.live.lottie.d.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.DD.size(); i2++) {
            this.path.addPath(this.DD.get(i2).iv(), matrix);
        }
        this.path.computeBounds(this.DS, false);
        if (this.btL == GradientType.Linear) {
            ix = iw();
        } else {
            ix = ix();
        }
        this.DR.set(matrix);
        ix.setLocalMatrix(this.DR);
        this.paint.setShader(ix);
        if (this.btE != null) {
            this.paint.setColorFilter(this.btE.getValue());
        }
        this.paint.setAlpha(com.baidu.live.lottie.d.e.clamp((int) (((this.btC.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.baidu.live.lottie.d.bb("GradientFillContent#draw");
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.DD.size(); i++) {
            this.path.addPath(this.DD.get(i).iv(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iw() {
        int iy = iy();
        LinearGradient linearGradient = this.DO.get(iy);
        if (linearGradient == null) {
            PointF value = this.btM.getValue();
            PointF value2 = this.btN.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.btK.getValue();
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
            PointF value = this.btM.getValue();
            PointF value2 = this.btN.getValue();
            com.baidu.live.lottie.model.content.c value3 = this.btK.getValue();
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
        int round = Math.round(this.btM.getProgress() * this.DW);
        int round2 = Math.round(this.btN.getProgress() * this.DW);
        int round3 = Math.round(this.btK.getProgress() * this.DW);
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
        if (t == com.baidu.live.lottie.l.Dd) {
            if (cVar == null) {
                this.btE = null;
                return;
            }
            this.btE = new com.baidu.live.lottie.a.b.p(cVar);
            this.btE.b(this);
            this.btA.a(this.btE);
        }
    }
}
