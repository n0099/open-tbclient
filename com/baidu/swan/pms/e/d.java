package com.baidu.swan.pms.e;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
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
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            aVar.bsT = aM(optJSONObject.optJSONObject("main"));
            aVar.btE = q(optJSONObject.optJSONArray("sub"));
        }
        aVar.btF = aN(jSONObject.optJSONObject("framework"));
        aVar.btH = aO(jSONObject.optJSONObject("extension"));
        aVar.btG = aQ(jSONObject.optJSONObject("app_info"));
        return aVar;
    }

    public static com.baidu.swan.pms.b.c.c aJ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.c cVar = new com.baidu.swan.pms.b.c.c();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            cVar.btE = q(optJSONObject.optJSONArray("sub"));
            return cVar;
        }
        return cVar;
    }

    public static com.baidu.swan.pms.b.c.d aK(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.d dVar = new com.baidu.swan.pms.b.c.d();
        dVar.avg = jSONObject.optLong("max_age");
        dVar.btF = aN(jSONObject.optJSONObject("framework"));
        dVar.btH = aO(jSONObject.optJSONObject("extension"));
        return dVar;
    }

    public static com.baidu.swan.pms.b.c.b aL(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.b bVar = new com.baidu.swan.pms.b.c.b();
        bVar.btI = aP(jSONObject);
        return bVar;
    }

    private static com.baidu.swan.pms.model.f aM(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) a(jSONObject, new com.baidu.swan.pms.model.f());
        fVar.bsS = jSONObject.optInt("pkg_type");
        return fVar;
    }

    private static List<h> q(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                h hVar = (h) a(optJSONObject, new h());
                hVar.Ht = optJSONObject.optString("sub_path");
                hVar.bsV = optJSONObject.optBoolean("independent");
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
        t.bsR = jSONObject.optString("bundle_id");
        t.ave = jSONObject.optInt("category");
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
        pMSAppInfo.bsH = jSONObject.optString("status_detail");
        pMSAppInfo.bsI = jSONObject.optString("status_desc");
        pMSAppInfo.auS = jSONObject.optString("resume_date");
        pMSAppInfo.auW = jSONObject.optString("subject_info");
        pMSAppInfo.avg = jSONObject.optLong("max_age");
        pMSAppInfo.bsL = jSONObject.optInt("sub_category");
        pMSAppInfo.iconUrl = jSONObject.optString("icon_url");
        pMSAppInfo.auV = jSONObject.optString("service_category");
        pMSAppInfo.bsM = jSONObject.optString("webview_domains");
        pMSAppInfo.bsN = jSONObject.optString("web_action");
        pMSAppInfo.bsO = jSONObject.optString("domains");
        pMSAppInfo.bsP = jSONObject.optString("ext");
        pMSAppInfo.bsG = jSONObject.optLong("app_sign");
        JSONObject optJSONObject = dd(pMSAppInfo.bsP).optJSONObject("bear_info");
        if (optJSONObject != null) {
            pMSAppInfo.auX = optJSONObject.toString();
            return pMSAppInfo;
        }
        return pMSAppInfo;
    }

    public static JSONObject dd(String str) {
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
