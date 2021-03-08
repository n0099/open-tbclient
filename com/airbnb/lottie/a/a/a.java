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
/* loaded from: classes5.dex */
public abstract class a implements d, j, a.InterfaceC0013a {
    private final com.airbnb.lottie.f Df;
    private final com.airbnb.lottie.model.layer.a EO;
    private final float[] ER;
    private final com.airbnb.lottie.a.b.a<?, Float> ES;
    private final com.airbnb.lottie.a.b.a<?, Integer> ET;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> EU;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> EV;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> EW;
    private final PathMeasure EM = new PathMeasure();
    private final Path path = new Path();
    private final Path EN = new Path();
    private final RectF rect = new RectF();
    private final List<C0012a> EP = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.Df = fVar;
        this.EO = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.ET = dVar.jb();
        this.ES = bVar.jb();
        if (bVar2 == null) {
            this.EV = null;
        } else {
            this.EV = bVar2.jb();
        }
        this.EU = new ArrayList(list.size());
        this.ER = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.EU.add(list.get(i).jb());
        }
        aVar.a(this.ET);
        aVar.a(this.ES);
        for (int i2 = 0; i2 < this.EU.size(); i2++) {
            aVar.a(this.EU.get(i2));
        }
        if (this.EV != null) {
            aVar.a(this.EV);
        }
        this.ET.b(this);
        this.ES.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.EU.get(i3).b(this);
        }
        if (this.EV != null) {
            this.EV.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0013a
    public void ir() {
        this.Df.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0012a c0012a;
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
        C0012a c0012a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).iB() == ShapeTrimPath.Type.Individually) {
                if (c0012a2 != null) {
                    this.EP.add(c0012a2);
                }
                C0012a c0012a3 = new C0012a((r) bVar2);
                ((r) bVar2).a(this);
                c0012a = c0012a3;
            } else if (bVar2 instanceof l) {
                c0012a = c0012a2 == null ? new C0012a(rVar) : c0012a2;
                c0012a.EX.add((l) bVar2);
            } else {
                c0012a = c0012a2;
            }
            size2--;
            c0012a2 = c0012a;
        }
        if (c0012a2 != null) {
            this.EP.add(c0012a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.ET.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.ES.getValue().floatValue() * com.airbnb.lottie.d.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.c.bf("StrokeContent#draw");
            return;
        }
        b(matrix);
        if (this.EW != null) {
            this.paint.setColorFilter(this.EW.getValue());
        }
        for (int i2 = 0; i2 < this.EP.size(); i2++) {
            C0012a c0012a = this.EP.get(i2);
            if (c0012a.EY != null) {
                a(canvas, c0012a, matrix);
            } else {
                com.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0012a.EX.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0012a.EX.get(size)).iu(), matrix);
                }
                com.airbnb.lottie.c.bf("StrokeContent#buildPath");
                com.airbnb.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.airbnb.lottie.c.bf("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.c.bf("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0012a c0012a, Matrix matrix) {
        float f;
        com.airbnb.lottie.c.beginSection("StrokeContent#applyTrimPath");
        if (c0012a.EY == null) {
            com.airbnb.lottie.c.bf("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0012a.EX.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0012a.EX.get(size)).iu(), matrix);
        }
        this.EM.setPath(this.path, false);
        float length = this.EM.getLength();
        while (true) {
            f = length;
            if (!this.EM.nextContour()) {
                break;
            }
            length = this.EM.getLength() + f;
        }
        float floatValue = (c0012a.EY.iE().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0012a.EY.iC().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0012a.EY.iD().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0012a.EX.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.EN.set(((l) c0012a.EX.get(size2)).iu());
            this.EN.transform(matrix);
            this.EM.setPath(this.EN, false);
            float length2 = this.EM.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.d.f.b(this.EN, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.EN, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.EN, this.paint);
                } else {
                    com.airbnb.lottie.d.f.b(this.EN, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.EN, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.airbnb.lottie.c.bf("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.c.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.EP.size(); i++) {
            C0012a c0012a = this.EP.get(i);
            for (int i2 = 0; i2 < c0012a.EX.size(); i2++) {
                this.path.addPath(((l) c0012a.EX.get(i2)).iu(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.ES.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.c.bf("StrokeContent#getBounds");
    }

    private void b(Matrix matrix) {
        com.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.EU.isEmpty()) {
            com.airbnb.lottie.c.bf("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.airbnb.lottie.d.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.EU.size()) {
                break;
            }
            this.ER[i2] = this.EU.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.ER[i2] < 1.0f) {
                    this.ER[i2] = 1.0f;
                }
            } else if (this.ER[i2] < 0.1f) {
                this.ER[i2] = 0.1f;
            }
            float[] fArr = this.ER;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.ER, this.EV == null ? 0.0f : this.EV.getValue().floatValue()));
        com.airbnb.lottie.c.bf("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.j.Ed) {
            this.ET.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ek) {
            this.ES.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ex) {
            if (cVar == null) {
                this.EW = null;
                return;
            }
            this.EW = new com.airbnb.lottie.a.b.p(cVar);
            this.EW.b(this);
            this.EO.a(this.EW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0012a {
        private final List<l> EX;
        @Nullable
        private final r EY;

        private C0012a(@Nullable r rVar) {
            this.EX = new ArrayList();
            this.EY = rVar;
        }
    }
}
