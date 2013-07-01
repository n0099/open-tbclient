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

    /* renamed from: a  reason: collision with root package name */
    private Context f272a;
    private long b = -1;

    public s(Context context) {
        this.f272a = null;
        this.f272a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String deviceID = DeviceId.getDeviceID(this.f272a);
        this.b = System.currentTimeMillis();
        n a2 = a.a(this.f272a).a();
        try {
            ArrayList b = c.a(this.f272a).a(a2.j()).b();
            if (b == null || b.size() <= 0) {
                return;
            }
            jSONObject.put("req", h.UPDATE_APPSSTATE.ordinal());
            jSONObject.put("deviceid", deviceID);
            jSONObject.put("time", this.b);
            jSONObject.put("needstoken", a2.g());
            jSONObject.put("channelid", a2.h());
            jSONObject.put("ccode", f.a(deviceID, "MhxzKhl", this.b));
            JSONArray jSONArray = new JSONArray();
            Iterator it = b.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("op", uVar.a().ordinal());
                jSONObject2.put("package", uVar.b());
                jSONObject2.put("signmd5", uVar.a(this.f272a));
                jSONObject2.put("version", uVar.c());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("applist", jSONArray);
            a.a(this.f272a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.b.p
    public void a(n nVar) {
        if (nVar.c()) {
            nVar.d();
        } else if (nVar.i() == 200) {
            if (nVar.e().size() > 0) {
                c.a(this.f272a).a(nVar.e());
            }
            if (c.a(this.f272a).c()) {
                new s(this.f272a).a();
            }
        } else if (nVar.i() == 58217) {
            if (nVar.a().size() > 0) {
                c.a(this.f272a).b(nVar.a());
            } else if (nVar.e().size() > 0) {
                c.a(this.f272a).a(nVar.e());
            }
            if (c.a(this.f272a).c()) {
                new s(this.f272a).a();
            }
        }
    }
}
