package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements m<PointF, PointF> {
    private final List<com.airbnb.lottie.a.b.h> eR;
    private PointF fY;

    public static m<PointF, PointF> h(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
        if (jSONObject.has("k")) {
            return new e(jSONObject.opt("k"), eVar);
        }
        return new i(b.a.e(jSONObject.optJSONObject(Config.EVENT_HEAT_X), eVar), b.a.e(jSONObject.optJSONObject("y"), eVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        this.eR = new ArrayList();
        this.fY = new PointF(0.0f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Object obj, com.airbnb.lottie.e eVar) {
        this.eR = new ArrayList();
        if (j(obj)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.eR.add(h.a.a(jSONArray.optJSONObject(i), eVar, a.fZ));
            }
            com.airbnb.lottie.a.a.f(this.eR);
            return;
        }
        this.fY = com.airbnb.lottie.c.b.a((JSONArray) obj, eVar.bb());
    }

    private boolean j(Object obj) {
        if (obj instanceof JSONArray) {
            Object opt = ((JSONArray) obj).opt(0);
            return (opt instanceof JSONObject) && ((JSONObject) opt).has("t");
        }
        return false;
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> bY() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.fY) : new com.airbnb.lottie.a.b.i(this.eR);
    }

    public boolean hasAnimation() {
        return !this.eR.isEmpty();
    }

    public String toString() {
        return "initialPoint=" + this.fY;
    }

    /* loaded from: classes2.dex */
    private static class a implements m.a<PointF> {
        private static final m.a<PointF> fZ = new a();

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
