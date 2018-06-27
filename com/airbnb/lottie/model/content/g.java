package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.l;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements b {
    private final String name;
    private final com.airbnb.lottie.model.a.b ou;
    private final com.airbnb.lottie.model.a.b ov;
    private final l ow;

    g(String str, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.ou = bVar;
        this.ov = bVar2;
        this.ow = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b db() {
        return this.ou;
    }

    public com.airbnb.lottie.model.a.b dc() {
        return this.ov;
    }

    public l dd() {
        return this.ow;
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static g u(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            return new g(jSONObject.optString("nm"), b.a.a(jSONObject.optJSONObject("c"), eVar, false), b.a.a(jSONObject.optJSONObject("o"), eVar, false), l.a.n(jSONObject.optJSONObject("tr"), eVar));
        }
    }
}
