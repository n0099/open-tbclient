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
    public com.baidu.swan.apps.x.a.a.c ayL;
    public double ayM;
    public List<com.baidu.swan.apps.x.a.a.d> ayN;
    public List<com.baidu.swan.apps.x.a.a.f> ayO;
    public List<com.baidu.swan.apps.x.a.a.a> ayP;
    public List<com.baidu.swan.apps.x.a.a.b> ayQ;
    public List<com.baidu.swan.apps.x.a.a.c> ayR;
    public List<com.baidu.swan.apps.x.a.a.e> ayS;
    public boolean ayT;
    public boolean ayU;
    public boolean ayV;
    public boolean ayW;
    public boolean ayX;
    public boolean ayY;
    public boolean isShowLocation;

    public c() {
        super("mapId", "map");
        this.ayM = 16.0d;
        this.isShowLocation = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.ayL = new com.baidu.swan.apps.x.a.a.c();
                this.ayL.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.ayM = jSONObject.optDouble("scale", 16.0d);
            }
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.ayT = jSONObject.optBoolean("enableZoom", true);
            this.ayU = jSONObject.optBoolean("enableScroll", true);
            this.ayV = jSONObject.optBoolean("enableRotate", false);
            this.ayW = jSONObject.optBoolean("showCompass", false);
            this.ayX = jSONObject.optBoolean("enableOverlooking", false);
            this.ayY = jSONObject.optBoolean("enable3D", false);
            try {
                this.ayN = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.ayP = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.ayO = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.ayQ = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.ayR = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.ayS = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
