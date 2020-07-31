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
/* loaded from: classes20.dex */
public class g implements d, j, a.InterfaceC0010a {
    private final com.airbnb.lottie.model.layer.a BO;
    private final com.airbnb.lottie.a.b.a<Integer, Integer> BS;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> BV;
    private final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> Ce;
    private final GradientType Cj;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Ck;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> Cl;
    private final int Cm;
    private final com.airbnb.lottie.g lottieDrawable;
    @NonNull
    private final String name;
    private final LongSparseArray<LinearGradient> Cf = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> Cg = new LongSparseArray<>();
    private final Matrix Ch = new Matrix();
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final RectF Ci = new RectF();
    private final List<l> BW = new ArrayList();

    public g(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        this.BO = aVar;
        this.name = dVar.getName();
        this.lottieDrawable = gVar;
        this.Cj = dVar.in();
        this.path.setFillType(dVar.ip());
        this.Cm = (int) (gVar.getComposition().gT() / 32.0f);
        this.Ce = dVar.iq().ia();
        this.Ce.b(this);
        aVar.a(this.Ce);
        this.BS = dVar.ih().ia();
        this.BS.b(this);
        aVar.a(this.BS);
        this.Ck = dVar.ir().ia();
        this.Ck.b(this);
        aVar.a(this.Ck);
        this.Cl = dVar.is().ia();
        this.Cl.b(this);
        aVar.a(this.Cl);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void hq() {
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
                    this.BW.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader hv;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.BW.size(); i2++) {
            this.path.addPath(this.BW.get(i2).ht(), matrix);
        }
        this.path.computeBounds(this.Ci, false);
        if (this.Cj == GradientType.Linear) {
            hv = hu();
        } else {
            hv = hv();
        }
        this.Ch.set(matrix);
        hv.setLocalMatrix(this.Ch);
        this.paint.setShader(hv);
        if (this.BV != null) {
            this.paint.setColorFilter(this.BV.getValue());
        }
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.BS.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        com.airbnb.lottie.d.aW("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.BW.size(); i++) {
            this.path.addPath(this.BW.get(i).ht(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private LinearGradient hu() {
        int hw = hw();
        LinearGradient linearGradient = this.Cf.get(hw);
        if (linearGradient == null) {
            PointF value = this.Ck.getValue();
            PointF value2 = this.Cl.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Ce.getValue();
            LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.im(), Shader.TileMode.CLAMP);
            this.Cf.put(hw, linearGradient2);
            return linearGradient2;
        }
        return linearGradient;
    }

    private RadialGradient hv() {
        int hw = hw();
        RadialGradient radialGradient = this.Cg.get(hw);
        if (radialGradient == null) {
            PointF value = this.Ck.getValue();
            PointF value2 = this.Cl.getValue();
            com.airbnb.lottie.model.content.c value3 = this.Ce.getValue();
            int[] colors = value3.getColors();
            float[] im = value3.im();
            float f = value.x;
            float f2 = value.y;
            RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(value2.x - f, value2.y - f2), colors, im, Shader.TileMode.CLAMP);
            this.Cg.put(hw, radialGradient2);
            return radialGradient2;
        }
        return radialGradient;
    }

    private int hw() {
        int round = Math.round(this.Ck.getProgress() * this.Cm);
        int round2 = Math.round(this.Cl.getProgress() * this.Cm);
        int round3 = Math.round(this.Ce.getProgress() * this.Cm);
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
        if (t == com.airbnb.lottie.k.Bx) {
            if (cVar == null) {
                this.BV = null;
                return;
            }
            this.BV = new com.airbnb.lottie.a.b.p(cVar);
            this.BV.b(this);
            this.BO.a(this.BV);
        }
    }
}
