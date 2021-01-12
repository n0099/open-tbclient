package com.baidu.live.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.baidu.live.lottie.a.b.p;
import com.baidu.live.lottie.h;
import com.baidu.live.lottie.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends a {
    private final List<a> BR;
    private final RectF GL;
    @Nullable
    private com.baidu.live.lottie.a.b.a<Float, Float> bqG;
    @Nullable
    private Boolean bqH;
    @Nullable
    private Boolean bqI;
    private final RectF rect;

    public b(h hVar, Layer layer, List<Layer> list, com.baidu.live.lottie.e eVar) {
        super(hVar, layer);
        a aVar;
        a aVar2;
        this.BR = new ArrayList();
        this.rect = new RectF();
        this.GL = new RectF();
        com.baidu.live.lottie.model.a.b MJ = layer.MJ();
        if (MJ != null) {
            this.bqG = MJ.LU();
            a(this.bqG);
            this.bqG.b(this);
        } else {
            this.bqG = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.hW().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a2 = a.a(list.get(size), hVar, eVar);
            if (a2 == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a2.ME().getId(), a2);
                if (aVar3 != null) {
                    aVar3.b(a2);
                    aVar2 = null;
                } else {
                    this.BR.add(0, a2);
                    switch (r0.MG()) {
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.ME().ke())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.baidu.live.lottie.model.layer.a
    void d(Canvas canvas, Matrix matrix, int i) {
        com.baidu.live.lottie.d.beginSection("CompositionLayer#draw");
        canvas.save();
        this.GL.set(0.0f, 0.0f, this.bqA.ka(), this.bqA.kb());
        matrix.mapRect(this.GL);
        for (int size = this.BR.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.GL.isEmpty()) {
                z = canvas.clipRect(this.GL);
            }
            if (z) {
                this.BR.get(size).c(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.baidu.live.lottie.d.bb("CompositionLayer#draw");
    }

    @Override // com.baidu.live.lottie.model.layer.a, com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.BR.size() - 1; size >= 0; size--) {
            this.BR.get(size).d(this.rect, this.Gx);
            if (rectF.isEmpty()) {
                rectF.set(this.rect);
            } else {
                rectF.set(Math.min(rectF.left, this.rect.left), Math.min(rectF.top, this.rect.top), Math.max(rectF.right, this.rect.right), Math.max(rectF.bottom, this.rect.bottom));
            }
        }
    }

    @Override // com.baidu.live.lottie.model.layer.a
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.setProgress(f);
        if (this.bqG != null) {
            f = (this.bqG.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().hS();
        }
        if (this.bqA.jX() != 0.0f) {
            f /= this.bqA.jX();
        }
        float jY = f - this.bqA.jY();
        for (int size = this.BR.size() - 1; size >= 0; size--) {
            this.BR.get(size).setProgress(jY);
        }
    }

    public boolean hasMasks() {
        if (this.bqI == null) {
            for (int size = this.BR.size() - 1; size >= 0; size--) {
                a aVar = this.BR.get(size);
                if (aVar instanceof e) {
                    if (aVar.jV()) {
                        this.bqI = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.bqI = true;
                    return true;
                }
            }
            this.bqI = false;
        }
        return this.bqI.booleanValue();
    }

    public boolean hasMatte() {
        if (this.bqH == null) {
            if (jT()) {
                this.bqH = true;
                return true;
            }
            for (int size = this.BR.size() - 1; size >= 0; size--) {
                if (this.BR.get(size).jT()) {
                    this.bqH = true;
                    return true;
                }
            }
            this.bqH = false;
        }
        return this.bqH.booleanValue();
    }

    @Override // com.baidu.live.lottie.model.layer.a
    protected void b(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.BR.size()) {
                this.BR.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.model.layer.a, com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        super.a((b) t, (com.baidu.live.lottie.e.c<b>) cVar);
        if (t == l.Da) {
            if (cVar == null) {
                this.bqG = null;
                return;
            }
            this.bqG = new p(cVar);
            a(this.bqG);
        }
    }
}
