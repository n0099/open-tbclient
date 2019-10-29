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
    public static com.baidu.swan.pms.b.c.a bg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.a aVar = new com.baidu.swan.pms.b.c.a();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            aVar.bMc = bk(optJSONObject.optJSONObject("main"));
            aVar.bMN = y(optJSONObject.optJSONArray("sub"));
        }
        aVar.bMO = bl(jSONObject.optJSONObject("framework"));
        aVar.bMQ = bm(jSONObject.optJSONObject("extension"));
        aVar.bMP = bo(jSONObject.optJSONObject("app_info"));
        return aVar;
    }

    public static com.baidu.swan.pms.b.c.c bh(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.c cVar = new com.baidu.swan.pms.b.c.c();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            cVar.bMN = y(optJSONObject.optJSONArray("sub"));
            return cVar;
        }
        return cVar;
    }

    public static com.baidu.swan.pms.b.c.d bi(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.d dVar = new com.baidu.swan.pms.b.c.d();
        dVar.aOT = jSONObject.optLong("max_age");
        dVar.bMO = bl(jSONObject.optJSONObject("framework"));
        dVar.bMQ = bm(jSONObject.optJSONObject("extension"));
        return dVar;
    }

    public static com.baidu.swan.pms.b.c.b bj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.b bVar = new com.baidu.swan.pms.b.c.b();
        bVar.bMR = bn(jSONObject);
        return bVar;
    }

    private static com.baidu.swan.pms.model.f bk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) a(jSONObject, new com.baidu.swan.pms.model.f());
        fVar.bMb = jSONObject.optInt("pkg_type");
        return fVar;
    }

    private static List<h> y(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                h hVar = (h) a(optJSONObject, new h());
                hVar.ud = optJSONObject.optString("sub_path");
                hVar.bMe = optJSONObject.optBoolean("independent");
                arrayList.add(hVar);
            }
            return arrayList;
        }
        return null;
    }

    private static com.baidu.swan.pms.model.d bl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.d) a(jSONObject, new com.baidu.swan.pms.model.d());
    }

    private static com.baidu.swan.pms.model.b bm(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.b) a(jSONObject, new com.baidu.swan.pms.model.b());
    }

    private static i bn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (i) a(jSONObject, new i());
    }

    private static <T extends com.baidu.swan.pms.model.e> T a(JSONObject jSONObject, T t) {
        if (jSONObject == null || t == null) {
            return null;
        }
        t.bMa = jSONObject.optString("bundle_id");
        t.category = jSONObject.optInt("category");
        t.versionName = jSONObject.optString(SharedPrefConfig.VERSION_NAME);
        t.versionCode = jSONObject.optInt("version_code");
        t.size = jSONObject.optLong(TiebaInitialize.LogFields.SIZE);
        t.md5 = jSONObject.optString("md5");
        t.sign = jSONObject.optString("sign");
        t.downloadUrl = jSONObject.optString("download_url");
        return t;
    }

    private static PMSAppInfo bo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PMSAppInfo pMSAppInfo = new PMSAppInfo();
        pMSAppInfo.appKey = jSONObject.optString("app_key");
        pMSAppInfo.appName = jSONObject.optString("app_name");
        pMSAppInfo.description = jSONObject.optString("app_desc");
        pMSAppInfo.appStatus = jSONObject.optInt("app_status");
        pMSAppInfo.bLQ = jSONObject.optString("status_detail");
        pMSAppInfo.bLR = jSONObject.optString("status_desc");
        pMSAppInfo.aOG = jSONObject.optString("resume_date");
        pMSAppInfo.aOK = jSONObject.optString("subject_info");
        pMSAppInfo.aOT = jSONObject.optLong("max_age");
        pMSAppInfo.bLU = jSONObject.optInt("sub_category");
        pMSAppInfo.iconUrl = jSONObject.optString("icon_url");
        pMSAppInfo.aOJ = jSONObject.optString("service_category");
        pMSAppInfo.bLV = jSONObject.optString("webview_domains");
        pMSAppInfo.bLW = jSONObject.optString("web_action");
        pMSAppInfo.bLX = jSONObject.optString("domains");
        pMSAppInfo.bLY = jSONObject.optString("ext");
        pMSAppInfo.bLP = jSONObject.optLong("app_sign");
        JSONObject optJSONObject = dP(pMSAppInfo.bLY).optJSONObject("bear_info");
        if (optJSONObject != null) {
            pMSAppInfo.aOL = optJSONObject.toString();
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
