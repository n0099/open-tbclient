package com.baidu.live.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.baidu.live.lottie.model.layer.Layer;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class e {
    private Map<String, List<Layer>> BN;
    private Map<String, com.baidu.live.lottie.model.c> BO;
    private SparseArrayCompat<com.baidu.live.lottie.model.d> BP;
    private LongSparseArray<Layer> BQ;
    private List<Layer> BR;
    private float BS;
    private float BT;
    private float BU;
    private Rect bounds;
    private Map<String, i> images;
    private final p bov = new p();
    private final HashSet<String> BM = new HashSet<>();

    public void b(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, i> map2, SparseArrayCompat<com.baidu.live.lottie.model.d> sparseArrayCompat, Map<String, com.baidu.live.lottie.model.c> map3) {
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

    public void setPerformanceTrackingEnabled(boolean z) {
        this.bov.setEnabled(z);
    }

    public p getPerformanceTracker() {
        return this.bov;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer aY(long j) {
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

    public SparseArrayCompat<com.baidu.live.lottie.model.d> hX() {
        return this.BP;
    }

    public Map<String, com.baidu.live.lottie.model.c> hY() {
        return this.BO;
    }

    public Map<String, i> hZ() {
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

    @Deprecated
    /* loaded from: classes9.dex */
    public static class a {
        @Deprecated
        public static com.baidu.live.lottie.a a(InputStream inputStream, o oVar) {
            C0186a c0186a = new C0186a(oVar);
            f.e(inputStream, (String) null).a(c0186a);
            return c0186a;
        }

        /* renamed from: com.baidu.live.lottie.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        private static final class C0186a implements com.baidu.live.lottie.a, j<e> {
            private final o bow;
            private boolean cancelled;

            private C0186a(o oVar) {
                this.cancelled = false;
                this.bow = oVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.lottie.j
            public void onResult(e eVar) {
                if (!this.cancelled) {
                    this.bow.c(eVar);
                }
            }
        }
    }
}
