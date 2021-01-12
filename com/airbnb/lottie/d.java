package com.airbnb.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class d {
    private final m BL = new m();
    private final HashSet<String> BM = new HashSet<>();
    private Map<String, List<Layer>> BN;
    private Map<String, com.airbnb.lottie.model.c> BO;
    private SparseArrayCompat<com.airbnb.lottie.model.d> BP;
    private LongSparseArray<Layer> BQ;
    private List<Layer> BR;
    private float BS;
    private float BT;
    private float BU;
    private Rect bounds;
    private Map<String, g> images;

    public void b(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.BS = f;
        this.BT = f2;
        this.BU = f3;
        this.BR = list;
        this.BQ = longSparseArray;
        this.BN = map;
        this.images = map2;
        this.BP = sparseArrayCompat;
        this.BO = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void bc(String str) {
        Log.w("LOTTIE", str);
        this.BM.add(str);
    }

    public ArrayList<String> hQ() {
        return new ArrayList<>(Arrays.asList(this.BM.toArray(new String[this.BM.size()])));
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.BL.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.BL;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer B(long j) {
        return this.BQ.get(j);
    }

    public Rect hR() {
        return this.bounds;
    }

    public float hS() {
        return (ia() / this.BU) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float hT() {
        return this.BS;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float hU() {
        return this.BT;
    }

    public float hV() {
        return this.BU;
    }

    public List<Layer> hW() {
        return this.BR;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> bd(String str) {
        return this.BN.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.d> hX() {
        return this.BP;
    }

    public Map<String, com.airbnb.lottie.model.c> hY() {
        return this.BO;
    }

    public Map<String, g> hZ() {
        return this.images;
    }

    public float ia() {
        return this.BT - this.BS;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.BR) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
