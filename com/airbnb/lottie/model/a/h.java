package com.airbnb.lottie.model.a;

import android.graphics.Path;
import com.airbnb.lottie.model.a.n;
import com.airbnb.lottie.model.content.h;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends o<com.airbnb.lottie.model.content.h, Path> {
    private final Path pT;

    private h(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h>> list, com.airbnb.lottie.model.content.h hVar) {
        super(list, hVar);
        this.pT = new Path();
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.h, Path> dp() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(h((com.airbnb.lottie.model.content.h) this.oZ)) : new com.airbnb.lottie.a.b.l(this.oL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.model.a.o
    /* renamed from: a */
    public Path h(com.airbnb.lottie.model.content.h hVar) {
        this.pT.reset();
        com.airbnb.lottie.c.e.a(hVar, this.pT);
        return this.pT;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static h k(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a dJ = n.a(jSONObject, eVar.cu(), eVar, h.a.qO).dJ();
            return new h(dJ.oL, (com.airbnb.lottie.model.content.h) dJ.oZ);
        }
    }
}
