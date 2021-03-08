package com.airbnb.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {
    private final m Dk = new m();
    private final HashSet<String> Dl = new HashSet<>();
    private Map<String, List<Layer>> Dm;
    private Map<String, com.airbnb.lottie.model.c> Dn;
    private SparseArrayCompat<com.airbnb.lottie.model.d> Do;
    private LongSparseArray<Layer> Dp;
    private List<Layer> Dq;
    private float Dr;
    private float Ds;
    private float Dt;
    private Rect bounds;
    private Map<String, g> images;

    public void b(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.Dr = f;
        this.Ds = f2;
        this.Dt = f3;
        this.Dq = list;
        this.Dp = longSparseArray;
        this.Dm = map;
        this.images = map2;
        this.Do = sparseArrayCompat;
        this.Dn = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void bg(String str) {
        Log.w("LOTTIE", str);
        this.Dl.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Dk.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.Dk;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer B(long j) {
        return this.Dp.get(j);
    }

    public Rect hQ() {
        return this.bounds;
    }

    public float hR() {
        return (hZ() / this.Dt) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float hS() {
        return this.Dr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float hT() {
        return this.Ds;
    }

    public float hU() {
        return this.Dt;
    }

    public List<Layer> hV() {
        return this.Dq;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> bh(String str) {
        return this.Dm.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.d> hW() {
        return this.Do;
    }

    public Map<String, com.airbnb.lottie.model.c> hX() {
        return this.Dn;
    }

    public Map<String, g> hY() {
        return this.images;
    }

    public float hZ() {
        return this.Ds - this.Dr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.Dq) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
