package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final a<Float, Float> mH;
    private final a<Float, Float> mI;
    private final PointF mz;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.mz = new PointF();
        this.mH = aVar;
        this.mI = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.mH.setProgress(f);
        this.mI.setProgress(f);
        this.mz.set(this.mH.getValue().floatValue(), this.mI.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ml.size()) {
                this.ml.get(i2).bH();
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
        return this.mz;
    }
}
