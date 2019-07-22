package com.airbnb.lottie.model.a;

import android.graphics.Path;
import com.airbnb.lottie.model.a.n;
import com.airbnb.lottie.model.content.h;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends o<com.airbnb.lottie.model.content.h, Path> {
    private final Path od;

    private h(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h>> list, com.airbnb.lottie.model.content.h hVar) {
        super(list, hVar);
        this.od = new Path();
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.h, Path> cF() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(k((com.airbnb.lottie.model.content.h) this.nl)) : new com.airbnb.lottie.a.b.l(this.mV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.model.a.o
    /* renamed from: a */
    public Path k(com.airbnb.lottie.model.content.h hVar) {
        this.od.reset();
        com.airbnb.lottie.c.e.a(hVar, this.od);
        return this.od;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static h k(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a cZ = n.a(jSONObject, eVar.bI(), eVar, h.a.pa).cZ();
            return new h(cZ.mV, (com.airbnb.lottie.model.content.h) cZ.nl);
        }
    }
}
