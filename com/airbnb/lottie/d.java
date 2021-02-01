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
/* loaded from: classes4.dex */
public class d {
    private final m BM = new m();
    private final HashSet<String> BN = new HashSet<>();
    private Map<String, List<Layer>> BO;
    private Map<String, com.airbnb.lottie.model.c> BP;
    private SparseArrayCompat<com.airbnb.lottie.model.d> BQ;
    private LongSparseArray<Layer> BR;
    private List<Layer> BS;
    private float BT;
    private float BU;
    private float BV;
    private Rect bounds;
    private Map<String, g> images;

    public void b(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.BT = f;
        this.BU = f2;
        this.BV = f3;
        this.BS = list;
        this.BR = longSparseArray;
        this.BO = map;
        this.images = map2;
        this.BQ = sparseArrayCompat;
        this.BP = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void bc(String str) {
        Log.w("LOTTIE", str);
        this.BN.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.BM.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.BM;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer B(long j) {
        return this.BR.get(j);
    }

    public Rect hQ() {
        return this.bounds;
    }

    public float hR() {
        return (hZ() / this.BV) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float hS() {
        return this.BT;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float hT() {
        return this.BU;
    }

    public float hU() {
        return this.BV;
    }

    public List<Layer> hV() {
        return this.BS;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> bd(String str) {
        return this.BO.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.d> hW() {
        return this.BQ;
    }

    public Map<String, com.airbnb.lottie.model.c> hX() {
        return this.BP;
    }

    public Map<String, g> hY() {
        return this.images;
    }

    public float hZ() {
        return this.BU - this.BT;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.BS) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
