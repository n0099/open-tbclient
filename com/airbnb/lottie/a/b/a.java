package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.e.a<K>> gD;
    @Nullable
    protected com.airbnb.lottie.e.c<A> gE;
    @Nullable
    private com.airbnb.lottie.e.a<K> gF;
    final List<InterfaceC0010a> listeners = new ArrayList();
    private boolean gC = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0010a {
        void bC();
    }

    abstract A a(com.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.e.a<K>> list) {
        this.gD = list;
    }

    public void bQ() {
        this.gC = true;
    }

    public void b(InterfaceC0010a interfaceC0010a) {
        this.listeners.add(interfaceC0010a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < bU()) {
            f = bU();
        } else if (f > bV()) {
            f = bV();
        }
        if (f != this.progress) {
            this.progress = f;
            by();
        }
    }

    public void by() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bC();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.airbnb.lottie.e.a<K> bR() {
        if (this.gF != null && this.gF.n(this.progress)) {
            return this.gF;
        }
        com.airbnb.lottie.e.a<K> aVar = this.gD.get(this.gD.size() - 1);
        if (this.progress < aVar.di()) {
            for (int size = this.gD.size() - 1; size >= 0; size--) {
                aVar = this.gD.get(size);
                if (aVar.n(this.progress)) {
                    break;
                }
            }
        }
        this.gF = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float bS() {
        if (this.gC) {
            return 0.0f;
        }
        com.airbnb.lottie.e.a<K> bR = bR();
        if (bR.dL()) {
            return 0.0f;
        }
        return (this.progress - bR.di()) / (bR.bV() - bR.di());
    }

    private float bT() {
        com.airbnb.lottie.e.a<K> bR = bR();
        if (bR.dL()) {
            return 0.0f;
        }
        return bR.ko.getInterpolation(bS());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bU() {
        if (this.gD.isEmpty()) {
            return 0.0f;
        }
        return this.gD.get(0).di();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float bV() {
        if (this.gD.isEmpty()) {
            return 1.0f;
        }
        return this.gD.get(this.gD.size() - 1).bV();
    }

    public A getValue() {
        return a(bR(), bT());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.airbnb.lottie.e.c<A> cVar) {
        if (this.gE != null) {
            this.gE.b(null);
        }
        this.gE = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
