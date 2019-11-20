package com.baidu.swan.apps.x.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    public com.baidu.swan.apps.x.a.a.c aTL;
    public double aTM;
    public List<com.baidu.swan.apps.x.a.a.d> aTN;
    public List<com.baidu.swan.apps.x.a.a.f> aTO;
    public List<com.baidu.swan.apps.x.a.a.a> aTP;
    public List<com.baidu.swan.apps.x.a.a.b> aTQ;
    public List<com.baidu.swan.apps.x.a.a.c> aTR;
    public List<com.baidu.swan.apps.x.a.a.e> aTS;
    public boolean aTT;
    public boolean aTU;
    public boolean aTV;
    public boolean aTW;
    public boolean aTX;
    public boolean aTY;
    public boolean isShowLocation;

    public c() {
        super("mapId", "map");
        this.aTM = 16.0d;
        this.isShowLocation = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.aTL = new com.baidu.swan.apps.x.a.a.c();
                this.aTL.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.aTM = jSONObject.optDouble("scale", 16.0d);
            }
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.aTT = jSONObject.optBoolean("enableZoom", true);
            this.aTU = jSONObject.optBoolean("enableScroll", true);
            this.aTV = jSONObject.optBoolean("enableRotate", false);
            this.aTW = jSONObject.optBoolean("showCompass", false);
            this.aTX = jSONObject.optBoolean("enableOverlooking", false);
            this.aTY = jSONObject.optBoolean("enable3D", false);
            try {
                this.aTN = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.aTP = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.aTO = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.aTQ = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.aTR = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.aTS = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
