package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes7.dex */
public class m extends a<PointF, PointF> {
    private final PointF EM;
    private final a<Float, Float> ET;
    private final a<Float, Float> EU;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.EM = new PointF();
        this.ET = aVar;
        this.EU = aVar2;
        setProgress(getProgress());
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.ET.setProgress(f);
        this.EU.setProgress(f);
        this.EM.set(this.ET.getValue().floatValue(), this.EU.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iT();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: jq */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        return this.EM;
    }
}
