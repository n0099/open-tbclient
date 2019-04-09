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
    public com.baidu.swan.apps.x.a.a.c ayM;
    public double ayN;
    public List<com.baidu.swan.apps.x.a.a.d> ayO;
    public List<com.baidu.swan.apps.x.a.a.f> ayP;
    public List<com.baidu.swan.apps.x.a.a.a> ayQ;
    public List<com.baidu.swan.apps.x.a.a.b> ayR;
    public List<com.baidu.swan.apps.x.a.a.c> ayS;
    public List<com.baidu.swan.apps.x.a.a.e> ayT;
    public boolean ayU;
    public boolean ayV;
    public boolean ayW;
    public boolean ayX;
    public boolean ayY;
    public boolean ayZ;
    public boolean isShowLocation;

    public c() {
        super("mapId", "map");
        this.ayN = 16.0d;
        this.isShowLocation = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.ayM = new com.baidu.swan.apps.x.a.a.c();
                this.ayM.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.ayN = jSONObject.optDouble("scale", 16.0d);
            }
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.ayU = jSONObject.optBoolean("enableZoom", true);
            this.ayV = jSONObject.optBoolean("enableScroll", true);
            this.ayW = jSONObject.optBoolean("enableRotate", false);
            this.ayX = jSONObject.optBoolean("showCompass", false);
            this.ayY = jSONObject.optBoolean("enableOverlooking", false);
            this.ayZ = jSONObject.optBoolean("enable3D", false);
            try {
                this.ayO = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.ayQ = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.ayP = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.ayR = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.ayS = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.ayT = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
