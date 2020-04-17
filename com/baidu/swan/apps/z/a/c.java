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
    public com.baidu.swan.apps.z.a.a.c bYd;
    public double bYe;
    public List<com.baidu.swan.apps.z.a.a.d> bYf;
    public List<com.baidu.swan.apps.z.a.a.f> bYg;
    public List<com.baidu.swan.apps.z.a.a.a> bYh;
    public List<com.baidu.swan.apps.z.a.a.b> bYi;
    public List<com.baidu.swan.apps.z.a.a.c> bYj;
    public List<com.baidu.swan.apps.z.a.a.e> bYk;
    public boolean bYl;
    public boolean bYm;
    public boolean bYn;
    public boolean bYo;
    public boolean bYp;
    public boolean bYq;
    public String bYr;
    public String bYs;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.bYe = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.bYd = new com.baidu.swan.apps.z.a.a.c();
                this.bYd.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.bYe = jSONObject.optDouble("scale", 16.0d);
            }
            this.bYr = jSONObject.optString("subkey", "");
            this.bYs = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.bYl = jSONObject.optBoolean("enableZoom", true);
            this.bYm = jSONObject.optBoolean("enableScroll", true);
            this.bYn = jSONObject.optBoolean("enableRotate", false);
            this.bYo = jSONObject.optBoolean("showCompass", false);
            this.bYp = jSONObject.optBoolean("enableOverlooking", false);
            this.bYq = jSONObject.optBoolean("enable3D", false);
            try {
                this.bYf = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.z.a.a.d.class);
                this.bYh = a(jSONObject, "circles", com.baidu.swan.apps.z.a.a.a.class);
                this.bYg = a(jSONObject, "polyline", com.baidu.swan.apps.z.a.a.f.class);
                this.bYi = a(jSONObject, "controls", com.baidu.swan.apps.z.a.a.b.class);
                this.bYj = a(jSONObject, "includePoints", com.baidu.swan.apps.z.a.a.c.class);
                this.bYk = a(jSONObject, "polygons", com.baidu.swan.apps.z.a.a.e.class);
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
