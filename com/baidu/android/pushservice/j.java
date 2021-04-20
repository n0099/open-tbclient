package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.j.m;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3407a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile j f3408b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f3409c;

    public static j a(Context context) {
        if (f3408b == null) {
            synchronized (j.class) {
                if (f3408b == null) {
                    f3408b = new j();
                    f3409c = context;
                }
            }
        }
        return f3408b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).getJSONObject("info").getString("token");
            } catch (JSONException unused) {
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, com.baidu.android.pushservice.j.i.a(f3409c, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"));
            jSONObject2.put("timestamp", (System.currentTimeMillis() / 1000) + "");
            jSONObject2.put(IAdRequestParam.CELL_ID, com.baidu.android.pushservice.j.i.a(f3409c, IAdRequestParam.CELL_ID));
            jSONObject2.put("device_type", "3");
            jSONObject2.put("sdk_int", Build.VERSION.SDK_INT + "");
            jSONObject2.put("push_sdk_version", ((int) a.a()) + "");
            int i = m.o(f3409c) ? 3 : 2;
            jSONObject2.put("connect_version", i + "");
            jSONObject2.put("bind_name", Build.MODEL);
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("push_proxy", str);
            }
            jSONObject2.put("os_version", Build.DISPLAY);
            jSONObject2.put("manufacturer", Build.MANUFACTURER);
            jSONObject2.put("bind_notify_status", com.baidu.android.pushservice.j.h.b(f3409c));
            jSONObject2.put("source", 2);
            JSONArray a2 = com.baidu.android.pushservice.j.k.a(jSONObject2.toString(), 3, 2);
            jSONObject.put("info", a2);
            jSONObject.put("info_len", a2.length());
        } catch (JSONException | Exception unused) {
        }
        return jSONObject.toString();
    }

    public void a(final String str) {
        final String str2 = h.f3102c + h.f3107h;
        final HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("requestNewBind", (short) 100) { // from class: com.baidu.android.pushservice.j.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                String b2 = j.this.b(str);
                com.baidu.android.pushservice.e.b a2 = com.baidu.android.pushservice.e.c.a(j.f3409c, str2, "POST", j.this.c(str), hashMap, "application/json");
                if (a2 != null) {
                    try {
                        com.baidu.android.pushservice.j.i.a(j.f3409c, IAdRequestParam.CELL_ID, new JSONObject(m.a(j.f3409c, a2.a())).getJSONObject("response_params").getString(IAdRequestParam.CELL_ID));
                        if (TextUtils.isEmpty(b2)) {
                            return;
                        }
                        com.baidu.android.pushservice.j.i.a(j.f3409c, "token", b2);
                    } catch (JSONException unused) {
                    }
                }
            }
        });
    }
}
