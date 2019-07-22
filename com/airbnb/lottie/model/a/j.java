package com.airbnb.lottie.model.a;

import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.a.n;
import com.airbnb.lottie.model.d;
import com.baidu.mobstat.Config;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends o<com.airbnb.lottie.model.d, com.airbnb.lottie.model.d> {
    j(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.d>> list, com.airbnb.lottie.model.d dVar) {
        super(list, dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.model.a.m
    /* renamed from: cO */
    public com.airbnb.lottie.a.b.o cF() {
        return new com.airbnb.lottie.a.b.o(this.mV);
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static j l(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            if (jSONObject != null && jSONObject.has(Config.EVENT_HEAT_X)) {
                eVar.E("Lottie doesn't support expressions.");
            }
            n.a cZ = n.a(jSONObject, 1.0f, eVar, b.og).cZ();
            return new j(cZ.mV, (com.airbnb.lottie.model.d) cZ.nl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements m.a<com.airbnb.lottie.model.d> {
        private static final b og = new b();

        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.model.a.m.a
        /* renamed from: g */
        public com.airbnb.lottie.model.d b(Object obj, float f) {
            return d.a.e((JSONObject) obj);
        }
    }
}
