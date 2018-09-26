package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.a.a<K>> oL;
    @Nullable
    private com.airbnb.lottie.a.a<K> oM;
    final List<InterfaceC0006a> oF = new ArrayList();
    private boolean oK = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0006a {
        void cM();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.oL = list;
    }

    public void cZ() {
        this.oK = true;
    }

    public void b(InterfaceC0006a interfaceC0006a) {
        this.oF.add(interfaceC0006a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < dc()) {
            f = dc();
        } else if (f > cI()) {
            f = cI();
        }
        if (f != this.progress) {
            this.progress = f;
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
    }

    private com.airbnb.lottie.a.a<K> da() {
        if (this.oL.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.oM != null && this.oM.g(this.progress)) {
            return this.oM;
        }
        com.airbnb.lottie.a.a<K> aVar = this.oL.get(this.oL.size() - 1);
        if (this.progress < aVar.cH()) {
            for (int size = this.oL.size() - 1; size >= 0; size--) {
                aVar = this.oL.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.oM = aVar;
        return aVar;
    }

    private float db() {
        if (this.oK) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> da = da();
        if (da.cJ()) {
            return 0.0f;
        }
        return da.nC.getInterpolation((this.progress - da.cH()) / (da.cI() - da.cH()));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float dc() {
        if (this.oL.isEmpty()) {
            return 0.0f;
        }
        return this.oL.get(0).cH();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float cI() {
        if (this.oL.isEmpty()) {
            return 1.0f;
        }
        return this.oL.get(this.oL.size() - 1).cI();
    }

    public A getValue() {
        return a(da(), db());
    }

    public float getProgress() {
        return this.progress;
    }
}
