package com.baidu.android.pushservice.f;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.f;
import com.baidu.android.pushservice.j.i;
import com.baidu.android.pushservice.j.m;
import com.qq.e.comm.constants.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static b f3084a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f3085b;

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optJSONObject("response_params").optInt(Constants.KEYS.RET);
            } catch (JSONException unused) {
            }
        }
        return 0;
    }

    public static c a() {
        if (f3085b == null) {
            synchronized (c.class) {
                if (f3085b == null) {
                    f3085b = new c();
                }
            }
        }
        return f3085b;
    }

    private String a(String str, String str2, HashMap<String, String> hashMap) {
        TreeSet<String> treeSet = new TreeSet(hashMap.keySet());
        StringBuilder sb = new StringBuilder();
        for (String str3 : treeSet) {
            sb.append(str3);
            sb.append("=");
            sb.append(hashMap.get(str3));
        }
        return f.a((str + str2 + sb.toString()).getBytes(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> a(Context context, String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"));
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("timestamp", currentTimeMillis + "");
        hashMap.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, f3084a.a() + "");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(DeviceId.getCUID(context));
        hashMap.put("cuids", jSONArray.toString());
        try {
            hashMap.put("vcode", f.a(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false));
        } catch (UnsupportedEncodingException e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
        hashMap.put("sign", a("POST", str2, hashMap));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            sb.append((Object) entry.getKey());
            sb.append("=");
            sb.append((Object) entry.getValue());
            sb.append(" ");
        }
        return hashMap;
    }

    private void a(Context context, int i2) {
        Intent launchIntentForPackage;
        if (context == null) {
            return;
        }
        if (f3084a == null) {
            b(context);
        }
        if (f3084a == null || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName())) == null) {
            return;
        }
        f3084a.a(context, launchIntentForPackage.getComponent(), i2);
    }

    private void b(Context context) {
        if (Build.VERSION.SDK_INT < 26 || !d.l(context)) {
            return;
        }
        f3084a = new a();
    }

    private void c(final Context context) {
        final String str = (h.f() ? h.a() : h.b()) + "/rest/3.0/clientfile/clearbadge";
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c() { // from class: com.baidu.android.pushservice.f.c.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                HashMap a2 = c.this.a(context, "POST", str);
                int i2 = 2;
                do {
                    com.baidu.android.pushservice.e.b b2 = com.baidu.android.pushservice.e.c.b(context, str, "POST", a2, "BCCS_SDK/3.0", h.c());
                    if (b2 != null) {
                        int b3 = b2.b();
                        String a3 = m.a(context, b2.a());
                        if (b3 == 200 && c.this.a(a3) == 0) {
                            return;
                        }
                    }
                    i2--;
                } while (i2 > 0);
            }
        });
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        a(context, 0);
        c(context);
    }
}
