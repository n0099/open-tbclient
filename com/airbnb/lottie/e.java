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
/* loaded from: classes10.dex */
public class e {
    private final o Bh = new o();
    private final HashSet<String> Bi = new HashSet<>();
    private Map<String, List<Layer>> Bj;
    private Map<String, com.airbnb.lottie.model.c> Bk;
    private SparseArrayCompat<com.airbnb.lottie.model.d> Bl;
    private LongSparseArray<Layer> Bm;
    private List<Layer> Bn;
    private float Bo;
    private float Bp;
    private float Bq;
    private Rect bounds;
    private Map<String, h> images;

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, h> map2, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.Bo = f;
        this.Bp = f2;
        this.Bq = f3;
        this.Bn = list;
        this.Bm = longSparseArray;
        this.Bj = map;
        this.images = map2;
        this.Bl = sparseArrayCompat;
        this.Bk = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void bc(String str) {
        Log.w("LOTTIE", str);
        this.Bi.add(str);
    }

    public ArrayList<String> it() {
        return new ArrayList<>(Arrays.asList(this.Bi.toArray(new String[this.Bi.size()])));
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Bh.setEnabled(z);
    }

    public o getPerformanceTracker() {
        return this.Bh;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer D(long j) {
        return this.Bm.get(j);
    }

    public Rect iu() {
        return this.bounds;
    }

    public float iv() {
        return (iD() / this.Bq) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float iw() {
        return this.Bo;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float ix() {
        return this.Bp;
    }

    public float iy() {
        return this.Bq;
    }

    public List<Layer> iz() {
        return this.Bn;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> bd(String str) {
        return this.Bj.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.d> iA() {
        return this.Bl;
    }

    public Map<String, com.airbnb.lottie.model.c> iB() {
        return this.Bk;
    }

    public Map<String, h> iC() {
        return this.images;
    }

    public float iD() {
        return this.Bp - this.Bo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.Bn) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    @Deprecated
    /* loaded from: classes10.dex */
    public static class a {
        @Deprecated
        public static com.airbnb.lottie.a a(Context context, String str, n nVar) {
            C0012a c0012a = new C0012a(nVar);
            f.t(context, str).a(c0012a);
            return c0012a;
        }

        /* renamed from: com.airbnb.lottie.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        private static final class C0012a implements com.airbnb.lottie.a, i<e> {
            private final n Br;
            private boolean cancelled;

            private C0012a(n nVar) {
                this.cancelled = false;
                this.Br = nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.i
            public void onResult(e eVar) {
                if (!this.cancelled) {
                    this.Br.onCompositionLoaded(eVar);
                }
            }
        }
    }
}
