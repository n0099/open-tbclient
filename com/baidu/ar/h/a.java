package com.baidu.ar.h;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfiguration;
import com.baidu.ar.i.d;
import com.baidu.ar.i.e;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.b;
import com.baidu.ar.util.c;
import com.baidu.ar.util.f;
import com.baidu.ar.util.g;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static a d = null;
    public boolean a = false;
    public boolean b = false;
    public boolean c = true;
    private d e;
    private ARConfiguration f;
    private String g;
    private Context h;

    private a() {
    }

    public static a a() {
        if (d == null) {
            d = new a();
        }
        return d;
    }

    public void a(Context context) {
        this.h = context;
        if (this.f != null) {
            this.g = this.f.getARKey() + Calendar.getInstance().getTimeInMillis();
        } else {
            this.g = String.valueOf(Calendar.getInstance().getTimeInMillis());
        }
    }

    public void a(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_id", "ar_entrance");
        hashMap.put("event_param", str);
        a(context, hashMap);
    }

    public void a(Context context, Map<String, String> map) {
        if (context == null) {
            return;
        }
        String str = Constants.URL_TRACK_AR_PREFIX + Constants.URL_STATISTIC_SERVICE + "/count_ar";
        b.b("server prefix is " + str);
        String uuid = new g(context).a().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (this.f != null) {
                if (!TextUtils.isEmpty(this.f.getARKey())) {
                    jSONObject.put(Constants.AR_KEY, this.f.getARKey());
                }
                jSONObject.put("ar_id", this.f.getARId());
            }
            e.a(context, jSONObject);
            e.b(context, jSONObject);
            jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(Long.valueOf(System.currentTimeMillis())));
            if (!TextUtils.isEmpty(f.a(context))) {
                jSONObject.put("channel", f.a(context));
            }
            jSONObject.put("os_type", Constants.OS_TYPE_VALUE);
            jSONObject.put("os_version", Build.MODEL);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put(Constants.HTTP_DEVICE_ID, uuid);
            jSONObject.put("os_version", Build.VERSION.SDK_INT);
            jSONObject.put(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION, c.a());
            jSONObject.put(Constants.HTTP_ENGINE_VERSION, c.a());
            if (!TextUtils.isEmpty(c.a(context))) {
                jSONObject.put(Constants.HTTP_APP_ID, c.a(context));
            }
            jSONObject.put(Constants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        b.a("params = " + jSONObject.toString());
        this.e = new d(str, null);
        this.e.execute(jSONObject.toString());
    }

    public void a(ARConfiguration aRConfiguration) {
        this.f = aRConfiguration;
    }

    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_id", str);
        hashMap.put("request_id", this.g);
        if (this.f != null) {
            hashMap.put("ar_type", String.valueOf(this.f.getARType()));
        }
        b.a("params is : " + hashMap.toString());
        a(this.h, hashMap);
    }

    public void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_id", str);
        hashMap.put("event_param", str2);
        hashMap.put("request_id", this.g);
        if (this.f != null) {
            hashMap.put("ar_type", String.valueOf(this.f.getARType()));
        }
        b.a("params is : " + hashMap.toString());
        a(this.h, hashMap);
    }

    public void a(boolean z) {
        if (this.c) {
            if (z) {
                this.c = false;
                this.b = true;
            }
        } else if (this.a) {
        } else {
            if (!z) {
                if (this.b) {
                    this.b = false;
                    a().a("untracked");
                }
            } else if (this.b) {
            } else {
                this.b = true;
                this.a = true;
                a().a("tracked");
            }
        }
    }

    public void b() {
        if (this.e != null && !this.e.isCancelled()) {
            this.e.cancel(true);
            this.e = null;
        }
        if (d != null) {
            d = null;
        }
        this.g = null;
    }
}
