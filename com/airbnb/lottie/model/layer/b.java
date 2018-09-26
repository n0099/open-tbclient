package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends a {
    private final List<a> mN;
    private final RectF rect;
    @Nullable
    private final com.airbnb.lottie.a.b.a<Float, Float> rq;
    private final RectF rr;

    public b(com.airbnb.lottie.f fVar, Layer layer, List<Layer> list, com.airbnb.lottie.e eVar) {
        super(fVar, layer);
        a aVar;
        this.mN = new ArrayList();
        this.rect = new RectF();
        this.rr = new RectF();
        com.airbnb.lottie.model.a.b eF = layer.eF();
        if (eF != null) {
            this.rq = eF.dp();
            a(this.rq);
            this.rq.b(this);
        } else {
            this.rq = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.cp().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), fVar, eVar);
            if (a == null) {
                aVar = aVar2;
            } else {
                longSparseArray.put(a.ep().getId(), a);
                if (aVar2 != null) {
                    aVar2.b(a);
                    aVar = null;
                } else {
                    this.mN.add(0, a);
                    switch (r0.ez()) {
                        case Add:
                        case Invert:
                            aVar = a;
                            continue;
                        default:
                            aVar = aVar2;
                            continue;
                    }
                }
            }
            size--;
            aVar2 = aVar;
        }
        for (int i = 0; i < longSparseArray.size(); i++) {
            a aVar3 = (a) longSparseArray.get(longSparseArray.keyAt(i));
            a aVar4 = (a) longSparseArray.get(aVar3.ep().eA());
            if (aVar4 != null) {
                aVar3.c(aVar4);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        canvas.save();
        this.rr.set(0.0f, 0.0f, this.rf.ew(), this.rf.ex());
        matrix.mapRect(this.rr);
        for (int size = this.mN.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.rr.isEmpty()) {
                z = canvas.clipRect(this.rr);
            }
            if (z) {
                this.mN.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.airbnb.lottie.d.U("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.mN.size() - 1; size >= 0; size--) {
            this.mN.get(size).a(this.rect, this.re);
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
        if (this.rq != null) {
            f = (this.rq.getValue().floatValue() * 1000.0f) / ((float) this.mp.cC().getDuration());
        }
        if (this.rf.eu() != 0.0f) {
            f /= this.rf.eu();
        }
        float cH = f - this.rf.cH();
        for (int size = this.mN.size() - 1; size >= 0; size--) {
            this.mN.get(size).setProgress(cH);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mN.size()) {
                a aVar = this.mN.get(i2);
                String name = aVar.ep().getName();
                if (str == null) {
                    aVar.b((String) null, (String) null, colorFilter);
                } else if (name.equals(str)) {
                    aVar.b(str, str2, colorFilter);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
