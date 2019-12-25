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
/* loaded from: classes4.dex */
public class b extends a {
    private final List<a> ec;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> ji;
    private final RectF jj;
    @Nullable
    private Boolean jk;
    @Nullable
    private Boolean jl;
    private final RectF rect;

    public b(com.airbnb.lottie.g gVar, Layer layer, List<Layer> list, com.airbnb.lottie.e eVar) {
        super(gVar, layer);
        a aVar;
        a aVar2;
        this.ec = new ArrayList();
        this.rect = new RectF();
        this.jj = new RectF();
        com.airbnb.lottie.model.a.b dt = layer.dt();
        if (dt != null) {
            this.ji = dt.cm();
            a(this.ji);
            this.ji.b(this);
        } else {
            this.ji = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.bj().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), gVar, eVar);
            if (a == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a.dc().getId(), a);
                if (aVar3 != null) {
                    aVar3.b(a);
                    aVar2 = null;
                } else {
                    this.ec.add(0, a);
                    switch (r0.dn()) {
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.dc().m6do())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        canvas.save();
        this.jj.set(0.0f, 0.0f, this.iX.dk(), this.iX.dl());
        matrix.mapRect(this.jj);
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.jj.isEmpty()) {
                z = canvas.clipRect(this.jj);
            }
            if (z) {
                this.ec.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.airbnb.lottie.d.F("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            this.ec.get(size).a(this.rect, this.iW);
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
        if (this.ji != null) {
            f = (this.ji.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().bf();
        }
        if (this.iX.dh() != 0.0f) {
            f /= this.iX.dh();
        }
        float di = f - this.iX.di();
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            this.ec.get(size).setProgress(di);
        }
    }

    public boolean hasMasks() {
        if (this.jl == null) {
            for (int size = this.ec.size() - 1; size >= 0; size--) {
                a aVar = this.ec.get(size);
                if (aVar instanceof e) {
                    if (aVar.df()) {
                        this.jl = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.jl = true;
                    return true;
                }
            }
            this.jl = false;
        }
        return this.jl.booleanValue();
    }

    public boolean hasMatte() {
        if (this.jk == null) {
            if (dd()) {
                this.jk = true;
                return true;
            }
            for (int size = this.ec.size() - 1; size >= 0; size--) {
                if (this.ec.get(size).dd()) {
                    this.jk = true;
                    return true;
                }
            }
            this.jk = false;
        }
        return this.jk.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.ec.size()) {
                this.ec.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.airbnb.lottie.e.c<b>) cVar);
        if (t == k.fj) {
            if (cVar == null) {
                this.ji = null;
                return;
            }
            this.ji = new p(cVar);
            a(this.ji);
        }
    }
}
