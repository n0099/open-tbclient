package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    public String callback;
    public com.baidu.swan.apps.w.a.a.c cpG;
    public double cpH;
    public List<com.baidu.swan.apps.w.a.a.d> cpI;
    public List<com.baidu.swan.apps.w.a.a.f> cpJ;
    public List<com.baidu.swan.apps.w.a.a.a> cpK;
    public List<com.baidu.swan.apps.w.a.a.b> cpL;
    public List<com.baidu.swan.apps.w.a.a.c> cpM;
    public List<com.baidu.swan.apps.w.a.a.e> cpN;
    public boolean cpO;
    public boolean cpP;
    public boolean cpQ;
    public boolean cpR;
    public boolean cpS;
    public boolean cpT;
    public String cpU;
    public String cpV;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.cpH = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.cpG = new com.baidu.swan.apps.w.a.a.c();
                this.cpG.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.cpH = jSONObject.optDouble("scale", 16.0d);
            }
            this.cpU = jSONObject.optString("subkey", "");
            this.cpV = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.cpO = jSONObject.optBoolean("enableZoom", true);
            this.cpP = jSONObject.optBoolean("enableScroll", true);
            this.cpQ = jSONObject.optBoolean("enableRotate", false);
            this.cpR = jSONObject.optBoolean("showCompass", false);
            this.cpS = jSONObject.optBoolean("enableOverlooking", false);
            this.cpT = jSONObject.optBoolean("enable3D", false);
            try {
                this.cpI = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.cpK = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.cpJ = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.cpL = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.cpM = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.cpN = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
