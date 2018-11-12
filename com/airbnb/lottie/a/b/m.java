package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final PointF pK;
    private final a<Float, Float> pQ;
    private final a<Float, Float> pR;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.pK = new PointF();
        this.pQ = aVar;
        this.pR = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.pQ.setProgress(f);
        this.pR.setProgress(f);
        this.pK.set(this.pQ.getValue().floatValue(), this.pR.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.py.size()) {
                this.py.get(i2).dd();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: dx */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        return this.pK;
    }
}
