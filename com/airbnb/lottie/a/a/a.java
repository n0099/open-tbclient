package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a implements d, j, a.InterfaceC0010a {
    private final com.airbnb.lottie.model.layer.a fJ;
    private final float[] fL;
    private final com.airbnb.lottie.a.b.a<?, Float> fM;
    private final com.airbnb.lottie.a.b.a<?, Integer> fN;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> fO;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> fP;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> fQ;
    private final com.airbnb.lottie.g lottieDrawable;
    private final PathMeasure fH = new PathMeasure();
    private final Path path = new Path();
    private final Path fI = new Path();
    private final RectF rect = new RectF();
    private final List<C0009a> fK = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = gVar;
        this.fJ = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.fN = dVar.cn();
        this.fM = bVar.cn();
        if (bVar2 == null) {
            this.fP = null;
        } else {
            this.fP = bVar2.cn();
        }
        this.fO = new ArrayList(list.size());
        this.fL = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.fO.add(list.get(i).cn());
        }
        aVar.a(this.fN);
        aVar.a(this.fM);
        for (int i2 = 0; i2 < this.fO.size(); i2++) {
            aVar.a(this.fO.get(i2));
        }
        if (this.fP != null) {
            aVar.a(this.fP);
        }
        this.fN.b(this);
        this.fM.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.fO.get(i3).b(this);
        }
        if (this.fP != null) {
            this.fP.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bD() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0009a c0009a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).bN() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0009a c0009a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).bN() == ShapeTrimPath.Type.Individually) {
                if (c0009a2 != null) {
                    this.fK.add(c0009a2);
                }
                C0009a c0009a3 = new C0009a((r) bVar2);
                ((r) bVar2).a(this);
                c0009a = c0009a3;
            } else if (bVar2 instanceof l) {
                c0009a = c0009a2 == null ? new C0009a(rVar) : c0009a2;
                c0009a.fR.add((l) bVar2);
            } else {
                c0009a = c0009a2;
            }
            size2--;
            c0009a2 = c0009a;
        }
        if (c0009a2 != null) {
            this.fK.add(c0009a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.fN.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.fM.getValue().floatValue() * com.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.F("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.fQ != null) {
            this.paint.setColorFilter(this.fQ.getValue());
        }
        for (int i2 = 0; i2 < this.fK.size(); i2++) {
            C0009a c0009a = this.fK.get(i2);
            if (c0009a.fS != null) {
                a(canvas, c0009a, matrix);
            } else {
                com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0009a.fR.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0009a.fR.get(size)).bG(), matrix);
                }
                com.airbnb.lottie.d.F("StrokeContent#buildPath");
                com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.airbnb.lottie.d.F("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.d.F("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0009a c0009a, Matrix matrix) {
        float f;
        com.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0009a.fS == null) {
            com.airbnb.lottie.d.F("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0009a.fR.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0009a.fR.get(size)).bG(), matrix);
        }
        this.fH.setPath(this.path, false);
        float length = this.fH.getLength();
        while (true) {
            f = length;
            if (!this.fH.nextContour()) {
                break;
            }
            length = this.fH.getLength() + f;
        }
        float floatValue = (c0009a.fS.bQ().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0009a.fS.bO().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0009a.fS.bP().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0009a.fR.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.fI.set(((l) c0009a.fR.get(size2)).bG());
            this.fI.transform(matrix);
            this.fH.setPath(this.fI, false);
            float length2 = this.fH.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.d.f.a(this.fI, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.fI, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.fI, this.paint);
                } else {
                    com.airbnb.lottie.d.f.a(this.fI, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.fI, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.airbnb.lottie.d.F("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.fK.size(); i++) {
            C0009a c0009a = this.fK.get(i);
            for (int i2 = 0; i2 < c0009a.fR.size(); i2++) {
                this.path.addPath(((l) c0009a.fR.get(i2)).bG(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.fM.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.F("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.fO.isEmpty()) {
            com.airbnb.lottie.d.F("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fO.size()) {
                break;
            }
            this.fL[i2] = this.fO.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.fL[i2] < 1.0f) {
                    this.fL[i2] = 1.0f;
                }
            } else if (this.fL[i2] < 0.1f) {
                this.fL[i2] = 0.1f;
            }
            float[] fArr = this.fL;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.fL, this.fP == null ? 0.0f : this.fP.getValue().floatValue()));
        com.airbnb.lottie.d.F("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.eP) {
            this.fN.a(cVar);
        } else if (t == com.airbnb.lottie.k.eW) {
            this.fM.a(cVar);
        } else if (t == com.airbnb.lottie.k.fo) {
            if (cVar == null) {
                this.fQ = null;
                return;
            }
            this.fQ = new com.airbnb.lottie.a.b.p(cVar);
            this.fQ.b(this);
            this.fJ.a(this.fQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0009a {
        private final List<l> fR;
        @Nullable
        private final r fS;

        private C0009a(@Nullable r rVar) {
            this.fR = new ArrayList();
            this.fS = rVar;
        }
    }
}
