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
    private final JSONObject qV;
    private final m.a<T> qW;
    private final float scale;

    private n(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        this.qV = jSONObject;
        this.scale = f;
        this.np = eVar;
        this.qW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        return new n<>(jSONObject, f, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> eb() {
        List<com.airbnb.lottie.a.a<T>> ec = ec();
        return new a<>(ec, h(ec));
    }

    private List<com.airbnb.lottie.a.a<T>> ec() {
        if (this.qV != null) {
            Object opt = this.qV.opt(Config.APP_KEY);
            if (j(opt)) {
                return a.C0007a.a((JSONArray) opt, this.np, this.scale, this.qW);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T h(List<com.airbnb.lottie.a.a<T>> list) {
        if (this.qV != null) {
            if (!list.isEmpty()) {
                return list.get(0).on;
            }
            return this.qW.b(this.qV.opt(Config.APP_KEY), this.scale);
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
        final List<com.airbnb.lottie.a.a<T>> pD;
        @Nullable
        final T pR;

        a(List<com.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.pD = list;
            this.pR = t;
        }
    }
}
