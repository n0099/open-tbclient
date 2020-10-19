package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public com.baidu.swan.apps.w.a.a.c cLG;
    public double cLH;
    public List<com.baidu.swan.apps.w.a.a.d> cLI;
    public List<com.baidu.swan.apps.w.a.a.f> cLJ;
    public List<com.baidu.swan.apps.w.a.a.a> cLK;
    public List<com.baidu.swan.apps.w.a.a.b> cLL;
    public List<com.baidu.swan.apps.w.a.a.c> cLM;
    public List<com.baidu.swan.apps.w.a.a.e> cLN;
    public boolean cLO;
    public boolean cLP;
    public boolean cLQ;
    public boolean cLR;
    public boolean cLS;
    public boolean cLT;
    public String cLU;
    public String cLV;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.cLH = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.cLG = new com.baidu.swan.apps.w.a.a.c();
                this.cLG.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.cLH = jSONObject.optDouble("scale", 16.0d);
            }
            this.cLU = jSONObject.optString("subkey", "");
            this.cLV = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.cLO = jSONObject.optBoolean("enableZoom", true);
            this.cLP = jSONObject.optBoolean("enableScroll", true);
            this.cLQ = jSONObject.optBoolean("enableRotate", false);
            this.cLR = jSONObject.optBoolean("showCompass", false);
            this.cLS = jSONObject.optBoolean("enableOverlooking", false);
            this.cLT = jSONObject.optBoolean("enable3D", false);
            try {
                this.cLI = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.cLK = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.cLJ = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.cLL = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.cLM = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.cLN = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
