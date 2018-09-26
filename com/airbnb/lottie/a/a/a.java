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
    private final com.airbnb.lottie.f mp;
    private final float[] nM;
    private final com.airbnb.lottie.a.b.a<?, Float> nN;
    private final com.airbnb.lottie.a.b.a<?, Integer> nO;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> nP;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> nQ;
    private final PathMeasure nI = new PathMeasure();
    private final Path nJ = new Path();
    private final Path nK = new Path();
    private final RectF rect = new RectF();
    private final List<C0005a> nL = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.mp = fVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.nO = dVar.dp();
        this.nN = bVar.dp();
        if (bVar2 == null) {
            this.nQ = null;
        } else {
            this.nQ = bVar2.dp();
        }
        this.nP = new ArrayList(list.size());
        this.nM = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.nP.add(list.get(i).dp());
        }
        aVar.a(this.nO);
        aVar.a(this.nN);
        for (int i2 = 0; i2 < this.nP.size(); i2++) {
            aVar.a(this.nP.get(i2));
        }
        if (this.nQ != null) {
            aVar.a(this.nQ);
        }
        this.nO.b(this);
        this.nN.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.nP.get(i3).b(this);
        }
        if (this.nQ != null) {
            this.nQ.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void cM() {
        this.mp.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0005a c0005a;
        int size = list.size() - 1;
        q qVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            qVar = ((bVar instanceof q) && ((q) bVar).cV() == ShapeTrimPath.Type.Individually) ? (q) bVar : qVar;
        }
        if (qVar != null) {
            qVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0005a c0005a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof q) && ((q) bVar2).cV() == ShapeTrimPath.Type.Individually) {
                if (c0005a2 != null) {
                    this.nL.add(c0005a2);
                }
                C0005a c0005a3 = new C0005a((q) bVar2);
                ((q) bVar2).a(this);
                c0005a = c0005a3;
            } else if (bVar2 instanceof k) {
                c0005a = c0005a2 == null ? new C0005a(qVar) : c0005a2;
                c0005a.nR.add((k) bVar2);
            } else {
                c0005a = c0005a2;
            }
            size2--;
            c0005a2 = c0005a;
        }
        if (c0005a2 != null) {
            this.nL.add(c0005a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha((int) (((this.nO.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.paint.setStrokeWidth(this.nN.getValue().floatValue() * com.airbnb.lottie.c.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.U("StrokeContent#draw");
            return;
        }
        a(matrix);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.nL.size()) {
                C0005a c0005a = this.nL.get(i3);
                if (c0005a.nS != null) {
                    a(canvas, c0005a, matrix);
                } else {
                    com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                    this.nJ.reset();
                    for (int size = c0005a.nR.size() - 1; size >= 0; size--) {
                        this.nJ.addPath(((k) c0005a.nR.get(size)).getPath(), matrix);
                    }
                    com.airbnb.lottie.d.U("StrokeContent#buildPath");
                    com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                    canvas.drawPath(this.nJ, this.paint);
                    com.airbnb.lottie.d.U("StrokeContent#drawPath");
                }
                i2 = i3 + 1;
            } else {
                com.airbnb.lottie.d.U("StrokeContent#draw");
                return;
            }
        }
    }

    private void a(Canvas canvas, C0005a c0005a, Matrix matrix) {
        float f;
        com.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0005a.nS == null) {
            com.airbnb.lottie.d.U("StrokeContent#applyTrimPath");
            return;
        }
        this.nJ.reset();
        for (int size = c0005a.nR.size() - 1; size >= 0; size--) {
            this.nJ.addPath(((k) c0005a.nR.get(size)).getPath(), matrix);
        }
        this.nI.setPath(this.nJ, false);
        float length = this.nI.getLength();
        while (true) {
            f = length;
            if (!this.nI.nextContour()) {
                break;
            }
            length = this.nI.getLength() + f;
        }
        float floatValue = (c0005a.nS.cY().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0005a.nS.cW().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0005a.nS.cX().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0005a.nR.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.nK.set(((k) c0005a.nR.get(size2)).getPath());
            this.nK.transform(matrix);
            this.nI.setPath(this.nK, false);
            float length2 = this.nI.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.c.f.a(this.nK, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.nK, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.nK, this.paint);
                } else {
                    com.airbnb.lottie.c.f.a(this.nK, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.nK, this.paint);
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
        this.nJ.reset();
        for (int i = 0; i < this.nL.size(); i++) {
            C0005a c0005a = this.nL.get(i);
            for (int i2 = 0; i2 < c0005a.nR.size(); i2++) {
                this.nJ.addPath(((k) c0005a.nR.get(i2)).getPath(), matrix);
            }
        }
        this.nJ.computeBounds(this.rect, false);
        float floatValue = this.nN.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.U("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.nP.isEmpty()) {
            com.airbnb.lottie.d.U("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.airbnb.lottie.c.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.nP.size()) {
                break;
            }
            this.nM[i2] = this.nP.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.nM[i2] < 1.0f) {
                    this.nM[i2] = 1.0f;
                }
            } else if (this.nM[i2] < 0.1f) {
                this.nM[i2] = 0.1f;
            }
            float[] fArr = this.nM;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.nM, this.nQ == null ? 0.0f : this.nQ.getValue().floatValue()));
        com.airbnb.lottie.d.U("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0005a {
        private final List<k> nR;
        @Nullable
        private final q nS;

        private C0005a(@Nullable q qVar) {
            this.nR = new ArrayList();
            this.nS = qVar;
        }
    }
}
