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
/* loaded from: classes10.dex */
public class e {
    private Map<String, List<Layer>> BP;
    private Map<String, com.baidu.live.lottie.model.c> BQ;
    private SparseArrayCompat<com.baidu.live.lottie.model.d> BR;
    private LongSparseArray<Layer> BS;
    private List<Layer> BT;
    private float BU;
    private float BV;
    private float BW;
    private Rect bounds;
    private Map<String, i> images;
    private final p bth = new p();
    private final HashSet<String> BO = new HashSet<>();

    public void b(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, i> map2, SparseArrayCompat<com.baidu.live.lottie.model.d> sparseArrayCompat, Map<String, com.baidu.live.lottie.model.c> map3) {
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

    public void setPerformanceTrackingEnabled(boolean z) {
        this.bth.setEnabled(z);
    }

    public p getPerformanceTracker() {
        return this.bth;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer aY(long j) {
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

    public SparseArrayCompat<com.baidu.live.lottie.model.d> hX() {
        return this.BR;
    }

    public Map<String, com.baidu.live.lottie.model.c> hY() {
        return this.BQ;
    }

    public Map<String, i> hZ() {
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

    @Deprecated
    /* loaded from: classes10.dex */
    public static class a {
        @Deprecated
        public static com.baidu.live.lottie.a a(InputStream inputStream, o oVar) {
            C0195a c0195a = new C0195a(oVar);
            f.e(inputStream, (String) null).a(c0195a);
            return c0195a;
        }

        /* renamed from: com.baidu.live.lottie.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        private static final class C0195a implements com.baidu.live.lottie.a, j<e> {
            private final o bti;
            private boolean cancelled;

            private C0195a(o oVar) {
                this.cancelled = false;
                this.bti = oVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.lottie.j
            public void onResult(e eVar) {
                if (!this.cancelled) {
                    this.bti.c(eVar);
                }
            }
        }
    }
}
