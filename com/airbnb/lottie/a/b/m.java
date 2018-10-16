package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final PointF pJ;
    private final a<Float, Float> pP;
    private final a<Float, Float> pQ;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.pJ = new PointF();
        this.pP = aVar;
        this.pQ = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.pP.setProgress(f);
        this.pQ.setProgress(f);
        this.pJ.set(this.pP.getValue().floatValue(), this.pQ.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.px.size()) {
                this.px.get(i2).de();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: dy */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        return this.pJ;
    }
}
