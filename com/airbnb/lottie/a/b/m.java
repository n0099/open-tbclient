package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final PointF pF;
    private final a<Float, Float> pL;
    private final a<Float, Float> pM;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.pF = new PointF();
        this.pL = aVar;
        this.pM = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.pL.setProgress(f);
        this.pM.setProgress(f);
        this.pF.set(this.pL.getValue().floatValue(), this.pM.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pr.size()) {
                this.pr.get(i2).dc();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: dw */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        return this.pF;
    }
}
