package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes20.dex */
public class m extends a<PointF, PointF> {
    private final PointF CX;
    private final a<Float, Float> Dd;
    private final a<Float, Float> De;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.CX = new PointF();
        this.Dd = aVar;
        this.De = aVar2;
        setProgress(getProgress());
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.Dd.setProgress(f);
        this.De.setProgress(f);
        this.CX.set(this.Dd.getValue().floatValue(), this.De.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).hq();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: hN */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        return this.CX;
    }
}
