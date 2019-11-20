package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final PointF eX;
    private final a<Float, Float> fe;
    private final a<Float, Float> ff;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.eX = new PointF();
        this.fe = aVar;
        this.ff = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.fe.setProgress(f);
        this.ff.setProgress(f);
        this.eX.set(this.fe.getValue().floatValue(), this.ff.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bt();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: bO */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        return this.eX;
    }
}
