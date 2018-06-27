package com.airbnb.lottie.model.a;

import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends o<Float, Float> {
    private b() {
        super(Float.valueOf(0.0f));
    }

    private b(List<com.airbnb.lottie.a.a<Float>> list, Float f) {
        super(list, f);
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<Float, Float> ck() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.mJ) : new com.airbnb.lottie.a.b.c(this.mr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.model.a.o
    /* renamed from: cl */
    public Float cm() {
        return (Float) this.mJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.model.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0008b implements m.a<Float> {
        static final C0008b nw = new C0008b();

        private C0008b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.model.a.m.a
        /* renamed from: e */
        public Float b(Object obj, float f) {
            return Float.valueOf(com.airbnb.lottie.c.b.h(obj) * f);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static b cn() {
            return new b();
        }

        public static b e(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            return a(jSONObject, eVar, true);
        }

        public static b a(JSONObject jSONObject, com.airbnb.lottie.e eVar, boolean z) {
            float bp = z ? eVar.bp() : 1.0f;
            if (jSONObject != null && jSONObject.has("x")) {
                eVar.E("Lottie doesn't support expressions.");
            }
            n.a cE = n.a(jSONObject, bp, eVar, C0008b.nw).cE();
            return new b(cE.mr, (Float) cE.mJ);
        }
    }
}
