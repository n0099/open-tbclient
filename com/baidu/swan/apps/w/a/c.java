package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public String callback;
    public com.baidu.swan.apps.w.a.a.c dhA;
    public double dhB;
    public List<com.baidu.swan.apps.w.a.a.d> dhC;
    public List<com.baidu.swan.apps.w.a.a.f> dhD;
    public List<com.baidu.swan.apps.w.a.a.a> dhE;
    public List<com.baidu.swan.apps.w.a.a.b> dhF;
    public List<com.baidu.swan.apps.w.a.a.c> dhG;
    public List<com.baidu.swan.apps.w.a.a.e> dhH;
    public boolean dhI;
    public boolean dhJ;
    public boolean dhK;
    public boolean dhL;
    public boolean dhM;
    public boolean dhN;
    public String dhO;
    public String dhP;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.dhB = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.dhA = new com.baidu.swan.apps.w.a.a.c();
                this.dhA.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.dhB = jSONObject.optDouble("scale", 16.0d);
            }
            this.dhO = jSONObject.optString("subkey", "");
            this.dhP = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.dhI = jSONObject.optBoolean("enableZoom", true);
            this.dhJ = jSONObject.optBoolean("enableScroll", true);
            this.dhK = jSONObject.optBoolean("enableRotate", false);
            this.dhL = jSONObject.optBoolean("showCompass", false);
            this.dhM = jSONObject.optBoolean("enableOverlooking", false);
            this.dhN = jSONObject.optBoolean("enable3D", false);
            try {
                this.dhC = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.dhE = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.dhD = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.dhF = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.dhG = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.dhH = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
