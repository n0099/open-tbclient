package com.airbnb.lottie.model.a;

import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.a.n;
import com.baidu.mobstat.Config;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends o<Integer, Integer> {
    private d() {
        super(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List<com.airbnb.lottie.a.a<Integer>> list, Integer num) {
        super(list, num);
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<Integer, Integer> dH() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.pR) : new com.airbnb.lottie.a.b.e(this.pD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.model.a.o
    /* renamed from: dL */
    public Integer dJ() {
        return (Integer) this.pR;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static d dM() {
            return new d();
        }

        public static d g(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            if (jSONObject != null && jSONObject.has(Config.EVENT_HEAT_X)) {
                eVar.V("Lottie doesn't support expressions.");
            }
            n.a eb = n.a(jSONObject, 1.0f, eVar, b.qD).eb();
            return new d(eb.pD, (Integer) eb.pR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements m.a<Integer> {
        private static final b qD = new b();

        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.model.a.m.a
        /* renamed from: a */
        public Integer b(Object obj, float f) {
            return Integer.valueOf(Math.round(com.airbnb.lottie.c.b.l(obj) * f));
        }
    }
}
