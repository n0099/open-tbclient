package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.a.m;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements b {
    private final m<PointF, PointF> nB;
    private final com.airbnb.lottie.model.a.f nJ;
    private final String name;
    private final com.airbnb.lottie.model.a.b oh;

    private f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nB = mVar;
        this.nJ = fVar;
        this.oh = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static f t(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            return new f(jSONObject.optString("nm"), com.airbnb.lottie.model.a.e.h(jSONObject.optJSONObject("p"), eVar), f.a.i(jSONObject.optJSONObject(NotifyType.SOUND), eVar), b.a.e(jSONObject.optJSONObject("r"), eVar));
        }
    }

    public String getName() {
        return this.name;
    }

    public com.airbnb.lottie.model.a.b cY() {
        return this.oh;
    }

    public com.airbnb.lottie.model.a.f cE() {
        return this.nJ;
    }

    public m<PointF, PointF> cu() {
        return this.nB;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{cornerRadius=" + this.oh.ck() + ", position=" + this.nB + ", size=" + this.nJ + '}';
    }
}
