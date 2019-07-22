package com.airbnb.lottie.model.a;

import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.a.n;
import com.baidu.mobstat.Config;
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
    public com.airbnb.lottie.a.b.a<Float, Float> cF() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.nl) : new com.airbnb.lottie.a.b.c(this.mV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.model.a.o
    /* renamed from: cG */
    public Float cH() {
        return (Float) this.nl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.airbnb.lottie.model.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0009b implements m.a<Float> {
        static final C0009b nY = new C0009b();

        private C0009b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.model.a.m.a
        /* renamed from: e */
        public Float b(Object obj, float f) {
            return Float.valueOf(com.airbnb.lottie.c.b.l(obj) * f);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static b cI() {
            return new b();
        }

        public static b e(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            return a(jSONObject, eVar, true);
        }

        public static b a(JSONObject jSONObject, com.airbnb.lottie.e eVar, boolean z) {
            float bI = z ? eVar.bI() : 1.0f;
            if (jSONObject != null && jSONObject.has(Config.EVENT_HEAT_X)) {
                eVar.E("Lottie doesn't support expressions.");
            }
            n.a cZ = n.a(jSONObject, bI, eVar, C0009b.nY).cZ();
            return new b(cZ.mV, (Float) cZ.nl);
        }
    }
}
