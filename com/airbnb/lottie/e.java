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
/* loaded from: classes18.dex */
public class e {
    private final o AO = new o();
    private final HashSet<String> AP = new HashSet<>();
    private Map<String, List<Layer>> AQ;
    private Map<String, com.airbnb.lottie.model.c> AR;
    private SparseArrayCompat<com.airbnb.lottie.model.d> AU;
    private LongSparseArray<Layer> AV;
    private List<Layer> AW;
    private float AX;
    private float AY;
    private float AZ;
    private Rect bounds;
    private Map<String, h> images;

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, h> map2, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.AX = f;
        this.AY = f2;
        this.AZ = f3;
        this.AW = list;
        this.AV = longSparseArray;
        this.AQ = map;
        this.images = map2;
        this.AU = sparseArrayCompat;
        this.AR = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void bc(String str) {
        Log.w("LOTTIE", str);
        this.AP.add(str);
    }

    public ArrayList<String> is() {
        return new ArrayList<>(Arrays.asList(this.AP.toArray(new String[this.AP.size()])));
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.AO.setEnabled(z);
    }

    public o getPerformanceTracker() {
        return this.AO;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer D(long j) {
        return this.AV.get(j);
    }

    public Rect it() {
        return this.bounds;
    }

    public float iu() {
        return (iC() / this.AZ) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float iv() {
        return this.AX;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float iw() {
        return this.AY;
    }

    public float ix() {
        return this.AZ;
    }

    public List<Layer> iy() {
        return this.AW;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> bd(String str) {
        return this.AQ.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.d> iz() {
        return this.AU;
    }

    public Map<String, com.airbnb.lottie.model.c> iA() {
        return this.AR;
    }

    public Map<String, h> iB() {
        return this.images;
    }

    public float iC() {
        return this.AY - this.AX;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.AW) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    @Deprecated
    /* loaded from: classes18.dex */
    public static class a {
        @Deprecated
        public static com.airbnb.lottie.a a(Context context, String str, n nVar) {
            C0011a c0011a = new C0011a(nVar);
            f.t(context, str).a(c0011a);
            return c0011a;
        }

        /* renamed from: com.airbnb.lottie.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        private static final class C0011a implements com.airbnb.lottie.a, i<e> {
            private final n Ba;
            private boolean cancelled;

            private C0011a(n nVar) {
                this.cancelled = false;
                this.Ba = nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.i
            public void onResult(e eVar) {
                if (!this.cancelled) {
                    this.Ba.onCompositionLoaded(eVar);
                }
            }
        }
    }
}
