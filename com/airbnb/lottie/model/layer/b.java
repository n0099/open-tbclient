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
/* loaded from: classes5.dex */
public class b extends a {
    private final List<a> eb;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> jh;
    private final RectF ji;
    @Nullable
    private Boolean jj;
    @Nullable
    private Boolean jk;
    private final RectF rect;

    public b(com.airbnb.lottie.g gVar, Layer layer, List<Layer> list, com.airbnb.lottie.e eVar) {
        super(gVar, layer);
        a aVar;
        a aVar2;
        this.eb = new ArrayList();
        this.rect = new RectF();
        this.ji = new RectF();
        com.airbnb.lottie.model.a.b dt = layer.dt();
        if (dt != null) {
            this.jh = dt.cm();
            a(this.jh);
            this.jh.b(this);
        } else {
            this.jh = null;
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
                    this.eb.add(0, a);
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.dc().m7do())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        canvas.save();
        this.ji.set(0.0f, 0.0f, this.iW.dk(), this.iW.dl());
        matrix.mapRect(this.ji);
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.ji.isEmpty()) {
                z = canvas.clipRect(this.ji);
            }
            if (z) {
                this.eb.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.airbnb.lottie.d.F("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            this.eb.get(size).a(this.rect, this.iV);
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
        if (this.jh != null) {
            f = (this.jh.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().bf();
        }
        if (this.iW.dh() != 0.0f) {
            f /= this.iW.dh();
        }
        float di = f - this.iW.di();
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            this.eb.get(size).setProgress(di);
        }
    }

    public boolean hasMasks() {
        if (this.jk == null) {
            for (int size = this.eb.size() - 1; size >= 0; size--) {
                a aVar = this.eb.get(size);
                if (aVar instanceof e) {
                    if (aVar.df()) {
                        this.jk = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.jk = true;
                    return true;
                }
            }
            this.jk = false;
        }
        return this.jk.booleanValue();
    }

    public boolean hasMatte() {
        if (this.jj == null) {
            if (dd()) {
                this.jj = true;
                return true;
            }
            for (int size = this.eb.size() - 1; size >= 0; size--) {
                if (this.eb.get(size).dd()) {
                    this.jj = true;
                    return true;
                }
            }
            this.jj = false;
        }
        return this.jj.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.eb.size()) {
                this.eb.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.airbnb.lottie.e.c<b>) cVar);
        if (t == k.fi) {
            if (cVar == null) {
                this.jh = null;
                return;
            }
            this.jh = new p(cVar);
            a(this.jh);
        }
    }
}
