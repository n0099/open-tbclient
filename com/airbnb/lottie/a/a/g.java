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
/* loaded from: classes7.dex */
public class g implements d, j, a.InterfaceC0011a {
    private final com.airbnb.lottie.model.layer.a DH;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> DM;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> DQ;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> DZ;
    private final GradientType Ee;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Ef;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Eg;
    private final int Eh;
    private final com.airbnb.lottie.g lottieDrawable;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> Ea = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> Eb = new LongSparseArray<>();
    private final Matrix Ec = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF Ed = new RectF();
    private final List<l> DR = new ArrayList();

    public g(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.DH = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = gVar;
        this.Ee = dVar.jP();
        this.path.setFillType(dVar.jQ());
        this.Eh = (int) (gVar.getComposition().iv() / 32.0f);
        this.DZ = dVar.jR().jD();
        this.DZ.b(this);
        aVar.a(this.DZ);
        this.DM = dVar.jJ().jD();
        this.DM.b(this);
        aVar.a(this.DM);
        this.Ef = dVar.jS().jD();
        this.Ef.b(this);
        aVar.a(this.Ef);
        this.Eg = dVar.jT().jD();
        this.Eg.b(this);
        aVar.a(this.Eg);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0011a
    public void iT() {
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
                    this.DR.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader iY;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.DR.size(); i2++) {
            this.path.addPath(this.DR.get(i2).iW(), matrix);
        }
        this.path.computeBounds(this.Ed, false);
        if (this.Ee == GradientType.Linear) {
            iY = iX();
        } else {
            iY = iY();
        }
        this.Ec.set(matrix);
        iY.setLocalMatrix(this.Ec);
        this.paint.setShader(iY);
        if (this.DQ != null) {
            this.paint.setColorFilter(this.DQ.getValue());
        }
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.DM.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.d.be("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.DR.size(); i++) {
            this.path.addPath(this.DR.get(i).iW(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iX() {
        int iZ = iZ();
        LinearGradient linearGradient = this.Ea.get(iZ);
        if (linearGradient == null) {
            PointF value = this.Ef.getValue();
            PointF value2 = this.Eg.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DZ.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.jO(), Shader.TileMode.CLAMP);
            this.Ea.put(iZ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iY() {
        int iZ = iZ();
        RadialGradient radialGradient = this.Eb.get(iZ);
        if (radialGradient == null) {
            PointF value = this.Ef.getValue();
            PointF value2 = this.Eg.getValue();
            com.airbnb.lottie.model.content.c value3 = this.DZ.getValue();
            int[] colors = value3.getColors();
            float[] jO = value3.jO();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, jO, Shader.TileMode.CLAMP);
            this.Eb.put(iZ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iZ() {
        int round = Math.round(this.Ef.getProgress() * this.Eh);
        int round2 = Math.round(this.Eg.getProgress() * this.Eh);
        int round3 = Math.round(this.DZ.getProgress() * this.Eh);
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
        if (t == com.airbnb.lottie.k.Do) {
            if (cVar == null) {
                this.DQ = null;
                return;
            }
            this.DQ = new com.airbnb.lottie.a.b.p(cVar);
            this.DQ.b(this);
            this.DH.a(this.DQ);
        }
    }
}
