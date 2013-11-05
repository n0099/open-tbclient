package com.baidu.android.nebula.a;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u implements q {

    /* renamed from: a  reason: collision with root package name */
    private Context f647a;
    private long b = -1;

    public u(Context context) {
        this.f647a = null;
        this.f647a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String deviceID = DeviceId.getDeviceID(this.f647a);
        this.b = System.currentTimeMillis();
        try {
            jSONObject.put("req", d.SEND_USERDATA.ordinal());
            jSONObject.put("deviceid", deviceID);
            jSONObject.put("time", this.b);
            jSONObject.put("ccode", k.a(deviceID, "MhxzKhl", this.b));
            i.a(this.f647a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.a.q
    public void a(r rVar) {
        if (rVar.i() == 200) {
            if (e.a(this.f647a).e()) {
                new n(this.f647a).a();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c.a(this.f647a, currentTimeMillis) > c.a(this.f647a) * 1000) {
                new o(this.f647a).a();
                c.b(this.f647a, currentTimeMillis);
            }
        }
    }
}
