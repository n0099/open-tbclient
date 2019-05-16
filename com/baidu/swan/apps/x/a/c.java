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
    public com.baidu.swan.apps.x.a.a.c azK;
    public double azL;
    public List<com.baidu.swan.apps.x.a.a.d> azM;
    public List<com.baidu.swan.apps.x.a.a.f> azN;
    public List<com.baidu.swan.apps.x.a.a.a> azO;
    public List<com.baidu.swan.apps.x.a.a.b> azP;
    public List<com.baidu.swan.apps.x.a.a.c> azQ;
    public List<com.baidu.swan.apps.x.a.a.e> azR;
    public boolean azS;
    public boolean azT;
    public boolean azU;
    public boolean azV;
    public boolean azW;
    public boolean azX;
    public boolean isShowLocation;

    public c() {
        super("mapId", "map");
        this.azL = 16.0d;
        this.isShowLocation = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                this.azK = new com.baidu.swan.apps.x.a.a.c();
                this.azK.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.azL = jSONObject.optDouble("scale", 16.0d);
            }
            this.isShowLocation = jSONObject.optBoolean("showLocation", true);
            this.azS = jSONObject.optBoolean("enableZoom", true);
            this.azT = jSONObject.optBoolean("enableScroll", true);
            this.azU = jSONObject.optBoolean("enableRotate", false);
            this.azV = jSONObject.optBoolean("showCompass", false);
            this.azW = jSONObject.optBoolean("enableOverlooking", false);
            this.azX = jSONObject.optBoolean("enable3D", false);
            try {
                this.azM = a(jSONObject, jSONObject.has("markers") ? "markers" : "covers", com.baidu.swan.apps.x.a.a.d.class);
                this.azO = a(jSONObject, "circles", com.baidu.swan.apps.x.a.a.a.class);
                this.azN = a(jSONObject, "polyline", com.baidu.swan.apps.x.a.a.f.class);
                this.azP = a(jSONObject, "controls", com.baidu.swan.apps.x.a.a.b.class);
                this.azQ = a(jSONObject, "includePoints", com.baidu.swan.apps.x.a.a.c.class);
                this.azR = a(jSONObject, "polygons", com.baidu.swan.apps.x.a.a.e.class);
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
