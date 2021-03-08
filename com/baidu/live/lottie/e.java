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
    private Map<String, List<Layer>> Dm;
    private Map<String, com.baidu.live.lottie.model.c> Dn;
    private SparseArrayCompat<com.baidu.live.lottie.model.d> Do;
    private LongSparseArray<Layer> Dp;
    private List<Layer> Dq;
    private float Dr;
    private float Ds;
    private float Dt;
    private Rect bounds;
    private Map<String, i> images;
    private final p btx = new p();
    private final HashSet<String> Dl = new HashSet<>();

    public void b(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, i> map2, SparseArrayCompat<com.baidu.live.lottie.model.d> sparseArrayCompat, Map<String, com.baidu.live.lottie.model.c> map3) {
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
        this.btx.setEnabled(z);
    }

    public p getPerformanceTracker() {
        return this.btx;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer bc(long j) {
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

    public SparseArrayCompat<com.baidu.live.lottie.model.d> hW() {
        return this.Do;
    }

    public Map<String, com.baidu.live.lottie.model.c> hX() {
        return this.Dn;
    }

    public Map<String, i> hY() {
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

    @Deprecated
    /* loaded from: classes9.dex */
    public static class a {
        @Deprecated
        public static com.baidu.live.lottie.a a(InputStream inputStream, o oVar) {
            C0193a c0193a = new C0193a(oVar);
            f.e(inputStream, (String) null).a(c0193a);
            return c0193a;
        }

        /* renamed from: com.baidu.live.lottie.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        private static final class C0193a implements com.baidu.live.lottie.a, j<e> {
            private final o bty;
            private boolean cancelled;

            private C0193a(o oVar) {
                this.cancelled = false;
                this.bty = oVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.lottie.j
            public void onResult(e eVar) {
                if (!this.cancelled) {
                    this.bty.c(eVar);
                }
            }
        }
    }
}
