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
    private final List<com.airbnb.lottie.a.b.h> fu;
    private PointF gx;

    public static m<PointF, PointF> h(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
        if (jSONObject.has("k")) {
            return new e(jSONObject.opt("k"), eVar);
        }
        return new i(b.a.e(jSONObject.optJSONObject(Config.EVENT_HEAT_X), eVar), b.a.e(jSONObject.optJSONObject("y"), eVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        this.fu = new ArrayList();
        this.gx = new PointF(0.0f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Object obj, com.airbnb.lottie.e eVar) {
        this.fu = new ArrayList();
        if (j(obj)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.fu.add(h.a.a(jSONArray.optJSONObject(i), eVar, a.gy));
            }
            com.airbnb.lottie.a.a.f(this.fu);
            return;
        }
        this.gx = com.airbnb.lottie.c.b.a((JSONArray) obj, eVar.bb());
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
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.gx) : new com.airbnb.lottie.a.b.i(this.fu);
    }

    public boolean hasAnimation() {
        return !this.fu.isEmpty();
    }

    public String toString() {
        return "initialPoint=" + this.gx;
    }

    /* loaded from: classes2.dex */
    private static class a implements m.a<PointF> {
        private static final m.a<PointF> gy = new a();

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
