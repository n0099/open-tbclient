package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public String callback;
    public com.baidu.swan.apps.w.a.a.c cxA;
    public double cxB;
    public List<com.baidu.swan.apps.w.a.a.d> cxC;
    public List<com.baidu.swan.apps.w.a.a.f> cxD;
    public List<com.baidu.swan.apps.w.a.a.a> cxE;
    public List<com.baidu.swan.apps.w.a.a.b> cxF;
    public List<com.baidu.swan.apps.w.a.a.c> cxG;
    public List<com.baidu.swan.apps.w.a.a.e> cxH;
    public boolean cxI;
    public boolean cxJ;
    public boolean cxK;
    public boolean cxL;
    public boolean cxM;
    public boolean cxN;
    public String cxO;
    public String cxP;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.cxB = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.cxA = new com.baidu.swan.apps.w.a.a.c();
                this.cxA.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.cxB = jSONObject.optDouble("scale", 16.0d);
            }
            this.cxO = jSONObject.optString("subkey", "");
            this.cxP = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.cxI = jSONObject.optBoolean("enableZoom", true);
            this.cxJ = jSONObject.optBoolean("enableScroll", true);
            this.cxK = jSONObject.optBoolean("enableRotate", false);
            this.cxL = jSONObject.optBoolean("showCompass", false);
            this.cxM = jSONObject.optBoolean("enableOverlooking", false);
            this.cxN = jSONObject.optBoolean("enable3D", false);
            try {
                this.cxC = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.cxE = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.cxD = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.cxF = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.cxG = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.cxH = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
