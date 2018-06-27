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
    private final com.airbnb.lottie.e kg;
    @Nullable
    private final JSONObject nQ;
    private final m.a<T> nR;
    private final float scale;

    private n(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        this.nQ = jSONObject;
        this.scale = f;
        this.kg = eVar;
        this.nR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, com.airbnb.lottie.e eVar, m.a<T> aVar) {
        return new n<>(jSONObject, f, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> cE() {
        List<com.airbnb.lottie.a.a<T>> cF = cF();
        return new a<>(cF, h(cF));
    }

    private List<com.airbnb.lottie.a.a<T>> cF() {
        if (this.nQ != null) {
            Object opt = this.nQ.opt("k");
            if (f(opt)) {
                return a.C0004a.a((JSONArray) opt, this.kg, this.scale, this.nR);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T h(List<com.airbnb.lottie.a.a<T>> list) {
        if (this.nQ != null) {
            if (!list.isEmpty()) {
                return list.get(0).lf;
            }
            return this.nR.b(this.nQ.opt("k"), this.scale);
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
        @Nullable
        final T mJ;
        final List<com.airbnb.lottie.a.a<T>> mr;

        a(List<com.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.mr = list;
            this.mJ = t;
        }
    }
}
