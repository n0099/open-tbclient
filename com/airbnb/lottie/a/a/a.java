package com.airbnb.lottie.a.a;

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
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a implements d, j, a.InterfaceC0007a {
    private final com.airbnb.lottie.f BJ;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> DA;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> DC;
    private final com.airbnb.lottie.model.layer.a Du;
    private final float[] Dw;
    private final com.airbnb.lottie.a.b.a<?, Float> Dx;
    private final com.airbnb.lottie.a.b.a<?, Integer> Dy;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> Dz;
    private final PathMeasure Ds = new PathMeasure();
    private final Path path = new Path();
    private final Path Dt = new Path();
    private final RectF rect = new RectF();
    private final List<C0006a> Dv = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.BJ = fVar;
        this.Du = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.Dy = dVar.jc();
        this.Dx = bVar.jc();
        if (bVar2 == null) {
            this.DA = null;
        } else {
            this.DA = bVar2.jc();
        }
        this.Dz = new ArrayList(list.size());
        this.Dw = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.Dz.add(list.get(i).jc());
        }
        aVar.a(this.Dy);
        aVar.a(this.Dx);
        for (int i2 = 0; i2 < this.Dz.size(); i2++) {
            aVar.a(this.Dz.get(i2));
        }
        if (this.DA != null) {
            aVar.a(this.DA);
        }
        this.Dy.b(this);
        this.Dx.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.Dz.get(i3).b(this);
        }
        if (this.DA != null) {
            this.DA.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void is() {
        this.BJ.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        C0006a c0006a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).iC() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0006a c0006a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).iC() == ShapeTrimPath.Type.Individually) {
                if (c0006a2 != null) {
                    this.Dv.add(c0006a2);
                }
                C0006a c0006a3 = new C0006a((r) bVar2);
                ((r) bVar2).a(this);
                c0006a = c0006a3;
            } else if (bVar2 instanceof l) {
                c0006a = c0006a2 == null ? new C0006a(rVar) : c0006a2;
                c0006a.DD.add((l) bVar2);
            } else {
                c0006a = c0006a2;
            }
            size2--;
            c0006a2 = c0006a;
        }
        if (c0006a2 != null) {
            this.Dv.add(c0006a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.Dy.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.Dx.getValue().floatValue() * com.airbnb.lottie.d.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.c.bb("StrokeContent#draw");
            return;
        }
        b(matrix);
        if (this.DC != null) {
            this.paint.setColorFilter(this.DC.getValue());
        }
        for (int i2 = 0; i2 < this.Dv.size(); i2++) {
            C0006a c0006a = this.Dv.get(i2);
            if (c0006a.DE != null) {
                a(canvas, c0006a, matrix);
            } else {
                com.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0006a.DD.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0006a.DD.get(size)).iv(), matrix);
                }
                com.airbnb.lottie.c.bb("StrokeContent#buildPath");
                com.airbnb.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.airbnb.lottie.c.bb("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.c.bb("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0006a c0006a, Matrix matrix) {
        float f;
        com.airbnb.lottie.c.beginSection("StrokeContent#applyTrimPath");
        if (c0006a.DE == null) {
            com.airbnb.lottie.c.bb("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0006a.DD.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0006a.DD.get(size)).iv(), matrix);
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
        float floatValue = (c0006a.DE.iF().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0006a.DE.iD().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0006a.DE.iE().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0006a.DD.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.Dt.set(((l) c0006a.DD.get(size2)).iv());
            this.Dt.transform(matrix);
            this.Ds.setPath(this.Dt, false);
            float length2 = this.Ds.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.d.f.b(this.Dt, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.Dt, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.Dt, this.paint);
                } else {
                    com.airbnb.lottie.d.f.b(this.Dt, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.Dt, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.airbnb.lottie.c.bb("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.c.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.Dv.size(); i++) {
            C0006a c0006a = this.Dv.get(i);
            for (int i2 = 0; i2 < c0006a.DD.size(); i2++) {
                this.path.addPath(((l) c0006a.DD.get(i2)).iv(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.Dx.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.c.bb("StrokeContent#getBounds");
    }

    private void b(Matrix matrix) {
        com.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.Dz.isEmpty()) {
            com.airbnb.lottie.c.bb("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.airbnb.lottie.d.f.c(matrix);
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
        this.paint.setPathEffect(new DashPathEffect(this.Dw, this.DA == null ? 0.0f : this.DA.getValue().floatValue()));
        com.airbnb.lottie.c.bb("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.j.CE) {
            this.Dy.a(cVar);
        } else if (t == com.airbnb.lottie.j.CL) {
            this.Dx.a(cVar);
        } else if (t == com.airbnb.lottie.j.Dd) {
            if (cVar == null) {
                this.DC = null;
                return;
            }
            this.DC = new com.airbnb.lottie.a.b.p(cVar);
            this.DC.b(this);
            this.Du.a(this.DC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0006a {
        private final List<l> DD;
        @Nullable
        private final r DE;

        private C0006a(@Nullable r rVar) {
            this.DD = new ArrayList();
            this.DE = rVar;
        }
    }
}
