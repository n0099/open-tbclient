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
    public com.baidu.swan.apps.z.a.a.c bzK;
    public double bzL;
    public List<com.baidu.swan.apps.z.a.a.d> bzM;
    public List<com.baidu.swan.apps.z.a.a.f> bzN;
    public List<com.baidu.swan.apps.z.a.a.a> bzO;
    public List<com.baidu.swan.apps.z.a.a.b> bzP;
    public List<com.baidu.swan.apps.z.a.a.c> bzQ;
    public List<com.baidu.swan.apps.z.a.a.e> bzR;
    public boolean bzS;
    public boolean bzT;
    public boolean bzU;
    public boolean bzV;
    public boolean bzW;
    public boolean bzX;
    public String bzY;
    public String bzZ;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.bzL = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.bzK = new com.baidu.swan.apps.z.a.a.c();
                this.bzK.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.bzL = jSONObject.optDouble("scale", 16.0d);
            }
            this.bzY = jSONObject.optString("subkey", "");
            this.bzZ = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.bzS = jSONObject.optBoolean("enableZoom", true);
            this.bzT = jSONObject.optBoolean("enableScroll", true);
            this.bzU = jSONObject.optBoolean("enableRotate", false);
            this.bzV = jSONObject.optBoolean("showCompass", false);
            this.bzW = jSONObject.optBoolean("enableOverlooking", false);
            this.bzX = jSONObject.optBoolean("enable3D", false);
            try {
                this.bzM = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.z.a.a.d.class);
                this.bzO = a(jSONObject, "circles", com.baidu.swan.apps.z.a.a.a.class);
                this.bzN = a(jSONObject, "polyline", com.baidu.swan.apps.z.a.a.f.class);
                this.bzP = a(jSONObject, "controls", com.baidu.swan.apps.z.a.a.b.class);
                this.bzQ = a(jSONObject, "includePoints", com.baidu.swan.apps.z.a.a.c.class);
                this.bzR = a(jSONObject, "polygons", com.baidu.swan.apps.z.a.a.e.class);
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
