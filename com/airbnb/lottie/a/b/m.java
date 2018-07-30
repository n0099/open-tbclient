package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final PointF mo;
    private final a<Float, Float> mw;
    private final a<Float, Float> mx;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.mo = new PointF();
        this.mw = aVar;
        this.mx = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.mw.setProgress(f);
        this.mx.setProgress(f);
        this.mo.set(this.mw.getValue().floatValue(), this.mx.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mb.size()) {
                this.mb.get(i2).bF();
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
        return this.mo;
    }
}
