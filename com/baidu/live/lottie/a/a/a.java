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
/* loaded from: classes9.dex */
public abstract class a implements d, j, a.InterfaceC0185a {
    private final float[] Du;
    private final List<com.baidu.live.lottie.a.b.a<?, Float>> Dx;
    private final com.baidu.live.lottie.model.layer.a boN;
    private final com.baidu.live.lottie.a.b.a<?, Float> boO;
    private final com.baidu.live.lottie.a.b.a<?, Integer> boP;
    @Nullable
    private final com.baidu.live.lottie.a.b.a<?, Float> boQ;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> boR;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final PathMeasure Dq = new PathMeasure();
    private final Path path = new Path();
    private final Path Dr = new Path();
    private final RectF rect = new RectF();
    private final List<C0184a> Dt = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.b bVar, List<com.baidu.live.lottie.model.a.b> list, com.baidu.live.lottie.model.a.b bVar2) {
        this.lottieDrawable = hVar;
        this.boN = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.boP = dVar.LU();
        this.boO = bVar.LU();
        if (bVar2 == null) {
            this.boQ = null;
        } else {
            this.boQ = bVar2.LU();
        }
        this.Dx = new ArrayList(list.size());
        this.Du = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.Dx.add(list.get(i).LU());
        }
        aVar.a(this.boP);
        aVar.a(this.boO);
        for (int i2 = 0; i2 < this.Dx.size(); i2++) {
            aVar.a(this.Dx.get(i2));
        }
        if (this.boQ != null) {
            aVar.a(this.boQ);
        }
        this.boP.b(this);
        this.boO.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.Dx.get(i3).b(this);
        }
        if (this.boQ != null) {
            this.boQ.b(this);
        }
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0185a
    public void is() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        C0184a c0184a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).LK() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0184a c0184a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).LK() == ShapeTrimPath.Type.Individually) {
                if (c0184a2 != null) {
                    this.Dt.add(c0184a2);
                }
                C0184a c0184a3 = new C0184a((r) bVar2);
                ((r) bVar2).a(this);
                c0184a = c0184a3;
            } else if (bVar2 instanceof l) {
                c0184a = c0184a2 == null ? new C0184a(rVar) : c0184a2;
                c0184a.DA.add((l) bVar2);
            } else {
                c0184a = c0184a2;
            }
            size2--;
            c0184a2 = c0184a;
        }
        if (c0184a2 != null) {
            this.Dt.add(c0184a2);
        }
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.baidu.live.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.baidu.live.lottie.d.e.clamp((int) (((this.boP.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.boO.getValue().floatValue() * com.baidu.live.lottie.d.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.baidu.live.lottie.d.bb("StrokeContent#draw");
            return;
        }
        b(matrix);
        if (this.boR != null) {
            this.paint.setColorFilter(this.boR.getValue());
        }
        for (int i2 = 0; i2 < this.Dt.size(); i2++) {
            C0184a c0184a = this.Dt.get(i2);
            if (c0184a.boS != null) {
                a(canvas, c0184a, matrix);
            } else {
                com.baidu.live.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0184a.DA.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0184a.DA.get(size)).iv(), matrix);
                }
                com.baidu.live.lottie.d.bb("StrokeContent#buildPath");
                com.baidu.live.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.baidu.live.lottie.d.bb("StrokeContent#drawPath");
            }
        }
        com.baidu.live.lottie.d.bb("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0184a c0184a, Matrix matrix) {
        float f;
        com.baidu.live.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0184a.boS == null) {
            com.baidu.live.lottie.d.bb("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0184a.DA.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0184a.DA.get(size)).iv(), matrix);
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
        float floatValue = (c0184a.boS.LN().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0184a.boS.LL().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0184a.boS.LM().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0184a.DA.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.Dr.set(((l) c0184a.DA.get(size2)).iv());
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
            C0184a c0184a = this.Dt.get(i);
            for (int i2 = 0; i2 < c0184a.DA.size(); i2++) {
                this.path.addPath(((l) c0184a.DA.get(i2)).iv(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.boO.getValue().floatValue();
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
        this.paint.setPathEffect(new DashPathEffect(this.Du, this.boQ == null ? 0.0f : this.boQ.getValue().floatValue()));
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
            this.boP.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CJ) {
            this.boO.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Db) {
            if (cVar == null) {
                this.boR = null;
                return;
            }
            this.boR = new com.baidu.live.lottie.a.b.p(cVar);
            this.boR.b(this);
            this.boN.a(this.boR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C0184a {
        private final List<l> DA;
        @Nullable
        private final r boS;

        private C0184a(@Nullable r rVar) {
            this.DA = new ArrayList();
            this.boS = rVar;
        }
    }
}
