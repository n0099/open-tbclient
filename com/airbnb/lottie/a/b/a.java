package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.a.a<K>> mW;
    @Nullable
    private com.airbnb.lottie.a.a<K> mZ;
    final List<InterfaceC0007a> mQ = new ArrayList();
    private boolean mV = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0007a {
        void bW();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.mW = list;
    }

    public void cj() {
        this.mV = true;
    }

    public void b(InterfaceC0007a interfaceC0007a) {
        this.mQ.add(interfaceC0007a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < cm()) {
            f = cm();
        } else if (f > bS()) {
            f = bS();
        }
        if (f != this.progress) {
            this.progress = f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mQ.size()) {
                    this.mQ.get(i2).bW();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private com.airbnb.lottie.a.a<K> ck() {
        if (this.mW.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.mZ != null && this.mZ.g(this.progress)) {
            return this.mZ;
        }
        com.airbnb.lottie.a.a<K> aVar = this.mW.get(this.mW.size() - 1);
        if (this.progress < aVar.bR()) {
            for (int size = this.mW.size() - 1; size >= 0; size--) {
                aVar = this.mW.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.mZ = aVar;
        return aVar;
    }

    private float cl() {
        if (this.mV) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> ck = ck();
        if (ck.bT()) {
            return 0.0f;
        }
        return ck.lL.getInterpolation((this.progress - ck.bR()) / (ck.bS() - ck.bR()));
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float cm() {
        if (this.mW.isEmpty()) {
            return 0.0f;
        }
        return this.mW.get(0).bR();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bS() {
        if (this.mW.isEmpty()) {
            return 1.0f;
        }
        return this.mW.get(this.mW.size() - 1).bS();
    }

    public A getValue() {
        return a(ck(), cl());
    }

    public float getProgress() {
        return this.progress;
    }
}
