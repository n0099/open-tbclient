package com.airbnb.lottie.model.a;

import com.airbnb.lottie.model.a.n;
import com.airbnb.lottie.model.k;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends o<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> {
    private g() {
        super(new com.airbnb.lottie.model.k());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.k>> list, com.airbnb.lottie.model.k kVar) {
        super(list, kVar);
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> bY() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.fg) : new com.airbnb.lottie.a.b.k(this.eR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static g j(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a cs = n.a(jSONObject, 1.0f, eVar, k.a.fU).cs();
            return new g(cs.eR, (com.airbnb.lottie.model.k) cs.fg);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static g cg() {
            return new g();
        }
    }
}
