package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public String callback;
    public com.baidu.swan.apps.w.a.a.c dje;
    public double djf;
    public List<com.baidu.swan.apps.w.a.a.d> djg;
    public List<com.baidu.swan.apps.w.a.a.f> djh;
    public List<com.baidu.swan.apps.w.a.a.a> dji;
    public List<com.baidu.swan.apps.w.a.a.b> djj;
    public List<com.baidu.swan.apps.w.a.a.c> djk;
    public List<com.baidu.swan.apps.w.a.a.e> djl;
    public boolean djm;
    public boolean djn;
    public boolean djo;
    public boolean djp;
    public boolean djq;
    public boolean djr;
    public String djs;
    public String djt;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.djf = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.dje = new com.baidu.swan.apps.w.a.a.c();
                this.dje.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.djf = jSONObject.optDouble("scale", 16.0d);
            }
            this.djs = jSONObject.optString("subkey", "");
            this.djt = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.djm = jSONObject.optBoolean("enableZoom", true);
            this.djn = jSONObject.optBoolean("enableScroll", true);
            this.djo = jSONObject.optBoolean("enableRotate", false);
            this.djp = jSONObject.optBoolean("showCompass", false);
            this.djq = jSONObject.optBoolean("enableOverlooking", false);
            this.djr = jSONObject.optBoolean("enable3D", false);
            try {
                this.djg = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.dji = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.djh = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.djj = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.djk = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.djl = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
