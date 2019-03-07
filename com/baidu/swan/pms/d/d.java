package com.baidu.swan.pms.d;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public static com.baidu.swan.pms.b.c.b ay(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.b bVar = new com.baidu.swan.pms.b.c.b();
        JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
        if (optJSONObject != null) {
            bVar.blX = aB(optJSONObject.optJSONObject("main"));
            bVar.bmM = s(optJSONObject.optJSONArray("sub"));
        }
        bVar.bmK = aC(jSONObject.optJSONObject("framework"));
        bVar.bmL = aD(jSONObject.optJSONObject("extension"));
        bVar.bmN = aE(jSONObject.optJSONObject("app_info"));
        return bVar;
    }

    public static com.baidu.swan.pms.b.c.c az(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.c cVar = new com.baidu.swan.pms.b.c.c();
        JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
        if (optJSONObject != null) {
            cVar.bmM = s(optJSONObject.optJSONArray("sub"));
            return cVar;
        }
        return cVar;
    }

    public static com.baidu.swan.pms.b.c.a aA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.a aVar = new com.baidu.swan.pms.b.c.a();
        aVar.aug = jSONObject.optLong("max_age");
        aVar.bmK = aC(jSONObject.optJSONObject("framework"));
        aVar.bmL = aD(jSONObject.optJSONObject("extension"));
        return aVar;
    }

    public static g aB(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = (g) a(jSONObject, new g());
        gVar.blW = jSONObject.optInt("pkg_type");
        return gVar;
    }

    public static List<i> s(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                i iVar = (i) a(optJSONObject, new i());
                iVar.Jz = optJSONObject.optString("sub_path");
                iVar.blZ = optJSONObject.optBoolean("independent");
                arrayList.add(iVar);
            }
            return arrayList;
        }
        return null;
    }

    public static com.baidu.swan.pms.model.e aC(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.e) a(jSONObject, new com.baidu.swan.pms.model.e());
    }

    public static com.baidu.swan.pms.model.c aD(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (com.baidu.swan.pms.model.c) a(jSONObject, new com.baidu.swan.pms.model.c());
    }

    public static <T extends com.baidu.swan.pms.model.f> T a(JSONObject jSONObject, T t) {
        if (jSONObject == null || t == null) {
            return null;
        }
        t.blV = jSONObject.optString("bundle_id");
        t.category = jSONObject.optInt("category");
        t.versionName = jSONObject.optString("version_name");
        t.versionCode = jSONObject.optInt("version_code");
        t.size = jSONObject.optLong("size");
        t.md5 = jSONObject.optString("md5");
        t.sign = jSONObject.optString(SapiUtils.KEY_QR_LOGIN_SIGN);
        t.downloadUrl = jSONObject.optString("download_url");
        return t;
    }

    public static com.baidu.swan.pms.model.a aE(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a();
        aVar.appKey = jSONObject.optString("app_key");
        aVar.appName = jSONObject.optString("app_name");
        aVar.description = jSONObject.optString("app_desc");
        aVar.appStatus = jSONObject.optInt("app_status");
        aVar.blM = jSONObject.optString("status_detail");
        aVar.blN = jSONObject.optString("status_desc");
        aVar.atT = jSONObject.optString("resume_date");
        aVar.atX = jSONObject.optString("subject_info");
        aVar.aug = jSONObject.optLong("max_age");
        aVar.appCategory = jSONObject.optInt("sub_category");
        aVar.iconUrl = jSONObject.optString("icon_url");
        aVar.atW = jSONObject.optString("service_category");
        aVar.blQ = jSONObject.optString("webview_domains");
        aVar.blR = jSONObject.optString("web_action");
        aVar.blS = jSONObject.optString("domains");
        aVar.blT = jSONObject.optString("ext");
        aVar.blL = jSONObject.optLong("app_sign");
        JSONObject optJSONObject = dk(aVar.blT).optJSONObject("bear_info");
        if (optJSONObject != null) {
            aVar.atY = optJSONObject.toString();
            return aVar;
        }
        return aVar;
    }

    public static JSONObject dk(String str) {
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
