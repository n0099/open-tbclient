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
/* loaded from: classes4.dex */
public abstract class a implements d, j, a.InterfaceC0010a {
    private final com.airbnb.lottie.model.layer.a fG;
    private final float[] fI;
    private final com.airbnb.lottie.a.b.a<?, Float> fJ;
    private final com.airbnb.lottie.a.b.a<?, Integer> fK;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> fL;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> fM;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> fN;
    private final com.airbnb.lottie.g lottieDrawable;
    private final PathMeasure fE = new PathMeasure();
    private final Path path = new Path();
    private final Path fF = new Path();
    private final RectF rect = new RectF();
    private final List<C0009a> fH = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = gVar;
        this.fG = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.fK = dVar.cm();
        this.fJ = bVar.cm();
        if (bVar2 == null) {
            this.fM = null;
        } else {
            this.fM = bVar2.cm();
        }
        this.fL = new ArrayList(list.size());
        this.fI = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.fL.add(list.get(i).cm());
        }
        aVar.a(this.fK);
        aVar.a(this.fJ);
        for (int i2 = 0; i2 < this.fL.size(); i2++) {
            aVar.a(this.fL.get(i2));
        }
        if (this.fM != null) {
            aVar.a(this.fM);
        }
        this.fK.b(this);
        this.fJ.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.fL.get(i3).b(this);
        }
        if (this.fM != null) {
            this.fM.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bC() {
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
            rVar = ((bVar instanceof r) && ((r) bVar).bM() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0009a c0009a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).bM() == ShapeTrimPath.Type.Individually) {
                if (c0009a2 != null) {
                    this.fH.add(c0009a2);
                }
                C0009a c0009a3 = new C0009a((r) bVar2);
                ((r) bVar2).a(this);
                c0009a = c0009a3;
            } else if (bVar2 instanceof l) {
                c0009a = c0009a2 == null ? new C0009a(rVar) : c0009a2;
                c0009a.fO.add((l) bVar2);
            } else {
                c0009a = c0009a2;
            }
            size2--;
            c0009a2 = c0009a;
        }
        if (c0009a2 != null) {
            this.fH.add(c0009a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.fK.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.fJ.getValue().floatValue() * com.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.F("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.fN != null) {
            this.paint.setColorFilter(this.fN.getValue());
        }
        for (int i2 = 0; i2 < this.fH.size(); i2++) {
            C0009a c0009a = this.fH.get(i2);
            if (c0009a.fP != null) {
                a(canvas, c0009a, matrix);
            } else {
                com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0009a.fO.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0009a.fO.get(size)).bF(), matrix);
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
        if (c0009a.fP == null) {
            com.airbnb.lottie.d.F("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0009a.fO.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0009a.fO.get(size)).bF(), matrix);
        }
        this.fE.setPath(this.path, false);
        float length = this.fE.getLength();
        while (true) {
            f = length;
            if (!this.fE.nextContour()) {
                break;
            }
            length = this.fE.getLength() + f;
        }
        float floatValue = (c0009a.fP.bP().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0009a.fP.bN().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0009a.fP.bO().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0009a.fO.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.fF.set(((l) c0009a.fO.get(size2)).bF());
            this.fF.transform(matrix);
            this.fE.setPath(this.fF, false);
            float length2 = this.fE.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.d.f.a(this.fF, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.fF, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.fF, this.paint);
                } else {
                    com.airbnb.lottie.d.f.a(this.fF, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.fF, this.paint);
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
        for (int i = 0; i < this.fH.size(); i++) {
            C0009a c0009a = this.fH.get(i);
            for (int i2 = 0; i2 < c0009a.fO.size(); i2++) {
                this.path.addPath(((l) c0009a.fO.get(i2)).bF(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.fJ.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.F("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.fL.isEmpty()) {
            com.airbnb.lottie.d.F("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fL.size()) {
                break;
            }
            this.fI[i2] = this.fL.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.fI[i2] < 1.0f) {
                    this.fI[i2] = 1.0f;
                }
            } else if (this.fI[i2] < 0.1f) {
                this.fI[i2] = 0.1f;
            }
            float[] fArr = this.fI;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.fI, this.fM == null ? 0.0f : this.fM.getValue().floatValue()));
        com.airbnb.lottie.d.F("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.eO) {
            this.fK.a(cVar);
        } else if (t == com.airbnb.lottie.k.eV) {
            this.fJ.a(cVar);
        } else if (t == com.airbnb.lottie.k.fk) {
            if (cVar == null) {
                this.fN = null;
                return;
            }
            this.fN = new com.airbnb.lottie.a.b.p(cVar);
            this.fN.b(this);
            this.fG.a(this.fN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0009a {
        private final List<l> fO;
        @Nullable
        private final r fP;

        private C0009a(@Nullable r rVar) {
            this.fO = new ArrayList();
            this.fP = rVar;
        }
    }
}
