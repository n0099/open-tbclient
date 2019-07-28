package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.f;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements b {
    private final String name;
    private final GradientType oB;
    private final Path.FillType oC;
    private final com.airbnb.lottie.model.a.c oD;
    private final com.airbnb.lottie.model.a.f oE;
    private final com.airbnb.lottie.model.a.f oF;
    @Nullable
    private final com.airbnb.lottie.model.a.b oG;
    @Nullable
    private final com.airbnb.lottie.model.a.b oH;
    private final com.airbnb.lottie.model.a.d or;

    private d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.oB = gradientType;
        this.oC = fillType;
        this.oD = cVar;
        this.or = dVar;
        this.oE = fVar;
        this.oF = fVar2;
        this.name = str;
        this.oG = bVar;
        this.oH = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dd() {
        return this.oB;
    }

    public Path.FillType de() {
        return this.oC;
    }

    public com.airbnb.lottie.model.a.c df() {
        return this.oD;
    }

    public com.airbnb.lottie.model.a.d cU() {
        return this.or;
    }

    public com.airbnb.lottie.model.a.f dg() {
        return this.oE;
    }

    public com.airbnb.lottie.model.a.f dh() {
        return this.oF;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.g(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static d p(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject(IXAdRequestInfo.GPS);
            if (optJSONObject != null && optJSONObject.has(Config.APP_KEY)) {
                int optInt = optJSONObject.optInt("p");
                optJSONObject = optJSONObject.optJSONObject(Config.APP_KEY);
                try {
                    optJSONObject.put("p", optInt);
                } catch (JSONException e) {
                }
            }
            com.airbnb.lottie.model.a.c f = optJSONObject != null ? c.a.f(optJSONObject, eVar) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Config.OS);
            com.airbnb.lottie.model.a.d g = optJSONObject2 != null ? d.a.g(optJSONObject2, eVar) : null;
            Path.FillType fillType = jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
            GradientType gradientType = jSONObject.optInt("t", 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            com.airbnb.lottie.model.a.f i = optJSONObject3 != null ? f.a.i(optJSONObject3, eVar) : null;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            return new d(optString, gradientType, fillType, f, g, i, optJSONObject4 != null ? f.a.i(optJSONObject4, eVar) : null, null, null);
        }
    }
}
