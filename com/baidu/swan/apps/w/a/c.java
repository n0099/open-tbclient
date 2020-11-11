package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public com.baidu.swan.apps.w.a.a.c cZV;
    public double cZW;
    public List<com.baidu.swan.apps.w.a.a.d> cZX;
    public List<com.baidu.swan.apps.w.a.a.f> cZY;
    public List<com.baidu.swan.apps.w.a.a.a> cZZ;
    public String callback;
    public List<com.baidu.swan.apps.w.a.a.b> daa;
    public List<com.baidu.swan.apps.w.a.a.c> dab;
    public List<com.baidu.swan.apps.w.a.a.e> dac;
    public boolean dad;
    public boolean dae;
    public boolean daf;
    public boolean dag;
    public boolean dah;
    public boolean dai;
    public String daj;
    public String dak;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.cZW = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.cZV = new com.baidu.swan.apps.w.a.a.c();
                this.cZV.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.cZW = jSONObject.optDouble("scale", 16.0d);
            }
            this.daj = jSONObject.optString("subkey", "");
            this.dak = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.dad = jSONObject.optBoolean("enableZoom", true);
            this.dae = jSONObject.optBoolean("enableScroll", true);
            this.daf = jSONObject.optBoolean("enableRotate", false);
            this.dag = jSONObject.optBoolean("showCompass", false);
            this.dah = jSONObject.optBoolean("enableOverlooking", false);
            this.dai = jSONObject.optBoolean("enable3D", false);
            try {
                this.cZX = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.cZZ = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.cZY = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.daa = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.dab = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.dac = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
