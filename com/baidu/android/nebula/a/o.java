package com.baidu.android.nebula.a;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o implements q {

    /* renamed from: a  reason: collision with root package name */
    private Context f652a;
    private long b = -1;

    public o(Context context) {
        this.f652a = null;
        this.f652a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String deviceID = DeviceId.getDeviceID(this.f652a);
        this.b = System.currentTimeMillis();
        r a2 = i.a(this.f652a).a();
        try {
            jSONObject.put("req", d.CHECK_APPSYNC.ordinal());
            jSONObject.put("deviceid", deviceID);
            jSONObject.put("time", this.b);
            jSONObject.put("needstoken", a2.g());
            jSONObject.put("channelid", a2.h());
            jSONObject.put("ccode", k.a(deviceID, "MhxzKhl", this.b));
            JSONArray jSONArray = new JSONArray();
            Iterator it = e.a(this.f652a).b(a2.f()).b().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("package", aVar.b());
                jSONObject2.put("signmd5", aVar.a(this.f652a));
                jSONObject2.put("version", aVar.c());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("checklist", jSONArray);
            i.a(this.f652a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.a.q
    public void a(r rVar) {
        if (rVar.i() != 200) {
            e.a(this.f652a).b();
            e.a(this.f652a).d();
            new n(this.f652a).a();
        }
    }
}
