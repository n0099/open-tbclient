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
    protected a.C0115a aiu;

    @Override // com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0115a c0115a) {
        this.aiu = c0115a;
    }

    public Map<String, String> l(Map<String, String> map) {
        Map<String, String> uA = com.baidu.poly.util.b.uA();
        if (!TextUtils.isEmpty(map.get("payInfo"))) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
                uA.put("appid", jSONObject.optString("appid"));
                uA.put("partnerid", jSONObject.optString("partnerid"));
                uA.put("prepayid", jSONObject.optString("prepayid"));
                uA.put("packagealias", jSONObject.optString("packagealias"));
                uA.put("noncestr", jSONObject.optString("noncestr"));
                uA.put(HttpConstants.TIMESTAMP, jSONObject.optString(HttpConstants.TIMESTAMP));
                uA.put("sign", jSONObject.optString("sign"));
                uA.put("orderInfo", jSONObject.optString("orderInfo"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return uA;
    }
}
