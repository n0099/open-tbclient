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
    @Nullable
    private final com.airbnb.lottie.model.a.b gA;
    @Nullable
    private final com.airbnb.lottie.model.a.b gB;
    private final com.airbnb.lottie.model.a.d gm;
    private final GradientType gv;
    private final Path.FillType gw;
    private final com.airbnb.lottie.model.a.c gx;
    private final com.airbnb.lottie.model.a.f gy;
    private final com.airbnb.lottie.model.a.f gz;
    private final String name;

    private d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.gv = gradientType;
        this.gw = fillType;
        this.gx = cVar;
        this.gm = dVar;
        this.gy = fVar;
        this.gz = fVar2;
        this.name = str;
        this.gA = bVar;
        this.gB = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cw() {
        return this.gv;
    }

    public Path.FillType cx() {
        return this.gw;
    }

    public com.airbnb.lottie.model.a.c cy() {
        return this.gx;
    }

    public com.airbnb.lottie.model.a.d cn() {
        return this.gm;
    }

    public com.airbnb.lottie.model.a.f cz() {
        return this.gy;
    }

    public com.airbnb.lottie.model.a.f cA() {
        return this.gz;
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
            if (optJSONObject != null && optJSONObject.has("k")) {
                int optInt = optJSONObject.optInt("p");
                optJSONObject = optJSONObject.optJSONObject("k");
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
