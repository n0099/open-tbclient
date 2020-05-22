package com.baidu.swan.apps.x.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    public String callback;
    public com.baidu.swan.apps.x.a.a.c ciL;
    public double ciM;
    public List<com.baidu.swan.apps.x.a.a.d> ciN;
    public List<com.baidu.swan.apps.x.a.a.f> ciO;
    public List<com.baidu.swan.apps.x.a.a.a> ciP;
    public List<com.baidu.swan.apps.x.a.a.b> ciQ;
    public List<com.baidu.swan.apps.x.a.a.c> ciR;
    public List<com.baidu.swan.apps.x.a.a.e> ciS;
    public boolean ciT;
    public boolean ciU;
    public boolean ciV;
    public boolean ciW;
    public boolean ciX;
    public boolean ciY;
    public String ciZ;
    public String cja;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.ciM = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.ciL = new com.baidu.swan.apps.x.a.a.c();
                this.ciL.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.ciM = jSONObject.optDouble("scale", 16.0d);
            }
            this.ciZ = jSONObject.optString("subkey", "");
            this.cja = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.ciT = jSONObject.optBoolean("enableZoom", true);
            this.ciU = jSONObject.optBoolean("enableScroll", true);
            this.ciV = jSONObject.optBoolean("enableRotate", false);
            this.ciW = jSONObject.optBoolean("showCompass", false);
            this.ciX = jSONObject.optBoolean("enableOverlooking", false);
            this.ciY = jSONObject.optBoolean("enable3D", false);
            try {
                this.ciN = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.ciP = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.ciO = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.ciQ = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.ciR = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.ciS = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
