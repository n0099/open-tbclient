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
    private final com.airbnb.lottie.model.a.d nO;
    private final GradientType nX;
    private final com.airbnb.lottie.model.a.c nZ;
    private final String name;
    private final com.airbnb.lottie.model.a.f oa;
    private final com.airbnb.lottie.model.a.f ob;
    private final com.airbnb.lottie.model.a.b oe;
    private final ShapeStroke.LineCapType of;
    private final ShapeStroke.LineJoinType og;
    private final List<com.airbnb.lottie.model.a.b> oh;
    @Nullable
    private final com.airbnb.lottie.model.a.b oi;

    private e(String str, GradientType gradientType, com.airbnb.lottie.model.a.c cVar, com.airbnb.lottie.model.a.d dVar, com.airbnb.lottie.model.a.f fVar, com.airbnb.lottie.model.a.f fVar2, com.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, List<com.airbnb.lottie.model.a.b> list, @Nullable com.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nX = gradientType;
        this.nZ = cVar;
        this.nO = dVar;
        this.oa = fVar;
        this.ob = fVar2;
        this.oe = bVar;
        this.of = lineCapType;
        this.og = lineJoinType;
        this.oh = list;
        this.oi = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType cI() {
        return this.nX;
    }

    public com.airbnb.lottie.model.a.c cJ() {
        return this.nZ;
    }

    public com.airbnb.lottie.model.a.d cz() {
        return this.nO;
    }

    public com.airbnb.lottie.model.a.f cK() {
        return this.oa;
    }

    public com.airbnb.lottie.model.a.f cL() {
        return this.ob;
    }

    public com.airbnb.lottie.model.a.b cM() {
        return this.oe;
    }

    public ShapeStroke.LineCapType cN() {
        return this.of;
    }

    public ShapeStroke.LineJoinType cO() {
        return this.og;
    }

    public List<com.airbnb.lottie.model.a.b> cP() {
        return this.oh;
    }

    @Nullable
    public com.airbnb.lottie.model.a.b cQ() {
        return this.oi;
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
