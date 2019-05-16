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
    public com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> cz() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.nm) : new com.airbnb.lottie.a.b.k(this.mW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static g j(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a cT = n.a(jSONObject, 1.0f, eVar, k.a.nW).cT();
            return new g(cT.mW, (com.airbnb.lottie.model.k) cT.nm);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static g cH() {
            return new g();
        }
    }
}
