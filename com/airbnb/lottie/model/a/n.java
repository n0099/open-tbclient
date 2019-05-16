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
    private final com.airbnb.lottie.e kJ;
    @Nullable
    private final JSONObject ou;
    private final m.a<T> ov;
    private final float scale;

    private n(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        this.ou = jSONObject;
        this.scale = f;
        this.kJ = eVar;
        this.ov = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        return new n<>(jSONObject, f, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> cT() {
        List<com.airbnb.lottie.a.a<T>> cU = cU();
        return new a<>(cU, h(cU));
    }

    private List<com.airbnb.lottie.a.a<T>> cU() {
        if (this.ou != null) {
            Object opt = this.ou.opt(Config.APP_KEY);
            if (j(opt)) {
                return a.C0005a.a((JSONArray) opt, this.kJ, this.scale, this.ov);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T h(List<com.airbnb.lottie.a.a<T>> list) {
        if (this.ou != null) {
            if (!list.isEmpty()) {
                return list.get(0).lJ;
            }
            return this.ov.b(this.ou.opt(Config.APP_KEY), this.scale);
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
        final List<com.airbnb.lottie.a.a<T>> mW;
        @Nullable
        final T nm;

        a(List<com.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.mW = list;
            this.nm = t;
        }
    }
}
