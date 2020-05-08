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
    private Rect bounds;
    private Map<String, h> images;
    private final o zG = new o();
    private final HashSet<String> zH = new HashSet<>();
    private Map<String, List<Layer>> zI;
    private Map<String, com.airbnb.lottie.model.c> zJ;
    private SparseArrayCompat<com.airbnb.lottie.model.d> zK;
    private LongSparseArray<Layer> zL;
    private List<Layer> zM;
    private float zN;
    private float zO;
    private float zP;

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, h> map2, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.zN = f;
        this.zO = f2;
        this.zP = f3;
        this.zM = list;
        this.zL = longSparseArray;
        this.zI = map;
        this.images = map2;
        this.zK = sparseArrayCompat;
        this.zJ = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void aW(String str) {
        Log.w("LOTTIE", str);
        this.zH.add(str);
    }

    public ArrayList<String> gB() {
        return new ArrayList<>(Arrays.asList(this.zH.toArray(new String[this.zH.size()])));
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.zG.setEnabled(z);
    }

    public o getPerformanceTracker() {
        return this.zG;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer D(long j) {
        return this.zL.get(j);
    }

    public Rect gC() {
        return this.bounds;
    }

    public float gD() {
        return (gL() / this.zP) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gE() {
        return this.zN;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float gF() {
        return this.zO;
    }

    public float gG() {
        return this.zP;
    }

    public List<Layer> gH() {
        return this.zM;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> aX(String str) {
        return this.zI.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.d> gI() {
        return this.zK;
    }

    public Map<String, com.airbnb.lottie.model.c> gJ() {
        return this.zJ;
    }

    public Map<String, h> gK() {
        return this.images;
    }

    public float gL() {
        return this.zO - this.zN;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.zM) {
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
            private boolean cancelled;
            private final n zQ;

            private C0011a(n nVar) {
                this.cancelled = false;
                this.zQ = nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.i
            public void onResult(e eVar) {
                if (!this.cancelled) {
                    this.zQ.onCompositionLoaded(eVar);
                }
            }
        }
    }
}
