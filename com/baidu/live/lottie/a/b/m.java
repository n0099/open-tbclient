package com.baidu.live.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes9.dex */
public class m extends a<PointF, PointF> {
    private final PointF FT;
    private final a<Float, Float> buB;
    private final a<Float, Float> buC;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.FT = new PointF();
        this.buB = aVar;
        this.buC = aVar2;
        setProgress(getProgress());
    }

    @Override // com.baidu.live.lottie.a.b.a
    public void setProgress(float f) {
        this.buB.setProgress(f);
        this.buC.setProgress(f);
        this.FT.set(this.buB.getValue().floatValue(), this.buC.getValue().floatValue());
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
        return this.FT;
    }
}
