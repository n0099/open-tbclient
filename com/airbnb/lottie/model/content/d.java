package com.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.f;
import com.baidu.appsearchlib.Info;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements b {
    private final com.airbnb.lottie.model.a.d nD;
    private final GradientType nM;
    private final Path.FillType nN;
    private final com.airbnb.lottie.model.a.c nO;
    private final com.airbnb.lottie.model.a.f nP;
    private final com.airbnb.lottie.model.a.f nQ;
    @Nullable
    private final com.airbnb.lottie.model.a.b nR;
    @Nullable
    private final com.airbnb.lottie.model.a.b nS;
    private final String name;

    private d(String str, GradientType gradientType, Path.FillType fillType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, com.airbnb.lottie.model.a.b bVar2) {
        this.nM = gradientType;
        this.nN = fillType;
        this.nO = cVar;
        this.nD = dVar;
        this.nP = fVar;
        this.nQ = fVar2;
        this.name = str;
        this.nR = bVar;
        this.nS = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cG() {
        return this.nM;
    }

    public Path.FillType getFillType() {
        return this.nN;
    }

    public com.airbnb.lottie.model.a.c cH() {
        return this.nO;
    }

    public com.airbnb.lottie.model.a.d cx() {
        return this.nD;
    }

    public com.airbnb.lottie.model.a.f cI() {
        return this.nP;
    }

    public com.airbnb.lottie.model.a.f cJ() {
        return this.nQ;
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
            if (optJSONObject != null && optJSONObject.has("k")) {
                int optInt = optJSONObject.optInt("p");
                optJSONObject = optJSONObject.optJSONObject("k");
                try {
                    optJSONObject.put("p", optInt);
                } catch (JSONException e) {
                }
            }
            com.airbnb.lottie.model.a.c f = optJSONObject != null ? c.a.f(optJSONObject, eVar) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            com.airbnb.lottie.model.a.d g = optJSONObject2 != null ? d.a.g(optJSONObject2, eVar) : null;
            Path.FillType fillType = jSONObject.optInt("r", 1) == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
            GradientType gradientType = jSONObject.optInt(Info.kBaiduTimeKey, 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject(NotifyType.SOUND);
            com.airbnb.lottie.model.a.f i = optJSONObject3 != null ? f.a.i(optJSONObject3, eVar) : null;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            return new d(optString, gradientType, fillType, f, g, i, optJSONObject4 != null ? f.a.i(optJSONObject4, eVar) : null, null, null);
        }
    }
}
