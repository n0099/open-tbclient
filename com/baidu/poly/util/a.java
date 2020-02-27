package com.baidu.poly.util;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public static String a(int i, String str, String str2) {
        String str3;
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str2)) {
            str3 = "statecode={" + i + "};order_no={" + str + "};notify=" + str2;
        } else {
            str3 = "statecode={" + i + "};order_no={" + str + "};notify={" + str2 + "}";
        }
        try {
            jSONObject.put("statusCode", i);
            jSONObject.put("statusMsg", str2);
            jSONObject.put("responseData", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
