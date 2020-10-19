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
/* loaded from: classes10.dex */
public abstract class a implements d, j, a.InterfaceC0011a {
    private final com.airbnb.lottie.model.layer.a CK;
    private final float[] CN;
    private final com.airbnb.lottie.a.b.a<?, Float> CO;
    private final com.airbnb.lottie.a.b.a<?, Integer> CP;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> CQ;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> CV;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> CW;
    private final com.airbnb.lottie.g lottieDrawable;
    private final PathMeasure CI = new PathMeasure();
    private final Path path = new Path();
    private final Path CJ = new Path();
    private final RectF rect = new RectF();
    private final List<C0010a> CL = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = gVar;
        this.CK = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.CP = dVar.jD();
        this.CO = bVar.jD();
        if (bVar2 == null) {
            this.CV = null;
        } else {
            this.CV = bVar2.jD();
        }
        this.CQ = new ArrayList(list.size());
        this.CN = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.CQ.add(list.get(i).jD());
        }
        aVar.a(this.CP);
        aVar.a(this.CO);
        for (int i2 = 0; i2 < this.CQ.size(); i2++) {
            aVar.a(this.CQ.get(i2));
        }
        if (this.CV != null) {
            aVar.a(this.CV);
        }
        this.CP.b(this);
        this.CO.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.CQ.get(i3).b(this);
        }
        if (this.CV != null) {
            this.CV.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0011a
    public void iT() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0010a c0010a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).jd() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0010a c0010a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).jd() == ShapeTrimPath.Type.Individually) {
                if (c0010a2 != null) {
                    this.CL.add(c0010a2);
                }
                C0010a c0010a3 = new C0010a((r) bVar2);
                ((r) bVar2).a(this);
                c0010a = c0010a3;
            } else if (bVar2 instanceof l) {
                c0010a = c0010a2 == null ? new C0010a(rVar) : c0010a2;
                c0010a.CX.add((l) bVar2);
            } else {
                c0010a = c0010a2;
            }
            size2--;
            c0010a2 = c0010a;
        }
        if (c0010a2 != null) {
            this.CL.add(c0010a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.CP.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.CO.getValue().floatValue() * com.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.bb("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.CW != null) {
            this.paint.setColorFilter(this.CW.getValue());
        }
        for (int i2 = 0; i2 < this.CL.size(); i2++) {
            C0010a c0010a = this.CL.get(i2);
            if (c0010a.CY != null) {
                a(canvas, c0010a, matrix);
            } else {
                com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0010a.CX.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0010a.CX.get(size)).iW(), matrix);
                }
                com.airbnb.lottie.d.bb("StrokeContent#buildPath");
                com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.airbnb.lottie.d.bb("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.d.bb("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0010a c0010a, Matrix matrix) {
        float f;
        com.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0010a.CY == null) {
            com.airbnb.lottie.d.bb("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0010a.CX.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0010a.CX.get(size)).iW(), matrix);
        }
        this.CI.setPath(this.path, false);
        float length = this.CI.getLength();
        while (true) {
            f = length;
            if (!this.CI.nextContour()) {
                break;
            }
            length = this.CI.getLength() + f;
        }
        float floatValue = (c0010a.CY.jg().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0010a.CY.je().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0010a.CY.jf().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0010a.CX.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.CJ.set(((l) c0010a.CX.get(size2)).iW());
            this.CJ.transform(matrix);
            this.CI.setPath(this.CJ, false);
            float length2 = this.CI.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.d.f.a(this.CJ, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.CJ, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.CJ, this.paint);
                } else {
                    com.airbnb.lottie.d.f.a(this.CJ, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.CJ, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.airbnb.lottie.d.bb("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.CL.size(); i++) {
            C0010a c0010a = this.CL.get(i);
            for (int i2 = 0; i2 < c0010a.CX.size(); i2++) {
                this.path.addPath(((l) c0010a.CX.get(i2)).iW(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.CO.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.bb("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.CQ.isEmpty()) {
            com.airbnb.lottie.d.bb("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.CQ.size()) {
                break;
            }
            this.CN[i2] = this.CQ.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.CN[i2] < 1.0f) {
                    this.CN[i2] = 1.0f;
                }
            } else if (this.CN[i2] < 0.1f) {
                this.CN[i2] = 0.1f;
            }
            float[] fArr = this.CN;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.CN, this.CV == null ? 0.0f : this.CV.getValue().floatValue()));
        com.airbnb.lottie.d.bb("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.BY) {
            this.CP.a(cVar);
        } else if (t == com.airbnb.lottie.k.Cf) {
            this.CO.a(cVar);
        } else if (t == com.airbnb.lottie.k.Cs) {
            if (cVar == null) {
                this.CW = null;
                return;
            }
            this.CW = new com.airbnb.lottie.a.b.p(cVar);
            this.CW.b(this);
            this.CK.a(this.CW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0010a {
        private final List<l> CX;
        @Nullable
        private final r CY;

        private C0010a(@Nullable r rVar) {
            this.CX = new ArrayList();
            this.CY = rVar;
        }
    }
}
