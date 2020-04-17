package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes6.dex */
public class m extends a<PointF, PointF> {
    private final PointF Cp;
    private final a<Float, Float> Cv;
    private final a<Float, Float> Cw;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.Cp = new PointF();
        this.Cv = aVar;
        this.Cw = aVar2;
        setProgress(getProgress());
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.Cv.setProgress(f);
        this.Cw.setProgress(f);
        this.Cp.set(this.Cv.getValue().floatValue(), this.Cw.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).ha();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: hx */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        return this.Cp;
    }
}
