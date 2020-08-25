package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public String callback;
    public List<com.baidu.swan.apps.w.a.a.a> cxA;
    public List<com.baidu.swan.apps.w.a.a.b> cxB;
    public List<com.baidu.swan.apps.w.a.a.c> cxC;
    public List<com.baidu.swan.apps.w.a.a.e> cxD;
    public boolean cxE;
    public boolean cxF;
    public boolean cxG;
    public boolean cxH;
    public boolean cxI;
    public boolean cxJ;
    public String cxK;
    public String cxL;
    public com.baidu.swan.apps.w.a.a.c cxw;
    public double cxx;
    public List<com.baidu.swan.apps.w.a.a.d> cxy;
    public List<com.baidu.swan.apps.w.a.a.f> cxz;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.cxx = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.cxw = new com.baidu.swan.apps.w.a.a.c();
                this.cxw.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.cxx = jSONObject.optDouble("scale", 16.0d);
            }
            this.cxK = jSONObject.optString("subkey", "");
            this.cxL = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.cxE = jSONObject.optBoolean("enableZoom", true);
            this.cxF = jSONObject.optBoolean("enableScroll", true);
            this.cxG = jSONObject.optBoolean("enableRotate", false);
            this.cxH = jSONObject.optBoolean("showCompass", false);
            this.cxI = jSONObject.optBoolean("enableOverlooking", false);
            this.cxJ = jSONObject.optBoolean("enable3D", false);
            try {
                this.cxy = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.cxA = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.cxz = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.cxB = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.cxC = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.cxD = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
