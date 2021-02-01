package com.baidu.live.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes10.dex */
public class m extends a<PointF, PointF> {
    private final PointF Ez;
    private final a<Float, Float> bsZ;
    private final a<Float, Float> bta;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.Ez = new PointF();
        this.bsZ = aVar;
        this.bta = aVar2;
        setProgress(getProgress());
    }

    @Override // com.baidu.live.lottie.a.b.a
    public void setProgress(float f) {
        this.bsZ.setProgress(f);
        this.bta.setProgress(f);
        this.Ez.set(this.bsZ.getValue().floatValue(), this.bta.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).ir();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: iO */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.baidu.live.lottie.e.a<PointF> aVar, float f) {
        return this.Ez;
    }
}
