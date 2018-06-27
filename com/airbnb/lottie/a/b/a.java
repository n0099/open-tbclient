package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.a.a<K>> mr;
    @Nullable
    private com.airbnb.lottie.a.a<K> mt;
    final List<InterfaceC0006a> ml = new ArrayList();
    private boolean mq = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0006a {
        void bH();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.mr = list;
    }

    public void bU() {
        this.mq = true;
    }

    public void b(InterfaceC0006a interfaceC0006a) {
        this.ml.add(interfaceC0006a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < bX()) {
            f = bX();
        } else if (f > bD()) {
            f = bD();
        }
        if (f != this.progress) {
            this.progress = f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ml.size()) {
                    this.ml.get(i2).bH();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private com.airbnb.lottie.a.a<K> bV() {
        if (this.mr.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.mt != null && this.mt.g(this.progress)) {
            return this.mt;
        }
        com.airbnb.lottie.a.a<K> aVar = this.mr.get(this.mr.size() - 1);
        if (this.progress < aVar.bC()) {
            for (int size = this.mr.size() - 1; size >= 0; size--) {
                aVar = this.mr.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.mt = aVar;
        return aVar;
    }

    private float bW() {
        if (this.mq) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> bV = bV();
        if (bV.bE()) {
            return 0.0f;
        }
        return bV.lh.getInterpolation((this.progress - bV.bC()) / (bV.bD() - bV.bC()));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float bX() {
        if (this.mr.isEmpty()) {
            return 0.0f;
        }
        return this.mr.get(0).bC();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float bD() {
        if (this.mr.isEmpty()) {
            return 1.0f;
        }
        return this.mr.get(this.mr.size() - 1).bD();
    }

    public A getValue() {
        return a(bV(), bW());
    }

    public float getProgress() {
        return this.progress;
    }
}
