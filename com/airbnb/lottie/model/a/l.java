package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.g;
import com.baidu.mobstat.Config;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e gi;
    private final m<PointF, PointF> gj;
    private final g gk;
    private final b gl;
    private final d gm;
    @Nullable
    private final b gn;
    @Nullable
    private final b go;

    private l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.gi = eVar;
        this.gj = mVar;
        this.gk = gVar;
        this.gl = bVar;
        this.gm = dVar;
        this.gn = bVar2;
        this.go = bVar3;
    }

    public e cj() {
        return this.gi;
    }

    public m<PointF, PointF> ck() {
        return this.gj;
    }

    public g cl() {
        return this.gk;
    }

    public b cm() {
        return this.gl;
    }

    public d cn() {
        return this.gm;
    }

    @Nullable
    public b co() {
        return this.gn;
    }

    @Nullable
    public b cp() {
        return this.go;
    }

    public p cq() {
        return new p(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static l cr() {
            return new l(new e(), new e(), g.a.cg(), b.a.cb(), d.a.cd(), b.a.cb(), b.a.cb());
        }

        public static l n(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            e eVar2;
            m<PointF, PointF> mVar;
            g gVar;
            b bVar;
            d dVar;
            JSONObject optJSONObject = jSONObject.optJSONObject(Config.APP_VERSION_CODE);
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
                M("rotation");
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

        private static void M(String str) {
            throw new IllegalArgumentException("Missing transform for " + str);
        }
    }
}
