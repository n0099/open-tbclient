package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a<K, A> {
    private final List<? extends com.airbnb.lottie.e.a<K>> EF;
    @Nullable
    protected com.airbnb.lottie.e.c<A> EG;
    @Nullable
    private com.airbnb.lottie.e.a<K> EH;
    final List<InterfaceC0011a> listeners = new ArrayList();
    private boolean EE = false;
    private float progress = 0.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0011a {
        void iT();
    }

    abstract A a(com.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.e.a<K>> list) {
        this.EF = list;
    }

    public void jh() {
        this.EE = true;
    }

    public void b(InterfaceC0011a interfaceC0011a) {
        this.listeners.add(interfaceC0011a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < jl()) {
            f = jl();
        } else if (f > jm()) {
            f = jm();
        }
        if (f != this.progress) {
            this.progress = f;
            iP();
        }
    }

    public void iP() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iT();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.airbnb.lottie.e.a<K> ji() {
        if (this.EH != null && this.EH.l(this.progress)) {
            return this.EH;
        }
        com.airbnb.lottie.e.a<K> aVar = this.EF.get(this.EF.size() - 1);
        if (this.progress < aVar.kz()) {
            for (int size = this.EF.size() - 1; size >= 0; size--) {
                aVar = this.EF.get(size);
                if (aVar.l(this.progress)) {
                    break;
                }
            }
        }
        this.EH = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jj() {
        if (this.EE) {
            return 0.0f;
        }
        com.airbnb.lottie.e.a<K> ji = ji();
        if (ji.lc()) {
            return 0.0f;
        }
        return (this.progress - ji.kz()) / (ji.jm() - ji.kz());
    }

    private float jk() {
        com.airbnb.lottie.e.a<K> ji = ji();
        if (ji.lc()) {
            return 0.0f;
        }
        return ji.Ih.getInterpolation(jj());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float jl() {
        if (this.EF.isEmpty()) {
            return 0.0f;
        }
        return this.EF.get(0).kz();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float jm() {
        if (this.EF.isEmpty()) {
            return 1.0f;
        }
        return this.EF.get(this.EF.size() - 1).jm();
    }

    public A getValue() {
        return a(ji(), jk());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.airbnb.lottie.e.c<A> cVar) {
        if (this.EG != null) {
            this.EG.b(null);
        }
        this.EG = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
