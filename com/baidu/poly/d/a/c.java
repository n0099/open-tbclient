package com.baidu.poly.d.a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.d.a;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c implements d {
    protected a.C0131a aBE;

    @Override // com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0131a c0131a) {
        this.aBE = c0131a;
    }

    public Map<String, String> m(Map<String, String> map) {
        Map<String, String> zP = com.baidu.poly.util.c.zP();
        if (!TextUtils.isEmpty(map.get("payInfo"))) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
                zP.put("appid", jSONObject.optString("appid"));
                zP.put("partnerid", jSONObject.optString("partnerid"));
                zP.put("prepayid", jSONObject.optString("prepayid"));
                zP.put("packagealias", jSONObject.optString("packagealias"));
                zP.put("noncestr", jSONObject.optString("noncestr"));
                zP.put("timestamp", jSONObject.optString("timestamp"));
                zP.put("sign", jSONObject.optString("sign"));
                zP.put("orderInfo", jSONObject.optString("orderInfo"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return zP;
    }
}
