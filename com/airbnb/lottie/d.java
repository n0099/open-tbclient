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
    private final m BN = new m();
    private final HashSet<String> BO = new HashSet<>();
    private Map<String, List<Layer>> BP;
    private Map<String, com.airbnb.lottie.model.c> BQ;
    private SparseArrayCompat<com.airbnb.lottie.model.d> BR;
    private LongSparseArray<Layer> BS;
    private List<Layer> BT;
    private float BU;
    private float BV;
    private float BW;
    private Rect bounds;
    private Map<String, g> images;

    public void b(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, g> map2, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.BU = f;
        this.BV = f2;
        this.BW = f3;
        this.BT = list;
        this.BS = longSparseArray;
        this.BP = map;
        this.images = map2;
        this.BR = sparseArrayCompat;
        this.BQ = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void bc(String str) {
        Log.w("LOTTIE", str);
        this.BO.add(str);
    }

    public ArrayList<String> hQ() {
        return new ArrayList<>(Arrays.asList(this.BO.toArray(new String[this.BO.size()])));
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.BN.setEnabled(z);
    }

    public m getPerformanceTracker() {
        return this.BN;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer B(long j) {
        return this.BS.get(j);
    }

    public Rect hR() {
        return this.bounds;
    }

    public float hS() {
        return (ia() / this.BW) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float hT() {
        return this.BU;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float hU() {
        return this.BV;
    }

    public float hV() {
        return this.BW;
    }

    public List<Layer> hW() {
        return this.BT;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> bd(String str) {
        return this.BP.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.d> hX() {
        return this.BR;
    }

    public Map<String, com.airbnb.lottie.model.c> hY() {
        return this.BQ;
    }

    public Map<String, g> hZ() {
        return this.images;
    }

    public float ia() {
        return this.BV - this.BU;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.BT) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
