package com.baidu.poly.d.a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.poly.d.a;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c implements d {
    protected a.C0099a aiz;

    @Override // com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0099a c0099a) {
        this.aiz = c0099a;
    }

    public Map<String, String> l(Map<String, String> map) {
        Map<String, String> uU = com.baidu.poly.util.c.uU();
        if (!TextUtils.isEmpty(map.get("payInfo"))) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
                uU.put("appid", jSONObject.optString("appid"));
                uU.put("partnerid", jSONObject.optString("partnerid"));
                uU.put("prepayid", jSONObject.optString("prepayid"));
                uU.put("packagealias", jSONObject.optString("packagealias"));
                uU.put("noncestr", jSONObject.optString("noncestr"));
                uU.put(DpStatConstants.KEY_TIMESTAMP, jSONObject.optString(DpStatConstants.KEY_TIMESTAMP));
                uU.put("sign", jSONObject.optString("sign"));
                uU.put("orderInfo", jSONObject.optString("orderInfo"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return uU;
    }
}
