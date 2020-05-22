package com.baidu.swan.pms.f;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.h;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public static com.baidu.swan.pms.c.c.b ck(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.b bVar = new com.baidu.swan.pms.c.c.b();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            bVar.dmt = cp(optJSONObject.optJSONObject("main"));
            bVar.dmw = G(optJSONObject.optJSONArray("sub"));
        }
        bVar.dmx = cq(jSONObject.optJSONObject("framework"));
        bVar.dmz = cr(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
        bVar.dmy = ct(jSONObject.optJSONObject("app_info"));
        return bVar;
    }

    public static com.baidu.swan.pms.c.c.d cl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.d dVar = new com.baidu.swan.pms.c.c.d();
        JSONObject optJSONObject = jSONObject.optJSONObject(Config.INPUT_DEF_PKG);
        if (optJSONObject != null) {
            dVar.dmw = G(optJSONObject.optJSONArray("sub"));
            return dVar;
        }
        return dVar;
    }

    public static com.baidu.swan.pms.c.c.e cm(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.e eVar = new com.baidu.swan.pms.c.c.e();
        eVar.maxAge = jSONObject.optLong("max_age");
        eVar.data = jSONObject;
        return eVar;
    }

    public static com.baidu.swan.pms.c.c.a cn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.a aVar = new com.baidu.swan.pms.c.c.a();
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a.C0456a c0456a = new a.C0456a();
                c0456a.errorCode = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
                c0456a.dlx = optJSONObject.optString("bundle_id");
                c0456a.category = optJSONObject.optInt("category");
                c0456a.dmt = cp(optJSONObject.optJSONObject("main"));
                c0456a.dmu = ct(optJSONObject.optJSONObject("app_info"));
                arrayList.add(c0456a);
            }
        }
        aVar.dms = arrayList;
        return aVar;
    }

    public static com.baidu.swan.pms.c.c.c co(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.c.c.c cVar = new com.baidu.swan.pms.c.c.c();
        cVar.dmA = cs(jSONObject);
        return cVar;
    }

    private static com.baidu.swan.pms.model.f cp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) a(jSONObject, new com.baidu.swan.pms.model.f());
        fVar.dlH = jSONObject.optInt("pkg_type");
        return fVar;
    }

    private static List<g> G(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                g gVar = (g) a(optJSONObject, new g());
                gVar.dlH = optJSONObject.optInt("pkg_type");
                gVar.pkgName = optJSONObject.optString("sub_path");
                gVar.dlI = optJSONObject.optBoolean("independent");
                arrayList.add(gVar);
            }
            return arrayList;
        }
        return null;
    }

    public static com.baidu.swan.pms.model.d cq(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.d) a(jSONObject, new com.baidu.swan.pms.model.d());
    }

    public static com.baidu.swan.pms.model.b cr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.b) a(jSONObject, new com.baidu.swan.pms.model.b());
    }

    private static h cs(JSONObject jSONObject) {
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
        t.dlx = jSONObject.optString("bundle_id");
        t.category = jSONObject.optInt("category");
        t.versionName = jSONObject.optString(SharedPrefConfig.VERSION_NAME);
        t.versionCode = jSONObject.optInt("version_code");
        t.size = jSONObject.optLong(TiebaInitialize.LogFields.SIZE);
        t.md5 = jSONObject.optString("md5");
        t.sign = jSONObject.optString("sign");
        t.downloadUrl = jSONObject.optString("download_url");
        return t;
    }

    public static PMSAppInfo ct(JSONObject jSONObject) {
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
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PHONE_BRAND);
        if (optJSONObject2 != null) {
            pMSAppInfo.brandsInfo = optJSONObject2.toString();
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
