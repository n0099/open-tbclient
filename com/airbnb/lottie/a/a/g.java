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
/* loaded from: classes10.dex */
public class g implements d, j, a.InterfaceC0011a {
    private final com.airbnb.lottie.model.layer.a CK;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> CP;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> CW;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> Df;
    private final GradientType Dk;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Dl;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Dm;
    private final int Dn;
    private final com.airbnb.lottie.g lottieDrawable;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> Dg = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> Dh = new LongSparseArray<>();
    private final Matrix Di = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF Dj = new RectF();
    private final List<l> CX = new ArrayList();

    public g(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.CK = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = gVar;
        this.Dk = dVar.jP();
        this.path.setFillType(dVar.jQ());
        this.Dn = (int) (gVar.getComposition().iv() / 32.0f);
        this.Df = dVar.jR().jD();
        this.Df.b(this);
        aVar.a(this.Df);
        this.CP = dVar.jJ().jD();
        this.CP.b(this);
        aVar.a(this.CP);
        this.Dl = dVar.jS().jD();
        this.Dl.b(this);
        aVar.a(this.Dl);
        this.Dm = dVar.jT().jD();
        this.Dm.b(this);
        aVar.a(this.Dm);
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
                    this.CX.add((l) bVar);
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
        for (int i2 = 0; i2 < this.CX.size(); i2++) {
            this.path.addPath(this.CX.get(i2).iW(), matrix);
        }
        this.path.computeBounds(this.Dj, false);
        if (this.Dk == GradientType.Linear) {
            iY = iX();
        } else {
            iY = iY();
        }
        this.Di.set(matrix);
        iY.setLocalMatrix(this.Di);
        this.paint.setShader(iY);
        if (this.CW != null) {
            this.paint.setColorFilter(this.CW.getValue());
        }
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.CP.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.d.bb("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.CX.size(); i++) {
            this.path.addPath(this.CX.get(i).iW(), matrix);
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
        LinearGradient linearGradient = this.Dg.get(iZ);
        if (linearGradient == null) {
            PointF value = this.Dl.getValue();
            PointF value2 = this.Dm.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Df.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.jO(), Shader.TileMode.CLAMP);
            this.Dg.put(iZ, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iY() {
        int iZ = iZ();
        RadialGradient radialGradient = this.Dh.get(iZ);
        if (radialGradient == null) {
            PointF value = this.Dl.getValue();
            PointF value2 = this.Dm.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Df.getValue();
            int[] colors = value3.getColors();
            float[] jO = value3.jO();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, jO, Shader.TileMode.CLAMP);
            this.Dh.put(iZ, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iZ() {
        int round = Math.round(this.Dl.getProgress() * this.Dn);
        int round2 = Math.round(this.Dm.getProgress() * this.Dn);
        int round3 = Math.round(this.Df.getProgress() * this.Dn);
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
        if (t == com.airbnb.lottie.k.Cs) {
            if (cVar == null) {
                this.CW = null;
                return;
            }
            this.CW = new com.airbnb.lottie.a.b.p(cVar);
            this.CW.b(this);
            this.CK.a(this.CW);
        }
    }
}
