package com.baidu.platform.comapi.walknavi.d.a.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.platform.comapi.walknavi.d.a.f.d;
import com.baidu.platform.comapi.walknavi.d.a.g.b;
import com.baidu.platform.comapi.walknavi.d.a.g.e;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.FrsArActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    private static a a = null;
    private d b;
    private com.baidu.platform.comapi.walknavi.d.a.a.a c;
    private String d;
    private Context e;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
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
            hashMap.put(FrsArActivityConfig.AR_TYPE, String.valueOf(this.c.c()));
        }
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("params is : " + hashMap.toString());
        if (this.e != null) {
            a(this.e, hashMap);
        }
    }

    private void a(Context context, Map<String, String> map) {
        String str = com.baidu.platform.comapi.walknavi.d.a.g.d.a + com.baidu.platform.comapi.walknavi.d.a.g.d.c + "/count_ar";
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
                jSONObject.put(FrsArActivityConfig.AR_ID, this.c.b());
            }
            com.baidu.platform.comapi.walknavi.d.a.f.e.a(context, jSONObject);
            jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(Long.valueOf(System.currentTimeMillis())));
            jSONObject.put("os_type", "android");
            jSONObject.put("os_version", Build.MODEL);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("device_id", uuid);
            jSONObject.put("os_version", Build.VERSION.SDK_INT);
            jSONObject.put(Constants.EXTRA_KEY_APP_VERSION, b.a());
            jSONObject.put("engine_version", b.a());
            if (!TextUtils.isEmpty(b.a(context))) {
                jSONObject.put(Constants.APP_ID, b.a(context));
            }
            jSONObject.put("system_version", Build.VERSION.SDK_INT);
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
        if (a != null) {
            a = null;
        }
        this.d = null;
    }
}
