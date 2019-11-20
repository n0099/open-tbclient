package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.b gC;
    private final ShapeStroke.LineCapType gD;
    private final ShapeStroke.LineJoinType gE;
    private final List<com.airbnb.lottie.model.a.b> gF;
    @Nullable
    private final com.airbnb.lottie.model.a.b gG;
    private final com.airbnb.lottie.model.a.d gm;
    private final GradientType gv;
    private final com.airbnb.lottie.model.a.c gx;
    private final com.airbnb.lottie.model.a.f gy;
    private final com.airbnb.lottie.model.a.f gz;
    private final String name;

    private e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.gv = gradientType;
        this.gx = cVar;
        this.gm = dVar;
        this.gy = fVar;
        this.gz = fVar2;
        this.gC = bVar;
        this.gD = lineCapType;
        this.gE = lineJoinType;
        this.gF = list;
        this.gG = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cw() {
        return this.gv;
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

    public com.airbnb.lottie.model.a.b cB() {
        return this.gC;
    }

    public ShapeStroke.LineCapType cC() {
        return this.gD;
    }

    public ShapeStroke.LineJoinType cD() {
        return this.gE;
    }

    public List<com.airbnb.lottie.model.a.b> cE() {
        return this.gF;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b cF() {
        return this.gG;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.h(fVar, aVar, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static e q(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            String optString = jSONObject.optString("nm");
            JSONObject optJSONObject = jSONObject.optJSONObject(IXAdRequestInfo.GPS);
            if (optJSONObject != null && optJSONObject.has("k")) {
                optJSONObject = optJSONObject.optJSONObject("k");
            }
            com.airbnb.lottie.model.a.c cVar = null;
            if (optJSONObject != null) {
                cVar = c.a.f(optJSONObject, eVar);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Config.OS);
            com.airbnb.lottie.model.a.d dVar = null;
            if (optJSONObject2 != null) {
                dVar = d.a.g(optJSONObject2, eVar);
            }
            GradientType gradientType = jSONObject.optInt("t", 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("s");
            com.airbnb.lottie.model.a.f fVar = null;
            if (optJSONObject3 != null) {
                fVar = f.a.i(optJSONObject3, eVar);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("e");
            com.airbnb.lottie.model.a.f fVar2 = null;
            if (optJSONObject4 != null) {
                fVar2 = f.a.i(optJSONObject4, eVar);
            }
            com.airbnb.lottie.model.a.b e = b.a.e(jSONObject.optJSONObject("w"), eVar);
            ShapeStroke.LineCapType lineCapType = ShapeStroke.LineCapType.values()[jSONObject.optInt("lc") - 1];
            ShapeStroke.LineJoinType lineJoinType = ShapeStroke.LineJoinType.values()[jSONObject.optInt("lj") - 1];
            com.airbnb.lottie.model.a.b bVar = null;
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has("d")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("d");
                com.airbnb.lottie.model.a.b bVar2 = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject5.optString("n");
                    if (optString2.equals(Config.OS)) {
                        bVar2 = b.a.e(optJSONObject5.optJSONObject("v"), eVar);
                    } else if (optString2.equals("d") || optString2.equals(IXAdRequestInfo.GPS)) {
                        arrayList.add(b.a.e(optJSONObject5.optJSONObject("v"), eVar));
                    }
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
                bVar = bVar2;
            }
            return new e(optString, gradientType, cVar, dVar, fVar, fVar2, e, lineCapType, lineJoinType, arrayList, bVar);
        }
    }
}
