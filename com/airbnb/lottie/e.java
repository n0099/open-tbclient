package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class e {
    private Rect bounds;
    private final o dV = new o();
    private final HashSet<String> dW = new HashSet<>();
    private Map<String, List<Layer>> dX;
    private Map<String, com.airbnb.lottie.model.c> dY;
    private SparseArrayCompat<com.airbnb.lottie.model.d> dZ;
    private LongSparseArray<Layer> eb;
    private List<Layer> ec;
    private float ed;
    private float ee;
    private float frameRate;
    private Map<String, h> images;

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, h> map2, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.ed = f;
        this.ee = f2;
        this.frameRate = f3;
        this.ec = list;
        this.eb = longSparseArray;
        this.dX = map;
        this.images = map2;
        this.dZ = sparseArrayCompat;
        this.dY = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void G(String str) {
        Log.w("LOTTIE", str);
        this.dW.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.dV.setEnabled(z);
    }

    public o getPerformanceTracker() {
        return this.dV;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer f(long j) {
        return this.eb.get(j);
    }

    public Rect be() {
        return this.bounds;
    }

    public float bf() {
        return (bn() / this.frameRate) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float bg() {
        return this.ed;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float bh() {
        return this.ee;
    }

    public float bi() {
        return this.frameRate;
    }

    public List<Layer> bj() {
        return this.ec;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> H(String str) {
        return this.dX.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.d> bk() {
        return this.dZ;
    }

    public Map<String, com.airbnb.lottie.model.c> bl() {
        return this.dY;
    }

    public Map<String, h> bm() {
        return this.images;
    }

    public float bn() {
        return this.ee - this.ed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.ec) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public static class a {
        @Deprecated
        public static com.airbnb.lottie.a a(Context context, String str, n nVar) {
            C0011a c0011a = new C0011a(nVar);
            f.F(context, str).a(c0011a);
            return c0011a;
        }

        /* renamed from: com.airbnb.lottie.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        private static final class C0011a implements com.airbnb.lottie.a, i<e> {
            private boolean cancelled;
            private final n ef;

            private C0011a(n nVar) {
                this.cancelled = false;
                this.ef = nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.i
            /* renamed from: a */
            public void onResult(e eVar) {
                if (!this.cancelled) {
                    this.ef.onCompositionLoaded(eVar);
                }
            }
        }
    }
}
