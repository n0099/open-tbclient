package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final PointF nd;
    private final a<Float, Float> nj;
    private final a<Float, Float> nk;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.nd = new PointF();
        this.nj = aVar;
        this.nk = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.nj.setProgress(f);
        this.nk.setProgress(f);
        this.nd.set(this.nj.getValue().floatValue(), this.nk.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mP.size()) {
                this.mP.get(i2).ca();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: cv */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        return this.nd;
    }
}
