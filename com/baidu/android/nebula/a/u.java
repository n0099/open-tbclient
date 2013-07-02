package com.baidu.android.nebula.a;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u implements q {
    private Context a;
    private long b = -1;

    public u(Context context) {
        this.a = null;
        this.a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String deviceID = DeviceId.getDeviceID(this.a);
        this.b = System.currentTimeMillis();
        try {
            jSONObject.put("req", d.SEND_USERDATA.ordinal());
            jSONObject.put("deviceid", deviceID);
            jSONObject.put("time", this.b);
            jSONObject.put("ccode", g.a(deviceID, "MhxzKhl", this.b));
            e.a(this.a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.a.q
    public void a(r rVar) {
        if (rVar.i() == 200) {
            if (h.a(this.a).d()) {
                new n(this.a).a();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c.a(this.a, currentTimeMillis) > c.a(this.a) * 1000) {
                new o(this.a).a();
                c.b(this.a, currentTimeMillis);
            }
        }
    }
}
