package com.baidu.poly.d.a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.poly.d.a;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c implements d {
    protected a.C0115a aiD;

    @Override // com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0115a c0115a) {
        this.aiD = c0115a;
    }

    public Map<String, String> l(Map<String, String> map) {
        Map<String, String> uE = com.baidu.poly.util.b.uE();
        if (!TextUtils.isEmpty(map.get("payInfo"))) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
                uE.put("appid", jSONObject.optString("appid"));
                uE.put("partnerid", jSONObject.optString("partnerid"));
                uE.put("prepayid", jSONObject.optString("prepayid"));
                uE.put("packagealias", jSONObject.optString("packagealias"));
                uE.put("noncestr", jSONObject.optString("noncestr"));
                uE.put(HttpConstants.TIMESTAMP, jSONObject.optString(HttpConstants.TIMESTAMP));
                uE.put("sign", jSONObject.optString("sign"));
                uE.put("orderInfo", jSONObject.optString("orderInfo"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return uE;
    }
}
