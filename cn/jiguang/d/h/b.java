package cn.jiguang.d.h;

import android.support.v4.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {
    int a = -1;
    int b = -1;
    int c = -1;
    int d = -1;
    int e = -1;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", this.a);
            jSONObject.put("scale", this.b);
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, this.c);
            jSONObject.put("voltage", this.d);
            jSONObject.put("temperature", this.e);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String toString() {
        return "BatteryInfo{level=" + this.a + ", scale=" + this.b + ", status=" + this.c + ", voltage=" + this.d + ", temperature=" + this.e + '}';
    }
}
