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
/* loaded from: classes7.dex */
public abstract class a implements d, j, a.InterfaceC0011a {
    private final com.airbnb.lottie.model.layer.a DH;
    private final float[] DJ;
    private final com.airbnb.lottie.a.b.a<?, Float> DK;
    private final com.airbnb.lottie.a.b.a<?, Integer> DM;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> DN;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> DO;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> DQ;
    private final com.airbnb.lottie.g lottieDrawable;
    private final PathMeasure DE = new PathMeasure();
    private final Path path = new Path();
    private final Path DG = new Path();
    private final RectF rect = new RectF();
    private final List<C0010a> DI = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = gVar;
        this.DH = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.DM = dVar.jD();
        this.DK = bVar.jD();
        if (bVar2 == null) {
            this.DO = null;
        } else {
            this.DO = bVar2.jD();
        }
        this.DN = new ArrayList(list.size());
        this.DJ = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.DN.add(list.get(i).jD());
        }
        aVar.a(this.DM);
        aVar.a(this.DK);
        for (int i2 = 0; i2 < this.DN.size(); i2++) {
            aVar.a(this.DN.get(i2));
        }
        if (this.DO != null) {
            aVar.a(this.DO);
        }
        this.DM.b(this);
        this.DK.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.DN.get(i3).b(this);
        }
        if (this.DO != null) {
            this.DO.b(this);
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
                    this.DI.add(c0010a2);
                }
                C0010a c0010a3 = new C0010a((r) bVar2);
                ((r) bVar2).a(this);
                c0010a = c0010a3;
            } else if (bVar2 instanceof l) {
                c0010a = c0010a2 == null ? new C0010a(rVar) : c0010a2;
                c0010a.DR.add((l) bVar2);
            } else {
                c0010a = c0010a2;
            }
            size2--;
            c0010a2 = c0010a;
        }
        if (c0010a2 != null) {
            this.DI.add(c0010a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.DM.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.DK.getValue().floatValue() * com.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.be("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.DQ != null) {
            this.paint.setColorFilter(this.DQ.getValue());
        }
        for (int i2 = 0; i2 < this.DI.size(); i2++) {
            C0010a c0010a = this.DI.get(i2);
            if (c0010a.DS != null) {
                a(canvas, c0010a, matrix);
            } else {
                com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0010a.DR.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0010a.DR.get(size)).iW(), matrix);
                }
                com.airbnb.lottie.d.be("StrokeContent#buildPath");
                com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.airbnb.lottie.d.be("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.d.be("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0010a c0010a, Matrix matrix) {
        float f;
        com.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0010a.DS == null) {
            com.airbnb.lottie.d.be("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0010a.DR.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0010a.DR.get(size)).iW(), matrix);
        }
        this.DE.setPath(this.path, false);
        float length = this.DE.getLength();
        while (true) {
            f = length;
            if (!this.DE.nextContour()) {
                break;
            }
            length = this.DE.getLength() + f;
        }
        float floatValue = (c0010a.DS.jg().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0010a.DS.je().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0010a.DS.jf().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0010a.DR.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.DG.set(((l) c0010a.DR.get(size2)).iW());
            this.DG.transform(matrix);
            this.DE.setPath(this.DG, false);
            float length2 = this.DE.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.d.f.a(this.DG, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.DG, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.DG, this.paint);
                } else {
                    com.airbnb.lottie.d.f.a(this.DG, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.DG, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.airbnb.lottie.d.be("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.DI.size(); i++) {
            C0010a c0010a = this.DI.get(i);
            for (int i2 = 0; i2 < c0010a.DR.size(); i2++) {
                this.path.addPath(((l) c0010a.DR.get(i2)).iW(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.DK.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.be("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.DN.isEmpty()) {
            com.airbnb.lottie.d.be("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.DN.size()) {
                break;
            }
            this.DJ[i2] = this.DN.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.DJ[i2] < 1.0f) {
                    this.DJ[i2] = 1.0f;
                }
            } else if (this.DJ[i2] < 0.1f) {
                this.DJ[i2] = 0.1f;
            }
            float[] fArr = this.DJ;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.DJ, this.DO == null ? 0.0f : this.DO.getValue().floatValue()));
        com.airbnb.lottie.d.be("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.CQ) {
            this.DM.a(cVar);
        } else if (t == com.airbnb.lottie.k.Db) {
            this.DK.a(cVar);
        } else if (t == com.airbnb.lottie.k.Do) {
            if (cVar == null) {
                this.DQ = null;
                return;
            }
            this.DQ = new com.airbnb.lottie.a.b.p(cVar);
            this.DQ.b(this);
            this.DH.a(this.DQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0010a {
        private final List<l> DR;
        @Nullable
        private final r DS;

        private C0010a(@Nullable r rVar) {
            this.DR = new ArrayList();
            this.DS = rVar;
        }
    }
}
