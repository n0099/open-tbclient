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
    private final e nA;
    private final m<PointF, PointF> nB;
    private final g nC;
    private final b nD;
    private final d nE;
    @Nullable
    private final b nF;
    @Nullable
    private final b nG;

    private l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.nA = eVar;
        this.nB = mVar;
        this.nC = gVar;
        this.nD = bVar;
        this.nE = dVar;
        this.nF = bVar2;
        this.nG = bVar3;
    }

    public e ct() {
        return this.nA;
    }

    public m<PointF, PointF> cu() {
        return this.nB;
    }

    public g cv() {
        return this.nC;
    }

    public b cw() {
        return this.nD;
    }

    public d cx() {
        return this.nE;
    }

    @Nullable
    public b cy() {
        return this.nF;
    }

    @Nullable
    public b cz() {
        return this.nG;
    }

    public p cA() {
        return new p(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static l cB() {
            return new l(new e(), new e(), g.a.cq(), b.a.cl(), d.a.cn(), b.a.cl(), b.a.cl());
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
                M("position");
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
                M("rotation");
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

        private static void M(String str) {
            throw new IllegalArgumentException("Missing transform for " + str);
        }
    }
}
