package com.baidu.android.nebula.b;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements p {
    private Context a;
    private long b = -1;

    public g(Context context) {
        this.a = null;
        this.a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String deviceID = DeviceId.getDeviceID(this.a);
        this.b = System.currentTimeMillis();
        try {
            jSONObject.put("req", h.SEND_USERDATA.ordinal());
            jSONObject.put("deviceid", deviceID);
            jSONObject.put("time", this.b);
            jSONObject.put("ccode", f.a(deviceID, "MhxzKhl", this.b));
            a.a(this.a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.b.p
    public void a(n nVar) {
        if (nVar.i() == 200) {
            if (c.a(this.a).e()) {
                new s(this.a).a();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - m.a(this.a, currentTimeMillis) > m.a(this.a) * 1000) {
                new k(this.a).a();
                m.b(this.a, currentTimeMillis);
            }
        }
    }
}
