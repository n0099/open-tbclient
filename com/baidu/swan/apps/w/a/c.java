package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public com.baidu.swan.apps.w.a.a.c cUc;
    public double cUd;
    public List<com.baidu.swan.apps.w.a.a.d> cUe;
    public List<com.baidu.swan.apps.w.a.a.f> cUf;
    public List<com.baidu.swan.apps.w.a.a.a> cUg;
    public List<com.baidu.swan.apps.w.a.a.b> cUh;
    public List<com.baidu.swan.apps.w.a.a.c> cUi;
    public List<com.baidu.swan.apps.w.a.a.e> cUj;
    public boolean cUk;
    public boolean cUl;
    public boolean cUm;
    public boolean cUn;
    public boolean cUo;
    public boolean cUp;
    public String cUq;
    public String cUr;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.cUd = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.cUc = new com.baidu.swan.apps.w.a.a.c();
                this.cUc.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.cUd = jSONObject.optDouble("scale", 16.0d);
            }
            this.cUq = jSONObject.optString("subkey", "");
            this.cUr = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.cUk = jSONObject.optBoolean("enableZoom", true);
            this.cUl = jSONObject.optBoolean("enableScroll", true);
            this.cUm = jSONObject.optBoolean("enableRotate", false);
            this.cUn = jSONObject.optBoolean("showCompass", false);
            this.cUo = jSONObject.optBoolean("enableOverlooking", false);
            this.cUp = jSONObject.optBoolean("enable3D", false);
            try {
                this.cUe = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.cUg = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.cUf = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.cUh = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.cUi = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.cUj = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
