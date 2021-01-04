package com.baidu.swan.apps.w.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    public String callback;
    public com.baidu.swan.apps.w.a.a.c dke;
    public double dkf;
    public List<com.baidu.swan.apps.w.a.a.d> dkg;
    public List<com.baidu.swan.apps.w.a.a.f> dkh;
    public List<com.baidu.swan.apps.w.a.a.a> dki;
    public List<com.baidu.swan.apps.w.a.a.b> dkj;
    public List<com.baidu.swan.apps.w.a.a.c> dkk;
    public List<com.baidu.swan.apps.w.a.a.e> dkl;
    public boolean dkm;
    public boolean dkn;
    public boolean dko;
    public boolean dkp;
    public boolean dkq;
    public boolean dkr;
    public String dks;
    public String dkt;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.dkf = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.dke = new com.baidu.swan.apps.w.a.a.c();
                this.dke.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.dkf = jSONObject.optDouble("scale", 16.0d);
            }
            this.dks = jSONObject.optString("subkey", "");
            this.dkt = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.dkm = jSONObject.optBoolean("enableZoom", true);
            this.dkn = jSONObject.optBoolean("enableScroll", true);
            this.dko = jSONObject.optBoolean("enableRotate", false);
            this.dkp = jSONObject.optBoolean("showCompass", false);
            this.dkq = jSONObject.optBoolean("enableOverlooking", false);
            this.dkr = jSONObject.optBoolean("enable3D", false);
            try {
                this.dkg = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.w.a.a.d.class);
                this.dki = a(jSONObject, "circles", com.baidu.swan.apps.w.a.a.a.class);
                this.dkh = a(jSONObject, "polyline", com.baidu.swan.apps.w.a.a.f.class);
                this.dkj = a(jSONObject, "controls", com.baidu.swan.apps.w.a.a.b.class);
                this.dkk = a(jSONObject, "includePoints", com.baidu.swan.apps.w.a.a.c.class);
                this.dkl = a(jSONObject, "polygons", com.baidu.swan.apps.w.a.a.e.class);
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
