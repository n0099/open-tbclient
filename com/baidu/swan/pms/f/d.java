package com.baidu.swan.pms.f;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.h;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    public static com.baidu.swan.pms.c.c.b bT(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.b bVar = new com.baidu.swan.pms.c.c.b();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            bVar.cxG = bY(optJSONObject.optJSONObject("main"));
            bVar.cxJ = F(optJSONObject.optJSONArray("sub"));
        }
        bVar.cxK = bZ(jSONObject.optJSONObject("framework"));
        bVar.cxM = ca(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
        bVar.cxL = cc(jSONObject.optJSONObject("app_info"));
        return bVar;
    }

    public static com.baidu.swan.pms.c.c.d bU(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.d dVar = new com.baidu.swan.pms.c.c.d();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            dVar.cxJ = F(optJSONObject.optJSONArray("sub"));
            return dVar;
        }
        return dVar;
    }

    public static com.baidu.swan.pms.c.c.e bV(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.e eVar = new com.baidu.swan.pms.c.c.e();
        eVar.maxAge = jSONObject.optLong("max_age");
        eVar.cxK = bZ(jSONObject.optJSONObject("framework"));
        eVar.cxM = ca(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
        return eVar;
    }

    public static com.baidu.swan.pms.c.c.a bW(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.a aVar = new com.baidu.swan.pms.c.c.a();
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a.C0352a c0352a = new a.C0352a();
                c0352a.errorCode = optJSONObject.optInt("errno");
                c0352a.cwO = optJSONObject.optString("bundle_id");
                c0352a.category = optJSONObject.optInt("category");
                c0352a.cxG = bY(optJSONObject.optJSONObject("main"));
                c0352a.cxH = cc(optJSONObject.optJSONObject("app_info"));
                arrayList.add(c0352a);
            }
        }
        aVar.cxF = arrayList;
        return aVar;
    }

    public static com.baidu.swan.pms.c.c.c bX(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.c cVar = new com.baidu.swan.pms.c.c.c();
        cVar.cxN = cb(jSONObject);
        return cVar;
    }

    private static com.baidu.swan.pms.model.f bY(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) a(jSONObject, new com.baidu.swan.pms.model.f());
        fVar.cwY = jSONObject.optInt("pkg_type");
        return fVar;
    }

    private static List<g> F(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                g gVar = (g) a(optJSONObject, new g());
                gVar.cwY = optJSONObject.optInt("pkg_type");
                gVar.pkgName = optJSONObject.optString("sub_path");
                gVar.independent = optJSONObject.optBoolean("independent");
                arrayList.add(gVar);
            }
            return arrayList;
        }
        return null;
    }

    public static com.baidu.swan.pms.model.d bZ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.d) a(jSONObject, new com.baidu.swan.pms.model.d());
    }

    public static com.baidu.swan.pms.model.b ca(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.b) a(jSONObject, new com.baidu.swan.pms.model.b());
    }

    private static h cb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        a(jSONObject, hVar);
        long optLong = jSONObject.optLong("max_age");
        hVar.maxAge = optLong >= 0 ? optLong : 0L;
        return hVar;
    }

    public static <T extends com.baidu.swan.pms.model.e> T a(JSONObject jSONObject, T t) {
        if (jSONObject == null || t == null) {
            return null;
        }
        t.cwO = jSONObject.optString("bundle_id");
        t.category = jSONObject.optInt("category");
        t.versionName = jSONObject.optString(SharedPrefConfig.VERSION_NAME);
        t.versionCode = jSONObject.optInt("version_code");
        t.size = jSONObject.optLong(TiebaInitialize.LogFields.SIZE);
        t.md5 = jSONObject.optString("md5");
        t.sign = jSONObject.optString("sign");
        t.downloadUrl = jSONObject.optString("download_url");
        return t;
    }

    public static PMSAppInfo cc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PMSAppInfo pMSAppInfo = new PMSAppInfo();
        pMSAppInfo.appKey = jSONObject.optString("app_key");
        pMSAppInfo.appName = jSONObject.optString("app_name");
        pMSAppInfo.description = jSONObject.optString("app_desc");
        pMSAppInfo.appStatus = jSONObject.optInt("app_status");
        pMSAppInfo.statusDetail = jSONObject.optString("status_detail");
        pMSAppInfo.statusDesc = jSONObject.optString("status_desc");
        pMSAppInfo.resumeDate = jSONObject.optString("resume_date");
        pMSAppInfo.subjectInfo = jSONObject.optString("subject_info");
        pMSAppInfo.maxAge = jSONObject.optLong("max_age");
        pMSAppInfo.appCategory = jSONObject.optInt("sub_category");
        pMSAppInfo.iconUrl = jSONObject.optString("icon_url");
        pMSAppInfo.serviceCategory = jSONObject.optString("service_category");
        pMSAppInfo.webViewDomains = jSONObject.optString("webview_domains");
        pMSAppInfo.webAction = jSONObject.optString("web_action");
        pMSAppInfo.domains = jSONObject.optString("domains");
        pMSAppInfo.serverExt = jSONObject.optString("ext");
        pMSAppInfo.appSign = jSONObject.optLong("app_sign");
        pMSAppInfo.payProtected = jSONObject.optInt("pay_protected", PMSConstants.PayProtected.NO_PAY_PROTECTED.type);
        pMSAppInfo.customerService = jSONObject.optInt("customer_service", PMSConstants.CustomerService.NO_CUSTOMER_SERVICE.type);
        pMSAppInfo.globalNotice = jSONObject.optInt("global_notice", PMSConstants.CloudSwitch.NO_DISPLAY.value);
        pMSAppInfo.globalPrivate = jSONObject.optInt("global_private", PMSConstants.CloudSwitch.NO_DISPLAY.value);
        pMSAppInfo.paNumber = jSONObject.optString("pa_number");
        JSONObject optJSONObject = parseString(pMSAppInfo.serverExt).optJSONObject("bear_info");
        if (optJSONObject != null) {
            pMSAppInfo.bearInfo = optJSONObject.toString();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("plugins");
        if (optJSONArray != null) {
            pMSAppInfo.pluginInfo = optJSONArray.toString();
            return pMSAppInfo;
        }
        return pMSAppInfo;
    }

    public static JSONObject parseString(String str) {
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
