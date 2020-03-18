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
    private final List<a> eb;
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> jk;
    private final RectF jl;
    @Nullable
    private Boolean jm;
    @Nullable
    private Boolean jn;
    private final RectF rect;

    public b(com.airbnb.lottie.g gVar, Layer layer, List<Layer> list, com.airbnb.lottie.e eVar) {
        super(gVar, layer);
        a aVar;
        a aVar2;
        this.eb = new ArrayList();
        this.rect = new RectF();
        this.jl = new RectF();
        com.airbnb.lottie.model.a.b du = layer.du();
        if (du != null) {
            this.jk = du.cn();
            a(this.jk);
            this.jk.b(this);
        } else {
            this.jk = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.bk().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), gVar, eVar);
            if (a == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a.dd().getId(), a);
                if (aVar3 != null) {
                    aVar3.b(a);
                    aVar2 = null;
                } else {
                    this.eb.add(0, a);
                    switch (r0.m7do()) {
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.dd().dp())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        int save = canvas.save();
        this.jl.set(0.0f, 0.0f, this.iZ.dl(), this.iZ.dm());
        matrix.mapRect(this.jl);
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.jl.isEmpty()) {
                z = canvas.clipRect(this.jl);
            }
            if (z) {
                this.eb.get(size).a(canvas, matrix, i);
            }
        }
        if (save > 0) {
            canvas.restoreToCount(save);
        }
        com.airbnb.lottie.d.F("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            this.eb.get(size).a(this.rect, this.iY);
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
        if (this.jk != null) {
            f = (this.jk.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().bg();
        }
        if (this.iZ.di() != 0.0f) {
            f /= this.iZ.di();
        }
        float dj = f - this.iZ.dj();
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            this.eb.get(size).setProgress(dj);
        }
    }

    public boolean hasMasks() {
        if (this.jn == null) {
            for (int size = this.eb.size() - 1; size >= 0; size--) {
                a aVar = this.eb.get(size);
                if (aVar instanceof e) {
                    if (aVar.dg()) {
                        this.jn = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.jn = true;
                    return true;
                }
            }
            this.jn = false;
        }
        return this.jn.booleanValue();
    }

    public boolean hasMatte() {
        if (this.jm == null) {
            if (de()) {
                this.jm = true;
                return true;
            }
            for (int size = this.eb.size() - 1; size >= 0; size--) {
                if (this.eb.get(size).de()) {
                    this.jm = true;
                    return true;
                }
            }
            this.jm = false;
        }
        return this.jm.booleanValue();
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
        if (t == k.fn) {
            if (cVar == null) {
                this.jk = null;
                return;
            }
            this.jk = new p(cVar);
            a(this.jk);
        }
    }
}
