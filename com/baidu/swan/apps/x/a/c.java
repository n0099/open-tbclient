package com.baidu.swan.apps.x.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    public String callback;
    public com.baidu.swan.apps.x.a.a.c cnA;
    public double cnB;
    public List<com.baidu.swan.apps.x.a.a.d> cnC;
    public List<com.baidu.swan.apps.x.a.a.f> cnD;
    public List<com.baidu.swan.apps.x.a.a.a> cnE;
    public List<com.baidu.swan.apps.x.a.a.b> cnF;
    public List<com.baidu.swan.apps.x.a.a.c> cnG;
    public List<com.baidu.swan.apps.x.a.a.e> cnH;
    public boolean cnI;
    public boolean cnJ;
    public boolean cnK;
    public boolean cnL;
    public boolean cnM;
    public boolean cnN;
    public String cnO;
    public String cnP;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.cnB = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.cnA = new com.baidu.swan.apps.x.a.a.c();
                this.cnA.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.cnB = jSONObject.optDouble("scale", 16.0d);
            }
            this.cnO = jSONObject.optString("subkey", "");
            this.cnP = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.cnI = jSONObject.optBoolean("enableZoom", true);
            this.cnJ = jSONObject.optBoolean("enableScroll", true);
            this.cnK = jSONObject.optBoolean("enableRotate", false);
            this.cnL = jSONObject.optBoolean("showCompass", false);
            this.cnM = jSONObject.optBoolean("enableOverlooking", false);
            this.cnN = jSONObject.optBoolean("enable3D", false);
            try {
                this.cnC = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.cnE = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.cnD = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.cnF = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.cnG = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.cnH = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
