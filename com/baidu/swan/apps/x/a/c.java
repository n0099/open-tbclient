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
    public com.baidu.swan.apps.x.a.a.c aAP;
    public double aAQ;
    public List<com.baidu.swan.apps.x.a.a.d> aAR;
    public List<com.baidu.swan.apps.x.a.a.f> aAS;
    public List<com.baidu.swan.apps.x.a.a.a> aAT;
    public List<com.baidu.swan.apps.x.a.a.b> aAU;
    public List<com.baidu.swan.apps.x.a.a.c> aAV;
    public List<com.baidu.swan.apps.x.a.a.e> aAW;
    public boolean aAX;
    public boolean aAY;
    public boolean aAZ;
    public boolean aBa;
    public boolean aBb;
    public boolean aBc;
    public boolean isShowLocation;

    public c() {
        super("mapId", "map");
        this.aAQ = 16.0d;
        this.isShowLocation = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.aAP = new com.baidu.swan.apps.x.a.a.c();
                this.aAP.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.aAQ = jSONObject.optDouble("scale", 16.0d);
            }
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.aAX = jSONObject.optBoolean("enableZoom", true);
            this.aAY = jSONObject.optBoolean("enableScroll", true);
            this.aAZ = jSONObject.optBoolean("enableRotate", false);
            this.aBa = jSONObject.optBoolean("showCompass", false);
            this.aBb = jSONObject.optBoolean("enableOverlooking", false);
            this.aBc = jSONObject.optBoolean("enable3D", false);
            try {
                this.aAR = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.aAT = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.aAS = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.aAU = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.aAV = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.aAW = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
