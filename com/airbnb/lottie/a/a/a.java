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
public abstract class a implements d, a.InterfaceC0009a {
    private final com.airbnb.lottie.f nh;
    private final float[] oB;
    private final com.airbnb.lottie.a.b.a<?, Float> oC;
    private final com.airbnb.lottie.a.b.a<?, Integer> oD;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> oE;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> oF;
    private final PathMeasure ox = new PathMeasure();
    private final Path oy = new Path();
    private final Path oz = new Path();
    private final RectF rect = new RectF();
    private final List<C0008a> oA = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.nh = fVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.oD = dVar.dH();
        this.oC = bVar.dH();
        if (bVar2 == null) {
            this.oF = null;
        } else {
            this.oF = bVar2.dH();
        }
        this.oE = new ArrayList(list.size());
        this.oB = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.oE.add(list.get(i).dH());
        }
        aVar.a(this.oD);
        aVar.a(this.oC);
        for (int i2 = 0; i2 < this.oE.size(); i2++) {
            aVar.a(this.oE.get(i2));
        }
        if (this.oF != null) {
            aVar.a(this.oF);
        }
        this.oD.b(this);
        this.oC.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.oE.get(i3).b(this);
        }
        if (this.oF != null) {
            this.oF.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void de() {
        this.nh.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0008a c0008a;
        int size = list.size() - 1;
        q qVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            qVar = ((bVar instanceof q) && ((q) bVar).dn() == ShapeTrimPath.Type.Individually) ? (q) bVar : qVar;
        }
        if (qVar != null) {
            qVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0008a c0008a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof q) && ((q) bVar2).dn() == ShapeTrimPath.Type.Individually) {
                if (c0008a2 != null) {
                    this.oA.add(c0008a2);
                }
                C0008a c0008a3 = new C0008a((q) bVar2);
                ((q) bVar2).a(this);
                c0008a = c0008a3;
            } else if (bVar2 instanceof k) {
                c0008a = c0008a2 == null ? new C0008a(qVar) : c0008a2;
                c0008a.oG.add((k) bVar2);
            } else {
                c0008a = c0008a2;
            }
            size2--;
            c0008a2 = c0008a;
        }
        if (c0008a2 != null) {
            this.oA.add(c0008a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha((int) (((this.oD.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.paint.setStrokeWidth(this.oC.getValue().floatValue() * com.airbnb.lottie.c.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.U("StrokeContent#draw");
            return;
        }
        a(matrix);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.oA.size()) {
                C0008a c0008a = this.oA.get(i3);
                if (c0008a.oH != null) {
                    a(canvas, c0008a, matrix);
                } else {
                    com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                    this.oy.reset();
                    for (int size = c0008a.oG.size() - 1; size >= 0; size--) {
                        this.oy.addPath(((k) c0008a.oG.get(size)).getPath(), matrix);
                    }
                    com.airbnb.lottie.d.U("StrokeContent#buildPath");
                    com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                    canvas.drawPath(this.oy, this.paint);
                    com.airbnb.lottie.d.U("StrokeContent#drawPath");
                }
                i2 = i3 + 1;
            } else {
                com.airbnb.lottie.d.U("StrokeContent#draw");
                return;
            }
        }
    }

    private void a(Canvas canvas, C0008a c0008a, Matrix matrix) {
        float f;
        com.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0008a.oH == null) {
            com.airbnb.lottie.d.U("StrokeContent#applyTrimPath");
            return;
        }
        this.oy.reset();
        for (int size = c0008a.oG.size() - 1; size >= 0; size--) {
            this.oy.addPath(((k) c0008a.oG.get(size)).getPath(), matrix);
        }
        this.ox.setPath(this.oy, false);
        float length = this.ox.getLength();
        while (true) {
            f = length;
            if (!this.ox.nextContour()) {
                break;
            }
            length = this.ox.getLength() + f;
        }
        float floatValue = (c0008a.oH.dq().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0008a.oH.m6do().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0008a.oH.dp().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0008a.oG.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.oz.set(((k) c0008a.oG.get(size2)).getPath());
            this.oz.transform(matrix);
            this.ox.setPath(this.oz, false);
            float length2 = this.ox.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.c.f.a(this.oz, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.oz, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.oz, this.paint);
                } else {
                    com.airbnb.lottie.c.f.a(this.oz, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.oz, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.airbnb.lottie.d.U("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.oy.reset();
        for (int i = 0; i < this.oA.size(); i++) {
            C0008a c0008a = this.oA.get(i);
            for (int i2 = 0; i2 < c0008a.oG.size(); i2++) {
                this.oy.addPath(((k) c0008a.oG.get(i2)).getPath(), matrix);
            }
        }
        this.oy.computeBounds(this.rect, false);
        float floatValue = this.oC.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.U("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.oE.isEmpty()) {
            com.airbnb.lottie.d.U("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.airbnb.lottie.c.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.oE.size()) {
                break;
            }
            this.oB[i2] = this.oE.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.oB[i2] < 1.0f) {
                    this.oB[i2] = 1.0f;
                }
            } else if (this.oB[i2] < 0.1f) {
                this.oB[i2] = 0.1f;
            }
            float[] fArr = this.oB;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.oB, this.oF == null ? 0.0f : this.oF.getValue().floatValue()));
        com.airbnb.lottie.d.U("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0008a {
        private final List<k> oG;
        @Nullable
        private final q oH;

        private C0008a(@Nullable q qVar) {
            this.oG = new ArrayList();
            this.oH = qVar;
        }
    }
}
