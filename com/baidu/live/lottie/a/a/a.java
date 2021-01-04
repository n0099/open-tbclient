package com.baidu.live.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a implements d, j, a.InterfaceC0194a {
    private final float[] Dw;
    private final List<com.baidu.live.lottie.a.b.a<?, Float>> Dz;
    private final com.baidu.live.lottie.model.layer.a btA;
    private final com.baidu.live.lottie.a.b.a<?, Float> btB;
    private final com.baidu.live.lottie.a.b.a<?, Integer> btC;
    @Nullable
    private final com.baidu.live.lottie.a.b.a<?, Float> btD;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> btE;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final PathMeasure Ds = new PathMeasure();
    private final Path path = new Path();
    private final Path Dt = new Path();
    private final RectF rect = new RectF();
    private final List<C0193a> Dv = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.b bVar, List<com.baidu.live.lottie.model.a.b> list, com.baidu.live.lottie.model.a.b bVar2) {
        this.lottieDrawable = hVar;
        this.btA = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.btC = dVar.PP();
        this.btB = bVar.PP();
        if (bVar2 == null) {
            this.btD = null;
        } else {
            this.btD = bVar2.PP();
        }
        this.Dz = new ArrayList(list.size());
        this.Dw = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.Dz.add(list.get(i).PP());
        }
        aVar.a(this.btC);
        aVar.a(this.btB);
        for (int i2 = 0; i2 < this.Dz.size(); i2++) {
            aVar.a(this.Dz.get(i2));
        }
        if (this.btD != null) {
            aVar.a(this.btD);
        }
        this.btC.b(this);
        this.btB.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.Dz.get(i3).b(this);
        }
        if (this.btD != null) {
            this.btD.b(this);
        }
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0194a
    public void is() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        C0193a c0193a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).PF() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0193a c0193a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).PF() == ShapeTrimPath.Type.Individually) {
                if (c0193a2 != null) {
                    this.Dv.add(c0193a2);
                }
                C0193a c0193a3 = new C0193a((r) bVar2);
                ((r) bVar2).a(this);
                c0193a = c0193a3;
            } else if (bVar2 instanceof l) {
                c0193a = c0193a2 == null ? new C0193a(rVar) : c0193a2;
                c0193a.DD.add((l) bVar2);
            } else {
                c0193a = c0193a2;
            }
            size2--;
            c0193a2 = c0193a;
        }
        if (c0193a2 != null) {
            this.Dv.add(c0193a2);
        }
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.baidu.live.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.baidu.live.lottie.d.e.clamp((int) (((this.btC.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.btB.getValue().floatValue() * com.baidu.live.lottie.d.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.baidu.live.lottie.d.bb("StrokeContent#draw");
            return;
        }
        b(matrix);
        if (this.btE != null) {
            this.paint.setColorFilter(this.btE.getValue());
        }
        for (int i2 = 0; i2 < this.Dv.size(); i2++) {
            C0193a c0193a = this.Dv.get(i2);
            if (c0193a.btF != null) {
                a(canvas, c0193a, matrix);
            } else {
                com.baidu.live.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0193a.DD.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0193a.DD.get(size)).iv(), matrix);
                }
                com.baidu.live.lottie.d.bb("StrokeContent#buildPath");
                com.baidu.live.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.baidu.live.lottie.d.bb("StrokeContent#drawPath");
            }
        }
        com.baidu.live.lottie.d.bb("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0193a c0193a, Matrix matrix) {
        float f;
        com.baidu.live.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0193a.btF == null) {
            com.baidu.live.lottie.d.bb("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0193a.DD.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0193a.DD.get(size)).iv(), matrix);
        }
        this.Ds.setPath(this.path, false);
        float length = this.Ds.getLength();
        while (true) {
            f = length;
            if (!this.Ds.nextContour()) {
                break;
            }
            length = this.Ds.getLength() + f;
        }
        float floatValue = (c0193a.btF.PI().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0193a.btF.PG().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0193a.btF.PH().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0193a.DD.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.Dt.set(((l) c0193a.DD.get(size2)).iv());
            this.Dt.transform(matrix);
            this.Ds.setPath(this.Dt, false);
            float length2 = this.Ds.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.baidu.live.lottie.d.f.b(this.Dt, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.Dt, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.Dt, this.paint);
                } else {
                    com.baidu.live.lottie.d.f.b(this.Dt, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.Dt, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.baidu.live.lottie.d.bb("StrokeContent#applyTrimPath");
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        com.baidu.live.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.Dv.size(); i++) {
            C0193a c0193a = this.Dv.get(i);
            for (int i2 = 0; i2 < c0193a.DD.size(); i2++) {
                this.path.addPath(((l) c0193a.DD.get(i2)).iv(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.btB.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.baidu.live.lottie.d.bb("StrokeContent#getBounds");
    }

    private void b(Matrix matrix) {
        com.baidu.live.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.Dz.isEmpty()) {
            com.baidu.live.lottie.d.bb("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.baidu.live.lottie.d.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Dz.size()) {
                break;
            }
            this.Dw[i2] = this.Dz.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.Dw[i2] < 1.0f) {
                    this.Dw[i2] = 1.0f;
                }
            } else if (this.Dw[i2] < 0.1f) {
                this.Dw[i2] = 0.1f;
            }
            float[] fArr = this.Dw;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.Dw, this.btD == null ? 0.0f : this.btD.getValue().floatValue()));
        com.baidu.live.lottie.d.bb("StrokeContent#applyDashPattern");
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.CE) {
            this.btC.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CL) {
            this.btB.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Dd) {
            if (cVar == null) {
                this.btE = null;
                return;
            }
            this.btE = new com.baidu.live.lottie.a.b.p(cVar);
            this.btE.b(this);
            this.btA.a(this.btE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0193a {
        private final List<l> DD;
        @Nullable
        private final r btF;

        private C0193a(@Nullable r rVar) {
            this.DD = new ArrayList();
            this.btF = rVar;
        }
    }
}
