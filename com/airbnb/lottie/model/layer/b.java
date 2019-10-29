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
    private final List<a> dz;
    @Nullable
    private final com.airbnb.lottie.a.b.a<Float, Float> hV;
    private final RectF hW;
    private final RectF rect;

    public b(com.airbnb.lottie.f fVar, Layer layer, List<Layer> list, com.airbnb.lottie.e eVar) {
        super(fVar, layer);
        a aVar;
        this.dz = new ArrayList();
        this.rect = new RectF();
        this.hW = new RectF();
        com.airbnb.lottie.model.a.b dp = layer.dp();
        if (dp != null) {
            this.hV = dp.bY();
            a(this.hV);
            this.hV.b(this);
        } else {
            this.hV = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.aW().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), fVar, eVar);
            if (a == null) {
                aVar = aVar2;
            } else {
                longSparseArray.put(a.cZ().getId(), a);
                if (aVar2 != null) {
                    aVar2.b(a);
                    aVar = null;
                } else {
                    this.dz.add(0, a);
                    switch (r0.dj()) {
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
            a aVar4 = (a) longSparseArray.get(aVar3.cZ().dk());
            if (aVar4 != null) {
                aVar3.c(aVar4);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        canvas.save();
        this.hW.set(0.0f, 0.0f, this.hL.dg(), this.hL.dh());
        matrix.mapRect(this.hW);
        for (int size = this.dz.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.hW.isEmpty()) {
                z = canvas.clipRect(this.hW);
            }
            if (z) {
                this.dz.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.airbnb.lottie.d.D("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.dz.size() - 1; size >= 0; size--) {
            this.dz.get(size).a(this.rect, this.hK);
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
        if (this.hV != null) {
            f = (this.hV.getValue().floatValue() * 1000.0f) / ((float) this.dh.bj().getDuration());
        }
        if (this.hL.de() != 0.0f) {
            f /= this.hL.de();
        }
        float bo = f - this.hL.bo();
        for (int size = this.dz.size() - 1; size >= 0; size--) {
            this.dz.get(size).setProgress(bo);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dz.size()) {
                a aVar = this.dz.get(i2);
                String name = aVar.cZ().getName();
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
