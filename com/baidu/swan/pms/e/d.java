package com.baidu.swan.pms.e;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.h;
import com.baidu.swan.pms.model.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public static com.baidu.swan.pms.b.c.a aI(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.a aVar = new com.baidu.swan.pms.b.c.a();
        JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
        if (optJSONObject != null) {
            aVar.bse = aM(optJSONObject.optJSONObject("main"));
            aVar.bsO = q(optJSONObject.optJSONArray("sub"));
        }
        aVar.bsP = aN(jSONObject.optJSONObject("framework"));
        aVar.bsR = aO(jSONObject.optJSONObject("extension"));
        aVar.bsQ = aQ(jSONObject.optJSONObject("app_info"));
        return aVar;
    }

    public static com.baidu.swan.pms.b.c.c aJ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.c cVar = new com.baidu.swan.pms.b.c.c();
        JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
        if (optJSONObject != null) {
            cVar.bsO = q(optJSONObject.optJSONArray("sub"));
            return cVar;
        }
        return cVar;
    }

    public static com.baidu.swan.pms.b.c.d aK(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.d dVar = new com.baidu.swan.pms.b.c.d();
        dVar.auC = jSONObject.optLong("max_age");
        dVar.bsP = aN(jSONObject.optJSONObject("framework"));
        dVar.bsR = aO(jSONObject.optJSONObject("extension"));
        return dVar;
    }

    public static com.baidu.swan.pms.b.c.b aL(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.b bVar = new com.baidu.swan.pms.b.c.b();
        bVar.bsS = aP(jSONObject);
        return bVar;
    }

    private static com.baidu.swan.pms.model.f aM(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) a(jSONObject, new com.baidu.swan.pms.model.f());
        fVar.bsd = jSONObject.optInt("pkg_type");
        return fVar;
    }

    private static List<h> q(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                h hVar = (h) a(optJSONObject, new h());
                hVar.Hi = optJSONObject.optString("sub_path");
                hVar.bsg = optJSONObject.optBoolean("independent");
                arrayList.add(hVar);
            }
            return arrayList;
        }
        return null;
    }

    private static com.baidu.swan.pms.model.d aN(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.d) a(jSONObject, new com.baidu.swan.pms.model.d());
    }

    private static com.baidu.swan.pms.model.b aO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.b) a(jSONObject, new com.baidu.swan.pms.model.b());
    }

    private static i aP(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (i) a(jSONObject, new i());
    }

    private static <T extends com.baidu.swan.pms.model.e> T a(JSONObject jSONObject, T t) {
        if (jSONObject == null || t == null) {
            return null;
        }
        t.bsc = jSONObject.optString("bundle_id");
        t.category = jSONObject.optInt("category");
        t.versionName = jSONObject.optString("version_name");
        t.versionCode = jSONObject.optInt("version_code");
        t.size = jSONObject.optLong("size");
        t.md5 = jSONObject.optString("md5");
        t.sign = jSONObject.optString("sign");
        t.downloadUrl = jSONObject.optString("download_url");
        return t;
    }

    private static PMSAppInfo aQ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PMSAppInfo pMSAppInfo = new PMSAppInfo();
        pMSAppInfo.appKey = jSONObject.optString("app_key");
        pMSAppInfo.appName = jSONObject.optString("app_name");
        pMSAppInfo.description = jSONObject.optString("app_desc");
        pMSAppInfo.appStatus = jSONObject.optInt("app_status");
        pMSAppInfo.brT = jSONObject.optString("status_detail");
        pMSAppInfo.brU = jSONObject.optString("status_desc");
        pMSAppInfo.aup = jSONObject.optString("resume_date");
        pMSAppInfo.aut = jSONObject.optString("subject_info");
        pMSAppInfo.auC = jSONObject.optLong("max_age");
        pMSAppInfo.appCategory = jSONObject.optInt("sub_category");
        pMSAppInfo.iconUrl = jSONObject.optString("icon_url");
        pMSAppInfo.aus = jSONObject.optString("service_category");
        pMSAppInfo.brX = jSONObject.optString("webview_domains");
        pMSAppInfo.brY = jSONObject.optString("web_action");
        pMSAppInfo.brZ = jSONObject.optString("domains");
        pMSAppInfo.bsa = jSONObject.optString("ext");
        pMSAppInfo.brS = jSONObject.optLong("app_sign");
        JSONObject optJSONObject = cY(pMSAppInfo.bsa).optJSONObject("bear_info");
        if (optJSONObject != null) {
            pMSAppInfo.auu = optJSONObject.toString();
            return pMSAppInfo;
        }
        return pMSAppInfo;
    }

    public static JSONObject cY(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return new JSONObject();
        }
    }
}
