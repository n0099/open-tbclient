package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.a.m;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements b {
    private final m<PointF, PointF> nA;
    private final com.airbnb.lottie.model.a.f nI;
    private final boolean nJ;
    private final String name;

    private a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.nA = mVar;
        this.nI = fVar;
        this.nJ = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.content.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0009a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static a o(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            return new a(jSONObject.optString("nm"), com.airbnb.lottie.model.a.e.h(jSONObject.optJSONObject("p"), eVar), f.a.i(jSONObject.optJSONObject(NotifyType.SOUND), eVar), jSONObject.optInt("d", 2) == 3);
        }
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> cu() {
        return this.nA;
    }

    public com.airbnb.lottie.model.a.f cE() {
        return this.nI;
    }

    public boolean isReversed() {
        return this.nJ;
    }
}
