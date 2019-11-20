package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.a.m;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements b {
    private final m<PointF, PointF> gj;
    private final com.airbnb.lottie.model.a.f gr;
    private final boolean gs;
    private final String name;

    private a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.gj = mVar;
        this.gr = fVar;
        this.gs = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.content.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0010a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static a o(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            return new a(jSONObject.optString("nm"), com.airbnb.lottie.model.a.e.h(jSONObject.optJSONObject("p"), eVar), f.a.i(jSONObject.optJSONObject("s"), eVar), jSONObject.optInt("d", 2) == 3);
        }
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> ck() {
        return this.gj;
    }

    public com.airbnb.lottie.model.a.f cu() {
        return this.gr;
    }

    public boolean isReversed() {
        return this.gs;
    }
}
