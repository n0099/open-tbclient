package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.baidu.android.pushservice.e.a;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x implements Runnable {
    private Context a;
    private int b = 3;
    private int c = 0;
    private boolean d = false;
    private boolean e = true;
    private a.C0033a f;

    public x(Context context, a.C0033a c0033a) {
        this.a = context.getApplicationContext();
        this.f = c0033a;
    }

    private boolean b() {
        boolean z;
        String d = com.baidu.android.pushservice.h.d();
        if (this.c > 2) {
            String b = com.baidu.android.pushservice.h.b(this.a, this.e);
            this.e = false;
            if (!TextUtils.isEmpty(b)) {
                d = d.replace(com.baidu.android.pushservice.h.b(), "http://" + b);
            }
        }
        InputStream inputStream = null;
        try {
            try {
                com.baidu.android.pushservice.f.a a = com.baidu.android.pushservice.f.b.a(d, "POST", c());
                int b2 = a.b();
                inputStream = a.a();
                if (b2 == 200) {
                    JSONObject jSONObject = new JSONObject(com.baidu.android.pushservice.h.a.b.a(inputStream)).getJSONObject("response_params");
                    if (jSONObject != null) {
                        String string = jSONObject.getString("channel_id");
                        String string2 = com.baidu.android.pushservice.h.f() ? jSONObject.getString("rsa_channel_token") : jSONObject.getString("channel_token");
                        jSONObject.getString("expires_time");
                        com.baidu.android.pushservice.j.a(this.a).a(string, string2);
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    com.baidu.android.pushservice.h.a.b.a(inputStream);
                    z = false;
                }
                try {
                    this.c = 0;
                    if (inputStream == null) {
                        this.d = true;
                    } else {
                        this.d = false;
                    }
                    com.baidu.android.pushservice.f.b.a(inputStream);
                } catch (IOException e) {
                    this.d = true;
                    com.baidu.android.pushservice.f.b.a(inputStream);
                    return z;
                } catch (Exception e2) {
                    this.d = false;
                    com.baidu.android.pushservice.f.b.a(inputStream);
                    return z;
                }
            } catch (Throwable th) {
                com.baidu.android.pushservice.f.b.a(null);
                throw th;
            }
        } catch (IOException e3) {
            z = false;
        } catch (Exception e4) {
            z = false;
        }
        return z;
    }

    private HashMap<String, String> c() throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("method", Constants.EXTRA_KEY_TOKEN);
        b.a(hashMap);
        hashMap.put("device_type", "3");
        String b = com.baidu.android.pushservice.k.e.b(this.a);
        if (com.baidu.android.pushservice.h.f()) {
            hashMap.put("rsa_device_id", com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptR(b.getBytes(), 1), "utf-8"));
        } else {
            hashMap.put(com.baidu.ar.util.Constants.HTTP_DEVICE_ID, b);
        }
        hashMap.put("device_name", Build.MODEL);
        int b2 = com.baidu.android.pushservice.j.m.b(this.a, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", -1);
        String a = com.baidu.android.pushservice.j.m.a(this.a, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (b2 == 2) {
            hashMap.put("bduss", com.baidu.android.pushservice.j.m.a(this.a, "com.baidu.android.pushservice.PushManager.BDUSS"));
            hashMap.put("appid", a);
        } else if (b2 == 1) {
            hashMap.put("access_token", a);
        } else {
            hashMap.put("apikey", a);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_level", Build.VERSION.SDK_INT);
        int[] b3 = com.baidu.android.pushservice.j.p.b(this.a);
        jSONObject.put("screen_height", b3[0]);
        jSONObject.put("screen_width", b3[1]);
        String str = Build.MODEL;
        if (str.length() > 128) {
            str = str.substring(0, TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
        jSONObject.put("model", str);
        jSONObject.put("isroot", com.baidu.android.pushservice.j.p.a(this.a) ? 1 : 0);
        jSONObject.put("is_baidu_app", com.baidu.android.pushservice.j.p.e(this.a, this.a.getPackageName()) ? 1 : 0);
        jSONObject.put("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
        String str2 = Build.MANUFACTURER;
        if (str2.length() > 128) {
            str2 = str2.substring(0, TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
        jSONObject.put("manufacturer", str2);
        hashMap.put(LoginActivityConfig.INFO, jSONObject.toString());
        return hashMap;
    }

    private void d() {
        this.c++;
        if (this.c >= this.b) {
            this.d = false;
            return;
        }
        try {
            Thread.sleep((1 << (this.c - 1)) * 5 * 1000);
        } catch (InterruptedException e) {
        }
    }

    protected void a() {
        boolean b;
        do {
            b = b();
            if (this.d) {
                d();
            }
            if (this.b <= 0) {
                break;
            }
        } while (this.d);
        if (this.f != null) {
            this.f.a(Boolean.valueOf(b));
        } else {
            com.baidu.android.pushservice.j.p.b("TokenRequester#execute-->mListener is null !!!!!", this.a);
        }
        com.baidu.android.pushservice.j.p.b("TokenRequester#execute-->RequestTokenThread connectResult: " + b, this.a);
        if (!b) {
            com.baidu.android.pushservice.j.p.e(this.a);
            return;
        }
        b.a(this.a);
        if (com.baidu.android.pushservice.g.a != null) {
            com.baidu.android.pushservice.j.p.b("TokenRequester#execute-->TokenRequester start PushService after Request finish. ", this.a);
            com.baidu.android.pushservice.j.o.a(this.a, new Intent());
        }
    }

    public void a(int i) {
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
