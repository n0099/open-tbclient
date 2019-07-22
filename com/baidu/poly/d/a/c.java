package com.baidu.poly.d.a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.d.a;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c implements d {
    protected a.C0085a aic;

    @Override // com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0085a c0085a) {
        this.aic = c0085a;
    }

    public Map<String, String> l(Map<String, String> map) {
        Map<String, String> uQ = com.baidu.poly.util.c.uQ();
        if (!TextUtils.isEmpty(map.get("payInfo"))) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
                uQ.put("appid", jSONObject.optString("appid"));
                uQ.put("partnerid", jSONObject.optString("partnerid"));
                uQ.put("prepayid", jSONObject.optString("prepayid"));
                uQ.put("packagealias", jSONObject.optString("packagealias"));
                uQ.put("noncestr", jSONObject.optString("noncestr"));
                uQ.put("timestamp", jSONObject.optString("timestamp"));
                uQ.put("sign", jSONObject.optString("sign"));
                uQ.put("orderInfo", jSONObject.optString("orderInfo"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return uQ;
    }
}
