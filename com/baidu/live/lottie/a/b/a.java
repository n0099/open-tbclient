package com.baidu.live.lottie.a.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class a<K, A> {
    private final List<? extends com.baidu.live.lottie.e.a<K>> Es;
    @Nullable
    protected com.baidu.live.lottie.e.c<A> bpt;
    @Nullable
    private com.baidu.live.lottie.e.a<K> bpu;
    final List<InterfaceC0185a> listeners = new ArrayList();
    private boolean Er = false;
    private float progress = 0.0f;

    /* renamed from: com.baidu.live.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0185a {
        void is();
    }

    abstract A a(com.baidu.live.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.baidu.live.lottie.e.a<K>> list) {
        this.Es = list;
    }

    public void iG() {
        this.Er = true;
    }

    public void b(InterfaceC0185a interfaceC0185a) {
        this.listeners.add(interfaceC0185a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < iK()) {
            f = iK();
        } else if (f > iL()) {
            f = iL();
        }
        if (f != this.progress) {
            this.progress = f;
            in();
        }
    }

    public void in() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).is();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.baidu.live.lottie.e.a<K> LO() {
        if (this.bpu != null && this.bpu.l(this.progress)) {
            return this.bpu;
        }
        com.baidu.live.lottie.e.a<K> aVar = this.Es.get(this.Es.size() - 1);
        if (this.progress < aVar.jY()) {
            for (int size = this.Es.size() - 1; size >= 0; size--) {
                aVar = this.Es.get(size);
                if (aVar.l(this.progress)) {
                    break;
                }
            }
        }
        this.bpu = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iI() {
        if (this.Er) {
            return 0.0f;
        }
        com.baidu.live.lottie.e.a<K> LO = LO();
        if (LO.kB()) {
            return 0.0f;
        }
        return (this.progress - LO.jY()) / (LO.iL() - LO.jY());
    }

    private float iJ() {
        com.baidu.live.lottie.e.a<K> LO = LO();
        if (LO.kB()) {
            return 0.0f;
        }
        return LO.HN.getInterpolation(iI());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float iK() {
        if (this.Es.isEmpty()) {
            return 0.0f;
        }
        return this.Es.get(0).jY();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float iL() {
        if (this.Es.isEmpty()) {
            return 1.0f;
        }
        return this.Es.get(this.Es.size() - 1).iL();
    }

    public A getValue() {
        return a(LO(), iJ());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.baidu.live.lottie.e.c<A> cVar) {
        if (this.bpt != null) {
            this.bpt.b(null);
        }
        this.bpt = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
