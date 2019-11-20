package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.model.a.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k implements b {
    private final com.airbnb.lottie.model.a.h gW;
    private final int index;
    private final String name;

    private k(String str, int i, com.airbnb.lottie.model.a.h hVar) {
        this.name = str;
        this.index = i;
        this.gW = hVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.h cW() {
        return this.gW;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.name + ", index=" + this.index + ", hasAnimation=" + this.gW.hasAnimation() + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static k z(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            return new k(jSONObject.optString("nm"), jSONObject.optInt("ind"), h.a.k(jSONObject.optJSONObject("ks"), eVar));
        }
    }
}
