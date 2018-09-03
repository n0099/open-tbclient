package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final PointF mp;
    private final a<Float, Float> mx;
    private final a<Float, Float> my;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.mp = new PointF();
        this.mx = aVar;
        this.my = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.mx.setProgress(f);
        this.my.setProgress(f);
        this.mp.set(this.mx.getValue().floatValue(), this.my.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mc.size()) {
                this.mc.get(i2).bF();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: bZ */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        return this.mp;
    }
}
