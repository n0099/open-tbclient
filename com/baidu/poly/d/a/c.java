package com.baidu.poly.d.a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.d.a;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c implements d {
    protected a.C0131a aBW;

    @Override // com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0131a c0131a) {
        this.aBW = c0131a;
    }

    public Map<String, String> m(Map<String, String> map) {
        Map<String, String> zO = com.baidu.poly.util.c.zO();
        if (!TextUtils.isEmpty(map.get("payInfo"))) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
                zO.put("appid", jSONObject.optString("appid"));
                zO.put("partnerid", jSONObject.optString("partnerid"));
                zO.put("prepayid", jSONObject.optString("prepayid"));
                zO.put("packagealias", jSONObject.optString("packagealias"));
                zO.put("noncestr", jSONObject.optString("noncestr"));
                zO.put("timestamp", jSONObject.optString("timestamp"));
                zO.put("sign", jSONObject.optString("sign"));
                zO.put("orderInfo", jSONObject.optString("orderInfo"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return zO;
    }
}
