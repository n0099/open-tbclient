package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.a.a<K>> fu;
    @Nullable
    private com.airbnb.lottie.a.a<K> fv;
    final List<InterfaceC0007a> listeners = new ArrayList();
    private boolean ft = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0007a {
        void bt();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.fu = list;
    }

    public void bH() {
        this.ft = true;
    }

    public void b(InterfaceC0007a interfaceC0007a) {
        this.listeners.add(interfaceC0007a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < bK()) {
            f = bK();
        } else if (f > bp()) {
            f = bp();
        }
        if (f != this.progress) {
            this.progress = f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.listeners.size()) {
                    this.listeners.get(i2).bt();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private com.airbnb.lottie.a.a<K> bI() {
        if (this.fu.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.fv != null && this.fv.g(this.progress)) {
            return this.fv;
        }
        com.airbnb.lottie.a.a<K> aVar = this.fu.get(this.fu.size() - 1);
        if (this.progress < aVar.bo()) {
            for (int size = this.fu.size() - 1; size >= 0; size--) {
                aVar = this.fu.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.fv = aVar;
        return aVar;
    }

    private float bJ() {
        if (this.ft) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> bI = bI();
        if (bI.bq()) {
            return 0.0f;
        }
        return bI.el.getInterpolation((this.progress - bI.bo()) / (bI.bp() - bI.bo()));
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bK() {
        if (this.fu.isEmpty()) {
            return 0.0f;
        }
        return this.fu.get(0).bo();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bp() {
        if (this.fu.isEmpty()) {
            return 1.0f;
        }
        return this.fu.get(this.fu.size() - 1).bp();
    }

    public A getValue() {
        return a(bI(), bJ());
    }

    public float getProgress() {
        return this.progress;
    }
}
