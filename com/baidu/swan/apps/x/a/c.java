package com.baidu.swan.apps.x.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    public com.baidu.swan.apps.x.a.a.c aUd;
    public double aUe;
    public List<com.baidu.swan.apps.x.a.a.d> aUf;
    public List<com.baidu.swan.apps.x.a.a.f> aUg;
    public List<com.baidu.swan.apps.x.a.a.a> aUh;
    public List<com.baidu.swan.apps.x.a.a.b> aUi;
    public List<com.baidu.swan.apps.x.a.a.c> aUj;
    public List<com.baidu.swan.apps.x.a.a.e> aUk;
    public boolean aUl;
    public boolean aUm;
    public boolean aUn;
    public boolean aUo;
    public boolean aUp;
    public boolean aUq;
    public boolean isShowLocation;

    public c() {
        super("mapId", "map");
        this.aUe = 16.0d;
        this.isShowLocation = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.aUd = new com.baidu.swan.apps.x.a.a.c();
                this.aUd.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.aUe = jSONObject.optDouble("scale", 16.0d);
            }
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.aUl = jSONObject.optBoolean("enableZoom", true);
            this.aUm = jSONObject.optBoolean("enableScroll", true);
            this.aUn = jSONObject.optBoolean("enableRotate", false);
            this.aUo = jSONObject.optBoolean("showCompass", false);
            this.aUp = jSONObject.optBoolean("enableOverlooking", false);
            this.aUq = jSONObject.optBoolean("enable3D", false);
            try {
                this.aUf = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.aUh = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.aUg = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.aUi = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.aUj = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.aUk = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
