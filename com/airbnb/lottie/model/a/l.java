package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.g;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e qO;
    private final m<PointF, PointF> qP;
    private final g qQ;
    private final b qR;
    private final d qS;
    @Nullable
    private final b qT;
    @Nullable
    private final b qU;

    private l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.qO = eVar;
        this.qP = mVar;
        this.qQ = gVar;
        this.qR = bVar;
        this.qS = dVar;
        this.qT = bVar2;
        this.qU = bVar3;
    }

    public e dS() {
        return this.qO;
    }

    public m<PointF, PointF> dT() {
        return this.qP;
    }

    public g dU() {
        return this.qQ;
    }

    public b dV() {
        return this.qR;
    }

    public d dW() {
        return this.qS;
    }

    @Nullable
    public b dX() {
        return this.qT;
    }

    @Nullable
    public b dY() {
        return this.qU;
    }

    public p dZ() {
        return new p(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static l ea() {
            return new l(new e(), new e(), g.a.dP(), b.a.dK(), d.a.dM(), b.a.dK(), b.a.dK());
        }

        public static l n(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            e eVar2;
            m<PointF, PointF> mVar;
            g gVar;
            b bVar;
            d dVar;
            JSONObject optJSONObject = jSONObject.optJSONObject(Config.APP_VERSION_CODE);
            if (optJSONObject != null) {
                eVar2 = new e(optJSONObject.opt(Config.APP_KEY), eVar);
            } else {
                Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
                eVar2 = new e();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("p");
            if (optJSONObject2 != null) {
                mVar = e.h(optJSONObject2, eVar);
            } else {
                ad(AiAppsNaViewModel.KEY_POSITION);
                mVar = null;
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
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
            JSONObject optJSONObject5 = jSONObject.optJSONObject(Config.OS);
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
