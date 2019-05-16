package com.baidu.poly.d.a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.d.a;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c implements d {
    protected a.C0085a ahB;

    @Override // com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0085a c0085a) {
        this.ahB = c0085a;
    }

    public Map<String, String> l(Map<String, String> map) {
        Map<String, String> uq = com.baidu.poly.util.c.uq();
        if (!TextUtils.isEmpty(map.get("payInfo"))) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
                uq.put("appid", jSONObject.optString("appid"));
                uq.put("partnerid", jSONObject.optString("partnerid"));
                uq.put("prepayid", jSONObject.optString("prepayid"));
                uq.put("packagealias", jSONObject.optString("packagealias"));
                uq.put("noncestr", jSONObject.optString("noncestr"));
                uq.put("timestamp", jSONObject.optString("timestamp"));
                uq.put("sign", jSONObject.optString("sign"));
                uq.put("orderInfo", jSONObject.optString("orderInfo"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return uq;
    }
}
