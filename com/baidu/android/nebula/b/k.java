package com.baidu.android.nebula.b;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements p {

    /* renamed from: a  reason: collision with root package name */
    private Context f530a;
    private long b = -1;

    public k(Context context) {
        this.f530a = null;
        this.f530a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String deviceID = DeviceId.getDeviceID(this.f530a);
        this.b = System.currentTimeMillis();
        n a2 = a.a(this.f530a).a();
        try {
            jSONObject.put("req", h.CHECK_APPSYNC.ordinal());
            jSONObject.put("deviceid", deviceID);
            jSONObject.put("time", this.b);
            jSONObject.put("needstoken", a2.g());
            jSONObject.put("channelid", a2.h());
            jSONObject.put("ccode", f.a(deviceID, "MhxzKhl", this.b));
            JSONArray jSONArray = new JSONArray();
            Iterator it = c.a(this.f530a).b(a2.f()).b().iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("package", uVar.b());
                jSONObject2.put("signmd5", uVar.a(this.f530a));
                jSONObject2.put("version", uVar.c());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("checklist", jSONArray);
            a.a(this.f530a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.b.p
    public void a(n nVar) {
        if (nVar.i() != 200) {
            c.a(this.f530a).b();
            c.a(this.f530a).d();
            new s(this.f530a).a();
        }
    }
}
