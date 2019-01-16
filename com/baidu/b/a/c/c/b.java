package com.baidu.b.a.c.c;

import android.text.TextUtils;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static com.baidu.b.a.c.a.a m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("name", "");
        long optLong = jSONObject.optLong("version", 0L);
        String optString2 = jSONObject.optString(ETAG.KEY_PACKAGE_NAME, "");
        String optString3 = jSONObject.optString("package_size", "");
        String optString4 = jSONObject.optString(ARResourceKey.HTTP_AR_MD5, "");
        String optString5 = jSONObject.optString("host_min_version", "");
        String optString6 = jSONObject.optString("host_max_version", "");
        String optString7 = jSONObject.optString("download_url", "");
        long optLong2 = jSONObject.optLong("update_v", 0L);
        String optString8 = jSONObject.optString("ext", "");
        int optInt = jSONObject.optInt("wifi", 0);
        int optInt2 = jSONObject.optInt("rollback", 0);
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || optLong2 < 0) {
            return null;
        }
        com.baidu.b.a.c.a.a aVar = new com.baidu.b.a.c.a.a();
        aVar.name = optString;
        aVar.Zw = optLong;
        aVar.packageName = optString2;
        aVar.size = optString3;
        aVar.md5 = optString4;
        aVar.Zy = optString5;
        aVar.Zz = optString6;
        aVar.downloadUrl = optString7;
        aVar.Zx = optLong2;
        aVar.ZA = optString8;
        aVar.ZB = optInt;
        aVar.rollback = optInt2;
        return aVar;
    }

    public static List<com.baidu.b.a.c.a.a> f(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            com.baidu.b.a.c.a.a m = m(jSONArray.optJSONObject(i));
            if (m != null) {
                arrayList.add(m);
            }
        }
        return arrayList;
    }

    public static com.baidu.b.a.c.a.a n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(ETAG.KEY_PACKAGE_NAME, "");
        long optLong = jSONObject.optLong("update_v", 0L);
        int optInt = jSONObject.optInt("errno");
        String optString2 = jSONObject.optString("errmsg");
        String optString3 = jSONObject.optString("tipmsg");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        com.baidu.b.a.c.a.a aVar = new com.baidu.b.a.c.a.a();
        aVar.packageName = optString;
        aVar.Zx = optLong;
        aVar.KI = optInt;
        aVar.errMsg = optString2;
        aVar.Zv = optString3;
        return aVar;
    }

    public static List<com.baidu.b.a.c.a.a> g(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            com.baidu.b.a.c.a.a n = n(jSONArray.optJSONObject(i));
            if (n != null) {
                arrayList.add(n);
            }
        }
        return arrayList;
    }
}
