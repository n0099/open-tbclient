package com.airbnb.lottie.model.a;

import android.graphics.Path;
import com.airbnb.lottie.model.a.n;
import com.airbnb.lottie.model.content.h;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends o<com.airbnb.lottie.model.content.h, Path> {
    private final Path nB;

    private h(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h>> list, com.airbnb.lottie.model.content.h hVar) {
        super(list, hVar);
        this.nB = new Path();
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.h, Path> ck() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(g((com.airbnb.lottie.model.content.h) this.mJ)) : new com.airbnb.lottie.a.b.l(this.mr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.model.a.o
    /* renamed from: a */
    public Path g(com.airbnb.lottie.model.content.h hVar) {
        this.nB.reset();
        com.airbnb.lottie.c.e.a(hVar, this.nB);
        return this.nB;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static h k(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a cE = n.a(jSONObject, eVar.bp(), eVar, h.a.oy).cE();
            return new h(cE.mr, (com.airbnb.lottie.model.content.h) cE.mJ);
        }
    }
}
