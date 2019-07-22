package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.a.a<K>> mV;
    @Nullable
    private com.airbnb.lottie.a.a<K> mW;
    final List<InterfaceC0007a> mP = new ArrayList();
    private boolean mU = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0007a {
        void ca();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.mV = list;
    }

    public void co() {
        this.mU = true;
    }

    public void b(InterfaceC0007a interfaceC0007a) {
        this.mP.add(interfaceC0007a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < cr()) {
            f = cr();
        } else if (f > bW()) {
            f = bW();
        }
        if (f != this.progress) {
            this.progress = f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mP.size()) {
                    this.mP.get(i2).ca();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private com.airbnb.lottie.a.a<K> cp() {
        if (this.mV.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.mW != null && this.mW.g(this.progress)) {
            return this.mW;
        }
        com.airbnb.lottie.a.a<K> aVar = this.mV.get(this.mV.size() - 1);
        if (this.progress < aVar.bV()) {
            for (int size = this.mV.size() - 1; size >= 0; size--) {
                aVar = this.mV.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.mW = aVar;
        return aVar;
    }

    private float cq() {
        if (this.mU) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> cp = cp();
        if (cp.bX()) {
            return 0.0f;
        }
        return cp.lK.getInterpolation((this.progress - cp.bV()) / (cp.bW() - cp.bV()));
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float cr() {
        if (this.mV.isEmpty()) {
            return 0.0f;
        }
        return this.mV.get(0).bV();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bW() {
        if (this.mV.isEmpty()) {
            return 1.0f;
        }
        return this.mV.get(this.mV.size() - 1).bW();
    }

    public A getValue() {
        return a(cp(), cq());
    }

    public float getProgress() {
        return this.progress;
    }
}
