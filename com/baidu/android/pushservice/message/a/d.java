package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.j.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends c {
    private static final String b = d.class.getSimpleName();

    public d(Context context) {
        super(context);
    }

    public static void a(final Context context) {
        long c = com.baidu.android.pushservice.j.n.c(context, "com.baidu.pushservice.internal.bind.LATEST_TIME");
        com.baidu.android.pushservice.g.a.c(b, "lastTime from SP is: " + c);
        final long currentTimeMillis = System.currentTimeMillis();
        com.baidu.android.pushservice.g.a.c(b, "System currentTimeMillis is: " + currentTimeMillis);
        long j = currentTimeMillis - c;
        com.baidu.android.pushservice.g.a.c(b, "curIntervalTime is: " + j);
        if (!com.baidu.android.pushservice.j.l.a(context) || j <= 259200000) {
            return;
        }
        com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("uploadInternalBindApps", (short) 95) { // from class: com.baidu.android.pushservice.message.a.d.1
            @Override // com.baidu.android.pushservice.i.c
            public void a() {
                try {
                    com.baidu.android.pushservice.g.a.c(d.b, "setSP LAST_INTERNAL_BIND_TIME, newLastTime is: " + currentTimeMillis);
                    com.baidu.android.pushservice.j.n.a(context, "com.baidu.pushservice.internal.bind.LATEST_TIME", currentTimeMillis);
                    String d = d.d(context);
                    com.baidu.android.pushservice.g.a.c(d.b, "bindParams is: " + d);
                    HashMap hashMap = new HashMap();
                    com.baidu.android.pushservice.e.b.b(hashMap);
                    hashMap.put("device_type", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                    hashMap.put(LegoListActivityConfig.PARAMS, d);
                    int i = 0;
                    do {
                        i++;
                        com.baidu.android.pushservice.g.a.c(d.b, "HttpUtil.execRequest! INTERNAL_BIND_URL: https://api.tuisong.baidu.com/rest/3.0/oem/upload_unbind_oem");
                        com.baidu.android.pushservice.f.a a = com.baidu.android.pushservice.f.b.a("https://api.tuisong.baidu.com/rest/3.0/oem/upload_unbind_oem", "POST", hashMap, "BCCS_SDK/3.0");
                        if (a.b() == 200) {
                            com.baidu.android.pushservice.g.a.c(d.b, "code == 200, HTTP POST success!");
                            return;
                        }
                        com.baidu.android.pushservice.g.a.c(d.b, "code == " + a.b() + ", HTTP POST unsuccess!");
                    } while (i < 2);
                } catch (Exception e) {
                    com.baidu.android.pushservice.g.a.d(d.b, "warn: " + e.getMessage());
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
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
        intent.putExtra("bind_name", Build.MODEL);
        intent.putExtra("bind_status", 0);
        intent.putExtra("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
        intent.setFlags(intent.getFlags() | 32);
        if (Build.VERSION.SDK_INT >= 19) {
            if (com.baidu.android.pushservice.j.m.a(context)) {
                intent.putExtra("bind_notify_status", "1");
            } else {
                intent.putExtra("bind_notify_status", "0");
            }
        }
        com.baidu.android.pushservice.g.a.c(b, "a internal bind intent send");
        p.a(context, intent);
    }

    private static String c(Context context) {
        String str;
        ArrayList<String> p = q.p(context);
        if (!p.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = p.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (q.w(context, next)) {
                    com.baidu.android.pushservice.g.a.c(b, next + " is Already Binded App.");
                } else {
                    Context u = q.u(context, next);
                    String v = q.v(u, next);
                    String a = q.a(u, next, "bp_reg_key");
                    com.baidu.android.pushservice.g.a.c(b, next + "->Manifest bp_reg_key corresponding apiKey is " + a);
                    if (!TextUtils.isEmpty(a)) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("packagename", next);
                            jSONObject.put("apikey", a);
                            jSONObject.put("installtime", v);
                            jSONObject.put("pkgMD5info", q.q(u, next));
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            com.baidu.android.pushservice.g.a.a(b, e);
                        }
                    }
                }
            }
            if (jSONArray.length() > 0) {
                str = jSONArray.toString();
                com.baidu.android.pushservice.g.a.c(b, "All can internal bind app info bindApps: " + str);
                return str;
            }
        }
        str = null;
        com.baidu.android.pushservice.g.a.c(b, "All can internal bind app info bindApps: " + str);
        return str;
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
        return com.baidu.android.pushservice.k.b.a(com.baidu.android.pushservice.k.g.a(jSONObject.toString().getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/7VlVn9LIrZ71PL2RZMbK/Yxc\r\ndb046w/cXVylxS7ouPY06namZUFVhdbUnNRJzmGUZlzs3jUbvMO3l+4c9cw/n9aQ\r\nrm/brgaRDeZbeSrQYRZv60xzJIimuFFxsRM+ku6/dAyYmXiQXlRbgvFQ0MsVng4j\r\nv+cXhtTis2Kbwb8mQwIDAQAB\r\n", 1024), "utf-8");
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        return null;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(String str, String str2, int i, byte[] bArr, String str3, byte[] bArr2) {
        JSONArray jSONArray;
        int length;
        int i2;
        int i3 = 0;
        com.baidu.android.pushservice.g.a.c(b, "Internal bind cmd from server, appid: " + str + "msgId: " + str2 + "msgType: " + i + "checkInfo: " + bArr.toString() + "msgBody: " + bArr2);
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr2));
            if (!jSONObject.isNull("custom_content")) {
                String string = jSONObject.getString("custom_content");
                com.baidu.android.pushservice.g.a.c(b, "jsonString: " + string);
                if (!TextUtils.isEmpty(string) && (length = (jSONArray = new JSONArray(string)).length()) > 0) {
                    ArrayList<String> p = q.p(this.a);
                    int i4 = 0;
                    while (i4 < length) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i4);
                        String string2 = jSONObject2.getString("package_name");
                        if (p.contains(string2)) {
                            String string3 = jSONObject2.getString("apikey");
                            if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !q.w(this.a, string2)) {
                                com.baidu.android.pushservice.g.a.c(b, "doInternalBind: packageName=" + string2 + ", apiKey=" + string3);
                                a(string3, string2, this.a);
                            }
                            i2 = i3;
                        } else {
                            i2 = 8;
                            com.baidu.android.pushservice.g.a.c(b, "packageName: [" + string2 + "] is not in allPushPkgs, return ack 8.");
                        }
                        i4++;
                        i3 = i2;
                    }
                }
            }
        } catch (Exception e) {
            i3 = 2;
            com.baidu.android.pushservice.g.a.a(b, e);
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        gVar.a(i3);
        return gVar;
    }
}
