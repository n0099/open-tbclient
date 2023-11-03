package com.baidu.android.pushservice.r;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.a0.f;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.l.d;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.e;
import com.tencent.connect.common.Constants;
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
    public static b a;
    public static volatile c b;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;

        public a(Context context, String str) {
            this.c = context;
            this.d = str;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            HashMap a = c.this.a(this.c, "POST", this.d);
            int i = 2;
            do {
                com.baidu.android.pushservice.q.b a2 = com.baidu.android.pushservice.q.c.a(this.c, this.d, "POST", a, "BCCS_SDK/3.0", g.b());
                if (a2 != null) {
                    int a3 = a2.a();
                    String a4 = Utility.a(this.c, a2.b());
                    if (a3 == 200 && c.this.a(a4) == 0) {
                        return;
                    }
                }
                i--;
            } while (i > 0);
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public final int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optJSONObject("response_params").optInt("ret");
            } catch (JSONException unused) {
            }
        }
        return 0;
    }

    public final String a(String str, String str2, HashMap<String, String> hashMap) {
        TreeSet<String> treeSet = new TreeSet(hashMap.keySet());
        StringBuilder sb = new StringBuilder();
        for (String str3 : treeSet) {
            sb.append(str3);
            sb.append("=");
            sb.append(hashMap.get(str3));
        }
        return f.a((str + str2 + sb.toString()).getBytes(), false);
    }

    public final HashMap<String, String> a(Context context, String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"));
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("timestamp", currentTimeMillis + "");
        hashMap.put(Constants.PARAM_PLATFORM, a.a() + "");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(DeviceId.getCUID(context));
        hashMap.put("cuids", jSONArray.toString());
        try {
            hashMap.put("vcode", f.a(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false));
        } catch (UnsupportedEncodingException unused) {
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

    public void a(Context context) {
        if (context == null) {
            return;
        }
        a(context, 0);
        c(context);
    }

    public final void a(Context context, int i) {
        Intent launchIntentForPackage;
        if (context == null) {
            return;
        }
        if (a == null) {
            b(context);
        }
        if (a == null || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName())) == null) {
            return;
        }
        a.a(context, launchIntentForPackage.getComponent(), i);
    }

    public final void b(Context context) {
        if (Build.VERSION.SDK_INT < 26 || !d.m(context)) {
            return;
        }
        a = new com.baidu.android.pushservice.r.a();
    }

    public final void c(Context context) {
        String c = g.f() ? g.c() : g.d();
        e.a().a(new a(context, c + "/rest/3.0/clientfile/clearbadge"));
    }
}
