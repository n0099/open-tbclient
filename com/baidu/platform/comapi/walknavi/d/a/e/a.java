package com.baidu.platform.comapi.walknavi.d.a.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.platform.comapi.walknavi.d.a.f.d;
import com.baidu.platform.comapi.walknavi.d.a.g.b;
import com.baidu.platform.comapi.walknavi.d.a.g.e;
import com.baidu.tbadk.core.atomData.FrsArActivityConfig;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f9989a;

    /* renamed from: b  reason: collision with root package name */
    public d f9990b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.d.a.a.a f9991c;

    /* renamed from: d  reason: collision with root package name */
    public String f9992d;

    /* renamed from: e  reason: collision with root package name */
    public Context f9993e;

    public static a a() {
        if (f9989a == null) {
            synchronized (a.class) {
                if (f9989a == null) {
                    f9989a = new a();
                }
            }
        }
        return f9989a;
    }

    public void b() {
        d dVar = this.f9990b;
        if (dVar != null && !dVar.isCancelled()) {
            this.f9990b.cancel(true);
            this.f9990b = null;
        }
        if (f9989a != null) {
            f9989a = null;
        }
        this.f9992d = null;
    }

    public void a(Context context, com.baidu.platform.comapi.walknavi.d.a.a.a aVar) {
        this.f9993e = context.getApplicationContext();
        this.f9991c = aVar;
        if (aVar != null) {
            this.f9992d = this.f9991c.a() + Calendar.getInstance().getTimeInMillis();
            return;
        }
        this.f9992d = String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_id", str);
        hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, this.f9992d);
        com.baidu.platform.comapi.walknavi.d.a.a.a aVar = this.f9991c;
        if (aVar != null) {
            hashMap.put(FrsArActivityConfig.AR_TYPE, String.valueOf(aVar.c()));
        }
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("params is : " + hashMap.toString());
        Context context = this.f9993e;
        if (context != null) {
            a(context, hashMap);
        }
    }

    private void a(Context context, Map<String, String> map) {
        String str = com.baidu.platform.comapi.walknavi.d.a.g.d.f10004a + com.baidu.platform.comapi.walknavi.d.a.g.d.f10006c + "/count_ar";
        String uuid = new e(context).a().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (this.f9991c != null) {
                if (!TextUtils.isEmpty(this.f9991c.a())) {
                    jSONObject.put("ar_key", this.f9991c.a());
                }
                jSONObject.put(FrsArActivityConfig.AR_ID, this.f9991c.b());
            }
            com.baidu.platform.comapi.walknavi.d.a.f.e.a(context, jSONObject);
            jSONObject.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
            jSONObject.put("os_type", "android");
            jSONObject.put("os_version", Build.MODEL);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put(Constants.KEY_DEVICE_ID, uuid);
            jSONObject.put("os_version", Build.VERSION.SDK_INT);
            jSONObject.put("app_version", b.a());
            jSONObject.put("engine_version", b.a());
            if (!TextUtils.isEmpty(b.a(context))) {
                jSONObject.put(com.xiaomi.mipush.sdk.Constants.APP_ID, b.a(context));
            }
            jSONObject.put("system_version", Build.VERSION.SDK_INT);
        } catch (Exception unused) {
        }
        d dVar = new d(str, null);
        this.f9990b = dVar;
        dVar.execute(jSONObject.toString());
    }
}
