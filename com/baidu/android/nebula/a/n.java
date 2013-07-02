package com.baidu.android.nebula.a;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n implements q {
    private Context a;
    private long b = -1;

    public n(Context context) {
        this.a = null;
        this.a = context;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject();
        String deviceID = DeviceId.getDeviceID(this.a);
        this.b = System.currentTimeMillis();
        r a = e.a(this.a).a();
        try {
            ArrayList b = h.a(this.a).a(a.j()).b();
            if (b == null || b.size() <= 0) {
                return;
            }
            jSONObject.put("req", d.UPDATE_APPSSTATE.ordinal());
            jSONObject.put("deviceid", deviceID);
            jSONObject.put("time", this.b);
            jSONObject.put("needstoken", a.g());
            jSONObject.put("channelid", a.h());
            jSONObject.put("ccode", g.a(deviceID, "MhxzKhl", this.b));
            JSONArray jSONArray = new JSONArray();
            Iterator it = b.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("op", aVar.a().ordinal());
                jSONObject2.put("package", aVar.b());
                jSONObject2.put("signmd5", aVar.a(this.a));
                jSONObject2.put("version", aVar.c());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("applist", jSONArray);
            e.a(this.a).a(jSONObject.toString(), this);
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.android.nebula.a.q
    public void a(r rVar) {
        if (rVar.c()) {
            rVar.d();
        } else if (rVar.i() == 200) {
            if (rVar.e().size() > 0) {
                h.a(this.a).a(rVar.e());
            }
            if (h.a(this.a).b()) {
                new n(this.a).a();
            }
        } else if (rVar.i() == 58217) {
            if (rVar.a().size() > 0) {
                h.a(this.a).b(rVar.a());
            } else if (rVar.e().size() > 0) {
                h.a(this.a).a(rVar.e());
            }
            if (h.a(this.a).b()) {
                new n(this.a).a();
            }
        }
    }
}
