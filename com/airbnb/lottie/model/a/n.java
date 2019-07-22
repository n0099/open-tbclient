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
    private final com.airbnb.lottie.e kI;
    @Nullable
    private final JSONObject ov;
    private final m.a<T> ow;
    private final float scale;

    private n(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        this.ov = jSONObject;
        this.scale = f;
        this.kI = eVar;
        this.ow = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        return new n<>(jSONObject, f, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> cZ() {
        List<com.airbnb.lottie.a.a<T>> da = da();
        return new a<>(da, h(da));
    }

    private List<com.airbnb.lottie.a.a<T>> da() {
        if (this.ov != null) {
            Object opt = this.ov.opt(Config.APP_KEY);
            if (j(opt)) {
                return a.C0005a.a((JSONArray) opt, this.kI, this.scale, this.ow);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T h(List<com.airbnb.lottie.a.a<T>> list) {
        if (this.ov != null) {
            if (!list.isEmpty()) {
                return list.get(0).lI;
            }
            return this.ow.b(this.ov.opt(Config.APP_KEY), this.scale);
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
        final List<com.airbnb.lottie.a.a<T>> mV;
        @Nullable
        final T nl;

        a(List<com.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.mV = list;
            this.nl = t;
        }
    }
}
