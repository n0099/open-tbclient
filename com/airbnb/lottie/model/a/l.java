package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.g;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e qL;
    private final m<PointF, PointF> qM;
    private final g qN;
    private final b qO;
    private final d qP;
    @Nullable
    private final b qQ;
    @Nullable
    private final b qR;

    private l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.qL = eVar;
        this.qM = mVar;
        this.qN = gVar;
        this.qO = bVar;
        this.qP = dVar;
        this.qQ = bVar2;
        this.qR = bVar3;
    }

    public e dQ() {
        return this.qL;
    }

    public m<PointF, PointF> dR() {
        return this.qM;
    }

    public g dS() {
        return this.qN;
    }

    public b dT() {
        return this.qO;
    }

    public d dU() {
        return this.qP;
    }

    @Nullable
    public b dV() {
        return this.qQ;
    }

    @Nullable
    public b dW() {
        return this.qR;
    }

    public p dX() {
        return new p(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static l dY() {
            return new l(new e(), new e(), g.a.dN(), b.a.dI(), d.a.dK(), b.a.dI(), b.a.dI());
        }

        public static l n(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            e eVar2;
            m<PointF, PointF> mVar;
            g gVar;
            b bVar;
            d dVar;
            JSONObject optJSONObject = jSONObject.optJSONObject("a");
            if (optJSONObject != null) {
                eVar2 = new e(optJSONObject.opt("k"), eVar);
            } else {
                Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
                eVar2 = new e();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("p");
            if (optJSONObject2 != null) {
                mVar = e.h(optJSONObject2, eVar);
            } else {
                ad("position");
                mVar = null;
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(NotifyType.SOUND);
            if (optJSONObject3 != null) {
                gVar = g.a.j(optJSONObject3, eVar);
            } else {
                gVar = new g(Collections.emptyList(), new com.airbnb.lottie.model.k());
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("r");
            if (optJSONObject4 == null) {
                optJSONObject4 = jSONObject.optJSONObject("rz");
            }
            if (optJSONObject4 != null) {
                bVar = b.a.a(optJSONObject4, eVar, false);
            } else {
                ad("rotation");
                bVar = null;
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("o");
            if (optJSONObject5 != null) {
                dVar = d.a.g(optJSONObject5, eVar);
            } else {
                dVar = new d(Collections.emptyList(), 100);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("so");
            b a = optJSONObject6 != null ? b.a.a(optJSONObject6, eVar, false) : null;
            JSONObject optJSONObject7 = jSONObject.optJSONObject("eo");
            return new l(eVar2, mVar, gVar, bVar, dVar, a, optJSONObject7 != null ? b.a.a(optJSONObject7, eVar, false) : null);
        }

        private static void ad(String str) {
            throw new IllegalArgumentException("Missing transform for " + str);
        }
    }
}
