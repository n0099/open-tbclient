package com.baidu.live.personmanager;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public static String B(int i, String str) {
        String str2;
        String str3;
        String str4 = null;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (i == 0) {
                    str3 = jSONObject.optString("user_list");
                    str2 = new JSONObject(jSONObject.optString("page")).optString("has_more");
                } else if (i == 1) {
                    str3 = jSONObject.optString("follow_list").trim();
                    if ("".equals(str3)) {
                        str3 = "[]";
                    }
                    str2 = jSONObject.optString("has_more");
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (jSONObject.optInt("error_code") == 0) {
                    str4 = "{\"has_more\":\"" + str2 + "\", \"user_list\":" + str3 + "}";
                    return str4;
                }
                return null;
            } catch (JSONException e) {
                BdLog.detailException(e);
                return str4;
            }
        }
        return null;
    }

    public static String bg(long j) {
        return j / 10000 > 0 ? i(Math.floor(j / 1000.0d) / 10.0d) + "w" : String.valueOf(j);
    }

    public static String i(double d) {
        String valueOf = String.valueOf(d);
        int indexOf = valueOf.indexOf(".");
        String substring = valueOf.substring(indexOf + 1, valueOf.length());
        if (substring.length() == 1) {
            if (Integer.parseInt(substring) == 0) {
                return valueOf.substring(0, indexOf);
            }
            return valueOf;
        } else if ("00".equals(substring)) {
            return valueOf.substring(0, indexOf);
        } else {
            return valueOf;
        }
    }
}
