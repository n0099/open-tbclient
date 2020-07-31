package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class b extends a {
    private final List<a> Ap;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Fk;
    private final RectF Fl;
    @Nullable
    private Boolean Fm;
    @Nullable
    private Boolean Fn;
    private final RectF rect;

    public b(com.airbnb.lottie.g gVar, Layer layer, List<Layer> list, com.airbnb.lottie.e eVar) {
        super(gVar, layer);
        a aVar;
        a aVar2;
        this.Ap = new ArrayList();
        this.rect = new RectF();
        this.Fl = new RectF();
        com.airbnb.lottie.model.a.b jj = layer.jj();
        if (jj != null) {
            this.Fk = jj.ia();
            a(this.Fk);
            this.Fk.b(this);
        } else {
            this.Fk = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.gX().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), gVar, eVar);
            if (a == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a.iS().getId(), a);
                if (aVar3 != null) {
                    aVar3.b(a);
                    aVar2 = null;
                } else {
                    this.Ap.add(0, a);
                    switch (r0.jd()) {
                        case Add:
                        case Invert:
                            aVar2 = a;
                            continue;
                        default:
                            aVar2 = aVar3;
                            continue;
                    }
                }
            }
            size--;
            aVar3 = aVar2;
        }
        for (int i = 0; i < longSparseArray.size(); i++) {
            a aVar4 = (a) longSparseArray.get(longSparseArray.keyAt(i));
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.iS().je())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        int save = canvas.save();
        this.Fl.set(0.0f, 0.0f, this.Fa.ja(), this.Fa.jb());
        matrix.mapRect(this.Fl);
        for (int size = this.Ap.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.Fl.isEmpty()) {
                z = canvas.clipRect(this.Fl);
            }
            if (z) {
                this.Ap.get(size).a(canvas, matrix, i);
            }
        }
        if (save > 0) {
            canvas.restoreToCount(save);
        }
        com.airbnb.lottie.d.aW("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.Ap.size() - 1; size >= 0; size--) {
            this.Ap.get(size).a(this.rect, this.EZ);
            if (rectF.isEmpty()) {
                rectF.set(this.rect);
            } else {
                rectF.set(Math.min(rectF.left, this.rect.left), Math.min(rectF.top, this.rect.top), Math.max(rectF.right, this.rect.right), Math.max(rectF.bottom, this.rect.bottom));
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.setProgress(f);
        if (this.Fk != null) {
            f = (this.Fk.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().gT();
        }
        if (this.Fa.iX() != 0.0f) {
            f /= this.Fa.iX();
        }
        float iY = f - this.Fa.iY();
        for (int size = this.Ap.size() - 1; size >= 0; size--) {
            this.Ap.get(size).setProgress(iY);
        }
    }

    public boolean hasMasks() {
        if (this.Fn == null) {
            for (int size = this.Ap.size() - 1; size >= 0; size--) {
                a aVar = this.Ap.get(size);
                if (aVar instanceof e) {
                    if (aVar.iV()) {
                        this.Fn = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.Fn = true;
                    return true;
                }
            }
            this.Fn = false;
        }
        return this.Fn.booleanValue();
    }

    public boolean hasMatte() {
        if (this.Fm == null) {
            if (iT()) {
                this.Fm = true;
                return true;
            }
            for (int size = this.Ap.size() - 1; size >= 0; size--) {
                if (this.Ap.get(size).iT()) {
                    this.Fm = true;
                    return true;
                }
            }
            this.Fm = false;
        }
        return this.Fm.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.Ap.size()) {
                this.Ap.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.airbnb.lottie.e.c<b>) cVar);
        if (t == k.Bw) {
            if (cVar == null) {
                this.Fk = null;
                return;
            }
            this.Fk = new p(cVar);
            a(this.Fk);
        }
    }
}
