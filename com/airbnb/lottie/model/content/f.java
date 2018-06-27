package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.a.m;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements b {
    private final m<PointF, PointF> nK;
    private final com.airbnb.lottie.model.a.f nS;
    private final String name;
    private final com.airbnb.lottie.model.a.b ot;

    private f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nK = mVar;
        this.nS = fVar;
        this.ot = bVar;
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

    public com.airbnb.lottie.model.a.b da() {
        return this.ot;
    }

    public com.airbnb.lottie.model.a.f cG() {
        return this.nS;
    }

    public m<PointF, PointF> cw() {
        return this.nK;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.m(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{cornerRadius=" + this.ot.cm() + ", position=" + this.nK + ", size=" + this.nS + '}';
    }
}
