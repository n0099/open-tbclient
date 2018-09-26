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
    private final com.airbnb.lottie.e my;
    @Nullable
    private final JSONObject qi;
    private final m.a<T> qj;
    private final float scale;

    private n(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        this.qi = jSONObject;
        this.scale = f;
        this.my = eVar;
        this.qj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        return new n<>(jSONObject, f, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> dJ() {
        List<com.airbnb.lottie.a.a<T>> dK = dK();
        return new a<>(dK, h(dK));
    }

    private List<com.airbnb.lottie.a.a<T>> dK() {
        if (this.qi != null) {
            Object opt = this.qi.opt(Config.APP_KEY);
            if (g(opt)) {
                return a.C0004a.a((JSONArray) opt, this.my, this.scale, this.qj);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T h(List<com.airbnb.lottie.a.a<T>> list) {
        if (this.qi != null) {
            if (!list.isEmpty()) {
                return list.get(0).nA;
            }
            return this.qj.b(this.qi.opt(Config.APP_KEY), this.scale);
        }
        return null;
    }

    private static boolean g(Object obj) {
        if (obj instanceof JSONArray) {
            Object opt = ((JSONArray) obj).opt(0);
            return (opt instanceof JSONObject) && ((JSONObject) opt).has("t");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> {
        final List<com.airbnb.lottie.a.a<T>> oL;
        @Nullable
        final T oZ;

        a(List<com.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.oL = list;
            this.oZ = t;
        }
    }
}
