package com.airbnb.lottie.model.a;

import android.graphics.Path;
import com.airbnb.lottie.model.a.n;
import com.airbnb.lottie.model.content.h;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends o<com.airbnb.lottie.model.content.h, Path> {
    private final Path qD;

    private h(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h>> list, com.airbnb.lottie.model.content.h hVar) {
        super(list, hVar);
        this.qD = new Path();
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.h, Path> dF() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(k((com.airbnb.lottie.model.content.h) this.pN)) : new com.airbnb.lottie.a.b.l(this.pz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.model.a.o
    /* renamed from: a */
    public Path k(com.airbnb.lottie.model.content.h hVar) {
        this.qD.reset();
        com.airbnb.lottie.c.e.a(hVar, this.qD);
        return this.qD;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static h k(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a dZ = n.a(jSONObject, eVar.cK(), eVar, h.a.ry).dZ();
            return new h(dZ.pz, (com.airbnb.lottie.model.content.h) dZ.pN);
        }
    }
}
