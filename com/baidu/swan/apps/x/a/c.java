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
    public boolean aAA;
    public boolean aAB;
    public boolean aAC;
    public boolean aAD;
    public boolean aAE;
    public com.baidu.swan.apps.x.a.a.c aAr;
    public double aAs;
    public List<com.baidu.swan.apps.x.a.a.d> aAt;
    public List<com.baidu.swan.apps.x.a.a.f> aAu;
    public List<com.baidu.swan.apps.x.a.a.a> aAv;
    public List<com.baidu.swan.apps.x.a.a.b> aAw;
    public List<com.baidu.swan.apps.x.a.a.c> aAx;
    public List<com.baidu.swan.apps.x.a.a.e> aAy;
    public boolean aAz;
    public boolean isShowLocation;

    public c() {
        super("mapId", "map");
        this.aAs = 16.0d;
        this.isShowLocation = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.aAr = new com.baidu.swan.apps.x.a.a.c();
                this.aAr.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.aAs = jSONObject.optDouble("scale", 16.0d);
            }
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.aAz = jSONObject.optBoolean("enableZoom", true);
            this.aAA = jSONObject.optBoolean("enableScroll", true);
            this.aAB = jSONObject.optBoolean("enableRotate", false);
            this.aAC = jSONObject.optBoolean("showCompass", false);
            this.aAD = jSONObject.optBoolean("enableOverlooking", false);
            this.aAE = jSONObject.optBoolean("enable3D", false);
            try {
                this.aAt = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.aAv = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.aAu = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.aAw = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.aAx = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.aAy = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
