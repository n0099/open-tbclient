package com.airbnb.lottie.model.a;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a;
import com.airbnb.lottie.model.a.m;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n<T> {
    private final com.airbnb.lottie.e dk;
    @Nullable
    private final JSONObject gO;
    private final m.a<T> gP;
    private final float scale;

    private n(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        this.gO = jSONObject;
        this.scale = f;
        this.dk = eVar;
        this.gP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        return new n<>(jSONObject, f, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> cs() {
        List<com.airbnb.lottie.a.a<T>> ct = ct();
        return new a<>(ct, h(ct));
    }

    private List<com.airbnb.lottie.a.a<T>> ct() {
        if (this.gO != null) {
            Object opt = this.gO.opt("k");
            if (j(opt)) {
                return a.C0005a.a((JSONArray) opt, this.dk, this.scale, this.gP);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T h(List<com.airbnb.lottie.a.a<T>> list) {
        if (this.gO != null) {
            if (!list.isEmpty()) {
                return list.get(0).ej;
            }
            return this.gP.b(this.gO.opt("k"), this.scale);
        }
        return null;
    }

    private static boolean j(Object obj) {
        if (obj instanceof JSONArray) {
            Object opt = ((JSONArray) obj).opt(0);
            return (opt instanceof JSONObject) && ((JSONObject) opt).has("t");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> {
        @Nullable
        final T fI;
        final List<com.airbnb.lottie.a.a<T>> fu;

        a(List<com.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.fu = list;
            this.fI = t;
        }
    }
}
