package com.baidu.live.lottie.a.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class a<K, A> {
    private final List<? extends com.baidu.live.lottie.e.a<K>> FL;
    @Nullable
    protected com.baidu.live.lottie.e.c<A> buw;
    @Nullable
    private com.baidu.live.lottie.e.a<K> bux;
    final List<InterfaceC0192a> listeners = new ArrayList();
    private boolean FK = false;
    private float progress = 0.0f;

    /* renamed from: com.baidu.live.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0192a {
        void ir();
    }

    abstract A a(com.baidu.live.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.baidu.live.lottie.e.a<K>> list) {
        this.FL = list;
    }

    public void iF() {
        this.FK = true;
    }

    public void b(InterfaceC0192a interfaceC0192a) {
        this.listeners.add(interfaceC0192a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < iJ()) {
            f = iJ();
        } else if (f > iK()) {
            f = iK();
        }
        if (f != this.progress) {
            this.progress = f;
            im();
        }
    }

    public void im() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).ir();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.baidu.live.lottie.e.a<K> Np() {
        if (this.bux != null && this.bux.p(this.progress)) {
            return this.bux;
        }
        com.baidu.live.lottie.e.a<K> aVar = this.FL.get(this.FL.size() - 1);
        if (this.progress < aVar.jX()) {
            for (int size = this.FL.size() - 1; size >= 0; size--) {
                aVar = this.FL.get(size);
                if (aVar.p(this.progress)) {
                    break;
                }
            }
        }
        this.bux = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iH() {
        if (this.FK) {
            return 0.0f;
        }
        com.baidu.live.lottie.e.a<K> Np = Np();
        if (Np.kA()) {
            return 0.0f;
        }
        return (this.progress - Np.jX()) / (Np.iK() - Np.jX());
    }

    private float iI() {
        com.baidu.live.lottie.e.a<K> Np = Np();
        if (Np.kA()) {
            return 0.0f;
        }
        return Np.Jm.getInterpolation(iH());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float iJ() {
        if (this.FL.isEmpty()) {
            return 0.0f;
        }
        return this.FL.get(0).jX();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float iK() {
        if (this.FL.isEmpty()) {
            return 1.0f;
        }
        return this.FL.get(this.FL.size() - 1).iK();
    }

    public A getValue() {
        return a(Np(), iI());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.baidu.live.lottie.e.c<A> cVar) {
        if (this.buw != null) {
            this.buw.b(null);
        }
        this.buw = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
