package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public String cYA;
    public com.baidu.swan.apps.w.a.a.c cYl;
    public double cYm;
    public List<com.baidu.swan.apps.w.a.a.d> cYn;
    public List<com.baidu.swan.apps.w.a.a.f> cYo;
    public List<com.baidu.swan.apps.w.a.a.a> cYp;
    public List<com.baidu.swan.apps.w.a.a.b> cYq;
    public List<com.baidu.swan.apps.w.a.a.c> cYr;
    public List<com.baidu.swan.apps.w.a.a.e> cYs;
    public boolean cYt;
    public boolean cYu;
    public boolean cYv;
    public boolean cYw;
    public boolean cYx;
    public boolean cYy;
    public String cYz;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.cYm = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.cYl = new com.baidu.swan.apps.w.a.a.c();
                this.cYl.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.cYm = jSONObject.optDouble("scale", 16.0d);
            }
            this.cYz = jSONObject.optString("subkey", "");
            this.cYA = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.cYt = jSONObject.optBoolean("enableZoom", true);
            this.cYu = jSONObject.optBoolean("enableScroll", true);
            this.cYv = jSONObject.optBoolean("enableRotate", false);
            this.cYw = jSONObject.optBoolean("showCompass", false);
            this.cYx = jSONObject.optBoolean("enableOverlooking", false);
            this.cYy = jSONObject.optBoolean("enable3D", false);
            try {
                this.cYn = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.cYp = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.cYo = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.cYq = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.cYr = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.cYs = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
