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
/* loaded from: classes18.dex */
public class g implements d, j, a.InterfaceC0010a {
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> CJ;
    private final GradientType CP;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> CQ;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> CV;
    private final int CW;
    private final com.airbnb.lottie.model.layer.a Cs;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> Cw;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> Cz;
    private final com.airbnb.lottie.g lottieDrawable;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> CK = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> CL = new LongSparseArray<>();
    private final Matrix CN = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF CO = new RectF();
    private final List<l> CB = new ArrayList();

    public g(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.Cs = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = gVar;
        this.CP = dVar.jN();
        this.path.setFillType(dVar.jO());
        this.CW = (int) (gVar.getComposition().iu() / 32.0f);
        this.CJ = dVar.jP().jB();
        this.CJ.b(this);
        aVar.a(this.CJ);
        this.Cw = dVar.jH().jB();
        this.Cw.b(this);
        aVar.a(this.Cw);
        this.CQ = dVar.jQ().jB();
        this.CQ.b(this);
        aVar.a(this.CQ);
        this.CV = dVar.jR().jB();
        this.CV.b(this);
        aVar.a(this.CV);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void iR() {
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
                    this.CB.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader iW;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.CB.size(); i2++) {
            this.path.addPath(this.CB.get(i2).iU(), matrix);
        }
        this.path.computeBounds(this.CO, false);
        if (this.CP == GradientType.Linear) {
            iW = iV();
        } else {
            iW = iW();
        }
        this.CN.set(matrix);
        iW.setLocalMatrix(this.CN);
        this.paint.setShader(iW);
        if (this.Cz != null) {
            this.paint.setColorFilter(this.Cz.getValue());
        }
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.Cw.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.d.bb("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.CB.size(); i++) {
            this.path.addPath(this.CB.get(i).iU(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient iV() {
        int iX = iX();
        LinearGradient linearGradient = this.CK.get(iX);
        if (linearGradient == null) {
            PointF value = this.CQ.getValue();
            PointF value2 = this.CV.getValue();
            com.airbnb.lottie.model.content.c value3 = this.CJ.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.jM(), Shader.TileMode.CLAMP);
            this.CK.put(iX, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient iW() {
        int iX = iX();
        RadialGradient radialGradient = this.CL.get(iX);
        if (radialGradient == null) {
            PointF value = this.CQ.getValue();
            PointF value2 = this.CV.getValue();
            com.airbnb.lottie.model.content.c value3 = this.CJ.getValue();
            int[] colors = value3.getColors();
            float[] jM = value3.jM();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, jM, Shader.TileMode.CLAMP);
            this.CL.put(iX, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int iX() {
        int round = Math.round(this.CQ.getProgress() * this.CW);
        int round2 = Math.round(this.CV.getProgress() * this.CW);
        int round3 = Math.round(this.CJ.getProgress() * this.CW);
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
        if (t == com.airbnb.lottie.k.Cb) {
            if (cVar == null) {
                this.Cz = null;
                return;
            }
            this.Cz = new com.airbnb.lottie.a.b.p(cVar);
            this.Cz.b(this);
            this.Cs.a(this.Cz);
        }
    }
}
