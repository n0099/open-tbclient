package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final PointF ne;
    private final a<Float, Float> nk;
    private final a<Float, Float> nl;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.ne = new PointF();
        this.nk = aVar;
        this.nl = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.nk.setProgress(f);
        this.nl.setProgress(f);
        this.ne.set(this.nk.getValue().floatValue(), this.nl.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mQ.size()) {
                this.mQ.get(i2).bW();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: cq */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        return this.ne;
    }
}
