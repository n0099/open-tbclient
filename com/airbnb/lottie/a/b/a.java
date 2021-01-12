package com.airbnb.lottie.a.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.e.a<K>> Es;
    @Nullable
    protected com.airbnb.lottie.e.c<A> Et;
    @Nullable
    private com.airbnb.lottie.e.a<K> Eu;
    final List<InterfaceC0007a> listeners = new ArrayList();
    private boolean Er = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0007a {
        void is();
    }

    abstract A a(com.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.e.a<K>> list) {
        this.Es = list;
    }

    public void iG() {
        this.Er = true;
    }

    public void b(InterfaceC0007a interfaceC0007a) {
        this.listeners.add(interfaceC0007a);
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

    private com.airbnb.lottie.e.a<K> iH() {
        if (this.Eu != null && this.Eu.l(this.progress)) {
            return this.Eu;
        }
        com.airbnb.lottie.e.a<K> aVar = this.Es.get(this.Es.size() - 1);
        if (this.progress < aVar.jY()) {
            for (int size = this.Es.size() - 1; size >= 0; size--) {
                aVar = this.Es.get(size);
                if (aVar.l(this.progress)) {
                    break;
                }
            }
        }
        this.Eu = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iI() {
        if (this.Er) {
            return 0.0f;
        }
        com.airbnb.lottie.e.a<K> iH = iH();
        if (iH.kB()) {
            return 0.0f;
        }
        return (this.progress - iH.jY()) / (iH.iL() - iH.jY());
    }

    private float iJ() {
        com.airbnb.lottie.e.a<K> iH = iH();
        if (iH.kB()) {
            return 0.0f;
        }
        return iH.HN.getInterpolation(iI());
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
        return a(iH(), iJ());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.airbnb.lottie.e.c<A> cVar) {
        if (this.Et != null) {
            this.Et.b(null);
        }
        this.Et = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
