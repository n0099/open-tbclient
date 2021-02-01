package com.baidu.swan.pms.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.h;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static com.baidu.swan.pms.c.c.b cW(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.b bVar = new com.baidu.swan.pms.c.c.b();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            bVar.euT = db(optJSONObject.optJSONObject("main"));
            bVar.euU = J(optJSONObject.optJSONArray("sub"));
        }
        bVar.euX = dc(jSONObject.optJSONObject("framework"));
        bVar.euZ = dd(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
        bVar.euY = df(jSONObject.optJSONObject("app_info"));
        return bVar;
    }

    public static com.baidu.swan.pms.c.c.d cX(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.d dVar = new com.baidu.swan.pms.c.c.d();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            dVar.euU = J(optJSONObject.optJSONArray("sub"));
            return dVar;
        }
        return dVar;
    }

    public static com.baidu.swan.pms.c.c.e cY(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.e eVar = new com.baidu.swan.pms.c.c.e();
        eVar.maxAge = jSONObject.optLong("max_age");
        eVar.data = jSONObject;
        return eVar;
    }

    public static com.baidu.swan.pms.c.c.a cZ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.a aVar = new com.baidu.swan.pms.c.c.a();
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a.C0539a c0539a = new a.C0539a();
                c0539a.errorCode = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
                c0539a.euc = optJSONObject.optString("bundle_id");
                c0539a.category = optJSONObject.optInt("category");
                c0539a.euT = db(optJSONObject.optJSONObject("main"));
                c0539a.euU = J(optJSONObject.optJSONArray("sub"));
                c0539a.euV = df(optJSONObject.optJSONObject("app_info"));
                arrayList.add(c0539a);
            }
        }
        aVar.euS = arrayList;
        return aVar;
    }

    public static com.baidu.swan.pms.c.c.c da(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.c cVar = new com.baidu.swan.pms.c.c.c();
        cVar.eva = de(jSONObject);
        return cVar;
    }

    private static com.baidu.swan.pms.model.f db(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) a(jSONObject, new com.baidu.swan.pms.model.f());
        fVar.eug = jSONObject.optInt("pkg_type");
        return fVar;
    }

    private static List<com.baidu.swan.pms.model.g> J(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                com.baidu.swan.pms.model.g gVar = (com.baidu.swan.pms.model.g) a(optJSONObject, new com.baidu.swan.pms.model.g());
                gVar.eug = optJSONObject.optInt("pkg_type");
                gVar.pkgName = optJSONObject.optString("sub_path");
                gVar.euh = optJSONObject.optBoolean("independent");
                arrayList.add(gVar);
            }
            return arrayList;
        }
        return null;
    }

    public static com.baidu.swan.pms.model.d dc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.d) a(jSONObject, new com.baidu.swan.pms.model.d());
    }

    public static com.baidu.swan.pms.model.b dd(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.b) a(jSONObject, new com.baidu.swan.pms.model.b());
    }

    private static h de(JSONObject jSONObject) {
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
        t.euc = jSONObject.optString("bundle_id");
        t.category = jSONObject.optInt("category");
        t.versionName = jSONObject.optString(SharedPrefConfig.VERSION_NAME);
        t.versionCode = jSONObject.optLong("version_code");
        t.size = jSONObject.optLong(TiebaInitialize.LogFields.SIZE);
        t.md5 = jSONObject.optString("md5");
        t.sign = jSONObject.optString("sign");
        t.downloadUrl = jSONObject.optString("download_url");
        return t;
    }

    public static PMSAppInfo df(JSONObject jSONObject) {
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
        String optString = parseString(pMSAppInfo.serverExt).optString("quick_app_key");
        if (!TextUtils.isEmpty(optString)) {
            pMSAppInfo.quickAppKey = optString;
        }
        JSONObject optJSONObject = parseString(pMSAppInfo.serverExt).optJSONObject("bear_info");
        if (optJSONObject != null) {
            pMSAppInfo.bearInfo = optJSONObject.toString();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("plugins");
        if (optJSONArray != null) {
            pMSAppInfo.pluginInfo = optJSONArray.toString();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PHONE_BRAND);
        if (optJSONObject2 != null) {
            pMSAppInfo.brandsInfo = optJSONObject2.toString();
        }
        com.baidu.swan.pms.d.bcp().b(jSONObject.optJSONArray("ban_path"), jSONObject.optString("ban_tips"), pMSAppInfo.appKey);
        com.baidu.swan.pms.d.bcp().a(pMSAppInfo, jSONObject.optJSONObject("scope_list"), jSONObject.optInt("service_degrade", 0) != 0);
        pMSAppInfo.webUrl = jSONObject.optString("web_url");
        pMSAppInfo.csProtocolVersion = PMSConstants.b.getVersion();
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

    public static boolean dg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return 1 == jSONObject.optInt("reset_env", 0);
    }
}
