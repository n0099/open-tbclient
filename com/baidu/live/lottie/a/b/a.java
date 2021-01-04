package com.baidu.live.lottie.a.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a<K, A> {
    private final List<? extends com.baidu.live.lottie.e.a<K>> Eu;
    @Nullable
    protected com.baidu.live.lottie.e.c<A> buh;
    @Nullable
    private com.baidu.live.lottie.e.a<K> bui;
    final List<InterfaceC0194a> listeners = new ArrayList();
    private boolean Et = false;
    private float progress = 0.0f;

    /* renamed from: com.baidu.live.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0194a {
        void is();
    }

    abstract A a(com.baidu.live.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.baidu.live.lottie.e.a<K>> list) {
        this.Eu = list;
    }

    public void iG() {
        this.Et = true;
    }

    public void b(InterfaceC0194a interfaceC0194a) {
        this.listeners.add(interfaceC0194a);
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

    private com.baidu.live.lottie.e.a<K> PJ() {
        if (this.bui != null && this.bui.l(this.progress)) {
            return this.bui;
        }
        com.baidu.live.lottie.e.a<K> aVar = this.Eu.get(this.Eu.size() - 1);
        if (this.progress < aVar.jY()) {
            for (int size = this.Eu.size() - 1; size >= 0; size--) {
                aVar = this.Eu.get(size);
                if (aVar.l(this.progress)) {
                    break;
                }
            }
        }
        this.bui = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iI() {
        if (this.Et) {
            return 0.0f;
        }
        com.baidu.live.lottie.e.a<K> PJ = PJ();
        if (PJ.kB()) {
            return 0.0f;
        }
        return (this.progress - PJ.jY()) / (PJ.iL() - PJ.jY());
    }

    private float iJ() {
        com.baidu.live.lottie.e.a<K> PJ = PJ();
        if (PJ.kB()) {
            return 0.0f;
        }
        return PJ.HP.getInterpolation(iI());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float iK() {
        if (this.Eu.isEmpty()) {
            return 0.0f;
        }
        return this.Eu.get(0).jY();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float iL() {
        if (this.Eu.isEmpty()) {
            return 1.0f;
        }
        return this.Eu.get(this.Eu.size() - 1).iL();
    }

    public A getValue() {
        return a(PJ(), iJ());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.baidu.live.lottie.e.c<A> cVar) {
        if (this.buh != null) {
            this.buh.b(null);
        }
        this.buh = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
