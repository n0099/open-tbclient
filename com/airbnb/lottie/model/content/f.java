package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.a.m;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements b {
    private final com.airbnb.lottie.model.a.b gP;
    private final m<PointF, PointF> gj;
    private final com.airbnb.lottie.model.a.f gr;
    private final String name;

    private f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.gj = mVar;
        this.gr = fVar;
        this.gP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static f t(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            return new f(jSONObject.optString("nm"), com.airbnb.lottie.model.a.e.h(jSONObject.optJSONObject("p"), eVar), f.a.i(jSONObject.optJSONObject("s"), eVar), b.a.e(jSONObject.optJSONObject("r"), eVar));
        }
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b cP() {
        return this.gP;
    }

    public com.airbnb.lottie.model.a.f cu() {
        return this.gr;
    }

    public m<PointF, PointF> ck() {
        return this.gj;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{cornerRadius=" + this.gP.ca() + ", position=" + this.gj + ", size=" + this.gr + '}';
    }
}
