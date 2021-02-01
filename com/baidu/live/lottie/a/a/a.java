package com.baidu.live.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a implements d, j, a.InterfaceC0186a {
    private final float[] Du;
    private final List<com.baidu.live.lottie.a.b.a<?, Float>> Dx;
    private final com.baidu.live.lottie.model.layer.a bso;
    private final com.baidu.live.lottie.a.b.a<?, Float> bsp;
    private final com.baidu.live.lottie.a.b.a<?, Integer> bsq;
    @Nullable
    private final com.baidu.live.lottie.a.b.a<?, Float> bsr;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> bss;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final PathMeasure Dq = new PathMeasure();
    private final Path path = new Path();
    private final Path Dr = new Path();
    private final RectF rect = new RectF();
    private final List<C0185a> Dt = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.b bVar, List<com.baidu.live.lottie.model.a.b> list, com.baidu.live.lottie.model.a.b bVar2) {
        this.lottieDrawable = hVar;
        this.bso = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.bsq = dVar.Ns();
        this.bsp = bVar.Ns();
        if (bVar2 == null) {
            this.bsr = null;
        } else {
            this.bsr = bVar2.Ns();
        }
        this.Dx = new ArrayList(list.size());
        this.Du = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.Dx.add(list.get(i).Ns());
        }
        aVar.a(this.bsq);
        aVar.a(this.bsp);
        for (int i2 = 0; i2 < this.Dx.size(); i2++) {
            aVar.a(this.Dx.get(i2));
        }
        if (this.bsr != null) {
            aVar.a(this.bsr);
        }
        this.bsq.b(this);
        this.bsp.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.Dx.get(i3).b(this);
        }
        if (this.bsr != null) {
            this.bsr.b(this);
        }
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0186a
    public void ir() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        C0185a c0185a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).Ni() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0185a c0185a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).Ni() == ShapeTrimPath.Type.Individually) {
                if (c0185a2 != null) {
                    this.Dt.add(c0185a2);
                }
                C0185a c0185a3 = new C0185a((r) bVar2);
                ((r) bVar2).a(this);
                c0185a = c0185a3;
            } else if (bVar2 instanceof l) {
                c0185a = c0185a2 == null ? new C0185a(rVar) : c0185a2;
                c0185a.DA.add((l) bVar2);
            } else {
                c0185a = c0185a2;
            }
            size2--;
            c0185a2 = c0185a;
        }
        if (c0185a2 != null) {
            this.Dt.add(c0185a2);
        }
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.baidu.live.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.baidu.live.lottie.d.e.clamp((int) (((this.bsq.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.bsp.getValue().floatValue() * com.baidu.live.lottie.d.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.baidu.live.lottie.d.bb("StrokeContent#draw");
            return;
        }
        b(matrix);
        if (this.bss != null) {
            this.paint.setColorFilter(this.bss.getValue());
        }
        for (int i2 = 0; i2 < this.Dt.size(); i2++) {
            C0185a c0185a = this.Dt.get(i2);
            if (c0185a.bst != null) {
                a(canvas, c0185a, matrix);
            } else {
                com.baidu.live.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0185a.DA.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0185a.DA.get(size)).iu(), matrix);
                }
                com.baidu.live.lottie.d.bb("StrokeContent#buildPath");
                com.baidu.live.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.baidu.live.lottie.d.bb("StrokeContent#drawPath");
            }
        }
        com.baidu.live.lottie.d.bb("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0185a c0185a, Matrix matrix) {
        float f;
        com.baidu.live.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0185a.bst == null) {
            com.baidu.live.lottie.d.bb("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0185a.DA.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0185a.DA.get(size)).iu(), matrix);
        }
        this.Dq.setPath(this.path, false);
        float length = this.Dq.getLength();
        while (true) {
            f = length;
            if (!this.Dq.nextContour()) {
                break;
            }
            length = this.Dq.getLength() + f;
        }
        float floatValue = (c0185a.bst.Nl().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0185a.bst.Nj().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0185a.bst.Nk().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0185a.DA.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.Dr.set(((l) c0185a.DA.get(size2)).iu());
            this.Dr.transform(matrix);
            this.Dq.setPath(this.Dr, false);
            float length2 = this.Dq.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.baidu.live.lottie.d.f.b(this.Dr, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.Dr, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.Dr, this.paint);
                } else {
                    com.baidu.live.lottie.d.f.b(this.Dr, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.Dr, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.baidu.live.lottie.d.bb("StrokeContent#applyTrimPath");
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        com.baidu.live.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.Dt.size(); i++) {
            C0185a c0185a = this.Dt.get(i);
            for (int i2 = 0; i2 < c0185a.DA.size(); i2++) {
                this.path.addPath(((l) c0185a.DA.get(i2)).iu(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.bsp.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.baidu.live.lottie.d.bb("StrokeContent#getBounds");
    }

    private void b(Matrix matrix) {
        com.baidu.live.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.Dx.isEmpty()) {
            com.baidu.live.lottie.d.bb("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.baidu.live.lottie.d.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Dx.size()) {
                break;
            }
            this.Du[i2] = this.Dx.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.Du[i2] < 1.0f) {
                    this.Du[i2] = 1.0f;
                }
            } else if (this.Du[i2] < 0.1f) {
                this.Du[i2] = 0.1f;
            }
            float[] fArr = this.Du;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.Du, this.bsr == null ? 0.0f : this.bsr.getValue().floatValue()));
        com.baidu.live.lottie.d.bb("StrokeContent#applyDashPattern");
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.CC) {
            this.bsq.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CJ) {
            this.bsp.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Db) {
            if (cVar == null) {
                this.bss = null;
                return;
            }
            this.bss = new com.baidu.live.lottie.a.b.p(cVar);
            this.bss.b(this);
            this.bso.a(this.bss);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0185a {
        private final List<l> DA;
        @Nullable
        private final r bst;

        private C0185a(@Nullable r rVar) {
            this.DA = new ArrayList();
            this.bst = rVar;
        }
    }
}
