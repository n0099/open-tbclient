package com.airbnb.lottie.model.a;

import android.graphics.Path;
import com.airbnb.lottie.model.a.n;
import com.airbnb.lottie.model.content.h;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends o<com.airbnb.lottie.model.content.h, Path> {
    private final Path gz;

    private h(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h>> list, com.airbnb.lottie.model.content.h hVar) {
        super(list, hVar);
        this.gz = new Path();
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.h, Path> bY() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(k((com.airbnb.lottie.model.content.h) this.fI)) : new com.airbnb.lottie.a.b.l(this.fu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.model.a.o
    /* renamed from: a */
    public Path k(com.airbnb.lottie.model.content.h hVar) {
        this.gz.reset();
        com.airbnb.lottie.c.e.a(hVar, this.gz);
        return this.gz;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static h k(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a cs = n.a(jSONObject, eVar.bb(), eVar, h.a.hu).cs();
            return new h(cs.fu, (com.airbnb.lottie.model.content.h) cs.fI);
        }
    }
}
