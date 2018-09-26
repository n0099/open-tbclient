package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes2.dex */
public class m extends a<PointF, PointF> {
    private final PointF oR;
    private final a<Float, Float> oX;
    private final a<Float, Float> oY;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.oR = new PointF();
        this.oX = aVar;
        this.oY = aVar2;
    }

    @Override // com.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.oX.setProgress(f);
        this.oY.setProgress(f);
        this.oR.set(this.oX.getValue().floatValue(), this.oY.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oF.size()) {
                this.oF.get(i2).cM();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: dg */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        return this.oR;
    }
}
