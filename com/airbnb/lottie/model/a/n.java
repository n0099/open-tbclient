package com.airbnb.lottie.model.a;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a;
import com.airbnb.lottie.model.a.m;
import com.baidu.mobstat.Config;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n<T> {
    private final com.airbnb.lottie.e nj;
    @Nullable
    private final JSONObject qS;
    private final m.a<T> qT;
    private final float scale;

    private n(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        this.qS = jSONObject;
        this.scale = f;
        this.nj = eVar;
        this.qT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        return new n<>(jSONObject, f, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> dZ() {
        List<com.airbnb.lottie.a.a<T>> ea = ea();
        return new a<>(ea, h(ea));
    }

    private List<com.airbnb.lottie.a.a<T>> ea() {
        if (this.qS != null) {
            Object opt = this.qS.opt(Config.APP_KEY);
            if (j(opt)) {
                return a.C0005a.a((JSONArray) opt, this.nj, this.scale, this.qT);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T h(List<com.airbnb.lottie.a.a<T>> list) {
        if (this.qS != null) {
            if (!list.isEmpty()) {
                return list.get(0).oh;
            }
            return this.qT.b(this.qS.opt(Config.APP_KEY), this.scale);
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
        final T pN;
        final List<com.airbnb.lottie.a.a<T>> pz;

        a(List<com.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.pz = list;
            this.pN = t;
        }
    }
}
