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
    @Nullable
    private com.airbnb.lottie.a.b.a<Float, Float> EG;
    private final RectF EH;
    @Nullable
    private Boolean EI;
    @Nullable
    private Boolean EJ;
    private final RectF rect;
    private final List<a> zM;

    public b(com.airbnb.lottie.g gVar, Layer layer, List<Layer> list, com.airbnb.lottie.e eVar) {
        super(gVar, layer);
        a aVar;
        a aVar2;
        this.zM = new ArrayList();
        this.rect = new RectF();
        this.EH = new RectF();
        com.airbnb.lottie.model.a.b iT = layer.iT();
        if (iT != null) {
            this.EG = iT.hK();
            a(this.EG);
            this.EG.b(this);
        } else {
            this.EG = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.gH().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), gVar, eVar);
            if (a == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a.iC().getId(), a);
                if (aVar3 != null) {
                    aVar3.b(a);
                    aVar2 = null;
                } else {
                    this.zM.add(0, a);
                    switch (r0.iN()) {
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.iC().iO())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        int save = canvas.save();
        this.EH.set(0.0f, 0.0f, this.Ev.iK(), this.Ev.iL());
        matrix.mapRect(this.EH);
        for (int size = this.zM.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.EH.isEmpty()) {
                z = canvas.clipRect(this.EH);
            }
            if (z) {
                this.zM.get(size).a(canvas, matrix, i);
            }
        }
        if (save > 0) {
            canvas.restoreToCount(save);
        }
        com.airbnb.lottie.d.aV("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.zM.size() - 1; size >= 0; size--) {
            this.zM.get(size).a(this.rect, this.Eu);
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
        if (this.EG != null) {
            f = (this.EG.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().gD();
        }
        if (this.Ev.iH() != 0.0f) {
            f /= this.Ev.iH();
        }
        float iI = f - this.Ev.iI();
        for (int size = this.zM.size() - 1; size >= 0; size--) {
            this.zM.get(size).setProgress(iI);
        }
    }

    public boolean hasMasks() {
        if (this.EJ == null) {
            for (int size = this.zM.size() - 1; size >= 0; size--) {
                a aVar = this.zM.get(size);
                if (aVar instanceof e) {
                    if (aVar.iF()) {
                        this.EJ = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.EJ = true;
                    return true;
                }
            }
            this.EJ = false;
        }
        return this.EJ.booleanValue();
    }

    public boolean hasMatte() {
        if (this.EI == null) {
            if (iD()) {
                this.EI = true;
                return true;
            }
            for (int size = this.zM.size() - 1; size >= 0; size--) {
                if (this.zM.get(size).iD()) {
                    this.EI = true;
                    return true;
                }
            }
            this.EI = false;
        }
        return this.EI.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.zM.size()) {
                this.zM.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.airbnb.lottie.e.c<b>) cVar);
        if (t == k.AU) {
            if (cVar == null) {
                this.EG = null;
                return;
            }
            this.EG = new p(cVar);
            a(this.EG);
        }
    }
}
