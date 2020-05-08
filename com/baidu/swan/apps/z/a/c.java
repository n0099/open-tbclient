package com.baidu.swan.apps.z.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    public com.baidu.swan.apps.z.a.a.c bYj;
    public double bYk;
    public List<com.baidu.swan.apps.z.a.a.d> bYl;
    public List<com.baidu.swan.apps.z.a.a.f> bYm;
    public List<com.baidu.swan.apps.z.a.a.a> bYn;
    public List<com.baidu.swan.apps.z.a.a.b> bYo;
    public List<com.baidu.swan.apps.z.a.a.c> bYp;
    public List<com.baidu.swan.apps.z.a.a.e> bYq;
    public boolean bYr;
    public boolean bYs;
    public boolean bYt;
    public boolean bYu;
    public boolean bYv;
    public boolean bYw;
    public String bYx;
    public String bYy;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.bYk = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.bYj = new com.baidu.swan.apps.z.a.a.c();
                this.bYj.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.bYk = jSONObject.optDouble("scale", 16.0d);
            }
            this.bYx = jSONObject.optString("subkey", "");
            this.bYy = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.bYr = jSONObject.optBoolean("enableZoom", true);
            this.bYs = jSONObject.optBoolean("enableScroll", true);
            this.bYt = jSONObject.optBoolean("enableRotate", false);
            this.bYu = jSONObject.optBoolean("showCompass", false);
            this.bYv = jSONObject.optBoolean("enableOverlooking", false);
            this.bYw = jSONObject.optBoolean("enable3D", false);
            try {
                this.bYl = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.z.a.a.d.class);
                this.bYn = a(jSONObject, "circles", com.baidu.swan.apps.z.a.a.a.class);
                this.bYm = a(jSONObject, "polyline", com.baidu.swan.apps.z.a.a.f.class);
                this.bYo = a(jSONObject, "controls", com.baidu.swan.apps.z.a.a.b.class);
                this.bYp = a(jSONObject, "includePoints", com.baidu.swan.apps.z.a.a.c.class);
                this.bYq = a(jSONObject, "polygons", com.baidu.swan.apps.z.a.a.e.class);
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
