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
    public String bAa;
    public String bAb;
    public com.baidu.swan.apps.z.a.a.c bzM;
    public double bzN;
    public List<com.baidu.swan.apps.z.a.a.d> bzO;
    public List<com.baidu.swan.apps.z.a.a.f> bzP;
    public List<com.baidu.swan.apps.z.a.a.a> bzQ;
    public List<com.baidu.swan.apps.z.a.a.b> bzR;
    public List<com.baidu.swan.apps.z.a.a.c> bzS;
    public List<com.baidu.swan.apps.z.a.a.e> bzT;
    public boolean bzU;
    public boolean bzV;
    public boolean bzW;
    public boolean bzX;
    public boolean bzY;
    public boolean bzZ;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.bzN = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.bzM = new com.baidu.swan.apps.z.a.a.c();
                this.bzM.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.bzN = jSONObject.optDouble("scale", 16.0d);
            }
            this.bAa = jSONObject.optString("subkey", "");
            this.bAb = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.bzU = jSONObject.optBoolean("enableZoom", true);
            this.bzV = jSONObject.optBoolean("enableScroll", true);
            this.bzW = jSONObject.optBoolean("enableRotate", false);
            this.bzX = jSONObject.optBoolean("showCompass", false);
            this.bzY = jSONObject.optBoolean("enableOverlooking", false);
            this.bzZ = jSONObject.optBoolean("enable3D", false);
            try {
                this.bzO = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.z.a.a.d.class);
                this.bzQ = a(jSONObject, "circles", com.baidu.swan.apps.z.a.a.a.class);
                this.bzP = a(jSONObject, "polyline", com.baidu.swan.apps.z.a.a.f.class);
                this.bzR = a(jSONObject, "controls", com.baidu.swan.apps.z.a.a.b.class);
                this.bzS = a(jSONObject, "includePoints", com.baidu.swan.apps.z.a.a.c.class);
                this.bzT = a(jSONObject, "polygons", com.baidu.swan.apps.z.a.a.e.class);
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
