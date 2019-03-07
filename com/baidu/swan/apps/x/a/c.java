package com.baidu.swan.apps.x.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    public com.baidu.swan.apps.x.a.a.c ayH;
    public double ayI;
    public List<com.baidu.swan.apps.x.a.a.d> ayJ;
    public List<com.baidu.swan.apps.x.a.a.f> ayK;
    public List<com.baidu.swan.apps.x.a.a.a> ayL;
    public List<com.baidu.swan.apps.x.a.a.b> ayM;
    public List<com.baidu.swan.apps.x.a.a.c> ayN;
    public List<com.baidu.swan.apps.x.a.a.e> ayO;
    public boolean ayP;
    public boolean ayQ;
    public boolean ayR;
    public boolean ayS;
    public boolean ayT;
    public boolean ayU;
    public boolean isShowLocation;

    public c() {
        super("mapId", "map");
        this.ayI = 16.0d;
        this.isShowLocation = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.ayH = new com.baidu.swan.apps.x.a.a.c();
                this.ayH.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.ayI = jSONObject.optDouble("scale", 16.0d);
            }
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.ayP = jSONObject.optBoolean("enableZoom", true);
            this.ayQ = jSONObject.optBoolean("enableScroll", true);
            this.ayR = jSONObject.optBoolean("enableRotate", false);
            this.ayS = jSONObject.optBoolean("showCompass", false);
            this.ayT = jSONObject.optBoolean("enableOverlooking", false);
            this.ayU = jSONObject.optBoolean("enable3D", false);
            try {
                this.ayJ = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.ayL = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.ayK = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.ayM = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.ayN = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.ayO = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
