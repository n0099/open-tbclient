package com.baidu.platform.comapi.walknavi.d.a.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.platform.comapi.walknavi.d.a.f.d;
import com.baidu.platform.comapi.walknavi.d.a.g.b;
import com.baidu.platform.comapi.walknavi.d.a.g.e;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f2986a = null;
    private d b;
    private com.baidu.platform.comapi.walknavi.d.a.a.a c;
    private String d;
    private Context e;

    private a() {
    }

    public static a a() {
        if (f2986a == null) {
            synchronized (a.class) {
                if (f2986a == null) {
                    f2986a = new a();
                }
            }
        }
        return f2986a;
    }

    public void a(Context context, com.baidu.platform.comapi.walknavi.d.a.a.a aVar) {
        this.e = context.getApplicationContext();
        this.c = aVar;
        if (this.c != null) {
            this.d = this.c.a() + Calendar.getInstance().getTimeInMillis();
        } else {
            this.d = String.valueOf(Calendar.getInstance().getTimeInMillis());
        }
    }

    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_id", str);
        hashMap.put("request_id", this.d);
        if (this.c != null) {
            hashMap.put("ar_type", String.valueOf(this.c.c()));
        }
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("params is : " + hashMap.toString());
        if (this.e != null) {
            a(this.e, hashMap);
        }
    }

    private void a(Context context, Map<String, String> map) {
        String str = com.baidu.platform.comapi.walknavi.d.a.g.d.f2991a + com.baidu.platform.comapi.walknavi.d.a.g.d.c + "/count_ar";
        String uuid = new e(context).a().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (this.c != null) {
                if (!TextUtils.isEmpty(this.c.a())) {
                    jSONObject.put("ar_key", this.c.a());
                }
                jSONObject.put("ar_id", this.c.b());
            }
            com.baidu.platform.comapi.walknavi.d.a.f.e.a(context, jSONObject);
            jSONObject.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
            jSONObject.put(HttpConstants.HTTP_OS_TYPE, "android");
            jSONObject.put("os_version", Build.MODEL);
            jSONObject.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
            jSONObject.put("device_id", uuid);
            jSONObject.put("os_version", Build.VERSION.SDK_INT);
            jSONObject.put("app_version", b.a());
            jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, b.a());
            if (!TextUtils.isEmpty(b.a(context))) {
                jSONObject.put("app_id", b.a(context));
            }
            jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        } catch (Exception e) {
        }
        this.b = new d(str, null);
        this.b.execute(jSONObject.toString());
    }

    public void b() {
        if (this.b != null && !this.b.isCancelled()) {
            this.b.cancel(true);
            this.b = null;
        }
        if (f2986a != null) {
            f2986a = null;
        }
        this.d = null;
    }
}
