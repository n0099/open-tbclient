package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.a.a<K>> pD;
    @Nullable
    private com.airbnb.lottie.a.a<K> pE;
    final List<InterfaceC0009a> px = new ArrayList();
    private boolean pC = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0009a {
        void de();
    }

    abstract A a(com.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.a.a<K>> list) {
        this.pD = list;
    }

    public void dr() {
        this.pC = true;
    }

    public void b(InterfaceC0009a interfaceC0009a) {
        this.px.add(interfaceC0009a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < du()) {
            f = du();
        } else if (f > da()) {
            f = da();
        }
        if (f != this.progress) {
            this.progress = f;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.px.size()) {
                    this.px.get(i2).de();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private com.airbnb.lottie.a.a<K> ds() {
        if (this.pD.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.pE != null && this.pE.g(this.progress)) {
            return this.pE;
        }
        com.airbnb.lottie.a.a<K> aVar = this.pD.get(this.pD.size() - 1);
        if (this.progress < aVar.cZ()) {
            for (int size = this.pD.size() - 1; size >= 0; size--) {
                aVar = this.pD.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.pE = aVar;
        return aVar;
    }

    private float dt() {
        if (this.pC) {
            return 0.0f;
        }
        com.airbnb.lottie.a.a<K> ds = ds();
        if (ds.db()) {
            return 0.0f;
        }
        return ds.oq.getInterpolation((this.progress - ds.cZ()) / (ds.da() - ds.cZ()));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float du() {
        if (this.pD.isEmpty()) {
            return 0.0f;
        }
        return this.pD.get(0).cZ();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float da() {
        if (this.pD.isEmpty()) {
            return 1.0f;
        }
        return this.pD.get(this.pD.size() - 1).da();
    }

    public A getValue() {
        return a(ds(), dt());
    }

    public float getProgress() {
        return this.progress;
    }
}
