package com.airbnb.lottie.model.a;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a;
import com.airbnb.lottie.model.a.m;
import com.baidu.appsearchlib.Info;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n<T> {
    private final com.airbnb.lottie.e jY;
    @Nullable
    private final JSONObject nH;
    private final m.a<T> nI;
    private final float scale;

    private n(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        this.nH = jSONObject;
        this.scale = f;
        this.jY = eVar;
        this.nI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        return new n<>(jSONObject, f, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> cC() {
        List<com.airbnb.lottie.a.a<T>> cD = cD();
        return new a<>(cD, h(cD));
    }

    private List<com.airbnb.lottie.a.a<T>> cD() {
        if (this.nH != null) {
            Object opt = this.nH.opt("k");
            if (f(opt)) {
                return a.C0004a.a((JSONArray) opt, this.jY, this.scale, this.nI);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T h(List<com.airbnb.lottie.a.a<T>> list) {
        if (this.nH != null) {
            if (!list.isEmpty()) {
                return list.get(0).kY;
            }
            return this.nI.b(this.nH.opt("k"), this.scale);
        }
        return null;
    }

    private static boolean f(Object obj) {
        if (obj instanceof JSONArray) {
            Object opt = ((JSONArray) obj).opt(0);
            return (opt instanceof JSONObject) && ((JSONObject) opt).has(Info.kBaiduTimeKey);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> {
        final List<com.airbnb.lottie.a.a<T>> mj;
        @Nullable
        final T mz;

        a(List<com.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.mj = list;
            this.mz = t;
        }
    }
}
