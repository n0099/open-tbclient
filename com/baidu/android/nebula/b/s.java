package com.baidu.android.nebula.b;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s implements p {
    private Context a;
    private long b = -1;

    public s(Context context) {
        this.a = null;
        this.a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String deviceID = DeviceId.getDeviceID(this.a);
        this.b = System.currentTimeMillis();
        n a = a.a(this.a).a();
        try {
            ArrayList b = c.a(this.a).a(a.j()).b();
            if (b == null || b.size() <= 0) {
                return;
            }
            jSONObject.put("req", h.UPDATE_APPSSTATE.ordinal());
            jSONObject.put("deviceid", deviceID);
            jSONObject.put("time", this.b);
            jSONObject.put("needstoken", a.g());
            jSONObject.put("channelid", a.h());
            jSONObject.put("ccode", f.a(deviceID, "MhxzKhl", this.b));
            JSONArray jSONArray = new JSONArray();
            Iterator it = b.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("op", uVar.a().ordinal());
                jSONObject2.put("package", uVar.b());
                jSONObject2.put("signmd5", uVar.a(this.a));
                jSONObject2.put("version", uVar.c());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("applist", jSONArray);
            a.a(this.a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.b.p
    public void a(n nVar) {
        if (nVar.c()) {
            nVar.d();
        } else if (nVar.i() == 200) {
            if (nVar.e().size() > 0) {
                c.a(this.a).a(nVar.e());
            }
            if (c.a(this.a).c()) {
                new s(this.a).a();
            }
        } else if (nVar.i() == 58217) {
            if (nVar.a().size() > 0) {
                c.a(this.a).b(nVar.a());
            } else if (nVar.e().size() > 0) {
                c.a(this.a).a(nVar.e());
            }
            if (c.a(this.a).c()) {
                new s(this.a).a();
            }
        }
    }
}
