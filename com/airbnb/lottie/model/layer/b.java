package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends a {
    private final List<a> Dq;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> Ig;
    private final RectF Ih;
    private final RectF rect;

    public b(com.airbnb.lottie.f fVar, Layer layer, List<Layer> list, com.airbnb.lottie.d dVar) {
        super(fVar, layer);
        a aVar;
        a aVar2;
        this.Dq = new ArrayList();
        this.rect = new RectF();
        this.Ih = new RectF();
        com.airbnb.lottie.model.a.b ki = layer.ki();
        if (ki != null) {
            this.Ig = ki.jb();
            a(this.Ig);
            this.Ig.b(this);
        } else {
            this.Ig = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.hV().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a2 = a.a(list.get(size), fVar, dVar);
            if (a2 == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a2.jR().getId(), a2);
                if (aVar3 != null) {
                    aVar3.b(a2);
                    aVar2 = null;
                } else {
                    this.Dq.add(0, a2);
                    switch (r0.kc()) {
                        case Add:
                        case Invert:
                            aVar2 = a2;
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.jR().kd())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void d(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.c.beginSection("CompositionLayer#draw");
        int save = canvas.save();
        this.Ih.set(0.0f, 0.0f, this.HV.jZ(), this.HV.ka());
        matrix.mapRect(this.Ih);
        for (int size = this.Dq.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.Ih.isEmpty()) {
                z = canvas.clipRect(this.Ih);
            }
            if (z) {
                this.Dq.get(size).c(canvas, matrix, i);
            }
        }
        if (save > 0) {
            canvas.restoreToCount(save);
        }
        com.airbnb.lottie.c.bf("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.Dq.size() - 1; size >= 0; size--) {
            this.Dq.get(size).d(this.rect, this.HU);
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
        if (this.Ig != null) {
            f = (this.Ig.getValue().floatValue() * 1000.0f) / this.Df.getComposition().hR();
        }
        if (this.HV.jW() != 0.0f) {
            f /= this.HV.jW();
        }
        float jX = f - this.HV.jX();
        for (int size = this.Dq.size() - 1; size >= 0; size--) {
            this.Dq.get(size).setProgress(jX);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.Dq.size()) {
                this.Dq.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.airbnb.lottie.e.c<b>) cVar);
        if (t == j.Ew) {
            if (cVar == null) {
                this.Ig = null;
                return;
            }
            this.Ig = new p(cVar);
            a(this.Ig);
        }
    }
}
