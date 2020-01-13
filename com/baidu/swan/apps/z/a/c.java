package com.baidu.swan.apps.z.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    public com.baidu.swan.apps.z.a.a.c bvB;
    public double bvC;
    public List<com.baidu.swan.apps.z.a.a.d> bvD;
    public List<com.baidu.swan.apps.z.a.a.f> bvE;
    public List<com.baidu.swan.apps.z.a.a.a> bvF;
    public List<com.baidu.swan.apps.z.a.a.b> bvG;
    public List<com.baidu.swan.apps.z.a.a.c> bvH;
    public List<com.baidu.swan.apps.z.a.a.e> bvI;
    public boolean bvJ;
    public boolean bvK;
    public boolean bvL;
    public boolean bvM;
    public boolean bvN;
    public boolean bvO;
    public String bvP;
    public String bvQ;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.bvC = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.bvB = new com.baidu.swan.apps.z.a.a.c();
                this.bvB.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.bvC = jSONObject.optDouble("scale", 16.0d);
            }
            this.bvP = jSONObject.optString("subkey", "");
            this.bvQ = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.bvJ = jSONObject.optBoolean("enableZoom", true);
            this.bvK = jSONObject.optBoolean("enableScroll", true);
            this.bvL = jSONObject.optBoolean("enableRotate", false);
            this.bvM = jSONObject.optBoolean("showCompass", false);
            this.bvN = jSONObject.optBoolean("enableOverlooking", false);
            this.bvO = jSONObject.optBoolean("enable3D", false);
            try {
                this.bvD = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.z.a.a.d.class);
                this.bvF = a(jSONObject, "circles", com.baidu.swan.apps.z.a.a.a.class);
                this.bvE = a(jSONObject, "polyline", com.baidu.swan.apps.z.a.a.f.class);
                this.bvG = a(jSONObject, "controls", com.baidu.swan.apps.z.a.a.b.class);
                this.bvH = a(jSONObject, "includePoints", com.baidu.swan.apps.z.a.a.c.class);
                this.bvI = a(jSONObject, "polygons", com.baidu.swan.apps.z.a.a.e.class);
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
