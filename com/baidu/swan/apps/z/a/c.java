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
    public com.baidu.swan.apps.z.a.a.c bzL;
    public double bzM;
    public List<com.baidu.swan.apps.z.a.a.d> bzN;
    public List<com.baidu.swan.apps.z.a.a.f> bzO;
    public List<com.baidu.swan.apps.z.a.a.a> bzP;
    public List<com.baidu.swan.apps.z.a.a.b> bzQ;
    public List<com.baidu.swan.apps.z.a.a.c> bzR;
    public List<com.baidu.swan.apps.z.a.a.e> bzS;
    public boolean bzT;
    public boolean bzU;
    public boolean bzV;
    public boolean bzW;
    public boolean bzX;
    public boolean bzY;
    public String bzZ;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.bzM = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.bzL = new com.baidu.swan.apps.z.a.a.c();
                this.bzL.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.bzM = jSONObject.optDouble("scale", 16.0d);
            }
            this.bzZ = jSONObject.optString("subkey", "");
            this.bAa = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.bzT = jSONObject.optBoolean("enableZoom", true);
            this.bzU = jSONObject.optBoolean("enableScroll", true);
            this.bzV = jSONObject.optBoolean("enableRotate", false);
            this.bzW = jSONObject.optBoolean("showCompass", false);
            this.bzX = jSONObject.optBoolean("enableOverlooking", false);
            this.bzY = jSONObject.optBoolean("enable3D", false);
            try {
                this.bzN = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.z.a.a.d.class);
                this.bzP = a(jSONObject, "circles", com.baidu.swan.apps.z.a.a.a.class);
                this.bzO = a(jSONObject, "polyline", com.baidu.swan.apps.z.a.a.f.class);
                this.bzQ = a(jSONObject, "controls", com.baidu.swan.apps.z.a.a.b.class);
                this.bzR = a(jSONObject, "includePoints", com.baidu.swan.apps.z.a.a.c.class);
                this.bzS = a(jSONObject, "polygons", com.baidu.swan.apps.z.a.a.e.class);
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
