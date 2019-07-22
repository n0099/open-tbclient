package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements b {
    private final String name;
    private final GradientType oB;
    private final com.airbnb.lottie.model.a.c oD;
    private final com.airbnb.lottie.model.a.f oE;
    private final com.airbnb.lottie.model.a.f oF;
    private final com.airbnb.lottie.model.a.b oI;
    private final ShapeStroke.LineCapType oJ;
    private final ShapeStroke.LineJoinType oK;
    private final List<com.airbnb.lottie.model.a.b> oL;
    @Nullable
    private final com.airbnb.lottie.model.a.b oM;
    private final com.airbnb.lottie.model.a.d or;

    private e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.oB = gradientType;
        this.oD = cVar;
        this.or = dVar;
        this.oE = fVar;
        this.oF = fVar2;
        this.oI = bVar;
        this.oJ = lineCapType;
        this.oK = lineJoinType;
        this.oL = list;
        this.oM = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dd() {
        return this.oB;
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

    public com.airbnb.lottie.model.a.b di() {
        return this.oI;
    }

    public ShapeStroke.LineCapType dj() {
        return this.oJ;
    }

    public ShapeStroke.LineJoinType dk() {
        return this.oK;
    }

    public List<com.airbnb.lottie.model.a.b> dl() {
        return this.oL;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b dm() {
        return this.oM;
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
            JSONObject optJSONObject = jSONObject.optJSONObject("g");
            if (optJSONObject != null && optJSONObject.has(Config.APP_KEY)) {
                optJSONObject = optJSONObject.optJSONObject(Config.APP_KEY);
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
            com.airbnb.lottie.model.a.b e = b.a.e(jSONObject.optJSONObject(Config.DEVICE_WIDTH), eVar);
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
                    } else if (optString2.equals("d") || optString2.equals("g")) {
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
