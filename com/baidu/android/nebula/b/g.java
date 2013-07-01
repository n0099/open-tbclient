package com.baidu.android.nebula.b;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements p {

    /* renamed from: a  reason: collision with root package name */
    private Context f262a;
    private long b = -1;

    public g(Context context) {
        this.f262a = null;
        this.f262a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String deviceID = DeviceId.getDeviceID(this.f262a);
        this.b = System.currentTimeMillis();
        try {
            jSONObject.put("req", h.SEND_USERDATA.ordinal());
            jSONObject.put("deviceid", deviceID);
            jSONObject.put("time", this.b);
            jSONObject.put("ccode", f.a(deviceID, "MhxzKhl", this.b));
            a.a(this.f262a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.b.p
    public void a(n nVar) {
        if (nVar.i() == 200) {
            if (c.a(this.f262a).e()) {
                new s(this.f262a).a();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - m.a(this.f262a, currentTimeMillis) > m.a(this.f262a) * 1000) {
                new k(this.f262a).a();
                m.b(this.f262a, currentTimeMillis);
            }
        }
    }
}
