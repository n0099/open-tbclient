package cn.com.chinatelecom.account.api.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class i {
    public static String a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            jSONObject.put("msg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
