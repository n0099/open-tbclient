package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.f;
import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements b {
    private final String name;
    private final com.airbnb.lottie.model.a.d qS;
    private final GradientType rb;
    private final Path.FillType rc;
    private final com.airbnb.lottie.model.a.c rd;
    private final com.airbnb.lottie.model.a.f re;
    private final com.airbnb.lottie.model.a.f rf;
    @Nullable
    private final com.airbnb.lottie.model.a.b rg;
    @Nullable
    private final com.airbnb.lottie.model.a.b rh;

    private d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.rb = gradientType;
        this.rc = fillType;
        this.rd = cVar;
        this.qS = dVar;
        this.re = fVar;
        this.rf = fVar2;
        this.name = str;
        this.rg = bVar;
        this.rh = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType ef() {
        return this.rb;
    }

    public Path.FillType getFillType() {
        return this.rc;
    }

    public com.airbnb.lottie.model.a.c eg() {
        return this.rd;
    }

    public com.airbnb.lottie.model.a.d dW() {
        return this.qS;
    }

    public com.airbnb.lottie.model.a.f eh() {
        return this.re;
    }

    public com.airbnb.lottie.model.a.f ei() {
        return this.rf;
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
            JSONObject optJSONObject = jSONObject.optJSONObject("g");
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
