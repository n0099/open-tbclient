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
    public com.baidu.swan.apps.x.a.a.c ayI;
    public double ayJ;
    public List<com.baidu.swan.apps.x.a.a.d> ayK;
    public List<com.baidu.swan.apps.x.a.a.f> ayL;
    public List<com.baidu.swan.apps.x.a.a.a> ayM;
    public List<com.baidu.swan.apps.x.a.a.b> ayN;
    public List<com.baidu.swan.apps.x.a.a.c> ayO;
    public List<com.baidu.swan.apps.x.a.a.e> ayP;
    public boolean ayQ;
    public boolean ayR;
    public boolean ayS;
    public boolean ayT;
    public boolean ayU;
    public boolean ayV;
    public boolean isShowLocation;

    public c() {
        super("mapId", "map");
        this.ayJ = 16.0d;
        this.isShowLocation = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.ayI = new com.baidu.swan.apps.x.a.a.c();
                this.ayI.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.ayJ = jSONObject.optDouble("scale", 16.0d);
            }
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.ayQ = jSONObject.optBoolean("enableZoom", true);
            this.ayR = jSONObject.optBoolean("enableScroll", true);
            this.ayS = jSONObject.optBoolean("enableRotate", false);
            this.ayT = jSONObject.optBoolean("showCompass", false);
            this.ayU = jSONObject.optBoolean("enableOverlooking", false);
            this.ayV = jSONObject.optBoolean("enable3D", false);
            try {
                this.ayK = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.ayM = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.ayL = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.ayN = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.ayO = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.ayP = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
