package com.baidu.swan.pms.e;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
    public static com.baidu.swan.pms.b.c.a bh(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.a aVar = new com.baidu.swan.pms.b.c.a();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            aVar.bLl = bl(optJSONObject.optJSONObject("main"));
            aVar.bLW = y(optJSONObject.optJSONArray("sub"));
        }
        aVar.bLX = bm(jSONObject.optJSONObject("framework"));
        aVar.bLZ = bn(jSONObject.optJSONObject("extension"));
        aVar.bLY = bp(jSONObject.optJSONObject("app_info"));
        return aVar;
    }

    public static com.baidu.swan.pms.b.c.c bi(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.c cVar = new com.baidu.swan.pms.b.c.c();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            cVar.bLW = y(optJSONObject.optJSONArray("sub"));
            return cVar;
        }
        return cVar;
    }

    public static com.baidu.swan.pms.b.c.d bj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.d dVar = new com.baidu.swan.pms.b.c.d();
        dVar.aOB = jSONObject.optLong("max_age");
        dVar.bLX = bm(jSONObject.optJSONObject("framework"));
        dVar.bLZ = bn(jSONObject.optJSONObject("extension"));
        return dVar;
    }

    public static com.baidu.swan.pms.b.c.b bk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.b bVar = new com.baidu.swan.pms.b.c.b();
        bVar.bMa = bo(jSONObject);
        return bVar;
    }

    private static com.baidu.swan.pms.model.f bl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) a(jSONObject, new com.baidu.swan.pms.model.f());
        fVar.bLk = jSONObject.optInt("pkg_type");
        return fVar;
    }

    private static List<h> y(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                h hVar = (h) a(optJSONObject, new h());
                hVar.pkgName = optJSONObject.optString("sub_path");
                hVar.bLn = optJSONObject.optBoolean("independent");
                arrayList.add(hVar);
            }
            return arrayList;
        }
        return null;
    }

    private static com.baidu.swan.pms.model.d bm(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.d) a(jSONObject, new com.baidu.swan.pms.model.d());
    }

    private static com.baidu.swan.pms.model.b bn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.b) a(jSONObject, new com.baidu.swan.pms.model.b());
    }

    private static i bo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (i) a(jSONObject, new i());
    }

    private static <T extends com.baidu.swan.pms.model.e> T a(JSONObject jSONObject, T t) {
        if (jSONObject == null || t == null) {
            return null;
        }
        t.bLj = jSONObject.optString("bundle_id");
        t.category = jSONObject.optInt("category");
        t.versionName = jSONObject.optString(SharedPrefConfig.VERSION_NAME);
        t.versionCode = jSONObject.optInt("version_code");
        t.size = jSONObject.optLong(TiebaInitialize.LogFields.SIZE);
        t.md5 = jSONObject.optString("md5");
        t.sign = jSONObject.optString("sign");
        t.downloadUrl = jSONObject.optString("download_url");
        return t;
    }

    private static PMSAppInfo bp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PMSAppInfo pMSAppInfo = new PMSAppInfo();
        pMSAppInfo.appKey = jSONObject.optString("app_key");
        pMSAppInfo.appName = jSONObject.optString("app_name");
        pMSAppInfo.description = jSONObject.optString("app_desc");
        pMSAppInfo.appStatus = jSONObject.optInt("app_status");
        pMSAppInfo.bKZ = jSONObject.optString("status_detail");
        pMSAppInfo.bLa = jSONObject.optString("status_desc");
        pMSAppInfo.aOo = jSONObject.optString("resume_date");
        pMSAppInfo.aOs = jSONObject.optString("subject_info");
        pMSAppInfo.aOB = jSONObject.optLong("max_age");
        pMSAppInfo.bLd = jSONObject.optInt("sub_category");
        pMSAppInfo.iconUrl = jSONObject.optString("icon_url");
        pMSAppInfo.aOr = jSONObject.optString("service_category");
        pMSAppInfo.bLe = jSONObject.optString("webview_domains");
        pMSAppInfo.bLf = jSONObject.optString("web_action");
        pMSAppInfo.bLg = jSONObject.optString("domains");
        pMSAppInfo.bLh = jSONObject.optString("ext");
        pMSAppInfo.bKY = jSONObject.optLong("app_sign");
        JSONObject optJSONObject = dP(pMSAppInfo.bLh).optJSONObject("bear_info");
        if (optJSONObject != null) {
            pMSAppInfo.aOt = optJSONObject.toString();
            return pMSAppInfo;
        }
        return pMSAppInfo;
    }

    public static JSONObject dP(String str) {
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
