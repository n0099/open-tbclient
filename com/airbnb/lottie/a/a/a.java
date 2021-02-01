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
/* loaded from: classes4.dex */
public abstract class a implements d, j, a.InterfaceC0007a {
    private final com.airbnb.lottie.f BH;
    private final com.airbnb.lottie.model.layer.a Ds;
    private final float[] Du;
    private final com.airbnb.lottie.a.b.a<?, Float> Dv;
    private final com.airbnb.lottie.a.b.a<?, Integer> Dw;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> Dx;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> Dy;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> Dz;
    private final PathMeasure Dq = new PathMeasure();
    private final Path path = new Path();
    private final Path Dr = new Path();
    private final RectF rect = new RectF();
    private final List<C0006a> Dt = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.BH = fVar;
        this.Ds = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.Dw = dVar.jb();
        this.Dv = bVar.jb();
        if (bVar2 == null) {
            this.Dy = null;
        } else {
            this.Dy = bVar2.jb();
        }
        this.Dx = new ArrayList(list.size());
        this.Du = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.Dx.add(list.get(i).jb());
        }
        aVar.a(this.Dw);
        aVar.a(this.Dv);
        for (int i2 = 0; i2 < this.Dx.size(); i2++) {
            aVar.a(this.Dx.get(i2));
        }
        if (this.Dy != null) {
            aVar.a(this.Dy);
        }
        this.Dw.b(this);
        this.Dv.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.Dx.get(i3).b(this);
        }
        if (this.Dy != null) {
            this.Dy.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ir() {
        this.BH.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        C0006a c0006a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).iB() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0006a c0006a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).iB() == ShapeTrimPath.Type.Individually) {
                if (c0006a2 != null) {
                    this.Dt.add(c0006a2);
                }
                C0006a c0006a3 = new C0006a((r) bVar2);
                ((r) bVar2).a(this);
                c0006a = c0006a3;
            } else if (bVar2 instanceof l) {
                c0006a = c0006a2 == null ? new C0006a(rVar) : c0006a2;
                c0006a.DA.add((l) bVar2);
            } else {
                c0006a = c0006a2;
            }
            size2--;
            c0006a2 = c0006a;
        }
        if (c0006a2 != null) {
            this.Dt.add(c0006a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.Dw.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.Dv.getValue().floatValue() * com.airbnb.lottie.d.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.c.bb("StrokeContent#draw");
            return;
        }
        b(matrix);
        if (this.Dz != null) {
            this.paint.setColorFilter(this.Dz.getValue());
        }
        for (int i2 = 0; i2 < this.Dt.size(); i2++) {
            C0006a c0006a = this.Dt.get(i2);
            if (c0006a.DC != null) {
                a(canvas, c0006a, matrix);
            } else {
                com.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0006a.DA.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0006a.DA.get(size)).iu(), matrix);
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
        if (c0006a.DC == null) {
            com.airbnb.lottie.c.bb("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0006a.DA.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0006a.DA.get(size)).iu(), matrix);
        }
        this.Dq.setPath(this.path, false);
        float length = this.Dq.getLength();
        while (true) {
            f = length;
            if (!this.Dq.nextContour()) {
                break;
            }
            length = this.Dq.getLength() + f;
        }
        float floatValue = (c0006a.DC.iE().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0006a.DC.iC().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0006a.DC.iD().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0006a.DA.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.Dr.set(((l) c0006a.DA.get(size2)).iu());
            this.Dr.transform(matrix);
            this.Dq.setPath(this.Dr, false);
            float length2 = this.Dq.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.d.f.b(this.Dr, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.Dr, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.Dr, this.paint);
                } else {
                    com.airbnb.lottie.d.f.b(this.Dr, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.Dr, this.paint);
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
        for (int i = 0; i < this.Dt.size(); i++) {
            C0006a c0006a = this.Dt.get(i);
            for (int i2 = 0; i2 < c0006a.DA.size(); i2++) {
                this.path.addPath(((l) c0006a.DA.get(i2)).iu(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.Dv.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.c.bb("StrokeContent#getBounds");
    }

    private void b(Matrix matrix) {
        com.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.Dx.isEmpty()) {
            com.airbnb.lottie.c.bb("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.airbnb.lottie.d.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Dx.size()) {
                break;
            }
            this.Du[i2] = this.Dx.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.Du[i2] < 1.0f) {
                    this.Du[i2] = 1.0f;
                }
            } else if (this.Du[i2] < 0.1f) {
                this.Du[i2] = 0.1f;
            }
            float[] fArr = this.Du;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.Du, this.Dy == null ? 0.0f : this.Dy.getValue().floatValue()));
        com.airbnb.lottie.c.bb("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.j.CC) {
            this.Dw.a(cVar);
        } else if (t == com.airbnb.lottie.j.CJ) {
            this.Dv.a(cVar);
        } else if (t == com.airbnb.lottie.j.Db) {
            if (cVar == null) {
                this.Dz = null;
                return;
            }
            this.Dz = new com.airbnb.lottie.a.b.p(cVar);
            this.Dz.b(this);
            this.Ds.a(this.Dz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0006a {
        private final List<l> DA;
        @Nullable
        private final r DC;

        private C0006a(@Nullable r rVar) {
            this.DA = new ArrayList();
            this.DC = rVar;
        }
    }
}
