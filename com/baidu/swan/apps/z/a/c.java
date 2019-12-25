package com.baidu.swan.apps.z.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    public com.baidu.swan.apps.z.a.a.c buN;
    public double buO;
    public List<com.baidu.swan.apps.z.a.a.d> buP;
    public List<com.baidu.swan.apps.z.a.a.f> buQ;
    public List<com.baidu.swan.apps.z.a.a.a> buR;
    public List<com.baidu.swan.apps.z.a.a.b> buS;
    public List<com.baidu.swan.apps.z.a.a.c> buT;
    public List<com.baidu.swan.apps.z.a.a.e> buU;
    public boolean buV;
    public boolean buW;
    public boolean buX;
    public boolean buY;
    public boolean buZ;
    public boolean bva;
    public String bvb;
    public String bvc;
    public String callback;
    public boolean isShowLocation;

    public c() {
        super("map", "mapId");
        this.buO = 16.0d;
        this.isShowLocation = true;
        this.callback = "";
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.buN = new com.baidu.swan.apps.z.a.a.c();
                this.buN.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.buO = jSONObject.optDouble("scale", 16.0d);
            }
            this.bvb = jSONObject.optString("subkey", "");
            this.bvc = jSONObject.optString("layerStyle", "");
            this.callback = jSONObject.optString("cb");
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.buV = jSONObject.optBoolean("enableZoom", true);
            this.buW = jSONObject.optBoolean("enableScroll", true);
            this.buX = jSONObject.optBoolean("enableRotate", false);
            this.buY = jSONObject.optBoolean("showCompass", false);
            this.buZ = jSONObject.optBoolean("enableOverlooking", false);
            this.bva = jSONObject.optBoolean("enable3D", false);
            try {
                this.buP = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.z.a.a.d.class);
                this.buR = a(jSONObject, "circles", com.baidu.swan.apps.z.a.a.a.class);
                this.buQ = a(jSONObject, "polyline", com.baidu.swan.apps.z.a.a.f.class);
                this.buS = a(jSONObject, "controls", com.baidu.swan.apps.z.a.a.b.class);
                this.buT = a(jSONObject, "includePoints", com.baidu.swan.apps.z.a.a.c.class);
                this.buU = a(jSONObject, "polygons", com.baidu.swan.apps.z.a.a.e.class);
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
