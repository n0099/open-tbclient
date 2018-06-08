package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends c {
    public d(Context context) {
        super(context);
    }

    public static void a(final Context context) {
        long b = com.baidu.android.pushservice.j.j.b(context, "com.baidu.pushservice.internal.bind.LATEST_TIME");
        final long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - b;
        if (!com.baidu.android.pushservice.j.h.a(context) || j <= 259200000) {
            return;
        }
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("uploadInternalBindApps", (short) 95) { // from class: com.baidu.android.pushservice.message.a.d.1
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                try {
                    com.baidu.android.pushservice.j.j.a(context, "com.baidu.pushservice.internal.bind.LATEST_TIME", currentTimeMillis);
                    String d = d.d(context);
                    HashMap hashMap = new HashMap();
                    com.baidu.android.pushservice.e.b.a(hashMap);
                    hashMap.put(StatisticConstants.DEVICE_TYPE, "3");
                    hashMap.put(LegoListActivityConfig.PARAMS, d);
                    int i = 0;
                    do {
                        i++;
                        if (com.baidu.android.pushservice.f.b.a("https://api.tuisong.baidu.com/rest/3.0/oem/upload_unbind_oem", "POST", hashMap, "BCCS_SDK/3.0").b() == 200) {
                            return;
                        }
                    } while (i < 2);
                } catch (Exception e) {
                }
            }
        });
    }

    private void a(String str, String str2, Context context) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.addFlags(32);
        intent.putExtra("method_version", "V2");
        intent.putExtra("secret_key", str);
        intent.putExtra(PushConstants.PACKAGE_NAME, str2);
        intent.putExtra("is_baidu_internal_bind", "true");
        intent.putExtra("method", PushConstants.METHOD_BIND);
        intent.putExtra("bind_status", 0);
        intent.putExtra("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
        if (Build.VERSION.SDK_INT >= 19) {
            intent.putExtra("bind_notify_status", com.baidu.android.pushservice.j.i.a(context) + "");
        }
        com.baidu.android.pushservice.j.l.a(context, intent);
    }

    private static String c(Context context) {
        ArrayList<String> q = com.baidu.android.pushservice.j.m.q(context);
        if (!q.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = q.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!com.baidu.android.pushservice.j.m.x(context, next)) {
                    Context v = com.baidu.android.pushservice.j.m.v(context, next);
                    String w = com.baidu.android.pushservice.j.m.w(v, next);
                    String a = com.baidu.android.pushservice.j.m.a(v, next, "bp_reg_key");
                    if (!TextUtils.isEmpty(a)) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("packagename", next);
                            jSONObject.put("apikey", a);
                            jSONObject.put("installtime", w);
                            jSONObject.put("pkgMD5info", com.baidu.android.pushservice.j.m.r(v, next));
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                        }
                    }
                }
            }
            if (jSONArray.length() > 0) {
                return jSONArray.toString();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Context context) throws Exception {
        String c = c(context);
        if (TextUtils.isEmpty(c)) {
            throw new Exception("NO INTERNAL BIND APP INFOS！");
        }
        JSONObject jSONObject = new JSONObject();
        String a = PushSettings.a(context);
        String a2 = com.baidu.android.pushservice.k.e.a(context);
        jSONObject.put("channel_id", a);
        jSONObject.put("cuid", a2);
        jSONObject.put("aksinfo", c);
        return com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptR(jSONObject.toString().getBytes(), 2), IoUtils.UTF_8);
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        JSONArray jSONArray;
        int length;
        int i;
        int i2 = 0;
        kVar.h();
        kVar.i();
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (!jSONObject.isNull("custom_content")) {
                String string = jSONObject.getString("custom_content");
                if (!TextUtils.isEmpty(string) && (length = (jSONArray = new JSONArray(string)).length()) > 0) {
                    ArrayList<String> q = com.baidu.android.pushservice.j.m.q(this.a);
                    int i3 = 0;
                    while (i3 < length) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                        String string2 = jSONObject2.getString("package_name");
                        if (q.contains(string2)) {
                            String string3 = jSONObject2.getString("apikey");
                            if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !com.baidu.android.pushservice.j.m.x(this.a, string2)) {
                                a(string3, string2, this.a);
                            }
                            i = i2;
                        } else {
                            i = 8;
                        }
                        i3++;
                        i2 = i;
                    }
                }
            }
        } catch (Exception e) {
            i2 = 2;
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i2);
        return gVar;
    }
}
