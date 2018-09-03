package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.a.a<K>> mj;
    @Nullable
    private com.airbnb.lottie.a.a<K> mk;
    final List<InterfaceC0006a> mc = new ArrayList();
    private boolean mi = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0006a {
        void bF();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.mj = list;
    }

    public void bS() {
        this.mi = true;
    }

    public void b(InterfaceC0006a interfaceC0006a) {
        this.mc.add(interfaceC0006a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < bV()) {
            f = bV();
        } else if (f > bB()) {
            f = bB();
        }
        if (f != this.progress) {
            this.progress = f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mc.size()) {
                    this.mc.get(i2).bF();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private com.airbnb.lottie.a.a<K> bT() {
        if (this.mj.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.mk != null && this.mk.g(this.progress)) {
            return this.mk;
        }
        com.airbnb.lottie.a.a<K> aVar = this.mj.get(this.mj.size() - 1);
        if (this.progress < aVar.bA()) {
            for (int size = this.mj.size() - 1; size >= 0; size--) {
                aVar = this.mj.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.mk = aVar;
        return aVar;
    }

    private float bU() {
        if (this.mi) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> bT = bT();
        if (bT.bC()) {
            return 0.0f;
        }
        return bT.la.getInterpolation((this.progress - bT.bA()) / (bT.bB() - bT.bA()));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float bV() {
        if (this.mj.isEmpty()) {
            return 0.0f;
        }
        return this.mj.get(0).bA();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float bB() {
        if (this.mj.isEmpty()) {
            return 1.0f;
        }
        return this.mj.get(this.mj.size() - 1).bB();
    }

    public A getValue() {
        return a(bT(), bU());
    }

    public float getProgress() {
        return this.progress;
    }
}
