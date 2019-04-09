package com.baidu.swan.pms.d;

import android.text.TextUtils;
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
            bVar.bmc = aB(optJSONObject.optJSONObject("main"));
            bVar.bmR = s(optJSONObject.optJSONArray("sub"));
        }
        bVar.bmP = aC(jSONObject.optJSONObject("framework"));
        bVar.bmQ = aD(jSONObject.optJSONObject("extension"));
        bVar.bmS = aE(jSONObject.optJSONObject("app_info"));
        return bVar;
    }

    public static com.baidu.swan.pms.b.c.c az(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.c cVar = new com.baidu.swan.pms.b.c.c();
        JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
        if (optJSONObject != null) {
            cVar.bmR = s(optJSONObject.optJSONArray("sub"));
            return cVar;
        }
        return cVar;
    }

    public static com.baidu.swan.pms.b.c.a aA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.pms.b.c.a aVar = new com.baidu.swan.pms.b.c.a();
        aVar.aum = jSONObject.optLong("max_age");
        aVar.bmP = aC(jSONObject.optJSONObject("framework"));
        aVar.bmQ = aD(jSONObject.optJSONObject("extension"));
        return aVar;
    }

    public static g aB(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = (g) a(jSONObject, new g());
        gVar.bmb = jSONObject.optInt("pkg_type");
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
                iVar.bme = optJSONObject.optBoolean("independent");
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
        t.bma = jSONObject.optString("bundle_id");
        t.category = jSONObject.optInt("category");
        t.versionName = jSONObject.optString("version_name");
        t.versionCode = jSONObject.optInt("version_code");
        t.size = jSONObject.optLong("size");
        t.md5 = jSONObject.optString("md5");
        t.sign = jSONObject.optString("sign");
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
        aVar.blR = jSONObject.optString("status_detail");
        aVar.blS = jSONObject.optString("status_desc");
        aVar.atZ = jSONObject.optString("resume_date");
        aVar.aud = jSONObject.optString("subject_info");
        aVar.aum = jSONObject.optLong("max_age");
        aVar.appCategory = jSONObject.optInt("sub_category");
        aVar.iconUrl = jSONObject.optString("icon_url");
        aVar.auc = jSONObject.optString("service_category");
        aVar.blV = jSONObject.optString("webview_domains");
        aVar.blW = jSONObject.optString("web_action");
        aVar.blX = jSONObject.optString("domains");
        aVar.blY = jSONObject.optString("ext");
        aVar.blQ = jSONObject.optLong("app_sign");
        JSONObject optJSONObject = dm(aVar.blY).optJSONObject("bear_info");
        if (optJSONObject != null) {
            aVar.aue = optJSONObject.toString();
            return aVar;
        }
        return aVar;
    }

    public static JSONObject dm(String str) {
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
