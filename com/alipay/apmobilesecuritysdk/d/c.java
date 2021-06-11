package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.f;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    public static Map<String, String> a(Context context) {
        com.alipay.security.mobile.module.deviceinfo.b a2 = com.alipay.security.mobile.module.deviceinfo.b.a();
        HashMap hashMap = new HashMap();
        f a3 = com.alipay.apmobilesecuritysdk.e.e.a(context);
        String a4 = a2.a(context);
        String b2 = a2.b(context);
        String p = a2.p(context);
        String s = a2.s(context);
        String r = a2.r(context);
        if (a3 != null) {
            if (com.alipay.security.mobile.module.a.a.a(a4)) {
                a4 = a3.a();
            }
            if (com.alipay.security.mobile.module.a.a.a(b2)) {
                b2 = a3.b();
            }
            if (com.alipay.security.mobile.module.a.a.a(p)) {
                p = a3.c();
            }
            if (com.alipay.security.mobile.module.a.a.a(s)) {
                s = a3.d();
            }
            if (com.alipay.security.mobile.module.a.a.a(r)) {
                r = a3.e();
            }
        }
        f fVar = new f(a4, b2, p, s, r);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", fVar.a());
                jSONObject.put(BaseStatisContent.IMSI, fVar.b());
                jSONObject.put("mac", fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject2);
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
        }
        hashMap.put("AD1", a4);
        hashMap.put("AD2", b2);
        hashMap.put("AD3", a2.j(context));
        hashMap.put("AD5", a2.l(context));
        hashMap.put("AD6", a2.n(context));
        hashMap.put("AD7", a2.o(context));
        hashMap.put("AD8", p);
        hashMap.put("AD9", a2.q(context));
        hashMap.put("AD10", r);
        hashMap.put("AD11", a2.d());
        hashMap.put("AD12", a2.f());
        hashMap.put("AD13", a2.g());
        hashMap.put("AD14", a2.i());
        hashMap.put("AD15", a2.j());
        hashMap.put("AD16", a2.k());
        hashMap.put("AD17", "");
        hashMap.put("AD18", s);
        hashMap.put("AD19", a2.t(context));
        hashMap.put("AD20", a2.n());
        hashMap.put("AD22", "");
        hashMap.put("AD23", a2.p());
        hashMap.put("AD24", com.alipay.security.mobile.module.a.a.g(a2.k(context)));
        hashMap.put("AD26", a2.g(context));
        hashMap.put("AD27", a2.w());
        hashMap.put("AD28", a2.y());
        hashMap.put("AD29", a2.A());
        hashMap.put("AD30", a2.x());
        hashMap.put("AD31", a2.z());
        hashMap.put("AD32", a2.u());
        hashMap.put("AD33", a2.v());
        hashMap.put("AD34", a2.x(context));
        hashMap.put("AD35", a2.y(context));
        hashMap.put("AD36", a2.v(context));
        hashMap.put("AD37", a2.s());
        hashMap.put("AD38", a2.q());
        hashMap.put("AD39", a2.c(context));
        hashMap.put("AD40", a2.d(context));
        hashMap.put("AD41", a2.b());
        hashMap.put("AD42", a2.c());
        hashMap.put("AL3", a2.u(context));
        return hashMap;
    }
}
