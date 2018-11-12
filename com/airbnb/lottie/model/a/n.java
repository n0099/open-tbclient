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
    private final com.airbnb.lottie.e np;
    @Nullable
    private final JSONObject qW;
    private final m.a<T> qX;
    private final float scale;

    private n(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        this.qW = jSONObject;
        this.scale = f;
        this.np = eVar;
        this.qX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        return new n<>(jSONObject, f, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> ea() {
        List<com.airbnb.lottie.a.a<T>> eb = eb();
        return new a<>(eb, h(eb));
    }

    private List<com.airbnb.lottie.a.a<T>> eb() {
        if (this.qW != null) {
            Object opt = this.qW.opt(Config.APP_KEY);
            if (j(opt)) {
                return a.C0007a.a((JSONArray) opt, this.np, this.scale, this.qX);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T h(List<com.airbnb.lottie.a.a<T>> list) {
        if (this.qW != null) {
            if (!list.isEmpty()) {
                return list.get(0).on;
            }
            return this.qX.b(this.qW.opt(Config.APP_KEY), this.scale);
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
        final List<com.airbnb.lottie.a.a<T>> pE;
        @Nullable
        final T pS;

        a(List<com.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.pE = list;
            this.pS = t;
        }
    }
}
