package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.a.a<K>> pE;
    @Nullable
    private com.airbnb.lottie.a.a<K> pF;
    final List<InterfaceC0009a> py = new ArrayList();
    private boolean pD = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0009a {
        void dd();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.pE = list;
    }

    public void dq() {
        this.pD = true;
    }

    public void b(InterfaceC0009a interfaceC0009a) {
        this.py.add(interfaceC0009a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < dt()) {
            f = dt();
        } else if (f > cZ()) {
            f = cZ();
        }
        if (f != this.progress) {
            this.progress = f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.py.size()) {
                    this.py.get(i2).dd();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private com.airbnb.lottie.a.a<K> dr() {
        if (this.pE.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.pF != null && this.pF.g(this.progress)) {
            return this.pF;
        }
        com.airbnb.lottie.a.a<K> aVar = this.pE.get(this.pE.size() - 1);
        if (this.progress < aVar.cY()) {
            for (int size = this.pE.size() - 1; size >= 0; size--) {
                aVar = this.pE.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.pF = aVar;
        return aVar;
    }

    private float ds() {
        if (this.pD) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> dr = dr();
        if (dr.da()) {
            return 0.0f;
        }
        return dr.oq.getInterpolation((this.progress - dr.cY()) / (dr.cZ() - dr.cY()));
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float dt() {
        if (this.pE.isEmpty()) {
            return 0.0f;
        }
        return this.pE.get(0).cY();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float cZ() {
        if (this.pE.isEmpty()) {
            return 1.0f;
        }
        return this.pE.get(this.pE.size() - 1).cZ();
    }

    public A getValue() {
        return a(dr(), ds());
    }

    public float getProgress() {
        return this.progress;
    }
}
