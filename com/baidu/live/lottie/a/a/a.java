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
public abstract class a implements d, j, a.InterfaceC0192a {
    private final float[] ER;
    private final List<com.baidu.live.lottie.a.b.a<?, Float>> EU;
    private final com.baidu.live.lottie.model.layer.a btP;
    private final com.baidu.live.lottie.a.b.a<?, Float> btQ;
    private final com.baidu.live.lottie.a.b.a<?, Integer> btR;
    @Nullable
    private final com.baidu.live.lottie.a.b.a<?, Float> btS;
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> btT;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final PathMeasure EM = new PathMeasure();
    private final Path path = new Path();
    private final Path EN = new Path();
    private final RectF rect = new RectF();
    private final List<C0191a> EP = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.baidu.live.lottie.model.a.d dVar, com.baidu.live.lottie.model.a.b bVar, List<com.baidu.live.lottie.model.a.b> list, com.baidu.live.lottie.model.a.b bVar2) {
        this.lottieDrawable = hVar;
        this.btP = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.btR = dVar.Nv();
        this.btQ = bVar.Nv();
        if (bVar2 == null) {
            this.btS = null;
        } else {
            this.btS = bVar2.Nv();
        }
        this.EU = new ArrayList(list.size());
        this.ER = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.EU.add(list.get(i).Nv());
        }
        aVar.a(this.btR);
        aVar.a(this.btQ);
        for (int i2 = 0; i2 < this.EU.size(); i2++) {
            aVar.a(this.EU.get(i2));
        }
        if (this.btS != null) {
            aVar.a(this.btS);
        }
        this.btR.b(this);
        this.btQ.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.EU.get(i3).b(this);
        }
        if (this.btS != null) {
            this.btS.b(this);
        }
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0192a
    public void ir() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0191a c0191a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).Nl() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0191a c0191a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).Nl() == ShapeTrimPath.Type.Individually) {
                if (c0191a2 != null) {
                    this.EP.add(c0191a2);
                }
                C0191a c0191a3 = new C0191a((r) bVar2);
                ((r) bVar2).a(this);
                c0191a = c0191a3;
            } else if (bVar2 instanceof l) {
                c0191a = c0191a2 == null ? new C0191a(rVar) : c0191a2;
                c0191a.EX.add((l) bVar2);
            } else {
                c0191a = c0191a2;
            }
            size2--;
            c0191a2 = c0191a;
        }
        if (c0191a2 != null) {
            this.EP.add(c0191a2);
        }
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.baidu.live.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.baidu.live.lottie.d.e.clamp((int) (((this.btR.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.btQ.getValue().floatValue() * com.baidu.live.lottie.d.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.baidu.live.lottie.d.bf("StrokeContent#draw");
            return;
        }
        b(matrix);
        if (this.btT != null) {
            this.paint.setColorFilter(this.btT.getValue());
        }
        for (int i2 = 0; i2 < this.EP.size(); i2++) {
            C0191a c0191a = this.EP.get(i2);
            if (c0191a.btU != null) {
                a(canvas, c0191a, matrix);
            } else {
                com.baidu.live.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0191a.EX.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0191a.EX.get(size)).iu(), matrix);
                }
                com.baidu.live.lottie.d.bf("StrokeContent#buildPath");
                com.baidu.live.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.baidu.live.lottie.d.bf("StrokeContent#drawPath");
            }
        }
        com.baidu.live.lottie.d.bf("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0191a c0191a, Matrix matrix) {
        float f;
        com.baidu.live.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0191a.btU == null) {
            com.baidu.live.lottie.d.bf("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0191a.EX.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0191a.EX.get(size)).iu(), matrix);
        }
        this.EM.setPath(this.path, false);
        float length = this.EM.getLength();
        while (true) {
            f = length;
            if (!this.EM.nextContour()) {
                break;
            }
            length = this.EM.getLength() + f;
        }
        float floatValue = (c0191a.btU.No().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0191a.btU.Nm().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0191a.btU.Nn().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0191a.EX.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.EN.set(((l) c0191a.EX.get(size2)).iu());
            this.EN.transform(matrix);
            this.EM.setPath(this.EN, false);
            float length2 = this.EM.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.baidu.live.lottie.d.f.b(this.EN, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.EN, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.EN, this.paint);
                } else {
                    com.baidu.live.lottie.d.f.b(this.EN, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.EN, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.baidu.live.lottie.d.bf("StrokeContent#applyTrimPath");
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        com.baidu.live.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.EP.size(); i++) {
            C0191a c0191a = this.EP.get(i);
            for (int i2 = 0; i2 < c0191a.EX.size(); i2++) {
                this.path.addPath(((l) c0191a.EX.get(i2)).iu(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.btQ.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.baidu.live.lottie.d.bf("StrokeContent#getBounds");
    }

    private void b(Matrix matrix) {
        com.baidu.live.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.EU.isEmpty()) {
            com.baidu.live.lottie.d.bf("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.baidu.live.lottie.d.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.EU.size()) {
                break;
            }
            this.ER[i2] = this.EU.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.ER[i2] < 1.0f) {
                    this.ER[i2] = 1.0f;
                }
            } else if (this.ER[i2] < 0.1f) {
                this.ER[i2] = 0.1f;
            }
            float[] fArr = this.ER;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.ER, this.btS == null ? 0.0f : this.btS.getValue().floatValue()));
        com.baidu.live.lottie.d.bf("StrokeContent#applyDashPattern");
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.Ed) {
            this.btR.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Ek) {
            this.btQ.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Ex) {
            if (cVar == null) {
                this.btT = null;
                return;
            }
            this.btT = new com.baidu.live.lottie.a.b.p(cVar);
            this.btT.b(this);
            this.btP.a(this.btT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C0191a {
        private final List<l> EX;
        @Nullable
        private final r btU;

        private C0191a(@Nullable r rVar) {
            this.EX = new ArrayList();
            this.btU = rVar;
        }
    }
}
