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
    private final com.airbnb.lottie.model.layer.a BM;
    private final float[] BO;
    private final com.airbnb.lottie.a.b.a<?, Float> BP;
    private final com.airbnb.lottie.a.b.a<?, Integer> BQ;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> BR;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> BS;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> BT;
    private final com.airbnb.lottie.g lottieDrawable;
    private final PathMeasure BK = new PathMeasure();
    private final Path path = new Path();
    private final Path BL = new Path();
    private final RectF rect = new RectF();
    private final List<C0009a> BN = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = gVar;
        this.BM = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.BQ = dVar.ia();
        this.BP = bVar.ia();
        if (bVar2 == null) {
            this.BS = null;
        } else {
            this.BS = bVar2.ia();
        }
        this.BR = new ArrayList(list.size());
        this.BO = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.BR.add(list.get(i).ia());
        }
        aVar.a(this.BQ);
        aVar.a(this.BP);
        for (int i2 = 0; i2 < this.BR.size(); i2++) {
            aVar.a(this.BR.get(i2));
        }
        if (this.BS != null) {
            aVar.a(this.BS);
        }
        this.BQ.b(this);
        this.BP.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.BR.get(i3).b(this);
        }
        if (this.BS != null) {
            this.BS.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void hq() {
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
            rVar = ((bVar instanceof r) && ((r) bVar).hA() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0009a c0009a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).hA() == ShapeTrimPath.Type.Individually) {
                if (c0009a2 != null) {
                    this.BN.add(c0009a2);
                }
                C0009a c0009a3 = new C0009a((r) bVar2);
                ((r) bVar2).a(this);
                c0009a = c0009a3;
            } else if (bVar2 instanceof l) {
                c0009a = c0009a2 == null ? new C0009a(rVar) : c0009a2;
                c0009a.BU.add((l) bVar2);
            } else {
                c0009a = c0009a2;
            }
            size2--;
            c0009a2 = c0009a;
        }
        if (c0009a2 != null) {
            this.BN.add(c0009a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.BQ.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.BP.getValue().floatValue() * com.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.aW("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.BT != null) {
            this.paint.setColorFilter(this.BT.getValue());
        }
        for (int i2 = 0; i2 < this.BN.size(); i2++) {
            C0009a c0009a = this.BN.get(i2);
            if (c0009a.BV != null) {
                a(canvas, c0009a, matrix);
            } else {
                com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0009a.BU.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0009a.BU.get(size)).ht(), matrix);
                }
                com.airbnb.lottie.d.aW("StrokeContent#buildPath");
                com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.airbnb.lottie.d.aW("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.d.aW("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0009a c0009a, Matrix matrix) {
        float f;
        com.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0009a.BV == null) {
            com.airbnb.lottie.d.aW("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0009a.BU.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0009a.BU.get(size)).ht(), matrix);
        }
        this.BK.setPath(this.path, false);
        float length = this.BK.getLength();
        while (true) {
            f = length;
            if (!this.BK.nextContour()) {
                break;
            }
            length = this.BK.getLength() + f;
        }
        float floatValue = (c0009a.BV.hD().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0009a.BV.hB().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0009a.BV.hC().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0009a.BU.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.BL.set(((l) c0009a.BU.get(size2)).ht());
            this.BL.transform(matrix);
            this.BK.setPath(this.BL, false);
            float length2 = this.BK.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.d.f.a(this.BL, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.BL, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.BL, this.paint);
                } else {
                    com.airbnb.lottie.d.f.a(this.BL, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.BL, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.airbnb.lottie.d.aW("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.BN.size(); i++) {
            C0009a c0009a = this.BN.get(i);
            for (int i2 = 0; i2 < c0009a.BU.size(); i2++) {
                this.path.addPath(((l) c0009a.BU.get(i2)).ht(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.BP.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.aW("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.BR.isEmpty()) {
            com.airbnb.lottie.d.aW("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.BR.size()) {
                break;
            }
            this.BO[i2] = this.BR.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.BO[i2] < 1.0f) {
                    this.BO[i2] = 1.0f;
                }
            } else if (this.BO[i2] < 0.1f) {
                this.BO[i2] = 0.1f;
            }
            float[] fArr = this.BO;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.BO, this.BS == null ? 0.0f : this.BS.getValue().floatValue()));
        com.airbnb.lottie.d.aW("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.Bb) {
            this.BQ.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bi) {
            this.BP.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bv) {
            if (cVar == null) {
                this.BT = null;
                return;
            }
            this.BT = new com.airbnb.lottie.a.b.p(cVar);
            this.BT.b(this);
            this.BM.a(this.BT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0009a {
        private final List<l> BU;
        @Nullable
        private final r BV;

        private C0009a(@Nullable r rVar) {
            this.BU = new ArrayList();
            this.BV = rVar;
        }
    }
}
