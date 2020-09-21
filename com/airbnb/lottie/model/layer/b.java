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
/* loaded from: classes6.dex */
public class b extends a {
    private final List<a> AW;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> FO;
    private final RectF FP;
    @Nullable
    private Boolean FQ;
    @Nullable
    private Boolean FR;
    private final RectF rect;

    public b(com.airbnb.lottie.g gVar, Layer layer, List<Layer> list, com.airbnb.lottie.e eVar) {
        super(gVar, layer);
        a aVar;
        a aVar2;
        this.AW = new ArrayList();
        this.rect = new RectF();
        this.FP = new RectF();
        com.airbnb.lottie.model.a.b kJ = layer.kJ();
        if (kJ != null) {
            this.FO = kJ.jC();
            a(this.FO);
            this.FO.b(this);
        } else {
            this.FO = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.iy().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), gVar, eVar);
            if (a == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a.ks().getId(), a);
                if (aVar3 != null) {
                    aVar3.b(a);
                    aVar2 = null;
                } else {
                    this.AW.add(0, a);
                    switch (r0.kD()) {
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.ks().kE())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        int save = canvas.save();
        this.FP.set(0.0f, 0.0f, this.FE.kA(), this.FE.kB());
        matrix.mapRect(this.FP);
        for (int size = this.AW.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.FP.isEmpty()) {
                z = canvas.clipRect(this.FP);
            }
            if (z) {
                this.AW.get(size).a(canvas, matrix, i);
            }
        }
        if (save > 0) {
            canvas.restoreToCount(save);
        }
        com.airbnb.lottie.d.bb("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.AW.size() - 1; size >= 0; size--) {
            this.AW.get(size).a(this.rect, this.FD);
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
        if (this.FO != null) {
            f = (this.FO.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().iu();
        }
        if (this.FE.kx() != 0.0f) {
            f /= this.FE.kx();
        }
        float ky = f - this.FE.ky();
        for (int size = this.AW.size() - 1; size >= 0; size--) {
            this.AW.get(size).setProgress(ky);
        }
    }

    public boolean hasMasks() {
        if (this.FR == null) {
            for (int size = this.AW.size() - 1; size >= 0; size--) {
                a aVar = this.AW.get(size);
                if (aVar instanceof e) {
                    if (aVar.kv()) {
                        this.FR = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.FR = true;
                    return true;
                }
            }
            this.FR = false;
        }
        return this.FR.booleanValue();
    }

    public boolean hasMatte() {
        if (this.FQ == null) {
            if (kt()) {
                this.FQ = true;
                return true;
            }
            for (int size = this.AW.size() - 1; size >= 0; size--) {
                if (this.AW.get(size).kt()) {
                    this.FQ = true;
                    return true;
                }
            }
            this.FQ = false;
        }
        return this.FQ.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.AW.size()) {
                this.AW.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.airbnb.lottie.e.c<b>) cVar);
        if (t == k.Ca) {
            if (cVar == null) {
                this.FO = null;
                return;
            }
            this.FO = new p(cVar);
            a(this.FO);
        }
    }
}
