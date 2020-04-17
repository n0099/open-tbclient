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
    private final com.airbnb.lottie.model.layer.a Bm;
    private final float[] Bo;
    private final com.airbnb.lottie.a.b.a<?, Float> Bp;
    private final com.airbnb.lottie.a.b.a<?, Integer> Bq;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> Br;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> Bs;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> Bt;
    private final com.airbnb.lottie.g lottieDrawable;
    private final PathMeasure Bk = new PathMeasure();
    private final Path path = new Path();
    private final Path Bl = new Path();
    private final RectF rect = new RectF();
    private final List<C0009a> Bn = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.b bVar, List<com.airbnb.lottie.model.a.b> list, com.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = gVar;
        this.Bm = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.Bq = dVar.hK();
        this.Bp = bVar.hK();
        if (bVar2 == null) {
            this.Bs = null;
        } else {
            this.Bs = bVar2.hK();
        }
        this.Br = new ArrayList(list.size());
        this.Bo = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.Br.add(list.get(i).hK());
        }
        aVar.a(this.Bq);
        aVar.a(this.Bp);
        for (int i2 = 0; i2 < this.Br.size(); i2++) {
            aVar.a(this.Br.get(i2));
        }
        if (this.Bs != null) {
            aVar.a(this.Bs);
        }
        this.Bq.b(this);
        this.Bp.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.Br.get(i3).b(this);
        }
        if (this.Bs != null) {
            this.Bs.b(this);
        }
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void ha() {
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
            rVar = ((bVar instanceof r) && ((r) bVar).hk() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0009a c0009a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).hk() == ShapeTrimPath.Type.Individually) {
                if (c0009a2 != null) {
                    this.Bn.add(c0009a2);
                }
                C0009a c0009a3 = new C0009a((r) bVar2);
                ((r) bVar2).a(this);
                c0009a = c0009a3;
            } else if (bVar2 instanceof l) {
                c0009a = c0009a2 == null ? new C0009a(rVar) : c0009a2;
                c0009a.Bu.add((l) bVar2);
            } else {
                c0009a = c0009a2;
            }
            size2--;
            c0009a2 = c0009a;
        }
        if (c0009a2 != null) {
            this.Bn.add(c0009a2);
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.airbnb.lottie.d.e.clamp((int) (((this.Bq.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.Bp.getValue().floatValue() * com.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.aV("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.Bt != null) {
            this.paint.setColorFilter(this.Bt.getValue());
        }
        for (int i2 = 0; i2 < this.Bn.size(); i2++) {
            C0009a c0009a = this.Bn.get(i2);
            if (c0009a.Bv != null) {
                a(canvas, c0009a, matrix);
            } else {
                com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0009a.Bu.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0009a.Bu.get(size)).hd(), matrix);
                }
                com.airbnb.lottie.d.aV("StrokeContent#buildPath");
                com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.airbnb.lottie.d.aV("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.d.aV("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0009a c0009a, Matrix matrix) {
        float f;
        com.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0009a.Bv == null) {
            com.airbnb.lottie.d.aV("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0009a.Bu.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0009a.Bu.get(size)).hd(), matrix);
        }
        this.Bk.setPath(this.path, false);
        float length = this.Bk.getLength();
        while (true) {
            f = length;
            if (!this.Bk.nextContour()) {
                break;
            }
            length = this.Bk.getLength() + f;
        }
        float floatValue = (c0009a.Bv.hn().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0009a.Bv.hl().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0009a.Bv.hm().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0009a.Bu.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.Bl.set(((l) c0009a.Bu.get(size2)).hd());
            this.Bl.transform(matrix);
            this.Bk.setPath(this.Bl, false);
            float length2 = this.Bk.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.airbnb.lottie.d.f.a(this.Bl, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.Bl, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.Bl, this.paint);
                } else {
                    com.airbnb.lottie.d.f.a(this.Bl, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.Bl, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.airbnb.lottie.d.aV("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.Bn.size(); i++) {
            C0009a c0009a = this.Bn.get(i);
            for (int i2 = 0; i2 < c0009a.Bu.size(); i2++) {
                this.path.addPath(((l) c0009a.Bu.get(i2)).hd(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.Bp.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.aV("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.Br.isEmpty()) {
            com.airbnb.lottie.d.aV("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Br.size()) {
                break;
            }
            this.Bo[i2] = this.Br.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.Bo[i2] < 1.0f) {
                    this.Bo[i2] = 1.0f;
                }
            } else if (this.Bo[i2] < 0.1f) {
                this.Bo[i2] = 0.1f;
            }
            float[] fArr = this.Bo;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.Bo, this.Bs == null ? 0.0f : this.Bs.getValue().floatValue()));
        com.airbnb.lottie.d.aV("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.Ay) {
            this.Bq.a(cVar);
        } else if (t == com.airbnb.lottie.k.AF) {
            this.Bp.a(cVar);
        } else if (t == com.airbnb.lottie.k.AV) {
            if (cVar == null) {
                this.Bt = null;
                return;
            }
            this.Bt = new com.airbnb.lottie.a.b.p(cVar);
            this.Bt.b(this);
            this.Bm.a(this.Bt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0009a {
        private final List<l> Bu;
        @Nullable
        private final r Bv;

        private C0009a(@Nullable r rVar) {
            this.Bu = new ArrayList();
            this.Bv = rVar;
        }
    }
}
