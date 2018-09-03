package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.baidu.appsearchlib.Info;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements b {
    private final com.airbnb.lottie.model.a.d nE;
    private final GradientType nN;
    private final com.airbnb.lottie.model.a.c nP;
    private final com.airbnb.lottie.model.a.f nQ;
    private final com.airbnb.lottie.model.a.f nR;
    private final com.airbnb.lottie.model.a.b nU;
    private final ShapeStroke.LineCapType nV;
    private final ShapeStroke.LineJoinType nW;
    private final List<com.airbnb.lottie.model.a.b> nX;
    @Nullable
    private final com.airbnb.lottie.model.a.b nY;
    private final String name;

    private e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nN = gradientType;
        this.nP = cVar;
        this.nE = dVar;
        this.nQ = fVar;
        this.nR = fVar2;
        this.nU = bVar;
        this.nV = lineCapType;
        this.nW = lineJoinType;
        this.nX = list;
        this.nY = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cG() {
        return this.nN;
    }

    public com.airbnb.lottie.model.a.c cH() {
        return this.nP;
    }

    public com.airbnb.lottie.model.a.d cx() {
        return this.nE;
    }

    public com.airbnb.lottie.model.a.f cI() {
        return this.nQ;
    }

    public com.airbnb.lottie.model.a.f cJ() {
        return this.nR;
    }

    public com.airbnb.lottie.model.a.b cK() {
        return this.nU;
    }

    public ShapeStroke.LineCapType cL() {
        return this.nV;
    }

    public ShapeStroke.LineJoinType cM() {
        return this.nW;
    }

    public List<com.airbnb.lottie.model.a.b> cN() {
        return this.nX;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b cO() {
        return this.nY;
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
            if (optJSONObject != null && optJSONObject.has("k")) {
                optJSONObject = optJSONObject.optJSONObject("k");
            }
            com.airbnb.lottie.model.a.c cVar = null;
            if (optJSONObject != null) {
                cVar = c.a.f(optJSONObject, eVar);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("o");
            com.airbnb.lottie.model.a.d dVar = null;
            if (optJSONObject2 != null) {
                dVar = d.a.g(optJSONObject2, eVar);
            }
            GradientType gradientType = jSONObject.optInt(Info.kBaiduTimeKey, 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject3 = jSONObject.optJSONObject(NotifyType.SOUND);
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
            ShapeStroke.LineCapType lineCapType = ShapeStroke.LineCapType.values()[jSONObject.optInt(com.baidu.fsg.base.statistics.j.g) - 1];
            ShapeStroke.LineJoinType lineJoinType = ShapeStroke.LineJoinType.values()[jSONObject.optInt("lj") - 1];
            com.airbnb.lottie.model.a.b bVar = null;
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has("d")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("d");
                com.airbnb.lottie.model.a.b bVar2 = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject5.optString("n");
                    if (optString2.equals("o")) {
                        bVar2 = b.a.e(optJSONObject5.optJSONObject(NotifyType.VIBRATE), eVar);
                    } else if (optString2.equals("d") || optString2.equals("g")) {
                        arrayList.add(b.a.e(optJSONObject5.optJSONObject(NotifyType.VIBRATE), eVar));
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
