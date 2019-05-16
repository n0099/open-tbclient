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
public abstract class a implements d, a.InterfaceC0007a {
    private final com.airbnb.lottie.f kC;
    private final float[] lV;
    private final com.airbnb.lottie.a.b.a<?, Float> lW;
    private final com.airbnb.lottie.a.b.a<?, Integer> lX;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> lY;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> lZ;
    private final PathMeasure lR = new PathMeasure();
    private final Path lS = new Path();
    private final Path lT = new Path();
    private final RectF rect = new RectF();
    private final List<C0006a> lU = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.kC = fVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.lX = dVar.cz();
        this.lW = bVar.cz();
        if (bVar2 == null) {
            this.lZ = null;
        } else {
            this.lZ = bVar2.cz();
        }
        this.lY = new ArrayList(list.size());
        this.lV = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.lY.add(list.get(i).cz());
        }
        aVar.a(this.lX);
        aVar.a(this.lW);
        for (int i2 = 0; i2 < this.lY.size(); i2++) {
            aVar.a(this.lY.get(i2));
        }
        if (this.lZ != null) {
            aVar.a(this.lZ);
        }
        this.lX.b(this);
        this.lW.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.lY.get(i3).b(this);
        }
        if (this.lZ != null) {
            this.lZ.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bW() {
        this.kC.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0006a c0006a;
        int size = list.size() - 1;
        q qVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            qVar = ((bVar instanceof q) && ((q) bVar).cf() == ShapeTrimPath.Type.Individually) ? (q) bVar : qVar;
        }
        if (qVar != null) {
            qVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0006a c0006a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof q) && ((q) bVar2).cf() == ShapeTrimPath.Type.Individually) {
                if (c0006a2 != null) {
                    this.lU.add(c0006a2);
                }
                C0006a c0006a3 = new C0006a((q) bVar2);
                ((q) bVar2).a(this);
                c0006a = c0006a3;
            } else if (bVar2 instanceof k) {
                c0006a = c0006a2 == null ? new C0006a(qVar) : c0006a2;
                c0006a.ma.add((k) bVar2);
            } else {
                c0006a = c0006a2;
            }
            size2--;
            c0006a2 = c0006a;
        }
        if (c0006a2 != null) {
            this.lU.add(c0006a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha((int) (((this.lX.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.paint.setStrokeWidth(this.lW.getValue().floatValue() * com.airbnb.lottie.c.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.D("StrokeContent#draw");
            return;
        }
        a(matrix);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.lU.size()) {
                C0006a c0006a = this.lU.get(i3);
                if (c0006a.mb != null) {
                    a(canvas, c0006a, matrix);
                } else {
                    com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                    this.lS.reset();
                    for (int size = c0006a.ma.size() - 1; size >= 0; size--) {
                        this.lS.addPath(((k) c0006a.ma.get(size)).getPath(), matrix);
                    }
                    com.airbnb.lottie.d.D("StrokeContent#buildPath");
                    com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                    canvas.drawPath(this.lS, this.paint);
                    com.airbnb.lottie.d.D("StrokeContent#drawPath");
                }
                i2 = i3 + 1;
            } else {
                com.airbnb.lottie.d.D("StrokeContent#draw");
                return;
            }
        }
    }

    private void a(Canvas canvas, C0006a c0006a, Matrix matrix) {
        float f;
        com.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0006a.mb == null) {
            com.airbnb.lottie.d.D("StrokeContent#applyTrimPath");
            return;
        }
        this.lS.reset();
        for (int size = c0006a.ma.size() - 1; size >= 0; size--) {
            this.lS.addPath(((k) c0006a.ma.get(size)).getPath(), matrix);
        }
        this.lR.setPath(this.lS, false);
        float length = this.lR.getLength();
        while (true) {
            f = length;
            if (!this.lR.nextContour()) {
                break;
            }
            length = this.lR.getLength() + f;
        }
        float floatValue = (c0006a.mb.ci().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0006a.mb.cg().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0006a.mb.ch().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0006a.ma.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.lT.set(((k) c0006a.ma.get(size2)).getPath());
            this.lT.transform(matrix);
            this.lR.setPath(this.lT, false);
            float length2 = this.lR.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.c.f.a(this.lT, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.lT, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.lT, this.paint);
                } else {
                    com.airbnb.lottie.c.f.a(this.lT, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.lT, this.paint);
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
        this.lS.reset();
        for (int i = 0; i < this.lU.size(); i++) {
            C0006a c0006a = this.lU.get(i);
            for (int i2 = 0; i2 < c0006a.ma.size(); i2++) {
                this.lS.addPath(((k) c0006a.ma.get(i2)).getPath(), matrix);
            }
        }
        this.lS.computeBounds(this.rect, false);
        float floatValue = this.lW.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.D("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.lY.isEmpty()) {
            com.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.airbnb.lottie.c.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.lY.size()) {
                break;
            }
            this.lV[i2] = this.lY.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.lV[i2] < 1.0f) {
                    this.lV[i2] = 1.0f;
                }
            } else if (this.lV[i2] < 0.1f) {
                this.lV[i2] = 0.1f;
            }
            float[] fArr = this.lV;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.lV, this.lZ == null ? 0.0f : this.lZ.getValue().floatValue()));
        com.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0006a {
        private final List<k> ma;
        @Nullable
        private final q mb;

        private C0006a(@Nullable q qVar) {
            this.ma = new ArrayList();
            this.mb = qVar;
        }
    }
}
