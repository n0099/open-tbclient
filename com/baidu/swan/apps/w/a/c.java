package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public String callback;
    public boolean dfA;
    public boolean dfB;
    public boolean dfC;
    public String dfD;
    public String dfE;
    public com.baidu.swan.apps.w.a.a.c dfp;
    public double dfq;
    public List<com.baidu.swan.apps.w.a.a.d> dfr;
    public List<com.baidu.swan.apps.w.a.a.f> dfs;
    public List<com.baidu.swan.apps.w.a.a.a> dft;
    public List<com.baidu.swan.apps.w.a.a.b> dfu;
    public List<com.baidu.swan.apps.w.a.a.c> dfv;
    public List<com.baidu.swan.apps.w.a.a.e> dfw;
    public boolean dfx;
    public boolean dfy;
    public boolean dfz;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.dfq = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.dfp = new com.baidu.swan.apps.w.a.a.c();
                this.dfp.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.dfq = jSONObject.optDouble("scale", 16.0d);
            }
            this.dfD = jSONObject.optString("subkey", "");
            this.dfE = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.dfx = jSONObject.optBoolean("enableZoom", true);
            this.dfy = jSONObject.optBoolean("enableScroll", true);
            this.dfz = jSONObject.optBoolean("enableRotate", false);
            this.dfA = jSONObject.optBoolean("showCompass", false);
            this.dfB = jSONObject.optBoolean("enableOverlooking", false);
            this.dfC = jSONObject.optBoolean("enable3D", false);
            try {
                this.dfr = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.dft = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.dfs = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.dfu = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.dfv = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.dfw = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
