package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.a.a<K>> mt;
    @Nullable
    private com.airbnb.lottie.a.a<K> mu;
    final List<InterfaceC0006a> listeners = new ArrayList();
    private boolean mr = false;
    private float kl = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0006a {
        void bH();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.mt = list;
    }

    public void bU() {
        this.mr = true;
    }

    public void b(InterfaceC0006a interfaceC0006a) {
        this.listeners.add(interfaceC0006a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < bX()) {
            f = bX();
        } else if (f > bD()) {
            f = bD();
        }
        if (f != this.kl) {
            this.kl = f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.listeners.size()) {
                    this.listeners.get(i2).bH();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private com.airbnb.lottie.a.a<K> bV() {
        if (this.mt.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.mu != null && this.mu.g(this.kl)) {
            return this.mu;
        }
        com.airbnb.lottie.a.a<K> aVar = this.mt.get(this.mt.size() - 1);
        if (this.kl < aVar.bC()) {
            for (int size = this.mt.size() - 1; size >= 0; size--) {
                aVar = this.mt.get(size);
                if (aVar.g(this.kl)) {
                    break;
                }
            }
        }
        this.mu = aVar;
        return aVar;
    }

    private float bW() {
        if (this.mr) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> bV = bV();
        if (bV.bE()) {
            return 0.0f;
        }
        return bV.li.getInterpolation((this.kl - bV.bC()) / (bV.bD() - bV.bC()));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float bX() {
        if (this.mt.isEmpty()) {
            return 0.0f;
        }
        return this.mt.get(0).bC();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float bD() {
        if (this.mt.isEmpty()) {
            return 1.0f;
        }
        return this.mt.get(this.mt.size() - 1).bD();
    }

    public A getValue() {
        return a(bV(), bW());
    }

    public float getProgress() {
        return this.kl;
    }
}
