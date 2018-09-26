package cn.jiguang.g.c;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    public String a;
    public String b;
    public String c;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", TextUtils.isEmpty(this.a) ? "" : this.a);
            jSONObject.put("iccid", TextUtils.isEmpty(this.c) ? "" : this.c);
            jSONObject.put("imsi", TextUtils.isEmpty(this.b) ? "" : this.b);
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    public final String toString() {
        return "SimInfo{imei='" + this.a + "', imsi='" + this.b + "', iccid='" + this.c + "'}";
    }
}
