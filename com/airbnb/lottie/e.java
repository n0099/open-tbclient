package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes20.dex */
public class e {
    private final o Aj = new o();
    private final HashSet<String> Ak = new HashSet<>();
    private Map<String, List<Layer>> Al;
    private Map<String, com.airbnb.lottie.model.c> Am;
    private SparseArrayCompat<com.airbnb.lottie.model.d> An;
    private LongSparseArray<Layer> Ao;
    private List<Layer> Ap;
    private float Aq;
    private float Ar;
    private float As;
    private Rect bounds;
    private Map<String, h> images;

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, h> map2, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.Aq = f;
        this.Ar = f2;
        this.As = f3;
        this.Ap = list;
        this.Ao = longSparseArray;
        this.Al = map;
        this.images = map2;
        this.An = sparseArrayCompat;
        this.Am = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void aX(String str) {
        Log.w("LOTTIE", str);
        this.Ak.add(str);
    }

    public ArrayList<String> gR() {
        return new ArrayList<>(Arrays.asList(this.Ak.toArray(new String[this.Ak.size()])));
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Aj.setEnabled(z);
    }

    public o getPerformanceTracker() {
        return this.Aj;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer D(long j) {
        return this.Ao.get(j);
    }

    public Rect gS() {
        return this.bounds;
    }

    public float gT() {
        return (hb() / this.As) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gU() {
        return this.Aq;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gV() {
        return this.Ar;
    }

    public float gW() {
        return this.As;
    }

    public List<Layer> gX() {
        return this.Ap;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> aY(String str) {
        return this.Al.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.d> gY() {
        return this.An;
    }

    public Map<String, com.airbnb.lottie.model.c> gZ() {
        return this.Am;
    }

    public Map<String, h> ha() {
        return this.images;
    }

    public float hb() {
        return this.Ar - this.Aq;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.Ap) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    @Deprecated
    /* loaded from: classes20.dex */
    public static class a {
        @Deprecated
        public static com.airbnb.lottie.a a(Context context, String str, n nVar) {
            C0011a c0011a = new C0011a(nVar);
            f.t(context, str).a(c0011a);
            return c0011a;
        }

        /* renamed from: com.airbnb.lottie.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        private static final class C0011a implements com.airbnb.lottie.a, i<e> {
            private final n At;
            private boolean cancelled;

            private C0011a(n nVar) {
                this.cancelled = false;
                this.At = nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.i
            public void onResult(e eVar) {
                if (!this.cancelled) {
                    this.At.onCompositionLoaded(eVar);
                }
            }
        }
    }
}
