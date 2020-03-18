package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes6.dex */
public class m extends a<PointF, PointF> {
    private final PointF gN;
    private final a<Float, Float> gT;
    private final a<Float, Float> gU;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.gN = new PointF();
        this.gT = aVar;
        this.gU = aVar2;
        setProgress(getProgress());
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.gT.setProgress(f);
        this.gU.setProgress(f);
        this.gN.set(this.gT.getValue().floatValue(), this.gU.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bD();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: ca */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        return this.gN;
    }
}
