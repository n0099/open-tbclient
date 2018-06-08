package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final PointF mA;
    private final a<Float, Float> mI;
    private final a<Float, Float> mJ;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.mA = new PointF();
        this.mI = aVar;
        this.mJ = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.mI.setProgress(f);
        this.mJ.setProgress(f);
        this.mA.set(this.mI.getValue().floatValue(), this.mJ.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bH();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: cb */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        return this.mA;
    }
}
