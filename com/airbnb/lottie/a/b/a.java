package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    @Nullable
    private com.airbnb.lottie.a.a<K> pA;
    private final List<? extends com.airbnb.lottie.a.a<K>> pz;
    final List<InterfaceC0007a> pr = new ArrayList();
    private boolean py = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0007a {
        void dc();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.pz = list;
    }

    public void dp() {
        this.py = true;
    }

    public void b(InterfaceC0007a interfaceC0007a) {
        this.pr.add(interfaceC0007a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < ds()) {
            f = ds();
        } else if (f > cY()) {
            f = cY();
        }
        if (f != this.progress) {
            this.progress = f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.pr.size()) {
                    this.pr.get(i2).dc();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private com.airbnb.lottie.a.a<K> dq() {
        if (this.pz.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.pA != null && this.pA.g(this.progress)) {
            return this.pA;
        }
        com.airbnb.lottie.a.a<K> aVar = this.pz.get(this.pz.size() - 1);
        if (this.progress < aVar.cX()) {
            for (int size = this.pz.size() - 1; size >= 0; size--) {
                aVar = this.pz.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.pA = aVar;
        return aVar;
    }

    private float dr() {
        if (this.py) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> dq = dq();
        if (dq.cZ()) {
            return 0.0f;
        }
        return dq.oj.getInterpolation((this.progress - dq.cX()) / (dq.cY() - dq.cX()));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float ds() {
        if (this.pz.isEmpty()) {
            return 0.0f;
        }
        return this.pz.get(0).cX();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float cY() {
        if (this.pz.isEmpty()) {
            return 1.0f;
        }
        return this.pz.get(this.pz.size() - 1).cY();
    }

    public A getValue() {
        return a(dq(), dr());
    }

    public float getProgress() {
        return this.progress;
    }
}
