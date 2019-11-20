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
    private final com.airbnb.lottie.f cG;
    private final float[] dV;
    private final com.airbnb.lottie.a.b.a<?, Float> dW;
    private final com.airbnb.lottie.a.b.a<?, Integer> dX;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> dY;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> dZ;
    private final PathMeasure dS = new PathMeasure();
    private final Path path = new Path();
    private final Path dT = new Path();
    private final RectF rect = new RectF();
    private final List<C0006a> dU = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.cG = fVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.dX = dVar.bY();
        this.dW = bVar.bY();
        if (bVar2 == null) {
            this.dZ = null;
        } else {
            this.dZ = bVar2.bY();
        }
        this.dY = new ArrayList(list.size());
        this.dV = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.dY.add(list.get(i).bY());
        }
        aVar.a(this.dX);
        aVar.a(this.dW);
        for (int i2 = 0; i2 < this.dY.size(); i2++) {
            aVar.a(this.dY.get(i2));
        }
        if (this.dZ != null) {
            aVar.a(this.dZ);
        }
        this.dX.b(this);
        this.dW.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.dY.get(i3).b(this);
        }
        if (this.dZ != null) {
            this.dZ.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bt() {
        this.cG.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0006a c0006a;
        int size = list.size() - 1;
        q qVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            qVar = ((bVar instanceof q) && ((q) bVar).bD() == ShapeTrimPath.Type.Individually) ? (q) bVar : qVar;
        }
        if (qVar != null) {
            qVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0006a c0006a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof q) && ((q) bVar2).bD() == ShapeTrimPath.Type.Individually) {
                if (c0006a2 != null) {
                    this.dU.add(c0006a2);
                }
                C0006a c0006a3 = new C0006a((q) bVar2);
                ((q) bVar2).a(this);
                c0006a = c0006a3;
            } else if (bVar2 instanceof k) {
                c0006a = c0006a2 == null ? new C0006a(qVar) : c0006a2;
                c0006a.ea.add((k) bVar2);
            } else {
                c0006a = c0006a2;
            }
            size2--;
            c0006a2 = c0006a;
        }
        if (c0006a2 != null) {
            this.dU.add(c0006a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha((int) (((this.dX.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.paint.setStrokeWidth(this.dW.getValue().floatValue() * com.airbnb.lottie.c.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.D("StrokeContent#draw");
            return;
        }
        a(matrix);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.dU.size()) {
                C0006a c0006a = this.dU.get(i3);
                if (c0006a.eb != null) {
                    a(canvas, c0006a, matrix);
                } else {
                    com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                    this.path.reset();
                    for (int size = c0006a.ea.size() - 1; size >= 0; size--) {
                        this.path.addPath(((k) c0006a.ea.get(size)).bw(), matrix);
                    }
                    com.airbnb.lottie.d.D("StrokeContent#buildPath");
                    com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                    canvas.drawPath(this.path, this.paint);
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
        if (c0006a.eb == null) {
            com.airbnb.lottie.d.D("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0006a.ea.size() - 1; size >= 0; size--) {
            this.path.addPath(((k) c0006a.ea.get(size)).bw(), matrix);
        }
        this.dS.setPath(this.path, false);
        float length = this.dS.getLength();
        while (true) {
            f = length;
            if (!this.dS.nextContour()) {
                break;
            }
            length = this.dS.getLength() + f;
        }
        float floatValue = (c0006a.eb.bG().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0006a.eb.bE().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0006a.eb.bF().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0006a.ea.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.dT.set(((k) c0006a.ea.get(size2)).bw());
            this.dT.transform(matrix);
            this.dS.setPath(this.dT, false);
            float length2 = this.dS.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.c.f.a(this.dT, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.dT, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.dT, this.paint);
                } else {
                    com.airbnb.lottie.c.f.a(this.dT, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.dT, this.paint);
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
        this.path.reset();
        for (int i = 0; i < this.dU.size(); i++) {
            C0006a c0006a = this.dU.get(i);
            for (int i2 = 0; i2 < c0006a.ea.size(); i2++) {
                this.path.addPath(((k) c0006a.ea.get(i2)).bw(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.dW.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.D("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.dY.isEmpty()) {
            com.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.airbnb.lottie.c.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dY.size()) {
                break;
            }
            this.dV[i2] = this.dY.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.dV[i2] < 1.0f) {
                    this.dV[i2] = 1.0f;
                }
            } else if (this.dV[i2] < 0.1f) {
                this.dV[i2] = 0.1f;
            }
            float[] fArr = this.dV;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.dV, this.dZ == null ? 0.0f : this.dZ.getValue().floatValue()));
        com.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0006a {
        private final List<k> ea;
        @Nullable
        private final q eb;

        private C0006a(@Nullable q qVar) {
            this.ea = new ArrayList();
            this.eb = qVar;
        }
    }
}
