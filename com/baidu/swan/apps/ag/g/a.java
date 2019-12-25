package com.baidu.swan.apps.ag.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.l;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.model.h;
import com.tencent.open.SocialOperation;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static boolean a(String str, String str2, h hVar) {
        int length;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || hVar == null) {
            return false;
        }
        String str3 = hVar.domains;
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str3).optJSONArray(str);
            if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                return com.baidu.swan.apps.aj.a.b.g(new URI(str2).getHost(), arrayList);
            }
            return false;
        } catch (URISyntaxException | JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
            return false;
        }
    }

    public static String e(h hVar) {
        if (hVar == null) {
            return "";
        }
        String str = hVar.token;
        JSONObject jSONObject = new JSONObject();
        String uuid = UUID.randomUUID().toString();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            jSONObject.put("noncestr", uuid);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put(SocialOperation.GAME_SIGNATURE, c(uuid, currentTimeMillis, str));
        } catch (JSONException e) {
            com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
        }
        return jSONObject.toString();
    }

    private static String c(String str, long j, String str2) {
        String str3 = "";
        e ZS = e.ZS();
        if (ZS != null) {
            str3 = com.baidu.swan.apps.e.a.fQ(ZS.getAppKey());
        }
        String[] strArr = {str3, str, String.valueOf(j), str2};
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (String str4 : strArr) {
            sb.append(str4);
        }
        return l.encrypt("SHA-1", sb.toString().getBytes(), false);
    }
}
