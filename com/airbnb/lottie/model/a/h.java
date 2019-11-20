package com.airbnb.lottie.model.a;

import android.graphics.Path;
import com.airbnb.lottie.model.a.n;
import com.airbnb.lottie.model.content.h;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends o<com.airbnb.lottie.model.content.h, Path> {
    private final Path ga;

    private h(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h>> list, com.airbnb.lottie.model.content.h hVar) {
        super(list, hVar);
        this.ga = new Path();
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.h, Path> bY() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(k((com.airbnb.lottie.model.content.h) this.fg)) : new com.airbnb.lottie.a.b.l(this.eR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.model.a.o
    /* renamed from: a */
    public Path k(com.airbnb.lottie.model.content.h hVar) {
        this.ga.reset();
        com.airbnb.lottie.c.e.a(hVar, this.ga);
        return this.ga;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static h k(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a cs = n.a(jSONObject, eVar.bb(), eVar, h.a.gU).cs();
            return new h(cs.eR, (com.airbnb.lottie.model.content.h) cs.fg);
        }
    }
}
