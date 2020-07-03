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
/* loaded from: classes6.dex */
public class e {
    private final o Ah = new o();
    private final HashSet<String> Ai = new HashSet<>();
    private Map<String, List<Layer>> Aj;
    private Map<String, com.airbnb.lottie.model.c> Ak;
    private SparseArrayCompat<com.airbnb.lottie.model.d> Al;
    private LongSparseArray<Layer> Am;
    private List<Layer> An;
    private float Ao;
    private float Ap;
    private float Aq;
    private Rect bounds;
    private Map<String, h> images;

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, h> map2, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.Ao = f;
        this.Ap = f2;
        this.Aq = f3;
        this.An = list;
        this.Am = longSparseArray;
        this.Aj = map;
        this.images = map2;
        this.Al = sparseArrayCompat;
        this.Ak = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void aX(String str) {
        Log.w("LOTTIE", str);
        this.Ai.add(str);
    }

    public ArrayList<String> gR() {
        return new ArrayList<>(Arrays.asList(this.Ai.toArray(new String[this.Ai.size()])));
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Ah.setEnabled(z);
    }

    public o getPerformanceTracker() {
        return this.Ah;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer D(long j) {
        return this.Am.get(j);
    }

    public Rect gS() {
        return this.bounds;
    }

    public float gT() {
        return (hb() / this.Aq) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gU() {
        return this.Ao;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gV() {
        return this.Ap;
    }

    public float gW() {
        return this.Aq;
    }

    public List<Layer> gX() {
        return this.An;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> aY(String str) {
        return this.Aj.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.d> gY() {
        return this.Al;
    }

    public Map<String, com.airbnb.lottie.model.c> gZ() {
        return this.Ak;
    }

    public Map<String, h> ha() {
        return this.images;
    }

    public float hb() {
        return this.Ap - this.Ao;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.An) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public static class a {
        @Deprecated
        public static com.airbnb.lottie.a a(Context context, String str, n nVar) {
            C0011a c0011a = new C0011a(nVar);
            f.t(context, str).a(c0011a);
            return c0011a;
        }

        /* renamed from: com.airbnb.lottie.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private static final class C0011a implements com.airbnb.lottie.a, i<e> {
            private final n Ar;
            private boolean cancelled;

            private C0011a(n nVar) {
                this.cancelled = false;
                this.Ar = nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.i
            public void onResult(e eVar) {
                if (!this.cancelled) {
                    this.Ar.onCompositionLoaded(eVar);
                }
            }
        }
    }
}
