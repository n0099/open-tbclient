package com.airbnb.lottie.a.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.e.a<K>> Eu;
    @Nullable
    protected com.airbnb.lottie.e.c<A> Ev;
    @Nullable
    private com.airbnb.lottie.e.a<K> Ew;
    final List<InterfaceC0007a> listeners = new ArrayList();
    private boolean Et = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0007a {
        void is();
    }

    abstract A a(com.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.e.a<K>> list) {
        this.Eu = list;
    }

    public void iG() {
        this.Et = true;
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
        if (this.Ew != null && this.Ew.l(this.progress)) {
            return this.Ew;
        }
        com.airbnb.lottie.e.a<K> aVar = this.Eu.get(this.Eu.size() - 1);
        if (this.progress < aVar.jY()) {
            for (int size = this.Eu.size() - 1; size >= 0; size--) {
                aVar = this.Eu.get(size);
                if (aVar.l(this.progress)) {
                    break;
                }
            }
        }
        this.Ew = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iI() {
        if (this.Et) {
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
        return iH.HP.getInterpolation(iI());
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
        return a(iH(), iJ());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.airbnb.lottie.e.c<A> cVar) {
        if (this.Ev != null) {
            this.Ev.b(null);
        }
        this.Ev = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
