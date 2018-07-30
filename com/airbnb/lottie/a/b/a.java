package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.a.a<K>> mi;
    @Nullable
    private com.airbnb.lottie.a.a<K> mj;
    final List<InterfaceC0006a> mb = new ArrayList();
    private boolean mh = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0006a {
        void bF();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.mi = list;
    }

    public void bS() {
        this.mh = true;
    }

    public void b(InterfaceC0006a interfaceC0006a) {
        this.mb.add(interfaceC0006a);
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
                if (i2 < this.mb.size()) {
                    this.mb.get(i2).bF();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private com.airbnb.lottie.a.a<K> bT() {
        if (this.mi.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.mj != null && this.mj.g(this.progress)) {
            return this.mj;
        }
        com.airbnb.lottie.a.a<K> aVar = this.mi.get(this.mi.size() - 1);
        if (this.progress < aVar.bA()) {
            for (int size = this.mi.size() - 1; size >= 0; size--) {
                aVar = this.mi.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.mj = aVar;
        return aVar;
    }

    private float bU() {
        if (this.mh) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> bT = bT();
        if (bT.bC()) {
            return 0.0f;
        }
        return bT.kZ.getInterpolation((this.progress - bT.bA()) / (bT.bB() - bT.bA()));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float bV() {
        if (this.mi.isEmpty()) {
            return 0.0f;
        }
        return this.mi.get(0).bA();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float bB() {
        if (this.mi.isEmpty()) {
            return 1.0f;
        }
        return this.mi.get(this.mi.size() - 1).bB();
    }

    public A getValue() {
        return a(bT(), bU());
    }

    public float getProgress() {
        return this.progress;
    }
}
