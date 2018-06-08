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
    private final com.airbnb.lottie.f jY;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> lA;
    private final float[] lu;
    private final com.airbnb.lottie.a.b.a<?, Float> lw;
    private final com.airbnb.lottie.a.b.a<?, Integer> lx;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> ly;
    private final PathMeasure lo = new PathMeasure();
    private final Path lp = new Path();
    private final Path lq = new Path();
    private final RectF lr = new RectF();
    private final List<C0005a> lt = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.jY = fVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.lx = dVar.ck();
        this.lw = bVar.ck();
        if (bVar2 == null) {
            this.lA = null;
        } else {
            this.lA = bVar2.ck();
        }
        this.ly = new ArrayList(list.size());
        this.lu = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.ly.add(list.get(i).ck());
        }
        aVar.a(this.lx);
        aVar.a(this.lw);
        for (int i2 = 0; i2 < this.ly.size(); i2++) {
            aVar.a(this.ly.get(i2));
        }
        if (this.lA != null) {
            aVar.a(this.lA);
        }
        this.lx.b(this);
        this.lw.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.ly.get(i3).b(this);
        }
        if (this.lA != null) {
            this.lA.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        this.jY.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0005a c0005a;
        int size = list.size() - 1;
        q qVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            qVar = ((bVar instanceof q) && ((q) bVar).bQ() == ShapeTrimPath.Type.Individually) ? (q) bVar : qVar;
        }
        if (qVar != null) {
            qVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0005a c0005a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof q) && ((q) bVar2).bQ() == ShapeTrimPath.Type.Individually) {
                if (c0005a2 != null) {
                    this.lt.add(c0005a2);
                }
                C0005a c0005a3 = new C0005a((q) bVar2);
                ((q) bVar2).a(this);
                c0005a = c0005a3;
            } else if (bVar2 instanceof k) {
                c0005a = c0005a2 == null ? new C0005a(qVar) : c0005a2;
                c0005a.lB.add((k) bVar2);
            } else {
                c0005a = c0005a2;
            }
            size2--;
            c0005a2 = c0005a;
        }
        if (c0005a2 != null) {
            this.lt.add(c0005a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha((int) (((this.lx.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.paint.setStrokeWidth(this.lw.getValue().floatValue() * com.airbnb.lottie.c.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.D("StrokeContent#draw");
            return;
        }
        a(matrix);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.lt.size()) {
                C0005a c0005a = this.lt.get(i3);
                if (c0005a.lC != null) {
                    a(canvas, c0005a, matrix);
                } else {
                    com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                    this.lp.reset();
                    for (int size = c0005a.lB.size() - 1; size >= 0; size--) {
                        this.lp.addPath(((k) c0005a.lB.get(size)).getPath(), matrix);
                    }
                    com.airbnb.lottie.d.D("StrokeContent#buildPath");
                    com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                    canvas.drawPath(this.lp, this.paint);
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
        if (c0005a.lC == null) {
            com.airbnb.lottie.d.D("StrokeContent#applyTrimPath");
            return;
        }
        this.lp.reset();
        for (int size = c0005a.lB.size() - 1; size >= 0; size--) {
            this.lp.addPath(((k) c0005a.lB.get(size)).getPath(), matrix);
        }
        this.lo.setPath(this.lp, false);
        float length = this.lo.getLength();
        while (true) {
            f = length;
            if (!this.lo.nextContour()) {
                break;
            }
            length = this.lo.getLength() + f;
        }
        float floatValue = (c0005a.lC.bT().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0005a.lC.bR().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0005a.lC.bS().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0005a.lB.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.lq.set(((k) c0005a.lB.get(size2)).getPath());
            this.lq.transform(matrix);
            this.lo.setPath(this.lq, false);
            float length2 = this.lo.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.c.f.a(this.lq, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.lq, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.lq, this.paint);
                } else {
                    com.airbnb.lottie.c.f.a(this.lq, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.lq, this.paint);
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
        this.lp.reset();
        for (int i = 0; i < this.lt.size(); i++) {
            C0005a c0005a = this.lt.get(i);
            for (int i2 = 0; i2 < c0005a.lB.size(); i2++) {
                this.lp.addPath(((k) c0005a.lB.get(i2)).getPath(), matrix);
            }
        }
        this.lp.computeBounds(this.lr, false);
        float floatValue = this.lw.getValue().floatValue();
        this.lr.set(this.lr.left - (floatValue / 2.0f), this.lr.top - (floatValue / 2.0f), this.lr.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.lr.bottom);
        rectF.set(this.lr);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.D("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.ly.isEmpty()) {
            com.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.airbnb.lottie.c.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ly.size()) {
                break;
            }
            this.lu[i2] = this.ly.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.lu[i2] < 1.0f) {
                    this.lu[i2] = 1.0f;
                }
            } else if (this.lu[i2] < 0.1f) {
                this.lu[i2] = 0.1f;
            }
            float[] fArr = this.lu;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.lu, this.lA == null ? 0.0f : this.lA.getValue().floatValue()));
        com.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0005a {
        private final List<k> lB;
        @Nullable
        private final q lC;

        private C0005a(@Nullable q qVar) {
            this.lB = new ArrayList();
            this.lC = qVar;
        }
    }
}
