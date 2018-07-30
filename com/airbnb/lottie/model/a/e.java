package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.baidu.appsearchlib.Info;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements m<PointF, PointF> {
    private final List<com.airbnb.lottie.a.b.h> mi;
    private PointF np;

    public static m<PointF, PointF> h(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
        if (jSONObject.has("k")) {
            return new e(jSONObject.opt("k"), eVar);
        }
        return new i(b.a.e(jSONObject.optJSONObject("x"), eVar), b.a.e(jSONObject.optJSONObject("y"), eVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        this.mi = new ArrayList();
        this.np = new PointF(0.0f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Object obj, com.airbnb.lottie.e eVar) {
        this.mi = new ArrayList();
        if (f(obj)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.mi.add(h.a.a(jSONArray.optJSONObject(i), eVar, a.nq));
            }
            com.airbnb.lottie.a.a.f(this.mi);
            return;
        }
        this.np = com.airbnb.lottie.c.b.a((JSONArray) obj, eVar.bn());
    }

    private boolean f(Object obj) {
        if (obj instanceof JSONArray) {
            Object opt = ((JSONArray) obj).opt(0);
            return (opt instanceof JSONObject) && ((JSONObject) opt).has(Info.kBaiduTimeKey);
        }
        return false;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> ci() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.np) : new com.airbnb.lottie.a.b.i(this.mi);
    }

    public boolean hasAnimation() {
        return !this.mi.isEmpty();
    }

    public String toString() {
        return "initialPoint=" + this.np;
    }

    /* loaded from: classes2.dex */
    private static class a implements m.a<PointF> {
        private static final m.a<PointF> nq = new a();

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.model.a.m.a
        /* renamed from: c */
        public PointF b(Object obj, float f) {
            return com.airbnb.lottie.c.b.a((JSONArray) obj, f);
        }
    }
}
