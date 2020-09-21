package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public String callback;
    public com.baidu.swan.apps.w.a.a.c czB;
    public double czC;
    public List<com.baidu.swan.apps.w.a.a.d> czD;
    public List<com.baidu.swan.apps.w.a.a.f> czE;
    public List<com.baidu.swan.apps.w.a.a.a> czF;
    public List<com.baidu.swan.apps.w.a.a.b> czG;
    public List<com.baidu.swan.apps.w.a.a.c> czH;
    public List<com.baidu.swan.apps.w.a.a.e> czI;
    public boolean czJ;
    public boolean czK;
    public boolean czL;
    public boolean czM;
    public boolean czN;
    public boolean czO;
    public String czP;
    public String czQ;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.czC = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.czB = new com.baidu.swan.apps.w.a.a.c();
                this.czB.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.czC = jSONObject.optDouble("scale", 16.0d);
            }
            this.czP = jSONObject.optString("subkey", "");
            this.czQ = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.czJ = jSONObject.optBoolean("enableZoom", true);
            this.czK = jSONObject.optBoolean("enableScroll", true);
            this.czL = jSONObject.optBoolean("enableRotate", false);
            this.czM = jSONObject.optBoolean("showCompass", false);
            this.czN = jSONObject.optBoolean("enableOverlooking", false);
            this.czO = jSONObject.optBoolean("enable3D", false);
            try {
                this.czD = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.czF = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.czE = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.czG = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.czH = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.czI = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private <T extends com.baidu.swan.apps.model.a> List<T> a(JSONObject jSONObject, String str, Class<T> cls) throws IllegalAccessException, InstantiationException, JSONException {
        if (!jSONObject.has(str)) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        if (length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                T newInstance = cls.newInstance();
                newInstance.parseFromJson(optJSONObject);
                if (newInstance.isValid()) {
                    arrayList.add(newInstance);
                }
            }
        }
        return arrayList;
    }
}
