package com.baidu.swan.apps.z.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    public List<com.baidu.swan.apps.z.a.a.f> bAa;
    public List<com.baidu.swan.apps.z.a.a.a> bAb;
    public List<com.baidu.swan.apps.z.a.a.b> bAc;
    public List<com.baidu.swan.apps.z.a.a.c> bAd;
    public List<com.baidu.swan.apps.z.a.a.e> bAe;
    public boolean bAf;
    public boolean bAg;
    public boolean bAh;
    public boolean bAi;
    public boolean bAj;
    public boolean bAk;
    public String bAl;
    public String bAm;
    public com.baidu.swan.apps.z.a.a.c bzX;
    public double bzY;
    public List<com.baidu.swan.apps.z.a.a.d> bzZ;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.bzY = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.bzX = new com.baidu.swan.apps.z.a.a.c();
                this.bzX.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.bzY = jSONObject.optDouble("scale", 16.0d);
            }
            this.bAl = jSONObject.optString("subkey", "");
            this.bAm = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.bAf = jSONObject.optBoolean("enableZoom", true);
            this.bAg = jSONObject.optBoolean("enableScroll", true);
            this.bAh = jSONObject.optBoolean("enableRotate", false);
            this.bAi = jSONObject.optBoolean("showCompass", false);
            this.bAj = jSONObject.optBoolean("enableOverlooking", false);
            this.bAk = jSONObject.optBoolean("enable3D", false);
            try {
                this.bzZ = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.z.a.a.d.class);
                this.bAb = a(jSONObject, "circles", com.baidu.swan.apps.z.a.a.a.class);
                this.bAa = a(jSONObject, "polyline", com.baidu.swan.apps.z.a.a.f.class);
                this.bAc = a(jSONObject, "controls", com.baidu.swan.apps.z.a.a.b.class);
                this.bAd = a(jSONObject, "includePoints", com.baidu.swan.apps.z.a.a.c.class);
                this.bAe = a(jSONObject, "polygons", com.baidu.swan.apps.z.a.a.e.class);
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
