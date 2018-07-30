package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a implements d, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jQ;
    private final float[] lj;
    private final com.airbnb.lottie.a.b.a<?, Float> lk;
    private final com.airbnb.lottie.a.b.a<?, Integer> ll;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> lm;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> ln;
    private final PathMeasure lf = new PathMeasure();
    private final Path lg = new Path();
    private final Path lh = new Path();
    private final RectF rect = new RectF();
    private final List<C0005a> li = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.jQ = fVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.ll = dVar.ci();
        this.lk = bVar.ci();
        if (bVar2 == null) {
            this.ln = null;
        } else {
            this.ln = bVar2.ci();
        }
        this.lm = new ArrayList(list.size());
        this.lj = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.lm.add(list.get(i).ci());
        }
        aVar.a(this.ll);
        aVar.a(this.lk);
        for (int i2 = 0; i2 < this.lm.size(); i2++) {
            aVar.a(this.lm.get(i2));
        }
        if (this.ln != null) {
            aVar.a(this.ln);
        }
        this.ll.b(this);
        this.lk.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.lm.get(i3).b(this);
        }
        if (this.ln != null) {
            this.ln.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        this.jQ.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0005a c0005a;
        int size = list.size() - 1;
        q qVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            qVar = ((bVar instanceof q) && ((q) bVar).bO() == ShapeTrimPath.Type.Individually) ? (q) bVar : qVar;
        }
        if (qVar != null) {
            qVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0005a c0005a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof q) && ((q) bVar2).bO() == ShapeTrimPath.Type.Individually) {
                if (c0005a2 != null) {
                    this.li.add(c0005a2);
                }
                C0005a c0005a3 = new C0005a((q) bVar2);
                ((q) bVar2).a(this);
                c0005a = c0005a3;
            } else if (bVar2 instanceof k) {
                c0005a = c0005a2 == null ? new C0005a(qVar) : c0005a2;
                c0005a.lo.add((k) bVar2);
            } else {
                c0005a = c0005a2;
            }
            size2--;
            c0005a2 = c0005a;
        }
        if (c0005a2 != null) {
            this.li.add(c0005a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha((int) (((this.ll.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.paint.setStrokeWidth(this.lk.getValue().floatValue() * com.airbnb.lottie.c.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.D("StrokeContent#draw");
            return;
        }
        a(matrix);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.li.size()) {
                C0005a c0005a = this.li.get(i3);
                if (c0005a.lp != null) {
                    a(canvas, c0005a, matrix);
                } else {
                    com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                    this.lg.reset();
                    for (int size = c0005a.lo.size() - 1; size >= 0; size--) {
                        this.lg.addPath(((k) c0005a.lo.get(size)).getPath(), matrix);
                    }
                    com.airbnb.lottie.d.D("StrokeContent#buildPath");
                    com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                    canvas.drawPath(this.lg, this.paint);
                    com.airbnb.lottie.d.D("StrokeContent#drawPath");
                }
                i2 = i3 + 1;
            } else {
                com.airbnb.lottie.d.D("StrokeContent#draw");
                return;
            }
        }
    }

    private void a(Canvas canvas, C0005a c0005a, Matrix matrix) {
        float f;
        com.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0005a.lp == null) {
            com.airbnb.lottie.d.D("StrokeContent#applyTrimPath");
            return;
        }
        this.lg.reset();
        for (int size = c0005a.lo.size() - 1; size >= 0; size--) {
            this.lg.addPath(((k) c0005a.lo.get(size)).getPath(), matrix);
        }
        this.lf.setPath(this.lg, false);
        float length = this.lf.getLength();
        while (true) {
            f = length;
            if (!this.lf.nextContour()) {
                break;
            }
            length = this.lf.getLength() + f;
        }
        float floatValue = (c0005a.lp.bR().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0005a.lp.bP().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0005a.lp.bQ().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0005a.lo.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.lh.set(((k) c0005a.lo.get(size2)).getPath());
            this.lh.transform(matrix);
            this.lf.setPath(this.lh, false);
            float length2 = this.lf.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.c.f.a(this.lh, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.lh, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.lh, this.paint);
                } else {
                    com.airbnb.lottie.c.f.a(this.lh, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.lh, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.airbnb.lottie.d.D("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.lg.reset();
        for (int i = 0; i < this.li.size(); i++) {
            C0005a c0005a = this.li.get(i);
            for (int i2 = 0; i2 < c0005a.lo.size(); i2++) {
                this.lg.addPath(((k) c0005a.lo.get(i2)).getPath(), matrix);
            }
        }
        this.lg.computeBounds(this.rect, false);
        float floatValue = this.lk.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.D("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.lm.isEmpty()) {
            com.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.airbnb.lottie.c.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.lm.size()) {
                break;
            }
            this.lj[i2] = this.lm.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.lj[i2] < 1.0f) {
                    this.lj[i2] = 1.0f;
                }
            } else if (this.lj[i2] < 0.1f) {
                this.lj[i2] = 0.1f;
            }
            float[] fArr = this.lj;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.lj, this.ln == null ? 0.0f : this.ln.getValue().floatValue()));
        com.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0005a {
        private final List<k> lo;
        @Nullable
        private final q lp;

        private C0005a(@Nullable q qVar) {
            this.lo = new ArrayList();
            this.lp = qVar;
        }
    }
}
