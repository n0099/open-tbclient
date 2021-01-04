package com.baidu.live.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes10.dex */
public class m extends a<PointF, PointF> {
    private final PointF EB;
    private final a<Float, Float> bum;
    private final a<Float, Float> bun;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.EB = new PointF();
        this.bum = aVar;
        this.bun = aVar2;
        setProgress(getProgress());
    }

    @Override // com.baidu.live.lottie.a.b.a
    public void setProgress(float f) {
        this.bum.setProgress(f);
        this.bun.setProgress(f);
        this.EB.set(this.bum.getValue().floatValue(), this.bun.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).is();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: iP */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.baidu.live.lottie.e.a<PointF> aVar, float f) {
        return this.EB;
    }
}
